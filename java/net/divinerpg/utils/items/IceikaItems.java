package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.api.items.ItemModBucket;
import net.divinerpg.api.items.ItemModFood;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.iceika.ItemEggNog;
import net.divinerpg.items.iceika.ItemFrossivence;
import net.divinerpg.items.iceika.ItemMusicShooter;
import net.divinerpg.items.iceika.ItemSerenadeOfIce;
import net.divinerpg.items.iceika.ItemSnowGlobe;
import net.divinerpg.items.vanilla.ItemProjectileShooter;
import net.divinerpg.items.vanilla.ItemThrowable;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class IceikaItems {

    public static int             HEAD              = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    public static final Item      snowflake         = new ItemMod("snowflake");
    public static final Item      iceShards         = new ItemMod("iceShards");
    public static final Item      iceStone          = new ItemMod("iceStone");

    public static final Item      icicleBane        = new ItemModSword(ToolMaterialMod.IcicleBane, "icicleBane");
    public static final Item      icineSword        = new ItemModSword(ToolMaterialMod.Icine, "icineSword");
    public static final Item      enderice          = new ItemModSword(ToolMaterialMod.Enderice, "enderice");
    public static final Item      snowSlash         = new ItemModSword(ToolMaterialMod.Snowslash, "snowslash");
    public static final Item      glacierSword      = new ItemModSword(ToolMaterialMod.Glacier, "glacierSword");
    public static final Item      frostkingSword    = new ItemModSword(ToolMaterialMod.Frostking, "frostkingSword");
    public static final Item      frozenMaul        = new ItemModSword(ToolMaterialMod.FrozenMaul, "frozenMaul");
    public static final Item      frossivence       = new ItemFrossivence("frossivence").setCreativeTab(DivineRPGTabs.swords);

    public static final Item      soundOfCarols     = new ItemMusicShooter("soundOfCarols").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      soundOfMusic      = new ItemMusicShooter("soundOfMusic").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item      frostclawCannon   = new ItemProjectileShooter("frostclawCannon", 21F, Sounds.frostclawCannon.getPrefixedName(), EntityResourceLocation.frostclawCannon.toString(), 10000, 0);
    public static final Item      fractiteCannon    = new ItemProjectileShooter("fractiteCannon", 15F, Sounds.frostclawCannon.getPrefixedName(), IceikaItems.iceShards, EntityResourceLocation.fractiteCannon.toString(), 1000, 0);
    public static final Item      snowflakeShuriken = new ItemThrowable(7, "snowflakeShuriken");
    public static final Item      serenadeOfIce     = new ItemSerenadeOfIce("serenadeOfIce");

    public static final Item      eggNog            = new ItemEggNog("eggNog");
    public static final Item      peppermints       = new ItemModFood(1, 0.3F, false, "peppermints");
    public static final Item      chocolateLog      = new ItemModFood(4, 1.0F, false, "chocolateLog");
    public static final Item      snowCones         = new ItemModFood(2, 0.3F, false, "snowCones");
    public static final Item      fruitCake         = new ItemModFood(16, 2.0F, false, "fruitCake");
    public static final Item      winterberry       = new ItemModFood(4, 1.0F, false, "winterberry");

    public static final Item 	  icicleBow = new ItemModBow("icicleBow", 10000, 2, 11, 24000, Items.arrow, "icicleArrow");
    public static final Item 	  snowstormBow = new ItemModBow("snowstormBow", -1, 2, 11, "snowstormArrow");

    private static final Object[] santaInfo         = new Object[] { ChatFormats.ICEIKA, "Massive Buff", ArmorInfo.SPEED, 6, ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };
    public static final Item      santaHead         = new ItemDivineArmor(EnumArmor.SANTA, HEAD, santaInfo);
    public static final Item      santaBody         = new ItemDivineArmor(EnumArmor.SANTA, BODY, santaInfo);
    public static final Item      santaLegs         = new ItemDivineArmor(EnumArmor.SANTA, LEGS, santaInfo);
    public static final Item      santaBoots        = new ItemDivineArmor(EnumArmor.SANTA, BOOTS, santaInfo);

    public static final Item      snowGlobe         = new ItemSnowGlobe("snowGlobe");

    public static final Item 	  frozenLavaBucket  = new ItemModBucket(IceikaBlocks.iceikaLava, "bucketOfFrozenLava");
}
