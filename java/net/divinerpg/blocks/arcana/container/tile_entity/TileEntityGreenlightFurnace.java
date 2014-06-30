package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.BlockGreenlightFurnace;

public class TileEntityGreenlightFurnace extends TileEntityModFurnace {

	public TileEntityGreenlightFurnace() {
		super("Greenlight Furnace", false, 300);
	}

	@Override
	public void addUpdate() {
		BlockGreenlightFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}