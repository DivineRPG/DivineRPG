package divinerpg.registries;

import divinerpg.items.arcana.ItemCollector;
import divinerpg.items.arcana.ItemFirestock;
import divinerpg.items.base.*;
import divinerpg.items.iceika.ItemEggNog;
import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.items.vanilla.ItemHealingStone;
import divinerpg.items.vanilla.ItemTomato;
import divinerpg.utils.FoodList;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.RarityList;
import divinerpg.utils.ToolStats;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.DivineRegistries.ITEMS;
import static divinerpg.registries.SoundRegistry.*;
import static divinerpg.registries.TagRegistry.*;

public class ItemRegistry {
    //For creative tabs
    public static final List<DeferredItem<? extends Item>> blocks = new ArrayList<>();
    public static final List<DeferredItem<? extends Item>> tools = new ArrayList<>();
    public static final List<DeferredItem<? extends Item>> misc = new ArrayList<>();

    //Items
    public static final DeferredItem<Item> realmite_nugget = register("realmite_nugget");
    public static final DeferredItem<Item> arlemite_nugget = register("arlemite_nugget");
    public static final DeferredItem<Item> rupee_nugget = register("rupee_nugget");
    public static final DeferredItem<Item> torridite_nugget = register("torridite_nugget");
    public static final DeferredItem<Item> oxdrite_nugget = register("oxdrite_nugget");
    public static final DeferredItem<Item> pieceOfRawArcanium = register("piece_of_raw_arcanium");

    public static final DeferredItem<Item> aquatic_pellets = register("aquatic_pellets");
    public static final DeferredItem<Item> pure_aquatic_pellets = register("pure_aquatic_pellets");
    public static final DeferredItem<Item> aquatic_ingot = register("aquatic_ingot");
    public static final DeferredItem<Item> realmite_ingot = register("realmite_ingot");
    public static final DeferredItem<Item> arlemite_ingot = register("arlemite_ingot");
    public static final DeferredItem<Item> rupee_ingot = register("rupee_ingot");
    public static final DeferredItem<Item> shadow_bar = register("shadow_bar");
    public static final DeferredItem<Item> torridite_ingot = register("torridite_ingot");
    public static final DeferredItem<Item> hellstone_ingot = register("hellstone_ingot");
    public static final DeferredItem<Item> oxdrite_ingot = register("oxdrite_ingot");

    public static final DeferredItem<Item> rock_chunks = register("rock_chunks");
    public static final DeferredItem<Item> bedrock_chunk = register("bedrock_chunk", properties -> new ItemMod(properties.fireResistant()));
    public static final DeferredItem<Item> torridite_chunk = register("torridite_chunk");
    public static final DeferredItem<Item> anthracite = register("anthracite");

    public static final DeferredItem<Item> bloodgem = register("bloodgem");
    public static final DeferredItem<Item> olivine = register("olivine");
    public static final DeferredItem<Item> arcanium = register("arcanium");


    public static final DeferredItem<Item> eden_fragments = register("eden_fragments");
    public static final DeferredItem<Item> wildwood_fragments = register("wildwood_fragments");
    public static final DeferredItem<Item> apalachia_fragments = register("apalachia_fragments");
    public static final DeferredItem<Item> skythern_fragments = register("skythern_fragments");
    public static final DeferredItem<Item> mortum_fragments = register("mortum_fragments");
    public static final DeferredItem<Item> collector_fragments = register("collector_fragments");
    public static final DeferredItem<Item> collector = register("collector", ItemCollector::new);

    public static final DeferredItem<Item> raw_realmite = register("raw_realmite");
    public static final DeferredItem<Item> raw_arlemite = register("raw_arlemite");
    public static final DeferredItem<Item> raw_rupee = register("raw_rupee");
    public static final DeferredItem<Item> raw_torridite = register("raw_torridite");
    public static final DeferredItem<Item> raw_oxdrite = register("raw_oxdrite");

    public static final DeferredItem<Item> crushed_raw_realmite = register("crushed_raw_realmite");
    public static final DeferredItem<Item> crushed_raw_arlemite = register("crushed_raw_arlemite");
    public static final DeferredItem<Item> crushed_raw_rupee = register("crushed_raw_rupee");
    public static final DeferredItem<Item> crushed_raw_torridite = register("crushed_raw_torridite");
    public static final DeferredItem<Item> crushed_raw_oxdrite = register("crushed_raw_oxdrite");

    public static final DeferredItem<Item> realmite_dust = register("realmite_dust");
    public static final DeferredItem<Item> arlemite_dust = register("arlemite_dust");
    public static final DeferredItem<Item> rupee_dust = register("rupee_dust");
    public static final DeferredItem<Item> shadow_dust = register("shadow_dust");
    public static final DeferredItem<Item> bloodgem_dust = register("bloodgem_dust");
    public static final DeferredItem<Item> torridite_dust = register("torridite_dust");
    public static final DeferredItem<Item> oxdrite_dust = register("oxdrite_dust");
    public static final DeferredItem<Item> eden_dust = register("eden_dust");
    public static final DeferredItem<Item> wildwood_dust = register("wildwood_dust");
    public static final DeferredItem<Item> apalachia_dust = register("apalachia_dust");
    public static final DeferredItem<Item> skythern_dust = register("skythern_dust");
    public static final DeferredItem<Item> mortum_dust = register("mortum_dust");

    public static final DeferredItem<Item> purple_blaze = register("purple_blaze");
    public static final DeferredItem<Item> fury_fire = register("fury_fire");
    public static final DeferredItem<Item> eden_sparkles = register("eden_sparkles");

    public static final DeferredItem<Item> shadow_coins = register("shadow_coins");
    public static final DeferredItem<Item> snowflake = register("snowflake");
    public static final DeferredItem<Item> dungeon_tokens = register("dungeon_tokens");
    public static final DeferredItem<Item> bedrock_upgrade_template = register("bedrock_upgrade_template", properties -> ItemSmithingTemplate.createBedrockUpgrade());
    public static final DeferredItem<Item> aquatic_coating_template = register("aquatic_coating_template", properties -> ItemSmithingTemplate.createAquaticCoating());
    public static final DeferredItem<Item> color_template = register("color_template", properties -> ItemSmithingTemplate.createColorTemplate());

    public static final DeferredItem<Item> red_diamond_chunk = register("red_diamond_chunk");
    public static final DeferredItem<Item> yellow_diamond_chunk = register("yellow_diamond_chunk");
    public static final DeferredItem<Item> green_diamond_chunk = register("green_diamond_chunk");
    public static final DeferredItem<Item> blue_diamond_chunk = register("blue_diamond_chunk");
    public static final DeferredItem<Item> gray_diamond_chunk = register("gray_diamond_chunk");

    public static final DeferredItem<Item> ice_shards = register("ice_shards");
    public static final DeferredItem<Item> terran_shards = register("terran_shards");
    public static final DeferredItem<Item> jungle_shards = register("jungle_shards");
    public static final DeferredItem<Item> molten_shards = register("molten_shards", properties -> new ItemMod(properties.fireResistant()));
    public static final DeferredItem<Item> corrupted_shards = register("corrupted_shards");
    public static final DeferredItem<Item> ender_shards = register("ender_shards");
    public static final DeferredItem<Item> divine_shards = register("divine_shards");

    public static final DeferredItem<Item> shadow_stone = register("shadow_stone", properties -> new ItemMod(properties.fireResistant()));
    public static final DeferredItem<Item> ice_stone = register("ice_stone");
    public static final DeferredItem<Item> terran_stone = register("terran_stone");
    public static final DeferredItem<Item> jungle_stone = register("jungle_stone");
    public static final DeferredItem<Item> molten_stone = register("molten_stone", properties -> new ItemMod(properties.fireResistant()));
    public static final DeferredItem<Item> soulfire_stone = register("soulfire_stone");
    public static final DeferredItem<Item> corrupted_stone = register("corrupted_stone");
    public static final DeferredItem<Item> ender_stone = register("ender_stone");
    public static final DeferredItem<Item> divine_stone = register("divine_stone");

    public static final DeferredItem<Item> eden_gem = register("eden_gem");
    public static final DeferredItem<Item> wildwood_gem = register("wildwood_gem");
    public static final DeferredItem<Item> apalachia_gem = register("apalachia_gem");
    public static final DeferredItem<Item> skythern_gem = register("skythern_gem");
    public static final DeferredItem<Item> mortum_gem = register("mortum_gem");

    public static final DeferredItem<Item> eden_chunk = register("eden_chunk");
    public static final DeferredItem<Item> wildwood_chunk = register("wildwood_chunk");
    public static final DeferredItem<Item> apalachia_chunk = register("apalachia_chunk");
    public static final DeferredItem<Item> skythern_chunk = register("skythern_chunk");
    public static final DeferredItem<Item> mortum_chunk = register("mortum_chunk");

    public static final DeferredItem<Item> teaker_lump = register("teaker_lump");
    public static final DeferredItem<Item> amthirmis_lump = register("amthirmis_lump");
    public static final DeferredItem<Item> darven_lump = register("darven_lump");
    public static final DeferredItem<Item> cermile_lump = register("cermile_lump");
    public static final DeferredItem<Item> pardimal_lump = register("pardimal_lump");
    public static final DeferredItem<Item> quadrotic_lump = register("quadrotic_lump");
    public static final DeferredItem<Item> karos_lump = register("karos_lump");
    public static final DeferredItem<Item> heliosis_lump = register("heliosis_lump");
    public static final DeferredItem<Item> arksiane_lump = register("arksiane_lump");

    public static final DeferredItem<Item> dirty_pearls = register("dirty_pearls");
    public static final DeferredItem<Item> clean_pearls = register("clean_pearls");
    public static final DeferredItem<Item> polished_pearls = register("polished_pearls");
    public static final DeferredItem<Item> shiny_pearls = register("shiny_pearls");

    public static final DeferredItem<Item> cyclops_eye_shards = register("cyclops_eye_shards");
    public static final DeferredItem<Item> cyclops_eye = register("cyclops_eye");
    public static final DeferredItem<Item> watching_eye = register("watching_eye");
    public static final DeferredItem<Item> legendary_ender_eye = register("legendary_ender_eye");

    public static final DeferredItem<Item> crab_claw = register("crab_claw");
    public static final DeferredItem<Item> shark_fin = register("shark_fin");
    public static final DeferredItem<Item> whale_fin = register("whale_fin");
    public static final DeferredItem<Item> liopleurodon_teeth = register("liopleurodon_teeth");
    public static final DeferredItem<Item> liopleurodon_skull = register("liopleurodon_skull");
    public static final DeferredItem<Item> aqua_ball = register("aqua_ball");
    public static final DeferredItem<Item> aquatic_blaze_rod = register("aquatic_blaze_rod");
    public static final DeferredItem<Item> kraken_scale = register("kraken_scale");
    public static final DeferredItem<Item> kraken_skin = register("kraken_skin");
    public static final DeferredItem<Item> seng_fur = register("seng_fur");
    public static final DeferredItem<Item> sabear_fur = register("sabear_fur");
    public static final DeferredItem<Item> sabear_tooth = register("sabear_tooth");
    public static final DeferredItem<Item> blubber = register("blubber");
    public static final DeferredItem<Item> acid = register("acid");

    public static final DeferredItem<Item> firestock = register("firestock", ItemFirestock::new);
    public static final DeferredItem<Item> marsine = register("marsine");

    public static final DeferredItem<Item> eden_soul = register("eden_soul");
    public static final DeferredItem<Item> wildwood_soul = register("wildwood_soul");
    public static final DeferredItem<Item> apalachia_soul = register("apalachia_soul");
    public static final DeferredItem<Item> skythern_soul = register("skythern_soul");
    public static final DeferredItem<Item> mortum_soul = register("mortum_soul");

    public static final DeferredItem<Item> eden_heart = register("eden_heart");
    public static final DeferredItem<Item> wildwood_heart = register("wildwood_heart");
    public static final DeferredItem<Item> apalachia_heart = register("apalachia_heart");
    public static final DeferredItem<Item> skythern_heart = register("experienced_cori_heart");
    public static final DeferredItem<Item> mortum_heart = register("mortum_heart");

    public static final DeferredItem<Item> base_spawn_crystal = register("base_spawn_crystal");

    public static final DeferredItem<Item> backsword_template = register("backsword_template");
    public static final DeferredItem<Item> hammer_template = register("hammer_template");
    public static final DeferredItem<Item> claw_template = register("claw_template");
    public static final DeferredItem<Item> bow_template = register("bow_template");
    public static final DeferredItem<Item> staff_template = register("staff_template");
    public static final DeferredItem<Item> cannon_template = register("cannon_template");
    public static final DeferredItem<Item> disk_template = register("disk_template");
    public static final DeferredItem<Item> dissipator_template = register("dissipator_template");
    public static final DeferredItem<Item> degraded_template = register("degraded_template");
    public static final DeferredItem<Item> finished_template = register("finished_template");
    public static final DeferredItem<Item> glistening_template = register("glistening_template");
    public static final DeferredItem<Item> demonized_template = register("demonized_template");
    public static final DeferredItem<Item> tormented_template = register("tormented_template");

