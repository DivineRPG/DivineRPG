package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoiseParametersProvider {
    public static final ResourceKey<NormalNoise> MAGNETIC_FLOW = ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "magnetic_flow"));
    public static final ResourceKey<NormalNoise> MAGNETIC_STABILITY = ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "magnetic_stability"));
    public static final ResourceKey<NormalNoise> OFFSET = ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "offset"));
    public static final ResourceKey<NormalNoise> STREAMS = ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "streams"));

    public static void bootstrap(BootstrapContext<NormalNoise> context) {
        context.register(MAGNETIC_FLOW, NormalNoise.createParity(-8, 2.0, 0.0, 0.0, 0.0));
        context.register(MAGNETIC_STABILITY, NormalNoise.createParity(-7, 2.0));
        context.register(OFFSET, NormalNoise.createParity(-3, 1.0, 1.0, 1.0, 0.0));
        context.register(STREAMS, NormalNoise.createParity(-6, 1.0));
    }
}