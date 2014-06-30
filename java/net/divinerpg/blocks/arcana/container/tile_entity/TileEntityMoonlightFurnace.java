package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.BlockMoonlightFurnace;

public class TileEntityMoonlightFurnace extends TileEntityModFurnace {

	public TileEntityMoonlightFurnace() {
		super("Moonlight Furnace", false, 300);
	}

	@Override
	public void addUpdate() {
		BlockMoonlightFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}