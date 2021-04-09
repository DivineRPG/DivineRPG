package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.*;

import java.util.*;

public abstract class BlockModDoubleCrop extends BlockModCrop implements IPlantable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
    private Random rand;

    public BlockModDoubleCrop(String name) {
        super(name);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));

        this.rand = new Random();
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return null;
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(getBaseSeedId());
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }
    public int getMaxAge() {
        return 2;
    }

    protected int getAge(BlockState p_185527_1_) {
        return p_185527_1_.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int p_185528_1_) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(p_185528_1_));
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }

    public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
        if (!p_225542_2_.isAreaLoaded(p_225542_3_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (p_225542_2_.getRawBrightness(p_225542_3_, 0) >= 9) {
            int i = this.getAge(p_225542_1_);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, p_225542_2_, p_225542_3_);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_225542_2_, p_225542_3_, p_225542_1_, p_225542_4_.nextInt((int)(25.0F / f) + 1) == 0)) {
                    p_225542_2_.setBlock(p_225542_3_, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_225542_2_, p_225542_3_, p_225542_1_);
                }
            }
        }

    }

    protected static float getGrowthSpeed(Block p_180672_0_, IBlockReader p_180672_1_, BlockPos p_180672_2_) {
        float f = 1.0F;
        BlockPos blockpos = p_180672_2_.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = p_180672_1_.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(p_180672_1_, blockpos.offset(i, 0, j), net.minecraft.util.Direction.UP, (net.minecraftforge.common.IPlantable) p_180672_0_)) {
                    f1 = 1.0F;
                    if (blockstate.isFertile(p_180672_1_, p_180672_2_.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = p_180672_2_.north();
        BlockPos blockpos2 = p_180672_2_.south();
        BlockPos blockpos3 = p_180672_2_.west();
        BlockPos blockpos4 = p_180672_2_.east();
        boolean flag = p_180672_0_ == p_180672_1_.getBlockState(blockpos3).getBlock() || p_180672_0_ == p_180672_1_.getBlockState(blockpos4).getBlock();
        boolean flag1 = p_180672_0_ == p_180672_1_.getBlockState(blockpos1).getBlock() || p_180672_0_ == p_180672_1_.getBlockState(blockpos2).getBlock();
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = p_180672_0_ == p_180672_1_.getBlockState(blockpos3.north()).getBlock() || p_180672_0_ == p_180672_1_.getBlockState(blockpos4.north()).getBlock() || p_180672_0_ == p_180672_1_.getBlockState(blockpos4.south()).getBlock() || p_180672_0_ == p_180672_1_.getBlockState(blockpos3.south()).getBlock();
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader world, BlockPos pos) {
        state = world.getBlockState(pos.below());
        Block block = state.getBlock();
        return block == this || state.getMaterial() == Material.GRASS;
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean p_220069_6_) {
        if (!this.mayPlaceOn(state, worldIn, pos)) {
            if (((Integer) state.getValue(AGE)).intValue() == 2) {
                this.destroy(worldIn, pos, state);
            } else if (((Integer) state.getValue(AGE)).intValue() == 0) {
                worldIn.destroyBlock(pos, true);
            }
            worldIn.destroyBlock(pos, false);
        } else {
            if (((Integer) state.getValue(AGE)).intValue() == 1 && pos.above().equals(fromPos)) {
                worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 0);
            }
        }
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos)
    {
        return PlantType.CROP;
    }
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(AGE);
    }

}
