package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class TwilightItemsArmor {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static Item edenHelmet;
	public static Item edenBody;
	public static Item edenLegs;
	public static Item edenBoots;

	public static Item wildwoodHelmet;
	public static Item wildwoodBody;
	public static Item wildwoodLegs;
	public static Item wildwoodBoots;

	public static Item apalachiaHelmet;
	public static Item apalachiaBody;
	public static Item apalachiaLegs;
	public static Item apalachiaBoots;

	public static Item skythernHelmet;
	public static Item skythernBody;
	public static Item skythernLegs;
	public static Item skythernBoots;

	public static Item mortumHelmet;
	public static Item mortumBody;
	public static Item mortumLegs;
	public static Item mortumBoots;

	public static Item haliteHelmet;
	public static Item haliteBody;
	public static Item haliteLegs;
	public static Item haliteBoots;
	
	public static void init() {
		Object[] edenInfo        = new Object[] { 3, ArmorInfo.ORE_DROPS };
	    edenHelmet      = new ItemDivineArmor(EnumArmor.EDEN, HEAD, edenInfo);
	    edenBody        = new ItemDivineArmor(EnumArmor.EDEN, BODY, edenInfo);
	    edenLegs        = new ItemDivineArmor(EnumArmor.EDEN, LEGS, edenInfo);
	    edenBoots       = new ItemDivineArmor(EnumArmor.EDEN, BOOTS, edenInfo);

	    Object[] wildInfo        = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
	    wildwoodHelmet  = new ItemDivineArmor(EnumArmor.WILD, HEAD, wildInfo);
	    wildwoodBody    = new ItemDivineArmor(EnumArmor.WILD, BODY, wildInfo);
	    wildwoodLegs    = new ItemDivineArmor(EnumArmor.WILD, LEGS, wildInfo);
	    wildwoodBoots   = new ItemDivineArmor(EnumArmor.WILD, BOOTS, wildInfo);

	    Object[] apInfo          = new Object[] { ArmorInfo.BLOCK_PROTECTION };
	    apalachiaHelmet = new ItemDivineArmor(EnumArmor.APALACHIA, HEAD, apInfo);
	    apalachiaBody   = new ItemDivineArmor(EnumArmor.APALACHIA, BODY, apInfo);
	    apalachiaLegs   = new ItemDivineArmor(EnumArmor.APALACHIA, LEGS, apInfo);
	    apalachiaBoots  = new ItemDivineArmor(EnumArmor.APALACHIA, BOOTS, apInfo);

	    Object[] skyInfo         = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	    skythernHelmet  = new ItemDivineArmor(EnumArmor.SKYTHERN, HEAD, skyInfo);
	    skythernBody    = new ItemDivineArmor(EnumArmor.SKYTHERN, BODY, skyInfo);
	    skythernLegs    = new ItemDivineArmor(EnumArmor.SKYTHERN, LEGS, skyInfo);
	    skythernBoots   = new ItemDivineArmor(EnumArmor.SKYTHERN, BOOTS, skyInfo);

	    Object[] mortInfo        = new Object[] { ArmorInfo.NIGHT_VISION };
	    mortumHelmet    = new ItemDivineArmor(EnumArmor.MORTUM, HEAD, mortInfo);
	    mortumBody      = new ItemDivineArmor(EnumArmor.MORTUM, BODY, mortInfo);
	    mortumLegs      = new ItemDivineArmor(EnumArmor.MORTUM, LEGS, mortInfo);
	    mortumBoots     = new ItemDivineArmor(EnumArmor.MORTUM, BOOTS, mortInfo);

	    Object[] halInfo         = new Object[] { 24, ArmorInfo.MELEE_DAMAGE };
	    haliteHelmet    = new ItemDivineArmor(EnumArmor.HALITE, HEAD, halInfo);
	    haliteBody      = new ItemDivineArmor(EnumArmor.HALITE, BODY, halInfo);
	    haliteLegs      = new ItemDivineArmor(EnumArmor.HALITE, LEGS, halInfo);
	    haliteBoots     = new ItemDivineArmor(EnumArmor.HALITE, BOOTS, halInfo);
	}

}
