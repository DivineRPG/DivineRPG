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

    //Mob Loot
    //TODO: to use c: tags for some of these instead
        EYES_CYCLOPS = item("eyes/cyclops"),
        CLAWS_CRAB = item("claws/crab"),
        TEETH_LIOPLEURODON = item("teeth/liopleurodon"),
        TEETH_SABEAR = item("teeth/sabear"),
        FINS_SHARK = item("fins/shark"),
        FINS_WHALE = item("fins/whale"),
        SKULLS_LIOPLEURODON = item("skulls/liopleurodon"),
        POWDERS_PURPLE_BLAZE = item("powders/purple_blaze"),
        SNOWFLAKES = item("snowflakes"),

    //Ingots
        INGOTS_AQUATIC = item("ingots/aquatic"),
        INGOTS_REALMITE = item("ingots/realmite"),
        INGOTS_ARLEMITE = item("ingots/arlemite"),
        INGOTS_RUPEE = item("ingots/rupee"),
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
        CHUNKS_BEDROCK = item("chunks/bedrock"),
        CHUNKS_EDEN = item("chunks/eden"),
        CHUNKS_WILDWOOD = item("chunks/wildwood"),
        CHUNKS_APALACHIA = item("chunks/apalachia"),
        CHUNKS_SKYTHERN = item("chunks/skythern"),
        CHUNKS_MORTUM = item("chunks/mortum"),

    //Crafting Items
        TOOLS_MAUL = item("tools/maul"),
        FURNACES = item("furnaces");

    public static final TagKey<Block>
        REPLACEABLE_BY_TREES_ICEIKA = block("replaceable_by_trees/iceika"),
    //General Blocks
        FIRE_BLOCK = block("fire"),
        GATEWAY_RECEIVER = block("gateway_receiver"),

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