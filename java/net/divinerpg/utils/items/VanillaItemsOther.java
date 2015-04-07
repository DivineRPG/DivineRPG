package net.divinerpg.utils.items;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemModBucket;
import net.divinerpg.items.base.ItemModSeeds;
import net.divinerpg.items.vanilla.ItemCallOfTheWatcher;
import net.divinerpg.items.vanilla.ItemHordeHorn;
import net.divinerpg.items.vanilla.ItemInfernalFlame;
import net.divinerpg.items.vanilla.ItemMysteriousClock;
import net.divinerpg.items.vanilla.ItemTeleportationCrystal;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.item.Item;

public class VanillaItemsOther {

    public static Item rupeeIngot;
    public static Item arlemiteIngot;
    public static Item realmiteIngot;
    public static Item shadowBar;
    public static Item hellstoneIngot;
    public static Item netheriteIngot;
    public static Item bloodgem;

    public static Item jungleShards;
    public static Item divineShards;
    public static Item corruptedShards;
    public static Item moltenShards;
    public static Item enderShard;
    public static Item cyclopsEyeShards;

    public static Item corruptedBullet;

    public static Item jungleStone;
    public static Item divineStone;
    public static Item corruptedStone;
    public static Item moltenStone;
    public static Item enderStone;
    public static Item healingStone;
    public static Item shadowStone;

    public static Item aquaticIngot;
    public static Item aquaticPellets;
    public static Item pureAquaticPellets;
    public static Item cyclopsEye;
    public static Item crabClaw;
    public static Item legendaryEnderEye;
    public static Item sharkFin;
    public static Item whaleFin;
    public static Item netheriteChunk;
    public static Item bluefireStone;
    public static Item purpleBlaze;
    public static Item furyFire;
    public static Item aquaBall;
    public static Item aquaticBlazeRod;

    public static Item greenDiamondChunk;
    public static Item grayDiamondChunk;
    public static Item blueDiamondChunk;
    public static Item redDiamondChunk;
    public static Item yellowDiamondChunk;
    
    public static Item tarBucket;
    
    public static Item mysteriousClock;
    public static Item watchingEye;
    public static Item callWatcher;
    public static Item infernalFlame;
    public static Item hordeHorn;
    
    public static Item mushroomSeeds;
    public static Item tomatoSeeds;
    public static Item krakenSkin;
    public static Item krakenScale;
    
    public static Item teleportationCrystal;

    public static void init() {
    	rupeeIngot         = new ItemMod("rupeeIngot");
        arlemiteIngot      = new ItemMod("arlemiteIngot");
        realmiteIngot      = new ItemMod("realmiteIngot");
        shadowBar          = new ItemMod("shadowBar");
        hellstoneIngot     = new ItemMod("hellstoneIngot");
        netheriteIngot     = new ItemMod("netheriteIngot");
        bloodgem           = new ItemMod("bloodgem");

        jungleShards       = new ItemMod("jungleShards");
        divineShards       = new ItemMod("divineShards");
        corruptedShards    = new ItemMod("corruptedShards");
        moltenShards       = new ItemMod("moltenShards");
        enderShard         = new ItemMod("enderShards");
        cyclopsEyeShards   = new ItemMod("cyclopsEyeShards");

        corruptedBullet    = new ItemMod("corruptedBullet");

        jungleStone        = new ItemMod("jungleStone");
        divineStone        = new ItemMod("divineStone");
        corruptedStone     = new ItemMod("corruptedStone");
        moltenStone        = new ItemMod("moltenStone");
        enderStone         = new ItemMod("enderStone");
        healingStone       = new ItemMod("healingStone").setHealAmount(20);
        shadowStone        = new ItemMod("shadowStone");

        aquaticIngot       = new ItemMod("aquaticIngot");
        aquaticPellets     = new ItemMod("aquaticPellets");
        pureAquaticPellets = new ItemMod("pureAquaticPellets");
        cyclopsEye         = new ItemMod("cyclopsEye");
        crabClaw           = new ItemMod("crabClaw");
        legendaryEnderEye  = new ItemMod("legendaryEnderEye");
        sharkFin           = new ItemMod("sharkFin");
        whaleFin           = new ItemMod("whaleFin");
        netheriteChunk     = new ItemMod("netheriteChunk");
        bluefireStone      = new ItemMod("bluefireStone");
        purpleBlaze        = new ItemMod("purpleBlaze");
        furyFire           = new ItemMod("furyFire");
        aquaBall           = new ItemMod("aquaBall");
        aquaticBlazeRod	   = new ItemMod("aquaticBlazeRod");

        greenDiamondChunk  = new ItemMod("greenDiamondChunk");
        grayDiamondChunk   = new ItemMod("grayDiamondChunk");
        blueDiamondChunk   = new ItemMod("blueDiamondChunk");
        redDiamondChunk  	= new ItemMod("redDiamondChunk");
        yellowDiamondChunk = new ItemMod("yellowDiamondChunk");
        
        tarBucket 			= new ItemModBucket(VanillaBlocks.tar, "bucketOfTar");
        
        mysteriousClock     = new ItemMysteriousClock("mysteriousClock");
        watchingEye        = new ItemMod("watchingEye");
        callWatcher        = new ItemCallOfTheWatcher("callOfTheWatcher");
        infernalFlame      = new ItemInfernalFlame("infernalFlame");
        hordeHorn      	= new ItemHordeHorn("hordeHorn");
        
        mushroomSeeds 		= new ItemModSeeds("whiteMushroomSeeds", (BlockModCrop)VanillaBlocks.mushroom);
        tomatoSeeds 		= new ItemModSeeds("tomatoSeeds", (BlockModCrop)VanillaBlocks.tomato);
        krakenSkin 		= new ItemMod("krakenSkin");
        krakenScale 		= new ItemMod("krakenScale");
        
        teleportationCrystal = new ItemTeleportationCrystal();
    }
    
}