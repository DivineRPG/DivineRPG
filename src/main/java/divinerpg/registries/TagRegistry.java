package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

public class TagRegistry {
    public static final TagKey<Item>
    //Ammunition
        AMMO_ROPE = item("ammo/rope"),
        AMMO_GRENADE = item("ammo/grenade"),
        AMMO_AQUATIC_CANNON = item("ammo/aquatic_cannon"),
        AMMO_CORRUPTED_CANNON = item("ammo/corrupted_cannon"),
        AMMO_FROST_CANNON = item("ammo/frost_cannon"),
        AMMO_FRACTITE_CANNON = item("ammo/fractite_cannon"),
        AMMO_GOLDEN_FURY = item("ammo/golden_fury"),
        AMMO_EDEN_BLITZ = item("ammo/eden_blitz"),
        AMMO_WILDWOOD_BLITZ = item("ammo/wildwood_blitz"),
        AMMO_APALACHIA_BLITZ = item("ammo/apalachia_blitz"),
        AMMO_SKYTHERN_BLITZ = item("ammo/skythern_blitz"),
        AMMO_MORTUM_BLITZ = item("ammo/mortum_blitz"),
        AMMO_HALITE_BLITZ = item("ammo/halite_blitz"),
        AMMO_VETHEAN_CANNON = item("ammo/vethean_cannon"),

    //Rift-related Items
        RIFT_REPLENISHING_EDEN = item("rift_replenishing/eden"),
        RIFT_REPLENISHING_WILDWOOD = item("rift_replenishing/wildwood"),
        RIFT_REPLENISHING_APALACHIA = item("rift_replenishing/apalachia"),
        RIFT_REPLENISHING_SKYTHERN = item("rift_replenishing/skythern"),
        RIFT_REPLENISHING_MORTUM = item("rift_replenishing/mortum"),

    //Repairs
        REPAIRS_GOLDEN_FURY = item("repairs/golden_fury"),

