package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.DIRT;

public class Scorchdirt extends BlockMod {
    public Scorchdirt() {
        super(Properties.ofFullCopy(DIRT).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.ROOTED_DIRT).randomTicks());
    }
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        pos = pos.above();
        state = level.getBlockState(pos);
        if(!state.is(this) && !state.is(BlockRegistry.scorchgrass) && state.isRandomlyTicking()) state.randomTick(level, pos, random);
    }
}