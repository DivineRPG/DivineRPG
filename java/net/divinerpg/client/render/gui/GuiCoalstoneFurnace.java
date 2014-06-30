package net.divinerpg.client.render.gui;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.iceika.container.ContainerCoalstoneFurnace;
import net.divinerpg.blocks.iceika.container.tile_entity.TileEntityCoalstoneFurnace;
import net.divinerpg.client.render.GuiModFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiCoalstoneFurnace extends GuiModFurnace {

	public GuiCoalstoneFurnace(InventoryPlayer par1InventoryPlayer, TileEntityModFurnace par2TileEntityFurnace) {
		super(par1InventoryPlayer, par2TileEntityFurnace, "Coalstone Furnace", "noFuel");
	}
}