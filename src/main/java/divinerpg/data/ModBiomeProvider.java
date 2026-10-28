package divinerpg.data;

import divinerpg.registries.EntityRegistry;
import divinerpg.registries.FeatureRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.*;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

import static divinerpg.DivineRPG.MODID;

public class ModBiomeProvider {

    public static final ResourceKey<Biome> EDEN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden"));
    public static final ResourceKey<Biome> EDEN_DRAVITE_CAVES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/dravite_caves"));
    public static final ResourceKey<Biome> EDEN_DRAVITE_HILLS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/dravite_hills"));
    public static final ResourceKey<Biome> EDEN_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/forest"));
    public static final ResourceKey<Biome> EDEN_GOLDEN_PEAKS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/golden_peaks"));
    public static final ResourceKey<Biome> EDEN_MAGNETIC_ISLES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/magnetic_isles"));
    public static final ResourceKey<Biome> EDEN_PLAINS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden/plains"));

    public static final ResourceKey<Biome> WILDWOOD = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "wildwood"));
    public static final ResourceKey<Biome> APALACHIA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "apalachia"));
    public static final ResourceKey<Biome> SKYTHERN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "skythern"));
    public static final ResourceKey<Biome> MORTUM = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "mortum"));

    public static final ResourceKey<Biome> ICEIKA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika"));
    public static final ResourceKey<Biome> ICEIKA_GLOWING_DEEP = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/glowing_deep"));
    public static final ResourceKey<Biome> ICEIKA_FROZEN_MENAGERIE = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/frozen_menagerie"));
    public static final ResourceKey<Biome> ICEIKA_MORGUE_MARSH = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/morgue_marsh"));
    public static final ResourceKey<Biome> ICEIKA_ICE_SPIKES = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/ice_spikes"));
    public static final ResourceKey<Biome> ICEIKA_BOREALIS_STEEPS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/borealis_steeps"));
    public static final ResourceKey<Biome> ICEIKA_FROZEN_OCEAN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/frozen_ocean"));
    public static final ResourceKey<Biome> ICEIKA_DEEP_FROZEN_OCEAN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/deep_frozen_ocean"));
    public static final ResourceKey<Biome> ICEIKA_SNOWY_PEAKS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/snowy_peaks"));
    public static final ResourceKey<Biome> ICEIKA_CHILL_PASSAGE = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/chill_passage"));
    public static final ResourceKey<Biome> ICEIKA_FRACTAL_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/fractal_forest"));
    public static final ResourceKey<Biome> ICEIKA_FROZEN_PEAKS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/frozen_peaks"));
    public static final ResourceKey<Biome> ICEIKA_GEYSER_PLATEAU = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/geyser_plateau"));
    public static final ResourceKey<Biome> ICEIKA_SHIVERSPINE_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/shiverspine_forest"));
    public static final ResourceKey<Biome> ICEIKA_COZYBARK_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/cozybark_forest"));
    public static final ResourceKey<Biome> ICEIKA_ICE_SHEET = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/ice_sheet"));
    public static final ResourceKey<Biome> ICEIKA_SNOW_BOG = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/snow_bog"));
    public static final ResourceKey<Biome> ICEIKA_TUNDRA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/tundra"));
    public static final ResourceKey<Biome> ICEIKA_BONEYARD = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/boneyard"));
    public static final ResourceKey<Biome> ICEIKA_THERMAL_VENTS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/thermal_vents"));
    public static final ResourceKey<Biome> ICEIKA_CHILLY_CAVERN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/chilly_cavern"));
    public static final ResourceKey<Biome> ICEIKA_SHELTERED_GARDEN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "iceika/sheltered_garden"));

    public static final ResourceKey<Biome> ARCANA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "arcana"));
    public static final ResourceKey<Biome> ARCANA_DUNE_VALLEY = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "arcana/dune_valley"));
    public static final ResourceKey<Biome> ARCANA_BARON_HIGHLANDS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "arcana/baron_highlands"));

    public static final ResourceKey<Biome> VETHEA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea"));
    public static final ResourceKey<Biome> VETHEA_SCORCHED_TOPS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/scorched_tops"));
    public static final ResourceKey<Biome> VETHEA_HYRELANDS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/hyrelands"));
    public static final ResourceKey<Biome> VETHEA_DREAM_GROUNDS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/dream_grounds"));
    public static final ResourceKey<Biome> VETHEA_EMBER_CAVERNS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "vethea/ember_caverns"));

    public static void bootstrap(BootstrapContext<Biome> ctx) {
        HolderGetter<PlacedFeature> placedFeatures = ctx.lookup(Registries.PLACED_FEATURE);
        HolderGetter<WorldCarver> worldCarvers = ctx.lookup(Registries.CARVER);

        MobSpawnSettings.Builder edenSpawners = new MobSpawnSettings.Builder();
        edenSpawners.addSpawn(EntityRegistry.EDEN_TOMO.get(), 20, 4, 4);
        edenSpawners.addSpawn(EntityRegistry.EDEN_CADILLION.get(), 20, 4, 4);
        edenSpawners.addSpawn(EntityRegistry.WEAK_CORI.get(), 1, 1, 1);
        edenSpawners.addSpawn(EntityRegistry.GREENFEET.get(), 20, 4, 4);
        edenSpawners.addSpawn(EntityRegistry.MADIVEL.get(), 20, 4, 4);
        edenSpawners.addSpawn(EntityRegistry.SUN_ARCHER.get(), 6, 4, 4);
        edenSpawners.addSpawn(EntityRegistry.GLINTHOP.get(), 20, 4, 4);
        BiomeGenerationSettings.Builder edenFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        edenFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.fromNamespaceAndPath("minecraft", "cave")));
        //TODO - features
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/twilight_stone_blob")));
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/ore")));
        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY);
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/divine_moss_stone")));
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/hanging_dripstone")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/tree")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/bush")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/duncap")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/plants")));
        Biome edenBaseBiome = new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10610863).grassColorOverride(16774932).foliageColorOverride(16774932).build()).mobSpawnSettings(edenSpawners.build()).generationSettings(edenFeatures.build()).build();
        ctx.register(EDEN, edenBaseBiome);
        ctx.register(EDEN_DRAVITE_CAVES, edenBaseBiome);
        ctx.register(EDEN_DRAVITE_HILLS, edenBaseBiome);
        ctx.register(EDEN_FOREST, edenBaseBiome);
        ctx.register(EDEN_GOLDEN_PEAKS, edenBaseBiome);
        ctx.register(EDEN_MAGNETIC_ISLES, edenBaseBiome);
        ctx.register(EDEN_PLAINS, edenBaseBiome);


        MobSpawnSettings.Builder apalachiaSpawners = new MobSpawnSettings.Builder();
        apalachiaSpawners.addSpawn(EntityRegistry.APALACHIA_CADILLION.get(), 2,4, 4);
        apalachiaSpawners.addSpawn(EntityRegistry.APALACHIA_GOLEM.get(), 2, 4, 4);
        apalachiaSpawners.addSpawn(EntityRegistry.APALACHIA_TOMO.get(), 2, 4, 4);
        apalachiaSpawners.addSpawn(EntityRegistry.ENCHANTED_WARRIOR.get(), 2, 4, 4);
        apalachiaSpawners.addSpawn(EntityRegistry.ENCHANTED_ARCHER.get(), 2, 4, 4);
        apalachiaSpawners.addSpawn(EntityRegistry.SPELLBINDER.get(), 1, 4, 4);
        BiomeGenerationSettings.Builder apalachiaFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        apalachiaFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        apalachiaFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.APALACHIA_ORE_PLACED);
        apalachiaFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY);
        apalachiaFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.APALACHIA_TREE_PLACED);
        apalachiaFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.APALACHIA_VEGETATION_KEY_PLACED);
        ctx.register(APALACHIA, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(15245798).grassColorOverride(12588287).foliageColorOverride(14161151).build()).mobSpawnSettings(apalachiaSpawners.build()).generationSettings(apalachiaFeatures.build()).build());

        MobSpawnSettings.Builder mortumSpawners = new MobSpawnSettings.Builder();
        mortumSpawners.addSpawn(EntityRegistry.DEMON_OF_DARKNESS.get(), 2, 4, 4);
        mortumSpawners.addSpawn(EntityRegistry.BASILISK.get(), 2, 4, 4);
        mortumSpawners.addSpawn(EntityRegistry.SOUL_STEALER.get(), 2, 4, 4);
        mortumSpawners.addSpawn(EntityRegistry.MORTUM_CADILLION.get(), 2, 4, 4);
        mortumSpawners.addSpawn(EntityRegistry.TWILIGHT_ARCHER.get(), 2, 4, 4);
        mortumSpawners.addSpawn(EntityRegistry.SORCERER.get(), 1, 4, 4);
        BiomeGenerationSettings.Builder mortumFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        mortumFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        //TODO - features
