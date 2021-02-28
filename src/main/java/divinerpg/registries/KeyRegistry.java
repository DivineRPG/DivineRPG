package divinerpg.registries;

import divinerpg.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.blockstateprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.surfacebuilders.*;
import net.minecraft.world.gen.trunkplacer.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class KeyRegistry {

    public static RegistryKey<World> EDEN_WORLD;
    public static RegistryKey<Biome> EDEN_BIOME;
    public static RegistryKey<SurfaceBuilder<?>> EDEN_BUILDER;
    public static final DeferredRegister<PointOfInterestType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DivineRPG.MODID);
    public static RegistryObject<PointOfInterestType> EDEN_PORTAL;
    public static ConfiguredFeature<BaseTreeFeatureConfig,?> DIVINE_TREE;



    public static void init(){
        EDEN_BIOME = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_WORLD = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_BUILDER = RegistryKey.getOrCreateKey(Registry.SURFACE_BUILDER_KEY, new ResourceLocation(DivineRPG.MODID, "eden"));
        EDEN_PORTAL = POI.register("eden_portal", () -> new PointOfInterestType("eden_portal", PointOfInterestType.getAllStates(BlockRegistry.edenPortal), 0, 1));
        DIVINE_TREE = Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockRegistry.divineLog.getDefaultState()), new SimpleBlockStateProvider(BlockRegistry.divineLeaves.getDefaultState()), new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build());

    }
}
