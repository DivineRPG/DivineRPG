package net.divinerpg.blocks.vanilla;

import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if(Block.getBlockFromItem(stack.getItem()) == VanillaBlocks.lamp1 && stack.getItemDamage() == 7) player.triggerAchievement(DivineRPGAchievements.oneLampTwoLampRedLampBlueLamp);
	}
}