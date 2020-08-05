package me.scidev.forge.modbase.block;

import org.apache.logging.log4j.Level;

import me.scidev.forge.modbase.ModBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class TestBlock extends Block {

	public TestBlock() {
		super(
			Properties.create(Material.CACTUS, MaterialColor.CYAN)
			.hardnessAndResistance(0f, 30f)
			.jumpFactor(43f)
			.harvestLevel(3)
			.harvestTool(ToolType.PICKAXE)
		);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		worldIn.destroyBlock(pos, true);
		worldIn.playSound(player, pos, new SoundEvent(new ResourceLocation("minecraft", "block.note_block.bit")), SoundCategory.MASTER, 1f, 2f);
		
		ResourceLocation ltrl = this.getRegistryName();
		ModBase.LOGGER.log(Level.INFO,ltrl.getNamespace()+":"+ltrl.getPath());
		return ActionResultType.SUCCESS;
	}
}
