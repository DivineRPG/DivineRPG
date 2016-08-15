package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiWhitefireFurnace extends GuiInfiniteFurnace {

	public GuiWhitefireFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Whitefire Furnace", "whitefireFurnace");
	}
}