package net.divinerpg.utils.items;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.base.ItemHealingSword;
import net.divinerpg.items.base.ItemModBow;
import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.items.base.ItemPoisonousSword;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.items.base.ItemSlowingSword;
import net.divinerpg.items.base.ItemThrowable;
import net.divinerpg.items.vanilla.ItemAnchor;
import net.divinerpg.items.vanilla.ItemCorruptedCannon;
import net.divinerpg.items.vanilla.ItemBurningSword;
import net.divinerpg.items.vanilla.ItemScythe;
import net.divinerpg.items.vanilla.ItemSerenadeOfDeath;
import net.divinerpg.items.vanilla.ItemSerenadeOfHealth;
import net.divinerpg.items.vanilla.ItemSerenadeStriker;
import net.divinerpg.items.vanilla.ItemVileStorm;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class VanillaItemsWeapons {

	private static EntityResourceLocation x;

	public static Item slimeSword;
	public static Item oceanKnife;
	public static Item aquaticMaul;
	public static Item arlemiteSword;
	public static Item bedrockSword;
	public static Item realmiteSword;
	public static Item rupeeSword;
	public static Item sandslash;
	public static Item divineSword;
	public static Item blueDivineSword;
	public static Item yellowDivineSword;
	public static Item grayDivineSword;
	public static Item redDivineSword;
	public static Item greenDivineSword;
	public static Item bedrockMaul;
	public static Item jungleKnife;
	public static Item donatorSword;
	public static Item aquaticTrident;
	public static Item aquaticDagger;
	public static Item aquaton;
	public static Item sharkSword;
	public static Item deathBringer;
	public static Item crabclawMaul;
	public static Item poisonSaber;
	public static Item furyMaul;
	public static Item corruptedMaul;
	public static Item frostSword;
	public static Item infernoSword;
	public static Item bloodgemSword;
	public static Item moltenSword;
	public static Item scorchingSword;
	public static Item bluefireSword;
	public static Item enderSword;
	public static Item blueEnderSword;
	public static Item grayEnderSword;
	public static Item greenEnderSword;
	public static Item redEnderSword;
	public static Item yellowEnderSword;
	public static Item cyclopsianSword;
	public static Item dualClaw;

	public static Item hunterBow;
	public static Item shadowBow;
	public static Item enderBow;
	public static Item bluefireBow;
	public static Item infernoBow;

	public static Item shuriken;
	public static Item vileStorm;
	public static Item scythe;
	public static Item frostCannon;
	public static Item cyclopsianStaff;
	public static Item maelstrom;
	public static Item crabAnchor;
	public static Item sharkAnchor;
	public static Item bowheadAnchor;
	public static Item goldenFury;
	public static Item corruptedCannon;
	public static Item ghastCannon;
	public static Item crabclawCannon;
	public static Item bowheadCannon;

	public static Item serenadeOfHealth;
	public static Item serenadeStriker;
	public static Item serenadeOfDeath;

	public static Item palavence;
	public static Item massivence;
	public static Item flamingFury;
	
	public static void init() {
		slimeSword         = new ItemModSword(ToolMaterialMod.Slime, "slimeSword");
	    oceanKnife         = new ItemModSword(ToolMaterialMod.OceanKnife, "oceanKnife");
	    aquaticMaul        = new ItemModSword(ToolMaterialMod.AquaMaul, "aquaMaul");
	    arlemiteSword      = new ItemModSword(ToolMaterialMod.Arlemite, "arlemiteStabber");
	    bedrockSword       = new ItemModSword(ToolMaterialMod.Bedrock, "bedrockSword");
	    realmiteSword      = new ItemModSword(ToolMaterialMod.Realmite, "realmiteSword");
	    rupeeSword         = new ItemModSword(ToolMaterialMod.Rupee, "rupeeRapier");
	    sandslash          = new ItemModSword(ToolMaterialMod.Sandslash, "sandslash");
	    divineSword        = new ItemModSword(ToolMaterialMod.Divine, "divineSword");
	    blueDivineSword    = new ItemModSword(ToolMaterialMod.Divine, "blueDivineSword");
	    yellowDivineSword  = new ItemModSword(ToolMaterialMod.Divine, "yellowDivineSword");
	    grayDivineSword    = new ItemModSword(ToolMaterialMod.Divine, "grayDivineSword");
	    redDivineSword     = new ItemModSword(ToolMaterialMod.Divine, "redDivineSword");
	    greenDivineSword   = new ItemModSword(ToolMaterialMod.Divine, "greenDivineSword");
	    bedrockMaul        = new ItemModSword(ToolMaterialMod.BedrockMaul, "bedrockMaul");
	    jungleKnife        = new ItemPoisonousSword(ToolMaterialMod.JungleKnife, "jungleKnife", 2.5f);
	    donatorSword       = new ItemModSword(ToolMaterialMod.Donator, "donatorSword");
	    aquaticTrident     = new ItemModSword(ToolMaterialMod.AquaTrident, "aquaticTrident");
	    aquaticDagger      = new ItemModSword(ToolMaterialMod.AquaDagger, "aquaticDagger");
	    aquaton            = new ItemModSword(ToolMaterialMod.Aquaton, "aquaton");
	    sharkSword         = new ItemModSword(ToolMaterialMod.Shark, "sharkSword");
	    deathBringer       = new ItemModSword(ToolMaterialMod.DeathBringer, "deathBringer");
	    crabclawMaul       = new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclawMaul");
	    poisonSaber        = new ItemPoisonousSword(ToolMaterialMod.PoisonSaber, "poisonSaber", 5);
	    furyMaul           = new ItemModSword(ToolMaterialMod.FuryMaul, "furyMaul");
	    corruptedMaul      = new ItemModSword(ToolMaterialMod.CorruptedMaul, "corruptedMaul");
	    frostSword         = new ItemSlowingSword(ToolMaterialMod.Frost, "frostSword");
	    infernoSword       = new ItemBurningSword(ToolMaterialMod.Inferno, "infernoSword", 12);
	    bloodgemSword      = new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgemSword");
	    moltenSword        = new ItemBurningSword(ToolMaterialMod.Molten, "moltenSword", 5);
	    scorchingSword     = new ItemModSword(ToolMaterialMod.Scorching, "scorchingSword");
	    bluefireSword      = new ItemModSword(ToolMaterialMod.Bluefire, "bluefireSword");
	    enderSword         = new ItemModSword(ToolMaterialMod.Ender, "enderSword");
	    blueEnderSword     = new ItemModSword(ToolMaterialMod.Ender, "blueEnderSword");
	    grayEnderSword     = new ItemModSword(ToolMaterialMod.Ender, "blackEnderSword");
	    greenEnderSword    = new ItemModSword(ToolMaterialMod.Ender, "greenEnderSword");
	    redEnderSword      = new ItemModSword(ToolMaterialMod.Ender, "redEnderSword");
	    yellowEnderSword   = new ItemModSword(ToolMaterialMod.Ender, "yellowEnderSword");
	    cyclopsianSword    = new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsianSword");
	    flamingFury        = new ItemBurningSword(ToolMaterialMod.FlamingFury, "flamingFury", 15);
	    dualClaw           = new ItemModSword(ToolMaterialMod.DualClaw, "dualClaw");
	    
	    hunterBow          = new ItemModBow("hunterBow", 2500, 2, 11, Items.arrow, "hunterArrow");
	    shadowBow          = new ItemModBow("shadowBow", 10000, 2, 11, 36000, Items.arrow, "shadowArrow");
	    enderBow           = new ItemModBow("enderBow", -1, 4, 16, "enderArrow");
	    bluefireBow        = new ItemModBow("bluefireBow", -1, 2, 11, "bluefireArrow");
	    infernoBow         = new ItemModBow("infernoBow", 10000, 2, 11, "infernoArrow");
	    
	    shuriken       	= new ItemThrowable("shuriken", 4);
	    vileStorm       	= new ItemVileStorm();
	    scythe		       	= new ItemScythe();
	    frostCannon       	= new ItemProjectileShooter("frostCannon", 6F, Sounds.frostCannon.getPrefixedName(), Items.snowball, EntityResourceLocation.frostCannon.toString(), 15000, 0);
	    cyclopsianStaff    = new ItemProjectileShooter("cyclopsianStaff", 7F, Sounds.staff.getPrefixedName(), VanillaItemsOther.cyclopsEyeShards, 3000, 0);
	    maelstrom          = new ItemProjectileShooter("maelstrom", 12F, Sounds.ghastCannon.getPrefixedName(), x.maelstrom.toString(), 100, 0);
	    crabAnchor         = new ItemAnchor("crabAnchor", x.crabAnchor.toString(), 4);
	    sharkAnchor        = new ItemAnchor("sharkAnchor", x.bowheadAnchor.toString(), 5);
	    bowheadAnchor      = new ItemAnchor("bowheadAnchor", x.bowheadAnchor.toString(), 6);
	    goldenFury         = new ItemProjectileShooter("goldenFury", 30F, Sounds.blitz.getPrefixedName(), Items.gold_nugget, -1, 0);
	    corruptedCannon    = new ItemCorruptedCannon("corruptedCannon");
	    ghastCannon        = new ItemProjectileShooter("ghastCannon", 16F, Sounds.ghastCannon.getPrefixedName(), x.ghastCannon.toString(), 100, 5);
	    crabclawCannon     = new ItemProjectileShooter("crabclawCannon", 12F, Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus), x.crabAnchor.toString(), 1000, 3);
	    bowheadCannon      = new ItemProjectileShooter("bowheadCannon", 12F, Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus), x.bowheadAnchor.toString(), 1000, 3);

	    serenadeOfHealth 	= new ItemSerenadeOfHealth("serenadeOfHealth");
	    serenadeStriker 	= new ItemSerenadeStriker("serenadeStriker");
	    serenadeOfDeath 	= new ItemSerenadeOfDeath("serenadeOfDeath");
	    
	    palavence 		    = new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 0.5f);
	    massivence 	    = new ItemHealingSword("massivence", ToolMaterialMod.Palavence, 1);
	}
}
