package divinerpg.data;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.densityfunction.generator.NoiseFunction;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunction;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunctions;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;
import java.util.Optional;

public class ModNoiseSettingsProvider {
    public static final ResourceKey<NoiseGeneratorSettings> EDEN_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden"));
    public static final ResourceKey<NoiseGeneratorSettings> WILDWOOD_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "wildwood"));
    public static final ResourceKey<NoiseGeneratorSettings> APALACHIA_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "apalachia"));
    public static final ResourceKey<NoiseGeneratorSettings> SKYTHERN_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "skythern"));
    public static final ResourceKey<NoiseGeneratorSettings> MORTUM_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "mortum"));
    public static final ResourceKey<NoiseGeneratorSettings> ICEIKA_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika"));
    public static final ResourceKey<NoiseGeneratorSettings> ARCANA_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "arcana"));
    public static final ResourceKey<NoiseGeneratorSettings> VETHEA_NOISE = ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea"));

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<Block> blocks = context.lookup(Registries.BLOCK);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        NoiseSettings standardNoise = new NoiseSettings(0, 256);
        NoiseRouter standardRouter = new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), DensityFunctions.zero(), DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -2.6F, 0), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, -2.6F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:end/base_3d_noise")))))), 1, 2));

        registerEdenNoise(context, blocks, densityFunctions, biomes);
        registerWildwoodNoise(context, blocks, densityFunctions);
        registerApalachiaNoise(context, blocks, densityFunctions);
        registerSkythernNoise(context, blocks, densityFunctions);
        registerMortumNoise(context, blocks, densityFunctions);
        registerDimensionNoise(context, blocks, ICEIKA_NOISE, standardNoise, standardRouter, "minecraft:snow_block", "minecraft:dirt", "twilight_stone");
        registerDimensionNoise(context, blocks, VETHEA_NOISE, standardNoise, standardRouter, "minecraft:grass_block", "minecraft:dirt", "twilight_stone");

        registerArcanaNoise(context, blocks, densityFunctions);
    }

    private static void registerEdenNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions, HolderGetter<Biome> biomes) {
        NoiseSettings edenNoise = new NoiseSettings(0, 256);
        DensityFunction terrainMagnetic = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/terrain_magnetic"))));
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction depthFunc = DensityFunctions.add(DensityFunctions.yClampedGradient(0, 255, 1.0F, -1.0F), DensityFunctions.clamp(DensityFunctions.add(terrainMagnetic, DensityFunctions.constant(-0.02F)), 0.0F, 999.0F));
        DensityFunction continentsFunc = DensityFunctions.add(terrainMagnetic, DensityFunctions.constant(0.15F));
        NoiseRouter edenRouter = new NoiseRouter(DensityFunctions.constant(0.6F), zero, continentsFunc, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), depthFunc, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/magnetic_biome_toggle")))), zero, terrainMagnetic);
        ResourceKey<Biome> draviteHillsKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/dravite_hills"));
        ResourceKey<Biome> goldenPeaksKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "eden/golden_peaks"));
        MaterialRule rule1 = MaterialRules.ifTrue(MaterialRules.not(MaterialRules.isBiome(biomes, draviteHillsKey)), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.isBiome(biomes, goldenPeaksKey), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.rayGrass.get().defaultBlockState())), MaterialRules.state(BlockRegistry.rayDirt.get().defaultBlockState()))), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.scorchedDirt.get().defaultBlockState())), MaterialRules.state(BlockRegistry.scorchedDirt.get().defaultBlockState()))));
        MaterialRule rule2 = MaterialRules.ifTrue(MaterialRules.isBiome(biomes, goldenPeaksKey), MaterialRules.state(BlockRegistry.rayStone.get().defaultBlockState()));
        MaterialRule rule3 = MaterialRules.ifTrue(MaterialRules.verticalGradient("draught_bottom", VerticalAnchor.absolute(96), VerticalAnchor.absolute(108)), MaterialRules.state(getBlockState(blocks, "draught_stone")));
        MaterialRule surfaceRule = MaterialRules.sequence(rule1, rule2, rule3);
        BlockState scorchalt = BlockRegistry.scorchalt.get().defaultBlockState();
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(edenNoise, scorchalt, water, edenRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(EDEN_NOISE, settings);
    }

    private static void registerWildwoodNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings wildwoodNoise = new NoiseSettings(0, 256);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation_large"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction finalDensity = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -1.0F, 0.0F), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, -1.0F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise")))))), 1, 2);
        NoiseRouter wildwoodRouter = new NoiseRouter(DensityFunctions.constant(0.6F), vegetation, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "wildwood_grass"))), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "wildwood_dirt"))));
        BlockState twilightStone = getBlockState(blocks, "twilight_stone");
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(wildwoodNoise, twilightStone, water, wildwoodRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(WILDWOOD_NOISE, settings);
    }

    private static void registerApalachiaNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings apalachiaNoise = new NoiseSettings(0, 256);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation_large"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction finalDensity = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -1.0F, 0.0F), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, -1.0F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise")))))), 1, 2);
        NoiseRouter apalachiaRouter = new NoiseRouter(DensityFunctions.constant(0.6F), vegetation, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "apalachia_grass"))), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "apalachia_dirt"))));
        BlockState twilightStone = getBlockState(blocks, "twilight_stone");
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(apalachiaNoise, twilightStone, water, apalachiaRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(APALACHIA_NOISE, settings);
    }

    private static void registerSkythernNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings skythernNoise = new NoiseSettings(0, 256);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation_large"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction base3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise"))));
        DensityFunction nether3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:nether/base_3d_noise"))));
        DensityFunction innerAdd = DensityFunctions.add(DensityFunctions.constant(0.05F), DensityFunctions.mul(DensityFunctions.constant(-0.5F), nether3d));
        DensityFunction finalDensityExpression = DensityFunctions.add(DensityFunctions.yClampedGradient(0, 32, -1.0F, 0.0F), DensityFunctions.add(DensityFunctions.yClampedGradient(200, 256, 0.0F, -1.0F), DensityFunctions.add(innerAdd, base3d)));
        DensityFunction finalDensity = DensityFunctions.interpolated(finalDensityExpression, 1, 2);
        NoiseRouter skythernRouter = new NoiseRouter(DensityFunctions.constant(0.6F), vegetation, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "skythern_grass"))), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "skythern_dirt"))));
        BlockState twilightStone = getBlockState(blocks, "twilight_stone");
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(skythernNoise, twilightStone, water, skythernRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(SKYTHERN_NOISE, settings);
    }

    private static void registerMortumNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings mortumNoise = new NoiseSettings(0, 128);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction temperature = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:temperature"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction nether3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:nether/base_3d_noise"))));
        DensityFunction innerAdd = DensityFunctions.add(DensityFunctions.constant(-2.5F), DensityFunctions.add(DensityFunctions.constant(0.9375F), DensityFunctions.mul(DensityFunctions.yClampedGradient(104, 128, 1.0F, 0.0F), DensityFunctions.add(DensityFunctions.constant(-0.9375F), nether3d))));
        DensityFunction multiplied = DensityFunctions.mul(DensityFunctions.yClampedGradient(-8, 24, 0.0F, 1.0F), innerAdd);
        DensityFunction finalDensityExpression = DensityFunctions.squeeze(DensityFunctions.mul(DensityFunctions.constant(0.64F), DensityFunctions.interpolated(DensityFunctions.blendDensity(DensityFunctions.add(DensityFunctions.constant(2.5F), multiplied)), 1, 1)));
        NoiseRouter mortumRouter = new NoiseRouter(temperature, vegetation, zero, zero, zero, zero, zero, finalDensityExpression);
        MaterialRule bedrockFloor = MaterialRules.ifTrue(MaterialRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(5)), MaterialRules.state(Blocks.BEDROCK.defaultBlockState()));
        MaterialRule bedrockRoof = MaterialRules.ifTrue(MaterialRules.not(MaterialRules.verticalGradient("minecraft:bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.belowTop(0))), MaterialRules.state(Blocks.BEDROCK.defaultBlockState()));
        MaterialRule grassDirtSurface = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(32), 0), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.yStartCheck(VerticalAnchor.absolute(122), 0)), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(getBlockState(blocks, "mortum_grass"))), MaterialRules.state(getBlockState(blocks, "mortum_dirt"))))));
        MaterialRule smolderingTarRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.yBlockCheck(VerticalAnchor.absolute(32), 0)), MaterialRules.ifTrue(MaterialRules.hole(), MaterialRules.state(getBlockState(blocks, "smoldering_tar")))));
        MaterialRule surfaceRule = MaterialRules.sequence(bedrockFloor, bedrockRoof, grassDirtSurface, smolderingTarRule);
        BlockState twilightStone = getBlockState(blocks, "twilight_stone");
        BlockState smolderingTar = getBlockState(blocks, "smoldering_tar");
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(mortumNoise, twilightStone, smolderingTar, mortumRouter, Holder.direct(surfaceRule), List.of(), 32, false, Optional.empty(), true, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(MORTUM_NOISE, settings);
    }

    private static void registerArcanaNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings arcanaNoise = new NoiseSettings(0, 256);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction depthFunc = DensityFunctions.yClampedGradient(0, 256, 0, 1);
        DensityFunction rangeInput = DensityFunctions.yClampedGradient(32, 34, -1, 1);
        DensityFunction addFunc = DensityFunctions.add(DensityFunctions.yClampedGradient(32, 256, 0.7F, -3), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise")))));
        DensityFunction finalDensity = DensityFunctions.interpolated(DensityFunctions.rangeChoice(rangeInput, 0, 1.1F, addFunc, zero), 1, 2);
        NoiseRouter arcanaRouter = new NoiseRouter(constantOne(1.0F), zero, zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), depthFunc, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule ceilingRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.CEILING), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:arcanite_moss", VerticalAnchor.absolute(44), VerticalAnchor.absolute(77)), MaterialRules.state(getBlockState(blocks, "arcanite_moss"))));
        MaterialRule floorRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:arcanite_sand", VerticalAnchor.absolute(76), VerticalAnchor.absolute(82)), MaterialRules.state(getBlockState(blocks, "arcanite_sand"))));
        MaterialRule surfaceRule = MaterialRules.sequence(ceilingRule, floorRule);
        BlockState arcaniteStone = getBlockState(blocks, "arcanite_stone");
        BlockState smolderingTar = getBlockState(blocks, "smoldering_tar");
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(arcanaNoise, arcaniteStone, smolderingTar, arcanaRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(ARCANA_NOISE, settings);
    }

    private static DensityFunction constantOne(float value) {
        return DensityFunctions.constant(value);
    }

    private static void registerDimensionNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, ResourceKey<NoiseGeneratorSettings> key, NoiseSettings noiseSettings, NoiseRouter router, String topPath, String fillerPath, String stonePath) {
        BlockState topBlock = getBlockState(blocks, topPath);
        BlockState fillerBlock = getBlockState(blocks, fillerPath);
        BlockState stoneBlock = getBlockState(blocks, stonePath);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(topBlock)), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(fillerBlock)));
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(noiseSettings, stoneBlock, Blocks.WATER.defaultBlockState(), router, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(key, settings);
    }

    private static BlockState getBlockState(HolderGetter<Block> blocks, String path) {
        Identifier id = path.contains(":") ? Identifier.parse(path) : Identifier.fromNamespaceAndPath(DivineRPG.MODID, path);
        return blocks.getOrThrow(ResourceKey.create(Registries.BLOCK, id)).value().defaultBlockState();
    }
}