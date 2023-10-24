package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.enums.*;
import divinerpg.items.arcana.*;
import divinerpg.items.base.*;
import divinerpg.items.iceika.*;
import divinerpg.items.twilight.*;
import divinerpg.items.vanilla.*;
import divinerpg.items.vethea.*;
import divinerpg.util.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.*;

import java.util.Objects;
import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.MobEffectRegistry.*;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    //Item tags
    public static final TagKey<Item> WARM_ARMOR = ItemTags.create(new ResourceLocation(DivineRPG.MODID, "warm_armor"));
    
    // Armor information
    // Vanilla dimensions
    private static ArmorInfo angelicInfo = new ArmorInfo(getArmorAbility("no_fall"), getArmorAbility("fly"));
    private static ArmorInfo aquastriveInfo = new ArmorInfo(getArmorAbility("underwater"), getArmorAbility("swim"));
    private static ArmorInfo arlemiteInfo = new ArmorInfo(getArmorAbility("ranged_protection", 66));
    private static ArmorInfo bedrockInfo = new ArmorInfo(getArmorAbility("fire_protection"), getArmorAbility("explosion_protection"));
    private static ArmorInfo corruptedInfo = new ArmorInfo(getArmorAbility("ranged_damage", 50));
    private static ArmorInfo divineInfo = new ArmorInfo(getArmorAbility("melee_damage", 6),
            getArmorAbility("jump_height", 2),
            getArmorAbility("no_fall"));
    private static ArmorInfo eliteRealmiteInfo = new ArmorInfo(getArmorAbility("no_fall"));
    private static ArmorInfo enderInfo = new ArmorInfo(getArmorAbility("explosion_protection"));
    private static ArmorInfo frozenInfo = new ArmorInfo(getArmorAbility("freeze", 6));
    private static ArmorInfo infernoInfo = new ArmorInfo(getArmorAbility("fire_protection"));
    private static ArmorInfo jackomanInfo = new ArmorInfo(getArmorAbility("scythe_damage", 3));
    private static ArmorInfo jungleInfo = new ArmorInfo(getArmorAbility("poison_protection"));
    private static ArmorInfo krakenInfo = new ArmorInfo(getArmorAbility("conduit_power"));
    private static ArmorInfo torriditeInfo = new ArmorInfo(getArmorAbility("fire_protection"));
    private static ArmorInfo rupeeInfo = new ArmorInfo(getArmorAbility("melee_protection", 66));
    private static ArmorInfo shadowInfo = new ArmorInfo(getArmorAbility("speed", 4), getArmorAbility("step_assist"));
    private static ArmorInfo skelemanInfo = new ArmorInfo(getArmorAbility("hunger"));
    private static ArmorInfo terranInfo = new ArmorInfo(getArmorAbility("haste"));
    private static ArmorInfo witherReaperInfo = new ArmorInfo(getArmorAbility("wither_protection"));
