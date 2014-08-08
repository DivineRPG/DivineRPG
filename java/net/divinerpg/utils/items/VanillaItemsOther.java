package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBucket;
import net.divinerpg.api.items.ItemModSeeds;
import net.divinerpg.items.vanilla.ItemHordeHorn;
import net.divinerpg.items.vanilla.ItemMysteriousClock;
import net.divinerpg.items.vanilla.ItemVanillaSpawner;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.item.Item;

public class VanillaItemsOther {


    public static final Item rupeeIngot         = new ItemMod("rupeeIngot");
    public static final Item arlemiteIngot      = new ItemMod("arlemiteIngot");
    public static final Item realmiteIngot      = new ItemMod("realmiteIngot");
    public static final Item shadowBar          = new ItemMod("shadowBar");
    public static final Item hellstoneIngot     = new ItemMod("hellstoneIngot");
    public static final Item netheriteIngot     = new ItemMod("netheriteIngot");
    public static final Item bloodgem           = new ItemMod("bloodgem");

    public static final Item jungleShards       = new ItemMod("jungleShards");
    public static final Item divineShards       = new ItemMod("divineShards");
    public static final Item corruptedShards    = new ItemMod("corruptedShards");
    public static final Item moltenShards       = new ItemMod("moltenShards");
    public static final Item enderShard         = new ItemMod("enderShards");
    public static final Item cyclopsEyeShards   = new ItemMod("cyclopsEyeShards");

    public static final Item jungleStone        = new ItemMod("jungleStone");
    public static final Item divineStone        = new ItemMod("divineStone");
    public static final Item corruptedStone     = new ItemMod("corruptedStone");
    public static final Item moltenStone        = new ItemMod("moltenStone");
    public static final Item enderStone         = new ItemMod("enderStone");
    public static final Item healingStone       = new ItemMod("healingStone").setHealAmount(10);

    public static final Item aquaticIngot       = new ItemMod("aquaticIngot");
    public static final Item aquaticPellets     = new ItemMod("aquaticPellets");
    public static final Item pureAquaticPellets = new ItemMod("pureAquaticPellets");
    public static final Item cyclopsEye         = new ItemMod("cyclopsEye");
    public static final Item crabClaw           = new ItemMod("crabClaw");
    public static final Item legendaryEnderEye  = new ItemMod("legendaryEnderEye");
    public static final Item sharkFin           = new ItemMod("sharkFin");
    public static final Item whaleFin           = new ItemMod("whaleFin");
    public static final Item netheriteChunk     = new ItemMod("netheriteChunk");
    public static final Item bluefireStone      = new ItemMod("bluefireStone");
    public static final Item purpleBlaze        = new ItemMod("purpleBlaze");
    public static final Item furyFire           = new ItemMod("furyFire");

    public static final Item greenDiamondChunk  = new ItemMod("greenDiamondChunk");
    public static final Item grayDiamondChunk   = new ItemMod("grayDiamondChunk");
    public static final Item blueDiamondChunk   = new ItemMod("blueDiamondChunk");
    public static final Item redDiamondChunk  	= new ItemMod("redDiamondChunk");
    public static final Item yellowDiamondChunk = new ItemMod("yellowDiamondChunk");
    
    public static final Item tarBucket 			= new ItemModBucket(VanillaBlocks.tar, "bucketOfTar");
    
    public static final Item myseriousClock     = new ItemMysteriousClock("mysteriousClock");
    public static final Item watchingEye        = new ItemMod("watchingEye");
    public static final Item callWatcher        = new ItemVanillaSpawner("callOfTheWatcher");
    public static final Item infernalFlame      = new ItemVanillaSpawner("infernalFlame");
    public static final Item hordeHorn      	= new ItemHordeHorn("hordeHorn");
    
    public static final Item mushroomSeeds 		= new ItemModSeeds("mushroomSeeds", VanillaBlocks.mushroom);
    public static final Item tomatoSeeds 		= new ItemModSeeds("tomatoSeeds", VanillaBlocks.tomato);
    public static final Item krakenSkin 		= new ItemMod("krakenSkin");
    public static final Item krakenScale 		= new ItemMod("krakenScale");
    
}