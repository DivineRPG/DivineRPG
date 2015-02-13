package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.blocks.arcana.BlockMoonlightFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;

public class TileEntityMoonlightFurnace extends TileEntityInfiniteFurnace {

	public TileEntityMoonlightFurnace() {
		super("Moonlight Furnace", false, 200);
	}

	@Override
	public void addUpdate() {
		BlockMoonlightFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}