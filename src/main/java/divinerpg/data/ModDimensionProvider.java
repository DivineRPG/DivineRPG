package divinerpg.data;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

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
        Holder<DimensionType> edenDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.EDEN);
        Holder<DimensionType> wildwoodDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.WILDWOOD);
        Holder<DimensionType> apalachiaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.APALACHIA);
        Holder<DimensionType> skythernDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.SKYTHERN);
        Holder<DimensionType> mortumDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.MORTUM);
        Holder<DimensionType> iceikaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.ICEIKA);
        Holder<DimensionType> arcanaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.ARCANA);
        Holder<DimensionType> vetheaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.VETHEA);

        Holder<NoiseGeneratorSettings> edenNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "eden")));
        Holder<Biome> edenBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden")));
        NoiseBasedChunkGenerator edenNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(edenBiome), edenNoise);
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
        Holder<Biome> iceikaBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika")));
        NoiseBasedChunkGenerator iceikaNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(iceikaBiome), iceikaNoise);
        context.register(ICEIKA_KEY, new LevelStem(iceikaDimension, iceikaNoiseGenerator));

        Holder<NoiseGeneratorSettings> arcanaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "arcana")));
        Holder<Biome> arcanaBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "arcana")));
        NoiseBasedChunkGenerator arcanaNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(arcanaBiome), arcanaNoise);
        context.register(ARCANA_KEY, new LevelStem(arcanaDimension, arcanaNoiseGenerator));

        Holder<NoiseGeneratorSettings> vetheaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "vethea")));
        Holder<Biome> vetheaBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea")));
        NoiseBasedChunkGenerator vetheaNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(vetheaBiome), vetheaNoise);
        context.register(VETHEA_KEY, new LevelStem(vetheaDimension, vetheaNoiseGenerator));
    }
}
