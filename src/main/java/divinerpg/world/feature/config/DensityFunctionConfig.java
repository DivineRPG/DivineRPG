package divinerpg.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record DensityFunctionConfig(DensityFunction function) implements FeatureConfiguration {
    public static final Codec<DensityFunctionConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(DensityFunction.HOLDER_HELPER_CODEC.fieldOf("argument").forGetter(DensityFunctionConfig::function)).apply(instance, DensityFunctionConfig::new));
}