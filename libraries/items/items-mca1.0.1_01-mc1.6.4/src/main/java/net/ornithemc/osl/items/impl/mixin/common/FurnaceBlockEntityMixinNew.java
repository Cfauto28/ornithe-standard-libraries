package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import ext.block.ExtBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.FurnaceBlockEntity;

import net.ornithemc.osl.items.impl.item.ItemUtil;

@Mixin(FurnaceBlockEntity.class)
public class FurnaceBlockEntityMixinNew {

	@WrapOperation(
		method = "getFuelTime",
		at = @At(
			value = "FIELD",
			target = "Lext/block/ExtBlock;id:I"
		)
	)
	private static int osl$items$fixBlockItem(ExtBlock block, Operation<Integer> op) {
		return ItemUtil.itemId(block);
	}
}
