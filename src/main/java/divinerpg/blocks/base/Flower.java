package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.tags.BlockTags.SAND;

public class Flower extends FlowerBlock {
    private final boolean canGrowOnSand;
    public Flower(Holder<MobEffect> mobEffects, float seconds, boolean canGrowOnSand, Properties p) {
        super(mobEffects, seconds, p);
        this.canGrowOnSand = canGrowOnSand;
    }
    public Flower(Holder<MobEffect> mobEffects, float seconds, Properties p) {
        this(mobEffects, seconds, false, p);
    }
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return canGrowOnSand ? super.mayPlaceOn(state, level, pos) || state.is(SAND) : super.mayPlaceOn(state, level, pos);
    }
    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 100;}
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {return 60;}
}