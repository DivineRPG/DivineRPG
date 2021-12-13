package divinerpg.registries;


import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.world.arcana.*;
import divinerpg.world.gen.piece.*;
import divinerpg.world.gen.structure.structures.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.settings.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import java.util.*;

public class StructureRegistry {

    public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, DivineRPG.MODID);

    public static final RegistryObject<Structure<NoFeatureConfig>> HUT = DEFERRED_REGISTRY_STRUCTURE.register("hut", () -> (new HutStructure(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> EDEN = DEFERRED_REGISTRY_STRUCTURE.register("eden", () -> (new EdenStructures(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> WILDWOOD = DEFERRED_REGISTRY_STRUCTURE.register("wildwood", () -> (new WildwoodStructures(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> APALACHIA = DEFERRED_REGISTRY_STRUCTURE.register("apalachia", () -> (new ApalachiaStructures(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> SKYTHERN = DEFERRED_REGISTRY_STRUCTURE.register("skythern", () -> (new SkythernStructures(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> MORTUM = DEFERRED_REGISTRY_STRUCTURE.register("mortum", () -> (new MortumStructures(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> ICEIKA = DEFERRED_REGISTRY_STRUCTURE.register("iceika", () -> (new IceikaStructures(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> ICEIKA_DUNGEON = DEFERRED_REGISTRY_STRUCTURE.register("iceika_dungeons", () -> (new IceikaDungeonStructures(NoFeatureConfig.CODEC)));

    public static void setupStructures() {
        DivineRPG.LOGGER.info("[DivineRPG] Setup structures");
        setupMapSpacingAndLand(HUT.get(), new StructureSeparationSettings(30, 5, 45642069), true);


        setupMapSpacingAndLand(EDEN.get(), new StructureSeparationSettings(30, 5, 45696902), true);
        setupMapSpacingAndLand(WILDWOOD.get(), new StructureSeparationSettings(30, 5, 45611420), true);
        setupMapSpacingAndLand(APALACHIA.get(), new StructureSeparationSettings(30, 5, 6844516), true);
        setupMapSpacingAndLand(SKYTHERN.get(), new StructureSeparationSettings(30, 5, 3213265), true);
        setupMapSpacingAndLand(MORTUM.get(), new StructureSeparationSettings(30, 5, 9784512), true);
        setupMapSpacingAndLand(ICEIKA.get(), new StructureSeparationSettings(30, 5, 3512846), true);
        setupMapSpacingAndLand(ICEIKA_DUNGEON.get(), new StructureSeparationSettings(30, 5, 6845645), true);

    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        if(transformSurroundingLand){
            Structure.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }
        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

            if(structureMap instanceof ImmutableMap){
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else{
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
    public interface Pieces {
        IStructurePieceType ARCANA_PIECE = register(ArcanaPieces.Piece::new, "arcana");
        IStructurePieceType ICEIKA_HOUSE = register(IceikaHousePiece.Piece::new, "iceika_house");
        IStructurePieceType ICEIKA_DUNGEON = register(IceikaDungeonPiece.Piece::new, "iceika_dungeon");

        static IStructurePieceType register(IStructurePieceType piece, String name) {
            return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), piece);
        }
    }
}