//        mortumFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/ore")));
        mortumFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY);
//        mortumFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/plants")));
//        mortumFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/tree")));
//        mortumFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/bush")));
        ctx.register(MORTUM, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(4403214).build()).setAttribute(EnvironmentAttributes.FOG_COLOR, new Vector3f(9536597)).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, new Vector3f(4926466)).setAttribute(EnvironmentAttributes.SKY_COLOR, new Vector3f(16756224)).setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.empty(),Optional.of(new AmbientMoodSettings(Holder.direct(SoundRegistry.MORTUM_MOOD.get()), 2000, 8, 2.0D)),List.of(new AmbientAdditionsSettings(Holder.direct(SoundRegistry.MORTUM_AMBIENCE.get()), 0.0111F)))).mobSpawnSettings(mortumSpawners.build()).generationSettings(mortumFeatures.build()).build());

        MobSpawnSettings.Builder skythernSpawners = new MobSpawnSettings.Builder();
        skythernSpawners.addSpawn(EntityRegistry.SKYTHERN_FIEND.get(), 4, 4, 4);
        skythernSpawners.addSpawn(EntityRegistry.SKYTHERN_GOLEM.get(), 4, 4, 4);
        skythernSpawners.addSpawn(EntityRegistry.SKYTHERN_ARCHER.get(), 4, 4, 4);
        skythernSpawners.addSpawn(EntityRegistry.SAMEK.get(), 4, 4, 4);
        skythernSpawners.addSpawn(EntityRegistry.ADVANCED_CORI.get(), 1, 4, 4);
        skythernSpawners.addSpawn(EntityRegistry.MYSTIC.get(), 2, 4, 4);
        skythernSpawners.addSpawn(EntityRegistry.MEGALITH.get(), 1, 4, 4);
        BiomeGenerationSettings.Builder skythernFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        skythernFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        skythernFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.fromNamespaceAndPath("minecraft", "cave")));
        //TODO - features
