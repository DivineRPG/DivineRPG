package net.divinerpg.utils.blocks;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.api.blocks.BlockModBook;
import net.divinerpg.api.blocks.BlockModBush;
import net.divinerpg.api.blocks.BlockModDoor;
import net.divinerpg.api.blocks.BlockModFire;
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
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class IceikaBlocks {

    public static final Block frozenDirt          = new BlockMod(EnumBlockType.GRASS, "frozenDirt", 2.5F);
    public static final Block frozenGrass         = new BlockModGrass((BlockMod) frozenDirt, "frozenGrass", 2.5F);
    public static final Block frozenStone         = new BlockMod("frozenStone", 6.0F);
    public static final Block frozenWood          = new BlockModLog("frozenLog").setHardness(5.0F);
    public static final Block brittleLeaves       = new BlockModLeaves("brittleLeaves", 0.1F);

    public static final Block winterberryBush     = new BlockModBush(false, "winterberryBush", "ripeWinterberryBush", null).setHardness(0.2F);
    public static final Block winterberryBushRipe = new BlockModBush(true, "ripeWinterberryBush", "winterberryBush", IceikaItems.winterberry).setHardness(0.2F);

    public static final Block icyStone            = new BlockMod("icyStone", -1F);
    public static final Block icyBricks           = new BlockMod("icyBricks", -1F);
    public static final Block frostedChest        = new BlockFrostedChest("frostedChest").setHardness(2.5F);
    public static final Block rollumSpawner       = new BlockModSpawner("rollumSpawner", "Rollum").setHardness(5.0F);
    public static final Block glacideSpawner      = new BlockModSpawner("glacideSpawner", "Glacide").setHardness(5.0F);
    public static final Block iceikaLava 		  = new BlockIceikaLava();
    public static final Block snowBricks          = new BlockMod("snowBricks", 6.0F);
    public static final Block coalstone           = new BlockMod("coalstone", 3.0F);
    public static final Block coalstoneStairs     = new BlockModStairs(coalstone, "coalstoneStairs");
    public static final Block workshopCarpet      = new BlockMod(EnumBlockType.WOOL, "workshopCarpet", 0.1F);
    public static final Block frostedGlass        = new BlockModGlass("frostedGlass", 1.0F);
    public static final Block workshopBookcase    = new BlockModBook("workshopBookcase").setHardness(1.5F);
    public static final Block workshopLamp        = new BlockMod(EnumBlockType.GLASS, "workshopLamp", 0.3F).setLightLevel(1);
    public static final Block steelDoorBlock      = new BlockModDoor(EnumBlockType.IRON, "steelDoorBlock", 7.0F, null);
    public static final Block coalstoneFurnace    = new BlockCoalstoneFurnace("coalstoneFurnace", false);
    public static final Block coalstoneFurnaceOn  = new BlockCoalstoneFurnace("coalstoneFurnaceActive", true);

    public static final Block iceikaFire          = new BlockIceikaFire("iceikaFire");
    public static final Block portal              = new BlockModPortal("iceikaPortal", ConfigurationHelper.iceika, iceikaFire, Blocks.snow);
}