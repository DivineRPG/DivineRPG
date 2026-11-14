package divinerpg.blocks.twilight;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class Scorchdirt extends Block {
    public Scorchdirt(Properties properties) {
        super(properties);
    }
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        pos = pos.above();
        state = level.getBlockState(pos);
        if(!state.is(this) && !state.is(BlockRegistry.scorchsoil.getLast()) && state.isRandomlyTicking()) state.randomTick(level, pos, random);
    }
}