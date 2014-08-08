package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemModAxe;
import net.divinerpg.api.items.ItemModPickaxe;
import net.divinerpg.api.items.ItemModShovel;
import net.divinerpg.api.items.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class TwilightItemsTools {
	
	public static final Item edenShickaxe       = new ItemShickaxe(ToolMaterialMod.EdenShick, "edenShickaxe");
    public static final Item wildwoodShickaxe   = new ItemShickaxe(ToolMaterialMod.WildwoodShick, "wildWoodShickaxe");
    public static final Item apalachiaShickaxe  = new ItemShickaxe(ToolMaterialMod.ApalachiaShick, "apalachiaShickaxe");
    public static final Item skythernShickaxe   = new ItemShickaxe(ToolMaterialMod.SkythernShick, "skythernShickaxe");
    public static final Item mortumShickaxe     = new ItemShickaxe(ToolMaterialMod.MortumShick, "mortumShickaxe");

    public static final Item edenPickaxe        = new ItemModPickaxe(ToolMaterialMod.EdenPick, "edenPickaxe");
    public static final Item wildwoodPickaxe    = new ItemModPickaxe(ToolMaterialMod.WildwoodPick, "wildWoodPickaxe");
    public static final Item apalachiaPickaxe   = new ItemModPickaxe(ToolMaterialMod.ApalachiaPick, "apalachiaPickaxe");
    public static final Item skythernPickaxe    = new ItemModPickaxe(ToolMaterialMod.SkythernPick, "skythernPickaxe");
    public static final Item mortumPickaxe      = new ItemModPickaxe(ToolMaterialMod.MortumPick, "mortumPickaxe");

    public static final Item edenAxe            = new ItemModAxe(ToolMaterialMod.EdenAxe, "edenAxe");
    public static final Item wildwoodAxe        = new ItemModAxe(ToolMaterialMod.WildwoodAxe, "wildWoodAxe");
    public static final Item apalachiaAxe       = new ItemModAxe(ToolMaterialMod.ApalachiaAxe, "apalachiaAxe");
    public static final Item skythernAxe        = new ItemModAxe(ToolMaterialMod.SkythernAxe, "skythernAxe");
    public static final Item mortumAxe          = new ItemModAxe(ToolMaterialMod.MortumAxe, "mortumAxe");

    public static final Item edenShovel         = new ItemModShovel(ToolMaterialMod.EdenSpade, "edenShovel");
    public static final Item wildwoodShovel     = new ItemModShovel(ToolMaterialMod.WildwoodSpade, "wildWoodShovel");
    public static final Item apalachiaShovel    = new ItemModShovel(ToolMaterialMod.ApalachiaSpade, "apalachiaShovel");
    public static final Item skythernShovel     = new ItemModShovel(ToolMaterialMod.SkythernSpade, "skythernShovel");
    public static final Item mortumShovel       = new ItemModShovel(ToolMaterialMod.MortumSpade, "mortumShovel");

}
