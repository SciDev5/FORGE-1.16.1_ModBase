package me.scidev.forge.modbase.world.gen;

import java.util.List;

import me.scidev.forge.modbase.entity.ModEntityTypes;
import me.scidev.forge.modbase.utils.BiomeUtils;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;

public class ModEntitySpawns {
	
	public static void registerSpawns() {
		registerSimpleSpawn(BiomeUtils.ALL_BIOMES, EntityClassification.MONSTER, ModEntityTypes.TEST_ENTITY.get(), 20, 2, 8);
	}
	public static void registerSimpleSpawn(List<Biome> biomes, EntityClassification entityClassification, EntityType<?> entityTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
		for (Biome biome : biomes)
			biome.getSpawns(entityClassification)
			.add(new Biome.SpawnListEntry(entityTypeIn, weight, minGroupCountIn, maxGroupCountIn));
	}

}
