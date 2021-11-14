package divinerpg.world.arcana;


import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.world.gen.feature.structure.*;

import java.util.*;

public class ArcanaRooms {
    private static final WeightedRandom<Structure<?>> CORNER_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<Structure<?>> CROSSROAD_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<Structure<?>> CROSSROAD_BOSS_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<Structure<?>> DEAD_END_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<Structure<?>> DEAD_END_NPC_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<Structure<?>> HALLWAY_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<Structure<?>> JUNCTION_ROOMS = new WeightedRandom<>();
    private static final HashMap<Cell.PieceType, WeightedRandom<Structure<?>>> TYPE_MAP = new HashMap<>();
    private static final HashMap<Cell.PieceType, Structure<?>> PORTAL_ROOMS = new HashMap<>();

    static {
        CORNER_ROOMS.addItem(StructureRegistry.COLUMN_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.CHAINED_ROOM_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.DELTA_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.GENERIC_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.HEAT_TRAP_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.LIVING_STATUE_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.METAL_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.PYRAMID_CORNER.get(), 4);
        CORNER_ROOMS.addItem(StructureRegistry.RAZORBACK_CORNER.get(), 4);

        CROSSROAD_ROOMS.addItem(StructureRegistry.COLUMN_CROSSROADS.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.DELTA_CROSSROADS.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.DUNGEON_PRISONER_CROSSROADS.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.EXTRACTION_CROSSROADS.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.HEAT_TRAP_CROSSROADS.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.HEAT_TRAP_CROSSROADS_ARCANIUM.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.HOLLOW_COLUMN_CROSSROADS.get(), 4);
        CROSSROAD_ROOMS.addItem(StructureRegistry.RAMP_CROSSROADS.get(), 4);

        CROSSROAD_BOSS_ROOMS.addItem(StructureRegistry.DRAMIX_ROOM.get(), 4);
        CROSSROAD_BOSS_ROOMS.addItem(StructureRegistry.PARASECTA_ROOM.get(), 4);

        DEAD_END_ROOMS.addItem(StructureRegistry.BANQUET_HALL.get(), 4);
        DEAD_END_ROOMS.addItem(StructureRegistry.DUNGEON_LIBRARY.get(), 4);
        DEAD_END_ROOMS.addItem(StructureRegistry.DUNGEON_PRISON.get(), 4);
        DEAD_END_ROOMS.addItem(StructureRegistry.DUNGEON_PRISON_BROKEN.get(), 4);
        DEAD_END_ROOMS.addItem(StructureRegistry.HEAT_TRAP_DEAD_END.get(), 4);
        DEAD_END_ROOMS.addItem(StructureRegistry.HILL_DEAD_END.get(), 4);
        DEAD_END_ROOMS.addItem(StructureRegistry.LAVA_DEAD_END.get(), 2);
        DEAD_END_ROOMS.addItem(StructureRegistry.LAVA_DEAD_END_ARCANIUM.get(), 1);
        DEAD_END_ROOMS.addItem(StructureRegistry.ROAMER_CHAMBER.get(), 4);

        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.DATTICON_WORKSHOP.get(), 4);
        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.KAZARI_ROOM.get(), 4);
        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.LEORNA_HUT.get(), 4);
        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.LORD_VATTICUS_STUDY.get(), 4);
        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.CAPTAIN_MERIK_FORGE.get(), 4);
        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.WAR_GENERAL_CHAMBER.get(), 4);
        DEAD_END_NPC_ROOMS.addItem(StructureRegistry.ZELUS_FARM.get(), 4);

        HALLWAY_ROOMS.addItem(StructureRegistry.HEAT_TRAP_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.LAVA_HALLWAY.get(), 2);
        HALLWAY_ROOMS.addItem(StructureRegistry.MAZE_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.PILLAR_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.RAMP_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.SERPENTINE_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.TILED_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.UTILITY_HALLWAY.get(), 4);
        HALLWAY_ROOMS.addItem(StructureRegistry.V_HALLWAY.get(), 4);

        JUNCTION_ROOMS.addItem(StructureRegistry.DEGRADED_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.DEGRADED_MAZE_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.HEAT_TRAP_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.MOUND_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.SERPENTINE_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.STAIR_COLUMN_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.TRIDENT_JUNCTION.get(), 4);
        JUNCTION_ROOMS.addItem(StructureRegistry.UTILITY_ROOM_JUNCTION.get(), 4);

        TYPE_MAP.put(Cell.PieceType.CORNER, CORNER_ROOMS);
        TYPE_MAP.put(Cell.PieceType.CROSSROADS, CROSSROAD_ROOMS);
        TYPE_MAP.put(Cell.PieceType.DEAD_END, DEAD_END_ROOMS);
        TYPE_MAP.put(Cell.PieceType.HALLWAY, HALLWAY_ROOMS);
        TYPE_MAP.put(Cell.PieceType.JUNCTION, JUNCTION_ROOMS);

        PORTAL_ROOMS.put(Cell.PieceType.CORNER, StructureRegistry.CORNER_PORTAL.get());
        PORTAL_ROOMS.put(Cell.PieceType.CROSSROADS, StructureRegistry.CROSSROADS_PORTAL.get());
        PORTAL_ROOMS.put(Cell.PieceType.DEAD_END, StructureRegistry.DEAD_END_PORTAL.get());
        PORTAL_ROOMS.put(Cell.PieceType.HALLWAY, StructureRegistry.HALLWAY_PORTAL.get());
        PORTAL_ROOMS.put(Cell.PieceType.JUNCTION, StructureRegistry.JUNCTION_PORTAL.get());
    }

    public static Structure<?> getRandomStructureByType(Random random, Cell.PieceType type) {
        WeightedRandom<Structure<?>> weightedRandom;
        if (type == Cell.PieceType.CROSSROADS && random.nextInt(7) == 0) {
            weightedRandom = CROSSROAD_BOSS_ROOMS;
        } else if (type == Cell.PieceType.DEAD_END && random.nextInt(4) == 0) {
            weightedRandom = DEAD_END_NPC_ROOMS;
        } else {
            weightedRandom = TYPE_MAP.get(type);
        }

        return weightedRandom.selectRandomItem(random);
    }

    public static Structure<?> getPortalRoomByType(Cell.PieceType type) {
        return PORTAL_ROOMS.get(type);
    }
}