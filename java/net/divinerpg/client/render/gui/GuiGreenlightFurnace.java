package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.client.render.GuiModFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiGreenlightFurnace extends GuiModFurnace {

	public GuiGreenlightFurnace(InventoryPlayer par1InventoryPlayer, TileEntityModFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Greenlight Furnace", "noFuel");
	}
}