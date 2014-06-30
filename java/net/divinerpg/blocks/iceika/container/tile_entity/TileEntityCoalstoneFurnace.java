package net.divinerpg.blocks.iceika.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.iceika.BlockCoalstoneFurnace;

public class TileEntityCoalstoneFurnace extends TileEntityModFurnace {

	public TileEntityCoalstoneFurnace() {
		super("Coalstone", false, 200);
	}

	@Override
	public void addUpdate() {
		BlockCoalstoneFurnace.updateActiveStates(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}