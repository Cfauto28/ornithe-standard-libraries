package net.ornithemc.osl.blocks.impl;

import java.util.Set;

import ext.block.ExtBlock;
import net.minecraft.block.Block;
import net.ornithemc.osl.blocks.api.BlockEvents;
import net.ornithemc.osl.core.api.util.NamespacedIdentifier;

public final class BlockRegistryImpl {

	private static boolean locked = true;
	private static boolean initialized = false;

	public static int getId(ExtBlock block) {
		return ExtBlock.REGISTRY.getId(block);
	}

	public static NamespacedIdentifier getKey(ExtBlock block) {
		return ExtBlock.REGISTRY.getKey(block);
	}

	public static ExtBlock getBlock(int id) {
		return ExtBlock.REGISTRY.get(id);
	}

	public static ExtBlock getBlock(NamespacedIdentifier key) {
		return ExtBlock.REGISTRY.get(key);
	}

	public static Set<NamespacedIdentifier> keySet() {
		return ExtBlock.REGISTRY.keySet();
	}

	public static <T extends ExtBlock> T register(int id, NamespacedIdentifier key, T block) {
		if (locked) {
			throw new IllegalStateException("register called too " + (initialized ? "late" : "early") + ": registry locked!");
		} else {
			ExtBlock.REGISTRY.register(id, key, block);
		}

		return block;
	}

	public static void lock() {
		if (!initialized) {
			throw new IllegalStateException("cannot lock block registry unless it's been initialized!");
		}

		locked = true;
	}

	public static void unlock() {
		if (initialized) {
			throw new IllegalStateException("cannot unlock block registry once it's been initialized!");
		}

		locked = false;
	}

	public static void init() {
		if (locked) {
			throw new IllegalStateException("cannot initialize block registry when it's locked!");
		}

		VanillaBlocks.init();

		BlockEvents.REGISTER_BLOCKS.invoker().run();
		initialized = true;
	}
}