    //Repairs Equipment
        REPAIRS_EQUIPMENT_DIAMOND = item("repairs/equipment/diamond"),//TODO: to replace with a vanilla tag after moving to a different minecraft version
        REPAIRS_EQUIPMENT_EXPENSIVE_GOLD = item("repairs/equipment/expensive/gold"),
        REPAIRS_EQUIPMENT_EXPENSIVE_REALMITE = item("repairs/equipment/expensive/realmite"),
        REPAIRS_EQUIPMENT_EXPENSIVE_SHADOW = item("repairs/equipment/expensive/shadow"),
        REPAIRS_EQUIPMENT_EXPENSIVE_TORRIDITE = item("repairs/equipment/expensive/torridite"),
        REPAIRS_EQUIPMENT_CYCLOPS = item("repairs/equipment/cyclops"),
        REPAIRS_EQUIPMENT_REALMITE = item("repairs/equipment/realmite"),
        REPAIRS_EQUIPMENT_OXDRITE = item("repairs/equipment/oxdrite"),
        REPAIRS_EQUIPMENT_SENG_FUR = item("repairs/equipment/seng_fur"),
        REPAIRS_EQUIPMENT_SABEAR_TEETH = item("repairs/equipment/sabear_teeth"),
        REPAIRS_EQUIPMENT_SANTA = item("repairs/equipment/santa"),
        REPAIRS_EQUIPMENT_CRAB = item("repairs/equipment/crab"),
        REPAIRS_EQUIPMENT_SHARK = item("repairs/equipment/shark"),
        REPAIRS_EQUIPMENT_WHALE = item("repairs/equipment/whale"),
        REPAIRS_EQUIPMENT_LIOPLEURODON = item("repairs/equipment/liopleurodon"),
        REPAIRS_EQUIPMENT_AQUATIC = item("repairs/equipment/aquatic"),
        REPAIRS_EQUIPMENT_KRAKEN = item("repairs/equipment/kraken"),
        REPAIRS_EQUIPMENT_JACK_O_MAN = item("repairs/equipment/jack_o_man"),
        REPAIRS_EQUIPMENT_SKELEMAN = item("repairs/equipment/skeleman"),
        REPAIRS_EQUIPMENT_WITHER_REAPER = item("repairs/equipment/wither_reaper"),
        REPAIRS_EQUIPMENT_ARLEMITE = item("repairs/equipment/arlemite"),
        REPAIRS_EQUIPMENT_ICE = item("repairs/equipment/ice"),
        REPAIRS_EQUIPMENT_SNOWFLAKE = item("repairs/equipment/snowflake"),
        REPAIRS_EQUIPMENT_JUNGLE = item("repairs/equipment/jungle"),
        REPAIRS_EQUIPMENT_BLOODGEM = item("repairs/equipment/bloodgem"),
        REPAIRS_EQUIPMENT_MOLTEN = item("repairs/equipment/molten"),
        REPAIRS_EQUIPMENT_SOULFIRE = item("repairs/equipment/soulfire"),
        REPAIRS_EQUIPMENT_BLAZE = item("repairs/equipment/blaze"),
        REPAIRS_EQUIPMENT_PURPLE_BLAZE = item("repairs/equipment/purple_blaze"),
        REPAIRS_EQUIPMENT_TORRIDITE = item("repairs/equipment/torridite"),
        REPAIRS_EQUIPMENT_TERRAN = item("repairs/equipment/terran"),
        REPAIRS_EQUIPMENT_ANGELIC = item("repairs/equipment/angelic"),
        REPAIRS_EQUIPMENT_SHADOW = item("repairs/equipment/shadow"),
        REPAIRS_EQUIPMENT_RUPEE = item("repairs/equipment/rupee"),
        REPAIRS_EQUIPMENT_CORRUPTED = item("repairs/equipment/corrupted"),
        REPAIRS_EQUIPMENT_BEDROCK = item("repairs/equipment/bedrock"),
        REPAIRS_EQUIPMENT_ARCANIUM = item("repairs/equipment/arcanium"),
        REPAIRS_EQUIPMENT_KORMA = item("repairs/equipment/korma"),
        REPAIRS_EQUIPMENT_VEMOS = item("repairs/equipment/vemos"),
        REPAIRS_EQUIPMENT_ENDER = item("repairs/equipment/ender"),
        REPAIRS_EQUIPMENT_DIVINE = item("repairs/equipment/divine"),
        REPAIRS_EQUIPMENT_EDEN = item("repairs/equipment/eden"),
        REPAIRS_EQUIPMENT_WILDWOOD = item("repairs/equipment/wildwood"),
        REPAIRS_EQUIPMENT_APALACHIA = item("repairs/equipment/apalachia"),
        REPAIRS_EQUIPMENT_SKYTHERN = item("repairs/equipment/skythern"),
        REPAIRS_EQUIPMENT_MORTUM = item("repairs/equipment/mortum"),
        REPAIRS_EQUIPMENT_TWILIGHT = item("repairs/equipment/twilight"),
        REPAIRS_EQUIPMENT_HALITE = item("repairs/equipment/halite"),
        REPAIRS_EQUIPMENT_AWAKENED_HALITE = item("repairs/equipment/awakened_halite"),
        REPAIRS_EQUIPMENT_DREAM = item("repairs/equipment/dream"),
        REPAIRS_EQUIPMENT_TEAKER = item("repairs/equipment/teaker"),
        REPAIRS_EQUIPMENT_AMTHIRMIS = item("repairs/equipment/amthirmis"),
        REPAIRS_EQUIPMENT_DARVEN = item("repairs/equipment/darven"),
        REPAIRS_EQUIPMENT_CERMILE = item("repairs/equipment/cermile"),
        REPAIRS_EQUIPMENT_PARDIMAL = item("repairs/equipment/pardimal"),
        REPAIRS_EQUIPMENT_QUADROTIC = item("repairs/equipment/quadrotic"),
        REPAIRS_EQUIPMENT_KAROS = item("repairs/equipment/karos"),
        REPAIRS_EQUIPMENT_HELIOSIS = item("repairs/equipment/heliosis"),
        REPAIRS_EQUIPMENT_ARKSIANE = item("repairs/equipment/arksiane"),
        REPAIRS_EQUIPMENT_EVER = item("repairs/equipment/ever"),
        REPAIRS_EQUIPMENT_DEGRADED = item("repairs/equipment/degraded"),
        REPAIRS_EQUIPMENT_FINISHED = item("repairs/equipment/finished"),
        REPAIRS_EQUIPMENT_GLISTENING = item("repairs/equipment/glistening"),
        REPAIRS_EQUIPMENT_DEMONIZED = item("repairs/equipment/demonized"),
        REPAIRS_EQUIPMENT_TORMENTED = item("repairs/equipment/tormented"),

