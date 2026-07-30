package net.ornithemc.osl.blocks.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;

import ext.block.ExtBlock;

import net.ornithemc.osl.blocks.api.block.BlockExtension;

@Mixin(ExtBlock.class)
public class BlockMixinOld implements BlockExtension {

	@Override
	public boolean isAir() {
		return false;
	}

	@Override
	public boolean is(ExtBlock block) {
		return (ExtBlock) (Object) this == block;
	}
}
