package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.common.*;

public abstract class BlockModDoubleCrop extends BlockModCrop implements IPlantable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
//    private Random rand;

    public BlockModDoubleCrop() {
        super();
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return null;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(getBaseSeedId());
    }

    public IntegerProperty getAgeProperty() {
        return getMaxAge() == 2 ? AGE : BlockStateProperties.AGE_1;
    }
    public int getMaxAge() {
        return 2;
    }

    public int getAge(BlockState p_185527_1_) {
        return p_185527_1_.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int p_185528_1_) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(p_185528_1_));
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (level.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, level, pos);
                if (ForgeHooks.onCropsGrowPre(level, pos, state, randomSource.nextInt((int)(25.0F / f) + 1) == 0)) {
                    level.setBlock(pos, this.getStateForAge(i + 1), 2);
                    ForgeHooks.onCropsGrowPost(level, pos, state);
                }
            }
        }

    }

    protected static float getGrowthSpeed(Block p_180672_0_, BlockGetter p_180672_1_, BlockPos p_180672_2_) {
        float f = 1.0F;
        BlockPos blockpos = p_180672_2_.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = p_180672_1_.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(p_180672_1_, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable) p_180672_0_)) {
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

    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        state = world.getBlockState(pos.below());
        Block block = state.getBlock();
        return block == this || state.is(BlockTags.DIRT);
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        if (level instanceof Level) {
            if (!this.mayPlaceOn(state, level, pos)) {
                if ((state.getValue(AGE)).intValue() == 2) {
                    this.destroy((Level) level, pos, state);
                } else if ((state.getValue(AGE)).intValue() == 0) {
                    ((Level) level).destroyBlock(pos, true);
                }
                ((Level) level).destroyBlock(pos, false);
            } else {
                if ((state.getValue(AGE)).intValue() == 1 && pos.above().equals(neighbor)) {
                    ((Level) level).setBlock(pos, state.setValue(AGE, Integer.valueOf(0)), 0);
                }
            }
        }
    }


    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos)
    {
        return PlantType.CROP;
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(getMaxAge() == 2 ? AGE : BlockStateProperties.AGE_1);
    }

}
