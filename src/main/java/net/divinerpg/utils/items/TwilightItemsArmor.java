package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemDivineArmor;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.utils.enums.ArmorInfo;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.item.Item;

public class TwilightItemsArmor {

	public static int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

	private static Object[] edenInfo = new Object[] { 3, ArmorInfo.ORE_DROPS };
	public static Item edenHelmet = new ItemDivineArmor(EnumArmor.EDEN, HEAD, edenInfo);
	public static Item edenChestplate = new ItemDivineArmor(EnumArmor.EDEN, BODY, edenInfo);
	public static Item edenLeggings = new ItemDivineArmor(EnumArmor.EDEN, LEGS, edenInfo);
	public static Item edenBoots = new ItemDivineArmor(EnumArmor.EDEN, BOOTS, edenInfo);

	private static Object[] wildInfo = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
	public static Item wildwoodHelmet = new ItemDivineArmor(EnumArmor.WILD, HEAD, wildInfo);
	public static Item wildwoodChestplate = new ItemDivineArmor(EnumArmor.WILD, BODY, wildInfo);
	public static Item wildwoodLeggings = new ItemDivineArmor(EnumArmor.WILD, LEGS, wildInfo);
	public static Item wildwoodBoots = new ItemDivineArmor(EnumArmor.WILD, BOOTS, wildInfo);

	private static Object[] apInfo = new Object[] { ArmorInfo.BLOCK_PROTECTION };
	public static Item apalachiaHelmet = new ItemDivineArmor(EnumArmor.APALACHIA, HEAD, apInfo);
	public static Item apalachiaChestplate = new ItemDivineArmor(EnumArmor.APALACHIA, BODY, apInfo);
	public static Item apalachiaLeggings = new ItemDivineArmor(EnumArmor.APALACHIA, LEGS, apInfo);
	public static Item apalachiaBoots = new ItemDivineArmor(EnumArmor.APALACHIA, BOOTS, apInfo);

	private static Object[] skyInfo = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	public static Item skythernHelmet = new ItemDivineArmor(EnumArmor.SKYTHERN, HEAD, skyInfo);
	public static Item skythernChestplate = new ItemDivineArmor(EnumArmor.SKYTHERN, BODY, skyInfo);
	public static Item skythernLeggings = new ItemDivineArmor(EnumArmor.SKYTHERN, LEGS, skyInfo);
	public static Item skythernBoots = new ItemDivineArmor(EnumArmor.SKYTHERN, BOOTS, skyInfo);

	private static Object[] mortInfo = new Object[] { ArmorInfo.NIGHT_VISION };
	public static Item mortumHelmet = new ItemDivineArmor(EnumArmor.MORTUM, HEAD, mortInfo);
	public static Item mortumChestplate = new ItemDivineArmor(EnumArmor.MORTUM, BODY, mortInfo);
	public static Item mortumLeggings = new ItemDivineArmor(EnumArmor.MORTUM, LEGS, mortInfo);
	public static Item mortumBoots = new ItemDivineArmor(EnumArmor.MORTUM, BOOTS, mortInfo);

	private static Object[] halInfo = new Object[] { 16, ArmorInfo.MELEE_DAMAGE };
	public static Item haliteHelmet = new ItemDivineArmor(EnumArmor.HALITE, HEAD, halInfo);
	public static Item haliteChestplate = new ItemDivineArmor(EnumArmor.HALITE, BODY, halInfo);
	public static Item haliteLeggings = new ItemDivineArmor(EnumArmor.HALITE, LEGS, halInfo);
	public static Item haliteBoots = new ItemDivineArmor(EnumArmor.HALITE, BOOTS, halInfo);

	public static void init() {}
}
