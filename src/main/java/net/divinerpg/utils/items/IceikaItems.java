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

	public static Item snowflake = new ItemMod("snowflake");
	public static Item iceShards = new ItemMod("iceShards");
	public static Item iceStone = new ItemMod("iceStone");

	public static Item icicleBane = new ItemSlowingSword(ToolMaterialMod.IcicleBane, "icicleBane");
	public static Item icineSword = new ItemSlowingSword(ToolMaterialMod.Icine, "icineSword");
	public static Item enderice = new ItemSlowingSword(ToolMaterialMod.Enderice, "enderice");
	public static Item snowSlash = new ItemSlowingSword(ToolMaterialMod.Snowslash, "snowslash");
	public static Item glacierSword = new ItemSlowingSword(ToolMaterialMod.Glacier, "glacierSword");
	public static Item frostkingSword = new ItemSlowingSword(ToolMaterialMod.Frostking, "frostkingSword");
	public static Item frozenMaul = new ItemSlowingSword(ToolMaterialMod.FrozenMaul, "frozenMaul");
	public static Item frossivence = new ItemHealingSword("frossivence", ToolMaterialMod.Frossivence, 1);

	public static Item soundOfCarols = new ItemMusicShooter("soundOfCarols").setCreativeTab(DivineRPGTabs.ranged);
	public static Item soundOfMusic = new ItemMusicShooter("soundOfMusic").setCreativeTab(DivineRPGTabs.ranged);
	public static Item frostclawCannon = new ItemProjectileShooter("frostclawCannon", 16F, Sounds.frostclawCannon.getPrefixedName(), Item.getItemFromBlock(Blocks.cactus), EntityResourceLocation.frostclawCannon.toString(), 10000, 0);
	public static Item fractiteCannon = new ItemProjectileShooter("fractiteCannon", 14F, Sounds.fractiteCannon.getPrefixedName(), iceShards, EntityResourceLocation.fractiteCannon.toString(), 10000, 0);
	public static Item snowflakeShuriken = new ItemThrowable("snowflakeShuriken", 7);
	public static Item serenadeOfIce = new ItemSerenadeOfIce("serenadeOfIce");

	public static Item eggNog = new ItemEggNog("eggNog");
	public static Item peppermints = new ItemModFood(1, 0.3F, false, "peppermints");
	public static Item chocolateLog = new ItemModFood(4, 1.0F, false, "chocolateLog");
	public static Item snowCones = new ItemModFood(2, 0.3F, false, "snowCones");
	public static Item fruitCake = new ItemModFood(16, 2.0F, false, "fruitCake");
	public static Item winterberry = new ItemModFood(4, 1.0F, false, "winterberry");

	public static Item icicleBow = new ItemModBow("icicleBow", 10000, 2, 11, 24000, Items.arrow, "icicleArrow");
	public static Item snowstormBow = new ItemModBow("snowstormBow", -1, 2, 11, "snowstormArrow");

	private static Object[] santaInfo = new Object[] { ChatFormats.ICEIKA, "Massive Buff", 2, ArmorInfo.SPEED, 6, ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };
	public static Item santaCap = new ItemDivineArmor(EnumArmor.SANTA, HEAD, santaInfo);
	public static Item santaTunic = new ItemDivineArmor(EnumArmor.SANTA, BODY, santaInfo);
	public static Item santaPants = new ItemDivineArmor(EnumArmor.SANTA, LEGS, santaInfo);
	public static Item santaBoots = new ItemDivineArmor(EnumArmor.SANTA, BOOTS, santaInfo);

	public static Item snowGlobe = new ItemSnowGlobe("snowGlobe");

	public static void init() {
	}
}
