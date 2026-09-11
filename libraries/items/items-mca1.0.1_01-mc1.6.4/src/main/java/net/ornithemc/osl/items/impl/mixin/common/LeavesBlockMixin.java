/*package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import ext.block.ExtLeavesBlock;
import net.minecraft.block.LeavesBlock;

import net.ornithemc.osl.items.impl.item.ItemUtil;

@Mixin(ExtLeavesBlock.class)
public class LeavesBlockMixin {

	@WrapOperation(
		method = "getSilkTouchDrop",
		at = @At(
			value = "FIELD",
			target = "Lext/block/ExtLeavesBlock;id:I"
		)
	)
	private int osl$items$fixBlockItem(ExtLeavesBlock block, Operation<Integer> op) {
		return ItemUtil.itemId(block);
	}
}
*/