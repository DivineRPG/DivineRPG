package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class ModNoiseSettingsProvider {
    public static final ResourceKey<NoiseGeneratorSettings> APALACHIA_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia"));

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        DensityFunction apalachiaDensity = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -2.6, 0.1), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0, -0.7), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:end/base_3d_noise")))))));

        NoiseRouter apalachiaRouter = new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.constant(0.6), DensityFunctions.shiftedNoise2d(new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))), 0.25, noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation_large")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise")))), apalachiaDensity, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
        SurfaceRules.RuleSource apalachiaSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), SurfaceRules.state(blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia_grass"))).value().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), SurfaceRules.state(blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia_dirt"))).value().defaultBlockState())));
        NoiseSettings apalachiaNoise = new NoiseSettings(0, 256, 1, 2);
        NoiseGeneratorSettings apalachiaSettings = new NoiseGeneratorSettings(apalachiaNoise, blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "twilight_stone"))).value().defaultBlockState(), Blocks.WATER.defaultBlockState(), apalachiaRouter, apalachiaSurface, List.of(), 0, false, false, false, false);

        context.register(APALACHIA_NOISE, apalachiaSettings);
    }
}