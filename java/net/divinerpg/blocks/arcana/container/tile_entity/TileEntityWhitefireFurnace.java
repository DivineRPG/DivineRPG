package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.blocks.arcana.BlockWhitefireFurnace;

public class TileEntityWhitefireFurnace extends TileEntityInfiniteFurnace {

	public TileEntityWhitefireFurnace() {
		super("Whitefire Furnace", false, 200);
	}

	@Override
	public void addUpdate() {
		BlockWhitefireFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}