    //Summoning Items
        SUMMONING_KITRA = item("summoning/kitra"),
        SUMMONING_CAPTAIN_MERIK = item("summoning/captain_merik"),
        SUMMONING_DATTICON = item("summoning/datticon"),
        SUMMONING_KAZARI = item("summoning/kazari"),
        SUMMONING_LEORNA = item("summoning/leorna"),
        SUMMONING_LORD_VATTICUS = item("summoning/lord_vatticus"),
        SUMMONING_WAR_GENERAL = item("summoning/war_general"),
        SUMMONING_ZELUS = item("summoning/zelus"),
        SUMMONING_SUNSTORM = item("summoning/sunstorm"),
        SUMMONING_TERMASECT = item("summoning/termasect"),
        SUMMONING_ETERNAL_ARCHER = item("summoning/eternal_archer"),
        SUMMONING_EXPERIENCED_CORI = item("summoning/experienced_cori"),

    //Pet Foods
        PET_FOODS_SNAPPER = item("pet_foods/snapper"),
        PET_FOODS_EHU = item("pet_foods/ehu"),
        PET_FOODS_HUSK = item("pet_foods/husk"),
        PET_FOODS_BROWN_GRIZZLE = item("pet_foods/brown_grizzle"),
        PET_FOODS_WHITE_GRIZZLE = item("pet_foods/white_grizzle"),
        PET_FOODS_STONE_GOLEM = item("pet_foods/stone_golem"),
        PET_FOODS_SMELTER = item("pet_foods/smelter"),
        PET_FOODS_HELL_PIG = item("pet_foods/hell_pig"),
        PET_FOODS_FYRACRYX = item("pet_foods/fyracryx"),
        PET_FOODS_GOLEM_OF_REJUVENATION = item("pet_foods/golem_of_rejuvenation"),
        PET_FOODS_PARATIKU = item("pet_foods/paratiku"),
        PET_FOODS_SEIMER = item("pet_foods/seimer"),
        PET_FOODS_GLINTHOP = item("pet_foods/glinthop"),
        PET_FOODS_MOON_WOLF = item("pet_foods/moon_wolf"),

    //Pet Taming Foods
        PET_TAMING_FOODS_SNAPPER = item("pet_taming_foods/snapper"),
        PET_TAMING_FOODS_EHU = item("pet_taming_foods/ehu"),
        PET_TAMING_FOODS_HUSK = item("pet_taming_foods/husk"),
        PET_TAMING_FOODS_BROWN_GRIZZLE = item("pet_taming_foods/brown_grizzle"),
        PET_TAMING_FOODS_WHITE_GRIZZLE = item("pet_taming_foods/white_grizzle"),
        PET_TAMING_FOODS_STONE_GOLEM = item("pet_taming_foods/stone_golem"),
        PET_TAMING_FOODS_SMELTER = item("pet_taming_foods/smelter"),
        PET_TAMING_FOODS_HELL_PIG = item("pet_taming_foods/hell_pig"),
        PET_TAMING_FOODS_FYRACRYX = item("pet_taming_foods/fyracryx"),
        PET_TAMING_FOODS_GOLEM_OF_REJUVENATION = item("pet_taming_foods/golem_of_rejuvenation"),
        PET_TAMING_FOODS_PARATIKU = item("pet_taming_foods/paratiku"),
        PET_TAMING_FOODS_SEIMER = item("pet_taming_foods/seimer"),
        PET_TAMING_FOODS_GLINTHOP = item("pet_taming_foods/glinthop"),
        //Yet unused, because it uses vanilla wolves behaviour of chewing bones
        PET_TAMING_FOODS_MOON_WOLF = item("pet_taming_foods/moon_wolf"),

