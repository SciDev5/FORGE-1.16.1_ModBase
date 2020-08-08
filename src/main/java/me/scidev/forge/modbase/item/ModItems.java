package me.scidev.forge.modbase.item;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.armor.ModArmorMaterial;
import me.scidev.forge.modbase.block.ModBlocks;
import me.scidev.forge.modbase.itemGroup.ModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static ItemGroup DEFAULT_ITEM_GROUP = ModItemGroups.TEST;
	public static int DEFAULT_STACK_SIZE = 64;
	public static int DEFAULT_TOOL_STACK_SIZE = 1;

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModBase.MOD_ID);
	
	public static void init(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
	// Items
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new TestItem());
	public static final RegistryObject<Item> TEST_TOOL = ITEMS.register("test_tool", () -> new PickaxeItem(ModItemTier.TEST, 1, -2.8f, new Properties().group(DEFAULT_ITEM_GROUP)));
	public static final RegistryObject<Item> TEST_FOOD = ITEMS.register("test_food", () -> new FoodItem(FoodItem.createSimpleFood(4, 10)));
	
	// ItemBlocks
	public static final RegistryObject<Item> TEST_BLOCK_ITEM = ITEMS.register("test_block",SimpleBlockItem.simpleSupplier(ModBlocks.TEST_BLOCK));
	public static final RegistryObject<Item> TEST_ORE_ITEM = ITEMS.register("test_ore",SimpleBlockItem.simpleSupplier(ModBlocks.TEST_ORE));

	// Armor
	public static final RegistryObject<Item> TEST_HELMET = ITEMS.register("test_helmet", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Properties().group(DEFAULT_ITEM_GROUP)));
	public static final RegistryObject<Item> TEST_CHESTPLATE = ITEMS.register("test_chestplate", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Properties().group(DEFAULT_ITEM_GROUP)));
	public static final RegistryObject<Item> TEST_LEGGINGS = ITEMS.register("test_leggings", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Properties().group(DEFAULT_ITEM_GROUP)));
	public static final RegistryObject<Item> TEST_BOOTS = ITEMS.register("test_boots", () -> new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Properties().group(DEFAULT_ITEM_GROUP)));
}
