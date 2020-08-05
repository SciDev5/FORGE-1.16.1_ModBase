package me.scidev.forge.modbase.client.render.entity;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.client.render.entity.model.TestEntityModel;
import me.scidev.forge.modbase.entity.TestEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TestEntityRenderer extends MobRenderer<TestEntity, TestEntityModel<TestEntity>> {

	private static final ResourceLocation TEXT_RESOURCE_LOCATION = new ResourceLocation(ModBase.MOD_ID, "textures/entities/test_entity.png");

	public TestEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager, new TestEntityModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(TestEntity entity) {
		return TEXT_RESOURCE_LOCATION;
	}
	
}