    //Mob Loot
        TEETH_LIOPLEURODON = item("teeth/liopleurodon"),
        TEETH_SABEAR = item("teeth/sabear"),
        SKULLS_LIOPLEURODON = item("skulls/liopleurodon"),
        SKIN_KRAKEN = item("skin/kraken"),
        FUR_SENG = item("fur/seng"),
        POWDERS_PURPLE_BLAZE = item("powders/purple_blaze"),
        SNOWFLAKES = item("snowflakes"),

    //Ingots
        INGOTS_AQUATIC = item("ingots/aquatic"),
        INGOTS_REALMITE = item("ingots/realmite"),
        INGOTS_ARLEMITE = item("ingots/arlemite"),
        INGOTS_RUPEE = item("ingots/rupee"),
        INGOTS_SHADOW = item("ingots/shadow"),
        INGOTS_TORRIDITE = item("ingots/torridite"),
        INGOTS_OXDRITE = item("ingots/oxdrite"),

    //Gems
        GEMS_SHADOW = item("gems/shadow"),
        GEMS_ICE = item("gems/ice"),
        GEMS_TERRAN = item("gems/terran"),
        GEMS_JUNGLE = item("gems/jungle"),
        GEMS_MOLTEN = item("gems/molten"),
        GEMS_SOULFIRE = item("gems/soulfire"),
        GEMS_CORRUPTED = item("gems/corrupted"),
        GEMS_ENDER = item("gems/ender"),
        GEMS_DIVINE = item("gems/divine"),
        GEMS_BLOODGEM = item("gems/bloodgem"),
        GEMS_ARCANIUM = item("gems/arcanium"),
        GEMS_EDEN = item("gems/eden"),
        GEMS_WILDWOOD = item("gems/wildwood"),
        GEMS_APALACHIA = item("gems/apalachia"),
        GEMS_SKYTHERN = item("gems/skythern"),
        GEMS_MORTUM = item("gems/mortum"),

    //Chunks
        CHUNKS_TORRIDITE = item("chunks/torridite"),
        CHUNKS_BEDROCK = item("chunks/bedrock"),
        CHUNKS_EDEN = item("chunks/eden"),
        CHUNKS_WILDWOOD = item("chunks/wildwood"),
        CHUNKS_APALACHIA = item("chunks/apalachia"),
        CHUNKS_SKYTHERN = item("chunks/skythern"),
        CHUNKS_MORTUM = item("chunks/mortum"),
        CHUNKS_TWILIGHT = item("chunks/twilight"),

    //Fuels
        FUELS_COLLECTOR = item("fuels/collector"),

    //Storage Blocks
        STORAGE_BLOCKS_REALMITE = item("storage_blocks/realmite"),

    //Tools
        TOOLS_MAUL = item("tools/maul"),

    //Misc
        FROSTED_ALLURE_CYCLE_ITEMS = item("frosted_allure_cycle_items"),
        FURNACES = item("furnaces");

    public static final TagKey<Block>
        MINEABLE_WITH_SHICKAXE = block("mineable/shickaxe"),
        REPLACEABLE_BY_TREES_ICEIKA = block("replaceable_by_trees/iceika"),
        FIRE_BLOCK = block("fire"),
        GATEWAY_RECEIVER = block("gateway_receiver"),

