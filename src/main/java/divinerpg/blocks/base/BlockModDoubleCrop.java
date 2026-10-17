package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.CommonHooks;

import static net.minecraft.tags.BlockTags.DIRT;
import static net.neoforged.neoforge.common.Tags.Fluids.LAVA;

public class BlockModDoubleCrop extends SugarCaneBlock {
    private final ItemLike seed;

    public BlockModDoubleCrop(Properties properties, ItemLike seed) {
        super(properties);
        this.seed = seed;
    }

    public BlockModDoubleCrop(Properties properties) {
        this(properties, null);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isEmptyBlock(pos.above())) {
            int i;
            for (i = 1; level.getBlockState(pos.below(i)).is(this); ++i) {}
            if (i < 3) {
                int j = state.getValue(AGE);
                if (CommonHooks.canCropGrow(level, pos, state, true)) {
                    if (j == 15) {
                        level.setBlockAndUpdate(pos.above(), defaultBlockState());
                        CommonHooks.fireCropGrowPost(level, pos.above(), defaultBlockState());
                        level.setBlock(pos, state.setValue(AGE, 14), 2);
                    } else level.setBlock(pos, state.setValue(AGE, j + 1), 4);
                }
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = level.getBlockState(pos.relative(direction));
            if (blockstate.hasLargeCollisionShape() || level.getFluidState(pos.relative(direction)).is(LAVA)) return false;
        }
        BlockState belowState = level.getBlockState(pos.below());
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos)) && (belowState.is(DIRT) || belowState.is(this) && belowState.getValue(AGE) == 14);
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(seed != null ? seed : this);
    }
}