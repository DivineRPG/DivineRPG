package divinerpg.world.feature.plant;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.config.DensityFunctionConfig;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunction;
import net.minecraft.world.level.levelgen.densityfunction.DensitySampler;
import net.minecraft.world.level.levelgen.densityfunction.SamplerContext;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.synth.Noise;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class LandVines implements Feature {
    public static final MapCodec<LandVines> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(DensityFunctionConfig.CODEC.fieldOf("config").forGetter(f -> f.config)).apply(instance, LandVines::new));

    private final DensityFunctionConfig config;
    public static final ResourceKey<Biome> MAGNETIC_ISLES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/magnetic_isles"));

    public LandVines(DensityFunctionConfig config) {
        this.config = config;
    }

    @Override
    public MapCodec<? extends Feature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource randomSource, BlockPos blockPos) {
        return place(config, level, chunkGenerator, randomSource, blockPos);
    }

    public boolean place(DensityFunctionConfig c, WorldGenLevel level, ChunkGenerator gen, RandomSource random, BlockPos pos) {
        pos = new BlockPos(pos.getX() & 0xFFFF_FFF0, 0, pos.getZ() & 0xFFFF_FFF0);
        BlockPos.MutableBlockPos m = pos.mutable();
        RandomState randomState = level.getLevel().getChunkSource().randomState();
        DensityFunction df = c.function();
        DensitySampler sampler = randomState.getSampler(df);
        for (int y = level.getMaxY(); y >= level.getMinY(); y--) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    int finalX = pos.getX() | x;
                    int finalZ = pos.getZ() | z;
                    m.set(finalX, y, finalZ);
                    float density = sampler.sampleValue(SamplerContext.EMPTY_UNCACHED, finalX, y, finalZ);
                    if (0 <= density) {
                        setBlock(level, m, BlockRegistry.divineMossStone.get().defaultBlockState());
                        switch ((x + z) & 3) {
                            case 0:
                                setVine(level, m.offset(1, -1, 0));
                                setVine(level, m.offset(2, 0, 0));
                                setVine(level, m.offset(1, 1, 1));
                                break;
                            case 1:
                                setVine(level, m.offset(1, 2, 0));
                                setVine(level, m.offset(2, 1, 0));
                                setVine(level, m.offset(0, 1, 1));
                                break;
                            case 2:
                                setVine(level, m.offset(0, 2, 0));
                                setVine(level, m.offset(-1, 1, 0));
                                setVine(level, m.offset(-1, 0, 1));
                                break;
                            default:
                                setVine(level, m.offset(0, -1, 0));
                                setVine(level, m.offset(-1, 0, 0));
                                setVine(level, m.offset(1, 1, 1));
                                break;
                        }
                    }
                }
            }
        }
        return true;
    }

    static BlockState vine = BlockRegistry.landVineStem.get().defaultBlockState(),
            northVine = BlockRegistry.landVine.get().defaultBlockState().setValue(BlockStateProperties.SOUTH, true),
            southVine = BlockRegistry.landVine.get().defaultBlockState().setValue(BlockStateProperties.NORTH, true),
            eastVine = BlockRegistry.landVine.get().defaultBlockState().setValue(BlockStateProperties.WEST, true),
            westVine = BlockRegistry.landVine.get().defaultBlockState().setValue(BlockStateProperties.EAST, true);

    void setVine(WorldGenLevel level, BlockPos pos) {
        setBlock(level, pos, vine);
        growVine(level, pos.north(), northVine);
        growVine(level, pos.south(), southVine);
        growVine(level, pos.east(), eastVine);
        growVine(level, pos.west(), westVine);
    }

    void growVine(WorldGenLevel level, BlockPos pos, BlockState state) {
        BlockPos.MutableBlockPos m = pos.mutable();
        for (int i = 0, max = 1 + level.getRandom().nextInt(5); i < max && setBlock(level, m, state); i++) {
            m.move(Direction.DOWN);
        }
        setBlock(level, m, state.setValue(BlockStateProperties.BOTTOM, true));
    }

    boolean setBlock(WorldGenLevel level, BlockPos pos, BlockState state) {
        if (level.getBlockState(pos).isAir() && level.getBiome(pos).is(MAGNETIC_ISLES)) {
            level.setBlock(pos, state, 2);
            return true;
        }
        return false;
    }
}