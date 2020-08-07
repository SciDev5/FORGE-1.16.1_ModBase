package me.scidev.forge.modbase.armor;

import java.util.function.Supplier;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.item.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
	TEST("test", 100, new int[]{4, 8, 10, 4}, 215, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3.0F, 2.0F, () -> {
		return Ingredient.fromItems(ModItems.TEST_ITEM.get());
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairMaterial;
	
	private ModArmorMaterial(
			String nameIn, int maxDamageFactorIn, int[] damageReductionAmountArrayIn,
			int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, 
			float knockbackResistanceIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = ModBase.MOD_ID+":"+nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountArrayIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.knockbackResistance = knockbackResistanceIn;
		this.repairMaterial = repairMaterialIn;
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.get();
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

}
