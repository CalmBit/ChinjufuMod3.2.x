package com.ayutaki.chinjufumod.init.pantry;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.init.ASDecoModPantry;
import com.ayutaki.chinjufumod.init.ChinjufuModTabs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBoxH_Apple extends BlockBox_Apple {

	public BlockBoxH_Apple(String unlocalizedName) {
		super(unlocalizedName);
		this.setCreativeTab(ChinjufuModTabs.tab_teatime);

	}

	@Override
	public boolean isDouble() {
		return false;
	}

	/*ドロップ指定、ピックアップ指定*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

	        stack.add(new ItemStack(ASDecoModPantry.BOX_H_EMPTY, 1, this.damageDropped(state)));
	        stack.add(new ItemStack(Items.APPLE, 8, this.damageDropped(state)));
	        return stack;

	}
}
