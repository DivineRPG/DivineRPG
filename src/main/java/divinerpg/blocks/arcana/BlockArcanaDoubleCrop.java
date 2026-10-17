package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockModDoubleCrop;
import divinerpg.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.BlockRegistry.arcaniteGrass;

public class BlockArcanaDoubleCrop extends BlockModDoubleCrop {
    public BlockArcanaDoubleCrop(Properties properties, ItemLike seed) {
        super(properties, seed);
    }
    public BlockArcanaDoubleCrop(Properties properties) {
        super(properties);
    }
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = level.getBlockState(pos.relative(direction));
            if (blockstate.hasLargeCollisionShape() || level.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) return false;
        }
        BlockState belowState = level.getBlockState(pos.below());
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos)) && ((belowState.getBlock() == arcaniteGrass.get() && Utils.bordersTar(level, pos.getX(), pos.getY() - 1, pos.getZ())) || belowState.is(this) && belowState.getValue(AGE) == 14);
    }
}