package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

import static divinerpg.DivineRPG.MODID;

public class TagRegistry {
        public static final TagKey<Item>
                AMMO_ROPE = item("ammo/rope"), AMMO_GRENADE = item("ammo/grenade"),
                AMMO_AQUATIC_CANNON = item("ammo/aquatic_cannon"), AMMO_CORRUPTED_CANNON = item("ammo/corrupted_cannon"),
                AMMO_FROST_CANNON = item("ammo/frost_cannon"), AMMO_FRACTITE_CANNON = item("ammo/fractite_cannon"),
                AMMO_GOLDEN_FURY = item("ammo/golden_fury"), AMMO_EDEN_BLITZ = item("ammo/eden_blitz"),
                AMMO_WILDWOOD_BLITZ = item("ammo/wildwood_blitz"), AMMO_APALACHIA_BLITZ = item("ammo/apalachia_blitz"),
                AMMO_SKYTHERN_BLITZ = item("ammo/skythern_blitz"), AMMO_MORTUM_BLITZ = item("ammo/mortum_blitz"),
                AMMO_HALITE_BLITZ = item("ammo/halite_blitz"), AMMO_VETHEAN_CANNON = item("ammo/vethean_cannon");

    public static final TagKey<Item>
            RIFT_EDEN = item("rift_replenishing/eden"), RIFT_WILDWOOD = item("rift_replenishing/wildwood"),
            RIFT_APALACHIA = item("rift_replenishing/apalachia"), RIFT_SKYTHERN = item("rift_replenishing/skythern"),
            RIFT_MORTUM = item("rift_replenishing/mortum");

    public static final TagKey<Item>
            ENCHANTABLE_ARMOR = minecraftItem("enchantable/armor"), ENCHANTABLE_CHEST = minecraftItem("enchantable/chest_armor"), ENCHANTABLE_FOOT = minecraftItem("enchantable/foot_armor"),
            ENCHANTABLE_HEAD = minecraftItem("enchantable/head_armor"), ENCHANTABLE_LEG = minecraftItem("enchantable/leg_armor"), TRIMMABLE_ARMOR = minecraftItem("trimmable_armor");

