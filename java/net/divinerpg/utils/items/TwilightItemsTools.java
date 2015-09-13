package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemModAxe;
import net.divinerpg.items.base.ItemModPickaxe;
import net.divinerpg.items.base.ItemModShovel;
import net.divinerpg.items.base.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class TwilightItemsTools {

	public static Item edenPickaxe = new ItemModPickaxe(ToolMaterialMod.EdenPick, "edenPickaxe");
	public static Item wildwoodPickaxe = new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildwoodPickaxe");
	public static Item apalachiaPickaxe = new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachiaPickaxe");
	public static Item skythernPickaxe = new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythernPickaxe");
	public static Item mortumPickaxe = new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortumPickaxe");

	public static Item edenAxe = new ItemModAxe(ToolMaterialMod.EdenAxe, "edenAxe");
	public static Item wildwoodAxe = new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildwoodAxe");
	public static Item apalachiaAxe = new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachiaAxe");
	public static Item skythernAxe = new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythernAxe");
	public static Item mortumAxe = new ItemModAxe(ToolMaterialMod.MortumAxe, "mortumAxe");

	public static Item edenShovel = new ItemModShovel(ToolMaterialMod.EdenSpade, "edenShovel");
	public static Item wildwoodShovel = new ItemModShovel(ToolMaterialMod.WildwoodSpade, "wildwoodShovel");
	public static Item apalachiaShovel = new ItemModShovel(ToolMaterialMod.ApalachiaSpade, "apalachiaShovel");
	public static Item skythernShovel = new ItemModShovel(ToolMaterialMod.SkythernSpade, "skythernShovel");
	public static Item mortumShovel = new ItemModShovel(ToolMaterialMod.MortumSpade, "mortumShovel");

	public static void init() {}
}
