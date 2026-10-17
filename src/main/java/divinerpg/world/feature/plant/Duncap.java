package divinerpg.world.feature.plant;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;

import static divinerpg.registries.BlockRegistry.duncap;
import static net.minecraft.core.Direction.Plane.HORIZONTAL;
import static net.minecraft.world.level.block.HorizontalDirectionalBlock.FACING;

public class Duncap implements Feature {
    public static final MapCodec<Duncap> CODEC = MapCodec.unit(Duncap::new);

    @Override
    public MapCodec<Duncap> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
        if(level.getBlockState(pos).isAir()) {
            BlockState s = duncap.get().defaultBlockState();
            for(Direction d : HORIZONTAL) {
                BlockPos p = pos.relative(d);
                if(level.getBlockState(p).isFaceSturdy(level, p, d.getOpposite())) {
                    setBlock(level, pos, s.setValue(FACING, d.getOpposite()));
                    return true;
                }
            }
        }
        return false;
    }
}