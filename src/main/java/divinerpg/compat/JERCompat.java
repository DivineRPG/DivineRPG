package divinerpg.compat;

import divinerpg.entities.apalachia.*;
import divinerpg.entities.boss.EntityTheWatcher;
import divinerpg.entities.eden.*;
import divinerpg.entities.iceika.*;
import divinerpg.entities.mortum.*;
import divinerpg.entities.skythern.*;
import divinerpg.entities.vanilla.end.*;
import divinerpg.entities.vanilla.nether.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.entities.wildwood.*;
import divinerpg.registries.*;
import jeresources.api.*;
import jeresources.api.drop.PlantDrop;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.*;

public class JERCompat {
    @JERPlugin
    public static IJERAPI jerAPI;


    public static void init(FMLCommonSetupEvent event) {
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
        //TODO - JER world gen compat
//        worldGenRegistry.register(new ItemStack(BlockRegistry.arlemiteOre), new DistributionSquare(Config.arlemite.getTries(), Config.arlemite.getVienSize(), Config.arlemite.getMinY(), Config.arlemite.getMaxY()));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.realmiteOre), new DistributionSquare(Config.realmite.getTries(), Config.realmite.getVienSize(), Config.realmite.getMinY(), Config.realmite.getMaxY()));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.rupeeOre), new DistributionSquare(Config.rupee.getTries(), Config.rupee.getVienSize(), Config.rupee.getMinY(), Config.rupee.getMaxY()));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.netheriteOre), new DistributionSquare(Config.nether.getTries(), Config.nether.getVienSize(), Config.nether.getMinY(), Config.nether.getMaxY()), new Restriction(new DimensionRestriction(-1)));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.bloodgemOre), new DistributionSquare(Config.nether.getTries(), Config.nether.getVienSize(), Config.nether.getMinY(), Config.nether.getMaxY()), new Restriction(new DimensionRestriction(-1)));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.edenOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.edenDimension.getId())));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.wildwoodOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.wildwoodDimension.getId())));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.apalachiaOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.apalachiaDimension.getId())));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.skythernOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.skythernDimension.getId())));
//        worldGenRegistry.register(new ItemStack(BlockRegistry.mortumOre), new DistributionSquare(Config.twilight.getTries(), Config.twilight.getVienSize(), Config.twilight.getMinY(), Config.twilight.getMaxY()), new Restriction(new DimensionRestriction(DimensionRegistry.mortumDimension.getId())));
    }

