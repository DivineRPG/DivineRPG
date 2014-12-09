package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModGrass;
import net.divinerpg.api.blocks.BlockModLeaves;
import net.divinerpg.api.blocks.BlockModLog;
import net.divinerpg.api.blocks.BlockModTorch;
import net.divinerpg.api.blocks.BlockModVine;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.blocks.twilight.BlockBlueFire;
import net.divinerpg.blocks.twilight.BlockTwilightFurnace;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;

public class TwilightBlocks {

    public static Block edenDirt;
    public static Block wildwoodDirt;
    public static Block apalachiaDirt;
    public static Block skythernDirt;
    public static Block mortumDirt;
    public static Block edenGrass;
    public static Block wildwoodGrass;
    public static Block apalachiaGrass;
    public static Block skythernGrass;
    public static Block mortumGrass;

    public static Block edenOre;
    public static Block wildwoodOre;
    public static Block apalachiaOre;
    public static Block skythernOre;
    public static Block mortumOre;

    public static Block edenBlock;
    public static Block wildwoodBlock;
    public static Block apalachiaBlock;
    public static Block skythernBlock;
    public static Block mortumBlock;

    public static Block edenLeaves;
    public static Block wildwoodLeaves;
    public static Block apalachiaLeaves;
    public static Block skythernLeaves;
    public static Block mortumLeaves;

    public static Block edenLogs;
    public static Block wildwoodLogs;
    public static Block apalachiaLogs;
    public static Block skythernLogs;
    public static Block mortumLogs;

    public static Block twilightStone;
    public static Block wildwoodVine;
    public static Block blueFire;
    public static Block edenPortal;
    public static Block wildwoodPortal;
    public static Block apalachiaPortal;
    public static Block skythernPortal;
    public static Block mortumPortal;
    public static Block twilightFurnace;
    public static Block twilightFurnaceOn;
    
    public static Block edenTorch;
    
    public static void init() {
    	edenDirt          = new BlockMod(EnumBlockType.DIRT, "edenDirt", 5.0F);
        wildwoodDirt      = new BlockMod(EnumBlockType.DIRT, "wildwoodDirt", 5.0F);
        apalachiaDirt     = new BlockMod(EnumBlockType.DIRT, "apalachiaDirt", 5.0F);
        skythernDirt      = new BlockMod(EnumBlockType.DIRT, "skythernDirt", 5.0F);
        mortumDirt        = new BlockMod(EnumBlockType.DIRT, "mortumDirt", 5.0F);
        edenGrass         = new BlockModGrass((BlockMod) edenDirt, "edenGrass", 5.0F);
        wildwoodGrass     = new BlockModGrass((BlockMod) wildwoodDirt, "wildwoodGrass", 5.0F);
        apalachiaGrass    = new BlockModGrass((BlockMod) apalachiaDirt, "apalachiaGrass", 5.0F);
        skythernGrass     = new BlockModGrass((BlockMod) skythernDirt, "skythernGrass", 5.0F);
        mortumGrass       = new BlockModGrass((BlockMod) mortumDirt, "mortumGrass", 5.0F);

        edenOre           = new BlockMod("edenOre", 9).toggleExp(true).setTwilightOre(true).setDropItem(TwilightItemsOther.edenFragments);
        wildwoodOre       = new BlockMod("wildwoodOre", 9).setTwilightOre(true).setDropItem(TwilightItemsOther.wildwoodFragments);
        apalachiaOre      = new BlockMod("apalachiaOre", 9).setTwilightOre(true).setDropItem(TwilightItemsOther.apalachiaFragments);
        skythernOre       = new BlockMod("skythernOre", 9).setTwilightOre(true).setDropItem(TwilightItemsOther.skythernFragments);
        mortumOre         = new BlockMod("mortumOre", 9).setTwilightOre(true).setDropItem(TwilightItemsOther.mortumFragments);

        edenBlock         = new BlockMod("edenBlock", 9);
        wildwoodBlock     = new BlockMod("wildwoodBlock", 9);
        apalachiaBlock    = new BlockMod("apalachiaBlock", 9);
        skythernBlock     = new BlockMod("skythernBlock", 9);
        mortumBlock       = new BlockMod("mortumBlock", 9);

        edenLeaves        = new BlockModLeaves("edenLeaves", 0.5F);
        wildwoodLeaves    = new BlockModLeaves("wildwoodLeaves", 0.5F);
        apalachiaLeaves   = new BlockModLeaves("apalachiaLeaves", 0.5F).setLightLevel(0.5F);
        skythernLeaves    = new BlockModLeaves("skythernLeaves", 0.5F);
        mortumLeaves      = new BlockModLeaves("mortumLeaves", 0.5F);

        edenLogs          = new BlockModLog("edenLog");
        wildwoodLogs      = new BlockModLog("wildwoodLog");
        apalachiaLogs     = new BlockModLog("apalachiaLog");
        skythernLogs      = new BlockModLog("skythernLog");
        mortumLogs        = new BlockModLog("mortumLog");

        twilightStone     = new BlockMod("twilightStone", 6.0F);
        wildwoodVine     = new BlockModVine("wildwoodVine");
        blueFire          = new BlockBlueFire("blueFire");
        edenPortal        = new BlockModPortal("edenPortal", ConfigurationHelper.eden, blueFire, VanillaBlocks.divineRock);
        wildwoodPortal    = new BlockModPortal("wildwoodPortal", ConfigurationHelper.wildwood, blueFire, edenBlock);
        apalachiaPortal   = new BlockModPortal("apalachiaPortal", ConfigurationHelper.apalachia, blueFire, wildwoodBlock);
        skythernPortal    = new BlockModPortal("skythernPortal", ConfigurationHelper.skythern, blueFire, apalachiaBlock);
        mortumPortal      = new BlockModPortal("mortumPortal", ConfigurationHelper.mortum, blueFire, skythernBlock);
        twilightFurnace   = new BlockTwilightFurnace("twilightFurnace", false);
        twilightFurnaceOn = new BlockTwilightFurnace("twilightFurnaceOn", true);
        
        edenTorch		  = new BlockModTorch("edenTorch", "greenFlame");
    }

}
