package naturix.divinerpg.bases.blocks.vethia;

import naturix.divinerpg.bases.blocks.BlockBase;
import naturix.divinerpg.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class Acid extends BlockBase {
	private boolean decays, poison;
	private EntityLivingBase e;
	public Acid(String name, boolean decays, boolean poison) {
        super(Material.SNOW, name);
        this.setTickRandomly(true);
        this.decays = decays;
        this.poison = poison;
    }

	@Override
    public int tickRate(World worldIn) {
        return 160;
    }
	@Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 5);
      if(decays && rand.nextInt(15) == 7) {
    	  world.setBlockState(pos, Blocks.AIR.getDefaultState());
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
        AxisAlignedBB extendBB = new AxisAlignedBB(x -0.1, y -0.1, z -0.1, x + 1.1,y +  0.225,z +  1.1);
        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
        	if (entity instanceof EntityLivingBase) {
                entity.attackEntityFrom(Utils.acidSource, 3);
                if(poison) {
                	entity.addPotionEffect(new PotionEffect(MobEffects.POISON, 150, 1, true, true));
                }
            }
        }
    }
    @Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	 public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	 @Override
	 public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		 return BLOCK_AABB;
	 }
	@Override
    @Deprecated
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return blockState.getBoundingBox(worldIn, pos);
    }

    /**
     * Return an AABB (in world coords!) that should be highlighted when the player is targeting this Block
     */
	@Override
    @Deprecated
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return state.getBoundingBox(worldIn, pos).offset(pos);
    
    }
}