package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.base.tileentity.container.ContainerDivineMerchant;
import net.minecraft.entity.IMerchant;

public class GuiLeorna extends GuiDivineMerchant{

	public GuiLeorna(ContainerDivineMerchant container, IMerchant mer) {
		super(container, mer, "Leorna", "leorna");
	}
}