        public static final TagKey<Item>
                REPAIR_GOLDEN_FURY = item("repairs/golden_fury"), REPAIR_DIAMOND = item("repairs/equipment/diamond"),
                REPAIR_EXP_GOLD = item("repairs/equipment/expensive/gold"), REPAIR_EXP_REALMITE = item("repairs/equipment/expensive/realmite"),
                REPAIR_EXP_SHADOW = item("repairs/equipment/expensive/shadow"), REPAIR_EXP_TORRIDITE = item("repairs/equipment/expensive/torridite"),
                REPAIR_CYCLOPS = item("repairs/equipment/cyclops"), REPAIR_REALMITE = item("repairs/equipment/realmite"),
                REPAIR_OXDRITE = item("repairs/equipment/oxdrite"), REPAIR_SENG_FUR = item("repairs/equipment/seng_fur"),
                REPAIR_SABEAR_TEETH = item("repairs/equipment/sabear_teeth"), REPAIR_SANTA = item("repairs/equipment/santa"),
                REPAIR_CRAB = item("repairs/equipment/crab"), REPAIR_SHARK = item("repairs/equipment/shark"),
                REPAIR_WHALE = item("repairs/equipment/whale"), REPAIR_LIOPLEURODON = item("repairs/equipment/liopleurodon"),
                REPAIR_AQUATIC = item("repairs/equipment/aquatic"), REPAIR_KRAKEN = item("repairs/equipment/kraken"),
                REPAIR_JACK_O_MAN = item("repairs/equipment/jack_o_man"), REPAIR_SKELEMAN = item("repairs/equipment/skeleman"),
                REPAIR_WITHER_REAPER = item("repairs/equipment/wither_reaper"), REPAIR_ARLEMITE = item("repairs/equipment/arlemite"),
                REPAIR_ICE = item("repairs/equipment/ice"), REPAIR_SNOWFLAKE = item("repairs/equipment/snowflake"),
                REPAIR_JUNGLE = item("repairs/equipment/jungle"), REPAIR_BLOODGEM = item("repairs/equipment/bloodgem"),
                REPAIR_MOLTEN = item("repairs/equipment/molten"), REPAIR_SOULFIRE = item("repairs/equipment/soulfire"),
                REPAIR_BLAZE = item("repairs/equipment/blaze"), REPAIR_PURPLE_BLAZE = item("repairs/equipment/purple_blaze"),
                REPAIR_TORRIDITE = item("repairs/equipment/torridite"), REPAIR_TERRAN = item("repairs/equipment/terran"),
                REPAIR_ANGELIC = item("repairs/equipment/angelic"), REPAIR_SHADOW = item("repairs/equipment/shadow"),
                REPAIR_RUPEE = item("repairs/equipment/rupee"), REPAIR_CORRUPTED = item("repairs/equipment/corrupted"),
                REPAIR_BEDROCK = item("repairs/equipment/bedrock"), REPAIR_ARCANIUM = item("repairs/equipment/arcanium"),
                REPAIR_KORMA = item("repairs/equipment/korma"), REPAIR_VEMOS = item("repairs/equipment/vemos"),
                REPAIR_ENDER = item("repairs/equipment/ender"), REPAIR_DIVINE = item("repairs/equipment/divine"),
                REPAIR_EDEN = item("repairs/equipment/eden"), REPAIR_WILDWOOD = item("repairs/equipment/wildwood"),
                REPAIR_APALACHIA = item("repairs/equipment/apalachia"), REPAIR_SKYTHERN = item("repairs/equipment/skythern"),
                REPAIR_MORTUM = item("repairs/equipment/mortum"), REPAIR_TWILIGHT = item("repairs/equipment/twilight"),
                REPAIR_HALITE = item("repairs/equipment/halite"), REPAIR_AWAKENED_HALITE = item("repairs/equipment/awakened_halite"),
                REPAIR_DREAM = item("repairs/equipment/dream"), REPAIR_TEAKER = item("repairs/equipment/teaker"),
                REPAIR_AMTHIRMIS = item("repairs/equipment/amthirmis"), REPAIR_DARVEN = item("repairs/equipment/darven"),
                REPAIR_CERMILE = item("repairs/equipment/cermile"), REPAIR_PARDIMAL = item("repairs/equipment/pardimal"),
                REPAIR_QUADROTIC = item("repairs/equipment/quadrotic"), REPAIR_KAROS = item("repairs/equipment/karos"),
                REPAIR_HELIOSIS = item("repairs/equipment/heliosis"), REPAIR_ARKSIANE = item("repairs/equipment/arksiane"),
                REPAIR_EVER = item("repairs/equipment/ever"), REPAIR_DEGRADED = item("repairs/equipment/degraded"),
                REPAIR_FINISHED = item("repairs/equipment/finished"), REPAIR_GLISTENING = item("repairs/equipment/glistening"),
                REPAIR_DEMONIZED = item("repairs/equipment/demonized"), REPAIR_TORMENTED = item("repairs/equipment/tormented");

        public static final TagKey<Item>
                SUMMON_KITRA = item("summoning/kitra"), SUMMON_MERIK = item("summoning/captain_merik"),
                SUMMON_DATTICON = item("summoning/datticon"), SUMMON_KAZARI = item("summoning/kazari"),
                SUMMON_LEORNA = item("summoning/leorna"), SUMMON_VATTICUS = item("summoning/lord_vatticus"),
                SUMMON_WAR_GENERAL = item("summoning/war_general"), SUMMON_ZELUS = item("summoning/zelus"),
                SUMMON_SUNSTORM = item("summoning/sunstorm"), SUMMON_TERMASECT = item("summoning/termasect"),
                SUMMON_ARCHER = item("summoning/eternal_archer"), SUMMON_CORI = item("summoning/experienced_cori");

    public static final TagKey<Item>
            FOOD_DOLOSSAL = item("animal_foods/dolossal"), FOOD_MAMOTH = item("animal_foods/mamoth");

