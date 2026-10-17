package divinerpg.world.density_function;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Interval;
import net.minecraft.world.level.levelgen.densityfunction.*;

public record Heaviside(DensityFunction argument) implements DensityFunction {
    public static final MapCodec<Heaviside> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(DensityFunction.CODEC.fieldOf("argument").forGetter(Heaviside::argument)).apply(instance, Heaviside::new));

    @Override
    public DensitySampler compileSampler(CompileContext context) {
        DensitySampler argSampler = argument.compileSampler(context);
        return new DensitySampler() {
            @Override
            public void sampleVolume(SamplerContext samplerContext, DensityBuffer outputBuffer, DensityVolume volume) {
                DensitySampler.sampleVolumeNaive(samplerContext, outputBuffer, volume, this);
            }

            @Override
            public float sampleValue(SamplerContext samplerContext, int x, int y, int z) {
                return argSampler.sampleValue(samplerContext, x, y, z) > 0 ? 1.0f : 0.0f;
            }
        };
    }

    @Override
    public DensityFunction rewriteChildren(DfRewriteRule rule) {
        return new Heaviside(rule.rewrite(argument));
    }

    @Override
    public Interval range() {
        return Interval.of(0.0F, 1.0F);
    }

    @Override
    public @Axes int domainAxes() {
        return argument.domainAxes();
    }

    @Override
    public MapCodec<? extends DensityFunction> codec() {
        return CODEC;
    }
}