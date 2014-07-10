package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemModAxe;
import net.divinerpg.api.items.ItemModHoe;
import net.divinerpg.api.items.ItemModPickaxe;
import net.divinerpg.api.items.ItemModShovel;
import net.divinerpg.api.items.ItemShickaxe;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.item.Item;

public class VanillaItemsTools {

	public static final Item rupeeShickaxe      = new ItemShickaxe(ToolMaterialMod.RupeeShick, "rupeeShickaxe");
    public static final Item rupeePickaxe       = new ItemModPickaxe(ToolMaterialMod.RupeePick, "rupeePickaxe");
    public static final Item rupeeAxe           = new ItemModAxe(ToolMaterialMod.RupeeAxe, "rupeeAxe");
    public static final Item rupeeShovel        = new ItemModShovel(ToolMaterialMod.RupeeSpade, "rupeeShovel");
    public static final Item rupeeHoe           = new ItemModHoe(ToolMaterialMod.RupeePick, "rupeeHoe");

    public static final Item arlemiteShickaxe   = new ItemShickaxe(ToolMaterialMod.ArlemiteShick, "arlemiteShickaxe");
    public static final Item arlemitePickaxe    = new ItemModPickaxe(ToolMaterialMod.ArlemitePick, "arlemitePickaxe");
    public static final Item arlemiteAxe        = new ItemModAxe(ToolMaterialMod.ArlemiteAxe, "arlemiteAxe");
    public static final Item arlemiteShovel     = new ItemModShovel(ToolMaterialMod.ArlemiteSpade, "arlemiteShovel");
    public static final Item arlemiteHoe        = new ItemModHoe(ToolMaterialMod.ArlemitePick, "arlemiteHoe");

    public static final Item realmitePickaxe    = new ItemModPickaxe(ToolMaterialMod.RealmitePick, "realmitePickaxe");
    public static final Item realmiteAxe        = new ItemModAxe(ToolMaterialMod.RealmiteAxe, "realmiteAxe");
    public static final Item realmiteShovel     = new ItemModShovel(ToolMaterialMod.RealmiteSpade, "realmiteShovel");
    public static final Item realmiteHoe        = new ItemModHoe(ToolMaterialMod.RealmitePick, "realmiteHoe");

    public static final Item bedrockPickaxe     = new ItemModPickaxe(ToolMaterialMod.BedrockPick, "bedrockPickaxe");
    public static final Item bedrockAxe         = new ItemModAxe(ToolMaterialMod.BedrockAxe, "bedrockAxe");
    public static final Item bedrockShovel      = new ItemModShovel(ToolMaterialMod.BedrockSpade, "bedrockShovel");

    public static final Item corruptedPickaxe   = new ItemModPickaxe(ToolMaterialMod.CorruptedPick, "corruptedPickaxe");
    public static final Item corruptedAxe       = new ItemModAxe(ToolMaterialMod.CorruptedAxe, "corruptedAxe");
    public static final Item corruptedShovel    = new ItemModShovel(ToolMaterialMod.CorruptedSpade, "corruptedShovel");
    
    public static final Item divineShickaxe     = new ItemShickaxe(ToolMaterialMod.DivineShick, "divineShickaxe");
    public static final Item divinePickaxe      = new ItemModPickaxe(ToolMaterialMod.DivinePick, "divinePickaxe");
    public static final Item divineAxe          = new ItemModAxe(ToolMaterialMod.DivineAxe, "divineAxe");
    public static final Item divineShovel       = new ItemModShovel(ToolMaterialMod.DivineSpade, "divineShovel");
    
}