//    private static ArmorInfo kingInfo = new ArmorInfo(Component.translatable("Absorbs super-power from other sets"));

    // Iceika
    private static ArmorInfo sengFurInfo = new ArmorInfo(Component.translatable("tooltip.armor_info.massive_buff"),
            getArmorAbility("speed", 2),
            getArmorAbility("melee_damage", 2),
            getArmorAbility("hunger"),
            getArmorAbility("melee_protection", 30))
            .withDimension(Component.translatable("tooltip.armor_info.iceika"), x -> Objects.equals(x, LevelRegistry.ICEIKA));

    // Twilight
    private static ArmorInfo edenInfo = new ArmorInfo(getArmorAbility("ore_drops", 3));
    private static ArmorInfo wildInfo = new ArmorInfo(getArmorAbility("water_health_regen"));
    private static ArmorInfo apInfo = new ArmorInfo(getArmorAbility("block_protection"));
    private static ArmorInfo skyInfo = new ArmorInfo(getArmorAbility("jump_height", 5), getArmorAbility("no_fall"));
    private static ArmorInfo mortInfo = new ArmorInfo(getArmorAbility("night_vision"));
    private static ArmorInfo halInfo = new ArmorInfo(getArmorAbility("melee_damage", 16));
    private static ArmorInfo awakened_halInfo = new ArmorInfo(getArmorAbility("melee_damage", 20),
            getArmorAbility("ranged_damage", 50));

    // Arcana
    private static ArmorInfo kormInfo = new ArmorInfo(getArmorAbility("arcana_regen"));
    private static ArmorInfo vemInfo = new ArmorInfo(getArmorAbility("health_regen"));

    // Vethea
    private static ArmorInfo basicHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15));
    private static ArmorInfo basicMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15));
    private static ArmorInfo basicHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15));

    private static ArmorInfo glisteningHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 3));
    private static ArmorInfo glisteningMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 1));
    private static ArmorInfo glisteningHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 2), getArmorAbility("no_fall"));
    
    private static ArmorInfo demonizedHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 6));
    private static ArmorInfo demonizedMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 2));
    private static ArmorInfo demonizedHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 3), getArmorAbility("no_fall"));
    
    private static ArmorInfo tormentedHelmInfo = new ArmorInfo(getArmorAbility("melee_protection", 15), getArmorAbility("melee_damage", 9));
    private static ArmorInfo tormentedMaskInfo = new ArmorInfo(getArmorAbility("ranged_protection", 15), getArmorAbility("speed", 3));
    private static ArmorInfo tormentedHoodInfo = new ArmorInfo(getArmorAbility("arcana_protection", 15), getArmorAbility("jump_height", 4), getArmorAbility("no_fall"));
    
    public static final RegistryObject<Item>
    //Misc
            cyclops_eye_shards = registerItem("cyclops_eye_shards"),
            cyclops_eye = registerItem("cyclops_eye"),
            crab_claw = registerItem("crab_claw"),
            shark_fin = registerItem("shark_fin"),
            whale_fin = registerItem("whale_fin"),
            liopleurodon_teeth = registerItem("liopleurodon_teeth"),
            liopleurodon_skull = registerItem("liopleurodon_skull"),
            aquatic_pellets = registerItem("aquatic_pellets"),
            pure_aquatic_pellets = registerItem("pure_aquatic_pellets"),
            aquatic_ingot = registerItem("aquatic_ingot"),
            kraken_scale = registerItem("kraken_scale"),
            kraken_skin = registerItem("kraken_skin"),
            aqua_ball = registerItem("aqua_ball"),
            aquatic_blaze_rod = registerItem("aquatic_blaze_rod"),
            raw_realmite = registerItem("raw_realmite"),
            raw_arlemite = registerItem("raw_arlemite"),
            raw_rupee = registerItem("raw_rupee"),
            healing_stone = registerItem("healing_stone", () -> new ItemHealingStone(20)),
            red_diamond_chunk = registerItem("red_diamond_chunk"),
            yellow_diamond_chunk = registerItem("yellow_diamond_chunk"),
            green_diamond_chunk = registerItem("green_diamond_chunk"),
            blue_diamond_chunk = registerItem("blue_diamond_chunk"),
            gray_diamond_chunk = registerItem("gray_diamond_chunk"),
            realmite_nugget = registerItem("realmite_nugget"),
            arlemite_nugget = registerItem("arlemite_nugget"),
            rupee_nugget = registerItem("rupee_nugget"),
            realmite_ingot = registerItem("realmite_ingot"),
            arlemite_ingot = registerItem("arlemite_ingot"),
            rupee_ingot = registerItem("rupee_ingot"),
            shadow_bar = registerItem("shadow_bar"),
            shadow_stone = registerItem("shadow_stone"),
            shadow_coins = registerItem("shadow_coins"),
            bedrock_chunk = registerItem("bedrock_chunk", () -> new ItemMod(new Item.Properties().fireResistant())),

            //Shards
            ice_shards = registerItem("ice_shards"),
            terran_shards = registerItem("terran_shards"),
            jungle_shards = registerItem("jungle_shards"),
            molten_shards = registerItem("molten_shards", () -> new ItemMod(new Item.Properties().fireResistant())),
            ender_shards = registerItem("ender_shards"),
            corrupted_shards = registerItem("corrupted_shards"),
            divine_shards = registerItem("divine_shards"),

            //Stones
            ice_stone = registerItem("ice_stone"),
            terran_stone = registerItem("terran_stone"),
            jungle_stone = registerItem("jungle_stone"),
            molten_stone = registerItem("molten_stone", () -> new ItemMod(new Item.Properties().fireResistant())),
            ender_stone = registerItem("ender_stone"),
            corrupted_stone = registerItem("corrupted_stone"),
            divine_stone = registerItem("divine_stone"),

            //Nether
            bloodgem = registerItem("bloodgem"),
            raw_torridite = registerItem("raw_torridite"),
            torridite_nugget = registerItem("torridite_nugget", () -> new ItemMod(new Item.Properties().fireResistant())),
            torridite_ingot = registerItem("torridite_ingot", () -> new ItemMod(new Item.Properties().fireResistant())),
            torridite_chunk = registerItem("torridite_chunk", () -> new ItemMod(new Item.Properties().fireResistant())),
            hellstone_ingot = registerItem("hellstone_ingot"),
            purple_blaze = registerItem("purple_blaze"),
            fury_fire = registerItem("fury_fire"),
            soulfire_stone = registerItem("soulfire_stone"),

            //Iceika
            seng_fur = registerItem("seng_fur"),
            sabear_fur = registerItem("sabear_fur"),
            sabear_tooth = registerItem("sabear_tooth"),
            snowflake = registerItem("snowflake"),
            anthracite = registerItem("anthracite", () -> new ItemModFuel(3200)),
            olivine = registerItem("olivine"),
            raw_oxdrite = registerItem("raw_oxdrite"),
            oxdrite_ingot = registerItem("oxdrite_ingot"),

            //End
            watching_eye = registerItem("watching_eye"),
            legendary_ender_eye = registerItem("legendary_ender_eye"),

            //Some Extra Stuff
            mysterious_clock = registerItem("mysterious_clock", () -> new ItemBossSpawner("message.ancient_entity", Level.OVERWORLD, () -> EntityRegistry.ANCIENT_ENTITY.get())),
            call_of_the_watcher = registerItem("call_of_the_watcher", () -> new ItemBossSpawner("message.watcher", Level.NETHER, () -> EntityRegistry.THE_WATCHER.get())),
            infernal_flame = registerItem("infernal_flame", () -> new ItemBossSpawner("message.king_of_scorchers", Level.NETHER, () -> EntityRegistry.KING_OF_SCORCHERS.get())),
            horde_horn = registerItem("horde_horn", () -> new ItemHordeHorn()),
            snow_globe = registerItem("snow_globe", () -> new ItemSnowGlobe()),
            twilight_clock = registerItem("twilight_clock", () -> new ItemTwilightClock()),
            heat_pack = registerItem("heat_pack", () -> new ItemHeatPack()),
            teleportation_crystal = registerItem("teleportation_crystal", () -> new ItemTeleportationCrystal()),
            teleportation_star = registerItem("teleportation_star", () -> new ItemTeleportationStar()),

            //Arcana
            collector_fragments = registerItem("collector_fragments"),
            collector = registerItem("collector", () -> new ItemCollector()),
            ancient_key = registerItem("ancient_key"),
            degraded_key = registerItem("degraded_key"),
            sludge_key = registerItem("sludge_key"),
            soul_key = registerItem("soul_key"),
            pieceOfRawArcanium = registerItem("piece_of_raw_arcanium"),
            arcanium = registerItem("arcanium"),
            wizards_book = registerItem("wizards_book", () -> new ItemWizardsBook()),
            dungeon_tokens = registerItem("dungeon_tokens"),
            aquamarine = registerItem("aquamarine", () -> new ItemAquamarine()),
            firestock = registerItem("firestock"),
            lamona = registerItem("lamona"),
            marsine = registerItem("marsine"),
            veilo = registerItem("veilo"),
            orb_of_light = registerItem("orb_of_light"),
            weak_arcana_potion = registerItem("weak_arcana_potion", () -> new ItemArcanaPotion(100)),
            strong_arcana_potion = registerItem("strong_arcana_potion", () -> new ItemArcanaPotion(200)),

            //Twilight Dimensions
            eden_dust = registerItem("eden_dust"),
            eden_sparkles = registerItem("eden_sparkles"),
            eden_soul = registerItem("eden_soul"),
            eden_fragments = registerItem("eden_fragments"),
            eden_gem = registerItem("eden_gem"),
            eden_chunk = registerItem("eden_chunk"),
            eden_heart = registerItem("eden_heart"),
            wildwood_dust = registerItem("wildwood_dust"),
            wildwood_soul = registerItem("wildwood_soul"),
            wildwood_fragments = registerItem("wildwood_fragments"),
            wildwood_gem = registerItem("wildwood_gem"),
            wildwood_chunk = registerItem("wildwood_chunk"),
            wildwood_heart = registerItem("wildwood_heart"),
            apalachia_dust = registerItem("apalachia_dust"),
            apalachia_soul = registerItem("apalachia_soul"),
            apalachia_fragments = registerItem("apalachia_fragments"),
            apalachia_gem = registerItem("apalachia_gem"),
            apalachia_chunk = registerItem("apalachia_chunk"),
            apalachia_heart = registerItem("apalachia_heart"),
            skythern_dust = registerItem("skythern_dust"),
            skythern_soul = registerItem("skythern_soul"),
            skythern_fragments = registerItem("skythern_fragments"),
            skythern_gem = registerItem("skythern_gem"),
            skythern_chunk = registerItem("skythern_chunk"),
            skythern_heart = registerItem("skythern_heart"),
            mortum_dust = registerItem("mortum_dust"),
            mortum_soul = registerItem("mortum_soul"),
            mortum_fragments = registerItem("mortum_fragments"),
            mortum_gem = registerItem("mortum_gem"),
            mortum_chunk = registerItem("mortum_chunk"),
            mortum_heart = registerItem("mortum_heart"),

            //Spawn Crystals
            base_spawn_crystal = registerItem("base_spawn_crystal"),
            vamacheron_crystal = registerItem("vamacheron_crystal", () -> new ItemBossSpawner("tooltip.mortum_only", LevelRegistry.MORTUM, () -> EntityRegistry.VAMACHERON.get())),
            karot_crystal = registerItem("karot_crystal", () -> new ItemBossSpawner("tooltip.mortum_only", LevelRegistry.MORTUM, () -> EntityRegistry.KAROT.get())),
            twilight_demon_crystal = registerItem("twilight_demon_crystal", () -> new ItemBossSpawner("tooltip.mortum_only", LevelRegistry.MORTUM, () -> EntityRegistry.TWILIGHT_DEMON.get())),
            densos_crystal = registerItem("densos_crystal", () -> new ItemBossSpawner("tooltip.mortum_only", LevelRegistry.MORTUM, () -> EntityRegistry.DENSOS.get())),
            reyvor_crystal = registerItem("reyvor_crystal", () -> new ItemBossSpawner("tooltip.mortum_only", LevelRegistry.MORTUM, () -> EntityRegistry.REYVOR.get())),
            soul_fiend_crystal = registerItem("soul_fiend_crystal", () -> new ItemBossSpawner("tooltip.mortum_only", LevelRegistry.MORTUM, () -> EntityRegistry.SOUL_FIEND.get())),

            //Food
            bacon = registerItem("bacon", () -> new ItemModFood(FoodList.BACON)),
            boiled_egg = registerItem("boiled_egg", () -> new ItemModFood(FoodList.BOILED_EGG)),
            cheese = registerItem("cheese", () -> new ItemModFood(FoodList.CHEESE)),
            donut = registerItem("donut", () -> new ItemModFood(FoodList.DONUT)),
            hot_pumpkin_pie = registerItem("hot_pumpkin_pie", () -> new ItemModFood(FoodList.HOT_PUMPKIN_PIE)),
            tomato = registerItem("tomato", () -> new ItemTomato()),
            white_mushroom = registerItem("white_mushroom", () -> new ItemModFood(FoodList.WHITE_MUSHROOM)),
            advanced_mushroom_stew = registerItem("advanced_mushroom_stew", () -> new BowlFoodItem(new Item.Properties().food(FoodList.ADVANCED_MUSHROOM_STEW).stacksTo(1))),
            chicken_dinner = registerItem("chicken_dinner", () -> new BowlFoodItem(new Item.Properties().food(FoodList.CHICKEN_DINNER).stacksTo(1))),
            raw_seng_meat = registerItem("raw_seng_meat", () -> new ItemModFood(FoodList.RAW_SENG_MEAT)),
            seng_steak = registerItem("seng_steak", () -> new ItemModFood(FoodList.COOKED_SENG_STEAK)),
            raw_wolpertinger_meat = registerItem("raw_wolpertinger_meat", () -> new ItemModFood(FoodList.RAW_WOLPERTINGER_MEAT)),
            wolpertinger_steak = registerItem("wolpertinger_steak", () -> new ItemModFood(FoodList.COOKED_WOLPERTINGER_STEAK)),
            chocolate_log = registerItem("chocolate_log", () -> new ItemModFood(FoodList.CHOCOLATE_LOG)),
            egg_nog = registerItem("egg_nog", () -> new ItemEggNog()),
            fruit_cake = registerItem("fruit_cake", () -> new ItemModFood(FoodList.FRUIT_CAKE)),
            peppermints = registerItem("peppermints", () -> new ItemModFood(FoodList.PEPPERMINTS)),
            snow_cones = registerItem("snow_cones", () -> new ItemModFood(FoodList.SNOW_CONES)),
            winterberry = registerItem("winterberry", () -> new ItemWinterberry()),
            hitchak = registerItem("hitchak", () -> new ItemModFood(FoodList.HITCHAK)),
            pinfly = registerItem("pinfly", () -> new ItemModFood(FoodList.PINFLY)),
            raw_empowered_meat = registerItem("raw_empowered_meat", () -> new ItemModFood(FoodList.RAW_EMPOWERED_MEAT)),
            empowered_meat = registerItem("empowered_meat", () -> new ItemModFood(FoodList.EMPOWERED_MEAT)),
            magic_meat = registerItem("magic_meat", () -> new ItemModFood(FoodList.MAGIC_MEAT, true)),
            enriched_magic_meat = registerItem("enriched_magic_meat", () -> new ItemModFood(FoodList.ENRICHED_MAGIC_MEAT, true)),
            forbidden_fruit = registerItem("forbidden_fruit", () -> new ItemForbiddenFruit()),
            moonbulb = registerItem("moonbulb", () -> new ItemModFood(FoodList.MOONBULB, true)),
            pink_glowbone = registerItem("pink_glowbone", () -> new ItemModFood(FoodList.PINK_GLOWBONE, true)),
            purple_glowbone = registerItem("purple_glowbone", () -> new ItemModFood(FoodList.PURPLE_GLOWBONE, true)),
            sky_flower = registerItem("sky_flower", () -> new ItemSkyFlower()),
            dream_cake = registerItem("dream_cake", () -> new ItemModFood(FoodList.DREAM_CAKE)),
            dream_carrot = registerItem("dream_carrot", () -> new ItemModFood(FoodList.DREAM_CARROT)),
            dream_melon = registerItem("dream_melon", () -> new ItemModFood(FoodList.DREAM_MELON)),
            dream_pie = registerItem("dream_pie", () -> new ItemModFood(FoodList.DREAM_PIE)),
            dream_sweets = registerItem("dream_sweets", () -> new ItemHealingFood(FoodList.DREAM_SWEETS)),
            dream_sours = registerItem("dream_sours", () -> new ItemHealingFood(FoodList.DREAM_SOURS)),
            honeychunk = registerItem("honeychunk", () -> new ItemModFood(FoodList.HONEYCHUNK)),
            honeysuckle = registerItem("honeysuckle", () -> new ItemModFood(FoodList.HONEYSUCKLE)),

            //Seeds
            tomato_seeds = registerItem("tomato_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "tomato_plant")), new Item.Properties())),
            white_mushroom_seeds = registerItem("white_mushroom_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "white_mushroom_plant")), new Item.Properties())),
            aquamarine_seeds = registerItem("aquamarine_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "aquamarine_plant")), new Item.Properties())),
            eucalyptus_root_seeds = registerItem("eucalyptus_root_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eucalyptus_plant")), new Item.Properties())),
            firestock_seeds = registerItem("firestock_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firestock_plant")), new Item.Properties())),
            hitchak_seeds = registerItem("hitchak_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hitchak_plant")), new Item.Properties())),
            lamona_seeds = registerItem("lamona_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "lamona_plant")), new Item.Properties())),
            marsine_seeds = registerItem("marsine_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "marsine_plant")), new Item.Properties())),
            pinfly_seeds = registerItem("pinfly_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "pinfly_plant")), new Item.Properties())),
            veilo_seeds = registerItem("veilo_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "veilo_plant")), new Item.Properties())),
            moonbulb_seeds = registerItem("moonbulb_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb_plant")), new Item.Properties())),
            pink_glowbone_seeds = registerItem("pink_glowbone_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "pink_glowbone_plant")), new Item.Properties())),
            purple_glowbone_seeds = registerItem("purple_glowbone_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "purple_glowbone_plant")), new Item.Properties())),
            sky_plant_seeds = registerItem("sky_plant_seeds", () -> new ItemNameBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sky_plant")), new Item.Properties())),

            //Vethea
            acid = registerItemVethean("acid"),
            rock_chunks = registerItemVethean("rock_chunks"),
            dirty_pearls = registerItemVethean("dirty_pearls"),
            clean_pearls = registerItemVethean("clean_pearls"),
            polished_pearls = registerItemVethean("polished_pearls"),
            shiny_pearls = registerItemVethean("shiny_pearls"),
            teaker_lump = registerItemVethean("teaker_lump"),
            amthirmis_lump = registerItemVethean("amthirmis_lump"),
            darven_lump = registerItemVethean("darven_lump"),
            cermile_lump = registerItemVethean("cermile_lump"),
            pardimal_lump = registerItemVethean("pardimal_lump"),
            quadrotic_lump = registerItemVethean("quadrotic_lump"),
            karos_lump = registerItemVethean("karos_lump"),
            heliosis_lump = registerItemVethean("heliosis_lump"),
            arksiane_lump = registerItemVethean("arksiane_lump"),
            backsword_template = registerItemVethean("backsword_template"),
            hammer_template = registerItemVethean("hammer_template"),
            claw_template = registerItemVethean("claw_template"),
            bow_template = registerItemVethean("bow_template"),
            staff_template = registerItemVethean("staff_template"),
            cannon_template = registerItemVethean("cannon_template"),
            disk_template = registerItemVethean("disk_template"),
            dissipator_template = registerItemVethean("dissipator_template"),
            degraded_template = registerItemVethean("degraded_template"),
            finished_template = registerItemVethean("finished_template"),
            glistening_template = registerItemVethean("glistening_template"),
            demonized_template = registerItemVethean("demonized_template"),
            tormented_template = registerItemVethean("tormented_template"),
            dream_flint = registerItem("dream_flint", () -> new ItemDreamFlint()),
            moon_clock = registerItemVethean("moon_clock"),
            miners_amulet = registerItem("miners_amulet", () -> new ItemMinersAmulet()),
            band_of_heiva_hunting = registerItemVethean("band_of_heiva_hunting"),

            //Pets
            snapper_egg = registerItem("snapper_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.SNAPPER.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            ehu_egg = registerItem("ehu_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.EHU.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            husk_egg = registerItem("husk_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.HUSK.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            brown_grizzle_egg = registerItem("brown_grizzle_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.BROWN_GRIZZLE.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            white_grizzle_egg = registerItem("white_grizzle_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.WHITE_GRIZZLE.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            stone_golem_egg = registerItem("stone_golem_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.STONE_GOLEM.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            smelter_egg = registerItem("smelter_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.SMELTER.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            fyracryx_egg = registerItem("fyracryx_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.FYRACRYX.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            golem_of_rejuvenation_egg = registerItem("golem_of_rejuvenation_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.GOLEM_OF_REJUVENATION.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            paratiku_egg = registerItem("paratiku_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.PARATIKU.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),
            seimer_egg = registerItem("seimer_spawn_egg", () -> new ForgeSpawnEggItem(() -> EntityRegistry.SEIMER.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties())),


    //Tools, Weapons & Armor
            //Swords
            cyclopsian_sword = registerItem("cyclopsian_sword", () -> new ItemModSword(ToolStats.CYCLOPSIAN_SWORD)),
            slime_sword = registerItem("slime_sword", () -> new ItemModSword(ToolStats.SLIME_SWORD)),
            glacier_sword = registerItem("glacier_sword", () -> new ItemSlowingSword(ToolStats.GLACIER_SWORD)),
            crabclaw_maul = registerItem("crabclaw_maul", () -> new ItemModSword(ToolStats.CRABCLAW_MAUL)),
            dual_claw = registerItem("dual_claw", () -> new ItemModSword(ToolStats.DUAL_CLAW)),
            shark_sword = registerItem("shark_sword", () -> new ItemModSword(ToolStats.SHARK_SWORD)),
            aquatooth_sword = registerItem("aquatooth_sword", () -> new ItemModSword(ToolStats.AQUATOOTH_SWORD)),
            aquatooth_maul = registerItem("aquatooth_maul", () -> new ItemModSword(ToolStats.AQUATOOTH_MAUL)),
            aquatic_dagger = registerItem("aquatic_dagger", () -> new ItemModSword(ToolStats.AQUA_DAGGER)),
            ocean_knife = registerItem("ocean_knife", () -> new ItemModSword(ToolStats.OCEAN_KNIFE)),
            aquatic_trident = registerItem("aquatic_trident", () -> new ItemModSword(ToolStats.AQUA_TRIDENT)),
            aquaton = registerItem("aquaton", () -> new ItemModSword(ToolStats.AQUATON)),
            aquatic_maul = registerItem("aquatic_maul", () -> new ItemModSword(ToolStats.AQUA_MAUL)),
            realmite_sword = registerItem("realmite_sword", () -> new ItemModSword(ToolStats.REALMITE_SWORD)),
            arlemite_stabber = registerItem("arlemite_stabber", () -> new ItemModSword(ToolStats.ARLEMITE_STABBER)),
            rupee_rapier = registerItem("rupee_rapier", () -> new ItemModSword(ToolStats.RUPEE_RAPIER)),
            bedrock_sword = registerItem("bedrock_sword", () -> new ItemModSword(ToolStats.BEDROCK_SWORD, new Item.Properties().fireResistant())),
            bedrock_maul = registerItem("bedrock_maul", () -> new ItemModSword(ToolStats.BEDROCK_MAUL, new Item.Properties().fireResistant())),
            frozen_maul = registerItem("frozen_maul", () -> new ItemSlowingSword(ToolStats.FROZEN_MAUL)),
            fury_maul = registerItem("fury_maul", () -> new ItemModSword(ToolStats.FURY_MAUL)),
            frost_sword = registerItem("frost_sword", () -> new ItemSlowingSword(ToolStats.FROST_SWORD)),
            frostking_sword = registerItem("frostking_sword", () -> new ItemSlowingSword(ToolStats.FROSTKING_SWORD)),
            icicle_bane = registerItem("icicle_bane", () -> new ItemSlowingSword(ToolStats.ICICLE_BANE)),
            terran_dagger = registerItem("terran_dagger", () -> new ItemModSword(ToolStats.TERRAN_DAGGER)),
            terran_knife = registerItem("terran_knife", () -> new ItemModSword(ToolStats.TERRAN_KNIFE)),
            terran_maul = registerItem("terran_maul", () -> new ItemModSword(ToolStats.TERRAN_MAUL)),
            jungle_knife = registerItem("jungle_knife", () -> new ItemPoisonousSword(ToolStats.JUNGLE_KNIFE, 2.5f)),
            jungle_rapier = registerItem("jungle_rapier", () -> new ItemPoisonousSword(ToolStats.JUNGLE_RAPIER, 4f)),
            poison_saber = registerItem("poison_saber", () -> new ItemPoisonousSword(ToolStats.POISON_SABER, 5)),
            bloodgem_sword = registerItem("bloodgem_sword", () -> new ItemModSword(ToolStats.BLOODGEM_SWORD)),
            molten_sword = registerItem("molten_sword", () -> new ItemBurningSword(ToolStats.MOLTEN_SWORD, 5)),
            scorching_sword = registerItem("scorching_sword", () -> new ItemModSword(ToolStats.SCORCHING_SWORD)),
            soulfire_sword = registerItem("soulfire_sword", () -> new ItemModSword(ToolStats.SOULFIRE_SWORD)),
            inferno_sword = registerItem("inferno_sword", () -> new ItemBurningSword(ToolStats.INFERNO_SWORD, 12)),
            flaming_fury = registerItem("flaming_fury", () -> new ItemBurningSword(ToolStats.FLAMING_FURY, 15)),
            sabear_sabre = registerItem("sabear_sabre", () -> new ItemModSword(ToolStats.SABEAR_SABRE)),
            ender_sword = registerItem("ender_sword", () -> new ItemModSword(RarityList.ENDER, ToolStats.ENDER_SWORD)),
            red_ender_sword = registerItem("red_ender_sword", () -> new ItemModSword(RarityList.RED, ToolStats.ENDER_SWORD)),
            yellow_ender_sword = registerItem("yellow_ender_sword", () -> new ItemModSword(RarityList.YELLOW, ToolStats.ENDER_SWORD)),
            green_ender_sword = registerItem("green_ender_sword", () -> new ItemModSword(RarityList.GREEN, ToolStats.ENDER_SWORD)),
            blue_ender_sword = registerItem("blue_ender_sword", () -> new ItemModSword(RarityList.BLUE, ToolStats.ENDER_SWORD)),
            black_ender_sword = registerItem("black_ender_sword", () -> new ItemModSword(RarityList.DARK, ToolStats.ENDER_SWORD)),
            enderice = registerItem("enderice", () -> new ItemSlowingSword(ToolStats.ENDERICE)),
            death_bringer = registerItem("death_bringer", () -> new ItemModSword(ToolStats.DEATH_BRINGER)),
            corrupted_maul = registerItem("corrupted_maul", () -> new ItemModSword(ToolStats.CORRUPTED_MAUL)),
            divine_sword = registerItem("divine_sword", () -> new ItemModSword(RarityList.DIVINE, ToolStats.DIVINE_SWORD)),
            red_divine_sword = registerItem("red_divine_sword", () -> new ItemModSword(RarityList.RED, ToolStats.DIVINE_SWORD)),
            yellow_divine_sword = registerItem("yellow_divine_sword", () -> new ItemModSword(RarityList.YELLOW, ToolStats.DIVINE_SWORD)),
            green_divine_sword = registerItem("green_divine_sword", () -> new ItemModSword(RarityList.GREEN, ToolStats.DIVINE_SWORD)),
            blue_divine_sword = registerItem("blue_divine_sword", () -> new ItemModSword(RarityList.BLUE, ToolStats.DIVINE_SWORD)),
            gray_divine_sword = registerItem("gray_divine_sword", () -> new ItemModSword(RarityList.DARK, ToolStats.DIVINE_SWORD)),
            icine_sword = registerItem("icine_sword", () -> new ItemSlowingSword(ToolStats.ICINE_SWORD)),
            sandslash = registerItem("sandslash", () -> new ItemModSword(ToolStats.SANDSLASH)),
            snowslash = registerItem("snowslash", () -> new ItemSlowingSword(ToolStats.SNOWSLASH)),
            storm_sword = registerItem("storm_sword", () -> new ItemStormSword(ToolStats.STORM_SWORD)),
            arcanium_saber = registerItem("arcanium_saber", () -> new ItemArcanaPoweredSword(ToolStats.ARCANIUM_SABER, 25, 5.0F)),
            shadow_saber = registerItem("shadow_saber", () -> new ItemShadowSaber(ToolStats.SHADOW_SABER)),
            livicia_sword = registerItem("livicia_sword", () -> new ItemModSword(ToolStats.LIVICIA_SWORD)),
            arcanite_blade = registerItem("arcanite_blade", () -> new ItemArcanaPoweredSword(ToolStats.ARCANITE_BLADE, 30, 6.0F)),
            eden_blade = registerItem("eden_blade", () -> new ItemModSword(RarityList.EDEN, ToolStats.EDEN_BLADE)),
            wildwood_blade = registerItem("wildwood_blade", () -> new ItemModSword(RarityList.WILDWOOD, ToolStats.WILDWOOD_BLADE)),
            apalachia_blade = registerItem("apalachia_blade", () -> new ItemModSword(RarityList.APALACHIA, ToolStats.APALACHIA_BLADE)),
            skythern_blade = registerItem("skythern_blade", () -> new ItemModSword(RarityList.SKYTHERN, ToolStats.SKYTHERN_BLADE)),
            mortum_blade = registerItem("mortum_blade", () -> new ItemModSword(RarityList.MORTUM, ToolStats.MORTUM_BLADE)),
            halite_blade = registerItem("halite_blade", () -> new ItemModSword(RarityList.HALITE, ToolStats.HALITE_BLADE)),

            //Healing
            palavence = registerItem("palavence", () -> new ItemHealingSword(ToolStats.PALAVENCE, 0.5F)),
            massivence = registerItem("massivence", () -> new ItemHealingSword(ToolStats.PALAVENCE, 1F)),
            frossivence = registerItem("frossivence", () -> new ItemHealingSword(ToolStats.FROSSIVENCE, 1F)),

            //Shields
            realmite_shield = registerItem("realmite_shield", () -> new DivineShield(new ResourceLocation(DivineRPG.MODID, "realmite_ingot"), 1200, "realmite_shield")),
            arlemite_shield = registerItem("arlemite_shield", () -> new DivineShield(new ResourceLocation(DivineRPG.MODID, "arlemite_ingot"), 1200, "arlemite_shield")),
            rupee_shield = registerItem("rupee_shield", () -> new DivineShield(new ResourceLocation(DivineRPG.MODID, "rupee_ingot"), 1200, "rupee_shield")),
            eden_shield = registerItem("eden_shield", () -> new DivineShield(RarityList.EDEN, new ResourceLocation(DivineRPG.MODID, "eden_chunk"), 1200, "eden_shield")),
            wildwood_shield = registerItem("wildwood_shield", () -> new DivineShield(RarityList.WILDWOOD, new ResourceLocation(DivineRPG.MODID, "wildwood_chunk"), 2400, "wildwood_shield")),
            apalachia_shield = registerItem("apalachia_shield", () -> new DivineShield(RarityList.APALACHIA, new ResourceLocation(DivineRPG.MODID, "apalachia_chunk"), 4800, "apalachia_shield")),
            skythern_shield = registerItem("skythern_shield", () -> new DivineShield(RarityList.SKYTHERN, new ResourceLocation(DivineRPG.MODID, "skythern_chunk"), 9600, "skythern_shield")),
            mortum_shield = registerItem("mortum_shield", () -> new DivineShield(RarityList.MORTUM, new ResourceLocation(DivineRPG.MODID, "mortum_chunk"), 19200, "mortum_shield")),
            halite_shield = registerItem("halite_shield", () -> new DivineShield(RarityList.HALITE, new ResourceLocation("air") , 0, "halite_shield")),

            //Serenades
            serenade_striker = registerItem("serenade_striker", () -> new ItemSerenadeStriker()),
            serenade_of_ice = registerItem("serenade_of_ice", () -> new ItemSerenadeOfIce()),
            serenade_of_death = registerItem("serenade_of_death", () -> new ItemSerenadeOfDeath()),
            serenade_of_health = registerItem("serenade_of_health", () -> new ItemSerenadeOfHealth()),
            serenade_of_infusion = registerItem("serenade_of_infusion", () -> new ItemSerenadeOfInfusion()),

            //Bows
            hunter_bow = registerItem("hunter_bow", () -> new ItemModBow(ArrowType.HUNTER_ARROW, 2500, new ResourceLocation("arrow"))),
            shadow_bow = registerItem("shadow_bow", () -> new ItemModBow(ArrowType.SHADOW_ARROW, 10000, 36000, new ResourceLocation("arrow"))),
            icicle_bow = registerItem("icicle_bow", () -> new ItemModBow(ArrowType.ICICLE_ARROW, 10000, 24000, new ResourceLocation("arrow"))),
            inferno_bow = registerItem("inferno_bow", () -> new ItemModBow(ArrowType.INFERNO_ARROW, 10000, ItemModBow.DEFAULT_MAX_USE_DURATION, null, new Item.Properties().durability(10000).fireResistant())),
            soulfire_bow = registerItem("soulfire_bow", () -> new ItemModBow(ArrowType.SOULFIRE_ARROW, -1)),
            snowstorm_bow = registerItem("snowstorm_bow", () -> new ItemModBow(ArrowType.SNOWSTORM_ARROW, -1)),
            ender_bow = registerItem("ender_bow", () -> new ItemModBow(RarityList.ENDER, ArrowType.ENDER_ARROW, -1)),
            eden_bow = registerItem("eden_bow", () -> new ItemModBow(RarityList.EDEN, ArrowType.EDEN_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "eden_arrow"))),
            wildwood_bow = registerItem("wildwood_bow", () -> new ItemModBow(RarityList.WILDWOOD, ArrowType.LESSER_WILDWOOD_ARROW, -1, 36000, new ResourceLocation(DivineRPG.MODID, "wildwood_arrow"))),
            apalachia_bow = registerItem("apalachia_bow", () -> new ItemModBow(RarityList.APALACHIA, ArrowType.GREATER_WILDWOOD_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "wildwood_arrow"))),
            skythern_bow = registerItem("skythern_bow", () -> new ItemModBow(RarityList.SKYTHERN, ArrowType.GREATER_WILDWOOD_ARROW, -1, 36000, new ResourceLocation(DivineRPG.MODID, "wildwood_arrow"))),
            mortum_bow = registerItem("mortum_bow", () -> new ItemModBow(RarityList.MORTUM, ArrowType.FURY_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "fury_arrow"))),
            halite_bow = registerItem("halite_bow", () -> new ItemModBow(RarityList.HALITE, ArrowType.FURY_ARROW, -1, 36000, new ResourceLocation(DivineRPG.MODID, "fury_arrow"))),
            twilight_bow = registerItem("twilight_bow", () -> new ItemModBow(ArrowType.FURY_ARROW, -1, 14400, new ResourceLocation(DivineRPG.MODID, "fury_arrow"))),

            //Arrows
            eden_arrow = registerItem("eden_arrow"),
            wildwood_arrow = registerItem("wildwood_arrow"),
            fury_arrow = registerItem("fury_arrow"),

            //Anchors
            crab_anchor = registerItem("crab_anchor", () -> new ItemAnchor(BulletType.CRAB_ANCHOR_SHOT)),
            shark_anchor = registerItem("shark_anchor", () -> new ItemAnchor(BulletType.SHARK_ANCHOR_SHOT)),
            bowhead_anchor = registerItem("bowhead_anchor", () -> new ItemAnchor(BulletType.BOWHEAD_ANCHOR_SHOT)),
            liopleurodon_anchor = registerItem("liopleurodon_anchor", () -> new ItemAnchor(BulletType.LIOPLEURODON_ANCHOR_SHOT)),

            //Harps
            sound_of_music = registerItem("sound_of_music", () -> new ItemMusicShooter(() -> SoundRegistry.SOUND_OF_MUSIC.get(), "sound_of_music")),
            sound_of_carols = registerItem("sound_of_carols", () -> new ItemMusicShooter(() -> SoundRegistry.SOUND_OF_CAROLS.get(), "sound_of_carols")),
            sound_of_whales = registerItem("sound_of_whales", () -> new ItemMusicShooter(() -> SoundRegistry.WHALE.get(), "sound_of_whales")),

            //Extra
            shuriken = registerItem("shuriken", () -> new ItemThrowingStar()),
            snowflake_shuriken = registerItem("snowflake_shuriken", () -> new ItemThrowingStar()),
            vile_storm = registerItem("vile_storm", () -> new ItemThrowingStar()),
            scythe = registerItem("scythe", () -> new ItemScythe()),
            cyclopsian_staff = registerItem("cyclopsian_staff", () -> new ItemModRanged(BulletType.CYCLOPSIAN_STAFF_SHOT, () -> SoundRegistry.STAFF.get(), 600, 0)),
            crabclaw_cannon = registerItem("crabclaw_cannon", () -> new ItemModRanged(BulletType.CRABCLAW_CANNON_SHOT, () -> SoundRegistry.GHAST_CANNON.get(), new ResourceLocation("cactus"), 1000, 12)),
            frostclaw_cannon = registerItem("frostclaw_cannon", () -> new ItemModRanged(BulletType.FROSTCLAW_CANNON_SHOT, () -> SoundRegistry.FROSTCLAW_CANNON.get(), new ResourceLocation("cactus"), 10000, 0)),
            bowhead_cannon = registerItem("bowhead_cannon", () -> new ItemModRanged(BulletType.BOWHEAD_CANNON_SHOT, () -> SoundRegistry.GHAST_CANNON.get(), new ResourceLocation("cactus"), 1000, 12)),
            frost_cannon = registerItem("frost_cannon", () -> new ItemModRanged(BulletType.FROST_CANNON_SHOT, () -> SoundRegistry.FROST_CANNON.get(), new ResourceLocation("snowball"), 15000, 0)),
            fractite_cannon = registerItem("fractite_cannon", () -> new ItemModRanged(BulletType.FRACTITE_CANNON_SHOT, () -> SoundRegistry.FRACTITE_CANNON.get(), new ResourceLocation(MODID, "ice_shards"), 10000, 0)),
            maelstrom = registerItem("maelstrom", () -> new ItemModRanged(BulletType.MAELSTROM_SHOT, () -> SoundRegistry.GHAST_CANNON.get(), 100, 0)),
            ghast_cannon = registerItem("ghast_cannon", () -> new ItemModRanged(BulletType.GHAST_CANNON_SHOT, () -> SoundRegistry.GHAST_CANNON.get(), 100, 20)),
            corrupted_cannon = registerItem("corrupted_cannon", () -> new ItemCorruptedCannon()),
            corrupted_bullet = registerItem("corrupted_bullet"),
            golden_fury = registerItem("golden_fury", () -> new ItemModRanged(BulletType.GOLDEN_FURY_SHOT, () -> SoundRegistry.BLITZ.get(), new ResourceLocation("gold_nugget"), -1, 0)),

            //Arcana
            divine_accumulator = registerItem("divine_accumulator", () -> new ItemDivineAccumulator()),
            ghostbane = registerItem("ghostbane", () -> new ItemGhostbane()),
            staff_of_enrichment = registerItem("staff_of_enrichment", () -> new ItemStaffEnrichment()),
            ender_scepter = registerItem("ender_scepter", () -> new ItemEnderScepter()),
            arcanium_attractor = registerItem("arcanium_attractor", () -> new ItemAttractor()),
            arcanium_reflector = registerItem("arcanium_reflector", () -> new ItemReflector()),
            captains_sparkler = registerItem("captains_sparkler", () -> new ItemCaptainsSparkler()),
            arcanite_blaster = registerItem("arcanite_blaster", () -> new ItemArcaniteBlaster()),
            la_vekor = registerItem("la_vekor", () -> new ItemLaVekor()),
            grenade = registerItem("grenade", () -> new ItemGrenade()),
            firefly = registerItem("firefly", () -> new ItemFirefly()),
            meriks_missile = registerItem("meriks_missile", () -> new ItemMeriksMissile()),
            generals_staff = registerItem("generals_staff", () -> new ItemGeneralsStaff()),
            starlight = registerItem("starlight", () -> new ItemStaffStarlight(5, 1)),
            staff_of_starlight = registerItem("staff_of_starlight", () -> new ItemStaffStarlight(25, 8)),
            meteor_mash = registerItem("meteor_mash", () -> new ItemMeteorMash()),

            //Blitz
            eden_blitz = registerItem("eden_blitz", () -> new ItemTwilightBlitz(RarityList.EDEN, BulletType.EDEN_BLITZ_SHOT, new ResourceLocation(DivineRPG.MODID, "eden_dust"))),
            wildwood_blitz = registerItem("wildwood_blitz", () -> new ItemTwilightBlitz(RarityList.WILDWOOD, BulletType.WILDWOOD_BLITZ_SHOT, new ResourceLocation(DivineRPG.MODID, "wildwood_dust"))),
            apalachia_blitz = registerItem("apalachia_blitz", () -> new ItemTwilightBlitz(RarityList.APALACHIA, BulletType.APALACHIA_BLITZ_SHOT, new ResourceLocation(DivineRPG.MODID, "apalachia_dust"))),
            skythern_blitz = registerItem("skythern_blitz", () -> new ItemTwilightBlitz(RarityList.SKYTHERN, BulletType.SKYTHERN_BLITZ_SHOT, new ResourceLocation(DivineRPG.MODID, "skythern_dust"))),
            mortum_blitz = registerItem("mortum_blitz", () -> new ItemTwilightBlitz(RarityList.MORTUM, BulletType.MORTUM_BLITZ_SHOT, new ResourceLocation(DivineRPG.MODID, "mortum_dust"))),
            halite_blitz = registerItem("halite_blitz", () -> new ItemTwilightBlitz(RarityList.HALITE, BulletType.HALITE_BLITZ_SHOT, new ResourceLocation(DivineRPG.MODID, "mortum_dust"))),

            //Phasers
            eden_phaser = registerItem("eden_phaser", () -> new ItemModRanged(RarityList.EDEN, BulletType.EDEN_PHASER_SHOT, () -> SoundRegistry.PHASER.get(), 3000, 12)),
            wildwood_phaser = registerItem("wildwood_phaser", () -> new ItemModRanged( RarityList.WILDWOOD, BulletType.WILDWOOD_PHASER_SHOT, () -> SoundRegistry.PHASER.get(), 3000, 12)),
            apalachia_phaser = registerItem("apalachia_phaser", () -> new ItemModRanged(RarityList.APALACHIA, BulletType.APALACHIA_PHASER_SHOT, () -> SoundRegistry.PHASER.get(), 3000, 12)),
            skythern_phaser = registerItem("skythern_phaser", () -> new ItemModRanged(RarityList.SKYTHERN, BulletType.SKYTHERN_PHASER_SHOT, () -> SoundRegistry.PHASER.get(), 3000, 12)),
            mortum_phaser = registerItem("mortum_phaser", () -> new ItemModRanged(RarityList.MORTUM, BulletType.MORTUM_PHASER_SHOT, () -> SoundRegistry.PHASER.get(), 3000, 12)),
            halite_phaser = registerItem("halite_phaser", () -> new ItemModRanged(RarityList.HALITE, BulletType.HALITE_PHASER_SHOT, () -> SoundRegistry.PHASER.get(), 3000, 12)),

            //Slicers
            eden_slicer = registerItem("eden_slicer", () -> new ItemModThrowable(RarityList.EDEN, BulletType.EDEN_SLICER_SHOT)),
            wildwood_slicer = registerItem("wildwood_slicer", () -> new ItemModThrowable(RarityList.WILDWOOD, BulletType.WILDWOOD_SLICER_SHOT)),
            apalachia_slicer = registerItem("apalachia_slicer", () -> new ItemModThrowable(RarityList.APALACHIA, BulletType.APALACHIA_SLICER_SHOT)),
            skythern_slicer = registerItem("skythern_slicer", () -> new ItemModThrowable(RarityList.SKYTHERN, BulletType.SKYTHERN_SLICER_SHOT)),
            mortum_slicer = registerItem("mortum_slicer", () -> new ItemModThrowable(RarityList.MORTUM, BulletType.MORTUM_SLICER_SHOT)),
            halite_slicer = registerItem("halite_slicer", () -> new ItemModThrowable(RarityList.HALITE, BulletType.HALITE_SLICER_SHOT)),

    //Tool Sets
    oxdrite_pickaxe = registerItem("oxdrite_pickaxe", () -> new ItemModPickaxe(ToolStats.OXDRITE_PICKAXE)),

    realmite_shovel = registerItem("realmite_shovel", () -> new ItemModShovel(ToolStats.REALMITE_SHOVEL)),
            realmite_pickaxe = registerItem("realmite_pickaxe", () -> new ItemModPickaxe(ToolStats.REALMITE_PICKAXE)),
            realmite_axe = registerItem("realmite_axe", () -> new ItemModAxe(ToolStats.REALMITE_AXE)),
            realmite_hoe = registerItem("realmite_hoe", () -> new ItemModHoe(ToolStats.REALMITE_PICKAXE)),

    arlemite_shovel = registerItem("arlemite_shovel", () -> new ItemModShovel(ToolStats.ARLEMITE_SHOVEL)),
            arlemite_pickaxe = registerItem("arlemite_pickaxe", () -> new ItemModPickaxe(ToolStats.ARLEMITE_PICKAXE)),
            arlemite_axe = registerItem("arlemite_axe", () -> new ItemModAxe(ToolStats.ARLEMITE_AXE)),
            arlemite_hoe = registerItem("arlemite_hoe", () -> new ItemModHoe(ToolStats.ARLEMITE_PICKAXE)),
            arlemite_shickaxe = registerItem("arlemite_shickaxe", () -> new ItemShickaxe(ToolStats.ARLEMITE_SHICKAXE)),

    rupee_shovel = registerItem("rupee_shovel", () -> new ItemModShovel(ToolStats.RUPEE_SHOVEL)),
            rupee_pickaxe = registerItem("rupee_pickaxe", () -> new ItemModPickaxe(ToolStats.RUPEE_PICKAXE)),
            rupee_axe = registerItem("rupee_axe", () -> new ItemModAxe(ToolStats.RUPEE_AXE)),
            rupee_hoe = registerItem("rupee_hoe", () -> new ItemModHoe(ToolStats.RUPEE_PICKAXE)),
            rupee_shickaxe = registerItem("rupee_shickaxe", () -> new ItemShickaxe(ToolStats.RUPEE_SHICKAXE)),

    bedrock_shovel = registerItem("bedrock_shovel", () -> new ItemModShovel(ToolStats.BEDROCK_SHOVEL, new Item.Properties().fireResistant())),
            bedrock_pickaxe = registerItem("bedrock_pickaxe", () -> new ItemModPickaxe(ToolStats.BEDROCK_PICKAXE, new Item.Properties().fireResistant())),
            bedrock_axe = registerItem("bedrock_axe", () -> new ItemModAxe(ToolStats.BEDROCK_AXE, new Item.Properties().fireResistant())),
            bedrock_hoe = registerItem("bedrock_hoe", () -> new ItemModHoe(ToolStats.BEDROCK_PICKAXE, new Item.Properties().fireResistant())),

    terran_shovel = registerItem("terran_shovel", () -> new ItemModShovel(ToolStats.TERRAN_SHOVEL)),
            terran_pickaxe = registerItem("terran_pickaxe", () -> new ItemModPickaxe(ToolStats.TERRAN_PICKAXE)),
            terran_axe = registerItem("terran_axe", () -> new ItemModAxe(ToolStats.TERRAN_AXE)),
            terran_hoe = registerItem("terran_hoe", () -> new ItemModHoe(ToolStats.TERRAN_PICKAXE)),
            terran_shickaxe = registerItem("terran_shickaxe", () -> new ItemShickaxe(ToolStats.TERRAN_SHICKAXE)),

    corrupted_shovel = registerItem("corrupted_shovel", () -> new ItemModShovel(ToolStats.CORRUPTED_SHOVEL)),
            corrupted_pickaxe = registerItem("corrupted_pickaxe", () -> new ItemModPickaxe(ToolStats.CORRUPTED_PICKAXE)),
            corrupted_axe = registerItem("corrupted_axe", () -> new ItemModAxe(ToolStats.CORRUPTED_AXE)),
            corrupted_hoe = registerItem("corrupted_hoe", () -> new ItemModHoe(ToolStats.CORRUPTED_PICKAXE)),
            corrupted_shickaxe = registerItem("corrupted_shickaxe", () -> new ItemShickaxe(ToolStats.CORRUPTED_SHICKAXE)),

    divine_shovel = registerItem("divine_shovel", () -> new ItemModShovel(ToolStats.DIVINE_SHOVEL, RarityList.DIVINE)),
            divine_pickaxe = registerItem("divine_pickaxe", () -> new ItemModPickaxe(ToolStats.DIVINE_PICKAXE, RarityList.DIVINE)),
            divine_axe = registerItem("divine_axe", () -> new ItemModAxe(ToolStats.DIVINE_AXE, RarityList.DIVINE)),
            divine_hoe = registerItem("divine_hoe", () -> new ItemModHoe(ToolStats.DIVINE_PICKAXE)),
            divine_shickaxe = registerItem("divine_shickaxe", () -> new ItemShickaxe(RarityList.DIVINE, ToolStats.DIVINE_SHICKAXE)),

    eden_shovel = registerItem("eden_shovel", () -> new ItemModShovel(ToolStats.EDEN_SHOVEL, RarityList.EDEN)),
            eden_pickaxe = registerItem("eden_pickaxe", () -> new ItemModPickaxe(ToolStats.EDEN_PICKAXE, RarityList.EDEN)),
            eden_axe = registerItem("eden_axe", () -> new ItemModAxe(ToolStats.EDEN_AXE, RarityList.EDEN)),
            eden_hoe = registerItem("eden_hoe", () -> new ItemModHoe(ToolStats.EDEN_PICKAXE)),
            eden_shickaxe = registerItem("eden_shickaxe", () -> new ItemShickaxe(RarityList.EDEN, ToolStats.EDEN_SHICKAXE)),

    wildwood_shovel = registerItem("wildwood_shovel", () -> new ItemModShovel(ToolStats.WILDWOOD_SHOVEL, RarityList.WILDWOOD)),
            wildwood_pickaxe = registerItem("wildwood_pickaxe", () -> new ItemModPickaxe(ToolStats.WILDWOOD_PICKAXE, RarityList.WILDWOOD)),
            wildwood_axe = registerItem("wildwood_axe", () -> new ItemModAxe(ToolStats.WILDWOOD_AXE, RarityList.WILDWOOD)),
            wildwood_hoe = registerItem("wildwood_hoe", () -> new ItemModHoe(ToolStats.WILDWOOD_PICKAXE)),
            wildwood_shickaxe = registerItem("wildwood_shickaxe", () -> new ItemShickaxe(RarityList.WILDWOOD, ToolStats.WILDWOOD_SHICKAXE)),

    apalachia_shovel = registerItem("apalachia_shovel", () -> new ItemModShovel(ToolStats.APALACHIA_SHOVEL, RarityList.APALACHIA)),
            apalachia_pickaxe = registerItem("apalachia_pickaxe", () -> new ItemModPickaxe(ToolStats.APALACHIA_PICKAXE, RarityList.APALACHIA)),
            apalachia_axe = registerItem("apalachia_axe", () -> new ItemModAxe(ToolStats.APALACHIA_AXE, RarityList.APALACHIA)),
            apalachia_hoe = registerItem("apalachia_hoe", () -> new ItemModHoe(ToolStats.APALACHIA_PICKAXE)),
            apalachia_shickaxe = registerItem("apalachia_shickaxe", () -> new ItemShickaxe(RarityList.APALACHIA, ToolStats.APALACHIA_SHICKAXE)),

    skythern_shovel = registerItem("skythern_shovel", () -> new ItemModShovel(ToolStats.SKYTHERN_SHOVEL, RarityList.SKYTHERN)),
            skythern_pickaxe = registerItem("skythern_pickaxe", () -> new ItemModPickaxe(ToolStats.SKYTHERN_PICKAXE, RarityList.SKYTHERN)),
            skythern_axe = registerItem("skythern_axe", () -> new ItemModAxe(ToolStats.SKYTHERN_AXE, RarityList.SKYTHERN)),
            skythern_hoe = registerItem("skythern_hoe", () -> new ItemModHoe(ToolStats.SKYTHERN_PICKAXE)),
            skythern_shickaxe = registerItem("skythern_shickaxe", () -> new ItemShickaxe(RarityList.SKYTHERN, ToolStats.SKYTHERN_SHICKAXE)),

    mortum_shovel = registerItem("mortum_shovel", () -> new ItemModShovel(ToolStats.MORTUM_SHOVEL, RarityList.MORTUM)),
            mortum_pickaxe = registerItem("mortum_pickaxe", () -> new ItemModPickaxe(ToolStats.MORTUM_PICKAXE, RarityList.MORTUM)),
            mortum_axe = registerItem("mortum_axe", () -> new ItemModAxe(ToolStats.MORTUM_AXE, RarityList.MORTUM)),
            mortum_hoe = registerItem("mortum_hoe", () -> new ItemModHoe(ToolStats.MORTUM_PICKAXE)),
            mortum_shickaxe = registerItem("mortum_shickaxe", () -> new ItemShickaxe(RarityList.MORTUM, ToolStats.MORTUM_SHICKAXE)),

    halite_shickaxe = registerItem("halite_shickaxe", () -> new ItemShickaxe(RarityList.HALITE, ToolStats.HALITE_SHICKAXE)),

    dream_shovel = registerItem("dream_shovel", () -> new ItemModShovel(ToolStats.DREAM_SHOVEL)),
            dream_pickaxe = registerItem("dream_pickaxe", () -> new ItemModPickaxe(ToolStats.DREAM_PICKAXE)),
            dream_axe = registerItem("dream_axe", () -> new ItemModAxe(ToolStats.DREAM_AXE)),

            //Buckets
            gem_fin_bucket = registerItem("gem_fin_bucket", () -> new MobBucketItem(()-> ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(MODID, "gem_fin")), ()-> Fluids.WATER, ()-> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1))),

            //Vethean Swords
            teaker_backsword = registerItem("teaker_backsword", () -> new ItemVetheanSword(ToolStats.TEAKER_BACKSWORD)),
            amthirmis_backsword = registerItem("amthirmis_backsword", () -> new ItemVetheanSword(ToolStats.AMTHIRMIS_BACKSWORD)),
            darven_backsword = registerItem("darven_backsword", () -> new ItemVetheanSword(ToolStats.DARVEN_BACKSWORD)),
            cermile_backsword = registerItem("cermile_backsword", () -> new ItemVetheanSword(ToolStats.CERMILE_BACKSWORD)),
            pardimal_backsword = registerItem("pardimal_backsword", () -> new ItemVetheanSword(ToolStats.PARDIMAL_BACKSWORD)),
            quadrotic_backsword = registerItem("quadrotic_backsword", () -> new ItemVetheanSword(ToolStats.QUADROTIC_BACKSWORD)),
            karos_backsword = registerItem("karos_backsword", () -> new ItemVetheanSword(ToolStats.KAROS_BACKSWORD)),
            heliosis_backsword = registerItem("heliosis_backsword", () -> new ItemVetheanSword(ToolStats.HELIOSIS_BACKSWORD)),
            arksiane_backsword = registerItem("arksiane_backsword", () -> new ItemVetheanSword(ToolStats.ARKSIANE_BACKSWORD)),

            //Hammers
            teaker_hammer = registerItem("teaker_hammer", () -> new ItemVetheanSword(ToolStats.TEAKER_HAMMER)),
            amthirmis_hammer = registerItem("amthirmis_hammer", () -> new ItemVetheanSword(ToolStats.AMTHIRMIS_HAMMER)),
            darven_hammer = registerItem("darven_hammer", () -> new ItemVetheanSword(ToolStats.DARVEN_HAMMER)),
            cermile_hammer = registerItem("cermile_hammer", () -> new ItemVetheanSword(ToolStats.CERMILE_HAMMER)),
            pardimal_hammer = registerItem("pardimal_hammer", () -> new ItemVetheanSword(ToolStats.PARDIMAL_HAMMER)),
            quadrotic_hammer = registerItem("quadrotic_hammer", () -> new ItemVetheanSword(ToolStats.QUADROTIC_HAMMER)),
            karos_hammer = registerItem("karos_hammer", () -> new ItemVetheanSword(ToolStats.KAROS_HAMMER)),
            heliosis_hammer = registerItem("heliosis_hammer", () -> new ItemVetheanSword(ToolStats.HELIOSIS_HAMMER)),
            arksiane_hammer = registerItem("arksiane_hammer", () -> new ItemVetheanSword(ToolStats.ARKSIANE_HAMMER)),
            everlight = registerItem("everlight", () -> new ItemVetheanSword(ToolStats.EVERLIGHT)),
            karos_rockmaul = registerItem("karos_rockmaul", () -> new ItemVetheanSword(ToolStats.KAROS_ROCKMAUL)),

            //Claws
            teaker_claw = registerItem("teaker_claw", () -> new ItemVetheanSword(ToolStats.TEAKER_CLAW)),
            amthirmis_claw = registerItem("amthirmis_claw", () -> new ItemVetheanSword(ToolStats.AMTHIRMIS_CLAW)),
            darven_claw = registerItem("darven_claw", () -> new ItemVetheanSword(ToolStats.DARVEN_CLAW)),
            cermile_claw = registerItem("cermile_claw", () -> new ItemVetheanSword(ToolStats.CERMILE_CLAW)),
            pardimal_claw = registerItem("pardimal_claw", () -> new ItemVetheanSword(ToolStats.PARDIMAL_CLAW)),
            quadrotic_claw = registerItem("quadrotic_claw", () -> new ItemVetheanSword(ToolStats.QUADROTIC_CLAW)),
            karos_claw = registerItem("karos_claw", () -> new ItemVetheanSword(ToolStats.KAROS_CLAW)),
            heliosis_claw = registerItem("heliosis_claw", () -> new ItemVetheanSword(ToolStats.HELIOSIS_CLAW)),
            arksiane_claw = registerItem("arksiane_claw", () -> new ItemVetheanSword(ToolStats.ARKSIANE_CLAW)),
            everbright = registerItem("everbright", () -> new ItemVetheanSword(ToolStats.EVERBRIGHT)),

            //Vethean Bows
            teaker_bow = registerItem("teaker_bow", () -> new ItemVetheanBow(ArrowType.TEAKER_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "teaker_arrow"))),
            amthirmis_bow = registerItem("amthirmis_bow", () -> new ItemVetheanBow(ArrowType.AMTHIRMIS_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "teaker_arrow"))),
            darven_bow = registerItem("darven_bow", () -> new ItemVetheanBow(ArrowType.DARVEN_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "darven_arrow"))),
            cermile_bow = registerItem("cermile_bow", () -> new ItemVetheanBow(ArrowType.CERMILE_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "darven_arrow"))),
            pardimal_bow = registerItem("pardimal_bow", () -> new ItemVetheanBow(ArrowType.PARDIMAL_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "pardimal_arrow"))),
            quadrotic_bow = registerItem("quadrotic_bow", () -> new ItemVetheanBow(ArrowType.QUADROTIC_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "pardimal_arrow"))),
            karos_bow = registerItem("karos_bow", () -> new ItemVetheanBow(ArrowType.KAROS_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "karos_arrow"))),
            heliosis_bow = registerItem("heliosis_bow", () -> new ItemVetheanBow(ArrowType.HELIOSIS_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "karos_arrow"))),
            arksiane_bow = registerItem("arksiane_bow", () -> new ItemVetheanBow(ArrowType.ARKSIANE_ARROW, -1, new ResourceLocation(DivineRPG.MODID, "karos_arrow"))),
            everfright = registerItem("everfright", () -> new ItemVetheanBow(ArrowType.EVERFRIGHT, -1, new ResourceLocation(DivineRPG.MODID, "ever_arrow"))),

            //Vethean Arrows
            teaker_arrow = registerItemVethean("teaker_arrow"),
            darven_arrow = registerItemVethean("darven_arrow"),
            pardimal_arrow = registerItemVethean("pardimal_arrow"),
            karos_arrow = registerItemVethean("karos_arrow"),
            ever_arrow = registerItemVethean("ever_arrow"),

            //Vethean Staffs
            teaker_staff = registerItem("teaker_staff", () -> new ItemStaff(3, 10)),
            amthirmis_staff = registerItem("amthirmis_staff", () -> new ItemStaff(5, 10)),
            darven_staff = registerItem("darven_staff", () -> new ItemStaff(8, 10)),
            cermile_staff = registerItem("cermile_staff", () -> new ItemStaff(12, 10)),
            pardimal_staff = registerItem("pardimal_staff", () -> new ItemStaff(15, 10)),
            quadrotic_staff = registerItem("quadrotic_staff", () -> new ItemStaff(19, 10)),
            karos_staff = registerItem("karos_staff", () -> new ItemStaff(21, 10)),
            heliosis_staff = registerItem("heliosis_staff", () -> new ItemStaff(28, 10)),
            arksiane_staff = registerItem("arksiane_staff", () -> new ItemStaff(36, 10)),
            evernight = registerItem("evernight", () -> new ItemEvernight(115, 80)),

            //Vethean Cannons
            teaker_cannon = registerItem("teaker_cannon", () -> new ItemVetheanCannon(BulletType.TEAKER_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            amthirmis_cannon = registerItem("amthirmis_cannon", () -> new ItemVetheanCannon(BulletType.AMTHIRMIS_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            darven_cannon = registerItem("darven_cannon", () -> new ItemVetheanCannon(BulletType.DARVEN_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            cermile_cannon = registerItem("cermile_cannon", () -> new ItemVetheanCannon(BulletType.CERMILE_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            pardimal_cannon = registerItem("pardimal_cannon", () -> new ItemVetheanCannon(BulletType.PARDIMAL_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            quadrotic_cannon = registerItem("quadrotic_cannon", () -> new ItemVetheanCannon(BulletType.QUADROTIC_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            karos_cannon = registerItem("karos_cannon", () -> new ItemVetheanCannon(BulletType.KAROS_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            heliosis_cannon = registerItem("heliosis_cannon", () -> new ItemVetheanCannon(BulletType.HELIOSIS_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            arksiane_cannon = registerItem("arksiane_cannon", () -> new ItemVetheanCannon(BulletType.ARKSIANE_CANNON_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),
            eversight = registerItem("eversight", () -> new ItemVetheanCannon(BulletType.EVERSIGHT_SHOT, new ResourceLocation(DivineRPG.MODID, "acid"))),

            //Vethean Disks
            teaker_disk = registerItem("teaker_disk", () -> new ItemVetheanDisk(DiskType.TEAKER_DISK)),
            amthirmis_disk = registerItem("amthirmis_disk", () -> new ItemVetheanDisk(DiskType.AMTHRIMIS_DISK)),
            darven_disk = registerItem("darven_disk", () -> new ItemVetheanDisk(DiskType.DARVEN_DISK)),
            cermile_disk = registerItem("cermile_disk", () -> new ItemVetheanDisk(DiskType.CERMILE_DISK)),
            pardimal_disk = registerItem("pardimal_disk", () -> new ItemVetheanDisk(DiskType.PARDIMAL_DISK)),
            quadrotic_disk = registerItem("quadrotic_disk", () -> new ItemVetheanDisk(DiskType.QUADROTIC_DISK)),
            karos_disk = registerItem("karos_disk", () -> new ItemVetheanDisk(DiskType.KAROS_DISK)),
            heliosis_disk = registerItem("heliosis_disk", () -> new ItemVetheanDisk(DiskType.HELIOSIS_DISK)),
            arksiane_disk = registerItem("arksiane_disk", () -> new ItemVetheanDisk(DiskType.ARKSIANE_DISK)),

            //Vethean Dissipators
            teaker_dissipator = registerItem("teaker_dissipator", () -> new ItemVetheanDissipator(DiskType.TEAKER_DISK)),
            amthirmis_dissipator = registerItem("amthirmis_dissipator", () -> new ItemVetheanDissipator(DiskType.AMTHRIMIS_DISK)),
            darven_dissipator = registerItem("darven_dissipator", () -> new ItemVetheanDissipator(DiskType.DARVEN_DISK)),
            cermile_dissipator = registerItem("cermile_dissipator", () -> new ItemVetheanDissipator(DiskType.CERMILE_DISK)),
            pardimal_dissipator = registerItem("pardimal_dissipator", () -> new ItemVetheanDissipator(DiskType.PARDIMAL_DISK)),
            quadrotic_dissipator = registerItem("quadrotic_dissipator", () -> new ItemVetheanDissipator(DiskType.QUADROTIC_DISK)),
            karos_dissipator = registerItem("karos_dissipator", () -> new ItemVetheanDissipator(DiskType.KAROS_DISK)),
            heliosis_dissipator = registerItem("heliosis_dissipator", () -> new ItemVetheanDissipator(DiskType.HELIOSIS_DISK)),
            arksiane_dissipator = registerItem("arksiane_dissipator", () -> new ItemVetheanDissipator(DiskType.ARKSIANE_DISK)),

            //Armor Pouches
            armor_pouch = registerItem("armor_pouch", () -> new ItemArmorPouch(ChatFormatting.WHITE)),
            red_armor_pouch = registerItem("red_armor_pouch", () -> new ItemArmorPouch(ChatFormatting.RED)),
            yellow_armor_pouch = registerItem("yellow_armor_pouch", () -> new ItemArmorPouch(ChatFormatting.YELLOW)),
            green_armor_pouch = registerItem("green_armor_pouch", () -> new ItemArmorPouch(ChatFormatting.GREEN)),
            blue_armor_pouch = registerItem("blue_armor_pouch", () -> new ItemArmorPouch(ChatFormatting.BLUE)),
            gray_armor_pouch = registerItem("gray_armor_pouch", () -> new ItemArmorPouch(ChatFormatting.GRAY)),

            //Blocks
            nightmare_bed = registerItem("nightmare_bed", () -> new ItemNightmareBed()),
            aqua_torch = registerItem("aqua_torch", () -> new StandingAndWallBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "aqua_torch")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "aqua_wall_torch")), new Item.Properties(), Direction.EAST)),
            skeleton_torch = registerItem("skeleton_torch", () -> new StandingAndWallBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleton_torch")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleton_wall_torch")), new Item.Properties(), Direction.EAST)),
            arcanium_torch = registerItem("arcanium_torch", () -> new StandingAndWallBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_torch")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_wall_torch")), new Item.Properties(), Direction.EAST)),
            eden_torch = registerItem("eden_torch", () -> new StandingAndWallBlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_torch")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_wall_torch")), new Item.Properties(), Direction.EAST));

    //Armour
    public static final RegistryObject<Item>
    aquastrive_helmet = registerItem("aquastrive_helmet", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.HELMET, aquastriveInfo, MobEffects.DOLPHINS_GRACE, MobEffects.WATER_BREATHING)),
            aquastrive_chestplate = registerItem("aquastrive_chestplate", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.CHESTPLATE, aquastriveInfo)),
            aquastrive_leggings = registerItem("aquastrive_leggings", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.LEGGINGS, aquastriveInfo)),
            aquastrive_boots = registerItem("aquastrive_boots", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.BOOTS, aquastriveInfo)),

    kraken_helmet = registerItem("kraken_helmet", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.HELMET, krakenInfo, MobEffects.CONDUIT_POWER)),
            kraken_chestplate = registerItem("kraken_chestplate", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.CHESTPLATE, krakenInfo)),
            kraken_leggings = registerItem("kraken_leggings", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.LEGGINGS, krakenInfo)),
            kraken_boots = registerItem("kraken_boots", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.BOOTS, krakenInfo)),

    realmite_helmet = registerItem("realmite_helmet", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.HELMET)),
            realmite_chestplate = registerItem("realmite_chestplate", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.CHESTPLATE)),
            realmite_leggings = registerItem("realmite_leggings", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.LEGGINGS)),
            realmite_boots = registerItem("realmite_boots", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.BOOTS)),

    elite_realmite_helmet = registerItem("elite_realmite_helmet", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.HELMET, eliteRealmiteInfo, PREVENT_FALL_DAMAGE.get())),
            elite_realmite_chestplate = registerItem("elite_realmite_chestplate", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.CHESTPLATE, eliteRealmiteInfo)),
            elite_realmite_leggings = registerItem("elite_realmite_leggings", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.LEGGINGS, eliteRealmiteInfo)),
            elite_realmite_boots = registerItem("elite_realmite_boots", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.BOOTS, eliteRealmiteInfo)),

    arlemite_helmet = registerItem("arlemite_helmet", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.HELMET, arlemiteInfo, PROJECTILE_PROTECTION.get())),
            arlemite_chestplate = registerItem("arlemite_chestplate", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.CHESTPLATE, arlemiteInfo)),
            arlemite_leggings = registerItem("arlemite_leggings", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.LEGGINGS, arlemiteInfo)),
            arlemite_boots = registerItem("arlemite_boots", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.BOOTS, arlemiteInfo)),

    rupee_helmet = registerItem("rupee_helmet", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.HELMET, rupeeInfo, MELEE_PROTECTION.get())),
            rupee_chestplate = registerItem("rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.CHESTPLATE, rupeeInfo)),
            rupee_leggings = registerItem("rupee_leggings", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.LEGGINGS, rupeeInfo)),
            rupee_boots = registerItem("rupee_boots", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.BOOTS, rupeeInfo)),

    red_rupee_helmet = registerItem("red_rupee_helmet", () -> new ItemDivineArmor(ArmorStats.RED_RUPEE, ArmorItem.Type.HELMET, rupeeInfo, MELEE_PROTECTION.get())),
            red_rupee_chestplate = registerItem("red_rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.RED_RUPEE, ArmorItem.Type.CHESTPLATE, rupeeInfo)),
            red_rupee_leggings = registerItem("red_rupee_leggings", () -> new ItemDivineArmor(ArmorStats.RED_RUPEE, ArmorItem.Type.LEGGINGS, rupeeInfo)),
            red_rupee_boots = registerItem("red_rupee_boots", () -> new ItemDivineArmor(ArmorStats.RED_RUPEE, ArmorItem.Type.BOOTS, rupeeInfo)),

    yellow_rupee_helmet = registerItem("yellow_rupee_helmet", () -> new ItemDivineArmor(ArmorStats.YELLOW_RUPEE, ArmorItem.Type.HELMET, rupeeInfo, MELEE_PROTECTION.get())),
            yellow_rupee_chestplate = registerItem("yellow_rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.YELLOW_RUPEE, ArmorItem.Type.CHESTPLATE, rupeeInfo)),
            yellow_rupee_leggings = registerItem("yellow_rupee_leggings", () -> new ItemDivineArmor(ArmorStats.YELLOW_RUPEE, ArmorItem.Type.LEGGINGS, rupeeInfo)),
            yellow_rupee_boots = registerItem("yellow_rupee_boots", () -> new ItemDivineArmor(ArmorStats.YELLOW_RUPEE, ArmorItem.Type.BOOTS, rupeeInfo)),

    green_rupee_helmet = registerItem("green_rupee_helmet", () -> new ItemDivineArmor(ArmorStats.GREEN_RUPEE, ArmorItem.Type.HELMET, rupeeInfo, MELEE_PROTECTION.get())),
            green_rupee_chestplate = registerItem("green_rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.GREEN_RUPEE, ArmorItem.Type.CHESTPLATE, rupeeInfo)),
            green_rupee_leggings = registerItem("green_rupee_leggings", () -> new ItemDivineArmor(ArmorStats.GREEN_RUPEE, ArmorItem.Type.LEGGINGS, rupeeInfo)),
            green_rupee_boots = registerItem("green_rupee_boots", () -> new ItemDivineArmor(ArmorStats.GREEN_RUPEE, ArmorItem.Type.BOOTS, rupeeInfo)),

    blue_rupee_helmet = registerItem("blue_rupee_helmet", () -> new ItemDivineArmor(ArmorStats.BLUE_RUPEE, ArmorItem.Type.HELMET, rupeeInfo, MELEE_PROTECTION.get())),
            blue_rupee_chestplate = registerItem("blue_rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.BLUE_RUPEE, ArmorItem.Type.CHESTPLATE, rupeeInfo)),
            blue_rupee_leggings = registerItem("blue_rupee_leggings", () -> new ItemDivineArmor(ArmorStats.BLUE_RUPEE, ArmorItem.Type.LEGGINGS, rupeeInfo)),
            blue_rupee_boots = registerItem("blue_rupee_boots", () -> new ItemDivineArmor(ArmorStats.BLUE_RUPEE, ArmorItem.Type.BOOTS, rupeeInfo)),

    gray_rupee_helmet = registerItem("gray_rupee_helmet", () -> new ItemDivineArmor(ArmorStats.GRAY_RUPEE, ArmorItem.Type.HELMET, rupeeInfo, MELEE_PROTECTION.get())),
            gray_rupee_chestplate = registerItem("gray_rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.GRAY_RUPEE, ArmorItem.Type.CHESTPLATE, rupeeInfo)),
            gray_rupee_leggings = registerItem("gray_rupee_leggings", () -> new ItemDivineArmor(ArmorStats.GRAY_RUPEE, ArmorItem.Type.LEGGINGS, rupeeInfo)),
            gray_rupee_boots = registerItem("gray_rupee_boots", () -> new ItemDivineArmor(ArmorStats.GRAY_RUPEE, ArmorItem.Type.BOOTS, rupeeInfo)),

    shadow_helmet = registerItem("shadow_helmet", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.HELMET, shadowInfo, STEP_ASSIST.get())),
            shadow_chestplate = registerItem("shadow_chestplate", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.CHESTPLATE, shadowInfo, new int[]{3}, MobEffects.MOVEMENT_SPEED)),
            shadow_leggings = registerItem("shadow_leggings", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.LEGGINGS, shadowInfo)),
            shadow_boots = registerItem("shadow_boots", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.BOOTS, shadowInfo)),

    bedrock_helmet = registerItem("bedrock_helmet", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.HELMET, bedrockInfo, new Item.Properties().fireResistant(), MobEffects.FIRE_RESISTANCE, EXPLOSION_PROTECTION.get())),
            bedrock_chestplate = registerItem("bedrock_chestplate", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.CHESTPLATE, bedrockInfo, new Item.Properties().fireResistant())),
            bedrock_leggings = registerItem("bedrock_leggings", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.LEGGINGS, bedrockInfo, new Item.Properties().fireResistant())),
            bedrock_boots = registerItem("bedrock_boots", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.BOOTS, bedrockInfo, new Item.Properties().fireResistant())),

    jack_o_man_helmet = registerItem("jack_o_man_helmet", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.HELMET, jackomanInfo)),
            jack_o_man_chestplate = registerItem("jack_o_man_chestplate", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.CHESTPLATE, jackomanInfo)),
            jack_o_man_leggings = registerItem("jack_o_man_leggings", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.LEGGINGS, jackomanInfo)),
            jack_o_man_boots = registerItem("jack_o_man_boots", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.BOOTS, jackomanInfo)),

    skeleman_helmet = registerItem("skeleman_helmet", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.HELMET, skelemanInfo, SKELEMAN_FEED.get())),
            skeleman_chestplate = registerItem("skeleman_chestplate", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.CHESTPLATE, skelemanInfo)),
            skeleman_leggings = registerItem("skeleman_leggings", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.LEGGINGS, skelemanInfo)),
            skeleman_boots = registerItem("skeleman_boots", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.BOOTS, skelemanInfo)),

    wither_reaper_helmet = registerItem("wither_reaper_helmet", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.HELMET, witherReaperInfo, WITHER_PROTECTION.get())),
            wither_reaper_chestplate = registerItem("wither_reaper_chestplate", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.CHESTPLATE, witherReaperInfo)),
            wither_reaper_leggings = registerItem("wither_reaper_leggings", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.LEGGINGS, witherReaperInfo)),
            wither_reaper_boots = registerItem("wither_reaper_boots", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.BOOTS, witherReaperInfo)),

    frozen_helmet = registerItem("frozen_helmet", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.HELMET, frozenInfo, FROZEN_SLOWNESS.get())),
            frozen_chestplate = registerItem("frozen_chestplate", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.CHESTPLATE, frozenInfo)),
            frozen_leggings = registerItem("frozen_leggings", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.LEGGINGS, frozenInfo)),
            frozen_boots = registerItem("frozen_boots", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.BOOTS, frozenInfo)),

    terran_helmet = registerItem("terran_helmet", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.HELMET, terranInfo, new int[]{2}, MobEffects.DIG_SPEED)),
            terran_chestplate = registerItem("terran_chestplate", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.CHESTPLATE, terranInfo)),
            terran_leggings = registerItem("terran_leggings", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.LEGGINGS, terranInfo)),
            terran_boots = registerItem("terran_boots", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.BOOTS, terranInfo)),

    jungle_helmet = registerItem("jungle_helmet", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.HELMET, jungleInfo, POISON_PROTECTION.get())),
            jungle_chestplate = registerItem("jungle_chestplate", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.CHESTPLATE, jungleInfo)),
            jungle_leggings = registerItem("jungle_leggings", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.LEGGINGS, jungleInfo)),
            jungle_boots = registerItem("jungle_boots", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.BOOTS, jungleInfo)),

    inferno_helmet = registerItem("inferno_helmet", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.HELMET, infernoInfo, new Item.Properties().fireResistant(), MobEffects.FIRE_RESISTANCE)),
            inferno_chestplate = registerItem("inferno_chestplate", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.CHESTPLATE, infernoInfo, new Item.Properties().fireResistant())),
            inferno_leggings = registerItem("inferno_leggings", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.LEGGINGS, infernoInfo, new Item.Properties().fireResistant())),
            inferno_boots = registerItem("inferno_boots", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.BOOTS, infernoInfo, new Item.Properties().fireResistant())),

    ender_helmet = registerItem("ender_helmet", () -> new ItemDivineArmor(ArmorStats.ENDER, ArmorItem.Type.HELMET, enderInfo, EXPLOSION_PROTECTION.get())),
            ender_chestplate = registerItem("ender_chestplate", () -> new ItemDivineArmor(ArmorStats.ENDER, ArmorItem.Type.CHESTPLATE, enderInfo)),
            ender_leggings = registerItem("ender_leggings", () -> new ItemDivineArmor(ArmorStats.ENDER, ArmorItem.Type.LEGGINGS, enderInfo)),
            ender_boots = registerItem("ender_boots", () -> new ItemDivineArmor(ArmorStats.ENDER, ArmorItem.Type.BOOTS, enderInfo)),

    red_ender_helmet = registerItem("red_ender_helmet", () -> new ItemDivineArmor(ArmorStats.RED_ENDER, ArmorItem.Type.HELMET, enderInfo, EXPLOSION_PROTECTION.get())),
            red_ender_chestplate = registerItem("red_ender_chestplate", () -> new ItemDivineArmor(ArmorStats.RED_ENDER, ArmorItem.Type.CHESTPLATE, enderInfo)),
            red_ender_leggings = registerItem("red_ender_leggings", () -> new ItemDivineArmor(ArmorStats.RED_ENDER, ArmorItem.Type.LEGGINGS, enderInfo)),
            red_ender_boots = registerItem("red_ender_boots", () -> new ItemDivineArmor(ArmorStats.RED_ENDER, ArmorItem.Type.BOOTS, enderInfo)),

    yellow_ender_helmet = registerItem("yellow_ender_helmet", () -> new ItemDivineArmor(ArmorStats.YELLOW_ENDER, ArmorItem.Type.HELMET, enderInfo, EXPLOSION_PROTECTION.get())),
            yellow_ender_chestplate = registerItem("yellow_ender_chestplate", () -> new ItemDivineArmor(ArmorStats.YELLOW_ENDER, ArmorItem.Type.CHESTPLATE, enderInfo)),
            yellow_ender_leggings = registerItem("yellow_ender_leggings", () -> new ItemDivineArmor(ArmorStats.YELLOW_ENDER, ArmorItem.Type.LEGGINGS, enderInfo)),
            yellow_ender_boots = registerItem("yellow_ender_boots", () -> new ItemDivineArmor(ArmorStats.YELLOW_ENDER, ArmorItem.Type.BOOTS, enderInfo)),

    green_ender_helmet = registerItem("green_ender_helmet", () -> new ItemDivineArmor(ArmorStats.GREEN_ENDER, ArmorItem.Type.HELMET, enderInfo, EXPLOSION_PROTECTION.get())),
            green_ender_chestplate = registerItem("green_ender_chestplate", () -> new ItemDivineArmor(ArmorStats.GREEN_ENDER, ArmorItem.Type.CHESTPLATE, enderInfo)),
            green_ender_leggings = registerItem("green_ender_leggings", () -> new ItemDivineArmor(ArmorStats.GREEN_ENDER, ArmorItem.Type.LEGGINGS, enderInfo)),
            green_ender_boots = registerItem("green_ender_boots", () -> new ItemDivineArmor(ArmorStats.GREEN_ENDER, ArmorItem.Type.BOOTS, enderInfo)),

    blue_ender_helmet = registerItem("blue_ender_helmet", () -> new ItemDivineArmor(ArmorStats.BLUE_ENDER, ArmorItem.Type.HELMET, enderInfo, EXPLOSION_PROTECTION.get())),
            blue_ender_chestplate = registerItem("blue_ender_chestplate", () -> new ItemDivineArmor(ArmorStats.BLUE_ENDER, ArmorItem.Type.CHESTPLATE, enderInfo)),
            blue_ender_leggings = registerItem("blue_ender_leggings", () -> new ItemDivineArmor(ArmorStats.BLUE_ENDER, ArmorItem.Type.LEGGINGS, enderInfo)),
            blue_ender_boots = registerItem("blue_ender_boots", () -> new ItemDivineArmor(ArmorStats.BLUE_ENDER, ArmorItem.Type.BOOTS, enderInfo)),

    gray_ender_helmet = registerItem("gray_ender_helmet", () -> new ItemDivineArmor(ArmorStats.GRAY_ENDER, ArmorItem.Type.HELMET, enderInfo, EXPLOSION_PROTECTION.get())),
            gray_ender_chestplate = registerItem("gray_ender_chestplate", () -> new ItemDivineArmor(ArmorStats.GRAY_ENDER, ArmorItem.Type.CHESTPLATE, enderInfo)),
            gray_ender_leggings = registerItem("gray_ender_leggings", () -> new ItemDivineArmor(ArmorStats.GRAY_ENDER, ArmorItem.Type.LEGGINGS, enderInfo)),
            gray_ender_boots = registerItem("gray_ender_boots", () -> new ItemDivineArmor(ArmorStats.GRAY_ENDER, ArmorItem.Type.BOOTS, enderInfo)),

    corrupted_helmet = registerItem("corrupted_helmet", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.HELMET, corruptedInfo, CORRUPTED_STRENGTH.get())),
            corrupted_chestplate = registerItem("corrupted_chestplate", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.CHESTPLATE, corruptedInfo)),
            corrupted_leggings = registerItem("corrupted_leggings", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.LEGGINGS, corruptedInfo)),
            corrupted_boots = registerItem("corrupted_boots", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.BOOTS, corruptedInfo)),

    divine_helmet = registerItem("divine_helmet", () -> new ItemDivineArmor(ArmorStats.DIVINE, ArmorItem.Type.HELMET, divineInfo, PREVENT_FALL_DAMAGE.get(), DIVINE_STRENGTH.get())),
            divine_chestplate = registerItem("divine_chestplate", () -> new ItemDivineArmor(ArmorStats.DIVINE, ArmorItem.Type.CHESTPLATE, divineInfo, new int[]{1}, MobEffects.JUMP)),
            divine_leggings = registerItem("divine_leggings", () -> new ItemDivineArmor(ArmorStats.DIVINE, ArmorItem.Type.LEGGINGS, divineInfo)),
            divine_boots = registerItem("divine_boots", () -> new ItemDivineArmor(ArmorStats.DIVINE, ArmorItem.Type.BOOTS, divineInfo)),

    torridite_helmet = registerItem("torridite_helmet", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.HELMET, torriditeInfo, new Item.Properties().fireResistant(), MobEffects.FIRE_RESISTANCE)),
            torridite_chestplate = registerItem("torridite_chestplate", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.CHESTPLATE, torriditeInfo, new Item.Properties().fireResistant())),
            torridite_leggings = registerItem("torridite_leggings", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.LEGGINGS, torriditeInfo, new Item.Properties().fireResistant())),
            torridite_boots = registerItem("torridite_boots", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.BOOTS, torriditeInfo, new Item.Properties().fireResistant())),

    angelic_helmet = registerItem("angelic_helmet", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.HELMET, angelicInfo, PREVENT_FALL_DAMAGE.get(), ANGELIC_FLIGHT.get())),
            angelic_chestplate = registerItem("angelic_chestplate", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.CHESTPLATE, angelicInfo)),
            angelic_leggings = registerItem("angelic_leggings", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.LEGGINGS, angelicInfo)),
            angelic_boots = registerItem("angelic_boots", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.BOOTS, angelicInfo)),

    seng_fur_helmet = registerItem("seng_fur_helmet", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.HELMET, sengFurInfo, SENG_FUR.get(), WARMTH.get())),
            seng_fur_chestplate = registerItem("seng_fur_chestplate", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.CHESTPLATE, sengFurInfo)),
            seng_fur_leggings = registerItem("seng_fur_leggings", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.LEGGINGS, sengFurInfo)),
            seng_fur_boots = registerItem("seng_fur_boots", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.BOOTS, sengFurInfo)),

    korma_helmet = registerItem("korma_helmet", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.HELMET, kormInfo, KORMA_ARCANA.get())),
            korma_chestplate = registerItem("korma_chestplate", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.CHESTPLATE, kormInfo)),
            korma_leggings = registerItem("korma_leggings", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.LEGGINGS, kormInfo)),
            korma_boots = registerItem("korma_boots", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.BOOTS, kormInfo)),

    vemos_helmet = registerItem("vemos_helmet", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.HELMET, vemInfo, VEMOS_HEAL.get())),
            vemos_chestplate = registerItem("vemos_chestplate", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.CHESTPLATE, vemInfo)),
            vemos_leggings = registerItem("vemos_leggings", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.LEGGINGS, vemInfo)),
            vemos_boots = registerItem("vemos_boots", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.BOOTS, vemInfo)),

    eden_helmet = registerItem("eden_helmet", () -> new ItemDivineArmor(ArmorStats.EDEN, ArmorItem.Type.HELMET, edenInfo)),
            eden_chestplate = registerItem("eden_chestplate", () -> new ItemDivineArmor(ArmorStats.EDEN, ArmorItem.Type.CHESTPLATE, edenInfo)),
            eden_leggings = registerItem("eden_leggings", () -> new ItemDivineArmor(ArmorStats.EDEN, ArmorItem.Type.LEGGINGS, edenInfo)),
            eden_boots = registerItem("eden_boots", () -> new ItemDivineArmor(ArmorStats.EDEN, ArmorItem.Type.BOOTS, edenInfo)),

    wildwood_helmet = registerItem("wildwood_helmet", () -> new ItemDivineArmor(ArmorStats.WILDWOOD, ArmorItem.Type.HELMET, wildInfo, WILDWOOD_HEAL.get())),
            wildwood_chestplate = registerItem("wildwood_chestplate", () -> new ItemDivineArmor(ArmorStats.WILDWOOD, ArmorItem.Type.CHESTPLATE, wildInfo)),
            wildwood_leggings = registerItem("wildwood_leggings", () -> new ItemDivineArmor(ArmorStats.WILDWOOD, ArmorItem.Type.LEGGINGS, wildInfo)),
            wildwood_boots = registerItem("wildwood_boots", () -> new ItemDivineArmor(ArmorStats.WILDWOOD, ArmorItem.Type.BOOTS, wildInfo)),

    apalachia_helmet = registerItem("apalachia_helmet", () -> new ItemDivineArmor(ArmorStats.APALACHIA, ArmorItem.Type.HELMET, apInfo, BLOCK_PROTECTION.get())),
            apalachia_chestplate = registerItem("apalachia_chestplate", () -> new ItemDivineArmor(ArmorStats.APALACHIA, ArmorItem.Type.CHESTPLATE, apInfo)),
            apalachia_leggings = registerItem("apalachia_leggings", () -> new ItemDivineArmor(ArmorStats.APALACHIA, ArmorItem.Type.LEGGINGS, apInfo)),
            apalachia_boots = registerItem("apalachia_boots", () -> new ItemDivineArmor(ArmorStats.APALACHIA, ArmorItem.Type.BOOTS, apInfo)),

    skythern_helmet = registerItem("skythern_helmet", () -> new ItemDivineArmor(ArmorStats.SKYTHERN, ArmorItem.Type.HELMET, skyInfo, PREVENT_FALL_DAMAGE.get())),
            skythern_chestplate = registerItem("skythern_chestplate", () -> new ItemDivineArmor(ArmorStats.SKYTHERN, ArmorItem.Type.CHESTPLATE, skyInfo, new int[] {5}, MobEffects.JUMP)),
            skythern_leggings = registerItem("skythern_leggings", () -> new ItemDivineArmor(ArmorStats.SKYTHERN, ArmorItem.Type.LEGGINGS, skyInfo)),
            skythern_boots = registerItem("skythern_boots", () -> new ItemDivineArmor(ArmorStats.SKYTHERN, ArmorItem.Type.BOOTS, skyInfo)),

    mortum_helmet = registerItem("mortum_helmet", () -> new ItemDivineArmor(ArmorStats.MORTUM, ArmorItem.Type.HELMET, mortInfo, MobEffects.NIGHT_VISION)),
            mortum_chestplate = registerItem("mortum_chestplate", () -> new ItemDivineArmor(ArmorStats.MORTUM, ArmorItem.Type.CHESTPLATE, mortInfo)),
            mortum_leggings = registerItem("mortum_leggings", () -> new ItemDivineArmor(ArmorStats.MORTUM, ArmorItem.Type.LEGGINGS, mortInfo)),
            mortum_boots = registerItem("mortum_boots", () -> new ItemDivineArmor(ArmorStats.MORTUM, ArmorItem.Type.BOOTS, mortInfo)),

    halite_helmet = registerItem("halite_helmet", () -> new ItemDivineArmor(ArmorStats.HALITE, ArmorItem.Type.HELMET, halInfo, HALITE_STRENGTH.get())),
            halite_chestplate = registerItem("halite_chestplate", () -> new ItemDivineArmor(ArmorStats.HALITE, ArmorItem.Type.CHESTPLATE, halInfo)),
            halite_leggings = registerItem("halite_leggings", () -> new ItemDivineArmor(ArmorStats.HALITE, ArmorItem.Type.LEGGINGS, halInfo)),
            halite_boots = registerItem("halite_boots", () -> new ItemDivineArmor(ArmorStats.HALITE, ArmorItem.Type.BOOTS, halInfo)),

    awakened_halite_helmet = registerItem("awakened_halite_helmet", () -> new ItemDivineArmor(ArmorStats.AWAKENED_HALITE, ArmorItem.Type.HELMET, awakened_halInfo, AWAKENED_HALITE_STRENGTH.get())),
            awakened_halite_chestplate = registerItem("awakened_halite_chestplate", () -> new ItemDivineArmor(ArmorStats.AWAKENED_HALITE, ArmorItem.Type.CHESTPLATE, awakened_halInfo)),
            awakened_halite_leggings = registerItem("awakened_halite_leggings", () -> new ItemDivineArmor(ArmorStats.AWAKENED_HALITE, ArmorItem.Type.LEGGINGS, awakened_halInfo)),
            awakened_halite_boots = registerItem("awakened_halite_boots", () -> new ItemDivineArmor(ArmorStats.AWAKENED_HALITE, ArmorItem.Type.BOOTS, awakened_halInfo)),

    degraded_helmet = registerItem("degraded_helmet", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, basicHelmInfo, DEGRADED_HELMET.get())),
            degraded_hood = registerItem("degraded_hood", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, basicHoodInfo, DEGRADED_HOOD.get())),
            degraded_mask = registerItem("degraded_mask", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, basicMaskInfo, DEGRADED_MASK.get())),
            degraded_chestplate = registerItem("degraded_chestplate", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.CHESTPLATE)),
            degraded_leggings = registerItem("degraded_leggings", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.LEGGINGS)),
            degraded_boots = registerItem("degraded_boots", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.BOOTS)),

    finished_helmet = registerItem("finished_helmet", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, basicHelmInfo, FINISHED_HELMET.get())),
            finished_hood = registerItem("finished_hood", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, basicHoodInfo, FINISHED_HOOD.get())),
            finished_mask = registerItem("finished_mask", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, basicMaskInfo, FINISHED_MASK.get())),
            finished_chestplate = registerItem("finished_chestplate", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.CHESTPLATE)),
            finished_leggings = registerItem("finished_leggings", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.LEGGINGS)),
            finished_boots = registerItem("finished_boots", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.BOOTS)),

    glistening_helmet = registerItem("glistening_helmet", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, glisteningHelmInfo, GLISTENING_HELMET.get())),
            glistening_hood = registerItem("glistening_hood", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, glisteningHoodInfo, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, GLISTENING_HOOD.get())),
            glistening_mask = registerItem("glistening_mask", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, glisteningMaskInfo, MobEffects.MOVEMENT_SPEED, GLISTENING_MASK.get())),
            glistening_chestplate = registerItem("glistening_chestplate", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.CHESTPLATE)),
            glistening_leggings = registerItem("glistening_leggings", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.LEGGINGS)),
            glistening_boots = registerItem("glistening_boots", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.BOOTS)),

    demonized_helmet = registerItem("demonized_helmet", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, demonizedHelmInfo, DEMONIZED_HELMET.get())),
            demonized_hood = registerItem("demonized_hood", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, demonizedHoodInfo, new int[]{0, 1, 0}, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, DEMONIZED_HOOD.get())),
            demonized_mask = registerItem("demonized_mask", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, demonizedMaskInfo, new int[]{1, 0}, MobEffects.MOVEMENT_SPEED, DEMONIZED_MASK.get())),
            demonized_chestplate = registerItem("demonized_chestplate", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.CHESTPLATE)),
            demonized_leggings = registerItem("demonized_leggings", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.LEGGINGS)),
            demonized_boots = registerItem("demonized_boots", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.BOOTS)),

    tormented_helmet = registerItem("tormented_helmet", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, tormentedHelmInfo, TORMENTED_HELMET.get())),
            tormented_hood = registerItem("tormented_hood", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, tormentedHoodInfo, new int[]{0, 2, 0}, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, TORMENTED_HOOD.get())),
            tormented_mask = registerItem("tormented_mask", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, tormentedMaskInfo, new int[]{2, 0}, MobEffects.MOVEMENT_SPEED, TORMENTED_MASK.get())),
            tormented_chestplate = registerItem("tormented_chestplate", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.CHESTPLATE)),
            tormented_leggings = registerItem("tormented_leggings", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.LEGGINGS)),
            tormented_boots = registerItem("tormented_boots", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.BOOTS));

    public static MutableComponent getArmorAbility(String keyPart, Object... params) {
        String id = String.format("tooltip.armor_info.%s", keyPart);

        return params == null || params.length < 1
                ? MutableComponent.create(new TranslatableContents(id, null, null))
                : MutableComponent.create(new TranslatableContents(id, null, params));
    }
    private static RegistryObject<Item> registerItemVethean(String registryId) {
        return ITEMS.register(registryId, () -> new ItemVethean());
    }
    private static RegistryObject<Item> registerItem(String registryId) {
        return ITEMS.register(registryId, () -> new ItemMod());
    }
    private static <T extends Item> RegistryObject<T> registerItem(String registryId, Supplier<T> item) {
        return ITEMS.register(registryId, item);
    }
}