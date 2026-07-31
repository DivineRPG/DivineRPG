package divinerpg.world.config.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.FoliagePlacerRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Supplier;

public class GiantDivineFoliagePlacer extends FoliagePlacer {

    public static final MapCodec<GiantDivineFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> foliagePlacerParts(instance).apply(instance, GiantDivineFoliagePlacer::new));
    private static Supplier<FoliagePlacerType<GiantDivineFoliagePlacer>> TYPE_SUPPLIER;
    public GiantDivineFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    public static void init(Supplier<FoliagePlacerType<GiantDivineFoliagePlacer>> typeSupplier) {
        TYPE_SUPPLIER = typeSupplier;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return TYPE_SUPPLIER.get();
    }

    @Override
    protected void createFoliage(WorldGenLevel level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int foliageOffset) {
        BlockPos center = attachment.pos();
        int maxRadius = foliageRadius + 7;
        int aboveHeight = 3;
        int belowHeight = 7;
        for (int y = -belowHeight; y <= aboveHeight; y++) {
            float progress;
            if (y >= 0)
                progress = 1f - (y / (float) aboveHeight);
            else
                progress = 1f - (Math.abs(y) / (float) belowHeight);
            int layerRadius = Math.max(1, (int) (maxRadius * progress));
            for (int x = -layerRadius; x <= layerRadius; x++) {
                for (int z = -layerRadius; z <= layerRadius; z++) {
                    double dist = x * x + z * z;
                    if (dist <= layerRadius * layerRadius + random.nextInt(2)) {
                        BlockPos pos = center.offset(x, y, z);
                        boolean underside = y < -1;
                        boolean innerCanopy = dist < layerRadius * layerRadius * 0.45;
                        if (underside && innerCanopy && random.nextFloat() < 0.035f) {
                            if (TreeFeature.validTreePos(level, pos)) {
                                foliageSetter.set(pos, Blocks.SHROOMLIGHT.defaultBlockState());
                                if (random.nextFloat() < 0.35f) {
                                    BlockPos up = pos.above();
                                    if (TreeFeature.validTreePos(level, up))
                                        foliageSetter.set(up, Blocks.SHROOMLIGHT.defaultBlockState());
                                }
                            }
                        } else {
                            if (random.nextFloat() > 0.07f)
                                tryPlaceLeaf(level, foliageSetter, random, config, pos);
                        }
                        if (y < 0 && dist > layerRadius * layerRadius * 0.8) {
                            if (random.nextFloat() < 0.35f) {
                                int length = 2 + random.nextInt(6);
                                for (int i = 1; i <= length; i++) {
                                    BlockPos down = pos.below(i);
                                    if (!level.isStateAtPosition(down, s -> s.isAir()))
                                        break;
                                    tryPlaceLeaf(level, foliageSetter, random, config, down);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected static boolean tryPlaceLeaf(WorldGenLevel level, FoliageSetter setter, RandomSource random, TreeConfiguration config, BlockPos pos) {
        if (!TreeFeature.validTreePos(level, pos))
            return false;
        BlockState state = config.foliageProvider.getState(level, random, pos).setValue(LeavesBlock.PERSISTENT, true).setValue(LeavesBlock.DISTANCE, 1);
        if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
            state = state.setValue(BlockStateProperties.WATERLOGGED, level.isFluidAtPosition(pos, f -> f.isSourceOfType(Fluids.WATER)));
        }
        setter.set(pos, state);
        return true;
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return 5;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean giantTrunk) {
        return false;
    }
}