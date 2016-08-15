package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiTinker extends GuiDivineMerchant{

	public GuiTinker(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Tinkerer", "workshopWorker");
	}	
}