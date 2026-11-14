package divinerpg.blocks.twilight;

import divinerpg.blocks.base.ModGrassBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class Scorchgrass extends ModGrassBlock {
    public Scorchgrass(Properties p, Supplier<Block> dirt, Supplier<Block> grass, boolean requiresLightToGrow) {
        super(p, dirt, grass, requiresLightToGrow);
    }
    @Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        pos = pos.above();
        state = level.getBlockState(pos);
        if(!state.is(this) && !state.is(dirtSupplier.get()) && state.isRandomlyTicking()) state.randomTick(level, pos, random);
    }
}