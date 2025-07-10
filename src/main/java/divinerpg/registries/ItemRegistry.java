package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.enums.*;
import divinerpg.items.arcana.*;
import divinerpg.items.base.*;
import divinerpg.items.iceika.*;
import divinerpg.items.ranged.*;
import divinerpg.items.ranged.shooter.*;
import divinerpg.items.ranged.staffs.*;
import divinerpg.items.twilight.*;
import divinerpg.items.vanilla.*;
import divinerpg.items.ranged.arrows.*;
import divinerpg.items.ranged.bows.*;
import divinerpg.items.vethea.*;
import divinerpg.util.*;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.*;

import java.util.ArrayList;
import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.ArmorMaterialRegistry.*;
import static divinerpg.registries.MobEffectRegistry.*;
import static divinerpg.util.ArmorInfo.*;
import static net.minecraft.world.effect.MobEffects.*;
import static net.minecraft.world.item.ArmorItem.Type.*;

public class ItemRegistry {
    public static final ArrayList<ItemLike> DISPENSER_ITEMS = new ArrayList<>();
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item>
        //Misc
        //Fuels
        anthracite = registerItem("anthracite"),
        collector = registerItem("collector", ItemCollector::new),

        //Raw
        raw_realmite = registerItem("raw_realmite"),
        raw_arlemite = registerItem("raw_arlemite"),
        raw_rupee = registerItem("raw_rupee"),
        raw_torridite = registerItem("raw_torridite"),
        raw_oxdrite = registerItem("raw_oxdrite"),

        //Powders
        purple_blaze = registerItem("purple_blaze"),
        fury_fire = registerItem("fury_fire"),
        eden_sparkles = registerItem("eden_sparkles"),

        //Dusts
        arlemite_dust = registerItem("arlemite_dust"),
        rupee_dust = registerItem("rupee_dust"),
        shadow_dust = registerItem("shadow_dust"),
        eden_dust = registerItem("eden_dust"),
        wildwood_dust = registerItem("wildwood_dust"),
        apalachia_dust = registerItem("apalachia_dust"),
        skythern_dust = registerItem("skythern_dust"),
        mortum_dust = registerItem("mortum_dust"),

        //Fragments
        collector_fragments = registerItem("collector_fragments"),
        eden_fragments = registerItem("eden_fragments"),
        wildwood_fragments = registerItem("wildwood_fragments"),
        apalachia_fragments = registerItem("apalachia_fragments"),
        skythern_fragments = registerItem("skythern_fragments"),
        mortum_fragments = registerItem("mortum_fragments"),
        rock_chunks = registerItemVethean("rock_chunks"),

        //Nuggets
        realmite_nugget = registerItem("realmite_nugget"),
        arlemite_nugget = registerItem("arlemite_nugget"),
        rupee_nugget = registerItem("rupee_nugget"),
        torridite_nugget = registerItem("torridite_nugget"),
        pieceOfRawArcanium = registerItem("piece_of_raw_arcanium"),

        //Ingots
        aquatic_pellets = registerItem("aquatic_pellets"),
        pure_aquatic_pellets = registerItem("pure_aquatic_pellets"),
        aquatic_ingot = registerItem("aquatic_ingot"),
        realmite_ingot = registerItem("realmite_ingot"),
        arlemite_ingot = registerItem("arlemite_ingot"),
        rupee_ingot = registerItem("rupee_ingot"),
        shadow_bar = registerItem("shadow_bar"),
        torridite_ingot = registerItem("torridite_ingot"),
        hellstone_ingot = registerItem("hellstone_ingot"),
        oxdrite_ingot = registerItem("oxdrite_ingot"),

        //Chunks
        bedrock_chunk = registerItem("bedrock_chunk", () -> new ItemMod(new Properties().fireResistant())),
        torridite_chunk = registerItem("torridite_chunk"),

        //Diamond Chunks
        red_diamond_chunk = registerItem("red_diamond_chunk"),
        yellow_diamond_chunk = registerItem("yellow_diamond_chunk"),
        green_diamond_chunk = registerItem("green_diamond_chunk"),
        blue_diamond_chunk = registerItem("blue_diamond_chunk"),
        gray_diamond_chunk = registerItem("gray_diamond_chunk"),

        //Shards
        ice_shards = registerItem("ice_shards"),
        terran_shards = registerItem("terran_shards"),
        jungle_shards = registerItem("jungle_shards"),
        molten_shards = registerItem("molten_shards", () -> new ItemMod(new Properties().fireResistant())),
        corrupted_shards = registerItem("corrupted_shards"),
        ender_shards = registerItem("ender_shards"),
        divine_shards = registerItem("divine_shards"),

        //Stones
        shadow_stone = registerItem("shadow_stone", () -> new ItemMod(new Properties().fireResistant())),
        ice_stone = registerItem("ice_stone"),
        terran_stone = registerItem("terran_stone"),
        jungle_stone = registerItem("jungle_stone"),
        molten_stone = registerItem("molten_stone", () -> new ItemMod(new Properties().fireResistant())),
        soulfire_stone = registerItem("soulfire_stone"),
        corrupted_stone = registerItem("corrupted_stone"),
        ender_stone = registerItem("ender_stone"),
        divine_stone = registerItem("divine_stone"),

        //Gems
        bloodgem = registerItem("bloodgem"),
        olivine = registerItem("olivine"),
        arcanium = registerItem("arcanium"),
        eden_gem = registerItem("eden_gem"),
        wildwood_gem = registerItem("wildwood_gem"),
        apalachia_gem = registerItem("apalachia_gem"),
        skythern_gem = registerItem("skythern_gem"),
        mortum_gem = registerItem("mortum_gem"),

        //Twilight Chunks
        eden_chunk = registerItem("eden_chunk"),
        wildwood_chunk = registerItem("wildwood_chunk"),
        apalachia_chunk = registerItem("apalachia_chunk"),
        skythern_chunk = registerItem("skythern_chunk"),
        mortum_chunk = registerItem("mortum_chunk"),

        //Lumps
        teaker_lump = registerItemVethean("teaker_lump"),
        amthirmis_lump = registerItemVethean("amthirmis_lump"),
        darven_lump = registerItemVethean("darven_lump"),
        cermile_lump = registerItemVethean("cermile_lump"),
        pardimal_lump = registerItemVethean("pardimal_lump"),
        quadrotic_lump = registerItemVethean("quadrotic_lump"),
        karos_lump = registerItemVethean("karos_lump"),
        heliosis_lump = registerItemVethean("heliosis_lump"),
        arksiane_lump = registerItemVethean("arksiane_lump"),

        //Currency
        shadow_coins = registerItem("shadow_coins"),
        snowflake = registerItem("snowflake"),
        dungeon_tokens = registerItem("dungeon_tokens"),
        dirty_pearls = registerItemVethean("dirty_pearls"),
        clean_pearls = registerItemVethean("clean_pearls"),
        polished_pearls = registerItemVethean("polished_pearls"),
        shiny_pearls = registerItemVethean("shiny_pearls"),

        //Eyes
        cyclops_eye_shards = registerItem("cyclops_eye_shards"),
        cyclops_eye = registerItem("cyclops_eye"),
        watching_eye = registerItem("watching_eye"),
        legendary_ender_eye = registerItem("legendary_ender_eye"),

        //Other Mobs Drop
        crab_claw = registerItem("crab_claw"),
        shark_fin = registerItem("shark_fin"),
        whale_fin = registerItem("whale_fin"),
        liopleurodon_teeth = registerItem("liopleurodon_teeth"),
        liopleurodon_skull = registerItem("liopleurodon_skull"),
        aqua_ball = registerItem("aqua_ball"),
        aquatic_blaze_rod = registerItem("aquatic_blaze_rod"),
        kraken_scale = registerItem("kraken_scale"),
        kraken_skin = registerItem("kraken_skin"),
        seng_fur = registerItem("seng_fur"),
        sabear_fur = registerItem("sabear_fur"),
        sabear_tooth = registerItem("sabear_tooth"),
        blubber = registerItem("blubber"),
        acid = registerItemVethean("acid"),

        //Non-edible Crops
        firestock = registerItem("firestock", ItemFireStock::new),
        marsine = registerItem("marsine"),

        //Souls
        eden_soul = registerItem("eden_soul"),
        wildwood_soul = registerItem("wildwood_soul"),
        apalachia_soul = registerItem("apalachia_soul"),
        skythern_soul = registerItem("skythern_soul"),
        mortum_soul = registerItem("mortum_soul"),

        //Hearts
        eden_heart = registerItem("eden_heart"),
        wildwood_heart = registerItem("wildwood_heart"),
        apalachia_heart = registerItem("apalachia_heart"),
        skythern_heart = registerItem("skythern_heart"),
        mortum_heart = registerItem("mortum_heart"),

        base_spawn_crystal = registerItem("base_spawn_crystal"),

        //Smithing Templates
        bedrock_upgrade_template = registerItem("bedrock_upgrade_template", ItemSmithingTemplate::createBedrockUpgrade),
        aquatic_coating_template = registerItem("aquatic_coating_template", ItemSmithingTemplate::createAquaticCoating),
        color_template = registerItem("color_template", ItemSmithingTemplate::createColorTemplate),

        //Infusion Templates
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

        //Food
        bacon = registerItem("bacon", () -> new ItemModFood(FoodList.BACON)),
        boiled_egg = registerItem("boiled_egg", () -> new ItemModFood(FoodList.BOILED_EGG)),
        cheese = registerItem("cheese", () -> new ItemModFood(FoodList.CHEESE)),
        donut = registerItem("donut", () -> new ItemModFood(FoodList.DONUT)),
        hot_pumpkin_pie = registerItem("hot_pumpkin_pie", () -> new ItemModFood(FoodList.HOT_PUMPKIN_PIE)),
        tomato = registerThrowableItem("tomato", ItemTomato::new),
        white_mushroom = registerItem("white_mushroom", () -> new ItemModFood(FoodList.WHITE_MUSHROOM)),
        advanced_mushroom_stew = registerItem("advanced_mushroom_stew", () -> new ItemModFood(new Properties().food(FoodList.ADVANCED_MUSHROOM_STEW).stacksTo(1))),
        chicken_dinner = registerItem("chicken_dinner", () -> new ItemModFood(new Properties().food(FoodList.CHICKEN_DINNER).stacksTo(1))),
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
        lamona = registerItem("lamona", () -> new ItemModFood(FoodList.LAMONA)),
        pinfly = registerItem("pinfly", () -> new ItemModFoodEffect(FoodList.PINFLY)),
        veilo = registerItem("veilo", () -> new ItemModFoodEffect(FoodList.VEILO)),
        raw_empowered_meat = registerItem("raw_empowered_meat", () -> new ItemModFood(FoodList.RAW_EMPOWERED_MEAT)),
        empowered_meat = registerItem("empowered_meat", () -> new ItemModFood(FoodList.EMPOWERED_MEAT)),
        magic_meat = registerItem("magic_meat", () -> new ItemModFood(FoodList.MAGIC_MEAT, true)),
        enriched_magic_meat = registerItem("enriched_magic_meat", () -> new ItemModFood(FoodList.ENRICHED_MAGIC_MEAT, true)),
        forbidden_fruit = registerItem("forbidden_fruit", () -> new ItemModFood(FoodList.FORBIDDEN_FRUIT)),
        moonbulb = registerItem("moonbulb", () -> new ItemModFood(FoodList.MOONBULB, true)),
        purple_glowbone = registerItem("purple_glowbone", () -> new ItemModFood(FoodList.PURPLE_GLOWBONE, true)),
        pink_glowbone = registerItem("pink_glowbone", () -> new ItemModFood(FoodList.PINK_GLOWBONE, true)),
        sky_flower = registerItem("sky_flower", () -> new ItemModFoodEffect(FoodList.SKY_FLOWER, true)),
        honeysuckle = registerItemVethean("honeysuckle", () -> new ItemModFood(FoodList.HONEYSUCKLE)),
        honeychunk = registerItemVethean("honeychunk", () -> new ItemModFood(FoodList.HONEYCHUNK)),
        dream_carrot = registerItemVethean("dream_carrot", () -> new ItemModFood(FoodList.DREAM_CARROT)),
        dream_melon = registerItemVethean("dream_melon", () -> new ItemModFood(FoodList.DREAM_MELON)),
        dream_pie = registerItemVethean("dream_pie", () -> new ItemModFood(FoodList.DREAM_PIE)),
        dream_cake = registerItemVethean("dream_cake", () -> new ItemModFood(FoodList.DREAM_CAKE)),
        dream_sweets = registerItemVethean("dream_sweets", () -> new ItemHealingFood(FoodList.DREAM_SWEETS)),
        dream_sours = registerItemVethean("dream_sours", () -> new ItemHealingFood(FoodList.DREAM_SOURS)),

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

