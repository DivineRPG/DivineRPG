package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.util.StatCollector;

public class GuiHunger extends GuiDivineMerchant{

	public GuiHunger(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "The Hunger", "hunger");
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		this.fontRendererObj.drawString(name, 56, 6, 16733279);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 16733279);
	}
}