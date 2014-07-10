package net.divinerpg.client;

import net.divinerpg.api.blocks.BlockModBush;
import net.divinerpg.api.blocks.BlockModLeaves;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.client.Minecraft;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientTickHandler {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void tickEnd(ClientTickEvent event) {
		/*boolean isFancy = Minecraft.getMinecraft().gameSettings.fancyGraphics;
		((BlockModBush)IceikaBlocks.winterberryBush).setGraphicsLevel(BlockModBush.isFancy);
		((BlockModBush)IceikaBlocks.winterberryBushRipe).setGraphicsLevel(BlockModBush.isFancy);
		((BlockModLeaves)IceikaBlocks.brittleLeaves).setGraphicsLevel(BlockModLeaves.isFancy);
		((BlockModLeaves)TwilightBlocks.apalachiaLeaves).setGraphicsLevel(BlockModLeaves.isFancy);
		((BlockModLeaves)TwilightBlocks.edenLeaves).setGraphicsLevel(BlockModLeaves.isFancy);
		((BlockModLeaves)TwilightBlocks.mortumLeaves).setGraphicsLevel(BlockModLeaves.isFancy);
		((BlockModLeaves)TwilightBlocks.skythernLeaves).setGraphicsLevel(BlockModLeaves.isFancy);
		((BlockModLeaves)TwilightBlocks.wildWoodLeaves).setGraphicsLevel(BlockModLeaves.isFancy);*/
	}
}