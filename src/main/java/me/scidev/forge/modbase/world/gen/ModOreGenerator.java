package me.scidev.forge.modbase.world.gen;

import java.util.List;

import me.scidev.forge.modbase.block.ModBlocks;
import me.scidev.forge.modbase.utils.BiomeUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModOreGenerator {

	public static OreFeatureConfig.FillerBlockType TEST_FILLER = OreFeatureConfig.FillerBlockType.create("TEST", "test_filler", new BlockMatcher(Blocks.DIRT));
	
	public static void generateAllOres() {
		generateSimpleOre(BiomeUtils.BIOMES_BY_CATEGORY.get(Category.EXTREME_HILLS), 4, 4, 0, 0, 80, TEST_FILLER, ModBlocks.TEST_ORE.get().getDefaultState());
		generateSimpleOre(BiomeUtils.ALL_BIOMES, 4, 8, 0, 0, 16, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TEST_ORE.get().getDefaultState());
		generateSimpleOre(BiomeUtils.BIOMES_BY_CATEGORY.get(Category.NETHER), 4, 8, 64, 0, 16, OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, ModBlocks.TEST_ORE.get().getDefaultState());
	}
	public static void generateSimpleOre(List<Biome> biomes, int count, int size, int bottomYOffset, int topYOffset, int maxheight, OreFeatureConfig.FillerBlockType toReplaceBlock, BlockState replacementBlockState) {
		CountRangeConfig placementConfig = new CountRangeConfig(count, bottomYOffset, topYOffset, maxheight);
		OreFeatureConfig featureConfig = new OreFeatureConfig(toReplaceBlock, replacementBlockState, size);
		ConfiguredPlacement<CountRangeConfig> placement = Placement.COUNT_RANGE.configure(placementConfig);
		for (Biome biome : biomes)
			biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(featureConfig).withPlacement(placement));
	}
}
