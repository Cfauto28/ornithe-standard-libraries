package net.ornithemc.osl.items.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.item.Item;

import net.ornithemc.osl.core.api.util.NamespacedIdentifiers;

final class VanillaItems {

	/**
	 * Namespaced IDs were introduced in 1.7. Before then, the numerical IDs
	 * were the only unique identifiers for items. Here we assign namespaced
	 * IDs to pre-1.7 items, matching the 1.7 IDs  where possible.
	 * <p>
	 * Note that in 1.7 snapshots the IDs went through several changes.
	 * The IDs used here match those used in Release 1.7.2.
	 */
	private static final String[] IDENTIFIERS = {
		// grouped per 10 for easier lookup

		"iron_shovel",
		"iron_pickaxe",
		"iron_axe",
		"flint_and_steel",
		"apple",
		"bow",
		"arrow",
		"coal",
		"diamond",
		"iron_ingot",

		"gold_ingot",
		"iron_sword",
		"wooden_sword",
		"wooden_shovel",
		"wooden_pickaxe",
		"wooden_axe",
		"stone_sword",
		"stone_shovel",
		"stone_pickaxe",
		"stone_axe",

		"diamond_sword",
		"diamond_shovel",
		"diamond_pickaxe",
		"diamond_axe",
		"stick",
		"bowl",
		"mushroom_stew",
		"golden_sword",
		"golden_shovel",
		"golden_pickaxe",

		"golden_axe",
		"string",
		"feather",
		"gunpowder",
		"wooden_hoe",
		"stone_hoe",
		"iron_hoe",
		"diamond_hoe",
		"golden_hoe",
		"wheat_seeds",

		"wheat",
		"bread",
		"leather_helmet",
		"leather_chestplate",
		"leather_leggings",
		"leather_boots",
		"chainmail_helmet",
		"chainmail_chestplate",
		"chainmail_leggings",
		"chainmail_boots",

		"iron_helmet",
		"iron_chestplate",
		"iron_leggings",
		"iron_boots",
		"diamond_helmet",
		"diamond_chestplate",
		"diamond_leggings",
		"diamond_boots",
		"golden_helmet",
		"golden_chestplate",

		"golden_leggings",
		"golden_boots",
		"flint",
		"porkchop",
		"cooked_porkchop",
		"painting",
		"golden_apple",
		"sign",
		"wooden_door",
		"bucket",

		"water_bucket",
		"lava_bucket",
		"minecart",
		"saddle",
		"iron_door",
		"redstone",
		"snowball",
		"boat",
		"leather",
		"milk_bucket",

		"brick",
		"clay_ball",
		"reeds",
		"paper",
		"book",
		"slime_ball",
		"chest_minecart",
		"furnace_minecart",
		"egg",
		"compass",
		
		"Obsidian_Helm", 
		"Obsidian_Chestplate", 
		"Obsidian_Leggings", 
		"Obsidian_Boots", 
		"Obsidian_Sword", 
		"Obsidian_Shovel", 
		"Obsidian_Pickaxe", 
		"Obsidian_Axe", 
		"Obsidian_Hoe", 
		"Obsidian_Ingot", 
		"Dye_Black", 
		"Dye_Green", 
		"Dye_Blue", 
		"Dye_Pink", 
		"Fryshroom", 
		"Liquified_Fire", 
		"Flameberge", 
		"Sunglasses", 
		"Firewood_Door", 
		"Essence", 
		"Eraser", 
		"Essence_Rifle", 
		"Hub_Door", 
		"Spear", 
		"Pear", 
		"Obsidian_Pear", 
		"Highwood_Door", 
		"Mycon_Door", 
		"Stylish_Visor", 
		"Stylish_Chestplate", 
		"Stylish_Shorts", 
		"Stylish_Shoes", 
		"Bismuth_Ingot", 
		"Mycon_Strand", 
		"Mycon_Sword", 
		"Mycon_Shovel", 
		"Mycon_Pickaxe", 
		"Mycon_Axe", 
		"Mycon_Hoe", 
		"Granular_Salt", 
		"Gray_Gun", 
		"Tea_Leaf", 
		"Tea_Bucket", 
		"Tea_Door", 
		"Lace_Agate", 
		"Clinohumite", 
		"Malachite", 
		"Pyrite", 
		"Hours_Long_Past_I", 
		"Hearthen_Mirror", 
		"Rain_Conch", 
		"Frigid_Bits", 
		"Candy_Ice", 
		"Ice_Door", 
		"Hours_Long_Past_II", 
		"Hours_Long_Past_III", 
		"Hours_Long_Past_VI", 
		"The_One_True_Book", 
		"Observer_Fur"
	};
	private static final String[] DISC_IDENTIFIERS = {
		"fishing_rod",
		"record_13",
		"record_cat", 
		"Record_Downbeat_Uplink", 
		"Record_Sandcastles", 
		"Record_K2", 
		"Rock_Beetle_RokkubitoruTune", 
		"Record_Desambrier", 
		"Record_Juhry", 
		"Record_Gyldan_Sverd"
	};

	static final int ITEM_ID_OFFSET = 32767;
	static final int DISC_ITEM_ID_OFFSET = 1999 + ITEM_ID_OFFSET;

	static void init() {
		for (Field f : Item.class.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && Item.class.isAssignableFrom(f.getType())) {
				try {
					Item item = (Item) f.get(null);

					if (item != null) {
						String identifier = null;

						if (item.id >= DISC_ITEM_ID_OFFSET) {
							int id = item.id - DISC_ITEM_ID_OFFSET;

							if (id >= 0 && id < DISC_IDENTIFIERS.length) {
								identifier = DISC_IDENTIFIERS[id];
							}
						} else if (item.id >= ITEM_ID_OFFSET) {
							int id = item.id - ITEM_ID_OFFSET;

							if (id >= 0 && id < IDENTIFIERS.length) {
								identifier = IDENTIFIERS[id];
							}
						}

						if (identifier != null) {
							ItemRegistryImpl.register(item.id, NamespacedIdentifiers.from(identifier), item);
						}
					}
				} catch (Throwable t) {
				}
			}
		}
	}
}