        //Pets
        snapper_egg = registerItem("snapper_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SNAPPER.get())),
        ehu_egg = registerItem("ehu_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.EHU.get())),
        husk_egg = registerItem("husk_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.HUSK.get())),
        brown_grizzle_egg = registerItem("brown_grizzle_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.BROWN_GRIZZLE.get())),
        white_grizzle_egg = registerItem("white_grizzle_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.WHITE_GRIZZLE.get())),
        stone_golem_egg = registerItem("stone_golem_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.STONE_GOLEM.get())),
        smelter_egg = registerItem("smelter_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SMELTER.get())),
        fyracryx_egg = registerItem("fyracryx_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.FYRACRYX.get())),
        golem_of_rejuvenation_egg = registerItem("golem_of_rejuvenation_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.GOLEM_OF_REJUVENATION.get())),
        paratiku_egg = registerItem("paratiku_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.PARATIKU.get())),
        seimer_egg = registerItem("seimer_spawn_egg", () -> new ItemPetSpawnEgg(EntityRegistry.SEIMER.get())),

    //Tools, Weapons & Armor
        //Extra Arcana Tools
        divine_accumulator = registerTool("divine_accumulator", ItemDivineAccumulator::new),
        ender_scepter = registerTool("ender_scepter", ItemEnderScepter::new),
        ghostbane = registerTool("ghostbane", ItemGhostbane::new),
        staff_of_enrichment = registerTool("staff_of_enrichment", ItemStaffEnrichment::new),
        arcanium_attractor = registerTool("arcanium_attractor", () -> new ItemRangedWeapon(EntityRegistry.ATTRACTOR_BEAM::value).withTooltip(LocalizeUtils.pull()).withSound(SoundRegistry.REFLECTOR.get()).arcanaUse(20).withPower(6)),
        arcanium_reflector = registerTool("arcanium_reflector", () -> new ItemRangedWeapon(EntityRegistry.REFLECTOR_BEAM::value).withTooltip(LocalizeUtils.push()).withSound(SoundRegistry.REFLECTOR.get()).arcanaUse(20).withPower(6)),

        //Buckets
        aquamarine = registerTool("aquamarine", ItemAquamarine::new),
        cauldron_fish_bucket = registerTool("cauldron_fish_bucket", () -> new MobBucketItem(EntityRegistry.CAULDRON_FISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, new Properties().stacksTo(1))),
        gem_fin_bucket = registerTool("gem_fin_bucket", () -> new MobBucketItem(EntityRegistry.GEM_FIN.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Properties()).stacksTo(1))),
        smoldering_tar_bucket = registerTool("smoldering_tar_bucket", () -> new BucketItem(FluidRegistry.SMOLDERING_TAR_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1))),

        //minecarts
        inserter_minecart = registerTool("inserter_minecart", ItemInserterMinecart::new),

        //Igniters
        snow_globe = registerTool("snow_globe", ItemSnowGlobe::new),
        frozen_clock = registerTool("frozen_clock", ItemFrozenClock::new),

        //Boss Summons
        mysterious_clock = registerTool("mysterious_clock", () -> new ItemBossSpawner("item.overworld_only", Level.OVERWORLD, EntityRegistry.ANCIENT_ENTITY::get)),
        call_of_the_watcher = registerTool("call_of_the_watcher", () -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.THE_WATCHER::get)),
        infernal_flame = registerTool("infernal_flame", () -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityRegistry.KING_OF_SCORCHERS::get)),
        horde_horn = registerTool("horde_horn", ItemHordeHorn::new),
        wizards_book = registerTool("wizards_book", ItemWizardsBook::new),
        vamacheron_crystal = registerTool("vamacheron_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.VAMACHERON::get)),
        karot_crystal = registerTool("karot_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.KAROT::get)),
        twilight_demon_crystal = registerTool("twilight_demon_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.TWILIGHT_DEMON::get)),
        densos_crystal = registerTool("densos_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.DENSOS::get)),
        reyvor_crystal = registerTool("reyvor_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.REYVOR::get)),
        soul_fiend_crystal = registerTool("soul_fiend_crystal", () -> new ItemBossSpawner("item.mortum_only", LevelRegistry.MORTUM, EntityRegistry.SOUL_FIEND::get)),
        dream_flint = registerTool("dream_flint", ItemDreamFlint::new),
        moon_clock = registerTool("moon_clock", () -> new ItemVethean(new Properties().stacksTo(1))),

        //Extra
        jungle_hook = registerTool("jungle_hook", ItemJungleHook::new),
        teleportation_crystal = registerTool("teleportation_crystal", ItemTeleportationCrystal::new),
        teleportation_star = registerTool("teleportation_star", ItemTeleportationStar::new),
        orb_of_light = registerTool("orb_of_light"),
        weak_arcana_potion = registerTool("weak_arcana_potion", () -> new ItemArcanaPotion(FoodList.WEAK_ARCANA_POTION, 100)),
        strong_arcana_potion = registerTool("strong_arcana_potion", () -> new ItemArcanaPotion(FoodList.STRONG_ARCANA_POTION, 200)),
        heat_pack = registerTool("heat_pack", ItemHeatPack::new),
        glacial_wall_totem = registerTool("glacial_wall_totem", () -> new ItemMod(new Properties().stacksTo(1))),
        miners_amulet = registerTool("miners_amulet", ItemMinersAmulet::new),
        band_of_lheiva_hunting = registerTool("band_of_lheiva_hunting", () -> new ItemVethean(new Properties().stacksTo(1))),

        //Music Discs
        md_red_stains = registerTool("md_red_stains_on_the_bluest_snow", () -> new ItemMod(new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SoundRegistry.MD_RED_STAINS_SONG.getKey()))),
        md_destiny = registerTool("md_destiny", () -> new ItemMod(new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SoundRegistry.MD_DESTINY_SONG.getKey()))),

        //Keys
        ancient_key = registerTool("ancient_key"),
        degraded_key = registerTool("degraded_key"),
        sludge_key = registerTool("sludge_key"),
        soul_key = registerTool("soul_key"),

        //Armor Pouches
        armor_pouch = registerTool("armor_pouch", () -> new ItemArmorPouch(16777215)),
        red_armor_pouch = registerTool("red_armor_pouch", () -> new ItemArmorPouch(16733525)),
        yellow_armor_pouch = registerTool("yellow_armor_pouch", () -> new ItemArmorPouch(16777045)),
        green_armor_pouch = registerTool("green_armor_pouch", () -> new ItemArmorPouch(5635925)),
        blue_armor_pouch = registerTool("blue_armor_pouch", () -> new ItemArmorPouch(5592575)),
        gray_armor_pouch = registerTool("gray_armor_pouch", () -> new ItemArmorPouch(11184810)),

        //Healing
        healing_stone = registerTool("healing_stone", ItemHealingStone::new),
        palavence = registerTool("palavence", () -> new ItemHealingSword(ToolStats.PALAVENCE, .5F)),
        massivence = registerTool("massivence", () -> new ItemHealingSword(ToolStats.MASSIVENCE, 1)),
        frossivence = registerTool("frossivence", () -> new ItemHealingSword(ToolStats.FROSSIVENCE, 1)),

        //Swords
        cyclopsian_sword = registerTool("cyclopsian_sword", () -> new ItemModSword(ToolStats.CYCLOPSIAN_SWORD)),
        slime_sword = registerTool("slime_sword", () -> new ItemModSword(ToolStats.SLIME_SWORD)),
        glacier_sword = registerTool("glacier_sword", () -> new ItemModSword(ToolStats.GLACIER_SWORD)),
        crabclaw_maul = registerTool("crabclaw_maul", () -> new ItemMaul(ToolStats.CRABCLAW_MAUL)),
        dual_claw = registerTool("dual_claw", () -> new ItemModSword(ToolStats.DUAL_CLAW)),
        shark_sword = registerTool("shark_sword", () -> new ItemModSword(ToolStats.SHARK_SWORD)),
        aquatooth_sword = registerTool("aquatooth_sword", () -> new ItemModSword(ToolStats.AQUATOOTH_SWORD)),
        aquatooth_maul = registerTool("aquatooth_maul", () -> new ItemMaul(ToolStats.AQUATOOTH_MAUL)),
        aquatic_dagger = registerTool("aquatic_dagger", () -> new ItemModSword(ToolStats.AQUA_DAGGER)),
        ocean_knife = registerTool("ocean_knife", () -> new ItemModSword(ToolStats.OCEAN_KNIFE)),
        aquatic_trident = registerTool("aquatic_trident", () -> new ItemModSword(ToolStats.AQUA_TRIDENT)),
        aquaton = registerTool("aquaton", () -> new ItemModSword(ToolStats.AQUATON)),
        aquatic_maul = registerTool("aquatic_maul", () -> new ItemMaul(ToolStats.AQUA_MAUL)),
        realmite_sword = registerTool("realmite_sword", () -> new ItemModSword(ToolStats.REALMITE_SWORD)),
        realmite_maul = registerTool("realmite_maul", () -> new ItemMaul(ToolStats.REALMITE_MAUL)),
        arlemite_stabber = registerTool("arlemite_stabber", () -> new ItemModSword(ToolStats.ARLEMITE_STABBER)),
        rupee_rapier = registerTool("rupee_rapier", () -> new ItemModSword(ToolStats.RUPEE_RAPIER)),
        bedrock_sword = registerTool("bedrock_sword", () -> new ItemModSword(ToolStats.BEDROCK_SWORD, new Properties().fireResistant())),
        bedrock_maul = registerTool("bedrock_maul", () -> new ItemMaul(ToolStats.BEDROCK_MAUL, new Properties().fireResistant())),
        frozen_maul = registerTool("frozen_maul", () -> new ItemMaul(ToolStats.FROZEN_MAUL)),
        fury_maul = registerTool("fury_maul", () -> new ItemMaul(ToolStats.FURY_MAUL)),
        death_bringer = registerTool("death_bringer", () -> new ItemModSword(ToolStats.DEATH_BRINGER)),
        corrupted_maul = registerTool("corrupted_maul", () -> new ItemMaul(ToolStats.CORRUPTED_MAUL)),
        terran_dagger = registerTool("terran_dagger", () -> new ItemModSword(ToolStats.TERRAN_DAGGER)),
        terran_knife = registerTool("terran_knife", () -> new ItemModSword(ToolStats.TERRAN_KNIFE)),
        terran_maul = registerTool("terran_maul", () -> new ItemMaul(ToolStats.TERRAN_MAUL)),
        jungle_knife = registerTool("jungle_knife", () -> new ItemModSword(ToolStats.JUNGLE_KNIFE)),
        jungle_rapier = registerTool("jungle_rapier", () -> new ItemModSword(ToolStats.JUNGLE_RAPIER)),
        poison_saber = registerTool("poison_saber", () -> new ItemModSword(ToolStats.POISON_SABER)),
        bloodgem_sword = registerTool("bloodgem_sword", () -> new ItemModSword(ToolStats.BLOODGEM_SWORD)),
        molten_sword = registerTool("molten_sword", () -> new ItemModSword(ToolStats.MOLTEN_SWORD, new Properties().fireResistant())),
        scorching_sword = registerTool("scorching_sword", () -> new ItemModSword(ToolStats.SCORCHING_SWORD)),
        soulfire_sword = registerTool("soulfire_sword", () -> new ItemModSword(ToolStats.SOULFIRE_SWORD)),
        inferno_sword = registerTool("inferno_sword", () -> new ItemModSword(ToolStats.INFERNO_SWORD, new Properties().fireResistant())),
        flaming_fury = registerTool("flaming_fury", () -> new ItemModSword(ToolStats.FLAMING_FURY, new Properties().fireResistant())),
        sabear_sabre = registerTool("sabear_sabre", () -> new ItemModSword(ToolStats.SABEAR_SABRE)),
        frost_sword = registerTool("frost_sword", () -> new ItemModSword(ToolStats.FROST_SWORD)),
        frostking_sword = registerTool("frostking_sword", () -> new ItemModSword(ToolStats.FROSTKING_SWORD)),
        icicle_bane = registerTool("icicle_bane", () -> new ItemModSword(ToolStats.ICICLE_BANE, RarityList.ICICLE)),
        glacial_blade = registerTool("glacial_blade", () -> new ItemModSword(ToolStats.GLACIAL_BLADE, RarityList.ICICLE)),
        icicle_dagger = registerTool("icicle_dagger", () -> new ItemModSword(ToolStats.ICICLE_DAGGER, RarityList.ICICLE)),
        ender_sword = registerTool("ender_sword", () -> new ItemModSword(ToolStats.ENDER_SWORD, RarityList.ENDER)),
        red_ender_sword = registerTool("red_ender_sword", () -> new ItemModSword(ToolStats.ENDER_SWORD, RarityList.RED)),
        yellow_ender_sword = registerTool("yellow_ender_sword", () -> new ItemModSword(ToolStats.ENDER_SWORD, RarityList.UNCOMMON)),
        green_ender_sword = registerTool("green_ender_sword", () -> new ItemModSword(ToolStats.ENDER_SWORD, RarityList.GREEN)),
        blue_ender_sword = registerTool("blue_ender_sword", () -> new ItemModSword(ToolStats.ENDER_SWORD, RarityList.BLUE)),
        black_ender_sword = registerTool("black_ender_sword", () -> new ItemModSword(ToolStats.ENDER_SWORD, RarityList.DARK_GRAY)),
        enderice = registerTool("enderice", () -> new ItemModSword(ToolStats.ENDERICE)),
        divine_sword = registerTool("divine_sword", () -> new ItemModSword(ToolStats.DIVINE_SWORD, RarityList.DIVINE)),
        red_divine_sword = registerTool("red_divine_sword", () -> new ItemModSword(ToolStats.DIVINE_SWORD, RarityList.RED)),
        yellow_divine_sword = registerTool("yellow_divine_sword", () -> new ItemModSword(ToolStats.DIVINE_SWORD, RarityList.UNCOMMON)),
        green_divine_sword = registerTool("green_divine_sword", () -> new ItemModSword(ToolStats.DIVINE_SWORD, RarityList.GREEN)),
        blue_divine_sword = registerTool("blue_divine_sword", () -> new ItemModSword(ToolStats.DIVINE_SWORD, RarityList.BLUE)),
        gray_divine_sword = registerTool("gray_divine_sword", () -> new ItemModSword(ToolStats.DIVINE_SWORD, RarityList.GRAY)),
        icine_sword = registerTool("icine_sword", () -> new ItemModSword(ToolStats.ICINE_SWORD)),
        sandslash = registerTool("sandslash", () -> new ItemModSword(ToolStats.SANDSLASH)),
        snowslash = registerTool("snowslash", () -> new ItemModSword(ToolStats.SNOWSLASH)),
        storm_sword = registerTool("storm_sword", ItemStormSword::new),
        shadow_saber = registerTool("shadow_saber", ItemShadowSaber::new),
        arcanium_saber = registerTool("arcanium_saber", () -> new ItemModSword(ToolStats.ARCANIUM_SABER).setAttackArcanaConsumption(25)),
        arcanite_blade = registerTool("arcanite_blade", () -> new ItemModSword(ToolStats.ARCANITE_BLADE).setAttackArcanaConsumption(30)),
        livicia_sword = registerTool("livicia_sword", () -> new ItemModSword(ToolStats.LIVICIA_SWORD)),
        eden_blade = registerTool("eden_blade", () -> new ItemModSword(ToolStats.EDEN_BLADE, RarityList.EDEN)),
        wildwood_blade = registerTool("wildwood_blade", () -> new ItemModSword(ToolStats.WILDWOOD_BLADE, RarityList.WILDWOOD)),
        apalachia_blade = registerTool("apalachia_blade", () -> new ItemModSword(ToolStats.APALACHIA_BLADE, RarityList.APALACHIA)),
        skythern_blade = registerTool("skythern_blade", () -> new ItemModSword(ToolStats.SKYTHERN_BLADE, RarityList.SKYTHERN)),
        mortum_blade = registerTool("mortum_blade", () -> new ItemModSword(ToolStats.MORTUM_BLADE, RarityList.MORTUM)),
        halite_blade = registerTool("halite_blade", () -> new ItemModSword(ToolStats.HALITE_BLADE, RarityList.HALITE)),

        //Vethean Swords
        teaker_backsword = registerTool("teaker_backsword", () -> new ItemModSword(ToolStats.TEAKER_BACKSWORD)),
        amthirmis_backsword = registerTool("amthirmis_backsword", () -> new ItemModSword(ToolStats.AMTHIRMIS_BACKSWORD)),
        darven_backsword = registerTool("darven_backsword", () -> new ItemModSword(ToolStats.DARVEN_BACKSWORD)),
        cermile_backsword = registerTool("cermile_backsword", () -> new ItemModSword(ToolStats.CERMILE_BACKSWORD)),
        pardimal_backsword = registerTool("pardimal_backsword", () -> new ItemModSword(ToolStats.PARDIMAL_BACKSWORD)),
        quadrotic_backsword = registerTool("quadrotic_backsword", () -> new ItemModSword(ToolStats.QUADROTIC_BACKSWORD)),
        karos_backsword = registerTool("karos_backsword", () -> new ItemModSword(ToolStats.KAROS_BACKSWORD)),
        heliosis_backsword = registerTool("heliosis_backsword", () -> new ItemModSword(ToolStats.HELIOSIS_BACKSWORD)),
        arksiane_backsword = registerTool("arksiane_backsword", () -> new ItemModSword(ToolStats.ARKSIANE_BACKSWORD)),

        //Hammers
        teaker_hammer = registerTool("teaker_hammer", () -> new ItemModSword(ToolStats.TEAKER_HAMMER)),
        amthirmis_hammer = registerTool("amthirmis_hammer", () -> new ItemModSword(ToolStats.AMTHIRMIS_HAMMER)),
        darven_hammer = registerTool("darven_hammer", () -> new ItemModSword(ToolStats.DARVEN_HAMMER)),
        cermile_hammer = registerTool("cermile_hammer", () -> new ItemModSword(ToolStats.CERMILE_HAMMER)),
        pardimal_hammer = registerTool("pardimal_hammer", () -> new ItemModSword(ToolStats.PARDIMAL_HAMMER)),
        quadrotic_hammer = registerTool("quadrotic_hammer", () -> new ItemModSword(ToolStats.QUADROTIC_HAMMER)),
        karos_hammer = registerTool("karos_hammer", () -> new ItemModSword(ToolStats.KAROS_HAMMER)),
        heliosis_hammer = registerTool("heliosis_hammer", () -> new ItemModSword(ToolStats.HELIOSIS_HAMMER)),
        arksiane_hammer = registerTool("arksiane_hammer", () -> new ItemModSword(ToolStats.ARKSIANE_HAMMER)),
        everlight = registerTool("everlight", () -> new ItemModSword(ToolStats.EVERLIGHT)),
        karos_rockmaul = registerTool("karos_rockmaul", () -> new ItemModSword(ToolStats.KAROS_ROCKMAUL)),

        //Claws
        teaker_claw = registerTool("teaker_claw", () -> new ItemModSword(ToolStats.TEAKER_CLAW)),
        amthirmis_claw = registerTool("amthirmis_claw", () -> new ItemModSword(ToolStats.AMTHIRMIS_CLAW)),
        darven_claw = registerTool("darven_claw", () -> new ItemModSword(ToolStats.DARVEN_CLAW)),
        cermile_claw = registerTool("cermile_claw", () -> new ItemModSword(ToolStats.CERMILE_CLAW)),
        pardimal_claw = registerTool("pardimal_claw", () -> new ItemModSword(ToolStats.PARDIMAL_CLAW)),
        quadrotic_claw = registerTool("quadrotic_claw", () -> new ItemModSword(ToolStats.QUADROTIC_CLAW)),
        karos_claw = registerTool("karos_claw", () -> new ItemModSword(ToolStats.KAROS_CLAW)),
        heliosis_claw = registerTool("heliosis_claw", () -> new ItemModSword(ToolStats.HELIOSIS_CLAW)),
        arksiane_claw = registerTool("arksiane_claw", () -> new ItemModSword(ToolStats.ARKSIANE_CLAW)),
        everbright = registerTool("everbright", () -> new ItemModSword(ToolStats.EVERBRIGHT)),

        //Shields
        realmite_shield = registerTool("realmite_shield", () -> new ItemDivineShield(realmite_ingot.get(), 426, "realmite_shield")),
        arlemite_shield = registerTool("arlemite_shield", () -> new ItemDivineShield(arlemite_ingot.get(), 734, "arlemite_shield")),
        rupee_shield = registerTool("rupee_shield", () -> new ItemDivineShield(rupee_ingot.get(), 823, "rupee_shield")),
        eden_shield = registerTool("eden_shield", () -> new ItemDivineShield(RarityList.EDEN, eden_gem.get(), 978, "eden_shield")),
        wildwood_shield = registerTool("wildwood_shield", () -> new ItemDivineShield(RarityList.WILDWOOD, wildwood_gem.get(), 1125, "wildwood_shield")),
        apalachia_shield = registerTool("apalachia_shield", () -> new ItemDivineShield(RarityList.APALACHIA, apalachia_gem.get(), 1256, "apalachia_shield")),
        skythern_shield = registerTool("skythern_shield", () -> new ItemDivineShield(RarityList.SKYTHERN, skythern_gem.get(), 1485, "skythern_shield")),
        mortum_shield = registerTool("mortum_shield", () -> new ItemDivineShield(RarityList.MORTUM, mortum_gem.get(), 1627, "mortum_shield")),
        halite_shield = registerTool("halite_shield", () -> new ItemDivineShield(RarityList.HALITE, Items.AIR, 0, "halite_shield")),

        //Serenades
        serenade_striker = registerTool("serenade_striker", ItemSerenadeStriker::new),
        serenade_of_ice = registerTool("serenade_of_ice", () -> new ItemRangedWeapon(EntityRegistry.ICE_BULLET::value, 100).withTooltip(LocalizeUtils.slow(5)).withSound(SoundRegistry.SERENADE.get())),
        serenade_of_death = registerTool("serenade_of_death", () -> new ItemRangedWeapon(EntityRegistry.DEATH_BULLET::value, 857).withTooltip(LocalizeUtils.magicDam(7)).withTooltip(LocalizeUtils.poison(2)).withSound(SoundRegistry.SERENADE.get())),
        serenade_of_health = registerTool("serenade_of_health", ItemSerenadeOfHealth::new),
        serenade_of_infusion = registerTool("serenade_of_infusion", ItemSerenadeOfInfusion::new),

        //Arrows
        hunter_arrow = registerThrowableTool("hunter_arrow", HunterArrowItem::new),
        shadow_arrow = registerThrowableTool("shadow_arrow", ShadowArrowItem::new),
        icicle_arrow = registerThrowableTool("icicle_arrow", IcicleArrowItem::new),
        inferno_arrow = registerThrowableTool("inferno_arrow", InfernoArrowItem::new),
        soulfire_arrow = registerThrowableTool("soulfire_arrow", SoulfireArrowItem::new),
        snowstorm_arrow = registerThrowableTool("snowstorm_arrow", SnowstormArrowItem::new),
        ender_arrow = registerThrowableTool("ender_arrow", EnderArrowItem::new),
        eden_arrow = registerThrowableTool("eden_arrow", EdenArrowItem::new),
        wildwood_arrow = registerThrowableTool("wildwood_arrow", WildwoodArrowItem::new),
        fury_arrow = registerThrowableTool("fury_arrow", FuryArrowItem::new),

        //Vethean Arrows
        teaker_arrow = registerThrowableTool("teaker_arrow", TeakerArrowItem::new),
        darven_arrow = registerThrowableTool("darven_arrow", DarvenArrowItem::new),
        pardimal_arrow = registerThrowableTool("pardimal_arrow", PardimalArrowItem::new),
        karos_arrow = registerThrowableTool("karos_arrow", KarosArrowItem::new),
        ever_arrow = registerThrowableTool("ever_arrow", EverArrowItem::new),

        //Bows
        hunter_bow = registerTool("hunter_bow", HunterBow::new),
        shadow_bow = registerTool("shadow_bow", ShadowBow::new),
        icicle_bow = registerTool("icicle_bow", IcicleBow::new),
        inferno_bow = registerTool("inferno_bow", InfernoBow::new),
        soulfire_bow = registerTool("soulfire_bow", () -> new ItemBow(new Properties(), 0, 72000, 1.5F, soulfire_arrow, RarityList.BLUE)),
        snowstorm_bow = registerTool("snowstorm_bow", () -> new ItemBow(new Properties(), 0, 72000, 1.7F, snowstorm_arrow, null)),
        ender_bow = registerTool("ender_bow", EnderBow::new),
        eden_bow = registerTool("eden_bow", () -> new ItemBow(new Properties(), 1517, 72000, 1.3F, null, RarityList.EDEN)),
        wildwood_bow = registerTool("wildwood_bow", () -> new ItemBow(new Properties(), 1624, 36000, 1.4F, null, RarityList.WILDWOOD)),
        apalachia_bow = registerTool("apalachia_bow", () -> new ItemBow(new Properties(), 1778, 72000, 1.5F, null, RarityList.APALACHIA)),
        skythern_bow = registerTool("skythern_bow", () -> new ItemBow(new Properties(), 1879, 36000, 1.6F, null, RarityList.SKYTHERN)),
        mortum_bow = registerTool("mortum_bow", () -> new ItemBow(new Properties(), 1990, 72000, 1.7F, null, RarityList.MORTUM)),
        halite_bow = registerTool("halite_bow", () -> new ItemBow(new Properties(), 2114, 36000, 1.8F, null, RarityList.HALITE)),
        twilight_bow = registerTool("twilight_bow", () -> new ItemBow(new Properties(), 2376, 14400, 1.9F, null, RarityList.TWILIGHT)),

        //Vethean Bows
        teaker_bow = registerTool("teaker_bow", () -> new VetheanBow(new Properties(), 0, 72000, .9F, null, RarityList.TEAKER)),
        amthirmis_bow = registerTool("amthirmis_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1, null, RarityList.AMTHIRMIS)),
        darven_bow = registerTool("darven_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.1F, null, RarityList.DARVEN)),
        cermile_bow = registerTool("cermile_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.2F, null, RarityList.CERMILE)),
        pardimal_bow = registerTool("pardimal_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.3F, null, RarityList.PARDIMAL)),
        quadrotic_bow = registerTool("quadrotic_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.4F, null, RarityList.QUADROTIC)),
        karos_bow = registerTool("karos_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.5F, null, RarityList.KAROS)),
        heliosis_bow = registerTool("heliosis_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.6F, null, RarityList.HELIOSIS)),
        arksiane_bow = registerTool("arksiane_bow", () -> new VetheanBow(new Properties(), 0, 72000, 1.7F, null, RarityList.ARKSIANE)),
        everfright = registerTool("everfright", () -> new VetheanBow(new Properties(), 0, 72000, 1.8F, null, RarityList.EVER)),

        //Anchors
        crab_anchor = registerTool("crab_anchor", () -> new ItemAnchor(ToolStats.CRAB_ANCHOR, EntityRegistry.CRAB_ANCHOR_SHOT::value, 3)),
        shark_anchor = registerTool("shark_anchor", () -> new ItemAnchor(ToolStats.SHARK_ANCHOR, EntityRegistry.SHARK_ANCHOR_SHOT::value, 4)),
        bowhead_anchor = registerTool("bowhead_anchor", () -> new ItemAnchor(ToolStats.BOWHEAD_ANCHOR, EntityRegistry.BOWHEAD_ANCHOR_SHOT::value, 5)),
        liopleurodon_anchor = registerTool("liopleurodon_anchor", () -> new ItemAnchor(ToolStats.LIOPLEURODON_ANCHOR, EntityRegistry.LIOPLEURODON_ANCHOR_SHOT::value, 6)),

        //Harps
        sound_of_music = registerTool("sound_of_music", () -> new ItemRangedWeapon(EntityRegistry.SOUND_OF_MUSIC::value, 666).withTooltip(LocalizeUtils.magicDam(9)).withSound(SoundRegistry.SOUND_OF_MUSIC.get()).withCooldown(20)),
        sound_of_carols = registerTool("sound_of_carols", () -> new ItemRangedWeapon(EntityRegistry.SOUND_OF_CAROLS::value, 1025).withTooltip(LocalizeUtils.magicDam(11)).withSound(SoundRegistry.SOUND_OF_CAROLS.get()).withCooldown(20)),//1592
        sound_of_whales = registerTool("sound_of_whales", () -> new ItemRangedWeapon(EntityRegistry.SOUND_OF_WHALES::value, 1025).withTooltip(LocalizeUtils.magicDam(13)).withSound(SoundRegistry.WHALE.get()).withCooldown(20)),

        //Shurikens
        shuriken = registerThrowableTool("shuriken", () -> new ItemThrowable(2)),
        snowflake_shuriken = registerThrowableTool("snowflake_shuriken", () -> new ItemThrowable(EntityRegistry.SNOWFLAKE_SHURIKEN::value, 3.5F).withTooltip(LocalizeUtils.slow(2))),
        vile_storm = registerThrowableTool("vile_storm", () -> new ItemThrowable(EntityRegistry.VILE_STORM::value, 3.5F).withTooltip(LocalizeUtils.poison(2))),

        //Slicers
        eden_slicer = registerThrowableTool("eden_slicer", () -> new ItemThrowable(4).nameColor(RarityList.EDEN)),
        wildwood_slicer = registerThrowableTool("wildwood_slicer", () -> new ItemThrowable(5).nameColor(RarityList.WILDWOOD)),
        apalachia_slicer = registerThrowableTool("apalachia_slicer", () -> new ItemThrowable(6).nameColor(RarityList.APALACHIA)),
        skythern_slicer = registerThrowableTool("skythern_slicer", () -> new ItemThrowable(7).nameColor(RarityList.SKYTHERN)),
        mortum_slicer = registerThrowableTool("mortum_slicer", () -> new ItemThrowable(8).nameColor(RarityList.MORTUM)),
        halite_slicer = registerThrowableTool("halite_slicer", () -> new ItemThrowable(9).nameColor(RarityList.HALITE)),

        //Vethean Disks
        teaker_disk = registerThrowableTool("teaker_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 2).withTooltip(LocalizeUtils.returnsToSender())),
        amthirmis_disk = registerThrowableTool("amthirmis_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 3).withTooltip(LocalizeUtils.returnsToSender())),
        darven_disk = registerThrowableTool("darven_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 4.5F).withTooltip(LocalizeUtils.returnsToSender())),
        cermile_disk = registerThrowableTool("cermile_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 6.5F).withTooltip(LocalizeUtils.returnsToSender())),
        pardimal_disk = registerThrowableTool("pardimal_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 8).withTooltip(LocalizeUtils.returnsToSender())),
        quadrotic_disk = registerThrowableTool("quadrotic_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 10).withTooltip(LocalizeUtils.returnsToSender())),
        karos_disk = registerThrowableTool("karos_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 11).withTooltip(LocalizeUtils.returnsToSender())),
        heliosis_disk = registerThrowableTool("heliosis_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 14.5F).withTooltip(LocalizeUtils.returnsToSender())),
        arksiane_disk = registerThrowableTool("arksiane_disk", () -> new ItemThrowable(new Properties().stacksTo(1), EntityRegistry.DISK::value, 18.5F).withTooltip(LocalizeUtils.returnsToSender())),

        //Vethean Dissipators
        teaker_dissipator = registerThrowableTool("teaker_dissipator", () -> new ItemVetheanDissipator(2).withTooltip(LocalizeUtils.returnsToSender())),
        amthirmis_dissipator = registerThrowableTool("amthirmis_dissipator", () -> new ItemVetheanDissipator(3).withTooltip(LocalizeUtils.returnsToSender())),
        darven_dissipator = registerThrowableTool("darven_dissipator", () -> new ItemVetheanDissipator(4.5F).withTooltip(LocalizeUtils.returnsToSender())),
        cermile_dissipator = registerThrowableTool("cermile_dissipator", () -> new ItemVetheanDissipator(6.5F).withTooltip(LocalizeUtils.returnsToSender())),
        pardimal_dissipator = registerThrowableTool("pardimal_dissipator", () -> new ItemVetheanDissipator(8).withTooltip(LocalizeUtils.returnsToSender())),
        quadrotic_dissipator = registerThrowableTool("quadrotic_dissipator", () -> new ItemVetheanDissipator(10).withTooltip(LocalizeUtils.returnsToSender())),
        karos_dissipator = registerThrowableTool("karos_dissipator", () -> new ItemVetheanDissipator(11).withTooltip(LocalizeUtils.returnsToSender())),
        heliosis_dissipator = registerThrowableTool("heliosis_dissipator", () -> new ItemVetheanDissipator(14.5F).withTooltip(LocalizeUtils.returnsToSender())),
        arksiane_dissipator = registerThrowableTool("arksiane_dissipator", () -> new ItemVetheanDissipator(18.5F).withTooltip(LocalizeUtils.returnsToSender())),

        //Explosive & Homing
        grenade = registerThrowableTool("grenade", () -> new ItemThrowable(EntityRegistry.GRENADE::value, 3F).withTooltip(LocalizeUtils.explosiveShots()).withCooldown(20).withSound(SoundEvents.TRIDENT_THROW.value())),
        la_vekor = registerTool("la_vekor", () -> new ItemRangedWeapon(TagRegistry.GRENADES, ItemRegistry.grenade::toStack, EntityRegistry.GRENADE::value, 1225).withTooltip(LocalizeUtils.rangedDam(6)).withTooltip(LocalizeUtils.explosiveShots()).withCooldown(10).withSound(SoundRegistry.LA_VEKOR.get()).arcanaUse(15)),
        firefly = registerTool("firefly", ItemFirefly::new),
        meriks_missile = registerTool("meriks_missile", ItemMeriksMissile::new),

        //Magic & Staves
        scythe = registerTool("scythe", ItemScythe::new),
        cyclopsian_staff = registerTool("cyclopsian_staff", () -> new ItemRangedWeapon(EntityRegistry.EYE_SHARD::value, 126).withTooltip(LocalizeUtils.rangedDam(3)).withSound(SoundRegistry.STAFF.get())),
        maelstrom = registerTool("maelstrom", () -> new ItemRangedWeapon(EntityRegistry.MAELSTROM_SHOT::value, 100).withTooltip(LocalizeUtils.magicDam(12)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        captains_sparkler = registerTool("captains_sparkler", () -> new ItemRangedWeapon(EntityRegistry.SPARKLER_SHOT::value, 1235).withTooltip(LocalizeUtils.arcanaDam(13)).withSound(SoundRegistry.SPARKLER.get()).withCooldown(15).arcanaUse(7)),
        generals_staff = registerTool("generals_staff", () -> new ItemRangedWeapon(EntityRegistry.GENERALS_SHOT::value, 1212).withTooltip(LocalizeUtils.arcanaDam(13)).withTooltip(LocalizeUtils.splitShots(5)).withSound(SoundRegistry.STARLIGHT.get()).withCooldown(50).arcanaUse(20)),
        starlight = registerTool("starlight", () -> new SkyDropStaff(EntityRegistry.STAR::value, 5, 13, 1, 10, 1010)),
        staff_of_starlight = registerTool("staff_of_starlight", () -> new SkyDropStaff(EntityRegistry.STAR::value, 25, 13, 8, 40, 1176)),
        meteor_mash = registerTool("meteor_mash", () -> new SkyDropStaff(EntityRegistry.METEOR::value, 35, 15, 1, 30, 1218)),

        //Vethean Staves
        teaker_staff = registerTool("teaker_staff", () -> new VetheanStaff(10, 1)),
        amthirmis_staff = registerTool("amthirmis_staff", () -> new VetheanStaff(10, 1.6F)),
        darven_staff = registerTool("darven_staff", () -> new VetheanStaff(10, 2.6F)),
        cermile_staff = registerTool("cermile_staff", () -> new VetheanStaff(10, 4)),
        pardimal_staff = registerTool("pardimal_staff", () -> new VetheanStaff(10, 5)),
        quadrotic_staff = registerTool("quadrotic_staff", () -> new VetheanStaff(10, 6.3F)),
        karos_staff = registerTool("karos_staff", () -> new VetheanStaff(10, 7)),
        heliosis_staff = registerTool("heliosis_staff", () -> new VetheanStaff(10, 9.3F)),
        arksiane_staff = registerTool("arksiane_staff", () -> new VetheanStaff(10, 12)),
        evernight = registerTool("evernight", Evernight::new),

        //Phasers
        eden_phaser = registerTool("eden_phaser", () -> new ItemRangedWeapon(EntityRegistry.EDEN_PHASER_SHOT::value, 1517).withTooltip(LocalizeUtils.magicDam(8)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.EDEN)),
        wildwood_phaser = registerTool("wildwood_phaser", () -> new ItemRangedWeapon(EntityRegistry.WILDWOOD_PHASER_SHOT::value, 1624).withTooltip(LocalizeUtils.magicDam(10)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.WILDWOOD)),
        apalachia_phaser = registerTool("apalachia_phaser", () -> new ItemRangedWeapon(EntityRegistry.APALACHIA_PHASER_SHOT::value, 1778).withTooltip(LocalizeUtils.magicDam(12)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.APALACHIA)),
        skythern_phaser = registerTool("skythern_phaser", () -> new ItemRangedWeapon(EntityRegistry.SKYTHERN_PHASER_SHOT::value, 1879).withTooltip(LocalizeUtils.magicDam(14)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.SKYTHERN)),
        mortum_phaser = registerTool("mortum_phaser", () -> new ItemRangedWeapon(EntityRegistry.MORTUM_PHASER_SHOT::value, 1990).withTooltip(LocalizeUtils.magicDam(16)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.MORTUM)),
        halite_phaser = registerTool("halite_phaser", () -> new ItemRangedWeapon(EntityRegistry.HALITE_PHASER_SHOT::value, 2114).withTooltip(LocalizeUtils.magicDam(18)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.HALITE)),

        //Cannons
        crabclaw_cannon = registerTool("crabclaw_cannon", () -> new ItemRangedWeapon(TagRegistry.AQUATIC_CANNON_AMMO, Items.CACTUS::getDefaultInstance, EntityRegistry.CRAB_CLAW::value, 246).withTooltip(LocalizeUtils.rangedDam(4)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        frostclaw_cannon = registerTool("frostclaw_cannon", () -> new ItemRangedWeapon(TagRegistry.AQUATIC_CANNON_AMMO, Items.CACTUS::getDefaultInstance, EntityRegistry.FROST_CLAW::value, 612).withTooltip(LocalizeUtils.rangedDam(7)).withSound(SoundRegistry.FROSTCLAW_CANNON.get())),
        bowhead_cannon = registerTool("bowhead_cannon", () -> new ItemRangedWeapon(TagRegistry.AQUATIC_CANNON_AMMO, Items.CACTUS::getDefaultInstance, EntityRegistry.BOWHEAD_SHOT::value, 592).withTooltip(LocalizeUtils.rangedDam(6)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        frost_cannon = registerTool("frost_cannon", () -> new ItemRangedWeapon(TagRegistry.FROST_CANNON_AMMO, Items.SNOWBALL::getDefaultInstance, EntityRegistry.FROST_CANNON_SHOT::value, 1126).withTooltip(LocalizeUtils.rangedDam(6)).withSound(SoundRegistry.FROST_CANNON.get())),
        fractite_cannon = registerTool("fractite_cannon", () -> new ItemRangedWeapon(TagRegistry.FRACTITE_CANNON_AMMO, ItemRegistry.ice_shards::toStack, EntityRegistry.FRACTITE_CANNON_SHOT::value, 1442).withTooltip(LocalizeUtils.rangedDam(8)).withSound(SoundRegistry.FRACTITE_CANNON.get())),
        ghast_cannon = registerTool("ghast_cannon", () -> new ItemRangedWeapon(EntityRegistry.GHAST_CANNON_SHOT::value, 726).withTooltip(LocalizeUtils.magicDam(11)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        golden_fury = registerTool("golden_fury", () -> new ItemRangedWeapon(TagRegistry.GOLDEN_FURY_AMMO, Items.GOLD_NUGGET::getDefaultInstance, EntityRegistry.GOLDEN_FURY_SHOT::value, 2417).withTooltip(LocalizeUtils.rangedDam(17)).withSound(SoundRegistry.BLITZ.get())),

        //Blitz
        eden_blitz = registerTool("eden_blitz", () -> new ItemRangedWeapon(TagRegistry.EDEN_BLITZ_AMMO, ItemRegistry.eden_dust::toStack, EntityRegistry.EDEN_BLITZ_SHOT::value, 1517).withTooltip(LocalizeUtils.rangedDam(10)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.EDEN)),
        wildwood_blitz = registerTool("wildwood_blitz", () -> new ItemRangedWeapon(TagRegistry.WILDWOOD_BLITZ_AMMO, ItemRegistry.wildwood_dust::toStack, EntityRegistry.WILDWOOD_BLITZ_SHOT::value, 1624).withTooltip(LocalizeUtils.rangedDam(12)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.WILDWOOD)),
        apalachia_blitz = registerTool("apalachia_blitz", () -> new ItemRangedWeapon(TagRegistry.APALACHIA_BLITZ_AMMO, ItemRegistry.apalachia_dust::toStack, EntityRegistry.APALACHIA_BLITZ_SHOT::value, 1778).withTooltip(LocalizeUtils.rangedDam(14)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.APALACHIA)),
        skythern_blitz = registerTool("skythern_blitz", () -> new ItemRangedWeapon(TagRegistry.SKYTHERN_BLITZ_AMMO, ItemRegistry.skythern_dust::toStack, EntityRegistry.SKYTHERN_BLITZ_SHOT::value, 1879).withTooltip(LocalizeUtils.rangedDam(16)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.SKYTHERN)),
        mortum_blitz = registerTool("mortum_blitz", () -> new ItemRangedWeapon(TagRegistry.MORTUM_BLITZ_AMMO, ItemRegistry.mortum_dust::toStack, EntityRegistry.MORTUM_BLITZ_SHOT::value, 1990).withTooltip(LocalizeUtils.rangedDam(18)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.MORTUM)),
        halite_blitz = registerTool("halite_blitz", () -> new ItemRangedWeapon(TagRegistry.HALITE_BLITZ_AMMO, ItemRegistry.mortum_dust::toStack, EntityRegistry.HALITE_BLITZ_SHOT::value, 2114).withTooltip(LocalizeUtils.rangedDam(20)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.HALITE)),

        //Shotguns
        corrupted_bullet = registerTool("corrupted_bullet"),
        corrupted_cannon = registerTool("corrupted_cannon", () -> new Shotgun(TagRegistry.CORRUPTED_CANNON_AMMO, () -> new ItemStack(ItemRegistry.corrupted_bullet.get(), 4), EntityRegistry.CORRUPTED_BULLET::value, 1672, 15, 4).withTooltip(LocalizeUtils.rangedDam("4x10")).withSound(SoundRegistry.GHAST_CANNON.get())),
        arcanite_blaster = registerTool("arcanite_blaster", () -> new Shotgun(EntityRegistry.BLASTER_BULLET::value, 1127, 30, 30).withTooltip(LocalizeUtils.arcanaDam("30x13")).withSound(SoundRegistry.GHAST_CANNON.get()).arcanaUse(20)),

        //Vethean Cannons
        teaker_cannon = registerTool("teaker_cannon", () -> new VetheanCannon(1)),
        amthirmis_cannon = registerTool("amthirmis_cannon", () -> new VetheanCannon(1.6F)),
        darven_cannon = registerTool("darven_cannon", () -> new VetheanCannon(2.6F)),
        cermile_cannon = registerTool("cermile_cannon", () -> new VetheanCannon(4)),
        pardimal_cannon = registerTool("pardimal_cannon", () -> new VetheanCannon(5)),
        quadrotic_cannon = registerTool("quadrotic_cannon", () -> new VetheanCannon(6.3F)),
        karos_cannon = registerTool("karos_cannon", () -> new VetheanCannon(7)),
        heliosis_cannon = registerTool("heliosis_cannon", () -> new VetheanCannon(9.3F)),
        arksiane_cannon = registerTool("arksiane_cannon", () -> new VetheanCannon(12)),
        eversight = registerTool("eversight", () -> new ItemRangedWeapon(TagRegistry.VETHEAN_CANNON_AMMO, ItemRegistry.acid::toStack, EntityRegistry.EVERSIGHT_SHOT::value).withTooltip(LocalizeUtils.rangedDam(42)).withSound(SoundRegistry.BLITZ.get()).arcanaUse(10)),

    //Tool Sets
    realmite_shovel = registerTool("realmite_shovel", () -> new ItemModShovel(ToolStats.REALMITE_SHOVEL)),
        realmite_pickaxe = registerTool("realmite_pickaxe", () -> new ItemModPickaxe(ToolStats.REALMITE_PICKAXE)),
        realmite_axe = registerTool("realmite_axe", () -> new ItemModAxe(ToolStats.REALMITE_AXE, -3.1F)),
        realmite_hoe = registerTool("realmite_hoe", () -> new ItemModHoe(ToolStats.REALMITE_HOE, -1)),

    oxdrite_pickaxe = registerTool("oxdrite_pickaxe", () -> new ItemModPickaxe(ToolStats.OXDRITE_PICKAXE)),

    arlemite_shovel = registerTool("arlemite_shovel", () -> new ItemModShovel(ToolStats.ARLEMITE_SHOVEL)),
        arlemite_pickaxe = registerTool("arlemite_pickaxe", () -> new ItemModPickaxe(ToolStats.ARLEMITE_PICKAXE)),
        arlemite_axe = registerTool("arlemite_axe", () -> new ItemModAxe(ToolStats.ARLEMITE_AXE, -3)),
        arlemite_hoe = registerTool("arlemite_hoe", () -> new ItemModHoe(ToolStats.ARLEMITE_HOE, 0)),
        arlemite_shickaxe = registerTool("arlemite_shickaxe", () -> new ItemShickaxe(ToolStats.ARLEMITE_SHICKAXE)),

    terran_shovel = registerTool("terran_shovel", () -> new ItemModShovel(ToolStats.TERRAN_SHOVEL)),
        terran_pickaxe = registerTool("terran_pickaxe", () -> new ItemModPickaxe(ToolStats.TERRAN_PICKAXE)),
        terran_axe = registerTool("terran_axe", () -> new ItemModAxe(ToolStats.TERRAN_AXE, -3)),
        terran_hoe = registerTool("terran_hoe", () -> new ItemModHoe(ToolStats.TERRAN_HOE, 0)),
        terran_shickaxe = registerTool("terran_shickaxe", () -> new ItemShickaxe(ToolStats.TERRAN_SHICKAXE)),
        terran_shifter = registerTool("terran_shifter", () -> new ItemShickaxe(ToolStats.TERRAN_SHIFTER)),

    rupee_shovel = registerTool("rupee_shovel", () -> new ItemModShovel(ToolStats.RUPEE_SHOVEL)),
        rupee_pickaxe = registerTool("rupee_pickaxe", () -> new ItemModPickaxe(ToolStats.RUPEE_PICKAXE)),
        rupee_axe = registerTool("rupee_axe", () -> new ItemModAxe(ToolStats.RUPEE_AXE, -3)),
        rupee_hoe = registerTool("rupee_hoe", () -> new ItemModHoe(ToolStats.RUPEE_HOE, 0)),
        rupee_shickaxe = registerTool("rupee_shickaxe", () -> new ItemShickaxe(ToolStats.RUPEE_SHICKAXE)),

    corrupted_shovel = registerTool("corrupted_shovel", () -> new ItemModShovel(ToolStats.CORRUPTED_SHOVEL)),
        corrupted_pickaxe = registerTool("corrupted_pickaxe", () -> new ItemModPickaxe(ToolStats.CORRUPTED_PICKAXE)),
        corrupted_axe = registerTool("corrupted_axe", () -> new ItemModAxe(ToolStats.CORRUPTED_AXE, -2.9F)),
        corrupted_hoe = registerTool("corrupted_hoe", () -> new ItemModHoe(ToolStats.CORRUPTED_HOE, 0)),
        corrupted_shickaxe = registerTool("corrupted_shickaxe", () -> new ItemShickaxe(ToolStats.CORRUPTED_SHICKAXE)),

    bedrock_shovel = registerTool("bedrock_shovel", () -> new ItemModShovel(ToolStats.BEDROCK_SHOVEL, new Properties().fireResistant())),
        bedrock_pickaxe = registerTool("bedrock_pickaxe", () -> new ItemModPickaxe(ToolStats.BEDROCK_PICKAXE, new Properties().fireResistant())),
        bedrock_axe = registerTool("bedrock_axe", () -> new ItemModAxe(ToolStats.BEDROCK_AXE, -2.9F, new Properties().fireResistant())),
        bedrock_hoe = registerTool("bedrock_hoe", () -> new ItemModHoe(ToolStats.BEDROCK_HOE, 0, new Properties().fireResistant())),

    divine_shovel = registerTool("divine_shovel", () -> new ItemModShovel(ToolStats.DIVINE_SHOVEL, RarityList.DIVINE)),
        divine_pickaxe = registerTool("divine_pickaxe", () -> new ItemModPickaxe(ToolStats.DIVINE_PICKAXE, RarityList.DIVINE)),
        divine_axe = registerTool("divine_axe", () -> new ItemModAxe(ToolStats.DIVINE_AXE, -2.9F, RarityList.DIVINE)),
        divine_hoe = registerTool("divine_hoe", () -> new ItemModHoe(ToolStats.DIVINE_HOE, 0, RarityList.DIVINE)),
        divine_shickaxe = registerTool("divine_shickaxe", () -> new ItemShickaxe(ToolStats.DIVINE_SHICKAXE, RarityList.DIVINE)),

    eden_shovel = registerTool("eden_shovel", () -> new ItemModShovel(ToolStats.EDEN_SHOVEL, RarityList.EDEN)),
        eden_pickaxe = registerTool("eden_pickaxe", () -> new ItemModPickaxe(ToolStats.EDEN_PICKAXE, RarityList.EDEN)),
        eden_axe = registerTool("eden_axe", () -> new ItemModAxe(ToolStats.EDEN_AXE, -2.8F, RarityList.EDEN)),
        eden_hoe = registerTool("eden_hoe", () -> new ItemModHoe(ToolStats.EDEN_HOE, 0, RarityList.EDEN)),
        eden_shickaxe = registerTool("eden_shickaxe", () -> new ItemShickaxe(ToolStats.EDEN_SHICKAXE, RarityList.EDEN)),

    wildwood_shovel = registerTool("wildwood_shovel", () -> new ItemModShovel(ToolStats.WILDWOOD_SHOVEL, RarityList.WILDWOOD)),
        wildwood_pickaxe = registerTool("wildwood_pickaxe", () -> new ItemModPickaxe(ToolStats.WILDWOOD_PICKAXE, RarityList.WILDWOOD)),
        wildwood_axe = registerTool("wildwood_axe", () -> new ItemModAxe(ToolStats.WILDWOOD_AXE, -2.8F, RarityList.WILDWOOD)),
        wildwood_hoe = registerTool("wildwood_hoe", () -> new ItemModHoe(ToolStats.WILDWOOD_HOE, 0, RarityList.WILDWOOD)),
        wildwood_shickaxe = registerTool("wildwood_shickaxe", () -> new ItemShickaxe(ToolStats.WILDWOOD_SHICKAXE, RarityList.WILDWOOD)),

    apalachia_shovel = registerTool("apalachia_shovel", () -> new ItemModShovel(ToolStats.APALACHIA_SHOVEL, RarityList.APALACHIA)),
        apalachia_pickaxe = registerTool("apalachia_pickaxe", () -> new ItemModPickaxe(ToolStats.APALACHIA_PICKAXE, RarityList.APALACHIA)),
        apalachia_axe = registerTool("apalachia_axe", () -> new ItemModAxe(ToolStats.APALACHIA_AXE, -2.8F, RarityList.APALACHIA)),
        apalachia_hoe = registerTool("apalachia_hoe", () -> new ItemModHoe(ToolStats.APALACHIA_HOE, 0, RarityList.APALACHIA)),
        apalachia_shickaxe = registerTool("apalachia_shickaxe", () -> new ItemShickaxe(ToolStats.APALACHIA_SHICKAXE, RarityList.APALACHIA)),

    skythern_shovel = registerTool("skythern_shovel", () -> new ItemModShovel(ToolStats.SKYTHERN_SHOVEL, RarityList.SKYTHERN)),
        skythern_pickaxe = registerTool("skythern_pickaxe", () -> new ItemModPickaxe(ToolStats.SKYTHERN_PICKAXE, RarityList.SKYTHERN)),
        skythern_axe = registerTool("skythern_axe", () -> new ItemModAxe(ToolStats.SKYTHERN_AXE, -2.8F, RarityList.SKYTHERN)),
        skythern_hoe = registerTool("skythern_hoe", () -> new ItemModHoe(ToolStats.SKYTHERN_HOE, 0, RarityList.SKYTHERN)),
        skythern_shickaxe = registerTool("skythern_shickaxe", () -> new ItemShickaxe(ToolStats.SKYTHERN_SHICKAXE, RarityList.SKYTHERN)),

    mortum_shovel = registerTool("mortum_shovel", () -> new ItemModShovel(ToolStats.MORTUM_SHOVEL, RarityList.MORTUM)),
        mortum_pickaxe = registerTool("mortum_pickaxe", () -> new ItemModPickaxe(ToolStats.MORTUM_PICKAXE, RarityList.MORTUM)),
        mortum_axe = registerTool("mortum_axe", () -> new ItemModAxe(ToolStats.MORTUM_AXE, -2.8F, RarityList.MORTUM)),
        mortum_hoe = registerTool("mortum_hoe", () -> new ItemModHoe(ToolStats.MORTUM_HOE, 0, RarityList.MORTUM)),
        mortum_shickaxe = registerTool("mortum_shickaxe", () -> new ItemShickaxe(ToolStats.MORTUM_SHICKAXE, RarityList.MORTUM)),

    halite_shickaxe = registerTool("halite_shickaxe", () -> new ItemShickaxe(ToolStats.HALITE_SHICKAXE, RarityList.HALITE)),

    dream_shovel = registerTool("dream_shovel", () -> new ItemModShovel(ToolStats.DREAM_SHOVEL)),
        dream_pickaxe = registerTool("dream_pickaxe", () -> new ItemModPickaxe(ToolStats.DREAM_PICKAXE)),
        dream_axe = registerTool("dream_axe", () -> new ItemModAxe(ToolStats.DREAM_AXE, -3.1F)),

        //Blocks
        nightmare_bed = registerBlockItem("nightmare_bed", ItemNightmareBed::new),
        aqua_torch = registerBlockItem("aqua_torch", () -> new StandingAndWallBlockItem(BlockRegistry.aquaTorch.get(), BlockRegistry.aquaWallTorch.get(), new Properties(), Direction.DOWN)),
        skeleton_torch = registerBlockItem("skeleton_torch", () -> new StandingAndWallBlockItem(BlockRegistry.skeletonTorch.get(), BlockRegistry.skeletonWallTorch.get(), new Properties(), Direction.DOWN)),
        arcanium_torch = registerBlockItem("arcanium_torch", () -> new StandingAndWallBlockItem(BlockRegistry.arcaniumTorch.get(), BlockRegistry.arcaniumWallTorch.get(), new Properties(), Direction.DOWN)),
        eden_torch = registerBlockItem("eden_torch", () -> new StandingAndWallBlockItem(BlockRegistry.edenTorch.get(), BlockRegistry.edenWallTorch.get(), new Properties(), Direction.DOWN)),

    //Armor
    realmite_helmet = registerTool("realmite_helmet", () -> new ItemDivineArmor(REALMITE, HELMET, 16)),
        realmite_chestplate = registerTool("realmite_chestplate", () -> new ItemDivineArmor(REALMITE, CHESTPLATE, 16)),
        realmite_leggings = registerTool("realmite_leggings", () -> new ItemDivineArmor(REALMITE, LEGGINGS, 16)),
        realmite_boots = registerTool("realmite_boots", () -> new ItemDivineArmor(REALMITE, BOOTS, 16)),

    seng_fur_helmet = registerTool("seng_fur_helmet", () -> new ItemDivineArmor(SENG_FUR, HELMET, 17, sengFurInfo, SENG_FUR_STRENGTH, WARMTH)),
        seng_fur_chestplate = registerTool("seng_fur_chestplate", () -> new ItemDivineArmor(SENG_FUR, CHESTPLATE, 17, sengFurInfo)),
        seng_fur_leggings = registerTool("seng_fur_leggings", () -> new ItemDivineArmor(SENG_FUR, LEGGINGS, 17, sengFurInfo)),
        seng_fur_boots = registerTool("seng_fur_boots", () -> new ItemDivineArmor(SENG_FUR, BOOTS, 17, sengFurInfo)),

	santa_helmet = registerTool("santa_helmet", () -> new ItemDivineArmor(SANTA, HELMET, 17, sengFurInfo, SENG_FUR_STRENGTH, WARMTH)),
        santa_chestplate = registerTool("santa_chestplate", () -> new ItemDivineArmor(SANTA, CHESTPLATE, 17, sengFurInfo)),
        santa_leggings = registerTool("santa_leggings", () -> new ItemDivineArmor(SANTA, LEGGINGS, 17, sengFurInfo)),
        santa_boots = registerTool("santa_boots", () -> new ItemDivineArmor(SANTA, BOOTS, 17, sengFurInfo)),

    aquastrive_helmet = registerTool("aquastrive_helmet", () -> new ItemDivineArmor(AQUASTRIVE, HELMET, 18, aquastriveInfo, WATER_BREATHING)),
        aquastrive_chestplate = registerTool("aquastrive_chestplate", () -> new ItemDivineArmor(AQUASTRIVE, CHESTPLATE, 18, aquastriveInfo)),
        aquastrive_leggings = registerTool("aquastrive_leggings", () -> new ItemDivineArmor(AQUASTRIVE, LEGGINGS, 18, aquastriveInfo)),
        aquastrive_boots = registerTool("aquastrive_boots", () -> new ItemDivineArmor(AQUASTRIVE, BOOTS, 18, aquastriveInfo)),

    kraken_helmet = registerTool("kraken_helmet", () -> new ItemDivineArmor(KRAKEN, HELMET, 20, krakenInfo, DOLPHINS_GRACE, CONDUIT_POWER)),
        kraken_chestplate = registerTool("kraken_chestplate", () -> new ItemDivineArmor(KRAKEN, CHESTPLATE, 20, krakenInfo)),
        kraken_leggings = registerTool("kraken_leggings", () -> new ItemDivineArmor(KRAKEN, LEGGINGS, 20, krakenInfo)),
        kraken_boots = registerTool("kraken_boots", () -> new ItemDivineArmor(KRAKEN, BOOTS, 20, krakenInfo)),

    jack_o_man_helmet = registerTool("jack_o_man_helmet", () -> new ItemDivineArmor(JACK_O_MAN, HELMET, 21, jackomanInfo)),
        jack_o_man_chestplate = registerTool("jack_o_man_chestplate", () -> new ItemDivineArmor(JACK_O_MAN, CHESTPLATE, 21, jackomanInfo)),
        jack_o_man_leggings = registerTool("jack_o_man_leggings", () -> new ItemDivineArmor(JACK_O_MAN, LEGGINGS, 21, jackomanInfo)),
        jack_o_man_boots = registerTool("jack_o_man_boots", () -> new ItemDivineArmor(JACK_O_MAN, BOOTS, 21, jackomanInfo)),

    skeleman_helmet = registerTool("skeleman_helmet", () -> new ItemDivineArmor(SKELEMAN, HELMET, 21, skelemanInfo, SKELEMAN_FEED)),
        skeleman_chestplate = registerTool("skeleman_chestplate", () -> new ItemDivineArmor(SKELEMAN, CHESTPLATE, 21, skelemanInfo)),
        skeleman_leggings = registerTool("skeleman_leggings", () -> new ItemDivineArmor(SKELEMAN, LEGGINGS, 21, skelemanInfo)),
        skeleman_boots = registerTool("skeleman_boots", () -> new ItemDivineArmor(SKELEMAN, BOOTS, 21, skelemanInfo)),

    wither_reaper_helmet = registerTool("wither_reaper_helmet", () -> new ItemDivineArmor(WITHER_REAPER, HELMET, 21, witherReaperInfo, WITHER_PROTECTION)),
        wither_reaper_chestplate = registerTool("wither_reaper_chestplate", () -> new ItemDivineArmor(WITHER_REAPER, CHESTPLATE, 21, witherReaperInfo)),
        wither_reaper_leggings = registerTool("wither_reaper_leggings", () -> new ItemDivineArmor(WITHER_REAPER, LEGGINGS, 21, witherReaperInfo)),
        wither_reaper_boots = registerTool("wither_reaper_boots", () -> new ItemDivineArmor(WITHER_REAPER, BOOTS, 21, witherReaperInfo)),

    arlemite_helmet = registerTool("arlemite_helmet", () -> new ItemDivineArmor(ARLEMITE, HELMET, 32, arlemiteInfo, PROJECTILE_PROTECTION)),
        arlemite_chestplate = registerTool("arlemite_chestplate", () -> new ItemDivineArmor(ARLEMITE, CHESTPLATE, 32, arlemiteInfo)),
        arlemite_leggings = registerTool("arlemite_leggings", () -> new ItemDivineArmor(ARLEMITE, LEGGINGS, 32, arlemiteInfo)),
        arlemite_boots = registerTool("arlemite_boots", () -> new ItemDivineArmor(ARLEMITE, BOOTS, 32, arlemiteInfo)),

    frozen_helmet = registerTool("frozen_helmet", () -> new ItemDivineArmor(FROZEN, HELMET, 33, frozenInfo, FROZEN_SLOWNESS)),
        frozen_chestplate = registerTool("frozen_chestplate", () -> new ItemDivineArmor(FROZEN, CHESTPLATE, 33, frozenInfo)),
        frozen_leggings = registerTool("frozen_leggings", () -> new ItemDivineArmor(FROZEN, LEGGINGS, 33, frozenInfo)),
        frozen_boots = registerTool("frozen_boots", () -> new ItemDivineArmor(FROZEN, BOOTS, 33, frozenInfo)),

    jungle_helmet = registerTool("jungle_helmet", () -> new ItemDivineArmor(JUNGLE, HELMET, 33, jungleInfo, POISON_PROTECTION)),
        jungle_chestplate = registerTool("jungle_chestplate", () -> new ItemDivineArmor(JUNGLE, CHESTPLATE, 33, jungleInfo)),
        jungle_leggings = registerTool("jungle_leggings", () -> new ItemDivineArmor(JUNGLE, LEGGINGS, 33, jungleInfo)),
        jungle_boots = registerTool("jungle_boots", () -> new ItemDivineArmor(JUNGLE, BOOTS, 33, jungleInfo)),

    inferno_helmet = registerTool("inferno_helmet", () -> new ItemDivineArmor(INFERNO, HELMET, 34, fireInfo, new Properties().fireResistant(), FIRE_RESISTANCE)),
        inferno_chestplate = registerTool("inferno_chestplate", () -> new ItemDivineArmor(INFERNO, CHESTPLATE, 34, fireInfo, new Properties().fireResistant())),
        inferno_leggings = registerTool("inferno_leggings", () -> new ItemDivineArmor(INFERNO, LEGGINGS, 34, fireInfo, new Properties().fireResistant())),
        inferno_boots = registerTool("inferno_boots", () -> new ItemDivineArmor(INFERNO, BOOTS, 34, fireInfo, new Properties().fireResistant())),

    torridite_helmet = registerTool("torridite_helmet", () -> new ItemDivineArmor(TORRIDITE, HELMET, 34, fireInfo, new Properties().fireResistant(), FIRE_RESISTANCE)),
        torridite_chestplate = registerTool("torridite_chestplate", () -> new ItemDivineArmor(TORRIDITE, CHESTPLATE, 34, fireInfo, new Properties().fireResistant())),
        torridite_leggings = registerTool("torridite_leggings", () -> new ItemDivineArmor(TORRIDITE, LEGGINGS, 34, fireInfo, new Properties().fireResistant())),
        torridite_boots = registerTool("torridite_boots", () -> new ItemDivineArmor(TORRIDITE, BOOTS, 34, fireInfo, new Properties().fireResistant())),

    terran_helmet = registerTool("terran_helmet", () -> new ItemDivineArmor(TERRAN, HELMET, 34, terranInfo, new int[]{2}, DIG_SPEED)),
        terran_chestplate = registerTool("terran_chestplate", () -> new ItemDivineArmor(TERRAN, CHESTPLATE, 34, terranInfo)),
        terran_leggings = registerTool("terran_leggings", () -> new ItemDivineArmor(TERRAN, LEGGINGS, 34, terranInfo)),
        terran_boots = registerTool("terran_boots", () -> new ItemDivineArmor(TERRAN, BOOTS, 34, terranInfo)),

    angelic_helmet = registerTool("angelic_helmet", () -> new ItemDivineArmor(ANGELIC, HELMET, 35, angelicInfo, PREVENT_FALL_DAMAGE, ANGELIC_FLIGHT)),
        angelic_chestplate = registerTool("angelic_chestplate", () -> new ItemDivineArmor(ANGELIC, CHESTPLATE, 35, angelicInfo)),
        angelic_leggings = registerTool("angelic_leggings", () -> new ItemDivineArmor(ANGELIC, LEGGINGS, 35, angelicInfo)),
        angelic_boots = registerTool("angelic_boots", () -> new ItemDivineArmor(ANGELIC, BOOTS, 35, angelicInfo)),

    shadow_helmet = registerTool("shadow_helmet", () -> new ItemDivineArmor(SHADOW, HELMET, 35, shadowInfo, STEP_ASSIST)),
        shadow_chestplate = registerTool("shadow_chestplate", () -> new ItemDivineArmor(SHADOW, CHESTPLATE, 35, shadowInfo, new int[]{3}, MOVEMENT_SPEED)),
        shadow_leggings = registerTool("shadow_leggings", () -> new ItemDivineArmor(SHADOW, LEGGINGS, 35, shadowInfo)),
        shadow_boots = registerTool("shadow_boots", () -> new ItemDivineArmor(SHADOW, BOOTS, 35, shadowInfo)),

    rupee_helmet = registerTool("rupee_helmet", () -> new ItemDivineArmor(RUPEE, HELMET, 35, rupeeInfo, MELEE_PROTECTION)),
        rupee_chestplate = registerTool("rupee_chestplate", () -> new ItemDivineArmor(RUPEE, CHESTPLATE, 35, rupeeInfo)),
        rupee_leggings = registerTool("rupee_leggings", () -> new ItemDivineArmor(RUPEE, LEGGINGS, 35, rupeeInfo)),
        rupee_boots = registerTool("rupee_boots", () -> new ItemDivineArmor(RUPEE, BOOTS, 35, rupeeInfo)),

    red_rupee_helmet = registerTool("red_rupee_helmet", () -> new ItemDivineArmor(RarityList.RED, RED_RUPEE, HELMET, 35, rupeeInfo, MELEE_PROTECTION)),
        red_rupee_chestplate = registerTool("red_rupee_chestplate", () -> new ItemDivineArmor(RarityList.RED, RED_RUPEE, CHESTPLATE, 35, rupeeInfo)),
        red_rupee_leggings = registerTool("red_rupee_leggings", () -> new ItemDivineArmor(RarityList.RED, RED_RUPEE, LEGGINGS, 35, rupeeInfo)),
        red_rupee_boots = registerTool("red_rupee_boots", () -> new ItemDivineArmor(RarityList.RED, RED_RUPEE, BOOTS, 35, rupeeInfo)),

    yellow_rupee_helmet = registerTool("yellow_rupee_helmet", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_RUPEE, HELMET, 35, rupeeInfo, MELEE_PROTECTION)),
        yellow_rupee_chestplate = registerTool("yellow_rupee_chestplate", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_RUPEE, CHESTPLATE, 35, rupeeInfo)),
        yellow_rupee_leggings = registerTool("yellow_rupee_leggings", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_RUPEE, LEGGINGS, 35, rupeeInfo)),
        yellow_rupee_boots = registerTool("yellow_rupee_boots", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_RUPEE, BOOTS, 35, rupeeInfo)),

    green_rupee_helmet = registerTool("green_rupee_helmet", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_RUPEE, HELMET, 35, rupeeInfo, MELEE_PROTECTION)),
        green_rupee_chestplate = registerTool("green_rupee_chestplate", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_RUPEE, CHESTPLATE, 35, rupeeInfo)),
        green_rupee_leggings = registerTool("green_rupee_leggings", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_RUPEE, LEGGINGS, 35, rupeeInfo)),
        green_rupee_boots = registerTool("green_rupee_boots", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_RUPEE, BOOTS, 35, rupeeInfo)),

    blue_rupee_helmet = registerTool("blue_rupee_helmet", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_RUPEE, HELMET, 35, rupeeInfo, MELEE_PROTECTION)),
        blue_rupee_chestplate = registerTool("blue_rupee_chestplate", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_RUPEE, CHESTPLATE, 35, rupeeInfo)),
        blue_rupee_leggings = registerTool("blue_rupee_leggings", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_RUPEE, LEGGINGS, 35, rupeeInfo)),
        blue_rupee_boots = registerTool("blue_rupee_boots", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_RUPEE, BOOTS, 35, rupeeInfo)),

    gray_rupee_helmet = registerTool("gray_rupee_helmet", () -> new ItemDivineArmor(RarityList.GRAY, GRAY_RUPEE, HELMET, 35, rupeeInfo, MELEE_PROTECTION)),
        gray_rupee_chestplate = registerTool("gray_rupee_chestplate", () -> new ItemDivineArmor(RarityList.GRAY, GRAY_RUPEE, CHESTPLATE, 35, rupeeInfo)),
        gray_rupee_leggings = registerTool("gray_rupee_leggings", () -> new ItemDivineArmor(RarityList.GRAY, GRAY_RUPEE, LEGGINGS, 35, rupeeInfo)),
        gray_rupee_boots = registerTool("gray_rupee_boots", () -> new ItemDivineArmor(RarityList.GRAY, GRAY_RUPEE, BOOTS, 35, rupeeInfo)),

    elite_realmite_helmet = registerTool("elite_realmite_helmet", () -> new ItemDivineArmor(ELITE_REALMITE, HELMET, 39, eliteRealmiteInfo, PREVENT_FALL_DAMAGE)),
        elite_realmite_chestplate = registerTool("elite_realmite_chestplate", () -> new ItemDivineArmor(ELITE_REALMITE, CHESTPLATE, 39, eliteRealmiteInfo)),
        elite_realmite_leggings = registerTool("elite_realmite_leggings", () -> new ItemDivineArmor(ELITE_REALMITE, LEGGINGS, 39, eliteRealmiteInfo)),
        elite_realmite_boots = registerTool("elite_realmite_boots", () -> new ItemDivineArmor(ELITE_REALMITE, BOOTS, 39, eliteRealmiteInfo)),

    corrupted_helmet = registerTool("corrupted_helmet", () -> new ItemDivineArmor(CORRUPTED, HELMET, 40, corruptedInfo, CORRUPTED_STRENGTH)),
        corrupted_chestplate = registerTool("corrupted_chestplate", () -> new ItemDivineArmor(CORRUPTED, CHESTPLATE, 40, corruptedInfo)),
        corrupted_leggings = registerTool("corrupted_leggings", () -> new ItemDivineArmor(CORRUPTED, LEGGINGS, 40, corruptedInfo)),
        corrupted_boots = registerTool("corrupted_boots", () -> new ItemDivineArmor(CORRUPTED, BOOTS, 40, corruptedInfo)),

    bedrock_helmet = registerTool("bedrock_helmet", () -> new ItemDivineArmor(BEDROCK, HELMET, 0, bedrockInfo, new Properties().fireResistant(), FIRE_RESISTANCE, EXPLOSION_PROTECTION)),
        bedrock_chestplate = registerTool("bedrock_chestplate", () -> new ItemDivineArmor(BEDROCK, CHESTPLATE, 0, bedrockInfo, new Properties().fireResistant())),
        bedrock_leggings = registerTool("bedrock_leggings", () -> new ItemDivineArmor(BEDROCK, LEGGINGS, 0, bedrockInfo, new Properties().fireResistant())),
        bedrock_boots = registerTool("bedrock_boots", () -> new ItemDivineArmor(BEDROCK, BOOTS, 0, bedrockInfo, new Properties().fireResistant())),

    korma_helmet = registerTool("korma_helmet", () -> new ItemDivineArmor(KORMA, HELMET, 41, kormInfo, KORMA_ARCANA)),
        korma_chestplate = registerTool("korma_chestplate", () -> new ItemDivineArmor(KORMA, CHESTPLATE, 41, kormInfo)),
        korma_leggings = registerTool("korma_leggings", () -> new ItemDivineArmor(KORMA, LEGGINGS, 41, kormInfo)),
        korma_boots = registerTool("korma_boots", () -> new ItemDivineArmor(KORMA, BOOTS, 41, kormInfo)),

    vemos_helmet = registerTool("vemos_helmet", () -> new ItemDivineArmor(VEMOS, HELMET, 43, vemInfo, VEMOS_HEAL)),
        vemos_chestplate = registerTool("vemos_chestplate", () -> new ItemDivineArmor(VEMOS, CHESTPLATE, 43, vemInfo)),
        vemos_leggings = registerTool("vemos_leggings", () -> new ItemDivineArmor(VEMOS, LEGGINGS, 43, vemInfo)),
        vemos_boots = registerTool("vemos_boots", () -> new ItemDivineArmor(VEMOS, BOOTS, 43, vemInfo)),

    ender_helmet = registerTool("ender_helmet", () -> new ItemDivineArmor(RarityList.ENDER, ENDER, HELMET, 0, enderInfo, EXPLOSION_PROTECTION)),
        ender_chestplate = registerTool("ender_chestplate", () -> new ItemDivineArmor(RarityList.ENDER, ENDER, CHESTPLATE, 0, enderInfo)),
        ender_leggings = registerTool("ender_leggings", () -> new ItemDivineArmor(RarityList.ENDER, ENDER, LEGGINGS, 0, enderInfo)),
        ender_boots = registerTool("ender_boots", () -> new ItemDivineArmor(RarityList.ENDER, ENDER, BOOTS, 0, enderInfo)),

    red_ender_helmet = registerTool("red_ender_helmet", () -> new ItemDivineArmor(RarityList.RED, RED_ENDER, HELMET, 0, enderInfo, EXPLOSION_PROTECTION)),
        red_ender_chestplate = registerTool("red_ender_chestplate", () -> new ItemDivineArmor(RarityList.RED, RED_ENDER, CHESTPLATE, 0, enderInfo)),
        red_ender_leggings = registerTool("red_ender_leggings", () -> new ItemDivineArmor(RarityList.RED, RED_ENDER, LEGGINGS, 0, enderInfo)),
        red_ender_boots = registerTool("red_ender_boots", () -> new ItemDivineArmor(RarityList.RED, RED_ENDER, BOOTS, 0, enderInfo)),

    yellow_ender_helmet = registerTool("yellow_ender_helmet", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_ENDER, HELMET, 0, enderInfo, EXPLOSION_PROTECTION)),
        yellow_ender_chestplate = registerTool("yellow_ender_chestplate", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_ENDER, CHESTPLATE, 0, enderInfo)),
        yellow_ender_leggings = registerTool("yellow_ender_leggings", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_ENDER, LEGGINGS, 0, enderInfo)),
        yellow_ender_boots = registerTool("yellow_ender_boots", () -> new ItemDivineArmor(RarityList.UNCOMMON, YELLOW_ENDER, BOOTS, 0, enderInfo)),

    green_ender_helmet = registerTool("green_ender_helmet", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_ENDER, HELMET, 0, enderInfo, EXPLOSION_PROTECTION)),
        green_ender_chestplate = registerTool("green_ender_chestplate", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_ENDER, CHESTPLATE, 0, enderInfo)),
        green_ender_leggings = registerTool("green_ender_leggings", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_ENDER, LEGGINGS, 0, enderInfo)),
        green_ender_boots = registerTool("green_ender_boots", () -> new ItemDivineArmor(RarityList.GREEN, GREEN_ENDER, BOOTS, 0, enderInfo)),

    blue_ender_helmet = registerTool("blue_ender_helmet", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_ENDER, HELMET, 0, enderInfo, EXPLOSION_PROTECTION)),
        blue_ender_chestplate = registerTool("blue_ender_chestplate", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_ENDER, CHESTPLATE, 0, enderInfo)),
        blue_ender_leggings = registerTool("blue_ender_leggings", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_ENDER, LEGGINGS, 0, enderInfo)),
        blue_ender_boots = registerTool("blue_ender_boots", () -> new ItemDivineArmor(RarityList.BLUE, BLUE_ENDER, BOOTS, 0, enderInfo)),

    gray_ender_helmet = registerTool("gray_ender_helmet", () -> new ItemDivineArmor(RarityList.DARK_GRAY, GRAY_ENDER, HELMET, 0, enderInfo, EXPLOSION_PROTECTION)),
        gray_ender_chestplate = registerTool("gray_ender_chestplate", () -> new ItemDivineArmor(RarityList.DARK_GRAY, GRAY_ENDER, CHESTPLATE, 0, enderInfo)),
        gray_ender_leggings = registerTool("gray_ender_leggings", () -> new ItemDivineArmor(RarityList.DARK_GRAY, GRAY_ENDER, LEGGINGS, 0, enderInfo)),
        gray_ender_boots = registerTool("gray_ender_boots", () -> new ItemDivineArmor(RarityList.DARK_GRAY, GRAY_ENDER, BOOTS, 0, enderInfo)),

    divine_helmet = registerTool("divine_helmet", () -> new ItemDivineArmor(RarityList.DIVINE, DIVINE, HELMET, 0, divineInfo, PREVENT_FALL_DAMAGE, DIVINE_STRENGTH)),
        divine_chestplate = registerTool("divine_chestplate", () -> new ItemDivineArmor(RarityList.DIVINE, DIVINE, CHESTPLATE, 0, divineInfo, new int[]{1}, JUMP)),
        divine_leggings = registerTool("divine_leggings", () -> new ItemDivineArmor(RarityList.DIVINE, DIVINE, LEGGINGS, 0, divineInfo)),
        divine_boots = registerTool("divine_boots", () -> new ItemDivineArmor(RarityList.DIVINE, DIVINE, BOOTS, 0, divineInfo)),

    eden_helmet = registerTool("eden_helmet", () -> new ItemDivineArmor(RarityList.EDEN, EDEN, HELMET, 45, edenInfo)),
        eden_chestplate = registerTool("eden_chestplate", () -> new ItemDivineArmor(RarityList.EDEN, EDEN, CHESTPLATE, 45, edenInfo)),
        eden_leggings = registerTool("eden_leggings", () -> new ItemDivineArmor(RarityList.EDEN, EDEN, LEGGINGS, 45, edenInfo)),
        eden_boots = registerTool("eden_boots", () -> new ItemDivineArmor(RarityList.EDEN, EDEN, BOOTS, 45, edenInfo)),

    wildwood_helmet = registerTool("wildwood_helmet", () -> new ItemDivineArmor(RarityList.WILDWOOD, WILDWOOD, HELMET, 46, wildInfo, WILDWOOD_HEAL)),
        wildwood_chestplate = registerTool("wildwood_chestplate", () -> new ItemDivineArmor(RarityList.WILDWOOD, WILDWOOD, CHESTPLATE, 46, wildInfo)),
        wildwood_leggings = registerTool("wildwood_leggings", () -> new ItemDivineArmor(RarityList.WILDWOOD, WILDWOOD, LEGGINGS, 46, wildInfo)),
        wildwood_boots = registerTool("wildwood_boots", () -> new ItemDivineArmor(RarityList.WILDWOOD, WILDWOOD, BOOTS, 46, wildInfo)),

    apalachia_helmet = registerTool("apalachia_helmet", () -> new ItemDivineArmor(RarityList.APALACHIA, APALACHIA, HELMET, 47, apInfo, BLOCK_PROTECTION)),
        apalachia_chestplate = registerTool("apalachia_chestplate", () -> new ItemDivineArmor(RarityList.APALACHIA, APALACHIA, CHESTPLATE, 47, apInfo)),
        apalachia_leggings = registerTool("apalachia_leggings", () -> new ItemDivineArmor(RarityList.APALACHIA, APALACHIA, LEGGINGS, 47, apInfo)),
        apalachia_boots = registerTool("apalachia_boots", () -> new ItemDivineArmor(RarityList.APALACHIA, APALACHIA, BOOTS, 47, apInfo)),

    skythern_helmet = registerTool("skythern_helmet", () -> new ItemDivineArmor(RarityList.SKYTHERN, SKYTHERN, HELMET, 48, skyInfo, PREVENT_FALL_DAMAGE)),
        skythern_chestplate = registerTool("skythern_chestplate", () -> new ItemDivineArmor(RarityList.SKYTHERN, SKYTHERN, CHESTPLATE, 48, skyInfo, new int[] {5}, JUMP)),
        skythern_leggings = registerTool("skythern_leggings", () -> new ItemDivineArmor(RarityList.SKYTHERN, SKYTHERN, LEGGINGS, 48, skyInfo)),
        skythern_boots = registerTool("skythern_boots", () -> new ItemDivineArmor(RarityList.SKYTHERN, SKYTHERN, BOOTS, 48, skyInfo)),

    mortum_helmet = registerTool("mortum_helmet", () -> new ItemDivineArmor(RarityList.MORTUM, MORTUM, HELMET, 49, mortInfo, NIGHT_VISION)),
        mortum_chestplate = registerTool("mortum_chestplate", () -> new ItemDivineArmor(RarityList.MORTUM, MORTUM, CHESTPLATE, 49, mortInfo)),
        mortum_leggings = registerTool("mortum_leggings", () -> new ItemDivineArmor(RarityList.MORTUM, MORTUM, LEGGINGS, 49, mortInfo)),
        mortum_boots = registerTool("mortum_boots", () -> new ItemDivineArmor(RarityList.MORTUM, MORTUM, BOOTS, 49, mortInfo)),

    halite_helmet = registerTool("halite_helmet", () -> new ItemDivineArmor(RarityList.HALITE, HALITE, HELMET, 50, halInfo, HALITE_STRENGTH)),
        halite_chestplate = registerTool("halite_chestplate", () -> new ItemDivineArmor(RarityList.HALITE, HALITE, CHESTPLATE, 50, halInfo)),
        halite_leggings = registerTool("halite_leggings", () -> new ItemDivineArmor(RarityList.HALITE, HALITE, LEGGINGS, 50, halInfo)),
        halite_boots = registerTool("halite_boots", () -> new ItemDivineArmor(RarityList.HALITE, HALITE, BOOTS, 50, halInfo)),

    awakened_halite_helmet = registerTool("awakened_halite_helmet", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, AWAKENED_HALITE, HELMET, 51, awakened_halInfo, AWAKENED_HALITE_STRENGTH)),
        awakened_halite_chestplate = registerTool("awakened_halite_chestplate", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, AWAKENED_HALITE, CHESTPLATE, 51, awakened_halInfo)),
        awakened_halite_leggings = registerTool("awakened_halite_leggings", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, AWAKENED_HALITE, LEGGINGS, 51, awakened_halInfo)),
        awakened_halite_boots = registerTool("awakened_halite_boots", () -> new ItemDivineArmor(RarityList.AWAKENED_HALITE, AWAKENED_HALITE, BOOTS, 51, awakened_halInfo)),

    degraded_helmet = registerTool("degraded_helmet", () -> new ItemDivineArmor(DEGRADED, HELMET, 25, basicHelmInfo, DEGRADED_HELMET)),
        degraded_hood = registerTool("degraded_hood", () -> new ItemDivineArmor(DEGRADED, HELMET, 25, basicHoodInfo, DEGRADED_HOOD)),
        degraded_mask = registerTool("degraded_mask", () -> new ItemDivineArmor(DEGRADED, HELMET, 25, basicMaskInfo, DEGRADED_MASK)),
        degraded_chestplate = registerTool("degraded_chestplate", () -> new ItemDivineArmor(DEGRADED, CHESTPLATE, 25)),
        degraded_leggings = registerTool("degraded_leggings", () -> new ItemDivineArmor(DEGRADED, LEGGINGS, 25)),
        degraded_boots = registerTool("degraded_boots", () -> new ItemDivineArmor(DEGRADED, BOOTS, 25)),

    finished_helmet = registerTool("finished_helmet", () -> new ItemDivineArmor(FINISHED, HELMET, 30, basicHelmInfo, FINISHED_HELMET)),
        finished_hood = registerTool("finished_hood", () -> new ItemDivineArmor(FINISHED, HELMET, 30, basicHoodInfo, FINISHED_HOOD)),
        finished_mask = registerTool("finished_mask", () -> new ItemDivineArmor(FINISHED, HELMET, 30, basicMaskInfo, FINISHED_MASK)),
        finished_chestplate = registerTool("finished_chestplate", () -> new ItemDivineArmor(FINISHED, CHESTPLATE, 30)),
        finished_leggings = registerTool("finished_leggings", () -> new ItemDivineArmor(FINISHED, LEGGINGS, 30)),
        finished_boots = registerTool("finished_boots", () -> new ItemDivineArmor(FINISHED, BOOTS, 30)),

    glistening_helmet = registerTool("glistening_helmet", () -> new ItemDivineArmor(GLISTENING, HELMET, 35, glisteningHelmInfo, GLISTENING_HELMET)),
        glistening_hood = registerTool("glistening_hood", () -> new ItemDivineArmor(GLISTENING, HELMET, 35, glisteningHoodInfo, PREVENT_FALL_DAMAGE, JUMP, GLISTENING_HOOD)),
        glistening_mask = registerTool("glistening_mask", () -> new ItemDivineArmor(GLISTENING, HELMET, 35, glisteningMaskInfo, MOVEMENT_SPEED, GLISTENING_MASK)),
        glistening_chestplate = registerTool("glistening_chestplate", () -> new ItemDivineArmor(GLISTENING, CHESTPLATE, 35)),
        glistening_leggings = registerTool("glistening_leggings", () -> new ItemDivineArmor(GLISTENING, LEGGINGS, 35)),
        glistening_boots = registerTool("glistening_boots", () -> new ItemDivineArmor(GLISTENING, BOOTS, 35)),

    demonized_helmet = registerTool("demonized_helmet", () -> new ItemDivineArmor(DEMONIZED, HELMET, 40, demonizedHelmInfo, DEMONIZED_HELMET)),
        demonized_hood = registerTool("demonized_hood", () -> new ItemDivineArmor(DEMONIZED, HELMET, 40, demonizedHoodInfo, new int[]{0, 1, 0}, PREVENT_FALL_DAMAGE, JUMP, DEMONIZED_HOOD)),
        demonized_mask = registerTool("demonized_mask", () -> new ItemDivineArmor(DEMONIZED, HELMET, 40, demonizedMaskInfo, new int[]{1, 0}, MOVEMENT_SPEED, DEMONIZED_MASK)),
        demonized_chestplate = registerTool("demonized_chestplate", () -> new ItemDivineArmor(DEMONIZED, CHESTPLATE, 40)),
        demonized_leggings = registerTool("demonized_leggings", () -> new ItemDivineArmor(DEMONIZED, LEGGINGS, 40)),
        demonized_boots = registerTool("demonized_boots", () -> new ItemDivineArmor(DEMONIZED, BOOTS, 40)),

    tormented_helmet = registerTool("tormented_helmet", () -> new ItemDivineArmor(TORMENTED, HELMET, 45, tormentedHelmInfo, TORMENTED_HELMET)),
        tormented_hood = registerTool("tormented_hood", () -> new ItemDivineArmor(TORMENTED, HELMET, 45, tormentedHoodInfo, new int[]{0, 2, 0}, PREVENT_FALL_DAMAGE, JUMP, TORMENTED_HOOD)),
        tormented_mask = registerTool("tormented_mask", () -> new ItemDivineArmor(TORMENTED, HELMET, 45, tormentedMaskInfo, new int[]{2, 0}, MOVEMENT_SPEED, TORMENTED_MASK)),
        tormented_chestplate = registerTool("tormented_chestplate", () -> new ItemDivineArmor(TORMENTED, CHESTPLATE, 45)),
        tormented_leggings = registerTool("tormented_leggings", () -> new ItemDivineArmor(TORMENTED, LEGGINGS, 45)),
        tormented_boots = registerTool("tormented_boots", () -> new ItemDivineArmor(TORMENTED, BOOTS, 45));

    public static void registerDispenserItems() {
        if(!DISPENSER_ITEMS.isEmpty()) for(ItemLike item : DISPENSER_ITEMS) DispenserBlock.registerProjectileBehavior(item);
        else DivineRPG.LOGGER.error("No items registered for dispenser behavior");
    }
    private static DeferredItem<Item> registerItemVethean(String registryId) {
        DeferredItem<Item> i = ITEMS.register(registryId, () -> new ItemVethean());
        CreativeTabRegistry.misc.add(i);
        return i;
    }
    private static <T extends Item> DeferredItem<T> registerItemVethean(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        CreativeTabRegistry.misc.add(i);
        return i;
    }
    private static DeferredItem<Item> registerItem(String registryId) {
        DeferredItem<Item> i = ITEMS.register(registryId, () -> new ItemMod());
        CreativeTabRegistry.misc.add(i);
        return i;
    }
    private static <T extends Item> DeferredItem<T> registerItem(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        CreativeTabRegistry.misc.add(i);
        return i;
    }
    private static DeferredItem<Item> registerTool(String registryId) {
        DeferredItem<Item> i = ITEMS.register(registryId, () -> new ItemMod());
        CreativeTabRegistry.tools.add(i);
        return i;
    }
    private static <T extends Item> DeferredItem<T> registerTool(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        CreativeTabRegistry.tools.add(i);
        return i;
    }
    private static <T extends Item> DeferredItem<T> registerThrowableItem(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        CreativeTabRegistry.misc.add(i);
        DISPENSER_ITEMS.add(i);
        return i;
    }
    private static <T extends Item> DeferredItem<T> registerThrowableTool(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        CreativeTabRegistry.tools.add(i);
        DISPENSER_ITEMS.add(i);
        return i;
    }
    private static <T extends Item> DeferredItem<T> registerBlockItem(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        CreativeTabRegistry.blocks.add(i);
        return i;
    }
}