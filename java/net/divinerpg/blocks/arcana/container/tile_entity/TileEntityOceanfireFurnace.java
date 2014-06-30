package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.BlockOceanfireFurnace;

public class TileEntityOceanfireFurnace extends TileEntityModFurnace {

	public TileEntityOceanfireFurnace() {
		super("Oceanfire Furnace", false, 300);
	}

	@Override
	public void addUpdate() {
		BlockOceanfireFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}