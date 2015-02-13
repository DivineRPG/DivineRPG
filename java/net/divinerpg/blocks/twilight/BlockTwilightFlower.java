package net.divinerpg.blocks.twilight;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockTwilightFlower extends BlockMod {

	private Block grass;
	
	public BlockTwilightFlower(String name, Block grass) {
		super(EnumBlockType.PLANT, name, 0.0F);
		float var4 = 0.2F;
		this.setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
		this.grass = grass;
	}

	@Override
	public boolean canPlaceBlockAt(World w, int x, int y, int z) {
		return w.getBlock(x, y-1, z) == grass;
	}
	
	@Override
    public boolean canBlockStay(World w, int x, int y, int z) {
        return w.getBlock(x, y - 1, z) == grass;
    }
	
	@Override
	public void onNeighborBlockChange(World w, int x, int y, int z, Block b) {
		if(!this.canBlockStay(w, x, y, z)){
			w.setBlockToAir(x, y, z);
			this.dropBlockAsItem(w, x, y, z, new ItemStack(this));
		}
	}
	
	@Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        return null;
    }
    
    @Override
    public int getRenderType() {
    	return 1;
    }
}