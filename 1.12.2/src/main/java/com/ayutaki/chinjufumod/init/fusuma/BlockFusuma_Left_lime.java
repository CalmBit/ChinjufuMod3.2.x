package com.ayutaki.chinjufumod.init.fusuma;

import java.util.Random;

import com.ayutaki.chinjufumod.handlers.SoundsHandler;
import com.ayutaki.chinjufumod.init.ASDecoModFusuma;
import com.ayutaki.chinjufumod.init.blocks.BlockFacingSapo;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class BlockFusuma_Left_lime extends BlockFacingSapo {

	public abstract boolean isOpen();

	public BlockFusuma_Left_lime(Material material) {
		super(material);

		this.setHardness(0.5F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);

		if(!isOpen()) { }
		else { }
	}

	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

	/* 右クリック操作 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if(isOpen()) {
			worldIn.playSound(null, pos, SoundsHandler.FUSUMA, SoundCategory.BLOCKS, 1.0F, 1.0F);
			return worldIn.setBlockState(pos, ASDecoModFusuma.FUSUMA_CL_lime.getDefaultState().withProperty(FACING, state.getValue(FACING)));
		}

		if (playerIn.isSneaking()) {
			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			return worldIn.setBlockState(pos, ASDecoModFusuma.FUSUMA_CR_lime.getDefaultState().withProperty(FACING, state.getValue(FACING)));
		}

		else {
			worldIn.playSound(null, pos, SoundsHandler.FUSUMA, SoundCategory.BLOCKS, 1.0F, 1.0F);
			return worldIn.setBlockState(pos, ASDecoModFusuma.FUSUMA_OL_lime.getDefaultState().withProperty(FACING, state.getValue(FACING)));
		}
	}


	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return new ItemStack(ASDecoModFusuma.FUSUMA_CL_lime).getItem();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ASDecoModFusuma.FUSUMA_CL_lime);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return isOpen() ? new BlockStateContainer(this, new IProperty[] { FACING }) : super.createBlockState();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
	    return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
	    return false;
	}
}
