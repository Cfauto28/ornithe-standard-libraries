package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ext.block.ExtBlock;
import net.ornithemc.osl.items.impl.ItemRegistryImpl;

@Mixin(ExtBlock.class)
public class BlockMixinOld {

	@Inject(
		method = "<clinit>",
		at = @At(
			value = "TAIL"
		)
	)
	private static void osl$items$registerVanillaBlockItems(CallbackInfo ci) {
		ItemRegistryImpl.registerVanillaBlockItems();
	}
}
