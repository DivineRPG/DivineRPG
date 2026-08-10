package divinerpg.world.feature.plant;

import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import static divinerpg.registries.BlockRegistry.duncap;
import static net.minecraft.core.Direction.Plane.HORIZONTAL;
import static net.minecraft.world.level.block.HorizontalDirectionalBlock.FACING;

public class Duncap extends Feature<NoneFeatureConfiguration> {
    public Duncap() {super(NoneFeatureConfiguration.CODEC);}
    @Override public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        return place(null, context.level(), null, context.random(), context.origin());
    }
    @Override public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
        if(level.getBlockState(pos).isAir()) {
            BlockState s = duncap.get().defaultBlockState();
            for(Direction d : HORIZONTAL) {
                BlockPos p = pos.relative(d);
                if(level.getBlockState(p).isFaceSturdy(level, p, d.getOpposite())) {
                    setBlock(level, pos, s.setValue(FACING, d.getOpposite()));
                    return true;
                }
            }
        } return false;
    }
}