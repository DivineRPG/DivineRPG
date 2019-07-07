package naturix.divinerpg.objects.blocks.vethea;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.BlockMod;
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

public class BlockAcid extends BlockMod {
	public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	private boolean decays, poison;
	private EntityLivingBase e;

	public BlockAcid(String name, boolean decays, boolean poison) {
		super(Material.SNOW, name);
		this.setTickRandomly(true);
		this.decays = decays;
		this.poison = poison;
	}

	public void detectInBB(BlockPos pos, World world) {
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		AxisAlignedBB extendBB = new AxisAlignedBB(x - 0.1, y - 0.1, z - 0.1, x + 1.1, y + 0.225, z + 1.1);
		List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
		for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
			if (entity instanceof EntityLivingBase) {
				entity.attackEntityFrom(Utils.acidSource, 3);
				if (poison) {
					entity.addPotionEffect(new PotionEffect(MobEffects.POISON, 150, 1, true, true));
				}
			}
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BLOCK_AABB;
	}

	@Override
	@Deprecated
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return blockState.getBoundingBox(worldIn, pos);
	}

	/**
	 * Return an AABB (in worldgen coords!) that should be highlighted when the
	 * player is targeting this Block
	 */
	@Override
	@Deprecated
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
		return state.getBoundingBox(worldIn, pos).offset(pos);

	}

	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, 5);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public int tickRate(World worldIn) {
		return 160;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		detectInBB(pos, world);
		world.scheduleUpdate(pos, this, 5);
		if (decays && rand.nextInt(15) == 7) {
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
	}
}