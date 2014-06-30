package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.twilight.ContainerTwilightFurnace;
import net.divinerpg.blocks.twilight.TileEntityTwilightFurnace;
import net.divinerpg.client.render.GuiModFurnace;
import net.divinerpg.client.render.GuiResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiTwilightFurnace extends GuiModFurnace {

	public GuiTwilightFurnace(InventoryPlayer par1InventoryPlayer, TileEntityModFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Twilight Furnace", "furnace");
	}
}