package net.divinerpg.blocks.vanilla.container.tileentity;

import net.divinerpg.blocks.vanilla.BlockBoneChest;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntityBoneChest extends TileEntityChest {
	
	public TileEntityBoneChest() {
		this.func_145976_a("Bone Chest");
	}
	
	@Override
	public void closeInventory()
    {
        if (this.getBlockType() instanceof BlockBoneChest)
        {
            --this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
        }
    }

}