    //Incorrect for Tools
        INCORRECT_FOR_AQUATIC_TOOL = block("incorrect_for_tool/aquatic"),
        INCORRECT_FOR_REALMITE_TOOL = block("incorrect_for_tool/realmite"),
        INCORRECT_FOR_OXDRITE_TOOL = block("incorrect_for_tool/oxdrite"),
        INCORRECT_FOR_ARLEMITE_TOOL = block("incorrect_for_tool/arlemite"),
        INCORRECT_FOR_TERRAN_TOOL = block("incorrect_for_tool/terran"),
        INCORRECT_FOR_JUNGLE_TOOL = block("incorrect_for_tool/jungle"),
        INCORRECT_FOR_RUPEE_TOOL = block("incorrect_for_tool/rupee"),
        INCORRECT_FOR_TORRIDITE_TOOL = block("incorrect_for_tool/torridite"),
        INCORRECT_FOR_BLOODGEM_TOOL = block("incorrect_for_tool/bloodgem"),
        INCORRECT_FOR_MOLTEN_TOOL = block("incorrect_for_tool/molten"),
        INCORRECT_FOR_SOULFIRE_TOOL = block("incorrect_for_tool/soulfire"),
        INCORRECT_FOR_ICE_TOOL = block("incorrect_for_tool/ice"),
        INCORRECT_FOR_SHADOW_TOOL = block("incorrect_for_tool/shadow"),
        INCORRECT_FOR_SHADOW_GEM_TOOL = block("incorrect_for_tool/shadow_gem"),
        INCORRECT_FOR_BEDROCK_TOOL = block("incorrect_for_tool/bedrock"),
        INCORRECT_FOR_CORRUPTED_TOOL = block("incorrect_for_tool/corrupted"),
        INCORRECT_FOR_ENDER_TOOL = block("incorrect_for_tool/ender"),
        INCORRECT_FOR_DIVINE_TOOL = block("incorrect_for_tool/divine"),
        INCORRECT_FOR_ARCANIUM_TOOL = block("incorrect_for_tool/arcanium"),
        INCORRECT_FOR_EDEN_TOOL = block("incorrect_for_tool/eden"),
        INCORRECT_FOR_WILDWOOD_TOOL = block("incorrect_for_tool/wildwood"),
        INCORRECT_FOR_APALACHIA_TOOL = block("incorrect_for_tool/apalachia"),
        INCORRECT_FOR_SKYTHERN_TOOL = block("incorrect_for_tool/skythern"),
        INCORRECT_FOR_MORTUM_TOOL = block("incorrect_for_tool/mortum"),
        INCORRECT_FOR_HALITE_TOOL = block("incorrect_for_tool/halite"),
        INCORRECT_FOR_DREAM_TOOL = block("incorrect_for_tool/dream"),
        INCORRECT_FOR_TEAKER_TOOL = block("incorrect_for_tool/teaker"),
        INCORRECT_FOR_AMTHIRMIS_TOOL = block("incorrect_for_tool/amthirmis"),
        INCORRECT_FOR_DARVEN_TOOL = block("incorrect_for_tool/darven"),
        INCORRECT_FOR_CERMILE_TOOL = block("incorrect_for_tool/cermile"),
        INCORRECT_FOR_PARDIMAL_TOOL = block("incorrect_for_tool/pardimal"),
        INCORRECT_FOR_QUADROTIC_TOOL = block("incorrect_for_tool/quadrotic"),
        INCORRECT_FOR_KAROS_TOOL = block("incorrect_for_tool/karos"),
        INCORRECT_FOR_HELIOSIS_TOOL = block("incorrect_for_tool/heliosis"),
        INCORRECT_FOR_ARKSIANE_TOOL = block("incorrect_for_tool/arksiane"),
        INCORRECT_FOR_EVER_TOOL = block("incorrect_for_tool/ever"),

    //Base Blocks
        BASE_BLOCKS_ICY_FIRE = block("base_blocks/icy_fire"),

    //Rift related Blocks
        RIFT_RESONATING_EDEN = block("rift_resonating/eden"),
        RIFT_RESONATING_WILDWOOD = block("rift_resonating/wildwood"),
        RIFT_RESONATING_APALACHIA = block("rift_resonating/apalachia"),
        RIFT_RESONATING_SKYTHERN = block("rift_resonating/skythern"),
        RIFT_RESONATING_MORTUM = block("rift_resonating/mortum");

    public static final TagKey<Fluid>
        SMOLDERING_TAR = fluid("smoldering_tar");

    public static final TagKey<Structure>
    //Iceika Structures
        ICEIKA_DUNGEON = structure("iceika_dungeon"),
        GRUZZORLUG_RAID_TARGETS = structure("gruzzorlug_raid_targets"),
        RAID_TARGETS = structure("groglin_raid_targets"),
        WHALE_SKULL = structure("whale_skull");
    private static ResourceLocation location(String path) {return ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, path);}
    private static TagKey<Block> block(String path) {return TagKey.create(Registries.BLOCK, location(path));}
    private static TagKey<Fluid> fluid(String path) {return TagKey.create(Registries.FLUID, location(path));}
    private static TagKey<Item> item(String path) {return TagKey.create(Registries.ITEM, location(path));}
    private static TagKey<Structure> structure(String path) {return TagKey.create(Registries.STRUCTURE, location(path));}
}