package naturix.divinerpg.bases.blocks.arcana;

import java.util.List;
import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.BlockBase;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HeatTrap extends BlockBase {
	public HeatTrap(String name) {
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
        if (this == ModBlocks.heatTrapOn) {
        	world.setBlockState(pos, ModBlocks.heatTrap.getDefaultState());
        }
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
        	if (entity instanceof EntityLivingBase && this == ModBlocks.heatTrapOn) {
                entity.attackEntityFrom(DamageSource.GENERIC, 1);
                entity.setFire(15);
            }
        	if(entity instanceof EntityLivingBase && this == ModBlocks.heatTrap) {
                world.setBlockState(pos, ModBlocks.heatTrapOn.getDefaultState());
            }
        }
    }
}