//        skythernFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/ore")));
        skythernFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY);
//        skythernFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/plants")));
//        skythernFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/tree")));
//        skythernFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/bush")));
        ctx.register(SKYTHERN, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10066329).grassColorOverride(16777215).foliageColorOverride(16777215).build()).setAttribute(EnvironmentAttributes.FOG_COLOR, new Vector3f(13948116)).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, new Vector3f(7895160)).setAttribute(EnvironmentAttributes.SKY_COLOR, new Vector3f(16777215)).mobSpawnSettings(skythernSpawners.build()).generationSettings(skythernFeatures.build()).build());

        MobSpawnSettings.Builder wildwoodSpawners = new MobSpawnSettings.Builder();
        wildwoodSpawners.addSpawn(EntityRegistry.WILDWOOD_CADILLION.get(), 4, 4, 4);
        wildwoodSpawners.addSpawn(EntityRegistry.WILDWOOD_TOMO.get(), 4, 4, 4);
        wildwoodSpawners.addSpawn(EntityRegistry.EPIPHITE.get(), 1, 2, 2);
        wildwoodSpawners.addSpawn(EntityRegistry.BEHEMOTH.get(), 1, 1, 1);
        wildwoodSpawners.addSpawn(EntityRegistry.WILDWOOD_GOLEM.get(), 3, 4, 4);
        wildwoodSpawners.addSpawn(EntityRegistry.VEREK.get(), 4, 4, 4);
        wildwoodSpawners.addSpawn(EntityRegistry.MAGE.get(), 2, 4, 4);
        wildwoodSpawners.addSpawn(EntityRegistry.MOON_WOLF.get(), 1, 1, 3);
        wildwoodSpawners.addMobSpawnCost(EntityRegistry.MOON_WOLF.get(), 0.1D, 1.0D);
        BiomeGenerationSettings.Builder wildwoodFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        wildwoodFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        //TODO - features
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "wildwood/ore")));
        wildwoodFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY);
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "wildwood/plants")));
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "wildwood/tree")));
        ctx.register(WILDWOOD, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10600680).grassColorOverride(23039).foliageColorOverride(2818303).build()).setAttribute(EnvironmentAttributes.FOG_COLOR, new Vector3f(6133246)).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, new Vector3f(13755391)).setAttribute(EnvironmentAttributes.SKY_COLOR, new Vector3f(10730239)).mobSpawnSettings(wildwoodSpawners.build()).generationSettings(wildwoodFeatures.build()).build());

        // Iceika Biomes
        MobSpawnSettings.Builder iceikaSpawners = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder iceikaFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        Biome iceikaBiomeBase = new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.0F).downfall(0.8F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(4159204).build()).mobSpawnSettings(iceikaSpawners.build()).generationSettings(iceikaFeatures.build()).build();
        ctx.register(ICEIKA, iceikaBiomeBase);
        ctx.register(ICEIKA_GLOWING_DEEP, iceikaBiomeBase);
        ctx.register(ICEIKA_FROZEN_MENAGERIE, iceikaBiomeBase);
        ctx.register(ICEIKA_MORGUE_MARSH, iceikaBiomeBase);
        ctx.register(ICEIKA_ICE_SPIKES, iceikaBiomeBase);
        ctx.register(ICEIKA_BOREALIS_STEEPS, iceikaBiomeBase);
        ctx.register(ICEIKA_FROZEN_OCEAN, iceikaBiomeBase);
        ctx.register(ICEIKA_DEEP_FROZEN_OCEAN, iceikaBiomeBase);
        ctx.register(ICEIKA_SNOWY_PEAKS, iceikaBiomeBase);
        ctx.register(ICEIKA_CHILL_PASSAGE, iceikaBiomeBase);
        ctx.register(ICEIKA_FRACTAL_FOREST, iceikaBiomeBase);
        ctx.register(ICEIKA_FROZEN_PEAKS, iceikaBiomeBase);
        ctx.register(ICEIKA_GEYSER_PLATEAU, iceikaBiomeBase);
        ctx.register(ICEIKA_SHIVERSPINE_FOREST, iceikaBiomeBase);
        ctx.register(ICEIKA_COZYBARK_FOREST, iceikaBiomeBase);
        ctx.register(ICEIKA_ICE_SHEET, iceikaBiomeBase);
        ctx.register(ICEIKA_SNOW_BOG, iceikaBiomeBase);
        ctx.register(ICEIKA_TUNDRA, iceikaBiomeBase);
        ctx.register(ICEIKA_BONEYARD, iceikaBiomeBase);
        ctx.register(ICEIKA_THERMAL_VENTS, iceikaBiomeBase);
        ctx.register(ICEIKA_CHILLY_CAVERN, iceikaBiomeBase);
        ctx.register(ICEIKA_SHELTERED_GARDEN, iceikaBiomeBase);

        // Arcana Biomes
        MobSpawnSettings.Builder arcanaSpawners = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder arcanaFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        ctx.register(ARCANA, new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.0F).downfall(0.0F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(4159204).build()).mobSpawnSettings(arcanaSpawners.build()).generationSettings(arcanaFeatures.build()).build());

        // Arcana - Dune Valley
        BiomeGenerationSettings.Builder duneValleyFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        //TODO - features
