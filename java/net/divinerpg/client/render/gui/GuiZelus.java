package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;
import net.divinerpg.utils.MessageLocalizer;

public class GuiZelus extends GuiDivineMerchant{

	public GuiZelus(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, (MessageLocalizer.norecolor("entity.DRPGZelus.name")), "zelus");
	}
}
