package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.world.OreVein;
import divinerpg.world.config.ore.OreVeinConfig;
import divinerpg.world.config.tree.TreeConfig;
import divinerpg.world.feature.DivineTree;
import divinerpg.world.feature.Ellipsoid;
import divinerpg.world.feature.config.EllipsoidConfig;
import divinerpg.world.feature.structurelike.KobblinHill;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.registries.DeferredHolder;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.DivineRegistries.FEATURES;

public class FeatureRegistry {

    public static final DeferredHolder<Feature<?>, Feature<EllipsoidConfig>> ELLIPSOID = FEATURES.register("blob", Ellipsoid::new);
    public static final DeferredHolder<Feature<?>, Feature<OreVeinConfig>> ORE_VEIN_FEATURE = FEATURES.register("ore_vein", OreVein::new);
    public static final DeferredHolder<Feature<?>, Feature<TreeConfig>> DIVINE_TREE = FEATURES.register("divine_tree", DivineTree::new);// Inside FeatureRegistry.java
    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> KOBBLIN_HILL_FEATURE = FEATURES.register("kobblin_hill", KobblinHill::new);
    public static final ResourceKey<ConfiguredFeature<?, ?>> KOBBLIN_HILL_KEY = registerConfigured("kobblin_hill");
    public static final ResourceKey<PlacedFeature> KOBBLIN_HILL = registerPlaced("kobblin_hill");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TAR_LAKE_KEY = registerConfigured("tar_lake");
    public static final ResourceKey<PlacedFeature> TAR_LAKE = registerPlaced("tar_lake");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ARLEMITE_ORE = registerConfigured("arlemite_ore");
    public static final ResourceKey<PlacedFeature> ARLEMITE_PLACED = registerPlaced("arlemite");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REALMITE_ORE = registerConfigured("realmite_ore");
    public static final ResourceKey<PlacedFeature> REALMITE_PLACED = registerPlaced("realmite");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUPEE_ORE = registerConfigured("rupee_ore");
    public static final ResourceKey<PlacedFeature> RUPEE_PLACED = registerPlaced("rupee");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLOODGEM_ORE = registerConfigured("bloodgem_ore");
    public static final ResourceKey<PlacedFeature> BLOODGEM_ORE_PLACED = registerPlaced("bloodgem_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TORRIDITE_ORE = registerConfigured("torridite_ore");
    public static final ResourceKey<PlacedFeature> TORRIDITE_PLACED = registerPlaced("torridite_ore");


    public static final ResourceKey<ConfiguredFeature<?, ?>> REALMITE_VEIN_SMALL = registerConfigured("realmite_vein_small");
    public static final ResourceKey<PlacedFeature> REALMITE_VEIN_SMALL_PLACED = registerPlaced("realmite_vein_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REALMITE_VEIN_LARGE = registerConfigured("realmite_vein_large");
    public static final ResourceKey<PlacedFeature> REALMITE_VEIN_LARGE_PLACED = registerPlaced("realmite_vein_large");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DIVINE_TREE_KEY = registerConfigured("divine_tree");
    public static final ResourceKey<PlacedFeature> DIVINE_TREE_PLACED = registerPlaced("divine_tree");
    public static final ResourceKey<PlacedFeature> GIANT_DIVINE_TREE_PLACED = registerPlaced("giant_divine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_DIVINE_TREE = registerConfigured("giant_divine_tree");

    private static ResourceKey<ConfiguredFeature<?, ?>> registerConfigured(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<PlacedFeature> registerPlaced(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static void load() {}
}