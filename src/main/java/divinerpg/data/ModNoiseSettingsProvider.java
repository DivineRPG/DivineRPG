package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunction;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunctions;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;

import java.util.List;
import java.util.Optional;

public class ModNoiseSettingsProvider {
    public static final ResourceKey<NoiseGeneratorSettings> APALACHIA_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia"));

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);

        DensityFunction apalachiaDensity = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -2.6F, 0.1F), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, -0.7F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:end/base_3d_noise")))))), 1, 2);

        NoiseRouter apalachiaRouter = new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), DensityFunctions.zero(), apalachiaDensity);

        MaterialRule apalachiaSurfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia_grass"))).value().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia_dirt"))).value().defaultBlockState())));

        NoiseSettings apalachiaNoise = new NoiseSettings(0, 256);

        NoiseGeneratorSettings apalachiaSettings = new NoiseGeneratorSettings(apalachiaNoise, blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "twilight_stone"))).value().defaultBlockState(), Blocks.WATER.defaultBlockState(), apalachiaRouter, Holder.direct(apalachiaSurfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);

        context.register(APALACHIA_NOISE, apalachiaSettings);
    }
}