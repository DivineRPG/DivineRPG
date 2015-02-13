package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.blocks.arcana.BlockGreenlightFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;

public class TileEntityGreenlightFurnace extends TileEntityInfiniteFurnace {

	public TileEntityGreenlightFurnace() {
		super("Greenlight Furnace", false, 250);
	}

	@Override
	public void addUpdate() {
		BlockGreenlightFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}