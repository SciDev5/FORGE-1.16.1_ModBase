package me.scidev.forge.modbase.item;

import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;

public class FoodItem extends SimpleItem {
	public FoodItem(Properties properties, Food foodData) {
		super(properties.food(foodData));
	}
	public FoodItem(Properties properties, Food foodData, int stackSize, ItemGroup itemGroup) {
		super(properties.food(foodData),stackSize,itemGroup);
	}
	public FoodItem(Food foodData, int stackSize, ItemGroup itemGroup) {
		super(new Properties().food(foodData),stackSize, itemGroup);
	}
	public FoodItem(Food foodData, int stackSize) {
		super(new Properties().food(foodData),stackSize,ModItems.DEFAULT_ITEM_GROUP);
	}
	public FoodItem(Food foodData) {
		super(new Properties().food(foodData));
	}
	
	public static Food createSimpleFood(int hunger, int saturation) {
		return new Food.Builder().hunger(hunger).saturation(saturation).build();
	}
}
