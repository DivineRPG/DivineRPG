package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.blocks.arcana.BlockOceanfireFurnace;

public class TileEntityOceanfireFurnace extends TileEntityInfiniteFurnace {

	public TileEntityOceanfireFurnace() {
		super("Oceanfire Furnace", false, 200);
	}

	@Override
	public void addUpdate() {
		BlockOceanfireFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}