package net.ornithemc.osl.blocks.api;

import java.util.Set;

import ext.block.ExtBlock;

import net.ornithemc.osl.blocks.impl.BlockRegistryImpl;
import net.ornithemc.osl.core.api.util.NamespacedIdentifier;

/**
 * Public access to the Blocks registry.
 */
public final class BlockRegistry {

	/**
	 * @return the numerical ID assigned to the given block.
	 */
	public static int getId(ExtBlock block) {
		return BlockRegistryImpl.getId(block);
	}

	/**
	 * @return the namespaced ID assigned to the given block.
	 */
	public static NamespacedIdentifier getKey(ExtBlock block) {
		return BlockRegistryImpl.getKey(block);
	}

	/**
	 * @return the block mapped to the given numerical ID.
	 */
	public static ExtBlock getBlock(int id) {
		return BlockRegistryImpl.getBlock(id);
	}

	/**
	 * @return the block mapped to the given namespaced ID.
	 */
	public static ExtBlock getBlock(NamespacedIdentifier key) {
		return BlockRegistryImpl.getBlock(key);
	}

	/**
	 * @return a set containing all namespaced IDs in the registry.
	 */
	public static Set<NamespacedIdentifier> keySet() {
		return BlockRegistryImpl.keySet();
	}

	/**
	 * @param <T>   the block type.
	 * @param id    the numerical ID of the block.
	 * @param key   the namespaced ID of the block.
	 * @param block the block to register.
	 * @return the registered  block.
	 */
	public static <T extends ExtBlock> T register(int id, NamespacedIdentifier key, T block) {
		return BlockRegistryImpl.register(id, key, block);
	}
}
