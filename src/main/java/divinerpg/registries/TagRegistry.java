package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TagRegistry {
    //Ammunition
    public static final TagKey<Item>
        ROPE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/rope")),
        GRENADES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/grenades")),
        AQUATIC_CANNON_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/aquatic_cannon")),
        CORRUPTED_CANNON_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/corrupted_cannon")),
        FROST_CANNON_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/frost_cannon")),
        FRACTITE_CANNON_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/fractite_cannon")),
        GOLDEN_FURY_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/golden_fury")),
        EDEN_BLITZ_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/eden_blitz")),
        WILDWOOD_BLITZ_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/wildwood_blitz")),
        APALACHIA_BLITZ_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/apalachia_blitz")),
        SKYTHERN_BLITZ_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/skythern_blitz")),
        MORTUM_BLITZ_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/mortum_blitz")),
        HALITE_BLITZ_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/halite_blitz")),
        VETHEAN_CANNON_AMMO = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "ammo/vethean_cannon"));

    //Rift related Items
    public static final TagKey<Item>
        EDEN_RIFT_REPLENISHING = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_replenishing/eden")),
        WILDWOOD_RIFT_REPLENISHING = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_replenishing/wildwood")),
        APALACHIA_RIFT_REPLENISHING = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_replenishing/apalachia")),
        SKYTHERN_RIFT_REPLENISHING = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_replenishing/skythern")),
        MORTUM_RIFT_REPLENISHING = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_replenishing/mortum"));

    //Crafting Items
    public static final TagKey<Item>
        MAULS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "tools/maul")),
        FURNACES = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "furnaces"));

    //Blocks
    public static final TagKey<Block> GATEWAY_RECEIVER = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "gateway_receiver"));

    //Rift related Blocks
    public static final TagKey<Block>
        EDEN_RIFT_RESONATING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_resonating/eden")),
        WILDWOOD_RIFT_RESONATING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_resonating/wildwood")),
        APALACHIA_RIFT_RESONATING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_resonating/apalachia")),
        SKYTHERN_RIFT_RESONATING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_resonating/skythern")),
        MORTUM_RIFT_RESONATING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rift_resonating/mortum"));

    //Structures
    public static final TagKey<Structure>
        ICEIKA_DUNGEON = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "iceika_dungeon")),
        GRUZZORLUG_RAID_TARGETS = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "gruzzorlug_raid_targets")),
        RAID_TARGETS = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "groglin_raid_targets")),
        WHALE_SKULL = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "whale_skull"));
}