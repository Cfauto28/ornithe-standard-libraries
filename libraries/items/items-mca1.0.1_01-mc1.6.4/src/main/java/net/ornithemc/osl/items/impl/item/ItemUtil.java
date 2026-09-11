package net.ornithemc.osl.items.impl.item;

import ext.block.ExtBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.ornithemc.osl.items.api.ItemRegistry;
import net.ornithemc.osl.items.impl.access.BlockItemAccess;

public final class ItemUtil {

	public static boolean blockItemsInitialized;

	public static int blockId(ItemStack item) {
		return item.getItem() instanceof BlockItem ? ((BlockItemAccess) item.getItem()).osl$items$getBlock() : 0;
	}

	public static int itemId(int block) {
		return itemId(ExtBlock.BY_ID[block]);
	}

	public static int itemId(ExtBlock block) {
		Item item = ItemRegistry.getItem(block);
		return item == null ? 0 : item.id;
	}
}
