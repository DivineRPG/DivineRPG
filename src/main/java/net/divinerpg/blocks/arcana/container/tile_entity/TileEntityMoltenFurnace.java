package net.divinerpg.blocks.arcana.container.tile_entity;

import net.divinerpg.blocks.arcana.BlockMoltenFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;

public class TileEntityMoltenFurnace extends TileEntityInfiniteFurnace {

	public TileEntityMoltenFurnace() {
		super("Molten Furnace", 275);
	}

	@Override
	public void addUpdate() {
		BlockMoltenFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}
}