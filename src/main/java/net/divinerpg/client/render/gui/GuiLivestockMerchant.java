package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.IMerchant;
import net.minecraft.util.StatCollector;

public class GuiLivestockMerchant extends GuiDivineMerchant {

	public GuiLivestockMerchant(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Livestock Merchant", "livestockMerchant");
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		this.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, name, 90, 6, 0x4EC215);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 0x4EC215);
	}
	@Override
	public void drawCenteredString(FontRenderer f, String text, int x, int y, int color) {
		f.drawString(text, x - f.getStringWidth(text) / 2, y, color);
	}

}