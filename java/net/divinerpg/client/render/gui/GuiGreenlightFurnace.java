package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.client.render.GuiModFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.divinerpg.utils.MessageLocalizer;

public class GuiGreenlightFurnace extends GuiModFurnace {

	public GuiGreenlightFurnace(InventoryPlayer par1InventoryPlayer, TileEntityModFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, (MessageLocalizer.normal("tile.greenlightFurnace")), "greenlightFurnace");
	}
}
