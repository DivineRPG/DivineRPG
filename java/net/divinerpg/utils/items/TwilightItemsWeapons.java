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

    public static final Item edenBlitz          = new ItemTwilightBlitz("edenBlitz", x.blitzEden.toString(), TwilightItemsOther.edenDust, 14F).setHasParticle("eden");
    public static final Item wildwoodBlitz      = new ItemTwilightBlitz("wildWoodBlitz", x.blitzWild.toString(), TwilightItemsOther.wildwoodDust, 19F).setHasParticle("wildwood");
    public static final Item apalachiaBlitz     = new ItemTwilightBlitz("apalachiaBlitz", x.blitzApalachia.toString(), TwilightItemsOther.apalachiaDust, 22F).setHasParticle("apalachia");
    public static final Item skythernBlitz      = new ItemTwilightBlitz("skythernBlitz", x.blitzSkythern.toString(), TwilightItemsOther.skythernDust, 27F).setHasParticle("skythern");
    public static final Item mortumBlitz        = new ItemTwilightBlitz("mortumBlitz", x.blitzMortum.toString(), TwilightItemsOther.mortumDust, 31F).setHasParticle("mortum");
    public static final Item haliteBlitz        = new ItemTwilightBlitz("haliteBlitz", x.blitzHalite.toString(), TwilightItemsOther.mortumDust, 33F).setHasParticle("halite");

    public static final Item edenPhaser         = new ItemProjectileShooter("edenPhaser", 24F, Sounds.phaser.getPrefixedName(), x.phaserEden.toString(), 3000, 3).setHasParticle("eden");
    public static final Item wildwoodPhaser     = new ItemProjectileShooter("wildWoodPhaser", 31F, Sounds.phaser.getPrefixedName(), x.phaserWild.toString(), 3000, 3).setHasParticle("wildwood");
    public static final Item apalachiaPhaser    = new ItemProjectileShooter("apalachiaPhaser", 35F, Sounds.phaser.getPrefixedName(), x.phaserApalachia.toString(), 3000, 3).setHasParticle("apalachia");
    public static final Item skythernPhaser     = new ItemProjectileShooter("skythernPhaser", 41F, Sounds.phaser.getPrefixedName(), x.phaserSkythern.toString(), 3000, 3).setHasParticle("skythern");
    public static final Item mortumPhaser       = new ItemProjectileShooter("mortumPhaser", 46F, Sounds.phaser.getPrefixedName(), x.phaserMortum.toString(), 3000, 3).setHasParticle("mortum");
    public static final Item halitePhaser       = new ItemProjectileShooter("halitePhaser", 51F, Sounds.phaser.getPrefixedName(), x.phaserHalite.toString(), 3000, 3).setHasParticle("halite");
    
    public static final Item edenArrow          = new ItemMod("edenArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item wildwoodArrow      = new ItemMod("wildWoodArrow").setCreativeTab(DivineRPGTabs.ranged);
    public static final Item furyArrow          = new ItemMod("furyArrow").setCreativeTab(DivineRPGTabs.ranged);

    public static final Item edenBow            = new ItemModBow("edenBow", -1, 10, 31, edenArrow);
    public static final Item wildwoodBow        = new ItemModBow("wildWoodBow", -1, 10, 31, 36000, wildwoodArrow);
    public static final Item apalachiaBow       = new ItemModBow("apalachiaBow", -1, 15, 46, wildwoodArrow);
    public static final Item skythernBow        = new ItemModBow("skythernBow", -1, 15, 46, 36000, wildwoodArrow);
    public static final Item mortumBow          = new ItemModBow("mortumBow", -1, 20, 61, furyArrow);
    public static final Item haliteBow          = new ItemModBow("haliteBow", -1, 20, 61, 36000, furyArrow);
    public static final Item twilightBow        = new ItemModBow("twilightBow", -1, 20, 61, 14400, furyArrow);
}
