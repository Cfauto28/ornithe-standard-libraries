package net.ornithemc.osl.blocks.impl.mixin.common;

import org.objectweb.asm.Opcodes;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ext.block.ExtBlock;
import net.minecraft.block.material.Material;

import net.ornithemc.osl.blocks.api.block.BlockExtension;
import net.ornithemc.osl.core.api.util.NamespacedIdentifiers;
import net.ornithemc.osl.registries.api.registry.RegistryKeys;
import net.ornithemc.osl.registries.api.registry.SyncedRegistries;
import net.ornithemc.osl.registries.api.registry.sync.BooleanArrayMapper;
import net.ornithemc.osl.registries.api.registry.sync.DynamicBooleanArray;

@Mixin(ExtBlock.class)
public abstract class BlockMixin_a1_1_0_12w06a implements BlockExtension {

	@Shadow @Final @Mutable
	private static boolean[] HAS_BLOCK_ENTITY;

	@Inject(
		method = "<clinit>",
		at = @At(
			value = "TAIL"
		)
	)
	private static void osl$blocks$registerArrayMappers(CallbackInfo ci) {
		SyncedRegistries.registerMapper(RegistryKeys.BLOCK, NamespacedIdentifiers.from("block/has_block_entity"), BooleanArrayMapper.of(() -> HAS_BLOCK_ENTITY, a -> HAS_BLOCK_ENTITY = a));
	}

	@Inject(
		method = "<init>",
		at = @At(
			value = "FIELD",
			target = "Lext/block/ExtBlock;BY_ID:[Lext/block/ExtBlock;",
			opcode = Opcodes.GETSTATIC,
			args = "array=set"
		)
	)
	private void osl$blocks$growArrays(int id, Material material, CallbackInfo ci) {
		int capacity = id + 1;

		HAS_BLOCK_ENTITY = DynamicBooleanArray.grow(HAS_BLOCK_ENTITY, capacity);
	}
}
