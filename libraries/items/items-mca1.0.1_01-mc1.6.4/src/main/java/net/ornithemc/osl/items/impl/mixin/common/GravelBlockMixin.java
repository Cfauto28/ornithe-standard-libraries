package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import ext.block.ExtGravelBlock;
import net.minecraft.block.GravelBlock;

import net.ornithemc.osl.items.impl.item.ItemUtil;

@Mixin(ExtGravelBlock.class)
public class GravelBlockMixin {

	@WrapOperation(
		method = "getDropItem",
		at = @At(
			value = "FIELD",
			target = "Lext/block/ExtGravelBlock;id:I"
		)
	)
	private int osl$items$fixBlockItem(ExtGravelBlock block, Operation<Integer> op) {
		return ItemUtil.itemId(block);
	}
}
