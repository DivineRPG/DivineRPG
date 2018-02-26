package naturix.divinerpg.utils;

import naturix.divinerpg.DivineRPG;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DivineRPGMaterials {
	//second to last number is damage value - 4
	public static final Item.ToolMaterial arlemiteSwordMaterial = EnumHelper.addToolMaterial("ARLEMITE", 2, 250, 6.0F, 2.0F, 14);
	public static final Item.ToolMaterial amthrimisSwordMaterial = EnumHelper.addToolMaterial("AMTHRIMIS", 2, 250, 3.0F, 1.0F, 1);
	public static final Item.ToolMaterial aquatoothSwordMaterial = EnumHelper.addToolMaterial("AQUATOOTH", 2, 250, 10.0F, 6.0F, 10);
	public static final Item.ToolMaterial arksianeSwordMaterial = EnumHelper.addToolMaterial("ARKSIANE", 2, 250, 14.0F, 10.0F, 14);
	public static final Item.ToolMaterial bedrockSwordMaterial = EnumHelper.addToolMaterial("BEDROCK", 2, 250, 14.0F, 10.0F, 14);
	public static final Item.ToolMaterial blackEnderSwordMaterial = EnumHelper.addToolMaterial("BLACKENDER", 2, 250, 16.0F, 12.0F, 16);
	public static final Item.ToolMaterial bloodgemSwordMaterial = EnumHelper.addToolMaterial("BLOODGEM", 2, 250, 15.0F, 11.0F, 15);
	public static final Item.ToolMaterial blueDivineSwordMaterial = EnumHelper.addToolMaterial("BLUEDIVINE", 2, 250, 22.0F, 18.0F, 22);
	public static final Item.ToolMaterial stormSwordMaterial = EnumHelper.addToolMaterial("STORM", 2, 250, 5.0F, 1.0F, 5);
	public static final Item.ToolMaterial rupeeSwordMaterial = EnumHelper.addToolMaterial("RUPEE", 2, 250, 5.0F, 1.0F, 5);
	
	//name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness);
	public static final ItemArmor.ArmorMaterial angelicArmorMaterial = EnumHelper.addArmorMaterial("ANGELIC", DivineRPG.modId + ":angelic", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial apalachiaArmorMaterial = EnumHelper.addArmorMaterial("APALACHIA", DivineRPG.modId + ":apalachia", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial aquastriveArmorMaterial = EnumHelper.addArmorMaterial("AQUASTRIVE", DivineRPG.modId + ":aquastrive", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial aquaticArmorMaterial = EnumHelper.addArmorMaterial("AQUATIC", DivineRPG.modId + ":aquatic", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial bedrockArmorMaterial = EnumHelper.addArmorMaterial("BEDROCK", DivineRPG.modId + ":bedrock", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial corruptedArmorMaterial = EnumHelper.addArmorMaterial("CORRUPTED", DivineRPG.modId + ":corrupted", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial degradedArmorMaterial = EnumHelper.addArmorMaterial("DEGRADED", DivineRPG.modId + ":degraded", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial demonizedArmorMaterial = EnumHelper.addArmorMaterial("DEMONIZED", DivineRPG.modId + ":demonized", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial divineArmorMaterial = EnumHelper.addArmorMaterial("DIVINE", DivineRPG.modId + ":divine", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial donatorArmorMaterial = EnumHelper.addArmorMaterial("DONATOR", DivineRPG.modId + ":donator", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial edenArmorMaterial = EnumHelper.addArmorMaterial("EDEN", DivineRPG.modId + ":eden", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial enderArmorMaterial = EnumHelper.addArmorMaterial("ENDER", DivineRPG.modId + ":ender", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial finishedArmorMaterial = EnumHelper.addArmorMaterial("FINISHED", DivineRPG.modId + ":finished", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial frozenArmorMaterial = EnumHelper.addArmorMaterial("FROZEN", DivineRPG.modId + ":frozen", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial glisteningArmorMaterial = EnumHelper.addArmorMaterial("GLISTENING", DivineRPG.modId + ":glistening", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial haliteArmorMaterial = EnumHelper.addArmorMaterial("HALITE", DivineRPG.modId + ":halite", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial infernoArmorMaterial = EnumHelper.addArmorMaterial("INFERNO", DivineRPG.modId + ":inferno", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial jackomanArmorMaterial = EnumHelper.addArmorMaterial("JACKOMAN", DivineRPG.modId + ":jackoman", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial jungleArmorMaterial = EnumHelper.addArmorMaterial("JUNGLE", DivineRPG.modId + ":jungle", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial kormaArmorMaterial = EnumHelper.addArmorMaterial("KORMA", DivineRPG.modId + ":korma", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial krakenArmorMaterial = EnumHelper.addArmorMaterial("KORMA", DivineRPG.modId + ":korma", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial mortumArmorMaterial = EnumHelper.addArmorMaterial("MORTUM", DivineRPG.modId + ":mortum", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial netheriteArmorMaterial = EnumHelper.addArmorMaterial("NETHERITE", DivineRPG.modId + ":netherite", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial realmiteArmorMaterial = EnumHelper.addArmorMaterial("REALMITE", DivineRPG.modId + ":realmite", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial rupeeArmorMaterial = EnumHelper.addArmorMaterial("RUPEE", DivineRPG.modId + ":rupee", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial shadowArmorMaterial = EnumHelper.addArmorMaterial("SHADOW", DivineRPG.modId + ":shadow", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial skelemanArmorMaterial = EnumHelper.addArmorMaterial("SKELEMAN", DivineRPG.modId + ":skeleman", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial skythernArmorMaterial = EnumHelper.addArmorMaterial("SKYTHERN", DivineRPG.modId + ":skythern", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial terranArmorMaterial = EnumHelper.addArmorMaterial("TERRAN", DivineRPG.modId + ":terran", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial tormentedArmorMaterial = EnumHelper.addArmorMaterial("TORMENTED", DivineRPG.modId + ":tormented", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial vemosArmorMaterial = EnumHelper.addArmorMaterial("VEMOS", DivineRPG.modId + ":vemos", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial wildwoodArmorMaterial = EnumHelper.addArmorMaterial("WILDWOOD", DivineRPG.modId + ":wildwood", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ItemArmor.ArmorMaterial witherreaperArmorMaterial = EnumHelper.addArmorMaterial("WITHERREAPER", DivineRPG.modId + ":witherreaper", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	}
