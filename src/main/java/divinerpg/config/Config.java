package divinerpg.config;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.proxy.CommonProxy;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.Level;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Config {

    public static final OreInfo realmite = new OreInfo("realmite", 5, 8, 1, 48);
    public static final OreInfo rupee = new OreInfo("rupee", 5, 4, 1, 16);
    public static final OreInfo arlemite = new OreInfo("arlemite", 5, 4, 1, 16);
    public static final OreInfo nether = new OreInfo("netherOres", 10, 4, 1, 256);
    public static final OreInfo twilight = new OreInfo("twilightOres", 10, 4, 15, 100);
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_GUI = "GUI";
    private static final String CATEGORY_WORLD_GEN = "World Gen";
    private static final String CategoryKing = "King armor";
    public static int mobSpawnMultiplier = 5;
    public static boolean isBeaconBase = true;
    public static boolean UpdateChecker = true;
    public static boolean canShowOverlay = true;
    public static boolean debug = false;
    public static int arcanaX, arcanaY;
    public static boolean generateHuts = true;
    public static boolean generateTrees = true;
    public static boolean generateTar = true;

    private static final String CATEGORY_DIMENSION = "Dimension";
    public static int edenDimensionId = 420;
    public static int wildWoodDimensionId = 421;
    public static int apalachiaDimensionId = 422;
    public static int skythernDimensionId = 423;
    public static int mortumDimensionId = 424;
    public static int iceikaDimensionId = 425;
    public static int arcanaDimensionId = 426;
    public static int vetheaDimensionId = 427;

    public static int kingCreationPercentage = 50;
    public static int maxAbsorbedCount = 0;

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        cfg.addCustomCategoryComment(CATEGORY_DIMENSION, "Dimension related configuration");
        edenDimensionId = cfg.getInt("edenId", CATEGORY_DIMENSION, 420, 2, 4096, "Eden dimension ID");
        wildWoodDimensionId = cfg.getInt("wildWoodId", CATEGORY_DIMENSION, 421, 2, 4096, "Wild Wood dimension ID");
        apalachiaDimensionId = cfg.getInt("apalachiaId", CATEGORY_DIMENSION, 422, 2, 4096, "Apalachia dimension ID");
        skythernDimensionId = cfg.getInt("skythernId", CATEGORY_DIMENSION, 423, 2, 4096, "Skythern dimension ID");
        mortumDimensionId = cfg.getInt("mortumId", CATEGORY_DIMENSION, 424, 2, 4096, "Mortum dimension ID");
        iceikaDimensionId = cfg.getInt("iceikaId", CATEGORY_DIMENSION, 425, 2, 4096, "Iceika dimension ID");
        arcanaDimensionId = cfg.getInt("arcanaId", CATEGORY_DIMENSION, 426, 2, 4096, "Arcana dimension ID");
        vetheaDimensionId = cfg.getInt("vetheaId", CATEGORY_DIMENSION, 427, 2, 4096, "Vethea dimension ID");
        isBeaconBase = cfg.getBoolean("beaconBase", CATEGORY_GENERAL, isBeaconBase,
                "Set to false to make DivineRPG blocks non-beacon objects");
        UpdateChecker = cfg.getBoolean("UpdateChecker", CATEGORY_GENERAL, UpdateChecker,
                "Set to false to disable the update checker");
        canShowOverlay = cfg.getBoolean("canShowOverlay", CATEGORY_GENERAL, canShowOverlay,
                "Set to false to disable the overlay");
        debug = cfg.getBoolean("debug mode", CATEGORY_GENERAL, debug,
                "Dont enable this unless instructed by a developer");
        mobSpawnMultiplier = cfg.getInt("Mob Spawn Multiplier", CATEGORY_GENERAL, 5, 1, 32,
                "If you are experiencing lag i would recommend lowering this number");
        cfg.addCustomCategoryComment(CATEGORY_WORLD_GEN, "World gen variables");
        Arrays.asList(arlemite, rupee, realmite, nether, twilight).forEach(oreInfo -> oreInfo.init(cfg, CATEGORY_WORLD_GEN));

        generateHuts = cfg.getBoolean("generateHuts", CATEGORY_WORLD_GEN, generateHuts, "Generate livestock merchant huts in the overworld?");
        generateTrees = cfg.getBoolean("generateTrees", CATEGORY_WORLD_GEN, generateTrees, "Generate divine trees in the overworld?");
        generateTar = cfg.getBoolean("generateTar", CATEGORY_WORLD_GEN, generateTar, "Generate tar lakes in the overworld?");
        cfg.addCustomCategoryComment(CATEGORY_GUI, "GUI Config options");
        arcanaX = cfg.getInt("arcanaX", CATEGORY_GUI, 111, 1, 255, "Arcana gui width");
        arcanaY = cfg.getInt("arcanaY", CATEGORY_GUI, 18, 1, 255, "Arcana gui height");

        cfg.addCustomCategoryComment(CategoryKing, "King armor settings");
        kingCreationPercentage = cfg.getInt("kingArmorCreatePercantage", CategoryKing, 50, 10, 70,
                "Peracantage of all existing super-powers set neede to create king armor");
        maxAbsorbedCount = cfg.getInt("kingArmorMaxAbsorb", CategoryKing, 0, 0, 100,
                "How much items king armor can accept. Set 0 to remove restriction");
    }

    private static void initMobStats(Configuration cfg) {
        Map<String, Float> attrubutesMap = new LinkedHashMap<String, Float>() {{
            put("acid_hag_attack", 5.0F);
            put("acid_hag_health", 25.0F);
            put("advanced_cori_attack", 100.0F);
            put("advanced_cori_health", 35.0F);
            put("alicanto_attack", 10.0F);
            put("alicanto_health", 75.0F);
            put("ancient_entity_attack", 12.0F);
            put("ancient_entity_health", 800.0F);
            put("angry_bunny_attack", 12.0F);
            put("angry_bunny_health", 60.0F);
            put("apalachia_cadillion_attack", 12.0F);
            put("apalachia_cadillion_health", 90.0F);
            put("apalachia_golem_attack", 16.0F);
            put("apalachia_golem_health", 250.0F);
            put("apalachia_tomo_attack", 10.0F);
            put("apalachia_tomo_health", 115.0F);
            put("arid_warrior_attack", 8.0F);
            put("arid_warrior_health", 40.0F);
            put("ayeraco_blue_attack", 5.0F);
            put("ayeraco_blue_health", 600.0F);
            put("ayeraco_green_attack", 5.0F);
            put("ayeraco_green_health", 600.0F);
            put("ayeraco_purple_attack", 5.0F);
            put("ayeraco_purple_health", 600.0F);
            put("ayeraco_red_attack", 5.0F);
            put("ayeraco_red_health", 600.0F);
            put("ayeraco_yellow_attack", 5.0F);
            put("ayeraco_yellow_health", 600.0F);
            put("basilisk_attack", 6.0F);
            put("basilisk_health", 500.0F);
            put("behemoth_attack", 9.0F);
            put("behemoth_health", 180.0F);
            put("biphron_attack", 14.0F);
            put("biphron_health", 40.0F);
            put("bohemite_attack", 13.0F);
            put("bohemite_health", 60.0F);
            put("brown_grizzle_attack", 0.0F);
            put("brown_grizzle_health", 100.0F);
            put("bunny_attack", 1.0F);
            put("bunny_health", 10.0F);
            put("captain_merik_attack", 0.0F);
            put("captain_merik_health", 1000.0F);
            put("cave_crawler_attack", 4.0F);
            put("cave_crawler_health", 30.0F);
            put("caveclops_attack", 6.0F);
            put("caveclops_health", 60.0F);
            put("crab_attack", 6.0F);
            put("crab_health", 45.0F);
            put("crypt_keeper_attack", 2.0F);
            put("crypt_keeper_health", 20.0F);
            put("cyclops_attack", 5.0F);
            put("cyclops_health", 35.0F);
            put("cymesoid_attack", 8.0F);
            put("cymesoid_health", 25.0F);
            put("datticon_attack", 0.0F);
            put("datticon_health", 1000.0F);
            put("death_hound_attack", 10.0F);
            put("death_hound_health", 120.0F);
            put("deathcryx_attack", 6.0F);
            put("deathcryx_health", 6.0F);
            put("demon_of_darkness_attack", 17.0F);
            put("demon_of_darkness_health", 200.0F);
            put("densos_attack", 28.0F);
            put("densos_health", 1000.0F);
            put("desert_crawler_attack", 6.0F);
            put("desert_crawler_health", 40.0F);
            put("dissiment_attack", 0.0F);
            put("dissiment_health", 70.0F);
            put("dramix_attack", 30.0F);
            put("dramix_health", 1400.0F);
            put("dreamwrecker_attack", 8.0F);
            put("dreamwrecker_health", 60.0F);
            put("dungeon_constructor_attack", 19.0F);
            put("dungeon_constructor_health", 100.0F);
            put("dungeon_demon_attack", 17.0F);
            put("dungeon_demon_health", 85.0F);
            put("dungeon_prisoner_attack", 17.0F);
            put("dungeon_prisoner_health", 85.0F);
            put("duo_attack", 7.0F);
            put("duo_health", 20.0F);
            put("eden_cadillion_attack", 10.0F);
            put("eden_cadillion_health", 75.0F);
            put("eden_tomo_attack", 8.0F);
            put("eden_tomo_health", 100.0F);
            put("ehu_attack", 6.0F);
            put("ehu_health", 60.0F);
            put("enchanted_archer_attack", 12.0F);
            put("enchanted_archer_health", 100.0F);
            put("enchanted_warrior_attack", 14.0F);
            put("enchanted_warrior_health", 200.0F);
            put("ender_spider_attack", 8.0F);
            put("ender_spider_health", 35.0F);
            put("ender_triplets_attack", 0.0F);
            put("ender_triplets_health", 10.0F);
            put("ender_watcher_attack", 8.0F);
            put("ender_watcher_health", 50.0F);
            put("ent_attack", 20.0F);
            put("ent_health", 50.0F);
            put("enthralled_dramcryx_attack", 7.0F);
            put("enthralled_dramcryx_health", 80.0F);
            put("epiphite_attack", 14.0F);
            put("epiphite_health", 100.0F);
            put("eternal_archer_attack", 2.0F);
            put("eternal_archer_health", 1550.0F);
            put("experienced_cori_attack", 16.0F);
            put("experienced_cori_health", 1150.0F);
            put("fake_vhraak_attack", 30.0F);
            put("fake_vhraak_health", 100.0F);
            put("fractite_attack", 0.0F);
            put("fractite_health", 50.0F);
            put("frost_archer_attack", 2.0F);
            put("frost_archer_health", 40.0F);
            put("frost_attack", 6.0F);
            put("frost_health", 50.0F);
            put("frosty_attack", 20.0F);
            put("frosty_health", 150.0F);
            put("fyracryx_attack", 0.0F);
            put("fyracryx_health", 60.0F);
            put("galroid_attack", 25.0F);
            put("galroid_health", 100.0F);
            put("glacide_attack", 12.0F);
            put("glacide_health", 80.0F);
            put("glacon_attack", 7.0F);
            put("glacon_health", 60.0F);
            put("golem_of_rejuvenation_attack", 0.0F);
            put("golem_of_rejuvenation_health", 30.0F);
            put("gorgosion_attack", 2.0F);
            put("gorgosion_health", 60.0F);
            put("greenfeet_attack", 14.0F);
            put("greenfeet_health", 200.0F);
            put("hastreus_attack", 12.0F);
            put("hastreus_health", 80.0F);
            put("helio_attack", 40.0F);
            put("helio_health", 140.0F);
            put("hell_pig_attack", 5.0F);
            put("hell_pig_health", 25.0F);
            put("hell_spider_attack", 9.0F);
            put("hell_spider_health", 50.0F);
            put("herbomancer_attack", 5.0F);
            put("herbomancer_health", 40.0F);
            put("herbomancer_minion_attack", 5.0F);
            put("herbomancer_minion_health", 10.0F);
            put("hive_queen_attack", 20.0F);
            put("hive_queen_health", 1500.0F);
            put("hive_soldier_attack", 6.0F);
            put("hive_soldier_health", 20.0F);
            put("hover_stinger_attack", 8.0F);
            put("hover_stinger_health", 40.0F);
            put("husk_attack", 8.0F);
            put("husk_health", 80.0F);
            put("jack_o_man_attack", 0.0F);
            put("jack_o_man_health", 1000.0F);
            put("jungle_bat_attack", 5.0F);
            put("jungle_bat_health", 20.0F);
            put("jungle_dramcryx_attack", 7.0F);
            put("jungle_dramcryx_health", 40.0F);
            put("jungle_spider_attack", 7.0F);
            put("jungle_spider_health", 45.0F);
            put("karos_attack", 20.0F);
            put("karos_health", 4000.0F);
            put("karot_attack", 32.0F);
            put("karot_health", 1250.0F);
            put("kazrotic_attack", 2.0F);
            put("kazrotic_health", 65.0F);
            put("king_crab_attack", 9.0F);
            put("king_crab_health", 100.0F);
            put("king_of_scorchers_attack", 22.0F);
            put("king_of_scorchers_health", 1100.0F);
            put("kobblin_attack", 7.0F);
            put("kobblin_health", 35.0F);
            put("lady_luna_attack", 20.0F);
            put("lady_luna_health", 8000.0F);
            put("leorna_attack", 0.0F);
            put("leorna_health", 1000.0F);
            put("lheiva_attack", 19.0F);
            put("lheiva_health", 85.0F);
            put("liopleurodon_attack", 13.0F);
            put("liopleurodon_health", 150.0F);
            put("livestock_merchant_attack", 0.0F);
            put("livestock_merchant_health", 1000.0F);
            put("living_statue_attack", 2.0F);
            put("living_statue_health", 60.0F);
            put("lord_vatticus_attack", 0.0F);
            put("lord_vatticus_health", 1000.0F);
            put("lorga_attack", 4.0F);
            put("lorga_flight_attack", 2.0F);
            put("lorga_flight_health", 40.0F);
            put("lorga_health", 15.0F);
            put("madivel_attack", 18.0F);
            put("madivel_health", 150.0F);
            put("mage_attack", 5.0F);
            put("mage_health", 90.0F);
            put("mandragora_attack", 4.0F);
            put("mandragora_health", 35.0F);
            put("megalith_attack", 20.0F);
            put("megalith_health", 350.0F);
            put("miner_attack", 5.0F);
            put("miner_health", 40.0F);
            put("moon_wolf_attack", 1.0F);
            put("moon_wolf_health", 200.0F);
            put("mortum_cadillion_attack", 20.0F);
            put("mortum_cadillion_health", 130.0F);
            put("mysterious_man_layer_1_attack", 2.0F);
            put("mysterious_man_layer_1_health", 20.0F);
            put("mysterious_man_layer_2_attack", 2.0F);
            put("mysterious_man_layer_2_health", 20.0F);
            put("mysterious_man_layer_3_attack", 2.0F);
            put("mysterious_man_layer_3_health", 20.0F);
            put("mystic_attack", 10.0F);
            put("mystic_health", 120.0F);
            put("parasecta_attack", 16.0F);
            put("parasecta_health", 1000.0F);
            put("paratiku_attack", 0.0F);
            put("paratiku_health", 100.0F);
            put("pumpkin_spider_attack", 7.0F);
            put("pumpkin_spider_health", 50.0F);
            put("quadro_attack", 8.0F);
            put("quadro_health", 4000.0F);
            put("raglok_attack", 30.0F);
            put("raglok_health", 5000.0F);
            put("rainbour_attack", 18.0F);
            put("rainbour_health", 100.0F);
            put("razorback_attack", 7.0F);
            put("razorback_health", 35.0F);
            put("reyvor_attack", 20.0F);
            put("reyvor_health", 1000.0F);
            put("roamer_attack", 20.0F);
            put("roamer_health", 110.0F);
            put("rollum_attack", 5.0F);
            put("rollum_health", 180.0F);
            put("rotatick_attack", 6.0F);
            put("rotatick_health", 40.0F);
            put("saguaro_worm_attack", 4.0F);
            put("saguaro_worm_health", 80.0F);
            put("samek_attack", 20.0F);
            put("samek_health", 160.0F);
            put("scorcher_attack", 5.0F);
            put("scorcher_health", 75.0F);
            put("seimer_attack", 6.0F);
            put("seimer_health", 150.0F);
            put("shadahier_attack", 6.0F);
            put("shadahier_health", 10.0F);
            put("shark_attack", 8.0F);
            put("shark_health", 80.0F);
            put("skythern_archer_attack", 14.0F);
            put("skythern_archer_health", 120.0F);
            put("skythern_fiend_attack", 20.0F);
            put("skythern_fiend_health", 80.0F);
            put("skythern_golem_attack", 18.0F);
            put("skythern_golem_health", 300.0F);
            put("smelter_attack", 7.0F);
            put("smelter_health", 120.0F);
            put("snapper_attack", 4.0F);
            put("snapper_health", 150.0F);
            put("sorcerer_attack", 12.0F);
            put("sorcerer_health", 150.0F);
            put("soul_fiend_attack", 24.0F);
            put("soul_fiend_health", 1100.0F);
            put("soul_spider_attack", 12.0F);
            put("soul_spider_health", 35.0F);
            put("soul_stealer_attack", 20.0F);
            put("soul_stealer_health", 140.0F);
            put("spellbinder_attack", 7.0F);
            put("spellbinder_health", 95.0F);
            put("stone_golem_attack", 5.0F);
            put("stone_golem_health", 100.0F);
            put("sun_archer_attack", 9.0F);
            put("sun_archer_health", 60.0F);
            put("sunstorm_attack", 12.0F);
            put("sunstorm_health", 1000.0F);
            put("temple_guardian_attack", 2.0F);
            put("temple_guardian_health", 20.0F);
            put("termasect_attack", 14.0F);
            put("termasect_health", 1050.0F);
            put("termid_attack", 4.0F);
            put("termid_health", 40.0F);
            put("the_eye_attack", 10.0F);
            put("the_eye_health", 40.0F);
            put("the_grue_attack", 10.0F);
            put("the_grue_health", 30.0F);
            put("the_hunger_attack", 0.0F);
            put("the_hunger_health", 1000.0F);
            put("the_watcher_attack", 2.0F);
            put("the_watcher_health", 950.0F);
            put("tocaxin_attack", 10.0F);
            put("tocaxin_health", 65.0F);
            put("twilight_archer_attack", 16.0F);
            put("twilight_archer_health", 140.0F);
            put("twilight_demon_attack", 30.0F);
            put("twilight_demon_health", 1600.0F);
            put("twins_attack", 2.0F);
            put("twins_health", 10.0F);
            put("vamacheron_attack", 34.0F);
            put("vamacheron_health", 1350.0F);
            put("verek_attack", 12.0F);
            put("verek_health", 50.0F);
            put("vermenous_attack", 13.0F);
            put("vermenous_health", 100.0F);
            put("vhraak_attack", 30.0F);
            put("vhraak_health", 100.0F);
            put("war_general_attack", 0.0F);
            put("war_general_health", 1000.0F);
            put("weak_cori_attack", 30.0F);
            put("weak_cori_health", 35.0F);
            put("whale_attack", 8.0F);
            put("whale_health", 80.0F);
            put("white_grizzle_attack", 9.0F);
            put("white_grizzle_health", 100.0F);
            put("wildfire_attack", 8.0F);
            put("wildfire_health", 50.0F);
            put("wildwood_cadillion_attack", 12.0F);
            put("wildwood_cadillion_health", 85.0F);
            put("wildwood_golem_attack", 16.0F);
            put("wildwood_golem_health", 200.0F);
            put("wildwood_tomo_attack", 10.0F);
            put("wildwood_tomo_health", 110.0F);
            put("workshop_merchant_attack", 0.0F);
            put("workshop_merchant_health", 1000.0F);
            put("workshop_tinkerer_attack", 0.0F);
            put("workshop_tinkerer_health", 1000.0F);
            put("wraith_attack", 9.0F);
            put("wraith_health", 100.0F);
            put("wreck_attack", 30.0F);
            put("wreck_health", 1024.0F);
            put("zelus_attack", 0.0F);
            put("zelus_health", 1000.0F);
            put("zone_attack", 0.0F);
            put("zone_health", 120.0F);
            put("zoragon_attack", 0.0F);
            put("zoragon_health", 70.0F);
        }};

        while (!attrubutesMap.isEmpty()) {
            // Very first name
            String name = attrubutesMap.keySet().iterator().next();

            int i = name.lastIndexOf('_');
            if (i >= 0) {
                name = name.substring(0, i);
            }

            String comment = new TextComponentTranslation(String.format("entity.%s.%s.name", Reference.MODID, name)).getUnformattedComponentText();

            cfg.addCustomCategoryComment(name, comment);

            String attackValue = name + "_attack";
            cfg.getFloat(attackValue, name, attrubutesMap.getOrDefault(attackValue, 1F), 1F, Float.MAX_VALUE, "Attack value");
            attrubutesMap.remove(attackValue);

            String healthValue = name + "_health";
            cfg.getFloat(healthValue, name, attrubutesMap.getOrDefault(healthValue, 1F), 1F, Float.MAX_VALUE, "Health value");
            attrubutesMap.remove(healthValue);
        }
    }

    public static void readConfig() {
        readConfig(CommonProxy.config, Config::initGeneralConfig);
        readConfig(CommonProxy.mobStatsConfig, Config::initMobStats);
    }

    private static void readConfig(Configuration cfg, Consumer<Configuration> initDefault) {
        try {
            cfg.load();
            initDefault.accept(cfg);
        } catch (Exception e1) {
            DivineRPG.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    /**
     * Initialize entity attributes from config
     *
     * @param e - entity instance
     * @return
     */
    public static void initEntityAttributes(EntityLivingBase e) {
        if (e == null)
            return;

        ResourceLocation id = EntityList.getKey(e);
        if (id == null || !id.getResourceDomain().equals(Reference.MODID))
            return;

        Configuration config = CommonProxy.mobStatsConfig;
        Property property = config.get(id.getResourcePath(), id.getResourcePath() + "_health", 0F);
        getOrRegister(e, SharedMonsterAttributes.MAX_HEALTH).setBaseValue(property.getDouble());

        property = config.get(id.getResourcePath(), id.getResourcePath() + "_attack", 0F);
        getOrRegister(e, SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(property.getDouble());
    }

    /**
     * Gets ettribute from entity enad register it if needed
     *
     * @param e    - current entity
     * @param attr - attribute
     * @return
     */
    private static IAttributeInstance getOrRegister(EntityLivingBase e, IAttribute attr) {
        AbstractAttributeMap map = e.getAttributeMap();
        IAttributeInstance instance = map.getAttributeInstance(attr);

        if (instance == null) {
            map.registerAttribute(attr);
            instance = map.getAttributeInstance(attr);
        }

        return instance;
    }
}
