package divinerpg.registry;

import divinerpg.structure.arcana.ArcanaStructureHandler;
import divinerpg.structure.iceika.archerdungeon.ArcherDungeonComponent;
import divinerpg.structure.iceika.archerdungeon.ArcherDungeonStart;
import divinerpg.structure.iceika.rollum.RollumDungeonComponent;
import divinerpg.structure.iceika.rollum.RollumDungeonStart;
import divinerpg.structure.vethea.crypt1.Crypt1Component;
import divinerpg.structure.vethea.crypt1.Crypt1Start;
import divinerpg.structure.vethea.crypt2.Crypt2Component;
import divinerpg.structure.vethea.crypt2.Crypt2Start;
import divinerpg.structure.vethea.evergarden.EvergardenComponent;
import divinerpg.structure.vethea.evergarden.EvergardenStart;
import divinerpg.structure.vethea.hive.HiveComponent;
import divinerpg.structure.vethea.hive.HiveStart;
import divinerpg.structure.vethea.karosmadhouse.KarosMadhouseComponent;
import divinerpg.structure.vethea.karosmadhouse.KarosMadhouseStart;
import divinerpg.structure.vethea.quadroticpost.QuadroticPostComponent;
import divinerpg.structure.vethea.quadroticpost.QuadroticPostStart;
import divinerpg.structure.vethea.raglokchamber.RaglokChamberComponent;
import divinerpg.structure.vethea.raglokchamber.RaglokChamberStart;
import divinerpg.structure.vethea.temple1.Temple1Component;
import divinerpg.structure.vethea.temple1.Temple1Start;
import divinerpg.structure.vethea.temple2.Temple2Component;
import divinerpg.structure.vethea.temple2.Temple2Start;
import divinerpg.structure.vethea.wreckhall.WreckHallComponent;
import divinerpg.structure.vethea.wreckhall.WreckHallStart;
import divinerpg.structure.base.DRPGStructureHandler;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class StructureRegistry {
    public static final DRPGStructureHandler SUNSTORM_DUNGEON = new DRPGStructureHandler("twilight/sunstorm_dungeon");
    public static final DRPGStructureHandler TERMASECT_NEST = new DRPGStructureHandler("twilight/termasect_nest");
    public static final DRPGStructureHandler ETERNAL_ARCHER_DUNGEON = new DRPGStructureHandler("twilight/eternal_archer_dungeon");
    public static final DRPGStructureHandler EXPERIENCED_CORI_DUNGEON = new DRPGStructureHandler("twilight/experienced_cori_dungeon");

    public static final DRPGStructureHandler COALSTONE_LAMP_1 = new DRPGStructureHandler("iceika/lamps/coalstone_lamp_1");
    public static final DRPGStructureHandler COALSTONE_LAMP_2 = new DRPGStructureHandler("iceika/lamps/coalstone_lamp_2");
    public static final DRPGStructureHandler COALSTONE_LAMP_3 = new DRPGStructureHandler("iceika/lamps/coalstone_lamp_3");
    public static final DRPGStructureHandler[] COALSTONE_LAMPS = {COALSTONE_LAMP_1, COALSTONE_LAMP_2, COALSTONE_LAMP_3};

    public static final DRPGStructureHandler WORKSHOP_HOUSE_1 = new DRPGStructureHandler("iceika/houses/workshop_house_1");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_2 = new DRPGStructureHandler("iceika/houses/workshop_house_2");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_3 = new DRPGStructureHandler("iceika/houses/workshop_house_3");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_4 = new DRPGStructureHandler("iceika/houses/workshop_house_4");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_5 = new DRPGStructureHandler("iceika/houses/workshop_house_5");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_6 = new DRPGStructureHandler("iceika/houses/workshop_house_6");
    //public static final DRPGStructureHandler WORKSHOP_LIBRARY = new DRPGStructureHandler("iceika/workshop_library"); //Left out for now because it's too big
    public static final DRPGStructureHandler[] WORKSHOP_HOUSES = {WORKSHOP_HOUSE_1, WORKSHOP_HOUSE_2, WORKSHOP_HOUSE_3, WORKSHOP_HOUSE_4, WORKSHOP_HOUSE_5, WORKSHOP_HOUSE_6};

    public static final DRPGStructureHandler HUNGER_HOUSE_1 = new DRPGStructureHandler("vethea/layer1/houses/hunger_house_1");
    public static final DRPGStructureHandler HUNGER_HOUSE_2 = new DRPGStructureHandler("vethea/layer1/houses/hunger_house_2");
    public static final DRPGStructureHandler HUNGER_HOUSE_3 = new DRPGStructureHandler("vethea/layer1/houses/hunger_house_3");
    public static final DRPGStructureHandler[] HUNGER_HOUSES = {HUNGER_HOUSE_1, HUNGER_HOUSE_2, HUNGER_HOUSE_3};

    //Simple test "rooms" displaying their patterns overhead. Used to ensure the maze algorithm is working properly
    public static final ArcanaStructureHandler CROSSROADS_TEST = new ArcanaStructureHandler("arcana/test/test_crossroads");
    public static final ArcanaStructureHandler CORNER_TEST = new ArcanaStructureHandler("arcana/test/test_corner");
    public static final ArcanaStructureHandler JUNCTION_TEST = new ArcanaStructureHandler("arcana/test/test_junction");
    public static final ArcanaStructureHandler HALLWAY_TEST = new ArcanaStructureHandler( "arcana/test/test_hallway");
    public static final ArcanaStructureHandler DEAD_END_TEST = new ArcanaStructureHandler("arcana/test/test_dead_end");

    //Used to test performance of generating actual rooms
    public static final ArcanaStructureHandler CROSSROADS_GEN_TEST = new ArcanaStructureHandler("arcana/component_06_crossroads");
    public static final ArcanaStructureHandler CORNER_GEN_TEST = new ArcanaStructureHandler("arcana/component_14_redone_corner");
    public static final ArcanaStructureHandler JUNCTION_GEN_TEST = new ArcanaStructureHandler("arcana/component_15_redone");
    public static final ArcanaStructureHandler HALLWAY_GEN_TEST = new ArcanaStructureHandler( "arcana/component_19_redone");
    public static final ArcanaStructureHandler DEAD_END_GEN_TEST = new ArcanaStructureHandler("arcana/component_13_dead_end");

    public static void registerLargeStructures() {
        MapGenStructureIO.registerStructure(Crypt1Start.class, "DRPGCrypt1");
        MapGenStructureIO.registerStructureComponent(Crypt1Component.class, "DRPGCrypt1Component");
        MapGenStructureIO.registerStructure(Crypt2Start.class, "DRPGCrypt2");
        MapGenStructureIO.registerStructureComponent(Crypt2Component.class, "DRPGCrypt2Component");
        MapGenStructureIO.registerStructure(Temple1Start.class, "DRPGTemple1");
        MapGenStructureIO.registerStructureComponent(Temple1Component.class, "DRPGTemple1Component");
        MapGenStructureIO.registerStructure(Temple2Start.class, "DRPGTemple2");
        MapGenStructureIO.registerStructureComponent(Temple2Component.class, "DRPGTemple2Component");
        MapGenStructureIO.registerStructure(HiveStart.class, "DRPGHive");
        MapGenStructureIO.registerStructureComponent(HiveComponent.class, "DRPGHiveComponent");
        MapGenStructureIO.registerStructure(QuadroticPostStart.class, "DRPGQuadroticPost");
        MapGenStructureIO.registerStructureComponent(QuadroticPostComponent.class, "DRPGQuadroticPostComponent");
        MapGenStructureIO.registerStructure(KarosMadhouseStart.class, "DRPGKarosMadhouse");
        MapGenStructureIO.registerStructureComponent(KarosMadhouseComponent.class, "DRPGKarosMadhouseComponent");
        MapGenStructureIO.registerStructure(RaglokChamberStart.class, "DRPGRaglokChamber");
        MapGenStructureIO.registerStructureComponent(RaglokChamberComponent.class, "DRPGRaglokChamberComponent");
        MapGenStructureIO.registerStructure(WreckHallStart.class, "DRPGWreckHall");
        MapGenStructureIO.registerStructureComponent(WreckHallComponent.class, "DRPGWreckHallComponent");
        MapGenStructureIO.registerStructure(EvergardenStart.class, "DRPGEvergarden");
        MapGenStructureIO.registerStructureComponent(EvergardenComponent.class, "DRPGEvergardenComponent");
        MapGenStructureIO.registerStructure(ArcherDungeonStart.class, "DRPGFrostArcherDungeon");
        MapGenStructureIO.registerStructureComponent(ArcherDungeonComponent.class, "DRPGFrostArcherDungeonComponent");
        MapGenStructureIO.registerStructure(RollumDungeonStart.class, "DRPGRollumDungeon");
        MapGenStructureIO.registerStructureComponent(RollumDungeonComponent.class, "DRPGRollumDungeonComponent");
    }



}
