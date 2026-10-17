package divinerpg.world.feature.ore;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public record OreVeinFeature(float cutoffChance, float straightness, float branchingChance, List<TargetBlockState> targetStates) implements Feature {

    public static final MapCodec<OreVeinFeature> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Codec.floatRange(0.0F, 1.0F).fieldOf("cutoff_chance").forGetter(OreVeinFeature::cutoffChance), Codec.floatRange(0.0F, 1.0F).fieldOf("straightness").forGetter(OreVeinFeature::straightness), Codec.floatRange(0.0F, 1.0F).fieldOf("branching_chance").forGetter(OreVeinFeature::branchingChance), TargetBlockState.CODEC.listOf().fieldOf("target_states").forGetter(OreVeinFeature::targetStates)).apply(instance, OreVeinFeature::new));

    @Override
    public MapCodec<OreVeinFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        return true;
    }

    public record TargetBlockState(RuleTest target, BlockState state, float chance, float discardChanceOnAirExposure) {
        public static final Codec<TargetBlockState> CODEC = RecordCodecBuilder.create(instance -> instance.group(RuleTest.CODEC.fieldOf("target").forGetter(TargetBlockState::target), BlockState.CODEC.fieldOf("state").forGetter(TargetBlockState::state), Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter(TargetBlockState::chance), Codec.floatRange(0.0F, 1.0F).fieldOf("discard_chance_on_air_exposure").forGetter(TargetBlockState::discardChanceOnAirExposure)).apply(instance, TargetBlockState::new));
    }
}