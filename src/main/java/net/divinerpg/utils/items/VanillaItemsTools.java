package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemModAxe;
import net.divinerpg.items.base.ItemModHoe;
import net.divinerpg.items.base.ItemModPickaxe;
import net.divinerpg.items.base.ItemModShovel;
import net.divinerpg.items.base.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class VanillaItemsTools {

	public static Item rupeeShickaxe = new ItemShickaxe(ToolMaterialMod.RupeeShick, "rupeeShickaxe");
	public static Item rupeePickaxe = new ItemModPickaxe(ToolMaterialMod.RupeePick, "rupeePickaxe");
	public static Item rupeeAxe = new ItemModAxe(ToolMaterialMod.RupeeAxe, "rupeeAxe");
	public static Item rupeeShovel = new ItemModShovel(ToolMaterialMod.RupeeSpade, "rupeeShovel");
	public static Item rupeeHoe = new ItemModHoe(ToolMaterialMod.RupeePick, "rupeeHoe");

	public static Item arlemiteShickaxe = new ItemShickaxe(ToolMaterialMod.ArlemiteShick, "arlemiteShickaxe");
	public static Item arlemitePickaxe = new ItemModPickaxe(ToolMaterialMod.ArlemitePick, "arlemitePickaxe");
	public static Item arlemiteAxe = new ItemModAxe(ToolMaterialMod.ArlemiteAxe, "arlemiteAxe");
	public static Item arlemiteShovel = new ItemModShovel(ToolMaterialMod.ArlemiteSpade, "arlemiteShovel");
	public static Item arlemiteHoe = new ItemModHoe(ToolMaterialMod.ArlemitePick, "arlemiteHoe");

	public static Item realmitePickaxe = new ItemModPickaxe(ToolMaterialMod.RealmitePick, "realmitePickaxe");
	public static Item realmiteAxe = new ItemModAxe(ToolMaterialMod.RealmiteAxe, "realmiteAxe");
	public static Item realmiteShovel = new ItemModShovel(ToolMaterialMod.RealmiteSpade, "realmiteShovel");
	public static Item realmiteHoe = new ItemModHoe(ToolMaterialMod.RealmitePick, "realmiteHoe");

	public static Item bedrockPickaxe = new ItemModPickaxe(ToolMaterialMod.BedrockPick, "bedrockPickaxe");
	public static Item bedrockAxe = new ItemModAxe(ToolMaterialMod.BedrockAxe, "bedrockAxe");
	public static Item bedrockShovel = new ItemModShovel(ToolMaterialMod.BedrockSpade, "bedrockShovel");

	public static Item corruptedPickaxe = new ItemModPickaxe(ToolMaterialMod.CorruptedPick, "corruptedPickaxe");
	public static Item corruptedAxe = new ItemModAxe(ToolMaterialMod.CorruptedAxe, "corruptedAxe");
	public static Item corruptedShovel = new ItemModShovel(ToolMaterialMod.CorruptedSpade, "corruptedShovel");

	public static Item divineShickaxe = new ItemShickaxe(ToolMaterialMod.DivineShick, "divineShickaxe");
	public static Item divinePickaxe = new ItemModPickaxe(ToolMaterialMod.DivinePick, "divinePickaxe");
	public static Item divineAxe = new ItemModAxe(ToolMaterialMod.DivineAxe, "divineAxe");
	public static Item divineShovel = new ItemModShovel(ToolMaterialMod.DivineSpade, "divineShovel");

	public static void init() {}

}
