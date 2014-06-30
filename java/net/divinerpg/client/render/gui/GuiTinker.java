package net.divinerpg.client.render.gui;

import net.divinerpg.api.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiTinker extends GuiDivineMerchent{

	public GuiTinker(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Tinkerer", "workshopWorker");
	}	
}