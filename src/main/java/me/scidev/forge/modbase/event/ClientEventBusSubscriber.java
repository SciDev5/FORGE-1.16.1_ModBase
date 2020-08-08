package me.scidev.forge.modbase.event;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.entity.ModEntityTypes;
import me.scidev.forge.modbase.item.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ModBase.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	@SubscribeEvent
	public static void clientSetup (FMLClientSetupEvent e) {
		ModEntityTypes.registerEntityRenderers();
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.registerSpawnEggs();
	}
}
