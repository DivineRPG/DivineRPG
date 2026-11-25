package divinerpg.blocks.twilight;

import divinerpg.blocks.base.Flower;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.effect.MobEffects.ABSORPTION;

public class Lushroom extends Flower {
    public Lushroom(Properties p) {
        super(ABSORPTION, 5, true, p);
    }
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(BlockRegistry.scorchalt.block());
    }
}