package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.client.render.GuiModFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiMoonlightFurnace extends GuiModFurnace {

	public GuiMoonlightFurnace(InventoryPlayer par1InventoryPlayer, TileEntityModFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Moonlight Furnace", "moonlightFurnace");
	}
}