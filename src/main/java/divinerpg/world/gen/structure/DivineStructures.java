package divinerpg.world.gen.structure;


import divinerpg.*;
import divinerpg.world.gen.structure.piece.*;
import divinerpg.world.gen.structure.structures.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
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

    public static final RegistryObject<Structure<NoFeatureConfig>> HUT = STRUCTURES.register("hut", () -> new HutStructure(NoFeatureConfig.field_236558_a_));

    public static final class Configured {
        public static final StructureFeature<?, ?> HUT = DivineStructures.HUT.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

        private static <FC extends IFeatureConfig> void register(String name, StructureFeature<FC, ?> stuctureFeature) {
            Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, new ResourceLocation(DivineRPG.MODID, name), stuctureFeature);
        }

        public static void registerStructures() {
            register("hut", HUT);
        }
    }

    public static final class Pieces {
        public static final IStructurePieceType HUT_PIECE = IStructurePieceType.register(HutPiece.Piece::new, "hut_piece");
    }

    public static void noise() {
        Structure.NAME_STRUCTURE_BIMAP.put("hut", HUT.get());
        WorldGenRegistries.NOISE_SETTINGS.forEach(settings -> {
            settings.getStructures().func_236195_a_().put(DivineStructures.HUT.get(), new StructureSeparationSettings(32, 8, 56181419));
        });
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void init(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            DivineStructures.Configured.registerStructures();
            DivineStructures.noise();
        });
    }
}