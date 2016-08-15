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
import net.divinerpg.items.vanilla.ItemBurningSword;
import net.divinerpg.items.vanilla.ItemCorruptedCannon;
import net.divinerpg.items.vanilla.ItemScythe;
import net.divinerpg.items.vanilla.ItemSerenadeOfDeath;
import net.divinerpg.items.vanilla.ItemSerenadeOfHealth;
import net.divinerpg.items.vanilla.ItemSerenadeOfInfusion;
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

	public static Item slimeSword = new ItemModSword(ToolMaterialMod.Slime, "slimeSword");
	public static Item oceanKnife = new ItemModSword(ToolMaterialMod.OceanKnife, "oceanKnife");
	public static Item aquaticMaul = new ItemModSword(ToolMaterialMod.AquaMaul, "aquaMaul");
	public static Item arlemiteSword = new ItemModSword(ToolMaterialMod.Arlemite, "arlemiteStabber");
	public static Item bedrockSword = new ItemModSword(ToolMaterialMod.Bedrock, "bedrockSword");
	public static Item realmiteSword = new ItemModSword(ToolMaterialMod.Realmite, "realmiteSword");
	public static Item rupeeSword = new ItemModSword(ToolMaterialMod.Rupee, "rupeeRapier");
	public static Item sandslash = new ItemModSword(ToolMaterialMod.Sandslash, "sandslash");
	public static Item divineSword = new ItemModSword(ToolMaterialMod.Divine, "divineSword");
	public static Item blueDivineSword = new ItemModSword(ToolMaterialMod.Divine, "blueDivineSword");
	public static Item yellowDivineSword = new ItemModSword(ToolMaterialMod.Divine, "yellowDivineSword");
	public static Item grayDivineSword = new ItemModSword(ToolMaterialMod.Divine, "grayDivineSword");
	public static Item redDivineSword = new ItemModSword(ToolMaterialMod.Divine, "redDivineSword");
	public static Item greenDivineSword = new ItemModSword(ToolMaterialMod.Divine, "greenDivineSword");
	public static Item bedrockMaul = new ItemModSword(ToolMaterialMod.BedrockMaul, "bedrockMaul");
	public static Item jungleKnife = new ItemPoisonousSword(ToolMaterialMod.JungleKnife, "jungleKnife", 2.5f);
	public static Item jungleRapier = new ItemPoisonousSword(ToolMaterialMod.JungleRapier, "jungleRapier", 4f);
	public static Item aquaticTrident = new ItemModSword(ToolMaterialMod.AquaTrident, "aquaticTrident");
	public static Item aquaticDagger = new ItemModSword(ToolMaterialMod.AquaDagger, "aquaticDagger");
	public static Item aquaton = new ItemModSword(ToolMaterialMod.Aquaton, "aquaton");
	public static Item sharkSword = new ItemModSword(ToolMaterialMod.Shark, "sharkSword");
	public static Item deathBringer = new ItemModSword(ToolMaterialMod.DeathBringer, "deathBringer");
	public static Item crabclawMaul = new ItemModSword(ToolMaterialMod.CrabclawMaul, "crabclawMaul");
	public static Item poisonSaber = new ItemPoisonousSword(ToolMaterialMod.PoisonSaber, "poisonSaber", 5);
	public static Item furyMaul = new ItemModSword(ToolMaterialMod.FuryMaul, "furyMaul");
	public static Item corruptedMaul = new ItemModSword(ToolMaterialMod.CorruptedMaul, "corruptedMaul");
	public static Item frostSword = new ItemSlowingSword(ToolMaterialMod.Frost, "frostSword");
	public static Item infernoSword = new ItemBurningSword(ToolMaterialMod.Inferno, "infernoSword", 12);
	public static Item bloodgemSword = new ItemModSword(ToolMaterialMod.Bloodgem, "bloodgemSword");
	public static Item moltenSword = new ItemBurningSword(ToolMaterialMod.Molten, "moltenSword", 5);
	public static Item scorchingSword = new ItemModSword(ToolMaterialMod.Scorching, "scorchingSword");
	public static Item bluefireSword = new ItemModSword(ToolMaterialMod.Bluefire, "bluefireSword");
	public static Item enderSword = new ItemModSword(ToolMaterialMod.Ender, "enderSword");
	public static Item blueEnderSword = new ItemModSword(ToolMaterialMod.Ender, "blueEnderSword");
	public static Item grayEnderSword = new ItemModSword(ToolMaterialMod.Ender, "blackEnderSword");
	public static Item greenEnderSword = new ItemModSword(ToolMaterialMod.Ender, "greenEnderSword");
	public static Item redEnderSword = new ItemModSword(ToolMaterialMod.Ender, "redEnderSword");
	public static Item yellowEnderSword = new ItemModSword(ToolMaterialMod.Ender, "yellowEnderSword");
	public static Item cyclopsianSword = new ItemModSword(ToolMaterialMod.Cyclops, "cyclopsianSword");
	public static Item flamingFury = new ItemBurningSword(ToolMaterialMod.FlamingFury, "flamingFury", 15);
	public static Item dualClaw = new ItemModSword(ToolMaterialMod.DualClaw, "dualClaw");
	public static Item terranDagger = new ItemModSword(ToolMaterialMod.TerranDagger, "terranDagger");
	public static Item terranKnife = new ItemModSword(ToolMaterialMod.TerranKnife, "terranKnife");
	public static Item terranMaul = new ItemModSword(ToolMaterialMod.TerranMaul, "terranMaul");
	public static Item aquatoothSword = new ItemModSword(ToolMaterialMod.AquatoothSword, "aquatoothSword");
	public static Item aquatoothMaul = new ItemModSword(ToolMaterialMod.AquatoothMaul, "aquatoothMaul");

	public static Item hunterBow = new ItemModBow("hunterBow", 2500, 2, 11, Items.arrow, "hunterArrow");
	public static Item shadowBow = new ItemModBow("shadowBow", 10000, 2, 11, 36000, Items.arrow, "shadowArrow");
	public static Item enderBow = new ItemModBow("enderBow", -1, 4, 16, "enderArrow");
	public static Item bluefireBow = new ItemModBow("bluefireBow", -1, 2, 11, "bluefireArrow");
	public static Item infernoBow = new ItemModBow("infernoBow", 10000, 2, 11, "infernoArrow");

	public static Item shuriken = new ItemThrowable("shuriken", 4);
	public static Item vileStorm = new ItemVileStorm();
	public static Item scythe = new ItemScythe();
	public static Item frostCannon = new ItemProjectileShooter("frostCannon", 6F, Sounds.frostCannon.getPrefixedName(), Items.snowball, EntityResourceLocation.frostCannon.toString(), 15000, 0);
	public static Item cyclopsianStaff = new ItemProjectileShooter("cyclopsianStaff", 7F, Sounds.staff.getPrefixedName(), VanillaItemsOther.cyclopsEyeShards, 3000, 0);
	public static Item maelstrom = new ItemProjectileShooter("maelstrom", 12F, Sounds.ghastCannon.getPrefixedName(), x.maelstrom.toString(), 100, 0);
	public static Item crabAnchor = new ItemAnchor("crabAnchor", x.crabAnchor.toString(), 3);
	public static Item sharkAnchor = new ItemAnchor("sharkAnchor", x.bowheadAnchor.toString(), 4);
	public static Item bowheadAnchor = new ItemAnchor("bowheadAnchor", x.bowheadAnchor.toString(), 5);
	public static Item liopleurodonAnchor = new ItemAnchor("liopleurodonAnchor", x.liopleurodonAnchor.toString(), 6);
	public static Item goldenFury = new ItemProjectileShooter("goldenFury", 30F, Sounds.blitz.getPrefixedName(), Items.gold_nugget, -1, 0);
	public static Item corruptedCannon = new ItemCorruptedCannon("corruptedCannon");
	public static Item ghastCannon = new ItemProjectileShooter("ghastCannon", 16F, Sounds.ghastCannon.getPrefixedName(), x.ghastCannon.toString(), 100, 5);
	public static Item crabclawCannon = new ItemProjectileShooter("crabclawCannon", 12F, Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus), x.crabAnchor.toString(), 1000, 3);
	public static Item bowheadCannon = new ItemProjectileShooter("bowheadCannon", 12F, Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus), x.bowheadAnchor.toString(), 1000, 3);

	public static Item serenadeOfHealth = new ItemSerenadeOfHealth("serenadeOfHealth");
	public static Item serenadeStriker = new ItemSerenadeStriker("serenadeStriker");
	public static Item serenadeOfDeath = new ItemSerenadeOfDeath("serenadeOfDeath");
	public static Item serenadeOfInfusion = new ItemSerenadeOfInfusion("serenadeOfInfusion");

	public static Item palavence = new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 0.5f);
	public static Item massivence = new ItemHealingSword("massivence", ToolMaterialMod.Palavence, 1);

	public static void init() {}
}
