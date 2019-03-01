package naturix.divinerpg.registry;

import java.util.ArrayList;
import java.util.List;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.Aquamarine;
import naturix.divinerpg.objects.items.ArmorBase;
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

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Egg base
	private static EntitySlime EntitySlime;

	// Items
	public static final Item amthirmisDisk = new ItemDisk(6, "disk_amthirmis");
	public static final Item hunterBow = new BowBase("bow_hunter");
	public static final Item shadowBow = new BowBase("bow_shadow");
	public static final Item enderBow = new BowBase("bow_ender");
	public static final Item bluefireBow = new BowBase("bow_bluefire");
	public static final Item infernoBow = new BowBase("bow_inferno");
	public static final Item icicleBow = new BowBase("bow_icicle");
	public static final Item snowBow = new BowBase("bow_snowstorm");
	public static final Item arcanium = new ItemBase("arcanium");
	public static final Item ingotArlemite = new ItemBase("ingot_arlemite");
	public static final Item ingotAquatic = new ItemBase("ingot_aquatic");
	public static final Item ingotHellstone = new ItemBase("ingot_hellstone");
	public static final Item ingotNetherite = new ItemBase("ingot_netherite");
	public static final Item ingotRealmite = new ItemBase("ingot_realmite");
	public static final Item ingotRupee = new ItemBase("ingot_rupee");
	public static final Item gemApalachia = new ItemBase("gem_apalachia");
	public static final Item gemEden = new ItemBase("gem_eden");
	public static final Item gemSkythern = new ItemBase("gem_skythern");
	public static final Item gemWildwood = new ItemBase("gem_wildwood");
	public static final Item gemMortum = new ItemBase("gem_mortum");
	public static final Item gemBlood = new ItemBase("gem_blood");
	public static final Item stoneJungle = new ItemBase("stone_jungle");
	public static final Item stoneIce = new ItemBase("stone_ice");
	public static final Item mysteriousClock = new MysteriousClock("clock_mysterious");
	public static final Item moonClock = new MysteriousClock("clock_moon");
	public static final Item twilightClock = new MysteriousClock("clock_twilight");
	public static final Item acid = new ItemBase("acid");
	public static final Item aquamarine = new Aquamarine("aquamarine");
	public static final Item aquaticBlazeRod = new ItemBase("rod_aquatic_blaze");
	public static final Item aquaton = new ItemBase("aquaton", DivineRPG.CombatTab);
	public static final Item arcanaSpawnEgg = new SpawnerBase("spawn_egg_arcana", EntitySlime);

	// Armour
	public static final Item angelicHelmet = new ArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.HEAD,
	        "angelic_helmet");
	public static final Item angelicChestplate = new ArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.CHEST,
	        "angelic_chestplate");
	public static final Item angelicLeggings = new ArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.LEGS,
	        "angelic_leggings");
	public static final Item angelicBoots = new ArmorBase(EnumArmor.ANGELIC, EntityEquipmentSlot.FEET, "angelic_boots");
	public static final Item apalachiaHelmet = new ArmorBase(EnumArmor.apalachiaArmorMaterial, EntityEquipmentSlot.HEAD,
	        "apalachia_helmet");
	public static final Item apalachiaChestplate = new ArmorBase(EnumArmor.apalachiaArmorMaterial,
	        EntityEquipmentSlot.CHEST, "apalachia_chestplate");
	public static final Item apalachiaLeggings = new ArmorBase(EnumArmor.apalachiaArmorMaterial,
	        EntityEquipmentSlot.LEGS, "apalachia_leggings");
	public static final Item apalachiaBoots = new ArmorBase(EnumArmor.apalachiaArmorMaterial, EntityEquipmentSlot.FEET,
	        "apalachia_boots");
	public static final Item aquastriveHelmet = new ArmorBase(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.HEAD, "aquastrive_helmet");
	public static final Item aquastriveChestplate = new ArmorBase(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.CHEST, "aquastrive_chestplate");
	public static final Item aquastriveLeggings = new ArmorBase(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.LEGS, "aquastrive_leggings");
	public static final Item aquastriveBoots = new ArmorBase(EnumArmor.aquastriveArmorMaterial,
	        EntityEquipmentSlot.FEET, "aquastrive_boots");
	public static final Item bedrockHelmet = new ArmorBase(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.HEAD,
	        "bedrock_helmet");
	public static final Item bedrockChestplate = new ArmorBase(EnumArmor.bedrockArmorMaterial,
	        EntityEquipmentSlot.CHEST, "bedrock_chestplate");
	public static final Item bedrockLeggings = new ArmorBase(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.LEGS,
	        "bedrock_leggings");
	public static final Item bedrockBoots = new ArmorBase(EnumArmor.bedrockArmorMaterial, EntityEquipmentSlot.FEET,
	        "bedrock_boots");
	public static final Item corruptedHelmet = new ArmorBase(EnumArmor.corruptedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "corrupted_helmet");
	public static final Item corruptedChestplate = new ArmorBase(EnumArmor.corruptedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "corrupted_chestplate");
	public static final Item corruptedLeggings = new ArmorBase(EnumArmor.corruptedArmorMaterial,
	        EntityEquipmentSlot.LEGS, "corrupted_leggings");
	public static final Item corruptedBoots = new ArmorBase(EnumArmor.corruptedArmorMaterial, EntityEquipmentSlot.FEET,
	        "corrupted_boots");
	public static final Item degradedHelmet = new ArmorBase(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "degraded_helmet");
	public static final Item degradedChestplate = new ArmorBase(EnumArmor.degradedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "degraded_chestplate");
	public static final Item degradedLeggings = new ArmorBase(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.LEGS,
	        "degraded_leggings");
	public static final Item degradedBoots = new ArmorBase(EnumArmor.degradedArmorMaterial, EntityEquipmentSlot.FEET,
	        "degraded_boots");
	public static final Item demonizedHelmet = new ArmorBase(EnumArmor.demonizedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "demonized_helmet");
	public static final Item demonizedChestplate = new ArmorBase(EnumArmor.demonizedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "demonized_chestplate");
	public static final Item demonizedLeggings = new ArmorBase(EnumArmor.demonizedArmorMaterial,
	        EntityEquipmentSlot.LEGS, "demonized_leggings");
	public static final Item demonizedBoots = new ArmorBase(EnumArmor.demonizedArmorMaterial, EntityEquipmentSlot.FEET,
	        "demonized_boots");
	public static final Item divineHelmet = new ArmorBase(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.HEAD,
	        "divine_helmet");
	public static final Item divineChestplate = new ArmorBase(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.CHEST,
	        "divine_chestplate");
	public static final Item divineLeggings = new ArmorBase(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.LEGS,
	        "divine_leggings");
	public static final Item divineBoots = new ArmorBase(EnumArmor.divineArmorMaterial, EntityEquipmentSlot.FEET,
	        "divine_boots");
	public static final Item donatorHelmet = new ArmorBase(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.HEAD,
	        "donator_helmet");
	public static final Item donatorChestplate = new ArmorBase(EnumArmor.donatorArmorMaterial,
	        EntityEquipmentSlot.CHEST, "donator_chestplate");
	public static final Item donatorLeggings = new ArmorBase(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.LEGS,
	        "donator_leggings");
	public static final Item donatorBoots = new ArmorBase(EnumArmor.donatorArmorMaterial, EntityEquipmentSlot.FEET,
	        "donator_boots");
	public static final Item edenHelmet = new ArmorBase(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.HEAD,
	        "eden_helmet");
	public static final Item edenChestplate = new ArmorBase(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.CHEST,
	        "eden_chestplate");
	public static final Item edenLeggings = new ArmorBase(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.LEGS,
	        "eden_leggings");
	public static final Item edenBoots = new ArmorBase(EnumArmor.edenArmorMaterial, EntityEquipmentSlot.FEET,
	        "eden_boots");
	public static final Item eliteRealmiteHelmet = new ArmorBase(EnumArmor.realmiteArmorMaterial,
	        EntityEquipmentSlot.HEAD, "realmite_helmet_elite");
	public static final Item eliteRealmiteChestplate = new ArmorBase(EnumArmor.realmiteArmorMaterial,
	        EntityEquipmentSlot.CHEST, "realmite_chestplate_elite");
	public static final Item eliteRealmiteLeggings = new ArmorBase(EnumArmor.realmiteArmorMaterial,
	        EntityEquipmentSlot.LEGS, "realmite_leggings_elite");
	public static final Item eliteRealmiteBoots = new ArmorBase(EnumArmor.realmiteArmorMaterial,
	        EntityEquipmentSlot.FEET, "realmite_boots_elite");
	public static final Item enderHelmet = new ArmorBase(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.HEAD,
	        "ender_helmet");
	public static final Item enderChestplate = new ArmorBase(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.CHEST,
	        "ender_chestplate");
	public static final Item enderLeggings = new ArmorBase(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.LEGS,
	        "ender_leggings");
	public static final Item enderBoots = new ArmorBase(EnumArmor.enderArmorMaterial, EntityEquipmentSlot.FEET,
	        "ender_boots");
	public static final Item finishedHelmet = new ArmorBase(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "finished_helmet");
	public static final Item finishedChestplate = new ArmorBase(EnumArmor.finishedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "finished_chestplate");
	public static final Item finishedLeggings = new ArmorBase(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.LEGS,
	        "finished_leggings");
	public static final Item finishedBoots = new ArmorBase(EnumArmor.finishedArmorMaterial, EntityEquipmentSlot.FEET,
	        "finished_boots");
	public static final Item frozenHelmet = new ArmorBase(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.HEAD,
	        "frozen_helmet");
	public static final Item frozenChestplate = new ArmorBase(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.CHEST,
	        "frozen_chestplate");
	public static final Item frozenLeggings = new ArmorBase(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.LEGS,
	        "frozen_leggings");
	public static final Item frozenBoots = new ArmorBase(EnumArmor.frozenArmorMaterial, EntityEquipmentSlot.FEET,
	        "frozen_boots");
	public static final Item glisteningHelmet = new ArmorBase(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.HEAD, "glistening_helmet");
	public static final Item glisteningChestplate = new ArmorBase(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.CHEST, "glistening_chestplate");
	public static final Item glisteningLeggings = new ArmorBase(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.LEGS, "glistening_leggings");
	public static final Item glisteningBoots = new ArmorBase(EnumArmor.glisteningArmorMaterial,
	        EntityEquipmentSlot.FEET, "glistening_boots");
	public static final Item haliteHelmet = new ArmorBase(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.HEAD,
	        "halite_helmet");
	public static final Item haliteChestplate = new ArmorBase(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.CHEST,
	        "halite_chestplate");
	public static final Item haliteLeggings = new ArmorBase(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.LEGS,
	        "halite_leggings");
	public static final Item haliteBoots = new ArmorBase(EnumArmor.haliteArmorMaterial, EntityEquipmentSlot.FEET,
	        "halite_boots");
	public static final Item infernoHelmet = new ArmorBase(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.HEAD,
	        "inferno_helmet");
	public static final Item infernoChestplate = new ArmorBase(EnumArmor.infernoArmorMaterial,
	        EntityEquipmentSlot.CHEST, "inferno_chestplate");
	public static final Item infernoLeggings = new ArmorBase(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.LEGS,
	        "inferno_leggings");
	public static final Item infernoBoots = new ArmorBase(EnumArmor.infernoArmorMaterial, EntityEquipmentSlot.FEET,
	        "inferno_boots");
	public static final Item jackomanHelmet = new ArmorBase(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.HEAD,
	        "jackoman_helmet");
	public static final Item jackomanChestplate = new ArmorBase(EnumArmor.jackomanArmorMaterial,
	        EntityEquipmentSlot.CHEST, "jackoman_chestplate");
	public static final Item jackomanLeggings = new ArmorBase(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.LEGS,
	        "jackoman_leggings");
	public static final Item jackomanBoots = new ArmorBase(EnumArmor.jackomanArmorMaterial, EntityEquipmentSlot.FEET,
	        "jackoman_boots");
	public static final Item jungleHelmet = new ArmorBase(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.HEAD,
	        "jungle_helmet");
	public static final Item jungleChestplate = new ArmorBase(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.CHEST,
	        "jungle_chestplate");
	public static final Item jungleLeggings = new ArmorBase(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.LEGS,
	        "jungle_leggings");
	public static final Item jungleBoots = new ArmorBase(EnumArmor.jungleArmorMaterial, EntityEquipmentSlot.FEET,
	        "jungle_boots");
	public static final Item kormaHelmet = new ArmorBase(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.HEAD,
	        "korma_helmet");
	public static final Item kormaChestplate = new ArmorBase(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.CHEST,
	        "korma_chestplate");
	public static final Item kormaLeggings = new ArmorBase(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.LEGS,
	        "korma_leggings");
	public static final Item kormaBoots = new ArmorBase(EnumArmor.kormaArmorMaterial, EntityEquipmentSlot.FEET,
	        "korma_boots");
	public static final Item krakenHelmet = new ArmorBase(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.HEAD,
	        "kraken_helmet");
	public static final Item krakenChestplate = new ArmorBase(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.CHEST,
	        "kraken_chestplate");
	public static final Item krakenLeggings = new ArmorBase(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.LEGS,
	        "kraken_leggings");
	public static final Item krakenBoots = new ArmorBase(EnumArmor.krakenArmorMaterial, EntityEquipmentSlot.FEET,
	        "kraken_boots");
	public static final Item mortumHelmet = new ArmorBase(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.HEAD,
	        "mortum_helmet");
	public static final Item mortumChestplate = new ArmorBase(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.CHEST,
	        "mortum_chestplate");
	public static final Item mortumLeggings = new ArmorBase(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.LEGS,
	        "mortum_leggings");
	public static final Item mortumBoots = new ArmorBase(EnumArmor.mortumArmorMaterial, EntityEquipmentSlot.FEET,
	        "mortum_boots");
	public static final Item netheriteHelmet = new ArmorBase(EnumArmor.netheriteArmorMaterial, EntityEquipmentSlot.HEAD,
	        "netherite_helmet");
	public static final Item netheriteChestplate = new ArmorBase(EnumArmor.netheriteArmorMaterial,
	        EntityEquipmentSlot.CHEST, "netherite_chestplate");
	public static final Item netheriteLeggings = new ArmorBase(EnumArmor.netheriteArmorMaterial,
	        EntityEquipmentSlot.LEGS, "netherite_leggings");
	public static final Item netheriteBoots = new ArmorBase(EnumArmor.netheriteArmorMaterial, EntityEquipmentSlot.FEET,
	        "netherite_boots");
	public static final Item realmiteHelmet = new ArmorBase(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.HEAD,
	        "realmite_helmet");
	public static final Item realmiteChestplate = new ArmorBase(EnumArmor.realmiteArmorMaterial,
	        EntityEquipmentSlot.CHEST, "realmite_chestplate");
	public static final Item realmiteLeggings = new ArmorBase(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.LEGS,
	        "realmite_leggings");
	public static final Item realmiteBoots = new ArmorBase(EnumArmor.realmiteArmorMaterial, EntityEquipmentSlot.FEET,
	        "realmite_boots");
	public static final Item rupeeHelmet = new ArmorBase(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.HEAD,
	        "rupee_helmet");
	public static final Item rupeeChestplate = new ArmorBase(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.CHEST,
	        "rupee_chestplate");
	public static final Item rupeeLeggings = new ArmorBase(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.LEGS,
	        "rupee_leggings");
	public static final Item rupeeBoots = new ArmorBase(EnumArmor.rupeeArmorMaterial, EntityEquipmentSlot.FEET,
	        "rupee_boots");
	public static final Item santaCap = new ArmorBase(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.HEAD,
	        "santa_cap");
	public static final Item santaTunic = new ArmorBase(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.CHEST,
	        "santa_tunic");
	public static final Item santaPants = new ArmorBase(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.LEGS,
	        "santa_pants");
	public static final Item santaBoots = new ArmorBase(EnumArmor.santaArmorMaterial, EntityEquipmentSlot.FEET,
	        "santa_boots");
	public static final Item shadowHelmet = new ArmorBase(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.HEAD,
	        "shadow_helmet");
	public static final Item shadowChestplate = new ArmorBase(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.CHEST,
	        "shadow_chestplate");
	public static final Item shadowLeggings = new ArmorBase(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.LEGS,
	        "shadow_leggings");
	public static final Item shadowBoots = new ArmorBase(EnumArmor.shadowArmorMaterial, EntityEquipmentSlot.FEET,
	        "shadow_boots");
	public static final Item skelemanHelmet = new ArmorBase(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.HEAD,
	        "skeleman_helmet");
	public static final Item skelemanChestplate = new ArmorBase(EnumArmor.skelemanArmorMaterial,
	        EntityEquipmentSlot.CHEST, "skeleman_chestplate");
	public static final Item skelemanLeggings = new ArmorBase(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.LEGS,
	        "skeleman_leggings");
	public static final Item skelemanBoots = new ArmorBase(EnumArmor.skelemanArmorMaterial, EntityEquipmentSlot.FEET,
	        "skeleman_boots");
	public static final Item skythernHelmet = new ArmorBase(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.HEAD,
	        "skythern_helmet");
	public static final Item skythernChestplate = new ArmorBase(EnumArmor.skythernArmorMaterial,
	        EntityEquipmentSlot.CHEST, "skythern_chestplate");
	public static final Item skythernLeggings = new ArmorBase(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.LEGS,
	        "skythern_leggings");
	public static final Item skythernBoots = new ArmorBase(EnumArmor.skythernArmorMaterial, EntityEquipmentSlot.FEET,
	        "skythern_boots");
	public static final Item terranHelmet = new ArmorBase(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.HEAD,
	        "terran_helmet");
	public static final Item terranChestplate = new ArmorBase(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.CHEST,
	        "terran_chestplate");
	public static final Item terranLeggings = new ArmorBase(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.LEGS,
	        "terran_leggings");
	public static final Item terranBoots = new ArmorBase(EnumArmor.terranArmorMaterial, EntityEquipmentSlot.FEET,
	        "terran_boots");
	public static final Item tormentedHelmet = new ArmorBase(EnumArmor.tormentedArmorMaterial, EntityEquipmentSlot.HEAD,
	        "tormented_helmet");
	public static final Item tormentedChestplate = new ArmorBase(EnumArmor.tormentedArmorMaterial,
	        EntityEquipmentSlot.CHEST, "tormented_chestplate");
	public static final Item tormentedLeggings = new ArmorBase(EnumArmor.tormentedArmorMaterial,
	        EntityEquipmentSlot.LEGS, "tormented_leggings");
	public static final Item tormentedBoots = new ArmorBase(EnumArmor.tormentedArmorMaterial, EntityEquipmentSlot.FEET,
	        "tormented_boots");
	public static final Item vemosHelmet = new ArmorBase(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.HEAD,
	        "vemos_helmet");
	public static final Item vemosChestplate = new ArmorBase(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.CHEST,
	        "vemos_chestplate");
	public static final Item vemosLeggings = new ArmorBase(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.LEGS,
	        "vemos_leggings");
	public static final Item vemosBoots = new ArmorBase(EnumArmor.vemosArmorMaterial, EntityEquipmentSlot.FEET,
	        "vemos_boots");
	public static final Item wildwoodHelmet = new ArmorBase(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.HEAD,
	        "wildwood_helmet");
	public static final Item wildwoodChestplate = new ArmorBase(EnumArmor.wildwoodArmorMaterial,
	        EntityEquipmentSlot.CHEST, "wildwood_chestplate");
	public static final Item wildwoodLeggings = new ArmorBase(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.LEGS,
	        "wildwood_leggings");
	public static final Item wildwoodBoots = new ArmorBase(EnumArmor.wildwoodArmorMaterial, EntityEquipmentSlot.FEET,
	        "wildwood_boots");
	public static final Item witherreaperHelmet = new ArmorBase(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.HEAD, "wither_reaper_helmet");
	public static final Item witherreaperChestplate = new ArmorBase(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.CHEST, "wither_reaper_chestplate");
	public static final Item witherreaperLeggings = new ArmorBase(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.LEGS, "wither_reaper_leggings");
	public static final Item witherreaperBoots = new ArmorBase(EnumArmor.witherreaperArmorMaterial,
	        EntityEquipmentSlot.FEET, "wither_reaper_boots");

	// tools
	public static final Item bandHeivaHunt = new ItemBase("band_heiva_hunt");
	public static final Item templateDisc = new ItemBase("template_disc");
	public static final Item templateCannon = new ItemBase("template_cannon");
	public static final Item templateBacksword = new ItemBase("template_backsword");
	public static final Item templateBow = new ItemBase("template_bow");
	public static final Item templateStaff = new ItemBase("template_staff");
	public static final Item templateClaw = new ItemBase("template_claw");
	public static final Item templateDegraded = new ItemBase("template_degraded");
	public static final Item templateFinished = new ItemBase("template_finished");
	public static final Item templateGlistening = new ItemBase("template_glistening");
	public static final Item templateDemonized = new ItemBase("template_demonized");
	public static final Item templateTormented = new ItemBase("template_tormented");
	public static final Item soulEden = new ItemBase("soul_eden");
	public static final Item soulWild = new ItemBase("soul_wildwood");
	public static final Item soulApalachia = new ItemBase("soul_apalachia");
	public static final Item soulSkythern = new ItemBase("soul_skythern");
	public static final Item soulMortum = new ItemBase("soul_mortum");
	public static final Item fragmentApalachia = new ItemBase("fragment_apalachia");
	public static final Item fragmentEden = new ItemBase("fragment_eden");
	public static final Item fragmentSkythern = new ItemBase("fragment_skythern");
	public static final Item fragmentWildwood = new ItemBase("fragment_wildwood");
	public static final Item fragmentMortum = new ItemBase("fragment_mortum");
	public static final Item corruptedAxe = new AxeBase(DivineRPGMaterials.corruptedAxeMaterial, "axe_corrupted");
	public static final Item corruptedShovel = new ShovelBase(DivineRPGMaterials.corruptedShovelMaterial,
	        "shovel_corrupted");
	public static final Item corruptedPickaxe = new PickaxeBase(DivineRPGMaterials.corruptedPickMaterial,
	        "pickaxe_corrupted", 18F, 1F);
	public static final Item pearlsDirty = new ItemBase("pearls_dirty");
	public static final Item pearlsClean = new ItemBase("pearls_clean");
	public static final Item pearlsShiny = new ItemBase("pearls_shiny");
	public static final Item pearlsPolished = new ItemBase("pearls_polished");
	public static final Item bookWizards = new BookBase("book_wizards");
	public static final Item lumpsTeaker = new ItemBase("lumps_teaker");
	public static final Item lumpsAmthirmis = new ItemBase("lumps_amthirmis");
	public static final Item lumpsDarven = new ItemBase("lumps_darven");
	public static final Item lumpsCermile = new ItemBase("lumps_cermile");
	public static final Item lumpsPardimal = new ItemBase("lumps_pardimal");
	public static final Item lumpsQuadrotic = new ItemBase("lumps_quadrotic");
	public static final Item lumpsKaros = new ItemBase("lumps_karos");
	public static final Item lumpsHeliosis = new ItemBase("lumps_heliosis");
	public static final Item lumpsArksiane = new ItemBase("lumps_arksiane");
	public static final Item serenadeStrike = new SerenadeStrike("serenade_striker");
	public static final Item serenadeHeal = new SerenadeHeal("serenade_heal");
	public static final Item serenadeIce = new SerenadeIce("serenade_ice");
	public static final Item serenadeDeath = new SerenadeDeath("serenade_death");
	public static final Item serenadeInfusion = new SerenadeInfusion("serenade_infusion");
	public static final Item cannonTeaker = new CannonBase("cannon_teaker");
	public static final Item cannonAmthirmis = new CannonBase("cannon_amthirmis");
	public static final Item cannonDarven = new CannonBase("cannon_darven");
	public static final Item cannonCermile = new CannonBase("cannon_cermile");
	public static final Item cannonPardimal = new CannonBase("cannon_pardimal");
	public static final Item cannonQuadrotic = new CannonBase("cannon_quadrotic");
	public static final Item cannonKaros = new CannonBase("cannon_karos");
	public static final Item cannonHeliosis = new CannonBase("cannon_heliosis");
	public static final Item cannonArksiane = new CannonBase("cannon_arksiane");

	// food
	public static final Item chickenDinner = new FoodBase("winner_winner", 18, false, true);
	public static final Item bacon = new FoodBase("bacon", 3, true, true);
	public static final Item hotPumpkinPie = new FoodBase("pie_pumpkin_hot", 7, true);
	public static final Item boiledEgg = new FoodBase("egg_boiled", 1, false);
	public static final Item cheese = new FoodBase("cheese", 1, false);
	public static final Item mushroomWhite = new FoodBase("mushroom_white", 1, false);
	public static final Item mushroomStewAdvanced = new ReturnsBowl("mushroom_stew", 10, false);
	public static final Item tomato = new FoodBase("tomato", 2, false);
	public static final Item donut = new FoodBase("donut", 18, false);
	public static final Item rawEmpoweredMeat = new FoodBase("meat_empowered_raw", 2, true, true);
	public static final Item empoweredMeat = new FoodBase("meat_empowered", 4, true, true);
	public static final Item magicMeat = new FoodBase("meat_magic", 1, true, true);
	public static final Item enrichedMagicMeat = new FoodBase("meat_magic_enriched", 2, true, true);
	public static final Item eggNog = new ReturnBucket("egg_nog", 5, false);
	public static final Item peppermints = new FoodBase("peppermints", 1, false);
	public static final Item chocolateLog = new FoodBase("chocolate_log", 1, false);
	public static final Item snowCone = new FoodBase("snowcone", 1, false);
	public static final Item fruitCake = new FoodBase("cake_fruit", 2, false);
	public static final Item winterberry = new FoodBase("winterberry", 1, false);
	public static final Item honeySuckle = new FoodBase("honeysuckle", 1, false);
	public static final Item honeyChunk = new FoodBase("honeychunk", 1, false);
	public static final Item dreamCarrot = new FoodBase("carrot_dream", 2, false);
	public static final Item dreamMelon = new FoodBase("melon_dream", 2, false);
	public static final Item dreamPie = new FoodBase("pie_dream", 4, false);
	public static final Item dreamCake = new FoodBase("cake_dream", 8, false);
	public static final Item dreamSweets = new FoodBase("sweets_dream", 1, false);
	public static final Item dreamSours = new FoodBase("sour_dream", 1, false);
	public static final Item moonbulb = new FoodBase("moonbulb", 3, false);
	public static final Item glowbonePurple = new FoodBase("glowbone_purple", 5, false);
	public static final Item glowbonePink = new FoodBase("glowbone_pink", 5, false);
	public static final Item skyflower = new FoodBase("skyflower", 1, false);
	public static final Item hitchak = new FoodBase("hitchak", 3, false);
	public static final Item pinfly = new FoodBase("pinfly", 1, false);
	public static final Item captainsparkler = new ItemCaptainsSparkler("captainsparkler");

	// Stuff to be sorted
	public static final Item teakerBackSword = new SwordBase(DivineRPGMaterials.teakerSwordMaterial,
	        "sword_teaker_back");
	public static final Item amthrimisBackSword = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial,
	        "sword_amthirmis_back");
	public static final Item darvenBackSword = new SwordBase(DivineRPGMaterials.darvenSwordMaterial,
	        "sword_darven_back");
	public static final Item cermileBackSword = new SwordBase(DivineRPGMaterials.cermileSwordMaterial,
	        "sword_cermile_back");
	public static final Item pardimalBackSword = new SwordBase(DivineRPGMaterials.pardimalSwordMaterial,
	        "sword_pardimal_back");
	public static final Item quadroticBackSword = new SwordBase(DivineRPGMaterials.quadroticSwordMaterial,
	        "sword_quadrotic_back");
	public static final Item karosBackSword = new SwordBase(DivineRPGMaterials.karosSwordMaterial, "sword_karos_back");
	public static final Item heliosisBackSword = new SwordBase(DivineRPGMaterials.heliosisSwordMaterial,
	        "sword_heliosis_back");
	public static final Item arksianeWrathSword = new SwordBase(DivineRPGMaterials.arksianeSwordMaterial,
	        "sword_arksiane_wrath");
	public static final Item icineSword = new SwordBase(DivineRPGMaterials.icineSwordMaterial, "sword_icine");
	public static final Item glacierSword = new SwordBase(DivineRPGMaterials.glacierSwordMaterial, "sword_glacier");
	public static final Item frostkingSword = new SwordBase(DivineRPGMaterials.frostKingSwordMaterial,
	        "sword_frostking");
	public static final Item frostSword = new SwordBase(DivineRPGMaterials.realmiteSwordMaterial, "sword_realmite");
	public static final Item divineSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine");
	public static final Item divineYSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial,
	        "sword_divine_yellow");
	public static final Item divineGSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_grey");
	public static final Item divineRSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial, "sword_divine_red");
	public static final Item divineGRSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial,
	        "sword_divine_green");
	public static final Item sharkSword = new SwordBase(DivineRPGMaterials.sharkSwordMaterial, "sword_shark");
	public static final Item slimeSword = new SwordBase(DivineRPGMaterials.slimeSwordMaterial, "sword_slime");
	public static final Item infernoSword = new SwordBase(DivineRPGMaterials.infernoSwordMaterial, "sword_inferno");
	public static final Item cyclopsianSword = new SwordBase(DivineRPGMaterials.cyclopsianSwordMaterial,
	        "sword_cyclopsian");
	public static final Item moltenSword = new SwordBase(DivineRPGMaterials.moltenSwordMaterial, "sword_molten");
	public static final Item scorchingSword = new SwordBase(DivineRPGMaterials.scorchingSwordMaterial,
	        "sword_scorching");
	public static final Item bluefireSword = new SwordBase(DivineRPGMaterials.bluefireSwordMaterial, "sword_bluefire");
	public static final Item enderSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender");
	public static final Item enderBSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_blue");
	public static final Item enderYSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_yellow");
	public static final Item enderGSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_green");
	public static final Item enderRSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "sword_ender_red");
	public static final Item aquatoothSword = new SwordBase(DivineRPGMaterials.aquatoothSwordMaterial,
	        "sword_aquatooth");
	public static final Item bedrockSword = new SwordBase(DivineRPGMaterials.bedrockSwordMaterial, "sword_bedrock");
	public static final Item blackEnderSword = new SwordBase(DivineRPGMaterials.enderSwordMaterial,
	        "sword_black_ender");
	public static final Item bloodgemSword = new SwordBase(DivineRPGMaterials.bloodgemSwordMaterial, "sword_bloodgem");
	public static final Item blueDivineSword = new SwordBase(DivineRPGMaterials.divineSwordMaterial,
	        "sword_blue_divine");
	public static final Item stormSword = new SwordBase(DivineRPGMaterials.stormSwordMaterial, "sword_storm");
	public static final Item donatorSword = new SwordBase(DivineRPGMaterials.realmiteSwordMaterial, "sword_donator");
	public static final Item realmitePickaxe = new PickaxeBase(DivineRPGMaterials.realmitePickMaterial,
	        "pickaxe_realmite", 0, 0);
	public static final Item edenPickaxe = new PickaxeBase(DivineRPGMaterials.edenPickMaterial, "pickaxe_eden", 0, 0);
	public static final Item wildwoodPickaxe = new PickaxeBase(DivineRPGMaterials.wildPickMaterial, "pickaxe_wildwood",
	        0, 0);
	public static final Item apalachiaPickaxe = new PickaxeBase(DivineRPGMaterials.apalachiaPickMaterial,
	        "pickaxe_apalachia", 0, 0);
	public static final Item skythernPickaxe = new PickaxeBase(DivineRPGMaterials.skythernPickMaterial,
	        "pickaxe_skythern", 0, 0);
	public static final Item mortumPickaxe = new PickaxeBase(DivineRPGMaterials.mortumPickMaterial, "pickaxe_mortum", 0,
	        0);
	public static final Item divinePickaxe = new PickaxeBase(DivineRPGMaterials.divinePickMaterial, "pickaxe_divine", 0,
	        0);
	public static final Item arlemitePickaxe = new PickaxeBase(DivineRPGMaterials.arlemitePickMaterial,
	        "pickaxe_arlemite", 0, 0);
	public static final Item rupeePickaxe = new PickaxeBase(DivineRPGMaterials.rupeePickMaterial, "pickaxe_rupee", 0,
	        0);
	public static final Item bedrockPickaxe = new PickaxeBase(DivineRPGMaterials.bedrockPickMaterial, "pickaxe_bedrock",
	        0, 0);
	public static final Item realmiteAxe = new AxeBase(DivineRPGMaterials.realmiteAxeMaterial, "axe_realmite");
	public static final Item edenAxe = new AxeBase(DivineRPGMaterials.edenAxeMaterial, "axe_eden");
	public static final Item wildwoodAxe = new AxeBase(DivineRPGMaterials.wildAxeMaterial, "axe_wildwood");
	public static final Item apalachiaAxe = new AxeBase(DivineRPGMaterials.apalachiaAxeMaterial, "axe_apalachia");
	public static final Item skythernAxe = new AxeBase(DivineRPGMaterials.skythernAxeMaterial, "axe_skythern");
	public static final Item mortumAxe = new AxeBase(DivineRPGMaterials.mortumAxeMaterial, "axe_mortum");
	public static final Item divineAxe = new AxeBase(DivineRPGMaterials.divineAxeMaterial, "axe_divine");
	public static final Item arlemiteAxe = new AxeBase(DivineRPGMaterials.arlemiteAxeMaterial, "axe_arlemite");
	public static final Item rupeeAxe = new AxeBase(DivineRPGMaterials.rupeeAxeMaterial, "axe_rupee");
	public static final Item bedrockAxe = new AxeBase(DivineRPGMaterials.bedrockAxeMaterial, "axe_bedrock");
	public static final Item realmiteShovel = new ShovelBase(DivineRPGMaterials.realmiteShovelMaterial,
	        "shovel_realmite");
	public static final Item edenShovel = new ShovelBase(DivineRPGMaterials.edenShovelMaterial, "shovel_eden");
	public static final Item wildwoodShovel = new ShovelBase(DivineRPGMaterials.wildShovelMaterial, "shovel_wildwood");
	public static final Item apalachiaShovel = new ShovelBase(DivineRPGMaterials.apalachiaShovelMaterial,
	        "shovel_apalachia");
	public static final Item skythernShovel = new ShovelBase(DivineRPGMaterials.skythernShovelMaterial,
	        "shovel_skythern");
	public static final Item mortumShovel = new ShovelBase(DivineRPGMaterials.mortumShovelMaterial, "shovel_mortum");
	public static final Item divineShovel = new ShovelBase(DivineRPGMaterials.divineShovelMaterial, "shovel_divine");
	public static final Item arlemiteShovel = new ShovelBase(DivineRPGMaterials.arlemiteShovelMaterial,
	        "shovel_arlemite");
	public static final Item rupeeShovel = new ShovelBase(DivineRPGMaterials.rupeeShovelMaterial, "shovel_rupee");
	public static final Item bedrockShovel = new ShovelBase(DivineRPGMaterials.bedrockShovelMaterial, "shovel_bedrock");

	public static final Item arlemiteHoe = new HoeBase(DivineRPGMaterials.arlemiteHoeMaterial, "hoe_arlemite");
	public static final Item rupeeHoe = new HoeBase(DivineRPGMaterials.rupeeHoeMaterial, "hoe_rupee");
	public static final Item realmiteHoe = new HoeBase(DivineRPGMaterials.realmiteHoeMaterial, "hoe_realmite");
	public static final Item rupeeShickaxe = new ShickaxeBase(DivineRPGMaterials.rupeeShickaxeMaterial,
	        "shickaxe_rupee");
	public static final Item arlemiteShickaxe = new ShickaxeBase(DivineRPGMaterials.arlemiteShickaxeMaterial,
	        "shickaxe_arlemite");
	public static final Item divineShickaxe = new ShickaxeBase(DivineRPGMaterials.divineShickaxeMaterial,
	        "shickaxe_divine");
	public static final Item crabClaw = new ItemBase("claw_crab");
	public static final Item crabClawDual = new SwordBase(DivineRPGMaterials.amthrimisSwordMaterial, "claw_crab_dual");
	public static final Item crabClawAnchor = new CannonBase("anchor_claw_crab");
	public static final Item everlight = new SwordBase(DivineRPGMaterials.everlightSwordMaterial, "everlight");
	public static final Item everbright = new SwordBase(DivineRPGMaterials.everbrightSwordMaterial, "everbright");
	public static final Item clawTeaker = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_teaker", true);
	public static final Item clawAmthirmis = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_amthirmis",
	        true);
	public static final Item clawDarven = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_darven", true);
	public static final Item clawCermile = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_cermile",
	        true);
	public static final Item clawPardimal = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_pardimal",
	        true);
	public static final Item clawQuadrotic = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_quadrotic",
	        true);
	public static final Item clawKaros = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_karos", true);
	public static final Item clawHeliosis = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_heliosis",
	        true);
	public static final Item clawArksiane = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "claw_arksiane",
	        true);
	public static final Item palavence = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "palavence");
	public static final Item massivence = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "massivence");
	public static final Item arlemiteStabber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial,
	        "stabber_arlemite");
	public static final Item rupeeRapier = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "rapier_rupee");
	public static final Item aquaticDagger = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "dagger_aquatic");
	public static final Item aquaticTrident = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial,
	        "trident_aquatic");
	public static final Item oceanKnife = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "knife_ocean");
	public static final Item deathBringer = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "deathbringer");
	public static final Item aquaticMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_aquatic");
	public static final Item crabclawMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_claw_crab");
	public static final Item poisonSaber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "saber_poison");
	public static final Item furyMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_fury");
	public static final Item icicleBane = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "icicle_bane");
	public static final Item corruptedMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_corrupted");
	public static final Item edenBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_eden");
	public static final Item bedrockMaul = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_bedrock");
	public static final Item apalachiaBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial,
	        "blade_apalachia");
	public static final Item mortumBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_mortum");
	public static final Item haliteBlade = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "blade_halite");
	public static final Item sandslash = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "sandslash");
	public static final Item shadowSaber = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "saber_shadow");
	public static final Item flamingFury = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "flamingfury");
	public static final Item daggerTerran = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "dagger_terran");
	public static final Item knifeTerran = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "knife_terran");
	public static final Item maulTerran = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_terran");
	public static final Item maulAquatooth = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "maul_aquatooth");
	public static final Item shardJungle = new ItemBase("shard_jungle");
	public static final Item shardMolten = new ItemBase("shard_molten");
	public static final Item shardCorrupted = new ItemBase("shard_corrupted");
	public static final Item shardEnder = new ItemBase("shard_ender");
	public static final Item shardTerran = new ItemBase("shard_terran");
	public static final Item shardDivine = new ItemBase("shard_divine");
	public static final Item finShark = new ItemBase("fin_shark");
	public static final Item finWhale = new ItemBase("fin_whale");
	public static final Item tokensDungeon = new ItemBase("tokens_dungeon");
	public static final Item tpStaff = new TeleportStaff("teleportation_crystal");
	public static final Item arrowInferno = new InfernoArrow("arrow_inferno");
	public static final Item edenSparklez = new ItemBase("eden_sparklez");
	public static final Item callWatcher = new CallOfTheWatcher("call_of_the_watcher");
	public static final Item eyeWatch = new ItemBase("watching_eye");
	public static final Item stoneMolten = new ItemBase("stone_molten");
	public static final Item stoneDivine = new ItemBase("stone_divine");
	public static final Item stoneEnder = new ItemBase("stone_ender");
	public static final Item stoneCorrupted = new ItemBase("stone_corrupted");
	public static final Item shadowBar = new ItemBase("ingot_shadow");
	public static final Item chunkNetherite = new ItemBase("chunk_netherite");
	public static final Item pelletsAquatic = new ItemBase("pellets_aquatic");
	public static final Item pelletsAquaticPure = new ItemBase("pellets_aquatic_pure");
	public static final Item shardIce = new ItemBase("shard_ice");
	public static final Item seedsGlowbonePurple = new ItemBase("seeds_glowbone_purple");
	public static final Item snowGlobe = new SnowGlobe("snow_globe");
	public static final Item blazePurple = new ItemBase("blaze_purple");
	public static final Item furyFire = new ItemBase("fury_fire");
	public static final Item stoneBluefire = new ItemBase("stone_bluefire");
	public static final Item eyeEnderLegendary = new ItemBase("eye_ender_legendary");
	public static final Item knifeJungle = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "knife_jungle");
	public static final Item eyeCyclops = new ItemBase("eye_cyclops");
	public static final Item liopleurodonAnchor = new CannonBase("liopleurodon_anchor");
	public static final Item liopleurodonSkull = new ItemBase("liopleurodon_skull");
	public static final Item liopleurodonTeeth = new ItemBase("liopleurodon_teeth");
	public static final Item stoneHealing = new ItemBase("stone_healing");
	public static final Item stoneTerran = new ItemBase("stone_terran");
	public static final Item rapierJungle = new SwordBase(DivineRPGMaterials.arlemiteSwordMaterial, "rapier_jungle");
	public static final Item shuriken = new Shuriken("shuriken", 4);
	public static final Item shurikenSnow = new Shuriken("shuriken_snow", 4);
	public static final Item vileStorm = new Vilestorm("vilestorm");
	public static final Item soundMusic = new ItemBase("sound_of_music");
	public static final Item maelstrom = new ItemBase("maelstrom");
	public static final Item chunkEden = new ItemBase("chunk_eden");
	public static final Item chunkWildwood = new ItemBase("chunk_wildwood");
	public static final Item chunkApalachia = new ItemBase("chunk_apalachia");
	public static final Item chunkSkythern = new ItemBase("chunk_skythern");
	public static final Item chunkMortum = new ItemBase("chunk_mortum");
	public static final Item cannonGhast = new CannonBase("cannon_ghast");
	public static final Item snowflake = new ItemBase("snowflake");
	public static final Item bowheadAnchor = new CannonBase("anchor_bowhead");
	public static final Item sharkAnchor = new CannonBase("anchor_shark");
	public static final Item cannonFrost = new CannonBase("cannon_frost");
	public static final Item cannonBowhead = new CannonBase("cannon_bowhead");
	public static final Item cannonCrab = new CannonBase("cannon_crab");
	public static final Item cannonCorrupted = new CannonBase("cannon_corrupted");
	public static final Item furyGold = new CannonBase("fury_golden");
	public static final Item hordeHorn = new HordeHorn("horde_horn");
	public static final Item steelDoor = new ItemBlockSteelDoor("steel_door", ModBlocks.steelDoor);
	public static final Item krakenSkin = new ItemBase("kraken_skin");
	public static final Item krakenScale = new ItemBase("kraken_scale");
	public static final Item coinShadow = new ItemBase("coin_shadow");
	public static final Item eggGrizzle = new ItemSpawnEgg("egg_grizzle");
	public static final Item eggGrizzleWhite = new ItemSpawnEgg("egg_grizzle_white");
	public static final Item divineAccumulator = new ItemBase("divine_accumulator");
	public static final Item meteorMash = new ItemBase("meteor_mash");
	public static final Item blasterArcanite = new ItemBase("blaster_arcanite");
	public static final Item bladeArcanite = new ItemBase("blade_arcana");
	public static final Item staffGenerals = new ItemBase("staff_generals");
	public static final Item arcaniumReflector = new ItemBase("arcanium_reflector");
	public static final Item arcaniumAttractor = new ItemBase("arcanium_attractor");
	public static final Item seedsEucalyptus = new ItemBase("seeds_eucalyptus");
	public static final Item seedsMarsine = new ItemBase("seeds_marsine");
	public static final Item seedsFirestock = new ItemBase("seeds_firestock");
	public static final Item seedsPinfly = new ItemBase("seeds_pinfly");
	public static final Item seedsAquamarine = new ItemBase("seeds_aquamarine");
	public static final Item seedsHitchak = new ItemBase("seeds_hitchak");
	public static final Item seedsVelio = new ItemBase("seeds_velio");
	public static final Item seedsLamona = new ItemBase("seeds_lamona");
	public static final Item enderSceptor = new ItemBase("sceptor_ender");
	public static final Item wraithbane = new ItemBase("wraithbane");
	public static final Item saberArcanium = new ItemBase("saber_arcanium");
	public static final Item firefly = new ItemBase("firefly");
	public static final Item staffStarlight = new ItemBase("staff_starlight");
	public static final Item meriksMissile = new ItemBase("missile_meriks");
	public static final Item swordLivicia = new ItemBase("sword_livicia");
	public static final Item lavekor = new ItemBase("lavekor");
	public static final Item grenade = new ItemBase("grenade");
	public static final Item snowslash = new ItemBase("snowslash");
	public static final Item collector = new ItemBase("collector");
	public static final Item collectorCharged = new ItemBase("collector_charged");
	public static final Item staffEnrichment = new ItemBase("staff_enrichment");
	public static final Item potionArcanaWeak = new ItemBase("potion_arcana_weak");
	public static final Item potionArcanaStrong = new ItemBase("potion_arcana_strong");
	public static final Item orbLight = new ItemBase("orb_light");
	public static final Item scythe = new ItemBase("scythe");
	public static final Item flintDream = new ItemBase("flint_dream");
	public static final Item maulKaros = new ItemBase("maul_karos_rock");
	public static final Item amuletMiners = new ItemBase("amulet_miners");
	public static final Item arrowTeaker = new ItemBase("arrow_teaker");
	public static final Item arrowDarven = new ItemBase("arrow_darven");
	public static final Item arrowPardimal = new ItemBase("arrow_pardimal");
	public static final Item arrowKaros = new ItemBase("arrow_karos");
	public static final Item stoneShadow = new ItemBase("stone_shadow");
	public static final Item frossivence = new ItemBase("frossivence");
	public static final Item soundCarol = new ItemBase("sound_of_carols");
	public static final Item maulFrozen = new ItemBase("maul_frozen");
	public static final Item cannonFractite = new CannonBase("cannon_fractite");
	public static final Item iceEnder = new SwordBase(DivineRPGMaterials.enderSwordMaterial, "ice_ender");
	public static final Item eggOverworld = new ItemBase("egg_overworld");
}