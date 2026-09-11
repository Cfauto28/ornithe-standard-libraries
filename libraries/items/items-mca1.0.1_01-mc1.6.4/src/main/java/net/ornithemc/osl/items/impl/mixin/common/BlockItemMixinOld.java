package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import ext.block.ExtBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import net.ornithemc.osl.items.impl.VanillaItems;
import net.ornithemc.osl.items.impl.access.BlockItemAccess;

@Mixin(BlockItem.class)
public class BlockItemMixinOld implements BlockItemAccess {

	@Shadow
	private int block;

	@Definition(
		id = "BY_ID",
		field = "Lext/block/ExtBlock;BY_ID:[Lext/block/ExtBlock;"
	)
	@Expression("BY_ID[?]")
	@WrapOperation(
		method = "<init>",
		at = @At(
			value = "MIXINEXTRAS:EXPRESSION"
		)
	)
	private ExtBlock osl$items$fixItemBlock(ExtBlock[] BY_ID, int id, Operation<ExtBlock> op) {
		if (id - VanillaItems.ITEM_ID_OFFSET == Item.AUTO_ASSIGN_ID) {
			id = 1; // doesn't matter what this is, so long as the block exists
		}

		return op.call(BY_ID, id);
	}

	@Override
	public int osl$items$getBlock() {
		return this.block;
	}

	@Override
	public void osl$items$setBlock(ExtBlock block) {
		this.block = block.id;
		((ItemAccess) this).osl$items$setSprite(((BlockAccess) block).osl$items$getSprite(2));
	}
}