    public static final TagKey<Item>
                PET_SNAPPER = item("pet_foods/snapper"), PET_EHU = item("pet_foods/ehu"), PET_HUSK = item("pet_foods/husk"),
                PET_BROWN_GRIZZLE = item("pet_foods/brown_grizzle"), PET_WHITE_GRIZZLE = item("pet_foods/white_grizzle"),
                PET_STONE_GOLEM = item("pet_foods/stone_golem"), PET_SMELTER = item("pet_foods/smelter"),
                PET_HELL_PIG = item("pet_foods/hell_pig"), PET_FYRACRYX = item("pet_foods/fyracryx"),
                PET_REJUVENATION = item("pet_foods/golem_of_rejuvenation"), PET_PARATIKU = item("pet_foods/paratiku"),
                PET_SEIMER = item("pet_foods/seimer"), PET_GLINTHOP = item("pet_foods/glinthop"),
                PET_MOON_WOLF = item("pet_foods/moon_wolf");

        public static final TagKey<Item>
                TAMING_SNAPPER = item("pet_taming_foods/snapper"), TAMING_EHU = item("pet_taming_foods/ehu"),
                TAMING_HUSK = item("pet_taming_foods/husk"), TAMING_BROWN_GRIZZLE = item("pet_taming_foods/brown_grizzle"),
                TAMING_WHITE_GRIZZLE = item("pet_taming_foods/white_grizzle"), TAMING_STONE_GOLEM = item("pet_taming_foods/stone_golem"),
                TAMING_SMELTER = item("pet_taming_foods/smelter"), TAMING_HELL_PIG = item("pet_taming_foods/hell_pig"),
                TAMING_FYRACRYX = item("pet_taming_foods/fyracryx"), TAMING_REJUVENATION = item("pet_taming_foods/golem_of_rejuvenation"),
                TAMING_PARATIKU = item("pet_taming_foods/paratiku"), TAMING_SEIMER = item("pet_taming_foods/seimer"),
                TAMING_GLINTHOP = item("pet_taming_foods/glinthop"), TAMING_MOON_WOLF = item("pet_taming_foods/moon_wolf");

        public static final TagKey<Item>
                TEETH_LIOPLEURODON = item("teeth/liopleurodon"), TEETH_SABEAR = item("teeth/sabear"),
                SKULLS_LIOPLEURODON = item("skulls/liopleurodon"), SKIN_KRAKEN = item("skin/kraken"),
                FUR_SENG = item("fur/seng"), POWDER_PURPLE_BLAZE = item("powders/purple_blaze"),
                SNOWFLAKES = item("snowflakes"),

        INGOT_AQUATIC = common("ingots/aquatic"), INGOT_REALMITE = common("ingots/realmite"),
                INGOT_ARLEMITE = common("ingots/arlemite"), INGOT_RUPEE = common("ingots/rupee"),
                INGOT_SHADOW = common("ingots/shadow"), INGOT_TORRIDITE = common("ingots/torridite"),
    INGOT_HELLSTONE = common("ingots/hellstone"),
                INGOT_OXDRITE = common("ingots/oxdrite"),

                DUST_AQUATIC = common("dusts/aquatic"), DUST_REALMITE = common("dusts/realmite"),
                DUST_ARLEMITE = common("dusts/arlemite"), DUST_RUPEE = common("dusts/rupee"),
                DUST_SHADOW = common("dusts/shadow"), DUST_TORRIDITE = common("dusts/torridite"),
                DUST_OXDRITE = common("dusts/oxdrite"),

        GEM_SHADOW = item("gems/shadow"), GEM_ICE = item("gems/ice"), GEM_TERRAN = item("gems/terran"),
                GEM_JUNGLE = item("gems/jungle"), GEM_MOLTEN = item("gems/molten"), GEM_SOULFIRE = item("gems/soulfire"),
                GEM_CORRUPTED = item("gems/corrupted"), GEM_ENDER = item("gems/ender"), GEM_DIVINE = item("gems/divine"),
                GEM_BLOODGEM = item("gems/bloodgem"), GEM_ARCANIUM = item("gems/arcanium"), GEM_EDEN = item("gems/eden"),
                GEM_WILDWOOD = item("gems/wildwood"), GEM_APALACHIA = item("gems/apalachia"),
                GEM_SKYTHERN = item("gems/skythern"), GEM_MORTUM = item("gems/mortum"),

