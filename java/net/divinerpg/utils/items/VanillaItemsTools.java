package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemModAxe;
import net.divinerpg.items.base.ItemModHoe;
import net.divinerpg.items.base.ItemModPickaxe;
import net.divinerpg.items.base.ItemModShovel;
import net.divinerpg.items.base.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class VanillaItemsTools {

	public static Item rupeeShickaxe;
	public static Item rupeePickaxe;
	public static Item rupeeAxe;
	public static Item rupeeShovel;
	public static Item rupeeHoe;

	public static Item arlemiteShickaxe;
	public static Item arlemitePickaxe;
	public static Item arlemiteAxe;
	public static Item arlemiteShovel;
	public static Item arlemiteHoe;

	public static Item realmitePickaxe;
	public static Item realmiteAxe;
	public static Item realmiteShovel;
	public static Item realmiteHoe;

	public static Item bedrockPickaxe;
	public static Item bedrockAxe;
	public static Item bedrockShovel;

	public static Item corruptedPickaxe;
	public static Item corruptedAxe;
	public static Item corruptedShovel;

	public static Item divineShickaxe;
	public static Item divinePickaxe;
	public static Item divineAxe;
	public static Item divineShovel;
	
	public static void init() {
		rupeeShickaxe      = new ItemShickaxe(ToolMaterialMod.RupeeShick, "rupeeShickaxe");
	    rupeePickaxe       = new ItemModPickaxe(ToolMaterialMod.RupeePick, "rupeePickaxe");
	    rupeeAxe           = new ItemModAxe(ToolMaterialMod.RupeeAxe, "rupeeAxe");
	    rupeeShovel        = new ItemModShovel(ToolMaterialMod.RupeeSpade, "rupeeShovel");
	    rupeeHoe           = new ItemModHoe(ToolMaterialMod.RupeePick, "rupeeHoe");

	    arlemiteShickaxe   = new ItemShickaxe(ToolMaterialMod.ArlemiteShick, "arlemiteShickaxe");
	    arlemitePickaxe    = new ItemModPickaxe(ToolMaterialMod.ArlemitePick, "arlemitePickaxe");
	    arlemiteAxe        = new ItemModAxe(ToolMaterialMod.ArlemiteAxe, "arlemiteAxe");
	    arlemiteShovel     = new ItemModShovel(ToolMaterialMod.ArlemiteSpade, "arlemiteShovel");
	    arlemiteHoe        = new ItemModHoe(ToolMaterialMod.ArlemitePick, "arlemiteHoe");

	    realmitePickaxe    = new ItemModPickaxe(ToolMaterialMod.RealmitePick, "realmitePickaxe");
	    realmiteAxe        = new ItemModAxe(ToolMaterialMod.RealmiteAxe, "realmiteAxe");
	    realmiteShovel     = new ItemModShovel(ToolMaterialMod.RealmiteSpade, "realmiteShovel");
	    realmiteHoe        = new ItemModHoe(ToolMaterialMod.RealmitePick, "realmiteHoe");

	    bedrockPickaxe     = new ItemModPickaxe(ToolMaterialMod.BedrockPick, "bedrockPickaxe");
	    bedrockAxe         = new ItemModAxe(ToolMaterialMod.BedrockAxe, "bedrockAxe");
	    bedrockShovel      = new ItemModShovel(ToolMaterialMod.BedrockSpade, "bedrockShovel");

	    corruptedPickaxe   = new ItemModPickaxe(ToolMaterialMod.CorruptedPick, "corruptedPickaxe");
	    corruptedAxe       = new ItemModAxe(ToolMaterialMod.CorruptedAxe, "corruptedAxe");
	    corruptedShovel    = new ItemModShovel(ToolMaterialMod.CorruptedSpade, "corruptedShovel");
	    
	    divineShickaxe     = new ItemShickaxe(ToolMaterialMod.DivineShick, "divineShickaxe");
	    divinePickaxe      = new ItemModPickaxe(ToolMaterialMod.DivinePick, "divinePickaxe");
	    divineAxe          = new ItemModAxe(ToolMaterialMod.DivineAxe, "divineAxe");
	    divineShovel       = new ItemModShovel(ToolMaterialMod.DivineSpade, "divineShovel");
	}

}
