package net.divinerpg.data;

import net.divinerpg.registries.FeatureRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static net.divinerpg.DivineRPG.MODID;

public class ModBiomeModifierBootstrap {

    public static void bootstrap(BootstrapContext<BiomeModifier> ctx) {

        var biomes = ctx.lookup(Registries.BIOME);
        var placed = ctx.lookup(Registries.PLACED_FEATURE);

        ResourceKey<BiomeModifier> OVERWORLD_ORES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "tag_overworld_ores"));
        ResourceKey<BiomeModifier> NETHER_ORES = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "tag_nether_ores"));
        ResourceKey<BiomeModifier> DIVINE_TREE_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "add_divine_trees"));
        ResourceKey<BiomeModifier> FOREST_VEGETATION = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, "tag_forest_vegetation"));

        ctx.register(OVERWORLD_ORES, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(FeatureRegistry.ARLEMITE_PLACED), placed.getOrThrow(FeatureRegistry.REALMITE_PLACED), placed.getOrThrow(FeatureRegistry.REALMITE_VEIN_LARGE_PLACED), placed.getOrThrow(FeatureRegistry.REALMITE_VEIN_SMALL_PLACED), placed.getOrThrow(FeatureRegistry.RUPEE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        ctx.register(NETHER_ORES, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placed.getOrThrow(FeatureRegistry.TORRIDITE_PLACED), placed.getOrThrow(FeatureRegistry.BLOODGEM_ORE_PLACED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        ctx.register(DIVINE_TREE_MODIFIER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placed.getOrThrow(FeatureRegistry.DIVINE_TREE_PLACED)), GenerationStep.Decoration.VEGETAL_DECORATION));
        ctx.register(FOREST_VEGETATION, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST), HolderSet.direct(placed.getOrThrow(FeatureRegistry.GIANT_DIVINE_TREE_PLACED)), GenerationStep.Decoration.VEGETAL_DECORATION));

    }
}