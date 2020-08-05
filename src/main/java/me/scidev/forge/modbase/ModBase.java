package me.scidev.forge.modbase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.scidev.forge.modbase.block.ModBlocks;
import me.scidev.forge.modbase.entity.ModEntityTypes;
import me.scidev.forge.modbase.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModBase.MOD_ID)
public class ModBase {
	
	public static final String MOD_ID = "modbase";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public Block block;
	public Item item;
	
	public ModBase() throws Exception {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModBlocks.init(eventBus);
		ModItems.init(eventBus);
		ModEntityTypes.init(eventBus);
	}
}
