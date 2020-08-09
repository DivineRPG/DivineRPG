package divinerpg.compat;

import divinerpg.config.Config;
import divinerpg.objects.entities.entity.apalachia.*;
import divinerpg.objects.entities.entity.arcana.*;
import divinerpg.objects.entities.entity.boss.*;
import divinerpg.objects.entities.entity.boss.ayeraco.*;
import divinerpg.objects.entities.entity.eden.*;
import divinerpg.objects.entities.entity.end.*;
import divinerpg.objects.entities.entity.iceika.*;
import divinerpg.objects.entities.entity.mortum.*;
import divinerpg.objects.entities.entity.nether.*;
import divinerpg.objects.entities.entity.skythern.*;
import divinerpg.objects.entities.entity.vanilla.*;
import divinerpg.objects.entities.entity.vethea.*;
import divinerpg.objects.entities.entity.wildwood.*;
import divinerpg.registry.*;
import jeresources.api.*;
import jeresources.api.distributions.DistributionSquare;
import jeresources.api.drop.PlantDrop;
import jeresources.api.restrictions.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class JERCompat {
	@JERPlugin
	public static IJERAPI jerAPI;
	
	public static void onInit(FMLInitializationEvent event) {
		World fakeWorld = jerAPI.getWorld();
		initDungeonLoot();
		initOreGen();
		initMobDrops();
		initPlants();

	}

	private static void initDungeonLoot() {
		IDungeonRegistry dungeonRegistry = jerAPI.getDungeonRegistry();
		dungeonRegistry.registerChest("Iceika Chest", LootTableRegistry.ICEIKA_CHEST_DUNGEON);
		dungeonRegistry.registerChest("Iceika Hut Chest", LootTableRegistry.ICEIKA_CHEST_HUT);
		dungeonRegistry.registerChest("Crypt Loot", LootTableRegistry.CRYPT_LOOT);
		dungeonRegistry.registerChest("Lower Temple Loot", LootTableRegistry.TEMPLE_LOOT_BOTTOM);
		dungeonRegistry.registerChest("Middle Temple Loot", LootTableRegistry.TEMPLE_LOOT_MIDDLE);
		dungeonRegistry.registerChest("Higher Temple Loot", LootTableRegistry.TEMPLE_LOOT_TOP);
		dungeonRegistry.registerChest("Quadrotic Post Loot", LootTableRegistry.QUADROTIC_POST_LOOT);
		dungeonRegistry.registerChest("Karos Mad House Loot", LootTableRegistry.KAROS_MADHOUSE_LOOT);
		dungeonRegistry.registerChest("Raglok Chamber Loot", LootTableRegistry.RAGLOK_CHAMBER_LOOT);
		dungeonRegistry.registerChest("Wreck Hall Loot", LootTableRegistry.WRECK_HALL_LOOT);
	}

	private static void initOreGen() {
		IWorldGenRegistry worldGenRegistry = jerAPI.getWorldGenRegistry();
		worldGenRegistry.register(new ItemStack(BlockRegistry.arlemiteOre), new DistributionSquare(Config.arlemite.getTries(), Config.arlemite.getVienSize(), Config.arlemite.getMinY(), Config.arlemite.getMaxY()));
		worldGenRegistry.register(new ItemStack(BlockRegistry.realmiteOre), new DistributionSquare(Config.realmite.getTries(), Config.realmite.getVienSize(), Config.realmite.getMinY(), Config.realmite.getMaxY()));
		worldGenRegistry.register(new ItemStack(BlockRegistry.rupeeOre), new DistributionSquare(Config.rupee.getTries(), Config.rupee.getVienSize(), Config.rupee.getMinY(), Config.rupee.getMaxY()));
		worldGenRegistry.register(new ItemStack(BlockRegistry.netheriteOre), new DistributionSquare(Config.nether.getTries(), Config.nether.getVienSize(), Config.nether.getMinY(), Config.nether.getMaxY()), new Restriction(new DimensionRestriction(-1)));
		worldGenRegistry.register(new ItemStack(BlockRegistry.bloodgemOre), new DistributionSquare(Config.nether.getTries(), Config.nether.getVienSize(), Config.nether.getMinY(), Config.nether.getMaxY()), new Restriction(new DimensionRestriction(-1)));
		worldGenRegistry.register(new ItemStack(BlockRegistry.edenOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.edenDimension.getId())));
		worldGenRegistry.register(new ItemStack(BlockRegistry.wildwoodOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.wildwoodDimension.getId())));
		worldGenRegistry.register(new ItemStack(BlockRegistry.apalachiaOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.apalachiaDimension.getId())));
		worldGenRegistry.register(new ItemStack(BlockRegistry.skythernOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.skythernDimension.getId())));
		worldGenRegistry.register(new ItemStack(BlockRegistry.mortumOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.mortumDimension.getId())));
	}
	
	private static void initMobDrops() {
		IMobRegistry mobRegistry = jerAPI.getMobRegistry();
		World world = jerAPI.getWorld();
		
		//APALACHIA
		mobRegistry.register(new EntityApalachiaCadillion(world), LootTableRegistry.ENTITIES_APALACHIA_CADILLION);
		mobRegistry.register(new EntityApalachiaGolem(world), LootTableRegistry.ENTITIES_APALACHIA_GOLEM);
		mobRegistry.register(new EntityApalachiaTomo(world), LootTableRegistry.ENTITIES_APALACHIA_TOMO);
		mobRegistry.register(new EntityEnchantedArcher(world), LootTableRegistry.ENTITIES_ENCHANTED_ARCHER);
		mobRegistry.register(new EntityEnchantedWarrior(world), LootTableRegistry.ENTITIES_ENCHANTED_WARRIOR);
		mobRegistry.register(new EntitySpellbinder(world), LootTableRegistry.ENTITIES_SPELLBINDER);
		
		//ARCANA
		mobRegistry.register(new EntityDeathcryx(world), LootTableRegistry.ENTITIES_DEATHCRYX);
		mobRegistry.register(new EntityDeathHound(world), LootTableRegistry.ENTITIES_DEATH_HOUND);
		mobRegistry.register(new EntityDungeonConstructor(world), LootTableRegistry.ENTITIES_DUNGEON_CONSTRUCTOR);
		mobRegistry.register(new EntityDungeonDemon(world), LootTableRegistry.ENTITIES_DUNGEON_DEMON);
		mobRegistry.register(new EntityDungeonPrisoner(world), LootTableRegistry.ENTITIES_DUNGEON_PRISONER);
		mobRegistry.register(new EntityLivingStatue(world), LootTableRegistry.ENTITIES_LIVING_STATUE);
		mobRegistry.register(new EntityRazorback(world), LootTableRegistry.ENTITIES_RAZORBACK);
		mobRegistry.register(new EntityRoamer(world), LootTableRegistry.ENTITIES_ROAMER);
		
		//BOSS
		mobRegistry.register(new EntityAyeracoBlue(world), LootTableRegistry.ENTITIES_AYERACO_BLUE);
		mobRegistry.register(new EntityAyeracoGreen(world), LootTableRegistry.ENTITIES_AYERACO_GREEN);
		mobRegistry.register(new EntityAyeracoPurple(world), LootTableRegistry.ENTITIES_AYERACO_PURPLE);
		mobRegistry.register(new EntityAyeracoRed(world), LootTableRegistry.ENTITIES_AYERACO_RED);
		mobRegistry.register(new EntityAyeracoYellow(world), LootTableRegistry.ENTITIES_AYERACO_YELLOW);
		mobRegistry.register(new EntityAncientEntity(world), LootTableRegistry.ENTITIES_ANCIENT_ENTITY);
		mobRegistry.register(new EntityDensos(world), LootTableRegistry.ENTITIES_DENSOS);
		mobRegistry.register(new EntityDramix(world), LootTableRegistry.ENTITIES_DRAMIX);
		mobRegistry.register(new EntityEternalArcher(world), LootTableRegistry.ENTITIES_ETERNAL_ARCHER);
		mobRegistry.register(new EntityExperiencedCori(world), LootTableRegistry.ENTITIES_EXPERIENCED_CORI);
		mobRegistry.register(new EntityHiveQueen(world), LootTableRegistry.ENTITIES_HIVE_QUEEN);
		mobRegistry.register(new EntityKaros(world), LootTableRegistry.ENTITIES_KAROS);
		mobRegistry.register(new EntityKarot(world), LootTableRegistry.ENTITIES_KAROT);
		mobRegistry.register(new EntityKingOfScorchers(world), LootTableRegistry.ENTITIES_KING_OF_SCORCHERS);
		mobRegistry.register(new EntityLadyLuna(world), LootTableRegistry.ENTITIES_LADY_LUNA);
		mobRegistry.register(new EntityParasecta(world), LootTableRegistry.ENTITIES_PARASECTA);
		mobRegistry.register(new EntityQuadro(world), LootTableRegistry.ENTITIES_QUADRO);
		mobRegistry.register(new EntityRaglok(world), LootTableRegistry.ENTITIES_RAGLOK);
		mobRegistry.register(new EntityReyvor(world), LootTableRegistry.ENTITIES_REYVOR);
		mobRegistry.register(new EntitySoulFiend(world), LootTableRegistry.ENTITIES_SOUL_FIEND);
		mobRegistry.register(new EntitySunstorm(world), LootTableRegistry.ENTITIES_SUNSTORM);
		mobRegistry.register(new EntityTermasect(world), LootTableRegistry.ENTITIES_TERMASECT);
		mobRegistry.register(new EntityTheWatcher(world), LootTableRegistry.ENTITIES_THE_WATCHER);
		mobRegistry.register(new EntityTwilightDemon(world), LootTableRegistry.ENTITIES_TWILIGHT_DEMON);
		mobRegistry.register(new EntityVamacheron(world), LootTableRegistry.ENTITIES_VAMACHERON);
		mobRegistry.register(new EntityWreck(world), LootTableRegistry.ENTITIES_WRECK);
		
		//EDEN
		mobRegistry.register(new EntityBunny(world), LootTableRegistry.ENTITIES_BUNNY);
		mobRegistry.register(new EntityEdenCadillion(world), LootTableRegistry.ENTITIES_EDEN_CADILLION);
		mobRegistry.register(new EntityEdenTomo(world), LootTableRegistry.ENTITIES_EDEN_TOMO);
		mobRegistry.register(new EntityGreenfeet(world), LootTableRegistry.ENTITIES_GREENFEET);
		mobRegistry.register(new EntityMadivel(world), LootTableRegistry.ENTITIES_MADIVEL);
		mobRegistry.register(new EntitySunArcher(world), LootTableRegistry.ENTITIES_SUN_ARCHER);
		mobRegistry.register(new EntityWeakCori(world), LootTableRegistry.ENTITIES_WEAK_CORI);
		
		//END
		mobRegistry.register(new EntityEnderSpider(world), LootTableRegistry.ENTITIES_ENDER_SPIDER);
		mobRegistry.register(new EntityEnderTriplets(world), LootTableRegistry.ENTITIES_ENDER_TRIPLETS);
		mobRegistry.register(new EntityEnderWatcher(world), LootTableRegistry.ENTITIES_ENDER_WATCHER);
		
		//ICEIKA
		mobRegistry.register(new EntityAlicanto(world), LootTableRegistry.ENTITIES_ALICANTO);
		mobRegistry.register(new EntityFractite(world), LootTableRegistry.ENTITIES_FRACTITE);
		mobRegistry.register(new EntityFrostArcher(world), LootTableRegistry.ENTITIES_FROST_ARCHER);
		mobRegistry.register(new EntityFrosty(world), LootTableRegistry.ENTITIES_FROSTY);
		mobRegistry.register(new EntityGlacide(world), LootTableRegistry.ENTITIES_GLACIDE);
		mobRegistry.register(new EntityHastreus(world), LootTableRegistry.ENTITIES_HASTREUS);
		mobRegistry.register(new EntityRollum(world), LootTableRegistry.ENTITIES_ROLLUM);
		
		//MORTUM
		mobRegistry.register(new EntityAngryBunny(world), LootTableRegistry.ENTITIES_ANGRY_BUNNY);
		mobRegistry.register(new EntityBasilisk(world), LootTableRegistry.ENTITIES_BASILISK);
		mobRegistry.register(new EntityDemonOfDarkness(world), LootTableRegistry.ENTITIES_DEMON_OF_DARKNESS);
		mobRegistry.register(new EntityMortumCadillion(world), LootTableRegistry.ENTITIES_MORTUM_CADILLION);
		mobRegistry.register(new EntitySorcerer(world), LootTableRegistry.ENTITIES_SORCERER);
		mobRegistry.register(new EntitySoulSpider(world), LootTableRegistry.ENTITIES_SOUL_SPIDER);
		mobRegistry.register(new EntitySoulStealer(world), LootTableRegistry.ENTITIES_SOUL_STEALER);
		mobRegistry.register(new EntityTwilightArcher(world), LootTableRegistry.ENTITIES_TWILIGHT_ARCHER);
		
		//NETHER
//		mobRegistry.register(new EntityHellBat(world), LootTableRegistry.ENTITIES_HELL_BAT);
		mobRegistry.register(new EntityHellPig(world), LootTableRegistry.ENTITIES_HELL_PIG);
		mobRegistry.register(new EntityHellSpider(world), LootTableRegistry.ENTITIES_HELL_SPIDER);
		mobRegistry.register(new EntityScorcher(world), LootTableRegistry.ENTITIES_SCORCHER);
		mobRegistry.register(new EntityWildfire(world), LootTableRegistry.ENTITIES_WILDFIRE);
		
		//SKYTHERN
		mobRegistry.register(new EntityAdvancedCori(world), LootTableRegistry.ENTITIES_ADVANCED_CORI);
		mobRegistry.register(new EntityMegalith(world), LootTableRegistry.ENTITIES_MEGALITH);
		mobRegistry.register(new EntityMystic(world), LootTableRegistry.ENTITIES_MYSTIC);
		mobRegistry.register(new EntitySamek(world), LootTableRegistry.ENTITIES_SAMEK);
		mobRegistry.register(new EntitySkythernArcher(world), LootTableRegistry.ENTITIES_SKYTHERN_ARCHER);
		mobRegistry.register(new EntitySkythernFiend(world), LootTableRegistry.ENTITIES_SKYTHERN_FIEND);
		mobRegistry.register(new EntitySkythernGolem(world), LootTableRegistry.ENTITIES_SKYTHERN_GOLEM);
		
		//VANILLA
		mobRegistry.register(new EntityAridWarrior(world), LootTableRegistry.ENTITIES_ARID_WARRIOR);
		mobRegistry.register(new EntityCaveclops(world), LootTableRegistry.ENTITIES_CAVECLOPS);
		mobRegistry.register(new EntityCaveCrawler(world), LootTableRegistry.ENTITIES_CAVE_CRAWLER);
		mobRegistry.register(new EntityCrab(world), LootTableRegistry.ENTITIES_CRAB);
		mobRegistry.register(new EntityCyclops(world), LootTableRegistry.ENTITIES_CYCLOPS);
		mobRegistry.register(new EntityDesertCrawler(world), LootTableRegistry.ENTITIES_DESERT_CRAWLER);
		mobRegistry.register(new EntityEnthralledDramcryx(world), LootTableRegistry.ENTITIES_ENTHRALLED_DRAMCRYX);
		mobRegistry.register(new EntityFrost(world), LootTableRegistry.ENTITIES_FROST);
		mobRegistry.register(new EntityGlacon(world), LootTableRegistry.ENTITIES_GLACON);
		mobRegistry.register(new EntityJungleBat(world), LootTableRegistry.ENTITIES_JUNGLE_BAT);
		mobRegistry.register(new EntityJungleDramcryx(world), LootTableRegistry.ENTITIES_JUNGLE_DRAMCRYX);
		mobRegistry.register(new EntityJungleSpider(world), LootTableRegistry.ENTITIES_JUNGLE_SPIDER);
		mobRegistry.register(new EntityKingCrab(world), LootTableRegistry.ENTITIES_KING_CRAB);
		mobRegistry.register(new EntityKobblin(world), LootTableRegistry.ENTITIES_KOBBLIN);
		mobRegistry.register(new EntityLiopleurodon(world), LootTableRegistry.ENTITIES_LIOPLEURODON);
		mobRegistry.register(new EntityMiner(world), LootTableRegistry.ENTITIES_MINER);
		mobRegistry.register(new EntityPumpkinSpider(world), LootTableRegistry.ENTITIES_PUMPKIN_SPIDER);
		mobRegistry.register(new EntityRainbour(world), LootTableRegistry.ENTITIES_RAINBOUR);
		mobRegistry.register(new EntityRotatick(world), LootTableRegistry.ENTITIES_ROTATICK);
		mobRegistry.register(new EntitySaguaroWorm(world), LootTableRegistry.ENTITIES_SAGUARO_WORM);
		mobRegistry.register(new EntityShark(world), LootTableRegistry.ENTITIES_SHARK);
		mobRegistry.register(new EntityTheEye(world), LootTableRegistry.ENTITIES_THE_EYE);
		mobRegistry.register(new EntityTheGrue(world), LootTableRegistry.ENTITIES_THE_GRUE);
		mobRegistry.register(new EntityWhale(world), LootTableRegistry.ENTITIES_WHALE);
		
		//VETHEA
		mobRegistry.register(new EntityAcidHag(world), LootTableRegistry.ENTITIES_ACID_HAG);
		mobRegistry.register(new EntityBiphron(world), LootTableRegistry.ENTITIES_BIPHRON);
		mobRegistry.register(new EntityBohemite(world), LootTableRegistry.ENTITIES_BOHEMITE);
		mobRegistry.register(new EntityCymesoid(world), LootTableRegistry.ENTITIES_CYMESOID);
		mobRegistry.register(new EntityDissiment(world), LootTableRegistry.ENTITIES_DISSIMENT);
		mobRegistry.register(new EntityDreamwrecker(world), LootTableRegistry.ENTITIES_DREAMWRECKER);
		mobRegistry.register(new EntityDuo(world), LootTableRegistry.ENTITIES_DUO);
		mobRegistry.register(new EntityEnt(world), LootTableRegistry.ENTITIES_ENT);
		mobRegistry.register(new EntityGalroid(world), LootTableRegistry.ENTITIES_GALROID);
		mobRegistry.register(new EntityHelio(world), LootTableRegistry.ENTITIES_HELIO);
		mobRegistry.register(new EntityHiveSoldier(world), LootTableRegistry.ENTITIES_HIVE_SOLDIER);
		mobRegistry.register(new EntityHoverStinger(world), LootTableRegistry.ENTITIES_HOVER_STINGER);
		mobRegistry.register(new EntityKazrotic(world), LootTableRegistry.ENTITIES_KAZROTIC);
		mobRegistry.register(new EntityLheiva(world), LootTableRegistry.ENTITIES_LHEIVA);
		mobRegistry.register(new EntityLorga(world), LootTableRegistry.ENTITIES_LORGA);
		mobRegistry.register(new EntityMandragora(world), LootTableRegistry.ENTITIES_MANDRAGORA);
		mobRegistry.register(new EntityShadahier(world), LootTableRegistry.ENTITIES_SHADAHIER);
		mobRegistry.register(new EntityTocaxin(world), LootTableRegistry.ENTITIES_TOCAXIN);
		mobRegistry.register(new EntityTwins(world), LootTableRegistry.ENTITIES_TWINS);
		mobRegistry.register(new EntityVermenous(world), LootTableRegistry.ENTITIES_VERMENOUS);
		mobRegistry.register(new EntityVhraak(world), LootTableRegistry.ENTITIES_VHRAAK);
		mobRegistry.register(new EntityZone(world), LootTableRegistry.ENTITIES_ZONE);
		mobRegistry.register(new EntityZoragon(world), LootTableRegistry.ENTITIES_ZORAGON);
		
		//WILDWOOD
		mobRegistry.register(new EntityBehemoth(world), LootTableRegistry.ENTITIES_BEHEMOTH);
		mobRegistry.register(new EntityEpiphite(world), LootTableRegistry.ENTITIES_EPIPHITE);
		mobRegistry.register(new EntityMage(world), LootTableRegistry.ENTITIES_MAGE);
		mobRegistry.register(new EntityMoonWolf(world), LootTableRegistry.ENTITIES_MOON_WOLF);
		mobRegistry.register(new EntityTermid(world), LootTableRegistry.ENTITIES_TERMID);
		mobRegistry.register(new EntityVerek(world), LootTableRegistry.ENTITIES_VEREK);
		mobRegistry.register(new EntityWildwoodCadillion(world), LootTableRegistry.ENTITIES_WILDWOOD_CADILLION);
		mobRegistry.register(new EntityWildwoodGolem(world), LootTableRegistry.ENTITIES_WILDWOOD_GOLEM);
		mobRegistry.register(new EntityWildwoodTomo(world), LootTableRegistry.ENTITIES_WILDWOOD_TOMO);
	}

	private static void initPlants() {
		IPlantRegistry plantRegistry = jerAPI.getPlantRegistry();
		plantRegistry.register(new ItemStack(ItemRegistry.moonbulbSeeds), new PlantDrop(new ItemStack(ItemRegistry.moonbulb), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.tomatoSeeds), new PlantDrop(new ItemStack(ItemRegistry.tomato), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.whiteMushroomSeeds), new PlantDrop(new ItemStack(ItemRegistry.whiteMushroom), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.aquamarineSeeds), new PlantDrop(new ItemStack(ItemRegistry.aquamarine), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.eucalyptusRootSeeds), new PlantDrop(new ItemStack(BlockRegistry.eucalyptusLog), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.firestockSeeds), new PlantDrop(new ItemStack(ItemRegistry.firestock), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.hitchakSeeds), new PlantDrop(new ItemStack(ItemRegistry.hitchak), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.lamonaSeeds), new PlantDrop(new ItemStack(ItemRegistry.lamona), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.marsineSeeds), new PlantDrop(new ItemStack(ItemRegistry.marsine), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.pinflySeeds), new PlantDrop(new ItemStack(ItemRegistry.pinfly), 1, 1));
		plantRegistry.register(new ItemStack(ItemRegistry.veiloSeeds), new PlantDrop(new ItemStack(ItemRegistry.veilo), 1, 1));
		}
}
