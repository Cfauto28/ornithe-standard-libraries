package net.ornithemc.osl.items.impl.mixin.common;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.item.Item;

@Mixin(Item.class)
public interface ItemAccess {

	@Invoker("setSprite")
	Item osl$items$setSprite(int sprite);

}
