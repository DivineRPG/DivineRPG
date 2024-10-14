package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;
import net.divinerpg.utils.MessageLocalizer;

public class GuiMerik extends GuiDivineMerchant{

	public GuiMerik(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, (MessageLocalizer.normal("entity.DRPGCaptainMerik.name")), "merik");
	}

}
