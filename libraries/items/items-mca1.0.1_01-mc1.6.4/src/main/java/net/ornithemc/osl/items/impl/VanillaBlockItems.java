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
import net.ornithemc.osl.core.api.util.NamespacedIdentifier;

final class VanillaBlockItems {

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
			Item item = Item.BY_ID[id];
			if (block != Blocks.AIR && item != null) {
				NamespacedIdentifier key = BlockRegistryImpl.getKey(block);
				if (ItemRegistryImpl.getItem(key) == null) {
					ItemRegistryImpl.register(block, item);
				} else {
					// some blocks have both a block item and special item form
					// we should handle that in some way, but how? TODO
				}
			}
		}
	}
}