        SHARDS_TERRAN = item("shards/terran"),

        CHUNK_TORRIDITE = item("chunks/torridite"), CHUNK_BEDROCK = item("chunks/bedrock"),
                CHUNK_EDEN = item("chunks/eden"), CHUNK_WILDWOOD = item("chunks/wildwood"),
                CHUNK_APALACHIA = item("chunks/apalachia"), CHUNK_SKYTHERN = item("chunks/skythern"),
                CHUNK_MORTUM = item("chunks/mortum"), CHUNK_TWILIGHT = item("chunks/twilight"),

        FUEL_COLLECTOR = item("fuels/collector"), STORAGE_REALMITE = common("storage_blocks/realmite"),
                TOOL_MAUL = item("tools/maul"), ARMOR_POUCHES = item("armor_pouches"),
                FROST_CYCLE = item("frosted_allure_cycle_items"), FURNACES = item("furnaces"),

        DIVINE_SWORDS = common("tools/swords/divine"), METAL_SPIKE_BLOCK = item("metal_spike_blocks");

    public static final TagKey<Item> PICKAXES = minecraftItem("pickaxes");
    public static final TagKey<Item> AXES = minecraftItem("axes");
    public static final TagKey<Item> HOES = minecraftItem("hoes");
    public static final TagKey<Item> SHOVELS = minecraftItem("shovels");
    public static final TagKey<Item> SWORDS = minecraftItem("swords");
    public static final TagKey<Item> COMMON_PICKAXES = common("tools/pickaxes");
    public static final TagKey<Item> COMMON_AXES = common("tools/axes");
    public static final TagKey<Item> COMMON_HOES = common("tools/hoes");
    public static final TagKey<Item> COMMON_SHOVELS = common("tools/shovels");
    public static final TagKey<Item> COMMON_SWORDS = common("tools/swords");
    public static final TagKey<Item> SHICKAXES = common("tools/shickaxes");

        public static final TagKey<Item> SHADOW_COIN = item("coins/shadow");

        public static final TagKey<Block>
                MINEABLE_SHICKAXE = block("mineable/shickaxe"), REPLACE_TREE_ICEIKA = block("replaceable_by_trees/iceika"),
                FIRE = block("fire"), GATEWAY_RECEIVER = block("gateway_receiver"), METAL_SPIKE_BLOCKS = block("metal_spike_blocks");

        public static final TagKey<Block>
                INC_AQUATIC = block("incorrect_for_tool/aquatic"), INC_REALMITE = block("incorrect_for_tool/realmite"),
                INC_OXDRITE = block("incorrect_for_tool/oxdrite"), INC_ARLEMITE = block("incorrect_for_tool/arlemite"),
                INC_TERRAN = block("incorrect_for_tool/terran"), INC_JUNGLE = block("incorrect_for_tool/jungle"),
                INC_RUPEE = block("incorrect_for_tool/rupee"), INC_TORRIDITE = block("incorrect_for_tool/torridite"),
                INC_BLOODGEM = block("incorrect_for_tool/bloodgem"), INC_MOLTEN = block("incorrect_for_tool/molten"),
                INC_SOULFIRE = block("incorrect_for_tool/soulfire"), INC_ICE = block("incorrect_for_tool/ice"),
                INC_SHADOW = block("incorrect_for_tool/shadow"), INC_SHADOW_GEM = block("incorrect_for_tool/shadow_gem"),
                INC_BEDROCK = block("incorrect_for_tool/bedrock"), INC_CORRUPTED = block("incorrect_for_tool/corrupted"),
                INC_ENDER = block("incorrect_for_tool/ender"), INC_DIVINE = block("incorrect_for_tool/divine"),
                INC_ARCANIUM = block("incorrect_for_tool/arcanium"), INC_EDEN = block("incorrect_for_tool/eden"),
                INC_WILDWOOD = block("incorrect_for_tool/wildwood"), INC_APALACHIA = block("incorrect_for_tool/apalachia"),
                INC_SKYTHERN = block("incorrect_for_tool/skythern"), INC_MORTUM = block("incorrect_for_tool/mortum"),
                INC_HALITE = block("incorrect_for_tool/halite"), INC_DREAM = block("incorrect_for_tool/dream"),
                INC_TEAKER = block("incorrect_for_tool/teaker"), INC_AMTHIRMIS = block("incorrect_for_tool/amthirmis"),
                INC_DARVEN = block("incorrect_for_tool/darven"), INC_CERMILE = block("incorrect_for_tool/cermile"),
                INC_PARDIMAL = block("incorrect_for_tool/pardimal"), INC_QUADROTIC = block("incorrect_for_tool/quadrotic"),
                INC_KAROS = block("incorrect_for_tool/karos"), INC_HELIOSIS = block("incorrect_for_tool/heliosis"),
                INC_ARKSIANE = block("incorrect_for_tool/arksiane"), INC_EVER = block("incorrect_for_tool/ever");

