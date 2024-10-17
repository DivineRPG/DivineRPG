package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.divinerpg.utils.MessageLocalizer;

public class GuiWhitefireFurnace extends GuiInfiniteFurnace {

	public GuiWhitefireFurnace(InventoryPlayer par1InventoryPlayer, TileEntityInfiniteFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, (MessageLocalizer.norecolor("tile.whitefireFurnace.name")), "whitefireFurnace");
	}
}
