package me.scidev.forge.modbase.item;

import org.apache.logging.log4j.Level;

import me.scidev.forge.modbase.ModBase;
import me.scidev.forge.modbase.itemGroup.ModItemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;

public class TestItem extends Item {

	public TestItem() {
		super(new Properties().maxStackSize(34).group(ModItemGroups.TEST));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ModBase.LOGGER.log(Level.INFO,"testing lol");
		playerIn.setMotion(0d, 3d, 0d);
		playerIn.setHealth((playerIn.getHealth()+1f)%20f);
		ItemStack itemStak = playerIn.getHeldItem(handIn);
		itemStak.setCount(itemStak.getCount()*2);
		worldIn.createExplosion(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 34, Mode.BREAK);
		return new ActionResult<ItemStack>(ActionResultType.PASS,itemStak);
	}
}
