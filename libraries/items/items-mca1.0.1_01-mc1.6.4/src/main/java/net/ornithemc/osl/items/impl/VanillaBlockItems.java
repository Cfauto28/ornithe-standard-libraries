package net.ornithemc.osl.items.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import ext.block.ExtBlock;
import ext.newblock.ExtNewBlock;
import net.minecraft.item.Item;

import net.ornithemc.osl.blocks.api.block.Blocks;
import net.ornithemc.osl.blocks.impl.BlockRegistryImpl;
import net.ornithemc.osl.blocks.impl.VanillaBlocks;
import net.ornithemc.osl.core.api.util.NamespacedIdentifier;
import net.ornithemc.osl.items.impl.item.ItemUtil;

public final class VanillaBlockItems {

	public static final int MAX_ID = VanillaBlocks.MAX_ID;

	static void init() {
		List<ExtBlock> newblocklist = new ArrayList<ExtBlock>();
		for (Field f : ExtNewBlock.class.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && ExtBlock.class.isAssignableFrom(f.getType())) {
				try {
					ExtBlock block = (ExtBlock) f.get(null);

					if (block != null) {
						newblocklist.add(block);
					}
				} catch (Throwable t) {
				}
			}
		}
		for (Field f : ExtBlock.class.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers()) && ExtBlock.class.isAssignableFrom(f.getType())) {
				try {
					ExtBlock block = (ExtBlock) f.get(null);

					if (block != null) {
						newblocklist.add(block);
					}
				} catch (Throwable t) {
				}
			}
		}
		for (int id = 0; id < newblocklist.size()/*VanillaItems.ITEM_ID_OFFSET*/; id++) {
			//ExtBlock block = ExtBlock.BY_ID[id];
			ExtBlock block = newblocklist.get(id);
			Item item = Item.BY_ID[block.id];
			if (block != Blocks.AIR && item != null) {
			NamespacedIdentifier identifier = BlockRegistryImpl.getIdentifier(block);
				
				if (ItemRegistryImpl.getItem(identifier) == null) {
					// some blocks have both a block item and special item form
					identifier = identifier.suffixed("_block");
				}
					
				ItemRegistryImpl.register(identifier, block, item);
			}
		}

		ItemUtil.blockItemsInitialized = true;
	}
}
