package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.blocks.arcana.BlockOceanfireFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;

public class TileEntityOceanfireFurnace extends TileEntityInfiniteFurnace {

	public TileEntityOceanfireFurnace() {
		super("Oceanfire Furnace", 225);
	}

	@Override
	public void addUpdate() {
		BlockOceanfireFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}