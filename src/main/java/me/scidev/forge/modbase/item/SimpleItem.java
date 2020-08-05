package me.scidev.forge.modbase.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SimpleItem extends Item {
	
	public SimpleItem(Properties properties, int stackSize, ItemGroup itemGroup) {
		super(properties.maxStackSize(stackSize).group(ModItems.DEFAULT_ITEM_GROUP));
	}
	public SimpleItem(Properties properties) {
		super(properties.maxStackSize(ModItems.DEFAULT_STACK_SIZE).group(ModItems.DEFAULT_ITEM_GROUP));
	}
	public SimpleItem(int stackSize, ItemGroup itemGroup) {
		super(new Properties().maxStackSize(stackSize).group(ModItems.DEFAULT_ITEM_GROUP));
	}
	public SimpleItem(int stackSize) {
		this(stackSize,ModItems.DEFAULT_ITEM_GROUP);
	}
	public SimpleItem() {
		this(ModItems.DEFAULT_STACK_SIZE,ModItems.DEFAULT_ITEM_GROUP);
	}
}
