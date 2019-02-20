package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.Aquamarine;
import naturix.divinerpg.objects.items.AxeBase;
import naturix.divinerpg.objects.items.BowBase;
import naturix.divinerpg.objects.items.CannonBase;
import naturix.divinerpg.objects.items.HoeBase;
import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.objects.items.ItemBlockSteelDoor;
import naturix.divinerpg.objects.items.ItemDisk;
import naturix.divinerpg.objects.items.ItemSpawnEgg;
import naturix.divinerpg.objects.items.PickaxeBase;
import naturix.divinerpg.objects.items.ShickaxeBase;
import naturix.divinerpg.objects.items.ShovelBase;
import naturix.divinerpg.objects.items.SnowGlobe;
import naturix.divinerpg.objects.items.SpawnerBase;
import naturix.divinerpg.objects.items.SwordBase;
import naturix.divinerpg.objects.items.TeleportStaff;
import naturix.divinerpg.objects.items.armor.Angelic;
import naturix.divinerpg.objects.items.armor.Apalachia;
import naturix.divinerpg.objects.items.armor.Aquastrive;
import naturix.divinerpg.objects.items.armor.Bedrock;
import naturix.divinerpg.objects.items.armor.BootsBase;
import naturix.divinerpg.objects.items.armor.ChestplateBase;
import naturix.divinerpg.objects.items.armor.Corrupted;
import naturix.divinerpg.objects.items.armor.Degraded;
import naturix.divinerpg.objects.items.armor.Demonized;
import naturix.divinerpg.objects.items.armor.Divine;
import naturix.divinerpg.objects.items.armor.Donator;
import naturix.divinerpg.objects.items.armor.Eden;
import naturix.divinerpg.objects.items.armor.Ender;
import naturix.divinerpg.objects.items.armor.Finished;
import naturix.divinerpg.objects.items.armor.Frozen;
import naturix.divinerpg.objects.items.armor.Glistening;
import naturix.divinerpg.objects.items.armor.Halite;
import naturix.divinerpg.objects.items.armor.HelmetBase;
import naturix.divinerpg.objects.items.armor.Inferno;
import naturix.divinerpg.objects.items.armor.JackOMan;
import naturix.divinerpg.objects.items.armor.Jungle;
import naturix.divinerpg.objects.items.armor.Korma;
import naturix.divinerpg.objects.items.armor.Kraken;
import naturix.divinerpg.objects.items.armor.LeggingsBase;
import naturix.divinerpg.objects.items.armor.Mortum;
import naturix.divinerpg.objects.items.armor.Netherite;
import naturix.divinerpg.objects.items.armor.Realmite;
import naturix.divinerpg.objects.items.armor.Rupee;
import naturix.divinerpg.objects.items.armor.Santa;
import naturix.divinerpg.objects.items.armor.Shadow;
import naturix.divinerpg.objects.items.armor.Skeleman;
import naturix.divinerpg.objects.items.armor.Skythern;
import naturix.divinerpg.objects.items.armor.Terran;
import naturix.divinerpg.objects.items.armor.Tormented;
import naturix.divinerpg.objects.items.armor.Vemos;
import naturix.divinerpg.objects.items.armor.Wildwood;
import naturix.divinerpg.objects.items.armor.WitherReaper;
import naturix.divinerpg.objects.items.arrows.InfernoArrow;
import naturix.divinerpg.objects.items.book.BookBase;
import naturix.divinerpg.objects.items.clock.MysteriousClock;
import naturix.divinerpg.objects.items.food.FoodBase;
import naturix.divinerpg.objects.items.food.ReturnBucket;
import naturix.divinerpg.objects.items.food.ReturnsBowl;
import naturix.divinerpg.objects.items.serenade.SerenadeDeath;
import naturix.divinerpg.objects.items.serenade.SerenadeHeal;
import naturix.divinerpg.objects.items.serenade.SerenadeIce;
import naturix.divinerpg.objects.items.serenade.SerenadeInfusion;
import naturix.divinerpg.objects.items.serenade.SerenadeStrike;
import naturix.divinerpg.objects.items.special.ItemCaptainsSparkler;
import naturix.divinerpg.objects.items.vanilla.CallOfTheWatcher;
import naturix.divinerpg.objects.items.vanilla.HordeHorn;
import naturix.divinerpg.objects.items.vanilla.Shuriken;
import naturix.divinerpg.objects.items.vanilla.Vilestorm;
import naturix.divinerpg.utils.DivineRPGMaterials;
import naturix.divinerpg.utils.material.EnumArmor;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	private static EntitySlime EntitySlime;
	public static ItemDisk amthirmisDisk = new ItemDisk(6, "disk_amthirmis");
	public static BowBase hunterBow = new BowBase("bow_hunter");
	public static BowBase shadowBow = new BowBase("bow_shadow");
	public static BowBase enderBow = new BowBase("bow_ender");
	public static BowBase bluefireBow = new BowBase("bow_bluefire");
	public static BowBase infernoBow = new BowBase("bow_inferno");
	public static BowBase icicleBow = new BowBase("bow_icicle");
	public static BowBase snowBow = new BowBase("bow_snowstorm");
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
	public static ItemBase gemBlood = new ItemBase("gem_blood");
	public static ItemBase stoneJungle = new ItemBase("stone_jungle");
	public static ItemBase stoneIce = new ItemBase("stone_ice");
	public static MysteriousClock mysteriousClock = new MysteriousClock("clock_mysterious");
	public static MysteriousClock moonClock = new MysteriousClock("clock_moon");
	public static MysteriousClock twilightClock = new MysteriousClock("clock_twilight");
	public static ItemBase acid = new ItemBase("acid");
	public static Aquamarine aquamarine = new Aquamarine("aquamarine");
	public static ItemBase aquaticBlazeRod = new ItemBase("rod_aquatic_blaze");
	public static ItemBase aquaton = new ItemBase("aquaton", DivineRPG.CombatTab);
	public static SpawnerBase arcanaSpawnEgg = new SpawnerBase("spawn_egg_arcana", EntitySlime);
	public static Angelic angelicHelmet = new Angelic(EnumArmor.ANGELIC, EntityEquipmentSlot.HEAD, "angelic_helmet");
	public static Angelic angelicChestplate = new Angelic(EnumArmor.ANGELIC, EntityEquipmentSlot.CHEST,
	        "angelic_chestplate");
	public static Angelic angelicLeggings = new Angelic(EnumArmor.ANGELIC, EntityEquipmentSlot.LEGS,
	        "angelic_leggings");
	public static Angelic angelicBoots = new Angelic(EnumArmor.ANGELIC, EntityEquipmentSlot.FEET, "angelic_boots");
	public static Apalachia apalachiaHelmet = new Apalachia(EnumArmor.apalachiaArmorMaterial, EntityEquipmentSlot.HEAD,
	        "apalachia_helmet");
	public static Apalachia apalachiaChestplate = new Apalachia(EnumArmor.apalachiaArmorMaterial,
	        EntityEquipmentSlot.CHEST, "apalachia_chestplate");
	public static Apalachia apalachiaLeggings = new Apalachia(EnumArmor.apalachiaArmorMaterial,
	        EntityEquipmentSlot.LEGS, "apalachia_leggings");
	public static Apalachia apalachiaBoots = new Apalachia(EnumArmor.apalachiaArmorMaterial, EntityEquipmentSlot.FEET,
	        "apalachia_boots");
	public static Aquastrive aquastriveHelmet = new Aquastrive(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.HEAD, "aquastrive_helmet");
	public static Aquastrive aquastriveChestplate = new Aquastrive(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.CHEST, "aquastrive_chestplate");
	public static Aquastrive aquastriveLeggings = new Aquastrive(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.LEGS, "aquastrive_leggings");
	public static Aquastrive aquastriveBoots = new Aquastrive(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.FEET, "aquastrive_boots");
	public static Bedrock bedrockHelmet = new Bedrock(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.HEAD,
	        "bedrock_helmet");
	public static Bedrock bedrockChestplate = new Bedrock(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.CHEST,
	        "bedrock_chestplate");
	public static Bedrock bedrockLeggings = new Bedrock(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.LEGS,
	        "bedrock_leggings");
	public static Bedrock bedrockBoots = new Bedrock(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.FEET,
	        "bedrock_boots");
	public static Corrupted corruptedHelmet = new Corrupted(EnumArmor.corruptedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "corrupted_helmet");
	public static Corrupted corruptedChestplate = new Corrupted(EnumArmor.corruptedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "corrupted_chestplate");
	public static Corrupted corruptedLeggings = new Corrupted(EnumArmor.corruptedArmorMaterial,
	        EntityEquipmentSlot.LEGS, "corrupted_leggings");
	public static Corrupted corruptedBoots = new Corrupted(EnumArmor.corruptedArmorMaterial, EntityEquipmentSlot.FEET,
	        "corrupted_boots");
	public static Degraded degradedHelmet = new Degraded(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "degraded_helmet");
	public static Degraded degradedChestplate = new Degraded(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.CHEST,
	        "degraded_chestplate");
	public static Degraded degradedLeggings = new Degraded(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.LEGS,
	        "degraded_leggings");
	public static Degraded degradedBoots = new Degraded(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.FEET,
	        "degraded_boots");
	public static Demonized demonizedHelmet = new Demonized(EnumArmor.demonizedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "demonized_helmet");
	public static Demonized demonizedChestplate = new Demonized(EnumArmor.demonizedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "demonized_chestplate");
	public static Demonized demonizedLeggings = new Demonized(EnumArmor.demonizedArmorMaterial,
	        EntityEquipmentSlot.LEGS, "demonized_leggings");
	public static Demonized demonizedBoots = new Demonized(EnumArmor.demonizedArmorMaterial, EntityEquipmentSlot.FEET,
	        "demonized_boots");
	public static Divine divineHelmet = new Divine(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.HEAD,
	        "divine_helmet");
	public static Divine divineChestplate = new Divine(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.CHEST,
	        "divine_chestplate");
	public static Divine divineLeggings = new Divine(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.LEGS,
	        "divine_leggings");
	public static Divine divineBoots = new Divine(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.FEET,
	        "divine_boots");
	public static Donator donatorHelmet = new Donator(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.HEAD,
	        "donator_helmet");
	public static Donator donatorChestplate = new Donator(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.CHEST,
	        "donator_chestplate");
	public static Donator donatorLeggings = new Donator(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.LEGS,
	        "donator_leggings");
	public static Donator donatorBoots = new Donator(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.FEET,
	        "donator_boots");
	public static Eden edenHelmet = new Eden(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.HEAD, "eden_helmet");
	public static Eden edenChestplate = new Eden(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.CHEST,
	        "eden_chestplate");
	public static Eden edenLeggings = new Eden(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.LEGS, "eden_leggings");
	public static Eden edenBoots = new Eden(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.FEET, "eden_boots");
	public static HelmetBase eliteRealmiteHelmet = new HelmetBase("realmite_helmet_elite",
	        EnumArmor.realmiteArmorMaterial, "realmite_elite1");
	public static ChestplateBase eliteRealmiteChestplate = new ChestplateBase("realmite_chestplate_elite",
	        EnumArmor.realmiteArmorMaterial, "realmite_elite1");
	public static LeggingsBase eliteRealmiteLeggings = new LeggingsBase("realmite_leggings_elite",
	        EnumArmor.realmiteArmorMaterial, "realmite_elite2");
	public static BootsBase eliteRealmiteBoots = new BootsBase("realmite_boots_elite", EnumArmor.realmiteArmorMaterial,
	        "realmite_elite3");
	public static Ender enderHelmet = new Ender(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.HEAD, "ender_helmet");
	public static Ender enderChestplate = new Ender(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.CHEST,
	        "ender_chestplate");
	public static Ender enderLeggings = new Ender(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.LEGS,
	        "ender_leggings");
	public static Ender enderBoots = new Ender(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.FEET, "ender_boots");
	public static Finished finishedHelmet = new Finished(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "finished_helmet");
	public static Finished finishedChestplate = new Finished(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.CHEST,
	        "finished_chestplate");
	public static Finished finishedLeggings = new Finished(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.LEGS,
	        "finished_leggings");
	public static Finished finishedBoots = new Finished(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.FEET,
	        "finished_boots");
	public static Frozen frozenHelmet = new Frozen(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.HEAD,
	        "frozen_helmet");
	public static Frozen frozenChestplate = new Frozen(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.CHEST,
	        "frozen_chestplate");
	public static Frozen frozenLeggings = new Frozen(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.LEGS,
	        "frozen_leggings");
	public static Frozen frozenBoots = new Frozen(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.FEET,
	        "frozen_boots");
	public static Glistening glisteningHelmet = new Glistening(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.HEAD, "glistening_helmet");
	public static Glistening glisteningChestplate = new Glistening(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.CHEST, "glistening_chestplate");
	public static Glistening glisteningLeggings = new Glistening(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.LEGS, "glistening_leggings");
	public static Glistening glisteningBoots = new Glistening(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.FEET, "glistening_boots");
	public static Halite haliteHelmet = new Halite(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.HEAD,
	        "halite_helmet");
	public static Halite haliteChestplate = new Halite(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.CHEST,
	        "halite_chestplate");
	public static Halite haliteLeggings = new Halite(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.LEGS,
	        "halite_leggings");
	public static Halite haliteBoots = new Halite(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.FEET,
	        "halite_boots");
	public static Inferno infernoHelmet = new Inferno(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.HEAD,
	        "inferno_helmet");
	public static Inferno infernoChestplate = new Inferno(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.CHEST,
	        "inferno_chestplate");
	public static Inferno infernoLeggings = new Inferno(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.LEGS,
	        "inferno_leggings");
	public static Inferno infernoBoots = new Inferno(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.FEET,
	        "inferno_boots");
	public static JackOMan jackomanHelmet = new JackOMan(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.HEAD,
	        "jackoman_helmet");
	public static JackOMan jackomanChestplate = new JackOMan(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.CHEST,
	        "jackoman_chestplate");
	public static JackOMan jackomanLeggings = new JackOMan(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.LEGS,
	        "jackoman_leggings");
	public static JackOMan jackomanBoots = new JackOMan(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.FEET,
	        "jackoman_boots");
	public static Jungle jungleHelmet = new Jungle(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.HEAD,
	        "jungle_helmet");
	public static Jungle jungleChestplate = new Jungle(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.CHEST,
	        "jungle_chestplate");
	public static Jungle jungleLeggings = new Jungle(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.LEGS,
	        "jungle_leggings");
	public static Jungle jungleBoots = new Jungle(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.FEET,
	        "jungle_boots");
	public static Korma kormaHelmet = new Korma(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.HEAD, "korma_helmet");
	public static Korma kormaChestplate = new Korma(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.CHEST,
	        "korma_chestplate");
	public static Korma kormaLeggings = new Korma(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.LEGS,
	        "korma_leggings");
	public static Korma kormaBoots = new Korma(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.FEET, "korma_boots");
	public static Kraken krakenHelmet = new Kraken(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.HEAD,
	        "kraken_helmet");
	public static Kraken krakenChestplate = new Kraken(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.CHEST,
	        "kraken_chestplate");
	public static Kraken krakenLeggings = new Kraken(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.LEGS,
	        "kraken_leggings");
	public static Kraken krakenBoots = new Kraken(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.FEET,
	        "kraken_boots");
	public static Mortum mortumHelmet = new Mortum(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.HEAD,
	        "mortum_helmet");
	public static Mortum mortumChestplate = new Mortum(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.CHEST,
	        "mortum_chestplate");
	public static Mortum mortumLeggings = new Mortum(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.LEGS,
	        "mortum_leggings");
	public static Mortum mortumBoots = new Mortum(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.FEET,
	        "mortum_boots");
	public static Netherite netheriteHelmet = new Netherite(EnumArmor.netheriteArmorMaterial, EntityEquipmentSlot.HEAD,
	        "netherite_helmet");
	public static Netherite netheriteChestplate = new Netherite(EnumArmor.netheriteArmorMaterial,
	        EntityEquipmentSlot.CHEST, "netherite_chestplate");
	public static Netherite netheriteLeggings = new Netherite(EnumArmor.netheriteArmorMaterial,
	        EntityEquipmentSlot.LEGS, "netherite_leggings");
	public static Netherite netheriteBoots = new Netherite(EnumArmor.netheriteArmorMaterial, EntityEquipmentSlot.FEET,
	        "netherite_boots");
	public static Realmite realmiteHelmet = new Realmite(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.HEAD,
	        "realmite_helmet");
	public static Realmite realmiteChestplate = new Realmite(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.CHEST,
	        "realmite_chestplate");
	public static Realmite realmiteLeggings = new Realmite(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.LEGS,
	        "realmite_leggings");
	public static Realmite realmiteBoots = new Realmite(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.FEET,
	        "realmite_boots");
	public static Rupee rupeeHelmet = new Rupee(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.HEAD, "rupee_helmet");
	public static Rupee rupeeChestplate = new Rupee(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.CHEST,
	        "rupee_chestplate");
	public static Rupee rupeeLeggings = new Rupee(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.LEGS,
	        "rupee_leggings");
	public static Rupee rupeeBoots = new Rupee(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.FEET, "rupee_boots");
	public static Santa santaCap = new Santa(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.HEAD, "santa_cap");
	public static Santa santaTunic = new Santa(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.CHEST, "santa_tunic");
	public static Santa santaPants = new Santa(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.LEGS, "santa_pants");
	public static Santa santaBoots = new Santa(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.FEET, "santa_boots");
	public static Shadow shadowHelmet = new Shadow(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.HEAD,
	        "shadow_helmet");
	public static Shadow shadowChestplate = new Shadow(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.CHEST,
	        "shadow_chestplate");
	public static Shadow shadowLeggings = new Shadow(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.LEGS,
	        "shadow_leggings");
	public static Shadow shadowBoots = new Shadow(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.FEET,
	        "shadow_boots");
	public static Skeleman skelemanHelmet = new Skeleman(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.HEAD,
	        "skeleman_helmet");
	public static Skeleman skelemanChestplate = new Skeleman(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.CHEST,
	        "skeleman_chestplate");
	public static Skeleman skelemanLeggings = new Skeleman(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.LEGS,
	        "skeleman_leggings");
	public static Skeleman skelemanBoots = new Skeleman(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.FEET,
	        "skeleman_boots");
	public static Skythern skythernHelmet = new Skythern(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.HEAD,
	        "skythern_helmet");
	public static Skythern skythernChestplate = new Skythern(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.CHEST,
	        "skythern_chestplate");
	public static Skythern skythernLeggings = new Skythern(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.LEGS,
	        "skythern_leggings");
	public static Skythern skythernBoots = new Skythern(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.FEET,
	        "skythern_boots");
	public static Terran terranHelmet = new Terran(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.HEAD,
	        "terran_helmet");
	public static Terran terranChestplate = new Terran(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.CHEST,
	        "terran_chestplate");
	public static Terran terranLeggings = new Terran(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.LEGS,
	        "terran_leggings");
	public static Terran terranBoots = new Terran(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.FEET,
	        "terran_boots");
	public static Tormented tormentedHelmet = new Tormented(EnumArmor.tormentedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "tormented_helmet");
	public static Tormented tormentedChestplate = new Tormented(EnumArmor.tormentedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "tormented_chestplate");
	public static Tormented tormentedLeggings = new Tormented(EnumArmor.tormentedArmorMaterial,
	        EntityEquipmentSlot.LEGS, "tormented_leggings");
	public static Tormented tormentedBoots = new Tormented(EnumArmor.tormentedArmorMaterial, EntityEquipmentSlot.FEET,
	        "tormented_boots");
	public static Vemos vemosHelmet = new Vemos(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.HEAD, "vemos_helmet");
	public static Vemos vemosChestplate = new Vemos(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.CHEST,
	        "vemos_chestplate");
	public static Vemos vemosLeggings = new Vemos(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.LEGS,
	        "vemos_leggings");
	public static Vemos vemosBoots = new Vemos(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.FEET, "vemos_boots");
	public static Wildwood wildwoodHelmet = new Wildwood(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.HEAD,
	        "wildwood_helmet");
	public static Wildwood wildwoodChestplate = new Wildwood(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.CHEST,
	        "wildwood_chestplate");
	public static Wildwood wildwoodLeggings = new Wildwood(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.LEGS,
	        "wildwood_leggings");
	public static Wildwood wildwoodBoots = new Wildwood(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.FEET,
	        "wildwood_boots");
	public static WitherReaper witherreaperHelmet = new WitherReaper(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.HEAD, "wither_reaper_helmet");
	public static WitherReaper witherreaperChestplate = new WitherReaper(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.CHEST, "wither_reaper_chestplate");
	public static WitherReaper witherreaperLeggings = new WitherReaper(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.LEGS, "wither_reaper_leggings");
	public static WitherReaper witherreaperBoots = new WitherReaper(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.FEET, "wither_reaper_boots");
	public static ItemBase bandHeivaHunt = new ItemBase("band_heiva_hunt");
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
	public static AxeBase corruptedAxe = new AxeBase(DivineRPGMaterials.corruptedAxeMaterial, "axe_corrupted");
	public static ShovelBase corruptedShovel = new ShovelBase(DivineRPGMaterials.corruptedShovelMaterial,
	        "shovel_corrupted");
	public static PickaxeBase corruptedPickaxe = new PickaxeBase(DivineRPGMaterials.corruptedPickMaterial,
	        "pickaxe_corrupted", 18F, 1F);
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
	public static CannonBase cannonTeaker = new CannonBase("cannon_teaker");
	public static CannonBase cannonAmthirmis = new CannonBase("cannon_amthirmis");
	public static CannonBase cannonDarven = new CannonBase("cannon_darven");
	public static CannonBase cannonCermile = new CannonBase("cannon_cermile");
	public static CannonBase cannonPardimal = new CannonBase("cannon_pardimal");
	public static CannonBase cannonQuadrotic = new CannonBase("cannon_quadrotic");
	public static CannonBase cannonKaros = new CannonBase("cannon_karos");
	public static CannonBase cannonHeliosis = new CannonBase("cannon_heliosis");
	public static CannonBase cannonArksiane = new CannonBase("cannon_arksiane");
	public static FoodBase chickenDinner = new FoodBase("winner_winner", 18, false, true);
	public static FoodBase bacon = new FoodBase("bacon", 3, true, true);
	public static FoodBase hotPumpkinPie = new FoodBase("pie_pumpkin_hot", 7, true);
	public static FoodBase boiledEgg = new FoodBase("egg_boiled", 1, false);
	public static FoodBase cheese = new FoodBase("cheese", 1, false);
	public static FoodBase mushroomWhite = new FoodBase("mushroom_white", 1, false);
	public static ReturnsBowl mushroomStewAdvanced = new ReturnsBowl("mushroom_stew", 10, false);
	public static FoodBase tomato = new FoodBase("tomato", 2, false);
	public static FoodBase donut = new FoodBase("donut", 18, false);
	public static FoodBase rawEmpoweredMeat = new FoodBase("meat_empowered_raw", 2, true, true);
	public static FoodBase empoweredMeat = new FoodBase("meat_empowered", 4, true, true);
	public static FoodBase magicMeat = new FoodBase("meat_magic", 1, true, true);
	public static FoodBase enrichedMagicMeat = new FoodBase("meat_magic_enriched", 2, true, true);
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
	public static ItemCaptainsSparkler captainsparkler = new ItemCaptainsSparkler("captainsparkler");
	public static SwordBase teakerBackSword = new SwordBase(DivineRPGMaterials.teakerSwordMaterial,
	        "sword_teaker_back");
	public static SwordBase amthrimisBackSword = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial,
	        "sword_amthirmis_back");
	public static SwordBase darvenBackSword = new SwordBase(DivineRPGMaterials.darvenSwordMaterial,
	        "sword_darven_back");
	public static SwordBase cermileBackSword = new SwordBase(DivineRPGMaterials.cermileSwordMaterial,
	        "sword_cermile_back");
	public static SwordBase pardimalBackSword = new SwordBase(DivineRPGMaterials.pardimalSwordMaterial,
	        "sword_pardimal_back");
	public static SwordBase quadroticBackSword = new SwordBase(DivineRPGMaterials.quadroticSwordMaterial,
	        "sword_quadrotic_back");
	public static SwordBase karosBackSword = new SwordBase(DivineRPGMaterials.karosSwordMaterial, "sword_karos_back");
	public static SwordBase heliosisBackSword = new SwordBase(DivineRPGMaterials.heliosisSwordMaterial,
	        "sword_heliosis_back");
	public static SwordBase arksianeWrathSword = new SwordBase(DivineRPGMaterials.arksianeSwordMaterial,
	        "sword_arksiane_wrath");
	public static SwordBase icineSword = new SwordBase(DivineRPGMaterials.icineSwordMaterial, "sword_icine");
	public static SwordBase glacierSword = new SwordBase(DivineRPGMaterials.glacierSwordMaterial, "sword_glacier");
	public static SwordBase frostkingSword = new SwordBase(DivineRPGMaterials.frostKingSwordMaterial,
	        "sword_frostking");
	public static SwordBase frostSword = new SwordBase(DivineRPGMaterials.realmiteSwordMaterial, "sword_realmite");
	public static SwordBase divineSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine");
	public static SwordBase divineYSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_yellow");
	public static SwordBase divineGSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_grey");
	public static SwordBase divineRSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_red");
	public static SwordBase divineGRSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_green");
	public static SwordBase sharkSword = new SwordBase(DivineRPGMaterials.sharkSwordMaterial, "sword_shark");
	public static SwordBase slimeSword = new SwordBase(DivineRPGMaterials.slimeSwordMaterial, "sword_slime");
	public static SwordBase infernoSword = new SwordBase(DivineRPGMaterials.infernoSwordMaterial, "sword_inferno");
	public static SwordBase cyclopsianSword = new SwordBase(DivineRPGMaterials.cyclopsianSwordMaterial,
	        "sword_cyclopsian");
	public static SwordBase moltenSword = new SwordBase(DivineRPGMaterials.moltenSwordMaterial, "sword_molten");
	public static SwordBase scorchingSword = new SwordBase(DivineRPGMaterials.scorchingSwordMaterial,
	        "sword_scorching");
	public static SwordBase bluefireSword = new SwordBase(DivineRPGMaterials.bluefireSwordMaterial, "sword_bluefire");
	public static SwordBase enderSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender");
	public static SwordBase enderBSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_blue");
	public static SwordBase enderYSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_yellow");
	public static SwordBase enderGSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_green");
	public static SwordBase enderRSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_red");
	public static SwordBase aquatoothSword = new SwordBase(DivineRPGMaterials.aquatoothSwordMaterial,
	        "sword_aquatooth");
	public static SwordBase bedrockSword = new SwordBase(DivineRPGMaterials.bedrockSwordMaterial, "sword_bedrock");
	public static SwordBase blackEnderSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_black_ender");
	public static SwordBase bloodgemSword = new SwordBase(DivineRPGMaterials.bloodgemSwordMaterial, "sword_bloodgem");
	public static SwordBase blueDivineSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial,
	        "sword_blue_divine");
	public static SwordBase stormSword = new SwordBase(DivineRPGMaterials.stormSwordMaterial, "sword_storm");
	public static SwordBase donatorSword = new SwordBase(DivineRPGMaterials.realmiteSwordMaterial, "sword_donator");
	public static PickaxeBase realmitePickaxe = new PickaxeBase(DivineRPGMaterials.realmitePickMaterial,
	        "pickaxe_realmite", 0, 0);
	public static PickaxeBase edenPickaxe = new PickaxeBase(DivineRPGMaterials.edenPickMaterial, "pickaxe_eden", 0, 0);
	public static PickaxeBase wildwoodPickaxe = new PickaxeBase(DivineRPGMaterials.wildPickMaterial, "pickaxe_wildwood",
	        0, 0);
	public static PickaxeBase apalachiaPickaxe = new PickaxeBase(DivineRPGMaterials.apalachiaPickMaterial,
	        "pickaxe_apalachia", 0, 0);
	public static PickaxeBase skythernPickaxe = new PickaxeBase(DivineRPGMaterials.skythernPickMaterial,
	        "pickaxe_skythern", 0, 0);
	public static PickaxeBase mortumPickaxe = new PickaxeBase(DivineRPGMaterials.mortumPickMaterial, "pickaxe_mortum",
	        0, 0);
	public static PickaxeBase divinePickaxe = new PickaxeBase(DivineRPGMaterials.divinePickMaterial, "pickaxe_divine",
	        0, 0);
	public static PickaxeBase arlemitePickaxe = new PickaxeBase(DivineRPGMaterials.arlemitePickMaterial,
	        "pickaxe_arlemite", 0, 0);
	public static PickaxeBase rupeePickaxe = new PickaxeBase(DivineRPGMaterials.rupeePickMaterial, "pickaxe_rupee", 0,
	        0);
	public static PickaxeBase bedrockPickaxe = new PickaxeBase(DivineRPGMaterials.bedrockPickMaterial,
	        "pickaxe_bedrock", 0, 0);
	public static AxeBase realmiteAxe = new AxeBase(DivineRPGMaterials.realmiteAxeMaterial, "axe_realmite");
	public static AxeBase edenAxe = new AxeBase(DivineRPGMaterials.edenAxeMaterial, "axe_eden");
	public static AxeBase wildwoodAxe = new AxeBase(DivineRPGMaterials.wildAxeMaterial, "axe_wildwood");
	public static AxeBase apalachiaAxe = new AxeBase(DivineRPGMaterials.apalachiaAxeMaterial, "axe_apalachia");
	public static AxeBase skythernAxe = new AxeBase(DivineRPGMaterials.skythernAxeMaterial, "axe_skythern");
	public static AxeBase mortumAxe = new AxeBase(DivineRPGMaterials.mortumAxeMaterial, "axe_mortum");
	public static AxeBase divineAxe = new AxeBase(DivineRPGMaterials.divineAxeMaterial, "axe_divine");
	public static AxeBase arlemiteAxe = new AxeBase(DivineRPGMaterials.arlemiteAxeMaterial, "axe_arlemite");
	public static AxeBase rupeeAxe = new AxeBase(DivineRPGMaterials.rupeeAxeMaterial, "axe_rupee");
	public static AxeBase bedrockAxe = new AxeBase(DivineRPGMaterials.bedrockAxeMaterial, "axe_bedrock");
	public static ShovelBase realmiteShovel = new ShovelBase(DivineRPGMaterials.realmiteShovelMaterial,
	        "shovel_realmite");
	public static ShovelBase edenShovel = new ShovelBase(DivineRPGMaterials.edenShovelMaterial, "shovel_eden");
	public static ShovelBase wildwoodShovel = new ShovelBase(DivineRPGMaterials.wildShovelMaterial, "shovel_wildwood");
	public static ShovelBase apalachiaShovel = new ShovelBase(DivineRPGMaterials.apalachiaShovelMaterial,
	        "shovel_apalachia");
	public static ShovelBase skythernShovel = new ShovelBase(DivineRPGMaterials.skythernShovelMaterial,
	        "shovel_skythern");
	public static ShovelBase mortumShovel = new ShovelBase(DivineRPGMaterials.mortumShovelMaterial, "shovel_mortum");
	public static ShovelBase divineShovel = new ShovelBase(DivineRPGMaterials.divineShovelMaterial, "shovel_divine");
	public static ShovelBase arlemiteShovel = new ShovelBase(DivineRPGMaterials.arlemiteShovelMaterial,
	        "shovel_arlemite");
	public static ShovelBase rupeeShovel = new ShovelBase(DivineRPGMaterials.rupeeShovelMaterial, "shovel_rupee");
	public static ShovelBase bedrockShovel = new ShovelBase(DivineRPGMaterials.bedrockShovelMaterial, "shovel_bedrock");

	public static HoeBase arlemiteHoe = new HoeBase(DivineRPGMaterials.arlemiteHoeMaterial, "hoe_arlemite");
	public static HoeBase rupeeHoe = new HoeBase(DivineRPGMaterials.rupeeHoeMaterial, "hoe_rupee");
	public static HoeBase realmiteHoe = new HoeBase(DivineRPGMaterials.realmiteHoeMaterial, "hoe_realmite");
	public static ShickaxeBase rupeeShickaxe = new ShickaxeBase(DivineRPGMaterials.rupeeShickaxeMaterial,
	        "shickaxe_rupee");
	public static ShickaxeBase arlemiteShickaxe = new ShickaxeBase(DivineRPGMaterials.arlemiteShickaxeMaterial,
	        "shickaxe_arlemite");
	public static ShickaxeBase divineShickaxe = new ShickaxeBase(DivineRPGMaterials.divineShickaxeMaterial,
	        "shickaxe_divine");
	public static ItemBase crabClaw = new ItemBase("claw_crab");
	public static SwordBase crabClawDual = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial, "claw_crab_dual");
	public static CannonBase crabClawAnchor = new CannonBase("anchor_claw_crab");
	public static SwordBase everlight = new SwordBase(DivineRPGMaterials.everlightSwordMaterial, "everlight");
	public static SwordBase everbright = new SwordBase(DivineRPGMaterials.everbrightSwordMaterial, "everbright");
	public static SwordBase clawTeaker = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_teaker", true);
	public static SwordBase clawAmthirmis = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_amthirmis",
	        true);
	public static SwordBase clawDarven = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_darven", true);
	public static SwordBase clawCermile = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_cermile", true);
	public static SwordBase clawPardimal = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_pardimal",
	        true);
	public static SwordBase clawQuadrotic = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_quadrotic",
	        true);
	public static SwordBase clawKaros = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_karos", true);
	public static SwordBase clawHeliosis = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_heliosis",
	        true);
	public static SwordBase clawArksiane = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_arksiane",
	        true);
	public static SwordBase palavence = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "palavence");
	public static SwordBase massivence = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "massivence");
	public static SwordBase arlemiteStabber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial,
	        "stabber_arlemite");
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
	public static SwordBase daggerTerran = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "dagger_terran");
	public static SwordBase knifeTerran = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "knife_terran");
	public static SwordBase maulTerran = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_terran");
	public static SwordBase maulAquatooth = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_aquatooth");
	public static ItemBase shardJungle = new ItemBase("shard_jungle");
	public static ItemBase shardMolten = new ItemBase("shard_molten");
	public static ItemBase shardCorrupted = new ItemBase("shard_corrupted");
	public static ItemBase shardEnder = new ItemBase("shard_ender");
	public static ItemBase shardTerran = new ItemBase("shard_terran");
	public static ItemBase shardDivine = new ItemBase("shard_divine");
	public static ItemBase finShark = new ItemBase("fin_shark");
	public static ItemBase finWhale = new ItemBase("fin_whale");
	public static ItemBase tokensDungeon = new ItemBase("tokens_dungeon");
	public static TeleportStaff tpStaff = new TeleportStaff("teleportation_crystal");
	public static InfernoArrow arrowInferno = new InfernoArrow("arrow_inferno");
	public static ItemBase edenSparklez = new ItemBase("eden_sparklez");
	public static CallOfTheWatcher callWatcher = new CallOfTheWatcher("callofthewatcher");
	public static ItemBase eyeWatch = new ItemBase("watchingeye");
	public static ItemBase stoneMolten = new ItemBase("stone_molten");
	public static ItemBase stoneDivine = new ItemBase("stone_divine");
	public static ItemBase stoneEnder = new ItemBase("stone_ender");
	public static ItemBase stoneCorrupted = new ItemBase("stone_corrupted");
	public static ItemBase shadowBar = new ItemBase("ingot_shadow");
	public static ItemBase chunkNetherite = new ItemBase("chunk_netherite");
	public static ItemBase pelletsAquatic = new ItemBase("pellets_aquatic");
	public static ItemBase pelletsAquaticPure = new ItemBase("pellets_aquatic_pure");
	public static ItemBase shardIce = new ItemBase("shard_ice");
	public static ItemBase seedsGlowbonePurple = new ItemBase("seeds_glowbone_purple");
	public static SnowGlobe snowGlobe = new SnowGlobe("snowglobe");
	public static ItemBase blazePurple = new ItemBase("blaze_purple");
	public static ItemBase furyFire = new ItemBase("fury_fire");
	public static ItemBase stoneBluefire = new ItemBase("stone_bluefire");
	public static ItemBase eyeEnderLegendary = new ItemBase("eye_ender_legendary");
	public static SwordBase knifeJungle = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "knife_jungle");
	public static ItemBase eyeCyclops = new ItemBase("eye_cyclops");
	public static CannonBase liopleurodonAnchor = new CannonBase("liopleurodon_anchor");
	public static ItemBase liopleurodonSkull = new ItemBase("liopleurodon_skull");
	public static ItemBase liopleurodonTeeth = new ItemBase("liopleurodon_teeth");
	public static ItemBase stoneHealing = new ItemBase("stone_healing");
	public static ItemBase stoneTerran = new ItemBase("stone_terran");
	public static SwordBase rapierJungle = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "rapier_jungle");
	public static Shuriken shuriken = new Shuriken("shuriken", 4);
	public static Shuriken shurikenSnow = new Shuriken("shuriken_snow", 4);
	public static Vilestorm vileStorm = new Vilestorm("vilestorm");
	public static ItemBase soundMusic = new ItemBase("sound_of_music");
	public static ItemBase maelstrom = new ItemBase("maelstrom");
	public static ItemBase chunkEden = new ItemBase("chunk_eden");
	public static ItemBase chunkWildwood = new ItemBase("chunk_wildwood");
	public static ItemBase chunkApalachia = new ItemBase("chunk_apalachia");
	public static ItemBase chunkSkythern = new ItemBase("chunk_skythern");
	public static ItemBase chunkMortum = new ItemBase("chunk_mortum");
	public static CannonBase cannonGhast = new CannonBase("cannon_ghast");
	public static ItemBase snowflake = new ItemBase("snowflake");
	public static CannonBase bowheadAnchor = new CannonBase("anchor_bowhead");
	public static CannonBase sharkAnchor = new CannonBase("anchor_shark");
	public static CannonBase cannonFrost = new CannonBase("cannon_frost");
	public static CannonBase cannonBowhead = new CannonBase("cannon_bowhead");
	public static CannonBase cannonCrab = new CannonBase("cannon_crab");
	public static CannonBase cannonCorrupted = new CannonBase("cannon_corrupted");
	public static CannonBase furyGold = new CannonBase("fury_golden");
	public static HordeHorn hordeHorn = new HordeHorn("horde_horn");
	public static ItemBlockSteelDoor steelDoor = new ItemBlockSteelDoor("steel_door", ModBlocks.steelDoor);
	public static ItemBase krakenSkin = new ItemBase("kraken_skin");
	public static ItemBase krakenScale = new ItemBase("kraken_scale");
	public static ItemBase coinShadow = new ItemBase("coin_shadow");
	// public static ItemBase eggOverworld = new ItemBase("egg_overworld");
	public static ItemSpawnEgg eggGrizzle = new ItemSpawnEgg("egg_grizzle");
	public static ItemSpawnEgg eggGrizzleWhite = new ItemSpawnEgg("egg_grizzle_white");
	public static ItemBase divineAccumulator = new ItemBase("divine_accumulator");
	public static ItemBase meteorMash = new ItemBase("meteor_mash");
	public static ItemBase blasterArcanite = new ItemBase("blaster_arcanite");
	public static ItemBase bladeArcanite = new ItemBase("blade_arcana");
	public static ItemBase staffGenerals = new ItemBase("staff_generals");
	public static ItemBase arcaniumReflector = new ItemBase("arcanium_reflector");
	public static ItemBase arcaniumAttractor = new ItemBase("arcanium_attractor");
	public static ItemBase seedsEucalyptus = new ItemBase("seeds_eucalyptus");
	public static ItemBase seedsMarsine = new ItemBase("seeds_marsine");
	public static ItemBase seedsFirestock = new ItemBase("seeds_firestock");
	public static ItemBase seedsPinfly = new ItemBase("seeds_pinfly");
	public static ItemBase seedsAquamarine = new ItemBase("seeds_aquamarine");
	public static ItemBase seedsHitchak = new ItemBase("seeds_hitchak");
	public static ItemBase seedsVelio = new ItemBase("seeds_velio");
	public static ItemBase seedsLamona = new ItemBase("seeds_lamona");
	public static ItemBase enderSceptor = new ItemBase("sceptor_ender");
	public static ItemBase wraithbane = new ItemBase("wraithbane");
	public static ItemBase saberArcanium = new ItemBase("saber_arcanium");
	public static ItemBase firefly = new ItemBase("firefly");
	public static ItemBase staffStarlight = new ItemBase("staff_starlight");
	public static ItemBase meriksMissile = new ItemBase("missile_meriks");
	public static ItemBase swordLivicia = new ItemBase("sword_livicia");
	public static ItemBase lavekor = new ItemBase("lavekor");
	public static ItemBase grenade = new ItemBase("grenade");
	public static ItemBase snowslash = new ItemBase("snowslash");
	public static ItemBase collector = new ItemBase("collector");
	public static ItemBase collectorCharged = new ItemBase("collector_charged");
	public static ItemBase staffEnrichment = new ItemBase("staff_enrichment");
	public static ItemBase potionArcanaWeak = new ItemBase("potion_arcana_weak");
	public static ItemBase potionArcanaStrong = new ItemBase("potion_arcana_strong");
	public static ItemBase orbLight = new ItemBase("orb_light");
	public static ItemBase scythe = new ItemBase("scythe");
	public static ItemBase flintDream = new ItemBase("flint_dream");
	public static ItemBase maulKaros = new ItemBase("maul_karos_rock");
	public static ItemBase amuletMiners = new ItemBase("amulet_miners");
	public static ItemBase arrowTeaker = new ItemBase("arrow_teaker");
	public static ItemBase arrowDarven = new ItemBase("arrow_darven");
	public static ItemBase arrowPardimal = new ItemBase("arrow_pardimal");
	public static ItemBase arrowKaros = new ItemBase("arrow_karos");
	public static ItemBase stoneShadow = new ItemBase("stone_shadow");
	public static ItemBase frossivence = new ItemBase("frossivence");
	public static ItemBase soundCarol = new ItemBase("sound_of_carols");
	public static ItemBase maulFrozen = new ItemBase("maul_frozen");
	public static CannonBase cannonFractite = new CannonBase("cannon_fractite");
	public static SwordBase iceEnder = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "ice_ender");
	public static ItemBase eggOverworld = new ItemBase("egg_overworld");

	public static void register(IForgeRegistry<Item> registry) {
		System.out.print("DivineRPG items loading");
		registry.registerAll(amthirmisDisk, hunterBow, shadowBow, enderBow, bluefireBow, infernoBow, arcanium,
		        ingotArlemite, ingotAquatic, ingotHellstone, ingotNetherite, ingotRealmite, ingotRupee, gemApalachia,
		        gemEden, gemSkythern, gemMortum, gemWildwood, mysteriousClock, moonClock, twilightClock, acid,
		        aquamarine, aquaticBlazeRod, aquaton, arcanaSpawnEgg, amthrimisBackSword, aquatoothSword,
		        arksianeWrathSword, bedrockSword, blackEnderSword, bloodgemSword, blueDivineSword, stormSword,
		        chickenDinner, angelicHelmet, angelicChestplate, angelicLeggings, angelicBoots, apalachiaHelmet,
		        apalachiaChestplate, apalachiaLeggings, apalachiaBoots, aquastriveHelmet, aquastriveChestplate,
		        aquastriveLeggings, aquastriveBoots, bedrockHelmet, bedrockChestplate, bedrockLeggings, bedrockBoots,
		        corruptedHelmet, corruptedChestplate, corruptedLeggings, corruptedBoots, degradedHelmet,
		        degradedChestplate, degradedLeggings, degradedBoots, demonizedHelmet, demonizedChestplate,
		        demonizedLeggings, demonizedBoots, divineHelmet, divineChestplate, divineLeggings, divineBoots,
		        donatorHelmet, donatorChestplate, donatorLeggings, donatorBoots, edenHelmet, edenChestplate,
		        edenLeggings, edenBoots, enderHelmet, enderChestplate, enderLeggings, enderBoots, finishedHelmet,
		        finishedChestplate, finishedLeggings, finishedBoots, frozenHelmet, frozenChestplate, frozenLeggings,
		        frozenBoots, glisteningHelmet, glisteningChestplate, glisteningLeggings, glisteningBoots, haliteHelmet,
		        haliteChestplate, haliteLeggings, haliteBoots, infernoHelmet, infernoChestplate, infernoLeggings,
		        infernoBoots, jackomanHelmet, jackomanChestplate, jackomanLeggings, jackomanBoots, jungleHelmet,
		        jungleChestplate, jungleLeggings, jungleBoots, liopleurodonAnchor, liopleurodonSkull, liopleurodonTeeth,
		        kormaHelmet, kormaChestplate, kormaLeggings, kormaBoots, krakenHelmet, krakenChestplate, krakenLeggings,
		        krakenBoots, mortumHelmet, mortumChestplate, mortumLeggings, mortumBoots, netheriteHelmet,
		        netheriteChestplate, netheriteLeggings, netheriteBoots, realmiteHelmet, realmiteChestplate,
		        realmiteLeggings, realmiteBoots, rupeeHelmet, rupeeChestplate, rupeeLeggings, rupeeBoots, santaCap,
		        santaTunic, santaPants, santaBoots, shadowHelmet, shadowChestplate, shadowLeggings, shadowBoots,
		        skelemanHelmet, skelemanChestplate, skelemanLeggings, skelemanBoots, skythernHelmet, skythernChestplate,
		        skythernLeggings, skythernBoots, terranHelmet, terranChestplate, terranLeggings, terranBoots,
		        tormentedHelmet, tormentedChestplate, tormentedLeggings, tormentedBoots, vemosHelmet, vemosChestplate,
		        vemosLeggings, vemosBoots, wildwoodHelmet, wildwoodChestplate, wildwoodLeggings, wildwoodBoots,
		        witherreaperHelmet, witherreaperChestplate, witherreaperLeggings, witherreaperBoots, bandHeivaHunt,
		        rupeeShickaxe, arlemiteShickaxe, divineShickaxe, cannonAmthirmis, templateDisc, templateCannon,
		        templateBacksword, templateBow, templateStaff, templateClaw, templateDegraded, templateFinished,
		        templateGlistening, templateDemonized, templateTormented, soulEden, soulWild, soulApalachia,
		        soulSkythern, soulMortum, fragmentApalachia, fragmentEden, fragmentSkythern, fragmentMortum,
		        fragmentWildwood, corruptedAxe, corruptedShovel, corruptedPickaxe, pearlsDirty, pearlsClean,
		        pearlsShiny, pearlsPolished, bookWizards, lumpsTeaker, lumpsAmthirmis, lumpsDarven, lumpsCermile,
		        lumpsPardimal, lumpsQuadrotic, lumpsKaros, lumpsHeliosis, lumpsArksiane, serenadeStrike, serenadeHeal,
		        serenadeIce, serenadeDeath, serenadeInfusion, cannonTeaker, cannonAmthirmis, cannonDarven,
		        cannonCermile, cannonPardimal, cannonQuadrotic, cannonKaros, cannonHeliosis, cannonArksiane, bacon,
		        hotPumpkinPie, boiledEgg, cheese, mushroomWhite, mushroomStewAdvanced, tomato, donut, rawEmpoweredMeat,
		        empoweredMeat, magicMeat, enrichedMagicMeat, eggNog, peppermints, chocolateLog, snowCone, fruitCake,
		        winterberry, honeySuckle, honeyChunk, dreamCarrot, dreamMelon, dreamPie, dreamCake, dreamSweets,
		        dreamSours, moonbulb, glowbonePurple, glowbonePink, skyflower, hitchak, pinfly, captainsparkler,
		        teakerBackSword, amthrimisBackSword, darvenBackSword, cermileBackSword, pardimalBackSword,
		        quadroticBackSword, karosBackSword, heliosisBackSword, arksianeWrathSword, icineSword, glacierSword,
		        frostkingSword, frostSword, divineSword, divineYSword, divineGSword, divineRSword, divineGRSword,
		        sharkSword, slimeSword, infernoSword, cyclopsianSword, moltenSword, scorchingSword, bluefireSword,
		        enderSword, enderBSword, enderYSword, enderGSword, enderRSword, donatorSword, realmitePickaxe,
		        edenPickaxe, wildwoodPickaxe, apalachiaPickaxe, skythernPickaxe, mortumPickaxe, divinePickaxe,
		        arlemitePickaxe, rupeePickaxe, bedrockPickaxe, realmiteAxe, edenAxe, wildwoodAxe, apalachiaAxe,
		        skythernAxe, mortumAxe, divineAxe, arlemiteAxe, rupeeAxe, bedrockAxe, realmiteShovel, edenShovel,
		        wildwoodShovel, apalachiaShovel, skythernShovel, mortumShovel, divineShovel, arlemiteShovel,
		        rupeeShovel, bedrockShovel, arlemiteHoe, rupeeHoe, realmiteHoe, crabClaw, crabClawDual, crabClawAnchor,
		        everlight, everbright, clawTeaker, clawAmthirmis, clawDarven, clawCermile, clawPardimal, clawQuadrotic,
		        clawKaros, clawHeliosis, clawArksiane, palavence, massivence, arlemiteStabber, rupeeRapier,
		        aquaticDagger, aquaticTrident, oceanKnife, deathBringer, aquaticMaul, crabclawMaul, poisonSaber,
		        furyMaul, icicleBane, corruptedMaul, edenBlade, bedrockMaul, apalachiaBlade, mortumBlade, haliteBlade,
		        sandslash, shadowSaber, flamingFury, shardJungle, shardMolten, shardCorrupted, shardEnder, finShark,
		        finWhale, tokensDungeon, tpStaff, arrowInferno, edenSparklez, shardTerran, shardDivine,
		        eliteRealmiteHelmet, eliteRealmiteChestplate, eliteRealmiteLeggings, eliteRealmiteBoots, callWatcher,
		        eyeWatch, stoneDivine, stoneMolten, shadowBar, chunkNetherite, pelletsAquatic, pelletsAquaticPure,
		        shardIce, gemBlood, seedsGlowbonePurple, snowGlobe, stoneJungle, stoneIce, stoneCorrupted, blazePurple,
		        furyFire, stoneBluefire, eyeEnderLegendary, stoneEnder, knifeJungle, eyeCyclops, liopleurodonAnchor,
		        liopleurodonSkull, liopleurodonTeeth, stoneHealing, daggerTerran, knifeTerran, maulTerran, stoneTerran,
		        maulAquatooth, rapierJungle, shuriken, vileStorm, soundMusic, maelstrom, chunkEden, chunkWildwood,
		        chunkApalachia, chunkSkythern, chunkMortum, cannonGhast, snowflake, bowheadAnchor, sharkAnchor,
		        cannonFrost, cannonBowhead, cannonCrab, cannonCorrupted, furyGold, hordeHorn, steelDoor, krakenSkin,
		        krakenScale, coinShadow, eggGrizzle, divineAccumulator, meteorMash, blasterArcanite, bladeArcanite,
		        staffGenerals, arcaniumReflector, arcaniumAttractor, seedsEucalyptus, seedsMarsine, seedsFirestock,
		        seedsPinfly, seedsAquamarine, seedsHitchak, seedsVelio, seedsLamona, enderSceptor, wraithbane,
		        saberArcanium, firefly, staffStarlight, meriksMissile, swordLivicia, lavekor, grenade, snowslash,
		        collector, staffEnrichment, potionArcanaWeak, potionArcanaStrong, orbLight, scythe, flintDream,
		        maulKaros, amuletMiners, arrowTeaker, arrowDarven, arrowPardimal, arrowKaros, stoneShadow, shurikenSnow,
		        icicleBow, snowBow, frossivence, soundCarol, maulFrozen, cannonFractite, iceEnder, eggGrizzleWhite,
		        collectorCharged, eggOverworld);
	}

	public static void registerModels() {
		amthirmisDisk.registerItemModel();
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
		angelicHelmet.registerItemModel();
		angelicChestplate.registerItemModel();
		angelicLeggings.registerItemModel();
		angelicBoots.registerItemModel();
		apalachiaHelmet.registerItemModel();
		apalachiaChestplate.registerItemModel();
		apalachiaLeggings.registerItemModel();
		apalachiaBoots.registerItemModel();
		aquastriveHelmet.registerItemModel();
		aquastriveChestplate.registerItemModel();
		aquastriveLeggings.registerItemModel();
		aquastriveBoots.registerItemModel();
		// aquaticHelmet.registerItemModel();
		// aquaticChestplate.registerItemModel();
		// aquaticLeggings.registerItemModel();
		// aquaticBoots.registerItemModel();
		bedrockHelmet.registerItemModel();
		bedrockChestplate.registerItemModel();
		bedrockLeggings.registerItemModel();
		bedrockBoots.registerItemModel();
		corruptedHelmet.registerItemModel();
		corruptedChestplate.registerItemModel();
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
		santaCap.registerItemModel();
		santaTunic.registerItemModel();
		santaPants.registerItemModel();
		santaBoots.registerItemModel();
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
		witherreaperBoots.registerItemModel();
		bandHeivaHunt.registerItemModel();
		rupeeShickaxe.registerItemModel();
		arlemiteShickaxe.registerItemModel();
		divineShickaxe.registerItemModel();
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
		finShark.registerItemModel();
		finWhale.registerItemModel();
		tokensDungeon.registerItemModel();
		tpStaff.registerItemModel();
		arrowInferno.registerItemModel();
		edenSparklez.registerItemModel();
		shardTerran.registerItemModel();
		eliteRealmiteHelmet.registerItemModel();
		eliteRealmiteChestplate.registerItemModel();
		eliteRealmiteLeggings.registerItemModel();
		eliteRealmiteBoots.registerItemModel();
		shardDivine.registerItemModel();
		callWatcher.registerItemModel();
		eyeWatch.registerItemModel();
		stoneDivine.registerItemModel();
		stoneMolten.registerItemModel();
		shadowBar.registerItemModel();
		chunkNetherite.registerItemModel();
		pelletsAquatic.registerItemModel();
		pelletsAquaticPure.registerItemModel();
		shardIce.registerItemModel();
		gemBlood.registerItemModel();
		seedsGlowbonePurple.registerItemModel();
		snowGlobe.registerItemModel();
		stoneJungle.registerItemModel();
		stoneIce.registerItemModel();
		blazePurple.registerItemModel();
		stoneBluefire.registerItemModel();
		furyFire.registerItemModel();
		eyeEnderLegendary.registerItemModel();
		stoneEnder.registerItemModel();
		stoneCorrupted.registerItemModel();
		knifeJungle.registerItemModel();
		eyeCyclops.registerItemModel();
		liopleurodonAnchor.registerItemModel();
		liopleurodonSkull.registerItemModel();
		liopleurodonTeeth.registerItemModel();
		stoneHealing.registerItemModel();
		daggerTerran.registerItemModel();
		knifeTerran.registerItemModel();
		maulTerran.registerItemModel();
		stoneTerran.registerItemModel();
		maulAquatooth.registerItemModel();
		rapierJungle.registerItemModel();
		shuriken.registerItemModel();
		vileStorm.registerItemModel();
		soundMusic.registerItemModel();
		maelstrom.registerItemModel();
		chunkEden.registerItemModel();
		chunkWildwood.registerItemModel();
		chunkApalachia.registerItemModel();
		chunkSkythern.registerItemModel();
		chunkMortum.registerItemModel();
		cannonGhast.registerItemModel();
		bowheadAnchor.registerItemModel();
		sharkAnchor.registerItemModel();
		cannonFrost.registerItemModel();
		cannonBowhead.registerItemModel();
		cannonCrab.registerItemModel();
		cannonCorrupted.registerItemModel();
		snowflake.registerItemModel();
		furyGold.registerItemModel();
		hordeHorn.registerItemModel();
		steelDoor.registerItemModel();
		krakenSkin.registerItemModel();
		krakenScale.registerItemModel();
		coinShadow.registerItemModel();
		eggGrizzle.registerItemModel();
		divineAccumulator.registerItemModel();
		meteorMash.registerItemModel();
		blasterArcanite.registerItemModel();
		bladeArcanite.registerItemModel();
		staffGenerals.registerItemModel();
		arcaniumReflector.registerItemModel();
		arcaniumAttractor.registerItemModel();
		seedsEucalyptus.registerItemModel();
		seedsMarsine.registerItemModel();
		seedsFirestock.registerItemModel();
		seedsPinfly.registerItemModel();
		seedsAquamarine.registerItemModel();
		seedsHitchak.registerItemModel();
		seedsVelio.registerItemModel();
		seedsLamona.registerItemModel();
		enderSceptor.registerItemModel();
		wraithbane.registerItemModel();
		saberArcanium.registerItemModel();
		firefly.registerItemModel();
		staffStarlight.registerItemModel();
		meriksMissile.registerItemModel();
		swordLivicia.registerItemModel();
		lavekor.registerItemModel();
		grenade.registerItemModel();
		snowslash.registerItemModel();
		collector.registerItemModel();
		staffEnrichment.registerItemModel();
		potionArcanaWeak.registerItemModel();
		potionArcanaStrong.registerItemModel();
		orbLight.registerItemModel();
		scythe.registerItemModel();
		flintDream.registerItemModel();
		maulKaros.registerItemModel();
		amuletMiners.registerItemModel();
		arrowTeaker.registerItemModel();
		arrowDarven.registerItemModel();
		arrowPardimal.registerItemModel();
		arrowKaros.registerItemModel();
		stoneShadow.registerItemModel();
		shurikenSnow.registerItemModel();
		icicleBow.registerItemModel();
		snowBow.registerItemModel();
		frossivence.registerItemModel();
		soundCarol.registerItemModel();
		maulFrozen.registerItemModel();
		cannonFractite.registerItemModel();
		iceEnder.registerItemModel();
		eggGrizzleWhite.registerItemModel();
		collectorCharged.registerItemModel();
		eggOverworld.registerItemModel();

		if (Config.debug) {
			DivineRPG.logger.info(DivineRPG.name + " items are loaded");
		}
	}

}