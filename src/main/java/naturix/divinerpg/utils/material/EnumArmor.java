package naturix.divinerpg.utils.material;

import naturix.divinerpg.DivineRPG;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class EnumArmor {

	public static final ItemArmor.ArmorMaterial ANGELIC = EnumHelper.addArmorMaterial("angelic",
	        DivineRPG.modId + ":angelic", 0, new int[] { (int) 6.3, 10, (int) 8.8, 5 }, 10,
	        SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	// DIVINE(addArmorMaterial("Divine", 10000, 10, VanillaItemsOther.divineStone),
	// "divine", false, 78),
	//
	// BEDROCK(addArmorMaterial("Bedrock", 10000, 10,
	// Item.getItemFromBlock(Blocks.bedrock)), "bedrock", false, 78),
	//
	// REALMITE(addArmorMaterial("Realmite", 5000, 10,
	// VanillaItemsOther.realmiteIngot), "realmite", false, 50),
	//
	// ELITE_REALMITE(addArmorMaterial("Elite Realmite", 0, 10), "eliteRealmite",
	// true, 65),
	//
	// ARLEMITE(addArmorMaterial("Arlemite", 0, 22), "arlemite", true, 50),
	//
	// RUPEE(addArmorMaterial("Rupee", 0, 10), "rupee", true, 50),
	//
	// RUPEE_YELLOW(addArmorMaterial("Rupee", 0, 10), "yellowRupee", true, 50),
	//
	// RUPEE_RED(addArmorMaterial("Rupee", 0, 10), "redRupee", true, 50),
	//
	// RUPEE_GREEN(addArmorMaterial("Rupee", 0, 10), "greenRupee", true, 50),
	//
	// RUPEE_GRAY(addArmorMaterial("Rupee", 0, 10), "grayRupee", true, 50),
	//
	// RUPEE_BLUE(addArmorMaterial("Rupee", 0, 10), "blueRupee", true, 50),
	//
	// KRAKEN(addArmorMaterial("Kraken", 5000, 10, VanillaItemsOther.krakenSkin),
	// "kraken", false, 45),
	//
	// WITHER_REAPER(addArmorMaterial("Wither Reaper", 0, 22), "witherReaper", true,
	// 0),
	//
	// SKELEMAN(addArmorMaterial("Skeleman", 0, 22), "skeleman", true, 0),
	//
	// JACKOMAN(addArmorMaterial("Jack O Man", 0, 22), "jackOMan", true, 0),
	//
	// INFERNO(addArmorMaterial("Inferno", 6500, 10), "inferno", true, 73),
	//
	// AQUATIC(addArmorMaterial("Aquastrive", 0, 10), "aquastrive", true, 70),
	//
	// SHADOW(addArmorMaterial("Shadow", 0, 10), "shadow", true, 75),
	//
	// NETHERITE(addArmorMaterial("Netherite", 5000, 10,
	// VanillaItemsOther.netheriteIngot), "netherite", false, 70),
	//
	// ENDER(addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone),
	// "ender", false, 73),
	//
	// ENDER_YELLOW(addArmorMaterial("Ender", 7500, 10,
	// VanillaItemsOther.enderStone), "yellowEnder", false, 73),
	//
	// ENDER_RED(addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone),
	// "redEnder", false, 73),
	//
	// ENDER_GREEN(addArmorMaterial("Ender", 7500, 10,
	// VanillaItemsOther.enderStone), "greenEnder", false, 73),
	//
	// ENDER_GRAY(addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone),
	// "grayEnder", false, 73),
	//
	// ENDER_BLUE(addArmorMaterial("Ender", 7500, 10, VanillaItemsOther.enderStone),
	// "blueEnder", false, 73),
	//
	// JUNGLE(addArmorMaterial("Jungle", 5000, 10, VanillaItemsOther.jungleStone),
	// "jungle", false, 65),
	//
	// FROZEN(addArmorMaterial("Frozen", 3000, 10, IceikaItems.iceStone), "frozen",
	// false, 65),
	//
	// CORRUPTED(addArmorMaterial("Corrupted", 5000, 10,
	// VanillaItemsOther.corruptedStone), "corrupted", false, 68),
	//
	// TERRAN(addArmorMaterial("Terran", 3000, 10, VanillaItemsOther.terranStone),
	// "terran", false, 68),
	//
	// EDEN(addArmorMaterial("Eden", 0, 10), "eden", true, 72),
	//
	// WILD(addArmorMaterial("Wild", 0, 10), "wildwood", true, 74),
	//
	// APALACHIA(addArmorMaterial("Apalachia", 0, 10), "apalachia", true, 76),
	//
	// SKYTHERN(addArmorMaterial("Skythern", 0, 10), "skythern", true, 78),
	//
	// MORTUM(addArmorMaterial("Mortum", 0, 10), "mortum", true, 80),
	//
	// HALITE(addArmorMaterial("Halite", 0, 12), "halite", true, 83),
	//
	// SANTA(addArmorMaterial("Santa", 0, 10), "santa", true, 0, true),
	//
	// KORMA(addArmorMaterial("Korma", 0, 22), "korma", true, 78),
	//
	// VEMOS(addArmorMaterial("Vemos", 0, 22), "vemos", true, 65),
	//
	// DIAMOND(addArmorMaterial("Diamond", 3000, 10), "diamond", false, 55),
	//
	// IRON(addArmorMaterial("Iron", 2000, 12), "iron", false, 30),
	//
	// GOLD(addArmorMaterial("Gold", 1000, 10), "gold", false, 22),
	//
	// DEGRADED(addArmorMaterial("Degraded", 0, 0), "degraded", true, 17),
	//
	// FINISHED(addArmorMaterial("Finished", 0, 0), "finished", true, 33),
	//
	// GLISTENING(addArmorMaterial("Glistening", 0, 0), "glistening", true, 50),
	//
	// DEMONIZED(addArmorMaterial("Demonized", 0, 0), "demonized", true, 60),
	//
	// TORMENTED(addArmorMaterial("Tormented", 0, 0), "tormented", true, 77);

	// name, textureName, durability, reductionAmounts, enchantability,
	// soundOnEquip, toughness);

	public static final ItemArmor.ArmorMaterial apalachiaArmorMaterial = EnumHelper.addArmorMaterial("APALACHIA",
	        DivineRPG.modId + ":apalachia", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial aquastriveArmorMaterial = EnumHelper.addArmorMaterial("AQUASTRIVE",
	        DivineRPG.modId + ":aquastrive", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial aquaticArmorMaterial = EnumHelper.addArmorMaterial("AQUATIC",
	        DivineRPG.modId + ":aquatic", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial bedrockArmorMaterial = EnumHelper.addArmorMaterial("BEDROCK",
	        DivineRPG.modId + ":bedrock", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial corruptedArmorMaterial = EnumHelper.addArmorMaterial("CORRUPTED",
	        DivineRPG.modId + ":corrupted", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial degradedArmorMaterial = EnumHelper.addArmorMaterial("DEGRADED",
	        DivineRPG.modId + ":degraded", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial demonizedArmorMaterial = EnumHelper.addArmorMaterial("DEMONIZED",
	        DivineRPG.modId + ":demonized", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial divineArmorMaterial = EnumHelper.addArmorMaterial("DIVINE",
	        DivineRPG.modId + ":divine", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial donatorArmorMaterial = EnumHelper.addArmorMaterial("DONATOR",
	        DivineRPG.modId + ":donator", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial edenArmorMaterial = EnumHelper.addArmorMaterial("EDEN",
	        DivineRPG.modId + ":eden", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial enderArmorMaterial = EnumHelper.addArmorMaterial("ENDER",
	        DivineRPG.modId + ":ender", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial finishedArmorMaterial = EnumHelper.addArmorMaterial("FINISHED",
	        DivineRPG.modId + ":finished", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial frozenArmorMaterial = EnumHelper.addArmorMaterial("FROZEN",
	        DivineRPG.modId + ":frozen", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial glisteningArmorMaterial = EnumHelper.addArmorMaterial("GLISTENING",
	        DivineRPG.modId + ":glistening", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial haliteArmorMaterial = EnumHelper.addArmorMaterial("HALITE",
	        DivineRPG.modId + ":halite", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial infernoArmorMaterial = EnumHelper.addArmorMaterial("INFERNO",
	        DivineRPG.modId + ":inferno", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial jackomanArmorMaterial = EnumHelper.addArmorMaterial("JACKOMAN",
	        DivineRPG.modId + ":jackoman", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial jungleArmorMaterial = EnumHelper.addArmorMaterial("JUNGLE",
	        DivineRPG.modId + ":jungle", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial kormaArmorMaterial = EnumHelper.addArmorMaterial("KORMA",
	        DivineRPG.modId + ":korma", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial krakenArmorMaterial = EnumHelper.addArmorMaterial("KORMA",
	        DivineRPG.modId + ":korma", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial mortumArmorMaterial = EnumHelper.addArmorMaterial("MORTUM",
	        DivineRPG.modId + ":mortum", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial netheriteArmorMaterial = EnumHelper.addArmorMaterial("NETHERITE",
	        DivineRPG.modId + ":netherite", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial realmiteArmorMaterial = EnumHelper.addArmorMaterial("REALMITE",
	        DivineRPG.modId + ":realmite", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial rupeeArmorMaterial = EnumHelper.addArmorMaterial("RUPEE",
	        DivineRPG.modId + ":rupee", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial santaArmorMaterial = EnumHelper.addArmorMaterial("SANTA",
	        DivineRPG.modId + ":santa", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ItemArmor.ArmorMaterial shadowArmorMaterial = EnumHelper.addArmorMaterial("SHADOW",
	        DivineRPG.modId + ":shadow", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial skelemanArmorMaterial = EnumHelper.addArmorMaterial("SKELEMAN",
	        DivineRPG.modId + ":skeleman", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial skythernArmorMaterial = EnumHelper.addArmorMaterial("SKYTHERN",
	        DivineRPG.modId + ":skythern", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial terranArmorMaterial = EnumHelper.addArmorMaterial("TERRAN",
	        DivineRPG.modId + ":terran", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial tormentedArmorMaterial = EnumHelper.addArmorMaterial("TORMENTED",
	        DivineRPG.modId + ":tormented", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial vemosArmorMaterial = EnumHelper.addArmorMaterial("VEMOS",
	        DivineRPG.modId + ":vemos", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial wildwoodArmorMaterial = EnumHelper.addArmorMaterial("WILDWOOD",
	        DivineRPG.modId + ":wildwood", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial witherreaperArmorMaterial = EnumHelper.addArmorMaterial("WITHERREAPER",
	        DivineRPG.modId + ":witherreaper", 15, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
	        0.0F);
}
