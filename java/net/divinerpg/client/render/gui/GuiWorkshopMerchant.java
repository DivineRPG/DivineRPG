package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;
import net.divinerpg.utils.MessageLocalizer;

public class GuiWorkshopMerchant extends GuiDivineMerchant{

	public GuiWorkshopMerchant(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, (MessageLocalizer.norecolor("entity.DRPGWorkshopMerchant.name")), "workshopWorker");
	}

}
