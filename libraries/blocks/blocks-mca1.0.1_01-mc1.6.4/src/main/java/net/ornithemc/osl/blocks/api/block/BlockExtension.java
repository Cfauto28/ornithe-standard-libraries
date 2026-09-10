package net.ornithemc.osl.blocks.api.block;

import ext.block.ExtBlock;

import net.ornithemc.osl.blocks.impl.BlockRegistryImpl;
import net.ornithemc.osl.registries.api.registry.DefaultedRegistry;

public interface BlockExtension {

	DefaultedRegistry<ExtBlock> REGISTRY = BlockRegistryImpl.REGISTRY;
	int AUTO_ASSIGN_ID = -172;

	/**
	 * @return whether this block is air.
	 */
	boolean isAir();

	/**
	 * @return whether this block is the same as the given block.
	 */
	boolean is(ExtBlock block);

}
