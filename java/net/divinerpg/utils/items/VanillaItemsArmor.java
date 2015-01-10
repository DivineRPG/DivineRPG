package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class VanillaItemsArmor {

    public static int             HEAD                = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    private static final Object[] angelicInfo             = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY,};
    public static final Item      angelicHelmet       = new ItemDivineArmor(EnumArmor.ANGELIC, HEAD, angelicInfo);
    public static final Item      angelicBody         = new ItemDivineArmor(EnumArmor.ANGELIC, BODY, angelicInfo);
    public static final Item      angelicLegs         = new ItemDivineArmor(EnumArmor.ANGELIC, LEGS, angelicInfo);
    public static final Item      angelicBoots        = new ItemDivineArmor(EnumArmor.ANGELIC, BOOTS, angelicInfo);

    private static final Object[] divineInfo             = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    public static final Item      divineHelmet        = new ItemDivineArmor(EnumArmor.DIVINE, HEAD, divineInfo);
    public static final Item      divineBody          = new ItemDivineArmor(EnumArmor.DIVINE, BODY, divineInfo);
    public static final Item      divineLegs          = new ItemDivineArmor(EnumArmor.DIVINE, LEGS, divineInfo);
    public static final Item      divineBoots         = new ItemDivineArmor(EnumArmor.DIVINE, BOOTS, divineInfo);

    private static final Object[] bedrockInfo             = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
    public static final Item      bedrockHelmet       = new ItemDivineArmor(EnumArmor.BEDROCK, HEAD, bedrockInfo);
    public static final Item      bedrockBody         = new ItemDivineArmor(EnumArmor.BEDROCK, BODY, bedrockInfo);
    public static final Item      bedrockLegs         = new ItemDivineArmor(EnumArmor.BEDROCK, LEGS, bedrockInfo);
    public static final Item      bedrockBoots        = new ItemDivineArmor(EnumArmor.BEDROCK, BOOTS, bedrockInfo);

    public static final Item      realmiteHelmet      = new ItemDivineArmor(EnumArmor.REALMITE, HEAD);
    public static final Item      realmiteBody        = new ItemDivineArmor(EnumArmor.REALMITE, BODY);
    public static final Item      realmiteLegs        = new ItemDivineArmor(EnumArmor.REALMITE, LEGS);
    public static final Item      realmiteBoots       = new ItemDivineArmor(EnumArmor.REALMITE, BOOTS);

    private static final Object[] eliteRealmiteInfo              = new Object[] { ArmorInfo.NO_FALL };
    public static final Item      eliteRealmiteHelmet = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, HEAD, eliteRealmiteInfo);
    public static final Item      eliteRealmiteBody   = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BODY, eliteRealmiteInfo);
    public static final Item      eliteRealmiteLegs   = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, LEGS, eliteRealmiteInfo);
    public static final Item      eliteRealmiteBoots  = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BOOTS, eliteRealmiteInfo);

    private static final Object[] arlemiteInfo             = new Object[] { 80, ArmorInfo.RANGED_PROTECTION };
    public static final Item      arlemiteHelmet      = new ItemDivineArmor(EnumArmor.ARLEMITE, HEAD, arlemiteInfo);
    public static final Item      arlemiteBody        = new ItemDivineArmor(EnumArmor.ARLEMITE, BODY, arlemiteInfo);
    public static final Item      arlemiteLegs        = new ItemDivineArmor(EnumArmor.ARLEMITE, LEGS, arlemiteInfo);
    public static final Item      arlemiteBoots       = new ItemDivineArmor(EnumArmor.ARLEMITE, BOOTS, arlemiteInfo);

    private static final Object[] rupeeInfo             = new Object[] { 80, ArmorInfo.MELEE_PROTECTION };
    public static final Item      rupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE, HEAD, rupeeInfo);
    public static final Item      rupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE, BODY, rupeeInfo);
    public static final Item      rupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE, LEGS, rupeeInfo);
    public static final Item      rupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE, BOOTS, rupeeInfo);
    public static final Item     yellowRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, HEAD, rupeeInfo);
    public static final Item     yellowRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, BODY, rupeeInfo);
    public static final Item     yellowRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, LEGS, rupeeInfo);
    public static final Item     yellowRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_YELLOW, BOOTS, rupeeInfo);
    public static final Item     redRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_RED, HEAD, rupeeInfo);
    public static final Item     redRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_RED, BODY, rupeeInfo);
    public static final Item     redRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_RED, LEGS, rupeeInfo);
    public static final Item     redRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_RED, BOOTS, rupeeInfo);
    public static final Item     greenRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, HEAD, rupeeInfo);
    public static final Item     greenRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, BODY, rupeeInfo);
    public static final Item     greenRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, LEGS, rupeeInfo);
    public static final Item     greenRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_GREEN, BOOTS, rupeeInfo);
    public static final Item     blueRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, HEAD, rupeeInfo);
    public static final Item     blueRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, BODY, rupeeInfo);
    public static final Item     blueRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, LEGS, rupeeInfo);
    public static final Item     blueRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_BLUE, BOOTS, rupeeInfo);
    public static final Item     grayRupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, HEAD, rupeeInfo);
    public static final Item     grayRupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, BODY, rupeeInfo);
    public static final Item     grayRupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, LEGS, rupeeInfo);
    public static final Item     grayRupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE_GRAY, BOOTS, rupeeInfo);

    private static final Object[] krakenInfo              = new Object[] { ArmorInfo.UNDERWATER };
    public static final Item      krakenHelmet        = new ItemDivineArmor(EnumArmor.KRAKEN, HEAD, krakenInfo);
    public static final Item      krakenBody          = new ItemDivineArmor(EnumArmor.KRAKEN, BODY, krakenInfo);
    public static final Item      krakenLegs          = new ItemDivineArmor(EnumArmor.KRAKEN, LEGS, krakenInfo);
    public static final Item      krakenBoots         = new ItemDivineArmor(EnumArmor.KRAKEN, BOOTS, krakenInfo);

    private static final Object[] jackomanInfo            = new Object[] { 4, ArmorInfo.SCYTHE_DAMAGE };
    public static final Item      jackOManHelmet      = new ItemDivineArmor(EnumArmor.JACKOMAN, HEAD, "jackOMan", jackomanInfo);
    public static final Item      jackOManBody        = new ItemDivineArmor(EnumArmor.JACKOMAN, BODY, "jackOMan", jackomanInfo);
    public static final Item      jackOManLegs        = new ItemDivineArmor(EnumArmor.JACKOMAN, LEGS, "jackOMan", jackomanInfo);
    public static final Item      jackOManBoots       = new ItemDivineArmor(EnumArmor.JACKOMAN, BOOTS, "jackOMan", jackomanInfo);

    private static final Object[] infernoInfo             = new Object[] { ArmorInfo.FIRE_PROTECTION };
    public static final Item      infernoHelmet       = new ItemDivineArmor(EnumArmor.INFERNO, HEAD, infernoInfo);
    public static final Item      infernoBody         = new ItemDivineArmor(EnumArmor.INFERNO, BODY, infernoInfo);
    public static final Item      infernoLegs         = new ItemDivineArmor(EnumArmor.INFERNO, LEGS, infernoInfo);
    public static final Item      infernoBoots        = new ItemDivineArmor(EnumArmor.INFERNO, BOOTS, infernoInfo);

    private static final Object[] aquastriveInfo              = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
    public static final Item      aquastriveHelmet    = new ItemDivineArmor(EnumArmor.AQUATIC, HEAD, aquastriveInfo);
    public static final Item      aquastriveBody      = new ItemDivineArmor(EnumArmor.AQUATIC, BODY, aquastriveInfo);
    public static final Item      aquastriveLegs      = new ItemDivineArmor(EnumArmor.AQUATIC, LEGS, aquastriveInfo);
    public static final Item      aquastriveBoots     = new ItemDivineArmor(EnumArmor.AQUATIC, BOOTS, aquastriveInfo);

    private static final Object[] shadowInfo              = new Object[] { 3, ArmorInfo.SPEED };
    public static final Item      shadowHelmet        = new ItemDivineArmor(EnumArmor.SHADOW, HEAD, shadowInfo);
    public static final Item      shadowBody          = new ItemDivineArmor(EnumArmor.SHADOW, BODY, shadowInfo);
    public static final Item      shadowLegs          = new ItemDivineArmor(EnumArmor.SHADOW, LEGS, shadowInfo);
    public static final Item      shadowBoots         = new ItemDivineArmor(EnumArmor.SHADOW, BOOTS, shadowInfo);

    private static final Object[] netheriteInfo            = new Object[] { ArmorInfo.FIRE_PROTECTION };
    public static final Item      netheriteHelmet     = new ItemDivineArmor(EnumArmor.NETHERITE, HEAD, netheriteInfo);
    public static final Item      netheriteBody       = new ItemDivineArmor(EnumArmor.NETHERITE, BODY, netheriteInfo);
    public static final Item      netheriteLegs       = new ItemDivineArmor(EnumArmor.NETHERITE, LEGS, netheriteInfo);
    public static final Item      netheriteBoots      = new ItemDivineArmor(EnumArmor.NETHERITE, BOOTS, netheriteInfo);

    private static final Object[] skelemanInfo            = new Object[] { ArmorInfo.HUNGER };
    public static final Item      skelemanHelmet      = new ItemDivineArmor(EnumArmor.SKELEMAN, HEAD, "skeleman", skelemanInfo);
    public static final Item      skelemanBody        = new ItemDivineArmor(EnumArmor.SKELEMAN, BODY, "skeleman", skelemanInfo);
    public static final Item      skelemanLegs        = new ItemDivineArmor(EnumArmor.SKELEMAN, LEGS, "skeleman", skelemanInfo);
    public static final Item      skelemanBoots       = new ItemDivineArmor(EnumArmor.SKELEMAN, BOOTS, "skeleman", skelemanInfo);

    private static final Object[] witherReaperInfo            = new Object[] { ArmorInfo.WITHER_PROTECTION };
    public static final Item      witherReaperHelmet  = new ItemDivineArmor(EnumArmor.WITHER_REAPER, HEAD, "witherReaper", witherReaperInfo);
    public static final Item      witherReaperBody    = new ItemDivineArmor(EnumArmor.WITHER_REAPER, BODY, "witherReaper", witherReaperInfo);
    public static final Item      witherReaperLegs    = new ItemDivineArmor(EnumArmor.WITHER_REAPER, LEGS, "witherReaper", witherReaperInfo);
    public static final Item      witherReaperBoots   = new ItemDivineArmor(EnumArmor.WITHER_REAPER, BOOTS, "witherReaper", witherReaperInfo);

    private static final Object[] enderInfo             = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
    public static final Item      enderHelmet         = new ItemDivineArmor(EnumArmor.ENDER, HEAD, enderInfo);
    public static final Item      enderBody           = new ItemDivineArmor(EnumArmor.ENDER, BODY, enderInfo);
    public static final Item      enderLegs           = new ItemDivineArmor(EnumArmor.ENDER, LEGS, enderInfo);
    public static final Item      enderBoots          = new ItemDivineArmor(EnumArmor.ENDER, BOOTS, enderInfo);
    public static final Item     yellowEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, HEAD, enderInfo);
    public static final Item     yellowEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, BODY, enderInfo);
    public static final Item     yellowEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, LEGS, enderInfo);
    public static final Item     yellowEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_YELLOW, BOOTS, enderInfo);
    public static final Item     redEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_RED, HEAD, enderInfo);
    public static final Item     redEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_RED, BODY, enderInfo);
    public static final Item     redEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_RED, LEGS, enderInfo);
    public static final Item     redEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_RED, BOOTS, enderInfo);
    public static final Item     greenEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_GREEN, HEAD, enderInfo);
    public static final Item     greenEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_GREEN, BODY, enderInfo);
    public static final Item     greenEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_GREEN, LEGS, enderInfo);
    public static final Item     greenEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_GREEN, BOOTS, enderInfo);
    public static final Item     blueEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_BLUE, HEAD, enderInfo);
    public static final Item     blueEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_BLUE, BODY, enderInfo);
    public static final Item     blueEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_BLUE, LEGS, enderInfo);
    public static final Item     blueEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_BLUE, BOOTS, enderInfo);
    public static final Item     grayEnderHelmet         = new ItemDivineArmor(EnumArmor.ENDER_GRAY, HEAD, enderInfo);
    public static final Item     grayEnderBody           = new ItemDivineArmor(EnumArmor.ENDER_GRAY, BODY, enderInfo);
    public static final Item     grayEnderLegs           = new ItemDivineArmor(EnumArmor.ENDER_GRAY, LEGS, enderInfo);
    public static final Item     grayEnderBoots          = new ItemDivineArmor(EnumArmor.ENDER_GRAY, BOOTS, enderInfo);
    
    private static final Object[] jungleInfo            = new Object[] { ArmorInfo.POISON_PROTECTION };
    public static final Item      jungleHelmet        = new ItemDivineArmor(EnumArmor.JUNGLE, HEAD, jungleInfo);
    public static final Item      jungleBody          = new ItemDivineArmor(EnumArmor.JUNGLE, BODY, jungleInfo);
    public static final Item      jungleLegs          = new ItemDivineArmor(EnumArmor.JUNGLE, LEGS, jungleInfo);
    public static final Item      jungleBoots         = new ItemDivineArmor(EnumArmor.JUNGLE, BOOTS, jungleInfo);
    
    private static final Object[] frozenInfo            = new Object[] { ArmorInfo.FREEZE };
    public static final Item      frozenHelmet        = new ItemDivineArmor(EnumArmor.FROZEN, HEAD, frozenInfo);
    public static final Item      frozenBody          = new ItemDivineArmor(EnumArmor.FROZEN, BODY, frozenInfo);
    public static final Item      frozenLegs          = new ItemDivineArmor(EnumArmor.FROZEN, LEGS, frozenInfo);
    public static final Item      frozenBoots         = new ItemDivineArmor(EnumArmor.FROZEN, BOOTS, frozenInfo);
    
    private static final Object[] corruptedInfo            = new Object[] { 20, ArmorInfo.RANGED_DAMAGE };
    public static final Item      corruptedHelmet        = new ItemDivineArmor(EnumArmor.CORRUPTED, HEAD, corruptedInfo);
    public static final Item      corruptedBody          = new ItemDivineArmor(EnumArmor.CORRUPTED, BODY, corruptedInfo);
    public static final Item      corruptedLegs          = new ItemDivineArmor(EnumArmor.CORRUPTED, LEGS, corruptedInfo);
    public static final Item      corruptedBoots         = new ItemDivineArmor(EnumArmor.CORRUPTED, BOOTS, corruptedInfo);
    
    public static final Item      diamondHelmet       = new ItemDivineArmor(EnumArmor.DIAMOND, HEAD);
    public static final Item      diamondBody         = new ItemDivineArmor(EnumArmor.DIAMOND, BODY);
    public static final Item      diamondLegs         = new ItemDivineArmor(EnumArmor.DIAMOND, LEGS);
    public static final Item      diamondBoots        = new ItemDivineArmor(EnumArmor.DIAMOND, BOOTS);
    
    public static final Item      ironHelmet          = new ItemDivineArmor(EnumArmor.IRON, HEAD);
    public static final Item      ironBody            = new ItemDivineArmor(EnumArmor.IRON, BODY);
    public static final Item      ironLegs            = new ItemDivineArmor(EnumArmor.IRON, LEGS);
    public static final Item      ironBoots           = new ItemDivineArmor(EnumArmor.IRON, BOOTS);
    
    public static final Item      goldHelmet          = new ItemDivineArmor(EnumArmor.GOLD, HEAD);
    public static final Item      goldBody            = new ItemDivineArmor(EnumArmor.GOLD, BODY);
    public static final Item      goldLegs            = new ItemDivineArmor(EnumArmor.GOLD, LEGS);
    public static final Item      goldBoots           = new ItemDivineArmor(EnumArmor.GOLD, BOOTS);
    
    public static final Item      leatherHelmet       = new ItemDivineArmor(EnumArmor.LEATHER, HEAD);
    public static final Item      leatherBody         = new ItemDivineArmor(EnumArmor.LEATHER, BODY);
    public static final Item      leatherLegs         = new ItemDivineArmor(EnumArmor.LEATHER, LEGS);
    public static final Item      leatherBoots        = new ItemDivineArmor(EnumArmor.LEATHER, BOOTS);
}
