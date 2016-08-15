package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiWorkshopMerchant extends GuiDivineMerchant{

	public GuiWorkshopMerchant(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Merchant", "workshopWorker");
	}

}