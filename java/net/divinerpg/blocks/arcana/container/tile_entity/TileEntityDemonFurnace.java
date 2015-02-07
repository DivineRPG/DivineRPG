package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.blocks.arcana.BlockDemonFurnace;

public class TileEntityDemonFurnace extends TileEntityInfiniteFurnace {

	public TileEntityDemonFurnace() {
		super("Demon Furnace", false, 100);
	}

	@Override
	public void addUpdate() {
		BlockDemonFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}