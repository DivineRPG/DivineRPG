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
        ROPE = item("ammo/rope"),
        GRENADES = item("ammo/grenades"),
        AQUATIC_CANNON_AMMO = item("ammo/aquatic_cannon"),
        CORRUPTED_CANNON_AMMO = item("ammo/corrupted_cannon"),
        FROST_CANNON_AMMO = item("ammo/frost_cannon"),
        FRACTITE_CANNON_AMMO = item("ammo/fractite_cannon"),
        GOLDEN_FURY_AMMO = item("ammo/golden_fury"),
        EDEN_BLITZ_AMMO = item("ammo/eden_blitz"),
        WILDWOOD_BLITZ_AMMO = item("ammo/wildwood_blitz"),
        APALACHIA_BLITZ_AMMO = item("ammo/apalachia_blitz"),
        SKYTHERN_BLITZ_AMMO = item("ammo/skythern_blitz"),
        MORTUM_BLITZ_AMMO = item("ammo/mortum_blitz"),
        HALITE_BLITZ_AMMO = item("ammo/halite_blitz"),
        VETHEAN_CANNON_AMMO = item("ammo/vethean_cannon"),

    //Rift-related Items
        EDEN_RIFT_REPLENISHING = item("rift_replenishing/eden"),
        WILDWOOD_RIFT_REPLENISHING = item("rift_replenishing/wildwood"),
        APALACHIA_RIFT_REPLENISHING = item("rift_replenishing/apalachia"),
        SKYTHERN_RIFT_REPLENISHING = item("rift_replenishing/skythern"),
        MORTUM_RIFT_REPLENISHING = item("rift_replenishing/mortum"),

    //Mob Loot
        EYES_CYCLOPS = item("eyes/cyclops"),
        CLAWS_CRAB = item("claws/crab"),
        TEETH_LIOPLEURODON = item("teeth/liopleurodon"),
        TEETH_SABEAR = item("teeth/sabear"),
        FINS_SHARK = item("fins/shark"),
        FINS_WHALE = item("fins/whale"),
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
        MAULS = item("tools/maul"),
        FURNACES = item("furnaces");

    public static final TagKey<Block>
    //General Blocks
        FIRE_BLOCK = block("fire"),
        GATEWAY_RECEIVER = block("gateway_receiver"),

    //Rift related Blocks
        EDEN_RIFT_RESONATING = block("rift_resonating/eden"),
        WILDWOOD_RIFT_RESONATING = block("rift_resonating/wildwood"),
        APALACHIA_RIFT_RESONATING = block("rift_resonating/apalachia"),
        SKYTHERN_RIFT_RESONATING = block("rift_resonating/skythern"),
        MORTUM_RIFT_RESONATING = block("rift_resonating/mortum");

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