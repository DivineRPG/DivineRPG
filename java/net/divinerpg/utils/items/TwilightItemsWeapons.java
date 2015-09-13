package net.divinerpg.utils.items;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemModBow;
import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.items.base.ItemThrowable;
import net.divinerpg.items.twilight.ItemTwilightBlitz;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.Item;

public class TwilightItemsWeapons {

	private static EntityResourceLocation x;

	public static Item edenBlade = new ItemModSword(ToolMaterialMod.Eden, "edenBlade");
	public static Item wildwoodBlade = new ItemModSword(ToolMaterialMod.Wildwood, "wildwoodBlade");
	public static Item apalachiaBlade = new ItemModSword(ToolMaterialMod.Apalachia, "apalachiaBlade");
	public static Item skythernBlade = new ItemModSword(ToolMaterialMod.Skythern, "skythernBlade");
	public static Item mortumBlade = new ItemModSword(ToolMaterialMod.Mortum, "mortumBlade");
	public static Item haliteBlade = new ItemModSword(ToolMaterialMod.Halite, "haliteBlade");

	public static Item edenSlicer = new ItemThrowable("edenSlicer", 8);
	public static Item wildwoodSlicer = new ItemThrowable("wildwoodSlicer", 10);
	public static Item apalachiaSlicer = new ItemThrowable("apalachiaSlicer", 12);
	public static Item skythernSlicer = new ItemThrowable("skythernSlicer", 14);
	public static Item mortumSlicer = new ItemThrowable("mortumSlicer", 16);
	public static Item haliteSlicer = new ItemThrowable("haliteSlicer", 22);

	public static Item edenBlitz = new ItemTwilightBlitz("edenBlitz", x.blitzEden.toString(), TwilightItemsOther.edenDust, 10F).setHasParticle("eden");
	public static Item wildwoodBlitz = new ItemTwilightBlitz("wildwoodBlitz", x.blitzWild.toString(), TwilightItemsOther.wildwoodDust, 12F).setHasParticle("wildwood");
	public static Item apalachiaBlitz = new ItemTwilightBlitz("apalachiaBlitz", x.blitzApalachia.toString(), TwilightItemsOther.apalachiaDust, 14F).setHasParticle("apalachia");
	public static Item skythernBlitz = new ItemTwilightBlitz("skythernBlitz", x.blitzSkythern.toString(), TwilightItemsOther.skythernDust, 16F).setHasParticle("skythern");
	public static Item mortumBlitz = new ItemTwilightBlitz("mortumBlitz", x.blitzMortum.toString(), TwilightItemsOther.mortumDust, 18F).setHasParticle("mortum");
	public static Item haliteBlitz = new ItemTwilightBlitz("haliteBlitz", x.blitzHalite.toString(), TwilightItemsOther.mortumDust, 20F).setHasParticle("halite");

	public static Item edenPhaser = new ItemProjectileShooter("edenPhaser", 14F, Sounds.phaser.getPrefixedName(), x.phaserEden.toString(), 3000, 3).setHasParticle("eden");
	public static Item wildwoodPhaser = new ItemProjectileShooter("wildwoodPhaser", 17F, Sounds.phaser.getPrefixedName(), x.phaserWild.toString(), 3000, 3).setHasParticle("wildwood");
	public static Item apalachiaPhaser = new ItemProjectileShooter("apalachiaPhaser", 20F, Sounds.phaser.getPrefixedName(), x.phaserApalachia.toString(), 3000, 3).setHasParticle("apalachia");
	public static Item skythernPhaser = new ItemProjectileShooter("skythernPhaser", 23F, Sounds.phaser.getPrefixedName(), x.phaserSkythern.toString(), 3000, 3).setHasParticle("skythern");
	public static Item mortumPhaser = new ItemProjectileShooter("mortumPhaser", 26F, Sounds.phaser.getPrefixedName(), x.phaserMortum.toString(), 3000, 3).setHasParticle("mortum");
	public static Item halitePhaser = new ItemProjectileShooter("halitePhaser", 29F, Sounds.phaser.getPrefixedName(), x.phaserHalite.toString(), 3000, 3).setHasParticle("halite");

	public static Item edenArrow = new ItemMod("edenArrow").setCreativeTab(DivineRPGTabs.ranged);
	public static Item wildwoodArrow = new ItemMod("wildwoodArrow").setCreativeTab(DivineRPGTabs.ranged);
	public static Item furyArrow = new ItemMod("furyArrow").setCreativeTab(DivineRPGTabs.ranged);

	public static Item edenBow = new ItemModBow("edenBow", -1, 6, 16, edenArrow);
	public static Item wildwoodBow = new ItemModBow("wildwoodBow", -1, 6, 16, 36000, wildwoodArrow);
	public static Item apalachiaBow = new ItemModBow("apalachiaBow", -1, 10, 20, wildwoodArrow);
	public static Item skythernBow = new ItemModBow("skythernBow", -1, 10, 20, 36000, wildwoodArrow);
	public static Item mortumBow = new ItemModBow("mortumBow", -1, 13, 25, furyArrow);
	public static Item haliteBow = new ItemModBow("haliteBow", -1, 13, 25, 36000, furyArrow);
	public static Item twilightBow = new ItemModBow("twilightBow", -1, 13, 25, 14400, furyArrow).setCreativeTab(null);
	
	public static void init() {}
}
