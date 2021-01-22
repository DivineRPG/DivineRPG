package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class KeyRegistry {

    public static RegistryKey<World> EDEN_WORLD;
    public static RegistryKey<Biome> EDEN_BIOME;
    public static RegistryKey<SurfaceBuilder<?>> EDEN_BUILDER;
    public static RegistryKey<Feature<?>> EDEN_TREE;
    public static RegistryKey<Feature<?>> EDEN_ORE;



    public static void init(){
        EDEN_TREE = RegistryKey.getOrCreateKey(Registry.FEATURE_KEY, new ResourceLocation(DivineRPG.MODID, "eden_tree"));
        EDEN_ORE = RegistryKey.getOrCreateKey(Registry.FEATURE_KEY, new ResourceLocation(DivineRPG.MODID, "eden_ore"));
        EDEN_BIOME = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_BUILDER = RegistryKey.getOrCreateKey(Registry.SURFACE_BUILDER_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));

    }
}
