package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiCoalstoneFurnace extends GuiInfiniteFurnace {

	public GuiCoalstoneFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Coalstone Furnace", "noFuel");
	}
}