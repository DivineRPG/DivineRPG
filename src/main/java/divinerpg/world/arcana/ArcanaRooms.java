package divinerpg.world.arcana;


import divinerpg.util.*;

import java.util.*;

public class ArcanaRooms {
    private static final WeightedRandom<ArcanaStructureHandler> CORNER_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<ArcanaStructureHandler> CROSSROAD_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<ArcanaStructureHandler> CROSSROAD_BOSS_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<ArcanaStructureHandler> DEAD_END_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<ArcanaStructureHandler> DEAD_END_NPC_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<ArcanaStructureHandler> HALLWAY_ROOMS = new WeightedRandom<>();
    private static final WeightedRandom<ArcanaStructureHandler> JUNCTION_ROOMS = new WeightedRandom<>();
    private static final HashMap<Cell.PieceType, WeightedRandom<ArcanaStructureHandler>> TYPE_MAP = new HashMap<>();
    private static final HashMap<Cell.PieceType, ArcanaStructureHandler> PORTAL_ROOMS = new HashMap<>();

    static {
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/column_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/chained_room_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/delta_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/generic_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/heat_trap_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/living_statue_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/metal_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/pyramid_corner"), 4);
        CORNER_ROOMS.addItem(new ArcanaStructureHandler("arcana/corner/razorback_corner"), 4);

        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/column_crossroads"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/delta_crossroads"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/dungeon_prisoner_crossroads"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/extraction_crossroads"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/heat_trap_crossroads"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/heat_trap_crossroads_arcanium"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/hollow_column_crossroads"), 4);
        CROSSROAD_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/ramp_crossroads"), 4);

        CROSSROAD_BOSS_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/boss/dramix_room"), 4);
        CROSSROAD_BOSS_ROOMS.addItem(new ArcanaStructureHandler("arcana/crossroads/boss/parasecta_room"), 4);

        DEAD_END_ROOMS.addItem(new ArcanaLootRoomHandler("arcana/deadend/banquet_hall"), 4);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/dungeon_library"), 4);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/dungeon_prison"), 4);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/dungeon_prison_broken"), 4);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/heat_trap_dead_end"), 4);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/hill_dead_end"), 4);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/lava_dead_end"), 2);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/lava_dead_end_arcanium"), 1);
        DEAD_END_ROOMS.addItem(new ArcanaStructureHandler("arcana/deadend/roamer_chamber"), 4);

        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/datticon_workshop"), 4);
        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/kazari_room"), 4);
        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/leorna_hut"), 4);
        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/lord_vatticus_study"), 4);
        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/captain_merik_forge"), 4);
        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/war_general_chamber"), 4);
        DEAD_END_NPC_ROOMS.addItem(new ArcanaNPCRoomHandler("arcana/deadend/npc/zelus_farm"), 4);

        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/heat_trap_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/lava_hallway"), 2);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/maze_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/pillar_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/ramp_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/serpentine_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/tiled_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaLootRoomHandler("arcana/hallway/utility_hallway"), 4);
        HALLWAY_ROOMS.addItem(new ArcanaStructureHandler("arcana/hallway/v_hallway"), 4);

        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/degraded_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/degraded_maze_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/heat_trap_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/mound_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/serpentine_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/stair_column_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/trident_junction"), 4);
        JUNCTION_ROOMS.addItem(new ArcanaStructureHandler("arcana/junction/utility_room_junction"), 4);

        TYPE_MAP.put(Cell.PieceType.CORNER, CORNER_ROOMS);
        TYPE_MAP.put(Cell.PieceType.CROSSROADS, CROSSROAD_ROOMS);
        TYPE_MAP.put(Cell.PieceType.DEAD_END, DEAD_END_ROOMS);
        TYPE_MAP.put(Cell.PieceType.HALLWAY, HALLWAY_ROOMS);
        TYPE_MAP.put(Cell.PieceType.JUNCTION, JUNCTION_ROOMS);

        PORTAL_ROOMS.put(Cell.PieceType.CORNER, new ArcanaStructureHandler("arcana/portal/corner_portal"));
        PORTAL_ROOMS.put(Cell.PieceType.CROSSROADS, new ArcanaStructureHandler("arcana/portal/crossroads_portal"));
        PORTAL_ROOMS.put(Cell.PieceType.DEAD_END, new ArcanaStructureHandler("arcana/portal/dead_end_portal"));
        PORTAL_ROOMS.put(Cell.PieceType.HALLWAY, new ArcanaStructureHandler("arcana/portal/hallway_portal"));
        PORTAL_ROOMS.put(Cell.PieceType.JUNCTION, new ArcanaStructureHandler("arcana/portal/junction_portal"));
    }

    public static ArcanaStructureHandler getRandomStructureByType(Random random, Cell.PieceType type) {
        WeightedRandom<ArcanaStructureHandler> weightedRandom;
        if (type == Cell.PieceType.CROSSROADS && random.nextInt(7) == 0) {
            weightedRandom = CROSSROAD_BOSS_ROOMS;
        } else if (type == Cell.PieceType.DEAD_END && random.nextInt(4) == 0) {
            weightedRandom = DEAD_END_NPC_ROOMS;
        } else {
            weightedRandom = TYPE_MAP.get(type);
        }

        return weightedRandom.selectRandomItem(random);
    }

    public static ArcanaStructureHandler getPortalRoomByType(Cell.PieceType type) {
        return PORTAL_ROOMS.get(type);
    }
}