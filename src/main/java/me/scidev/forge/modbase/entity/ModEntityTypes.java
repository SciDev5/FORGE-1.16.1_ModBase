package me.scidev.forge.modbase.entity;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.client.render.entity.TestEntityRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, ModBase.MOD_ID);
	
	public static void init(IEventBus eventBus) {
		ENTITIES.register(eventBus);
	}
	
	public static void registerAllEntityAttributes() {
		GlobalEntityTypeAttributes.put(TEST_ENTITY.get(), TestEntity.setCustomAttributes().create());
	}
	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TEST_ENTITY.get(), TestEntityRenderer::new);
	}
	
	// Entities
	public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY = ENTITIES.register("test_entity", () -> EntityType.Builder.create(TestEntity::new, EntityClassification.MONSTER).size(0.5f, 0.5f).build(new ResourceLocation(ModBase.MOD_ID, "test_entity").toString()));
}
