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
import net.neoforged.neoforge.common.*;

public abstract class BlockModDoubleCrop extends BlockModCrop implements IPlantable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };
//    private Random rand;

    public BlockModDoubleCrop() {
        super();
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0));
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return null;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(getBaseSeedId());
    }

    public IntegerProperty getAgeProperty() {
        return getMaxAge() == 2 ? AGE : BlockStateProperties.AGE_1;
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }

    public int getMaxAge() {
        return 2;
    }

    public int getAge(BlockState p_185527_1_) {
        return p_185527_1_.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (level.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, level, pos);
                if (CommonHooks.onCropsGrowPre(level, pos, state, randomSource.nextInt((int)(25.0F / f) + 1) == 0)) {
                    level.setBlock(pos, this.getStateForAge(i + 1), 2);
                    CommonHooks.onCropsGrowPost(level, pos, state);
                }
            }
        }

    }

    protected static float getGrowthSpeed(Block block, BlockGetter blockGetter, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = blockGetter.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(blockGetter, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (IPlantable) block)) {
                    f1 = 1.0F;
                    if (blockstate.isFertile(blockGetter, pos.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = block == blockGetter.getBlockState(blockpos3).getBlock() || block == blockGetter.getBlockState(blockpos4).getBlock();
        boolean flag1 = block == blockGetter.getBlockState(blockpos1).getBlock() || block == blockGetter.getBlockState(blockpos2).getBlock();
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = block == blockGetter.getBlockState(blockpos3.north()).getBlock() || block == blockGetter.getBlockState(blockpos4.north()).getBlock() || block == blockGetter.getBlockState(blockpos4.south()).getBlock() || block == blockGetter.getBlockState(blockpos3.south()).getBlock();
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }

    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        return (levelReader.getRawBrightness(pos, 0) >= 8 || levelReader.canSeeSky(pos)) && levelReader.getBlockState(pos.below()).is(BlockTags.DIRT);
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
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.CROP;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(getMaxAge() == 2 ? AGE : BlockStateProperties.AGE_1);
    }
}
