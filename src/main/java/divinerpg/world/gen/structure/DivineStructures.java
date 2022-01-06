package divinerpg.world.gen.structure;


import java.util.Random;

import divinerpg.*;
import divinerpg.world.gen.structure.structures.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.settings.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.registries.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DivineStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, DivineRPG.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> HUT = STRUCTURES.register("hut", () -> new HutStructure(NoFeatureConfig.CODEC));

    public static final class Configured {
        public static final StructureFeature<?, ?> HUT = DivineStructures.HUT.get().configured(IFeatureConfig.NONE);

        private static <FC extends IFeatureConfig> void register(String name, StructureFeature<FC, ?> stuctureFeature) {
            Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(DivineRPG.MODID, name), stuctureFeature);
        }

        public static void registerStructures() {
            register("hut", HUT);
        }
    }

    public static void noise() {
        //StructureSeparationSettings.
        //average distance apart
        //minimal distance apart
        //seed mod
        Structure.STRUCTURES_REGISTRY.put("hut", HUT.get());
        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.forEach(settings -> {
            settings.structureSettings().structureConfig().put(DivineStructures.HUT.get(), new StructureSeparationSettings(65, 32, 427227012));
        });
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void init(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            DivineStructures.Configured.registerStructures();
            DivineStructures.noise();
        });
    }
    public static int getYPositionForFeature(int x, int z, final ChunkGenerator chunkGen) {
        final Rotation bzj5 = Rotation.getRandom(new Random((long)(x + z * 1024)));
        int integer3 = 5;
        int integer4 = 5;
        if (bzj5 == Rotation.CLOCKWISE_90) {
            integer3 = -5;
        }
        else if (bzj5 == Rotation.CLOCKWISE_180) {
            integer3 = -5;
            integer4 = -5;
        }
        else if (bzj5 == Rotation.COUNTERCLOCKWISE_90) {
            integer4 = -5;
        }
        final int integer7 = chunkGen.getFirstOccupiedHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
        final int integer8 = chunkGen.getFirstOccupiedHeight(x, z + integer4, Heightmap.Type.WORLD_SURFACE_WG);
        final int integer9 = chunkGen.getFirstOccupiedHeight(x + integer3, z, Heightmap.Type.WORLD_SURFACE_WG);
        final int integer10 = chunkGen.getFirstOccupiedHeight(x + integer3, z + integer4, Heightmap.Type.WORLD_SURFACE_WG);
        return Math.min(Math.min(integer7, integer8), Math.min(integer9, integer10));
    }
}