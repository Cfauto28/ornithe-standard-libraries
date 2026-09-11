package net.ornithemc.osl.blocks.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import ext.block.ExtBlock;
import ext.newblock.ExtNewBlock;
import net.ornithemc.osl.blocks.api.block.Blocks;
import net.ornithemc.osl.core.api.util.NamespacedIdentifiers;

public final class VanillaBlocks {

	/**
	 * Namespaced IDs were introduced in 1.7. Before then, the numerical IDs
	 * were the only unique identifiers for blocks. Here we assign namespaced
	 * IDs to pre-1.7 blocks, matching the 1.7 IDs  where possible.
	 * <p>
	 * Note that in 1.7 snapshots the IDs went through several changes.
	 * The IDs used here match those used in Release 1.7.2.
	 */
	private static final String[] IDENTIFIERS = {
		// grouped per 10 for easier lookup

		"air",
		"stone",
		"grass",
		"dirt",
		"cobblestone",
		"planks",
		"sapling",
		"bedrock",
		"flowing_water",
		"water",

		"flowing_lava",
		"lava",
		"sand",
		"gravel",
		"gold_ore",
		"iron_ore",
		"coal_ore",
		"log",
		"leaves",
		"sponge",

		"glass",
		
//		IDs 21 to 34 and ID 36 were unused
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		null,
		
		"wool",
		
		null,
		
		"yellow_flower",
		"red_flower",
		"brown_mushroom",

		"red_mushroom",
		"gold_block",
		"iron_block",
		"double_stone_slab",
		"stone_slab",
		"brick_block",
		"tnt",
		"bookshelf",
		"mossy_cobblestone",
		"obsidian",

		"torch",
		"fire",
		"mob_spawner",
		"oak_stairs",
		"chest",
		"redstone_wire",
		"diamond_ore",
		"diamond_block",
		"crafting_table",
		"wheat_block",

		"farmland",
		"furnace",
		"lit_furnace",
		"standing_sign",
		"wooden_door_block",
		"ladder_block",
		"rail_block",
		"stone_stairs",
		"wall_sign",
		"lever",

		"stone_pressure_plate",
		"iron_door_block",
		"wooden_pressure_plate",
		"redstone_ore",
		"lit_redstone_ore",
		"unlit_redstone_torch",
		"redstone_torch",
		"stone_button",
		"snow_layer",
		"ice",

		"snow_block",
		"cactus",
		"clay_block",
		"reeds_block",
		"jukebox",
		"fence",
		
		null,
		null,
		null,
		null,
		
		"Fortified_Glass", 
		"Pillar", 
		"Stone_Tile", 
		"Glitched_Tile", 
		"Tile", 
		"Dimension_Floor", 
		"Dimension_Wall", 
		"DEBUG_1", 
		"Blue_Dimension_Tile", 
		"Yellow_Dimension_Tile", 
		"Fake_Grass", 
		"Blue_Mojang_Block", 
		"White_Mojang_Block", 
		"Green_Mojang_Block", 
		"Ghost_Block", 
		"Construction_Block", 
		"Fake_Dirt", 
		"Fake_Stone", 
		"Fake_Sand", 
		"Magenta_Cloth", 
		"Blue_Cloth", 
		"Green_Cloth", 
		"Black_Cloth", 
		"DEBUG_2", 
		"Salt_Block", 
		"Water_Lily", 
		"Celestial_Flame", 
		"Flame-Infused_Lily", 
		"Gold-Infused_Lily", 
		"Obsidian-Infused_Lily", 
		"Safe", 
		"Magenta_Glass", 
		"Blue_Glass", 
		"Green_Glass", 
		"Black_Glass", 
		"Fortified_Magenta_Glass", 
		"Fortified_Blue_Glass", 
		"Fortified_Green_Glass", 
		"Fortified_Black_Glass", 
		"Flamewood", 
		"Flamewood_Planks", 
		"Flamewood_Leaves", 
		"Low_Lily", 
		"Low_Vine", 
		"Low_Riverbed", 
		"Low_Wart", 
		"Low_River_Stone", 
		"Low_River_Gold_Ore", 
		"Low_River_Iron_Ore", 
		"Low_River_Coal_Ore", 
		"Low_River_Diamond_Ore", 
		"Low_River_Greenstone_Ore", 
		"Glowing_Low_River_Greenstone_Ore", 
		"Flamewood_Door", 
		"Cobbled_Limestone", 
		"Limestone", 
		"Green_Dimension_Floor", 
		"Alternative_Dimension_Wall", 
		"Glowing_Cache", 
		"Essence_Cache", 
		"Essence_Transformer", 
		"Double_Wood_Slab", 
		"Wood_Slab", 
		"Heater", 
		"Essence_Cloner", 
		"Ice_Door", 
		"Essence_Fountain", 
		"Smooth_Stone", 
		"Smooth_Limestone", 
		"Crude_Pillar", 
		"Hydrangea", 
		"Highwood_Log", 
		"Highwood_Leaves", 
		"Highwood_Roots", 
		"Highwood_Planks", 
		"Grass", 
		"Elder_Decorated_Stone", 
		"Elder_Brick", 
		"Elder_Pillar", 
		"Elder_Smooth_Stone", 
		"Bookshelf", 
		"Empty_Bookshelf", 

		null,
		
		"Wireframe_Block_1", 
		"Vending_Machine_Health_Boost_Bottom", 
		"Vending_Machine_Health_Boost_Top", 
		"Vending_Machine_Armor_Bottom", 
		"Vending_Machine_Armor_Top", 
		"Vending_Machine_Dash_Bottom", 
		"Vending_Machine_Dash_Top", 
		"Vending_Machine_Quick_Revive_Bottom", 
		"Vending_Machine_Quick_Revive_Top", 
		"Lichen", 
		"Lichen_Bricks", 
		"Lichen_Mass", 
		"Gold_Elder_Brick", 
		"Sky_Flame-In-Glass", 
		"Weapon_Upgrader", 
		"Wireframe_Block_2", 
		"Weapon_Giver_Gray_Gun", 
		"Gold_Flame-In-Glass", 
		"Obsidian_Flame-In-Glass", 
		"Low_Flame-In-Glass",
		
		null,
		null, 
		
		"Decorative_Block_1", 
		"Decorative_Block_2", 
		"Gold_Brick", 
		"Obsidian_Brick", 
		"Diamond_Brick", 
		"Iron_Brick", 
		"Flamewood_Pillar", 
		"Highwood_Pillar", 
		"Slate_Bricks", 
		"Slate_Beacon", 
		"Slate_Pillar", 
		"Solar_Plate", 
		"Denial_Plate", 
		"Switch_Plate", 
		"Loop_Plate", 
		"Part_Plate", 
		"Trinity_Plate", 
		"Association_Plate", 
		"Dialect_Plate", 
		"Syllables_Plate", 
		"Mirrors_Plate", 
		"Wifi_Block", 
		"Low_Mycon", 
		"Mycon_Stem", 
		"Fern", 
		"Mycon_Cap", 
		"Glowing_Mycon_Cap", 
		"Salt_Bricks", 
		"Mycon_Plank", 
		"Highwood_Door", 
		"Mycon_Door", 
		"Mycon_Workbench", 
		"Highwood_Workbench", 
		"Firewood_Workbench", 
		"Bismuth_Ore", 
		"Bismuth_Block", 
		"Bismuth_Pillar", 
		"Bismuth_Brick", 
		"Tea_Bush", 
		"Tea_Wood", 
		"Tea_Plank", 
		"Tea_Door", 
		"Tea_Pillar", 
		"Tea_Workbench", 
		"Mycon_Pillar", 
		"Coal_Brick", 
		"Greenstone_Brick", 
		"Snow_Brick", 
		"Freezer", 
		"Working_Freezer", 
		"Lace_Agate_Ore", 
		"Clinohumite_Ore", 
		"Malachite_Ore", 
		"Pyrite_Ore", 
		"Lace_Agate_Block", 
		"Clinohumite_Block", 
		"Malachite_Block", 
		"Pyrite_Block", 
		"Grass_Pathway", 
		"Frigid_Trunk", 
		"Frigid_Leaves"
	};

	public static final int MAX_ID = 32766;

	static void init() {
		// Air block added by OSL
		register(Blocks.AIR);

		for (Field f : ExtBlock.class.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && ExtBlock.class.isAssignableFrom(f.getType())) {
				try {
					ExtBlock block = (ExtBlock) f.get(null);

					if (block != null) {
						register(block);
					}
				} catch (Throwable t) {
				}
			}
		}
		for (Field f : ExtNewBlock.class.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && ExtBlock.class.isAssignableFrom(f.getType())) {
				try {
					ExtBlock block = (ExtBlock) f.get(null);

					if (block != null) {
						register(block);
					}
				} catch (Throwable t) {
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	private static void register(ExtBlock block) {
		if (block.id >= 0 && block.id < IDENTIFIERS.length) {
			String identifier = IDENTIFIERS[block.id];

			if (identifier != null) {
				BlockRegistryImpl.register(block.id, NamespacedIdentifiers.from(identifier), block);
			}
		}
	}
}
