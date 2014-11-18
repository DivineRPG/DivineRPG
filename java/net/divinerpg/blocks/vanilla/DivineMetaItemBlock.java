package net.divinerpg.blocks.vanilla;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class DivineMetaItemBlock extends ItemBlock {
	public DivineMetaItemBlock(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String name = "tile." + ((IDivineMetaBlock)Block.getBlockFromItem(stack.getItem())).getNames()[stack.getItemDamage()] + ((IDivineMetaBlock)Block.getBlockFromItem(stack.getItem())).getSuffix();	
		return name;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}