package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.divinerpg.utils.MessageLocalizer;

public class GuiOceanfireFurnace extends GuiInfiniteFurnace {

	public GuiOceanfireFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace entity) {
		super(par1InventoryPlayer, entity, (MessageLocalizer.norecolor("tile.oceanfireFurnace.name")), "oceanfireFurnace");
	}
}
