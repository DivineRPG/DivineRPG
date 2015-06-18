package net.divinerpg.utils.items;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.items.base.ItemHealingSword;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemModBow;
import net.divinerpg.items.base.ItemModFood;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.items.base.ItemSlowingSword;
import net.divinerpg.items.base.ItemThrowable;
import net.divinerpg.items.iceika.ItemEggNog;
import net.divinerpg.items.iceika.ItemMusicShooter;
import net.divinerpg.items.iceika.ItemSerenadeOfIce;
import net.divinerpg.items.iceika.ItemSnowGlobe;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class IceikaItems {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static Item snowflake;
	public static Item iceShards;
	public static Item iceStone;

	public static Item icicleBane;
	public static Item icineSword;
	public static Item enderice;
	public static Item snowSlash;
	public static Item glacierSword;
	public static Item frostkingSword;
	public static Item frozenMaul;
	public static Item frossivence;

	public static Item soundOfCarols;
	public static Item soundOfMusic;
	public static Item frostclawCannon;
	public static Item fractiteCannon;
	public static Item snowflakeShuriken;
	public static Item serenadeOfIce;

	public static Item eggNog;
	public static Item peppermints;
	public static Item chocolateLog;
	public static Item snowCones;
	public static Item fruitCake;
	public static Item winterberry;

	public static Item icicleBow;
	public static Item snowstormBow;

	public static Item santaCap;
	public static Item santaTunic;
	public static Item santaPants;
	public static Item santaBoots;

	public static Item snowGlobe;
	
	public static void init() {
	     snowflake         = new ItemMod("snowflake");
         iceShards         = new ItemMod("iceShards");
         iceStone          = new ItemMod("iceStone");

         icicleBane        = new ItemSlowingSword(ToolMaterialMod.IcicleBane, "icicleBane");
         icineSword        = new ItemSlowingSword(ToolMaterialMod.Icine, "icineSword");
         enderice          = new ItemSlowingSword(ToolMaterialMod.Enderice, "enderice");
         snowSlash         = new ItemSlowingSword(ToolMaterialMod.Snowslash, "snowslash");
         glacierSword      = new ItemSlowingSword(ToolMaterialMod.Glacier, "glacierSword");
         frostkingSword    = new ItemSlowingSword(ToolMaterialMod.Frostking, "frostkingSword");
         frozenMaul        = new ItemSlowingSword(ToolMaterialMod.FrozenMaul, "frozenMaul");
         frossivence       = new ItemHealingSword("frossivence", ToolMaterialMod.Frossivence, 1);

         soundOfCarols     = new ItemMusicShooter("soundOfCarols").setCreativeTab(DivineRPGTabs.ranged);
         soundOfMusic      = new ItemMusicShooter("soundOfMusic").setCreativeTab(DivineRPGTabs.ranged);
         frostclawCannon   = new ItemProjectileShooter("frostclawCannon", 16F, Sounds.frostclawCannon.getPrefixedName(), Item.getItemFromBlock(Blocks.cactus), EntityResourceLocation.frostclawCannon.toString(), 10000, 0);
         fractiteCannon    = new ItemProjectileShooter("fractiteCannon", 14F, Sounds.fractiteCannon.getPrefixedName(), iceShards, EntityResourceLocation.fractiteCannon.toString(), 10000, 0);
         snowflakeShuriken = new ItemThrowable("snowflakeShuriken", 7);
         serenadeOfIce     = new ItemSerenadeOfIce("serenadeOfIce");

         eggNog            = new ItemEggNog("eggNog");
         peppermints       = new ItemModFood(1, 0.3F, false, "peppermints");
         chocolateLog      = new ItemModFood(4, 1.0F, false, "chocolateLog");
         snowCones         = new ItemModFood(2, 0.3F, false, "snowCones");
         fruitCake         = new ItemModFood(16, 2.0F, false, "fruitCake");
         winterberry       = new ItemModFood(4, 1.0F, false, "winterberry");

    	 icicleBow 		   = new ItemModBow("icicleBow", 10000, 2, 11, 24000, Items.arrow, "icicleArrow");
    	 snowstormBow      = new ItemModBow("snowstormBow", -1, 2, 11, "snowstormArrow");

    	 Object[] santaInfo = new Object[] { ChatFormats.ICEIKA, "Massive Buff", 2, ArmorInfo.SPEED, 6, ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };
         santaCap          = new ItemDivineArmor(EnumArmor.SANTA, HEAD, santaInfo);
         santaTunic        = new ItemDivineArmor(EnumArmor.SANTA, BODY, santaInfo);
         santaPants        = new ItemDivineArmor(EnumArmor.SANTA, LEGS, santaInfo);
         santaBoots        = new ItemDivineArmor(EnumArmor.SANTA, BOOTS, santaInfo);

         snowGlobe         = new ItemSnowGlobe("snowGlobe");
	}
}
