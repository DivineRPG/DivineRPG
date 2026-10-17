package divinerpg.world.feature.structurelike;

import com.mojang.serialization.MapCodec;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.Ellipsoid;
import divinerpg.world.feature.config.EllipsoidConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class KobblinHill implements Feature {
    public static final MapCodec<KobblinHill> CODEC = MapCodec.unit(KobblinHill::new);

    @Override
    public MapCodec<KobblinHill> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
        pos = pos.offset(0, -1, 0);
        Ellipsoid ellipsoid = new Ellipsoid(new EllipsoidConfig(Holder.direct(BlockStateProvider.of(Blocks.COARSE_DIRT)), 2, 3, List.of(new BlockMatchTest(Blocks.AIR), new BlockMatchTest(Blocks.GRASS_BLOCK))));
        ellipsoid.place(level, g, random, pos);
        setBlock(level, pos, BlockRegistry.kobblinBurrow.get().defaultBlockState());
        return true;
    }
}