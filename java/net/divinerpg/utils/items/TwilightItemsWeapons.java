package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.twilight.ItemTwilightBlitz;
import net.divinerpg.items.vanilla.ItemProjectileShooter;
import net.divinerpg.items.vanilla.ItemThrowable;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;

public class TwilightItemsWeapons {

	private static EntityResourceLocation x;

	public static Item edenBlade;
	public static Item wildwoodBlade;
	public static Item apalachiaBlade;
	public static Item skythernBlade;
	public static Item mortumBlade;
	public static Item haliteBlade;

	public static Item edenSlicer;
	public static Item wildwoodSlicer;
	public static Item apalachiaSlicer;
	public static Item skythernSlicer;
	public static Item mortumSlicer;
	public static Item haliteSlicer;

	public static Item edenBlitz;
	public static Item wildwoodBlitz;
	public static Item apalachiaBlitz;
	public static Item skythernBlitz;
	public static Item mortumBlitz;
	public static Item haliteBlitz;

	public static Item edenPhaser;
	public static Item wildwoodPhaser;
	public static Item apalachiaPhaser;
	public static Item skythernPhaser;
	public static Item mortumPhaser;
	public static Item halitePhaser;

	public static Item edenArrow;
	public static Item wildwoodArrow;
	public static Item furyArrow;

	public static Item edenBow;
	public static Item wildwoodBow;
	public static Item apalachiaBow;
	public static Item skythernBow;
	public static Item mortumBow;
	public static Item haliteBow;
	public static Item twilightBow;
	
	public static void init() {
		edenBlade          = new ItemModSword(ToolMaterialMod.Eden, "edenBlade");
	    wildwoodBlade      = new ItemModSword(ToolMaterialMod.Wildwood, "wildwoodBlade");
	    apalachiaBlade     = new ItemModSword(ToolMaterialMod.Apalachia, "apalachiaBlade");
	    skythernBlade      = new ItemModSword(ToolMaterialMod.Skythern, "skythernBlade");
	    mortumBlade        = new ItemModSword(ToolMaterialMod.Mortum, "mortumBlade");
	    haliteBlade        = new ItemModSword(ToolMaterialMod.Halite, "haliteBlade");
	    
	    edenSlicer         = new ItemThrowable(12, "edenSlicer");
	    wildwoodSlicer     = new ItemThrowable(18, "wildwoodSlicer");
	    apalachiaSlicer    = new ItemThrowable(22, "apalachiaSlicer");
	    skythernSlicer     = new ItemThrowable(28, "skythernSlicer");
	    mortumSlicer       = new ItemThrowable(36, "mortumSlicer");
	    haliteSlicer       = new ItemThrowable(42, "haliteSlicer");

	    edenBlitz          = new ItemTwilightBlitz("edenBlitz", x.blitzEden.toString(), TwilightItemsOther.edenDust, 14F).setHasParticle("eden");
	    wildwoodBlitz      = new ItemTwilightBlitz("wildwoodBlitz", x.blitzWild.toString(), TwilightItemsOther.wildwoodDust, 19F).setHasParticle("wildwood");
	    apalachiaBlitz     = new ItemTwilightBlitz("apalachiaBlitz", x.blitzApalachia.toString(), TwilightItemsOther.apalachiaDust, 22F).setHasParticle("apalachia");
	    skythernBlitz      = new ItemTwilightBlitz("skythernBlitz", x.blitzSkythern.toString(), TwilightItemsOther.skythernDust, 27F).setHasParticle("skythern");
	    mortumBlitz        = new ItemTwilightBlitz("mortumBlitz", x.blitzMortum.toString(), TwilightItemsOther.mortumDust, 31F).setHasParticle("mortum");
	    haliteBlitz        = new ItemTwilightBlitz("haliteBlitz", x.blitzHalite.toString(), TwilightItemsOther.mortumDust, 33F).setHasParticle("halite");

	    edenPhaser         = new ItemProjectileShooter("edenPhaser", 24F, Sounds.phaser.getPrefixedName(), x.phaserEden.toString(), 3000, 3).setHasParticle("eden");
	    wildwoodPhaser     = new ItemProjectileShooter("wildwoodPhaser", 31F, Sounds.phaser.getPrefixedName(), x.phaserWild.toString(), 3000, 3).setHasParticle("wildwood");
	    apalachiaPhaser    = new ItemProjectileShooter("apalachiaPhaser", 35F, Sounds.phaser.getPrefixedName(), x.phaserApalachia.toString(), 3000, 3).setHasParticle("apalachia");
	    skythernPhaser     = new ItemProjectileShooter("skythernPhaser", 41F, Sounds.phaser.getPrefixedName(), x.phaserSkythern.toString(), 3000, 3).setHasParticle("skythern");
	    mortumPhaser       = new ItemProjectileShooter("mortumPhaser", 46F, Sounds.phaser.getPrefixedName(), x.phaserMortum.toString(), 3000, 3).setHasParticle("mortum");
	    halitePhaser       = new ItemProjectileShooter("halitePhaser", 51F, Sounds.phaser.getPrefixedName(), x.phaserHalite.toString(), 3000, 3).setHasParticle("halite");
	    
	    edenArrow          = new ItemMod("edenArrow").setCreativeTab(DivineRPGTabs.ranged);
	    wildwoodArrow      = new ItemMod("wildwoodArrow").setCreativeTab(DivineRPGTabs.ranged);
	    furyArrow          = new ItemMod("furyArrow").setCreativeTab(DivineRPGTabs.ranged);

	    edenBow            = new ItemModBow("edenBow", -1, 10, 31, edenArrow);
	    wildwoodBow        = new ItemModBow("wildwoodBow", -1, 10, 31, 36000, wildwoodArrow);
	    apalachiaBow       = new ItemModBow("apalachiaBow", -1, 15, 46, wildwoodArrow);
	    skythernBow        = new ItemModBow("skythernBow", -1, 15, 46, 36000, wildwoodArrow);
	    mortumBow          = new ItemModBow("mortumBow", -1, 20, 61, furyArrow);
	    haliteBow          = new ItemModBow("haliteBow", -1, 20, 61, 36000, furyArrow);
	    twilightBow        = new ItemModBow("twilightBow", -1, 20, 61, 14400, furyArrow);
	}
}
