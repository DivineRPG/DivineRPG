package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockModGrassBlock;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static divinerpg.registries.BlockRegistry.edenBrush;

public class Scorchgrass extends BlockModGrassBlock {
    public Scorchgrass() {
        super(BlockRegistry.scorchdirt, MapColor.COLOR_YELLOW);
    }
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        pos = pos.above();
        state = level.getBlockState(pos);
        if(!state.is(this) && !state.is(BlockRegistry.scorchdirt) && state.isRandomlyTicking()) state.randomTick(level, pos, random);
    }
    @Override
    public BlockState grass() {
        return edenBrush.get().defaultBlockState();
    }
}
