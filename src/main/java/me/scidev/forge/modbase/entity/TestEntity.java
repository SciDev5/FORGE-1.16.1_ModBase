package me.scidev.forge.modbase.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.JumpGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestEntity extends AnimalEntity {

	protected TestEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 2d)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5d);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new JumpGoal() {
			@Override
			public boolean shouldExecute() {
				return true;
			}
		});
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 1394;
	}

	@Override protected SoundEvent getAmbientSound() { return SoundEvents.BLOCK_PORTAL_AMBIENT; }
	@Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.BLOCK_ANVIL_USE; }
	@Override protected SoundEvent getDeathSound() { return SoundEvents.BLOCK_ANVIL_FALL; }
	@Override protected void playStepSound(BlockPos pos, BlockState blockIn) { this.playSound(SoundEvents.BLOCK_BAMBOO_BREAK, 0.2f, 1f); }
	
	@Override
	public AgeableEntity createChild(AgeableEntity arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
