package divinerpg.world.feature;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.world.feature.config.EllipsoidConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class Ellipsoid implements Feature {

    public static final MapCodec<Ellipsoid> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(EllipsoidConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, Ellipsoid::new));
    private final EllipsoidConfig config;

    public Ellipsoid(EllipsoidConfig config) {
        this.config = config;
    }

    @Override
    public MapCodec<Ellipsoid> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos pos) {
        if (canBeHere(config.replace, random, level.getBlockState(pos), pos)) {
            int xSize = getSize(random, config.minSize, config.maxSize);
            int ySize = getSize(random, config.minSize, config.maxSize);
            int zSize = getSize(random, config.minSize, config.maxSize);

            for (int x = -xSize; x < xSize; x++) {
                for (int y = -ySize; y < ySize; y++) {
                    for (int z = -zSize; z < zSize; z++) {
                        BlockPos p = pos.offset(x, y, z);
                        if ((Math.pow(x, 2) / Math.pow(xSize, 2)) + (Math.pow(y, 2) / Math.pow(ySize, 2)) + (Math.pow(z, 2) / Math.pow(zSize, 2)) < 0.5
                                && canBeHere(config.replace, random, level.getBlockState(p), p)) {
                            level.setBlock(p, config.block.value().getState(level, random, p), 3);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    protected final int getSize(RandomSource random, int minSize, int maxSize) {
        return random.nextInt(minSize, maxSize + 1);
    }

    public final boolean canBeHere(List<RuleTest> replace, RandomSource random, BlockState state, BlockPos pos) {
        if (replace.isEmpty() && defaultReplace(state)) return true;
        for (RuleTest test : replace) {
            if (test.test(state, pos, random)) return true;
        }
        return false;
    }

    public boolean defaultReplace(BlockState state) {
        return state.isAir();
    }
}