    public static final DeferredItem<Item> bacon = register("bacon", properties -> new ItemModFood(FoodList.BACON, properties));
    public static final DeferredItem<Item> cooked_bacon = register("cooked_bacon", properties -> new ItemModFood(FoodList.COOKED_BACON, properties));
    public static final DeferredItem<Item> boiled_egg = register("boiled_egg", properties -> new ItemModFood(FoodList.BOILED_EGG, properties));
    public static final DeferredItem<Item> cheese = register("cheese", properties -> new ItemModFood(FoodList.CHEESE, properties));
    public static final DeferredItem<Item> donut = register("donut", properties -> new ItemModFood(FoodList.DONUT, properties));
    public static final DeferredItem<Item> hot_pumpkin_pie = register("hot_pumpkin_pie", properties -> new ItemModFoodEffect(FoodList.HOT_PUMPKIN_PIE, properties));
    public static final DeferredItem<Item> tomato = registerThrowableItem("tomato", ItemTomato::new);
    public static final DeferredItem<Item> white_mushroom = register("white_mushroom", properties -> new ItemModFood(FoodList.WHITE_MUSHROOM, properties));
    public static final DeferredItem<Item> advanced_mushroom_stew = register("advanced_mushroom_stew", properties -> new ItemModFoodEffect(true, FoodList.ADVANCED_MUSHROOM_STEW, properties));
    public static final DeferredItem<Item> chicken_dinner = register("chicken_dinner", properties -> new ItemModFoodEffect(true, FoodList.CHICKEN_DINNER, properties));
    public static final DeferredItem<Item> robbin_egg = register("robbin_egg");
    public static final DeferredItem<Item> cauldron_flesh = register("cauldron_flesh", properties -> new ItemModFood(FoodList.CAULDRON_FLESH, properties));
    public static final DeferredItem<Item> raw_seng_meat = register("raw_seng_meat", properties -> new ItemModFood(FoodList.RAW_SENG_MEAT, properties));
    public static final DeferredItem<Item> seng_steak = register("seng_steak", properties -> new ItemModFood(FoodList.COOKED_SENG_MEAT, properties));
    public static final DeferredItem<Item> raw_wolpertinger_meat = register("raw_wolpertinger_meat", properties -> new ItemModFood(FoodList.RAW_WOLPERTINGER_MEAT, properties));
    public static final DeferredItem<Item> wolpertinger_steak = register("wolpertinger_steak", properties -> new ItemModFood(FoodList.COOKED_WOLPERTINGER_MEAT, properties));
    public static final DeferredItem<Item> chocolate_log = register("chocolate_log", properties -> new ItemModFood(FoodList.CHOCOLATE_LOG, properties));
    public static final DeferredItem<Item> egg_nog = register("egg_nog", ItemEggNog::new);
    public static final DeferredItem<Item> fruit_cake = register("fruit_cake", properties -> new ItemModFood(FoodList.FRUIT_CAKE, properties));
    public static final DeferredItem<Item> peppermints = register("peppermints", properties -> new ItemModFood(FoodList.PEPPERMINTS, properties));
    public static final DeferredItem<Item> snow_cones = register("snow_cones", properties -> new ItemModFood(FoodList.SNOW_CONES, properties));
    public static final DeferredItem<Item> winterberry = register("winterberry", properties -> createBlockItemWithCustomItemName(Blocks.CAVE_VINES).apply(properties.food(FoodList.WINTERBERRY).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "winterberry")))));
    public static final DeferredItem<Item> hitchak = register("hitchak", properties -> new ItemModFood(FoodList.HITCHAK, properties));
    public static final DeferredItem<Item> lamona = register("lamona", properties -> new ItemModFood(FoodList.LAMONA, properties));
    public static final DeferredItem<Item> pinfly = register("pinfly", properties -> new ItemModFoodEffect(FoodList.PINFLY, properties));
    public static final DeferredItem<Item> veilo = register("veilo", properties -> new ItemModFoodEffect(FoodList.VEILO, properties));
    public static final DeferredItem<Item> raw_empowered_meat = register("raw_empowered_meat", properties -> new ItemModFood(FoodList.RAW_EMPOWERED_MEAT, properties));
    public static final DeferredItem<Item> empowered_meat = register("empowered_meat", properties -> new ItemModFood(FoodList.EMPOWERED_MEAT, properties));
    public static final DeferredItem<Item> magic_meat = register("magic_meat", properties -> new ItemModFood(FoodList.MAGIC_MEAT, true, properties));
    public static final DeferredItem<Item> enriched_magic_meat = register("enriched_magic_meat", properties -> new ItemModFood(FoodList.ENRICHED_MAGIC_MEAT, true, properties));
    public static final DeferredItem<Item> forbidden_fruit = register("forbidden_fruit", properties -> new ItemModFood(FoodList.FORBIDDEN_FRUIT, properties));
    public static final DeferredItem<Item> moonbulb = register("moonbulb", properties -> new ItemModFoodEffect(FoodList.MOONBULB, true, properties));
    public static final DeferredItem<Item> purple_glowbone = register("purple_glowbone", properties -> new ItemModFoodEffect(false, FoodList.PURPLE_GLOWBONE, true, properties));
    public static final DeferredItem<Item> pink_glowbone = register("pink_glowbone", properties -> new ItemModFoodEffect(false, FoodList.PINK_GLOWBONE, true, properties));
    public static final DeferredItem<Item> sky_flower = register("sky_flower", properties -> new ItemModFoodEffect(false, FoodList.SKY_FLOWER, true, properties));
    public static final DeferredItem<Item> honeysuckle = register("honeysuckle", properties -> new ItemModFoodEffect(FoodList.HONEYSUCKLE, properties));
    public static final DeferredItem<Item> honeychunk = register("honeychunk", properties -> new ItemModFoodEffect(FoodList.HONEYCHUNK, properties));
    public static final DeferredItem<Item> dream_carrot = register("dream_carrot", properties -> new ItemModFood(FoodList.DREAM_CARROT, properties));
    public static final DeferredItem<Item> dream_melon = register("dream_melon", properties -> new ItemModFood(FoodList.DREAM_MELON, properties));
    public static final DeferredItem<Item> dream_pie = register("dream_pie", properties -> new ItemModFood(FoodList.DREAM_PIE, properties));
    public static final DeferredItem<Item> dream_cake = register("dream_cake", properties -> new ItemModFood(FoodList.DREAM_CAKE, properties));
    public static final DeferredItem<Item> dream_sweets = register("dream_sweets", properties -> new ItemHealingFood(FoodList.DREAM_SWEETS, properties));
    public static final DeferredItem<Item> dream_sours = register("dream_sours", properties -> new ItemHealingFood(FoodList.DREAM_SOURS, properties));

    //TODO - plant blocks
