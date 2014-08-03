package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class VanillaItemsArmor {

    public static int             HEAD                = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    private static final Object[] angInfo             = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY };
    public static final Item      angelicHelmet       = new ItemDivineArmor(EnumArmor.ANGELIC, HEAD, angInfo);
    public static final Item      angelicBody         = new ItemDivineArmor(EnumArmor.ANGELIC, BODY, angInfo);
    public static final Item      angelicLegs         = new ItemDivineArmor(EnumArmor.ANGELIC, LEGS, angInfo);
    public static final Item      angelicBoots        = new ItemDivineArmor(EnumArmor.ANGELIC, BOOTS, angInfo);

    private static final Object[] divInfo             = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    public static final Item      divineHelmet        = new ItemDivineArmor(EnumArmor.DIVINE, HEAD, divInfo);
    public static final Item      divineBody          = new ItemDivineArmor(EnumArmor.DIVINE, BODY, divInfo);
    public static final Item      divineLegs          = new ItemDivineArmor(EnumArmor.DIVINE, LEGS, divInfo);
    public static final Item      divineBoots         = new ItemDivineArmor(EnumArmor.DIVINE, BOOTS, divInfo);

    private static final Object[] bedInfo             = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
    public static final Item      bedrockHelmet       = new ItemDivineArmor(EnumArmor.BEDROCK, HEAD, bedInfo);
    public static final Item      bedrockBody         = new ItemDivineArmor(EnumArmor.BEDROCK, BODY, bedInfo);
    public static final Item      bedrockLegs         = new ItemDivineArmor(EnumArmor.BEDROCK, LEGS, bedInfo);
    public static final Item      bedrockBoots        = new ItemDivineArmor(EnumArmor.BEDROCK, BOOTS, bedInfo);

    public static final Item      realmiteHelmet      = new ItemDivineArmor(EnumArmor.REALMITE, HEAD);
    public static final Item      realmiteBody        = new ItemDivineArmor(EnumArmor.REALMITE, BODY);
    public static final Item      realmiteLegs        = new ItemDivineArmor(EnumArmor.REALMITE, LEGS);
    public static final Item      realmiteBoots       = new ItemDivineArmor(EnumArmor.REALMITE, BOOTS);

    private static final Object[] elInfo              = new Object[] { ArmorInfo.NO_FALL };
    public static final Item      eliteRealmiteHelmet = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, HEAD, elInfo);
    public static final Item      eliteRealmiteBody   = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BODY, elInfo);
    public static final Item      eliteRealmiteLegs   = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, LEGS, elInfo);
    public static final Item      eliteRealmiteBoots  = new ItemDivineArmor(EnumArmor.ELITE_REALMITE, BOOTS, elInfo);

    private static final Object[] arlInfo             = new Object[] { 80, ArmorInfo.RANGED_PROTECTION };
    public static final Item      arlemiteHelmet      = new ItemDivineArmor(EnumArmor.ARLEMITE, HEAD, arlInfo);
    public static final Item      arlemiteBody        = new ItemDivineArmor(EnumArmor.ARLEMITE, BODY, arlInfo);
    public static final Item      arlemiteLegs        = new ItemDivineArmor(EnumArmor.ARLEMITE, LEGS, arlInfo);
    public static final Item      arlemiteBoots       = new ItemDivineArmor(EnumArmor.ARLEMITE, BOOTS, arlInfo);

    private static final Object[] rupInfo             = new Object[] { 80, ArmorInfo.MELEE_PROTECTION };
    public static final Item      rupeeHelmet         = new ItemDivineArmor(EnumArmor.RUPEE, HEAD, rupInfo);
    public static final Item      rupeeBody           = new ItemDivineArmor(EnumArmor.RUPEE, BODY, rupInfo);
    public static final Item      rupeeLegs           = new ItemDivineArmor(EnumArmor.RUPEE, LEGS, rupInfo);
    public static final Item      rupeeBoots          = new ItemDivineArmor(EnumArmor.RUPEE, BOOTS, rupInfo);

    private static final Object[] krInfo              = new Object[] { ArmorInfo.UNDERWATER };
    public static final Item      krakenHelmet        = new ItemDivineArmor(EnumArmor.KRAKEN, HEAD, krInfo);
    public static final Item      krakenBody          = new ItemDivineArmor(EnumArmor.KRAKEN, BODY, krInfo);
    public static final Item      krakenLegs          = new ItemDivineArmor(EnumArmor.KRAKEN, LEGS, krInfo);
    public static final Item      krakenBoots         = new ItemDivineArmor(EnumArmor.KRAKEN, BOOTS, krInfo);

    private static final Object[] jackInfo            = new Object[] { 4, ArmorInfo.SCYTHE_DAMAGE };
    public static final Item      jackOManHelmet      = new ItemDivineArmor(EnumArmor.COSTUMES, HEAD, "jackOMan", jackInfo);
    public static final Item      jackOManBody        = new ItemDivineArmor(EnumArmor.COSTUMES, BODY, "jackOMan", jackInfo);
    public static final Item      jackOManLegs        = new ItemDivineArmor(EnumArmor.COSTUMES, LEGS, "jackOMan", jackInfo);
    public static final Item      jackOManBoots       = new ItemDivineArmor(EnumArmor.COSTUMES, BOOTS, "jackOMan", jackInfo);

    private static final Object[] infInfo             = new Object[] { ArmorInfo.FIRE_PROTECTION };
    public static final Item      infernoHelmet       = new ItemDivineArmor(EnumArmor.INFERNO, HEAD, infInfo);
    public static final Item      infernoBody         = new ItemDivineArmor(EnumArmor.INFERNO, BODY, infInfo);
    public static final Item      infernoLegs         = new ItemDivineArmor(EnumArmor.INFERNO, LEGS, infInfo);
    public static final Item      infernoBoots        = new ItemDivineArmor(EnumArmor.INFERNO, BOOTS, infInfo);

    private static final Object[] aqInfo              = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
    public static final Item      aquastriveHelmet    = new ItemDivineArmor(EnumArmor.AQUATIC, HEAD, aqInfo);
    public static final Item      aquastriveBody      = new ItemDivineArmor(EnumArmor.AQUATIC, BODY, aqInfo);
    public static final Item      aquastriveLegs      = new ItemDivineArmor(EnumArmor.AQUATIC, LEGS, aqInfo);
    public static final Item      aquastriveBoots     = new ItemDivineArmor(EnumArmor.AQUATIC, BOOTS, aqInfo);

    private static final Object[] shInfo              = new Object[] { ArmorInfo.SPEED };
    public static final Item      shadowHelmet        = new ItemDivineArmor(EnumArmor.SHADOW, HEAD, shInfo);
    public static final Item      shadowBody          = new ItemDivineArmor(EnumArmor.SHADOW, BODY, shInfo);
    public static final Item      shadowLegs          = new ItemDivineArmor(EnumArmor.SHADOW, LEGS, shInfo);
    public static final Item      shadowBoots         = new ItemDivineArmor(EnumArmor.SHADOW, BOOTS, shInfo);

    private static final Object[] nethInfo            = new Object[] { ArmorInfo.FIRE_PROTECTION };
    public static final Item      netheriteHelmet     = new ItemDivineArmor(EnumArmor.NETHERITE, HEAD, nethInfo);
    public static final Item      netheriteBody       = new ItemDivineArmor(EnumArmor.NETHERITE, BODY, nethInfo);
    public static final Item      netheriteLegs       = new ItemDivineArmor(EnumArmor.NETHERITE, LEGS, nethInfo);
    public static final Item      netheriteBoots      = new ItemDivineArmor(EnumArmor.NETHERITE, BOOTS, nethInfo);

    private static final Object[] skelInfo            = new Object[] { ArmorInfo.HUNGER };
    public static final Item      skelemanHelmet      = new ItemDivineArmor(EnumArmor.COSTUMES, HEAD, "skeleman", skelInfo);
    public static final Item      skelemanBody        = new ItemDivineArmor(EnumArmor.COSTUMES, BODY, "skeleman", skelInfo);
    public static final Item      skelemanLegs        = new ItemDivineArmor(EnumArmor.COSTUMES, LEGS, "skeleman", skelInfo);
    public static final Item      skelemanBoots       = new ItemDivineArmor(EnumArmor.COSTUMES, BOOTS, "skeleman", skelInfo);

    private static final Object[] withInfo            = new Object[] { ArmorInfo.WITHER_PROTECTION };
    public static final Item      witherReaperHelmet  = new ItemDivineArmor(EnumArmor.COSTUMES, HEAD, "witherReaper", withInfo);
    public static final Item      witherReaperBody    = new ItemDivineArmor(EnumArmor.COSTUMES, BODY, "witherReaper", withInfo);
    public static final Item      witherReaperLegs    = new ItemDivineArmor(EnumArmor.COSTUMES, LEGS, "witherReaper", withInfo);
    public static final Item      witherReaperBoots   = new ItemDivineArmor(EnumArmor.COSTUMES, BOOTS, "witherReaper", withInfo);

    private static final Object[] endInfo             = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
    public static final Item      enderHelmet         = new ItemDivineArmor(EnumArmor.ENDER, HEAD, endInfo);
    public static final Item      enderBody           = new ItemDivineArmor(EnumArmor.ENDER, BODY, endInfo);
    public static final Item      enderLegs           = new ItemDivineArmor(EnumArmor.ENDER, LEGS, endInfo);
    public static final Item      enderBoots          = new ItemDivineArmor(EnumArmor.ENDER, BOOTS, endInfo);
    
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
