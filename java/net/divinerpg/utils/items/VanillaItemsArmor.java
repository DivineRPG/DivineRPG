package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class VanillaItemsArmor {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	private static Object[] angelicInfo = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY };
	public static Item angelicHelmet = new ItemDivineArmor(EnumArmor.ANGELIC, HEAD, angelicInfo);
	public static Item angelicBody = new ItemDivineArmor(EnumArmor.ANGELIC, BODY, angelicInfo);
	public static Item angelicLegs = new ItemDivineArmor(EnumArmor.ANGELIC, LEGS, angelicInfo);
	public static Item angelicBoots = new ItemDivineArmor(EnumArmor.ANGELIC, BOOTS, angelicInfo);

	private static Object[] divineInfo = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	public static Item divineHelmet = new ItemDivineArmor(EnumArmor.DIVINE, HEAD, divineInfo);
	public static Item divineBody = new ItemDivineArmor(EnumArmor.DIVINE, BODY, divineInfo);
	public static Item divineLegs = new ItemDivineArmor(EnumArmor.DIVINE, LEGS, divineInfo);
	public static Item divineBoots = new ItemDivineArmor(EnumArmor.DIVINE, BOOTS, divineInfo);

	private static Object[] bedrockInfo = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
	public static Item bedrockHelmet = new ItemDivineArmor(EnumArmor.BEDROCK, HEAD, bedrockInfo);
	public static Item bedrockBody = new ItemDivineArmor(EnumArmor.BEDROCK, BODY, bedrockInfo);
	public static Item bedrockLegs = new ItemDivineArmor(EnumArmor.BEDROCK, LEGS, bedrockInfo);
	public static Item bedrockBoots = new ItemDivineArmor(EnumArmor.BEDROCK, BOOTS, bedrockInfo);

	public static Item realmiteHelmet = new ItemDivineArmor(EnumArmor.REALMITE, HEAD);
	public static Item realmiteBody = new ItemDivineArmor(EnumArmor.REALMITE, BODY);
	public static Item realmiteLegs = new ItemDivineArmor(EnumArmor.REALMITE, LEGS);
	public static Item realmiteBoots = new ItemDivineArmor(EnumArmor.REALMITE, BOOTS);

	private static Object[] eliteRealmiteInfo = new Object[] { ArmorInfo.NO_FALL };
	public static Item eliteRealmiteHelmet = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, HEAD, eliteRealmiteInfo);
	public static Item eliteRealmiteBody = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BODY, eliteRealmiteInfo);
	public static Item eliteRealmiteLegs = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, LEGS, eliteRealmiteInfo);
	public static Item eliteRealmiteBoots = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BOOTS, eliteRealmiteInfo);

	private static Object[] arlemiteInfo = new Object[] { 85, ArmorInfo.RANGED_PROTECTION };
	public static Item arlemiteHelmet = new ItemDivineArmor(EnumArmor.ARLEMITE, HEAD, arlemiteInfo);
	public static Item arlemiteBody = new ItemDivineArmor(EnumArmor.ARLEMITE, BODY, arlemiteInfo);
	public static Item arlemiteLegs = new ItemDivineArmor(EnumArmor.ARLEMITE, LEGS, arlemiteInfo);
	public static Item arlemiteBoots = new ItemDivineArmor(EnumArmor.ARLEMITE, BOOTS, arlemiteInfo);

	private static Object[] rupeeInfo = new Object[] { 85, ArmorInfo.MELEE_PROTECTION };
	public static Item rupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE, HEAD, rupeeInfo);
	public static Item rupeeBody = new ItemDivineArmor(EnumArmor.RUPEE, BODY, rupeeInfo);
	public static Item rupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE, LEGS, rupeeInfo);
	public static Item rupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE, BOOTS, rupeeInfo);
	public static Item yellowRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, HEAD, rupeeInfo);
	public static Item yellowRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, BODY, rupeeInfo);
	public static Item yellowRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, LEGS, rupeeInfo);
	public static Item yellowRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, BOOTS, rupeeInfo);
	public static Item redRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_RED, HEAD, rupeeInfo);
	public static Item redRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_RED, BODY, rupeeInfo);
	public static Item redRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_RED, LEGS, rupeeInfo);
	public static Item redRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_RED, BOOTS, rupeeInfo);
	public static Item greenRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, HEAD, rupeeInfo);
	public static Item greenRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, BODY, rupeeInfo);
	public static Item greenRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, LEGS, rupeeInfo);
	public static Item greenRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, BOOTS, rupeeInfo);
	public static Item blueRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, HEAD, rupeeInfo);
	public static Item blueRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, BODY, rupeeInfo);
	public static Item blueRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, LEGS, rupeeInfo);
	public static Item blueRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, BOOTS, rupeeInfo);
	public static Item grayRupeeHelmet = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, HEAD, rupeeInfo);
	public static Item grayRupeeBody = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, BODY, rupeeInfo);
	public static Item grayRupeeLegs = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, LEGS, rupeeInfo);
	public static Item grayRupeeBoots = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, BOOTS, rupeeInfo);

	private static Object[] krakenInfo = new Object[] { ArmorInfo.UNDERWATER };
	public static Item krakenHelmet = new ItemDivineArmor(EnumArmor.KRAKEN, HEAD, krakenInfo);
	public static Item krakenBody = new ItemDivineArmor(EnumArmor.KRAKEN, BODY, krakenInfo);
	public static Item krakenLegs = new ItemDivineArmor(EnumArmor.KRAKEN, LEGS, krakenInfo);
	public static Item krakenBoots = new ItemDivineArmor(EnumArmor.KRAKEN, BOOTS, krakenInfo);

	private static Object[] jackomanInfo = new Object[] { 3, ArmorInfo.SCYTHE_DAMAGE };
	public static Item jackOManHelmet = new ItemDivineArmor(EnumArmor.JACKOMAN, HEAD, "jackOMan", jackomanInfo);
	public static Item jackOManBody = new ItemDivineArmor(EnumArmor.JACKOMAN, BODY, "jackOMan", jackomanInfo);
	public static Item jackOManLegs = new ItemDivineArmor(EnumArmor.JACKOMAN, LEGS, "jackOMan", jackomanInfo);
	public static Item jackOManBoots = new ItemDivineArmor(EnumArmor.JACKOMAN, BOOTS, "jackOMan", jackomanInfo);

	private static Object[] infernoInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
	public static Item infernoHelmet = new ItemDivineArmor(EnumArmor.INFERNO, HEAD, infernoInfo);
	public static Item infernoBody = new ItemDivineArmor(EnumArmor.INFERNO, BODY, infernoInfo);
	public static Item infernoLegs = new ItemDivineArmor(EnumArmor.INFERNO, LEGS, infernoInfo);
	public static Item infernoBoots = new ItemDivineArmor(EnumArmor.INFERNO, BOOTS, infernoInfo);

	private static Object[] aquastriveInfo = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
	public static Item aquastriveHelmet = new ItemDivineArmor(EnumArmor.AQUATIC, HEAD, aquastriveInfo);
	public static Item aquastriveBody = new ItemDivineArmor(EnumArmor.AQUATIC, BODY, aquastriveInfo);
	public static Item aquastriveLegs = new ItemDivineArmor(EnumArmor.AQUATIC, LEGS, aquastriveInfo);
	public static Item aquastriveBoots = new ItemDivineArmor(EnumArmor.AQUATIC, BOOTS, aquastriveInfo);

	private static Object[] shadowInfo = new Object[] { 3, ArmorInfo.SPEED };
	public static Item shadowHelmet = new ItemDivineArmor(EnumArmor.SHADOW, HEAD, shadowInfo);
	public static Item shadowBody = new ItemDivineArmor(EnumArmor.SHADOW, BODY, shadowInfo);
	public static Item shadowLegs = new ItemDivineArmor(EnumArmor.SHADOW, LEGS, shadowInfo);
	public static Item shadowBoots = new ItemDivineArmor(EnumArmor.SHADOW, BOOTS, shadowInfo);

	private static Object[] netheriteInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
	public static Item netheriteHelmet = new ItemDivineArmor(EnumArmor.NETHERITE, HEAD, netheriteInfo);
	public static Item netheriteBody = new ItemDivineArmor(EnumArmor.NETHERITE, BODY, netheriteInfo);
	public static Item netheriteLegs = new ItemDivineArmor(EnumArmor.NETHERITE, LEGS, netheriteInfo);
	public static Item netheriteBoots = new ItemDivineArmor(EnumArmor.NETHERITE, BOOTS, netheriteInfo);

	private static Object[] skelemanInfo = new Object[] { ArmorInfo.HUNGER };
	public static Item skelemanHelmet = new ItemDivineArmor(EnumArmor.SKELEMAN, HEAD, "skeleman", skelemanInfo);
	public static Item skelemanBody = new ItemDivineArmor(EnumArmor.SKELEMAN, BODY, "skeleman", skelemanInfo);
	public static Item skelemanLegs = new ItemDivineArmor(EnumArmor.SKELEMAN, LEGS, "skeleman", skelemanInfo);
	public static Item skelemanBoots = new ItemDivineArmor(EnumArmor.SKELEMAN, BOOTS, "skeleman", skelemanInfo);

	private static Object[] witherReaperInfo = new Object[] { ArmorInfo.WITHER_PROTECTION };
	public static Item witherReaperHelmet = new ItemDivineArmor(EnumArmor.WITHER_REAPER, HEAD, "witherReaper", witherReaperInfo);
	public static Item witherReaperBody = new ItemDivineArmor(EnumArmor.WITHER_REAPER, BODY, "witherReaper", witherReaperInfo);
	public static Item witherReaperLegs = new ItemDivineArmor(EnumArmor.WITHER_REAPER, LEGS, "witherReaper", witherReaperInfo);
	public static Item witherReaperBoots = new ItemDivineArmor(EnumArmor.WITHER_REAPER, BOOTS, "witherReaper", witherReaperInfo);

	private static Object[] enderInfo = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
	public static Item enderHelmet = new ItemDivineArmor(EnumArmor.ENDER, HEAD, enderInfo);
	public static Item enderBody = new ItemDivineArmor(EnumArmor.ENDER, BODY, enderInfo);
	public static Item enderLegs = new ItemDivineArmor(EnumArmor.ENDER, LEGS, enderInfo);
	public static Item enderBoots = new ItemDivineArmor(EnumArmor.ENDER, BOOTS, enderInfo);
	public static Item yellowEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, HEAD, enderInfo);
	public static Item yellowEnderBody = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, BODY, enderInfo);
	public static Item yellowEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, LEGS, enderInfo);
	public static Item yellowEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, BOOTS, enderInfo);
	public static Item redEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_RED, HEAD, enderInfo);
	public static Item redEnderBody = new ItemDivineArmor(EnumArmor.ENDER_RED, BODY, enderInfo);
	public static Item redEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_RED, LEGS, enderInfo);
	public static Item redEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_RED, BOOTS, enderInfo);
	public static Item greenEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_GREEN, HEAD, enderInfo);
	public static Item greenEnderBody = new ItemDivineArmor(EnumArmor.ENDER_GREEN, BODY, enderInfo);
	public static Item greenEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_GREEN, LEGS, enderInfo);
	public static Item greenEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_GREEN, BOOTS, enderInfo);
	public static Item blueEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_BLUE, HEAD, enderInfo);
	public static Item blueEnderBody = new ItemDivineArmor(EnumArmor.ENDER_BLUE, BODY, enderInfo);
	public static Item blueEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_BLUE, LEGS, enderInfo);
	public static Item blueEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_BLUE, BOOTS, enderInfo);
	public static Item grayEnderHelmet = new ItemDivineArmor(EnumArmor.ENDER_GRAY, HEAD, enderInfo);
	public static Item grayEnderBody = new ItemDivineArmor(EnumArmor.ENDER_GRAY, BODY, enderInfo);
	public static Item grayEnderLegs = new ItemDivineArmor(EnumArmor.ENDER_GRAY, LEGS, enderInfo);
	public static Item grayEnderBoots = new ItemDivineArmor(EnumArmor.ENDER_GRAY, BOOTS, enderInfo);

	private static Object[] jungleInfo = new Object[] { ArmorInfo.POISON_PROTECTION };
	public static Item jungleHelmet = new ItemDivineArmor(EnumArmor.JUNGLE, HEAD, jungleInfo);
	public static Item jungleBody = new ItemDivineArmor(EnumArmor.JUNGLE, BODY, jungleInfo);
	public static Item jungleLegs = new ItemDivineArmor(EnumArmor.JUNGLE, LEGS, jungleInfo);
	public static Item jungleBoots = new ItemDivineArmor(EnumArmor.JUNGLE, BOOTS, jungleInfo);

	private static Object[] frozenInfo = new Object[] { ArmorInfo.FREEZE };
	public static Item frozenHelmet = new ItemDivineArmor(EnumArmor.FROZEN, HEAD, frozenInfo);
	public static Item frozenBody = new ItemDivineArmor(EnumArmor.FROZEN, BODY, frozenInfo);
	public static Item frozenLegs = new ItemDivineArmor(EnumArmor.FROZEN, LEGS, frozenInfo);
	public static Item frozenBoots = new ItemDivineArmor(EnumArmor.FROZEN, BOOTS, frozenInfo);

	private static Object[] corruptedInfo = new Object[] { 20, ArmorInfo.RANGED_DAMAGE };
	public static Item corruptedHelmet = new ItemDivineArmor(EnumArmor.CORRUPTED, HEAD, corruptedInfo);
	public static Item corruptedBody = new ItemDivineArmor(EnumArmor.CORRUPTED, BODY, corruptedInfo);
	public static Item corruptedLegs = new ItemDivineArmor(EnumArmor.CORRUPTED, LEGS, corruptedInfo);
	public static Item corruptedBoots = new ItemDivineArmor(EnumArmor.CORRUPTED, BOOTS, corruptedInfo);

	private static Object[] terranInfo = new Object[] { 20, ArmorInfo.HASTE };
	public static Item terranHelmet = new ItemDivineArmor(EnumArmor.TERRAN, HEAD, terranInfo);
	public static Item terranBody = new ItemDivineArmor(EnumArmor.TERRAN, BODY, terranInfo);
	public static Item terranLegs = new ItemDivineArmor(EnumArmor.TERRAN, LEGS, terranInfo);
	public static Item terranBoots = new ItemDivineArmor(EnumArmor.TERRAN, BOOTS, terranInfo);

	public static Item diamondHelmet = new ItemDivineArmor(EnumArmor.DIAMOND, HEAD);
	public static Item diamondBody = new ItemDivineArmor(EnumArmor.DIAMOND, BODY);
	public static Item diamondLegs = new ItemDivineArmor(EnumArmor.DIAMOND, LEGS);
	public static Item diamondBoots = new ItemDivineArmor(EnumArmor.DIAMOND, BOOTS);

	public static Item ironHelmet = new ItemDivineArmor(EnumArmor.IRON, HEAD);
	public static Item ironBody = new ItemDivineArmor(EnumArmor.IRON, BODY);
	public static Item ironLegs = new ItemDivineArmor(EnumArmor.IRON, LEGS);
	public static Item ironBoots = new ItemDivineArmor(EnumArmor.IRON, BOOTS);

	public static Item goldHelmet = new ItemDivineArmor(EnumArmor.GOLD, HEAD);
	public static Item goldBody = new ItemDivineArmor(EnumArmor.GOLD, BODY);
	public static Item goldLegs = new ItemDivineArmor(EnumArmor.GOLD, LEGS);
	public static Item goldBoots = new ItemDivineArmor(EnumArmor.GOLD, BOOTS);

	public static void init() {}
}
