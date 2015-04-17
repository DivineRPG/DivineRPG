package net.divinerpg.utils.blocks;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.blocks.base.BlockModBook;
import net.divinerpg.blocks.base.BlockModDoor;
import net.divinerpg.blocks.base.BlockModGlass;
import net.divinerpg.blocks.base.BlockModGrass;
import net.divinerpg.blocks.base.BlockModLeaves;
import net.divinerpg.blocks.base.BlockModLog;
import net.divinerpg.blocks.base.BlockModSpawner;
import net.divinerpg.blocks.base.BlockModStairs;
import net.divinerpg.blocks.base.portal.BlockModPortal;
import net.divinerpg.blocks.iceika.BlockCandyCane;
import net.divinerpg.blocks.iceika.BlockCoalstoneFurnace;
import net.divinerpg.blocks.iceika.BlockFrostedChest;
import net.divinerpg.blocks.iceika.BlockIceikaFire;
import net.divinerpg.blocks.iceika.BlockPresentBox;
import net.divinerpg.blocks.iceika.BlockWinterberryBush;
import net.divinerpg.blocks.iceika.BlockXmasLights;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class IceikaBlocks {

	public static Block frozenDirt;
	public static Block frozenGrass;
	public static Block frozenStone;
	public static Block frozenWood;
	public static Block brittleLeaves;

	public static Block winterberryBush;
	public static Block winterberryBushRipe;

	public static Block icyStone;
	public static Block icyBricks;
	public static Block frostedChest;
	public static Block decorativeFrostedChest;
	public static Block rollumSpawner;
	public static Block frostArcherSpawner;
	public static Block snowBricks;
	public static Block coalstone;
	public static Block coalstoneStairs;
	public static Block workshopCarpet;
	public static Block frostedGlass;
	public static Block workshopBookcase;
	public static Block workshopLamp;
	public static Block steelDoorBlock;
	public static Block coalstoneFurnace;
	public static Block coalstoneFurnaceOn;

	public static Block redXmasLights;
	public static Block greenXmasLights;
	public static Block blueXmasLights;
	public static Block yellowXmasLights;
	public static Block purpleXmasLights;
	public static Block candyCane;
	
	public static Block presentBox;

	public static Block iceikaFire;
	public static Block iceikaPortal;
	
	public static void init() {
		frozenDirt          = new BlockMod(EnumBlockType.GRASS, "frozenDirt", 2.5F);
	    frozenGrass         = new BlockModGrass((BlockMod) frozenDirt, "frozenGrass", "frozenDirt", 2.5F);
	    frozenStone         = new BlockMod("frozenStone", 6.0F);
	    frozenWood          = new BlockModLog("frozenLog").setHardness(5.0F);
	    brittleLeaves       = new BlockModLeaves("brittleLeaves", 0.1F);

	    winterberryBush     = new BlockWinterberryBush(false, "winterberryBush").setHardness(0.2F);
	    winterberryBushRipe = new BlockWinterberryBush(true, "ripeWinterberryBush").setHardness(0.2F);

	    icyStone            = new BlockMod("icyStone", -1F);
	    icyBricks           = new BlockMod("icyBricks", -1F);
	    frostedChest        = new BlockFrostedChest("frostedChest", true).setHardness(2.5F);
	    decorativeFrostedChest= new BlockFrostedChest("decorativeFrostedChest", false).setHardness(2.5F);
	    rollumSpawner       = new BlockModSpawner("rollumSpawner", "Rollum").setHardness(5.0F);
	    frostArcherSpawner  = new BlockModSpawner("frostArcherSpawner", "FrostArcher").setHardness(5.0F);
	    snowBricks          = new BlockMod("snowBricks", 6.0F);
	    coalstone           = new BlockMod("coalstone", 3.0F);
	    coalstoneStairs     = new BlockModStairs(coalstone, "coalstoneStairs");
	    workshopCarpet      = new BlockMod(EnumBlockType.WOOL, "workshopCarpet", 0.1F);
	    frostedGlass        = new BlockModGlass("frostedGlass", 1.0F);
	    workshopBookcase    = new BlockModBook(EnumBlockType.ROCK, "workshopBookcase").setHardness(1.5F);
	    workshopLamp        = new BlockMod(EnumBlockType.GLASS, "workshopLamp", 0.3F).setLightLevel(1);
	    steelDoorBlock      = new BlockModDoor(EnumBlockType.IRON, "steelDoorBlock", 7.0F, true);
	    coalstoneFurnace    = new BlockCoalstoneFurnace("coalstoneFurnace", false);
	    coalstoneFurnaceOn  = new BlockCoalstoneFurnace("coalstoneFurnaceActive", true);
	    
	    redXmasLights		= new BlockXmasLights("redChristmasLights");
	    greenXmasLights		= new BlockXmasLights("greenChristmasLights");
	    blueXmasLights		= new BlockXmasLights("blueChristmasLights");
	    yellowXmasLights	= new BlockXmasLights("yellowChristmasLights");
	    purpleXmasLights	= new BlockXmasLights("purpleChristmasLights");
	    candyCane 			= new BlockCandyCane();
	    
	    presentBox			= new BlockPresentBox();

	    iceikaFire          = new BlockIceikaFire("iceikaFire");
	    iceikaPortal        = new BlockModPortal("iceikaPortal", ConfigurationHelper.iceika, iceikaFire, Blocks.snow);
	}
}