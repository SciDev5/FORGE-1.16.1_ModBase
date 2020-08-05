package me.scidev.forge.modbase.client.render.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import me.scidev.forge.modbase.entity.TestEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class TestEntityModel<T extends TestEntity> extends EntityModel<T> {

	private final ModelRenderer model_0;
	
	public TestEntityModel() {
		textureWidth = 32;
		textureHeight = 16;
		
		model_0 = new ModelRenderer(this);
		model_0.setRotationPoint(0f, 0f, 0f);
		model_0.setTextureOffset(0, 0).addBox(-4f, 16f, -4f, 8f, 8f, 8f,false);
	}
	
	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// not useful
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
		model_0.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}
