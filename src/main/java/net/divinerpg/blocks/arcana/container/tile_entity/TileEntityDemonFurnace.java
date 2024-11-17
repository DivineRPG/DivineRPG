package net.divinerpg.blocks.arcana.container.tile_entity;

import java.util.Random;

import net.divinerpg.blocks.arcana.BlockDemonFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class TileEntityDemonFurnace extends TileEntityInfiniteFurnace {
	private Random rand = new Random();

	public TileEntityDemonFurnace() {
		super("Demon Furnace", 100);
	}

	@Override
	public void addUpdate() {
		BlockDemonFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	}

    public void updateEntity() {
    	super.updateEntity();
        if(!this.worldObj.isRemote) {
            if(this.isBurning() && this.rand.nextInt(50) == 0) {
				int x = this.xCoord + this.rand.nextInt(3) - 1;
				int y = this.yCoord + this.rand.nextInt(3) - 1;
				int z = this.zCoord + this.rand.nextInt(3) - 1;
				Block b = this.worldObj.getBlock(x, y, z);
				if (b == Blocks.air) {
					this.worldObj.setBlock(x, y, z, Blocks.fire);
				}
            }
        }
    }
}