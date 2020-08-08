package me.scidev.forge.modbase.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;

public class ModSpawnEggItem extends SpawnEggItem {

	protected static final List<SpawnEggItem> modSpawnEggs = new ArrayList<>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;
	
	public ModSpawnEggItem(RegistryObject<? extends EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn, Properties builder) {
		super(null, primaryColorIn, secondaryColorIn, builder);
		this.entityTypeSupplier = Lazy.of(typeIn::get);
		modSpawnEggs.add(this);
	}
	
	public static void registerSpawnEggs() {
		DefaultDispenseItemBehavior dispenseSpawnEggBehavior = new DefaultDispenseItemBehavior() {
			@Override
			protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
				Direction direction = source.getBlockState().get(DispenserBlock.FACING);
				BlockPos placeBlock = source.getBlockPos().add(direction.getDirectionVec());
				BlockState placeLocState = source.getWorld().getBlockState(placeBlock);
				if (placeLocState.causesSuffocation(source.getWorld(), placeBlock))
					return stack;
				
				EntityType<?> type = ((SpawnEggItem)stack.getItem()).getType(stack.getTag());
				BlockPos spwanPos = new BlockPos(source.getX() + (double)direction.getXOffset() * (0.5000099999997474D + (double)type.getWidth() / 2.0D), source.getY() + (double)direction.getYOffset() * (0.5000099999997474D + (double)type.getHeight() / 2.0D) - (double)type.getHeight() / 2.0D, source.getZ() + (double)direction.getZOffset() * (0.5000099999997474D + (double)type.getWidth() / 2.0D));
				type.spawn(source.getWorld(), stack, null, spwanPos, SpawnReason.DISPENSER, true, false);
								
				stack.shrink(1);
				return stack;
			}
		};
		for (SpawnEggItem egg : modSpawnEggs) 
			DispenserBlock.registerDispenseBehavior(egg, dispenseSpawnEggBehavior);
		modSpawnEggs.clear();
	}
	
	@Override
	public EntityType<?> getType(CompoundNBT nbt) {
		return entityTypeSupplier.get();
	}

}
