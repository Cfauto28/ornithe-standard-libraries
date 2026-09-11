package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ext.block.ExtBlock;
import net.minecraft.item.ItemStack;

import net.ornithemc.osl.items.impl.item.ItemUtil;

@Mixin(ItemStack.class)
public class ItemStackMixinNew {

	@Shadow
	private int id;

	@Inject(
		method = "<init>(III)V",
		at = @At(
			value = "TAIL"
		)
	)
	private void osl$items$fixBlockItemId(int block, int size, int metadata, CallbackInfo ci) {
		if (ItemUtil.blockItemsInitialized) {
			this.id = ItemUtil.itemId(block);
		}
	}
}
