package divinerpg.registry;

import divinerpg.structure.iceika.archerdungeon.*;
import divinerpg.structure.iceika.rollum.*;
import divinerpg.structure.vethea.crypt1.*;
import divinerpg.structure.vethea.crypt2.*;
import divinerpg.structure.vethea.evergarden.*;
import divinerpg.structure.vethea.hive.*;
import divinerpg.structure.vethea.karosmadhouse.*;
import divinerpg.structure.vethea.quadroticpost.*;
import divinerpg.structure.vethea.raglokchamber.*;
import divinerpg.structure.vethea.temple1.*;
import divinerpg.structure.vethea.temple2.*;
import divinerpg.structure.vethea.wreckhall.*;
import divinerpg.structure.base.DRPGStructureHandler;
import net.minecraft.world.gen.structure.MapGenStructureIO;

import java.util.ArrayList;
import java.util.List;

public class StructureRegistry {

    //Arcana structures are in ArcanaRooms

	//Eden
    public static final DRPGStructureHandler SUNSTORM_DUNGEON = new DRPGStructureHandler("twilight/eden/sunstorm_dungeon");
    public static final DRPGStructureHandler BROKEN_EDEN_PORTAL = new DRPGStructureHandler("twilight/eden/broken_eden_portal");
    public static final DRPGStructureHandler EDEN_PILLAR1 = new DRPGStructureHandler("twilight/eden/eden_pillar1");
    public static final DRPGStructureHandler EDEN_PILLAR2 = new DRPGStructureHandler("twilight/eden/eden_pillar2");
    public static final DRPGStructureHandler EDEN_PILLAR3 = new DRPGStructureHandler("twilight/eden/eden_pillar3");
    public static final List<DRPGStructureHandler> EDEN_SMALL_STRUCTURES = new ArrayList<DRPGStructureHandler>();
    static {
        EDEN_SMALL_STRUCTURES.add(BROKEN_EDEN_PORTAL);
        EDEN_SMALL_STRUCTURES.add(EDEN_PILLAR1);
        EDEN_SMALL_STRUCTURES.add(EDEN_PILLAR2);
        EDEN_SMALL_STRUCTURES.add(EDEN_PILLAR3);
    }

    //Wildwood
    public static final DRPGStructureHandler TERMASECT_NEST = new DRPGStructureHandler("twilight/wildwood/termasect_nest");
    public static final DRPGStructureHandler WILDWOOD_TREEHOUSE = new DRPGStructureHandler("twilight/wildwood/wildwood_treehouse");
    public static final DRPGStructureHandler WILDWOOD_PILLAR1 = new DRPGStructureHandler("twilight/wildwood/wildwood_pillar1");
    public static final DRPGStructureHandler WILDWOOD_PILLAR2 = new DRPGStructureHandler("twilight/wildwood/wildwood_pillar2");
    public static final DRPGStructureHandler WILDWOOD_HOUSE = new DRPGStructureHandler("twilight/wildwood/wildwood_house");
    public static final List<DRPGStructureHandler> WILDWOOD_SMALL_STRUCTURES = new ArrayList<DRPGStructureHandler>();
    static {
        WILDWOOD_SMALL_STRUCTURES.add(WILDWOOD_TREEHOUSE);
        WILDWOOD_SMALL_STRUCTURES.add(WILDWOOD_PILLAR1);
        WILDWOOD_SMALL_STRUCTURES.add(WILDWOOD_PILLAR2);
        WILDWOOD_SMALL_STRUCTURES.add(WILDWOOD_HOUSE);
    }

    //Apalachia
    public static final DRPGStructureHandler ETERNAL_ARCHER_DUNGEON = new DRPGStructureHandler("twilight/apalachia/eternal_archer_dungeon");
    public static final DRPGStructureHandler APALACHIA_PILLAR1 = new DRPGStructureHandler("twilight/apalachia/apalachia_pillar1");
    public static final DRPGStructureHandler APALACHIA_PILLAR2 = new DRPGStructureHandler("twilight/apalachia/apalachia_pillar2");
    public static final DRPGStructureHandler APALACHIA_PILLAR3 = new DRPGStructureHandler("twilight/apalachia/apalachia_pillar3");
    public static final DRPGStructureHandler APALACHIA_FALLEN_LOG = new DRPGStructureHandler("twilight/apalachia/apalachia_fallen_log");
    public static final List<DRPGStructureHandler> APALACHIA_SMALL_STRUCTURES = new ArrayList<DRPGStructureHandler>();
    static {
        APALACHIA_SMALL_STRUCTURES.add(APALACHIA_PILLAR1);
        APALACHIA_SMALL_STRUCTURES.add(APALACHIA_PILLAR2);
        APALACHIA_SMALL_STRUCTURES.add(APALACHIA_PILLAR3);
        APALACHIA_SMALL_STRUCTURES.add(APALACHIA_FALLEN_LOG);
    }


    //Skythern
    public static final DRPGStructureHandler EXPERIENCED_CORI_DUNGEON = new DRPGStructureHandler("twilight/skythern/experienced_cori_dungeon");
    public static final DRPGStructureHandler SKYTHERN_PILLAR1 = new DRPGStructureHandler("twilight/skythern/skythern_pillar1");
    public static final DRPGStructureHandler SKYTHERN_PILLAR2 = new DRPGStructureHandler("twilight/skythern/skythern_pillar2");
    public static final DRPGStructureHandler SKYTHERN_FALLEN_LOG1 = new DRPGStructureHandler("twilight/skythern/skythern_fallen_log1");
    public static final DRPGStructureHandler SKYTHERN_FALLEN_LOG2 = new DRPGStructureHandler("twilight/skythern/skythern_fallen_log2");
    
    public static final List<DRPGStructureHandler> SKYTHERN_SMALL_STRUCTURES = new ArrayList<DRPGStructureHandler>();
    static {
        SKYTHERN_SMALL_STRUCTURES.add(SKYTHERN_PILLAR1);
        SKYTHERN_SMALL_STRUCTURES.add(SKYTHERN_PILLAR2);
        SKYTHERN_SMALL_STRUCTURES.add(SKYTHERN_FALLEN_LOG1);
        SKYTHERN_SMALL_STRUCTURES.add(SKYTHERN_FALLEN_LOG2);
    }
    //Mortum
    public static final List<DRPGStructureHandler> MORTUM_SMALL_STRUCTURES = new ArrayList<DRPGStructureHandler>();
    public static final DRPGStructureHandler MORTUM_PILLAR1 = new DRPGStructureHandler("twilight/mortum/mortum_pillar1");
    public static final DRPGStructureHandler MORTUM_PILLAR2 = new DRPGStructureHandler("twilight/mortum/mortum_pillar2");
    public static final DRPGStructureHandler MORTUM_PILLAR3 = new DRPGStructureHandler("twilight/mortum/mortum_pillar3");
    public static final DRPGStructureHandler MORTUM_HUT = new DRPGStructureHandler("twilight/mortum/mortum_hut");
    
    static {
        MORTUM_SMALL_STRUCTURES.add(MORTUM_PILLAR1);
        MORTUM_SMALL_STRUCTURES.add(MORTUM_PILLAR2);
        MORTUM_SMALL_STRUCTURES.add(MORTUM_PILLAR3);
        MORTUM_SMALL_STRUCTURES.add(MORTUM_HUT);
  }


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
