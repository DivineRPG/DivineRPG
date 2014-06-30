package net.divinerpg.helper.event;

import net.divinerpg.api.blocks.BlockModBush;
import net.divinerpg.helper.blocks.IceikaBlocks;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventBonemeal {

	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event) {
		if(event.world.getBlock(event.x, event.y, event.z) == IceikaBlocks.winterberryBush) {
			((BlockModBush)IceikaBlocks.winterberryBush).grow(event.world, event.x, event.y, event.z);
		}
	}
	
}
