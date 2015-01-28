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
	public void onBlockHarvested(HarvestDropsEvent e) {}
}