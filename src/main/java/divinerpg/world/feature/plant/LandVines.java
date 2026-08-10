package divinerpg.world.feature.plant;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import divinerpg.world.feature.config.DensityFunctionConfig;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.*;

public class LandVines extends Feature<DensityFunctionConfig> {
    public static final ResourceKey<Biome> MAGNETIC_ISLES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/magnetic_isles"));
    public LandVines() {super(DensityFunctionConfig.CODEC);}
    @Override
    public boolean place(FeaturePlaceContext<DensityFunctionConfig> context) {
        return place(context.config(), context.level(), null, null, context.origin());
    }
    @Override
    public boolean place(DensityFunctionConfig c, WorldGenLevel level, ChunkGenerator gen, RandomSource random, BlockPos pos) {
        pos = new BlockPos(pos.getX() & 0xFFFF_FFF0, 0, pos.getZ() & 0xFFFF_FFF0);
        BlockPos.MutableBlockPos m = pos.mutable();
        DensityFunction df = getWorkingDensityFunction(level.getLevel().getChunkSource().randomState(), c.function());
        for(int y = level.getMaxY(); y >= level.getMinY(); y--) for(int x = 0; x < 16; x++) for(int z = 0; z < 16; z++) if(0 <= df.compute(new DensityFunction.SinglePointContext(pos.getX() | x, y, pos.getZ() | z))) {
            setBlock(level, m.set(pos.getX() | x, y, pos.getZ() | z), BlockRegistry.divineMossStone.get().defaultBlockState());
            switch((x + z) & 3) {
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
        } return true;
    }
    public static DensityFunction getWorkingDensityFunction(RandomState random, DensityFunction f) {
        return f.mapAll(new DensityFunction.Visitor() {
            private final Map<DensityFunction, DensityFunction> wrapped = new HashMap<>();
            public DensityFunction apply(DensityFunction fc) {
                return wrapped.computeIfAbsent(fc, function -> function instanceof DensityFunctions.HolderHolder(Holder<DensityFunction> function1) ? function1.value() : (function instanceof DensityFunctions.MarkerOrMarked marker ? marker.wrapped() : function));
            }
            @Override
            public DensityFunction.NoiseHolder visitNoise(DensityFunction.NoiseHolder noiseHolder) {
                Holder<NormalNoise.NoiseParameters> holder = noiseHolder.noiseData();
                NormalNoise normalnoise = random.getOrCreateNoise(holder.unwrapKey().orElseThrow());
                return new DensityFunction.NoiseHolder(holder, normalnoise);
            }
        });
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
        for(int i = 0, max = 1 + level.getRandom().nextInt(5); i < max && setBlock(level, m, state); i++) m.move(Direction.DOWN);
        setBlock(level, m, state.setValue(BlockStateProperties.BOTTOM, true));
    }
    boolean setBlock(WorldGenLevel level, BlockPos pos, BlockState state) {
        if(level.getBlockState(pos).isAir() && level.getBiome(pos).is(MAGNETIC_ISLES)) {
            level.setBlock(pos, state, 2);
            return true;
        } return false;
    }

}