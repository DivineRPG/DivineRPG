package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.*;
import naturix.divinerpg.bases.armor.*;
import naturix.divinerpg.bases.clock.MysteriousClock;
import naturix.divinerpg.utils.DivineRPGMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	private static EntitySlime EntitySlime;
	private static final CreativeTabs tab = DivineRPG.ItemsTab;
	
	public static ThrowableBase amthirmisDisk = new ThrowableBase("amthirmisDisk");
	public static BowBase hunterBow = new BowBase("bow_hunter");
	public static BowBase shadowBow = new BowBase("bow_shadow");
	public static BowBase enderBow = new BowBase("bow_ender");
	public static BowBase bluefireBow = new BowBase("bow_bluefire");
	public static BowBase infernoBow = new BowBase("bow_inferno");
	public static ItemBase arcanium = new ItemBase("arcanium");
	public static ItemBase ingotArlemite = new ItemBase("ingot_arlemite");
	public static ItemBase ingotAquatic = new ItemBase("ingot_aquatic");
	public static ItemBase ingotHellstone = new ItemBase("ingot_hellstone");
	public static ItemBase ingotNetherite = new ItemBase("ingot_netherite");
	public static ItemBase ingotRealmite = new ItemBase("ingot_realmite");
	public static ItemBase ingotRupee = new ItemBase("ingot_rupee");
	public static ItemBase gemApalachia = new ItemBase("gem_apalachia");
	public static ItemBase gemEden = new ItemBase("gem_eden");
	public static ItemBase gemSkythern = new ItemBase("gem_skythern");
	public static ItemBase gemWildwood = new ItemBase("gem_wildwood");
	public static MysteriousClock mysteriousClock = new MysteriousClock("clock_mysterious");
	public static MysteriousClock moonClock = new MysteriousClock("clock_moon");
	public static MysteriousClock twilightClock = new MysteriousClock("clock_twilight");
	public static ItemBase acid = new ItemBase("acid");
	public static FoodBase advancedMushroomStew = new FoodBase("advanced_mushroom_stew", 7, false);
	public static ItemBase aquamarine = new ItemBase("aquamarine");
	public static ItemBase aquaticBlazeRod = new ItemBase("rod_aquatic_blaze");
	public static ItemBase aquaton = new ItemBase("aquaton", DivineRPG.CombatTab);
	public static SpawnerBase arcanaSpawnEgg = new SpawnerBase("spawn_egg_arcana", EntitySlime);
	public static FoodBase chickenDinner = new FoodBase("winner_winner", 18, false);
	public static AxeBase corruptedAxe = new AxeBase(DivineRPGMaterials.stormSwordMaterial, "axe_corrupted", 18F, 1F);
	public static Angelic angelicHelmet = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.HEAD, "angelic_helmet");
	public static Angelic angelicChestplate = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.CHEST, "angelic_chestplate");
	public static Angelic angelicLeggings = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.LEGS, "angelic_leggings");
	public static Angelic angelicBoots = new Angelic(DivineRPGMaterials.angelicArmorMaterial, EntityEquipmentSlot.FEET, "angelic_boots");
	public static Apalachia apalachiaHelmet = new Apalachia(DivineRPGMaterials.apalachiaArmorMaterial, EntityEquipmentSlot.HEAD, "apalachia_helmet");
	public static Apalachia apalachiaChestplate = new Apalachia(DivineRPGMaterials.apalachiaArmorMaterial, EntityEquipmentSlot.CHEST, "apalachia_chestplate");
	public static Apalachia apalachiaLeggings = new Apalachia(DivineRPGMaterials.apalachiaArmorMaterial, EntityEquipmentSlot.LEGS, "apalachia_leggings");
	public static Apalachia apalachiaBoots = new Apalachia(DivineRPGMaterials.apalachiaArmorMaterial, EntityEquipmentSlot.FEET, "apalachia_boots");
	public static Aquastrive aquastriveHelmet = new Aquastrive(DivineRPGMaterials.aquastriveArmorMaterial, EntityEquipmentSlot.HEAD, "aquastrive_helmet");
	public static Aquastrive aquastriveChestplate = new Aquastrive(DivineRPGMaterials.aquastriveArmorMaterial, EntityEquipmentSlot.CHEST, "aquastrive_chestplate");
	public static Aquastrive aquastriveLeggings = new Aquastrive(DivineRPGMaterials.aquastriveArmorMaterial, EntityEquipmentSlot.LEGS, "aquastrive_leggings");
	public static Aquastrive aquastriveBoots = new Aquastrive(DivineRPGMaterials.aquastriveArmorMaterial, EntityEquipmentSlot.FEET, "aquastrive_boots");
	public static Aquatic aquaticHelmet = new Aquatic(DivineRPGMaterials.aquaticArmorMaterial, EntityEquipmentSlot.HEAD, "aquatic_helmet");
	public static Aquatic aquaticChestplate = new Aquatic(DivineRPGMaterials.aquaticArmorMaterial, EntityEquipmentSlot.CHEST, "aquatic_chestplate");
	public static Aquatic aquaticLeggings = new Aquatic(DivineRPGMaterials.aquaticArmorMaterial, EntityEquipmentSlot.LEGS, "aquatic_leggings");
	public static Aquatic aquaticBoots = new Aquatic(DivineRPGMaterials.aquaticArmorMaterial, EntityEquipmentSlot.FEET, "aquatic_boots");
	public static Bedrock bedrockHelmet = new Bedrock(DivineRPGMaterials.bedrockArmorMaterial, EntityEquipmentSlot.HEAD, "bedrock_helmet");
	public static Bedrock bedrockChestplate = new Bedrock(DivineRPGMaterials.bedrockArmorMaterial, EntityEquipmentSlot.CHEST, "bedrock_chestplate");
	public static Bedrock bedrockLeggings = new Bedrock(DivineRPGMaterials.bedrockArmorMaterial, EntityEquipmentSlot.LEGS, "bedrock_leggings");
	public static Bedrock bedrockBoots = new Bedrock(DivineRPGMaterials.bedrockArmorMaterial, EntityEquipmentSlot.FEET, "bedrock_boots");
	public static Corrupted corruptedHelmet = new Corrupted(DivineRPGMaterials.corruptedArmorMaterial, EntityEquipmentSlot.HEAD, "corrupted_helmet");
	public static Corrupted corruptedChestplate = new Corrupted(DivineRPGMaterials.corruptedArmorMaterial, EntityEquipmentSlot.CHEST, "corrupted_chestplate");
	public static Corrupted corruptedLeggings = new Corrupted(DivineRPGMaterials.corruptedArmorMaterial, EntityEquipmentSlot.LEGS, "corrupted_leggings");
	public static Corrupted corruptedBoots = new Corrupted(DivineRPGMaterials.corruptedArmorMaterial, EntityEquipmentSlot.FEET, "corrupted_boots");
	public static Degraded degradedHelmet = new Degraded(DivineRPGMaterials.degradedArmorMaterial, EntityEquipmentSlot.HEAD, "degraded_helmet");
	public static Degraded degradedChestplate = new Degraded(DivineRPGMaterials.degradedArmorMaterial, EntityEquipmentSlot.CHEST, "degraded_chestplate");
	public static Degraded degradedLeggings = new Degraded(DivineRPGMaterials.degradedArmorMaterial, EntityEquipmentSlot.LEGS, "degraded_leggings");
	public static Degraded degradedBoots = new Degraded(DivineRPGMaterials.degradedArmorMaterial, EntityEquipmentSlot.FEET, "degraded_boots");
	public static Demonized demonizedHelmet = new Demonized(DivineRPGMaterials.demonizedArmorMaterial, EntityEquipmentSlot.HEAD, "demonized_helmet");
	public static Demonized demonizedChestplate = new Demonized(DivineRPGMaterials.demonizedArmorMaterial, EntityEquipmentSlot.CHEST, "demonized_chestplate");
	public static Demonized demonizedLeggings = new Demonized(DivineRPGMaterials.demonizedArmorMaterial, EntityEquipmentSlot.LEGS, "demonized_leggings");
	public static Demonized demonizedBoots = new Demonized(DivineRPGMaterials.demonizedArmorMaterial, EntityEquipmentSlot.FEET, "demonized_boots");
	public static Divine divineHelmet = new Divine(DivineRPGMaterials.divineArmorMaterial, EntityEquipmentSlot.HEAD, "divine_helmet");
	public static Divine divineChestplate = new Divine(DivineRPGMaterials.divineArmorMaterial, EntityEquipmentSlot.CHEST, "divine_chestplate");
	public static Divine divineLeggings = new Divine(DivineRPGMaterials.divineArmorMaterial, EntityEquipmentSlot.LEGS, "divine_leggings");
	public static Divine divineBoots = new Divine(DivineRPGMaterials.divineArmorMaterial, EntityEquipmentSlot.FEET, "divine_boots");
	public static Donator donatorHelmet = new Donator(DivineRPGMaterials.donatorArmorMaterial, EntityEquipmentSlot.HEAD, "donator_helmet");
	public static Donator donatorChestplate = new Donator(DivineRPGMaterials.donatorArmorMaterial, EntityEquipmentSlot.CHEST, "donator_chestplate");
	public static Donator donatorLeggings = new Donator(DivineRPGMaterials.donatorArmorMaterial, EntityEquipmentSlot.LEGS, "donator_leggings");
	public static Donator donatorBoots = new Donator(DivineRPGMaterials.donatorArmorMaterial, EntityEquipmentSlot.FEET, "donator_boots");
	public static Eden edenHelmet = new Eden(DivineRPGMaterials.edenArmorMaterial, EntityEquipmentSlot.HEAD, "eden_helmet");
	public static Eden edenChestplate = new Eden(DivineRPGMaterials.edenArmorMaterial, EntityEquipmentSlot.CHEST, "eden_chestplate");
	public static Eden edenLeggings = new Eden(DivineRPGMaterials.edenArmorMaterial, EntityEquipmentSlot.LEGS, "eden_leggings");
	public static Eden edenBoots = new Eden(DivineRPGMaterials.edenArmorMaterial, EntityEquipmentSlot.FEET, "eden_boots");
	public static Ender enderHelmet = new Ender(DivineRPGMaterials.enderArmorMaterial, EntityEquipmentSlot.HEAD, "ender_helmet");
	public static Ender enderChestplate = new Ender(DivineRPGMaterials.enderArmorMaterial, EntityEquipmentSlot.CHEST, "ender_chestplate");
	public static Ender enderLeggings = new Ender(DivineRPGMaterials.enderArmorMaterial, EntityEquipmentSlot.LEGS, "ender_leggings");
	public static Ender enderBoots = new Ender(DivineRPGMaterials.enderArmorMaterial, EntityEquipmentSlot.FEET, "ender_boots");
	public static Finished finishedHelmet = new Finished(DivineRPGMaterials.finishedArmorMaterial, EntityEquipmentSlot.HEAD, "finished_helmet");
	public static Finished finishedChestplate = new Finished(DivineRPGMaterials.finishedArmorMaterial, EntityEquipmentSlot.CHEST, "finished_chestplate");
	public static Finished finishedLeggings = new Finished(DivineRPGMaterials.finishedArmorMaterial, EntityEquipmentSlot.LEGS, "finished_leggings");
	public static Finished finishedBoots = new Finished(DivineRPGMaterials.finishedArmorMaterial, EntityEquipmentSlot.FEET, "finished_boots");
	public static Frozen frozenHelmet = new Frozen(DivineRPGMaterials.frozenArmorMaterial, EntityEquipmentSlot.HEAD, "frozen_helmet");
	public static Frozen frozenChestplate = new Frozen(DivineRPGMaterials.frozenArmorMaterial, EntityEquipmentSlot.CHEST, "frozen_chestplate");
	public static Frozen frozenLeggings = new Frozen(DivineRPGMaterials.frozenArmorMaterial, EntityEquipmentSlot.LEGS, "frozen_leggings");
	public static Frozen frozenBoots = new Frozen(DivineRPGMaterials.frozenArmorMaterial, EntityEquipmentSlot.FEET, "frozen_boots");
	public static Glistening glisteningHelmet = new Glistening(DivineRPGMaterials.glisteningArmorMaterial, EntityEquipmentSlot.HEAD, "glistening_helmet");
	public static Glistening glisteningChestplate = new Glistening(DivineRPGMaterials.glisteningArmorMaterial, EntityEquipmentSlot.CHEST, "glistening_chestplate");
	public static Glistening glisteningLeggings = new Glistening(DivineRPGMaterials.glisteningArmorMaterial, EntityEquipmentSlot.LEGS, "glistening_leggings");
	public static Glistening glisteningBoots = new Glistening(DivineRPGMaterials.glisteningArmorMaterial, EntityEquipmentSlot.FEET, "glistening_boots");
	public static Halite haliteHelmet = new Halite(DivineRPGMaterials.haliteArmorMaterial, EntityEquipmentSlot.HEAD, "halite_helmet");
	public static Halite haliteChestplate = new Halite(DivineRPGMaterials.haliteArmorMaterial, EntityEquipmentSlot.CHEST, "halite_chestplate");
	public static Halite haliteLeggings = new Halite(DivineRPGMaterials.haliteArmorMaterial, EntityEquipmentSlot.LEGS, "halite_leggings");
	public static Halite haliteBoots = new Halite(DivineRPGMaterials.haliteArmorMaterial, EntityEquipmentSlot.FEET, "halite_boots");
	public static Inferno infernoHelmet = new Inferno(DivineRPGMaterials.infernoArmorMaterial, EntityEquipmentSlot.HEAD, "inferno_helmet");
	public static Inferno infernoChestplate = new Inferno(DivineRPGMaterials.infernoArmorMaterial, EntityEquipmentSlot.CHEST, "inferno_chestplate");
	public static Inferno infernoLeggings = new Inferno(DivineRPGMaterials.infernoArmorMaterial, EntityEquipmentSlot.LEGS, "inferno_leggings");
	public static Inferno infernoBoots = new Inferno(DivineRPGMaterials.infernoArmorMaterial, EntityEquipmentSlot.FEET, "inferno_boots");
	public static JackOMan jackomanHelmet = new JackOMan(DivineRPGMaterials.jackomanArmorMaterial, EntityEquipmentSlot.HEAD, "jackoman_helmet");
	public static JackOMan jackomanChestplate = new JackOMan(DivineRPGMaterials.jackomanArmorMaterial, EntityEquipmentSlot.CHEST, "jackoman_chestplate");
	public static JackOMan jackomanLeggings = new JackOMan(DivineRPGMaterials.jackomanArmorMaterial, EntityEquipmentSlot.LEGS, "jackoman_leggings");
	public static JackOMan jackomanBoots = new JackOMan(DivineRPGMaterials.jackomanArmorMaterial, EntityEquipmentSlot.FEET, "jackoman_boots");
	public static Jungle jungleHelmet = new Jungle(DivineRPGMaterials.jungleArmorMaterial, EntityEquipmentSlot.HEAD, "jungle_helmet");
	public static Jungle jungleChestplate = new Jungle(DivineRPGMaterials.jungleArmorMaterial, EntityEquipmentSlot.CHEST, "jungle_chestplate");
	public static Jungle jungleLeggings = new Jungle(DivineRPGMaterials.jungleArmorMaterial, EntityEquipmentSlot.LEGS, "jungle_leggings");
	public static Jungle jungleBoots = new Jungle(DivineRPGMaterials.jungleArmorMaterial, EntityEquipmentSlot.FEET, "jungle_boots");
	public static Korma kormaHelmet = new Korma(DivineRPGMaterials.kormaArmorMaterial, EntityEquipmentSlot.HEAD, "korma_helmet");
	public static Korma kormaChestplate = new Korma(DivineRPGMaterials.kormaArmorMaterial, EntityEquipmentSlot.CHEST, "korma_chestplate");
	public static Korma kormaLeggings = new Korma(DivineRPGMaterials.kormaArmorMaterial, EntityEquipmentSlot.LEGS, "korma_leggings");
	public static Korma kormaBoots = new Korma(DivineRPGMaterials.kormaArmorMaterial, EntityEquipmentSlot.FEET, "korma_boots");
	public static Kraken krakenHelmet = new Kraken(DivineRPGMaterials.krakenArmorMaterial, EntityEquipmentSlot.HEAD, "kraken_helmet");
	public static Kraken krakenChestplate = new Kraken(DivineRPGMaterials.krakenArmorMaterial, EntityEquipmentSlot.CHEST, "kraken_chestplate");
	public static Kraken krakenLeggings = new Kraken(DivineRPGMaterials.krakenArmorMaterial, EntityEquipmentSlot.LEGS, "kraken_leggings");
	public static Kraken krakenBoots = new Kraken(DivineRPGMaterials.krakenArmorMaterial, EntityEquipmentSlot.FEET, "kraken_boots");
	public static Mortum mortumHelmet = new Mortum(DivineRPGMaterials.mortumArmorMaterial, EntityEquipmentSlot.HEAD, "mortum_helmet");
	public static Mortum mortumChestplate = new Mortum(DivineRPGMaterials.mortumArmorMaterial, EntityEquipmentSlot.CHEST, "mortum_chestplate");
	public static Mortum mortumLeggings = new Mortum(DivineRPGMaterials.mortumArmorMaterial, EntityEquipmentSlot.LEGS, "mortum_leggings");
	public static Mortum mortumBoots = new Mortum(DivineRPGMaterials.mortumArmorMaterial, EntityEquipmentSlot.FEET, "mortum_boots");
	public static Netherite netheriteHelmet = new Netherite(DivineRPGMaterials.netheriteArmorMaterial, EntityEquipmentSlot.HEAD, "netherite_helmet");
	public static Netherite netheriteChestplate = new Netherite(DivineRPGMaterials.netheriteArmorMaterial, EntityEquipmentSlot.CHEST, "netherite_chestplate");
	public static Netherite netheriteLeggings = new Netherite(DivineRPGMaterials.netheriteArmorMaterial, EntityEquipmentSlot.LEGS, "netherite_leggings");
	public static Netherite netheriteBoots = new Netherite(DivineRPGMaterials.netheriteArmorMaterial, EntityEquipmentSlot.FEET, "netherite_boots");
	public static Realmite realmiteHelmet = new Realmite(DivineRPGMaterials.realmiteArmorMaterial, EntityEquipmentSlot.HEAD, "realmite_helmet");
	public static Realmite realmiteChestplate = new Realmite(DivineRPGMaterials.realmiteArmorMaterial, EntityEquipmentSlot.CHEST, "realmite_chestplate");
	public static Realmite realmiteLeggings = new Realmite(DivineRPGMaterials.realmiteArmorMaterial, EntityEquipmentSlot.LEGS, "realmite_leggings");
	public static Realmite realmiteBoots = new Realmite(DivineRPGMaterials.realmiteArmorMaterial, EntityEquipmentSlot.FEET, "realmite_boots");
	public static Rupee rupeeHelmet = new Rupee(DivineRPGMaterials.rupeeArmorMaterial, EntityEquipmentSlot.HEAD, "rupee_helmet");
	public static Rupee rupeeChestplate = new Rupee(DivineRPGMaterials.rupeeArmorMaterial, EntityEquipmentSlot.CHEST, "rupee_chestplate");
	public static Rupee rupeeLeggings = new Rupee(DivineRPGMaterials.rupeeArmorMaterial, EntityEquipmentSlot.LEGS, "rupee_leggings");
	public static Rupee rupeeBoots = new Rupee(DivineRPGMaterials.rupeeArmorMaterial, EntityEquipmentSlot.FEET, "rupee_boots");
	public static Shadow shadowHelmet = new Shadow(DivineRPGMaterials.shadowArmorMaterial, EntityEquipmentSlot.HEAD, "shadow_helmet");
	public static Shadow shadowChestplate = new Shadow(DivineRPGMaterials.shadowArmorMaterial, EntityEquipmentSlot.CHEST, "shadow_chestplate");
	public static Shadow shadowLeggings = new Shadow(DivineRPGMaterials.shadowArmorMaterial, EntityEquipmentSlot.LEGS, "shadow_leggings");
	public static Shadow shadowBoots = new Shadow(DivineRPGMaterials.shadowArmorMaterial, EntityEquipmentSlot.FEET, "shadow_boots");
	public static Skeleman skelemanHelmet = new Skeleman(DivineRPGMaterials.skelemanArmorMaterial, EntityEquipmentSlot.HEAD, "skeleman_helmet");
	public static Skeleman skelemanChestplate = new Skeleman(DivineRPGMaterials.skelemanArmorMaterial, EntityEquipmentSlot.CHEST, "skeleman_chestplate");
	public static Skeleman skelemanLeggings = new Skeleman(DivineRPGMaterials.skelemanArmorMaterial, EntityEquipmentSlot.LEGS, "skeleman_leggings");
	public static Skeleman skelemanBoots = new Skeleman(DivineRPGMaterials.skelemanArmorMaterial, EntityEquipmentSlot.FEET, "skeleman_boots");
	public static Skythern skythernHelmet = new Skythern(DivineRPGMaterials.skythernArmorMaterial, EntityEquipmentSlot.HEAD, "skythern_helmet");
	public static Skythern skythernChestplate = new Skythern(DivineRPGMaterials.skythernArmorMaterial, EntityEquipmentSlot.CHEST, "skythern_chestplate");
	public static Skythern skythernLeggings = new Skythern(DivineRPGMaterials.skythernArmorMaterial, EntityEquipmentSlot.LEGS, "skythern_leggings");
	public static Skythern skythernBoots = new Skythern(DivineRPGMaterials.skythernArmorMaterial, EntityEquipmentSlot.FEET, "skythern_boots");
	public static Terran terranHelmet = new Terran(DivineRPGMaterials.terranArmorMaterial, EntityEquipmentSlot.HEAD, "terran_helmet");
	public static Terran terranChestplate = new Terran(DivineRPGMaterials.terranArmorMaterial, EntityEquipmentSlot.CHEST, "terran_chestplate");
	public static Terran terranLeggings = new Terran(DivineRPGMaterials.terranArmorMaterial, EntityEquipmentSlot.LEGS, "terran_leggings");
	public static Terran terranBoots = new Terran(DivineRPGMaterials.terranArmorMaterial, EntityEquipmentSlot.FEET, "terran_boots");
	public static Tormented tormentedHelmet = new Tormented(DivineRPGMaterials.tormentedArmorMaterial, EntityEquipmentSlot.HEAD, "tormented_helmet");
	public static Tormented tormentedChestplate = new Tormented(DivineRPGMaterials.tormentedArmorMaterial, EntityEquipmentSlot.CHEST, "tormented_chestplate");
	public static Tormented tormentedLeggings = new Tormented(DivineRPGMaterials.tormentedArmorMaterial, EntityEquipmentSlot.LEGS, "tormented_leggings");
	public static Tormented tormentedBoots = new Tormented(DivineRPGMaterials.tormentedArmorMaterial, EntityEquipmentSlot.FEET, "tormented_boots");
	public static Vemos vemosHelmet = new Vemos(DivineRPGMaterials.vemosArmorMaterial, EntityEquipmentSlot.HEAD, "vemos_helmet");
	public static Vemos vemosChestplate = new Vemos(DivineRPGMaterials.vemosArmorMaterial, EntityEquipmentSlot.CHEST, "vemos_chestplate");
	public static Vemos vemosLeggings = new Vemos(DivineRPGMaterials.vemosArmorMaterial, EntityEquipmentSlot.LEGS, "vemos_leggings");
	public static Vemos vemosBoots = new Vemos(DivineRPGMaterials.vemosArmorMaterial, EntityEquipmentSlot.FEET, "vemos_boots");
	public static Wildwood wildwoodHelmet = new Wildwood(DivineRPGMaterials.wildwoodArmorMaterial, EntityEquipmentSlot.HEAD, "wildwood_helmet");
	public static Wildwood wildwoodChestplate = new Wildwood(DivineRPGMaterials.wildwoodArmorMaterial, EntityEquipmentSlot.CHEST, "wildwood_chestplate");
	public static Wildwood wildwoodLeggings = new Wildwood(DivineRPGMaterials.wildwoodArmorMaterial, EntityEquipmentSlot.LEGS, "wildwood_leggings");
	public static Wildwood wildwoodBoots = new Wildwood(DivineRPGMaterials.wildwoodArmorMaterial, EntityEquipmentSlot.FEET, "wildwood_boots");
	public static WitherReaper witherreaperHelmet = new WitherReaper(DivineRPGMaterials.witherreaperArmorMaterial, EntityEquipmentSlot.HEAD, "wither_reaper_helmet");
	public static WitherReaper witherreaperChestplate = new WitherReaper(DivineRPGMaterials.witherreaperArmorMaterial, EntityEquipmentSlot.CHEST, "wither_reaper_chestplate");
	public static WitherReaper witherreaperLeggings = new WitherReaper(DivineRPGMaterials.witherreaperArmorMaterial, EntityEquipmentSlot.LEGS, "wither_reaper_leggings");
	public static WitherReaper witherreaperBoots = new WitherReaper(DivineRPGMaterials.witherreaperArmorMaterial, EntityEquipmentSlot.FEET, "wither_reaper_boots");
	public static SwordBase amthrimisBackSword = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial, "sword_amthirmis_back");
	public static SwordBase aquatoothSword = new SwordBase(DivineRPGMaterials.aquatoothSwordMaterial, "sword_aquatooth");
	public static SwordBase arksianeWrathSword = new SwordBase(DivineRPGMaterials.arksianeSwordMaterial, "sword_arksiane_wrath");
	public static SwordBase bedrockSword = new SwordBase(DivineRPGMaterials.bedrockSwordMaterial, "sword_bedrock");
	public static SwordBase blackEnderSword = new SwordBase(DivineRPGMaterials.blackEnderSwordMaterial, "sword_black_ender");
	public static SwordBase bloodgemSword = new SwordBase(DivineRPGMaterials.bloodgemSwordMaterial, "sword_bloodgem");
	public static SwordBase blueDivineSword = new SwordBase(DivineRPGMaterials.blueDivineSwordMaterial, "sword_blue_divine");
	public static SwordBase arlemiteSword = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "sword_arlemite");
	public static SwordBase stormSword = new SwordBase(DivineRPGMaterials.stormSwordMaterial, "sword_storm"); 
	public static ItemBase bandHeivaHunt = new ItemBase("band_heiva_hunt");
	public static ShickaxeBase rupeeShickaxe = new ShickaxeBase(DivineRPGMaterials.rupeeSwordMaterial, "shickaxe_rupee", 950);
	public static ShickaxeBase arlemiteShickaxe = new ShickaxeBase(DivineRPGMaterials.arlemiteSwordMaterial, "shickaxe_arlemite", 1000);
	public static ShickaxeBase divineShickaxe = new ShickaxeBase(DivineRPGMaterials.blueDivineSwordMaterial, "shickaxe_divine", 1250);
	
	
	public static void register(IForgeRegistry<Item> registry) {
		System.out.print("DivineRPG items loading");
		registry.registerAll(
				arlemiteSword,
				amthirmisDisk,
				hunterBow,
				shadowBow,
				enderBow,
				bluefireBow,
				infernoBow,
				arcanium,
				ingotArlemite,
				ingotAquatic,
				ingotHellstone,
				ingotNetherite,
				ingotRealmite,
				ingotRupee,
				gemApalachia,
				gemEden,
				gemSkythern,
				gemWildwood,
				mysteriousClock,
				moonClock,
				twilightClock,
				acid,
				advancedMushroomStew,
				aquamarine,
				aquaticBlazeRod,
				aquaton,
				arcanaSpawnEgg,
				amthrimisBackSword,
				aquatoothSword,
				arksianeWrathSword,
				bedrockSword,
				blackEnderSword,
				bloodgemSword,
				blueDivineSword,
				stormSword,
				chickenDinner,
				corruptedAxe,
				angelicHelmet,
				angelicChestplate,
				angelicLeggings,
				angelicBoots,
				apalachiaHelmet,
				apalachiaChestplate,
				apalachiaLeggings,
				apalachiaBoots,
				aquastriveHelmet,
				aquastriveChestplate,
				aquastriveLeggings,
				aquastriveBoots,
				aquaticHelmet,
				aquaticChestplate,
				aquaticLeggings,
				aquaticBoots,
				bedrockHelmet,
				bedrockChestplate,
				bedrockLeggings,
				bedrockBoots,
				corruptedHelmet,
				corruptedChestplate,
				corruptedLeggings,
				corruptedBoots,
				degradedHelmet,
				degradedChestplate,
				degradedLeggings,
				degradedBoots,
				demonizedHelmet,
				demonizedChestplate,
				demonizedLeggings,
				demonizedBoots,
				divineHelmet,
				divineChestplate,
				divineLeggings,
				divineBoots,
				donatorHelmet,
				donatorChestplate,
				donatorLeggings,
				donatorBoots,
				edenHelmet,
				edenChestplate,
				edenLeggings,
				edenBoots,
				enderHelmet,
				enderChestplate,
				enderLeggings,
				enderBoots,
				finishedHelmet,
				finishedChestplate,
				finishedLeggings,
				finishedBoots,
				frozenHelmet,
				frozenChestplate,
				frozenLeggings,
				frozenBoots,
				glisteningHelmet,
				glisteningChestplate,
				glisteningLeggings,
				glisteningBoots,
				haliteHelmet,
				haliteChestplate,
				haliteLeggings,
				haliteBoots,
				infernoHelmet,
				infernoChestplate,
				infernoLeggings,
				infernoBoots,
				jackomanHelmet,
				jackomanChestplate,
				jackomanLeggings,
				jackomanBoots,
				jungleHelmet,
				jungleChestplate,
				jungleLeggings,
				jungleBoots,
				kormaHelmet,
				kormaChestplate,
				kormaLeggings,
				kormaBoots,
				krakenHelmet,
				krakenChestplate,
				krakenLeggings,
				krakenBoots,
				mortumHelmet,
				mortumChestplate,
				mortumLeggings,
				mortumBoots,
				netheriteHelmet,
				netheriteChestplate,
				netheriteLeggings,
				netheriteBoots,
				realmiteHelmet,
				realmiteChestplate,
				realmiteLeggings,
				realmiteBoots,
				rupeeHelmet,
				rupeeChestplate,
				rupeeLeggings,
				rupeeBoots,
				shadowHelmet,
				shadowChestplate,
				shadowLeggings,
				shadowBoots,
				skelemanHelmet,
				skelemanChestplate,
				skelemanLeggings,
				skelemanBoots,
				skythernHelmet,
				skythernChestplate,
				skythernLeggings,
				skythernBoots,
				terranHelmet,
				terranChestplate,
				terranLeggings,
				terranBoots,
				tormentedHelmet,
				tormentedChestplate,
				tormentedLeggings,
				tormentedBoots,
				vemosHelmet,
				vemosChestplate,
				vemosLeggings,
				vemosBoots,
				wildwoodHelmet,
				wildwoodChestplate,
				wildwoodLeggings,
				wildwoodBoots,
				witherreaperHelmet,
				witherreaperChestplate,
				witherreaperLeggings,
				witherreaperBoots,
				bandHeivaHunt,
				rupeeShickaxe,
				arlemiteShickaxe,
				divineShickaxe
				);
	}
	
	public static void registerModels() {
		arlemiteSword.registerItemModel(arlemiteSword);
		amthirmisDisk.registerItemModel(amthirmisDisk);
		hunterBow.registerItemModel(); 
		shadowBow.registerItemModel();
		enderBow.registerItemModel();
		bluefireBow.registerItemModel();
		infernoBow.registerItemModel();
		arcanium.registerItemModel();
		ingotArlemite.registerItemModel();
		ingotAquatic.registerItemModel();
		ingotHellstone.registerItemModel();
		ingotNetherite.registerItemModel();
		ingotRupee.registerItemModel();
		ingotRealmite.registerItemModel();
		gemApalachia.registerItemModel();
		gemEden.registerItemModel();
		gemSkythern.registerItemModel();
		gemWildwood.registerItemModel();
		mysteriousClock.registerItemModel();
		moonClock.registerItemModel();
		twilightClock.registerItemModel();
		acid.registerItemModel();
		advancedMushroomStew.registerItemModel();
		aquamarine.registerItemModel();
		aquamarine.registerItemModel();
		aquaticBlazeRod.registerItemModel();
		aquaton.registerItemModel();
		arcanaSpawnEgg.registerItemModel();
		amthrimisBackSword.registerItemModel(amthrimisBackSword);
		aquatoothSword.registerItemModel(aquatoothSword);
		arksianeWrathSword.registerItemModel(arksianeWrathSword);
		bedrockSword.registerItemModel(bedrockSword);
		blackEnderSword.registerItemModel(blackEnderSword);
		bloodgemSword.registerItemModel(bloodgemSword);
		blueDivineSword.registerItemModel(blueDivineSword);
		stormSword.registerItemModel(stormSword);
		chickenDinner.registerItemModel();
		corruptedAxe.registerItemModel(corruptedAxe);
		angelicHelmet.registerItemModel(angelicHelmet);
		angelicChestplate.registerItemModel(angelicChestplate);
		angelicLeggings.registerItemModel(angelicLeggings);
		angelicBoots.registerItemModel(angelicBoots);
		apalachiaHelmet.registerItemModel(apalachiaHelmet);
		apalachiaChestplate.registerItemModel(apalachiaChestplate);
		apalachiaLeggings.registerItemModel(apalachiaLeggings);
		apalachiaBoots.registerItemModel(apalachiaBoots);
		aquastriveHelmet.registerItemModel(aquastriveHelmet);
		aquastriveChestplate.registerItemModel(aquastriveChestplate);
		aquastriveLeggings.registerItemModel(aquastriveLeggings);
		aquastriveBoots.registerItemModel(aquastriveBoots);
		aquaticHelmet.registerItemModel(aquaticHelmet);
		aquaticChestplate.registerItemModel(aquaticChestplate);
		aquaticLeggings.registerItemModel(aquaticLeggings);
		aquaticBoots.registerItemModel(aquaticBoots);
		bedrockHelmet.registerItemModel(bedrockHelmet);
		bedrockChestplate.registerItemModel(bedrockChestplate);
		bedrockLeggings.registerItemModel(bedrockLeggings);
		bedrockBoots.registerItemModel(bedrockBoots);
		corruptedHelmet.registerItemModel(corruptedHelmet);
		corruptedChestplate.registerItemModel(corruptedChestplate);
		corruptedLeggings.registerItemModel();
		corruptedBoots.registerItemModel();
		degradedHelmet.registerItemModel();
		degradedChestplate.registerItemModel();
		degradedLeggings.registerItemModel();
		degradedBoots.registerItemModel();
		demonizedHelmet.registerItemModel();
		demonizedChestplate.registerItemModel();
		demonizedLeggings.registerItemModel();
		demonizedBoots.registerItemModel();
		divineHelmet.registerItemModel();
		divineChestplate.registerItemModel();
		divineLeggings.registerItemModel();
		divineBoots.registerItemModel();
		donatorHelmet.registerItemModel();
		donatorChestplate.registerItemModel();
		donatorLeggings.registerItemModel();
		donatorBoots.registerItemModel();
		edenHelmet.registerItemModel();
		edenChestplate.registerItemModel();
		edenLeggings.registerItemModel();
		edenBoots.registerItemModel();
		enderHelmet.registerItemModel();
		enderChestplate.registerItemModel();
		enderLeggings.registerItemModel();
		enderBoots.registerItemModel();
		finishedHelmet.registerItemModel();
		finishedChestplate.registerItemModel();
		finishedLeggings.registerItemModel();
		finishedBoots.registerItemModel();
		frozenHelmet.registerItemModel();
		frozenChestplate.registerItemModel();
		frozenLeggings.registerItemModel();
		frozenBoots.registerItemModel();
		glisteningHelmet.registerItemModel();
		glisteningChestplate.registerItemModel();
		glisteningLeggings.registerItemModel();
		glisteningBoots.registerItemModel();
		haliteHelmet.registerItemModel();
		haliteChestplate.registerItemModel();
		haliteLeggings.registerItemModel();
		haliteBoots.registerItemModel();
		infernoHelmet.registerItemModel();
		infernoChestplate.registerItemModel();
		infernoLeggings.registerItemModel();
		infernoBoots.registerItemModel();
		jackomanHelmet.registerItemModel();
		jackomanChestplate.registerItemModel();
		jackomanLeggings.registerItemModel();
		jackomanBoots.registerItemModel();
		jungleHelmet.registerItemModel();
		jungleChestplate.registerItemModel();
		jungleLeggings.registerItemModel();
		jungleBoots.registerItemModel();
		kormaHelmet.registerItemModel();
		kormaChestplate.registerItemModel();
		kormaLeggings.registerItemModel();
		kormaBoots.registerItemModel();
		krakenHelmet.registerItemModel();
		krakenChestplate.registerItemModel();
		krakenLeggings.registerItemModel();
		krakenBoots.registerItemModel();
		mortumHelmet.registerItemModel();
		mortumChestplate.registerItemModel();
		mortumLeggings.registerItemModel();
		mortumBoots.registerItemModel();
		netheriteHelmet.registerItemModel();
		netheriteChestplate.registerItemModel();
		netheriteLeggings.registerItemModel();
		netheriteBoots.registerItemModel();
		realmiteHelmet.registerItemModel();
		realmiteChestplate.registerItemModel();
		realmiteLeggings.registerItemModel();
		realmiteBoots.registerItemModel();
		rupeeHelmet.registerItemModel();
		rupeeChestplate.registerItemModel();
		rupeeLeggings.registerItemModel();
		rupeeBoots.registerItemModel();
		shadowHelmet.registerItemModel();
		shadowChestplate.registerItemModel();
		shadowLeggings.registerItemModel();
		shadowBoots.registerItemModel();
		skelemanHelmet.registerItemModel();
		skelemanChestplate.registerItemModel();
		skelemanLeggings.registerItemModel();
		skelemanBoots.registerItemModel();
		skythernHelmet.registerItemModel();
		skythernChestplate.registerItemModel();
		skythernLeggings.registerItemModel();
		skythernBoots.registerItemModel();
		terranHelmet.registerItemModel();
		terranChestplate.registerItemModel();
		terranLeggings.registerItemModel();
		terranBoots.registerItemModel();
		tormentedHelmet.registerItemModel();
		tormentedChestplate.registerItemModel();
		tormentedLeggings.registerItemModel();
		tormentedBoots.registerItemModel();
		vemosHelmet.registerItemModel();
		vemosChestplate.registerItemModel();
		vemosLeggings.registerItemModel();
		vemosBoots.registerItemModel();
		wildwoodHelmet.registerItemModel();
		wildwoodChestplate.registerItemModel();
		wildwoodLeggings.registerItemModel();
		wildwoodBoots.registerItemModel();
		witherreaperHelmet.registerItemModel();
		witherreaperChestplate.registerItemModel();
		witherreaperLeggings.registerItemModel();
		witherreaperBoots.registerItemModel(witherreaperBoots);
		bandHeivaHunt.registerItemModel();
		rupeeShickaxe.registerItemModel(rupeeShickaxe);
		arlemiteShickaxe.registerItemModel(arlemiteShickaxe);
		divineShickaxe.registerItemModel(divineShickaxe);
		System.out.print("DivineRPG items loaded");
	}
}