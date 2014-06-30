package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.client.render.GuiModFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiExtractor extends GuiModFurnace {

	public GuiExtractor(InventoryPlayer par1InventoryPlayer, TileEntityModFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Extractor", "extractor");
	}
}