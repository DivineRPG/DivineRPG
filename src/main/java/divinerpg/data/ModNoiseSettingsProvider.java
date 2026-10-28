package divinerpg.data;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.FluidRegistry;
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

        registerEdenNoise(context, blocks, densityFunctions, biomes);
        registerWildwoodNoise(context, blocks, densityFunctions);
        registerApalachiaNoise(context, blocks, densityFunctions);
        registerSkythernNoise(context, blocks, densityFunctions);
        registerMortumNoise(context, blocks, densityFunctions);

        registerIceikaNoise(context, blocks, densityFunctions, biomes);
        registerVetheaNoise(context, blocks, densityFunctions, biomes);
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
        MaterialRule rule3 = MaterialRules.ifTrue(MaterialRules.verticalGradient("draught_bottom", VerticalAnchor.absolute(96), VerticalAnchor.absolute(108)), MaterialRules.state(BlockRegistry.draughtStone.get().defaultBlockState()));
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
        DensityFunction finalDensity = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -1.0F, 0.0F), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, -1.0F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise")))))), 4, 1);
        NoiseRouter wildwoodRouter = new NoiseRouter(DensityFunctions.constant(0.6F), vegetation, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.wildwoodGrass.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.wildwoodDirt.get().defaultBlockState())));
        BlockState twilightStone = BlockRegistry.twilightStone.get().defaultBlockState();
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(wildwoodNoise, twilightStone, water, wildwoodRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(WILDWOOD_NOISE, settings);
    }

    private static void registerApalachiaNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings apalachiaNoise = new NoiseSettings(0, 256);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation_large"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction finalDensity = DensityFunctions.interpolated(DensityFunctions.add(DensityFunctions.yClampedGradient(0, 128, -2.6F,  0.1F), DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, -1.1F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:end/base_3d_noise")))))), 4, 8);
        NoiseRouter apalachiaRouter = new NoiseRouter(DensityFunctions.constant(0.6F), vegetation, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.apalachiaGrass.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.apalachiaDirt.get().defaultBlockState())));
        BlockState twilightStone = BlockRegistry.twilightStone.get().defaultBlockState();
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
        DensityFunction finalDensity = DensityFunctions.interpolated(finalDensityExpression, 4, 1);
        NoiseRouter skythernRouter = new NoiseRouter(DensityFunctions.constant(0.6F), vegetation, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth")))), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule surfaceRule = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.skythernGrass.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.skythernDirt.get().defaultBlockState())));
        BlockState twilightStone = BlockRegistry.twilightStone.get().defaultBlockState();
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
        DensityFunction finalDensityExpression = DensityFunctions.squeeze(DensityFunctions.mul(DensityFunctions.constant(0.64F), DensityFunctions.interpolated(DensityFunctions.blendDensity(DensityFunctions.add(DensityFunctions.constant(2.5F), multiplied)), 4, 1)));
        NoiseRouter mortumRouter = new NoiseRouter(temperature, vegetation, zero, zero, zero, zero, zero, finalDensityExpression);
        MaterialRule bedrockFloor = MaterialRules.ifTrue(MaterialRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(5)), MaterialRules.state(Blocks.BEDROCK.defaultBlockState()));
        MaterialRule bedrockRoof = MaterialRules.ifTrue(MaterialRules.not(MaterialRules.verticalGradient("minecraft:bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.belowTop(0))), MaterialRules.state(Blocks.BEDROCK.defaultBlockState()));
        MaterialRule grassDirtSurface = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(32), 0), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.yStartCheck(VerticalAnchor.absolute(122), 0)), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.mortumGrass.get().defaultBlockState())), MaterialRules.state(BlockRegistry.mortumDirt.get().defaultBlockState())))));
        MaterialRule smolderingTarRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.yBlockCheck(VerticalAnchor.absolute(32), 0)), MaterialRules.ifTrue(MaterialRules.hole(), MaterialRules.state(FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState()))));
        MaterialRule surfaceRule = MaterialRules.sequence(bedrockFloor, bedrockRoof, grassDirtSurface, smolderingTarRule);
        BlockState twilightStone = BlockRegistry.twilightStone.get().defaultBlockState();
        BlockState smolderingTar = FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(mortumNoise, twilightStone, smolderingTar, mortumRouter, Holder.direct(surfaceRule), List.of(), 32, false, Optional.empty(), true, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(MORTUM_NOISE, settings);
    }

    private static void registerIceikaNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions, HolderGetter<Biome> biomes) {
        NoiseSettings iceikaNoise = new NoiseSettings(-64, 384);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction shiftX = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "shift_x"))));
        DensityFunction shiftZ = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "shift_z"))));
        DensityFunction temperature = DensityFunctions.add(DensityFunctions.constant(-1.0F), new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:temperature"))), 0.25, 0.0, shiftX, zero, shiftZ));
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation"))), 0.25, 0.0, shiftX, zero, shiftZ);
        DensityFunction continentalnessShifted = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:continentalness"))), 0.25, 0.0, shiftX, zero, shiftZ);
        DensityFunction continents = DensityFunctions.mul(DensityFunctions.constant(1.12F), DensityFunctions.add(DensityFunctions.yClampedGradient(-64, 320, 0.0F, 0.51F), DensityFunctions.cache(continentalnessShifted)));
        DensityFunction erosionShifted = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:erosion"))), 0.25, 0.0, shiftX, zero, shiftZ);
        DensityFunction erosion = DensityFunctions.cache(erosionShifted);
        DensityFunction overworldOffset = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/offset"))));
        DensityFunction depth = DensityFunctions.add(DensityFunctions.yClampedGradient(-64, 258, 2.1F, -2.0F), overworldOffset);
        DensityFunction ridgeShifted = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:ridge"))), 0.25, 0.0, shiftX, zero, shiftZ);
        DensityFunction ridges = DensityFunctions.cache(ridgeShifted);
        DensityFunction overworldDepth = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/depth"))));
        DensityFunction overworldFactor = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/factor"))));
        DensityFunction slopedCheese = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/sloped_cheese"))));
        DensityFunction caveEntrances = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/caves/entrances"))));
        DensityFunction caveLayer = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:cave_layer"))), 1.0, 8.0, zero, zero, zero);
        DensityFunction caveCheese = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:cave_cheese"))), 1.0, 0.6666666666666666, zero, zero, zero);
        DensityFunction spaghetti2d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/caves/spaghetti_2d"))));
        DensityFunction spaghettiRoughness = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/caves/spaghetti_roughness_function"))));
        DensityFunction cavePillars = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/caves/pillars"))));
        DensityFunction noodleCaves = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/caves/noodle"))));
        DensityFunction inRangeVal = DensityFunctions.min(slopedCheese, DensityFunctions.mul(DensityFunctions.constant(5.0F), caveEntrances));
        DensityFunction outOfRangeVal1 = DensityFunctions.min(DensityFunctions.min(DensityFunctions.add(DensityFunctions.mul(DensityFunctions.constant(4.0F), DensityFunctions.square(caveLayer)), DensityFunctions.add(DensityFunctions.clamp(DensityFunctions.add(DensityFunctions.constant(0.27F), caveCheese), -1.0F, 1.0F), DensityFunctions.clamp(DensityFunctions.add(DensityFunctions.constant(1.5F), DensityFunctions.mul(DensityFunctions.constant(-0.64F), slopedCheese)), 0.0F, 0.5F))), caveEntrances), DensityFunctions.add(spaghetti2d, spaghettiRoughness));
        DensityFunction outOfRangeVal2 = DensityFunctions.rangeChoice(cavePillars, -1000000.0F, 0.03F, DensityFunctions.constant(-1000000.0F), cavePillars);
        DensityFunction outOfRangeFinal = DensityFunctions.max(outOfRangeVal1, outOfRangeVal2);
        DensityFunction rangeChoice = DensityFunctions.rangeChoice(slopedCheese, -1000000.0F, 1.5625F, inRangeVal, outOfRangeFinal);
        DensityFunction mainAdd = DensityFunctions.add(DensityFunctions.constant(0.118F), DensityFunctions.mul(DensityFunctions.yClampedGradient(-64, -40, 0.0F, 1.0F), DensityFunctions.add(DensityFunctions.constant(-0.1171875F), DensityFunctions.add(DensityFunctions.constant(-0.078125F), DensityFunctions.mul(DensityFunctions.yClampedGradient(240, 256, 1.0F, 0.0F), DensityFunctions.add(DensityFunctions.constant(0.078125F), rangeChoice))))));
        DensityFunction finalDensity = DensityFunctions.min(DensityFunctions.squeeze(DensityFunctions.mul(DensityFunctions.constant(0.64F), DensityFunctions.interpolated(DensityFunctions.blendDensity(mainAdd), 4, 1))), noodleCaves);
        NoiseRouter iceikaRouter = new NoiseRouter(temperature, vegetation, continents, erosion, depth, ridges, zero, finalDensity);
        ResourceKey<Biome> glowingDeepKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/glowing_deep"));
        ResourceKey<Biome> frozenMenagerieKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/frozen_menagerie"));
        ResourceKey<Biome> morgueMarshKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/morgue_marsh"));
        ResourceKey<Biome> iceSpikesKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/ice_spikes"));
        ResourceKey<Biome> borealisSteepsKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/borealis_steeps"));
        ResourceKey<Biome> frozenOceanKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/frozen_ocean"));
        ResourceKey<Biome> deepFrozenOceanKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/deep_frozen_ocean"));
        ResourceKey<Biome> snowyPeaksKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/snowy_peaks"));
        ResourceKey<Biome> chillPassageKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/chill_passage"));
        ResourceKey<Biome> fractalForestKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/fractal_forest"));
        ResourceKey<Biome> frozenPeaksKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/frozen_peaks"));
        ResourceKey<Biome> geyserPlateauKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "iceika/geyser_plateau"));
        MaterialRule bedrockRule = MaterialRules.ifTrue(MaterialRules.verticalGradient("minecraft:bedrock_floor", VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(5)), MaterialRules.state(Blocks.BEDROCK.defaultBlockState()));
        MaterialRule geliditeRule = MaterialRules.ifTrue(MaterialRules.isBiome(biomes, glowingDeepKey), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:gelidite", VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), MaterialRules.state(BlockRegistry.gelidite.get().defaultBlockState())));
        MaterialRule packedIceBaseRule = MaterialRules.ifTrue(MaterialRules.isBiome(biomes, frozenMenagerieKey), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:packed_ice", VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)), MaterialRules.state(Blocks.PACKED_ICE.defaultBlockState())));
        MaterialRule surfaceMainSeq = MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.isBiome(biomes, morgueMarshKey), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "streams")), 0.0, 0.1), MaterialRules.state(Blocks.WATER.defaultBlockState()))), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:frozen_stone_bottom", VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)), MaterialRules.state(BlockRegistry.frozenStone.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:cobbled_frozen_stone", VerticalAnchor.absolute(16), VerticalAnchor.absolute(48)), MaterialRules.state(BlockRegistry.cobbledFrozenStone.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.waterBlockCheck(0, 0), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.isBiome(biomes, iceSpikesKey, borealisSteepsKey, frozenOceanKey, deepFrozenOceanKey), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.verticalGradient("divinerpg:packed_ice", VerticalAnchor.absolute(64), VerticalAnchor.absolute(245))), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.isBiome(biomes, borealisSteepsKey), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.verticalGradient("divinerpg:borealis_stone", VerticalAnchor.absolute(128), VerticalAnchor.absolute(255))), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:borealis_cobble", VerticalAnchor.absolute(128), VerticalAnchor.absolute(245)), MaterialRules.state(BlockRegistry.cobbledFrozenStone.get().defaultBlockState())), MaterialRules.state(BlockRegistry.frozenStone.get().defaultBlockState())))), MaterialRules.state(Blocks.PACKED_ICE.defaultBlockState())))), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, iceSpikesKey, snowyPeaksKey, chillPassageKey, fractalForestKey), MaterialRules.state(Blocks.SNOW_BLOCK.defaultBlockState())), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, frozenPeaksKey, frozenMenagerieKey), MaterialRules.state(Blocks.PACKED_ICE.defaultBlockState())), MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(32), 0), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.isBiome(biomes, frozenOceanKey, deepFrozenOceanKey), MaterialRules.state(BlockRegistry.frozenGravel.get().defaultBlockState())), MaterialRules.state(BlockRegistry.frozenGrass.get().defaultBlockState()))), MaterialRules.state(Blocks.PACKED_ICE.defaultBlockState())))), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, geyserPlateauKey, borealisSteepsKey, frozenOceanKey, deepFrozenOceanKey), MaterialRules.ifTrue(MaterialRules.waterBlockCheck(0, 0), MaterialRules.state(BlockRegistry.cobbledFrozenStone.get().defaultBlockState()))), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, frozenPeaksKey), MaterialRules.ifTrue(MaterialRules.waterBlockCheck(0, 0), MaterialRules.state(Blocks.PACKED_ICE.defaultBlockState()))), MaterialRules.ifTrue(MaterialRules.not(MaterialRules.waterBlockCheck(0, 0)), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:gravel")), 0.2, 1.0), MaterialRules.state(BlockRegistry.frozenGravel.get().defaultBlockState()))), MaterialRules.state(BlockRegistry.frozenDirt.get().defaultBlockState()));
        MaterialRule mainFloorRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), surfaceMainSeq);
        MaterialRule surfaceRule = MaterialRules.sequence(bedrockRule, geliditeRule, packedIceBaseRule, mainFloorRule);
        BlockState frozenStone = BlockRegistry.frozenStone.get().defaultBlockState();
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(iceikaNoise, frozenStone, water, iceikaRouter, Holder.direct(surfaceRule), List.of(), 63, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(ICEIKA_NOISE, settings);
    }

    private static void registerArcanaNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions) {
        NoiseSettings arcanaNoise = new NoiseSettings(0, 256);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction depthFunc = DensityFunctions.yClampedGradient(0, 256, 0, 1);
        DensityFunction rangeInput = DensityFunctions.yClampedGradient(32, 34, -1, 1);
        DensityFunction addFunc = DensityFunctions.add(DensityFunctions.yClampedGradient(32, 256, 0.7F, -3), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise")))));
        DensityFunction finalDensity = DensityFunctions.interpolated(DensityFunctions.rangeChoice(rangeInput, 0, 1.1F, addFunc, zero), 4, 1);
        NoiseRouter arcanaRouter = new NoiseRouter(constantOne(1.0F), zero, zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), depthFunc, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), zero, finalDensity);
        MaterialRule ceilingRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.CEILING), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:arcanite_moss", VerticalAnchor.absolute(44), VerticalAnchor.absolute(77)), MaterialRules.state(BlockRegistry.arcaniteMoss.get().defaultBlockState())));
        MaterialRule floorRule = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:arcanite_sand", VerticalAnchor.absolute(76), VerticalAnchor.absolute(82)), MaterialRules.state(BlockRegistry.arcaniteSand.get().defaultBlockState())));
        MaterialRule surfaceRule = MaterialRules.sequence(ceilingRule, floorRule);
        BlockState arcaniteStone = BlockRegistry.arcaniteStone.get().defaultBlockState();
        BlockState smolderingTar = FluidRegistry.SMOLDERING_TAR_BLOCK.get().defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(arcanaNoise, arcaniteStone, smolderingTar, arcanaRouter, Holder.direct(surfaceRule), List.of(), 0, false, Optional.empty(), false, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(ARCANA_NOISE, settings);
    }

    private static void registerVetheaNoise(BootstrapContext<NoiseGeneratorSettings> context, HolderGetter<Block> blocks, HolderGetter<DensityFunction> densityFunctions, HolderGetter<Biome> biomes) {
        NoiseSettings vetheaNoise = new NoiseSettings(-64, 384);
        HolderGetter<NormalNoise> noises = context.lookup(Registries.NOISE);
        DensityFunction zero = DensityFunctions.zero();
        DensityFunction temperature = DensityFunctions.yClampedGradient(-64, 310, 1.0F, -1.0F);
        DensityFunction vegetation = new NoiseFunction(noises.getOrThrow(ResourceKey.create(Registries.NOISE, Identifier.parse("minecraft:vegetation"))), 0.25, 0.0, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_x")))), zero, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:shift_z")))));
        DensityFunction continents = DensityFunctions.add(DensityFunctions.yClampedGradient(-64, 310, 1.0F, -0.3F), new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/continents")))));
        DensityFunction depth = DensityFunctions.yClampedGradient(-64, 310, 1.0F, -1.0F);
        DensityFunction initialDensity = DensityFunctions.yClampedGradient(-64, -50, 1.0F, 0.0F);
        DensityFunction nether3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:nether/base_3d_noise"))));
        DensityFunction overworld3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/base_3d_noise"))));
        DensityFunction end3d = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:end/base_3d_noise"))));
        DensityFunction term1 = DensityFunctions.squeeze(DensityFunctions.mul(DensityFunctions.constant(0.64F), DensityFunctions.blendDensity(DensityFunctions.add(DensityFunctions.constant(2.47F), DensityFunctions.mul(DensityFunctions.yClampedGradient(-70, -46, 0.0F, 1.0F), DensityFunctions.add(DensityFunctions.constant(-1.53F), DensityFunctions.mul(DensityFunctions.yClampedGradient(40, 64, 1.0F, 0.0F), DensityFunctions.add(DensityFunctions.constant(-0.92F), nether3d))))))));
        DensityFunction term2_part1 = DensityFunctions.add(DensityFunctions.yClampedGradient(54, 64, 0.0F, -0.3F), DensityFunctions.mul(DensityFunctions.yClampedGradient(54, 72, 0.0F, 1.0F), DensityFunctions.add(DensityFunctions.yClampedGradient(54, 128, 0.4F, -0.4F), overworld3d)));
        DensityFunction term2_part2_inner = DensityFunctions.add(DensityFunctions.add(DensityFunctions.yClampedGradient(200, 280, 0.0F, -2.0F), DensityFunctions.add(DensityFunctions.yClampedGradient(243, 300, 0.0F, 2.0F), DensityFunctions.yClampedGradient(285, 310, 0.0F, -2.0F))), end3d);
        DensityFunction term2_part2 = DensityFunctions.add(DensityFunctions.yClampedGradient(128, 256, 0.0F, 1.2F), DensityFunctions.mul(DensityFunctions.yClampedGradient(128, 256, 0.0F, 1.1F), term2_part2_inner));
        DensityFunction finalDensityExpression = DensityFunctions.interpolated(DensityFunctions.add(term1, DensityFunctions.add(term2_part1, term2_part2)), 4, 1);
        NoiseRouter vetheaRouter = new NoiseRouter(temperature, vegetation, continents, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/erosion")))), depth, new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(ResourceKey.create(Registries.DENSITY_FUNCTION, Identifier.parse("minecraft:overworld/ridges")))), initialDensity, finalDensityExpression);
        ResourceKey<Biome> scorchedTopsKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea/scorched_tops"));
        ResourceKey<Biome> hyrelandsKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea/hyrelands"));
        ResourceKey<Biome> dreamGroundsKey = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea/dream_grounds"));
        MaterialRule ruleNonScorchedTops = MaterialRules.ifTrue(MaterialRules.not(MaterialRules.isBiome(biomes, scorchedTopsKey)), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.isBiome(biomes, hyrelandsKey), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.evergrass.get().defaultBlockState()))), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, dreamGroundsKey), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.dreamGrass.get().defaultBlockState()))), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.flameGrass.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(1, true, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.dreamDirt.get().defaultBlockState()))));
        MaterialRule ruleScorchedTops = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), MaterialRules.state(BlockRegistry.scorchedGrass.get().defaultBlockState()));
        MaterialRule bedrockFloor = MaterialRules.ifTrue(MaterialRules.verticalGradient("divinerpg:everstone_floor", VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(5)), MaterialRules.state(BlockRegistry.darkEverstone.get().defaultBlockState()));
        MaterialRule surfaceRule = MaterialRules.sequence(ruleNonScorchedTops, ruleScorchedTops, bedrockFloor);
        BlockState dreamStone = BlockRegistry.dreamStone.get().defaultBlockState();
        BlockState water = Blocks.WATER.defaultBlockState();
        NoiseGeneratorSettings settings = new NoiseGeneratorSettings(vetheaNoise, dreamStone, water, vetheaRouter, Holder.direct(surfaceRule), List.of(), -64, false, Optional.empty(), true, NoiseGeneratorSettings.DebugFunctions.EMPTY);
        context.register(VETHEA_NOISE, settings);
    }

    private static DensityFunction constantOne(float value) {
        return DensityFunctions.constant(value);
    }

}