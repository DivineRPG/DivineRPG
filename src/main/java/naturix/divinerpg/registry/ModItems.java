package naturix.divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import naturix.divinerpg.objects.items.ItemArmorBase;
import naturix.divinerpg.objects.items.ItemAxeBase;
import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.objects.items.ItemBowBase;
import naturix.divinerpg.objects.items.ItemFastFood;
import naturix.divinerpg.objects.items.ItemHealingSword;
import naturix.divinerpg.objects.items.ItemHoeBase;
import naturix.divinerpg.objects.items.ItemNotReady;
import naturix.divinerpg.objects.items.ItemPickaxeBase;
import naturix.divinerpg.objects.items.ItemPoisonousSword;
import naturix.divinerpg.objects.items.ItemShickaxeBase;
import naturix.divinerpg.objects.items.ItemShovelBase;
import naturix.divinerpg.objects.items.ItemSlowingSword;
import naturix.divinerpg.objects.items.ItemSpawnEgg;
import naturix.divinerpg.objects.items.ItemSwordBase;
import naturix.divinerpg.objects.items.food.ItemFoodBase;
import naturix.divinerpg.objects.items.iceika.ItemSnowGlobe;
import naturix.divinerpg.objects.items.vanilla.ItemBurningSword;
import naturix.divinerpg.objects.items.vanilla.ItemCallOfTheWatcher;
import naturix.divinerpg.objects.items.vanilla.ItemHordeHorn;
import naturix.divinerpg.objects.items.vanilla.ItemMysteriousClock;
import naturix.divinerpg.utils.ArmorInfo;
import naturix.divinerpg.utils.ChatFormats;
import naturix.divinerpg.utils.GenerateJSON;
import naturix.divinerpg.utils.material.EnumArmor;
import naturix.divinerpg.utils.material.ToolMaterialMod;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Vanilla Weapons
	public static Item slimeSword = new ItemSwordBase(ToolMaterialMod.Slime, "slime_sword");
	public static Item oceanKnife = new ItemSwordBase(ToolMaterialMod.OceanKnife, "ocean_knife");
	public static Item aquaticMaul = new ItemSwordBase(ToolMaterialMod.AquaMaul, "aqua_maul");
	public static Item arlemiteStabber = new ItemSwordBase(ToolMaterialMod.Arlemite, "arlemite_stabber");
	public static Item bedrockSword = new ItemSwordBase(ToolMaterialMod.Bedrock, "bedrock_sword");
	public static Item realmiteSword = new ItemSwordBase(ToolMaterialMod.Realmite, "realmite_sword");
	public static Item rupeeSword = new ItemSwordBase(ToolMaterialMod.Rupee, "rupee_rapier");
	public static Item sandslash = new ItemSwordBase(ToolMaterialMod.Sandslash, "sandslash");
	public static Item divineSword = new ItemSwordBase(ToolMaterialMod.Divine, "divine_sword");
	public static Item blueDivineSword = new ItemSwordBase(ToolMaterialMod.Divine, "blue_divine_sword");
	public static Item yellowDivineSword = new ItemSwordBase(ToolMaterialMod.Divine, "yellow_divine_sword");
	public static Item grayDivineSword = new ItemSwordBase(ToolMaterialMod.Divine, "gray_divine_sword");
	public static Item redDivineSword = new ItemSwordBase(ToolMaterialMod.Divine, "red_divine_sword");
	public static Item greenDivineSword = new ItemSwordBase(ToolMaterialMod.Divine, "green_divine_sword");
	public static Item bedrockMaul = new ItemSwordBase(ToolMaterialMod.BedrockMaul, "bedrock_maul");
	public static Item jungleKnife = new ItemPoisonousSword(ToolMaterialMod.JungleKnife, "jungle_knife", 2.5f);
	public static Item jungleRapier = new ItemPoisonousSword(ToolMaterialMod.JungleRapier, "jungle_rapier", 4f);
	public static Item aquaticTrident = new ItemSwordBase(ToolMaterialMod.AquaTrident, "aquatic_trident");
	public static Item aquaticDagger = new ItemSwordBase(ToolMaterialMod.AquaDagger, "aquatic_dagger");
	public static Item aquaton = new ItemSwordBase(ToolMaterialMod.Aquaton, "aquaton");
	public static Item sharkSword = new ItemSwordBase(ToolMaterialMod.Shark, "shark_sword");
	public static Item deathBringer = new ItemSwordBase(ToolMaterialMod.DeathBringer, "death_bringer");
	public static Item crabclawMaul = new ItemSwordBase(ToolMaterialMod.CrabclawMaul, "crabclaw_maul");
	public static Item poisonSaber = new ItemPoisonousSword(ToolMaterialMod.PoisonSaber, "poison_saber", 5);
	public static Item furyMaul = new ItemSwordBase(ToolMaterialMod.FuryMaul, "fury_maul");
	public static Item corruptedMaul = new ItemSwordBase(ToolMaterialMod.CorruptedMaul, "corrupted_maul");
	public static Item frostSword = new ItemSlowingSword(ToolMaterialMod.Frost, "frost_sword");
	public static Item infernoSword = new ItemBurningSword(ToolMaterialMod.Inferno, "inferno_sword", 12);
	public static Item bloodgemSword = new ItemSwordBase(ToolMaterialMod.Bloodgem, "bloodgem_sword");
	public static Item moltenSword = new ItemBurningSword(ToolMaterialMod.Molten, "molten_sword", 5);
	public static Item scorchingSword = new ItemSwordBase(ToolMaterialMod.Scorching, "scorching_sword");
	public static Item bluefireSword = new ItemSwordBase(ToolMaterialMod.Bluefire, "bluefire_sword");
	public static Item enderSword = new ItemSwordBase(ToolMaterialMod.Ender, "ender_sword");
	public static Item blueEnderSword = new ItemSwordBase(ToolMaterialMod.Ender, "blue_ender_sword");
	public static Item grayEnderSword = new ItemSwordBase(ToolMaterialMod.Ender, "black_ender_sword");
	public static Item greenEnderSword = new ItemSwordBase(ToolMaterialMod.Ender, "green_ender_sword");
	public static Item redEnderSword = new ItemSwordBase(ToolMaterialMod.Ender, "red_ender_sword");
	public static Item yellowEnderSword = new ItemSwordBase(ToolMaterialMod.Ender, "yellow_ender_sword");
	public static Item cyclopsianSword = new ItemSwordBase(ToolMaterialMod.Cyclops, "cyclopsian_sword");
	public static Item flamingFury = new ItemBurningSword(ToolMaterialMod.FlamingFury, "flaming_fury", 15);
	public static Item dualClaw = new ItemSwordBase(ToolMaterialMod.DualClaw, "dual_claw");
	public static Item terranDagger = new ItemSwordBase(ToolMaterialMod.TerranDagger, "terran_dagger");
	public static Item terranKnife = new ItemSwordBase(ToolMaterialMod.TerranKnife, "terran_knife");
	public static Item terranMaul = new ItemSwordBase(ToolMaterialMod.TerranMaul, "terran_maul");
	public static Item aquatoothSword = new ItemSwordBase(ToolMaterialMod.AquatoothSword, "aquatooth_sword");
	public static Item aquatoothMaul = new ItemSwordBase(ToolMaterialMod.AquatoothMaul, "aquatooth_maul");

	public static Item hunterBow = new ItemBowBase("hunter_bow", 2500, 2, 11, Items.ARROW, "hunter_arrow");
	public static Item shadowBow = new ItemBowBase("shadow_bow", 10000, 2, 11, 36000, Items.ARROW, "shadow_arrow");
	public static Item enderBow = new ItemBowBase("ender_bow", -1, 4, 16, "ender_arrow");
	public static Item bluefireBow = new ItemBowBase("bluefire_bow", -1, 2, 11, "bluefire_arrow");
	public static Item infernoBow = new ItemBowBase("inferno_bow", 10000, 2, 11, "inferno_arrow");

	// public static Item shuriken = new ItemShuriken("shuriken", 4);
	// public static Item vileStorm = new ItemVileStorm("vile_storm");
	public static Item shuriken = new ItemNotReady("shuriken", DRPGCreativeTabs.ranged);
	public static Item vileStorm = new ItemNotReady("vile_storm", DRPGCreativeTabs.ranged);
	// public static Item scythe = new ItemScythe();
	public static Item scythe = new ItemNotReady("scythe", DRPGCreativeTabs.ranged);
	// public static Item frostCannon = new ItemProjectileShooter("frost_cannon",
	// 6F, Sounds.frostCannon.getPrefixedName(),
	// Items.SNOWBALL, EntityResourceLocation.frostCannon.toString(), 15000, 0);
	public static Item frostCannon = new ItemNotReady("frost_cannon", DRPGCreativeTabs.ranged);
	public static Item cyclopsianStaff = new ItemNotReady("cyclopsian_staff", DRPGCreativeTabs.ranged);
	// public static Item cyclopsianStaff = new
	// ItemProjectileShooter("cyclopsian_staff", 7F, DRPGSoundHandler.STAFF,
	// ModItems.cyclopsianSword.getRegistryName().getResourcePath(), 3000, 0);
	// public static Item maelstrom = new ItemProjectileShooter("maelstrom", 12F,
	// Sounds.ghastCannon.getPrefixedName(),
	// x.maelstrom.toString(), 100, 0);
	public static Item maelstrom = new ItemNotReady("maelstrom", DRPGCreativeTabs.ranged);
	// public static Item crabAnchor = new ItemAnchor("crab_anchor",
	// x.crabAnchor.toString(), 3);
	public static Item crabAnchor = new ItemNotReady("crab_anchor", DRPGCreativeTabs.ranged);
	// public static Item sharkAnchor = new ItemAnchor("shark_anchor",
	// x.bowheadAnchor.toString(), 4);
	public static Item sharkAnchor = new ItemNotReady("shark_anchor", DRPGCreativeTabs.ranged);
	// public static Item bowheadAnchor = new ItemAnchor("bowhead_anchor",
	// x.bowheadAnchor.toString(), 5);
	public static Item bowheadAnchor = new ItemNotReady("bowhead_anchor", DRPGCreativeTabs.ranged);
	// public static Item liopleurodonAnchor = new ItemAnchor("liopleurodon_anchor",
	// x.liopleurodonAnchor.toString(), 6);
	public static Item liopleurodonAnchor = new ItemNotReady("liopleurodon_anchor", DRPGCreativeTabs.ranged);
	// public static Item goldenFury = new ItemProjectileShooter("golden_fury", 30F,
	// Sounds.blitz.getPrefixedName(),
	// Items.GOLD_NUGGET, -1, 0);
	public static Item goldenFury = new ItemNotReady("golden_fury", DRPGCreativeTabs.ranged);
	// public static Item corruptedCannon = new
	// ItemCorruptedCannon("corrupted_cannon");
	public static Item corruptedCannon = new ItemNotReady("corrupted_cannon", DRPGCreativeTabs.ranged);
	// public static Item ghastCannon = new ItemProjectileShooter("ghast_cannon",
	// 16F,
	// Sounds.ghastCannon.getPrefixedName(), x.ghastCannon.toString(), 100, 5);
	public static Item ghastCannon = new ItemNotReady("ghast_cannon", DRPGCreativeTabs.ranged);
	// public static Item crabclawCannon = new
	// ItemProjectileShooter("crabclaw_cannon", 12F,
	// Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus),
	// x.crabAnchor.toString(), 1000, 3);
	public static Item crabclawCannon = new ItemNotReady("crabclaw_cannon", DRPGCreativeTabs.ranged);
	// public static Item bowheadCannon = new
	// ItemProjectileShooter("bowhead_cannon", 12F,
	// Sounds.ghastCannon.getPrefixedName(), Util.toItem(Blocks.cactus),
	// x.bowheadAnchor.toString(), 1000, 3);
	public static Item bowheadCannon = new ItemNotReady("bowhead_cannon", DRPGCreativeTabs.ranged);

	// public static Item serenadeOfHealth = new
	// ItemSerenadeOfHealth("serenade_of_health");
	public static Item serenadeOfHealth = new ItemNotReady("serenade_of_health", DRPGCreativeTabs.items);
	// public static Item serenadeStriker = new
	// ItemSerenadeStriker("serenade_striker");
	public static Item serenadeStriker = new ItemNotReady("serenade_striker", DRPGCreativeTabs.ranged);
	// public static Item serenadeOfDeath = new
	// ItemSerenadeOfDeath("serenade_of_death");
	public static Item serenadeOfDeath = new ItemNotReady("serenade_of_death", DRPGCreativeTabs.ranged);
	// public static Item serenadeOfInfusion = new
	// ItemSerenadeOfInfusion("serenade_of_infusion");
	public static Item serenadeOfInfusion = new ItemNotReady("serenade_of_infusion", DRPGCreativeTabs.items);

	public static Item palavence = new ItemHealingSword("palavence", ToolMaterialMod.Palavence, 0.5f);
	public static Item massivence = new ItemHealingSword("massivence", ToolMaterialMod.Palavence, 1);

	// Vanilla Armor
	private static Object[] angelicInfo = new Object[] { ArmorInfo.NO_FALL, ArmorInfo.FLY };
	public static Item angelicHelmet = new ItemArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.HEAD, angelicInfo);
	public static Item angelicBody = new ItemArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.CHEST, angelicInfo);
	public static Item angelicLegs = new ItemArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.LEGS, angelicInfo);
	public static Item angelicBoots = new ItemArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.FEET, angelicInfo);

	private static Object[] divineInfo = new Object[] { 6, ArmorInfo.MELEE_DAMAGE, 2, ArmorInfo.JUMP_HEIGHT,
	        ArmorInfo.NO_FALL };
	public static Item divineHelmet = new ItemArmorBase(EnumArmor.DIVINE, EntityEquipmentSlot.HEAD, divineInfo);
	public static Item divineBody = new ItemArmorBase(EnumArmor.DIVINE, EntityEquipmentSlot.CHEST, divineInfo);
	public static Item divineLegs = new ItemArmorBase(EnumArmor.DIVINE, EntityEquipmentSlot.LEGS, divineInfo);
	public static Item divineBoots = new ItemArmorBase(EnumArmor.DIVINE, EntityEquipmentSlot.FEET, divineInfo);

	private static Object[] bedrockInfo = new Object[] { ArmorInfo.FIRE_PROTECTION, ArmorInfo.EXPLOSION_PROTECTION };
	public static Item bedrockHelmet = new ItemArmorBase(EnumArmor.BEDROCK, EntityEquipmentSlot.HEAD, bedrockInfo);
	public static Item bedrockBody = new ItemArmorBase(EnumArmor.BEDROCK, EntityEquipmentSlot.CHEST, bedrockInfo);
	public static Item bedrockLegs = new ItemArmorBase(EnumArmor.BEDROCK, EntityEquipmentSlot.LEGS, bedrockInfo);
	public static Item bedrockBoots = new ItemArmorBase(EnumArmor.BEDROCK, EntityEquipmentSlot.FEET, bedrockInfo);

	public static Item realmiteHelmet = new ItemArmorBase(EnumArmor.REALMITE, EntityEquipmentSlot.HEAD);
	public static Item realmiteBody = new ItemArmorBase(EnumArmor.REALMITE, EntityEquipmentSlot.CHEST);
	public static Item realmiteLegs = new ItemArmorBase(EnumArmor.REALMITE, EntityEquipmentSlot.LEGS);
	public static Item realmiteBoots = new ItemArmorBase(EnumArmor.REALMITE, EntityEquipmentSlot.FEET);

	private static Object[] eliteRealmiteInfo = new Object[] { ArmorInfo.NO_FALL };
	public static Item eliteRealmiteHelmet = new ItemArmorBase(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.HEAD,
	        eliteRealmiteInfo);
	public static Item eliteRealmiteBody = new ItemArmorBase(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.CHEST,
	        eliteRealmiteInfo);
	public static Item eliteRealmiteLegs = new ItemArmorBase(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.LEGS,
	        eliteRealmiteInfo);
	public static Item eliteRealmiteBoots = new ItemArmorBase(EnumArmor.ELITE_REALMITE, EntityEquipmentSlot.FEET,
	        eliteRealmiteInfo);

	private static Object[] arlemiteInfo = new Object[] { 85, ArmorInfo.RANGED_PROTECTION };
	public static Item arlemiteHelmet = new ItemArmorBase(EnumArmor.ARLEMITE, EntityEquipmentSlot.HEAD, arlemiteInfo);
	public static Item arlemiteBody = new ItemArmorBase(EnumArmor.ARLEMITE, EntityEquipmentSlot.CHEST, arlemiteInfo);
	public static Item arlemiteLegs = new ItemArmorBase(EnumArmor.ARLEMITE, EntityEquipmentSlot.LEGS, arlemiteInfo);
	public static Item arlemiteBoots = new ItemArmorBase(EnumArmor.ARLEMITE, EntityEquipmentSlot.FEET, arlemiteInfo);

	private static Object[] rupeeInfo = new Object[] { 85, ArmorInfo.MELEE_PROTECTION };
	public static Item rupeeHelmet = new ItemArmorBase(EnumArmor.RUPEE, EntityEquipmentSlot.HEAD, rupeeInfo);
	public static Item rupeeBody = new ItemArmorBase(EnumArmor.RUPEE, EntityEquipmentSlot.CHEST, rupeeInfo);
	public static Item rupeeLegs = new ItemArmorBase(EnumArmor.RUPEE, EntityEquipmentSlot.LEGS, rupeeInfo);
	public static Item rupeeBoots = new ItemArmorBase(EnumArmor.RUPEE, EntityEquipmentSlot.FEET, rupeeInfo);
	public static Item yellowRupeeHelmet = new ItemArmorBase(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.HEAD,
	        rupeeInfo);
	public static Item yellowRupeeBody = new ItemArmorBase(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.CHEST,
	        rupeeInfo);
	public static Item yellowRupeeLegs = new ItemArmorBase(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.LEGS, rupeeInfo);
	public static Item yellowRupeeBoots = new ItemArmorBase(EnumArmor.RUPEE_YELLOW, EntityEquipmentSlot.FEET,
	        rupeeInfo);
	public static Item redRupeeHelmet = new ItemArmorBase(EnumArmor.RUPEE_RED, EntityEquipmentSlot.HEAD, rupeeInfo);
	public static Item redRupeeBody = new ItemArmorBase(EnumArmor.RUPEE_RED, EntityEquipmentSlot.CHEST, rupeeInfo);
	public static Item redRupeeLegs = new ItemArmorBase(EnumArmor.RUPEE_RED, EntityEquipmentSlot.LEGS, rupeeInfo);
	public static Item redRupeeBoots = new ItemArmorBase(EnumArmor.RUPEE_RED, EntityEquipmentSlot.FEET, rupeeInfo);
	public static Item greenRupeeHelmet = new ItemArmorBase(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.HEAD, rupeeInfo);
	public static Item greenRupeeBody = new ItemArmorBase(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.CHEST, rupeeInfo);
	public static Item greenRupeeLegs = new ItemArmorBase(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.LEGS, rupeeInfo);
	public static Item greenRupeeBoots = new ItemArmorBase(EnumArmor.RUPEE_GREEN, EntityEquipmentSlot.FEET, rupeeInfo);
	public static Item blueRupeeHelmet = new ItemArmorBase(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.HEAD, rupeeInfo);
	public static Item blueRupeeBody = new ItemArmorBase(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.CHEST, rupeeInfo);
	public static Item blueRupeeLegs = new ItemArmorBase(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.LEGS, rupeeInfo);
	public static Item blueRupeeBoots = new ItemArmorBase(EnumArmor.RUPEE_BLUE, EntityEquipmentSlot.FEET, rupeeInfo);
	public static Item grayRupeeHelmet = new ItemArmorBase(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.HEAD, rupeeInfo);
	public static Item grayRupeeBody = new ItemArmorBase(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.CHEST, rupeeInfo);
	public static Item grayRupeeLegs = new ItemArmorBase(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.LEGS, rupeeInfo);
	public static Item grayRupeeBoots = new ItemArmorBase(EnumArmor.RUPEE_GRAY, EntityEquipmentSlot.FEET, rupeeInfo);

	private static Object[] krakenInfo = new Object[] { ArmorInfo.UNDERWATER };
	public static Item krakenHelmet = new ItemArmorBase(EnumArmor.KRAKEN, EntityEquipmentSlot.HEAD, krakenInfo);
	public static Item krakenBody = new ItemArmorBase(EnumArmor.KRAKEN, EntityEquipmentSlot.CHEST, krakenInfo);
	public static Item krakenLegs = new ItemArmorBase(EnumArmor.KRAKEN, EntityEquipmentSlot.LEGS, krakenInfo);
	public static Item krakenBoots = new ItemArmorBase(EnumArmor.KRAKEN, EntityEquipmentSlot.FEET, krakenInfo);

	private static Object[] jackomanInfo = new Object[] { 3, ArmorInfo.SCYTHE_DAMAGE };
	public static Item jackOManHelmet = new ItemArmorBase(EnumArmor.JACKOMAN, EntityEquipmentSlot.HEAD, "jackOMan",
	        jackomanInfo);
	public static Item jackOManBody = new ItemArmorBase(EnumArmor.JACKOMAN, EntityEquipmentSlot.CHEST, "jackOMan",
	        jackomanInfo);
	public static Item jackOManLegs = new ItemArmorBase(EnumArmor.JACKOMAN, EntityEquipmentSlot.LEGS, "jackOMan",
	        jackomanInfo);
	public static Item jackOManBoots = new ItemArmorBase(EnumArmor.JACKOMAN, EntityEquipmentSlot.FEET, "jackOMan",
	        jackomanInfo);

	private static Object[] infernoInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
	public static Item infernoHelmet = new ItemArmorBase(EnumArmor.INFERNO, EntityEquipmentSlot.HEAD, infernoInfo);
	public static Item infernoBody = new ItemArmorBase(EnumArmor.INFERNO, EntityEquipmentSlot.CHEST, infernoInfo);
	public static Item infernoLegs = new ItemArmorBase(EnumArmor.INFERNO, EntityEquipmentSlot.LEGS, infernoInfo);
	public static Item infernoBoots = new ItemArmorBase(EnumArmor.INFERNO, EntityEquipmentSlot.FEET, infernoInfo);

	private static Object[] aquastriveInfo = new Object[] { ArmorInfo.UNDERWATER, ArmorInfo.SWIM };
	public static Item aquastriveHelmet = new ItemArmorBase(EnumArmor.AQUATIC, EntityEquipmentSlot.HEAD,
	        aquastriveInfo);
	public static Item aquastriveBody = new ItemArmorBase(EnumArmor.AQUATIC, EntityEquipmentSlot.CHEST, aquastriveInfo);
	public static Item aquastriveLegs = new ItemArmorBase(EnumArmor.AQUATIC, EntityEquipmentSlot.LEGS, aquastriveInfo);
	public static Item aquastriveBoots = new ItemArmorBase(EnumArmor.AQUATIC, EntityEquipmentSlot.FEET, aquastriveInfo);

	private static Object[] shadowInfo = new Object[] { 3, ArmorInfo.SPEED };
	public static Item shadowHelmet = new ItemArmorBase(EnumArmor.SHADOW, EntityEquipmentSlot.HEAD, shadowInfo);
	public static Item shadowBody = new ItemArmorBase(EnumArmor.SHADOW, EntityEquipmentSlot.CHEST, shadowInfo);
	public static Item shadowLegs = new ItemArmorBase(EnumArmor.SHADOW, EntityEquipmentSlot.LEGS, shadowInfo);
	public static Item shadowBoots = new ItemArmorBase(EnumArmor.SHADOW, EntityEquipmentSlot.FEET, shadowInfo);

	private static Object[] netheriteInfo = new Object[] { ArmorInfo.FIRE_PROTECTION };
	public static Item netheriteHelmet = new ItemArmorBase(EnumArmor.NETHERITE, EntityEquipmentSlot.HEAD,
	        netheriteInfo);
	public static Item netheriteBody = new ItemArmorBase(EnumArmor.NETHERITE, EntityEquipmentSlot.CHEST, netheriteInfo);
	public static Item netheriteLegs = new ItemArmorBase(EnumArmor.NETHERITE, EntityEquipmentSlot.LEGS, netheriteInfo);
	public static Item netheriteBoots = new ItemArmorBase(EnumArmor.NETHERITE, EntityEquipmentSlot.FEET, netheriteInfo);

	private static Object[] skelemanInfo = new Object[] { ArmorInfo.HUNGER };
	public static Item skelemanHelmet = new ItemArmorBase(EnumArmor.SKELEMAN, EntityEquipmentSlot.HEAD, skelemanInfo);
	public static Item skelemanBody = new ItemArmorBase(EnumArmor.SKELEMAN, EntityEquipmentSlot.CHEST, skelemanInfo);
	public static Item skelemanLegs = new ItemArmorBase(EnumArmor.SKELEMAN, EntityEquipmentSlot.LEGS, skelemanInfo);
	public static Item skelemanBoots = new ItemArmorBase(EnumArmor.SKELEMAN, EntityEquipmentSlot.FEET, skelemanInfo);

	private static Object[] witherReaperInfo = new Object[] { ArmorInfo.WITHER_PROTECTION };
	public static Item witherReaperHelmet = new ItemArmorBase(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.HEAD,
	        witherReaperInfo);
	public static Item witherReaperBody = new ItemArmorBase(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.CHEST,
	        witherReaperInfo);
	public static Item witherReaperLegs = new ItemArmorBase(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.LEGS,
	        witherReaperInfo);
	public static Item witherReaperBoots = new ItemArmorBase(EnumArmor.WITHER_REAPER, EntityEquipmentSlot.FEET,
	        witherReaperInfo);

	private static Object[] enderInfo = new Object[] { ArmorInfo.EXPLOSION_PROTECTION };
	public static Item enderHelmet = new ItemArmorBase(EnumArmor.ENDER, EntityEquipmentSlot.HEAD, enderInfo);
	public static Item enderBody = new ItemArmorBase(EnumArmor.ENDER, EntityEquipmentSlot.CHEST, enderInfo);
	public static Item enderLegs = new ItemArmorBase(EnumArmor.ENDER, EntityEquipmentSlot.LEGS, enderInfo);
	public static Item enderBoots = new ItemArmorBase(EnumArmor.ENDER, EntityEquipmentSlot.FEET, enderInfo);
	public static Item yellowEnderHelmet = new ItemArmorBase(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.HEAD,
	        enderInfo);
	public static Item yellowEnderBody = new ItemArmorBase(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.CHEST,
	        enderInfo);
	public static Item yellowEnderLegs = new ItemArmorBase(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.LEGS, enderInfo);
	public static Item yellowEnderBoots = new ItemArmorBase(EnumArmor.ENDER_YELLOW, EntityEquipmentSlot.FEET,
	        enderInfo);
	public static Item redEnderHelmet = new ItemArmorBase(EnumArmor.ENDER_RED, EntityEquipmentSlot.HEAD, enderInfo);
	public static Item redEnderBody = new ItemArmorBase(EnumArmor.ENDER_RED, EntityEquipmentSlot.CHEST, enderInfo);
	public static Item redEnderLegs = new ItemArmorBase(EnumArmor.ENDER_RED, EntityEquipmentSlot.LEGS, enderInfo);
	public static Item redEnderBoots = new ItemArmorBase(EnumArmor.ENDER_RED, EntityEquipmentSlot.FEET, enderInfo);
	public static Item greenEnderHelmet = new ItemArmorBase(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.HEAD, enderInfo);
	public static Item greenEnderBody = new ItemArmorBase(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.CHEST, enderInfo);
	public static Item greenEnderLegs = new ItemArmorBase(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.LEGS, enderInfo);
	public static Item greenEnderBoots = new ItemArmorBase(EnumArmor.ENDER_GREEN, EntityEquipmentSlot.FEET, enderInfo);
	public static Item blueEnderHelmet = new ItemArmorBase(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.HEAD, enderInfo);
	public static Item blueEnderBody = new ItemArmorBase(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.CHEST, enderInfo);
	public static Item blueEnderLegs = new ItemArmorBase(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.LEGS, enderInfo);
	public static Item blueEnderBoots = new ItemArmorBase(EnumArmor.ENDER_BLUE, EntityEquipmentSlot.FEET, enderInfo);
	public static Item grayEnderHelmet = new ItemArmorBase(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.HEAD, enderInfo);
	public static Item grayEnderBody = new ItemArmorBase(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.CHEST, enderInfo);
	public static Item grayEnderLegs = new ItemArmorBase(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.LEGS, enderInfo);
	public static Item grayEnderBoots = new ItemArmorBase(EnumArmor.ENDER_GRAY, EntityEquipmentSlot.FEET, enderInfo);

	private static Object[] jungleInfo = new Object[] { ArmorInfo.POISON_PROTECTION };
	public static Item jungleHelmet = new ItemArmorBase(EnumArmor.JUNGLE, EntityEquipmentSlot.HEAD, jungleInfo);
	public static Item jungleBody = new ItemArmorBase(EnumArmor.JUNGLE, EntityEquipmentSlot.CHEST, jungleInfo);
	public static Item jungleLegs = new ItemArmorBase(EnumArmor.JUNGLE, EntityEquipmentSlot.LEGS, jungleInfo);
	public static Item jungleBoots = new ItemArmorBase(EnumArmor.JUNGLE, EntityEquipmentSlot.FEET, jungleInfo);

	private static Object[] frozenInfo = new Object[] { ArmorInfo.FREEZE };
	public static Item frozenHelmet = new ItemArmorBase(EnumArmor.FROZEN, EntityEquipmentSlot.HEAD, frozenInfo);
	public static Item frozenBody = new ItemArmorBase(EnumArmor.FROZEN, EntityEquipmentSlot.CHEST, frozenInfo);
	public static Item frozenLegs = new ItemArmorBase(EnumArmor.FROZEN, EntityEquipmentSlot.LEGS, frozenInfo);
	public static Item frozenBoots = new ItemArmorBase(EnumArmor.FROZEN, EntityEquipmentSlot.FEET, frozenInfo);

	private static Object[] corruptedInfo = new Object[] { 20, ArmorInfo.RANGED_DAMAGE };
	public static Item corruptedHelmet = new ItemArmorBase(EnumArmor.CORRUPTED, EntityEquipmentSlot.HEAD,
	        corruptedInfo);
	public static Item corruptedBody = new ItemArmorBase(EnumArmor.CORRUPTED, EntityEquipmentSlot.CHEST, corruptedInfo);
	public static Item corruptedLegs = new ItemArmorBase(EnumArmor.CORRUPTED, EntityEquipmentSlot.LEGS, corruptedInfo);
	public static Item corruptedBoots = new ItemArmorBase(EnumArmor.CORRUPTED, EntityEquipmentSlot.FEET, corruptedInfo);

	private static Object[] terranInfo = new Object[] { 20, ArmorInfo.HASTE };
	public static Item terranHelmet = new ItemArmorBase(EnumArmor.TERRAN, EntityEquipmentSlot.HEAD, terranInfo);
	public static Item terranBody = new ItemArmorBase(EnumArmor.TERRAN, EntityEquipmentSlot.CHEST, terranInfo);
	public static Item terranLegs = new ItemArmorBase(EnumArmor.TERRAN, EntityEquipmentSlot.LEGS, terranInfo);
	public static Item terranBoots = new ItemArmorBase(EnumArmor.TERRAN, EntityEquipmentSlot.FEET, terranInfo);

	// public static Item diamondHelmet = new ItemArmorBase(EnumArmor.DIAMOND,
	// EntityEquipmentSlot.HEAD);
	// public static Item diamondBody = new ItemArmorBase(EnumArmor.DIAMOND,
	// EntityEquipmentSlot.CHEST);
	// public static Item diamondLegs = new ItemArmorBase(EnumArmor.DIAMOND,
	// EntityEquipmentSlot.LEGS);
	// public static Item diamondBoots = new ItemArmorBase(EnumArmor.DIAMOND,
	// EntityEquipmentSlot.FEET);

	// public static Item ironHelmet = new ItemArmorBase(EnumArmor.IRON,
	// EntityEquipmentSlot.HEAD);
	// public static Item ironBody = new ItemArmorBase(EnumArmor.IRON,
	// EntityEquipmentSlot.CHEST);
	// public static Item ironLegs = new ItemArmorBase(EnumArmor.IRON,
	// EntityEquipmentSlot.LEGS);
	// public static Item ironBoots = new ItemArmorBase(EnumArmor.IRON,
	// EntityEquipmentSlot.FEET);

	// public static Item goldHelmet = new ItemArmorBase(EnumArmor.GOLD,
	// EntityEquipmentSlot.HEAD);
	// public static Item goldBody = new ItemArmorBase(EnumArmor.GOLD,
	// EntityEquipmentSlot.CHEST);
	// public static Item goldLegs = new ItemArmorBase(EnumArmor.GOLD,
	// EntityEquipmentSlot.LEGS);
	// public static Item goldBoots = new ItemArmorBase(EnumArmor.GOLD,
	// EntityEquipmentSlot.FEET);

	// Vanilla Tools
	public static Item rupeeShickaxe = new ItemShickaxeBase(ToolMaterialMod.RupeeShick, "rupee_shickaxe");
	public static Item rupeePickaxe = new ItemPickaxeBase(ToolMaterialMod.RupeePick, "rupee_pickaxe");
	public static Item rupeeAxe = new ItemAxeBase(ToolMaterialMod.RupeeAxe, "rupee_axe");
	public static Item rupeeShovel = new ItemShovelBase(ToolMaterialMod.RupeeShovel, "rupee_shovel");
	public static Item rupeeHoe = new ItemHoeBase(ToolMaterialMod.RupeePick, "rupee_hoe");

	public static Item arlemiteShickaxe = new ItemShickaxeBase(ToolMaterialMod.ArlemiteShick, "arlemite_shickaxe");
	public static Item arlemitePickaxe = new ItemPickaxeBase(ToolMaterialMod.ArlemitePick, "arlemite_pickaxe");
	public static Item arlemiteAxe = new ItemAxeBase(ToolMaterialMod.ArlemiteAxe, "arlemite_axe");
	public static Item arlemiteShovel = new ItemShovelBase(ToolMaterialMod.ArlemiteShovel, "arlemite_shovel");
	public static Item arlemiteHoe = new ItemHoeBase(ToolMaterialMod.ArlemitePick, "arlemite_hoe");

	public static Item realmitePickaxe = new ItemPickaxeBase(ToolMaterialMod.RealmitePick, "realmite_pickaxe");
	public static Item realmiteAxe = new ItemAxeBase(ToolMaterialMod.RealmiteAxe, "realmite_axe");
	public static Item realmiteShovel = new ItemShovelBase(ToolMaterialMod.RealmiteShovel, "realmite_shovel");
	public static Item realmiteHoe = new ItemHoeBase(ToolMaterialMod.RealmitePick, "realmite_hoe");

	public static Item bedrockPickaxe = new ItemPickaxeBase(ToolMaterialMod.BedrockPick, "bedrock_pickaxe");
	public static Item bedrockAxe = new ItemAxeBase(ToolMaterialMod.BedrockAxe, "bedrock_axe");
	public static Item bedrockShovel = new ItemShovelBase(ToolMaterialMod.BedrockShovel, "bedrock_shovel");

	public static Item corruptedPickaxe = new ItemPickaxeBase(ToolMaterialMod.CorruptedPick, "corrupted_pickaxe");
	public static Item corruptedAxe = new ItemAxeBase(ToolMaterialMod.CorruptedAxe, "corrupted_axe");
	public static Item corruptedShovel = new ItemShovelBase(ToolMaterialMod.CorruptedShovel, "corrupted_shovel");

	public static Item divineShickaxe = new ItemShickaxeBase(ToolMaterialMod.DivineShick, "divine_shickaxe");
	public static Item divinePickaxe = new ItemPickaxeBase(ToolMaterialMod.DivinePick, "divine_pickaxe");
	public static Item divineAxe = new ItemAxeBase(ToolMaterialMod.DivineAxe, "divine_axe");
	public static Item divineShovel = new ItemShovelBase(ToolMaterialMod.DivineShovel, "divine_shovel");

	// Vanilla Other
	public static Item rupeeIngot = new ItemBase("rupee_ingot");
	public static Item arlemiteIngot = new ItemBase("arlemite_ingot");
	public static Item realmiteIngot = new ItemBase("realmite_ingot");
	public static Item shadowBar = new ItemBase("shadow_bar");
	public static Item hellstoneIngot = new ItemBase("hellstone_ingot");
	public static Item netheriteIngot = new ItemBase("netherite_ingot");
	public static Item bloodgem = new ItemBase("bloodgem");

	public static Item jungleShards = new ItemBase("jungle_shards");
	public static Item divineShards = new ItemBase("divine_shards");
	public static Item corruptedShards = new ItemBase("corrupted_shards");
	public static Item moltenShards = new ItemBase("molten_shards");
	public static Item enderShards = new ItemBase("ender_shards");
	public static Item terranShards = new ItemBase("terran_shards");
	public static Item cyclopsEyeShards = new ItemBase("cyclops_eye_shards");

	public static Item corruptedBullet = new ItemBase("corrupted_bullet");

	public static Item jungleStone = new ItemBase("jungle_stone");
	public static Item divineStone = new ItemBase("divine_stone");
	public static Item corruptedStone = new ItemBase("corrupted_stone");
	public static Item moltenStone = new ItemBase("molten_stone");
	public static Item enderStone = new ItemBase("ender_stone");
	public static Item terranStone = new ItemBase("terran_stone");
	public static Item healingStone = new ItemBase("healing_stone").setHealAmount(20);
	public static Item shadowStone = new ItemBase("shadow_stone");

	public static Item aquaticIngot = new ItemBase("aquatic_ingot");
	public static Item aquaticPellets = new ItemBase("aquatic_pellets");
	public static Item pureAquaticPellets = new ItemBase("pure_aquatic_pellets");
	public static Item cyclopsEye = new ItemBase("cyclops_eye");
	public static Item crabClaw = new ItemBase("crab_claw");
	public static Item legendaryEnderEye = new ItemBase("legendary_ender_eye");
	public static Item sharkFin = new ItemBase("shark_fin");
	public static Item whaleFin = new ItemBase("whale_fin");
	public static Item liopleurodonSkull = new ItemBase("liopleurodon_skull");
	public static Item liopleurodonTeeth = new ItemBase("liopleurodon_teeth");
	public static Item netheriteChunk = new ItemBase("netherite_chunk");
	public static Item bluefireStone = new ItemBase("bluefire_stone");
	public static Item purpleBlaze = new ItemBase("purple_blaze");
	public static Item furyFire = new ItemBase("fury_fire");
	public static Item aquaBall = new ItemBase("aqua_ball");
	public static Item aquaticBlazeRod = new ItemBase("aquatic_blaze_rod");
	public static Item shadowCoins = new ItemBase("shadow_coins");

	public static Item petSpawnEgg = new ItemSpawnEgg("pet_spawn_egg");

	public static Item greenDiamondChunk = new ItemBase("green_diamond_chunk");
	public static Item grayDiamondChunk = new ItemBase("gray_diamond_chunk");
	public static Item blueDiamondChunk = new ItemBase("blue_diamond_chunk");
	public static Item redDiamondChunk = new ItemBase("red_diamond_chunk");
	public static Item yellowDiamondChunk = new ItemBase("yellow_diamond_chunk");

	// public static Item tarBucket = new ItemModBucket(VanillaBlocks.tar,
	// "bucket_of_tar");
	public static Item tarBucket = new ItemNotReady("bucket_of_tar", DRPGCreativeTabs.items);

	public static Item mysteriousClock = new ItemMysteriousClock("mysterious_clock");
	// public static Item mysteriousClock = new ItemNotReady("mysterious_clock",
	// DRPGCreativeTabs.items);
	public static Item watchingEye = new ItemBase("watching_eye");
	public static Item callOfTheWatcher = new ItemCallOfTheWatcher("call_of_the_watcher");
	// public static Item infernalFlame = new ItemInfernalFlame("infernal_flame");
	public static Item infernalFlame = new ItemNotReady("infernal_flame", DRPGCreativeTabs.ranged);
	public static Item hordeHorn = new ItemHordeHorn("horde_horn");

	// public static Item mushroomSeeds = new ItemModSeeds("white_mushroom_seeds",
	// (BlockModCrop) VanillaBlocks.mushroom);
	public static Item whiteMushroomSeeds = new ItemNotReady("white_mushroom_seeds", DRPGCreativeTabs.items);
	// public static Item tomatoSeeds = new ItemModSeeds("tomato_seeds",
	// (BlockModCrop) VanillaBlocks.tomato);
	public static Item tomatoSeeds = new ItemNotReady("tomato_seeds", DRPGCreativeTabs.items);
	public static Item krakenSkin = new ItemBase("kraken_skin");
	public static Item krakenScale = new ItemBase("kraken_scale");

	// public static Item teleportationCrystal = new ItemTeleportationCrystal();
	public static Item teleportationCrystal = new ItemNotReady("teleportation_crystal", DRPGCreativeTabs.items);

	// Iceika
	public static Item snowflake = new ItemBase("snowflake");
	public static Item iceShards = new ItemBase("ice_shards");
	public static Item iceStone = new ItemBase("ice_stone");

	public static Item icicleBane = new ItemSlowingSword(ToolMaterialMod.IcicleBane, "icicle_bane");
	public static Item icineSword = new ItemSlowingSword(ToolMaterialMod.Icine, "icine_sword");
	public static Item enderice = new ItemSlowingSword(ToolMaterialMod.Enderice, "enderice");
	public static Item snowSlash = new ItemSlowingSword(ToolMaterialMod.Snowslash, "snowslash");
	public static Item glacierSword = new ItemSlowingSword(ToolMaterialMod.Glacier, "glacier_sword");
	public static Item frostkingSword = new ItemSlowingSword(ToolMaterialMod.Frostking, "frostking_sword");
	public static Item frozenMaul = new ItemSlowingSword(ToolMaterialMod.FrozenMaul, "frozen_maul");
	public static Item frossivence = new ItemHealingSword("frossivence", ToolMaterialMod.Frossivence, 1);

	// public static Item soundOfCarols = new
	// ItemMusicShooter("sound_of_carols").setCreativeTab(DivineRPGTabs.ranged);
	public static Item soundOfCarols = new ItemNotReady("sound_of_carols", DRPGCreativeTabs.ranged);
	// public static Item soundOfMusic = new
	// ItemMusicShooter("sound_of_music").setCreativeTab(DivineRPGTabs.ranged);
	public static Item soundOfMusic = new ItemNotReady("sound_of_music", DRPGCreativeTabs.ranged);
	// public static Item frostclawCannon = new
	// ItemProjectileShooter("frostclaw_cannon", 16F,
	// Sounds.frostclawCannon.getPrefixedName(),
	// Item.getItemFromBlock(Blocks.cactus),
	// EntityResourceLocation.frostclawCannon.toString(), 10000, 0);
	public static Item frostclawCannon = new ItemNotReady("frostclaw_cannon", DRPGCreativeTabs.ranged);
	// public static Item fractiteCannon = new
	// ItemProjectileShooter("fractite_cannon", 14F,
	// Sounds.fractiteCannon.getPrefixedName(), iceShards,
	// EntityResourceLocation.fractiteCannon.toString(), 10000,
	// 0);
	public static Item fractiteCannon = new ItemNotReady("fractite_cannon", DRPGCreativeTabs.ranged);
	// public static Item snowflakeShuriken = new
	// ItemSnowflakeShuriken("snowflake_shuriken", 7);
	public static Item snowflakeShuriken = new ItemNotReady("snowflake_shuriken", DRPGCreativeTabs.ranged);
	// public static Item serenadeOfIce = new ItemSerenadeOfIce("serenade_of_ice");
	public static Item serenadeOfIce = new ItemNotReady("serenade_of_ice", DRPGCreativeTabs.ranged);

	// public static Item eggNog = new ItemEggNog("egg_nog");
	public static Item eggNog = new ItemNotReady("egg_nog", DRPGCreativeTabs.items);
	public static Item peppermints = new ItemFoodBase(1, 0.3F, false, "peppermints");
	public static Item chocolateLog = new ItemFoodBase(4, 1.0F, false, "chocolate_log");
	public static Item snowCones = new ItemFoodBase(2, 0.3F, false, "snow_cones");
	public static Item fruitCake = new ItemFoodBase(16, 2.0F, false, "fruit_cake");
	public static Item winterberry = new ItemFoodBase(4, 1.0F, false, "winterberry");

	public static Item icicleBow = new ItemBowBase("icicle_bow", 10000, 2, 11, 24000, Items.ARROW, "icicle_arrow");
	public static Item snowstormBow = new ItemBowBase("snowstorm_bow", -1, 2, 11, "snowstorm_arrow");

	private static Object[] santaInfo = new Object[] { ChatFormats.ICEIKA, "Massive Buff", 2, ArmorInfo.SPEED, 6,
	        ArmorInfo.MELEE_DAMAGE, ArmorInfo.HUNGER, 80, ArmorInfo.DAMAGE_REDUCTION };
	public static Item santaCap = new ItemArmorBase(EnumArmor.SANTA, EntityEquipmentSlot.HEAD, santaInfo);
	public static Item santaTunic = new ItemArmorBase(EnumArmor.SANTA, EntityEquipmentSlot.CHEST, santaInfo);
	public static Item santaPants = new ItemArmorBase(EnumArmor.SANTA, EntityEquipmentSlot.LEGS, santaInfo);
	public static Item santaBoots = new ItemArmorBase(EnumArmor.SANTA, EntityEquipmentSlot.FEET, santaInfo);

	public static Item snowGlobe = new ItemSnowGlobe("snow_globe");

	// Foods
	public static Item bacon = new ItemFoodBase(2, 3.0F, true, "bacon");
	public static Item hotPumpkinPie = new ItemFoodBase(5, 7.0F, true, "hot_pumpkin_pie");
	public static Item boiledEgg = new ItemFoodBase(4, 0.5F, false, "boiled_egg");
	public static Item cheese = new ItemFoodBase(2, 0.2F, false, "cheese");
	public static Item whiteMushroom = new ItemFoodBase(1, 0.1F, false, "white_mushroom");
	public static Item advMushroomStew = new ItemFoodBase(10, 10.0F, false, "advanced_mushroom_stew");
	public static Item chickenDinner = new ItemFoodBase(20, 20.0F, false, "chicken_dinner");
	public static Item tomato = new ItemFoodBase(4, 0.3F, false, "tomato");
	public static Item donut = new ItemFoodBase(16, 0.3F, false, "donut");
	public static Item rawEmpoweredMeat = new ItemFoodBase(5, 2.0F, true, "raw_empowered_meat");
	public static Item empoweredMeat = new ItemFoodBase(10, 4.0F, true, "empowered_meat");
	public static Item magicMeat = new ItemFastFood(5, 1.0F, true, "magic_meat");
	public static Item enrichedMagicMeat = new ItemFastFood(7, 2.5F, true, "enriched_magic_meat");

	// Twilight Weapons
	public static Item edenBlade = new ItemSwordBase(ToolMaterialMod.Eden, "eden_blade");
	public static Item wildwoodBlade = new ItemSwordBase(ToolMaterialMod.Wildwood, "wildwood_blade");
	public static Item apalachiaBlade = new ItemSwordBase(ToolMaterialMod.Apalachia, "apalachia_blade");
	public static Item skythernBlade = new ItemSwordBase(ToolMaterialMod.Skythern, "skythern_blade");
	public static Item mortumBlade = new ItemSwordBase(ToolMaterialMod.Mortum, "mortum_blade");
	public static Item haliteBlade = new ItemSwordBase(ToolMaterialMod.Halite, "halite_blade");

	// public static Item edenSlicer = new ItemThrowable("eden_slicer", 8);
	// public static Item wildwoodSlicer = new ItemThrowable("wildwood_slicer", 10);
	// public static Item apalachiaSlicer = new ItemThrowable("apalachia_slicer",
	// 12);
	// public static Item skythernSlicer = new ItemThrowable("skythern_slicer", 14);
	// public static Item mortumSlicer = new ItemThrowable("mortum_slicer", 16);
	// public static Item haliteSlicer = new ItemThrowable("halite_slicer", 22);
	public static Item edenSlicer = new ItemNotReady("eden_slicer", DRPGCreativeTabs.ranged);
	public static Item wildwoodSlicer = new ItemNotReady("wildwood_slicer", DRPGCreativeTabs.ranged);
	public static Item apalachiaSlicer = new ItemNotReady("apalachia_slicer", DRPGCreativeTabs.ranged);
	public static Item skythernSlicer = new ItemNotReady("skythern_slicer", DRPGCreativeTabs.ranged);
	public static Item mortumSlicer = new ItemNotReady("mortum_slicer", DRPGCreativeTabs.ranged);
	public static Item haliteSlicer = new ItemNotReady("halite_slicer", DRPGCreativeTabs.ranged);

	// public static Item edenBlitz = new ItemTwilightBlitz("eden_blitz",
	// x.blitzEden.toString(), TwilightItemsOther.edenDust,
	// 10F).setHasParticle("eden");
	// public static Item wildwoodBlitz = new ItemTwilightBlitz("wildwood_blitz",
	// x.blitzWild.toString(), TwilightItemsOther.wildwoodDust,
	// 12F).setHasParticle("wildwood");
	// public static Item apalachiaBlitz = new ItemTwilightBlitz("apalachia_blitz",
	// x.blitzApalachia.toString(), TwilightItemsOther.apalachiaDust,
	// 14F).setHasParticle("apalachia");
	// public static Item skythernBlitz = new ItemTwilightBlitz("skythern_blitz",
	// x.blitzSkythern.toString(), TwilightItemsOther.skythernDust,
	// 16F).setHasParticle("skythern");
	// public static Item mortumBlitz = new ItemTwilightBlitz("mortum_blitz",
	// x.blitzMortum.toString(), TwilightItemsOther.mortumDust,
	// 18F).setHasParticle("mortum");
	// public static Item haliteBlitz = new ItemTwilightBlitz("halite_blitz",
	// x.blitzHalite.toString(), TwilightItemsOther.mortumDust,
	// 20F).setHasParticle("halite");
	public static Item edenBlitz = new ItemNotReady("eden_blitz", DRPGCreativeTabs.ranged);
	public static Item wildwoodBlitz = new ItemNotReady("wildwood_blitz", DRPGCreativeTabs.ranged);
	public static Item apalachiaBlitz = new ItemNotReady("apalachia_blitz", DRPGCreativeTabs.ranged);
	public static Item skythernBlitz = new ItemNotReady("skythern_blitz", DRPGCreativeTabs.ranged);
	public static Item mortumBlitz = new ItemNotReady("mortum_blitz", DRPGCreativeTabs.ranged);
	public static Item haliteBlitz = new ItemNotReady("halite_blitz", DRPGCreativeTabs.ranged);

	// public static Item edenPhaser = new ItemProjectileShooter("eden_phaser", 14F,
	// Sounds.phaser.getPrefixedName(), x.phaserEden.toString(), 3000,
	// 3).setHasParticle("eden");
	// public static Item wildwoodPhaser = new
	// ItemProjectileShooter("wildwood_phaser", 17F,
	// Sounds.phaser.getPrefixedName(), x.phaserWild.toString(), 3000,
	// 3).setHasParticle("wildwood");
	// public static Item apalachiaPhaser = new
	// ItemProjectileShooter("apalachia_phaser", 20F,
	// Sounds.phaser.getPrefixedName(), x.phaserApalachia.toString(), 3000,
	// 3).setHasParticle("apalachia");
	// public static Item skythernPhaser = new
	// ItemProjectileShooter("skythern_phaser", 23F,
	// Sounds.phaser.getPrefixedName(), x.phaserSkythern.toString(), 3000,
	// 3).setHasParticle("skythern");
	// public static Item mortumPhaser = new ItemProjectileShooter("mortum_phaser",
	// 26F, Sounds.phaser.getPrefixedName(), x.phaserMortum.toString(), 3000,
	// 3).setHasParticle("mortum");
	// public static Item halitePhaser = new ItemProjectileShooter("halite_phaser",
	// 29F, Sounds.phaser.getPrefixedName(), x.phaserHalite.toString(), 3000,
	// 3).setHasParticle("halite");
	public static Item edenPhaser = new ItemNotReady("eden_phaser", DRPGCreativeTabs.ranged);
	public static Item wildwoodPhaser = new ItemNotReady("wildwood_phaser", DRPGCreativeTabs.ranged);
	public static Item apalachiaPhaser = new ItemNotReady("apalachia_phaser", DRPGCreativeTabs.ranged);
	public static Item skythernPhaser = new ItemNotReady("skythern_phaser", DRPGCreativeTabs.ranged);
	public static Item mortumPhaser = new ItemNotReady("mortum_phaser", DRPGCreativeTabs.ranged);
	public static Item halitePhaser = new ItemNotReady("halite_phaser", DRPGCreativeTabs.ranged);

	public static Item edenArrow = new ItemBase("eden_arrow").setCreativeTab(DRPGCreativeTabs.ranged);
	public static Item wildwoodArrow = new ItemBase("wildwood_arrow").setCreativeTab(DRPGCreativeTabs.ranged);
	public static Item furyArrow = new ItemBase("fury_arrow").setCreativeTab(DRPGCreativeTabs.ranged);

	public static Item edenBow = new ItemBowBase("eden_bow", -1, 6, 16, edenArrow);
	public static Item wildwoodBow = new ItemBowBase("wildwood_bow", -1, 6, 16, 36000, wildwoodArrow);
	public static Item apalachiaBow = new ItemBowBase("apalachia_bow", -1, 10, 20, wildwoodArrow);
	public static Item skythernBow = new ItemBowBase("skythern_bow", -1, 10, 20, 36000, wildwoodArrow);
	public static Item mortumBow = new ItemBowBase("mortum_bow", -1, 13, 25, furyArrow);
	public static Item haliteBow = new ItemBowBase("halite_bow", -1, 13, 25, 36000, furyArrow);
	public static Item twilightBow = new ItemBowBase("twilight_bow", -1, 13, 25, 14400, furyArrow).setCreativeTab(null);

	// Twilight Tools
	public static Item edenPickaxe = new ItemPickaxeBase(ToolMaterialMod.EdenPick, "eden_pickaxe");
	public static Item wildwoodPickaxe = new ItemPickaxeBase(ToolMaterialMod.WildwoodPick, "wildwood_pickaxe");
	public static Item apalachiaPickaxe = new ItemPickaxeBase(ToolMaterialMod.ApalachiaPick, "apalachia_pickaxe");
	public static Item skythernPickaxe = new ItemPickaxeBase(ToolMaterialMod.SkythernPick, "skythern_pickaxe");
	public static Item mortumPickaxe = new ItemPickaxeBase(ToolMaterialMod.MortumPick, "mortum_pickaxe");

	public static Item edenAxe = new ItemAxeBase(ToolMaterialMod.EdenAxe, "eden_axe");
	public static Item wildwoodAxe = new ItemAxeBase(ToolMaterialMod.WildwoodAxe, "wildwood_axe");
	public static Item apalachiaAxe = new ItemAxeBase(ToolMaterialMod.ApalachiaAxe, "apalachia_axe");
	public static Item skythernAxe = new ItemAxeBase(ToolMaterialMod.SkythernAxe, "skythern_axe");
	public static Item mortumAxe = new ItemAxeBase(ToolMaterialMod.MortumAxe, "mortum_axe");

	public static Item edenShovel = new ItemShovelBase(ToolMaterialMod.EdenShovel, "eden_shovel");
	public static Item wildwoodShovel = new ItemShovelBase(ToolMaterialMod.WildwoodShovel, "wildwood_shovel");
	public static Item apalachiaShovel = new ItemShovelBase(ToolMaterialMod.ApalachiaShovel, "apalachia_shovel");
	public static Item skythernShovel = new ItemShovelBase(ToolMaterialMod.SkythernShovel, "skythern_shovel");
	public static Item mortumShovel = new ItemShovelBase(ToolMaterialMod.MortumShovel, "mortum_shovel");

	// Twilight Armor
	private static Object[] edenInfo = new Object[] { 3, ArmorInfo.ORE_DROPS };
	public static Item edenHelmet = new ItemArmorBase(EnumArmor.EDEN, EntityEquipmentSlot.HEAD, edenInfo);
	public static Item edenChestplate = new ItemArmorBase(EnumArmor.EDEN, EntityEquipmentSlot.CHEST, edenInfo);
	public static Item edenLeggings = new ItemArmorBase(EnumArmor.EDEN, EntityEquipmentSlot.LEGS, edenInfo);
	public static Item edenBoots = new ItemArmorBase(EnumArmor.EDEN, EntityEquipmentSlot.FEET, edenInfo);

	private static Object[] wildInfo = new Object[] { ArmorInfo.UNDERWATER_HEALTH_REGEN };
	public static Item wildwoodHelmet = new ItemArmorBase(EnumArmor.WILD, EntityEquipmentSlot.HEAD, wildInfo);
	public static Item wildwoodChestplate = new ItemArmorBase(EnumArmor.WILD, EntityEquipmentSlot.CHEST, wildInfo);
	public static Item wildwoodLeggings = new ItemArmorBase(EnumArmor.WILD, EntityEquipmentSlot.LEGS, wildInfo);
	public static Item wildwoodBoots = new ItemArmorBase(EnumArmor.WILD, EntityEquipmentSlot.FEET, wildInfo);

	private static Object[] apInfo = new Object[] { ArmorInfo.BLOCK_PROTECTION };
	public static Item apalachiaHelmet = new ItemArmorBase(EnumArmor.APALACHIA, EntityEquipmentSlot.HEAD, apInfo);
	public static Item apalachiaChestplate = new ItemArmorBase(EnumArmor.APALACHIA, EntityEquipmentSlot.CHEST, apInfo);
	public static Item apalachiaLeggings = new ItemArmorBase(EnumArmor.APALACHIA, EntityEquipmentSlot.LEGS, apInfo);
	public static Item apalachiaBoots = new ItemArmorBase(EnumArmor.APALACHIA, EntityEquipmentSlot.FEET, apInfo);

	private static Object[] skyInfo = new Object[] { 5, ArmorInfo.JUMP_HEIGHT, ArmorInfo.NO_FALL };
	public static Item skythernHelmet = new ItemArmorBase(EnumArmor.SKYTHERN, EntityEquipmentSlot.HEAD, skyInfo);
	public static Item skythernChestplate = new ItemArmorBase(EnumArmor.SKYTHERN, EntityEquipmentSlot.CHEST, skyInfo);
	public static Item skythernLeggings = new ItemArmorBase(EnumArmor.SKYTHERN, EntityEquipmentSlot.LEGS, skyInfo);
	public static Item skythernBoots = new ItemArmorBase(EnumArmor.SKYTHERN, EntityEquipmentSlot.FEET, skyInfo);

	private static Object[] mortInfo = new Object[] { ArmorInfo.NIGHT_VISION };
	public static Item mortumHelmet = new ItemArmorBase(EnumArmor.MORTUM, EntityEquipmentSlot.HEAD, mortInfo);
	public static Item mortumChestplate = new ItemArmorBase(EnumArmor.MORTUM, EntityEquipmentSlot.CHEST, mortInfo);
	public static Item mortumLeggings = new ItemArmorBase(EnumArmor.MORTUM, EntityEquipmentSlot.LEGS, mortInfo);
	public static Item mortumBoots = new ItemArmorBase(EnumArmor.MORTUM, EntityEquipmentSlot.FEET, mortInfo);

	private static Object[] halInfo = new Object[] { 16, ArmorInfo.MELEE_DAMAGE };
	public static Item haliteHelmet = new ItemArmorBase(EnumArmor.HALITE, EntityEquipmentSlot.HEAD, halInfo);
	public static Item haliteChestplate = new ItemArmorBase(EnumArmor.HALITE, EntityEquipmentSlot.CHEST, halInfo);
	public static Item haliteLeggings = new ItemArmorBase(EnumArmor.HALITE, EntityEquipmentSlot.LEGS, halInfo);
	public static Item haliteBoots = new ItemArmorBase(EnumArmor.HALITE, EntityEquipmentSlot.FEET, halInfo);

	// Twilight Crops
	public static Item moonbulb = new ItemFastFood(1, 5, false, "moonbulb");
	// public static Item moonbulbSeeds = new ItemTwilightSeeds("moonbulb_seeds",
	// ModBlocks.moonbulb, Blocks.GRASS);
	public static Item moonbulbSeeds = new ItemNotReady("moonbulb_seeds", DRPGCreativeTabs.items);
	public static Item purpleGlowbone = new ItemFastFood(3, 5, false, "purple_glowbone");
	// public static Item purpleGlowboneSeeds = new
	// ItemTwilightSeeds("purple_glowbone_seeds", ModBlocks.purpleGlowbone,
	// Blocks.GRASS);
	public static Item purpleGlowboneSeeds = new ItemNotReady("purple_glowbone_seeds", DRPGCreativeTabs.items);
	public static Item pinkGlowbone = new ItemFastFood(3, 5, false, "pink_glowbone");
	// public static Item pinkGlowboneSeeds = new
	// ItemTwilightSeeds("pink_glowbone_seeds", ModBlocks.pinkGlowbone,
	// Blocks.GRASS);
	public static Item pinkGlowboneSeeds = new ItemNotReady("pink_glowbone_seeds", DRPGCreativeTabs.items);
	// public static Item skyFlower = new ItemSkyFlower();
	public static Item skyFlower = new ItemNotReady("sky_flower", DRPGCreativeTabs.items);
	// public static Item skyPlantSeeds = new ItemTwilightSeeds("sky_plant_seeds",
	// ModBlocks.skyPlant, Blocks.GRASS);
	public static Item skyPlantSeeds = new ItemNotReady("sky_plant_seeds", DRPGCreativeTabs.items);

	// Twilight Items
	public static Item edenSoul = new ItemBase("eden_soul");
	public static Item wildwoodSoul = new ItemBase("wildwood_soul");
	public static Item apalachiaSoul = new ItemBase("apalachia_soul");
	public static Item skythernSoul = new ItemBase("skythern_soul");
	public static Item mortumSoul = new ItemBase("mortum_soul");

	public static Item edenFragments = new ItemBase("eden_fragments");
	public static Item wildwoodFragments = new ItemBase("wildwood_fragments");
	public static Item apalachiaFragments = new ItemBase("apalachia_fragments");
	public static Item skythernFragments = new ItemBase("skythern_fragments");
	public static Item mortumFragments = new ItemBase("mortum_fragments");

	public static Item edenGem = new ItemBase("eden_gem");
	public static Item wildwoodGem = new ItemBase("wildwood_gem");
	public static Item apalachiaGem = new ItemBase("apalachia_gem");
	public static Item skythernGem = new ItemBase("skythern_gem");
	public static Item mortumGem = new ItemBase("mortum_gem");

	public static Item edenChunk = new ItemBase("eden_chunk");
	public static Item wildwoodChunk = new ItemBase("wildwood_chunk");
	public static Item apalachiaChunk = new ItemBase("apalachia_chunk");
	public static Item skythernChunk = new ItemBase("skythern_chunk");
	public static Item mortumChunk = new ItemBase("mortum_chunk");

	public static Item edenDust = new ItemBase("eden_dust");
	public static Item wildwoodDust = new ItemBase("wildwood_dust");
	public static Item apalachiaDust = new ItemBase("apalachia_dust");
	public static Item skythernDust = new ItemBase("skythern_dust");
	public static Item mortumDust = new ItemBase("mortum_dust");

	// public static Item twilightClock = new ItemTwilightClock("twilight_clock");
	public static Item twilightClock = new ItemNotReady("twilight_clock", DRPGCreativeTabs.items);

	public static Item edenSparkles = new ItemBase("eden_sparkles");

	public static Item baseSpawnCrystal = new ItemBase("base_spawn_crystal");
	// public static Item densosCrystal = new ItemTwilightSpawner("densos_crystal");
	// public static Item karotCrystal = new ItemTwilightSpawner("karot_crystal");
	// public static Item reyvorCrystal = new ItemTwilightSpawner("reyvor_crystal");
	// public static Item soulFiendCrystal = new
	// ItemTwilightSpawner("soul_fiend_crystal");
	// public static Item twilightDemonCrystal = new
	// ItemTwilightSpawner("twilight_demon_crystal");
	// public static Item vamacheronCrystal = new
	// ItemTwilightSpawner("vamacheron_crystal");
	// public static Item eternalArcherCrystal = new
	// ItemTwilightSpawner("eternal_archer_crystal");
	public static Item densosCrystal = new ItemNotReady("densos_crystal", DRPGCreativeTabs.items);
	public static Item karotCrystal = new ItemNotReady("karot_crystal", DRPGCreativeTabs.items);
	public static Item reyvorCrystal = new ItemNotReady("reyvor_crystal", DRPGCreativeTabs.items);
	public static Item soulFiendCrystal = new ItemNotReady("soul_fiend_crystal", DRPGCreativeTabs.items);
	public static Item twilightDemonCrystal = new ItemNotReady("twilight_demon_crystal", DRPGCreativeTabs.items);
	public static Item vamacheronCrystal = new ItemNotReady("vamacheron_crystal", DRPGCreativeTabs.items);
	public static Item eternalArcherCrystal = new ItemNotReady("eternal_archer_crystal", DRPGCreativeTabs.items);

	// Arcana
	public static Item dungeonTokens = new ItemBase("dungeon_tokens");
	public static Item arcanium = new ItemBase("arcanium");
	// public static Item staffStarlight = new
	// ItemStaffStarlight("staffOfStarlight");
	// public static Item starlight = new ItemStaffStarlight("starlight");
	// public static Item stormSword = new ItemStormSword("stormSword",
	// ToolMaterialMod.Storm);
	public static Item staffStarlight = new ItemNotReady("staff_of_starlight", DRPGCreativeTabs.items);
	public static Item starlight = new ItemNotReady("starlight", DRPGCreativeTabs.items);
	public static Item stormSword = new ItemNotReady("storm_sword", DRPGCreativeTabs.ranged);
	// public static Item captainsSparkler = new
	// ItemCaptainsSparkler("captains_sparkler");
	public static Item captainsSparkler = new ItemNotReady("captains_sparkler", DRPGCreativeTabs.ranged);
	// public static Item strongArcanaPotion = new
	// ItemArcanaPotion("strongArcanaPotion", 200);
	// public static Item weakArcanaPotion = new
	// ItemArcanaPotion("weakArcanaPotion", 100);
	public static Item strongArcanaPotion = new ItemNotReady("strong_arcana_potion", DRPGCreativeTabs.items);
	public static Item weakArcanaPotion = new ItemNotReady("weak_arcana_potion", DRPGCreativeTabs.items);
	public static Item collector = new ItemBase("collector");
	// public static Item chargedCollector = new
	// ItemChargedCollector("chargedCollector");
	// public static Item wizardBook = new ItemWizardsBook("wizardsBook");
	// public static Item staffOfEnrichment = new
	// ItemStaffEnrichment("staffOfEnrichment");
	// public static Item orbOfLight = new ItemOrbOfLight();
	// public static Item meriksMissile = new ItemMeriksMissile("meriksMissile", 1,
	// -1, 50);
	// public static Item grenade = new ItemGrenade("grenade");
	// public static Item firefly = new ItemFirefly();
	// public static Item laVekor = new ItemLaVekor();
	// public static Item enderScepter = new ItemEnderScepter("enderScepter");
	// public static Item arcaniumSaber = new ItemArcaniumSaber("arcaniumSaber",
	// ToolMaterialMod.Saber);
	// public static Item ghostbane = new ItemGhostbane();
	// public static Item arcaniumReflector = new ItemReflector();
	// public static Item shadowSword = new ItemShadowSword("shadowSaber",
	// ToolMaterialMod.ShadowSaber);
	// public static Item liviciaSword = new
	// ItemSwordBase(ToolMaterialMod.LiviciaSword, "liviciaSword");
	// public static Item meteorMash = new ItemMeteorMash();
	// public static Item divineAccumulator = new ItemDivineAccumulator();
	// public static Item arcaniteBlaster = new ItemArcaniteBlaster();
	// public static Item arcaniteBlade = new ItemArcaniteBlade();
	// public static Item generalsStaff = new ItemGeneralsStaff();
	// public static Item arcaniumAttractor = new ItemAttractor();
	public static Item chargedCollector = new ItemNotReady("charged_collector", DRPGCreativeTabs.items);
	public static Item wizardBook = new ItemNotReady("wizards_book", DRPGCreativeTabs.items);
	public static Item staffOfEnrichment = new ItemNotReady("staff_of_enrichment", DRPGCreativeTabs.tools);
	public static Item orbOfLight = new ItemNotReady("orb_of_light", DRPGCreativeTabs.items);
	public static Item meriksMissile = new ItemNotReady("meriks_missile", DRPGCreativeTabs.ranged);
	public static Item grenade = new ItemNotReady("grenade", DRPGCreativeTabs.ranged);
	public static Item firefly = new ItemNotReady("firefly", DRPGCreativeTabs.ranged);
	public static Item laVekor = new ItemNotReady("la_vekor", DRPGCreativeTabs.ranged);
	public static Item enderScepter = new ItemNotReady("ender_scepter", DRPGCreativeTabs.items);
	public static Item arcaniumSaber = new ItemNotReady("arcanium_saber", DRPGCreativeTabs.ranged);
	public static Item ghostbane = new ItemNotReady("ghostbane", DRPGCreativeTabs.ranged);
	public static Item arcaniumReflector = new ItemNotReady("arcanium_reflector", DRPGCreativeTabs.ranged);
	public static Item shadowSword = new ItemNotReady("shadow_saber", DRPGCreativeTabs.ranged);
	public static Item liviciaSword = new ItemNotReady("livicia_sword", DRPGCreativeTabs.ranged);
	public static Item meteorMash = new ItemNotReady("meteor_mash", DRPGCreativeTabs.ranged);
	public static Item divineAccumulator = new ItemNotReady("divine_accumulator", DRPGCreativeTabs.ranged);
	public static Item arcaniteBlaster = new ItemNotReady("arcanite_blaster", DRPGCreativeTabs.ranged);
	public static Item arcaniteBlade = new ItemNotReady("arcanite_blade", DRPGCreativeTabs.ranged);
	public static Item generalsStaff = new ItemNotReady("generals_staff", DRPGCreativeTabs.ranged);
	public static Item arcaniumAttractor = new ItemNotReady("arcanium_attractor", DRPGCreativeTabs.ranged);

	// public static Item sludgeKey = new ItemKey("sludgeKey");
	// public static Item ancientKey = new ItemKey("ancientKey");
	// public static Item soulKey = new ItemKey("soulKey");
	// public static Item degradedKey = new ItemKey("degradedKey");
	public static Item sludgeKey = new ItemNotReady("sludge_key", DRPGCreativeTabs.items);
	public static Item ancientKey = new ItemNotReady("ancient_key", DRPGCreativeTabs.items);
	public static Item soulKey = new ItemNotReady("soul_key", DRPGCreativeTabs.items);
	public static Item degradedKey = new ItemNotReady("degraded_key", DRPGCreativeTabs.items);

	// public static Item golemSpawner = new ItemArcanaSpawnEgg("golemEgg");
	// public static Item seimerSpawner = new ItemArcanaSpawnEgg("seimerEgg");
	// public static Item paratikuSpawner = new ItemArcanaSpawnEgg("paratikuEgg");
	// public static Item fyracryxSpawner = new ItemArcanaSpawnEgg("fyracryxEgg");
	public static Item golemSpawner = new ItemNotReady("golem_egg", DRPGCreativeTabs.items);
	public static Item seimerSpawner = new ItemNotReady("seimer_egg", DRPGCreativeTabs.items);
	public static Item paratikuSpawner = new ItemNotReady("paratiku_egg", DRPGCreativeTabs.items);
	public static Item fyracryxSpawner = new ItemNotReady("fyracryx_egg", DRPGCreativeTabs.items);

	public static Item hitchak = new ItemFoodBase(2, 3, false, "hitchak");
	// public static Item hitchakSeeds = new ItemArcanaSeeds("hitchakSeeds",
	// (BlockModCrop) ArcanaBlocks.hitchak);
	public static Item hitchakSeeds = new ItemNotReady("hitchak_seeds", DRPGCreativeTabs.items);
	public static Item veilo = new ItemBase("veilo");
	// public static Item veiloSeeds = new ItemArcanaSeeds("veiloSeeds",
	// (BlockModCrop) ArcanaBlocks.veilo);
	public static Item veiloSeeds = new ItemNotReady("veilo_seeds", DRPGCreativeTabs.items);
	public static Item marsine = new ItemBase("marsine");
	// public static Item marsineSeeds = new ItemArcanaSeeds("marsineSeeds",
	// (BlockModCrop) ArcanaBlocks.marsine);
	// public static Item lamona = new ItemLamona();
	// public static Item lamonaSeeds = new ItemArcanaSeeds("lamonaSeeds",
	// (BlockModCrop) ArcanaBlocks.lamona);
	public static Item marsineSeeds = new ItemNotReady("marsine_seeds", DRPGCreativeTabs.items);
	public static Item lamona = new ItemNotReady("lamona", DRPGCreativeTabs.items);
	public static Item lamonaSeeds = new ItemNotReady("lamona_seeds", DRPGCreativeTabs.items);
	public static Item firestock = new ItemBase("firestock");
	// public static Item firestockSeeds = new ItemTwilightSeeds("firestockSeeds",
	// ArcanaBlocks.firestock, ArcanaBlocks.arcanaGrass);
	public static Item firestockSeeds = new ItemNotReady("firestock_seeds", DRPGCreativeTabs.items);
	public static Item pinfly = new ItemFoodBase(2, 0.3F, false, "pinfly")
	        .setPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2), 1.0F);
	// public static Item pinflySeeds = new ItemTwilightSeeds("pinflySeeds",
	// ArcanaBlocks.pinfly, ArcanaBlocks.arcanaGrass);
	// public static Item aquamarine = new ItemAquamarine("aquamarine");
	// public static Item aquamarineSeeds = new ItemArcanaSeeds("aquamarineSeeds",
	// (BlockModCrop) ArcanaBlocks.aquamarine);
	// public static Item eucalyptusSeeds = new
	// ItemArcanaSeeds("eucalyptusRootSeeds", (BlockModCrop)
	// ArcanaBlocks.eucalyptusRoot);
	public static Item pinflySeeds = new ItemNotReady("pinfly_seeds", DRPGCreativeTabs.items);
	public static Item aquamarine = new ItemNotReady("aquamarine", DRPGCreativeTabs.items);
	public static Item aquamarineSeeds = new ItemNotReady("aquamarine_seeds", DRPGCreativeTabs.items);
	public static Item eucalyptusSeeds = new ItemNotReady("eucalyptus_root_seeds", DRPGCreativeTabs.items);

	private static Object[] kormInfo = new Object[] { ArmorInfo.ARCANA_REGEN };
	public static Item kormaHelmet = new ItemArmorBase(EnumArmor.KORMA, EntityEquipmentSlot.HEAD, kormInfo);
	public static Item kormaBody = new ItemArmorBase(EnumArmor.KORMA, EntityEquipmentSlot.CHEST, kormInfo);
	public static Item kormaLegs = new ItemArmorBase(EnumArmor.KORMA, EntityEquipmentSlot.LEGS, kormInfo);
	public static Item kormaBoots = new ItemArmorBase(EnumArmor.KORMA, EntityEquipmentSlot.FEET, kormInfo);

	private static Object[] vemInfo = new Object[] { ArmorInfo.HEALTH_REGEN };
	public static Item vemosHelmet = new ItemArmorBase(EnumArmor.VEMOS, EntityEquipmentSlot.HEAD, vemInfo);
	public static Item vemosBody = new ItemArmorBase(EnumArmor.VEMOS, EntityEquipmentSlot.CHEST, vemInfo);
	public static Item vemosLegs = new ItemArmorBase(EnumArmor.VEMOS, EntityEquipmentSlot.LEGS, vemInfo);
	public static Item vemosBoots = new ItemArmorBase(EnumArmor.VEMOS, EntityEquipmentSlot.FEET, vemInfo);

	// Vethea
	public static Item dirtyPearls = new ItemBase("dirty_pearls");
	public static Item cleanPearls = new ItemBase("clean_pearls");
	public static Item polishedPearls = new ItemBase("polished_pearls");
	public static Item shinyPearls = new ItemBase("shiny_pearls");

	// public static Item barredDoor = new ItemModDoor(VetheaBlocks.barredDoor,
	// "barred_door");
	// public static Item barredDoor = new ItemNotReady("barred_door",
	// DRPGCreativeTabs.items);

	public static Item teakerLump = new ItemBase("teaker_lump");
	public static Item amthirmisLump = new ItemBase("amthirmis_lump");
	public static Item darvenLump = new ItemBase("darven_lump");
	public static Item cermileLump = new ItemBase("cermile_lump");
	public static Item pardimalLump = new ItemBase("pardimal_lump");
	public static Item quadroticLump = new ItemBase("quadrotic_lump");
	public static Item karosLump = new ItemBase("karos_lump");
	public static Item heliosisLump = new ItemBase("heliosis_lump");
	public static Item arksianeLump = new ItemBase("arksiane_lump");

	// public static Item teakerDisk = new ItemDisk(4, "teaker_disk");
	// public static Item amthrimisDisk = new ItemDisk(6, "amthirmis_disk");
	// public static Item darvenDisk = new ItemDisk(9, "darven_disk");
	// public static Item cermileDisk = new ItemDisk(13, "cermile_disk");
	// public static Item pardimalDisk = new ItemDisk(16, "pardimal_disk");
	// public static Item quadroticDisk = new ItemDisk(20, "quadrotic_wardisk");
	// public static Item karosDisk = new ItemDisk(22, "karos_wardisk");
	// public static Item heliosisDisk = new ItemDisk(29, "heliosis_wrathdisk");
	// public static Item arksianeDisk = new ItemDisk(37, "arksiane_wrathdisk");
	public static Item teakerDisk = new ItemNotReady("teaker_disk", DRPGCreativeTabs.ranged);
	public static Item amthrimisDisk = new ItemNotReady("amthirmis_disk", DRPGCreativeTabs.ranged);
	public static Item darvenDisk = new ItemNotReady("darven_disk", DRPGCreativeTabs.ranged);
	public static Item cermileDisk = new ItemNotReady("cermile_disk", DRPGCreativeTabs.ranged);
	public static Item pardimalDisk = new ItemNotReady("pardimal_disk", DRPGCreativeTabs.ranged);
	public static Item quadroticDisk = new ItemNotReady("quadrotic_wardisk", DRPGCreativeTabs.ranged);
	public static Item karosDisk = new ItemNotReady("karos_wardisk", DRPGCreativeTabs.ranged);
	public static Item heliosisDisk = new ItemNotReady("heliosis_wrathdisk", DRPGCreativeTabs.ranged);
	public static Item arksianeDisk = new ItemNotReady("arksiane_wrathdisk", DRPGCreativeTabs.ranged);

	// public static Item teakerStaff = new ItemStaff(3, 10, "teaker_staff");
	// public static Item amthrimisStaff = new ItemStaff(5, 10, "amthirmis_staff");
	// public static Item darvenStaff = new ItemStaff(8, 10, "darven_staff");
	// public static Item cermileStaff = new ItemStaff(12, 10, "cermile_staff");
	// public static Item pardimalStaff = new ItemStaff(15, 10, "pardimal_staff");
	// public static Item quadroticStaff = new ItemStaff(19, 10,
	// "quadrotic_warstaff");
	// public static Item karosStaff = new ItemStaff(21, 10, "karos_warstaff");
	// public static Item heliosisStaff = new ItemStaff(28, 10,
	// "heliosis_wrathstaff");
	// public static Item arksianeStaff = new ItemStaff(36, 10,
	// "arksiane_wrathstaff");
	public static Item teakerStaff = new ItemNotReady("teaker_staff", DRPGCreativeTabs.ranged);
	public static Item amthrimisStaff = new ItemNotReady("amthirmis_staff", DRPGCreativeTabs.ranged);
	public static Item darvenStaff = new ItemNotReady("darven_staff", DRPGCreativeTabs.ranged);
	public static Item cermileStaff = new ItemNotReady("cermile_staff", DRPGCreativeTabs.ranged);
	public static Item pardimalStaff = new ItemNotReady("pardimal_staff", DRPGCreativeTabs.ranged);
	public static Item quadroticStaff = new ItemNotReady("quadrotic_warstaff", DRPGCreativeTabs.ranged);
	public static Item karosStaff = new ItemNotReady("karos_warstaff", DRPGCreativeTabs.ranged);
	public static Item heliosisStaff = new ItemNotReady("heliosis_wrathstaff", DRPGCreativeTabs.ranged);
	public static Item arksianeStaff = new ItemNotReady("arksiane_wrathstaff", DRPGCreativeTabs.ranged);

	// public static Item honeysuckle = new ItemVetheanFood(1, 0.2F, "honeysuckle");
	// public static Item honeychunk = new ItemVetheanFood(1, 0.2F, "honeychunk");
	// public static Item dreamCarrot = new ItemVetheanFood(3, 0.4F,
	// "dream_carrot");
	// public static Item dreamMelon = new ItemVetheanFood(6, 0.6F, "dream_melon");
	// public static Item dreamPie = new ItemVetheanFood(4, 0.8F, "dream_pie");
	// public static Item dreamCake = new ItemVetheanFood(8, 0.8F, "dream_cake");
	// public static Item dreamSweets = new ItemVetheanHealingFood(0, 0F, false, 2,
	// "dream_sweets");
	// public static Item dreamSours = new ItemVetheanHealingFood(0, 0F, false, 8,
	// "dream_sours");
	public static Item honeysuckle = new ItemNotReady("honeysuckle", DRPGCreativeTabs.items);
	public static Item honeychunk = new ItemNotReady("honeychunk", DRPGCreativeTabs.items);
	public static Item dreamCarrot = new ItemNotReady("dream_carrot", DRPGCreativeTabs.items);
	public static Item dreamMelon = new ItemNotReady("dream_melon", DRPGCreativeTabs.items);
	public static Item dreamPie = new ItemNotReady("dream_pie", DRPGCreativeTabs.items);
	public static Item dreamCake = new ItemNotReady("dream_cake", DRPGCreativeTabs.items);
	public static Item dreamSweets = new ItemNotReady("dream_sweets", DRPGCreativeTabs.items);
	public static Item dreamSours = new ItemNotReady("dream_sours", DRPGCreativeTabs.items);
	public static Item acid = new ItemBase("acid");
	public static Item heivaBelt = new ItemBase("band_of_heiva_hunting");
	public static Item minersAmulet = new ItemBase("miners_amulet");

	public static Item hammerTemplate = new ItemBase("hammer_template");
	public static Item backswordTemplate = new ItemBase("backsword_template");
	public static Item bowTemplate = new ItemBase("bow_template");
	public static Item cannonTemplate = new ItemBase("cannon_template");
	public static Item clawTemplate = new ItemBase("claw_template");
	public static Item diskTemplate = new ItemBase("disk_template");
	public static Item staffTemplate = new ItemBase("staff_template");
	public static Item degradedTemplate = new ItemBase("degraded_template");
	public static Item finishedTemplate = new ItemBase("finished_template");
	public static Item glisteningTemplate = new ItemBase("glistening_template");
	public static Item demonizedTemplate = new ItemBase("demonized_template");
	public static Item tormentedTemplate = new ItemBase("tormented_template");

	// public static Item teakerCannon = new ItemVetheanCannon("teaker_cannon", 3);
	// public static Item amthrimisCannon = new
	// ItemVetheanCannon("amthirmis_cannon", 5);
	// public static Item darvenCannon = new ItemVetheanCannon("darven_cannon", 8);
	// public static Item cermileCannon = new ItemVetheanCannon("cermile_cannon",
	// 12);
	// public static Item pardimalCannon = new ItemVetheanCannon("pardimal_cannon",
	// 15);
	// public static Item quadroticCannon = new
	// ItemVetheanCannon("quadrotic_warcannon", 19);
	// public static Item karosCannon = new ItemVetheanCannon("karos_warcannon",
	// 21);
	// public static Item heliosisCannon = new
	// ItemVetheanCannon("heliosis_wrathcannon", 28);
	// public static Item arksianeCannon = new
	// ItemVetheanCannon("arksiane_wrathcannon", 36);
	public static Item teakerCannon = new ItemNotReady("teaker_cannon", DRPGCreativeTabs.ranged);
	public static Item amthrimisCannon = new ItemNotReady("amthirmis_cannon", DRPGCreativeTabs.ranged);
	public static Item darvenCannon = new ItemNotReady("darven_cannon", DRPGCreativeTabs.ranged);
	public static Item cermileCannon = new ItemNotReady("cermile_cannon", DRPGCreativeTabs.ranged);
	public static Item pardimalCannon = new ItemNotReady("pardimal_cannon", DRPGCreativeTabs.ranged);
	public static Item quadroticCannon = new ItemNotReady("quadrotic_warcannon", DRPGCreativeTabs.ranged);
	public static Item karosCannon = new ItemNotReady("karos_warcannon", DRPGCreativeTabs.ranged);
	public static Item heliosisCannon = new ItemNotReady("heliosis_wrathcannon", DRPGCreativeTabs.ranged);
	public static Item arksianeCannon = new ItemNotReady("arksiane_wrathcannon", DRPGCreativeTabs.ranged);

	// public static Item teakerHammer = new ItemVetheanSword("teaker_hammer",
	// Util.addHammerMaterial(6));
	// public static Item amthrimisHammer = new ItemVetheanSword("amthirmis_hammer",
	// Util.addHammerMaterial(8));
	// public static Item darvenHammer = new ItemVetheanSword("darven_hammer",
	// Util.addHammerMaterial(12));
	// public static Item cermileHammer = new ItemVetheanSword("cermile_hammer",
	// Util.addHammerMaterial(15));
	// public static Item pardimalHammer = new ItemVetheanSword("pardimal_hammer",
	// Util.addHammerMaterial(19));
	// public static Item quadroticHammer = new
	// ItemVetheanSword("quadrotic_warhammer", Util.addHammerMaterial(24));
	// public static Item karosHammer = new ItemVetheanSword("karos_warhammer",
	// Util.addHammerMaterial(26));
	// public static Item heliosisHammer = new
	// ItemVetheanSword("heliosis_wrathhammer", Util.addHammerMaterial(33));
	// public static Item arksianeHammer = new
	// ItemVetheanSword("arksiane_wrathhammer", Util.addHammerMaterial(39));
	public static Item teakerHammer = new ItemNotReady("teaker_hammer", DRPGCreativeTabs.ranged);
	public static Item amthrimisHammer = new ItemNotReady("amthirmis_hammer", DRPGCreativeTabs.ranged);
	public static Item darvenHammer = new ItemNotReady("darven_hammer", DRPGCreativeTabs.ranged);
	public static Item cermileHammer = new ItemNotReady("cermile_hammer", DRPGCreativeTabs.ranged);
	public static Item pardimalHammer = new ItemNotReady("pardimal_hammer", DRPGCreativeTabs.ranged);
	public static Item quadroticHammer = new ItemNotReady("quadrotic_warhammer", DRPGCreativeTabs.ranged);
	public static Item karosHammer = new ItemNotReady("karos_warhammer", DRPGCreativeTabs.ranged);
	public static Item heliosisHammer = new ItemNotReady("heliosis_wrathhammer", DRPGCreativeTabs.ranged);
	public static Item arksianeHammer = new ItemNotReady("arksiane_wrathhammer", DRPGCreativeTabs.ranged);

	// public static Item teakerSword = new ItemVetheanSword("teaker_backsword",
	// Util.addHammerMaterial(4));
	// public static Item amthrimisSword = new
	// ItemVetheanSword("amthirmis_backsword", Util.addHammerMaterial(6));
	// public static Item darvenSword = new ItemVetheanSword("darven_backsword",
	// Util.addHammerMaterial(9));
	// public static Item cermileSword = new ItemVetheanSword("cermile_backsword",
	// Util.addHammerMaterial(13));
	// public static Item pardimalSword = new ItemVetheanSword("pardimal_backsword",
	// Util.addHammerMaterial(16));
	// public static Item quadroticSword = new
	// ItemVetheanSword("quadrotic_warsword", Util.addHammerMaterial(20));
	// public static Item karosSword = new ItemVetheanSword("karos_warsword",
	// Util.addHammerMaterial(22));
	// public static Item heliosisSword = new
	// ItemVetheanSword("heliosis_wrathsword", Util.addHammerMaterial(29));
	// public static Item arksianeSword = new
	// ItemVetheanSword("arksiane_wrathsword", Util.addHammerMaterial(37));
	public static Item teakerSword = new ItemNotReady("teaker_backsword", DRPGCreativeTabs.ranged);
	public static Item amthrimisSword = new ItemNotReady("amthirmis_backsword", DRPGCreativeTabs.ranged);
	public static Item darvenSword = new ItemNotReady("darven_backsword", DRPGCreativeTabs.ranged);
	public static Item cermileSword = new ItemNotReady("cermile_backsword", DRPGCreativeTabs.ranged);
	public static Item pardimalSword = new ItemNotReady("pardimal_backsword", DRPGCreativeTabs.ranged);
	public static Item quadroticSword = new ItemNotReady("quadrotic_warsword", DRPGCreativeTabs.ranged);
	public static Item karosSword = new ItemNotReady("karos_warsword", DRPGCreativeTabs.ranged);
	public static Item heliosisSword = new ItemNotReady("heliosis_wrathsword", DRPGCreativeTabs.ranged);
	public static Item arksianeSword = new ItemNotReady("arksiane_wrathsword", DRPGCreativeTabs.ranged);

	// public static Item teakerClaw = new ItemVetheanClaw(3, "teaker_claw");
	// public static Item amthrimisClaw = new ItemVetheanClaw(5, "amthirmis_claw");
	// public static Item darvenClaw = new ItemVetheanClaw(7, "darven_claw");
	// public static Item cermileClaw = new ItemVetheanClaw(8, "cermile_claw");
	// public static Item pardimalClaw = new ItemVetheanClaw(12, "pardimal_claw");
	// public static Item quadroticClaw = new ItemVetheanClaw(14,
	// "quadrotic_warclaw");
	// public static Item karosClaw = new ItemVetheanClaw(19, "karos_warclaw");
	// public static Item heliosisClaw = new ItemVetheanClaw(26,
	// "heliosis_wrathclaw");
	// public static Item arksianeClaw = new ItemVetheanClaw(35,
	// "arksiane_wrathclaw");
	public static Item teakerClaw = new ItemNotReady("teaker_claw", DRPGCreativeTabs.ranged);
	public static Item amthrimisClaw = new ItemNotReady("amthirmis_claw", DRPGCreativeTabs.ranged);
	public static Item darvenClaw = new ItemNotReady("darven_claw", DRPGCreativeTabs.ranged);
	public static Item cermileClaw = new ItemNotReady("cermile_claw", DRPGCreativeTabs.ranged);
	public static Item pardimalClaw = new ItemNotReady("pardimal_claw", DRPGCreativeTabs.ranged);
	public static Item quadroticClaw = new ItemNotReady("quadrotic_warclaw", DRPGCreativeTabs.ranged);
	public static Item karosClaw = new ItemNotReady("karos_warclaw", DRPGCreativeTabs.ranged);
	public static Item heliosisClaw = new ItemNotReady("heliosis_wrathclaw", DRPGCreativeTabs.ranged);
	public static Item arksianeClaw = new ItemNotReady("arksiane_wrathclaw", DRPGCreativeTabs.ranged);

	// public static Item eversight = new ItemVetheanEversight("eversight");
	// public static Item everlight = new ItemVetheanSword("everlight",
	// Util.addHammerMaterial(44));
	// public static Item everbright = new ItemVetheanClaw(42, "everbright");
	public static Item eversight = new ItemNotReady("eversight", DRPGCreativeTabs.ranged);
	public static Item everlight = new ItemNotReady("everlight", DRPGCreativeTabs.ranged);
	public static Item everbright = new ItemNotReady("everbright", DRPGCreativeTabs.ranged);
	public static Item everArrow = new ItemBase("ever_arrow").setCreativeTab(DRPGCreativeTabs.ranged);
	// public static Item everfright = new ItemModBow("everfright", -1, 25, 46,
	// everArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item evernight = new ItemStaff(115, 80, "evernight");
	public static Item everfrightBow = new ItemNotReady("everfright_bow", DRPGCreativeTabs.ranged);
	public static Item evernight = new ItemNotReady("evernight", DRPGCreativeTabs.ranged);

	// public static Item karosRockmaul = new ItemVetheanSword("karos_rockmaul",
	// Util.addHammerMaterial(46));
	public static Item karosRockmaul = new ItemNotReady("karos_rockmaul", DRPGCreativeTabs.ranged);

	public static Item teakerArrow = new ItemBase("teaker_arrow").setCreativeTab(DRPGCreativeTabs.ranged);;
	public static Item darvenArrow = new ItemBase("darven_arrow").setCreativeTab(DRPGCreativeTabs.ranged);;
	public static Item pardimalArrow = new ItemBase("pardimal_arrow").setCreativeTab(DRPGCreativeTabs.ranged);;
	public static Item karosArrow = new ItemBase("karos_arrow").setCreativeTab(DRPGCreativeTabs.ranged);;

	// public static Item teakerBow = new ItemModBow("teaker_bow", -1, 2, 5,
	// teakerArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item amthrimisBow = new ItemModBow("amthirmis_bow", -1, 2, 7,
	// teakerArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item darvenBow = new ItemModBow("darven_bow", -1, 3, 11,
	// darvenArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item cermileBow = new ItemModBow("cermile_bow", -1, 4, 14,
	// darvenArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item pardimalBow = new ItemModBow("pardimal_bow", -1, 5, 18,
	// pardimalArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item quadroticBow = new ItemModBow("quadrotic_warbow", -1, 6,
	// 21, pardimalArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item karosBow = new ItemModBow("karos_warbow", -1, 7, 23,
	// karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item heliosisBow = new ItemModBow("heliosis_wrathbow", -1, 8,
	// 28, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	// public static Item arksianeBow = new ItemModBow("arksiane_wrathbow", -1, 12,
	// 36, karosArrow).setSound(Sounds.vetheaBow.getPrefixedName()).setVethean();
	public static Item teakerBow = new ItemNotReady("teaker_bow", DRPGCreativeTabs.ranged);
	public static Item amthrimisBow = new ItemNotReady("amthirmis_bow", DRPGCreativeTabs.ranged);
	public static Item darvenBow = new ItemNotReady("darven_bow", DRPGCreativeTabs.ranged);
	public static Item cermileBow = new ItemNotReady("cermile_bow", DRPGCreativeTabs.ranged);
	public static Item pardimalBow = new ItemNotReady("pardimal_bow", DRPGCreativeTabs.ranged);
	public static Item quadroticBow = new ItemNotReady("quadrotic_warbow", DRPGCreativeTabs.ranged);
	public static Item karosBow = new ItemNotReady("karos_warbow", DRPGCreativeTabs.ranged);
	public static Item heliosisBow = new ItemNotReady("heliosis_wrathbow", DRPGCreativeTabs.ranged);
	public static Item arksianeBow = new ItemNotReady("arksiane_wrathbow", DRPGCreativeTabs.ranged);

	// public static Item dreamFlint = new ItemDreamFlint();
	// public static Item moonClock = new ItemMoonClock();
	public static Item dreamFlint = new ItemNotReady("dream_flint", DRPGCreativeTabs.items);
	public static Item moonClock = new ItemNotReady("moon_clock", DRPGCreativeTabs.items);
	public static Item rockChunks = new ItemBase("rock_chunks");
	// public static Item nightmareBed = new ItemNightmareBed();
	public static Item nightmareBed = new ItemNotReady("nightmare_bed", DRPGCreativeTabs.items);

	private static Object[] basicHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION };
	private static Object[] basicMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION };
	private static Object[] basicHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION };
	private static Object[] glisteningHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 3, ArmorInfo.MELEE_DAMAGE };
	private static Object[] glisteningMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 1.4, ArmorInfo.SPEED };
	private static Object[] glisteningHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 2, ArmorInfo.JUMP_HEIGHT,
	        ArmorInfo.NO_FALL };
	private static Object[] demonizedHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 6, ArmorInfo.MELEE_DAMAGE };
	private static Object[] demonizedMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 1.8, ArmorInfo.SPEED };
	private static Object[] demonizedHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 3, ArmorInfo.JUMP_HEIGHT,
	        ArmorInfo.NO_FALL };
	private static Object[] tormentedHelmInfo = { 15, ArmorInfo.MELEE_PROTECTION, 9, ArmorInfo.MELEE_DAMAGE };
	private static Object[] tormentedMaskInfo = { 15, ArmorInfo.RANGED_PROTECTION, 2.2, ArmorInfo.SPEED };
	private static Object[] tormentedHoodInfo = { 15, ArmorInfo.ARCANA_PROTECTION, 4, ArmorInfo.JUMP_HEIGHT,
	        ArmorInfo.NO_FALL };

	public static Item degradedHelmet = new ItemArmorBase(EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicHelmInfo,
	        true, "helmet");
	public static Item degradedMask = new ItemArmorBase(EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicMaskInfo,
	        true, "mask");
	public static Item degradedHood = new ItemArmorBase(EnumArmor.DEGRADED, EntityEquipmentSlot.HEAD, basicHoodInfo,
	        true, "hood");
	public static Item degradedBody = new ItemArmorBase(EnumArmor.DEGRADED, EntityEquipmentSlot.CHEST, true);
	public static Item degradedLegs = new ItemArmorBase(EnumArmor.DEGRADED, EntityEquipmentSlot.LEGS, true);
	public static Item degradedBoots = new ItemArmorBase(EnumArmor.DEGRADED, EntityEquipmentSlot.FEET, true);

	public static Item finishedHelmet = new ItemArmorBase(EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicHelmInfo,
	        true, "helmet");
	public static Item finishedMask = new ItemArmorBase(EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicMaskInfo,
	        true, "mask");
	public static Item finishedHood = new ItemArmorBase(EnumArmor.FINISHED, EntityEquipmentSlot.HEAD, basicHoodInfo,
	        true, "hood");
	public static Item finishedBody = new ItemArmorBase(EnumArmor.FINISHED, EntityEquipmentSlot.CHEST, true);
	public static Item finishedLegs = new ItemArmorBase(EnumArmor.FINISHED, EntityEquipmentSlot.LEGS, true);
	public static Item finishedBoots = new ItemArmorBase(EnumArmor.FINISHED, EntityEquipmentSlot.FEET, true);

	public static Item glisteningHelmet = new ItemArmorBase(EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD,
	        glisteningHelmInfo, true, "helmet");
	public static Item glisteningMask = new ItemArmorBase(EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD,
	        glisteningMaskInfo, true, "mask");
	public static Item glisteningHood = new ItemArmorBase(EnumArmor.GLISTENING, EntityEquipmentSlot.HEAD,
	        glisteningHoodInfo, true, "hood");
	public static Item glisteningBody = new ItemArmorBase(EnumArmor.GLISTENING, EntityEquipmentSlot.CHEST, true);
	public static Item glisteningLegs = new ItemArmorBase(EnumArmor.GLISTENING, EntityEquipmentSlot.LEGS, true);
	public static Item glisteningBoots = new ItemArmorBase(EnumArmor.GLISTENING, EntityEquipmentSlot.FEET, true);

	public static Item demonizedHelmet = new ItemArmorBase(EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD,
	        demonizedHelmInfo, true, "helmet");
	public static Item demonizedMask = new ItemArmorBase(EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD,
	        demonizedMaskInfo, true, "mask");
	public static Item demonizedHood = new ItemArmorBase(EnumArmor.DEMONIZED, EntityEquipmentSlot.HEAD,
	        demonizedHoodInfo, true, "hood");
	public static Item demonizedBody = new ItemArmorBase(EnumArmor.DEMONIZED, EntityEquipmentSlot.CHEST, true);
	public static Item demonizedLegs = new ItemArmorBase(EnumArmor.DEMONIZED, EntityEquipmentSlot.LEGS, true);
	public static Item demonizedBoots = new ItemArmorBase(EnumArmor.DEMONIZED, EntityEquipmentSlot.FEET, true);

	public static Item tormentedHelmet = new ItemArmorBase(EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD,
	        tormentedHelmInfo, true, "helmet");
	public static Item tormentedMask = new ItemArmorBase(EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD,
	        tormentedMaskInfo, true, "mask");
	public static Item tormentedHood = new ItemArmorBase(EnumArmor.TORMENTED, EntityEquipmentSlot.HEAD,
	        tormentedHoodInfo, true, "hood");
	public static Item tormentedBody = new ItemArmorBase(EnumArmor.TORMENTED, EntityEquipmentSlot.CHEST, true);
	public static Item tormentedLegs = new ItemArmorBase(EnumArmor.TORMENTED, EntityEquipmentSlot.LEGS, true);
	public static Item tormentedBoots = new ItemArmorBase(EnumArmor.TORMENTED, EntityEquipmentSlot.FEET, true);

	public static void CreateJSONs() {
		GenerateJSON.generateItemModelJSONs();
	}
}