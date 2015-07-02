package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class VanillaItemsArmor {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static Item angelicHelmet;
	public static Item angelicBody;
	public static Item angelicLegs;
	public static Item angelicBoots;

	public static Item divineHelmet;
	public static Item divineBody;
	public static Item divineLegs;
	public static Item divineBoots;

	public static Item bedrockHelmet;
	public static Item bedrockBody;
	public static Item bedrockLegs;
	public static Item bedrockBoots;

	public static Item realmiteHelmet;
	public static Item realmiteBody;
	public static Item realmiteLegs;
	public static Item realmiteBoots;

	public static Item eliteRealmiteHelmet;
	public static Item eliteRealmiteBody;
	public static Item eliteRealmiteLegs;
	public static Item eliteRealmiteBoots;

	public static Item arlemiteHelmet;
	public static Item arlemiteBody;
	public static Item arlemiteLegs;
	public static Item arlemiteBoots;

	public static Item rupeeHelmet;
	public static Item rupeeBody;
	public static Item rupeeLegs;
	public static Item rupeeBoots;
	public static Item yellowRupeeHelmet;
	public static Item yellowRupeeBody;
	public static Item yellowRupeeLegs;
	public static Item yellowRupeeBoots;
	public static Item redRupeeHelmet;
	public static Item redRupeeBody;
	public static Item redRupeeLegs;
	public static Item redRupeeBoots;
	public static Item greenRupeeHelmet;
	public static Item greenRupeeBody;
	public static Item greenRupeeLegs;
	public static Item greenRupeeBoots;
	public static Item blueRupeeHelmet;
	public static Item blueRupeeBody;
	public static Item blueRupeeLegs;
	public static Item blueRupeeBoots;
	public static Item grayRupeeHelmet;
	public static Item grayRupeeBody;
	public static Item grayRupeeLegs;
	public static Item grayRupeeBoots;

	public static Item krakenHelmet;
	public static Item krakenBody;
	public static Item krakenLegs;
	public static Item krakenBoots;

	public static Item jackOManHelmet;
	public static Item jackOManBody;
	public static Item jackOManLegs;
	public static Item jackOManBoots;

	public static Item infernoHelmet;
	public static Item infernoBody;
	public static Item infernoLegs;
	public static Item infernoBoots;

	public static Item aquastriveHelmet;
	public static Item aquastriveBody;
	public static Item aquastriveLegs;
	public static Item aquastriveBoots;

	public static Item shadowHelmet;
	public static Item shadowBody;
	public static Item shadowLegs;
	public static Item shadowBoots;

	public static Item netheriteHelmet;
	public static Item netheriteBody;
	public static Item netheriteLegs;
	public static Item netheriteBoots;

	public static Item skelemanHelmet;
	public static Item skelemanBody;
	public static Item skelemanLegs;
	public static Item skelemanBoots;

	public static Item witherReaperHelmet;
	public static Item witherReaperBody;
	public static Item witherReaperLegs;
	public static Item witherReaperBoots;

	public static Item enderHelmet;
	public static Item enderBody;
	public static Item enderLegs;
	public static Item enderBoots;
	public static Item yellowEnderHelmet;
	public static Item yellowEnderBody;
	public static Item yellowEnderLegs;
	public static Item yellowEnderBoots;
	public static Item redEnderHelmet;
	public static Item redEnderBody;
	public static Item redEnderLegs;
	public static Item redEnderBoots;
	public static Item greenEnderHelmet;
	public static Item greenEnderBody;
	public static Item greenEnderLegs;
	public static Item greenEnderBoots;
	public static Item blueEnderHelmet;
	public static Item blueEnderBody;
	public static Item blueEnderLegs;
	public static Item blueEnderBoots;
	public static Item grayEnderHelmet;
	public static Item grayEnderBody;
	public static Item grayEnderLegs;
	public static Item grayEnderBoots;

	public static Item jungleHelmet;
	public static Item jungleBody;
	public static Item jungleLegs;
	public static Item jungleBoots;

	public static Item frozenHelmet;
	public static Item frozenBody;
	public static Item frozenLegs;
	public static Item frozenBoots;

	public static Item corruptedHelmet;
	public static Item corruptedBody;
	public static Item corruptedLegs;
	public static Item corruptedBoots;

	public static Item diamondHelmet;
	public static Item diamondBody;
	public static Item diamondLegs;
	public static Item diamondBoots;

	public static Item ironHelmet;
	public static Item ironBody;
	public static Item ironLegs;
	public static Item ironBoots;

	public static Item goldHelmet;
	public static Item goldBody;
	public static Item goldLegs;
	public static Item goldBoots;

	public static void init() {
    	Object[] angelicInfo             = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY,};
        angelicHelmet       = new ItemDivineArmor(EnumArmor.ANGELIC, HEAD, angelicInfo);
        angelicBody         = new ItemDivineArmor(EnumArmor.ANGELIC, BODY, angelicInfo);
        angelicLegs         = new ItemDivineArmor(EnumArmor.ANGELIC, LEGS, angelicInfo);
        angelicBoots        = new ItemDivineArmor(EnumArmor.ANGELIC, BOOTS, angelicInfo);

        Object[] divineInfo             = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
        divineHelmet        = new ItemDivineArmor(EnumArmor.DIVINE, HEAD, divineInfo);
        divineBody          = new ItemDivineArmor(EnumArmor.DIVINE, BODY, divineInfo);
        divineLegs          = new ItemDivineArmor(EnumArmor.DIVINE, LEGS, divineInfo);
        divineBoots         = new ItemDivineArmor(EnumArmor.DIVINE, BOOTS, divineInfo);

        Object[] bedrockInfo             = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
        bedrockHelmet       = new ItemDivineArmor(EnumArmor.BEDROCK, HEAD, bedrockInfo);
        bedrockBody         = new ItemDivineArmor(EnumArmor.BEDROCK, BODY, bedrockInfo);
        bedrockLegs         = new ItemDivineArmor(EnumArmor.BEDROCK, LEGS, bedrockInfo);
        bedrockBoots        = new ItemDivineArmor(EnumArmor.BEDROCK, BOOTS, bedrockInfo);

        realmiteHelmet      = new ItemDivineArmor(EnumArmor.REALMITE, HEAD);
        realmiteBody        = new ItemDivineArmor(EnumArmor.REALMITE, BODY);
        realmiteLegs        = new ItemDivineArmor(EnumArmor.REALMITE, LEGS);
        realmiteBoots       = new ItemDivineArmor(EnumArmor.REALMITE, BOOTS);

        Object[] eliteRealmiteInfo              = new Object[] { ArmorInfo.NO_FALL };
        eliteRealmiteHelmet = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, HEAD, eliteRealmiteInfo);
        eliteRealmiteBody   = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BODY, eliteRealmiteInfo);
        eliteRealmiteLegs   = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, LEGS, eliteRealmiteInfo);
        eliteRealmiteBoots  = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BOOTS, eliteRealmiteInfo);

        Object[] arlemiteInfo             = new Object[] { 85, ArmorInfo.RANGED_PROTECTION };
        arlemiteHelmet      = new ItemDivineArmor(EnumArmor.ARLEMITE, HEAD, arlemiteInfo);
        arlemiteBody        = new ItemDivineArmor(EnumArmor.ARLEMITE, BODY, arlemiteInfo);
        arlemiteLegs        = new ItemDivineArmor(EnumArmor.ARLEMITE, LEGS, arlemiteInfo);
        arlemiteBoots       = new ItemDivineArmor(EnumArmor.ARLEMITE, BOOTS, arlemiteInfo);

        Object[] rupeeInfo             = new Object[] { 85, ArmorInfo.MELEE_PROTECTION };
        rupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE, HEAD, rupeeInfo);
        rupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE, BODY, rupeeInfo);
        rupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE, LEGS, rupeeInfo);
        rupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE, BOOTS, rupeeInfo);
        yellowRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, HEAD, rupeeInfo);
        yellowRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, BODY, rupeeInfo);
        yellowRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, LEGS, rupeeInfo);
        yellowRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, BOOTS, rupeeInfo);
   redRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_RED, HEAD, rupeeInfo);
   redRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_RED, BODY, rupeeInfo);
   redRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_RED, LEGS, rupeeInfo);
   redRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_RED, BOOTS, rupeeInfo);
        greenRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, HEAD, rupeeInfo);
        greenRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, BODY, rupeeInfo);
        greenRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, LEGS, rupeeInfo);
        greenRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, BOOTS, rupeeInfo);
        blueRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, HEAD, rupeeInfo);
        blueRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, BODY, rupeeInfo);
        blueRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, LEGS, rupeeInfo);
        blueRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, BOOTS, rupeeInfo);
        grayRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, HEAD, rupeeInfo);
        grayRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, BODY, rupeeInfo);
        grayRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, LEGS, rupeeInfo);
        grayRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, BOOTS, rupeeInfo);

        Object[] krakenInfo              = new Object[] { ArmorInfo.UNDERWATER };
        krakenHelmet        = new ItemDivineArmor(EnumArmor.KRAKEN, HEAD, krakenInfo);
        krakenBody          = new ItemDivineArmor(EnumArmor.KRAKEN, BODY, krakenInfo);
        krakenLegs          = new ItemDivineArmor(EnumArmor.KRAKEN, LEGS, krakenInfo);
        krakenBoots         = new ItemDivineArmor(EnumArmor.KRAKEN, BOOTS, krakenInfo);

        Object[] jackomanInfo            = new Object[] { 3, ArmorInfo.SCYTHE_DAMAGE };
        jackOManHelmet      = new ItemDivineArmor(EnumArmor.JACKOMAN, HEAD, "jackOMan", jackomanInfo);
        jackOManBody        = new ItemDivineArmor(EnumArmor.JACKOMAN, BODY, "jackOMan", jackomanInfo);
        jackOManLegs        = new ItemDivineArmor(EnumArmor.JACKOMAN, LEGS, "jackOMan", jackomanInfo);
        jackOManBoots       = new ItemDivineArmor(EnumArmor.JACKOMAN, BOOTS, "jackOMan", jackomanInfo);

        Object[] infernoInfo             = new Object[] { ArmorInfo.FIRE_PROTECTION };
        infernoHelmet       = new ItemDivineArmor(EnumArmor.INFERNO, HEAD, infernoInfo);
        infernoBody         = new ItemDivineArmor(EnumArmor.INFERNO, BODY, infernoInfo);
        infernoLegs         = new ItemDivineArmor(EnumArmor.INFERNO, LEGS, infernoInfo);
        infernoBoots        = new ItemDivineArmor(EnumArmor.INFERNO, BOOTS, infernoInfo);

        Object[] aquastriveInfo              = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
        aquastriveHelmet    = new ItemDivineArmor(EnumArmor.AQUATIC, HEAD, aquastriveInfo);
        aquastriveBody      = new ItemDivineArmor(EnumArmor.AQUATIC, BODY, aquastriveInfo);
        aquastriveLegs      = new ItemDivineArmor(EnumArmor.AQUATIC, LEGS, aquastriveInfo);
        aquastriveBoots     = new ItemDivineArmor(EnumArmor.AQUATIC, BOOTS, aquastriveInfo);

        Object[] shadowInfo              = new Object[] { 3, ArmorInfo.SPEED };
        shadowHelmet        = new ItemDivineArmor(EnumArmor.SHADOW, HEAD, shadowInfo);
        shadowBody          = new ItemDivineArmor(EnumArmor.SHADOW, BODY, shadowInfo);
        shadowLegs          = new ItemDivineArmor(EnumArmor.SHADOW, LEGS, shadowInfo);
        shadowBoots         = new ItemDivineArmor(EnumArmor.SHADOW, BOOTS, shadowInfo);

        Object[] netheriteInfo            = new Object[] { ArmorInfo.FIRE_PROTECTION };
        netheriteHelmet     = new ItemDivineArmor(EnumArmor.NETHERITE, HEAD, netheriteInfo);
        netheriteBody       = new ItemDivineArmor(EnumArmor.NETHERITE, BODY, netheriteInfo);
        netheriteLegs       = new ItemDivineArmor(EnumArmor.NETHERITE, LEGS, netheriteInfo);
        netheriteBoots      = new ItemDivineArmor(EnumArmor.NETHERITE, BOOTS, netheriteInfo);

        Object[] skelemanInfo            = new Object[] { ArmorInfo.HUNGER };
        skelemanHelmet      = new ItemDivineArmor(EnumArmor.SKELEMAN, HEAD, "skeleman", skelemanInfo);
        skelemanBody        = new ItemDivineArmor(EnumArmor.SKELEMAN, BODY, "skeleman", skelemanInfo);
        skelemanLegs        = new ItemDivineArmor(EnumArmor.SKELEMAN, LEGS, "skeleman", skelemanInfo);
        skelemanBoots       = new ItemDivineArmor(EnumArmor.SKELEMAN, BOOTS, "skeleman", skelemanInfo);

        Object[] witherReaperInfo            = new Object[] { ArmorInfo.WITHER_PROTECTION };
        witherReaperHelmet  = new ItemDivineArmor(EnumArmor.WITHER_REAPER, HEAD, "witherReaper", witherReaperInfo);
        witherReaperBody    = new ItemDivineArmor(EnumArmor.WITHER_REAPER, BODY, "witherReaper", witherReaperInfo);
        witherReaperLegs    = new ItemDivineArmor(EnumArmor.WITHER_REAPER, LEGS, "witherReaper", witherReaperInfo);
        witherReaperBoots   = new ItemDivineArmor(EnumArmor.WITHER_REAPER, BOOTS, "witherReaper", witherReaperInfo);

        Object[] enderInfo             = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
        enderHelmet         = new ItemDivineArmor(EnumArmor.ENDER, HEAD, enderInfo);
        enderBody           = new ItemDivineArmor(EnumArmor.ENDER, BODY, enderInfo);
        enderLegs           = new ItemDivineArmor(EnumArmor.ENDER, LEGS, enderInfo);
        enderBoots          = new ItemDivineArmor(EnumArmor.ENDER, BOOTS, enderInfo);
        yellowEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, HEAD, enderInfo);
        yellowEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, BODY, enderInfo);
        yellowEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, LEGS, enderInfo);
        yellowEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, BOOTS, enderInfo);
        redEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_RED, HEAD, enderInfo);
        redEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_RED, BODY, enderInfo);
        redEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_RED, LEGS, enderInfo);
        redEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_RED, BOOTS, enderInfo);
        greenEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_GREEN, HEAD, enderInfo);
        greenEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_GREEN, BODY, enderInfo);
        greenEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_GREEN, LEGS, enderInfo);
        greenEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_GREEN, BOOTS, enderInfo);
        blueEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_BLUE, HEAD, enderInfo);
        blueEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_BLUE, BODY, enderInfo);
        blueEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_BLUE, LEGS, enderInfo);
        blueEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_BLUE, BOOTS, enderInfo);
        grayEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_GRAY, HEAD, enderInfo);
        grayEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_GRAY, BODY, enderInfo);
        grayEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_GRAY, LEGS, enderInfo);
        grayEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_GRAY, BOOTS, enderInfo);
        
        Object[] jungleInfo            = new Object[] { ArmorInfo.POISON_PROTECTION };
        jungleHelmet        = new ItemDivineArmor(EnumArmor.JUNGLE, HEAD, jungleInfo);
        jungleBody          = new ItemDivineArmor(EnumArmor.JUNGLE, BODY, jungleInfo);
        jungleLegs          = new ItemDivineArmor(EnumArmor.JUNGLE, LEGS, jungleInfo);
        jungleBoots         = new ItemDivineArmor(EnumArmor.JUNGLE, BOOTS, jungleInfo);
        
        Object[] frozenInfo            = new Object[] { ArmorInfo.FREEZE };
        frozenHelmet        = new ItemDivineArmor(EnumArmor.FROZEN, HEAD, frozenInfo);
        frozenBody          = new ItemDivineArmor(EnumArmor.FROZEN, BODY, frozenInfo);
        frozenLegs          = new ItemDivineArmor(EnumArmor.FROZEN, LEGS, frozenInfo);
        frozenBoots         = new ItemDivineArmor(EnumArmor.FROZEN, BOOTS, frozenInfo);
        
        Object[] corruptedInfo            = new Object[] { 20, ArmorInfo.RANGED_DAMAGE };
        corruptedHelmet        = new ItemDivineArmor(EnumArmor.CORRUPTED, HEAD, corruptedInfo);
        corruptedBody          = new ItemDivineArmor(EnumArmor.CORRUPTED, BODY, corruptedInfo);
        corruptedLegs          = new ItemDivineArmor(EnumArmor.CORRUPTED, LEGS, corruptedInfo);
        corruptedBoots         = new ItemDivineArmor(EnumArmor.CORRUPTED, BOOTS, corruptedInfo);
        
        diamondHelmet       = new ItemDivineArmor(EnumArmor.DIAMOND, HEAD);
        diamondBody         = new ItemDivineArmor(EnumArmor.DIAMOND, BODY);
        diamondLegs         = new ItemDivineArmor(EnumArmor.DIAMOND, LEGS);
        diamondBoots        = new ItemDivineArmor(EnumArmor.DIAMOND, BOOTS);
        
        ironHelmet          = new ItemDivineArmor(EnumArmor.IRON, HEAD);
        ironBody            = new ItemDivineArmor(EnumArmor.IRON, BODY);
        ironLegs            = new ItemDivineArmor(EnumArmor.IRON, LEGS);
        ironBoots           = new ItemDivineArmor(EnumArmor.IRON, BOOTS);
        
        goldHelmet          = new ItemDivineArmor(EnumArmor.GOLD, HEAD);
        goldBody            = new ItemDivineArmor(EnumArmor.GOLD, BODY);
        goldLegs            = new ItemDivineArmor(EnumArmor.GOLD, LEGS);
        goldBoots           = new ItemDivineArmor(EnumArmor.GOLD, BOOTS);
    }
}
