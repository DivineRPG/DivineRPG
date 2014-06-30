package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.BlockWhitefireFurnace;

public class TileEntityWhitefireFurnace extends TileEntityModFurnace {

	public TileEntityWhitefireFurnace() {
		super("Whitefire Furnace", false, 300);
	}

	@Override
	public void addUpdate() {
		BlockWhitefireFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}