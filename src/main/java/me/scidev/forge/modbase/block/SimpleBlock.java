package me.scidev.forge.modbase.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SimpleBlock extends Block {

	public SimpleBlock(Material materialIn, float hardnessIn, float resistanceIn, ToolType harvestTool, int harvestLevel, boolean isNotSolid, SoundType soundTypeIn) {
		super(assembleProperties(materialIn, hardnessIn, resistanceIn, harvestTool, harvestLevel, isNotSolid, soundTypeIn));
	}
	private static Properties assembleProperties(Material materialIn, float hardnessIn, float resistanceIn, ToolType harvestTool, int harvestLevel, boolean isNotSolid, SoundType soundTypeIn) {
		Properties properties = Properties.create(materialIn);
		properties.hardnessAndResistance(hardnessIn, resistanceIn);
		properties.harvestTool(harvestTool).harvestLevel(harvestLevel);
		properties.sound(soundTypeIn);
		if (isNotSolid) properties.notSolid();
		return properties;
	}

}
