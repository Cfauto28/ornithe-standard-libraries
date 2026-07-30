package net.ornithemc.osl.networking.impl.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.network.packet.Packet2Handshake;

import net.ornithemc.osl.networking.impl.Constants;

@Mixin(Packet2Handshake.class)
public class HandshakePacketMixin {

	@Shadow private String key;

	@Inject(
		method = "<init>(Ljava/lang/String;)V",
		at = @At(
			value = "TAIL"
		)
	)
	private void osl$networking$modifyHandshakeForOsl(CallbackInfo ci) {
		key = Constants.OSL_HANDSHAKE_KEY;
	}
}
