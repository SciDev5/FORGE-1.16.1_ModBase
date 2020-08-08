package me.scidev.forge.modbase.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class SimpleOreBlock extends OreBlock {

	private final int minXp;
	private final int maxXp;
	
	public SimpleOreBlock(Properties properties,int minXp,int maxXp) {
		super(properties);
		this.minXp = minXp;
		this.maxXp = maxXp;
	}
	public SimpleOreBlock(Properties properties,int xp) {
		super(properties);
		this.minXp = xp;
		this.maxXp = xp;
	}
	
	@Override
	protected int getExperience(Random rand) {
		if (minXp >= maxXp) 
			return minXp;
		else
			return MathHelper.nextInt(rand, minXp, maxXp);
	}

	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		return silktouch == 0 ? this.getExperience(RANDOM) : 0;
	}
}
