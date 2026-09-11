package net.ornithemc.osl.blocks.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ext.block.ExtFireBlock;
import net.ornithemc.osl.blocks.api.BlockRegistry;
import net.ornithemc.osl.blocks.impl.block.BlockPostInit;
import net.ornithemc.osl.core.api.util.NamespacedIdentifier;
import net.ornithemc.osl.registries.api.registry.RegistryKeys;
import net.ornithemc.osl.registries.api.registry.SyncedRegistries;
import net.ornithemc.osl.registries.api.registry.sync.DynamicIntArray;
import net.ornithemc.osl.registries.api.registry.sync.IntArrayMapper;
import net.ornithemc.osl.registries.impl.registry.RegistriesImpl;

@Mixin(ExtFireBlock.class)
public class FireBlockMixin implements BlockPostInit {

	@Shadow
	private int[] field_1_3297;
	@Shadow
	private int[] field_1_3298;

	@Inject(
		method = "method_1_2216",
		at = @At(
			value = "HEAD"
		)
	)
	private void osl$blocks$growArrays(int block, int flammability, int burnChance, CallbackInfo ci) {
		int capacity = block + 1;

		this.field_1_3297 = DynamicIntArray.grow(this.field_1_3297, capacity);
		this.field_1_3298 = DynamicIntArray.grow(this.field_1_3298, capacity);
	}

	@Override
	public void osl$blocks$postInit() {
		ExtFireBlock block = (ExtFireBlock) (Object) this;
		NamespacedIdentifier identifier = BlockRegistry.getIdentifier(block);

		if (identifier == null) {
			RegistriesImpl.LOGGER.warn("Unable to register FireBlock array mappers for unregistered block {} (ID {})", block, block.id);
		} else {
			SyncedRegistries.registerMapper(RegistryKeys.BLOCK, identifier.suffixed("/flammability"), IntArrayMapper.of(() -> this.field_1_3297, a -> this.field_1_3297 = a));
			SyncedRegistries.registerMapper(RegistryKeys.BLOCK, identifier.suffixed("/burn_chance"), IntArrayMapper.of(() -> this.field_1_3298, a -> this.field_1_3298 = a));
		}
	}
}
