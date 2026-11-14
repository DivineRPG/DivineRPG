package divinerpg.blocks.arcana;

import divinerpg.blocks.base.DoubleCrop;
import divinerpg.registries.BlockRegistry;
import divinerpg.utils.Utils;
import net.minecraft.core.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;

public class ArcanaDoubleCrop extends DoubleCrop {
    public ArcanaDoubleCrop(Properties p, ItemLike seed) {super(p, seed);}
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate = level.getBlockState(pos.relative(direction));
            if(blockstate.hasLargeCollisionShape() || level.getFluidState(pos.relative(direction)).is(FluidTags.LAVA)) return false;
        } BlockState belowState = level.getBlockState(pos.below());
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos))
                && ((belowState.getBlock() == BlockRegistry.arcaniteSoil.getLast().get() && Utils.bordersTar(level, pos.getX(), pos.getY() - 1, pos.getZ()))
                || belowState.is(this) && belowState.getValue(AGE) == 14);
    }
}