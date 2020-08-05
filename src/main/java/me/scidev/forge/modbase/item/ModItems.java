package me.scidev.forge.modbase.item;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.block.ModBlocks;
import me.scidev.forge.modbase.itemGroup.ModItemGroups;
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
	public static final RegistryObject<Item> TEST_TOOL_ITEM = ITEMS.register("test_tool", () -> new PickaxeItem(ModItemTier.TEST, 1, -2.8f, new Properties().group(DEFAULT_ITEM_GROUP)));
	public static final RegistryObject<Item> TEST_FOOD_ITEM = ITEMS.register("test_food", () -> new FoodItem(FoodItem.createSimpleFood(4, 10)));
	
	// ItemBlocks
	public static final RegistryObject<Item> TEST_BLOCK_ITEM = ITEMS.register("test_block",SimpleBlockItem.simpleSupplier(ModBlocks.TEST_BLOCK));
}
