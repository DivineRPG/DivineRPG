package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemHealingSword;
import net.divinerpg.api.items.ItemModBow;
import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.api.items.ItemSlowingSword;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.items.vanilla.ItemAnchor;
import net.divinerpg.items.vanilla.ItemCorruptedCannon;
import net.divinerpg.items.vanilla.ItemInfernoSword;
import net.divinerpg.items.vanilla.ItemMaelstorm;
import net.divinerpg.items.vanilla.ItemProjectileShooter;
import net.divinerpg.items.vanilla.ItemScythe;
import net.divinerpg.items.vanilla.ItemSerenadeOfDeath;
import net.divinerpg.items.vanilla.ItemSerenadeOfHealth;
import net.divinerpg.items.vanilla.ItemSerenadeStriker;
import net.divinerpg.items.vanilla.ItemThrowable;
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
	public static Item pinkDivineSword;
	public static Item purpleDivineSword;
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
	public static Item enderSwordBlue;
	public static Item enderSwordDark;
	public static Item enderSwordGreen;
	public static Item enderSwordRed;
	public static Item enderSwordYellow;
	public static Item cyclopsianSword;

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
	public static Item maelstorm;
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
	    pinkDivineSword    = new ItemModSword(ToolMaterialMod.Divine, "pinkDivineSword");
	    purpleDivineSword  = new ItemModSword(ToolMaterialMod.Divine, "purpleDivineSword");
	    redDivineSword     = new ItemModSword(ToolMaterialMod.Divine, "redDivineSword");
	    greenDivineSword   = new ItemModSword(ToolMaterialMod.Divine, "greenDivineSword");
	    bedrockMaul        = new ItemModSword(ToolMaterialMod.Bedrock, "bedrockMaul");
	    jungleKnife        = new ItemModSword(ToolMaterialMod.JungleKnife, "jungleKnife");
	    donatorSword       = new ItemModSword(ToolMaterialMod.Donator, "donatorSword");
	    aquaticTrident     = new ItemModSword(ToolMaterialMod.AquaTrident, "aquaticTrident");
	    aquaticDagger      = new ItemModSword(ToolMaterialMod.AquaDagger, "aquaticDagger");
	    aquaton            = new ItemModSword(ToolMaterialMod.Aquaton, "aquaton");
	    sharkSword         = new ItemModSword(ToolMaterialMod.Shark, "sharkSword");
	    deathBringer       = new ItemModSword(ToolMaterialMod.DeathBringer, "deathBringer");
	    crabclawMaul       = new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclawMaul");
	    poisonSaber        = new ItemModSword(ToolMaterialMod.PoisonSaber, "poisonSaber");
	    furyMaul           = new ItemModSword(ToolMaterialMod.FuryMaul, "furyMaul");
	    corruptedMaul      = new ItemModSword(ToolMaterialMod.CorruptedMaul, "corruptedMaul");
	    frostSword         = new ItemSlowingSword(ToolMaterialMod.Frost, "frostSword");
	    infernoSword       = new ItemInfernoSword(ToolMaterialMod.Inferno, "infernoSword");
	    bloodgemSword      = new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgemSword");
	    moltenSword        = new ItemModSword(ToolMaterialMod.Molten, "moltenSword");
	    scorchingSword     = new ItemModSword(ToolMaterialMod.Scorching, "scorchingSword");
	    bluefireSword      = new ItemModSword(ToolMaterialMod.Bluefire, "bluefireSword");
	    enderSword         = new ItemModSword(ToolMaterialMod.Ender, "enderSword");
	    enderSwordBlue     = new ItemModSword(ToolMaterialMod.Ender, "enderSwordBlue");
	    enderSwordDark     = new ItemModSword(ToolMaterialMod.Ender, "enderSwordBlack");
	    enderSwordGreen    = new ItemModSword(ToolMaterialMod.Ender, "enderSwordGreen");
	    enderSwordRed      = new ItemModSword(ToolMaterialMod.Ender, "enderSwordRed");
	    enderSwordYellow   = new ItemModSword(ToolMaterialMod.Ender, "enderSwordYellow");
	    cyclopsianSword    = new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsianSword");
	    
	    hunterBow          = new ItemModBow("hunterBow", 2500, 2, 11, Items.arrow, "hunterArrow");
	    shadowBow          = new ItemModBow("shadowBow", 10000, 2, 11, 36000, Items.arrow, "shadowArrow");
	    enderBow           = new ItemModBow("enderBow", -1, 4, 16, "enderArrow");
	    bluefireBow        = new ItemModBow("bluefireBow", -1, 2, 11, "bluefireArrow");
	    infernoBow         = new ItemModBow("infernoBow", 10000, 2, 11, "infernoArrow");
	    
	    shuriken       	= new ItemThrowable(4, "shuriken");
	    vileStorm       	= new ItemThrowable(4, "vileStorm");
	    scythe		       	= new ItemScythe("scythe");
	    frostCannon       	= new ItemProjectileShooter("frostCannon", 8F, Sounds.frostCannon.getPrefixedName(), Items.snowball, EntityResourceLocation.frostCannon.toString(), 15000, 0);
	    cyclopsianStaff    = new ItemProjectileShooter("cyclopsianStaff", 7F, Sounds.staff.getPrefixedName(), VanillaItemsOther.cyclopsEyeShards, 3000, 0);
	    maelstorm          = new ItemMaelstorm("maelstorm");
	    crabAnchor         = new ItemAnchor("crabAnchor", x.crabAnchor.toString(), 4);
	    sharkAnchor        = new ItemAnchor("sharkAnchor", x.bowheadAnchor.toString(), 5);
	    bowheadAnchor      = new ItemAnchor("bowheadAnchor", x.bowheadAnchor.toString(), 6);
	    goldenFury         = new ItemProjectileShooter("goldenFury", 32F, Sounds.blitz.getPrefixedName(), Items.gold_nugget, -1, 0);
	    corruptedCannon    = new ItemCorruptedCannon("corruptedCannon");
	    ghastCannon        = new ItemProjectileShooter("ghastCannon", 40F, Sounds.ghastCannon.getPrefixedName(), x.ghastCannon.toString(), 100, 5);
	    crabclawCannon     = new ItemProjectileShooter("crabclawCannon", 19F, Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus), x.crabAnchor.toString(), 1000, 3);
	    bowheadCannon      = new ItemProjectileShooter("bowheadCannon", 19F, Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus), x.bowheadAnchor.toString(), 1000, 3);

	    serenadeOfHealth 	= new ItemSerenadeOfHealth("serenadeOfHealth");
	    serenadeStriker 	= new ItemSerenadeStriker("serenadeStriker");
	    serenadeOfDeath 	= new ItemSerenadeOfDeath("serenadeOfDeath");
	    
	    palavence 		    = new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 1);
	    massivence 	    = new ItemHealingSword("massivence", ToolMaterialMod.Massivence, 2);
		flamingFury		= new ItemModSword(ToolMaterialMod.FlamingFury, "flamingFury");
	}
}
