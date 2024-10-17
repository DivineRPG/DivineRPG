package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.util.StatCollector;
import net.divinerpg.utils.MessageLocalizer;

public class GuiJackOMan extends GuiDivineMerchant{

	public GuiJackOMan(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, (MessageLocalizer.norecolor("entity.DRPGJackOMan.name")), "jackOMan");
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		this.fontRendererObj.drawString(name, 56, 6, 0xFFED00);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 0xFFED00);
	}
}
