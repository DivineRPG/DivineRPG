package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiVatticus extends GuiDivineMerchent{

	public GuiVatticus(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Vatticus", "vatticus");
	}
}