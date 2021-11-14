package divinerpg.registries;


import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.world.arcana.*;
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

    public static final RegistryObject<Structure<NoFeatureConfig>> COLUMN_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("column_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/column_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> CHAINED_ROOM_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("chained_room_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/chained_room_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DELTA_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("delta_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/delta_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> GENERIC_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("generic_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/generic_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HEAT_TRAP_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("heat_trap_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/heat_trap_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> LIVING_STATUE_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("living_statue_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/living_statue_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> METAL_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("metal_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/metal_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> PYRAMID_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("pyramid_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/pyramid_corner")));
    public static final RegistryObject<Structure<NoFeatureConfig>> RAZORBACK_CORNER = DEFERRED_REGISTRY_STRUCTURE.register("razorback_corner", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/corner/razorback_corner")));

    public static final RegistryObject<Structure<NoFeatureConfig>> COLUMN_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("column_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/column_crossroads")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DELTA_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("delta_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/delta_crossroads")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DUNGEON_PRISONER_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("dungeon_prisoner_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/dungeon_prisoner_crossroads")));
    public static final RegistryObject<Structure<NoFeatureConfig>> EXTRACTION_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("extraction_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/extraction_crossroads")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HEAT_TRAP_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("heat_trap_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/heat_trap_crossroads")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HEAT_TRAP_CROSSROADS_ARCANIUM = DEFERRED_REGISTRY_STRUCTURE.register("heat_trap_crossroads_arcanium", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/heat_trap_crossroads_arcanium")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HOLLOW_COLUMN_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("hollow_column_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/hollow_column_crossroads")));
    public static final RegistryObject<Structure<NoFeatureConfig>> RAMP_CROSSROADS = DEFERRED_REGISTRY_STRUCTURE.register("ramp_crossroads", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/ramp_crossroads")));

    public static final RegistryObject<Structure<NoFeatureConfig>> DRAMIX_ROOM = DEFERRED_REGISTRY_STRUCTURE.register("dramix_room", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/boss/dramix_room")));
    public static final RegistryObject<Structure<NoFeatureConfig>> PARASECTA_ROOM = DEFERRED_REGISTRY_STRUCTURE.register("parasecta_room", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/crossroads/boss/parasecta_room")));

    public static final RegistryObject<Structure<NoFeatureConfig>> BANQUET_HALL = DEFERRED_REGISTRY_STRUCTURE.register("banquet_hall", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/banquet_hall")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DUNGEON_LIBRARY = DEFERRED_REGISTRY_STRUCTURE.register("dungeon_library", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/dungeon_library")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DUNGEON_PRISON = DEFERRED_REGISTRY_STRUCTURE.register("dungeon_prison", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/dungeon_prison")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DUNGEON_PRISON_BROKEN = DEFERRED_REGISTRY_STRUCTURE.register("dungeon_prison_broken", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/dungeon_prison_broken")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HEAT_TRAP_DEAD_END = DEFERRED_REGISTRY_STRUCTURE.register("heat_trap_dead_end", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/heat_trap_dead_end")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HILL_DEAD_END = DEFERRED_REGISTRY_STRUCTURE.register("hill_dead_end", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/hill_dead_end")));
    public static final RegistryObject<Structure<NoFeatureConfig>> LAVA_DEAD_END = DEFERRED_REGISTRY_STRUCTURE.register("lava_dead_end", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/lava_dead_end")));
    public static final RegistryObject<Structure<NoFeatureConfig>> LAVA_DEAD_END_ARCANIUM = DEFERRED_REGISTRY_STRUCTURE.register("lava_dead_end_arcanium", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/lava_dead_end_arcanium")));
    public static final RegistryObject<Structure<NoFeatureConfig>> ROAMER_CHAMBER = DEFERRED_REGISTRY_STRUCTURE.register("roamer_chamber", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/roamer_chamber")));

    public static final RegistryObject<Structure<NoFeatureConfig>> DATTICON_WORKSHOP = DEFERRED_REGISTRY_STRUCTURE.register("datticon_workshop", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/datticon_workshop")));
    public static final RegistryObject<Structure<NoFeatureConfig>> KAZARI_ROOM = DEFERRED_REGISTRY_STRUCTURE.register("kazari_room", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/kazari_room")));
    public static final RegistryObject<Structure<NoFeatureConfig>> LEORNA_HUT = DEFERRED_REGISTRY_STRUCTURE.register("leorna_hut", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/leorna_hut")));
    public static final RegistryObject<Structure<NoFeatureConfig>> LORD_VATTICUS_STUDY = DEFERRED_REGISTRY_STRUCTURE.register("lord_vatticus_study", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/lord_vatticus_study")));
    public static final RegistryObject<Structure<NoFeatureConfig>> CAPTAIN_MERIK_FORGE = DEFERRED_REGISTRY_STRUCTURE.register("captain_merik_forge", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/captain_merik_forge")));
    public static final RegistryObject<Structure<NoFeatureConfig>> WAR_GENERAL_CHAMBER = DEFERRED_REGISTRY_STRUCTURE.register("war_general_chamber", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/war_general_chamber")));
    public static final RegistryObject<Structure<NoFeatureConfig>> ZELUS_FARM = DEFERRED_REGISTRY_STRUCTURE.register("zelus_farm", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/deadend/npc/zelus_farm")));

    public static final RegistryObject<Structure<NoFeatureConfig>> HEAT_TRAP_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("heat_trap_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/heat_trap_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> LAVA_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("lava_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/lava_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> MAZE_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("maze_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/maze_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> PILLAR_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("pillar_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/pillar_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> RAMP_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("ramp_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/ramp_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> SERPENTINE_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("serpentine_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/serpentine_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> TILED_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("tiled_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/tiled_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> UTILITY_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("utility_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/utility_hallway")));
    public static final RegistryObject<Structure<NoFeatureConfig>> V_HALLWAY = DEFERRED_REGISTRY_STRUCTURE.register("v_hallway", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/hallway/v_hallway")));

    public static final RegistryObject<Structure<NoFeatureConfig>> DEGRADED_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("degraded_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/degraded_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DEGRADED_MAZE_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("degraded_maze_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/degraded_maze_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HEAT_TRAP_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("heat_trap_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/heat_trap_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> MOUND_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("mound_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/mound_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> SERPENTINE_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("serpentine_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/serpentine_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> STAIR_COLUMN_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("stair_column_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/stair_column_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> TRIDENT_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("trident_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/trident_junction")));
    public static final RegistryObject<Structure<NoFeatureConfig>> UTILITY_ROOM_JUNCTION = DEFERRED_REGISTRY_STRUCTURE.register("utility_room_junction", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/junction/utility_room_junction")));

    public static final RegistryObject<Structure<NoFeatureConfig>> CORNER_PORTAL = DEFERRED_REGISTRY_STRUCTURE.register("corner_portal", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/portal/corner_portal")));
    public static final RegistryObject<Structure<NoFeatureConfig>> CROSSROADS_PORTAL = DEFERRED_REGISTRY_STRUCTURE.register("crossroads_portal", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/portal/crossroads_portal")));
    public static final RegistryObject<Structure<NoFeatureConfig>> DEAD_END_PORTAL = DEFERRED_REGISTRY_STRUCTURE.register("dead_end_portal", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/portal/dead_end_portal")));
    public static final RegistryObject<Structure<NoFeatureConfig>> HALLWAY_PORTAL = DEFERRED_REGISTRY_STRUCTURE.register("hallway_portal", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/portal/hallway_portal")));
    public static final RegistryObject<Structure<NoFeatureConfig>> JUNCTION_PORTAL = DEFERRED_REGISTRY_STRUCTURE.register("junction_portal", () -> (new ArcanaStructure(NoFeatureConfig.CODEC, "arcana/portal/junction_portal")));

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

        setupMapSpacingAndLand(COLUMN_CORNER.get(), new StructureSeparationSettings(30, 5, 213), false);
        setupMapSpacingAndLand(CHAINED_ROOM_CORNER.get(), new StructureSeparationSettings(30, 5, 214), false);
        setupMapSpacingAndLand(DELTA_CORNER.get(), new StructureSeparationSettings(30, 5, 215), false);
        setupMapSpacingAndLand(GENERIC_CORNER.get(), new StructureSeparationSettings(30, 5, 216), false);
        setupMapSpacingAndLand(HEAT_TRAP_CORNER.get(), new StructureSeparationSettings(30, 5, 217), false);
        setupMapSpacingAndLand(LIVING_STATUE_CORNER.get(), new StructureSeparationSettings(30, 5, 218), false);
        setupMapSpacingAndLand(METAL_CORNER.get(), new StructureSeparationSettings(30, 5, 219), false);
        setupMapSpacingAndLand(PYRAMID_CORNER.get(), new StructureSeparationSettings(30, 5, 220), false);
        setupMapSpacingAndLand(RAZORBACK_CORNER.get(), new StructureSeparationSettings(30, 5, 221), false);

        setupMapSpacingAndLand(COLUMN_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 222), false);
        setupMapSpacingAndLand(DELTA_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 223), false);
        setupMapSpacingAndLand(DUNGEON_PRISONER_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 224), false);
        setupMapSpacingAndLand(EXTRACTION_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 225), false);
        setupMapSpacingAndLand(HEAT_TRAP_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 226), false);
        setupMapSpacingAndLand(HEAT_TRAP_CROSSROADS_ARCANIUM.get(), new StructureSeparationSettings(30, 5, 227), false);
        setupMapSpacingAndLand(HOLLOW_COLUMN_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 228), false);
        setupMapSpacingAndLand(RAMP_CROSSROADS.get(), new StructureSeparationSettings(30, 5, 229), false);

        setupMapSpacingAndLand(DRAMIX_ROOM.get(), new StructureSeparationSettings(30, 5, 230), false);
        setupMapSpacingAndLand(PARASECTA_ROOM.get(), new StructureSeparationSettings(30, 5, 231), false);

        setupMapSpacingAndLand(BANQUET_HALL.get(), new StructureSeparationSettings(30, 5, 232), false);
        setupMapSpacingAndLand(DUNGEON_LIBRARY.get(), new StructureSeparationSettings(30, 5, 233), false);
        setupMapSpacingAndLand(DUNGEON_PRISON.get(), new StructureSeparationSettings(30, 5, 234), false);
        setupMapSpacingAndLand(DUNGEON_PRISON_BROKEN.get(), new StructureSeparationSettings(30, 5, 235), false);
        setupMapSpacingAndLand(HEAT_TRAP_DEAD_END.get(), new StructureSeparationSettings(30, 5, 236), false);
        setupMapSpacingAndLand(HILL_DEAD_END.get(), new StructureSeparationSettings(30, 5, 237), false);
        setupMapSpacingAndLand(LAVA_DEAD_END.get(), new StructureSeparationSettings(30, 5, 238), false);
        setupMapSpacingAndLand(LAVA_DEAD_END_ARCANIUM.get(), new StructureSeparationSettings(30, 5, 239), false);
        setupMapSpacingAndLand(ROAMER_CHAMBER.get(), new StructureSeparationSettings(30, 5, 240), false);

        setupMapSpacingAndLand(DATTICON_WORKSHOP.get(), new StructureSeparationSettings(30, 5, 241), false);
        setupMapSpacingAndLand(KAZARI_ROOM.get(), new StructureSeparationSettings(30, 5, 242), false);
        setupMapSpacingAndLand(LEORNA_HUT.get(), new StructureSeparationSettings(30, 5, 243), false);
        setupMapSpacingAndLand(LORD_VATTICUS_STUDY.get(), new StructureSeparationSettings(30, 5, 244), false);
        setupMapSpacingAndLand(CAPTAIN_MERIK_FORGE.get(), new StructureSeparationSettings(30, 5, 245), false);
        setupMapSpacingAndLand(WAR_GENERAL_CHAMBER.get(), new StructureSeparationSettings(30, 5, 246), false);
        setupMapSpacingAndLand(ZELUS_FARM.get(), new StructureSeparationSettings(30, 5, 247), false);

        setupMapSpacingAndLand(HEAT_TRAP_HALLWAY.get(), new StructureSeparationSettings(30, 5, 248), false);
        setupMapSpacingAndLand(LAVA_HALLWAY.get(), new StructureSeparationSettings(30, 5, 249), false);
        setupMapSpacingAndLand(MAZE_HALLWAY.get(), new StructureSeparationSettings(30, 5, 250), false);
        setupMapSpacingAndLand(PILLAR_HALLWAY.get(), new StructureSeparationSettings(30, 5, 251), false);
        setupMapSpacingAndLand(RAMP_HALLWAY.get(), new StructureSeparationSettings(30, 5, 252), false);
        setupMapSpacingAndLand(SERPENTINE_HALLWAY.get(), new StructureSeparationSettings(30, 5, 253), false);
        setupMapSpacingAndLand(TILED_HALLWAY.get(), new StructureSeparationSettings(30, 5, 254), false);
        setupMapSpacingAndLand(UTILITY_HALLWAY.get(), new StructureSeparationSettings(30, 5, 255), false);
        setupMapSpacingAndLand(V_HALLWAY.get(), new StructureSeparationSettings(30, 5, 256), false);

        setupMapSpacingAndLand(DEGRADED_JUNCTION.get(), new StructureSeparationSettings(30, 5, 257), false);
        setupMapSpacingAndLand(DEGRADED_MAZE_JUNCTION.get(), new StructureSeparationSettings(30, 5, 258), false);
        setupMapSpacingAndLand(HEAT_TRAP_JUNCTION.get(), new StructureSeparationSettings(30, 5, 259), false);
        setupMapSpacingAndLand(MOUND_JUNCTION.get(), new StructureSeparationSettings(30, 5, 260), false);
        setupMapSpacingAndLand(SERPENTINE_JUNCTION.get(), new StructureSeparationSettings(30, 5, 261), false);
        setupMapSpacingAndLand(STAIR_COLUMN_JUNCTION.get(), new StructureSeparationSettings(30, 5, 262), false);
        setupMapSpacingAndLand(TRIDENT_JUNCTION.get(), new StructureSeparationSettings(30, 5, 263), false);
        setupMapSpacingAndLand(UTILITY_ROOM_JUNCTION.get(), new StructureSeparationSettings(30, 5, 264), false);

        setupMapSpacingAndLand(CORNER_PORTAL.get(), new StructureSeparationSettings(30, 5, 265), false);
        setupMapSpacingAndLand(CROSSROADS_PORTAL.get(), new StructureSeparationSettings(30, 5, 266), false);
        setupMapSpacingAndLand(DEAD_END_PORTAL.get(), new StructureSeparationSettings(30, 5, 267), false);
        setupMapSpacingAndLand(HALLWAY_PORTAL.get(), new StructureSeparationSettings(30, 5, 268), false);
        setupMapSpacingAndLand(JUNCTION_PORTAL.get(), new StructureSeparationSettings(30, 5, 269), false);

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

        static IStructurePieceType register(IStructurePieceType piece, String name) {
            return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), piece);
        }
    }
}
