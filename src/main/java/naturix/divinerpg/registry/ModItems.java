package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.AxeBase;
import naturix.divinerpg.bases.items.BowBase;
import naturix.divinerpg.bases.items.CannonBase;
import naturix.divinerpg.bases.items.HoeBase;
import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.bases.items.PickaxeBase;
import naturix.divinerpg.bases.items.ShickaxeBase;
import naturix.divinerpg.bases.items.ShovelBase;
import naturix.divinerpg.bases.items.SpawnerBase;
import naturix.divinerpg.bases.items.SwordBase;
import naturix.divinerpg.bases.items.TeleportStaff;
import naturix.divinerpg.bases.items.ThrowableBase;
import naturix.divinerpg.bases.items.armor.Angelic;
import naturix.divinerpg.bases.items.armor.Apalachia;
import naturix.divinerpg.bases.items.armor.Aquastrive;
import naturix.divinerpg.bases.items.armor.Aquatic;
import naturix.divinerpg.bases.items.armor.Bedrock;
import naturix.divinerpg.bases.items.armor.Corrupted;
import naturix.divinerpg.bases.items.armor.Degraded;
import naturix.divinerpg.bases.items.armor.Demonized;
import naturix.divinerpg.bases.items.armor.Divine;
import naturix.divinerpg.bases.items.armor.Donator;
import naturix.divinerpg.bases.items.armor.Eden;
import naturix.divinerpg.bases.items.armor.Ender;
import naturix.divinerpg.bases.items.armor.Finished;
import naturix.divinerpg.bases.items.armor.Frozen;
import naturix.divinerpg.bases.items.armor.Glistening;
import naturix.divinerpg.bases.items.armor.Halite;
import naturix.divinerpg.bases.items.armor.Inferno;
import naturix.divinerpg.bases.items.armor.JackOMan;
import naturix.divinerpg.bases.items.armor.Jungle;
import naturix.divinerpg.bases.items.armor.Korma;
import naturix.divinerpg.bases.items.armor.Kraken;
import naturix.divinerpg.bases.items.armor.Mortum;
import naturix.divinerpg.bases.items.armor.Netherite;
import naturix.divinerpg.bases.items.armor.Realmite;
import naturix.divinerpg.bases.items.armor.Rupee;
import naturix.divinerpg.bases.items.armor.Shadow;
import naturix.divinerpg.bases.items.armor.Skeleman;
import naturix.divinerpg.bases.items.armor.Skythern;
import naturix.divinerpg.bases.items.armor.Terran;
import naturix.divinerpg.bases.items.armor.Tormented;
import naturix.divinerpg.bases.items.armor.Vemos;
import naturix.divinerpg.bases.items.armor.Wildwood;
import naturix.divinerpg.bases.items.armor.WitherReaper;
import naturix.divinerpg.bases.items.arrows.InfernoArrow;
import naturix.divinerpg.bases.items.book.BookBase;
import naturix.divinerpg.bases.items.clock.MysteriousClock;
import naturix.divinerpg.bases.items.food.FoodBase;
import naturix.divinerpg.bases.items.food.ReturnBucket;
import naturix.divinerpg.bases.items.food.ReturnsBowl;
import naturix.divinerpg.bases.items.serenade.SerenadeDeath;
import naturix.divinerpg.bases.items.serenade.SerenadeHeal;
import naturix.divinerpg.bases.items.serenade.SerenadeIce;
import naturix.divinerpg.bases.items.serenade.SerenadeInfusion;
import naturix.divinerpg.bases.items.serenade.SerenadeStrike;
import naturix.divinerpg.bases.items.special.Aquamarine;
import naturix.divinerpg.utils.DivineRPGMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	private static EntitySlime EntitySlime;
	private static final CreativeTabs tab = DivineRPG.ItemsTab;
	
	public static ThrowableBase amthirmisDisk = new ThrowableBase("amthirmisDisk");
	public static BowBase hunterBow = new BowBase("bow_hunter", Items.ARROW);
	public static BowBase shadowBow = new BowBase("bow_shadow", Items.ARROW);
	public static BowBase enderBow = new BowBase("bow_ender", Items.ARROW);
	public static BowBase bluefireBow = new BowBase("bow_bluefire", Items.ARROW);
	public static BowBase infernoBow = new BowBase("bow_inferno", ModItems.arrowInferno);
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
	public static ItemBase gemMortum = new ItemBase("gem_mortum");
	public static MysteriousClock mysteriousClock = new MysteriousClock("clock_mysterious");
	public static MysteriousClock moonClock = new MysteriousClock("clock_moon");
	public static MysteriousClock twilightClock = new MysteriousClock("clock_twilight");
	public static ItemBase acid = new ItemBase("acid");
	public static Aquamarine aquamarine = new Aquamarine("aquamarine");
	public static ItemBase aquaticBlazeRod = new ItemBase("rod_aquatic_blaze");
	public static ItemBase aquaton = new ItemBase("aquaton", DivineRPG.CombatTab);
	public static SpawnerBase arcanaSpawnEgg = new SpawnerBase("spawn_egg_arcana", EntitySlime);
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
	public static ItemBase bandHeivaHunt = new ItemBase("band_heiva_hunt");
	public static ShickaxeBase rupeeShickaxe = new ShickaxeBase(DivineRPGMaterials.rupeeSwordMaterial, "shickaxe_rupee", 950, 2);
	public static ShickaxeBase arlemiteShickaxe = new ShickaxeBase(DivineRPGMaterials.arlemiteSwordMaterial, "shickaxe_arlemite", 1000, 2);
	public static ShickaxeBase divineShickaxe = new ShickaxeBase(DivineRPGMaterials.divineSwordMaterial, "shickaxe_divine", 1250, 3);
	public static ItemBase templateDisc = new ItemBase("template_disc");
	public static ItemBase templateCannon = new ItemBase("template_cannon");
	public static ItemBase templateBacksword = new ItemBase("template_backsword");
	public static ItemBase templateBow = new ItemBase("template_bow");
	public static ItemBase templateStaff = new ItemBase("template_staff");
	public static ItemBase templateClaw = new ItemBase("template_claw");
	public static ItemBase templateDegraded = new ItemBase("template_degraded");
	public static ItemBase templateFinished = new ItemBase("template_finished");
	public static ItemBase templateGlistening = new ItemBase("template_glistening");
	public static ItemBase templateDemonized = new ItemBase("template_demonized");
	public static ItemBase templateTormented = new ItemBase("template_tormented");
	public static ItemBase soulEden = new ItemBase("soul_eden");
	public static ItemBase soulWild = new ItemBase("soul_wildwood");
	public static ItemBase soulApalachia = new ItemBase("soul_apalachia");
	public static ItemBase soulSkythern = new ItemBase("soul_skythern");
	public static ItemBase soulMortum = new ItemBase("soul_mortum");
	public static ItemBase fragmentApalachia = new ItemBase("fragment_apalachia");
	public static ItemBase fragmentEden = new ItemBase("fragment_eden");
	public static ItemBase fragmentSkythern = new ItemBase("fragment_skythern");
	public static ItemBase fragmentWildwood = new ItemBase("fragment_wildwood");
	public static ItemBase fragmentMortum = new ItemBase("fragment_mortum");
	public static AxeBase corruptedAxe = new AxeBase(DivineRPGMaterials.stormSwordMaterial, "axe_corrupted", 18F, 1F);
	public static ShovelBase corruptedShovel = new ShovelBase(DivineRPGMaterials.stormSwordMaterial, "shovel_corrupted", 18F, 1F);
	public static PickaxeBase corruptedPickaxe = new PickaxeBase(DivineRPGMaterials.stormSwordMaterial, "pickaxe_corrupted", 18F, 1F);
	public static ItemBase pearlsDirty = new ItemBase("pearls_dirty");
	public static ItemBase pearlsClean = new ItemBase("pearls_clean");
	public static ItemBase pearlsShiny = new ItemBase("pearls_shiny");
	public static ItemBase pearlsPolished = new ItemBase("pearls_polished");
	public static BookBase bookWizards = new BookBase("book_wizards");
	public static ItemBase lumpsTeaker = new ItemBase("lumps_teaker");
	public static ItemBase lumpsAmthirmis = new ItemBase("lumps_amthirmis");
	public static ItemBase lumpsDarven = new ItemBase("lumps_darven");
	public static ItemBase lumpsCermile = new ItemBase("lumps_cermile");
	public static ItemBase lumpsPardimal = new ItemBase("lumps_pardimal");
	public static ItemBase lumpsQuadrotic = new ItemBase("lumps_quadrotic");
	public static ItemBase lumpsKaros = new ItemBase("lumps_karos");
	public static ItemBase lumpsHeliosis = new ItemBase("lumps_heliosis");
	public static ItemBase lumpsArksiane = new ItemBase("lumps_arksiane");
	public static SerenadeStrike serenadeStrike = new SerenadeStrike("serenade_striker");
	public static SerenadeHeal serenadeHeal = new SerenadeHeal("serenade_heal");
	public static SerenadeIce serenadeIce = new SerenadeIce("serenade_ice");
	public static SerenadeDeath serenadeDeath = new SerenadeDeath("serenade_death");
	public static SerenadeInfusion serenadeInfusion = new SerenadeInfusion("serenade_infusion");
	public static CannonBase cannonTeaker = new CannonBase("cannon_teaker", ModItems.acid);
	public static CannonBase cannonAmthirmis = new CannonBase("cannon_amthirmis", ModItems.acid);
	public static CannonBase cannonDarven = new CannonBase("cannon_darven", ModItems.acid);
	public static CannonBase cannonCermile = new CannonBase("cannon_cermile", ModItems.acid);
	public static CannonBase cannonPardimal = new CannonBase("cannon_pardimal", ModItems.acid);
	public static CannonBase cannonQuadrotic = new CannonBase("cannon_quadrotic", ModItems.acid);
	public static CannonBase cannonKaros = new CannonBase("cannon_karos", ModItems.acid);
	public static CannonBase cannonHeliosis = new CannonBase("cannon_heliosis", ModItems.acid);
	public static CannonBase cannonArksiane = new CannonBase("cannon_arksiane", ModItems.acid);
	public static FoodBase chickenDinner = new FoodBase("winner_winner", 18, false);
	public static FoodBase bacon = new FoodBase("bacon", 3, true);
	public static FoodBase hotPumpkinPie = new FoodBase("pie_pumpkin_hot", 7, true);
	public static FoodBase boiledEgg = new FoodBase("egg_boiled", 1, false);
	public static FoodBase cheese = new FoodBase("cheese", 1, false);
	public static FoodBase mushroomWhite = new FoodBase("mushroom_white", 1, false);
	public static ReturnsBowl mushroomStewAdvanced = new ReturnsBowl("mushroom_stew", 10, false);
	public static FoodBase tomato = new FoodBase("tomato", 2, false);
	public static FoodBase donut = new FoodBase("donut", 18, false);
	public static FoodBase rawEmpoweredMeat = new FoodBase("meat_empowered_raw", 2, true);
	public static FoodBase empoweredMeat = new FoodBase("meat_empowered", 4, true);
	public static FoodBase magicMeat = new FoodBase("meat_magic", 1, true);
	public static FoodBase enrichedMagicMeat = new FoodBase("meat_magic_enriched", 2, true);
	public static ReturnBucket eggNog = new ReturnBucket("egg_nog", 5, false);
	public static FoodBase peppermints = new FoodBase("peppermints", 1, false);
	public static FoodBase chocolateLog = new FoodBase("chocolate_log", 1, false);
	public static FoodBase snowCone = new FoodBase("snowcone", 1, false);
	public static FoodBase fruitCake = new FoodBase("cake_fruit", 2, false);
	public static FoodBase winterberry = new FoodBase("winterberry", 1, false);
	public static FoodBase honeySuckle = new FoodBase("honeysuckle", 1, false);
	public static FoodBase honeyChunk = new FoodBase("honeychunk", 1, false);
	public static FoodBase dreamCarrot = new FoodBase("carrot_dream", 2, false);
	public static FoodBase dreamMelon = new FoodBase("melon_dream", 2, false);
	public static FoodBase dreamPie = new FoodBase("pie_dream", 4, false);
	public static FoodBase dreamCake = new FoodBase("cake_dream", 8, false);
	public static FoodBase dreamSweets = new FoodBase("sweets_dream", 1, false);
	public static FoodBase dreamSours = new FoodBase("sour_dream", 1, false);
	public static FoodBase moonbulb = new FoodBase("moonbulb", 3, false);
	public static FoodBase glowbonePurple = new FoodBase("glowbone_purple", 5, false);
	public static FoodBase glowbonePink = new FoodBase("glowbone_pink", 5, false);
	public static FoodBase skyflower = new FoodBase("skyflower", 1, false);
	public static FoodBase hitchak = new FoodBase("hitchak", 3, false);
	public static FoodBase pinfly = new FoodBase("pinfly", 1, false);
	public static SwordBase captainsparkler = new SwordBase(DivineRPGMaterials.stormSwordMaterial, "captainsparkler");
	public static SwordBase teakerBackSword = new SwordBase(DivineRPGMaterials.teakerSwordMaterial, "sword_teaker_back");
	public static SwordBase amthrimisBackSword = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial, "sword_amthirmis_back");
	public static SwordBase darvenBackSword = new SwordBase(DivineRPGMaterials.darvenSwordMaterial, "sword_darven_back");
	public static SwordBase cermileBackSword = new SwordBase(DivineRPGMaterials.cermileSwordMaterial, "sword_cermile_back");
	public static SwordBase pardimalBackSword = new SwordBase(DivineRPGMaterials.pardimalSwordMaterial, "sword_pardimal_back");
	public static SwordBase quadroticBackSword = new SwordBase(DivineRPGMaterials.quadroticSwordMaterial, "sword_quadrotic_back");
	public static SwordBase karosBackSword = new SwordBase(DivineRPGMaterials.karosSwordMaterial, "sword_karos_back");
	public static SwordBase heliosisBackSword = new SwordBase(DivineRPGMaterials.heliosisSwordMaterial, "sword_heliosis_back");
	public static SwordBase arksianeWrathSword = new SwordBase(DivineRPGMaterials.arksianeSwordMaterial, "sword_arksiane_wrath");
	public static SwordBase icineSword = new SwordBase(DivineRPGMaterials.icineSwordMaterial, "sword_icine");
	public static SwordBase glacierSword = new SwordBase(DivineRPGMaterials.glacierSwordMaterial, "sword_glacier");
	public static SwordBase frostkingSword = new SwordBase(DivineRPGMaterials.frostKingSwordMaterial, "sword_frostking");
	public static SwordBase frostSword = new SwordBase(DivineRPGMaterials.realmiteSwordMaterial, "sword_realmite");
	public static SwordBase divineSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine");
	public static SwordBase divineYSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_yellow");
	public static SwordBase divineGSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_grey");
	public static SwordBase divineRSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_red");
	public static SwordBase divineGRSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_green");
	public static SwordBase sharkSword = new SwordBase(DivineRPGMaterials.sharkSwordMaterial, "sword_shark");
	public static SwordBase slimeSword = new SwordBase(DivineRPGMaterials.slimeSwordMaterial, "sword_slime");
	public static SwordBase infernoSword = new SwordBase(DivineRPGMaterials.infernoSwordMaterial, "sword_inferno");
	public static SwordBase cyclopsianSword = new SwordBase(DivineRPGMaterials.cyclopsianSwordMaterial, "sword_cyclopsian");
	public static SwordBase moltenSword = new SwordBase(DivineRPGMaterials.moltenSwordMaterial, "sword_molten");
	public static SwordBase scorchingSword = new SwordBase(DivineRPGMaterials.scorchingSwordMaterial, "sword_scorching");
	public static SwordBase bluefireSword = new SwordBase(DivineRPGMaterials.bluefireSwordMaterial, "sword_bluefire");
	public static SwordBase enderSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender");
	public static SwordBase enderBSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_blue");
	public static SwordBase enderYSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_yellow");
	public static SwordBase enderGSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_green");
	public static SwordBase enderRSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_red");
	public static SwordBase aquatoothSword = new SwordBase(DivineRPGMaterials.aquatoothSwordMaterial, "sword_aquatooth");
	public static SwordBase bedrockSword = new SwordBase(DivineRPGMaterials.bedrockSwordMaterial, "sword_bedrock");
	public static SwordBase blackEnderSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_black_ender");
	public static SwordBase bloodgemSword = new SwordBase(DivineRPGMaterials.bloodgemSwordMaterial, "sword_bloodgem");
	public static SwordBase blueDivineSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_blue_divine");
	public static SwordBase stormSword = new SwordBase(DivineRPGMaterials.stormSwordMaterial, "sword_storm"); 
	public static SwordBase donatorSword = new SwordBase(DivineRPGMaterials.realmiteSwordMaterial, "sword_donator"); 
	public static PickaxeBase realmitePickaxe = new PickaxeBase(DivineRPGMaterials.realmiteSwordMaterial, "pickaxe_realmite", 0, 0); 
	public static PickaxeBase edenPickaxe = new PickaxeBase(DivineRPGMaterials.edenSwordMaterial, "pickaxe_eden", 0, 0); 
	public static PickaxeBase wildwoodPickaxe = new PickaxeBase(DivineRPGMaterials.wildwoodSwordMaterial, "pickaxe_wildwood", 0, 0); 
	public static PickaxeBase apalachiaPickaxe = new PickaxeBase(DivineRPGMaterials.apalachiaSwordMaterial, "pickaxe_apalachia", 0, 0); 
	public static PickaxeBase skythernPickaxe = new PickaxeBase(DivineRPGMaterials.skythernSwordMaterial, "pickaxe_skythern", 0, 0); 
	public static PickaxeBase mortumPickaxe = new PickaxeBase(DivineRPGMaterials.mortumSwordMaterial, "pickaxe_mortum", 0, 0); 
	public static PickaxeBase divinePickaxe = new PickaxeBase(DivineRPGMaterials.divineSwordMaterial, "pickaxe_divine", 0, 0); 
	public static PickaxeBase arlemitePickaxe = new PickaxeBase(DivineRPGMaterials.arlemiteSwordMaterial, "pickaxe_arlemite", 0, 0); 
	public static PickaxeBase rupeePickaxe = new PickaxeBase(DivineRPGMaterials.rupeeSwordMaterial, "pickaxe_rupee", 0, 0); 
	public static PickaxeBase bedrockPickaxe = new PickaxeBase(DivineRPGMaterials.bedrockSwordMaterial, "pickaxe_bedrock", 0, 0); 
	public static AxeBase realmiteAxe = new AxeBase(DivineRPGMaterials.realmiteSwordMaterial, "axe_realmite", 0, 0); 
	public static AxeBase edenAxe = new AxeBase(DivineRPGMaterials.edenSwordMaterial, "axe_eden", 0, 0); 
	public static AxeBase wildwoodAxe = new AxeBase(DivineRPGMaterials.wildwoodSwordMaterial, "axe_wildwood", 0, 0); 
	public static AxeBase apalachiaAxe = new AxeBase(DivineRPGMaterials.apalachiaSwordMaterial, "axe_apalachia", 0, 0); 
	public static AxeBase skythernAxe = new AxeBase(DivineRPGMaterials.skythernSwordMaterial, "axe_skythern", 0, 0); 
	public static AxeBase mortumAxe = new AxeBase(DivineRPGMaterials.mortumSwordMaterial, "axe_mortum", 0, 0); 
	public static AxeBase divineAxe = new AxeBase(DivineRPGMaterials.divineSwordMaterial, "axe_divine", 0, 0); 
	public static AxeBase arlemiteAxe = new AxeBase(DivineRPGMaterials.arlemiteSwordMaterial, "axe_arlemite", 0, 0); 
	public static AxeBase rupeeAxe = new AxeBase(DivineRPGMaterials.rupeeSwordMaterial, "axe_rupee", 0, 0); 
	public static AxeBase bedrockAxe = new AxeBase(DivineRPGMaterials.bedrockSwordMaterial, "axe_bedrock", 0, 0); 
	public static ShovelBase realmiteShovel = new ShovelBase(DivineRPGMaterials.realmiteSwordMaterial, "shovel_realmite", 0, 0); 
	public static ShovelBase edenShovel = new ShovelBase(DivineRPGMaterials.edenSwordMaterial, "shovel_eden", 0, 0); 
	public static ShovelBase wildwoodShovel = new ShovelBase(DivineRPGMaterials.wildwoodSwordMaterial, "shovel_wildwood", 0, 0); 
	public static ShovelBase apalachiaShovel = new ShovelBase(DivineRPGMaterials.apalachiaSwordMaterial, "shovel_apalachia", 0, 0); 
	public static ShovelBase skythernShovel = new ShovelBase(DivineRPGMaterials.skythernSwordMaterial, "shovel_skythern", 0, 0); 
	public static ShovelBase mortumShovel = new ShovelBase(DivineRPGMaterials.mortumSwordMaterial, "shovel_mortum", 0, 0); 
	public static ShovelBase divineShovel = new ShovelBase(DivineRPGMaterials.divineSwordMaterial, "shovel_divine", 0, 0); 
	public static ShovelBase arlemiteShovel = new ShovelBase(DivineRPGMaterials.arlemiteSwordMaterial, "shovel_arlemite", 0, 0); 
	public static ShovelBase rupeeShovel = new ShovelBase(DivineRPGMaterials.rupeeSwordMaterial, "shovel_rupee", 0, 0); 
	public static ShovelBase bedrockShovel = new ShovelBase(DivineRPGMaterials.bedrockSwordMaterial, "shovel_bedrock", 0, 0); 
	public static HoeBase arlemiteHoe = new HoeBase(DivineRPGMaterials.arlemiteSwordMaterial, "hoe_arlemite", 0, 0); 
	public static HoeBase rupeeHoe = new HoeBase(DivineRPGMaterials.rupeeSwordMaterial, "hoe_rupee", 0, 0); 
	public static HoeBase realmiteHoe = new HoeBase(DivineRPGMaterials.realmiteSwordMaterial, "hoe_realmite", 0, 0); 
	public static ItemBase crabClaw = new ItemBase("claw_crab"); 
	public static CannonBase crabClawCannon = new CannonBase("cannon_claw_crab", Item.getItemFromBlock(Blocks.CACTUS)); 
	public static SwordBase crabClawDual = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial, "claw_crab_dual"); 
	public static CannonBase crabClawAnchor = new CannonBase("anchor_claw_crab", null); 
	public static SwordBase everlight = new SwordBase(DivineRPGMaterials.everlightSwordMaterial, "everlight");
	public static SwordBase everbright = new SwordBase(DivineRPGMaterials.everbrightSwordMaterial, "everbright"); 
	public static SwordBase clawTeaker = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_teaker", true);
	public static SwordBase clawAmthirmis = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_amthirmis", true);
	public static SwordBase clawDarven = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_darven", true);
	public static SwordBase clawCermile = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_cermile", true);
	public static SwordBase clawPardimal = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_pardimal", true);
	public static SwordBase clawQuadrotic = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_quadrotic", true);
	public static SwordBase clawKaros = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_karos", true);
	public static SwordBase clawHeliosis = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_heliosis", true);
	public static SwordBase clawArksiane = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_arksiane", true);
	public static SwordBase palavence = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "palavence");
	public static SwordBase massivence = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "massivence");
	public static SwordBase arlemiteStabber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "stabber_arlemite");
	public static SwordBase rupeeRapier = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "rapier_rupee");
	public static SwordBase aquaticDagger = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "dagger_aquatic");
	public static SwordBase aquaticTrident = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "trident_aquatic");
	public static SwordBase oceanKnife = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "knife_ocean");
	public static SwordBase deathBringer = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "deathbringer");
	public static SwordBase aquaticMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_aquatic");
	public static SwordBase crabclawMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_claw_crab");
	public static SwordBase poisonSaber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "saber_poison");
	public static SwordBase furyMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_fury");
	public static SwordBase icicleBane = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "icicle_bane");
	public static SwordBase corruptedMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_corrupted");
	public static SwordBase edenBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_eden");
	public static SwordBase bedrockMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_bedrock");
	public static SwordBase apalachiaBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_apalachia");
	public static SwordBase mortumBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_mortum");
	public static SwordBase haliteBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_halite");
	public static SwordBase sandslash = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "sandslash");
	public static SwordBase shadowSaber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "saber_shadow");
	public static SwordBase flamingFury = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "flamingfury");
	public static ItemBase shardJungle = new ItemBase("shard_jungle"); 
	public static ItemBase shardMolten = new ItemBase("shard_molten"); 
	public static ItemBase shardCorrupted = new ItemBase("shard_corrupted"); 
	public static ItemBase shardEnder = new ItemBase("shard_ender"); 
	public static ItemBase sharkFin = new ItemBase("shark_fin"); 
	public static ItemBase tokensDungeon = new ItemBase("tokens_dungeon"); 
	public static TeleportStaff tpStaff = new TeleportStaff("teleportation_crystal");
	public static InfernoArrow arrowInferno = new InfernoArrow("arrow_inferno");
	public static ItemBase edenSparklez = new ItemBase("eden_sparklez"); 
	
	public static void register(IForgeRegistry<Item> registry) {
		System.out.print("DivineRPG items loading");
		registry.registerAll(
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
				gemMortum,
				gemWildwood,
				mysteriousClock,
				moonClock,
				twilightClock,
				acid,
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
				divineShickaxe,
				cannonAmthirmis,
				templateDisc,
				templateCannon,
				templateBacksword,
				templateBow,
				templateStaff,
				templateClaw,
				templateDegraded,
				templateFinished,
				templateGlistening,
				templateDemonized,
				templateTormented,
				soulEden,
				soulWild,
				soulApalachia,
				soulSkythern,
				soulMortum,
				fragmentApalachia,
				fragmentEden,
				fragmentSkythern,
				fragmentMortum,
				fragmentWildwood,
				corruptedAxe,
				corruptedShovel,
				corruptedPickaxe,
				pearlsDirty,
				pearlsClean,
				pearlsShiny,
				pearlsPolished,
				bookWizards,
				lumpsTeaker,
				lumpsAmthirmis,
				lumpsDarven,
				lumpsCermile,
				lumpsPardimal,
				lumpsQuadrotic,
				lumpsKaros,
				lumpsHeliosis,
				lumpsArksiane,
				serenadeStrike,
				serenadeHeal,
				serenadeIce,
				serenadeDeath,
				serenadeInfusion,
				cannonTeaker,
				cannonAmthirmis,
				cannonDarven,
				cannonCermile,
				cannonPardimal,
				cannonQuadrotic,
				cannonKaros,
				cannonHeliosis,
				cannonArksiane,
				bacon,
				hotPumpkinPie,
				boiledEgg,
				cheese,
				mushroomWhite,
				mushroomStewAdvanced,
				tomato,
				donut,
				rawEmpoweredMeat,
				empoweredMeat,
				magicMeat,
				enrichedMagicMeat,
				eggNog,
				peppermints,
				chocolateLog,
				snowCone,
				fruitCake,
				winterberry,
				honeySuckle,
				honeyChunk,
				dreamCarrot,
				dreamMelon,
				dreamPie,
				dreamCake,
				dreamSweets,
				dreamSours,
				moonbulb,
				glowbonePurple,
				glowbonePink,
				skyflower,
				hitchak,
				pinfly,
				captainsparkler,
				teakerBackSword,
				amthrimisBackSword,
				darvenBackSword,
				cermileBackSword,
				pardimalBackSword,
				quadroticBackSword,
				karosBackSword,
				heliosisBackSword,
				arksianeWrathSword,
				icineSword,
				glacierSword,
				frostkingSword,
				frostSword,
				divineSword,
				divineYSword,
				divineGSword,
				divineRSword,
				divineGRSword,
				sharkSword,
				slimeSword,
				infernoSword,
				cyclopsianSword,
				moltenSword,
				scorchingSword,
				bluefireSword,
				enderSword,
				enderBSword,
				enderYSword,
				enderGSword,
				enderRSword,
				donatorSword,
				realmitePickaxe,
				edenPickaxe,
				wildwoodPickaxe,
				apalachiaPickaxe,
				skythernPickaxe,
				mortumPickaxe,
				divinePickaxe,
				arlemitePickaxe,
				rupeePickaxe,
				bedrockPickaxe,
				realmiteAxe,
				edenAxe,
				wildwoodAxe,
				apalachiaAxe,
				skythernAxe,
				mortumAxe,
				divineAxe,
				arlemiteAxe,
				rupeeAxe,
				bedrockAxe,
				realmiteShovel,
				edenShovel,
				wildwoodShovel,
				apalachiaShovel,
				skythernShovel,
				mortumShovel,
				divineShovel,
				arlemiteShovel,
				rupeeShovel,
				bedrockShovel,
				arlemiteHoe,
				rupeeHoe,
				realmiteHoe,
				crabClaw,
				crabClawCannon,
				crabClawDual,
				crabClawAnchor,
				everlight,
				everbright,
				clawTeaker,
				clawAmthirmis,
				clawDarven,
				clawCermile,
				clawPardimal,
				clawQuadrotic,
				clawKaros,
				clawHeliosis,
				clawArksiane,
				palavence,
				massivence,
				arlemiteStabber,
				rupeeRapier,
				aquaticDagger,
				aquaticTrident,
				oceanKnife,
				deathBringer,
				aquaticMaul,
				crabclawMaul,
				poisonSaber,
				furyMaul,
				icicleBane,
				corruptedMaul,
				edenBlade,
				bedrockMaul,
				apalachiaBlade,
				mortumBlade,
				haliteBlade,
				sandslash,
				shadowSaber,
				flamingFury,
				shardJungle,
				shardMolten,
				shardCorrupted,
				shardEnder,
				sharkFin,
				tokensDungeon,
				tpStaff,
				arrowInferno,
				edenSparklez
				);
	}
	
	public static void registerModels() {
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
		gemMortum.registerItemModel();
		gemWildwood.registerItemModel();
		mysteriousClock.registerItemModel();
		moonClock.registerItemModel();
		twilightClock.registerItemModel();
		acid.registerItemModel();
		aquamarine.registerItemModel();
		aquamarine.registerItemModel();
		aquaticBlazeRod.registerItemModel();
		aquaton.registerItemModel();
		arcanaSpawnEgg.registerItemModel();
		amthrimisBackSword.registerItemModel();
		aquatoothSword.registerItemModel();
		arksianeWrathSword.registerItemModel();
		bedrockSword.registerItemModel();
		blackEnderSword.registerItemModel();
		bloodgemSword.registerItemModel();
		blueDivineSword.registerItemModel();
		stormSword.registerItemModel();
		chickenDinner.registerItemModel();
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
		cannonAmthirmis.registerItemModel();
		templateDisc.registerItemModel();
		templateCannon.registerItemModel();
		templateBacksword.registerItemModel();
		templateBow.registerItemModel();
		templateStaff.registerItemModel();
		templateClaw.registerItemModel();
		templateDegraded.registerItemModel();
		templateFinished.registerItemModel();
		templateGlistening.registerItemModel();
		templateDemonized.registerItemModel();
		templateTormented.registerItemModel();
		soulEden.registerItemModel();
		soulWild.registerItemModel();
		soulApalachia.registerItemModel();
		soulSkythern.registerItemModel();
		soulMortum.registerItemModel();
		fragmentApalachia.registerItemModel();
		fragmentEden.registerItemModel();
		fragmentSkythern.registerItemModel();
		fragmentMortum.registerItemModel();
		fragmentWildwood.registerItemModel();
		corruptedAxe.registerItemModel();
		corruptedShovel.registerItemModel();
		corruptedPickaxe.registerItemModel();
		pearlsDirty.registerItemModel();
		pearlsClean.registerItemModel();
		pearlsShiny.registerItemModel();
		pearlsPolished.registerItemModel();
		bookWizards.registerItemModel();
		lumpsTeaker.registerItemModel();
		lumpsAmthirmis.registerItemModel();
		lumpsDarven.registerItemModel();
		lumpsCermile.registerItemModel();
		lumpsPardimal.registerItemModel();
		lumpsQuadrotic.registerItemModel();
		lumpsKaros.registerItemModel();
		lumpsHeliosis.registerItemModel();
		lumpsArksiane.registerItemModel();
		serenadeStrike.registerItemModel();
		serenadeHeal.registerItemModel();
		serenadeIce.registerItemModel();
		serenadeDeath.registerItemModel();
		serenadeInfusion.registerItemModel();
		cannonTeaker.registerItemModel();
		cannonAmthirmis.registerItemModel();
		cannonDarven.registerItemModel();
		cannonCermile.registerItemModel();
		cannonPardimal.registerItemModel();
		cannonQuadrotic.registerItemModel();
		cannonKaros.registerItemModel();
		cannonHeliosis.registerItemModel();
		cannonArksiane.registerItemModel();
		bacon.registerItemModel();
		hotPumpkinPie.registerItemModel();
		boiledEgg.registerItemModel();
		cheese.registerItemModel();
		mushroomWhite.registerItemModel();
		mushroomStewAdvanced.registerItemModel();
		tomato.registerItemModel();
		donut.registerItemModel();
		rawEmpoweredMeat.registerItemModel();
		empoweredMeat.registerItemModel();
		magicMeat.registerItemModel();
		enrichedMagicMeat.registerItemModel();
		eggNog.registerItemModel();
		peppermints.registerItemModel();
		chocolateLog.registerItemModel();
		snowCone.registerItemModel();
		fruitCake.registerItemModel();
		winterberry.registerItemModel();
		honeySuckle.registerItemModel();
		honeyChunk.registerItemModel();
		dreamCarrot.registerItemModel();
		dreamMelon.registerItemModel();
		dreamPie.registerItemModel();
		dreamCake.registerItemModel();
		dreamSweets.registerItemModel();
		dreamSours.registerItemModel();
		moonbulb.registerItemModel();
		glowbonePurple.registerItemModel();
		glowbonePink.registerItemModel();
		skyflower.registerItemModel();
		hitchak.registerItemModel();
		pinfly.registerItemModel();
		captainsparkler.registerItemModel();
		teakerBackSword.registerItemModel();
		amthrimisBackSword.registerItemModel();
		darvenBackSword.registerItemModel();
		cermileBackSword.registerItemModel();
		pardimalBackSword.registerItemModel();
		quadroticBackSword.registerItemModel();
		karosBackSword.registerItemModel();
		heliosisBackSword.registerItemModel();
		arksianeWrathSword.registerItemModel();
		icineSword.registerItemModel();
		glacierSword.registerItemModel();
		frostkingSword.registerItemModel();
		frostSword.registerItemModel();
		divineSword.registerItemModel();
		divineYSword.registerItemModel();
		divineGSword.registerItemModel();
		divineRSword.registerItemModel();
		divineGRSword.registerItemModel();
		sharkSword.registerItemModel();
		slimeSword.registerItemModel();
		infernoSword.registerItemModel();
		cyclopsianSword.registerItemModel();
		moltenSword.registerItemModel();
		scorchingSword.registerItemModel();
		bluefireSword.registerItemModel();
		enderSword.registerItemModel();
		enderBSword.registerItemModel();
		enderYSword.registerItemModel();
		enderGSword.registerItemModel();
		enderRSword.registerItemModel();
		donatorSword.registerItemModel();
		realmitePickaxe.registerItemModel();
		edenPickaxe.registerItemModel();
		wildwoodPickaxe.registerItemModel();
		apalachiaPickaxe.registerItemModel();
		skythernPickaxe.registerItemModel();
		mortumPickaxe.registerItemModel();
		divinePickaxe.registerItemModel();
		arlemitePickaxe.registerItemModel();
		rupeePickaxe.registerItemModel();
		bedrockPickaxe.registerItemModel();
		realmiteAxe.registerItemModel();
		edenAxe.registerItemModel();
		wildwoodAxe.registerItemModel();
		apalachiaAxe.registerItemModel();
		skythernAxe.registerItemModel();
		mortumAxe.registerItemModel();
		divineAxe.registerItemModel();
		arlemiteAxe.registerItemModel();
		rupeeAxe.registerItemModel();
		bedrockAxe.registerItemModel();
		realmiteShovel.registerItemModel();
		edenShovel.registerItemModel();
		wildwoodShovel.registerItemModel();
		apalachiaShovel.registerItemModel();
		skythernShovel.registerItemModel();
		mortumShovel.registerItemModel();
		divineShovel.registerItemModel();
		arlemiteShovel.registerItemModel();
		rupeeShovel.registerItemModel();
		bedrockShovel.registerItemModel();
		arlemiteHoe.registerItemModel();
		rupeeHoe.registerItemModel();
		realmiteHoe.registerItemModel();
		crabClaw.registerItemModel();
		crabClawCannon.registerItemModel();
		crabClawDual.registerItemModel();
		crabClawAnchor.registerItemModel();
		everlight.registerItemModel();
		everbright.registerItemModel();
		clawTeaker.registerItemModel();
		clawAmthirmis.registerItemModel();
		clawDarven.registerItemModel();
		clawCermile.registerItemModel();
		clawPardimal.registerItemModel();
		clawQuadrotic.registerItemModel();
		clawKaros.registerItemModel();
		clawHeliosis.registerItemModel();
		clawArksiane.registerItemModel();
		palavence.registerItemModel();
		massivence.registerItemModel();
		arlemiteStabber.registerItemModel();
		rupeeRapier.registerItemModel();
		aquaticDagger.registerItemModel();
		aquaticTrident.registerItemModel();
		oceanKnife.registerItemModel();
		deathBringer.registerItemModel();
		aquaticMaul.registerItemModel();
		crabclawMaul.registerItemModel();
		poisonSaber.registerItemModel();
		furyMaul.registerItemModel();
		icicleBane.registerItemModel();
		corruptedMaul.registerItemModel();
		edenBlade.registerItemModel();
		bedrockMaul.registerItemModel();
		apalachiaBlade.registerItemModel();
		mortumBlade.registerItemModel();
		haliteBlade.registerItemModel();
		sandslash.registerItemModel();
		shadowSaber.registerItemModel();
		flamingFury.registerItemModel();
		shardJungle.registerItemModel();
		shardMolten.registerItemModel();
		shardCorrupted.registerItemModel();
		shardEnder.registerItemModel();
		sharkFin.registerItemModel();
		tokensDungeon.registerItemModel();
		tpStaff.registerItemModel();
		arrowInferno.registerItemModel();
		edenSparklez.registerItemModel();
		
		DivineRPG.logger.info(DivineRPG.name + " items are loaded");
	}
	
}