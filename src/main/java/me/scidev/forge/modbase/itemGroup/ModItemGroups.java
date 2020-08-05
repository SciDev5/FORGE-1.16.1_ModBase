package me.scidev.forge.modbase.itemGroup;

import me.scidev.forge.modbase.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
	public static final ItemGroup TEST = new ItemGroup("test") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItems.TEST_ITEM.get(),1);
		}
	};
}
