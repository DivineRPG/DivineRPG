package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.blocks.arcana.BlockWhitefireFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;

public class TileEntityWhitefireFurnace extends TileEntityInfiniteFurnace {

	public TileEntityWhitefireFurnace() {
		super("Whitefire Furnace", 150);
	}

	@Override
	public void addUpdate() {
		BlockWhitefireFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}