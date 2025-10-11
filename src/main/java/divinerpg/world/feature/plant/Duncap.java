package divinerpg.world.feature.plant;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import static net.minecraft.core.Direction.Plane.HORIZONTAL;

public class Duncap extends Feature<NoneFeatureConfiguration> {
    public Duncap() {super(NoneFeatureConfiguration.CODEC);}
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        return place(null, context.level(), null, context.random(), context.origin());
    }
    @Override
    public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
        if(level.getBlockState(pos).isAir()) {
            BlockState s = BlockRegistry.duncap.get().defaultBlockState();
            for(Direction d : HORIZONTAL) {
                BlockPos p = pos.relative(d);
                if(level.getBlockState(p).isFaceSturdy(level, p, d.getOpposite())) {
                    setBlock(level, pos, s.setValue(HorizontalDirectionalBlock.FACING, d.getOpposite()));
                    return true;
                }
            }
        } return false;
    }
}
