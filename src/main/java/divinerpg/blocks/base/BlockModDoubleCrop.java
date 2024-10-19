package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.CommonHooks;

public class BlockModDoubleCrop extends SugarCaneBlock {
//    private final ResourceLocation seed;
    public BlockModDoubleCrop() {
        super(Properties.ofFullCopy(Blocks.WHEAT));
//        this.seed = seed;
    }
    public BlockModDoubleCrop(int lightLevel) {
        super(Properties.ofFullCopy(Blocks.WHEAT).lightLevel((state) -> lightLevel));
//        this.seed = seed;
    }
    @Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(level.isEmptyBlock(pos.above())) {
            int i;
            for(i = 1; level.getBlockState(pos.below(i)).is(this); ++i) {}
            if(i < 3) {
                int j = state.getValue(AGE);
                if(CommonHooks.canCropGrow(level, pos, state, true)) {
                    if(j == 15) {
                        level.setBlockAndUpdate(pos.above(), defaultBlockState());
                        CommonHooks.fireCropGrowPost(level, pos.above(), defaultBlockState());
                        level.setBlock(pos, state.setValue(AGE, 14), 2);
                    } else level.setBlock(pos, state.setValue(AGE, j + 1), 4);
                }
            }
        }
    }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = level.getBlockState(pos.relative(direction));
            if(blockstate.hasLargeCollisionShape() || level.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) return false;
        } BlockState belowState = level.getBlockState(pos.below());
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos)) && (belowState.is(BlockTags.DIRT) || belowState.is(this) && belowState.getValue(AGE) == 14);
    }
//    @Override public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {return new ItemStack(BuiltInRegistries.ITEM.get(seed));}
//    @Override public net.minecraftforge.common.PlantType getPlantType(BlockGetter world, BlockPos pos) {return net.minecraftforge.common.PlantType.CROP;}
}