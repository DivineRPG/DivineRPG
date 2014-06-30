package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.vanilla.container.ContainerDivineTable;
import net.divinerpg.client.render.GuiResourceLocation;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GuiDivineTable extends GuiContainer {

	public GuiDivineTable(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
		super(new ContainerDivineTable(par1InventoryPlayer, par2World, par3, par4, par5));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRendererObj.drawString("Divine Crafting Table", 40 + 5, - 10 - 10, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 50 + 14, this.ySize - 96 - 10 - 19, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiResourceLocation.divineTable);
		this.xSize = 176;
		this.ySize = 231;
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}