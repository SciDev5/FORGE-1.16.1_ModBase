package me.scidev.forge.modbase.item;

import java.util.List;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class ToolItem extends Item {
	protected final float efficiency;
	private final Multimap<Attribute, AttributeModifier> attributes;
	private final IItemTier tier;
	
	public ToolItem(Properties properties, ToolType toolType, IItemTier toolTier, float relativeEfficiency, int attackDamageIn, float attackSpeedIn) {
		super(properties.addToolType(toolType, toolTier.getHarvestLevel()).defaultMaxDamage(toolTier.getMaxUses()));
		this.tier = toolTier;
		this.efficiency = relativeEfficiency * tier.getEfficiency();
	    Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	    builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)(attackDamageIn + tier.getAttackDamage()), AttributeModifier.Operation.ADDITION));
	    builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)attackSpeedIn, AttributeModifier.Operation.ADDITION));
	    this.attributes = builder.build();
	}
	public ToolItem(Properties properties, List<ToolType> toolTypes, IItemTier toolTier, float relativeEfficiency, int attackDamageIn, float attackSpeedIn) {
		super(ToolItem.addAllToolTypes(properties, toolTypes, toolTier).defaultMaxDamage(toolTier.getMaxUses()));
		this.tier = toolTier;
		this.efficiency = relativeEfficiency * tier.getEfficiency();
	    Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
	    builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)(attackDamageIn + tier.getAttackDamage()), AttributeModifier.Operation.ADDITION));
	    builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)attackSpeedIn, AttributeModifier.Operation.ADDITION));
	    this.attributes = builder.build();
	}

	public ToolItem(ToolType toolType, IItemTier toolLevel, float relativeEfficiency, int attackDamageIn, float attackSpeedIn) {
		this(new Properties().group(ModItems.DEFAULT_ITEM_GROUP), toolType, toolLevel, relativeEfficiency, attackDamageIn, attackSpeedIn);
	}
	public ToolItem(ToolType toolType, IItemTier toolLevel, float relativeEfficiency, int attackDamageIn, float attackSpeedIn, ItemGroup group) {
		this(new Properties().group(group), toolType, toolLevel, relativeEfficiency, attackDamageIn, attackSpeedIn);
	}
	
	public ToolItem(List<ToolType> toolTypes, IItemTier toolTier, float relativeEfficiency, int attackDamageIn, float attackSpeedIn) {
		this(new Properties().group(ModItems.DEFAULT_ITEM_GROUP), toolTypes, toolTier, relativeEfficiency, attackDamageIn, attackSpeedIn);
	}
	public ToolItem(List<ToolType> toolTypes, IItemTier toolTier, float relativeEfficiency, int attackDamageIn, float attackSpeedIn, ItemGroup group) {
		this(new Properties().group(group), toolTypes, toolTier, relativeEfficiency, attackDamageIn, attackSpeedIn);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return this.canHarvestBlock(stack, state) ? this.efficiency : 1f;
	}

	@Override
	public boolean canHarvestBlock(ItemStack stack, BlockState state) {
		for (ToolType toolType : this.getToolTypes(stack))
			if (state.getBlock().isToolEffective(state,toolType))
				return true;
		return false;
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damageItem(2, attacker, (entity) -> {
			entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});
		return true;
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		if (!worldIn.isRemote && state.getBlockHardness(worldIn, pos) != 0.0F) {
			stack.damageItem(1, entityLiving, (entity) -> {
				entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			});
		}

		return true;
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
	@Override
	public int getItemEnchantability(ItemStack stack) {
		return tier.getEnchantability();
	}
	
	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributes : super.getAttributeModifiers(equipmentSlot);
	}
	
	public static Properties addAllToolTypes(Properties properties, List<ToolType> toolInfos, IItemTier toolTier) {
		for (ToolType type : toolInfos)
			properties.addToolType(type, toolTier.getHarvestLevel());
		return properties;
	}
}
