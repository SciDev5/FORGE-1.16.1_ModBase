package me.scidev.forge.modbase.block;

import me.scidev.forge.modbase.ModBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModBase.MOD_ID);
	
	public static void init(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
	// Blocks
	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new TestBlock());
	public static final RegistryObject<Block> TEST_ORE = BLOCKS.register("test_ore", () -> 
		new SimpleOreBlock(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
			.setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE)
			.hardnessAndResistance(3f, 10f), 3, 6)
		);
}
