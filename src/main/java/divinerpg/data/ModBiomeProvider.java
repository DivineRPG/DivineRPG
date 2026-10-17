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
    public static final ResourceKey<Biome> WILDWOOD = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "wildwood"));
    public static final ResourceKey<Biome> APALACHIA = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "apalachia"));
    public static final ResourceKey<Biome> SKYTHERN = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "skythern"));
    public static final ResourceKey<Biome> MORTUM = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, "mortum"));

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
        ctx.register(EDEN, new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.4F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(10610863).grassColorOverride(16774932).foliageColorOverride(16774932).build()).mobSpawnSettings(edenSpawners.build()).generationSettings(edenFeatures.build()).build());

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
    }
}