//        duneValleyFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/dungeon")));
//        duneValleyFeatures.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/tar_lake")));
//        duneValleyFeatures.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/vines")));
//        duneValleyFeatures.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/brush")));
//        duneValleyFeatures.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/bush")));
//        duneValleyFeatures.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/gem_of_the_dunes")));

        ctx.register(ARCANA_DUNE_VALLEY, new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.0F).downfall(0.0F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(8019531).grassColorOverride(2044369).foliageColorOverride(2044369).build()).setAttribute(EnvironmentAttributes.SKY_COLOR, new Vector3f(10540502)).setAttribute(EnvironmentAttributes.FOG_COLOR, new Vector3f(7579884)).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, new Vector3f(14319662)).setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.of(Holder.direct(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP.value())), Optional.of(new AmbientMoodSettings(Holder.direct(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD.value()), 6000, 8, 2.0D)), List.of(new AmbientAdditionsSettings(Holder.direct(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS.value()), 0.0111F)))).mobSpawnSettings(arcanaSpawners.build()).generationSettings(duneValleyFeatures.build()).build());

        // Arcana - Baron Highlands
        BiomeGenerationSettings.Builder baronHighlandsFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        baronHighlandsFeatures.addCarver(ResourceKey.create(Registries.CARVER, Identifier.parse("minecraft:cave")));
        //TODO - feature
