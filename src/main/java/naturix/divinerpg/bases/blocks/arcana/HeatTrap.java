package naturix.divinerpg.bases.blocks.arcana;

import java.util.List;
import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.BlockBase;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.Utils;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HeatTrap extends BlockBase {
	
	private EntityPlayerMP entity;
	private IBlockState state;
	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	    
	public HeatTrap(String name, float hardness) {
        super(Material.ROCK ,name);
        this.setTickRandomly(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
        }
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
	@Override
    public int tickRate(World worldIn) {
        return 30;
    }
 
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 5);
        if(this == ModBlocks.heatTrap)
            world.setBlockState(pos, ModBlocks.heatTrap.getDefaultState()); 
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
        	if (entity instanceof EntityPlayer) {
        		if(this == ModBlocks.heatTrap.getStateFromMeta(1) && entity instanceof EntityPlayerMP) {
                entity.attackEntityFrom(Utils.trapSource, 16);
                entity.setFire(15);
                DivineRPG.logger.info("someone has just activated a heat trap. The blockstate is " + this.getBlockState() + " and the default state is " + this.getDefaultState());
      
        		}}
        }
        if(this == ModBlocks.heatTrap) {
            world.setBlockState(pos, state.withProperty(STAGE, 1));
            DivineRPG.logger.info("someone has just created a heat trap. The blockstate is " + this.getBlockState() + " and the default state is " + this.getDefaultState());
        }
        
}
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(STAGE, Integer.valueOf(0));
    }

    @Override 
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | state.getValue(STAGE);
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }
}