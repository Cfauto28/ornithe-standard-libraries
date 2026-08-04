package net.ornithemc.osl.blocks.impl.mixin.common;

import org.objectweb.asm.Opcodes;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;

import ext.block.ExtBlock;

import net.ornithemc.osl.blocks.impl.BlockRegistryImpl;

@Mixin(ExtBlock.class)
public class BlockMixin {

	@Inject(
		method = "<clinit>",
		at = @At(
			value = "HEAD"
		)
	)
	private static void osl$blocks$unlockBlockRegistry(CallbackInfo ci) {
		BlockRegistryImpl.unlock();
	}

	@Inject(
		method = "<clinit>",
		slice = @Slice(
			from = @At(
				value = "FIELD",
				opcode = Opcodes.PUTSTATIC,
				target = "Lext/block/ExtBlock;STONE:Lext/block/ExtBlock;"
			)
		),
		at = @At(
			value = "CONSTANT",
			args = "intValue=32767",
			ordinal = 0
		)
	)
	private static void osl$blocks$initAndLockBlockRegistry(CallbackInfo ci, @Share("osl$blocks$blocksRegistered") LocalBooleanRef blocksRegistered) {
		// in some versions this injector targets a for-loop
		if (!blocksRegistered.get()) {
			BlockRegistryImpl.init();
			BlockRegistryImpl.lock();
		}

		blocksRegistered.set(true);
	}

	@Override
	public String toString() {
		return "Block{" + BlockRegistryImpl.getKey((ExtBlock) (Object) this) + "}";
	}
}
