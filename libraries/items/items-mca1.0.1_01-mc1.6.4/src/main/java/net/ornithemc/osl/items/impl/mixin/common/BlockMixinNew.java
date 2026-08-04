package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ext.block.ExtBlock;
import net.ornithemc.osl.items.impl.ItemRegistryImpl;

@Mixin(ExtBlock.class)
public class BlockMixinNew {

	@Inject(
		method = "<clinit>",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/stat/Stats;initBlockStats()V"
		)
	)
	private static void osl$items$initBlockItems(CallbackInfo ci) {
		ItemRegistryImpl.initBlocks();
	}
}
