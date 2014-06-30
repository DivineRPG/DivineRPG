package net.divinerpg.client.render.gui;

import net.divinerpg.api.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiJackOMan extends GuiDivineMerchent{

	public GuiJackOMan(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Jack 'O' Man", "jackOMan");
	}
}