package net.divinerpg.blocks.vanilla;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSteel extends ItemBlock {
	public ItemBlockSteel(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String name = "tile." + BlockSteel.names[stack.getItemDamage()] + "Steel";	
		return name;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}