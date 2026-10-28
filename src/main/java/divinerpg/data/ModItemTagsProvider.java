package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        registerMetalSet("arlemite", ItemRegistry.arlemite_ingot.key(), ItemRegistry.arlemite_nugget.key(), null, BlockRegistry.arlemiteBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_arlemite.key(), ItemRegistry.arlemite_dust.key(), List.of(BlockRegistry.arlemiteOre.asItem().builtInRegistryHolder().key(), BlockRegistry.arlemiteOreDeepslate.asItem().builtInRegistryHolder().key()));
        registerMetalSet("rupee", ItemRegistry.rupee_ingot.key(), ItemRegistry.rupee_nugget.key(),null,BlockRegistry.rupeeBlock.asItem().builtInRegistryHolder().key(),ItemRegistry.raw_rupee.key(), ItemRegistry.rupee_dust.key(),List.of(BlockRegistry.rupeeOre.asItem().builtInRegistryHolder().key(),BlockRegistry.rupeeOreDeepslate.asItem().builtInRegistryHolder().key()));
        registerMetalSet("aquatic", ItemRegistry.aquatic_ingot.key(), null, null, null, null, null, null);
        registerMetalSet("hellstone", ItemRegistry.hellstone_ingot.key(), null, null, null, null, null, null);
        registerMetalSet("shadow", ItemRegistry.shadow_bar.key(), null, null, null, null, ItemRegistry.shadow_dust.key(), null);
        registerMetalSet("bloodgem", null, null, ItemRegistry.bloodgem.key(), BlockRegistry.bloodgemBlock.asItem().builtInRegistryHolder().key(), null, null, List.of(BlockRegistry.bloodgemOre.asItem().builtInRegistryHolder().key()));
        registerMetalSet("oxdrite", ItemRegistry.oxdrite_ingot.key(), ItemRegistry.oxdrite_nugget.key(), null, BlockRegistry.oxdriteBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_oxdrite.key(), ItemRegistry.oxdrite_dust.key(), List.of(BlockRegistry.oxdriteOre.asItem().builtInRegistryHolder().key()));
        registerMetalSet("realmite", ItemRegistry.realmite_ingot.key(), ItemRegistry.realmite_nugget.key(), null, BlockRegistry.realmiteBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_realmite.key(), ItemRegistry.realmite_dust.key(), List.of(BlockRegistry.realmiteOre.asItem().builtInRegistryHolder().key(), BlockRegistry.realmiteOreDeepslate.asItem().builtInRegistryHolder().key()));
        registerMetalSet("torridite", ItemRegistry.torridite_ingot.key(), ItemRegistry.torridite_nugget.key(), null, BlockRegistry.torriditeBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_torridite.key(), ItemRegistry.torridite_dust.key(), List.of(BlockRegistry.torriditeOre.asItem().builtInRegistryHolder().key()));

        tag(commonTag("foods")).addTags(commonTag("foods/white_mushroom"));
        tag(commonTag("foods/white_mushroom")).add(ItemRegistry.white_mushroom.key());
        tag(commonTag("mushrooms")).add(ItemRegistry.white_mushroom.key());
        tag(TagRegistry.SMELTS_LOOT).add(Blocks.COAL_BLOCK.asItem().builtInRegistryHolder().key());

        tag(TagRegistry.REPAIR_REALMITE).add(ItemRegistry.realmite_ingot.key());
        tag(TagRegistry.REPAIR_ARLEMITE).add(ItemRegistry.arlemite_ingot.key());
        tag(TagRegistry.REPAIR_RUPEE).add(ItemRegistry.rupee_ingot.key());
        tag(TagRegistry.REPAIR_ICE).add(ItemRegistry.ice_shards.key());
        tag(TagRegistry.REPAIR_ENDER).add(ItemRegistry.ender_shards.key());
        tag(TagRegistry.DIVINE_SWORDS).add(ItemRegistry.divine_sword.key(), ItemRegistry.red_divine_sword.key(), ItemRegistry.yellow_divine_sword.key(), ItemRegistry.green_divine_sword.key(), ItemRegistry.gray_divine_sword.key(), ItemRegistry.blue_divine_sword.key());
        tag(TagRegistry.ARMOR_POUCHES).add(ItemRegistry.armor_pouch.key(), ItemRegistry.red_armor_pouch.key(), ItemRegistry.yellow_armor_pouch.key(), ItemRegistry.green_armor_pouch.key(), ItemRegistry.gray_armor_pouch.key(), ItemRegistry.blue_armor_pouch.key());
        tag(TagRegistry.SHADOW_COIN).add(ItemRegistry.shadow_coins.key());

        tag(TagRegistry.CHUNK_BEDROCK).add(ItemRegistry.bedrock_chunk.key());
        tag(TagRegistry.GEM_SHADOW).add(ItemRegistry.shadow_stone.key());
        tag(TagRegistry.GEM_SOULFIRE).add(ItemRegistry.soulfire_stone.key());
        tag(TagRegistry.TOOL_MAUL).add(ItemRegistry.aquatic_maul.key(), ItemRegistry.aquatooth_maul.key(), ItemRegistry.bedrock_maul.key(), ItemRegistry.corrupted_maul.key(), ItemRegistry.crabclaw_maul.key(), ItemRegistry.frozen_maul.key(), ItemRegistry.fury_maul.key(), ItemRegistry.realmite_maul.key(), ItemRegistry.terran_maul.key());
        tag(TagRegistry.METAL_SPIKE_BLOCK).add(BlockRegistry.spikeBlock.asItem().builtInRegistryHolder().key(), BlockRegistry.hotSpikeBlock.asItem().builtInRegistryHolder().key());

        tag(ItemTags.WALLS).add(BlockRegistry.cobaltiteWall.asItem().builtInRegistryHolder().key(), BlockRegistry.coalstoneWall.asItem().builtInRegistryHolder().key(), BlockRegistry.arcaniteWall.asItem().builtInRegistryHolder().key());

        tag(TagRegistry.ENCHANTABLE_ARMOR).addTags(TagRegistry.ENCHANTABLE_CHEST, TagRegistry.ENCHANTABLE_FOOT, TagRegistry.ENCHANTABLE_HEAD, TagRegistry.ENCHANTABLE_LEG);
        tag(TagRegistry.ENCHANTABLE_HEAD).add(ItemRegistry.REALMITE_HELMET.key(), ItemRegistry.SENG_FUR_HELMET.key(), ItemRegistry.SANTA_HELMET.key(), ItemRegistry.AQUASTRIVE_HELMET.key(), ItemRegistry.KRAKEN_HELMET.key(), ItemRegistry.JACK_O_MAN_HELMET.key(), ItemRegistry.SKELEMAN_HELMET.key(), ItemRegistry.WITHER_REAPER_HELMET.key(), ItemRegistry.ARLEMITE_HELMET.key(), ItemRegistry.FROZEN_HELMET.key(), ItemRegistry.JUNGLE_HELMET.key(), ItemRegistry.INFERNO_HELMET.key(), ItemRegistry.TORRIDITE_HELMET.key(), ItemRegistry.TERRAN_HELMET.key(), ItemRegistry.ANGELIC_HELMET.key(), ItemRegistry.SHADOW_HELMET.key(), ItemRegistry.RUPEE_HELMET.key(), ItemRegistry.RED_RUPEE_HELMET.key(), ItemRegistry.YELLOW_RUPEE_HELMET.key(), ItemRegistry.GREEN_RUPEE_HELMET.key(), ItemRegistry.BLUE_RUPEE_HELMET.key(), ItemRegistry.GRAY_RUPEE_HELMET.key(), ItemRegistry.ELITE_REALMITE_HELMET.key(), ItemRegistry.CORRUPTED_HELMET.key(), ItemRegistry.BEDROCK_HELMET.key(), ItemRegistry.KORMA_HELMET.key(), ItemRegistry.VEMOS_HELMET.key(), ItemRegistry.ENDER_HELMET.key(), ItemRegistry.RED_ENDER_HELMET.key(), ItemRegistry.YELLOW_ENDER_HELMET.key(), ItemRegistry.GREEN_ENDER_HELMET.key(), ItemRegistry.BLUE_ENDER_HELMET.key(), ItemRegistry.GRAY_ENDER_HELMET.key(), ItemRegistry.DIVINE_HELMET.key(), ItemRegistry.EDEN_HELMET.key(), ItemRegistry.WILDWOOD_HELMET.key(), ItemRegistry.APALACHIA_HELMET.key(), ItemRegistry.SKYTHERN_HELMET.key(), ItemRegistry.MORTUM_HELMET.key(), ItemRegistry.HALITE_HELMET.key(), ItemRegistry.AWAKENED_HALITE_HELMET.key(), ItemRegistry.DEGRADED_HELMET.key(), ItemRegistry.DEGRADED_HOOD.key(), ItemRegistry.DEGRADED_MASK.key(), ItemRegistry.FINISHED_HELMET.key(), ItemRegistry.FINISHED_HOOD.key(), ItemRegistry.FINISHED_MASK.key(), ItemRegistry.GLISTENING_HELMET.key(), ItemRegistry.GLISTENING_HOOD.key(), ItemRegistry.GLISTENING_MASK.key(), ItemRegistry.DEMONIZED_HELMET.key(), ItemRegistry.DEMONIZED_MASK.key(), ItemRegistry.DEMONIZED_HOOD.key(), ItemRegistry.TORMENTED_HELMET.key(), ItemRegistry.TORMENTED_HOOD.key(), ItemRegistry.TORMENTED_MASK.key());
        tag(TagRegistry.ENCHANTABLE_CHEST).add(ItemRegistry.REALMITE_CHESTPLATE.key(), ItemRegistry.SENG_FUR_CHESTPLATE.key(), ItemRegistry.SANTA_CHESTPLATE.key(), ItemRegistry.AQUASTRIVE_CHESTPLATE.key(), ItemRegistry.KRAKEN_CHESTPLATE.key(), ItemRegistry.JACK_O_MAN_CHESTPLATE.key(), ItemRegistry.SKELEMAN_CHESTPLATE.key(), ItemRegistry.WITHER_REAPER_CHESTPLATE.key(), ItemRegistry.ARLEMITE_CHESTPLATE.key(), ItemRegistry.FROZEN_CHESTPLATE.key(), ItemRegistry.JUNGLE_CHESTPLATE.key(), ItemRegistry.INFERNO_CHESTPLATE.key(), ItemRegistry.TORRIDITE_CHESTPLATE.key(), ItemRegistry.TERRAN_CHESTPLATE.key(), ItemRegistry.ANGELIC_CHESTPLATE.key(), ItemRegistry.SHADOW_CHESTPLATE.key(), ItemRegistry.RUPEE_CHESTPLATE.key(), ItemRegistry.RED_RUPEE_CHESTPLATE.key(), ItemRegistry.YELLOW_RUPEE_CHESTPLATE.key(), ItemRegistry.GREEN_RUPEE_CHESTPLATE.key(), ItemRegistry.BLUE_RUPEE_CHESTPLATE.key(), ItemRegistry.GRAY_RUPEE_CHESTPLATE.key(), ItemRegistry.ELITE_REALMITE_CHESTPLATE.key(), ItemRegistry.CORRUPTED_CHESTPLATE.key(), ItemRegistry.BEDROCK_CHESTPLATE.key(), ItemRegistry.KORMA_CHESTPLATE.key(), ItemRegistry.VEMOS_CHESTPLATE.key(), ItemRegistry.ENDER_CHESTPLATE.key(), ItemRegistry.RED_ENDER_CHESTPLATE.key(), ItemRegistry.YELLOW_ENDER_CHESTPLATE.key(), ItemRegistry.GREEN_ENDER_CHESTPLATE.key(), ItemRegistry.BLUE_ENDER_CHESTPLATE.key(), ItemRegistry.GRAY_ENDER_CHESTPLATE.key(), ItemRegistry.DIVINE_CHESTPLATE.key(), ItemRegistry.EDEN_CHESTPLATE.key(), ItemRegistry.WILDWOOD_CHESTPLATE.key(), ItemRegistry.APALACHIA_CHESTPLATE.key(), ItemRegistry.SKYTHERN_CHESTPLATE.key(), ItemRegistry.MORTUM_CHESTPLATE.key(), ItemRegistry.HALITE_CHESTPLATE.key(), ItemRegistry.AWAKENED_HALITE_CHESTPLATE.key(), ItemRegistry.DEGRADED_CHESTPLATE.key(), ItemRegistry.FINISHED_CHESTPLATE.key(), ItemRegistry.GLISTENING_CHESTPLATE.key(), ItemRegistry.DEMONIZED_CHESTPLATE.key(), ItemRegistry.TORMENTED_CHESTPLATE.key());
        tag(TagRegistry.ENCHANTABLE_LEG).add(ItemRegistry.REALMITE_LEGGINGS.key(), ItemRegistry.SENG_FUR_LEGGINGS.key(), ItemRegistry.SANTA_LEGGINGS.key(), ItemRegistry.AQUASTRIVE_LEGGINGS.key(), ItemRegistry.KRAKEN_LEGGINGS.key(), ItemRegistry.JACK_O_MAN_LEGGINGS.key(), ItemRegistry.SKELEMAN_LEGGINGS.key(), ItemRegistry.WITHER_REAPER_LEGGINGS.key(), ItemRegistry.ARLEMITE_LEGGINGS.key(), ItemRegistry.FROZEN_LEGGINGS.key(), ItemRegistry.JUNGLE_LEGGINGS.key(), ItemRegistry.INFERNO_LEGGINGS.key(), ItemRegistry.TORRIDITE_LEGGINGS.key(), ItemRegistry.TERRAN_LEGGINGS.key(), ItemRegistry.ANGELIC_LEGGINGS.key(), ItemRegistry.SHADOW_LEGGINGS.key(), ItemRegistry.RUPEE_LEGGINGS.key(), ItemRegistry.RED_RUPEE_LEGGINGS.key(), ItemRegistry.YELLOW_RUPEE_LEGGINGS.key(), ItemRegistry.GREEN_RUPEE_LEGGINGS.key(), ItemRegistry.BLUE_RUPEE_LEGGINGS.key(), ItemRegistry.GRAY_RUPEE_LEGGINGS.key(), ItemRegistry.ELITE_REALMITE_LEGGINGS.key(), ItemRegistry.CORRUPTED_LEGGINGS.key(), ItemRegistry.BEDROCK_LEGGINGS.key(), ItemRegistry.KORMA_LEGGINGS.key(), ItemRegistry.VEMOS_LEGGINGS.key(), ItemRegistry.ENDER_LEGGINGS.key(), ItemRegistry.RED_ENDER_LEGGINGS.key(), ItemRegistry.YELLOW_ENDER_LEGGINGS.key(), ItemRegistry.GREEN_ENDER_LEGGINGS.key(), ItemRegistry.BLUE_ENDER_LEGGINGS.key(), ItemRegistry.GRAY_ENDER_LEGGINGS.key(), ItemRegistry.DIVINE_LEGGINGS.key(), ItemRegistry.EDEN_LEGGINGS.key(), ItemRegistry.WILDWOOD_LEGGINGS.key(), ItemRegistry.APALACHIA_LEGGINGS.key(), ItemRegistry.SKYTHERN_LEGGINGS.key(), ItemRegistry.MORTUM_LEGGINGS.key(), ItemRegistry.HALITE_LEGGINGS.key(), ItemRegistry.AWAKENED_HALITE_LEGGINGS.key(), ItemRegistry.DEGRADED_LEGGINGS.key(), ItemRegistry.FINISHED_LEGGINGS.key(), ItemRegistry.GLISTENING_LEGGINGS.key(), ItemRegistry.DEMONIZED_LEGGINGS.key(), ItemRegistry.TORMENTED_LEGGINGS.key());
        tag(TagRegistry.ENCHANTABLE_FOOT).add(ItemRegistry.REALMITE_BOOTS.key(), ItemRegistry.SENG_FUR_BOOTS.key(), ItemRegistry.SANTA_BOOTS.key(), ItemRegistry.AQUASTRIVE_BOOTS.key(), ItemRegistry.KRAKEN_BOOTS.key(), ItemRegistry.JACK_O_MAN_BOOTS.key(), ItemRegistry.SKELEMAN_BOOTS.key(), ItemRegistry.WITHER_REAPER_BOOTS.key(), ItemRegistry.ARLEMITE_BOOTS.key(), ItemRegistry.FROZEN_BOOTS.key(), ItemRegistry.JUNGLE_BOOTS.key(), ItemRegistry.INFERNO_BOOTS.key(), ItemRegistry.TORRIDITE_BOOTS.key(), ItemRegistry.TERRAN_BOOTS.key(), ItemRegistry.ANGELIC_BOOTS.key(), ItemRegistry.SHADOW_BOOTS.key(), ItemRegistry.RUPEE_BOOTS.key(), ItemRegistry.RED_RUPEE_BOOTS.key(), ItemRegistry.YELLOW_RUPEE_BOOTS.key(), ItemRegistry.GREEN_RUPEE_BOOTS.key(), ItemRegistry.BLUE_RUPEE_BOOTS.key(), ItemRegistry.GRAY_RUPEE_BOOTS.key(), ItemRegistry.ELITE_REALMITE_BOOTS.key(), ItemRegistry.CORRUPTED_BOOTS.key(), ItemRegistry.BEDROCK_BOOTS.key(), ItemRegistry.KORMA_BOOTS.key(), ItemRegistry.VEMOS_BOOTS.key(), ItemRegistry.ENDER_BOOTS.key(), ItemRegistry.RED_ENDER_BOOTS.key(), ItemRegistry.YELLOW_ENDER_BOOTS.key(), ItemRegistry.GREEN_ENDER_BOOTS.key(), ItemRegistry.BLUE_ENDER_BOOTS.key(), ItemRegistry.GRAY_ENDER_BOOTS.key(), ItemRegistry.DIVINE_BOOTS.key(), ItemRegistry.EDEN_BOOTS.key(), ItemRegistry.WILDWOOD_BOOTS.key(), ItemRegistry.APALACHIA_BOOTS.key(), ItemRegistry.SKYTHERN_BOOTS.key(), ItemRegistry.MORTUM_BOOTS.key(), ItemRegistry.HALITE_BOOTS.key(), ItemRegistry.AWAKENED_HALITE_BOOTS.key(), ItemRegistry.DEGRADED_BOOTS.key(), ItemRegistry.FINISHED_BOOTS.key(), ItemRegistry.GLISTENING_BOOTS.key(), ItemRegistry.DEMONIZED_BOOTS.key(), ItemRegistry.TORMENTED_BOOTS.key());
        tag(TagRegistry.TRIMMABLE_ARMOR).add(ItemRegistry.REALMITE_HELMET.key(), ItemRegistry.SENG_FUR_HELMET.key(), ItemRegistry.SANTA_HELMET.key(), ItemRegistry.AQUASTRIVE_HELMET.key(), ItemRegistry.KRAKEN_HELMET.key(), ItemRegistry.JACK_O_MAN_HELMET.key(), ItemRegistry.SKELEMAN_HELMET.key(), ItemRegistry.WITHER_REAPER_HELMET.key(), ItemRegistry.ARLEMITE_HELMET.key(), ItemRegistry.FROZEN_HELMET.key(), ItemRegistry.JUNGLE_HELMET.key(), ItemRegistry.INFERNO_HELMET.key(), ItemRegistry.TORRIDITE_HELMET.key(), ItemRegistry.TERRAN_HELMET.key(), ItemRegistry.ANGELIC_HELMET.key(), ItemRegistry.SHADOW_HELMET.key(), ItemRegistry.RUPEE_HELMET.key(), ItemRegistry.RED_RUPEE_HELMET.key(), ItemRegistry.YELLOW_RUPEE_HELMET.key(), ItemRegistry.GREEN_RUPEE_HELMET.key(), ItemRegistry.BLUE_RUPEE_HELMET.key(), ItemRegistry.GRAY_RUPEE_HELMET.key(), ItemRegistry.ELITE_REALMITE_HELMET.key(), ItemRegistry.CORRUPTED_HELMET.key(), ItemRegistry.BEDROCK_HELMET.key(), ItemRegistry.KORMA_HELMET.key(), ItemRegistry.VEMOS_HELMET.key(), ItemRegistry.ENDER_HELMET.key(), ItemRegistry.RED_ENDER_HELMET.key(), ItemRegistry.YELLOW_ENDER_HELMET.key(), ItemRegistry.GREEN_ENDER_HELMET.key(), ItemRegistry.BLUE_ENDER_HELMET.key(), ItemRegistry.GRAY_ENDER_HELMET.key(), ItemRegistry.DIVINE_HELMET.key(), ItemRegistry.EDEN_HELMET.key(), ItemRegistry.WILDWOOD_HELMET.key(), ItemRegistry.APALACHIA_HELMET.key(), ItemRegistry.SKYTHERN_HELMET.key(), ItemRegistry.MORTUM_HELMET.key(), ItemRegistry.HALITE_HELMET.key(), ItemRegistry.AWAKENED_HALITE_HELMET.key(), ItemRegistry.DEGRADED_HELMET.key(), ItemRegistry.DEGRADED_HOOD.key(), ItemRegistry.DEGRADED_MASK.key(), ItemRegistry.FINISHED_HELMET.key(), ItemRegistry.FINISHED_HOOD.key(), ItemRegistry.FINISHED_MASK.key(), ItemRegistry.GLISTENING_HELMET.key(), ItemRegistry.GLISTENING_HOOD.key(), ItemRegistry.GLISTENING_MASK.key(), ItemRegistry.DEMONIZED_HELMET.key(), ItemRegistry.DEMONIZED_MASK.key(), ItemRegistry.DEMONIZED_HOOD.key(), ItemRegistry.TORMENTED_HELMET.key(), ItemRegistry.TORMENTED_HOOD.key(), ItemRegistry.TORMENTED_MASK.key(), ItemRegistry.REALMITE_CHESTPLATE.key(), ItemRegistry.SENG_FUR_CHESTPLATE.key(), ItemRegistry.SANTA_CHESTPLATE.key(), ItemRegistry.AQUASTRIVE_CHESTPLATE.key(), ItemRegistry.KRAKEN_CHESTPLATE.key(), ItemRegistry.JACK_O_MAN_CHESTPLATE.key(), ItemRegistry.SKELEMAN_CHESTPLATE.key(), ItemRegistry.WITHER_REAPER_CHESTPLATE.key(), ItemRegistry.ARLEMITE_CHESTPLATE.key(), ItemRegistry.FROZEN_CHESTPLATE.key(), ItemRegistry.JUNGLE_CHESTPLATE.key(), ItemRegistry.INFERNO_CHESTPLATE.key(), ItemRegistry.TORRIDITE_CHESTPLATE.key(), ItemRegistry.TERRAN_CHESTPLATE.key(), ItemRegistry.ANGELIC_CHESTPLATE.key(), ItemRegistry.SHADOW_CHESTPLATE.key(), ItemRegistry.RUPEE_CHESTPLATE.key(), ItemRegistry.RED_RUPEE_CHESTPLATE.key(), ItemRegistry.YELLOW_RUPEE_CHESTPLATE.key(), ItemRegistry.GREEN_RUPEE_CHESTPLATE.key(), ItemRegistry.BLUE_RUPEE_CHESTPLATE.key(), ItemRegistry.GRAY_RUPEE_CHESTPLATE.key(), ItemRegistry.ELITE_REALMITE_CHESTPLATE.key(), ItemRegistry.CORRUPTED_CHESTPLATE.key(), ItemRegistry.BEDROCK_CHESTPLATE.key(), ItemRegistry.KORMA_CHESTPLATE.key(), ItemRegistry.VEMOS_CHESTPLATE.key(), ItemRegistry.ENDER_CHESTPLATE.key(), ItemRegistry.RED_ENDER_CHESTPLATE.key(), ItemRegistry.YELLOW_ENDER_CHESTPLATE.key(), ItemRegistry.GREEN_ENDER_CHESTPLATE.key(), ItemRegistry.BLUE_ENDER_CHESTPLATE.key(), ItemRegistry.GRAY_ENDER_CHESTPLATE.key(), ItemRegistry.DIVINE_CHESTPLATE.key(), ItemRegistry.EDEN_CHESTPLATE.key(), ItemRegistry.WILDWOOD_CHESTPLATE.key(), ItemRegistry.APALACHIA_CHESTPLATE.key(), ItemRegistry.SKYTHERN_CHESTPLATE.key(), ItemRegistry.MORTUM_CHESTPLATE.key(), ItemRegistry.HALITE_CHESTPLATE.key(), ItemRegistry.AWAKENED_HALITE_CHESTPLATE.key(), ItemRegistry.DEGRADED_CHESTPLATE.key(), ItemRegistry.FINISHED_CHESTPLATE.key(), ItemRegistry.GLISTENING_CHESTPLATE.key(), ItemRegistry.DEMONIZED_CHESTPLATE.key(), ItemRegistry.TORMENTED_CHESTPLATE.key(), ItemRegistry.REALMITE_LEGGINGS.key(), ItemRegistry.SENG_FUR_LEGGINGS.key(), ItemRegistry.SANTA_LEGGINGS.key(), ItemRegistry.AQUASTRIVE_LEGGINGS.key(), ItemRegistry.KRAKEN_LEGGINGS.key(), ItemRegistry.JACK_O_MAN_LEGGINGS.key(), ItemRegistry.SKELEMAN_LEGGINGS.key(), ItemRegistry.WITHER_REAPER_LEGGINGS.key(), ItemRegistry.ARLEMITE_LEGGINGS.key(), ItemRegistry.FROZEN_LEGGINGS.key(), ItemRegistry.JUNGLE_LEGGINGS.key(), ItemRegistry.INFERNO_LEGGINGS.key(), ItemRegistry.TORRIDITE_LEGGINGS.key(), ItemRegistry.TERRAN_LEGGINGS.key(), ItemRegistry.ANGELIC_LEGGINGS.key(), ItemRegistry.SHADOW_LEGGINGS.key(), ItemRegistry.RUPEE_LEGGINGS.key(), ItemRegistry.RED_RUPEE_LEGGINGS.key(), ItemRegistry.YELLOW_RUPEE_LEGGINGS.key(), ItemRegistry.GREEN_RUPEE_LEGGINGS.key(), ItemRegistry.BLUE_RUPEE_LEGGINGS.key(), ItemRegistry.GRAY_RUPEE_LEGGINGS.key(), ItemRegistry.ELITE_REALMITE_LEGGINGS.key(), ItemRegistry.CORRUPTED_LEGGINGS.key(), ItemRegistry.BEDROCK_LEGGINGS.key(), ItemRegistry.KORMA_LEGGINGS.key(), ItemRegistry.VEMOS_LEGGINGS.key(), ItemRegistry.ENDER_LEGGINGS.key(), ItemRegistry.RED_ENDER_LEGGINGS.key(), ItemRegistry.YELLOW_ENDER_LEGGINGS.key(), ItemRegistry.GREEN_ENDER_LEGGINGS.key(), ItemRegistry.BLUE_ENDER_LEGGINGS.key(), ItemRegistry.GRAY_ENDER_LEGGINGS.key(), ItemRegistry.DIVINE_LEGGINGS.key(), ItemRegistry.EDEN_LEGGINGS.key(), ItemRegistry.WILDWOOD_LEGGINGS.key(), ItemRegistry.APALACHIA_LEGGINGS.key(), ItemRegistry.SKYTHERN_LEGGINGS.key(), ItemRegistry.MORTUM_LEGGINGS.key(), ItemRegistry.HALITE_LEGGINGS.key(), ItemRegistry.AWAKENED_HALITE_LEGGINGS.key(), ItemRegistry.DEGRADED_LEGGINGS.key(), ItemRegistry.FINISHED_LEGGINGS.key(), ItemRegistry.GLISTENING_LEGGINGS.key(), ItemRegistry.DEMONIZED_LEGGINGS.key(), ItemRegistry.TORMENTED_LEGGINGS.key(), ItemRegistry.REALMITE_BOOTS.key(), ItemRegistry.SENG_FUR_BOOTS.key(), ItemRegistry.SANTA_BOOTS.key(), ItemRegistry.AQUASTRIVE_BOOTS.key(), ItemRegistry.KRAKEN_BOOTS.key(), ItemRegistry.JACK_O_MAN_BOOTS.key(), ItemRegistry.SKELEMAN_BOOTS.key(), ItemRegistry.WITHER_REAPER_BOOTS.key(), ItemRegistry.ARLEMITE_BOOTS.key(), ItemRegistry.FROZEN_BOOTS.key(), ItemRegistry.JUNGLE_BOOTS.key(), ItemRegistry.INFERNO_BOOTS.key(), ItemRegistry.TORRIDITE_BOOTS.key(), ItemRegistry.TERRAN_BOOTS.key(), ItemRegistry.ANGELIC_BOOTS.key(), ItemRegistry.SHADOW_BOOTS.key(), ItemRegistry.RUPEE_BOOTS.key(), ItemRegistry.RED_RUPEE_BOOTS.key(), ItemRegistry.YELLOW_RUPEE_BOOTS.key(), ItemRegistry.GREEN_RUPEE_BOOTS.key(), ItemRegistry.BLUE_RUPEE_BOOTS.key(), ItemRegistry.GRAY_RUPEE_BOOTS.key(), ItemRegistry.ELITE_REALMITE_BOOTS.key(), ItemRegistry.CORRUPTED_BOOTS.key(), ItemRegistry.BEDROCK_BOOTS.key(), ItemRegistry.KORMA_BOOTS.key(), ItemRegistry.VEMOS_BOOTS.key(), ItemRegistry.ENDER_BOOTS.key(), ItemRegistry.RED_ENDER_BOOTS.key(), ItemRegistry.YELLOW_ENDER_BOOTS.key(), ItemRegistry.GREEN_ENDER_BOOTS.key(), ItemRegistry.BLUE_ENDER_BOOTS.key(), ItemRegistry.GRAY_ENDER_BOOTS.key(), ItemRegistry.DIVINE_BOOTS.key(), ItemRegistry.EDEN_BOOTS.key(), ItemRegistry.WILDWOOD_BOOTS.key(), ItemRegistry.APALACHIA_BOOTS.key(), ItemRegistry.SKYTHERN_BOOTS.key(), ItemRegistry.MORTUM_BOOTS.key(), ItemRegistry.HALITE_BOOTS.key(), ItemRegistry.AWAKENED_HALITE_BOOTS.key(), ItemRegistry.DEGRADED_BOOTS.key(), ItemRegistry.FINISHED_BOOTS.key(), ItemRegistry.GLISTENING_BOOTS.key(), ItemRegistry.DEMONIZED_BOOTS.key(), ItemRegistry.TORMENTED_BOOTS.key());

        tag(TagRegistry.SNOWFLAKES).add(ItemRegistry.snowflake.key());
        tag(customTag("fur/seng")).add(ItemRegistry.seng_fur.key());
        tag(customTag("lumps/amthirmis")).add(ItemRegistry.amthirmis_lump.key());
        tag(customTag("lumps/cermile")).add(ItemRegistry.cermile_lump.key());

        tag(TagRegistry.SMELTABLE_GOLD_COMPRESSED).add(ItemRegistry.golden_fury.key());
        tag(TagRegistry.SMELTABLE_REALMITE_COMPRESSED).add(ItemRegistry.ELITE_REALMITE_HELMET.key(), ItemRegistry.ELITE_REALMITE_CHESTPLATE.key(), ItemRegistry.ELITE_REALMITE_LEGGINGS.key(), ItemRegistry.ELITE_REALMITE_BOOTS.key());
        tag(TagRegistry.SMELTABLE_TORRIDITE_COMPRESSED).add(ItemRegistry.TORRIDITE_HELMET.key(), ItemRegistry.TORRIDITE_CHESTPLATE.key(), ItemRegistry.TORRIDITE_LEGGINGS.key(), ItemRegistry.TORRIDITE_BOOTS.key());

        tag(TagRegistry.SMELTABLE_APALACHIA).add(ItemRegistry.apalachia_pickaxe.key(), ItemRegistry.apalachia_shovel.key(), ItemRegistry.apalachia_axe.key(), ItemRegistry.apalachia_hoe.key(), ItemRegistry.apalachia_shickaxe.key(), ItemRegistry.apalachia_blade.key(), ItemRegistry.apalachia_bow.key(), ItemRegistry.apalachia_phaser.key(), ItemRegistry.apalachia_blitz.key(), ItemRegistry.apalachia_shield.key(), ItemRegistry.APALACHIA_BOOTS.key(), ItemRegistry.APALACHIA_LEGGINGS.key(), ItemRegistry.APALACHIA_CHESTPLATE.key(), ItemRegistry.APALACHIA_HELMET.key());
        tag(TagRegistry.SMELTABLE_ARLEMITE).add(ItemRegistry.arlemite_pickaxe.key(), ItemRegistry.arlemite_shovel.key(), ItemRegistry.arlemite_axe.key(), ItemRegistry.arlemite_hoe.key(), ItemRegistry.arlemite_shickaxe.key(), ItemRegistry.arlemite_stabber.key(), ItemRegistry.arlemite_shield.key(), ItemRegistry.ARLEMITE_BOOTS.key(), ItemRegistry.ARLEMITE_LEGGINGS.key(), ItemRegistry.ARLEMITE_CHESTPLATE.key(), ItemRegistry.ARLEMITE_HELMET.key());
        tag(TagRegistry.SMELTABLE_CORRUPTED).add(ItemRegistry.corrupted_pickaxe.key(), ItemRegistry.corrupted_shovel.key(), ItemRegistry.corrupted_axe.key(), ItemRegistry.corrupted_hoe.key(), ItemRegistry.corrupted_shickaxe.key(), ItemRegistry.death_bringer.key(), ItemRegistry.corrupted_maul.key(), ItemRegistry.corrupted_cannon.key(), ItemRegistry.CORRUPTED_BOOTS.key(), ItemRegistry.CORRUPTED_LEGGINGS.key(), ItemRegistry.CORRUPTED_CHESTPLATE.key(), ItemRegistry.CORRUPTED_HELMET.key());
        tag(TagRegistry.SMELTABLE_DIVINE).add(ItemRegistry.divine_pickaxe.key(), ItemRegistry.divine_shovel.key(), ItemRegistry.divine_axe.key(), ItemRegistry.divine_hoe.key(), ItemRegistry.divine_shickaxe.key(), ItemRegistry.divine_sword.key(), ItemRegistry.red_divine_sword.key(), ItemRegistry.yellow_divine_sword.key(), ItemRegistry.green_divine_sword.key(), ItemRegistry.blue_divine_sword.key(), ItemRegistry.gray_divine_sword.key(), ItemRegistry.icine_sword.key(), ItemRegistry.DIVINE_BOOTS.key(), ItemRegistry.DIVINE_LEGGINGS.key(), ItemRegistry.DIVINE_CHESTPLATE.key(), ItemRegistry.DIVINE_HELMET.key());
        tag(TagRegistry.SMELTABLE_EDEN).add(ItemRegistry.eden_pickaxe.key(), ItemRegistry.eden_shovel.key(), ItemRegistry.eden_axe.key(), ItemRegistry.eden_hoe.key(), ItemRegistry.eden_shickaxe.key(), ItemRegistry.eden_blade.key(), ItemRegistry.eden_bow.key(), ItemRegistry.eden_phaser.key(), ItemRegistry.eden_blitz.key(), ItemRegistry.eden_shield.key(), ItemRegistry.EDEN_BOOTS.key(), ItemRegistry.EDEN_LEGGINGS.key(), ItemRegistry.EDEN_CHESTPLATE.key(), ItemRegistry.EDEN_HELMET.key());
        tag(TagRegistry.SMELTABLE_ENDER).add(ItemRegistry.ender_bow.key(), ItemRegistry.ENDER_BOOTS.key(), ItemRegistry.ENDER_LEGGINGS.key(), ItemRegistry.ENDER_CHESTPLATE.key(), ItemRegistry.ENDER_HELMET.key(), ItemRegistry.RED_ENDER_BOOTS.key(), ItemRegistry.RED_ENDER_LEGGINGS.key(), ItemRegistry.RED_ENDER_CHESTPLATE.key(), ItemRegistry.RED_ENDER_HELMET.key(), ItemRegistry.YELLOW_ENDER_BOOTS.key(), ItemRegistry.YELLOW_ENDER_LEGGINGS.key(), ItemRegistry.YELLOW_ENDER_CHESTPLATE.key(), ItemRegistry.YELLOW_ENDER_HELMET.key(), ItemRegistry.GREEN_ENDER_BOOTS.key(), ItemRegistry.GREEN_ENDER_LEGGINGS.key(), ItemRegistry.GREEN_ENDER_CHESTPLATE.key(), ItemRegistry.GREEN_ENDER_HELMET.key(), ItemRegistry.BLUE_ENDER_BOOTS.key(), ItemRegistry.BLUE_ENDER_LEGGINGS.key(), ItemRegistry.BLUE_ENDER_CHESTPLATE.key(), ItemRegistry.BLUE_ENDER_HELMET.key(), ItemRegistry.GRAY_ENDER_BOOTS.key(), ItemRegistry.GRAY_ENDER_LEGGINGS.key(), ItemRegistry.GRAY_ENDER_CHESTPLATE.key(), ItemRegistry.GRAY_ENDER_HELMET.key());
        tag(TagRegistry.SMELTABLE_ICE).add(ItemRegistry.frost_sword.key(), ItemRegistry.frostking_sword.key(), ItemRegistry.icicle_bow.key(), ItemRegistry.frost_cannon.key(), ItemRegistry.fractite_cannon.key(), ItemRegistry.FROZEN_BOOTS.key(), ItemRegistry.FROZEN_LEGGINGS.key(), ItemRegistry.FROZEN_CHESTPLATE.key(), ItemRegistry.FROZEN_HELMET.key());
        tag(TagRegistry.SMELTABLE_JUNGLE).add(ItemRegistry.jungle_hook.key(), ItemRegistry.jungle_knife.key(), ItemRegistry.jungle_rapier.key(), ItemRegistry.poison_saber.key(), ItemRegistry.hunter_bow.key(), ItemRegistry.JUNGLE_HELMET.key(), ItemRegistry.JUNGLE_CHESTPLATE.key(), ItemRegistry.JUNGLE_LEGGINGS.key(), ItemRegistry.JUNGLE_BOOTS.key());
        tag(TagRegistry.SMELTABLE_MOLTEN).add(ItemRegistry.molten_sword.key(), ItemRegistry.inferno_bow.key(), ItemRegistry.INFERNO_HELMET.key(), ItemRegistry.INFERNO_CHESTPLATE.key(), ItemRegistry.INFERNO_LEGGINGS.key(), ItemRegistry.INFERNO_BOOTS.key());
        tag(TagRegistry.SMELTABLE_MORTUM).add(ItemRegistry.mortum_pickaxe.key(), ItemRegistry.mortum_shovel.key(), ItemRegistry.mortum_axe.key(), ItemRegistry.mortum_hoe.key(), ItemRegistry.mortum_shickaxe.key(), ItemRegistry.mortum_blade.key(), ItemRegistry.mortum_bow.key(), ItemRegistry.mortum_phaser.key(), ItemRegistry.mortum_blitz.key(), ItemRegistry.mortum_shield.key(), ItemRegistry.MORTUM_HELMET.key(), ItemRegistry.MORTUM_CHESTPLATE.key(), ItemRegistry.MORTUM_LEGGINGS.key(), ItemRegistry.MORTUM_BOOTS.key());
        tag(TagRegistry.SMELTABLE_OXDRITE).add(ItemRegistry.oxdrite_pickaxe.key());
        tag(TagRegistry.SMELTABLE_REALMITE).add(ItemRegistry.realmite_pickaxe.key(), ItemRegistry.realmite_shovel.key(), ItemRegistry.realmite_axe.key(), ItemRegistry.realmite_hoe.key(), ItemRegistry.palavence.key(), ItemRegistry.realmite_sword.key(), ItemRegistry.realmite_maul.key(), ItemRegistry.realmite_shield.key(), ItemRegistry.REALMITE_HELMET.key(), ItemRegistry.REALMITE_CHESTPLATE.key(), ItemRegistry.REALMITE_LEGGINGS.key(), ItemRegistry.REALMITE_BOOTS.key());
        tag(TagRegistry.SMELTABLE_RUPEE).add(ItemRegistry.rupee_pickaxe.key(), ItemRegistry.rupee_shovel.key(), ItemRegistry.rupee_axe.key(), ItemRegistry.rupee_hoe.key(), ItemRegistry.rupee_shickaxe.key(), ItemRegistry.rupee_rapier.key(), ItemRegistry.rupee_shield.key(), ItemRegistry.RUPEE_HELMET.key(), ItemRegistry.RUPEE_CHESTPLATE.key(), ItemRegistry.RUPEE_LEGGINGS.key(), ItemRegistry.RUPEE_BOOTS.key(), ItemRegistry.RED_RUPEE_HELMET.key(), ItemRegistry.RED_RUPEE_CHESTPLATE.key(), ItemRegistry.RED_RUPEE_LEGGINGS.key(), ItemRegistry.RED_RUPEE_BOOTS.key(), ItemRegistry.YELLOW_RUPEE_HELMET.key(), ItemRegistry.YELLOW_RUPEE_CHESTPLATE.key(), ItemRegistry.YELLOW_RUPEE_LEGGINGS.key(), ItemRegistry.YELLOW_RUPEE_BOOTS.key(), ItemRegistry.GREEN_RUPEE_HELMET.key(), ItemRegistry.GREEN_RUPEE_CHESTPLATE.key(), ItemRegistry.GREEN_RUPEE_LEGGINGS.key(), ItemRegistry.GREEN_RUPEE_BOOTS.key(), ItemRegistry.BLUE_RUPEE_HELMET.key(), ItemRegistry.BLUE_RUPEE_CHESTPLATE.key(), ItemRegistry.BLUE_RUPEE_LEGGINGS.key(), ItemRegistry.BLUE_RUPEE_BOOTS.key(), ItemRegistry.GRAY_RUPEE_HELMET.key(), ItemRegistry.GRAY_RUPEE_CHESTPLATE.key(), ItemRegistry.GRAY_RUPEE_LEGGINGS.key(), ItemRegistry.GRAY_RUPEE_BOOTS.key());
        tag(TagRegistry.SMELTABLE_SKYTHERN).add(ItemRegistry.skythern_pickaxe.key(), ItemRegistry.skythern_shovel.key(), ItemRegistry.skythern_axe.key(), ItemRegistry.skythern_hoe.key(), ItemRegistry.skythern_shickaxe.key(), ItemRegistry.skythern_blade.key(), ItemRegistry.skythern_bow.key(), ItemRegistry.skythern_phaser.key(), ItemRegistry.skythern_blitz.key(), ItemRegistry.skythern_shield.key(), ItemRegistry.SKYTHERN_HELMET.key(), ItemRegistry.SKYTHERN_CHESTPLATE.key(), ItemRegistry.SKYTHERN_LEGGINGS.key(), ItemRegistry.SKYTHERN_BOOTS.key());
        tag(TagRegistry.SMELTABLE_TERRAN).add(ItemRegistry.terran_pickaxe.key(), ItemRegistry.terran_shovel.key(), ItemRegistry.terran_axe.key(), ItemRegistry.terran_hoe.key(), ItemRegistry.terran_shickaxe.key(), ItemRegistry.terran_shifter.key(), ItemRegistry.terran_dagger.key(), ItemRegistry.terran_knife.key(), ItemRegistry.terran_maul.key(), ItemRegistry.TERRAN_HELMET.key(), ItemRegistry.TERRAN_CHESTPLATE.key(), ItemRegistry.TERRAN_LEGGINGS.key(), ItemRegistry.TERRAN_BOOTS.key());
        tag(TagRegistry.SMELTABLE_TORRIDITE).add(ItemRegistry.massivence.key(), ItemRegistry.frossivence.key(), ItemRegistry.scorching_sword.key());
        tag(TagRegistry.SMELTABLE_WILDWOOD).add(ItemRegistry.wildwood_pickaxe.key(), ItemRegistry.wildwood_shovel.key(), ItemRegistry.wildwood_axe.key(), ItemRegistry.wildwood_hoe.key(), ItemRegistry.wildwood_shickaxe.key(), ItemRegistry.wildwood_blade.key(), ItemRegistry.wildwood_bow.key(), ItemRegistry.wildwood_phaser.key(), ItemRegistry.wildwood_blitz.key(), ItemRegistry.wildwood_shield.key(), ItemRegistry.WILDWOOD_HELMET.key(), ItemRegistry.WILDWOOD_CHESTPLATE.key(), ItemRegistry.WILDWOOD_LEGGINGS.key(), ItemRegistry.WILDWOOD_BOOTS.key());

        tag(TagRegistry.SKIN_KRAKEN).add(ItemRegistry.kraken_skin.key());
        tag(TagRegistry.HEART_EDEN).add(ItemRegistry.eden_heart.key());
        tag(TagRegistry.HEART_WILDWOOD).add(ItemRegistry.wildwood_heart.key());
        tag(TagRegistry.HEART_APALACHIA).add(ItemRegistry.apalachia_heart.key());
        tag(TagRegistry.HEART_SKYTHERN).add(ItemRegistry.skythern_heart.key());
        tag(TagRegistry.HEART_MORTUM).add(ItemRegistry.mortum_heart.key());
        tag(TagRegistry.HEARTS).addTags(TagRegistry.HEART_EDEN, TagRegistry.HEART_WILDWOOD, TagRegistry.HEART_APALACHIA, TagRegistry.HEART_SKYTHERN, TagRegistry.HEART_MORTUM);

        tag(TagRegistry.DIAMOND_GRAY).add(ItemRegistry.gray_diamond_chunk.key());
        tag(TagRegistry.DIAMOND_BLUE).add(ItemRegistry.blue_diamond_chunk.key());
        tag(TagRegistry.DIAMOND_GREEN).add(ItemRegistry.green_diamond_chunk.key());
        tag(TagRegistry.DIAMOND_RED).add(ItemRegistry.red_diamond_chunk.key());
        tag(TagRegistry.DIAMOND_YELLOW).add(ItemRegistry.yellow_diamond_chunk.key());
        tag(commonTag("gems/diamond")).addTags(TagRegistry.DIAMOND_GRAY, TagRegistry.DIAMOND_BLUE, TagRegistry.DIAMOND_GREEN, TagRegistry.DIAMOND_RED, TagRegistry.DIAMOND_YELLOW);
        tag(TagRegistry.DIAMOND_NO).addTags(ItemTags.create(Identifier.fromNamespaceAndPath("c", "gems/diamond"))).remove(ItemRegistry.gray_diamond_chunk.key(), ItemRegistry.blue_diamond_chunk.key(), ItemRegistry.green_diamond_chunk.key(), ItemRegistry.red_diamond_chunk.key(), ItemRegistry.yellow_diamond_chunk.key());

        tag(TagRegistry.FUEL_COLLECTOR).add(ItemRegistry.collector.key());

        for (var entry : DivineRegistries.BLOCKS.getEntries()) {
            Block b = entry.get();
            if (b.asItem() == Items.AIR) continue;
            var itemKey = b.asItem().builtInRegistryHolder().key();
            String path = entry.getId().getPath();
            if (path.contains("_planks")) tag(ItemTags.PLANKS).add(itemKey);
            if (path.contains("_log")) tag(ItemTags.LOGS).add(itemKey);
            if (b instanceof FenceBlock) tag(ItemTags.WOODEN_FENCES).add(itemKey);
            if (b instanceof StairBlock) tag(ItemTags.WOODEN_STAIRS).add(itemKey);
            if (b instanceof SlabBlock) tag(ItemTags.WOODEN_SLABS).add(itemKey);
            if (b instanceof DoorBlock) tag(ItemTags.WOODEN_DOORS).add(itemKey);
            if (b instanceof TrapDoorBlock) tag(ItemTags.WOODEN_TRAPDOORS).add(itemKey);
            if (b instanceof ButtonBlock) tag(ItemTags.WOODEN_BUTTONS).add(itemKey);
        }
        addToolTags();
    }

    private void registerMetalSet(String name, ResourceKey<Item> ingot, ResourceKey<Item> nugget, ResourceKey<Item> gem, ResourceKey<Item> block, ResourceKey<Item> raw, ResourceKey<Item> dusts, Iterable<ResourceKey<Item>> ores) {
        if (ingot != null) {
            tag(commonTag("ingots/" + name)).add(ingot);
            tag(commonTag("ingots")).addTag(commonTag("ingots/" + name));
        }
        if (nugget != null) {
            tag(commonTag("nuggets/" + name)).add(nugget);
            tag(commonTag("nuggets")).addTag(commonTag("nuggets/" + name));
        }
        if (gem != null) {
            tag(commonTag("gems/" + name)).add(gem);
            tag(commonTag("gems")).addTag(commonTag("gems/" + name));
        }
        if (block != null) {
            tag(commonTag("storage_blocks/" + name)).add(block);
            tag(commonTag("storage_blocks")).addTag(commonTag("storage_blocks/" + name));
        }
        if (raw != null) {
            tag(commonTag("raw_materials/" + name)).add(raw);
            tag(commonTag("raw_materials")).addTag(commonTag("raw_materials/" + name));
        }
        if (dusts != null) {
            tag(commonTag("dusts/" + name)).add(dusts);
            tag(commonTag("dusts")).addTag(commonTag("dusts/" + name));
        }
        if (ores != null) {
            for (ResourceKey<Item> ore : ores) {
                if (ore != null) {
                    tag(commonTag("ores/" + name)).add(ore);
                }
            }
            tag(commonTag("ores")).addTag(commonTag("ores/" + name));
        }
    }

    private void addToolTags() {
        registerTool(ItemTags.PICKAXES, ItemRegistry.realmite_pickaxe.key(), ItemRegistry.arlemite_pickaxe.key());
        registerTool(ItemTags.AXES, ItemRegistry.realmite_axe.key(), ItemRegistry.arlemite_axe.key());
        registerTool(ItemTags.SHOVELS, ItemRegistry.realmite_shovel.key(), ItemRegistry.arlemite_shovel.key());
        registerTool(ItemTags.HOES, ItemRegistry.realmite_hoe.key(), ItemRegistry.arlemite_hoe.key());
        registerTool(ItemTags.SWORDS, ItemRegistry.realmite_sword.key(), ItemRegistry.arlemite_stabber.key());

        tag(TagRegistry.SHICKAXES).add(
                ItemRegistry.rupee_shickaxe.key(),
                ItemRegistry.arlemite_shickaxe.key()
        );
        tag(commonTag("tools")).addTags(TagRegistry.PICKAXES, TagRegistry.AXES, TagRegistry.SHOVELS, TagRegistry.HOES, TagRegistry.SHICKAXES, TagRegistry.SWORDS, TagRegistry.TOOL_MAUL);

    }

    private static TagKey<Item> commonTag(String name){
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", name));
    }
    private TagKey<Item> minecraftTag(String name){
        return TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace(name));
    }
    private TagKey<Item> customTag(String name){
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name));
    }

    @SafeVarargs
    private final void registerTool(TagKey<Item> vanillaTag, ResourceKey<Item>... items) {
        tag(vanillaTag).add(items);
        String path = vanillaTag.location().getPath();
        tag(commonTag("tools/" + path)).add(items);
    }
}