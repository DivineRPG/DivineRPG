package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.BlockBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockElevantium extends BlockBase {

	public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F,
	        0.9375F);

	public BlockElevantium(String name) {
		super(Material.IRON, name, DRPGCreativeTabs.BlocksTab);
		setResistance(20);
		this.setHardness(3);
	}

	public boolean canEntitySpawn(Entity entityIn) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BLOCK_AABB;
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
	public void neighborChanged(IBlockState state, World w, BlockPos pos, Block blockIn, BlockPos fromPos) {
		dropBlockAsItem(w, pos, this.getDefaultState(), 1);
		w.setBlockToAir(pos);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity) {
		entity.motionY += 0.75;
		entity.fallDistance = 0;
		if (entity instanceof EntityPlayer) {
			// ((EntityPlayer) entity).triggerAchievement(DivineRPGAchievements.skyHigh);
		}
	}

}