//    public static final DeferredItem<Item> tomato_seeds = registerSeed("tomato_seeds", BlockRegistry.tomatoPlant);
//    public static final DeferredItem<Item> white_mushroom_seeds = registerSeed("white_mushroom_seeds", BlockRegistry.whiteMushroomPlant);
//    public static final DeferredItem<Item> aquamarine_seeds = registerSeed("aquamarine_seeds", BlockRegistry.aquamarinePlant);
//    public static final DeferredItem<Item> eucalyptus_root_seeds = registerSeed("eucalyptus_root_seeds", BlockRegistry.eucalyptusPlant);
//    public static final DeferredItem<Item> firestock_seeds = registerSeed("firestock_seeds", BlockRegistry.firestockPlant);
//    public static final DeferredItem<Item> hitchak_seeds = registerSeed("hitchak_seeds", BlockRegistry.hitchakPlant);
//    public static final DeferredItem<Item> lamona_seeds = registerSeed("lamona_seeds", BlockRegistry.lamonaPlant);
//    public static final DeferredItem<Item> marsine_seeds = registerSeed("marsine_seeds", BlockRegistry.marsinePlant);
//    public static final DeferredItem<Item> pinfly_seeds = registerSeed("pinfly_seeds", BlockRegistry.pinflyPlant);
//    public static final DeferredItem<Item> veilo_seeds = registerSeed("veilo_seeds", BlockRegistry.veiloPlant);
//    public static final DeferredItem<Item> moonbulb_seeds = registerSeed("moonbulb_seeds", BlockRegistry.moonbulbPlant);
//    public static final DeferredItem<Item> pink_glowbone_seeds = registerSeed("pink_glowbone_seeds", BlockRegistry.pinkGlowbonePlant);
//    public static final DeferredItem<Item> purple_glowbone_seeds = registerSeed("purple_glowbone_seeds", BlockRegistry.purpleGlowbonePlant);
//    public static final DeferredItem<Item> sky_plant_seeds = registerSeed("sky_plant_seeds", BlockRegistry.skyPlant);

    public static final DeferredItem<Item> snapper_egg = registerEgg("snapper_spawn_egg", () -> EntityRegistry.SNAPPER.get());
    public static final DeferredItem<Item> ehu_egg = registerEgg("ehu_spawn_egg", () -> EntityRegistry.EHU.get());
    public static final DeferredItem<Item> husk_egg = registerEgg("husk_spawn_egg", () -> EntityRegistry.HUSK.get());
    public static final DeferredItem<Item> brown_grizzle_egg = registerEgg("brown_grizzle_spawn_egg", () -> EntityRegistry.BROWN_GRIZZLE.get());
    public static final DeferredItem<Item> white_grizzle_egg = registerEgg("white_grizzle_spawn_egg", () -> EntityRegistry.WHITE_GRIZZLE.get());
    public static final DeferredItem<Item> stone_golem_egg = registerEgg("stone_golem_spawn_egg", () -> EntityRegistry.STONE_GOLEM.get());
    public static final DeferredItem<Item> smelter_egg = registerEgg("smelter_spawn_egg", () -> EntityRegistry.SMELTER.get());
    public static final DeferredItem<Item> fyracryx_egg = registerEgg("fyracryx_spawn_egg", () -> EntityRegistry.FYRACRYX.get());
    public static final DeferredItem<Item> golem_of_rejuvenation_egg = registerEgg("golem_of_rejuvenation_spawn_egg", () -> EntityRegistry.GOLEM_OF_REJUVENATION.get());
    public static final DeferredItem<Item> paratiku_egg = registerEgg("paratiku_spawn_egg", () -> EntityRegistry.PARATIKU.get());
    public static final DeferredItem<Item> seimer_egg = registerEgg("seimer_spawn_egg", () -> EntityRegistry.SEIMER.get());

    public static final DeferredItem<Item> divine_accumulator = register("divine_accumulator"/*, properties -> new ItemDivineAccumulator(properties)*/);
    public static final DeferredItem<Item> ender_scepter = register("ender_scepter"/*, properties -> new ItemEnderScepter(properties)*/);
    public static final DeferredItem<Item> ghostbane = register("ghostbane"/*, properties -> new ItemGhostbane(properties)*/);
    public static final DeferredItem<Item> staff_of_enrichment = register("staff_of_enrichment"/*, properties -> new ItemStaffEnrichment(properties)*/);
    public static final DeferredItem<Item> arcanium_attractor = register("arcanium_attractor", props -> new ItemRangedWeapon(props, EntityRegistry.ATTRACTOR_BEAM::get).withTooltip(LocalizeUtils.pull()).withSound(SoundEvents.ARROW_SHOOT).arcanaUse(20).withPower(6));
    public static final DeferredItem<Item> arcanium_reflector = register("arcanium_reflector", props -> new ItemRangedWeapon(props, EntityRegistry.REFLECTOR_BEAM::get).withTooltip(LocalizeUtils.push()).withSound(SoundEvents.ARROW_SHOOT).arcanaUse(20).withPower(6));
    public static final DeferredItem<Item> aquamarine = register("aquamarine"/*, properties -> new ItemAquamarine(properties)*/);

    public static final DeferredItem<Item> cauldron_fish_bucket = register("cauldron_fish_bucket", properties -> new MobBucketItem(EntityRegistry.CAULDRON_FISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));
    public static final DeferredItem<Item> gem_fin_bucket = register("gem_fin_bucket", properties -> new MobBucketItem(EntityRegistry.GEM_FIN.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, properties.stacksTo(1)));
    public static final DeferredItem<Item> smoldering_tar_bucket = register("smoldering_tar_bucket", properties -> new BucketItem(Fluids.LAVA, properties.craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final DeferredItem<Item> inserter_minecart = register("inserter_minecart"/*, properties -> new ItemInserterMinecart(properties)*/);

    public static final DeferredItem<Item> snow_globe = register("snow_globe"/*, properties -> new ItemSnowGlobe(properties)*/);
    public static final DeferredItem<Item> frozen_clock = register("frozen_clock"/*, properties -> new ItemFrozenClock(properties)*/);

    public static final DeferredItem<Item> mysterious_clock = register("mysterious_clock"/*, properties -> new ItemBossSpawner("item.overworld_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> call_of_the_watcher = register("call_of_the_watcher"/*, properties -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> infernal_flame = register("infernal_flame"/*, properties -> new ItemBossSpawner("item.nether_only", Level.NETHER, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> horde_horn = register("horde_horn"/*, properties -> new ItemHordeHorn(properties)*/);
    public static final DeferredItem<Item> wizards_book = register("wizards_book"/*, properties -> new ItemWizardsBook(properties)*/);
    public static final DeferredItem<Item> vamacheron_crystal = register("vamacheron_crystal"/*, properties -> new ItemBossSpawner("item.mortum_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> karot_crystal = register("karot_crystal"/*, properties -> new ItemBossSpawner("item.mortum_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> twilight_demon_crystal = register("twilight_demon_crystal"/*, properties -> new ItemBossSpawner("item.mortum_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> densos_crystal = register("densos_crystal"/*, properties -> new ItemBossSpawner("item.mortum_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> reyvor_crystal = register("reyvor_crystal"/*, properties -> new ItemBossSpawner("item.mortum_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> soul_fiend_crystal = register("soul_fiend_crystal"/*, properties -> new ItemBossSpawner("item.mortum_only", Level.OVERWORLD, EntityType.ZOMBIE, properties)*/);
    public static final DeferredItem<Item> dream_flint = register("dream_flint"/*, properties -> new ItemDreamFlint(properties)*/);
    public static final DeferredItem<Item> moon_clock = register("moon_clock"/*, properties -> new ItemVethean(properties.stacksTo(1))*/);

    public static final DeferredItem<Item> jungle_hook = register("jungle_hook"/*, properties -> new ItemJungleHook(properties)*/);
    public static final DeferredItem<Item> teleportation_crystal = register("teleportation_crystal"/*, properties -> new ItemTeleportationCrystal(properties)*/);
    public static final DeferredItem<Item> teleportation_star = register("teleportation_star"/*, properties -> new ItemTeleportationStar(properties)*/);
    public static final DeferredItem<Item> orb_of_light = register("orb_of_light");
    public static final DeferredItem<Item> weak_arcana_potion = register("weak_arcana_potion"/*, properties -> new ItemArcanaPotion(FoodList.WEAK_ARCANA_POTION, 100, properties)*/);
    public static final DeferredItem<Item> strong_arcana_potion = register("strong_arcana_potion"/*, properties -> new ItemArcanaPotion(FoodList.STRONG_ARCANA_POTION, 200, properties)*/);
    public static final DeferredItem<Item> heat_pack = register("heat_pack"/*, properties -> new ItemHeatPack(properties)*/);
    public static final DeferredItem<Item> glacial_wall_totem = register("glacial_wall_totem", properties -> new ItemMod(properties.stacksTo(1)));
    public static final DeferredItem<Item> miners_amulet = register("miners_amulet"/*, properties -> new ItemMinersAmulet(properties)*/);
    public static final DeferredItem<Item> band_of_lheiva_hunting = register("band_of_lheiva_hunting"/*, properties -> new ItemVethean(properties.stacksTo(1))*/);

    public static final DeferredItem<Item> md_red_stains = register("md_red_stains_on_the_bluest_snow", properties -> new ItemMod(properties.stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(RED_STAINS_SONG.getKey())));
    public static final DeferredItem<Item> md_destiny = register("md_destiny", properties -> new ItemMod(properties.stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(SoundRegistry.DESTINY_SONG.getKey())));

    public static final DeferredItem<Item> ancient_key = register("ancient_key");
    public static final DeferredItem<Item> degraded_key = register("degraded_key");
    public static final DeferredItem<Item> sludge_key = register("sludge_key");
    public static final DeferredItem<Item> soul_key = register("soul_key");

    public static final DeferredItem<Item> armor_pouch = register("armor_pouch"/*, properties -> new ItemArmorPouch(16777215, properties)*/);
    public static final DeferredItem<Item> red_armor_pouch = register("red_armor_pouch"/*, properties -> new ItemArmorPouch(16733525, properties)*/);
    public static final DeferredItem<Item> yellow_armor_pouch = register("yellow_armor_pouch"/*, properties -> new ItemArmorPouch(16777045, properties)*/);
    public static final DeferredItem<Item> green_armor_pouch = register("green_armor_pouch"/*, properties -> new ItemArmorPouch(5635925, properties)*/);
    public static final DeferredItem<Item> blue_armor_pouch = register("blue_armor_pouch"/*, properties -> new ItemArmorPouch(5592575, properties)*/);
    public static final DeferredItem<Item> gray_armor_pouch = register("gray_armor_pouch"/*, properties -> new ItemArmorPouch(11184810, properties)*/);
    public static final DeferredItem<Item>
        cyclopsian_sword = registerSword("cyclopsian_sword", ToolStats.CYCLOPSIAN_SWORD, Rarity.COMMON, false),
        slime_sword      = registerSword("slime_sword", ToolStats.SLIME_SWORD, Rarity.COMMON, false),
        glacier_sword    = registerSword("glacier_sword", ToolStats.GLACIER_SWORD, Rarity.COMMON, false),
        crabclaw_maul    = registerMaul("crabclaw_maul", ToolStats.CRABCLAW_MAUL, Rarity.COMMON, false),
        dual_claw        = registerSword("dual_claw", ToolStats.DUAL_CLAW, Rarity.COMMON, false),
        shark_sword      = registerSword("shark_sword", ToolStats.SHARK_SWORD, Rarity.COMMON, false),
        aquatooth_sword  = registerSword("aquatooth_sword", ToolStats.AQUATOOTH_SWORD, Rarity.COMMON, false),
        aquatooth_maul   = registerMaul("aquatooth_maul", ToolStats.AQUATOOTH_MAUL, Rarity.COMMON, false),
        aquatic_dagger   = registerSword("aquatic_dagger", ToolStats.AQUA_DAGGER, Rarity.COMMON, false),
        ocean_knife      = registerSword("ocean_knife", ToolStats.OCEAN_KNIFE, Rarity.COMMON, false),
        aquatic_trident  = registerSword("aquatic_trident", ToolStats.AQUA_TRIDENT, Rarity.COMMON, false),
        aquaton          = registerSword("aquaton", ToolStats.AQUATON, Rarity.COMMON, false),
        aquatic_maul     = registerMaul("aquatic_maul", ToolStats.AQUA_MAUL, Rarity.COMMON, false),
        realmite_sword   = registerSword("realmite_sword", ToolStats.REALMITE_SWORD, Rarity.COMMON, false),
        realmite_maul    = registerMaul("realmite_maul", ToolStats.REALMITE_MAUL, Rarity.COMMON, false),
        arlemite_stabber = registerSword("arlemite_stabber", ToolStats.ARLEMITE_STABBER, Rarity.COMMON, false),
        rupee_rapier     = registerSword("rupee_rapier", ToolStats.RUPEE_RAPIER, Rarity.COMMON, false),
        bedrock_sword    = registerSword("bedrock_sword", ToolStats.BEDROCK_SWORD, Rarity.COMMON, true),
        bedrock_maul     = registerMaul("bedrock_maul", ToolStats.BEDROCK_MAUL, Rarity.COMMON, true),
        frozen_maul      = registerMaul("frozen_maul", ToolStats.FROZEN_MAUL, Rarity.COMMON, true),
        fury_maul        = registerMaul("fury_maul", ToolStats.FURY_MAUL, Rarity.COMMON, true),
        death_bringer    = registerSword("death_bringer", ToolStats.DEATH_BRINGER, Rarity.COMMON, false),
        corrupted_maul   = registerMaul("corrupted_maul", ToolStats.CORRUPTED_MAUL, Rarity.COMMON, false),
        terran_dagger    = registerSword("terran_dagger", ToolStats.TERRAN_DAGGER, Rarity.COMMON, false),
        terran_knife     = registerSword("terran_knife", ToolStats.TERRAN_KNIFE, Rarity.COMMON, false),
        terran_maul      = registerMaul("terran_maul", ToolStats.TERRAN_MAUL, Rarity.COMMON, false),
        jungle_knife     = registerSword("jungle_knife", ToolStats.JUNGLE_KNIFE, Rarity.COMMON, false),
        jungle_rapier    = registerSword("jungle_rapier", ToolStats.JUNGLE_RAPIER, Rarity.COMMON, false),
        poison_saber     = registerSword("poison_saber", ToolStats.POISON_SABER, Rarity.COMMON, false),
        bloodgem_sword   = registerSword("bloodgem_sword", ToolStats.BLOODGEM_SWORD, Rarity.COMMON, false),
        molten_sword     = registerSword("molten_sword", ToolStats.MOLTEN_SWORD, Rarity.COMMON, true),
        scorching_sword  = registerSword("scorching_sword", ToolStats.SCORCHING_SWORD, Rarity.COMMON, false),
        soulfire_sword   = registerSword("soulfire_sword", ToolStats.SOULFIRE_SWORD, Rarity.COMMON, false),
        inferno_sword    = registerSword("inferno_sword", ToolStats.INFERNO_SWORD, Rarity.COMMON, true),
        flaming_fury     = registerSword("flaming_fury", ToolStats.FLAMING_FURY, Rarity.COMMON, true),
        sabear_sabre        = registerSword("sabear_sabre", ToolStats.SABEAR_SABRE, Rarity.COMMON, false),
        frost_sword         = registerSword("frost_sword", ToolStats.FROST_SWORD, Rarity.COMMON, false),
        frostking_sword     = registerSword("frostking_sword", ToolStats.FROSTKING_SWORD, Rarity.COMMON, false),
        icicle_bane         = registerSword("icicle_bane", ToolStats.ICICLE_BANE, RarityList.ICICLE, false),
        glacial_blade       = registerSword("glacial_blade", ToolStats.GLACIAL_BLADE, RarityList.ICICLE, false),
        icicle_dagger       = registerSword("icicle_dagger", ToolStats.ICICLE_DAGGER, RarityList.ICICLE, false),
        ender_sword         = registerSword("ender_sword", ToolStats.ENDER_SWORD, RarityList.ENDER, false),
        red_ender_sword     = registerSword("red_ender_sword", ToolStats.ENDER_SWORD, RarityList.RED, false),
        yellow_ender_sword  = registerSword("yellow_ender_sword", ToolStats.ENDER_SWORD, RarityList.YELLOW, false),
        green_ender_sword   = registerSword("green_ender_sword", ToolStats.ENDER_SWORD, RarityList.GREEN, false),
        blue_ender_sword    = registerSword("blue_ender_sword", ToolStats.ENDER_SWORD, RarityList.BLUE, false),
        black_ender_sword   = registerSword("black_ender_sword", ToolStats.ENDER_SWORD, RarityList.DARK_GRAY, false),
        enderice            = registerSword("enderice", ToolStats.ENDERICE, Rarity.COMMON, false),
        divine_sword        = registerSword("divine_sword", ToolStats.DIVINE_SWORD, RarityList.DIVINE, false),
        red_divine_sword    = registerSword("red_divine_sword", ToolStats.DIVINE_SWORD, RarityList.RED, false),
        yellow_divine_sword = registerSword("yellow_divine_sword", ToolStats.DIVINE_SWORD, RarityList.YELLOW, false),
        green_divine_sword  = registerSword("green_divine_sword", ToolStats.DIVINE_SWORD, RarityList.GREEN, false),
        blue_divine_sword   = registerSword("blue_divine_sword", ToolStats.DIVINE_SWORD, RarityList.BLUE, false),
        gray_divine_sword   = registerSword("gray_divine_sword", ToolStats.DIVINE_SWORD, RarityList.GRAY, false),
        icine_sword        = registerSword("icine_sword", ToolStats.ICINE_SWORD, Rarity.COMMON, false),
        sandslash          = registerSword("sandslash", ToolStats.SANDSLASH, Rarity.COMMON, false),
        snowslash          = registerSword("snowslash", ToolStats.SNOWSLASH, Rarity.COMMON, false),
        livicia_sword      = registerSword("livicia_sword", ToolStats.LIVICIA_SWORD, Rarity.COMMON, false),
        eden_blade         = registerSword("eden_blade", ToolStats.EDEN_BLADE, RarityList.EDEN, false),
        wildwood_blade     = registerSword("wildwood_blade", ToolStats.WILDWOOD_BLADE, RarityList.WILDWOOD, false),
        apalachia_blade    = registerSword("apalachia_blade", ToolStats.APALACHIA_BLADE, RarityList.APALACHIA, false),
        skythern_blade     = registerSword("skythern_blade", ToolStats.SKYTHERN_BLADE, RarityList.SKYTHERN, false),
        mortum_blade       = registerSword("mortum_blade", ToolStats.MORTUM_BLADE, RarityList.MORTUM, false),
        halite_blade       = registerSword("halite_blade", ToolStats.HALITE_BLADE, RarityList.HALITE, false),
        teaker_backsword    = registerSword("teaker_backsword", ToolStats.TEAKER_BACKSWORD, Rarity.COMMON, false),
        amthirmis_backsword = registerSword("amthirmis_backsword", ToolStats.AMTHIRMIS_BACKSWORD, Rarity.COMMON, false),
        darven_backsword    = registerSword("darven_backsword", ToolStats.DARVEN_BACKSWORD, Rarity.COMMON, false),
        cermile_backsword   = registerSword("cermile_backsword", ToolStats.CERMILE_BACKSWORD, Rarity.COMMON, false),
        pardimal_backsword  = registerSword("pardimal_backsword", ToolStats.PARDIMAL_BACKSWORD, Rarity.COMMON, false),
        quadrotic_backsword = registerSword("quadrotic_backsword", ToolStats.QUADROTIC_BACKSWORD, Rarity.COMMON, false),
        karos_backsword     = registerSword("karos_backsword", ToolStats.KAROS_BACKSWORD, Rarity.COMMON, false),
        heliosis_backsword  = registerSword("heliosis_backsword", ToolStats.HELIOSIS_BACKSWORD, Rarity.COMMON, false),
        arksiane_backsword  = registerSword("arksiane_backsword", ToolStats.ARKSIANE_BACKSWORD, Rarity.COMMON, false),
        teaker_hammer      = registerSword("teaker_hammer", ToolStats.TEAKER_HAMMER, Rarity.COMMON, false),
        amthirmis_hammer   = registerSword("amthirmis_hammer", ToolStats.AMTHIRMIS_HAMMER, Rarity.COMMON, false),
        darven_hammer      = registerSword("darven_hammer", ToolStats.DARVEN_HAMMER, Rarity.COMMON, false),
        cermile_hammer     = registerSword("cermile_hammer", ToolStats.CERMILE_HAMMER, Rarity.COMMON, false),
        pardimal_hammer    = registerSword("pardimal_hammer", ToolStats.PARDIMAL_HAMMER, Rarity.COMMON, false),
        quadrotic_hammer   = registerSword("quadrotic_hammer", ToolStats.QUADROTIC_HAMMER, Rarity.COMMON, false),
        karos_hammer       = registerSword("karos_hammer", ToolStats.KAROS_HAMMER, Rarity.COMMON, false),
        heliosis_hammer    = registerSword("heliosis_hammer", ToolStats.HELIOSIS_HAMMER, Rarity.COMMON, false),
        arksiane_hammer    = registerSword("arksiane_hammer", ToolStats.ARKSIANE_HAMMER, Rarity.COMMON, false),
        everlight          = registerSword("everlight", ToolStats.EVERLIGHT, Rarity.COMMON, false),
        karos_rockmaul     = registerMaul("karos_rockmaul", ToolStats.KAROS_ROCKMAUL, Rarity.COMMON, false),
        teaker_claw        = registerSword("teaker_claw", ToolStats.TEAKER_CLAW, Rarity.COMMON, false),
        amthirmis_claw     = registerSword("amthirmis_claw", ToolStats.AMTHIRMIS_CLAW, Rarity.COMMON, false),
        darven_claw        = registerSword("darven_claw", ToolStats.DARVEN_CLAW, Rarity.COMMON, false),
        cermile_claw       = registerSword("cermile_claw", ToolStats.CERMILE_CLAW, Rarity.COMMON, false),
        pardimal_claw      = registerSword("pardimal_claw", ToolStats.PARDIMAL_CLAW, Rarity.COMMON, false),
        quadrotic_claw     = registerSword("quadrotic_claw", ToolStats.QUADROTIC_CLAW, Rarity.COMMON, false),
        karos_claw         = registerSword("karos_claw", ToolStats.KAROS_CLAW, Rarity.COMMON, false),
        heliosis_claw      = registerSword("heliosis_claw", ToolStats.HELIOSIS_CLAW, Rarity.COMMON, false),
        arksiane_claw      = registerSword("arksiane_claw", ToolStats.ARKSIANE_CLAW, Rarity.COMMON, false),
        everbright         = registerSword("everbright", ToolStats.EVERBRIGHT, Rarity.COMMON, false),
        realmite_shield    = registerShield("realmite_shield", REPAIR_REALMITE, 426, "realmite"),
        arlemite_shield    = registerShield("arlemite_shield", REPAIR_ARLEMITE, 734, "arlemite"),
        rupee_shield       = registerShield("rupee_shield", REPAIR_RUPEE, 823, "rupee"),
        eden_shield        = registerShield("eden_shield", RarityList.EDEN, REPAIR_EDEN, 978, "eden"),
        wildwood_shield    = registerShield("wildwood_shield", RarityList.WILDWOOD, REPAIR_WILDWOOD, 1125, "wildwood"),
        apalachia_shield   = registerShield("apalachia_shield", RarityList.APALACHIA, REPAIR_APALACHIA, 1256, "apalachia"),
        skythern_shield    = registerShield("skythern_shield", RarityList.SKYTHERN, REPAIR_SKYTHERN, 1485, "skythern"),
        mortum_shield      = registerShield("mortum_shield", RarityList.MORTUM, REPAIR_MORTUM, 1627, "mortum"),
        halite_shield      = registerShield("halite_shield", RarityList.HALITE, REPAIR_HALITE, 0, "halite"),
        serenade_striker     = register("serenade_striker"/*, () -> new ItemSerenadeStriker(new Item.Properties().setId(key("serenade_striker"))) */),
        serenade_of_ice      = register("serenade_of_ice", props -> new ItemRangedWeapon(props, EntityRegistry.ICE_BULLET::value).withSound(SERENADE.get()).withTooltip(LocalizeUtils.slow(5))),
        serenade_of_death    = register("serenade_of_death", props -> new ItemRangedWeapon(props, EntityRegistry.DEATH_BULLET::value).withTooltips(List.of(LocalizeUtils.magicDam(7), LocalizeUtils.poison(2))).withSound(SERENADE.get())),
        serenade_of_health   = register("serenade_of_health"/*, () -> new ItemSerenadeOfHealth(new Item.Properties().setId(key("serenade_of_health"))) */),
        serenade_of_infusion = register("serenade_of_infusion"/*, () -> new ItemSerenadeOfInfusion(new Item.Properties().setId(key("serenade_of_infusion"))) */),
        hunter_arrow    = register("hunter_arrow"/*, () -> new HunterArrowItem(new Item.Properties().setId(key("hunter_arrow"))) */),
        shadow_arrow    = register("shadow_arrow"/*, () -> new ShadowArrowItem(new Item.Properties().setId(key("shadow_arrow"))) */),
        icicle_arrow    = register("icicle_arrow"/*, () -> new IcicleArrowItem(new Item.Properties().setId(key("icicle_arrow"))) */),
        inferno_arrow   = register("inferno_arrow"/*, () -> new InfernoArrowItem(new Item.Properties().setId(key("inferno_arrow"))) */),
        soulfire_arrow  = register("soulfire_arrow"/*, () -> new SoulfireArrowItem(new Item.Properties().setId(key("soulfire_arrow"))) */),
        snowstorm_arrow = register("snowstorm_arrow"/*, () -> new SnowstormArrowItem(new Item.Properties().setId(key("snowstorm_arrow"))) */),
        ender_arrow     = register("ender_arrow"/*, () -> new EnderArrowItem(new Item.Properties().setId(key("ender_arrow"))) */),
        eden_arrow      = register("eden_arrow"/*, () -> new EdenArrowItem(new Item.Properties().setId(key("eden_arrow"))) */),
        wildwood_arrow  = register("wildwood_arrow"/*, () -> new WildwoodArrowItem(new Item.Properties().setId(key("wildwood_arrow"))) */),
        fury_arrow      = register("fury_arrow"/*, () -> new FuryArrowItem(new Item.Properties().setId(key("fury_arrow"))) */),
        teaker_arrow  = register("teaker_arrow"/*, () -> new TeakerArrowItem(new Item.Properties().setId(key("teaker_arrow"))) */),
        darven_arrow  = register("darven_arrow"/*, () -> new DarvenArrowItem(new Item.Properties().setId(key("darven_arrow"))) */),
        pardimal_arrow = register("pardimal_arrow"/*, () -> new PardimalArrowItem(new Item.Properties().setId(key("pardimal_arrow"))) */),
        karos_arrow   = register("karos_arrow"/*, () -> new KarosArrowItem(new Item.Properties().setId(key("karos_arrow"))) */),
        ever_arrow    = register("ever_arrow"/*, () -> new EverArrowItem(new Item.Properties().setId(key("ever_arrow"))) */),
        storm_sword    = register("storm_sword"/*, () -> new ItemStormSword(new Item.Properties().setId(key("storm_sword")))*/),
        shadow_saber   = register("shadow_saber"/*, () -> new ItemShadowSaber(new Item.Properties().setId(key("shadow_saber")).sword(...))*/),
        arcanium_saber = register("arcanium_saber"/*, () -> new ItemModSword(ToolStats.ARCANIUM_SABER, new Item.Properties().setId(key("arcanium_saber")).sword(...)).setAttackArcanaConsumption(25)*/),
        arcanite_blade = register("arcanite_blade"/*, () -> new ItemModSword(ToolStats.ARCANITE_BLADE, new Item.Properties().setId(key("arcanite_blade")).sword(...)).setAttackArcanaConsumption(30)*/),
        hunter_bow = registerTool("hunter_bow"/*, HunterBow::new*/),
        shadow_bow = registerTool("shadow_bow"/*, ShadowBow::new*/),
        icicle_bow = registerTool("icicle_bow"/*, IcicleBow::new*/),
        inferno_bow = registerTool("inferno_bow"/*, InfernoBow::new*/),
        soulfire_bow = registerTool("soulfire_bow"/*, () -> new ItemBow(ToolStats.SOULFIRE_BOW, new Properties(), soulfire_arrow, RarityList.BLUE)*/),
        snowstorm_bow = registerTool("snowstorm_bow"/*, () -> new ItemBow(ToolStats.SNOWSTORM_BOW, new Properties(), snowstorm_arrow, null)*/),
        ender_bow = registerTool("ender_bow"/*, EnderBow::new*/),
        eden_bow = registerTool("eden_bow"/*, () -> new ItemBow(ToolStats.EDEN_BOW, new Properties(), null, RarityList.EDEN)*/),
        wildwood_bow = registerTool("wildwood_bow"/*, () -> new ItemBow(ToolStats.WILDWOOD_BOW, new Properties(), null, RarityList.WILDWOOD)*/),
        apalachia_bow = registerTool("apalachia_bow"/*, () -> new ItemBow(ToolStats.APALACHIA_BOW, new Properties(), null, RarityList.APALACHIA)*/),
        skythern_bow = registerTool("skythern_bow"/*, () -> new ItemBow(ToolStats.SKYTHERN_BOW, new Properties(), null, RarityList.SKYTHERN)*/),
        mortum_bow = registerTool("mortum_bow"/*, () -> new ItemBow(ToolStats.MORTUM_BOW, new Properties(), null, RarityList.MORTUM)*/),
        halite_bow = registerTool("halite_bow"/*, () -> new ItemBow(ToolStats.HALITE_BOW, new Properties(), null, RarityList.HALITE)*/),
        twilight_bow = registerTool("twilight_bow"/*, () -> new ItemBow(ToolStats.TWILIGHT_BOW, new Properties(), null, RarityList.TWILIGHT)*/),
        teaker_bow = registerTool("teaker_bow"/*, () -> new VetheanBow(ToolStats.TEAKER_BOW, null, RarityList.TEAKER)*/),
        amthirmis_bow = registerTool("amthirmis_bow"/*, () -> new VetheanBow(ToolStats.AMTHIRMIS_BOW, null, RarityList.AMTHIRMIS)*/),
        darven_bow = registerTool("darven_bow"/*, () -> new VetheanBow(ToolStats.DARVEN_BOW, null, RarityList.DARVEN)*/),
        cermile_bow = registerTool("cermile_bow"/*, () -> new VetheanBow(ToolStats.CERMILE_BOW, null, RarityList.CERMILE)*/),
        pardimal_bow = registerTool("pardimal_bow"/*, () -> new VetheanBow(ToolStats.PARDIMAL_BOW, null, RarityList.PARDIMAL)*/),
        quadrotic_bow = registerTool("quadrotic_bow"/*, () -> new VetheanBow(ToolStats.QUADROTIC_BOW, null, RarityList.QUADROTIC)*/),
        karos_bow = registerTool("karos_bow"/*, () -> new VetheanBow(ToolStats.KAROS_BOW, null, RarityList.KAROS)*/),
        heliosis_bow = registerTool("heliosis_bow"/*, () -> new VetheanBow(ToolStats.HELIOSIS_BOW, null, RarityList.HELIOSIS)*/),
        arksiane_bow = registerTool("arksiane_bow"/*, () -> new VetheanBow(ToolStats.ARKSIANE_BOW, null, RarityList.ARKSIANE)*/),
        everfright = registerTool("everfright"/*, () -> new VetheanBow(ToolStats.EVERFRIGHT, null, RarityList.EVER)*/),
        crab_anchor = register("crab_anchor"/*, new ItemAnchor(ToolStats.CRAB_ANCHOR, EntityRegistry.CRAB_ANCHOR_SHOT::value, 3, new Item.Properties().setId(key("crab_anchor"))) */),
        shark_anchor = register("shark_anchor"/*, () -> /* new ItemAnchor(ToolStats.SHARK_ANCHOR, EntityRegistry.SHARK_ANCHOR_SHOT::value, 4, new Item.Properties().setId(key("shark_anchor"))) */),
        bowhead_anchor = register("bowhead_anchor"/*, () -> /* new ItemAnchor(ToolStats.BOWHEAD_ANCHOR, EntityRegistry.BOWHEAD_ANCHOR_SHOT::value, 5, new Item.Properties().setId(key("bowhead_anchor"))) */),
        liopleurodon_anchor = register("liopleurodon_anchor"/*, () -> /* new ItemAnchor(ToolStats.LIOPLEURODON_ANCHOR, EntityRegistry.LIOPLEURODON_ANCHOR_SHOT::value, 6, new Item.Properties().setId(key("liopleurodon_anchor"))) */),
        sound_of_music = register("sound_of_music", props -> new ItemRangedWeapon(props.durability(666), EntityRegistry.SOUND_OF_MUSIC::value).withSound(SOUND_OF_MUSIC.get()).withTooltip(LocalizeUtils.magicDam(9)).withCooldown(20)),
        sound_of_carols = register("sound_of_carols", props -> new ItemRangedWeapon(props.durability(1025), EntityRegistry.SOUND_OF_CAROLS::value).withSound(SOUND_OF_CAROLS.get()).withTooltip(LocalizeUtils.magicDam(11)).withCooldown(20)),
        sound_of_whales = register("sound_of_whales", props -> new ItemRangedWeapon(props.durability(1025), EntityRegistry.SOUND_OF_WHALES::value).withSound(WHALE.get()).withTooltip(LocalizeUtils.magicDam(13)).withCooldown(20)),
        shuriken           = register("shuriken"/*, () -> new ItemThrowable(2, new Item.Properties().setId(key("shuriken")))*/),
        snowflake_shuriken = register("snowflake_shuriken"/*, () -> new ItemThrowable(EntityRegistry.SNOWFLAKE_SHURIKEN::value, 3.5F, new Item.Properties().setId(key("snowflake_shuriken"))).withTooltip(LocalizeUtils.slow(2))*/),
        vile_storm         = register("vile_storm"/*, () -> new ItemThrowable(EntityRegistry.VILE_STORM::value, 3.5F, new Item.Properties().setId(key("vile_storm"))).withTooltip(LocalizeUtils.poison(2))*/),
        eden_slicer     = register("eden_slicer"/*, () -> new ItemThrowable(4, new Item.Properties().setId(key("eden_slicer"))).nameColor(RarityList.EDEN)*/),
        wildwood_slicer = register("wildwood_slicer"/*, () -> new ItemThrowable(5, new Item.Properties().setId(key("wildwood_slicer"))).nameColor(RarityList.WILDWOOD)*/),
        apalachia_slicer= register("apalachia_slicer"/*, () -> new ItemThrowable(6, new Item.Properties().setId(key("apalachia_slicer"))).nameColor(RarityList.APALACHIA)*/),
        skythern_slicer = register("skythern_slicer"/*, () -> new ItemThrowable(7, new Item.Properties().setId(key("skythern_slicer"))).nameColor(RarityList.SKYTHERN)*/),
        mortum_slicer   = register("mortum_slicer"/*, () -> new ItemThrowable(8, new Item.Properties().setId(key("mortum_slicer"))).nameColor(RarityList.MORTUM)*/),
        halite_slicer   = register("halite_slicer"/*, () -> new ItemThrowable(9, new Item.Properties().setId(key("halite_slicer"))).nameColor(RarityList.HALITE)*/),
        teaker_disk     = register("teaker_disk"/*, new ItemThrowable(new Item.Properties().setId(key("teaker_disk")).stacksTo(1), EntityRegistry.DISK::value, 2).withTooltip(LocalizeUtils.returnsToSender())*/),
        amthirmis_disk  = register("amthirmis_disk"/*, new ItemThrowable(new Item.Properties().setId(key("amthirmis_disk")).stacksTo(1), EntityRegistry.DISK::value, 3).withTooltip(LocalizeUtils.returnsToSender())*/),
        darven_disk     = register("darven_disk"/*, new ItemThrowable(new Item.Properties().setId(key("darven_disk")).stacksTo(1), EntityRegistry.DISK::value, 4.5F).withTooltip(LocalizeUtils.returnsToSender())*/),
        cermile_disk    = register("cermile_disk"/*, new ItemThrowable(new Item.Properties().setId(key("cermile_disk")).stacksTo(1), EntityRegistry.DISK::value, 6.5F).withTooltip(LocalizeUtils.returnsToSender())*/),
        pardimal_disk   = register("pardimal_disk"/*, new ItemThrowable(new Item.Properties().setId(key("pardimal_disk")).stacksTo(1), EntityRegistry.DISK::value, 8).withTooltip(LocalizeUtils.returnsToSender())*/),
        quadrotic_disk  = register("quadrotic_disk"/*, new ItemThrowable(new Item.Properties().setId(key("quadrotic_disk")).stacksTo(1), EntityRegistry.DISK::value, 10).withTooltip(LocalizeUtils.returnsToSender())*/),
        karos_disk      = register("karos_disk"/*, new ItemThrowable(new Item.Properties().setId(key("karos_disk")).stacksTo(1), EntityRegistry.DISK::value, 11).withTooltip(LocalizeUtils.returnsToSender())*/),
        heliosis_disk   = register("heliosis_disk"/*, new ItemThrowable(new Item.Properties().setId(key("heliosis_disk")).stacksTo(1), EntityRegistry.DISK::value, 14.5F).withTooltip(LocalizeUtils.returnsToSender())*/),
        arksiane_disk   = register("arksiane_disk"/*, new ItemThrowable(new Item.Properties().setId(key("arksiane_disk")).stacksTo(1), EntityRegistry.DISK::value, 18.5F).withTooltip(LocalizeUtils.returnsToSender())*/),
        teaker_dissipator    = register("teaker_dissipator"/*, new ItemVetheanDissipator(2, new Item.Properties().setId(key("teaker_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        amthirmis_dissipator = register("amthirmis_dissipator"/*, new ItemVetheanDissipator(3, new Item.Properties().setId(key("amthirmis_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        darven_dissipator    = register("darven_dissipator"/*, new ItemVetheanDissipator(4.5F, new Item.Properties().setId(key("darven_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        cermile_dissipator   = register("cermile_dissipator"/*, new ItemVetheanDissipator(6.5F, new Item.Properties().setId(key("cermile_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        pardimal_dissipator  = register("pardimal_dissipator"/*, new ItemVetheanDissipator(8, new Item.Properties().setId(key("pardimal_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        quadrotic_dissipator = register("quadrotic_dissipator"/*, new ItemVetheanDissipator(10, new Item.Properties().setId(key("quadrotic_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        karos_dissipator     = register("karos_dissipator"/*, new ItemVetheanDissipator(11, new Item.Properties().setId(key("karos_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        heliosis_dissipator  = register("heliosis_dissipator"/*, new ItemVetheanDissipator(14.5F, new Item.Properties().setId(key("heliosis_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        arksiane_dissipator  = register("arksiane_dissipator"/*, new ItemVetheanDissipator(18.5F, new Item.Properties().setId(key("arksiane_dissipator"))).withTooltip(LocalizeUtils.returnsToSender())*/),
        grenade        = register("grenade"/*, new ItemThrowable(new Item.Properties().setId(key("grenade")), EntityRegistry.GRENADE::value, 3F).withTooltip(LocalizeUtils.explosiveShots()).withCooldown(20).withSound(SoundEvents.TRIDENT_THROW.value())*/),
        la_vekor       = register("la_vekor", props -> new ItemRangedWeapon(props.durability(1225), AMMO_GRENADE, ItemRegistry.grenade::toStack, EntityRegistry.GRENADE::value).withSound(LA_VEKOR.get()).withTooltips(List.of(LocalizeUtils.rangedDam(6), LocalizeUtils.explosiveShots())).withCooldown(10).arcanaUse(15)),
        firefly        = registerTool("firefly"/*, new ItemFirefly(new Item.Properties().setId(key("firefly"))) */),
        meriks_missile = registerTool("meriks_missile"/*, new ItemMeriksMissile(new Item.Properties().setId(key("meriks_missile"))) */),
        scythe             = register("scythe"/*, () -> /* new ItemScythe(new Item.Properties().setId(key("scythe"))) */),
        cyclopsian_staff = register("cyclopsian_staff", props -> new ItemRangedWeapon(props, EntityRegistry.EYE_SHARD::value).withSound(SoundRegistry.STAFF.get()).withTooltip(LocalizeUtils.rangedDam(3))),
        maelstrom = register("maelstrom", props -> new ItemRangedWeapon(props,EntityRegistry.MAELSTROM_SHOT::value).withSound(SoundRegistry.GHAST_CANNON.get()).withTooltip(LocalizeUtils.magicDam(12)).withCooldown(20)),
        captains_sparkler = register("captains_sparkler", props -> new ItemRangedWeapon(props,EntityRegistry.SPARKLER_SHOT::value).withSound(SoundRegistry.SPARKLER.get()).withTooltip(LocalizeUtils.arcanaDam(13)).withCooldown(15).arcanaUse(7)),
        generals_staff = register("generals_staff", props -> new ItemRangedWeapon(props,EntityRegistry.GENERALS_SHOT::value).withSound(SoundRegistry.STARLIGHT.get()).withTooltips(List.of(LocalizeUtils.arcanaDam(13), LocalizeUtils.splitShots(5))).withCooldown(50).arcanaUse(20)),
        starlight          = register("starlight"/*, () -> /* new SkyDropStaff(EntityRegistry.STAR::value, 5, 13, 1, 10, 1010, new Item.Properties().setId(key("starlight"))) */),
        staff_of_starlight = register("staff_of_starlight"/*, () -> /* new SkyDropStaff(EntityRegistry.STAR::value, 25, 13, 8, 40, 1176, new Item.Properties().setId(key("staff_of_starlight"))) */),
        meteor_mash        = register("meteor_mash"/*, () -> /* new SkyDropStaff(EntityRegistry.METEOR::value, 35, 15, 1, 30, 1218, new Item.Properties().setId(key("meteor_mash"))) */),
        teaker_staff     = register("teaker_staff"/*, () -> /* new VetheanStaff(10, 1, new Item.Properties().setId(key("teaker_staff"))) */),
        amthirmis_staff  = register("amthirmis_staff"/*, () -> /* new VetheanStaff(10, 1.6F, new Item.Properties().setId(key("amthirmis_staff"))) */),
        darven_staff     = register("darven_staff"/*, () -> /* new VetheanStaff(10, 2.6F, new Item.Properties().setId(key("darven_staff"))) */),
        cermile_staff    = register("cermile_staff"/*, () -> /* new VetheanStaff(10, 4, new Item.Properties().setId(key("cermile_staff"))) */),
        pardimal_staff   = register("pardimal_staff"/*, () -> /* new VetheanStaff(10, 5, new Item.Properties().setId(key("pardimal_staff"))) */),
        quadrotic_staff  = register("quadrotic_staff"/*, () -> /* new VetheanStaff(10, 6.3F, new Item.Properties().setId(key("quadrotic_staff"))) */),
        karos_staff      = register("karos_staff"/*, () -> /* new VetheanStaff(10, 7, new Item.Properties().setId(key("karos_staff"))) */),
        heliosis_staff   = register("heliosis_staff"/*, () -> /* new VetheanStaff(10, 9.3F, new Item.Properties().setId(key("heliosis_staff"))) */),
        arksiane_staff   = register("arksiane_staff"/*, () -> /* new VetheanStaff(10, 12, new Item.Properties().setId(key("arksiane_staff"))) */),
        evernight        = register("evernight"/*, () -> /* new Evernight(new Item.Properties().setId(key("evernight"))) */),
        eden_phaser      = register("eden_phaser", props -> new ItemRangedWeapon(props, EntityRegistry.EDEN_PHASER_SHOT::value).withTooltip(LocalizeUtils.magicDam(8)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.EDEN)),
        wildwood_phaser  = register("wildwood_phaser", props -> new ItemRangedWeapon(props, EntityRegistry.WILDWOOD_PHASER_SHOT::value).withTooltip(LocalizeUtils.magicDam(10)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.WILDWOOD)),
        apalachia_phaser = register("apalachia_phaser", props -> new ItemRangedWeapon(props, EntityRegistry.APALACHIA_PHASER_SHOT::value).withTooltip(LocalizeUtils.magicDam(12)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.APALACHIA)),
        skythern_phaser  = register("skythern_phaser", props -> new ItemRangedWeapon(props, EntityRegistry.SKYTHERN_PHASER_SHOT::value).withTooltip(LocalizeUtils.magicDam(14)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.SKYTHERN)),
        mortum_phaser    = register("mortum_phaser", props -> new ItemRangedWeapon(props, EntityRegistry.MORTUM_PHASER_SHOT::value).withTooltip(LocalizeUtils.magicDam(16)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.MORTUM)),
        halite_phaser    = register("halite_phaser", props -> new ItemRangedWeapon(props, EntityRegistry.HALITE_PHASER_SHOT::value).withTooltip(LocalizeUtils.magicDam(18)).withSound(SoundRegistry.PHASER.get()).withCooldown(50).nameColor(RarityList.HALITE)),
        crabclaw_cannon  = register("crabclaw_cannon", props -> new ItemRangedWeapon(props.durability(246), TagRegistry.AMMO_AQUATIC_CANNON, Items.CACTUS::getDefaultInstance, EntityRegistry.CRAB_CLAW::value).withTooltip(LocalizeUtils.rangedDam(4)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        frostclaw_cannon = register("frostclaw_cannon", props -> new ItemRangedWeapon(props.durability(612), TagRegistry.AMMO_AQUATIC_CANNON, Items.CACTUS::getDefaultInstance, EntityRegistry.FROST_CLAW::value).withTooltip(LocalizeUtils.rangedDam(7)).withSound(SoundRegistry.FROSTCLAW_CANNON.get())),
        bowhead_cannon   = register("bowhead_cannon", props -> new ItemRangedWeapon(props.durability(592), TagRegistry.AMMO_AQUATIC_CANNON, Items.CACTUS::getDefaultInstance, EntityRegistry.BOWHEAD_SHOT::value).withTooltip(LocalizeUtils.rangedDam(6)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        frost_cannon     = register("frost_cannon", props -> new ItemRangedWeapon(props.durability(1126), TagRegistry.AMMO_FROST_CANNON, Items.SNOWBALL::getDefaultInstance, EntityRegistry.FROST_CANNON_SHOT::value).withTooltip(LocalizeUtils.rangedDam(6)).withSound(SoundRegistry.FROST_CANNON.get())),
        fractite_cannon  = register("fractite_cannon", props -> new ItemRangedWeapon(props.durability(1442), TagRegistry.AMMO_FRACTITE_CANNON, ItemRegistry.ice_shards::toStack, EntityRegistry.FRACTITE_CANNON_SHOT::value).withTooltip(LocalizeUtils.rangedDam(8)).withSound(SoundRegistry.FRACTITE_CANNON.get())),
        ghast_cannon     = register("ghast_cannon", props -> new ItemRangedWeapon(props.durability(726), EntityRegistry.GHAST_CANNON_SHOT::value).withTooltip(LocalizeUtils.magicDam(11)).withSound(SoundRegistry.GHAST_CANNON.get()).withCooldown(20)),
        golden_fury      = register("golden_fury", props -> new ItemRangedWeapon(props.durability(2417), TagRegistry.AMMO_GOLDEN_FURY, Items.GOLD_NUGGET::getDefaultInstance, EntityRegistry.GOLDEN_FURY_SHOT::value).withTooltip(LocalizeUtils.rangedDam(17)).withSound(SoundRegistry.BLITZ.get())),
        eden_blitz      = register("eden_blitz", props -> new ItemRangedWeapon(props.durability(1517), TagRegistry.AMMO_EDEN_BLITZ, ItemRegistry.eden_dust::toStack, EntityRegistry.EDEN_BLITZ_SHOT::value).withTooltip(LocalizeUtils.rangedDam(10)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.EDEN)),
        wildwood_blitz  = register("wildwood_blitz", props -> new ItemRangedWeapon(props.durability(1624), TagRegistry.AMMO_WILDWOOD_BLITZ, ItemRegistry.wildwood_dust::toStack, EntityRegistry.WILDWOOD_BLITZ_SHOT::value).withTooltip(LocalizeUtils.rangedDam(12)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.WILDWOOD)),
        apalachia_blitz = register("apalachia_blitz", props -> new ItemRangedWeapon(props.durability(1778), TagRegistry.AMMO_APALACHIA_BLITZ, ItemRegistry.apalachia_dust::toStack, EntityRegistry.APALACHIA_BLITZ_SHOT::value).withTooltip(LocalizeUtils.rangedDam(14)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.APALACHIA)),
        skythern_blitz  = register("skythern_blitz", props -> new ItemRangedWeapon(props.durability(1879), TagRegistry.AMMO_SKYTHERN_BLITZ, ItemRegistry.skythern_dust::toStack, EntityRegistry.SKYTHERN_BLITZ_SHOT::value).withTooltip(LocalizeUtils.rangedDam(16)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.SKYTHERN)),
        mortum_blitz    = register("mortum_blitz", props -> new ItemRangedWeapon(props.durability(1990), TagRegistry.AMMO_MORTUM_BLITZ, ItemRegistry.mortum_dust::toStack, EntityRegistry.MORTUM_BLITZ_SHOT::value).withTooltip(LocalizeUtils.rangedDam(18)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.MORTUM)),
        halite_blitz    = register("halite_blitz", props -> new ItemRangedWeapon(props.durability(2114), TagRegistry.AMMO_HALITE_BLITZ, ItemRegistry.mortum_dust::toStack, EntityRegistry.HALITE_BLITZ_SHOT::value).withTooltip(LocalizeUtils.rangedDam(20)).withSound(SoundRegistry.BLITZ.get()).nameColor(RarityList.HALITE)),
        corrupted_bullet = register("corrupted_bullet"),
        corrupted_cannon = register("corrupted_cannon"/*, () -> new Shotgun(TagRegistry.AMMO_CORRUPTED_CANNON/*, () -> new ItemStack(ItemRegistry.corrupted_bullet.get(), 4), EntityRegistry.CORRUPTED_BULLET::value, 1672, 15, 4, new Item.Properties().setId(key("corrupted_cannon"))).withTooltip(LocalizeUtils.rangedDam("4x10")).withSound(SoundRegistry.GHAST_CANNON.get())*/),
        arcanite_blaster = register("arcanite_blaster"/*, () -> new Shotgun(EntityRegistry.BLASTER_BULLET::value, 1127, 30, 30, new Item.Properties().setId(key("arcanite_blaster"))).withTooltip(LocalizeUtils.arcanaDam("30x13")).withSound(SoundRegistry.GHAST_CANNON.get()).arcanaUse(20)*/),
        teaker_cannon        = register("teaker_cannon"/*, () -> new VetheanCannon(1, new Item.Properties().setId(key("teaker_cannon")))*/),
        amthirmis_cannon     = register("amthirmis_cannon"/*, () -> new VetheanCannon(1.6F, new Item.Properties().setId(key("amthirmis_cannon")))*/),
        darven_cannon        = register("darven_cannon"/*, () -> new VetheanCannon(2.6F, new Item.Properties().setId(key("darven_cannon")))*/),
        cermile_cannon       = register("cermile_cannon"/*, () -> new VetheanCannon(4, new Item.Properties().setId(key("cermile_cannon")))*/),
        pardimal_cannon      = register("pardimal_cannon"/*, () -> new VetheanCannon(5, new Item.Properties().setId(key("pardimal_cannon")))*/),
        quadrotic_cannon     = register("quadrotic_cannon"/*, () -> new VetheanCannon(6.3F, new Item.Properties().setId(key("quadrotic_cannon")))*/),
        karos_cannon         = register("karos_cannon"/*, () -> new VetheanCannon(7, new Item.Properties().setId(key("karos_cannon")))*/),
        heliosis_cannon      = register("heliosis_cannon"/*, () -> new VetheanCannon(9.3F, new Item.Properties().setId(key("heliosis_cannon")))*/),
        arksiane_cannon      = register("arksiane_cannon"/*, () -> new VetheanCannon(12, new Item.Properties().setId(key("arksiane_cannon")))*/),
        eversight            = register("eversight", props -> new ItemRangedWeapon(props, TagRegistry.AMMO_VETHEAN_CANNON, ItemRegistry.acid::toStack, EntityRegistry.EVERSIGHT_SHOT::value).withTooltip(LocalizeUtils.rangedDam(42)).withSound(SoundRegistry.BLITZ.get()).arcanaUse(10)),
        realmite_shovel      = registerShovel("realmite_shovel", ToolStats.REALMITE_SHOVEL, Rarity.COMMON, false),
        realmite_pickaxe     = registerPickaxe("realmite_pickaxe", ToolStats.REALMITE_PICKAXE, Rarity.COMMON, false),
        realmite_axe         = registerAxe("realmite_axe", ToolStats.REALMITE_AXE, Rarity.COMMON, false),
        realmite_hoe         = registerHoe("realmite_hoe", ToolStats.REALMITE_HOE, Rarity.COMMON, false),
        oxdrite_pickaxe   = registerPickaxe("oxdrite_pickaxe", ToolStats.OXDRITE_PICKAXE, Rarity.COMMON, false),
        arlemite_shovel   = registerShovel("arlemite_shovel", ToolStats.ARLEMITE_SHOVEL, Rarity.COMMON, false),
        arlemite_pickaxe  = registerPickaxe("arlemite_pickaxe", ToolStats.ARLEMITE_PICKAXE, Rarity.COMMON, false),
        arlemite_axe      = registerAxe("arlemite_axe", ToolStats.ARLEMITE_AXE, Rarity.COMMON, false),
        arlemite_hoe      = registerHoe("arlemite_hoe", ToolStats.ARLEMITE_HOE, Rarity.COMMON, false),
        arlemite_shickaxe = registerShickaxe("arlemite_shickaxe", ToolStats.ARLEMITE_SHICKAXE, Rarity.COMMON, false),
        terran_shovel    = registerShovel("terran_shovel", ToolStats.TERRAN_SHOVEL, Rarity.COMMON, false),
        terran_pickaxe   = registerPickaxe("terran_pickaxe", ToolStats.TERRAN_PICKAXE, Rarity.COMMON, false),
        terran_axe       = registerAxe("terran_axe", ToolStats.TERRAN_AXE, Rarity.COMMON, false),
        terran_hoe       = registerHoe("terran_hoe", ToolStats.TERRAN_HOE, Rarity.COMMON, false),
        terran_shickaxe  = registerShickaxe("terran_shickaxe", ToolStats.TERRAN_SHICKAXE, Rarity.COMMON, false),
        terran_shifter   = registerShickaxe("terran_shifter", ToolStats.TERRAN_SHIFTER, Rarity.COMMON, false),
        rupee_shovel     = registerShovel("rupee_shovel", ToolStats.RUPEE_SHOVEL, Rarity.COMMON, false),
        rupee_pickaxe    = registerPickaxe("rupee_pickaxe", ToolStats.RUPEE_PICKAXE, Rarity.COMMON, false),
        rupee_axe        = registerAxe("rupee_axe", ToolStats.RUPEE_AXE, Rarity.COMMON, false),
        rupee_hoe        = registerHoe("rupee_hoe", ToolStats.RUPEE_HOE, Rarity.COMMON, false),
        rupee_shickaxe   = registerShickaxe("rupee_shickaxe", ToolStats.RUPEE_SHICKAXE, Rarity.COMMON, false),
        corrupted_shovel   = registerShovel("corrupted_shovel", ToolStats.CORRUPTED_SHOVEL, Rarity.COMMON, false),
        corrupted_pickaxe  = registerPickaxe("corrupted_pickaxe", ToolStats.CORRUPTED_PICKAXE, Rarity.COMMON, false),
        corrupted_axe      = registerAxe("corrupted_axe", ToolStats.CORRUPTED_AXE, Rarity.COMMON, false),
        corrupted_hoe      = registerHoe("corrupted_hoe", ToolStats.CORRUPTED_HOE, Rarity.COMMON, false),
        corrupted_shickaxe = registerShickaxe("corrupted_shickaxe", ToolStats.CORRUPTED_SHICKAXE, Rarity.COMMON, false),
        bedrock_shovel    = registerShovel("bedrock_shovel", ToolStats.BEDROCK_SHOVEL, Rarity.COMMON, true),
        bedrock_pickaxe   = registerPickaxe("bedrock_pickaxe", ToolStats.BEDROCK_PICKAXE, Rarity.COMMON, true),
        bedrock_axe       = registerAxe("bedrock_axe", ToolStats.BEDROCK_AXE, Rarity.COMMON, true),
        bedrock_hoe       = registerHoe("bedrock_hoe", ToolStats.BEDROCK_HOE, Rarity.COMMON, true),
        divine_shovel    = registerShovel("divine_shovel", ToolStats.DIVINE_SHOVEL, Rarity.COMMON, false),
        divine_pickaxe   = registerPickaxe("divine_pickaxe", ToolStats.DIVINE_PICKAXE, Rarity.COMMON, false),
        divine_axe       = registerAxe("divine_axe", ToolStats.DIVINE_AXE, Rarity.COMMON, false),
        divine_hoe       = registerHoe("divine_hoe", ToolStats.DIVINE_HOE, Rarity.COMMON, false),
        divine_shickaxe  = registerShickaxe("divine_shickaxe", ToolStats.DIVINE_SHICKAXE, Rarity.COMMON, false),
        eden_shovel      = registerShovel("eden_shovel", ToolStats.EDEN_SHOVEL, Rarity.COMMON, false),
        eden_pickaxe     = registerPickaxe("eden_pickaxe", ToolStats.EDEN_PICKAXE, Rarity.COMMON, false),
        eden_axe         = registerAxe("eden_axe", ToolStats.EDEN_AXE, Rarity.COMMON, false),
        eden_hoe         = registerHoe("eden_hoe", ToolStats.EDEN_HOE, Rarity.COMMON, false),
        eden_shickaxe    = registerShickaxe("eden_shickaxe", ToolStats.EDEN_SHICKAXE, Rarity.COMMON, false),
        wildwood_shovel    = registerShovel("wildwood_shovel", ToolStats.WILDWOOD_SHOVEL, Rarity.COMMON, false),
        wildwood_pickaxe   = registerPickaxe("wildwood_pickaxe", ToolStats.WILDWOOD_PICKAXE, Rarity.COMMON, false),
        wildwood_axe       = registerAxe("wildwood_axe", ToolStats.WILDWOOD_AXE, Rarity.COMMON, false),
        wildwood_hoe       = registerHoe("wildwood_hoe", ToolStats.WILDWOOD_HOE, Rarity.COMMON, false),
        wildwood_shickaxe  = registerShickaxe("wildwood_shickaxe", ToolStats.WILDWOOD_SHICKAXE, Rarity.COMMON, false),
        apalachia_shovel   = registerShovel("apalachia_shovel", ToolStats.APALACHIA_SHOVEL, Rarity.COMMON, false),
        apalachia_pickaxe  = registerPickaxe("apalachia_pickaxe", ToolStats.APALACHIA_PICKAXE, Rarity.COMMON, false),
        apalachia_axe      = registerAxe("apalachia_axe", ToolStats.APALACHIA_AXE, Rarity.COMMON, false),
        apalachia_hoe      = registerHoe("apalachia_hoe", ToolStats.APALACHIA_HOE, Rarity.COMMON, false),
        apalachia_shickaxe = registerShickaxe("apalachia_shickaxe", ToolStats.APALACHIA_SHICKAXE, Rarity.COMMON, false),
        skythern_shovel    = registerShovel("skythern_shovel", ToolStats.SKYTHERN_SHOVEL, Rarity.COMMON, false),
        skythern_pickaxe   = registerPickaxe("skythern_pickaxe", ToolStats.SKYTHERN_PICKAXE, Rarity.COMMON, false),
        skythern_axe       = registerAxe("skythern_axe", ToolStats.SKYTHERN_AXE, Rarity.COMMON, false),
        skythern_hoe       = registerHoe("skythern_hoe", ToolStats.SKYTHERN_HOE, Rarity.COMMON, false),
        skythern_shickaxe  = registerShickaxe("skythern_shickaxe", ToolStats.SKYTHERN_SHICKAXE, Rarity.COMMON, false),
        mortum_shovel    = registerShovel("mortum_shovel", ToolStats.MORTUM_SHOVEL, Rarity.COMMON, false),
        mortum_pickaxe   = registerPickaxe("mortum_pickaxe", ToolStats.MORTUM_PICKAXE, Rarity.COMMON, false),
        mortum_axe       = registerAxe("mortum_axe", ToolStats.MORTUM_AXE, Rarity.COMMON, false),
        mortum_hoe       = registerHoe("mortum_hoe", ToolStats.MORTUM_HOE, Rarity.COMMON, false),
        mortum_shickaxe  = registerShickaxe("mortum_shickaxe", ToolStats.MORTUM_SHICKAXE, Rarity.COMMON, false),
        halite_shickaxe = registerShickaxe("halite_shickaxe", ToolStats.HALITE_SHICKAXE, Rarity.COMMON, false),
        dream_shovel    = registerShovel("dream_shovel", ToolStats.DREAM_SHOVEL, Rarity.COMMON, false),
        dream_pickaxe   = registerPickaxe("dream_pickaxe", ToolStats.DREAM_PICKAXE, Rarity.COMMON, false),
        dream_axe       = registerAxe("dream_axe", ToolStats.DREAM_AXE, Rarity.COMMON, false),
        nightmare_bed = register("nightmare_bed"/*, () -> /* new ItemNightmareBed(new Item.Properties().setId(key("nightmare_bed"))) */),
        divine_sign            = register("divine_sign"/*, () -> new DivineSign(BlockRegistry.divineSign.get(), BlockRegistry.divineWallSign.get(), new Item.Properties().setId(key("divine_sign")))*/),
        divine_hanging_sign    = register("divine_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.divineHangingSign.get(), BlockRegistry.divineHangingWallSign.get(), new Item.Properties().setId(key("divine_hanging_sign")))*/),
        shiverspine_sign       = register("shiverspine_sign"/*, () -> new DivineSign(BlockRegistry.shiverspineSign.get(), BlockRegistry.shiverspineWallSign.get(), new Item.Properties().setId(key("shiverspine_sign")))*/),
        shiverspine_hanging_sign = register("shiverspine_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.shiverspineHangingSign.get(), BlockRegistry.shiverspineHangingWallSign.get(), new Item.Properties().setId(key("shiverspine_hanging_sign")))*/),
        auroraoak_sign         = register("auroraoak_sign"/*, () -> new DivineSign(BlockRegistry.auroraoakSign.get(), BlockRegistry.auroraoakWallSign.get(), new Item.Properties().setId(key("auroraoak_sign")))*/),
        auroraoak_hanging_sign = register("auroraoak_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.auroraoakHangingSign.get(), BlockRegistry.auroraoakHangingWallSign.get(), new Item.Properties().setId(key("auroraoak_hanging_sign")))*/),
        cozybark_sign          = register("cozybark_sign"/*, () -> new DivineSign(BlockRegistry.cozybarkSign.get(), BlockRegistry.cozybarkWallSign.get(), new Item.Properties().setId(key("cozybark_sign")))*/),
        cozybark_hanging_sign  = register("cozybark_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.cozybarkHangingSign.get(), BlockRegistry.cozybarkHangingWallSign.get(), new Item.Properties().setId(key("cozybark_hanging_sign")))*/),
        streamleaf_sign        = register("streamleaf_sign"/*, () -> new DivineSign(BlockRegistry.streamleafSign.get(), BlockRegistry.streamleafWallSign.get(), new Item.Properties().setId(key("streamleaf_sign")))*/),
        streamleaf_hanging_sign = register("streamleaf_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.streamleafHangingSign.get(), BlockRegistry.streamleafHangingWallSign.get(), new Item.Properties().setId(key("streamleaf_hanging_sign")))*/),
        eucalyptus_sign        = register("eucalyptus_sign"/*, () -> new DivineSign(BlockRegistry.eucalyptusSign.get(), BlockRegistry.eucalyptusWallSign.get(), new Item.Properties().setId(key("eucalyptus_sign")))*/),
        eucalyptus_hanging_sign = register("eucalyptus_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.eucalyptusHangingSign.get(), BlockRegistry.eucalyptusHangingWallSign.get(), new Item.Properties().setId(key("eucalyptus_hanging_sign")))*/),
        eden_sign              = register("eden_sign"/*, () -> new DivineSign(BlockRegistry.edenSign.get(), BlockRegistry.edenWallSign.get(), new Item.Properties().setId(key("eden_sign")))*/),
        eden_hanging_sign      = register("eden_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.edenHangingSign.get(), BlockRegistry.edenHangingWallSign.get(), new Item.Properties().setId(key("eden_hanging_sign")))*/),
        wildwood_sign          = register("wildwood_sign"/*, () -> new DivineSign(BlockRegistry.wildwoodSign.get(), BlockRegistry.wildwoodWallSign.get(), new Item.Properties().setId(key("wildwood_sign")))*/),
        wildwood_hanging_sign  = register("wildwood_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.wildwoodHangingSign.get(), BlockRegistry.wildwoodHangingWallSign.get(), new Item.Properties().setId(key("wildwood_hanging_sign")))*/),
        apalachia_sign         = register("apalachia_sign"/*, () -> new DivineSign(BlockRegistry.apalachiaSign.get(), BlockRegistry.apalachiaWallSign.get(), new Item.Properties().setId(key("apalachia_sign")))*/),
        apalachia_hanging_sign = register("apalachia_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.apalachiaHangingSign.get(), BlockRegistry.apalachiaHangingWallSign.get(), new Item.Properties().setId(key("apalachia_hanging_sign")))*/),
        skythern_sign          = register("skythern_sign"/*, () -> new DivineSign(BlockRegistry.skythernSign.get(), BlockRegistry.skythernWallSign.get(), new Item.Properties().setId(key("skythern_sign")))*/),
        skythern_hanging_sign  = register("skythern_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.skythernHangingSign.get(), BlockRegistry.skythernHangingWallSign.get(), new Item.Properties().setId(key("skythern_hanging_sign")))*/),
        mortum_sign            = register("mortum_sign"/*, () -> new DivineSign(BlockRegistry.mortumSign.get(), BlockRegistry.mortumWallSign.get(), new Item.Properties().setId(key("mortum_sign")))*/),
        mortum_hanging_sign    = register("mortum_hanging_sign"/*, () -> new DivineSignHanging(BlockRegistry.mortumHangingSign.get(), BlockRegistry.mortumHangingWallSign.get(), new Item.Properties().setId(key("mortum_hanging_sign")))*/),
        aqua_torch = register("aqua_torch"/*, () -> new AquaTorch(new Item.Properties().setId(key("aqua_torch")))*/),
        skeleton_torch = register("skeleton_torch"/*, () -> new StandingAndWallBlockItem(BlockRegistry.skeletonTorch.get(), BlockRegistry.skeletonWallTorch.get(), new Item.Properties().setId(key("skeleton_torch")), Direction.DOWN)*/),
        arcanium_torch = register("arcanium_torch"/*, () -> new StandingAndWallBlockItem(BlockRegistry.arcaniumTorch.get(), BlockRegistry.arcaniumWallTorch.get(), new Item.Properties().setId(key("arcanium_torch")), Direction.DOWN)*/),
        eden_torch = register("eden_torch"/*, () -> new StandingAndWallBlockItem(BlockRegistry.edenTorch.get(), BlockRegistry.edenWallTorch.get(), new Item.Properties().setId(key("eden_torch")), Direction.DOWN)*/);

    public static final DeferredItem<Item> healing_stone = register("healing_stone", ItemHealingStone::new);
    public static final DeferredItem<Item> palavence = registerTool("palavence", p -> new ItemHealingSword(ToolStats.PALAVENCE, 0.5F, p));
    public static final DeferredItem<Item> massivence = registerTool("massivence", p -> new ItemHealingSword(ToolStats.MASSIVENCE, 1.0F, p));
    public static final DeferredItem<Item> frossivence = registerTool("frossivence", p -> new ItemHealingSword(ToolStats.FROSSIVENCE, 1.0F, p));


    public static final DeferredItem<Item> REALMITE_HELMET = ITEMS.registerItem("realmite_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.REALMITE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> REALMITE_CHESTPLATE = ITEMS.registerItem("realmite_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.REALMITE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> REALMITE_LEGGINGS = ITEMS.registerItem("realmite_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.REALMITE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> REALMITE_BOOTS = ITEMS.registerItem("realmite_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.REALMITE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> SENG_FUR_HELMET = ITEMS.registerItem("seng_fur_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SENG_FUR, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> SENG_FUR_CHESTPLATE = ITEMS.registerItem("seng_fur_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SENG_FUR, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> SENG_FUR_LEGGINGS = ITEMS.registerItem("seng_fur_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SENG_FUR, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> SENG_FUR_BOOTS = ITEMS.registerItem("seng_fur_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SENG_FUR, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> SANTA_HELMET = ITEMS.registerItem("santa_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SANTA, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> SANTA_CHESTPLATE = ITEMS.registerItem("santa_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SANTA, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> SANTA_LEGGINGS = ITEMS.registerItem("santa_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SANTA, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> SANTA_BOOTS = ITEMS.registerItem("santa_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SANTA, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> AQUASTRIVE_HELMET = ITEMS.registerItem("aquastrive_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AQUASTRIVE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> AQUASTRIVE_CHESTPLATE = ITEMS.registerItem("aquastrive_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AQUASTRIVE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> AQUASTRIVE_LEGGINGS = ITEMS.registerItem("aquastrive_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AQUASTRIVE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> AQUASTRIVE_BOOTS = ITEMS.registerItem("aquastrive_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AQUASTRIVE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> KRAKEN_HELMET = ITEMS.registerItem("kraken_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KRAKEN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> KRAKEN_CHESTPLATE = ITEMS.registerItem("kraken_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KRAKEN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> KRAKEN_LEGGINGS = ITEMS.registerItem("kraken_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KRAKEN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> KRAKEN_BOOTS = ITEMS.registerItem("kraken_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KRAKEN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> JACK_O_MAN_HELMET = ITEMS.registerItem("jack_o_man_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JACK_O_MAN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> JACK_O_MAN_CHESTPLATE = ITEMS.registerItem("jack_o_man_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JACK_O_MAN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> JACK_O_MAN_LEGGINGS = ITEMS.registerItem("jack_o_man_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JACK_O_MAN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> JACK_O_MAN_BOOTS = ITEMS.registerItem("jack_o_man_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JACK_O_MAN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> SKELEMAN_HELMET = ITEMS.registerItem("skeleman_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKELEMAN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> SKELEMAN_CHESTPLATE = ITEMS.registerItem("skeleman_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKELEMAN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> SKELEMAN_LEGGINGS = ITEMS.registerItem("skeleman_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKELEMAN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> SKELEMAN_BOOTS = ITEMS.registerItem("skeleman_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKELEMAN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> WITHER_REAPER_HELMET = ITEMS.registerItem("wither_reaper_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WITHER_REAPER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> WITHER_REAPER_CHESTPLATE = ITEMS.registerItem("wither_reaper_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WITHER_REAPER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> WITHER_REAPER_LEGGINGS = ITEMS.registerItem("wither_reaper_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WITHER_REAPER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> WITHER_REAPER_BOOTS = ITEMS.registerItem("wither_reaper_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WITHER_REAPER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> ARLEMITE_HELMET = ITEMS.registerItem("arlemite_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ARLEMITE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> ARLEMITE_CHESTPLATE = ITEMS.registerItem("arlemite_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ARLEMITE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> ARLEMITE_LEGGINGS = ITEMS.registerItem("arlemite_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ARLEMITE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> ARLEMITE_BOOTS = ITEMS.registerItem("arlemite_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ARLEMITE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> FROZEN_HELMET = ITEMS.registerItem("frozen_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FROZEN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> FROZEN_CHESTPLATE = ITEMS.registerItem("frozen_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FROZEN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> FROZEN_LEGGINGS = ITEMS.registerItem("frozen_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FROZEN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> FROZEN_BOOTS = ITEMS.registerItem("frozen_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FROZEN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> JUNGLE_HELMET = ITEMS.registerItem("jungle_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JUNGLE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> JUNGLE_CHESTPLATE = ITEMS.registerItem("jungle_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JUNGLE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> JUNGLE_LEGGINGS = ITEMS.registerItem("jungle_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JUNGLE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> JUNGLE_BOOTS = ITEMS.registerItem("jungle_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.JUNGLE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> INFERNO_HELMET = ITEMS.registerItem("inferno_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.INFERNO, ArmorType.HELMET).fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> INFERNO_CHESTPLATE = ITEMS.registerItem("inferno_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.INFERNO, ArmorType.CHESTPLATE).fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> INFERNO_LEGGINGS = ITEMS.registerItem("inferno_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.INFERNO, ArmorType.LEGGINGS).fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> INFERNO_BOOTS = ITEMS.registerItem("inferno_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.INFERNO, ArmorType.BOOTS).fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> TORRIDITE_HELMET = ITEMS.registerItem("torridite_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORRIDITE, ArmorType.HELMET).fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> TORRIDITE_CHESTPLATE = ITEMS.registerItem("torridite_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORRIDITE, ArmorType.CHESTPLATE).fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> TORRIDITE_LEGGINGS = ITEMS.registerItem("torridite_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORRIDITE, ArmorType.LEGGINGS).fireResistant().stacksTo(1)));
    public static final DeferredItem<Item> TORRIDITE_BOOTS = ITEMS.registerItem("torridite_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORRIDITE, ArmorType.BOOTS).fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> TERRAN_HELMET = ITEMS.registerItem("terran_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TERRAN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> TERRAN_CHESTPLATE = ITEMS.registerItem("terran_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TERRAN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> TERRAN_LEGGINGS = ITEMS.registerItem("terran_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TERRAN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> TERRAN_BOOTS = ITEMS.registerItem("terran_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TERRAN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> ANGELIC_HELMET = ITEMS.registerItem("angelic_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ANGELIC, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> ANGELIC_CHESTPLATE = ITEMS.registerItem("angelic_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ANGELIC, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> ANGELIC_LEGGINGS = ITEMS.registerItem("angelic_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ANGELIC, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> ANGELIC_BOOTS = ITEMS.registerItem("angelic_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ANGELIC, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> SHADOW_HELMET = ITEMS.registerItem("shadow_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SHADOW, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> SHADOW_CHESTPLATE = ITEMS.registerItem("shadow_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SHADOW, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> SHADOW_LEGGINGS = ITEMS.registerItem("shadow_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SHADOW, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> SHADOW_BOOTS = ITEMS.registerItem("shadow_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SHADOW, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> RUPEE_HELMET = ITEMS.registerItem("rupee_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RUPEE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> RUPEE_CHESTPLATE = ITEMS.registerItem("rupee_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RUPEE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> RUPEE_LEGGINGS = ITEMS.registerItem("rupee_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RUPEE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> RUPEE_BOOTS = ITEMS.registerItem("rupee_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RUPEE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> RED_RUPEE_HELMET = ITEMS.registerItem("red_rupee_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_RUPEE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> RED_RUPEE_CHESTPLATE = ITEMS.registerItem("red_rupee_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_RUPEE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> RED_RUPEE_LEGGINGS = ITEMS.registerItem("red_rupee_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_RUPEE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> RED_RUPEE_BOOTS = ITEMS.registerItem("red_rupee_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_RUPEE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> YELLOW_RUPEE_HELMET = ITEMS.registerItem("yellow_rupee_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_RUPEE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_RUPEE_CHESTPLATE = ITEMS.registerItem("yellow_rupee_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_RUPEE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_RUPEE_LEGGINGS = ITEMS.registerItem("yellow_rupee_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_RUPEE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_RUPEE_BOOTS = ITEMS.registerItem("yellow_rupee_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_RUPEE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> GREEN_RUPEE_HELMET = ITEMS.registerItem("green_rupee_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_RUPEE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GREEN_RUPEE_CHESTPLATE = ITEMS.registerItem("green_rupee_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_RUPEE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> GREEN_RUPEE_LEGGINGS = ITEMS.registerItem("green_rupee_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_RUPEE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> GREEN_RUPEE_BOOTS = ITEMS.registerItem("green_rupee_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_RUPEE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> BLUE_RUPEE_HELMET = ITEMS.registerItem("blue_rupee_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_RUPEE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> BLUE_RUPEE_CHESTPLATE = ITEMS.registerItem("blue_rupee_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_RUPEE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> BLUE_RUPEE_LEGGINGS = ITEMS.registerItem("blue_rupee_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_RUPEE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> BLUE_RUPEE_BOOTS = ITEMS.registerItem("blue_rupee_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_RUPEE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> GRAY_RUPEE_HELMET = ITEMS.registerItem("gray_rupee_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_RUPEE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GRAY_RUPEE_CHESTPLATE = ITEMS.registerItem("gray_rupee_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_RUPEE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> GRAY_RUPEE_LEGGINGS = ITEMS.registerItem("gray_rupee_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_RUPEE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> GRAY_RUPEE_BOOTS = ITEMS.registerItem("gray_rupee_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_RUPEE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> ELITE_REALMITE_HELMET = ITEMS.registerItem("elite_realmite_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ELITE_REALMITE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> ELITE_REALMITE_CHESTPLATE = ITEMS.registerItem("elite_realmite_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ELITE_REALMITE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> ELITE_REALMITE_LEGGINGS = ITEMS.registerItem("elite_realmite_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ELITE_REALMITE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> ELITE_REALMITE_BOOTS = ITEMS.registerItem("elite_realmite_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ELITE_REALMITE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> CORRUPTED_HELMET = ITEMS.registerItem("corrupted_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.CORRUPTED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> CORRUPTED_CHESTPLATE = ITEMS.registerItem("corrupted_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.CORRUPTED, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> CORRUPTED_LEGGINGS = ITEMS.registerItem("corrupted_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.CORRUPTED, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> CORRUPTED_BOOTS = ITEMS.registerItem("corrupted_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.CORRUPTED, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> BEDROCK_HELMET = ITEMS.registerItem("bedrock_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BEDROCK, ArmorType.HELMET).fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> BEDROCK_CHESTPLATE = ITEMS.registerItem("bedrock_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BEDROCK, ArmorType.CHESTPLATE).fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> BEDROCK_LEGGINGS = ITEMS.registerItem("bedrock_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BEDROCK, ArmorType.LEGGINGS).fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> BEDROCK_BOOTS = ITEMS.registerItem("bedrock_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BEDROCK, ArmorType.BOOTS).fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));

    public static final DeferredItem<Item> KORMA_HELMET = ITEMS.registerItem("korma_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KORMA, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> KORMA_CHESTPLATE = ITEMS.registerItem("korma_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KORMA, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> KORMA_LEGGINGS = ITEMS.registerItem("korma_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KORMA, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> KORMA_BOOTS = ITEMS.registerItem("korma_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.KORMA, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> VEMOS_HELMET = ITEMS.registerItem("vemos_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.VEMOS, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> VEMOS_CHESTPLATE = ITEMS.registerItem("vemos_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.VEMOS, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> VEMOS_LEGGINGS = ITEMS.registerItem("vemos_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.VEMOS, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> VEMOS_BOOTS = ITEMS.registerItem("vemos_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.VEMOS, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> ENDER_HELMET = ITEMS.registerItem("ender_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ENDER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> ENDER_CHESTPLATE = ITEMS.registerItem("ender_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ENDER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> ENDER_LEGGINGS = ITEMS.registerItem("ender_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ENDER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> ENDER_BOOTS = ITEMS.registerItem("ender_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.ENDER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> RED_ENDER_HELMET = ITEMS.registerItem("red_ender_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_ENDER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> RED_ENDER_CHESTPLATE = ITEMS.registerItem("red_ender_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_ENDER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> RED_ENDER_LEGGINGS = ITEMS.registerItem("red_ender_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_ENDER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> RED_ENDER_BOOTS = ITEMS.registerItem("red_ender_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.RED_ENDER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> YELLOW_ENDER_HELMET = ITEMS.registerItem("yellow_ender_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_ENDER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_ENDER_CHESTPLATE = ITEMS.registerItem("yellow_ender_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_ENDER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_ENDER_LEGGINGS = ITEMS.registerItem("yellow_ender_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_ENDER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> YELLOW_ENDER_BOOTS = ITEMS.registerItem("yellow_ender_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.YELLOW_ENDER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> GREEN_ENDER_HELMET = ITEMS.registerItem("green_ender_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_ENDER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GREEN_ENDER_CHESTPLATE = ITEMS.registerItem("green_ender_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_ENDER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> GREEN_ENDER_LEGGINGS = ITEMS.registerItem("green_ender_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_ENDER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> GREEN_ENDER_BOOTS = ITEMS.registerItem("green_ender_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GREEN_ENDER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> BLUE_ENDER_HELMET = ITEMS.registerItem("blue_ender_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_ENDER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> BLUE_ENDER_CHESTPLATE = ITEMS.registerItem("blue_ender_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_ENDER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> BLUE_ENDER_LEGGINGS = ITEMS.registerItem("blue_ender_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_ENDER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> BLUE_ENDER_BOOTS = ITEMS.registerItem("blue_ender_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.BLUE_ENDER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> GRAY_ENDER_HELMET = ITEMS.registerItem("gray_ender_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_ENDER, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GRAY_ENDER_CHESTPLATE = ITEMS.registerItem("gray_ender_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_ENDER, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> GRAY_ENDER_LEGGINGS = ITEMS.registerItem("gray_ender_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_ENDER, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> GRAY_ENDER_BOOTS = ITEMS.registerItem("gray_ender_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GRAY_ENDER, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> DIVINE_HELMET = ITEMS.registerItem("divine_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DIVINE, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DIVINE_CHESTPLATE = ITEMS.registerItem("divine_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DIVINE, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> DIVINE_LEGGINGS = ITEMS.registerItem("divine_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DIVINE, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> DIVINE_BOOTS = ITEMS.registerItem("divine_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DIVINE, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> EDEN_HELMET = ITEMS.registerItem("eden_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.EDEN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> EDEN_CHESTPLATE = ITEMS.registerItem("eden_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.EDEN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> EDEN_LEGGINGS = ITEMS.registerItem("eden_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.EDEN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> EDEN_BOOTS = ITEMS.registerItem("eden_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.EDEN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> WILDWOOD_HELMET = ITEMS.registerItem("wildwood_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WILDWOOD, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> WILDWOOD_CHESTPLATE = ITEMS.registerItem("wildwood_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WILDWOOD, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> WILDWOOD_LEGGINGS = ITEMS.registerItem("wildwood_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WILDWOOD, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> WILDWOOD_BOOTS = ITEMS.registerItem("wildwood_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.WILDWOOD, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> APALACHIA_HELMET = ITEMS.registerItem("apalachia_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.APALACHIA, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> APALACHIA_CHESTPLATE = ITEMS.registerItem("apalachia_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.APALACHIA, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> APALACHIA_LEGGINGS = ITEMS.registerItem("apalachia_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.APALACHIA, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> APALACHIA_BOOTS = ITEMS.registerItem("apalachia_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.APALACHIA, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> SKYTHERN_HELMET = ITEMS.registerItem("skythern_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKYTHERN, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> SKYTHERN_CHESTPLATE = ITEMS.registerItem("skythern_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKYTHERN, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> SKYTHERN_LEGGINGS = ITEMS.registerItem("skythern_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKYTHERN, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> SKYTHERN_BOOTS = ITEMS.registerItem("skythern_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.SKYTHERN, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> MORTUM_HELMET = ITEMS.registerItem("mortum_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.MORTUM, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> MORTUM_CHESTPLATE = ITEMS.registerItem("mortum_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.MORTUM, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> MORTUM_LEGGINGS = ITEMS.registerItem("mortum_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.MORTUM, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> MORTUM_BOOTS = ITEMS.registerItem("mortum_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.MORTUM, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> HALITE_HELMET = ITEMS.registerItem("halite_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.HALITE, ArmorType.HELMET).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> HALITE_CHESTPLATE = ITEMS.registerItem("halite_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.HALITE, ArmorType.CHESTPLATE).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> HALITE_LEGGINGS = ITEMS.registerItem("halite_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.HALITE, ArmorType.LEGGINGS).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> HALITE_BOOTS = ITEMS.registerItem("halite_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.HALITE, ArmorType.BOOTS).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));

    public static final DeferredItem<Item> AWAKENED_HALITE_HELMET = ITEMS.registerItem("awakened_halite_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AWAKENED_HALITE, ArmorType.HELMET).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> AWAKENED_HALITE_CHESTPLATE = ITEMS.registerItem("awakened_halite_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AWAKENED_HALITE, ArmorType.CHESTPLATE).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> AWAKENED_HALITE_LEGGINGS = ITEMS.registerItem("awakened_halite_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AWAKENED_HALITE, ArmorType.LEGGINGS).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));
    public static final DeferredItem<Item> AWAKENED_HALITE_BOOTS = ITEMS.registerItem("awakened_halite_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.AWAKENED_HALITE, ArmorType.BOOTS).stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE)));

    public static final DeferredItem<Item> DEGRADED_HELMET = ITEMS.registerItem("degraded_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEGRADED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DEGRADED_HOOD = ITEMS.registerItem("degraded_hood", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEGRADED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DEGRADED_MASK = ITEMS.registerItem("degraded_mask", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEGRADED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DEGRADED_CHESTPLATE = ITEMS.registerItem("degraded_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEGRADED, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> DEGRADED_LEGGINGS = ITEMS.registerItem("degraded_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEGRADED, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> DEGRADED_BOOTS = ITEMS.registerItem("degraded_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEGRADED, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> FINISHED_HELMET = ITEMS.registerItem("finished_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FINISHED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> FINISHED_HOOD = ITEMS.registerItem("finished_hood", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FINISHED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> FINISHED_MASK = ITEMS.registerItem("finished_mask", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FINISHED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> FINISHED_CHESTPLATE = ITEMS.registerItem("finished_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FINISHED, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> FINISHED_LEGGINGS = ITEMS.registerItem("finished_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FINISHED, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> FINISHED_BOOTS = ITEMS.registerItem("finished_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.FINISHED, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> GLISTENING_HELMET = ITEMS.registerItem("glistening_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GLISTENING, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GLISTENING_HOOD = ITEMS.registerItem("glistening_hood", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GLISTENING, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GLISTENING_MASK = ITEMS.registerItem("glistening_mask", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GLISTENING, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> GLISTENING_CHESTPLATE = ITEMS.registerItem("glistening_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GLISTENING, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> GLISTENING_LEGGINGS = ITEMS.registerItem("glistening_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GLISTENING, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> GLISTENING_BOOTS = ITEMS.registerItem("glistening_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.GLISTENING, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> DEMONIZED_HELMET = ITEMS.registerItem("demonized_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEMONIZED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DEMONIZED_HOOD = ITEMS.registerItem("demonized_hood", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEMONIZED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DEMONIZED_MASK = ITEMS.registerItem("demonized_mask", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEMONIZED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> DEMONIZED_CHESTPLATE = ITEMS.registerItem("demonized_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEMONIZED, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> DEMONIZED_LEGGINGS = ITEMS.registerItem("demonized_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEMONIZED, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> DEMONIZED_BOOTS = ITEMS.registerItem("demonized_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.DEMONIZED, ArmorType.BOOTS).stacksTo(1)));

    public static final DeferredItem<Item> TORMENTED_HELMET = ITEMS.registerItem("tormented_helmet", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORMENTED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> TORMENTED_HOOD = ITEMS.registerItem("tormented_hood", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORMENTED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> TORMENTED_MASK = ITEMS.registerItem("tormented_mask", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORMENTED, ArmorType.HELMET).stacksTo(1)));
    public static final DeferredItem<Item> TORMENTED_CHESTPLATE = ITEMS.registerItem("tormented_chestplate", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORMENTED, ArmorType.CHESTPLATE).stacksTo(1)));
    public static final DeferredItem<Item> TORMENTED_LEGGINGS = ITEMS.registerItem("tormented_leggings", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORMENTED, ArmorType.LEGGINGS).stacksTo(1)));
    public static final DeferredItem<Item> TORMENTED_BOOTS = ITEMS.registerItem("tormented_boots", props -> new ItemMod(props.humanoidArmor(ArmorMaterialRegistry.TORMENTED, ArmorType.BOOTS).stacksTo(1)));

    private static DeferredItem<Item> register(String name) {
        return ITEMS.register(name, () -> new ItemMod(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
    }

    private static DeferredItem<Item> register(String name, Function<Item.Properties, Item> factory) {
        return ITEMS.register(name, () -> factory.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
    }

    private static DeferredItem<Item> registerSeed(String name, Supplier<Block> block) {
        return register(name, properties -> new BlockItem(block.get(), properties.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
    }

    private static DeferredItem<Item> registerEgg(String name, Supplier<EntityType<? extends Mob>> entity) {
        return register(name, properties -> new ItemPetSpawnEgg(properties.spawnEgg(entity.get()).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
    }

    private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return (p) -> {
            return new BlockItem(block, p.useItemDescriptionPrefix());
        };
    }

    private static DeferredItem<Item> registerTool(String name, Function<Item.Properties, Item> factory) {
        return ITEMS.register(name, () -> factory.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
    }
    private static DeferredItem<Item> registerTool(String name) {
        return register(name); //Placeholder until the tool classes are registered
    }

    private static DeferredItem<Item> registerAxe(String name, ToolStats stats, Rarity rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.axe(stats.getMaterial(), 1.0F, -2.4F);
            return new AxeItem(stats.getMaterial(), 1.0F, -2.4F, props);});
    }

    private static DeferredItem<Item> registerAxe(String name, ToolStats stats, Integer rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.axe(stats.getMaterial(), 1.0F, -2.4F);
            return new AxeItem(stats.getMaterial(), 1.0F, -2.4F, props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerHoe(String name, ToolStats stats, Rarity rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new HoeItem(stats.getMaterial(), 1.0F, -2.4F, props);});
    }

    private static DeferredItem<Item> registerHoe(String name, ToolStats stats, Integer rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new HoeItem(stats.getMaterial(), 1.0F, -2.4F, props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerPickaxe(String name, ToolStats stats, Rarity rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.pickaxe(stats.getMaterial(), 1.0F, -2.4F);
            return new Item(props);});
    }

    private static DeferredItem<Item> registerPickaxe(String name, ToolStats stats, Integer rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.pickaxe(stats.getMaterial(), 1.0F, -2.4F);
            return new Item(props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerShovel(String name, ToolStats stats, Rarity rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ShovelItem(stats.getMaterial(), 1.0F, -2.4F, props);});
    }

    private static DeferredItem<Item> registerShovel(String name, ToolStats stats, Integer rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ShovelItem(stats.getMaterial(), 1.0F, -2.4F, props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerSword(String name, ToolStats stats, Rarity rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.sword(stats.getMaterial(), 1.0F, -2.4F);
            return new Item(props);});
    }

    private static DeferredItem<Item> registerSword(String name, ToolStats stats, Integer rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.sword(stats.getMaterial(), 1.0F, -2.4F);
            return new Item(props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerShickaxe(String name, ToolStats stats, Rarity rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ItemShickaxe(stats, props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerShickaxe(String name, ToolStats stats, Integer rarity, boolean fireResistant) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fireResistant) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ItemShickaxe(stats, props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerMaul(String name, ToolStats stats, Rarity rarity, boolean fire) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name))).rarity(rarity);
            if (fire) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.sword(stats.getMaterial(), 1.0F, -2.4F);
            return new ItemMaul(stats.getMaterial(), props);});
    }

    private static DeferredItem<Item> registerMaul(String name, ToolStats stats, Integer rarity, boolean fire) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)));
            if (fire) props.fireResistant();
            if(stats.getMaterial().durability() == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            props.sword(stats.getMaterial(), 1.0F, -2.4F);
            return new ItemMaul(stats.getMaterial(), props) {@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};});
    }

    private static DeferredItem<Item> registerShield(String name, Rarity rarity, TagKey<Item> repair, int durability, String texture) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))
                    .durability(durability)
                    .rarity(rarity)
                    .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
                    .repairable(repair)
                    .equippableUnswappable(EquipmentSlot.OFFHAND)
                    .delayedComponent(DataComponents.BLOCKS_ATTACKS, context -> new BlocksAttacks(0.25F, 1.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)), new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F), Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK)))
                    .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK);
            if(durability == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ShieldItem(props);
        });
    }

    private static DeferredItem<Item> registerShield(String name, Integer rarity, TagKey<Item> repair, int durability, String texture) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))
                    .durability(durability)
                    .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
                    .repairable(repair)
                    .equippableUnswappable(EquipmentSlot.OFFHAND)
                    .delayedComponent(DataComponents.BLOCKS_ATTACKS, context -> new BlocksAttacks(0.25F, 1.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)), new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F), Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK)))
                    .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK);
            if(durability == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ShieldItem(props){@Override public Component getName(ItemStack stack) {return rarity != null ? ((MutableComponent) super.getName(stack)).withColor(rarity) : super.getName(stack);}};
        });
    }

    private static DeferredItem<Item> registerShield(String name, Object repair, int durability, String texture) {
        return ITEMS.register(name, () -> {
            Item.Properties props = new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))
                    .durability(durability)
                    .component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
                    .repairable(ItemTags.WOODEN_TOOL_MATERIALS)
                    .equippableUnswappable(EquipmentSlot.OFFHAND)
                    .delayedComponent(DataComponents.BLOCKS_ATTACKS, context -> new BlocksAttacks(0.25F, 1.0F, List.of(new BlocksAttacks.DamageReduction(90.0F, Optional.empty(), 0.0F, 1.0F)), new BlocksAttacks.ItemDamageFunction(3.0F, 1.0F, 1.0F), Optional.of(context.getOrThrow(DamageTypeTags.BYPASSES_SHIELD)), Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK)))
                    .component(DataComponents.BREAK_SOUND, SoundEvents.SHIELD_BREAK);
            if(durability == -1){props.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);}
            return new ShieldItem(props);
        });
    }

    private static <T extends Item> DeferredItem<T> registerThrowableItem(String registryId, Supplier<T> item) {
        DeferredItem<T> i = ITEMS.register(registryId, item);
        return i;
    }

    public static void load() {}
}