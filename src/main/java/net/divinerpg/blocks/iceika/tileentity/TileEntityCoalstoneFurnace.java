package net.divinerpg.blocks.iceika.tileentity;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.blocks.iceika.BlockCoalstoneFurnace;

public class TileEntityCoalstoneFurnace extends TileEntityInfiniteFurnace {

	public TileEntityCoalstoneFurnace() {
		super("Coalstone Furnace", 300);
	}

	@Override
	public void addUpdate() {
		BlockCoalstoneFurnace.updateActiveStates(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}