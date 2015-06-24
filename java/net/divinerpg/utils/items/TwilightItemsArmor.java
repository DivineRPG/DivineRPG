package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class TwilightItemsArmor {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	public static Item edenHelmet;
	public static Item edenChestplate;
	public static Item edenLeggings;
	public static Item edenBoots;

	public static Item wildwoodHelmet;
	public static Item wildwoodChestplate;
	public static Item wildwoodLeggings;
	public static Item wildwoodBoots;

	public static Item apalachiaHelmet;
	public static Item apalachiaChestplate;
	public static Item apalachiaLeggings;
	public static Item apalachiaBoots;

	public static Item skythernHelmet;
	public static Item skythernChestplate;
	public static Item skythernLeggings;
	public static Item skythernBoots;

	public static Item mortumHelmet;
	public static Item mortumChestplate;
	public static Item mortumLeggings;
	public static Item mortumBoots;

	public static Item haliteHelmet;
	public static Item haliteChestplate;
	public static Item haliteLeggings;
	public static Item haliteBoots;
	
	public static void init() {
		Object[] edenInfo   = new Object[] { 3, ArmorInfo.ORE_DROPS };
	    edenHelmet      	= new ItemDivineArmor(EnumArmor.EDEN, HEAD, edenInfo);
	    edenChestplate      = new ItemDivineArmor(EnumArmor.EDEN, BODY, edenInfo);
	    edenLeggings        = new ItemDivineArmor(EnumArmor.EDEN, LEGS, edenInfo);
	    edenBoots       	= new ItemDivineArmor(EnumArmor.EDEN, BOOTS, edenInfo);

	    Object[] wildInfo   = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
	    wildwoodHelmet    	= new ItemDivineArmor(EnumArmor.WILD, HEAD, wildInfo);
	    wildwoodChestplate  = new ItemDivineArmor(EnumArmor.WILD, BODY, wildInfo);
	    wildwoodLeggings    = new ItemDivineArmor(EnumArmor.WILD, LEGS, wildInfo);
	    wildwoodBoots       = new ItemDivineArmor(EnumArmor.WILD, BOOTS, wildInfo);

	    Object[] apInfo     = new Object[] { ArmorInfo.BLOCK_PROTECTION };
	    apalachiaHelmet 	= new ItemDivineArmor(EnumArmor.APALACHIA, HEAD, apInfo);
	    apalachiaChestplate = new ItemDivineArmor(EnumArmor.APALACHIA, BODY, apInfo);
	    apalachiaLeggings   = new ItemDivineArmor(EnumArmor.APALACHIA, LEGS, apInfo);
	    apalachiaBoots  	= new ItemDivineArmor(EnumArmor.APALACHIA, BOOTS, apInfo);

	    Object[] skyInfo    = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	    skythernHelmet  	= new ItemDivineArmor(EnumArmor.SKYTHERN, HEAD, skyInfo);
	    skythernChestplate  = new ItemDivineArmor(EnumArmor.SKYTHERN, BODY, skyInfo);
	    skythernLeggings    = new ItemDivineArmor(EnumArmor.SKYTHERN, LEGS, skyInfo);
	    skythernBoots  		= new ItemDivineArmor(EnumArmor.SKYTHERN, BOOTS, skyInfo);

	    Object[] mortInfo   = new Object[] { ArmorInfo.NIGHT_VISION };
	    mortumHelmet    	= new ItemDivineArmor(EnumArmor.MORTUM, HEAD, mortInfo);
	    mortumChestplate    = new ItemDivineArmor(EnumArmor.MORTUM, BODY, mortInfo);
	    mortumLeggings      = new ItemDivineArmor(EnumArmor.MORTUM, LEGS, mortInfo);
	    mortumBoots     	= new ItemDivineArmor(EnumArmor.MORTUM, BOOTS, mortInfo);

	    Object[] halInfo    = new Object[] { 16, ArmorInfo.MELEE_DAMAGE };
	    haliteHelmet    	= new ItemDivineArmor(EnumArmor.HALITE, HEAD, halInfo);
	    haliteChestplate    = new ItemDivineArmor(EnumArmor.HALITE, BODY, halInfo);
	    haliteLeggings      = new ItemDivineArmor(EnumArmor.HALITE, LEGS, halInfo);
	    haliteBoots     	= new ItemDivineArmor(EnumArmor.HALITE, BOOTS, halInfo);
	}

}
