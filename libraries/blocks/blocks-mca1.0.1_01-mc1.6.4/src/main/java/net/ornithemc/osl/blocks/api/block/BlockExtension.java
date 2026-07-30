package net.ornithemc.osl.blocks.api.block;

import ext.block.ExtBlock;
import net.minecraft.block.Block;

import net.ornithemc.osl.core.api.registry.DefaultedIdRegistry;
import net.ornithemc.osl.core.api.registry.SimpleIdRegistry;

public interface BlockExtension {

	SimpleIdRegistry<ExtBlock> REGISTRY = new DefaultedIdRegistry<>("air");

	/**
	 * @return whether this block is air.
	 */
	boolean isAir();

	/**
	 * @return whether this block is the same as the given block.
	 */
	boolean is(ExtBlock block);

}
