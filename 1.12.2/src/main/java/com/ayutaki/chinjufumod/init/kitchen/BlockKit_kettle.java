package com.ayutaki.chinjufumod.init.kitchen;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.init.ASDecoModKitchen;
import com.ayutaki.chinjufumod.init.TTimeItems;
import com.ayutaki.chinjufumod.init.blocks.BlockFacingSapo;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKit_kettle extends BlockFacingSapo {

	public BlockKit_kettle() {
		super(Material.WOOD);

		this.setSoundType(SoundType.WOOD);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);

		if (itemstack.isEmpty()) {

			if (playerIn instanceof EntityPlayer) {
				((EntityPlayer) playerIn).inventory.addItemStackToInventory(new ItemStack(TTimeItems.Item_YAKAN_kara));
				worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, 2.0F);
			}
			worldIn.setBlockState(pos, ASDecoModKitchen.KITCHEN.getDefaultState()
					.withProperty(FACING, state.getValue(FACING)));
		}
		return true;
	}

	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {

	    return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

	        stack.add(new ItemStack(ASDecoModKitchen.KITCHEN, 1, this.damageDropped(state)));
	        stack.add(new ItemStack(TTimeItems.Item_YAKAN_kara, 1, this.damageDropped(state)));

	        return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {

		return new ItemStack(ASDecoModKitchen.KITCHEN);
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
