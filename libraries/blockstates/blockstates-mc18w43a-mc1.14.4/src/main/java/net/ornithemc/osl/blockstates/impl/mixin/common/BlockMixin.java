package net.ornithemc.osl.blockstates.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;

import net.ornithemc.osl.blockstates.api.block.BlockExtension;

@Mixin(BlockState.class)
public class BlockMixin implements BlockExtension {

	@Override
	public boolean is(Block block) {
		return (Block) (Object) this == block;
	}
}
