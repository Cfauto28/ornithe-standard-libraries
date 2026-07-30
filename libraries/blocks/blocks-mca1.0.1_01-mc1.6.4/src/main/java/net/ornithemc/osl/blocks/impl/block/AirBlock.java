package net.ornithemc.osl.blocks.impl.block;

import ext.block.ExtBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class AirBlock extends ExtBlock {

	public AirBlock() {
		super(0, Material.AIR);
	}

	@Override
	public boolean isAir() {
		return true;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public Box getCollisionShape(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean canRayTrace(int metadata, boolean allowLiquids) {
		return false;
	}
}
