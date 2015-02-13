package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiGreenlightFurnace extends GuiInfiniteFurnace {

	public GuiGreenlightFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Greenlight Furnace", "noFuel");
	}
}