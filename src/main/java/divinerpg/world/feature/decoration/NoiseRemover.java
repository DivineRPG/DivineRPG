package divinerpg.world.feature.decoration;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.*;

public class NoiseRemover extends Feature<NoneFeatureConfiguration> {
    public NoiseRemover() {super(NoneFeatureConfiguration.CODEC);}
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        return place(null, context.level(), null, null, context.origin());
    }
    @Override
    public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator gen, RandomSource random, BlockPos pos) {
        pos = new BlockPos(pos.getX() & 0xFFFF_FFF0, 0, pos.getZ() & 0xFFFF_FFF0);
        BlockPos.MutableBlockPos m = pos.mutable();
        ArrayList<BlockPos> toClear = new ArrayList<>();
        BlockState state;
        for(int y = level.getMaxBuildHeight(); y >= level.getMinBuildHeight(); y--) for(int x = 0; x < 16; x++) for(int z = 0; z < 16; z++) if(!(state = level.getBlockState(m.set(pos.getX() | x, y, pos.getZ() | z))).isAir() && !state.is(BlockRegistry.landVine)) {
            int count = 0;
            List<BlockPos> positions = List.of(
                m.offset(0, 1, 1),
                m.offset(1, 1, 0), m.offset(0, 1, 0), m.offset(-1, 1, 0),
                m.offset(0, 1, -1),
                m.offset(1, 0, 1), m.offset(0, 0, 1), m.offset(-1, 0, 1),
                m.offset(1, 0, 0), m.offset(-1, 0, 0),
                m.offset(1, 0, -1), m.offset(0, 0, -1), m.offset(-1, 0, -1),
                m.offset(0, -1, 1),
                m.offset(1, -1, 0), m.offset(0, -1, 0), m.offset(-1, -1, 0),
                m.offset(0, -1, -1)
            );
            for(BlockPos p : positions) if(!level.getBlockState(p).isAir()) count++;
            if(count < 3) toClear.add(m.immutable());
        } toClear.forEach(p -> level.setBlock(p, Blocks.AIR.defaultBlockState(), 2));
        return true;
    }
}