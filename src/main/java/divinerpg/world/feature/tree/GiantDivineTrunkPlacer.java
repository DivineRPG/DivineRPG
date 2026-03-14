package divinerpg.world.feature.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.TrunkPlacerRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class GiantDivineTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<GiantDivineTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, GiantDivineTrunkPlacer::new));

    public GiantDivineTrunkPlacer(int baseHeight, int randA, int randB) {
        super(baseHeight, randA, randB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TrunkPlacerRegistry.GIANT_DIVINE_TRUNK.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> setter, RandomSource random, int height, BlockPos start, TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> foliage = new ArrayList<>();
        BlockPos soilPos = start.below();
        if (!level.isStateAtPosition(soilPos, s -> s.is(BlockTags.DIRT) || s.is(Blocks.GRASS_BLOCK))) {
            return foliage;
        }
        int baseRadius = 4;
        float spiralStrength = 1.2f;
        float spiralSpeed = 0.18f;
        for (int y = 0; y < height; y++) {
            float progress = (float) y / height;
            int radius = Math.max(1, (int)(baseRadius * Math.pow(1 - progress, 0.6)));
            int offsetX = (int)(Math.sin(y * spiralSpeed) * spiralStrength);
            int offsetZ = (int)(Math.cos(y * spiralSpeed) * spiralStrength);
            BlockPos center = start.offset(offsetX, y, offsetZ);
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + z * z <= radius * radius + random.nextInt(2)) {
                        BlockPos pos = center.offset(x, 0, z);
                        placeLog(level, setter, random, pos, config);
                    }
                }
            }
            if (y > height * 0.55 && random.nextFloat() < 0.12f) {
                generateBranch(level, setter, random, center, config);
            }
        }
        foliage.add(new FoliagePlacer.FoliageAttachment(start.above(height), 4, false));
        generateRoots(level, setter, random, start, config);
        return foliage;
    }

    private void generateRoots(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> setter, RandomSource random, BlockPos start, TreeConfiguration config) {
        int rootCount = 4 + random.nextInt(3);
        for (int i = 0; i < rootCount; i++) {
            double angle = (2 * Math.PI / rootCount) * i + random.nextDouble() * 0.5;
            int length = 3 + random.nextInt(3);
            for (int j = 0; j < length; j++) {
                int x = (int) Math.round(Math.cos(angle) * j);
                int z = (int) Math.round(Math.sin(angle) * j);
                BlockPos pos = start.offset(x, -j, z);
                if (level.isStateAtPosition(pos, s -> s.isAir() || s.is(Blocks.GRASS_BLOCK) || s.is(Blocks.DIRT))) {
                    placeLog(level, setter, random, pos, config);
                }
            }
        }
    }

    private void generateBranch(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> setter, RandomSource random, BlockPos start, TreeConfiguration config) {
        Direction dir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        int length = 8 + random.nextInt(6);
        int radius = 2;
        BlockPos pos = start;
        for (int i = 0; i < length; i++) {
            pos = pos.relative(dir).above(random.nextInt(2));
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x * x + z * z <= radius * radius) {
                        placeLog(level, setter, random, pos.offset(x, 0, z), config);
                    }
                }
            }
            if (i > length * 0.6)
                radius = 1;
        }
        generateLeafCluster(level, setter, random, pos, config);
    }

    private void generateLeafCluster(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> setter, RandomSource random, BlockPos center, TreeConfiguration config) {
        int radius = 4;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x*x + y*y + z*z <= radius * radius + random.nextInt(3)) {
                        BlockPos pos = center.offset(x, y, z);
                        setter.accept(pos, config.foliageProvider.getState(random, pos));
                    }
                }
            }
        }
    }
}