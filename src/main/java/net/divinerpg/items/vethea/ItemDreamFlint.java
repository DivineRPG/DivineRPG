package net.divinerpg.items.vethea;

import net.divinerpg.entities.vethea.EntityKaros;
import net.divinerpg.entities.vethea.EntityQuadro;
import net.divinerpg.entities.vethea.EntityRaglok;
import net.divinerpg.entities.vethea.EntityWreck;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDreamFlint extends ItemMod {

	public ItemDreamFlint() {
		super("dreamFlint", DivineRPGTabs.spawner);
		setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {	
		if(!world.isRemote && world.getBlock(x, y+1, z) == Blocks.air && world.getBlock(x, y+2, z) == Blocks.air && player.canPlayerEdit(x, y+1, z, side, stack)) {
			if(world.getBlock(x, y, z) == VetheaBlocks.wreckAltar) {
				EntityWreck entity = new EntityWreck(world);
				entity.setLocationAndAngles(x, y+1, z, 0, 0);
				if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
				    world.spawnEntityInWorld(entity);
				    if(!player.capabilities.isCreativeMode)stack.stackSize--;
				}
			} else if(world.getBlock(x, y, z) == VetheaBlocks.raglokAltar) {
				EntityRaglok entity = new EntityRaglok(world);
				entity.setLocationAndAngles(x, y+1, z, 0, 0);
				if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(entity);
                    if(!player.capabilities.isCreativeMode)stack.stackSize--;
                }
			} else if(world.getBlock(x, y, z) == VetheaBlocks.karosAltar) {
				EntityKaros entity = new EntityKaros(world);
				entity.setLocationAndAngles(x, y+1, z, 0, 0);
				if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(entity);
                    if(!player.capabilities.isCreativeMode)stack.stackSize--;
                }
			} else if(world.getBlock(x, y, z) == VetheaBlocks.quadroticAltar) {
				EntityQuadro entity = new EntityQuadro(world);
				entity.setLocationAndAngles(x, y+1, z, 0, 0);
				if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(entity);
                    if(!player.capabilities.isCreativeMode)stack.stackSize--;
                }
			} else if(world.getBlock(x, y, z) == VetheaBlocks.wreckAltar) {
				EntityWreck entity = new EntityWreck(world);
				entity.setLocationAndAngles(x, y+1, z, 0, 0);
				if(world.getCollidingBoundingBoxes(entity, entity.boundingBox).isEmpty()) { 
                    world.spawnEntityInWorld(entity);
                    if(!player.capabilities.isCreativeMode)stack.stackSize--;
                }
			}
			else {
				return false;
			}
			return true;
		}
		return false;
	}

}