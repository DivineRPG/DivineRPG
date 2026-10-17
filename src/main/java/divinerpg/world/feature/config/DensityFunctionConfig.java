package divinerpg.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunction;

public record DensityFunctionConfig(DensityFunction function) {
    public static final Codec<DensityFunctionConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(DensityFunction.CODEC.fieldOf("argument").forGetter(DensityFunctionConfig::function)).apply(instance, DensityFunctionConfig::new));
}