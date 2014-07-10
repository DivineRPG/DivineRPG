package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemDivineArmor;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class TwilightItemsArmor {

    public static int             HEAD            = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    private static final Object[] edenInfo        = new Object[] { ChatFormats.TWILIGHT, 3, ArmorInfo.ORE_DROPS };
    public static final Item      edenHelmet      = new ItemDivineArmor(EnumArmor.EDEN, HEAD, edenInfo);
    public static final Item      edenBody        = new ItemDivineArmor(EnumArmor.EDEN, BODY, edenInfo);
    public static final Item      edenLegs        = new ItemDivineArmor(EnumArmor.EDEN, LEGS, edenInfo);
    public static final Item      edenBoots       = new ItemDivineArmor(EnumArmor.EDEN, BOOTS, edenInfo);

    private static final Object[] wildInfo        = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
    public static final Item      wildwoodHelmet  = new ItemDivineArmor(EnumArmor.WILD, HEAD, wildInfo);
    public static final Item      wildwoodBody    = new ItemDivineArmor(EnumArmor.WILD, BODY, wildInfo);
    public static final Item      wildwoodLegs    = new ItemDivineArmor(EnumArmor.WILD, LEGS, wildInfo);
    public static final Item      wildwoodBoots   = new ItemDivineArmor(EnumArmor.WILD, BOOTS, wildInfo);

    private static final Object[] apInfo          = new Object[] { ArmorInfo.BLOCK_PROTECTION };
    public static final Item      apalachiaHelmet = new ItemDivineArmor(EnumArmor.APALACHIA, HEAD, apInfo);
    public static final Item      apalachiaBody   = new ItemDivineArmor(EnumArmor.APALACHIA, BODY, apInfo);
    public static final Item      apalachiaLegs   = new ItemDivineArmor(EnumArmor.APALACHIA, LEGS, apInfo);
    public static final Item      apalachiaBoots  = new ItemDivineArmor(EnumArmor.APALACHIA, BOOTS, apInfo);

    private static final Object[] skyInfo         = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
    public static final Item      skythernHelmet  = new ItemDivineArmor(EnumArmor.SKYTHERN, HEAD, skyInfo);
    public static final Item      skythernBody    = new ItemDivineArmor(EnumArmor.SKYTHERN, BODY, skyInfo);
    public static final Item      skythernLegs    = new ItemDivineArmor(EnumArmor.SKYTHERN, LEGS, skyInfo);
    public static final Item      skythernBoots   = new ItemDivineArmor(EnumArmor.SKYTHERN, BOOTS, skyInfo);

    private static final Object[] mortInfo        = new Object[] { ArmorInfo.NIGHT_VISION };
    public static final Item      mortumHelmet    = new ItemDivineArmor(EnumArmor.MORTUM, HEAD, mortInfo);
    public static final Item      mortumBody      = new ItemDivineArmor(EnumArmor.MORTUM, BODY, mortInfo);
    public static final Item      mortumLegs      = new ItemDivineArmor(EnumArmor.MORTUM, LEGS, mortInfo);
    public static final Item      mortumBoots     = new ItemDivineArmor(EnumArmor.MORTUM, BOOTS, mortInfo);

    private static final Object[] halInfo         = new Object[] { 24, ArmorInfo.MELEE_DAMAGE };
    public static final Item      haliteHelmet    = new ItemDivineArmor(EnumArmor.HALITE, HEAD, halInfo);
    public static final Item      haliteBody      = new ItemDivineArmor(EnumArmor.HALITE, BODY, halInfo);
    public static final Item      haliteLegs      = new ItemDivineArmor(EnumArmor.HALITE, LEGS, halInfo);
    public static final Item      haliteBoots     = new ItemDivineArmor(EnumArmor.HALITE, BOOTS, halInfo);

}
