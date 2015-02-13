package net.divinerpg.blocks.arcana.container;

import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.base.tileentity.container.ContainerModFurnace;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerNoFuel extends ContainerModFurnace {

	public ContainerNoFuel(InventoryPlayer player, TileEntityModFurnace furnace) {
		super(player, furnace, false);
	}
}