package net.divinerpg.utils.events;

import java.util.Random;

import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHarvest {

	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent e){
		Block ice = Blocks.ice;
		Block snowLayer = Blocks.snow_layer;
		Block snow = Blocks.snow;
		Item snowFlake = IceikaItems.snowflake;
		Random dropChance = new Random();
		EntityItem flake = new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(snowFlake));
		if(e.harvester != null){
			if(e.block == snow || e.block == snowLayer || e.block == ice){
				if(dropChance.nextInt(100) == 0)
					e.world.spawnEntityInWorld(flake);
			}
		}	
	}
}