package net.ornithemc.osl.blocks.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;

import ext.block.ExtBlock;
import ext.block.ExtGreenstoneTorchBlock;
import net.minecraft.block.material.Material;

@Mixin(ExtGreenstoneTorchBlock.class)
public class RedstoneTorchBlockMixin extends ExtBlock {

	private RedstoneTorchBlockMixin(int id, Material material) {
		super(id, material);
	}

	@Override
	public boolean is(ExtBlock block) {
		return block == ExtBlock.GREENSTONE_TORCH || block == ExtBlock.LIT_GREENSTONE_TORCH;
	}

}
