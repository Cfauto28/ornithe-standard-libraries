package net.ornithemc.osl.items.impl.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;

import ext.block.ExtBlock;
import net.minecraft.client.render.ItemInHandRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

import net.ornithemc.osl.items.impl.access.BlockItemAccess;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {

	@Definition(
		id = "BY_ID",
		field = "Lext/block/ExtBlock;BY_ID:[Lext/block/ExtBlock;"
	)
	@Expression("BY_ID[?]")
	@WrapOperation(
		method = "render",
		at = @At(
			value = "MIXINEXTRAS:EXPRESSION"
		)
	)
	private ExtBlock osl$items$fixBlockCheck(ExtBlock[] BY_ID, int id, Operation<ExtBlock> op, @Local ItemStack item) {
		return item.getItem() instanceof BlockItem ? op.call(BY_ID, ((BlockItemAccess) item.getItem()).osl$items$getBlock()) : null;
	}
}
