package net.divinerpg.utils.items;

import net.divinerpg.blocks.base.BlockModCrop;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemModBucket;
import net.divinerpg.items.base.ItemModSeeds;
import net.divinerpg.items.vanilla.ItemCallOfTheWatcher;
import net.divinerpg.items.vanilla.ItemGrizzleEgg;
import net.divinerpg.items.vanilla.ItemHordeHorn;
import net.divinerpg.items.vanilla.ItemInfernalFlame;
import net.divinerpg.items.vanilla.ItemMysteriousClock;
import net.divinerpg.items.vanilla.ItemTeleportationCrystal;
import net.divinerpg.items.vanilla.ItemVanillaSpawnEgg;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.minecraft.item.Item;

public class VanillaItemsOther {

    public static Item rupeeIngot     = new ItemMod("rupeeIngot");
    public static Item arlemiteIngot  = new ItemMod("arlemiteIngot");
    public static Item realmiteIngot  = new ItemMod("realmiteIngot");
    public static Item shadowBar      = new ItemMod("shadowBar");
    public static Item hellstoneIngot = new ItemMod("hellstoneIngot");
    public static Item netheriteIngot = new ItemMod("netheriteIngot");
    public static Item bloodgem       = new ItemMod("bloodgem");

    public static Item jungleShards     = new ItemMod("jungleShards");
    public static Item divineShards     = new ItemMod("divineShards");
    public static Item corruptedShards  = new ItemMod("corruptedShards");
    public static Item moltenShards     = new ItemMod("moltenShards");
    public static Item enderShards      = new ItemMod("enderShards");
    public static Item terranShards     = new ItemMod("terranShards");
    public static Item cyclopsEyeShards = new ItemMod("cyclopsEyeShards");

    public static Item corruptedBullet = new ItemMod("corruptedBullet");

    public static Item jungleStone    = new ItemMod("jungleStone");
    public static Item divineStone    = new ItemMod("divineStone");
    public static Item corruptedStone = new ItemMod("corruptedStone");
    public static Item moltenStone    = new ItemMod("moltenStone");
    public static Item enderStone     = new ItemMod("enderStone");
    public static Item terranStone    = new ItemMod("terranStone");
    public static Item healingStone   = new ItemMod("healingStone").setHealAmount(20);
    public static Item shadowStone    = new ItemMod("shadowStone");

    public static Item aquaticIngot       = new ItemMod("aquaticIngot");
    public static Item aquaticPellets     = new ItemMod("aquaticPellets");
    public static Item pureAquaticPellets = new ItemMod("pureAquaticPellets");
    public static Item cyclopsEye         = new ItemMod("cyclopsEye");
    public static Item crabClaw           = new ItemMod("crabClaw");
    public static Item legendaryEnderEye  = new ItemMod("legendaryEnderEye");
    public static Item sharkFin           = new ItemMod("sharkFin");
    public static Item whaleFin           = new ItemMod("whaleFin");
    public static Item liopleurodonSkull  = new ItemMod("liopleurodonSkull");
    public static Item liopleurodonTeeth  = new ItemMod("liopleurodonTeeth");
    public static Item netheriteChunk     = new ItemMod("netheriteChunk");
    public static Item bluefireStone      = new ItemMod("bluefireStone");
    public static Item purpleBlaze        = new ItemMod("purpleBlaze");
    public static Item furyFire           = new ItemMod("furyFire");
    public static Item aquaBall           = new ItemMod("aquaBall");
    public static Item aquaticBlazeRod    = new ItemMod("aquaticBlazeRod");
    public static Item shadowCoins        = new ItemMod("shadowCoins");

    public static Item overworldEgg = new ItemVanillaSpawnEgg();
    public static Item grizzleEgg   = new ItemGrizzleEgg();

    public static Item greenDiamondChunk  = new ItemMod("greenDiamondChunk");
    public static Item grayDiamondChunk   = new ItemMod("grayDiamondChunk");
    public static Item blueDiamondChunk   = new ItemMod("blueDiamondChunk");
    public static Item redDiamondChunk    = new ItemMod("redDiamondChunk");
    public static Item yellowDiamondChunk = new ItemMod("yellowDiamondChunk");

    public static Item tarBucket = new ItemModBucket(VanillaBlocks.tar, "bucketOfTar");

    public static Item mysteriousClock = new ItemMysteriousClock("mysteriousClock");
    public static Item watchingEye     = new ItemMod("watchingEye");
    public static Item callWatcher     = new ItemCallOfTheWatcher("callOfTheWatcher");
    public static Item infernalFlame   = new ItemInfernalFlame("infernalFlame");
    public static Item hordeHorn       = new ItemHordeHorn("hordeHorn");

    public static Item mushroomSeeds = new ItemModSeeds("whiteMushroomSeeds", (BlockModCrop) VanillaBlocks.mushroom);
    public static Item tomatoSeeds   = new ItemModSeeds("tomatoSeeds", (BlockModCrop) VanillaBlocks.tomato);
    public static Item krakenSkin    = new ItemMod("krakenSkin");
    public static Item krakenScale   = new ItemMod("krakenScale");

    public static Item teleportationCrystal = new ItemTeleportationCrystal();

    public static void init() {}

}
