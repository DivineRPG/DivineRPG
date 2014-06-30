package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.blocks.arcana.BlockMoltenFurnace;

public class TileEntityMoltenFurnace extends TileEntityModFurnace {

	public TileEntityMoltenFurnace() {
		super("Molten Furnace", false, 300);
	}

	@Override
	public void addUpdate() {
		BlockMoltenFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}