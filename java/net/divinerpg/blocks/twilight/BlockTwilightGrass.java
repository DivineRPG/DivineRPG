package net.divinerpg.blocks.twilight;

import java.util.ArrayList;
import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockTwilightGrass extends BlockMod implements IShearable {

	private Block grass;
	
	public BlockTwilightGrass(String name, Block grass) {
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
    
    @Override
    public Item getItemDropped(int par1, Random rand, int par3) {
    	return null;
    }
    
    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1));
        return ret;
    }

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}
}