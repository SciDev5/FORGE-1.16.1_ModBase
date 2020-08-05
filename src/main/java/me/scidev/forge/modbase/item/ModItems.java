package me.scidev.forge.modbase.item;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.block.ModBlocks;
import me.scidev.forge.modbase.itemGroup.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static ItemGroup DEFAULT_ITEM_GROUP = ModItemGroups.TEST;
	public static int DEFAULT_STACK_SIZE = 64;

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModBase.MOD_ID);
	
	
	public static void init(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
	
	// Items
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new TestItem());
	
	// ItemBlocks
	public static final RegistryObject<Item> TEST_BLOCK_ITEM = ITEMS.register("test_block",SimpleBlockItem.simpleSupplier(ModBlocks.TEST_BLOCK));
}
