package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiDemonFurnace extends GuiInfiniteFurnace {

	public GuiDemonFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Demon Furnace", "demonFurnace");
	}
}