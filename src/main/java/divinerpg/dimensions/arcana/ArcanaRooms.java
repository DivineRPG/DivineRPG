package divinerpg.dimensions.arcana;

import divinerpg.capabilities.arcana.Arcana;
import divinerpg.structure.arcana.ArcanaStructureHandler;
import divinerpg.utils.WeightedRandom;

public class ArcanaRooms {
    public static WeightedRandom<ArcanaStructureHandler> CORNER_ROOMS = new WeightedRandom<>();
    public static WeightedRandom<ArcanaStructureHandler> CROSSROAD_ROOMS = new WeightedRandom<>();
    public static WeightedRandom<ArcanaStructureHandler> DEAD_END_ROOMS = new WeightedRandom<>();
    public static WeightedRandom<ArcanaStructureHandler> HALLWAY_ROOMS = new WeightedRandom<>();
    public static WeightedRandom<ArcanaStructureHandler> JUNCTION_ROOMS = new WeightedRandom<>();
}
