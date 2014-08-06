package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.entities.twilight.projectile.EntityApalachiaArrow;
import net.divinerpg.entities.twilight.projectile.EntityEdenArrow;
import net.divinerpg.entities.twilight.projectile.EntityHaliteArrow;
import net.divinerpg.entities.twilight.projectile.EntityMortumArrow;
import net.divinerpg.entities.twilight.projectile.EntitySkythernArrow;
import net.divinerpg.entities.twilight.projectile.EntityWildWoodArrow;
import net.divinerpg.items.twilight.ItemTwilightBlitz;
import net.divinerpg.items.twilight.ItemTwilightPhaser;
import net.divinerpg.items.vanilla.ItemThrowable;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;

public class TwilightItemsWeapons {
	
	public static final Item edenBlade          = new ItemModSword(ToolMaterialMod.Eden, "edenBlade");
    public static final Item wildwoodBlade      = new ItemModSword(ToolMaterialMod.Wildwood, "wildWoodBlade");
    public static final Item apalachiaBlade     = new ItemModSword(ToolMaterialMod.Apalachia, "apalachiaBlade");
    public static final Item skythernBlade      = new ItemModSword(ToolMaterialMod.Skythern, "skythernBlade");
    public static final Item mortumBlade        = new ItemModSword(ToolMaterialMod.Mortum, "mortumBlade");
    public static final Item haliteBlade        = new ItemModSword(ToolMaterialMod.Halite, "haliteBlade");
    
    public static final Item edenSlicer         = new ItemThrowable(12, "edenSlicer");
    public static final Item wildwoodSlicer     = new ItemThrowable(18, "wildWoodSlicer");
    public static final Item apalachiaSlicer    = new ItemThrowable(22, "apalachiaSlicer");
    public static final Item skythernSlicer     = new ItemThrowable(28, "skythernSlicer");
    public static final Item mortumSlicer       = new ItemThrowable(36, "mortumSlicer");
    public static final Item haliteSlicer       = new ItemThrowable(42, "haliteSlicer");

    public static final Item edenBlitz          = new ItemTwilightBlitz(14, "Eden Dust", "edenBlitz");
    public static final Item wildwoodBlitz      = new ItemTwilightBlitz(19, "WildWood Dust", "wildWoodBlitz");
    public static final Item apalachiaBlitz     = new ItemTwilightBlitz(22, "Apalachia Dust", "apalachiaBlitz");
    public static final Item skythernBlitz      = new ItemTwilightBlitz(27, "Skythern Dust", "skythernBlitz");
    public static final Item mortumBlitz        = new ItemTwilightBlitz(31, "Mortum Dust", "mortumBlitz");
    public static final Item haliteBlitz        = new ItemTwilightBlitz(33, "Mortum Dust", "haliteBlitz");

    public static final Item edenPhaser         = new ItemTwilightPhaser(24, "edenPhaser");
    public static final Item wildwoodPhaser     = new ItemTwilightPhaser(31, "wildWoodPhaser");
    public static final Item apalachiaPhaser    = new ItemTwilightPhaser(35, "apalachiaPhaser");
    public static final Item skythernPhaser     = new ItemTwilightPhaser(41, "skythernPhaser");
    public static final Item mortumPhaser       = new ItemTwilightPhaser(46, "mortumPhaser");
    public static final Item halitePhaser       = new ItemTwilightPhaser(51, "halitePhaser");
    
    public static final Item edenArrow          = new ItemMod("edenArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item wildwoodArrow      = new ItemMod("wildWoodArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item apalachiaArrow     = new ItemMod("apalachiaArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item skythernArrow      = new ItemMod("skythernArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item mortumArrow        = new ItemMod("mortumArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item haliteArrow        = new ItemMod("haliteArrow").setCreativeTab(DivineRPGTabs.ranged);

    public static final Item edenBow            = new ItemModBow("edenBow", -1, 21, edenArrow, EntityEdenArrow.class);
    public static final Item wildwoodBow        = new ItemModBow("wildWoodBow", -1, 31, wildwoodArrow, EntityWildWoodArrow.class);
    public static final Item apalachiaBow       = new ItemModBow("apalachiaBow", -1, 41, apalachiaArrow, EntityApalachiaArrow.class);
    public static final Item skythernBow        = new ItemModBow("skythernBow", -1, 46, skythernArrow, EntitySkythernArrow.class);
    public static final Item mortumBow          = new ItemModBow("mortumBow", -1, 51, mortumArrow, EntityMortumArrow.class);
    public static final Item haliteBow          = new ItemModBow("haliteBow", -1, 61, haliteArrow, EntityHaliteArrow.class);
    
    public static final Item corruptedBullet    = new ItemMod("corruptedBullet");
    
}