//        baronHighlandsFeatures.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "arcana/soul_fire")));
        ctx.register(ARCANA_BARON_HIGHLANDS, new Biome.BiomeBuilder().hasPrecipitation(false).temperature(2.0F).downfall(0.0F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10451812).grassColorOverride(6056679).foliageColorOverride(6056679).build()).setAttribute(EnvironmentAttributes.SKY_COLOR, new Vector3f(11786203)).setAttribute(EnvironmentAttributes.FOG_COLOR, new Vector3f(11965169)).setAttribute(EnvironmentAttributes.AMBIENT_PARTICLES, List.of(new AmbientParticle(ParticleTypes.SMOKE, 0.001F))).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, new Vector3f(13472278)).setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.of(Holder.direct(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP.value())), Optional.of(new AmbientMoodSettings(Holder.direct(SoundEvents.AMBIENT_BASALT_DELTAS_MOOD.value()), 8000, 8, 2.0D)), List.of(new AmbientAdditionsSettings(Holder.direct(SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS.value()), 0.0111F)))).mobSpawnSettings(arcanaSpawners.build()).generationSettings(baronHighlandsFeatures.build()).build());

        // Vethea Biome
        MobSpawnSettings.Builder vetheaSpawners = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder vetheaFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        Biome vetheaBiomeBase = new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.0F).downfall(0.0F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(4159204).build()).mobSpawnSettings(vetheaSpawners.build()).generationSettings(vetheaFeatures.build()).build();
        ctx.register(VETHEA, vetheaBiomeBase);
        ctx.register(VETHEA_SCORCHED_TOPS, vetheaBiomeBase);
        ctx.register(VETHEA_HYRELANDS, vetheaBiomeBase);
        ctx.register(VETHEA_DREAM_GROUNDS, vetheaBiomeBase);
        ctx.register(VETHEA_EMBER_CAVERNS, vetheaBiomeBase);
    }
}