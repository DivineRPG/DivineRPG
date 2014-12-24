package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModBook;
import net.divinerpg.api.blocks.BlockModBush;
import net.divinerpg.api.blocks.BlockModDoor;
import net.divinerpg.api.blocks.BlockModGlass;
import net.divinerpg.api.blocks.BlockModGrass;
import net.divinerpg.api.blocks.BlockModLeaves;
import net.divinerpg.api.blocks.BlockModLog;
import net.divinerpg.api.blocks.BlockModSpawner;
import net.divinerpg.api.blocks.BlockModStairs;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.blocks.iceika.BlockCoalstoneFurnace;
import net.divinerpg.blocks.iceika.BlockFrostedChest;
import net.divinerpg.blocks.iceika.BlockIceikaFire;
import net.divinerpg.blocks.iceika.BlockIceikaLava;
import net.divinerpg.blocks.iceika.BlockXmasLights;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class IceikaBlocks {

    public static Block frozenDirt          = new BlockMod(EnumBlockType.GRASS, "frozenDirt", 2.5F);
    public static Block frozenGrass         = new BlockModGrass((BlockMod) frozenDirt, "frozenGrass", "frozenDirt", 2.5F);
    public static Block frozenStone         = new BlockMod("frozenStone", 6.0F);
    public static Block frozenWood          = new BlockModLog("frozenLog").setHardness(5.0F);
    public static Block brittleLeaves       = new BlockModLeaves("brittleLeaves", 0.1F);

    public static Block winterberryBush     = new BlockModBush(false, "winterberryBush", "ripeWinterberryBush", null).setHardness(0.2F);
    public static Block winterberryBushRipe = new BlockModBush(true, "ripeWinterberryBush", "winterberryBush", IceikaItems.winterberry).setHardness(0.2F);

    public static Block icyStone            = new BlockMod("icyStone", -1F);
    public static Block icyBricks           = new BlockMod("icyBricks", -1F);
    public static Block frostedChest        = new BlockFrostedChest("frostedChest", true).setHardness(2.5F);
    public static Block decorativeFrostedChest= new BlockFrostedChest("decorativeFrostedChest", false).setHardness(2.5F);
    public static Block rollumSpawner       = new BlockModSpawner("rollumSpawner", "Rollum").setHardness(5.0F);
    public static Block frostArcherSpawner  = new BlockModSpawner("frostArcherSpawner", "FrostArcher").setHardness(5.0F);
    public static Block iceikaLava 		  = new BlockIceikaLava();
    public static Block snowBricks          = new BlockMod("snowBricks", 6.0F);
    public static Block coalstone           = new BlockMod("coalstone", 3.0F);
    public static Block coalstoneStairs     = new BlockModStairs(coalstone, "coalstoneStairs");
    public static Block workshopCarpet      = new BlockMod(EnumBlockType.WOOL, "workshopCarpet", 0.1F);
    public static Block frostedGlass        = new BlockModGlass("frostedGlass", 1.0F);
    public static Block workshopBookcase    = new BlockModBook("workshopBookcase").setHardness(1.5F);
    public static Block workshopLamp        = new BlockMod(EnumBlockType.GLASS, "workshopLamp", 0.3F).setLightLevel(1);
    public static Block steelDoorBlock      = new BlockModDoor(EnumBlockType.IRON, "steelDoorBlock", 7.0F, true);
    public static Block coalstoneFurnace    = new BlockCoalstoneFurnace("coalstoneFurnace", false);
    public static Block coalstoneFurnaceOn  = new BlockCoalstoneFurnace("coalstoneFurnaceActive", true);
    
    public static Block redXmasLights		= new BlockXmasLights("redChristmasLights");
    public static Block greenXmasLights		= new BlockXmasLights("greenChristmasLights");
    public static Block blueXmasLights		= new BlockXmasLights("blueChristmasLights");
    public static Block yellowXmasLights	= new BlockXmasLights("yellowChristmasLights");
    public static Block purpleXmasLights	= new BlockXmasLights("purpleChristmasLights");

    public static Block iceikaFire          = new BlockIceikaFire("iceikaFire");
    public static Block iceikaPortal        = new BlockModPortal("iceikaPortal", ConfigurationHelper.iceika, iceikaFire, Blocks.snow);
}