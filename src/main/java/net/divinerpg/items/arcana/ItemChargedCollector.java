package net.divinerpg.items.arcana;

import net.divinerpg.entities.arcana.EntityConstructor;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChargedCollector extends ItemMod {

	public ItemChargedCollector(String name) {
		super(name);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		EntityConstructor con = new EntityConstructor(world);
		Block block = world.getBlock(x, y, z);
		if(!world.isRemote){
			if(block == ArcanaBlocks.dramixAltar){
				con.setLocationAndAngles(x + 0.5F, y + 1, z + 0.5F, 0.0F, 0.0F);
				if(world.getCollidingBoundingBoxes(con, con.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(con);
                    if(!player.capabilities.isCreativeMode)stack.stackSize--;
                }
				return true;
			}
		}
		return false;
	}
		
	@Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}