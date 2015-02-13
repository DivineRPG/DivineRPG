package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiZelus extends GuiDivineMerchent{

	public GuiZelus(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Zelus", "zelus");
	}
}