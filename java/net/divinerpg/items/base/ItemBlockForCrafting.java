package net.divinerpg.items.base;

import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockForCrafting extends ItemBlock {

	public ItemBlockForCrafting(Block b) {
		super(b);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
	}

}
