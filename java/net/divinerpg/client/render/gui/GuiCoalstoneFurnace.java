package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.divinerpg.utils.MessageLocalizer;

public class GuiCoalstoneFurnace extends GuiInfiniteFurnace {

	public GuiCoalstoneFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, (MessageLocalizer.norecolor("tile.coalstoneFurnace.name")), "noFuel");
	}
}
