package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import ext.block.ExtBlock;

@Mixin(ExtBlock.class)
public interface BlockAccess {

	@Invoker("getSprite")
	int osl$items$getSprite(int face);

}
