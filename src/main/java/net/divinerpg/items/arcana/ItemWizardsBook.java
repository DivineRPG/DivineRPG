package net.divinerpg.items.arcana;

import net.divinerpg.entities.arcana.EntityDramix;
import net.divinerpg.entities.arcana.EntityParasecta;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWizardsBook extends ItemMod {

	public ItemWizardsBook(String name) {
		super(name, DivineRPGTabs.spawner);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer p, World world, int x, int y, int z, int i, float f, float f1, float f2) {
		EntityParasecta parasecta = new EntityParasecta(world);
		EntityDramix dramix = new EntityDramix(world);
		Block block = world.getBlock(x, y, z);

		if(!world.isRemote){
			if(block == ArcanaBlocks.parasectaAltar){
				parasecta.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				if(world.getCollidingBoundingBoxes(parasecta, parasecta.boundingBox).isEmpty()) { 
				    world.spawnEntityInWorld(parasecta);
				    if(!p.capabilities.isCreativeMode) stack.stackSize--;
				}
				return true;
			} 

			if(block == ArcanaBlocks.dramixAltar){
				dramix.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				if(world.getCollidingBoundingBoxes(dramix, dramix.boundingBox).isEmpty()) { 
				    world.spawnEntityInWorld(dramix);
				    if(!p.capabilities.isCreativeMode) stack.stackSize--;
				}
				return true;
			}
		}
		return false;
	}
}