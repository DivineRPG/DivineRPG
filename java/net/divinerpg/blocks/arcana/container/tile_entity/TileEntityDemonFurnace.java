package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.BlockDemonFurnace;

public class TileEntityDemonFurnace extends TileEntityModFurnace {

	public TileEntityDemonFurnace() {
		super("Demon Furnace", false, 300);
	}

	@Override
	public void addUpdate() {
		BlockDemonFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}