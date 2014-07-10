package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModGrass;
import net.divinerpg.api.blocks.BlockModLeaves;
import net.divinerpg.api.blocks.BlockModLog;
import net.divinerpg.api.blocks.BlockModVine;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.blocks.twilight.BlockBlueFire;
import net.divinerpg.blocks.twilight.BlockTwilightFurnace;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;

public class TwilightBlocks {

    public static final Block edenDirt          = new BlockMod(EnumBlockType.DIRT, "edenDirt", 5.0F);
    public static final Block wildWoodDirt      = new BlockMod(EnumBlockType.DIRT, "wildWoodDirt", 5.0F);
    public static final Block apalachiaDirt     = new BlockMod(EnumBlockType.DIRT, "apalachiaDirt", 5.0F);
    public static final Block skythernDirt      = new BlockMod(EnumBlockType.DIRT, "skythernDirt", 5.0F);
    public static final Block mortumDirt        = new BlockMod(EnumBlockType.DIRT, "mortumDirt", 5.0F);
    public static final Block edenGrass         = new BlockModGrass((BlockMod) edenDirt, "edenGrass", 5.0F);
    public static final Block wildWoodGrass     = new BlockModGrass((BlockMod) wildWoodDirt, "wildWoodGrass", 5.0F);
    public static final Block apalachiaGrass    = new BlockModGrass((BlockMod) apalachiaDirt, "apalachiaGrass", 5.0F);
    public static final Block skythernGrass     = new BlockModGrass((BlockMod) skythernDirt, "skythernGrass", 5.0F);
    public static final Block mortumGrass       = new BlockModGrass((BlockMod) mortumDirt, "mortumGrass", 5.0F);

    public static final Block edenOre           = new BlockMod("edenOre", 9).toggleExp(true).setTwilightOre(true);
    public static final Block wildWoodOre       = new BlockMod("wildWoodOre", 9).setTwilightOre(true);
    public static final Block apalachiaOre      = new BlockMod("apalachiaOre", 9).setTwilightOre(true);
    public static final Block skythernOre       = new BlockMod("skythernOre", 9).setTwilightOre(true);
    public static final Block mortumOre         = new BlockMod("mortumOre", 9).setTwilightOre(true);

    public static final Block edenBlock         = new BlockMod("edenBlock", 9);
    public static final Block wildwoodBlock     = new BlockMod("wildwoodBlock", 9);
    public static final Block apalachiaBlock    = new BlockMod("apalachiaBlock", 9);
    public static final Block skythernBlock     = new BlockMod("skythernBlock", 9);
    public static final Block mortumBlock       = new BlockMod("mortumBlock", 9);

    public static final Block edenLeaves        = new BlockModLeaves("edenLeaves", 0.5F);
    public static final Block wildWoodLeaves    = new BlockModLeaves("wildWoodLeaves", 0.5F);
    public static final Block apalachiaLeaves   = new BlockModLeaves("apalachiaLeaves", 0.5F).setLightLevel(0.5F);
    public static final Block skythernLeaves    = new BlockModLeaves("skythernLeaves", 0.5F);
    public static final Block mortumLeaves      = new BlockModLeaves("mortumLeaves", 0.5F);

    public static final Block edenLogs          = new BlockModLog("edenLog");
    public static final Block wildWoodLogs      = new BlockModLog("wildWoodLog");
    public static final Block apalachiaLogs     = new BlockModLog("apalachiaLog");
    public static final Block skythernLogs      = new BlockModLog("skythernLog");
    public static final Block mortumLogs        = new BlockModLog("mortumLog");

    public static final Block twilightStone     = new BlockMod("twilightStone", 6.0F);
    public static final Block wildWoodsVine     = new BlockModVine("wildWoodsVine");
    public static final Block blueFire          = new BlockBlueFire("blueFire");
    public static final Block edenPortal        = new BlockModPortal("edenPortal", ConfigurationHelper.eden, blueFire, VanillaBlocks.divineRock);
    public static final Block wildwoodPortal    = new BlockModPortal("wildwoodPortal", ConfigurationHelper.wildwood, blueFire, edenBlock);
    public static final Block apalachiaPortal   = new BlockModPortal("apalachiaPortal", ConfigurationHelper.apalachia, blueFire, wildwoodBlock);
    public static final Block skythernPortal    = new BlockModPortal("skythernPortal", ConfigurationHelper.skythern, blueFire, apalachiaBlock);
    public static final Block mortumPortal      = new BlockModPortal("mortumPortal", ConfigurationHelper.mortum, blueFire, skythernBlock);
    public static final Block twilightFurnace   = new BlockTwilightFurnace("twilightFurnace", false);
    public static final Block twilightFurnaceOn = new BlockTwilightFurnace("twilightFurnaceOn", true);

}
