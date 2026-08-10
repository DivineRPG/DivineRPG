package divinerpg.data;

import divinerpg.registries.EntityRegistry;
import divinerpg.registries.FeatureRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.attribute.AmbientAdditionsSettings;
import net.minecraft.world.attribute.AmbientMoodSettings;
import net.minecraft.world.attribute.AmbientSounds;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

import static divinerpg.DivineRPG.MODID;

public class ModBiomeProvider {

    public static final ResourceKey<Biome> EDEN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "eden"));
    public static final ResourceKey<Biome> WILDWOOD = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "wildwood"));
    public static final ResourceKey<Biome> APALACHIA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "apalachia"));
    public static final ResourceKey<Biome> SKYTHERN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "skythern"));
    public static final ResourceKey<Biome> MORTUM = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "mortum"));

    public static void bootstrap(BootstrapContext<Biome> ctx) {
        HolderGetter<PlacedFeature> placedFeatures = ctx.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = ctx.lookup(Registries.CONFIGURED_CARVER);

        MobSpawnSettings.Builder edenSpawners = new MobSpawnSettings.Builder();
        edenSpawners.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityRegistry.EDEN_TOMO.get(), 4, 4));
        edenSpawners.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityRegistry.EDEN_CADILLION.get(), 4, 4));
        edenSpawners.addSpawn(MobCategory.MONSTER, 1,  new MobSpawnSettings.SpawnerData(EntityRegistry.WEAK_CORI.get(), 1, 1));
        edenSpawners.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityRegistry.GREENFEET.get(), 4, 4));
        edenSpawners.addSpawn(MobCategory.MONSTER, 20, new MobSpawnSettings.SpawnerData(EntityRegistry.MADIVEL.get(), 4, 4));
        edenSpawners.addSpawn(MobCategory.MONSTER, 6,  new MobSpawnSettings.SpawnerData(EntityRegistry.SUN_ARCHER.get(), 4, 4));
        edenSpawners.addSpawn(MobCategory.CREATURE, 20, new MobSpawnSettings.SpawnerData(EntityRegistry.GLINTHOP.get(), 4, 4));
        edenSpawners.creatureGenerationProbability(0.05F);
        BiomeGenerationSettings.Builder edenFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        edenFeatures.addCarver(ResourceKey.create(Registries.CONFIGURED_CARVER, Identifier.fromNamespaceAndPath("minecraft", "cave")));
        //TODO - features
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/twilight_stone_blob")));
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/ore")));
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "twilight_tar_lake")));
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/divine_moss_stone")));
//        edenFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/hanging_dripstone")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/tree")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/bush")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/duncap")));
//        edenFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "eden/plants")));
        ctx.register(EDEN, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10610863).grassColorOverride(16774932).foliageColorOverride(16774932).build()).mobSpawnSettings(edenSpawners.build()).generationSettings(edenFeatures.build()).build());

        MobSpawnSettings.Builder apalachiaSpawners = new MobSpawnSettings.Builder();
        apalachiaSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.APALACHIA_CADILLION.get(), 4, 4));
        apalachiaSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.APALACHIA_GOLEM.get(), 4, 4));
        apalachiaSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.APALACHIA_TOMO.get(), 4, 4));
        apalachiaSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.ENCHANTED_WARRIOR.get(), 4, 4));
        apalachiaSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.ENCHANTED_ARCHER.get(), 4, 4));
        apalachiaSpawners.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.SPELLBINDER.get(), 4, 4));
        BiomeGenerationSettings.Builder apalachiaFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        apalachiaFeatures.addCarver(ResourceKey.create(Registries.CONFIGURED_CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        apalachiaFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.APALACHIA_ORE_PLACED);
        apalachiaFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeatureRegistry.TWILIGHT_TAR_LAKE_PLACED_KEY);
        apalachiaFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.APALACHIA_TREE_PLACED);
        apalachiaFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.APALACHIA_VEGETATION_KEY_PLACED);
        ctx.register(APALACHIA, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(15245798).grassColorOverride(12588287).foliageColorOverride(14161151).build()).mobSpawnSettings(apalachiaSpawners.build()).generationSettings(apalachiaFeatures.build()).build());

        MobSpawnSettings.Builder mortumSpawners = new MobSpawnSettings.Builder();
        mortumSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.DEMON_OF_DARKNESS.get(), 4, 4));
        mortumSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.BASILISK.get(), 4, 4));
        mortumSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.SOUL_STEALER.get(), 4, 4));
        mortumSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.MORTUM_CADILLION.get(), 4, 4));
        mortumSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.TWILIGHT_ARCHER.get(), 4, 4));
        mortumSpawners.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.SORCERER.get(), 4, 4));
        BiomeGenerationSettings.Builder mortumFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        mortumFeatures.addCarver(ResourceKey.create(Registries.CONFIGURED_CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        //TODO - features
//        mortumFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/ore")));
//        mortumFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/tar_lake")));
//        mortumFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/plants")));
//        mortumFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/tree")));
//        mortumFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "mortum/bush")));
        ctx.register(MORTUM, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(4403214).build()).setAttribute(EnvironmentAttributes.FOG_COLOR, 9536597).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4926466).setAttribute(EnvironmentAttributes.SKY_COLOR, 16756224).setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(Optional.empty(),Optional.of(new AmbientMoodSettings(Holder.direct(SoundRegistry.MORTUM_MOOD.get()), 2000, 8, 2.0D)),List.of(new AmbientAdditionsSettings(Holder.direct(SoundRegistry.MORTUM_AMBIENCE.get()), 0.0111F)))).mobSpawnSettings(mortumSpawners.build()).generationSettings(mortumFeatures.build()).build());

        MobSpawnSettings.Builder skythernSpawners = new MobSpawnSettings.Builder();
        skythernSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.SKYTHERN_FIEND.get(), 4, 4));
        skythernSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.SKYTHERN_GOLEM.get(), 4, 4));
        skythernSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.SKYTHERN_ARCHER.get(), 4, 4));
        skythernSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.SAMEK.get(), 4, 4));
        skythernSpawners.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.ADVANCED_CORI.get(), 4, 4));
        skythernSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.MYSTIC.get(), 4, 4));
        skythernSpawners.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.MEGALITH.get(), 4, 4));
        BiomeGenerationSettings.Builder skythernFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        skythernFeatures.addCarver(ResourceKey.create(Registries.CONFIGURED_CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        skythernFeatures.addCarver(ResourceKey.create(Registries.CONFIGURED_CARVER, Identifier.fromNamespaceAndPath("minecraft", "cave")));
        //TODO - features
//        skythernFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/ore")));
//        skythernFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "twilight_tar_lake")));
//        skythernFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/plants")));
//        skythernFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/tree")));
//        skythernFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "skythern/bush")));
        ctx.register(SKYTHERN, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10066329).grassColorOverride(16777215).foliageColorOverride(16777215).build()).setAttribute(EnvironmentAttributes.FOG_COLOR, 13948116).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 7895160).setAttribute(EnvironmentAttributes.SKY_COLOR, 16777215).mobSpawnSettings(skythernSpawners.build()).generationSettings(skythernFeatures.build()).build());

        MobSpawnSettings.Builder wildwoodSpawners = new MobSpawnSettings.Builder();
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.WILDWOOD_CADILLION.get(), 4, 4));
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.WILDWOOD_TOMO.get(), 4, 4));
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.EPIPHITE.get(), 2, 2));
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.BEHEMOTH.get(), 1, 1));
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 3, new MobSpawnSettings.SpawnerData(EntityRegistry.WILDWOOD_GOLEM.get(), 4, 4));
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 4, new MobSpawnSettings.SpawnerData(EntityRegistry.VEREK.get(), 4, 4));
        wildwoodSpawners.addSpawn(MobCategory.MONSTER, 2, new MobSpawnSettings.SpawnerData(EntityRegistry.MAGE.get(), 4, 4));
        wildwoodSpawners.addSpawn(MobCategory.CREATURE, 1, new MobSpawnSettings.SpawnerData(EntityRegistry.MOON_WOLF.get(), 1, 3));
        wildwoodSpawners.addMobCharge(EntityRegistry.MOON_WOLF.get(), 0.1D, 1.0D);
        BiomeGenerationSettings.Builder wildwoodFeatures = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        wildwoodFeatures.addCarver(ResourceKey.create(Registries.CONFIGURED_CARVER, Identifier.fromNamespaceAndPath("minecraft", "canyon")));
        //TODO - features
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "wildwood/ore")));
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "twilight_tar_lake")));
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "wildwood/plants")));
//        wildwoodFeatures.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, "wildwood/tree")));
        ctx.register(WILDWOOD, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10600680).grassColorOverride(23039).foliageColorOverride(2818303).build()).setAttribute(EnvironmentAttributes.FOG_COLOR, 6133246).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 13755391).setAttribute(EnvironmentAttributes.SKY_COLOR, 10730239).mobSpawnSettings(wildwoodSpawners.build()).generationSettings(wildwoodFeatures.build()).build());
    }
}