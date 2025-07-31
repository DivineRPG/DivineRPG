package divinerpg.world.density_function;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;

public record Heaviside(DensityFunction argument) implements DensityFunction {
    public static final MapCodec<Heaviside> DATA_CODEC = DensityFunction.HOLDER_HELPER_CODEC.fieldOf("argument").xmap(Heaviside::new, Heaviside::argument);
    static final KeyDispatchDataCodec<Heaviside> CODEC = KeyDispatchDataCodec.of(DATA_CODEC);
    @Override
    public double compute(FunctionContext c) {
        return argument.compute(c) > 0 ? 1 : 0;
    }
    @Override
    public void fillArray(double[] doubles, ContextProvider contextProvider) {
        for(int i = 0; i < doubles.length; i++) doubles[i] = doubles[i] > 0 ? 1 : 0;
    }
    @Override
    public DensityFunction mapAll(Visitor visitor) {
        return new Heaviside(argument.mapAll(visitor));
    }
    @Override
    public double minValue() {
        return 0;
    }
    @Override
    public double maxValue() {
        return 1;
    }
    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return CODEC;
    }
}