/*package net.ornithemc.osl.items.impl.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import ext.block.ExtStoneSlabBlock;

import net.ornithemc.osl.items.impl.item.ItemUtil;

@Mixin(ExtStoneSlabBlock.class)
public class SlabBlockMixin {

	@WrapOperation(
		method = "getPickItem",
		at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/block/SlabBlock;id:I",
			ordinal= 1
		)
	)
	private int osl$items$fixBlockItem(ExtStoneSlabBlock block, Operation<Integer> op) {
		return ItemUtil.itemId(block);
	}
}
*/