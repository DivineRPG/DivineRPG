package net.divinerpg.blocks.iceika;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.divinerpg.api.blocks.BlockModLadder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockXmasLights extends BlockModLadder {

	public BlockXmasLights(String name) {
		super(name);
		setLightLevel(1);
	}
	
	@Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
        return false;
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return world.isSideSolid(x - 1, y, z, EAST ) || world.isSideSolid(x + 1, y, z, WEST ) || world.isSideSolid(x, y, z - 1, SOUTH) || world.isSideSolid(x, y, z + 1, NORTH) || world.getBlock(x - 1, y, z).isLeaves(world, x-1, y, z) || world.getBlock(x + 1, y, z).isLeaves(world, x+1, y, z) || world.getBlock(x, y, z-1).isLeaves(world, x, y, z-1) || world.getBlock(x, y, z+1).isLeaves(world, x, y, z+1);
    }
	

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        int j1 = p_149660_9_;

        if ((p_149660_9_ == 0 || side == 2))
        {
            j1 = 2;
        }

        if ((j1 == 0 || side == 3))
        {
            j1 = 3;
        }

        if ((j1 == 0 || side == 4))
        {
            j1 = 4;
        }

        if ((j1 == 0 || side == 5))
        {
            j1 = 5;
        }

        return j1;
    }

    @Override
    public void onNeighborBlockChange(World w, int x, int y, int z, Block b){}

}
