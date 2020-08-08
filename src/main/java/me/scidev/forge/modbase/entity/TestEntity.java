package me.scidev.forge.modbase.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TestEntity extends MonsterEntity {

	protected TestEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 2d)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25d);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0d));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return 99999;
	}

	@Override protected SoundEvent getAmbientSound() { return SoundEvents.BLOCK_PORTAL_AMBIENT; }
	@Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.BLOCK_ANVIL_USE; }
	@Override protected SoundEvent getDeathSound() { return SoundEvents.BLOCK_BEACON_DEACTIVATE; }
	@Override protected void playStepSound(BlockPos pos, BlockState blockIn) { this.playSound(SoundEvents.BLOCK_BAMBOO_BREAK, 0.2f, 1f); }
	
	@Override
	public void tick() {
		super.tick();
		if (rand.nextFloat() < 0.00025f) {
			world.createExplosion(this, this.getPosX(), this.getPosY()+0.25d, this.getPosZ(), 4, Mode.NONE);
			this.setDead();
		}
	}
	
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
		return worldIn.getLight(this.getOnPosition()) > 10;
	}
}
