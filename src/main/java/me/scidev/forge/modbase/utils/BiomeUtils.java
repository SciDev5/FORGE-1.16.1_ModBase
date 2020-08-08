package me.scidev.forge.modbase.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeUtils {

	public static Map<Category,List<Biome>> BIOMES_BY_CATEGORY;
	public static List<Biome> ALL_BIOMES;
	private static boolean BIOMES_CATEGORIZED = false;
	
	public static void assembleBiomeInfo() {
		if (!BIOMES_CATEGORIZED)
			BIOMES_CATEGORIZED = true;
		else return;
		BIOMES_BY_CATEGORY = new HashMap<>();
		ALL_BIOMES = new ArrayList<Biome>();
		for (Biome biome : ForgeRegistries.BIOMES) {
			ALL_BIOMES.add(biome);
			List<Biome> categoryBiomeList = BIOMES_BY_CATEGORY.get(biome.getCategory());
			if (categoryBiomeList == null)
				categoryBiomeList = new ArrayList<>();
			categoryBiomeList.add(biome);
			BIOMES_BY_CATEGORY.put(biome.getCategory(),categoryBiomeList);
		}
	}
}
