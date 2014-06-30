package net.divinerpg.client.render.gui;

import net.divinerpg.api.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiDatticon extends GuiDivineMerchent{

	public GuiDatticon(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Datticon", "datticon");
	}
}