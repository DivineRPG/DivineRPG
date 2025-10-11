package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockModFlower;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.effect.MobEffects.ABSORPTION;
import static net.minecraft.world.level.material.MapColor.TERRACOTTA_ORANGE;

public class Lushroom extends BlockModFlower {
    public Lushroom() {
        super(ABSORPTION, 5, TERRACOTTA_ORANGE, true);
    }
    @Override protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(BlockRegistry.scorchalt);
    }
}