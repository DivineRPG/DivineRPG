package naturix.divinerpg.objects.blocks.vanilla;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VanillaBlock extends BlockMod {

	private Random rand = new Random();

	public VanillaBlock(EnumBlockType type, String name, float hardness, int harvest) {
		super(type, name, hardness);
		setHarvestLevel("pickaxe", harvest);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			int j1 = 0;

			if (this == ModBlocks.bloodgemOre) {
				j1 = MathHelper.getInt(rand, 0, 4);
			}
			return j1;
		}
		return 0;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (state.getBlock() == ModBlocks.netheriteOre) {
			entity.attackEntityFrom(DamageSource.IN_FIRE, 1.0F);
		}
	}

	protected static final AxisAlignedBB NETHERITE_ORE_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D,
            0.9375D);
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
            List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, NETHERITE_ORE_AABB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return NETHERITE_ORE_AABB;
    }

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0
		        && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
			int j = random.nextInt(fortune + 2) - 1;

			if (j < 0) {
				j = 0;
			}

			return this.quantityDropped(random) * (j + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
}