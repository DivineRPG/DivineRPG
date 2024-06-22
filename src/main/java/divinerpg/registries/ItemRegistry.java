package divinerpg.registries;

import divinerpg.enums.*;
import divinerpg.items.arcana.*;
import divinerpg.items.base.*;
import divinerpg.items.iceika.*;
import divinerpg.items.twilight.*;
import divinerpg.items.vanilla.*;
import divinerpg.items.vethea.*;
import divinerpg.util.*;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.*;
import java.util.function.Supplier;
import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.MobEffectRegistry.*;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
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
            healing_stone = registerItem("healing_stone", ItemHealingStone::new),
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
            bedrock_chunk = registerItem("bedrock_chunk", () -> new ItemMod(new Properties().fireResistant())),

            //Shards
            ice_shards = registerItem("ice_shards"),
            terran_shards = registerItem("terran_shards"),
            jungle_shards = registerItem("jungle_shards"),
            molten_shards = registerItem("molten_shards", () -> new ItemMod(new Properties().fireResistant())),
            corrupted_shards = registerItem("corrupted_shards"),
            ender_shards = registerItem("ender_shards"),
            divine_shards = registerItem("divine_shards"),

            //Stones
            ice_stone = registerItem("ice_stone"),
            terran_stone = registerItem("terran_stone"),
            jungle_stone = registerItem("jungle_stone"),
            molten_stone = registerItem("molten_stone", () -> new ItemMod(new Properties().fireResistant())),
            corrupted_stone = registerItem("corrupted_stone"),
            ender_stone = registerItem("ender_stone"),
            divine_stone = registerItem("divine_stone"),

            //Nether
            bloodgem = registerItem("bloodgem"),
            raw_torridite = registerItem("raw_torridite"),
            torridite_nugget = registerItem("torridite_nugget", () -> new ItemMod(new Properties().fireResistant())),
            torridite_ingot = registerItem("torridite_ingot", () -> new ItemMod(new Properties().fireResistant())),
            torridite_chunk = registerItem("torridite_chunk", () -> new ItemMod(new Properties().fireResistant())),
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

            //Smithing Templates
            bedrock_upgrade_template = registerItem("bedrock_upgrade_template", ItemSmithingTemplate::createBedrockUpgrade),
            aquatic_coating_template = registerItem("aquatic_coating_template", ItemSmithingTemplate::createAquaticCoating),
            color_template = registerItem("color_template", ItemSmithingTemplate::createColorTemplate),

            //Some Extra Stuff
            mysterious_clock = registerItem("mysterious_clock", () -> new ItemBossSpawner("item.overworld_only", Level.OVERWORLD, EntityRegistry.ANCIENT_ENTITY::get)),
            call_of_the_watcher = registerItem("call_of_the_watcher", () -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.THE_WATCHER::get)),
            infernal_flame = registerItem("infernal_flame", () -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.KING_OF_SCORCHERS::get)),
            horde_horn = registerItem("horde_horn", ItemHordeHorn::new),
            snow_globe = registerItem("snow_globe", ItemSnowGlobe::new),
            twilight_clock = registerItem("twilight_clock", ItemTwilightClock::new),
            heat_pack = registerItem("heat_pack", ItemHeatPack::new),
            glacial_wall_totem = registerItem("glacial_wall_totem", () -> new ItemMod(new Properties().stacksTo(1))),
            teleportation_crystal = registerItem("teleportation_crystal", ItemTeleportationCrystal::new),
            teleportation_star = registerItem("teleportation_star", ItemTeleportationStar::new),

            //Arcana
            collector_fragments = registerItem("collector_fragments"),
            collector = registerItem("collector", ItemCollector::new),
            ancient_key = registerItem("ancient_key"),
            degraded_key = registerItem("degraded_key"),
            sludge_key = registerItem("sludge_key"),
            soul_key = registerItem("soul_key"),
            pieceOfRawArcanium = registerItem("piece_of_raw_arcanium"),
            arcanium = registerItem("arcanium"),
            wizards_book = registerItem("wizards_book", ItemWizardsBook::new),
            dungeon_tokens = registerItem("dungeon_tokens"),
            aquamarine = registerItem("aquamarine", ItemAquamarine::new),
            firestock = registerItem("firestock"),
            lamona = registerItem("lamona"),
            marsine = registerItem("marsine"),
            veilo = registerItem("veilo"),
            orb_of_light = registerItem("orb_of_light"),
            weak_arcana_potion = registerItem("weak_arcana_potion", () -> new ItemArcanaPotion(FoodList.WEAK_ARCANA_POTION, 100)),
            strong_arcana_potion = registerItem("strong_arcana_potion", () -> new ItemArcanaPotion(FoodList.STRONG_ARCANA_POTION, 200)),

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
            vamacheron_crystal = registerItem("vamacheron_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.VAMACHERON::get)),
            karot_crystal = registerItem("karot_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.KAROT::get)),
            twilight_demon_crystal = registerItem("twilight_demon_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.TWILIGHT_DEMON::get)),
            densos_crystal = registerItem("densos_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.DENSOS::get)),
            reyvor_crystal = registerItem("reyvor_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.REYVOR::get)),
            soul_fiend_crystal = registerItem("soul_fiend_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.SOUL_FIEND::get)),

            //Food
            bacon = registerItem("bacon", () -> new ItemModFood(FoodList.BACON)),
            boiled_egg = registerItem("boiled_egg", () -> new ItemModFood(FoodList.BOILED_EGG)),
            cheese = registerItem("cheese", () -> new ItemModFood(FoodList.CHEESE)),
            donut = registerItem("donut", () -> new ItemModFood(FoodList.DONUT)),
            hot_pumpkin_pie = registerItem("hot_pumpkin_pie", () -> new ItemModFood(FoodList.HOT_PUMPKIN_PIE)),
            tomato = registerItem("tomato", ItemTomato::new),
            white_mushroom = registerItem("white_mushroom", () -> new ItemModFood(FoodList.WHITE_MUSHROOM)),
            advanced_mushroom_stew = registerItem("advanced_mushroom_stew", () -> new BowlFoodItem(new Properties().food(FoodList.ADVANCED_MUSHROOM_STEW).stacksTo(1))),
            chicken_dinner = registerItem("chicken_dinner", () -> new BowlFoodItem(new Properties().food(FoodList.CHICKEN_DINNER).stacksTo(1))),
            robbin_egg = registerItem("robbin_egg"),
            cauldron_flesh = registerItem("cauldron_flesh", () -> new ItemModFood(FoodList.CAULDRON_FLESH)),
            raw_seng_meat = registerItem("raw_seng_meat", () -> new ItemModFood(FoodList.RAW_SENG_MEAT)),
            seng_steak = registerItem("seng_steak", () -> new ItemModFood(FoodList.COOKED_SENG_STEAK)),
            raw_wolpertinger_meat = registerItem("raw_wolpertinger_meat", () -> new ItemModFood(FoodList.RAW_WOLPERTINGER_MEAT)),
            wolpertinger_steak = registerItem("wolpertinger_steak", () -> new ItemModFood(FoodList.COOKED_WOLPERTINGER_STEAK)),
            chocolate_log = registerItem("chocolate_log", () -> new ItemModFood(FoodList.CHOCOLATE_LOG)),
            egg_nog = registerItem("egg_nog", ItemEggNog::new),
            fruit_cake = registerItem("fruit_cake", () -> new ItemModFood(FoodList.FRUIT_CAKE)),
            peppermints = registerItem("peppermints", () -> new ItemModFood(FoodList.PEPPERMINTS)),
            snow_cones = registerItem("snow_cones", () -> new ItemModFood(FoodList.SNOW_CONES)),
            winterberry = registerItem("winterberry", ItemWinterberry::new),
            hitchak = registerItem("hitchak", () -> new ItemModFood(FoodList.HITCHAK)),
            pinfly = registerItem("pinfly", () -> new ItemModFood(FoodList.PINFLY)),
            raw_empowered_meat = registerItem("raw_empowered_meat", () -> new ItemModFood(FoodList.RAW_EMPOWERED_MEAT)),
            empowered_meat = registerItem("empowered_meat", () -> new ItemModFood(FoodList.EMPOWERED_MEAT)),
            magic_meat = registerItem("magic_meat", () -> new ItemModFood(FoodList.MAGIC_MEAT, true)),
            enriched_magic_meat = registerItem("enriched_magic_meat", () -> new ItemModFood(FoodList.ENRICHED_MAGIC_MEAT, true)),
            forbidden_fruit = registerItem("forbidden_fruit", () -> new ItemModFood(FoodList.FORBIDDEN_FRUIT)),
            moonbulb = registerItem("moonbulb", () -> new ItemModFood(FoodList.MOONBULB, true)),
            purple_glowbone = registerItem("purple_glowbone", () -> new ItemModFood(FoodList.PURPLE_GLOWBONE, true)),
            pink_glowbone = registerItem("pink_glowbone", () -> new ItemModFood(FoodList.PINK_GLOWBONE, true)),
            sky_flower = registerItem("sky_flower", ItemSkyFlower::new),
            honeysuckle = registerItem("honeysuckle", () -> new ItemModFood(FoodList.HONEYSUCKLE)),
            honeychunk = registerItem("honeychunk", () -> new ItemModFood(FoodList.HONEYCHUNK)),
            dream_carrot = registerItem("dream_carrot", () -> new ItemModFood(FoodList.DREAM_CARROT)),
            dream_melon = registerItem("dream_melon", () -> new ItemModFood(FoodList.DREAM_MELON)),
            dream_pie = registerItem("dream_pie", () -> new ItemModFood(FoodList.DREAM_PIE)),
            dream_cake = registerItem("dream_cake", () -> new ItemModFood(FoodList.DREAM_CAKE)),
            dream_sweets = registerItem("dream_sweets", () -> new ItemHealingFood(FoodList.DREAM_SWEETS)),
            dream_sours = registerItem("dream_sours", () -> new ItemHealingFood(FoodList.DREAM_SOURS)),

            //Seeds
            tomato_seeds = registerItem("tomato_seeds", () -> new ItemNameBlockItem(BlockRegistry.tomatoPlant.get(), new Properties())),
            white_mushroom_seeds = registerItem("white_mushroom_seeds", () -> new ItemNameBlockItem(BlockRegistry.whiteMushroomPlant.get(), new Properties())),
            aquamarine_seeds = registerItem("aquamarine_seeds", () -> new ItemNameBlockItem(BlockRegistry.aquamarinePlant.get(), new Properties())),
            eucalyptus_root_seeds = registerItem("eucalyptus_root_seeds", () -> new ItemNameBlockItem(BlockRegistry.eucalyptusPlant.get(), new Properties())),
            firestock_seeds = registerItem("firestock_seeds", () -> new ItemNameBlockItem(BlockRegistry.firestockPlant.get(), new Properties())),
            hitchak_seeds = registerItem("hitchak_seeds", () -> new ItemNameBlockItem(BlockRegistry.hitchakPlant.get(), new Properties())),
            lamona_seeds = registerItem("lamona_seeds", () -> new ItemNameBlockItem(BlockRegistry.lamonaPlant.get(), new Properties())),
            marsine_seeds = registerItem("marsine_seeds", () -> new ItemNameBlockItem(BlockRegistry.marsinePlant.get(), new Properties())),
            pinfly_seeds = registerItem("pinfly_seeds", () -> new ItemNameBlockItem(BlockRegistry.pinflyPlant.get(), new Properties())),
            veilo_seeds = registerItem("veilo_seeds", () -> new ItemNameBlockItem(BlockRegistry.veiloPlant.get(), new Properties())),
            moonbulb_seeds = registerItem("moonbulb_seeds", () -> new ItemNameBlockItem(BlockRegistry.moonbulbPlant.get(), new Properties())),
            pink_glowbone_seeds = registerItem("pink_glowbone_seeds", () -> new ItemNameBlockItem(BlockRegistry.pinkGlowbonePlant.get(), new Properties())),
            purple_glowbone_seeds = registerItem("purple_glowbone_seeds", () -> new ItemNameBlockItem(BlockRegistry.purpleGlowbonePlant.get(), new Properties())),
            sky_plant_seeds = registerItem("sky_plant_seeds", () -> new ItemNameBlockItem(BlockRegistry.skyPlant.get(), new Properties())),

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
            dream_flint = registerItemVethean("dream_flint", ItemDreamFlint::new),
            moon_clock = registerItemVethean("moon_clock", () -> new ItemVethean(new Properties().stacksTo(1))),
            miners_amulet = registerItemVethean("miners_amulet", ItemMinersAmulet::new),
            band_of_lheiva_hunting = registerItemVethean("band_of_lheiva_hunting", () -> new ItemVethean(new Properties().stacksTo(1))),

            //Pets
            snapper_egg = registerItem("snapper_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SNAPPER)),
            ehu_egg = registerItem("ehu_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.EHU)),
            husk_egg = registerItem("husk_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.HUSK)),
            brown_grizzle_egg = registerItem("brown_grizzle_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.BROWN_GRIZZLE)),
            white_grizzle_egg = registerItem("white_grizzle_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.WHITE_GRIZZLE)),
            stone_golem_egg = registerItem("stone_golem_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.STONE_GOLEM)),
            smelter_egg = registerItem("smelter_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SMELTER)),
            fyracryx_egg = registerItem("fyracryx_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.FYRACRYX)),
            golem_of_rejuvenation_egg = registerItem("golem_of_rejuvenation_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.GOLEM_OF_REJUVENATION)),
            paratiku_egg = registerItem("paratiku_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.PARATIKU)),
            seimer_egg = registerItem("seimer_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SEIMER)),


    //Tools, Weapons & Armor
            //Swords
            cyclopsian_sword = registerItem("cyclopsian_sword", () -> new ItemModSword(ToolStats.CYCLOPSIAN_SWORD)),
            slime_sword = registerItem("slime_sword", () -> new ItemModSword(ToolStats.SLIME_SWORD)),
            glacier_sword = registerItem("glacier_sword", () -> new ItemModSword(ToolStats.GLACIER_SWORD)),
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
            bedrock_sword = registerItem("bedrock_sword", () -> new ItemModSword(ToolStats.BEDROCK_SWORD, new Properties().fireResistant())),
            bedrock_maul = registerItem("bedrock_maul", () -> new ItemModSword(ToolStats.BEDROCK_MAUL, new Properties().fireResistant())),
            frozen_maul = registerItem("frozen_maul", () -> new ItemModSword(ToolStats.FROZEN_MAUL)),
            fury_maul = registerItem("fury_maul", () -> new ItemModSword(ToolStats.FURY_MAUL)),
            death_bringer = registerItem("death_bringer", () -> new ItemModSword(ToolStats.DEATH_BRINGER)),
            corrupted_maul = registerItem("corrupted_maul", () -> new ItemModSword(ToolStats.CORRUPTED_MAUL)),
            terran_dagger = registerItem("terran_dagger", () -> new ItemModSword(ToolStats.TERRAN_DAGGER)),
            terran_knife = registerItem("terran_knife", () -> new ItemModSword(ToolStats.TERRAN_KNIFE)),
            terran_maul = registerItem("terran_maul", () -> new ItemModSword(ToolStats.TERRAN_MAUL)),
            jungle_knife = registerItem("jungle_knife", () -> new ItemModSword(ToolStats.JUNGLE_KNIFE)),
            jungle_rapier = registerItem("jungle_rapier", () -> new ItemModSword(ToolStats.JUNGLE_RAPIER)),
            poison_saber = registerItem("poison_saber", () -> new ItemModSword(ToolStats.POISON_SABER)),
            bloodgem_sword = registerItem("bloodgem_sword", () -> new ItemModSword(ToolStats.BLOODGEM_SWORD)),
            molten_sword = registerItem("molten_sword", () -> new ItemModSword(ToolStats.MOLTEN_SWORD, new Properties().fireResistant())),
            scorching_sword = registerItem("scorching_sword", () -> new ItemModSword(ToolStats.SCORCHING_SWORD)),
            soulfire_sword = registerItem("soulfire_sword", () -> new ItemModSword(ToolStats.SOULFIRE_SWORD)),
            inferno_sword = registerItem("inferno_sword", () -> new ItemModSword(ToolStats.INFERNO_SWORD, new Properties().fireResistant())),
            flaming_fury = registerItem("flaming_fury", () -> new ItemModSword(ToolStats.FLAMING_FURY, new Properties().fireResistant())),
            sabear_sabre = registerItem("sabear_sabre", () -> new ItemModSword(ToolStats.SABEAR_SABRE)),
            frost_sword = registerItem("frost_sword", () -> new ItemModSword(ToolStats.FROST_SWORD)),
            frostking_sword = registerItem("frostking_sword", () -> new ItemModSword(ToolStats.FROSTKING_SWORD)),
            icicle_bane = registerItem("icicle_bane", () -> new ItemModSword(ToolStats.ICICLE_BANE)),
            glacial_blade = registerItem("glacial_blade", () -> new ItemModSword(ToolStats.GLACIAL_BLADE)),
            icicle_dagger = registerItem("icicle_dagger", () -> new ItemModSword(ToolStats.ICICLE_DAGGER)),
            ender_sword = registerItem("ender_sword", () -> new ItemModSword(RarityList.ENDER, ToolStats.ENDER_SWORD)),
            red_ender_sword = registerItem("red_ender_sword", () -> new ItemModSword(RarityList.RED, ToolStats.ENDER_SWORD)),
            yellow_ender_sword = registerItem("yellow_ender_sword", () -> new ItemModSword(Rarity.UNCOMMON, ToolStats.ENDER_SWORD)),
            green_ender_sword = registerItem("green_ender_sword", () -> new ItemModSword(RarityList.GREEN, ToolStats.ENDER_SWORD)),
            blue_ender_sword = registerItem("blue_ender_sword", () -> new ItemModSword(RarityList.BLUE, ToolStats.ENDER_SWORD)),
            black_ender_sword = registerItem("black_ender_sword", () -> new ItemModSword(RarityList.DARK_GRAY, ToolStats.ENDER_SWORD)),
            enderice = registerItem("enderice", () -> new ItemModSword(ToolStats.ENDERICE)),
            divine_sword = registerItem("divine_sword", () -> new ItemModSword(RarityList.DIVINE, ToolStats.DIVINE_SWORD)),
            red_divine_sword = registerItem("red_divine_sword", () -> new ItemModSword(RarityList.RED, ToolStats.DIVINE_SWORD)),
            yellow_divine_sword = registerItem("yellow_divine_sword", () -> new ItemModSword(Rarity.UNCOMMON, ToolStats.DIVINE_SWORD)),
            green_divine_sword = registerItem("green_divine_sword", () -> new ItemModSword(RarityList.GREEN, ToolStats.DIVINE_SWORD)),
            blue_divine_sword = registerItem("blue_divine_sword", () -> new ItemModSword(RarityList.BLUE, ToolStats.DIVINE_SWORD)),
            gray_divine_sword = registerItem("gray_divine_sword", () -> new ItemModSword(RarityList.GRAY, ToolStats.DIVINE_SWORD)),
            icine_sword = registerItem("icine_sword", () -> new ItemModSword(ToolStats.ICINE_SWORD)),
            sandslash = registerItem("sandslash", () -> new ItemModSword(ToolStats.SANDSLASH)),
            snowslash = registerItem("snowslash", () -> new ItemModSword(ToolStats.SNOWSLASH)),
            storm_sword = registerItem("storm_sword", ItemStormSword::new),
            shadow_saber = registerItem("shadow_saber", ItemShadowSaber::new),
            arcanium_saber = registerItem("arcanium_saber", () -> new ItemModSword(ToolStats.ARCANIUM_SABER).setAttackArcanaConsumption(25)),
            arcanite_blade = registerItem("arcanite_blade", () -> new ItemModSword(ToolStats.ARCANITE_BLADE).setAttackArcanaConsumption(30)),
            livicia_sword = registerItem("livicia_sword", () -> new ItemModSword(ToolStats.LIVICIA_SWORD)),
            eden_blade = registerItem("eden_blade", () -> new ItemModSword(RarityList.EDEN, ToolStats.EDEN_BLADE)),
            wildwood_blade = registerItem("wildwood_blade", () -> new ItemModSword(RarityList.WILDWOOD, ToolStats.WILDWOOD_BLADE)),
            apalachia_blade = registerItem("apalachia_blade", () -> new ItemModSword(RarityList.APALACHIA, ToolStats.APALACHIA_BLADE)),
            skythern_blade = registerItem("skythern_blade", () -> new ItemModSword(RarityList.SKYTHERN, ToolStats.SKYTHERN_BLADE)),
            mortum_blade = registerItem("mortum_blade", () -> new ItemModSword(RarityList.MORTUM, ToolStats.MORTUM_BLADE)),
            halite_blade = registerItem("halite_blade", () -> new ItemModSword(RarityList.HALITE, ToolStats.HALITE_BLADE)),

            //Healing
            palavence = registerItem("palavence", () -> new ItemHealingSword(ToolStats.PALAVENCE, .5F)),
            massivence = registerItem("massivence", () -> new ItemHealingSword(ToolStats.MASSIVENCE, 1)),
            frossivence = registerItem("frossivence", () -> new ItemHealingSword(ToolStats.FROSSIVENCE, 1)),

            //Arcana Misc.
            divine_accumulator = registerItem("divine_accumulator", ItemDivineAccumulator::new),
            ender_scepter = registerItem("ender_scepter", ItemEnderScepter::new),
            ghostbane = registerItem("ghostbane", ItemGhostbane::new),
            staff_of_enrichment = registerItem("staff_of_enrichment", ItemStaffEnrichment::new),
            arcanium_attractor = registerItem("arcanium_attractor", () -> new ItemModRanged(BulletType.ATTRACTOR_SHOT, SoundRegistry.REFLECTOR.get(), null, 0, 0, 20)),
            arcanium_reflector = registerItem("arcanium_reflector", () -> new ItemModRanged(BulletType.REFLECTOR_SHOT, SoundRegistry.REFLECTOR.get(), null, 0, 0, 20)),

            //Shields
            realmite_shield = registerItem("realmite_shield", () -> new DivineShield(realmite_ingot.get(), 426, "realmite_shield")),
            arlemite_shield = registerItem("arlemite_shield", () -> new DivineShield(arlemite_ingot.get(), 734, "arlemite_shield")),
            rupee_shield = registerItem("rupee_shield", () -> new DivineShield(rupee_ingot.get(), 823, "rupee_shield")),
            eden_shield = registerItem("eden_shield", () -> new DivineShield(RarityList.EDEN, eden_gem.get(), 978, "eden_shield")),
            wildwood_shield = registerItem("wildwood_shield", () -> new DivineShield(RarityList.WILDWOOD, wildwood_gem.get(), 1125, "wildwood_shield")),
            apalachia_shield = registerItem("apalachia_shield", () -> new DivineShield(RarityList.APALACHIA, apalachia_gem.get(), 1256, "apalachia_shield")),
            skythern_shield = registerItem("skythern_shield", () -> new DivineShield(RarityList.SKYTHERN, skythern_gem.get(), 1485, "skythern_shield")),
            mortum_shield = registerItem("mortum_shield", () -> new DivineShield(RarityList.MORTUM, mortum_gem.get(), 1627, "mortum_shield")),
            halite_shield = registerItem("halite_shield", () -> new DivineShield(RarityList.HALITE, Items.AIR, 0, "halite_shield")),

            //Serenades
            serenade_striker = registerItem("serenade_striker", ItemSerenadeStriker::new),
            serenade_of_ice = registerItem("serenade_of_ice", () -> new ItemModRanged(BulletType.SERENADE_OF_ICE_SHOT, SoundRegistry.SERENADE.get(), 100, 0)),
            serenade_of_death = registerItem("serenade_of_death", () -> new ItemModRanged(BulletType.SERENADE_OF_DEATH_SHOT, SoundRegistry.SERENADE.get(), 857, 0)),
            serenade_of_health = registerItem("serenade_of_health", ItemSerenadeOfHealth::new),
            serenade_of_infusion = registerItem("serenade_of_infusion", ItemSerenadeOfInfusion::new),

            //Arrows
            eden_arrow = registerItem("eden_arrow"),
            wildwood_arrow = registerItem("wildwood_arrow"),
            fury_arrow = registerItem("fury_arrow"),

            //Vethean Arrows
            teaker_arrow = registerItemVethean("teaker_arrow"),
            darven_arrow = registerItemVethean("darven_arrow"),
            pardimal_arrow = registerItemVethean("pardimal_arrow"),
            karos_arrow = registerItemVethean("karos_arrow"),
            ever_arrow = registerItemVethean("ever_arrow"),

            //Bows
            hunter_bow = registerItem("hunter_bow", () -> new ItemModBow(ArrowType.HUNTER_ARROW, 1125)),
            shadow_bow = registerItem("shadow_bow", () -> new ItemModBow(ArrowType.SHADOW_ARROW, 1225, 36000)),
            icicle_bow = registerItem("icicle_bow", () -> new ItemModBow(ArrowType.ICICLE_ARROW, 1456, 24000)),
            inferno_bow = registerItem("inferno_bow", () -> new ItemModBow(ArrowType.INFERNO_ARROW, ItemModBow.DEFAULT_MAX_USE_DURATION, new Properties().durability(0).fireResistant())),
            soulfire_bow = registerItem("soulfire_bow", () -> new ItemModBow(ArrowType.SOULFIRE_ARROW, 0)),
            snowstorm_bow = registerItem("snowstorm_bow", () -> new ItemModBow(ArrowType.SNOWSTORM_ARROW, 0)),
            ender_bow = registerItem("ender_bow", () -> new ItemModBow(RarityList.ENDER, ArrowType.ENDER_ARROW, 0)),
            eden_bow = registerItem("eden_bow", () -> new ItemModBow(RarityList.EDEN, ArrowType.EDEN_ARROW, 1517)),
            wildwood_bow = registerItem("wildwood_bow", () -> new ItemModBow(RarityList.WILDWOOD, ArrowType.LESSER_WILDWOOD_ARROW, 1624, 36000)),
            apalachia_bow = registerItem("apalachia_bow", () -> new ItemModBow(RarityList.APALACHIA, ArrowType.GREATER_WILDWOOD_ARROW, 1778)),
            skythern_bow = registerItem("skythern_bow", () -> new ItemModBow(RarityList.SKYTHERN, ArrowType.GREATER_WILDWOOD_ARROW, 1879, 36000)),
            mortum_bow = registerItem("mortum_bow", () -> new ItemModBow(RarityList.MORTUM, ArrowType.FURY_ARROW, 1990)),
            halite_bow = registerItem("halite_bow", () -> new ItemModBow(RarityList.HALITE, ArrowType.FURY_ARROW, 2114, 36000)),
            twilight_bow = registerItem("twilight_bow", () -> new ItemModBow(ArrowType.FURY_ARROW, 2376, 14400)),

            //Anchors
            crab_anchor = registerItem("crab_anchor", () -> new ItemAnchor(ToolStats.CRAB_ANCHOR, BulletType.CRAB_ANCHOR_SHOT)),
            shark_anchor = registerItem("shark_anchor", () -> new ItemAnchor(ToolStats.SHARK_ANCHOR, BulletType.SHARK_ANCHOR_SHOT)),
            bowhead_anchor = registerItem("bowhead_anchor", () -> new ItemAnchor(ToolStats.BOWHEAD_ANCHOR, BulletType.BOWHEAD_ANCHOR_SHOT)),
            liopleurodon_anchor = registerItem("liopleurodon_anchor", () -> new ItemAnchor(ToolStats.LIOPLEURODON_ANCHOR, BulletType.LIOPLEURODON_ANCHOR_SHOT)),

            //Harps
            sound_of_music = registerItem("sound_of_music", () -> new ItemModRanged(BulletType.SOUND_OF_MUSIC_SHOT, SoundRegistry.SOUND_OF_MUSIC.get(), 666, 20)),
            sound_of_carols = registerItem("sound_of_carols", () -> new ItemModRanged(BulletType.SOUND_OF_CAROLS_SHOT, SoundRegistry.SOUND_OF_CAROLS.get(), 1025, 20)),
            sound_of_whales = registerItem("sound_of_whales", () -> new ItemModRanged(BulletType.SOUND_OF_WHALES_SHOT, SoundRegistry.WHALE.get(), 1592, 20)),

            //Shurikens
            shuriken = registerItem("shuriken", () -> new ItemModThrowable(BulletType.SHURIKEN_SHOT)),
            snowflake_shuriken = registerItem("snowflake_shuriken", () -> new ItemModThrowable(BulletType.SNOWFLAKE_SHURIKEN_SHOT)),
            vile_storm = registerItem("vile_storm", () -> new ItemModThrowable(BulletType.VILE_STORM_SHOT)),

            //Slicers
            eden_slicer = registerItem("eden_slicer", () -> new ItemModThrowable(RarityList.EDEN, BulletType.EDEN_SLICER_SHOT)),
            wildwood_slicer = registerItem("wildwood_slicer", () -> new ItemModThrowable(RarityList.WILDWOOD, BulletType.WILDWOOD_SLICER_SHOT)),
            apalachia_slicer = registerItem("apalachia_slicer", () -> new ItemModThrowable(RarityList.APALACHIA, BulletType.APALACHIA_SLICER_SHOT)),
            skythern_slicer = registerItem("skythern_slicer", () -> new ItemModThrowable(RarityList.SKYTHERN, BulletType.SKYTHERN_SLICER_SHOT)),
            mortum_slicer = registerItem("mortum_slicer", () -> new ItemModThrowable(RarityList.MORTUM, BulletType.MORTUM_SLICER_SHOT)),
            halite_slicer = registerItem("halite_slicer", () -> new ItemModThrowable(RarityList.HALITE, BulletType.HALITE_SLICER_SHOT)),

            //Extra
            scythe = registerItem("scythe", ItemScythe::new),
            cyclopsian_staff = registerItem("cyclopsian_staff", () -> new ItemModRanged(BulletType.CYCLOPSIAN_STAFF_SHOT, SoundRegistry.STAFF.get(), 126, 0)),
            maelstrom = registerItem("maelstrom", () -> new ItemModRanged(BulletType.MAELSTROM_SHOT, SoundRegistry.GHAST_CANNON.get(), 100, 20)),
            captains_sparkler = registerItem("captains_sparkler", () -> new ItemModRanged(BulletType.CAPTAINS_SPARKLER_SHOT, SoundRegistry.SPARKLER.get(), null, 1235, 15, 7)),
            grenade = registerItem("grenade", () -> new ItemModThrowable(BulletType.GRENADE)),
            la_vekor = registerItem("la_vekor", () -> new ItemModRanged(BulletType.GRENADE, SoundRegistry.LA_VEKOR.get(), ItemRegistry.grenade.get(), 1225, 10, 15)),
            firefly = registerItem("firefly", ItemFirefly::new),
            meriks_missile = registerItem("meriks_missile", ItemMeriksMissile::new),
            generals_staff = registerItem("generals_staff", () -> new ItemModRanged(BulletType.GENERALS_STAFF_SHOT, SoundRegistry.STARLIGHT.get(), null, 1212, 50, 20)),
            starlight = registerItem("starlight", () -> new ItemStaffSkyDrop(BulletType.STAR, 5, 1, 10, 1010)),
            staff_of_starlight = registerItem("staff_of_starlight", () -> new ItemStaffSkyDrop(BulletType.STAR, 25, 8, 40, 1176)),
            meteor_mash = registerItem("meteor_mash", () -> new ItemStaffSkyDrop(BulletType.METEOR, 35, 1, 30, 1218)),

            //Phasers
            eden_phaser = registerItem("eden_phaser", () -> new ItemTwilightPhaser(RarityList.EDEN, BulletType.EDEN_PHASER_SHOT, 1517)),
            wildwood_phaser = registerItem("wildwood_phaser", () -> new ItemTwilightPhaser(RarityList.WILDWOOD, BulletType.WILDWOOD_PHASER_SHOT, 1624)),
            apalachia_phaser = registerItem("apalachia_phaser", () -> new ItemTwilightPhaser(RarityList.APALACHIA, BulletType.APALACHIA_PHASER_SHOT, 1778)),
            skythern_phaser = registerItem("skythern_phaser", () -> new ItemTwilightPhaser(RarityList.SKYTHERN, BulletType.SKYTHERN_PHASER_SHOT, 1879)),
            mortum_phaser = registerItem("mortum_phaser", () -> new ItemTwilightPhaser(RarityList.MORTUM, BulletType.MORTUM_PHASER_SHOT, 1990)),
            halite_phaser = registerItem("halite_phaser", () -> new ItemTwilightPhaser(RarityList.HALITE, BulletType.HALITE_PHASER_SHOT, 2114)),

            //Cannons
            crabclaw_cannon = registerItem("crabclaw_cannon", () -> new ItemModRanged(BulletType.CRABCLAW_CANNON_SHOT, SoundRegistry.GHAST_CANNON.get(), Blocks.CACTUS.asItem(), 246, 20)),
            frostclaw_cannon = registerItem("frostclaw_cannon", () -> new ItemModRanged(BulletType.FROSTCLAW_CANNON_SHOT, SoundRegistry.FROSTCLAW_CANNON.get(), Blocks.CACTUS.asItem(), 612, 0)),
            bowhead_cannon = registerItem("bowhead_cannon", () -> new ItemModRanged(BulletType.BOWHEAD_CANNON_SHOT, SoundRegistry.GHAST_CANNON.get(), Blocks.CACTUS.asItem(), 592, 20)),
            frost_cannon = registerItem("frost_cannon", () -> new ItemModRanged(BulletType.FROST_CANNON_SHOT, SoundRegistry.FROST_CANNON.get(), Items.SNOWBALL, 1126, 0)),
            fractite_cannon = registerItem("fractite_cannon", () -> new ItemModRanged(BulletType.FRACTITE_CANNON_SHOT, SoundRegistry.FRACTITE_CANNON.get(), ice_shards.get(), 1442, 0)),
            ghast_cannon = registerItem("ghast_cannon", () -> new ItemModRanged(BulletType.GHAST_CANNON_SHOT, SoundRegistry.GHAST_CANNON.get(), 726, 20)),
            golden_fury = registerItem("golden_fury", () -> new ItemModRanged(BulletType.GOLDEN_FURY_SHOT, SoundRegistry.BLITZ.get(), Items.GOLD_NUGGET, 2417, 0)),

            //Blitz
            eden_blitz = registerItem("eden_blitz", () -> new ItemTwilightBlitz(RarityList.EDEN, BulletType.EDEN_BLITZ_SHOT, eden_dust.get(), 1517)),
            wildwood_blitz = registerItem("wildwood_blitz", () -> new ItemTwilightBlitz(RarityList.WILDWOOD, BulletType.WILDWOOD_BLITZ_SHOT, wildwood_dust.get(), 1624)),
            apalachia_blitz = registerItem("apalachia_blitz", () -> new ItemTwilightBlitz(RarityList.APALACHIA, BulletType.APALACHIA_BLITZ_SHOT, apalachia_dust.get(), 1778)),
            skythern_blitz = registerItem("skythern_blitz", () -> new ItemTwilightBlitz(RarityList.SKYTHERN, BulletType.SKYTHERN_BLITZ_SHOT, skythern_dust.get(), 1879)),
            mortum_blitz = registerItem("mortum_blitz", () -> new ItemTwilightBlitz(RarityList.MORTUM, BulletType.MORTUM_BLITZ_SHOT, mortum_dust.get(), 1990)),
            halite_blitz = registerItem("halite_blitz", () -> new ItemTwilightBlitz(RarityList.HALITE, BulletType.HALITE_BLITZ_SHOT, mortum_dust.get(), 2114)),

            //Shotguns
            corrupted_bullet = registerItem("corrupted_bullet"),
            corrupted_cannon = registerItem("corrupted_cannon", () -> new ItemModShotgun(BulletType.CORRUPTED_BULLET, SoundRegistry.GHAST_CANNON.get(), 1672, 15, corrupted_bullet.get(), 0, 4)),
            arcanite_blaster = registerItem("arcanite_blaster", () -> new ItemModShotgun(BulletType.ARCANITE_BLASTER, SoundRegistry.GHAST_CANNON.get(), 1127, 30, null, 20, 30)),

    //Tool Sets
    realmite_shovel = registerItem("realmite_shovel", () -> new ItemModShovel(ToolStats.REALMITE_SHOVEL)),
            realmite_pickaxe = registerItem("realmite_pickaxe", () -> new ItemModPickaxe(ToolStats.REALMITE_PICKAXE)),
            realmite_axe = registerItem("realmite_axe", () -> new ItemModAxe(ToolStats.REALMITE_AXE, -3.1F)),
            realmite_hoe = registerItem("realmite_hoe", () -> new ItemModHoe(ToolStats.REALMITE_HOE, -1)),

    oxdrite_pickaxe = registerItem("oxdrite_pickaxe", () -> new ItemModPickaxe(ToolStats.OXDRITE_PICKAXE)),

    arlemite_shovel = registerItem("arlemite_shovel", () -> new ItemModShovel(ToolStats.ARLEMITE_SHOVEL)),
            arlemite_pickaxe = registerItem("arlemite_pickaxe", () -> new ItemModPickaxe(ToolStats.ARLEMITE_PICKAXE)),
            arlemite_axe = registerItem("arlemite_axe", () -> new ItemModAxe(ToolStats.ARLEMITE_AXE, -3)),
            arlemite_hoe = registerItem("arlemite_hoe", () -> new ItemModHoe(ToolStats.ARLEMITE_HOE, 0)),
            arlemite_shickaxe = registerItem("arlemite_shickaxe", () -> new ItemShickaxe(ToolStats.ARLEMITE_SHICKAXE)),

    terran_shovel = registerItem("terran_shovel", () -> new ItemModShovel(ToolStats.TERRAN_SHOVEL)),
            terran_pickaxe = registerItem("terran_pickaxe", () -> new ItemModPickaxe(ToolStats.TERRAN_PICKAXE)),
            terran_axe = registerItem("terran_axe", () -> new ItemModAxe(ToolStats.TERRAN_AXE, -3)),
            terran_hoe = registerItem("terran_hoe", () -> new ItemModHoe(ToolStats.TERRAN_HOE, 0)),
            terran_shickaxe = registerItem("terran_shickaxe", () -> new ItemShickaxe(ToolStats.TERRAN_SHICKAXE)),

    rupee_shovel = registerItem("rupee_shovel", () -> new ItemModShovel(ToolStats.RUPEE_SHOVEL)),
            rupee_pickaxe = registerItem("rupee_pickaxe", () -> new ItemModPickaxe(ToolStats.RUPEE_PICKAXE)),
            rupee_axe = registerItem("rupee_axe", () -> new ItemModAxe(ToolStats.RUPEE_AXE, -3)),
            rupee_hoe = registerItem("rupee_hoe", () -> new ItemModHoe(ToolStats.RUPEE_HOE, 0)),
            rupee_shickaxe = registerItem("rupee_shickaxe", () -> new ItemShickaxe(ToolStats.RUPEE_SHICKAXE)),

    corrupted_shovel = registerItem("corrupted_shovel", () -> new ItemModShovel(ToolStats.CORRUPTED_SHOVEL)),
            corrupted_pickaxe = registerItem("corrupted_pickaxe", () -> new ItemModPickaxe(ToolStats.CORRUPTED_PICKAXE)),
            corrupted_axe = registerItem("corrupted_axe", () -> new ItemModAxe(ToolStats.CORRUPTED_AXE, -2.9F)),
            corrupted_hoe = registerItem("corrupted_hoe", () -> new ItemModHoe(ToolStats.CORRUPTED_HOE, 0)),
            corrupted_shickaxe = registerItem("corrupted_shickaxe", () -> new ItemShickaxe(ToolStats.CORRUPTED_SHICKAXE)),

    bedrock_shovel = registerItem("bedrock_shovel", () -> new ItemModShovel(ToolStats.BEDROCK_SHOVEL, new Properties().fireResistant())),
            bedrock_pickaxe = registerItem("bedrock_pickaxe", () -> new ItemModPickaxe(ToolStats.BEDROCK_PICKAXE, new Properties().fireResistant())),
            bedrock_axe = registerItem("bedrock_axe", () -> new ItemModAxe(ToolStats.BEDROCK_AXE, new Properties().fireResistant())),
            bedrock_hoe = registerItem("bedrock_hoe", () -> new ItemModHoe(ToolStats.BEDROCK_HOE, new Properties().fireResistant())),

    divine_shovel = registerItem("divine_shovel", () -> new ItemModShovel(ToolStats.DIVINE_SHOVEL, RarityList.DIVINE)),
            divine_pickaxe = registerItem("divine_pickaxe", () -> new ItemModPickaxe(ToolStats.DIVINE_PICKAXE, RarityList.DIVINE)),
            divine_axe = registerItem("divine_axe", () -> new ItemModAxe(ToolStats.DIVINE_AXE, -2.9F, RarityList.DIVINE)),
            divine_hoe = registerItem("divine_hoe", () -> new ItemModHoe(ToolStats.DIVINE_HOE, RarityList.DIVINE)),
            divine_shickaxe = registerItem("divine_shickaxe", () -> new ItemShickaxe(RarityList.DIVINE, ToolStats.DIVINE_SHICKAXE)),

    eden_shovel = registerItem("eden_shovel", () -> new ItemModShovel(ToolStats.EDEN_SHOVEL, RarityList.EDEN)),
            eden_pickaxe = registerItem("eden_pickaxe", () -> new ItemModPickaxe(ToolStats.EDEN_PICKAXE, RarityList.EDEN)),
            eden_axe = registerItem("eden_axe", () -> new ItemModAxe(ToolStats.EDEN_AXE, -2.8F, RarityList.EDEN)),
            eden_hoe = registerItem("eden_hoe", () -> new ItemModHoe(ToolStats.EDEN_HOE, RarityList.EDEN)),
            eden_shickaxe = registerItem("eden_shickaxe", () -> new ItemShickaxe(RarityList.EDEN, ToolStats.EDEN_SHICKAXE)),

    wildwood_shovel = registerItem("wildwood_shovel", () -> new ItemModShovel(ToolStats.WILDWOOD_SHOVEL, RarityList.WILDWOOD)),
            wildwood_pickaxe = registerItem("wildwood_pickaxe", () -> new ItemModPickaxe(ToolStats.WILDWOOD_PICKAXE, RarityList.WILDWOOD)),
            wildwood_axe = registerItem("wildwood_axe", () -> new ItemModAxe(ToolStats.WILDWOOD_AXE, -2.8F, RarityList.WILDWOOD)),
            wildwood_hoe = registerItem("wildwood_hoe", () -> new ItemModHoe(ToolStats.WILDWOOD_HOE, RarityList.WILDWOOD)),
            wildwood_shickaxe = registerItem("wildwood_shickaxe", () -> new ItemShickaxe(RarityList.WILDWOOD, ToolStats.WILDWOOD_SHICKAXE)),

    apalachia_shovel = registerItem("apalachia_shovel", () -> new ItemModShovel(ToolStats.APALACHIA_SHOVEL, RarityList.APALACHIA)),
            apalachia_pickaxe = registerItem("apalachia_pickaxe", () -> new ItemModPickaxe(ToolStats.APALACHIA_PICKAXE, RarityList.APALACHIA)),
            apalachia_axe = registerItem("apalachia_axe", () -> new ItemModAxe(ToolStats.APALACHIA_AXE, -2.8F, RarityList.APALACHIA)),
            apalachia_hoe = registerItem("apalachia_hoe", () -> new ItemModHoe(ToolStats.APALACHIA_HOE, RarityList.APALACHIA)),
            apalachia_shickaxe = registerItem("apalachia_shickaxe", () -> new ItemShickaxe(RarityList.APALACHIA, ToolStats.APALACHIA_SHICKAXE)),

    skythern_shovel = registerItem("skythern_shovel", () -> new ItemModShovel(ToolStats.SKYTHERN_SHOVEL, RarityList.SKYTHERN)),
            skythern_pickaxe = registerItem("skythern_pickaxe", () -> new ItemModPickaxe(ToolStats.SKYTHERN_PICKAXE, RarityList.SKYTHERN)),
            skythern_axe = registerItem("skythern_axe", () -> new ItemModAxe(ToolStats.SKYTHERN_AXE, -2.8F, RarityList.SKYTHERN)),
            skythern_hoe = registerItem("skythern_hoe", () -> new ItemModHoe(ToolStats.SKYTHERN_HOE, RarityList.SKYTHERN)),
            skythern_shickaxe = registerItem("skythern_shickaxe", () -> new ItemShickaxe(RarityList.SKYTHERN, ToolStats.SKYTHERN_SHICKAXE)),

    mortum_shovel = registerItem("mortum_shovel", () -> new ItemModShovel(ToolStats.MORTUM_SHOVEL, RarityList.MORTUM)),
            mortum_pickaxe = registerItem("mortum_pickaxe", () -> new ItemModPickaxe(ToolStats.MORTUM_PICKAXE, RarityList.MORTUM)),
            mortum_axe = registerItem("mortum_axe", () -> new ItemModAxe(ToolStats.MORTUM_AXE, -2.8F, RarityList.MORTUM)),
            mortum_hoe = registerItem("mortum_hoe", () -> new ItemModHoe(ToolStats.MORTUM_HOE, RarityList.MORTUM)),
            mortum_shickaxe = registerItem("mortum_shickaxe", () -> new ItemShickaxe(RarityList.MORTUM, ToolStats.MORTUM_SHICKAXE)),

    halite_shickaxe = registerItem("halite_shickaxe", () -> new ItemShickaxe(RarityList.HALITE, ToolStats.HALITE_SHICKAXE)),

    dream_shovel = registerItemVethean("dream_shovel", () -> new ItemModShovel(ToolStats.DREAM_SHOVEL)),
            dream_pickaxe = registerItemVethean("dream_pickaxe", () -> new ItemModPickaxe(ToolStats.DREAM_PICKAXE)),
            dream_axe = registerItemVethean("dream_axe", () -> new ItemModAxe(ToolStats.DREAM_AXE, -3.1F)),

            //Buckets
            gem_fin_bucket = registerItem("gem_fin_bucket", () -> new MobBucketItem(EntityRegistry.GEM_FIN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Properties()).stacksTo(1))),
            cauldron_fish_bucket = registerItem("cauldron_fish_bucket", () -> new MobBucketItem(EntityRegistry.CAULDRON_FISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Properties().stacksTo(1))),
            smoldering_tar_bucket = registerItem("smoldering_tar_bucket", () -> new BucketItem(FluidRegistry.SMOLDERING_TAR_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1))),

    //Vethean Swords
            teaker_backsword = registerItemVethean("teaker_backsword", () -> new ItemModSword(ToolStats.TEAKER_BACKSWORD)),
            amthirmis_backsword = registerItemVethean("amthirmis_backsword", () -> new ItemModSword(ToolStats.AMTHIRMIS_BACKSWORD)),
            darven_backsword = registerItemVethean("darven_backsword", () -> new ItemModSword(ToolStats.DARVEN_BACKSWORD)),
            cermile_backsword = registerItemVethean("cermile_backsword", () -> new ItemModSword(ToolStats.CERMILE_BACKSWORD)),
            pardimal_backsword = registerItemVethean("pardimal_backsword", () -> new ItemModSword(ToolStats.PARDIMAL_BACKSWORD)),
            quadrotic_backsword = registerItemVethean("quadrotic_backsword", () -> new ItemModSword(ToolStats.QUADROTIC_BACKSWORD)),
            karos_backsword = registerItemVethean("karos_backsword", () -> new ItemModSword(ToolStats.KAROS_BACKSWORD)),
            heliosis_backsword = registerItemVethean("heliosis_backsword", () -> new ItemModSword(ToolStats.HELIOSIS_BACKSWORD)),
            arksiane_backsword = registerItemVethean("arksiane_backsword", () -> new ItemModSword(ToolStats.ARKSIANE_BACKSWORD)),

            //Hammers
            teaker_hammer = registerItemVethean("teaker_hammer", () -> new ItemModSword(ToolStats.TEAKER_HAMMER)),
            amthirmis_hammer = registerItemVethean("amthirmis_hammer", () -> new ItemModSword(ToolStats.AMTHIRMIS_HAMMER)),
            darven_hammer = registerItemVethean("darven_hammer", () -> new ItemModSword(ToolStats.DARVEN_HAMMER)),
            cermile_hammer = registerItemVethean("cermile_hammer", () -> new ItemModSword(ToolStats.CERMILE_HAMMER)),
            pardimal_hammer = registerItemVethean("pardimal_hammer", () -> new ItemModSword(ToolStats.PARDIMAL_HAMMER)),
            quadrotic_hammer = registerItemVethean("quadrotic_hammer", () -> new ItemModSword(ToolStats.QUADROTIC_HAMMER)),
            karos_hammer = registerItemVethean("karos_hammer", () -> new ItemModSword(ToolStats.KAROS_HAMMER)),
            heliosis_hammer = registerItemVethean("heliosis_hammer", () -> new ItemModSword(ToolStats.HELIOSIS_HAMMER)),
            arksiane_hammer = registerItemVethean("arksiane_hammer", () -> new ItemModSword(ToolStats.ARKSIANE_HAMMER)),
            everlight = registerItemVethean("everlight", () -> new ItemModSword(ToolStats.EVERLIGHT)),
            karos_rockmaul = registerItemVethean("karos_rockmaul", () -> new ItemModSword(ToolStats.KAROS_ROCKMAUL)),

            //Claws
            teaker_claw = registerItemVethean("teaker_claw", () -> new ItemModSword(ToolStats.TEAKER_CLAW)),
            amthirmis_claw = registerItemVethean("amthirmis_claw", () -> new ItemModSword(ToolStats.AMTHIRMIS_CLAW)),
            darven_claw = registerItemVethean("darven_claw", () -> new ItemModSword(ToolStats.DARVEN_CLAW)),
            cermile_claw = registerItemVethean("cermile_claw", () -> new ItemModSword(ToolStats.CERMILE_CLAW)),
            pardimal_claw = registerItemVethean("pardimal_claw", () -> new ItemModSword(ToolStats.PARDIMAL_CLAW)),
            quadrotic_claw = registerItemVethean("quadrotic_claw", () -> new ItemModSword(ToolStats.QUADROTIC_CLAW)),
            karos_claw = registerItemVethean("karos_claw", () -> new ItemModSword(ToolStats.KAROS_CLAW)),
            heliosis_claw = registerItemVethean("heliosis_claw", () -> new ItemModSword(ToolStats.HELIOSIS_CLAW)),
            arksiane_claw = registerItemVethean("arksiane_claw", () -> new ItemModSword(ToolStats.ARKSIANE_CLAW)),
            everbright = registerItemVethean("everbright", () -> new ItemModSword(ToolStats.EVERBRIGHT)),

            //Vethean Bows
            teaker_bow = registerItemVethean("teaker_bow", () -> new ItemModBow(ArrowType.TEAKER_ARROW, 0)),
            amthirmis_bow = registerItemVethean("amthirmis_bow", () -> new ItemModBow(ArrowType.AMTHIRMIS_ARROW, 0)),
            darven_bow = registerItemVethean("darven_bow", () -> new ItemModBow(ArrowType.DARVEN_ARROW, 0)),
            cermile_bow = registerItemVethean("cermile_bow", () -> new ItemModBow(ArrowType.CERMILE_ARROW, 0)),
            pardimal_bow = registerItemVethean("pardimal_bow", () -> new ItemModBow(ArrowType.PARDIMAL_ARROW, 0)),
            quadrotic_bow = registerItemVethean("quadrotic_bow", () -> new ItemModBow(ArrowType.QUADROTIC_ARROW, 0)),
            karos_bow = registerItemVethean("karos_bow", () -> new ItemModBow(ArrowType.KAROS_ARROW, 0)),
            heliosis_bow = registerItemVethean("heliosis_bow", () -> new ItemModBow(ArrowType.HELIOSIS_ARROW, 0)),
            arksiane_bow = registerItemVethean("arksiane_bow", () -> new ItemModBow(ArrowType.ARKSIANE_ARROW, 0)),
            everfright = registerItemVethean("everfright", () -> new ItemModBow(ArrowType.EVERFRIGHT, 0)),

            //Vethean Staffs
            teaker_staff = registerItemVethean("teaker_staff", () -> new ItemStaff(BulletType.TEAKER_STAFF_SHOT, 10, 0)),
            amthirmis_staff = registerItemVethean("amthirmis_staff", () -> new ItemStaff(BulletType.AMTHIRMIS_STAFF_SHOT, 10, 0)),
            darven_staff = registerItemVethean("darven_staff", () -> new ItemStaff(BulletType.DARVEN_STAFF_SHOT, 10, 0)),
            cermile_staff = registerItemVethean("cermile_staff", () -> new ItemStaff(BulletType.CERMILE_STAFF_SHOT, 10, 0)),
            pardimal_staff = registerItemVethean("pardimal_staff", () -> new ItemStaff(BulletType.PARDIMAL_STAFF_SHOT, 10, 0)),
            quadrotic_staff = registerItemVethean("quadrotic_staff", () -> new ItemStaff(BulletType.QUADROTIC_STAFF_SHOT, 10, 0)),
            karos_staff = registerItemVethean("karos_staff", () -> new ItemStaff(BulletType.KAROS_STAFF_SHOT, 10, 0)),
            heliosis_staff = registerItemVethean("heliosis_staff", () -> new ItemStaff(BulletType.HELIOSIS_STAFF_SHOT, 10, 0)),
            arksiane_staff = registerItemVethean("arksiane_staff", () -> new ItemStaff(BulletType.ARKSIANE_STAFF_SHOT, 10, 0)),
            evernight = registerItemVethean("evernight", () -> new ItemStaff(BulletType.EVERNIGHT_SHOT, 80, 20)),

            //Vethean Cannons
            teaker_cannon = registerItemVethean("teaker_cannon", () -> new ItemVetheanCannon(BulletType.TEAKER_CANNON_SHOT)),
            amthirmis_cannon = registerItemVethean("amthirmis_cannon", () -> new ItemVetheanCannon(BulletType.AMTHIRMIS_CANNON_SHOT)),
            darven_cannon = registerItemVethean("darven_cannon", () -> new ItemVetheanCannon(BulletType.DARVEN_CANNON_SHOT)),
            cermile_cannon = registerItemVethean("cermile_cannon", () -> new ItemVetheanCannon(BulletType.CERMILE_CANNON_SHOT)),
            pardimal_cannon = registerItemVethean("pardimal_cannon", () -> new ItemVetheanCannon(BulletType.PARDIMAL_CANNON_SHOT)),
            quadrotic_cannon = registerItemVethean("quadrotic_cannon", () -> new ItemVetheanCannon(BulletType.QUADROTIC_CANNON_SHOT)),
            karos_cannon = registerItemVethean("karos_cannon", () -> new ItemVetheanCannon(BulletType.KAROS_CANNON_SHOT)),
            heliosis_cannon = registerItemVethean("heliosis_cannon", () -> new ItemVetheanCannon(BulletType.HELIOSIS_CANNON_SHOT)),
            arksiane_cannon = registerItemVethean("arksiane_cannon", () -> new ItemVetheanCannon(BulletType.ARKSIANE_CANNON_SHOT)),
            eversight = registerItemVethean("eversight", () -> new ItemVetheanCannon(BulletType.EVERSIGHT_SHOT)),

            //Vethean Disks
            teaker_disk = registerItemVethean("teaker_disk", () -> new ItemVetheanDisk(BulletType.TEAKER_DISK)),
            amthirmis_disk = registerItemVethean("amthirmis_disk", () -> new ItemVetheanDisk(BulletType.AMTHIRMIS_DISK)),
            darven_disk = registerItemVethean("darven_disk", () -> new ItemVetheanDisk(BulletType.DARVEN_DISK)),
            cermile_disk = registerItemVethean("cermile_disk", () -> new ItemVetheanDisk(BulletType.CERMILE_DISK)),
            pardimal_disk = registerItemVethean("pardimal_disk", () -> new ItemVetheanDisk(BulletType.PARDIMAL_DISK)),
            quadrotic_disk = registerItemVethean("quadrotic_disk", () -> new ItemVetheanDisk(BulletType.QUADROTIC_DISK)),
            karos_disk = registerItemVethean("karos_disk", () -> new ItemVetheanDisk(BulletType.KAROS_DISK)),
            heliosis_disk = registerItemVethean("heliosis_disk", () -> new ItemVetheanDisk(BulletType.HELIOSIS_DISK)),
            arksiane_disk = registerItemVethean("arksiane_disk", () -> new ItemVetheanDisk(BulletType.ARKSIANE_DISK)),

            //Vethean Dissipators
            teaker_dissipator = registerItemVethean("teaker_dissipator", () -> new ItemVetheanDissipator(BulletType.TEAKER_DISSIPATOR)),
            amthirmis_dissipator = registerItemVethean("amthirmis_dissipator", () -> new ItemVetheanDissipator(BulletType.AMTHIRMIS_DISSIPATOR)),
            darven_dissipator = registerItemVethean("darven_dissipator", () -> new ItemVetheanDissipator(BulletType.DARVEN_DISSIPATOR)),
            cermile_dissipator = registerItemVethean("cermile_dissipator", () -> new ItemVetheanDissipator(BulletType.CERMILE_DISSIPATOR)),
            pardimal_dissipator = registerItemVethean("pardimal_dissipator", () -> new ItemVetheanDissipator(BulletType.PARDIMAL_DISSIPATOR)),
            quadrotic_dissipator = registerItemVethean("quadrotic_dissipator", () -> new ItemVetheanDissipator(BulletType.QUADROTIC_DISSIPATOR)),
            karos_dissipator = registerItemVethean("karos_dissipator", () -> new ItemVetheanDissipator(BulletType.KAROS_DISSIPATOR)),
            heliosis_dissipator = registerItemVethean("heliosis_dissipator", () -> new ItemVetheanDissipator(BulletType.HELIOSIS_DISSIPATOR)),
            arksiane_dissipator = registerItemVethean("arksiane_dissipator", () -> new ItemVetheanDissipator(BulletType.ARKSIANE_DISSIPATOR)),

            //Armor Pouches
            armor_pouch = registerItem("armor_pouch", () -> new ItemArmorPouch(Rarity.COMMON)),
            red_armor_pouch = registerItem("red_armor_pouch", () -> new ItemArmorPouch(RarityList.RED)),
            yellow_armor_pouch = registerItem("yellow_armor_pouch", () -> new ItemArmorPouch(Rarity.UNCOMMON)),
            green_armor_pouch = registerItem("green_armor_pouch", () -> new ItemArmorPouch(RarityList.GREEN)),
            blue_armor_pouch = registerItem("blue_armor_pouch", () -> new ItemArmorPouch(RarityList.BLUE)),
            gray_armor_pouch = registerItem("gray_armor_pouch", () -> new ItemArmorPouch(RarityList.GRAY)),

            //Blocks
            nightmare_bed = registerItemVethean("nightmare_bed", ItemNightmareBed::new),
            aqua_torch = registerItem("aqua_torch", () -> new StandingAndWallBlockItem(BlockRegistry.aquaTorch.get(), BlockRegistry.aquaWallTorch.get(), new Properties(), Direction.DOWN)),
            skeleton_torch = registerItem("skeleton_torch", () -> new StandingAndWallBlockItem(BlockRegistry.skeletonTorch.get(), BlockRegistry.skeletonWallTorch.get(), new Properties(), Direction.DOWN)),
            arcanium_torch = registerItem("arcanium_torch", () -> new StandingAndWallBlockItem(BlockRegistry.arcaniumTorch.get(), BlockRegistry.arcaniumWallTorch.get(), new Properties(), Direction.DOWN)),
            eden_torch = registerItem("eden_torch", () -> new StandingAndWallBlockItem(BlockRegistry.edenTorch.get(), BlockRegistry.edenWallTorch.get(), new Properties(), Direction.DOWN));

    //Armour
    public static final RegistryObject<Item>
    realmite_helmet = registerItem("realmite_helmet", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.HELMET)),
            realmite_chestplate = registerItem("realmite_chestplate", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.CHESTPLATE)),
            realmite_leggings = registerItem("realmite_leggings", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.LEGGINGS)),
            realmite_boots = registerItem("realmite_boots", () -> new ItemDivineArmor(ArmorStats.REALMITE, ArmorItem.Type.BOOTS)),

    seng_fur_helmet = registerItem("seng_fur_helmet", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.HELMET, ArmorInfo.sengFurInfo, SENG_FUR.get(), WARMTH.get())),
            seng_fur_chestplate = registerItem("seng_fur_chestplate", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.CHESTPLATE, ArmorInfo.sengFurInfo)),
            seng_fur_leggings = registerItem("seng_fur_leggings", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.LEGGINGS, ArmorInfo.sengFurInfo)),
            seng_fur_boots = registerItem("seng_fur_boots", () -> new ItemDivineArmor(ArmorStats.SENG_FUR, ArmorItem.Type.BOOTS, ArmorInfo.sengFurInfo)),

	santa_helmet = registerItem("santa_helmet", () -> new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.HELMET, ArmorInfo.sengFurInfo, SENG_FUR.get(), WARMTH.get())),
		    santa_chestplate = registerItem("santa_chestplate", () -> new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.CHESTPLATE, ArmorInfo.sengFurInfo)),
		    santa_leggings = registerItem("santa_leggings", () -> new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.LEGGINGS, ArmorInfo.sengFurInfo)),
		    santa_boots = registerItem("santa_boots", () -> new ItemDivineArmor(ArmorStats.SANTA, ArmorItem.Type.BOOTS, ArmorInfo.sengFurInfo)),
            
    aquastrive_helmet = registerItem("aquastrive_helmet", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.HELMET, ArmorInfo.aquastriveInfo, MobEffects.WATER_BREATHING)),
            aquastrive_chestplate = registerItem("aquastrive_chestplate", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.CHESTPLATE, ArmorInfo.aquastriveInfo)),
            aquastrive_leggings = registerItem("aquastrive_leggings", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.LEGGINGS, ArmorInfo.aquastriveInfo)),
            aquastrive_boots = registerItem("aquastrive_boots", () -> new ItemDivineArmor(ArmorStats.AQUASTRIVE, ArmorItem.Type.BOOTS, ArmorInfo.aquastriveInfo)),

    kraken_helmet = registerItem("kraken_helmet", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.HELMET, ArmorInfo.krakenInfo, MobEffects.DOLPHINS_GRACE, MobEffects.CONDUIT_POWER)),
            kraken_chestplate = registerItem("kraken_chestplate", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.CHESTPLATE, ArmorInfo.krakenInfo)),
            kraken_leggings = registerItem("kraken_leggings", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.LEGGINGS, ArmorInfo.krakenInfo)),
            kraken_boots = registerItem("kraken_boots", () -> new ItemDivineArmor(ArmorStats.KRAKEN, ArmorItem.Type.BOOTS, ArmorInfo.krakenInfo)),

    jack_o_man_helmet = registerItem("jack_o_man_helmet", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.HELMET, ArmorInfo.jackomanInfo)),
            jack_o_man_chestplate = registerItem("jack_o_man_chestplate", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.CHESTPLATE, ArmorInfo.jackomanInfo)),
            jack_o_man_leggings = registerItem("jack_o_man_leggings", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.LEGGINGS, ArmorInfo.jackomanInfo)),
            jack_o_man_boots = registerItem("jack_o_man_boots", () -> new ItemDivineArmor(ArmorStats.JACK_O_MAN, ArmorItem.Type.BOOTS, ArmorInfo.jackomanInfo)),

    skeleman_helmet = registerItem("skeleman_helmet", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.HELMET, ArmorInfo.skelemanInfo, SKELEMAN_FEED.get())),
            skeleman_chestplate = registerItem("skeleman_chestplate", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.CHESTPLATE, ArmorInfo.skelemanInfo)),
            skeleman_leggings = registerItem("skeleman_leggings", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.LEGGINGS, ArmorInfo.skelemanInfo)),
            skeleman_boots = registerItem("skeleman_boots", () -> new ItemDivineArmor(ArmorStats.SKELEMAN, ArmorItem.Type.BOOTS, ArmorInfo.skelemanInfo)),

    wither_reaper_helmet = registerItem("wither_reaper_helmet", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.HELMET, ArmorInfo.witherReaperInfo, WITHER_PROTECTION.get())),
            wither_reaper_chestplate = registerItem("wither_reaper_chestplate", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.CHESTPLATE, ArmorInfo.witherReaperInfo)),
            wither_reaper_leggings = registerItem("wither_reaper_leggings", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.LEGGINGS, ArmorInfo.witherReaperInfo)),
            wither_reaper_boots = registerItem("wither_reaper_boots", () -> new ItemDivineArmor(ArmorStats.WITHER_REAPER, ArmorItem.Type.BOOTS, ArmorInfo.witherReaperInfo)),

    arlemite_helmet = registerItem("arlemite_helmet", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.HELMET, ArmorInfo.arlemiteInfo, PROJECTILE_PROTECTION.get())),
            arlemite_chestplate = registerItem("arlemite_chestplate", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.arlemiteInfo)),
            arlemite_leggings = registerItem("arlemite_leggings", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.LEGGINGS, ArmorInfo.arlemiteInfo)),
            arlemite_boots = registerItem("arlemite_boots", () -> new ItemDivineArmor(ArmorStats.ARLEMITE, ArmorItem.Type.BOOTS, ArmorInfo.arlemiteInfo)),

    frozen_helmet = registerItem("frozen_helmet", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.HELMET, ArmorInfo.frozenInfo, FROZEN_SLOWNESS.get())),
            frozen_chestplate = registerItem("frozen_chestplate", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.CHESTPLATE, ArmorInfo.frozenInfo)),
            frozen_leggings = registerItem("frozen_leggings", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.LEGGINGS, ArmorInfo.frozenInfo)),
            frozen_boots = registerItem("frozen_boots", () -> new ItemDivineArmor(ArmorStats.FROZEN, ArmorItem.Type.BOOTS, ArmorInfo.frozenInfo)),

    jungle_helmet = registerItem("jungle_helmet", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.HELMET, ArmorInfo.jungleInfo, POISON_PROTECTION.get())),
            jungle_chestplate = registerItem("jungle_chestplate", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.CHESTPLATE, ArmorInfo.jungleInfo)),
            jungle_leggings = registerItem("jungle_leggings", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.LEGGINGS, ArmorInfo.jungleInfo)),
            jungle_boots = registerItem("jungle_boots", () -> new ItemDivineArmor(ArmorStats.JUNGLE, ArmorItem.Type.BOOTS, ArmorInfo.jungleInfo)),

    inferno_helmet = registerItem("inferno_helmet", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.HELMET, ArmorInfo.fireInfo, new Properties().fireResistant(), MobEffects.FIRE_RESISTANCE)),
            inferno_chestplate = registerItem("inferno_chestplate", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.CHESTPLATE, ArmorInfo.fireInfo, new Properties().fireResistant())),
            inferno_leggings = registerItem("inferno_leggings", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.LEGGINGS, ArmorInfo.fireInfo, new Properties().fireResistant())),
            inferno_boots = registerItem("inferno_boots", () -> new ItemDivineArmor(ArmorStats.INFERNO, ArmorItem.Type.BOOTS, ArmorInfo.fireInfo, new Properties().fireResistant())),

    torridite_helmet = registerItem("torridite_helmet", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.HELMET, ArmorInfo.fireInfo, new Properties().fireResistant(), MobEffects.FIRE_RESISTANCE)),
            torridite_chestplate = registerItem("torridite_chestplate", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.fireInfo, new Properties().fireResistant())),
            torridite_leggings = registerItem("torridite_leggings", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.LEGGINGS, ArmorInfo.fireInfo, new Properties().fireResistant())),
            torridite_boots = registerItem("torridite_boots", () -> new ItemDivineArmor(ArmorStats.TORRIDITE, ArmorItem.Type.BOOTS, ArmorInfo.fireInfo, new Properties().fireResistant())),

    terran_helmet = registerItem("terran_helmet", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.HELMET, ArmorInfo.terranInfo, new int[]{2}, MobEffects.DIG_SPEED)),
            terran_chestplate = registerItem("terran_chestplate", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.CHESTPLATE, ArmorInfo.terranInfo)),
            terran_leggings = registerItem("terran_leggings", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.LEGGINGS, ArmorInfo.terranInfo)),
            terran_boots = registerItem("terran_boots", () -> new ItemDivineArmor(ArmorStats.TERRAN, ArmorItem.Type.BOOTS, ArmorInfo.terranInfo)),

    angelic_helmet = registerItem("angelic_helmet", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.HELMET, ArmorInfo.angelicInfo, PREVENT_FALL_DAMAGE.get(), ANGELIC_FLIGHT.get())),
            angelic_chestplate = registerItem("angelic_chestplate", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.CHESTPLATE, ArmorInfo.angelicInfo)),
            angelic_leggings = registerItem("angelic_leggings", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.LEGGINGS, ArmorInfo.angelicInfo)),
            angelic_boots = registerItem("angelic_boots", () -> new ItemDivineArmor(ArmorStats.ANGELIC, ArmorItem.Type.BOOTS, ArmorInfo.angelicInfo)),

    shadow_helmet = registerItem("shadow_helmet", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.HELMET, ArmorInfo.shadowInfo, STEP_ASSIST.get())),
            shadow_chestplate = registerItem("shadow_chestplate", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.CHESTPLATE, ArmorInfo.shadowInfo, new int[]{3}, MobEffects.MOVEMENT_SPEED)),
            shadow_leggings = registerItem("shadow_leggings", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.LEGGINGS, ArmorInfo.shadowInfo)),
            shadow_boots = registerItem("shadow_boots", () -> new ItemDivineArmor(ArmorStats.SHADOW, ArmorItem.Type.BOOTS, ArmorInfo.shadowInfo)),

    rupee_helmet = registerItem("rupee_helmet", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
            rupee_chestplate = registerItem("rupee_chestplate", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
            rupee_leggings = registerItem("rupee_leggings", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
            rupee_boots = registerItem("rupee_boots", () -> new ItemDivineArmor(ArmorStats.RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),

    red_rupee_helmet = registerItem("red_rupee_helmet", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
            red_rupee_chestplate = registerItem("red_rupee_chestplate", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
            red_rupee_leggings = registerItem("red_rupee_leggings", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
            red_rupee_boots = registerItem("red_rupee_boots", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),

    yellow_rupee_helmet = registerItem("yellow_rupee_helmet", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
            yellow_rupee_chestplate = registerItem("yellow_rupee_chestplate", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
            yellow_rupee_leggings = registerItem("yellow_rupee_leggings", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
            yellow_rupee_boots = registerItem("yellow_rupee_boots", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),

    green_rupee_helmet = registerItem("green_rupee_helmet", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
            green_rupee_chestplate = registerItem("green_rupee_chestplate", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
            green_rupee_leggings = registerItem("green_rupee_leggings", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
            green_rupee_boots = registerItem("green_rupee_boots", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),

    blue_rupee_helmet = registerItem("blue_rupee_helmet", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
            blue_rupee_chestplate = registerItem("blue_rupee_chestplate", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
            blue_rupee_leggings = registerItem("blue_rupee_leggings", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
            blue_rupee_boots = registerItem("blue_rupee_boots", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),

    gray_rupee_helmet = registerItem("gray_rupee_helmet", () -> new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.HELMET, ArmorInfo.rupeeInfo, MELEE_PROTECTION.get())),
            gray_rupee_chestplate = registerItem("gray_rupee_chestplate", () -> new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.CHESTPLATE, ArmorInfo.rupeeInfo)),
            gray_rupee_leggings = registerItem("gray_rupee_leggings", () -> new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.LEGGINGS, ArmorInfo.rupeeInfo)),
            gray_rupee_boots = registerItem("gray_rupee_boots", () -> new ItemDivineArmor(RarityList.GRAY, ArmorStats.GRAY_RUPEE, ArmorItem.Type.BOOTS, ArmorInfo.rupeeInfo)),

    elite_realmite_helmet = registerItem("elite_realmite_helmet", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.HELMET, ArmorInfo.eliteRealmiteInfo, PREVENT_FALL_DAMAGE.get())),
            elite_realmite_chestplate = registerItem("elite_realmite_chestplate", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.eliteRealmiteInfo)),
            elite_realmite_leggings = registerItem("elite_realmite_leggings", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.LEGGINGS, ArmorInfo.eliteRealmiteInfo)),
            elite_realmite_boots = registerItem("elite_realmite_boots", () -> new ItemDivineArmor(ArmorStats.ELITE_REALMITE, ArmorItem.Type.BOOTS, ArmorInfo.eliteRealmiteInfo)),

    corrupted_helmet = registerItem("corrupted_helmet", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.HELMET, ArmorInfo.corruptedInfo, CORRUPTED_STRENGTH.get())),
            corrupted_chestplate = registerItem("corrupted_chestplate", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.CHESTPLATE, ArmorInfo.corruptedInfo)),
            corrupted_leggings = registerItem("corrupted_leggings", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.LEGGINGS, ArmorInfo.corruptedInfo)),
            corrupted_boots = registerItem("corrupted_boots", () -> new ItemDivineArmor(ArmorStats.CORRUPTED, ArmorItem.Type.BOOTS, ArmorInfo.corruptedInfo)),

    bedrock_helmet = registerItem("bedrock_helmet", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.HELMET, ArmorInfo.bedrockInfo, new Properties().fireResistant(), MobEffects.FIRE_RESISTANCE, EXPLOSION_PROTECTION.get())),
            bedrock_chestplate = registerItem("bedrock_chestplate", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.CHESTPLATE, ArmorInfo.bedrockInfo, new Properties().fireResistant())),
            bedrock_leggings = registerItem("bedrock_leggings", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.LEGGINGS, ArmorInfo.bedrockInfo, new Properties().fireResistant())),
            bedrock_boots = registerItem("bedrock_boots", () -> new ItemDivineArmor(ArmorStats.BEDROCK, ArmorItem.Type.BOOTS, ArmorInfo.bedrockInfo, new Properties().fireResistant())),

    korma_helmet = registerItem("korma_helmet", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.HELMET, ArmorInfo.kormInfo, KORMA_ARCANA.get())),
            korma_chestplate = registerItem("korma_chestplate", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.CHESTPLATE, ArmorInfo.kormInfo)),
            korma_leggings = registerItem("korma_leggings", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.LEGGINGS, ArmorInfo.kormInfo)),
            korma_boots = registerItem("korma_boots", () -> new ItemDivineArmor(ArmorStats.KORMA, ArmorItem.Type.BOOTS, ArmorInfo.kormInfo)),

    vemos_helmet = registerItem("vemos_helmet", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.HELMET, ArmorInfo.vemInfo, VEMOS_HEAL.get())),
            vemos_chestplate = registerItem("vemos_chestplate", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.CHESTPLATE, ArmorInfo.vemInfo)),
            vemos_leggings = registerItem("vemos_leggings", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.LEGGINGS, ArmorInfo.vemInfo)),
            vemos_boots = registerItem("vemos_boots", () -> new ItemDivineArmor(ArmorStats.VEMOS, ArmorItem.Type.BOOTS, ArmorInfo.vemInfo)),

    ender_helmet = registerItem("ender_helmet", () -> new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
            ender_chestplate = registerItem("ender_chestplate", () -> new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
            ender_leggings = registerItem("ender_leggings", () -> new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
            ender_boots = registerItem("ender_boots", () -> new ItemDivineArmor(RarityList.ENDER, ArmorStats.ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),

    red_ender_helmet = registerItem("red_ender_helmet", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
            red_ender_chestplate = registerItem("red_ender_chestplate", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
            red_ender_leggings = registerItem("red_ender_leggings", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
            red_ender_boots = registerItem("red_ender_boots", () -> new ItemDivineArmor(RarityList.RED, ArmorStats.RED_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),

    yellow_ender_helmet = registerItem("yellow_ender_helmet", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
            yellow_ender_chestplate = registerItem("yellow_ender_chestplate", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
            yellow_ender_leggings = registerItem("yellow_ender_leggings", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
            yellow_ender_boots = registerItem("yellow_ender_boots", () -> new ItemDivineArmor(Rarity.UNCOMMON, ArmorStats.YELLOW_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),

    green_ender_helmet = registerItem("green_ender_helmet", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
            green_ender_chestplate = registerItem("green_ender_chestplate", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
            green_ender_leggings = registerItem("green_ender_leggings", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
            green_ender_boots = registerItem("green_ender_boots", () -> new ItemDivineArmor(RarityList.GREEN, ArmorStats.GREEN_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),

    blue_ender_helmet = registerItem("blue_ender_helmet", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
            blue_ender_chestplate = registerItem("blue_ender_chestplate", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
            blue_ender_leggings = registerItem("blue_ender_leggings", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
            blue_ender_boots = registerItem("blue_ender_boots", () -> new ItemDivineArmor(RarityList.BLUE, ArmorStats.BLUE_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),

    gray_ender_helmet = registerItem("gray_ender_helmet", () -> new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.HELMET, ArmorInfo.enderInfo, EXPLOSION_PROTECTION.get())),
            gray_ender_chestplate = registerItem("gray_ender_chestplate", () -> new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.CHESTPLATE, ArmorInfo.enderInfo)),
            gray_ender_leggings = registerItem("gray_ender_leggings", () -> new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.LEGGINGS, ArmorInfo.enderInfo)),
            gray_ender_boots = registerItem("gray_ender_boots", () -> new ItemDivineArmor(RarityList.DARK_GRAY, ArmorStats.GRAY_ENDER, ArmorItem.Type.BOOTS, ArmorInfo.enderInfo)),

    divine_helmet = registerItem("divine_helmet", () -> new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.HELMET, ArmorInfo.divineInfo, PREVENT_FALL_DAMAGE.get(), DIVINE_STRENGTH.get())),
            divine_chestplate = registerItem("divine_chestplate", () -> new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.CHESTPLATE, ArmorInfo.divineInfo, new int[]{1}, MobEffects.JUMP)),
            divine_leggings = registerItem("divine_leggings", () -> new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.LEGGINGS, ArmorInfo.divineInfo)),
            divine_boots = registerItem("divine_boots", () -> new ItemDivineArmor(RarityList.DIVINE, ArmorStats.DIVINE, ArmorItem.Type.BOOTS, ArmorInfo.divineInfo)),

    eden_helmet = registerItem("eden_helmet", () -> new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.HELMET, ArmorInfo.edenInfo)),
            eden_chestplate = registerItem("eden_chestplate", () -> new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.CHESTPLATE, ArmorInfo.edenInfo)),
            eden_leggings = registerItem("eden_leggings", () -> new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.LEGGINGS, ArmorInfo.edenInfo)),
            eden_boots = registerItem("eden_boots", () -> new ItemDivineArmor(RarityList.EDEN, ArmorStats.EDEN, ArmorItem.Type.BOOTS, ArmorInfo.edenInfo)),

    wildwood_helmet = registerItem("wildwood_helmet", () -> new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.HELMET, ArmorInfo.wildInfo, WILDWOOD_HEAL.get())),
            wildwood_chestplate = registerItem("wildwood_chestplate", () -> new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.CHESTPLATE, ArmorInfo.wildInfo)),
            wildwood_leggings = registerItem("wildwood_leggings", () -> new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.LEGGINGS, ArmorInfo.wildInfo)),
            wildwood_boots = registerItem("wildwood_boots", () -> new ItemDivineArmor(RarityList.WILDWOOD, ArmorStats.WILDWOOD, ArmorItem.Type.BOOTS, ArmorInfo.wildInfo)),

    apalachia_helmet = registerItem("apalachia_helmet", () -> new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.HELMET, ArmorInfo.apInfo, BLOCK_PROTECTION.get())),
            apalachia_chestplate = registerItem("apalachia_chestplate", () -> new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.CHESTPLATE, ArmorInfo.apInfo)),
            apalachia_leggings = registerItem("apalachia_leggings", () -> new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.LEGGINGS, ArmorInfo.apInfo)),
            apalachia_boots = registerItem("apalachia_boots", () -> new ItemDivineArmor(RarityList.APALACHIA, ArmorStats.APALACHIA, ArmorItem.Type.BOOTS, ArmorInfo.apInfo)),

    skythern_helmet = registerItem("skythern_helmet", () -> new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.HELMET, ArmorInfo.skyInfo, PREVENT_FALL_DAMAGE.get())),
            skythern_chestplate = registerItem("skythern_chestplate", () -> new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.CHESTPLATE, ArmorInfo.skyInfo, new int[] {5}, MobEffects.JUMP)),
            skythern_leggings = registerItem("skythern_leggings", () -> new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.LEGGINGS, ArmorInfo.skyInfo)),
            skythern_boots = registerItem("skythern_boots", () -> new ItemDivineArmor(RarityList.SKYTHERN, ArmorStats.SKYTHERN, ArmorItem.Type.BOOTS, ArmorInfo.skyInfo)),

    mortum_helmet = registerItem("mortum_helmet", () -> new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.HELMET, ArmorInfo.mortInfo, MobEffects.NIGHT_VISION)),
            mortum_chestplate = registerItem("mortum_chestplate", () -> new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.CHESTPLATE, ArmorInfo.mortInfo)),
            mortum_leggings = registerItem("mortum_leggings", () -> new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.LEGGINGS, ArmorInfo.mortInfo)),
            mortum_boots = registerItem("mortum_boots", () -> new ItemDivineArmor(RarityList.MORTUM, ArmorStats.MORTUM, ArmorItem.Type.BOOTS, ArmorInfo.mortInfo)),

    halite_helmet = registerItem("halite_helmet", () -> new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.HELMET, ArmorInfo.halInfo, HALITE_STRENGTH.get())),
            halite_chestplate = registerItem("halite_chestplate", () -> new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.halInfo)),
            halite_leggings = registerItem("halite_leggings", () -> new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.LEGGINGS, ArmorInfo.halInfo)),
            halite_boots = registerItem("halite_boots", () -> new ItemDivineArmor(RarityList.HALITE, ArmorStats.HALITE, ArmorItem.Type.BOOTS, ArmorInfo.halInfo)),

    awakened_halite_helmet = registerItem("awakened_halite_helmet", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.HELMET, ArmorInfo.awakened_halInfo, AWAKENED_HALITE_STRENGTH.get())),
            awakened_halite_chestplate = registerItem("awakened_halite_chestplate", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.CHESTPLATE, ArmorInfo.awakened_halInfo)),
            awakened_halite_leggings = registerItem("awakened_halite_leggings", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.LEGGINGS, ArmorInfo.awakened_halInfo)),
            awakened_halite_boots = registerItem("awakened_halite_boots", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, ArmorStats.AWAKENED_HALITE, ArmorItem.Type.BOOTS, ArmorInfo.awakened_halInfo)),

    degraded_helmet = registerItemVethean("degraded_helmet", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, ArmorInfo.basicHelmInfo, DEGRADED_HELMET.get())),
            degraded_hood = registerItemVethean("degraded_hood", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, ArmorInfo.basicHoodInfo, DEGRADED_HOOD.get())),
            degraded_mask = registerItemVethean("degraded_mask", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.HELMET, ArmorInfo.basicMaskInfo, DEGRADED_MASK.get())),
            degraded_chestplate = registerItemVethean("degraded_chestplate", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.CHESTPLATE)),
            degraded_leggings = registerItemVethean("degraded_leggings", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.LEGGINGS)),
            degraded_boots = registerItemVethean("degraded_boots", () -> new ItemDivineArmor(ArmorStats.DEGRADED, ArmorItem.Type.BOOTS)),

    finished_helmet = registerItemVethean("finished_helmet", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, ArmorInfo.basicHelmInfo, FINISHED_HELMET.get())),
            finished_hood = registerItemVethean("finished_hood", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, ArmorInfo.basicHoodInfo, FINISHED_HOOD.get())),
            finished_mask = registerItemVethean("finished_mask", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.HELMET, ArmorInfo.basicMaskInfo, FINISHED_MASK.get())),
            finished_chestplate = registerItemVethean("finished_chestplate", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.CHESTPLATE)),
            finished_leggings = registerItemVethean("finished_leggings", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.LEGGINGS)),
            finished_boots = registerItemVethean("finished_boots", () -> new ItemDivineArmor(ArmorStats.FINISHED, ArmorItem.Type.BOOTS)),

    glistening_helmet = registerItemVethean("glistening_helmet", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, ArmorInfo.glisteningHelmInfo, GLISTENING_HELMET.get())),
            glistening_hood = registerItemVethean("glistening_hood", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, ArmorInfo.glisteningHoodInfo, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, GLISTENING_HOOD.get())),
            glistening_mask = registerItemVethean("glistening_mask", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.HELMET, ArmorInfo.glisteningMaskInfo, MobEffects.MOVEMENT_SPEED, GLISTENING_MASK.get())),
            glistening_chestplate = registerItemVethean("glistening_chestplate", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.CHESTPLATE)),
            glistening_leggings = registerItemVethean("glistening_leggings", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.LEGGINGS)),
            glistening_boots = registerItemVethean("glistening_boots", () -> new ItemDivineArmor(ArmorStats.GLISTENING, ArmorItem.Type.BOOTS)),

    demonized_helmet = registerItemVethean("demonized_helmet", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, ArmorInfo.demonizedHelmInfo, DEMONIZED_HELMET.get())),
            demonized_hood = registerItemVethean("demonized_hood", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, ArmorInfo.demonizedHoodInfo, new int[]{0, 1, 0}, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, DEMONIZED_HOOD.get())),
            demonized_mask = registerItemVethean("demonized_mask", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.HELMET, ArmorInfo.demonizedMaskInfo, new int[]{1, 0}, MobEffects.MOVEMENT_SPEED, DEMONIZED_MASK.get())),
            demonized_chestplate = registerItemVethean("demonized_chestplate", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.CHESTPLATE)),
            demonized_leggings = registerItemVethean("demonized_leggings", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.LEGGINGS)),
            demonized_boots = registerItemVethean("demonized_boots", () -> new ItemDivineArmor(ArmorStats.DEMONIZED, ArmorItem.Type.BOOTS)),

    tormented_helmet = registerItemVethean("tormented_helmet", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, ArmorInfo.tormentedHelmInfo, TORMENTED_HELMET.get())),
            tormented_hood = registerItemVethean("tormented_hood", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, ArmorInfo.tormentedHoodInfo, new int[]{0, 2, 0}, PREVENT_FALL_DAMAGE.get(), MobEffects.JUMP, TORMENTED_HOOD.get())),
            tormented_mask = registerItemVethean("tormented_mask", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.HELMET, ArmorInfo.tormentedMaskInfo, new int[]{2, 0}, MobEffects.MOVEMENT_SPEED, TORMENTED_MASK.get())),
            tormented_chestplate = registerItemVethean("tormented_chestplate", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.CHESTPLATE)),
            tormented_leggings = registerItemVethean("tormented_leggings", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.LEGGINGS)),
            tormented_boots = registerItemVethean("tormented_boots", () -> new ItemDivineArmor(ArmorStats.TORMENTED, ArmorItem.Type.BOOTS));

    private static RegistryObject<Item> registerItemVethean(String registryId) {return ITEMS.register(registryId, ItemVethean::new);}
    private static <T extends Item> RegistryObject<T> registerItemVethean(String registryId, Supplier<T> item) {return ITEMS.register(registryId, item);}
    private static RegistryObject<Item> registerItem(String registryId) {return ITEMS.register(registryId, ItemMod::new);}
    private static <T extends Item> RegistryObject<T> registerItem(String registryId, Supplier<T> item) {return ITEMS.register(registryId, item);}
}