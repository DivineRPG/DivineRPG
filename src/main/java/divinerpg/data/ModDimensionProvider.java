package divinerpg.data;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;

import static divinerpg.DivineRPG.MODID;

public class ModDimensionProvider {
    public static final ResourceKey<LevelStem> APALACHIA_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "apalachia"));
    public static final ResourceKey<LevelStem> EDEN_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "eden"));
    public static final ResourceKey<LevelStem> WILDWOOD_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "wildwood"));
    public static final ResourceKey<LevelStem> SKYTHERN_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "skythern"));
    public static final ResourceKey<LevelStem> MORTUM_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "mortum"));
    public static final ResourceKey<LevelStem> ICEIKA_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "iceika"));
    public static final ResourceKey<LevelStem> ARCANA_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "arcana"));
    public static final ResourceKey<LevelStem> VETHEA_KEY = ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(MODID, "vethea"));

    public static void bootstrap(BootstrapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        Holder<DimensionType> edenDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.EDEN);
        Holder<DimensionType> wildwoodDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.WILDWOOD);
        Holder<DimensionType> apalachiaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.APALACHIA);
        Holder<DimensionType> skythernDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.SKYTHERN);
        Holder<DimensionType> mortumDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.MORTUM);
        Holder<DimensionType> iceikaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.ICEIKA);
        Holder<DimensionType> arcanaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.ARCANA);
        Holder<DimensionType> vetheaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.VETHEA);

        Holder<NoiseGeneratorSettings> edenNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "eden")));
        MultiNoiseBiomeSource edenBiomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(Climate.parameters(Climate.Parameter.point(0.6F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(-1.0F, 0.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/plains")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.6F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.5F), Climate.Parameter.point(-1.0F), Climate.Parameter.span(-1.0F, 0.0F), Climate.Parameter.point(-0.7F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/dravite_hills")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.6F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.5F), Climate.Parameter.point(-1.0F), Climate.Parameter.span(-1.0F, 0.0F), Climate.Parameter.point(0.8F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/dravite_caves")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.6F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(0.01F, 1.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/magnetic_isles")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.6F), Climate.Parameter.point(1.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(-1.0F, 0.0F), Climate.Parameter.point(0.0F), 0.25F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/forest")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.6F), Climate.Parameter.point(1.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(-1.0F, -0.2F), Climate.Parameter.point(-0.7F), 0.1F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/golden_peaks"))))
        )));
        NoiseBasedChunkGenerator edenNoiseGenerator = new NoiseBasedChunkGenerator(edenBiomeSource, edenNoise);
        context.register(EDEN_KEY, new LevelStem(edenDimension, edenNoiseGenerator));

        Holder<NoiseGeneratorSettings> wildwoodNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "wildwood")));
        Holder<Biome> wildwoodBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "wildwood")));
        NoiseBasedChunkGenerator wildwoodNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(wildwoodBiome), wildwoodNoise);
        context.register(WILDWOOD_KEY, new LevelStem(wildwoodDimension, wildwoodNoiseGenerator));

        Holder<NoiseGeneratorSettings> apalachiaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "apalachia")));
        Holder<Biome> apalachiaBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "apalachia")));
        NoiseBasedChunkGenerator apalachiaNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(apalachiaBiome), apalachiaNoise);
        context.register(APALACHIA_KEY, new LevelStem(apalachiaDimension, apalachiaNoiseGenerator));

        Holder<NoiseGeneratorSettings> skythernNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "skythern")));
        Holder<Biome> skythernBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "skythern")));
        NoiseBasedChunkGenerator skythernNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(skythernBiome), skythernNoise);
        context.register(SKYTHERN_KEY, new LevelStem(skythernDimension, skythernNoiseGenerator));

        Holder<NoiseGeneratorSettings> mortumNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "mortum")));
        Holder<Biome> mortumBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "mortum")));
        NoiseBasedChunkGenerator mortumNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(mortumBiome), mortumNoise);
        context.register(MORTUM_KEY, new LevelStem(mortumDimension, mortumNoiseGenerator));

        Holder<NoiseGeneratorSettings> iceikaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "iceika")));
        MultiNoiseBiomeSource iceikaBiomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, -1.625F), Climate.Parameter.span(-1.0F, -0.75F), Climate.Parameter.span(0.05F, 1.0F), Climate.Parameter.span(-1.0F, -0.5F), Climate.Parameter.span(-0.365F, 0.125F), Climate.Parameter.point(-0.7F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/frozen_peaks")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.5F, -1.12F), Climate.Parameter.span(-0.625F, 0.25F), Climate.Parameter.span(0.02F, 1.0F), Climate.Parameter.span(0.1F, 0.75F), Climate.Parameter.span(-0.4F, 0.5F), Climate.Parameter.point(-0.75F), 0.16F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/chill_passage")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.25F, -0.5F), Climate.Parameter.span(0.1F, 0.6F), Climate.Parameter.span(0.11F, 1.0F), Climate.Parameter.span(-0.6F, -0.06F), Climate.Parameter.span(0.7F, 1.0F), Climate.Parameter.point(-0.75F), 0.23F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/borealis_steeps")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.5F, 0.0F), Climate.Parameter.span(-0.625F, -0.25F), Climate.Parameter.span(0.1F, 1.0F), Climate.Parameter.span(0.6F, 1.0F), Climate.Parameter.span(-1.0F, -0.5F), Climate.Parameter.point(-0.7F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/snowy_peaks")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, -1.625F), Climate.Parameter.span(0.5F, 0.75F), Climate.Parameter.span(0.3F, 0.9F), Climate.Parameter.span(-0.625F, -0.5F), Climate.Parameter.span(0.0F, 0.375F), Climate.Parameter.point(-0.4F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/fractal_forest")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.8F, -0.5F), Climate.Parameter.span(0.0F, 0.5F), Climate.Parameter.span(0.35F, 1.0F), Climate.Parameter.span(-0.625F, 0.3F), Climate.Parameter.span(-0.5F, 0.125F), Climate.Parameter.point(-0.137F), 0.32F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/shiverspine_forest")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.375F, -0.125F), Climate.Parameter.span(-1.0F, -0.75F), Climate.Parameter.span(0.125F, 0.365F), Climate.Parameter.span(-1.0F, 0.0F), Climate.Parameter.point(1.0F), Climate.Parameter.point(-0.4F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/geyser_plateau")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.4F, 0.0F), Climate.Parameter.span(0.6F, 1.0F), Climate.Parameter.span(0.6F, 1.0F), Climate.Parameter.span(0.5F, 1.0F), Climate.Parameter.span(0.4F, 1.0F), Climate.Parameter.point(-0.3F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/cozybark_forest")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, -1.75F), Climate.Parameter.span(0.4F, 0.75F), Climate.Parameter.span(0.1F, 0.9F), Climate.Parameter.span(-0.75F, -0.4F), Climate.Parameter.span(0.5F, 0.75F), Climate.Parameter.span(-0.3F, 0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/fractal_forest")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.75F, -1.5F), Climate.Parameter.span(-0.75F, -0.25F), Climate.Parameter.span(0.2F, 0.5F), Climate.Parameter.span(-1.0F, -0.75F), Climate.Parameter.span(-0.75F, 0.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/ice_spikes")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(-1.9F), Climate.Parameter.point(-0.4F), Climate.Parameter.point(1.0F), Climate.Parameter.point(-0.1F), Climate.Parameter.point(0.3F), Climate.Parameter.point(0.0F), 0.3F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/ice_spikes")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.375F, -1.15F), Climate.Parameter.span(-0.125F, 0.2F), Climate.Parameter.span(0.05F, 0.08F), Climate.Parameter.span(0.25F, 0.625F), Climate.Parameter.span(0.125F, 0.4F), Climate.Parameter.point(0.0F), 0.222F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/snow_bog")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.25F, -0.75F), Climate.Parameter.span(-0.8F, -0.375F), Climate.Parameter.span(0.35F, 1.0F), Climate.Parameter.span(-0.25F, 0.32F), Climate.Parameter.span(-1.0F, -0.25F), Climate.Parameter.span(-0.1F, -0.02F), 0.222F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/tundra")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.5F, -0.375F), Climate.Parameter.span(0.125F, 0.25F), Climate.Parameter.point(0.1F), Climate.Parameter.span(0.5F, 0.875F), Climate.Parameter.span(-0.375F, 0.5F), Climate.Parameter.point(0.0F), 0.222F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/morgue_marsh")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(-0.25F), Climate.Parameter.point(-1.0F), Climate.Parameter.span(0.125F, 0.365F), Climate.Parameter.span(-1.0F, -0.1F), Climate.Parameter.point(1.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/geyser_plateau")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.36F, 0.0F), Climate.Parameter.span(0.6F, 1.0F), Climate.Parameter.span(0.3F, 1.0F), Climate.Parameter.span(0.5F, 1.0F), Climate.Parameter.span(0.4F, 1.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/cozybark_forest")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, -1.5F), Climate.Parameter.span(-1.0F, -0.6F), Climate.Parameter.span(-1.0F, -0.6F), Climate.Parameter.span(0.0F, 1.0F), Climate.Parameter.span(0.0F, 1.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/ice_sheet")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, 0.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-0.8F, -0.52F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.point(0.0F), 0.255F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/frozen_ocean")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, 0.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-1.0F, -0.75F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.point(0.0F), 0.24F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/deep_frozen_ocean")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.75F, -0.5F), Climate.Parameter.span(0.1F, 0.375F), Climate.Parameter.span(-1.0F, -0.65F), Climate.Parameter.span(-0.3F, 0.1F), Climate.Parameter.span(0.45F, 0.8F), Climate.Parameter.point(0.0F), 0.1F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/boneyard")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.25F, 0.0F), Climate.Parameter.span(0.5F, 1.0F), Climate.Parameter.span(-1.0F, -0.7F), Climate.Parameter.span(-1.0F, -0.625F), Climate.Parameter.span(0.875F, 1.0F), Climate.Parameter.point(0.1F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/thermal_vents")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-2.0F, -1.625F), Climate.Parameter.span(-0.5F, -0.125F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-0.625F, -0.375F), Climate.Parameter.span(-1.0F, -0.625F), Climate.Parameter.point(0.53F), 0.15F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/frozen_menagerie")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.5F, -1.125F), Climate.Parameter.span(-1.0F, -0.625F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(-0.25F, 0.0F), Climate.Parameter.span(-0.5F, -0.125F), Climate.Parameter.point(0.55F), 0.1F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/chilly_cavern")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-1.0F, -0.5F), Climate.Parameter.span(0.125F, 0.75F), Climate.Parameter.span(-1.0F, 1.0F), Climate.Parameter.span(0.625F, 1.0F), Climate.Parameter.span(0.375F, 0.625F), Climate.Parameter.point(1.0F), 0.25F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/glowing_deep")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.375F, -0.25F), Climate.Parameter.span(0.625F, 1.0F), Climate.Parameter.span(-0.625F, 1.0F), Climate.Parameter.span(0.125F, 0.5F), Climate.Parameter.span(0.0F, 0.25F), Climate.Parameter.point(0.45F), 0.12F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/sheltered_garden")))),
                Pair.of(Climate.parameters(Climate.Parameter.span(-0.125F, 0.0F), Climate.Parameter.span(0.0F, 0.5F), Climate.Parameter.span(-1.0F, -0.75F), Climate.Parameter.span(-1.0F, -0.75F), Climate.Parameter.span(0.75F, 1.0F), Climate.Parameter.point(0.7F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/thermal_vents"))))
        )));
        NoiseBasedChunkGenerator iceikaNoiseGenerator = new NoiseBasedChunkGenerator(iceikaBiomeSource, iceikaNoise);
        context.register(ICEIKA_KEY, new LevelStem(iceikaDimension, iceikaNoiseGenerator));

        Holder<NoiseGeneratorSettings> arcanaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "arcana")));
        MultiNoiseBiomeSource arcanaBiomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(Climate.parameters(Climate.Parameter.point(1.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.304F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "arcana/baron_highlands")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(1.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.3F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "arcana/dune_valley"))))
        )));
        NoiseBasedChunkGenerator arcanaNoiseGenerator = new NoiseBasedChunkGenerator(arcanaBiomeSource, arcanaNoise);
        context.register(ARCANA_KEY, new LevelStem(arcanaDimension, arcanaNoiseGenerator));

        Holder<NoiseGeneratorSettings> vetheaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "vethea")));
        MultiNoiseBiomeSource vetheaBiomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(Climate.parameters(Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(-1.0F, -0.7F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/scorched_tops")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(-0.69F, -0.4F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/hyrelands")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(0.2F, 0.39F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/dream_grounds")))),
                Pair.of(Climate.parameters(Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.point(0.0F), Climate.Parameter.span(0.4F, 1.0F), Climate.Parameter.point(0.0F), 0.0F), biomes.getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/ember_caverns"))))
        )));
        NoiseBasedChunkGenerator vetheaNoiseGenerator = new NoiseBasedChunkGenerator(vetheaBiomeSource, vetheaNoise);
        context.register(VETHEA_KEY, new LevelStem(vetheaDimension, vetheaNoiseGenerator));
    }
}