    private static void initMobDrops() {
        IMobRegistry mobRegistry = jerAPI.getMobRegistry();
        World world = jerAPI.getWorld();
        //TODO - finish mob drop jer compat
        //APALACHIA
        mobRegistry.register(new EntityApalachiaCadillion(EntityRegistry.APALACHIA_CADILLION, world), LootTableRegistry.ENTITIES_APALACHIA_CADILLION);
        mobRegistry.register(new EntityApalachiaGolem(EntityRegistry.APALACHIA_GOLEM, world), LootTableRegistry.ENTITIES_APALACHIA_GOLEM);
        mobRegistry.register(new EntityApalachiaTomo(EntityRegistry.APALACHIA_TOMO, world), LootTableRegistry.ENTITIES_APALACHIA_TOMO);
        mobRegistry.register(new EntityEnchantedArcher(EntityRegistry.ENCHANTED_ARCHER, world), LootTableRegistry.ENTITIES_ENCHANTED_ARCHER);
        mobRegistry.register(new EntityEnchantedWarrior(EntityRegistry.ENCHANTED_WARRIOR, world), LootTableRegistry.ENTITIES_ENCHANTED_WARRIOR);
        mobRegistry.register(new EntitySpellbinder(EntityRegistry.SPELLBINDER, world), LootTableRegistry.ENTITIES_SPELLBINDER);

        //ARCANA
//        mobRegistry.register(new EntityDeathcryx(world), LootTableRegistry.ENTITIES_DEATHCRYX);
//        mobRegistry.register(new EntityDeathHound(world), LootTableRegistry.ENTITIES_DEATH_HOUND);
//        mobRegistry.register(new EntityDungeonConstructor(world), LootTableRegistry.ENTITIES_DUNGEON_CONSTRUCTOR);
//        mobRegistry.register(new EntityDungeonDemon(world), LootTableRegistry.ENTITIES_DUNGEON_DEMON);
//        mobRegistry.register(new EntityDungeonPrisoner(world), LootTableRegistry.ENTITIES_DUNGEON_PRISONER);
//        mobRegistry.register(new EntityLivingStatue(world), LootTableRegistry.ENTITIES_LIVING_STATUE);
//        mobRegistry.register(new EntityRazorback(world), LootTableRegistry.ENTITIES_RAZORBACK);
//        mobRegistry.register(new EntityRoamer(world), LootTableRegistry.ENTITIES_ROAMER);

        //BOSS
//        mobRegistry.register(new EntityAyeracoBlue(world), LootTableRegistry.ENTITIES_AYERACO_BLUE);
//        mobRegistry.register(new EntityAyeracoGreen(world), LootTableRegistry.ENTITIES_AYERACO_GREEN);
//        mobRegistry.register(new EntityAyeracoPurple(world), LootTableRegistry.ENTITIES_AYERACO_PURPLE);
//        mobRegistry.register(new EntityAyeracoRed(world), LootTableRegistry.ENTITIES_AYERACO_RED);
//        mobRegistry.register(new EntityAyeracoYellow(world), LootTableRegistry.ENTITIES_AYERACO_YELLOW);
//        mobRegistry.register(new EntityAncientEntity(world), LootTableRegistry.ENTITIES_ANCIENT_ENTITY);
//        mobRegistry.register(new EntityDensos(world), LootTableRegistry.ENTITIES_DENSOS);
//        mobRegistry.register(new EntityDramix(world), LootTableRegistry.ENTITIES_DRAMIX);
//        mobRegistry.register(new EntityEternalArcher(world), LootTableRegistry.ENTITIES_ETERNAL_ARCHER);
//        mobRegistry.register(new EntityExperiencedCori(world), LootTableRegistry.ENTITIES_EXPERIENCED_CORI);
//        mobRegistry.register(new EntityHiveQueen(world), LootTableRegistry.ENTITIES_HIVE_QUEEN);
//        mobRegistry.register(new EntityKaros(world), LootTableRegistry.ENTITIES_KAROS);
//        mobRegistry.register(new EntityKarot(world), LootTableRegistry.ENTITIES_KAROT);
//        mobRegistry.register(new EntityKingOfScorchers(world), LootTableRegistry.ENTITIES_KING_OF_SCORCHERS);
//        mobRegistry.register(new EntityLadyLuna(world), LootTableRegistry.ENTITIES_LADY_LUNA);
//        mobRegistry.register(new EntityParasecta(world), LootTableRegistry.ENTITIES_PARASECTA);
//        mobRegistry.register(new EntityQuadro(world), LootTableRegistry.ENTITIES_QUADRO);
//        mobRegistry.register(new EntityRaglok(world), LootTableRegistry.ENTITIES_RAGLOK);
//        mobRegistry.register(new EntityReyvor(world), LootTableRegistry.ENTITIES_REYVOR);
//        mobRegistry.register(new EntitySoulFiend(world), LootTableRegistry.ENTITIES_SOUL_FIEND);
//        mobRegistry.register(new EntitySunstorm(world), LootTableRegistry.ENTITIES_SUNSTORM);
//        mobRegistry.register(new EntityTermasect(world), LootTableRegistry.ENTITIES_TERMASECT);
        mobRegistry.register(new EntityTheWatcher(EntityRegistry.THE_WATCHER, world), LootTableRegistry.ENTITIES_THE_WATCHER);
//        mobRegistry.register(new EntityTwilightDemon(world), LootTableRegistry.ENTITIES_TWILIGHT_DEMON);
//        mobRegistry.register(new EntityVamacheron(world), LootTableRegistry.ENTITIES_VAMACHERON);
//        mobRegistry.register(new EntityWreck(world), LootTableRegistry.ENTITIES_WRECK);

        //EDEN
        mobRegistry.register(new EntityBunny(EntityRegistry.BUNNY, world), LootTableRegistry.ENTITIES_BUNNY);
        mobRegistry.register(new EntityEdenCadillion(EntityRegistry.EDEN_CADILLION, world), LootTableRegistry.ENTITIES_EDEN_CADILLION);
        mobRegistry.register(new EntityEdenTomo(EntityRegistry.EDEN_TOMO, world), LootTableRegistry.ENTITIES_EDEN_TOMO);
        mobRegistry.register(new EntityGreenfeet(EntityRegistry.GREENFEET, world), LootTableRegistry.ENTITIES_GREENFEET);
        mobRegistry.register(new EntityMadivel(EntityRegistry.MADIVEL, world), LootTableRegistry.ENTITIES_MADIVEL);
        mobRegistry.register(new EntitySunArcher(EntityRegistry.SUN_ARCHER, world), LootTableRegistry.ENTITIES_SUN_ARCHER);
        mobRegistry.register(new EntityWeakCori(EntityRegistry.WEAK_CORI, world), LootTableRegistry.ENTITIES_WEAK_CORI);

        //END
        mobRegistry.register(new EntityEnderSpider(EntityRegistry.ENDER_SPIDER, world), LootTableRegistry.ENTITIES_ENDER_SPIDER);
        mobRegistry.register(new EntityEnderTriplets(EntityRegistry.ENDER_TRIPLETS, world), LootTableRegistry.ENTITIES_ENDER_TRIPLETS);
        mobRegistry.register(new EntityEnderWatcher(EntityRegistry.ENDER_WATCHER, world), LootTableRegistry.ENTITIES_ENDER_WATCHER);

        //ICEIKA
        mobRegistry.register(new EntityAlicanto(EntityRegistry.ALICANTO, world), LootTableRegistry.ENTITIES_ALICANTO);
        mobRegistry.register(new EntityFractite(EntityRegistry.FRACTITE, world), LootTableRegistry.ENTITIES_FRACTITE);
        mobRegistry.register(new EntityFrostArcher(EntityRegistry.FROST_ARCHER, world), LootTableRegistry.ENTITIES_FROST_ARCHER);
        mobRegistry.register(new EntityFrosty(EntityRegistry.FROSTY, world), LootTableRegistry.ENTITIES_FROSTY);
        mobRegistry.register(new EntityGlacide(EntityRegistry.GLACIDE, world), LootTableRegistry.ENTITIES_GLACIDE);
        mobRegistry.register(new EntityHastreus(EntityRegistry.HASTREUS, world), LootTableRegistry.ENTITIES_HASTREUS);
        mobRegistry.register(new EntityRollum(EntityRegistry.ROLLUM, world), LootTableRegistry.ENTITIES_ROLLUM);

        //MORTUM
        mobRegistry.register(new EntityAngryBunny(EntityRegistry.ANGRY_BUNNY, world), LootTableRegistry.ENTITIES_ANGRY_BUNNY);
        mobRegistry.register(new EntityBasilisk(EntityRegistry.BASILISK, world), LootTableRegistry.ENTITIES_BASILISK);
        mobRegistry.register(new EntityDemonOfDarkness(EntityRegistry.DEMON_OF_DARKNESS, world), LootTableRegistry.ENTITIES_DEMON_OF_DARKNESS);
        mobRegistry.register(new EntityMortumCadillion(EntityRegistry.MORTUM_CADILLION, world), LootTableRegistry.ENTITIES_MORTUM_CADILLION);
        mobRegistry.register(new EntitySorcerer(EntityRegistry.SORCERER, world), LootTableRegistry.ENTITIES_SORCERER);
        mobRegistry.register(new EntitySoulSpider(EntityRegistry.SOUL_SPIDER, world), LootTableRegistry.ENTITIES_SOUL_SPIDER);
        mobRegistry.register(new EntitySoulStealer(EntityRegistry.SOUL_STEALER, world), LootTableRegistry.ENTITIES_SOUL_STEALER);
        mobRegistry.register(new EntityTwilightArcher(EntityRegistry.TWILIGHT_ARCHER, world), LootTableRegistry.ENTITIES_TWILIGHT_ARCHER);

        //NETHER
		mobRegistry.register(new EntityHellBat(EntityRegistry.HELL_BAT, world), LootTableRegistry.ENTITIES_HELL_BAT);
        mobRegistry.register(new EntityHellPig(EntityRegistry.HELL_PIG, world), LootTableRegistry.ENTITIES_HELL_PIG);
        mobRegistry.register(new EntityHellSpider(EntityRegistry.HELL_SPIDER, world), LootTableRegistry.ENTITIES_HELL_SPIDER);
        mobRegistry.register(new EntityScorcher(EntityRegistry.SCORCHER, world), LootTableRegistry.ENTITIES_SCORCHER);
        mobRegistry.register(new EntityWildfire(EntityRegistry.WILDFIRE, world), LootTableRegistry.ENTITIES_WILDFIRE);

        //SKYTHERN
        mobRegistry.register(new EntityAdvancedCori(EntityRegistry.ADVANCED_CORI, world), LootTableRegistry.ENTITIES_ADVANCED_CORI);
        mobRegistry.register(new EntityMegalith(EntityRegistry.MEGALITH, world), LootTableRegistry.ENTITIES_MEGALITH);
        mobRegistry.register(new EntityMystic(EntityRegistry.MYSTIC, world), LootTableRegistry.ENTITIES_MYSTIC);
        mobRegistry.register(new EntitySamek(EntityRegistry.SAMEK, world), LootTableRegistry.ENTITIES_SAMEK);
        mobRegistry.register(new EntitySkythernArcher(EntityRegistry.SKYTHERN_ARCHER, world), LootTableRegistry.ENTITIES_SKYTHERN_ARCHER);
        mobRegistry.register(new EntitySkythernFiend(EntityRegistry.SKYTHERN_FIEND, world), LootTableRegistry.ENTITIES_SKYTHERN_FIEND);
        mobRegistry.register(new EntitySkythernGolem(EntityRegistry.SKYTHERN_GOLEM, world), LootTableRegistry.ENTITIES_SKYTHERN_GOLEM);

        //VANILLA
        mobRegistry.register(new EntityAridWarrior(EntityRegistry.ARID_WARRIOR, world), LootTableRegistry.ENTITIES_ARID_WARRIOR);
        mobRegistry.register(new EntityCaveclops(EntityRegistry.CAVECLOPS, world), LootTableRegistry.ENTITIES_CAVECLOPS);
        mobRegistry.register(new EntityCaveCrawler(EntityRegistry.CAVE_CRAWLER, world), LootTableRegistry.ENTITIES_CAVE_CRAWLER);
        mobRegistry.register(new EntityCrab(EntityRegistry.CRAB, world), LootTableRegistry.ENTITIES_CRAB);
        mobRegistry.register(new EntityCyclops(EntityRegistry.CYCLOPS, world), LootTableRegistry.ENTITIES_CYCLOPS);
        mobRegistry.register(new EntityDesertCrawler(EntityRegistry.DESERT_CRAWLER, world), LootTableRegistry.ENTITIES_DESERT_CRAWLER);
        mobRegistry.register(new EntityEnthralledDramcryx(EntityRegistry.ENTHRALLED_DRAMCRYX, world), LootTableRegistry.ENTITIES_ENTHRALLED_DRAMCRYX);
        mobRegistry.register(new EntityFrost(EntityRegistry.FROST, world), LootTableRegistry.ENTITIES_FROST);
        mobRegistry.register(new EntityGlacon(EntityRegistry.GLACON, world), LootTableRegistry.ENTITIES_GLACON);
        mobRegistry.register(new EntityJungleBat(EntityRegistry.JUNGLE_BAT, world), LootTableRegistry.ENTITIES_JUNGLE_BAT);
        mobRegistry.register(new EntityJungleDramcryx(EntityRegistry.JUNGLE_DRAMCRYX, world), LootTableRegistry.ENTITIES_JUNGLE_DRAMCRYX);
        mobRegistry.register(new EntityJungleSpider(EntityRegistry.JUNGLE_SPIDER, world), LootTableRegistry.ENTITIES_JUNGLE_SPIDER);
        mobRegistry.register(new EntityKingCrab(EntityRegistry.KING_CRAB, world), LootTableRegistry.ENTITIES_KING_CRAB);
        mobRegistry.register(new EntityKobblin(EntityRegistry.KOBBLIN, world), LootTableRegistry.ENTITIES_KOBBLIN);
        mobRegistry.register(new EntityLiopleurodon(EntityRegistry.LIOPLEURODON, world), LootTableRegistry.ENTITIES_LIOPLEURODON);
        mobRegistry.register(new EntityMiner(EntityRegistry.MINER, world), LootTableRegistry.ENTITIES_MINER);
        mobRegistry.register(new EntityPumpkinSpider(EntityRegistry.PUMPKIN_SPIDER, world), LootTableRegistry.ENTITIES_PUMPKIN_SPIDER);
        mobRegistry.register(new EntityRainbour(EntityRegistry.RAINBOUR, world), LootTableRegistry.ENTITIES_RAINBOUR);
        mobRegistry.register(new EntityRotatick(EntityRegistry.ROTATICK, world), LootTableRegistry.ENTITIES_ROTATICK);
        mobRegistry.register(new EntitySaguaroWorm(EntityRegistry.SAGUARO_WORM, world), LootTableRegistry.ENTITIES_SAGUARO_WORM);
        mobRegistry.register(new EntityShark(EntityRegistry.SHARK, world), LootTableRegistry.ENTITIES_SHARK);
        mobRegistry.register(new EntityTheEye(EntityRegistry.THE_EYE, world), LootTableRegistry.ENTITIES_THE_EYE);
        mobRegistry.register(new EntityTheGrue(EntityRegistry.THE_GRUE, world), LootTableRegistry.ENTITIES_THE_GRUE);
        mobRegistry.register(new EntityWhale(EntityRegistry.WHALE, world), LootTableRegistry.ENTITIES_WHALE);

        //VETHEA
//        mobRegistry.register(new EntityAcidHag(world), LootTableRegistry.ENTITIES_ACID_HAG);
//        mobRegistry.register(new EntityBiphron(world), LootTableRegistry.ENTITIES_BIPHRON);
//        mobRegistry.register(new EntityBohemite(world), LootTableRegistry.ENTITIES_BOHEMITE);
//        mobRegistry.register(new EntityCymesoid(world), LootTableRegistry.ENTITIES_CYMESOID);
//        mobRegistry.register(new EntityDissiment(world), LootTableRegistry.ENTITIES_DISSIMENT);
//        mobRegistry.register(new EntityDreamwrecker(world), LootTableRegistry.ENTITIES_DREAMWRECKER);
//        mobRegistry.register(new EntityDuo(world), LootTableRegistry.ENTITIES_DUO);
//        mobRegistry.register(new EntityEnt(world), LootTableRegistry.ENTITIES_ENT);
//        mobRegistry.register(new EntityGalroid(world), LootTableRegistry.ENTITIES_GALROID);
//        mobRegistry.register(new EntityHelio(world), LootTableRegistry.ENTITIES_HELIO);
//        mobRegistry.register(new EntityHiveSoldier(world), LootTableRegistry.ENTITIES_HIVE_SOLDIER);
//        mobRegistry.register(new EntityHoverStinger(world), LootTableRegistry.ENTITIES_HOVER_STINGER);
//        mobRegistry.register(new EntityKazrotic(world), LootTableRegistry.ENTITIES_KAZROTIC);
//        mobRegistry.register(new EntityLheiva(world), LootTableRegistry.ENTITIES_LHEIVA);
//        mobRegistry.register(new EntityLorga(world), LootTableRegistry.ENTITIES_LORGA);
//        mobRegistry.register(new EntityMandragora(world), LootTableRegistry.ENTITIES_MANDRAGORA);
//        mobRegistry.register(new EntityShadahier(world), LootTableRegistry.ENTITIES_SHADAHIER);
//        mobRegistry.register(new EntityTocaxin(world), LootTableRegistry.ENTITIES_TOCAXIN);
//        mobRegistry.register(new EntityTwins(world), LootTableRegistry.ENTITIES_TWINS);
//        mobRegistry.register(new EntityVermenous(world), LootTableRegistry.ENTITIES_VERMENOUS);
//        mobRegistry.register(new EntityVhraak(world), LootTableRegistry.ENTITIES_VHRAAK);
//        mobRegistry.register(new EntityZone(world), LootTableRegistry.ENTITIES_ZONE);
//        mobRegistry.register(new EntityZoragon(world), LootTableRegistry.ENTITIES_ZORAGON);

        //WILDWOOD
        mobRegistry.register(new EntityBehemoth(EntityRegistry.BEHEMOTH, world), LootTableRegistry.ENTITIES_BEHEMOTH);
        mobRegistry.register(new EntityEpiphite(EntityRegistry.EPIPHITE, world), LootTableRegistry.ENTITIES_EPIPHITE);
        mobRegistry.register(new EntityMage(EntityRegistry.MAGE, world), LootTableRegistry.ENTITIES_MAGE);
        mobRegistry.register(new EntityMoonWolf(EntityRegistry.MOON_WOLF, world), LootTableRegistry.ENTITIES_MOON_WOLF);
        mobRegistry.register(new EntityTermid(EntityRegistry.TERMID, world), LootTableRegistry.ENTITIES_TERMID);
        mobRegistry.register(new EntityVerek(EntityRegistry.VEREK, world), LootTableRegistry.ENTITIES_VEREK);
        mobRegistry.register(new EntityWildwoodCadillion(EntityRegistry.WILDWOOD_CADILLION, world), LootTableRegistry.ENTITIES_WILDWOOD_CADILLION);
        mobRegistry.register(new EntityWildwoodGolem(EntityRegistry.WILDWOOD_GOLEM, world), LootTableRegistry.ENTITIES_WILDWOOD_GOLEM);
        mobRegistry.register(new EntityWildwoodTomo(EntityRegistry.WILDWOOD_TOMO, world), LootTableRegistry.ENTITIES_WILDWOOD_TOMO);
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
