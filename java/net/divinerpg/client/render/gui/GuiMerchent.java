package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiMerchent extends GuiDivineMerchent{

	public GuiMerchent(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Merchant", "workshopWorker");
	}

}