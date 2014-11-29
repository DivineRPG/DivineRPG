package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.items.twilight.ItemTwilightClock;
import net.divinerpg.items.twilight.ItemTwilightSpawner;
import net.minecraft.item.Item;

public class TwilightItemsOther {

    public static Item edenSoul;
    public static Item wildwoodSoul;
    public static Item apalachiaSoul;
    public static Item skythernSoul;
    public static Item mortumSoul;

    public static Item edenFragments;
    public static Item wildwoodFragments;
    public static Item apalachiaFragments;
    public static Item skythernFragments;
    public static Item mortumFragments;

    public static Item edenGem;
    public static Item wildwoodGem;
    public static Item apalachiaGem;
    public static Item skythernGem;
    public static Item mortumGem;

    public static Item edenChunk;
    public static Item wildwoodChunk;
    public static Item apalachiaChunk;
    public static Item skythernChunk;
    public static Item mortumChunk;

    public static Item edenDust;
    public static Item wildwoodDust;
    public static Item apalachiaDust;
    public static Item skythernDust;
    public static Item mortumDust;

    public static Item twilightClock;

    public static Item edenSparkles;

    public static Item spawnerBase;
    public static Item spawnDensos;
    public static Item spawnKarot;
    public static Item spawnReyvor;
    public static Item spawnSoulFiend;
    public static Item spawnTwilight;
    public static Item spawnVamacheron;
    
    public static void init() {
    	edenSoul            = new ItemMod("edenSoul");
        wildwoodSoul        = new ItemMod("wildWoodSoul");
        apalachiaSoul       = new ItemMod("apalachiaSoul");
        skythernSoul        = new ItemMod("skythernSoul");
        mortumSoul          = new ItemMod("mortumSoul");

        edenFragments       = new ItemMod("edenFragments");
        wildwoodFragments   = new ItemMod("wildWoodFragments");
        apalachiaFragments  = new ItemMod("apalachiaFragments");
        skythernFragments   = new ItemMod("skythernFragments");
        mortumFragments     = new ItemMod("mortumFragments");

        edenGem             = new ItemMod("edenGem");
        wildwoodGem         = new ItemMod("wildwoodGem");
        apalachiaGem        = new ItemMod("apalachiaGem");
        skythernGem         = new ItemMod("skythernGem");
        mortumGem           = new ItemMod("mortumGem");

        edenChunk           = new ItemMod("edenChunk");
        wildwoodChunk       = new ItemMod("wildwoodChunk");
        apalachiaChunk      = new ItemMod("apalachiaChunk");
        skythernChunk       = new ItemMod("skythernChunk");
        mortumChunk         = new ItemMod("mortumChunk");

        edenDust            = new ItemMod("edenDust");
        wildwoodDust        = new ItemMod("wildWoodDust");
        apalachiaDust       = new ItemMod("apalachiaDust");
        skythernDust        = new ItemMod("skythernDust");
        mortumDust          = new ItemMod("mortumDust");

        twilightClock 		= new ItemTwilightClock("twilightClock");

        edenSparkles	    = new ItemMod("edenSparkles");

        spawnerBase 		= new ItemMod("spawnerBase");
        spawnDensos 		= new ItemTwilightSpawner("spawnDensos");
        spawnKarot 			= new ItemTwilightSpawner("spawnKarot");
        spawnReyvor 		= new ItemTwilightSpawner("spawnReyvor");
        spawnSoulFiend		= new ItemTwilightSpawner("spawnSoulFiend");
        spawnTwilight 		= new ItemTwilightSpawner("spawnTwilightDemon");
        spawnVamacheron		= new ItemTwilightSpawner("spawnVamacheron");
    }
    
}