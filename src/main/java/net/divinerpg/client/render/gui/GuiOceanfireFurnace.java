package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiOceanfireFurnace extends GuiInfiniteFurnace {

	public GuiOceanfireFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace entity) {
		super(par1InventoryPlayer, entity, "Oceanfire Furnace", "oceanfireFurnace");
	}
}