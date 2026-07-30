package net.ornithemc.osl.blocks.impl.block;

import ext.block.ExtBlock;

import net.ornithemc.osl.blocks.api.block.BlockExtension;

public interface BlockExtensionImpl extends BlockExtension {

	@Override
	default boolean isAir() {
		throw new AbstractMethodError();
	}

	@Override
	default boolean is(ExtBlock block) {
		throw new AbstractMethodError();
	}
}
