package divinerpg.world.feature.structurelike;

import divinerpg.registries.*;
import divinerpg.world.feature.config.EllipsoidConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class KobblinHill extends Feature<NoneFeatureConfiguration> {
    public KobblinHill() {super(NoneFeatureConfiguration.CODEC);}
    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        return place(null, context.level(), null, context.random(), context.origin());
    }
    @Override
    public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
        pos = pos.offset(0, -1, 0);
        FeatureRegistry.ELLIPSOID.get().place(new EllipsoidConfig(BlockStateProvider.simple(Blocks.COARSE_DIRT), 2, 3, List.of(new BlockMatchTest(Blocks.AIR), new BlockMatchTest(Blocks.GRASS_BLOCK))), level, g, random, pos);
        setBlock(level, pos, BlockRegistry.kobblinBurrow.get().defaultBlockState());
        return true;
    }
}