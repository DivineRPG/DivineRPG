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

    public static void bootstrap(BootstrapContext<LevelStem> context) {
        Holder<DimensionType> apalachiaDimension = context.lookup(Registries.DIMENSION_TYPE).getOrThrow(ModDimensionTypeProvider.APALACHIA);
        Holder<NoiseGeneratorSettings> apalachiaNoise = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(MODID, "apalachia")));
        Holder<Biome> apalachiaBiome = context.lookup(Registries.BIOME).getOrThrow(ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "apalachia")));
        NoiseBasedChunkGenerator apalachiaNoiseGenerator = new NoiseBasedChunkGenerator(new FixedBiomeSource(apalachiaBiome), apalachiaNoise);

        context.register(APALACHIA_KEY, new LevelStem(apalachiaDimension, apalachiaNoiseGenerator));
    }
}
