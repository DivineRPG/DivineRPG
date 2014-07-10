package net.divinerpg.utils.events;

import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventBucketFill {

	@SubscribeEvent
	public void onBucketFilledEvent(FillBucketEvent e){
		if(e.current.getItem() != Items.bucket){
			return;
		}

		ItemStack filledBucket = getLiquid(e.world, e.target);

		if(filledBucket == null)
			return;

		e.world.setBlockToAir(e.target.blockX, e.target.blockY, e.target.blockZ);
		e.result = filledBucket;
		e.setResult(Result.ALLOW);
	}

	public ItemStack getLiquid(World w, MovingObjectPosition m){
		Block block = w.getBlock(m.blockX, m.blockY, m.blockZ);
		if(block == VanillaBlocks.tar){
			return new ItemStack(VanillaItemsOther.tarBucket);
		}

		return null;
	}

}
