package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.twilight.ItemTwilightClock;
import net.divinerpg.items.twilight.ItemTwilightSeeds;
import net.divinerpg.items.twilight.ItemTwilightSpawner;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
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

    public static Item baseSpawnCrystal;
    public static Item densosCrystal;
    public static Item karotCrystal;
    public static Item reyvorCrystal;
    public static Item soulFiendCrystal;
    public static Item twilightDemonCrystal;
    public static Item vamacheronCrystal;
    public static Item eternalArcherCrystal;
    
    public static void init() {
    	edenSoul            = new ItemMod("edenSoul");
        wildwoodSoul        = new ItemMod("wildwoodSoul");
        apalachiaSoul       = new ItemMod("apalachiaSoul");
        skythernSoul        = new ItemMod("skythernSoul");
        mortumSoul          = new ItemMod("mortumSoul");

        edenFragments       = new ItemMod("edenFragments");
        wildwoodFragments   = new ItemMod("wildwoodFragments");
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
        wildwoodDust        = new ItemMod("wildwoodDust");
        apalachiaDust       = new ItemMod("apalachiaDust");
        skythernDust        = new ItemMod("skythernDust");
        mortumDust          = new ItemMod("mortumDust");

        twilightClock 		= new ItemTwilightClock("twilightClock");

        edenSparkles	    = new ItemMod("edenSparkles");

        baseSpawnCrystal 	= new ItemMod("baseSpawnCrystal");
        densosCrystal 		= new ItemTwilightSpawner("densosCrystal");
        karotCrystal 		= new ItemTwilightSpawner("karotCrystal");
        reyvorCrystal 		= new ItemTwilightSpawner("reyvorCrystal");
        soulFiendCrystal	= new ItemTwilightSpawner("soulFiendCrystal");
        twilightDemonCrystal= new ItemTwilightSpawner("twilightDemonCrystal");
        vamacheronCrystal	= new ItemTwilightSpawner("vamacheronCrystal");
        eternalArcherCrystal= new ItemTwilightSpawner("eternalArcherCrystal");
    }
    
}