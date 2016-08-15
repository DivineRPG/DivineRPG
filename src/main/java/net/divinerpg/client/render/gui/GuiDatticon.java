package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiDatticon extends GuiDivineMerchant{

	public GuiDatticon(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Datticon", "datticon");
	}
}