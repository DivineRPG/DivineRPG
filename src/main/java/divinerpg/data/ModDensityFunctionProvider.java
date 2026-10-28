package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunction;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunctions;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModDensityFunctionProvider {
    public static final ResourceKey<DensityFunction> MAGNETIC_STRINGS = ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/magnetic_strings"));
    public static final ResourceKey<DensityFunction> TERRAIN = ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/terrain"));
    public static final ResourceKey<DensityFunction> MAGNETIC_BIOME_TOGGLE = ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/magnetic_biome_toggle"));
    public static final ResourceKey<DensityFunction> TERRAIN_MAGNETIC = ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/terrain_magnetic"));
    public static final ResourceKey<DensityFunction> SHIFT_X = ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "shift_x"));
    public static final ResourceKey<DensityFunction> SHIFT_Z = ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "shift_z"));

    public static void bootstrap(BootstrapContext<DensityFunction> context) {
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);

        DensityFunction magneticFlow = DensityFunctions.noise(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "magnetic_flow"))), 2.0, 2.0);
        DensityFunction magneticStability = DensityFunctions.noise(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "magnetic_stability"))), 1.95, 1.95);
        DensityFunction magneticStrings = DensityFunctions.mul(DensityFunctions.constant(-10.0F), DensityFunctions.add(DensityFunctions.abs(magneticFlow), DensityFunctions.abs(magneticStability)));
        context.register(MAGNETIC_STRINGS, magneticStrings);
        DensityFunction grad1 = DensityFunctions.yClampedGradient(0, 128, -1.0F, 0.0F);
        DensityFunction grad2 = DensityFunctions.yClampedGradient(128, 256, -0.1F, -1.34F);
        DensityFunction grad3 = DensityFunctions.yClampedGradient(112, 128, 0.0F, 0.1F);
        DensityFunction grad4 = DensityFunctions.yClampedGradient(128, 132, 0.0F, -0.1F);
        DensityFunction base3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise"))));
        DensityFunction terrain = DensityFunctions.interpolated(DensityFunctions.add(grad1, DensityFunctions.add(DensityFunctions.add(grad2, DensityFunctions.add(grad3, grad4)), base3d)), 4, 1);
        context.register(TERRAIN, terrain);
        DensityFunction flow05 = DensityFunctions.noise(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "magnetic_flow"))), 0.5, 0.5);
        DensityFunction addedNoise = DensityFunctions.add(DensityFunctions.constant(-0.45F), flow05);
        DensityFunction magneticToggle = DensityFunctions.cache(addedNoise);
        context.register(MAGNETIC_BIOME_TOGGLE, magneticToggle);
        DensityFunction magneticToggleRef = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(MAGNETIC_BIOME_TOGGLE));
        DensityFunction magneticStringsRef = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(MAGNETIC_STRINGS));
        DensityFunction terrainRef = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(TERRAIN));
        DensityFunction rangeInnerAdd = DensityFunctions.add(magneticStringsRef, DensityFunctions.add(DensityFunctions.yClampedGradient(128, 135, 0.0F, 1.0F), DensityFunctions.yClampedGradient(232, 260, 0.0F, -10.0F)));
        DensityFunction rangeWhenInRange = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -1.0F, 0.0F), DensityFunctions.add(base3d, DensityFunctions.clamp(rangeInnerAdd, -1.0F, 1.0F))), 4, 1);
        DensityFunction rangeChoice = DensityFunctions.rangeChoice(magneticToggleRef, 1.0F, 2.0F, rangeWhenInRange, DensityFunctions.constant(-1.0F));
        DensityFunction terrainMagnetic = DensityFunctions.max(terrainRef, rangeChoice);
        context.register(TERRAIN_MAGNETIC, terrainMagnetic);
        var offsetNoise = noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "offset")));
        context.register(SHIFT_X, DensityFunctions.cache(DensityFunctions.cache(DensityFunctions.shiftA(offsetNoise))));
        context.register(SHIFT_Z, DensityFunctions.cache(DensityFunctions.cache(DensityFunctions.shiftB(offsetNoise))));
    }
}