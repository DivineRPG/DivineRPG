package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class Spike extends BlockBase {
	public Spike(String name) {
		super(Material.ROCK, name);
		this.setHardness(2);
        setTickRandomly(true);
	} 

	@Override
    public int tickRate(World worldIn) {
        return 30;
    }
 
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 5);
      
    }
 
    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 5);
    }

    public void detectInBB (BlockPos pos, World world){
        double x = (double)pos.getX();
        double y = (double)pos.getY();
        double z = (double)pos.getZ();
        AxisAlignedBB extendBB = new AxisAlignedBB(x -0.1, y -0.1, z -0.1, x + 1.1,y +  1.1,z +  1.1);
        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
        	if (entity instanceof EntityLivingBase && this == ModBlocks.spikeHot) {
                entity.attackEntityFrom(Utils.spikeSource, 8);
                entity.setFire(15);
            }
        	if(entity instanceof EntityLivingBase && this == ModBlocks.spikeCold) {
        		entity.attackEntityFrom(Utils.spikeSource, 5);  
            }
        }
    }
}