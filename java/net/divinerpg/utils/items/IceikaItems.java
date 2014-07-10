package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBucket;
import net.divinerpg.api.items.ItemModDoor;
import net.divinerpg.api.items.ItemModFood;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.items.iceika.ItemFrostclawCannon;
import net.divinerpg.items.iceika.ItemMusicShooter;
import net.divinerpg.items.iceika.ItemSnowGlobe;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;

public class IceikaItems {

    public static int             HEAD              = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    public static final Item      snowflake         = new ItemMod("snowFlake");

    public static final Item      icicleBane        = new ItemModSword(ToolMaterialMod.IcicleBane, "icicleBane");
    public static final Item      icineSword        = new ItemModSword(ToolMaterialMod.Icine, "icineSword");
    public static final Item      enderice          = new ItemModSword(ToolMaterialMod.Enderice, "enderice");
    public static final Item      snowSlash         = new ItemModSword(ToolMaterialMod.Snowslash, "snowslash");
    public static final Item      glacierSword      = new ItemModSword(ToolMaterialMod.Glacier, "glacierSword");
    public static final Item      frostkingSword    = new ItemModSword(ToolMaterialMod.Frostking, "frostkingSword");
    public static final Item      frozenMaul        = new ItemModSword(ToolMaterialMod.FrozenMaul, "frozenMaul");
    public static final Item      frossivence       = new ItemMod("frossivence").setCreativeTab(DivineRPGTabs.swords);

    public static final Item      soundOfCarols     = new ItemMusicShooter("soundOfCarols").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      soundOfMusic      = new ItemMusicShooter("soundOfMusic").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      frostclawCannon   = new ItemFrostclawCannon("frostclawCannon").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      fractiteCannon    = new ItemMod("fractiteCannon").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      snowflakeShuriken = new ItemMod("snowflakeShuriken").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      serenadeOfIce     = new ItemMod("serenadeofIce");

    public static final Item      eggNog            = new ItemMod("eggNog");
    public static final Item      peppermints       = new ItemModFood(1, 0.3F, false, "peppermints");
    public static final Item      chocolateLog      = new ItemModFood(4, 1.0F, false, "chocolateLog");
    public static final Item      snowCones         = new ItemModFood(2, 0.3F, false, "snowCones");
    public static final Item      fruitCake         = new ItemModFood(16, 2.0F, false, "fruitCake");
    public static final Item      winterberry       = new ItemModFood(4, 1.0F, false, "winterberry");

    //public static final Item icicleBow = new ItemIceBow("icicleBow");
    //public static final Item snowStormBow = new ItemSnowStormBow("snowStormBow");

    private static final Object[] santaInfo         = new Object[] { ChatFormats.ICEIKA, "Massive Buff", ArmorInfo.SPEED, 6, ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };
    public static final Item      santaHead         = new ItemDivineArmor(EnumArmor.SANTA, HEAD, santaInfo);
    public static final Item      santaBody         = new ItemDivineArmor(EnumArmor.SANTA, BODY, santaInfo);
    public static final Item      santaLegs         = new ItemDivineArmor(EnumArmor.SANTA, LEGS, santaInfo);
    public static final Item      santaBoots        = new ItemDivineArmor(EnumArmor.SANTA, BOOTS, santaInfo);

    public static final Item      iceShards         = new ItemMod("iceShards");
    public static final Item      iceStone          = new ItemMod("iceStone");

    public static final Item      snowGlobe         = new ItemSnowGlobe("snowGlobe");

    public static final Item 	  frozenLavaBucket  = new ItemModBucket(IceikaBlocks.iceikaLava, "bucketOfFrozenLava");
}
