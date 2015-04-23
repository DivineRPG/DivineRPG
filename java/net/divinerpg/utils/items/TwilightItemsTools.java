package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemModAxe;
import net.divinerpg.items.base.ItemModPickaxe;
import net.divinerpg.items.base.ItemModShovel;
import net.divinerpg.items.base.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class TwilightItemsTools {

	public static Item edenPickaxe;
	public static Item wildwoodPickaxe;
	public static Item apalachiaPickaxe;
	public static Item skythernPickaxe;
	public static Item mortumPickaxe;

	public static Item edenAxe;
	public static Item wildwoodAxe;
	public static Item apalachiaAxe;
	public static Item skythernAxe;
	public static Item mortumAxe;

	public static Item edenShovel;
	public static Item wildwoodShovel;
	public static Item apalachiaShovel;
	public static Item skythernShovel;
	public static Item mortumShovel;
	
	public static void init() {

	    edenPickaxe        = new ItemModPickaxe(ToolMaterialMod.EdenPick, "edenPickaxe");
	    wildwoodPickaxe    = new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildwoodPickaxe");
	    apalachiaPickaxe   = new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachiaPickaxe");
	    skythernPickaxe    = new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythernPickaxe");
	    mortumPickaxe      = new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortumPickaxe");

	    edenAxe            = new ItemModAxe(ToolMaterialMod.EdenAxe, "edenAxe");
	    wildwoodAxe        = new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildwoodAxe");
	    apalachiaAxe       = new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachiaAxe");
	    skythernAxe        = new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythernAxe");
	    mortumAxe          = new ItemModAxe(ToolMaterialMod.MortumAxe, "mortumAxe");

	    edenShovel         = new ItemModShovel(ToolMaterialMod.EdenSpade, "edenShovel");
	    wildwoodShovel     = new ItemModShovel(ToolMaterialMod.WildwoodSpade, "wildwoodShovel");
	    apalachiaShovel    = new ItemModShovel(ToolMaterialMod.ApalachiaSpade, "apalachiaShovel");
	    skythernShovel     = new ItemModShovel(ToolMaterialMod.SkythernSpade, "skythernShovel");
	    mortumShovel       = new ItemModShovel(ToolMaterialMod.MortumSpade, "mortumShovel");
	}

}
