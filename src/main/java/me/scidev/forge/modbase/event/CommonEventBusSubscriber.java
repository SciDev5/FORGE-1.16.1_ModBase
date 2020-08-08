package me.scidev.forge.modbase.event;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.entity.ModEntityTypes;
import me.scidev.forge.modbase.utils.BiomeUtils;
import me.scidev.forge.modbase.world.gen.ModEntitySpawns;
import me.scidev.forge.modbase.world.gen.ModOreGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = ModBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEventBusSubscriber {
	@SubscribeEvent
	public static void commonSetup(final FMLCommonSetupEvent setupEvent) {
		DeferredWorkQueue.runLater(new Runnable() {
			@Override public void run() {
				ModEntityTypes.registerAllEntityAttributes();
			}
		});
	}
	@SubscribeEvent
	public static void postWorldLoad(final FMLLoadCompleteEvent event) {
		BiomeUtils.assembleBiomeInfo();
		ModOreGenerator.generateAllOres();
		ModEntitySpawns.registerSpawns();
	}
}