        public static final TagKey<Block> BASE_ICY_FIRE = block("base_blocks/icy_fire");
        public static final TagKey<Block> APALACHIA_INFINIBURN = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "infiniburn/apalachia"));

        public static final TagKey<Block>
                RIFT_EDEN_BLOCK = block("rift_resonating/eden"), RIFT_WILDWOOD_BLOCK = block("rift_resonating/wildwood"),
                RIFT_APALACHIA_BLOCK = block("rift_resonating/apalachia"), RIFT_SKYTHERN_BLOCK = block("rift_resonating/skythern"),
                RIFT_MORTUM_BLOCK = block("rift_resonating/mortum");

    public static final TagKey<Fluid> SMOLDERING_TAR = fluid("smoldering_tar");
    public static final TagKey<DamageType> AVOIDS_THORNS = damageType("avoids_saguaro_thorns"), MAGE_RESIST = damageType("mage_resistant_to");
    public static final TagKey<Structure>
            ICEIKA_DUNGEON = structure("iceika_dungeon"), GRUZZORLUG_RAID = structure("gruzzorlug_raid_targets"),
            RAID_TARGETS = structure("groglin_raid_targets"), WHALE_SKULL = structure("whale_skull");

    public static final TagKey<Biome> BASALT_DELTAS = biome("basalt_deltas"), CRIMSON_FOREST = biome("crimson_forest"), IS_DEEP_DARK_OR_MUSHROOM = biome("is_deep_dark_or_mushroom"),
            DRIPSTONE_CAVES = biome("dripstone_caves"), NETHER_WASTES = biome("nether_wastes"), SOUL_SAND_VALLEY = biome("soul_sand_valley"), WARM_OCEAN = biome("warm_ocean");

    public static final TagKey<EntityType<?>> OVERWORLD = entityType("creatures/overworld"), NETHER = entityType("creatures/nether"), END = entityType("creatures/end"),
            BEACH = entityType("creatures/overworld/beach"), CAVE = entityType("creatures/overworld/cave"), DESERT = entityType("creatures/overworld/desert"),
            GENERAL = entityType("creatures/overworld/general"), JUNGLE = entityType("creatures/overworld/jungle"), SNOWY = entityType("creatures/overworld/snowy"),
            VISITOR = entityType("creatures/overworld/visitor"), WATER = entityType("creatures/overworld/water"), AQUATIC = entityType("aquatic"),
            BOSSES = entityType("bosses"), JELLYFISH = entityType("jellyfish"), PROJECTILE = entityType("projectile"), SHARKS = entityType("sharks"),
            WHALES = entityType("whales");

    private static TagKey<Item> item(String path) { return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, path)); }
    private static TagKey<Item> minecraftItem(String path) { return TagKey.create(Registries.ITEM, Identifier.parse(path)); }
    private static TagKey<Item> common(String path) { return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path)); }
    private static TagKey<Block> block(String path) { return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, path)); }
    private static TagKey<Fluid> fluid(String path) { return TagKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(MODID, path)); }
    private static TagKey<DamageType> damageType(String path) { return TagKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(MODID, path)); }
    private static TagKey<Structure> structure(String path) { return TagKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(MODID, path)); }
    private static TagKey<Biome> biome(String path) { return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, path)); }
    private static TagKey<EntityType<?>> entityType(String path) { return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MODID, path)); }
}