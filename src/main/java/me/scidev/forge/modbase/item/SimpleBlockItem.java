package me.scidev.forge.modbase.item;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class SimpleBlockItem extends BlockItem {

	public SimpleBlockItem(Block blockIn, Properties properties) {
		super(blockIn, properties);
	}

	public SimpleBlockItem(Block blockIn) {
		super(blockIn, new Properties().maxStackSize(ModItems.DEFAULT_STACK_SIZE).group(ModItems.DEFAULT_ITEM_GROUP));
	}
	public SimpleBlockItem(Block blockIn, int stackSize) {
		super(blockIn, new Properties().maxStackSize(stackSize).group(ModItems.DEFAULT_ITEM_GROUP));
	}
	public SimpleBlockItem(Block blockIn, int stackSize, ItemGroup tab) {
		super(blockIn, new Properties().maxStackSize(stackSize).group(tab));
	}

	public static Supplier<BlockItem> simpleSupplier(Supplier<Block> blockSupplierIn) {
		return new Supplier<BlockItem>() {
			private final Supplier<Block> blockSupplier = blockSupplierIn;
			@Override
			public BlockItem get() {
				return new SimpleBlockItem(blockSupplier.get());
			}
		};
	}
}
