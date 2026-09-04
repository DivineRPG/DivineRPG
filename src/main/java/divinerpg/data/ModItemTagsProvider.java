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
        registerMetalSet("arlemite", ItemRegistry.arlemite_ingot.getKey(), ItemRegistry.arlemite_nugget.getKey(), null, BlockRegistry.arlemiteBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_arlemite.getKey(), ItemRegistry.arlemite_dust.getKey(), List.of(BlockRegistry.arlemiteOre.asItem().builtInRegistryHolder().key(), BlockRegistry.arlemiteOreDeepslate.asItem().builtInRegistryHolder().key()));
        registerMetalSet("rupee", ItemRegistry.rupee_ingot.getKey(), ItemRegistry.rupee_nugget.getKey(),null,BlockRegistry.rupeeBlock.asItem().builtInRegistryHolder().key(),ItemRegistry.raw_rupee.getKey(), ItemRegistry.rupee_dust.getKey(),List.of(BlockRegistry.rupeeOre.asItem().builtInRegistryHolder().key(),BlockRegistry.rupeeOreDeepslate.asItem().builtInRegistryHolder().key()));
        registerMetalSet("aquatic", ItemRegistry.aquatic_ingot.getKey(), null, null, null, null, null, null);
        registerMetalSet("hellstone", ItemRegistry.hellstone_ingot.getKey(), null, null, null, null, null, null);
        registerMetalSet("shadow", ItemRegistry.shadow_bar.getKey(), null, null, null, null, ItemRegistry.shadow_dust.getKey(), null);
        registerMetalSet("bloodgem", null, null, ItemRegistry.bloodgem.getKey(), BlockRegistry.bloodgemBlock.asItem().builtInRegistryHolder().key(), null, null, List.of(BlockRegistry.bloodgemOre.asItem().builtInRegistryHolder().key()));
        registerMetalSet("oxdrite", ItemRegistry.oxdrite_ingot.getKey(), ItemRegistry.oxdrite_nugget.getKey(), null, BlockRegistry.oxdriteBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_oxdrite.getKey(), ItemRegistry.oxdrite_dust.getKey(), List.of(BlockRegistry.oxdriteOre.asItem().builtInRegistryHolder().key()));
        registerMetalSet("realmite", ItemRegistry.realmite_ingot.getKey(), ItemRegistry.realmite_nugget.getKey(), null, BlockRegistry.realmiteBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_realmite.getKey(), ItemRegistry.realmite_dust.getKey(), List.of(BlockRegistry.realmiteOre.asItem().builtInRegistryHolder().key(), BlockRegistry.realmiteOreDeepslate.asItem().builtInRegistryHolder().key()));
        registerMetalSet("torridite", ItemRegistry.torridite_ingot.getKey(), ItemRegistry.torridite_nugget.getKey(), null, BlockRegistry.torriditeBlock.asItem().builtInRegistryHolder().key(), ItemRegistry.raw_torridite.getKey(), ItemRegistry.torridite_dust.getKey(), List.of(BlockRegistry.torriditeOre.asItem().builtInRegistryHolder().key()));

        tag(commonTag("foods")).addTags(commonTag("foods/white_mushroom"));
        tag(commonTag("foods/white_mushroom")).add(ItemRegistry.white_mushroom.getKey());
        tag(commonTag("mushrooms")).add(ItemRegistry.white_mushroom.getKey());
        tag(TagRegistry.SMELTS_LOOT).add(Blocks.COAL_BLOCK.asItem().builtInRegistryHolder().key());

            tag(TagRegistry.REPAIR_REALMITE).add(ItemRegistry.realmite_ingot.getKey());
            tag(TagRegistry.REPAIR_ARLEMITE).add(ItemRegistry.arlemite_ingot.getKey());
            tag(TagRegistry.REPAIR_RUPEE).add(ItemRegistry.rupee_ingot.getKey());
            tag(TagRegistry.REPAIR_ICE).add(ItemRegistry.ice_shards.getKey());
            tag(TagRegistry.REPAIR_ENDER).add(ItemRegistry.ender_shards.getKey());
            tag(TagRegistry.DIVINE_SWORDS).add(ItemRegistry.divine_sword.getKey(), ItemRegistry.red_divine_sword.getKey(), ItemRegistry.yellow_divine_sword.getKey(), ItemRegistry.green_divine_sword.getKey(), ItemRegistry.gray_divine_sword.getKey(), ItemRegistry.blue_divine_sword.getKey());
            tag(TagRegistry.ARMOR_POUCHES).add(ItemRegistry.armor_pouch.getKey(), ItemRegistry.red_armor_pouch.getKey(), ItemRegistry.yellow_armor_pouch.getKey(), ItemRegistry.green_armor_pouch.getKey(), ItemRegistry.gray_armor_pouch.getKey(), ItemRegistry.blue_armor_pouch.getKey());
            tag(TagRegistry.SHADOW_COIN).add(ItemRegistry.shadow_coins.getKey());

            tag(TagRegistry.CHUNK_BEDROCK).add(ItemRegistry.bedrock_chunk.getKey());
            tag(TagRegistry.GEM_SHADOW).add(ItemRegistry.shadow_stone.getKey());
            tag(TagRegistry.GEM_SOULFIRE).add(ItemRegistry.soulfire_stone.getKey());
            tag(TagRegistry.TOOL_MAUL).add(ItemRegistry.aquatic_maul.getKey(), ItemRegistry.aquatooth_maul.getKey(), ItemRegistry.bedrock_maul.getKey(), ItemRegistry.corrupted_maul.getKey(), ItemRegistry.crabclaw_maul.getKey(), ItemRegistry.frozen_maul.getKey(), ItemRegistry.fury_maul.getKey(), ItemRegistry.realmite_maul.getKey(), ItemRegistry.terran_maul.getKey());
            tag(TagRegistry.METAL_SPIKE_BLOCK).add(BlockRegistry.spikeBlock.asItem().builtInRegistryHolder().key(), BlockRegistry.hotSpikeBlock.asItem().builtInRegistryHolder().key());

            tag(ItemTags.WALLS).add(BlockRegistry.cobaltiteWall.asItem().builtInRegistryHolder().key(), BlockRegistry.coalstoneWall.asItem().builtInRegistryHolder().key(), BlockRegistry.arcaniteWall.asItem().builtInRegistryHolder().key());

            tag(TagRegistry.ENCHANTABLE_ARMOR).addTags(TagRegistry.ENCHANTABLE_CHEST, TagRegistry.ENCHANTABLE_FOOT, TagRegistry.ENCHANTABLE_HEAD, TagRegistry.ENCHANTABLE_LEG);
            tag(TagRegistry.ENCHANTABLE_HEAD).add(ItemRegistry.REALMITE_HELMET.getKey(), ItemRegistry.SENG_FUR_HELMET.getKey(), ItemRegistry.SANTA_HELMET.getKey(), ItemRegistry.AQUASTRIVE_HELMET.getKey(), ItemRegistry.KRAKEN_HELMET.getKey(), ItemRegistry.JACK_O_MAN_HELMET.getKey(), ItemRegistry.SKELEMAN_HELMET.getKey(), ItemRegistry.WITHER_REAPER_HELMET.getKey(), ItemRegistry.ARLEMITE_HELMET.getKey(), ItemRegistry.FROZEN_HELMET.getKey(), ItemRegistry.JUNGLE_HELMET.getKey(), ItemRegistry.INFERNO_HELMET.getKey(), ItemRegistry.TORRIDITE_HELMET.getKey(), ItemRegistry.TERRAN_HELMET.getKey(), ItemRegistry.ANGELIC_HELMET.getKey(), ItemRegistry.SHADOW_HELMET.getKey(), ItemRegistry.RUPEE_HELMET.getKey(), ItemRegistry.RED_RUPEE_HELMET.getKey(), ItemRegistry.YELLOW_RUPEE_HELMET.getKey(), ItemRegistry.GREEN_RUPEE_HELMET.getKey(), ItemRegistry.BLUE_RUPEE_HELMET.getKey(), ItemRegistry.GRAY_RUPEE_HELMET.getKey(), ItemRegistry.ELITE_REALMITE_HELMET.getKey(), ItemRegistry.CORRUPTED_HELMET.getKey(), ItemRegistry.BEDROCK_HELMET.getKey(), ItemRegistry.KORMA_HELMET.getKey(), ItemRegistry.VEMOS_HELMET.getKey(), ItemRegistry.ENDER_HELMET.getKey(), ItemRegistry.RED_ENDER_HELMET.getKey(), ItemRegistry.YELLOW_ENDER_HELMET.getKey(), ItemRegistry.GREEN_ENDER_HELMET.getKey(), ItemRegistry.BLUE_ENDER_HELMET.getKey(), ItemRegistry.GRAY_ENDER_HELMET.getKey(), ItemRegistry.DIVINE_HELMET.getKey(), ItemRegistry.EDEN_HELMET.getKey(), ItemRegistry.WILDWOOD_HELMET.getKey(), ItemRegistry.APALACHIA_HELMET.getKey(), ItemRegistry.SKYTHERN_HELMET.getKey(), ItemRegistry.MORTUM_HELMET.getKey(), ItemRegistry.HALITE_HELMET.getKey(), ItemRegistry.AWAKENED_HALITE_HELMET.getKey(), ItemRegistry.DEGRADED_HELMET.getKey(), ItemRegistry.DEGRADED_HOOD.getKey(), ItemRegistry.DEGRADED_MASK.getKey(), ItemRegistry.FINISHED_HELMET.getKey(), ItemRegistry.FINISHED_HOOD.getKey(), ItemRegistry.FINISHED_MASK.getKey(), ItemRegistry.GLISTENING_HELMET.getKey(), ItemRegistry.GLISTENING_HOOD.getKey(), ItemRegistry.GLISTENING_MASK.getKey(), ItemRegistry.DEMONIZED_HELMET.getKey(), ItemRegistry.DEMONIZED_MASK.getKey(), ItemRegistry.DEMONIZED_HOOD.getKey(), ItemRegistry.TORMENTED_HELMET.getKey(), ItemRegistry.TORMENTED_HOOD.getKey(), ItemRegistry.TORMENTED_MASK.getKey());
            tag(TagRegistry.ENCHANTABLE_CHEST).add(ItemRegistry.REALMITE_CHESTPLATE.getKey(), ItemRegistry.SENG_FUR_CHESTPLATE.getKey(), ItemRegistry.SANTA_CHESTPLATE.getKey(), ItemRegistry.AQUASTRIVE_CHESTPLATE.getKey(), ItemRegistry.KRAKEN_CHESTPLATE.getKey(), ItemRegistry.JACK_O_MAN_CHESTPLATE.getKey(), ItemRegistry.SKELEMAN_CHESTPLATE.getKey(), ItemRegistry.WITHER_REAPER_CHESTPLATE.getKey(), ItemRegistry.ARLEMITE_CHESTPLATE.getKey(), ItemRegistry.FROZEN_CHESTPLATE.getKey(), ItemRegistry.JUNGLE_CHESTPLATE.getKey(), ItemRegistry.INFERNO_CHESTPLATE.getKey(), ItemRegistry.TORRIDITE_CHESTPLATE.getKey(), ItemRegistry.TERRAN_CHESTPLATE.getKey(), ItemRegistry.ANGELIC_CHESTPLATE.getKey(), ItemRegistry.SHADOW_CHESTPLATE.getKey(), ItemRegistry.RUPEE_CHESTPLATE.getKey(), ItemRegistry.RED_RUPEE_CHESTPLATE.getKey(), ItemRegistry.YELLOW_RUPEE_CHESTPLATE.getKey(), ItemRegistry.GREEN_RUPEE_CHESTPLATE.getKey(), ItemRegistry.BLUE_RUPEE_CHESTPLATE.getKey(), ItemRegistry.GRAY_RUPEE_CHESTPLATE.getKey(), ItemRegistry.ELITE_REALMITE_CHESTPLATE.getKey(), ItemRegistry.CORRUPTED_CHESTPLATE.getKey(), ItemRegistry.BEDROCK_CHESTPLATE.getKey(), ItemRegistry.KORMA_CHESTPLATE.getKey(), ItemRegistry.VEMOS_CHESTPLATE.getKey(), ItemRegistry.ENDER_CHESTPLATE.getKey(), ItemRegistry.RED_ENDER_CHESTPLATE.getKey(), ItemRegistry.YELLOW_ENDER_CHESTPLATE.getKey(), ItemRegistry.GREEN_ENDER_CHESTPLATE.getKey(), ItemRegistry.BLUE_ENDER_CHESTPLATE.getKey(), ItemRegistry.GRAY_ENDER_CHESTPLATE.getKey(), ItemRegistry.DIVINE_CHESTPLATE.getKey(), ItemRegistry.EDEN_CHESTPLATE.getKey(), ItemRegistry.WILDWOOD_CHESTPLATE.getKey(), ItemRegistry.APALACHIA_CHESTPLATE.getKey(), ItemRegistry.SKYTHERN_CHESTPLATE.getKey(), ItemRegistry.MORTUM_CHESTPLATE.getKey(), ItemRegistry.HALITE_CHESTPLATE.getKey(), ItemRegistry.AWAKENED_HALITE_CHESTPLATE.getKey(), ItemRegistry.DEGRADED_CHESTPLATE.getKey(), ItemRegistry.FINISHED_CHESTPLATE.getKey(), ItemRegistry.GLISTENING_CHESTPLATE.getKey(), ItemRegistry.DEMONIZED_CHESTPLATE.getKey(), ItemRegistry.TORMENTED_CHESTPLATE.getKey());
            tag(TagRegistry.ENCHANTABLE_LEG).add(ItemRegistry.REALMITE_LEGGINGS.getKey(), ItemRegistry.SENG_FUR_LEGGINGS.getKey(), ItemRegistry.SANTA_LEGGINGS.getKey(), ItemRegistry.AQUASTRIVE_LEGGINGS.getKey(), ItemRegistry.KRAKEN_LEGGINGS.getKey(), ItemRegistry.JACK_O_MAN_LEGGINGS.getKey(), ItemRegistry.SKELEMAN_LEGGINGS.getKey(), ItemRegistry.WITHER_REAPER_LEGGINGS.getKey(), ItemRegistry.ARLEMITE_LEGGINGS.getKey(), ItemRegistry.FROZEN_LEGGINGS.getKey(), ItemRegistry.JUNGLE_LEGGINGS.getKey(), ItemRegistry.INFERNO_LEGGINGS.getKey(), ItemRegistry.TORRIDITE_LEGGINGS.getKey(), ItemRegistry.TERRAN_LEGGINGS.getKey(), ItemRegistry.ANGELIC_LEGGINGS.getKey(), ItemRegistry.SHADOW_LEGGINGS.getKey(), ItemRegistry.RUPEE_LEGGINGS.getKey(), ItemRegistry.RED_RUPEE_LEGGINGS.getKey(), ItemRegistry.YELLOW_RUPEE_LEGGINGS.getKey(), ItemRegistry.GREEN_RUPEE_LEGGINGS.getKey(), ItemRegistry.BLUE_RUPEE_LEGGINGS.getKey(), ItemRegistry.GRAY_RUPEE_LEGGINGS.getKey(), ItemRegistry.ELITE_REALMITE_LEGGINGS.getKey(), ItemRegistry.CORRUPTED_LEGGINGS.getKey(), ItemRegistry.BEDROCK_LEGGINGS.getKey(), ItemRegistry.KORMA_LEGGINGS.getKey(), ItemRegistry.VEMOS_LEGGINGS.getKey(), ItemRegistry.ENDER_LEGGINGS.getKey(), ItemRegistry.RED_ENDER_LEGGINGS.getKey(), ItemRegistry.YELLOW_ENDER_LEGGINGS.getKey(), ItemRegistry.GREEN_ENDER_LEGGINGS.getKey(), ItemRegistry.BLUE_ENDER_LEGGINGS.getKey(), ItemRegistry.GRAY_ENDER_LEGGINGS.getKey(), ItemRegistry.DIVINE_LEGGINGS.getKey(), ItemRegistry.EDEN_LEGGINGS.getKey(), ItemRegistry.WILDWOOD_LEGGINGS.getKey(), ItemRegistry.APALACHIA_LEGGINGS.getKey(), ItemRegistry.SKYTHERN_LEGGINGS.getKey(), ItemRegistry.MORTUM_LEGGINGS.getKey(), ItemRegistry.HALITE_LEGGINGS.getKey(), ItemRegistry.AWAKENED_HALITE_LEGGINGS.getKey(), ItemRegistry.DEGRADED_LEGGINGS.getKey(), ItemRegistry.FINISHED_LEGGINGS.getKey(), ItemRegistry.GLISTENING_LEGGINGS.getKey(), ItemRegistry.DEMONIZED_LEGGINGS.getKey(), ItemRegistry.TORMENTED_LEGGINGS.getKey());
            tag(TagRegistry.ENCHANTABLE_FOOT).add(ItemRegistry.REALMITE_BOOTS.getKey(), ItemRegistry.SENG_FUR_BOOTS.getKey(), ItemRegistry.SANTA_BOOTS.getKey(), ItemRegistry.AQUASTRIVE_BOOTS.getKey(), ItemRegistry.KRAKEN_BOOTS.getKey(), ItemRegistry.JACK_O_MAN_BOOTS.getKey(), ItemRegistry.SKELEMAN_BOOTS.getKey(), ItemRegistry.WITHER_REAPER_BOOTS.getKey(), ItemRegistry.ARLEMITE_BOOTS.getKey(), ItemRegistry.FROZEN_BOOTS.getKey(), ItemRegistry.JUNGLE_BOOTS.getKey(), ItemRegistry.INFERNO_BOOTS.getKey(), ItemRegistry.TORRIDITE_BOOTS.getKey(), ItemRegistry.TERRAN_BOOTS.getKey(), ItemRegistry.ANGELIC_BOOTS.getKey(), ItemRegistry.SHADOW_BOOTS.getKey(), ItemRegistry.RUPEE_BOOTS.getKey(), ItemRegistry.RED_RUPEE_BOOTS.getKey(), ItemRegistry.YELLOW_RUPEE_BOOTS.getKey(), ItemRegistry.GREEN_RUPEE_BOOTS.getKey(), ItemRegistry.BLUE_RUPEE_BOOTS.getKey(), ItemRegistry.GRAY_RUPEE_BOOTS.getKey(), ItemRegistry.ELITE_REALMITE_BOOTS.getKey(), ItemRegistry.CORRUPTED_BOOTS.getKey(), ItemRegistry.BEDROCK_BOOTS.getKey(), ItemRegistry.KORMA_BOOTS.getKey(), ItemRegistry.VEMOS_BOOTS.getKey(), ItemRegistry.ENDER_BOOTS.getKey(), ItemRegistry.RED_ENDER_BOOTS.getKey(), ItemRegistry.YELLOW_ENDER_BOOTS.getKey(), ItemRegistry.GREEN_ENDER_BOOTS.getKey(), ItemRegistry.BLUE_ENDER_BOOTS.getKey(), ItemRegistry.GRAY_ENDER_BOOTS.getKey(), ItemRegistry.DIVINE_BOOTS.getKey(), ItemRegistry.EDEN_BOOTS.getKey(), ItemRegistry.WILDWOOD_BOOTS.getKey(), ItemRegistry.APALACHIA_BOOTS.getKey(), ItemRegistry.SKYTHERN_BOOTS.getKey(), ItemRegistry.MORTUM_BOOTS.getKey(), ItemRegistry.HALITE_BOOTS.getKey(), ItemRegistry.AWAKENED_HALITE_BOOTS.getKey(), ItemRegistry.DEGRADED_BOOTS.getKey(), ItemRegistry.FINISHED_BOOTS.getKey(), ItemRegistry.GLISTENING_BOOTS.getKey(), ItemRegistry.DEMONIZED_BOOTS.getKey(), ItemRegistry.TORMENTED_BOOTS.getKey());
            tag(TagRegistry.TRIMMABLE_ARMOR).add(ItemRegistry.REALMITE_HELMET.getKey(), ItemRegistry.SENG_FUR_HELMET.getKey(), ItemRegistry.SANTA_HELMET.getKey(), ItemRegistry.AQUASTRIVE_HELMET.getKey(), ItemRegistry.KRAKEN_HELMET.getKey(), ItemRegistry.JACK_O_MAN_HELMET.getKey(), ItemRegistry.SKELEMAN_HELMET.getKey(), ItemRegistry.WITHER_REAPER_HELMET.getKey(), ItemRegistry.ARLEMITE_HELMET.getKey(), ItemRegistry.FROZEN_HELMET.getKey(), ItemRegistry.JUNGLE_HELMET.getKey(), ItemRegistry.INFERNO_HELMET.getKey(), ItemRegistry.TORRIDITE_HELMET.getKey(), ItemRegistry.TERRAN_HELMET.getKey(), ItemRegistry.ANGELIC_HELMET.getKey(), ItemRegistry.SHADOW_HELMET.getKey(), ItemRegistry.RUPEE_HELMET.getKey(), ItemRegistry.RED_RUPEE_HELMET.getKey(), ItemRegistry.YELLOW_RUPEE_HELMET.getKey(), ItemRegistry.GREEN_RUPEE_HELMET.getKey(), ItemRegistry.BLUE_RUPEE_HELMET.getKey(), ItemRegistry.GRAY_RUPEE_HELMET.getKey(), ItemRegistry.ELITE_REALMITE_HELMET.getKey(), ItemRegistry.CORRUPTED_HELMET.getKey(), ItemRegistry.BEDROCK_HELMET.getKey(), ItemRegistry.KORMA_HELMET.getKey(), ItemRegistry.VEMOS_HELMET.getKey(), ItemRegistry.ENDER_HELMET.getKey(), ItemRegistry.RED_ENDER_HELMET.getKey(), ItemRegistry.YELLOW_ENDER_HELMET.getKey(), ItemRegistry.GREEN_ENDER_HELMET.getKey(), ItemRegistry.BLUE_ENDER_HELMET.getKey(), ItemRegistry.GRAY_ENDER_HELMET.getKey(), ItemRegistry.DIVINE_HELMET.getKey(), ItemRegistry.EDEN_HELMET.getKey(), ItemRegistry.WILDWOOD_HELMET.getKey(), ItemRegistry.APALACHIA_HELMET.getKey(), ItemRegistry.SKYTHERN_HELMET.getKey(), ItemRegistry.MORTUM_HELMET.getKey(), ItemRegistry.HALITE_HELMET.getKey(), ItemRegistry.AWAKENED_HALITE_HELMET.getKey(), ItemRegistry.DEGRADED_HELMET.getKey(), ItemRegistry.DEGRADED_HOOD.getKey(), ItemRegistry.DEGRADED_MASK.getKey(), ItemRegistry.FINISHED_HELMET.getKey(), ItemRegistry.FINISHED_HOOD.getKey(), ItemRegistry.FINISHED_MASK.getKey(), ItemRegistry.GLISTENING_HELMET.getKey(), ItemRegistry.GLISTENING_HOOD.getKey(), ItemRegistry.GLISTENING_MASK.getKey(), ItemRegistry.DEMONIZED_HELMET.getKey(), ItemRegistry.DEMONIZED_MASK.getKey(), ItemRegistry.DEMONIZED_HOOD.getKey(), ItemRegistry.TORMENTED_HELMET.getKey(), ItemRegistry.TORMENTED_HOOD.getKey(), ItemRegistry.TORMENTED_MASK.getKey(), ItemRegistry.REALMITE_CHESTPLATE.getKey(), ItemRegistry.SENG_FUR_CHESTPLATE.getKey(), ItemRegistry.SANTA_CHESTPLATE.getKey(), ItemRegistry.AQUASTRIVE_CHESTPLATE.getKey(), ItemRegistry.KRAKEN_CHESTPLATE.getKey(), ItemRegistry.JACK_O_MAN_CHESTPLATE.getKey(), ItemRegistry.SKELEMAN_CHESTPLATE.getKey(), ItemRegistry.WITHER_REAPER_CHESTPLATE.getKey(), ItemRegistry.ARLEMITE_CHESTPLATE.getKey(), ItemRegistry.FROZEN_CHESTPLATE.getKey(), ItemRegistry.JUNGLE_CHESTPLATE.getKey(), ItemRegistry.INFERNO_CHESTPLATE.getKey(), ItemRegistry.TORRIDITE_CHESTPLATE.getKey(), ItemRegistry.TERRAN_CHESTPLATE.getKey(), ItemRegistry.ANGELIC_CHESTPLATE.getKey(), ItemRegistry.SHADOW_CHESTPLATE.getKey(), ItemRegistry.RUPEE_CHESTPLATE.getKey(), ItemRegistry.RED_RUPEE_CHESTPLATE.getKey(), ItemRegistry.YELLOW_RUPEE_CHESTPLATE.getKey(), ItemRegistry.GREEN_RUPEE_CHESTPLATE.getKey(), ItemRegistry.BLUE_RUPEE_CHESTPLATE.getKey(), ItemRegistry.GRAY_RUPEE_CHESTPLATE.getKey(), ItemRegistry.ELITE_REALMITE_CHESTPLATE.getKey(), ItemRegistry.CORRUPTED_CHESTPLATE.getKey(), ItemRegistry.BEDROCK_CHESTPLATE.getKey(), ItemRegistry.KORMA_CHESTPLATE.getKey(), ItemRegistry.VEMOS_CHESTPLATE.getKey(), ItemRegistry.ENDER_CHESTPLATE.getKey(), ItemRegistry.RED_ENDER_CHESTPLATE.getKey(), ItemRegistry.YELLOW_ENDER_CHESTPLATE.getKey(), ItemRegistry.GREEN_ENDER_CHESTPLATE.getKey(), ItemRegistry.BLUE_ENDER_CHESTPLATE.getKey(), ItemRegistry.GRAY_ENDER_CHESTPLATE.getKey(), ItemRegistry.DIVINE_CHESTPLATE.getKey(), ItemRegistry.EDEN_CHESTPLATE.getKey(), ItemRegistry.WILDWOOD_CHESTPLATE.getKey(), ItemRegistry.APALACHIA_CHESTPLATE.getKey(), ItemRegistry.SKYTHERN_CHESTPLATE.getKey(), ItemRegistry.MORTUM_CHESTPLATE.getKey(), ItemRegistry.HALITE_CHESTPLATE.getKey(), ItemRegistry.AWAKENED_HALITE_CHESTPLATE.getKey(), ItemRegistry.DEGRADED_CHESTPLATE.getKey(), ItemRegistry.FINISHED_CHESTPLATE.getKey(), ItemRegistry.GLISTENING_CHESTPLATE.getKey(), ItemRegistry.DEMONIZED_CHESTPLATE.getKey(), ItemRegistry.TORMENTED_CHESTPLATE.getKey(), ItemRegistry.REALMITE_LEGGINGS.getKey(), ItemRegistry.SENG_FUR_LEGGINGS.getKey(), ItemRegistry.SANTA_LEGGINGS.getKey(), ItemRegistry.AQUASTRIVE_LEGGINGS.getKey(), ItemRegistry.KRAKEN_LEGGINGS.getKey(), ItemRegistry.JACK_O_MAN_LEGGINGS.getKey(), ItemRegistry.SKELEMAN_LEGGINGS.getKey(), ItemRegistry.WITHER_REAPER_LEGGINGS.getKey(), ItemRegistry.ARLEMITE_LEGGINGS.getKey(), ItemRegistry.FROZEN_LEGGINGS.getKey(), ItemRegistry.JUNGLE_LEGGINGS.getKey(), ItemRegistry.INFERNO_LEGGINGS.getKey(), ItemRegistry.TORRIDITE_LEGGINGS.getKey(), ItemRegistry.TERRAN_LEGGINGS.getKey(), ItemRegistry.ANGELIC_LEGGINGS.getKey(), ItemRegistry.SHADOW_LEGGINGS.getKey(), ItemRegistry.RUPEE_LEGGINGS.getKey(), ItemRegistry.RED_RUPEE_LEGGINGS.getKey(), ItemRegistry.YELLOW_RUPEE_LEGGINGS.getKey(), ItemRegistry.GREEN_RUPEE_LEGGINGS.getKey(), ItemRegistry.BLUE_RUPEE_LEGGINGS.getKey(), ItemRegistry.GRAY_RUPEE_LEGGINGS.getKey(), ItemRegistry.ELITE_REALMITE_LEGGINGS.getKey(), ItemRegistry.CORRUPTED_LEGGINGS.getKey(), ItemRegistry.BEDROCK_LEGGINGS.getKey(), ItemRegistry.KORMA_LEGGINGS.getKey(), ItemRegistry.VEMOS_LEGGINGS.getKey(), ItemRegistry.ENDER_LEGGINGS.getKey(), ItemRegistry.RED_ENDER_LEGGINGS.getKey(), ItemRegistry.YELLOW_ENDER_LEGGINGS.getKey(), ItemRegistry.GREEN_ENDER_LEGGINGS.getKey(), ItemRegistry.BLUE_ENDER_LEGGINGS.getKey(), ItemRegistry.GRAY_ENDER_LEGGINGS.getKey(), ItemRegistry.DIVINE_LEGGINGS.getKey(), ItemRegistry.EDEN_LEGGINGS.getKey(), ItemRegistry.WILDWOOD_LEGGINGS.getKey(), ItemRegistry.APALACHIA_LEGGINGS.getKey(), ItemRegistry.SKYTHERN_LEGGINGS.getKey(), ItemRegistry.MORTUM_LEGGINGS.getKey(), ItemRegistry.HALITE_LEGGINGS.getKey(), ItemRegistry.AWAKENED_HALITE_LEGGINGS.getKey(), ItemRegistry.DEGRADED_LEGGINGS.getKey(), ItemRegistry.FINISHED_LEGGINGS.getKey(), ItemRegistry.GLISTENING_LEGGINGS.getKey(), ItemRegistry.DEMONIZED_LEGGINGS.getKey(), ItemRegistry.TORMENTED_LEGGINGS.getKey(), ItemRegistry.REALMITE_BOOTS.getKey(), ItemRegistry.SENG_FUR_BOOTS.getKey(), ItemRegistry.SANTA_BOOTS.getKey(), ItemRegistry.AQUASTRIVE_BOOTS.getKey(), ItemRegistry.KRAKEN_BOOTS.getKey(), ItemRegistry.JACK_O_MAN_BOOTS.getKey(), ItemRegistry.SKELEMAN_BOOTS.getKey(), ItemRegistry.WITHER_REAPER_BOOTS.getKey(), ItemRegistry.ARLEMITE_BOOTS.getKey(), ItemRegistry.FROZEN_BOOTS.getKey(), ItemRegistry.JUNGLE_BOOTS.getKey(), ItemRegistry.INFERNO_BOOTS.getKey(), ItemRegistry.TORRIDITE_BOOTS.getKey(), ItemRegistry.TERRAN_BOOTS.getKey(), ItemRegistry.ANGELIC_BOOTS.getKey(), ItemRegistry.SHADOW_BOOTS.getKey(), ItemRegistry.RUPEE_BOOTS.getKey(), ItemRegistry.RED_RUPEE_BOOTS.getKey(), ItemRegistry.YELLOW_RUPEE_BOOTS.getKey(), ItemRegistry.GREEN_RUPEE_BOOTS.getKey(), ItemRegistry.BLUE_RUPEE_BOOTS.getKey(), ItemRegistry.GRAY_RUPEE_BOOTS.getKey(), ItemRegistry.ELITE_REALMITE_BOOTS.getKey(), ItemRegistry.CORRUPTED_BOOTS.getKey(), ItemRegistry.BEDROCK_BOOTS.getKey(), ItemRegistry.KORMA_BOOTS.getKey(), ItemRegistry.VEMOS_BOOTS.getKey(), ItemRegistry.ENDER_BOOTS.getKey(), ItemRegistry.RED_ENDER_BOOTS.getKey(), ItemRegistry.YELLOW_ENDER_BOOTS.getKey(), ItemRegistry.GREEN_ENDER_BOOTS.getKey(), ItemRegistry.BLUE_ENDER_BOOTS.getKey(), ItemRegistry.GRAY_ENDER_BOOTS.getKey(), ItemRegistry.DIVINE_BOOTS.getKey(), ItemRegistry.EDEN_BOOTS.getKey(), ItemRegistry.WILDWOOD_BOOTS.getKey(), ItemRegistry.APALACHIA_BOOTS.getKey(), ItemRegistry.SKYTHERN_BOOTS.getKey(), ItemRegistry.MORTUM_BOOTS.getKey(), ItemRegistry.HALITE_BOOTS.getKey(), ItemRegistry.AWAKENED_HALITE_BOOTS.getKey(), ItemRegistry.DEGRADED_BOOTS.getKey(), ItemRegistry.FINISHED_BOOTS.getKey(), ItemRegistry.GLISTENING_BOOTS.getKey(), ItemRegistry.DEMONIZED_BOOTS.getKey(), ItemRegistry.TORMENTED_BOOTS.getKey());


        tag(TagRegistry.SMELTABLE_GOLD_COMPRESSED).add(ItemRegistry.golden_fury.getKey());
        tag(TagRegistry.SMELTABLE_REALMITE_COMPRESSED).add(ItemRegistry.ELITE_REALMITE_HELMET.getKey(), ItemRegistry.ELITE_REALMITE_CHESTPLATE.getKey(), ItemRegistry.ELITE_REALMITE_LEGGINGS.getKey(), ItemRegistry.ELITE_REALMITE_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_TORRIDITE_COMPRESSED).add(ItemRegistry.TORRIDITE_HELMET.getKey(), ItemRegistry.TORRIDITE_CHESTPLATE.getKey(), ItemRegistry.TORRIDITE_LEGGINGS.getKey(), ItemRegistry.TORRIDITE_BOOTS.getKey());

        tag(TagRegistry.SMELTABLE_APALACHIA).add(ItemRegistry.apalachia_pickaxe.getKey(), ItemRegistry.apalachia_shovel.getKey(), ItemRegistry.apalachia_axe.getKey(), ItemRegistry.apalachia_hoe.getKey(), ItemRegistry.apalachia_shickaxe.getKey(), ItemRegistry.apalachia_blade.getKey(), ItemRegistry.apalachia_bow.getKey(), ItemRegistry.apalachia_phaser.getKey(), ItemRegistry.apalachia_blitz.getKey(), ItemRegistry.apalachia_shield.getKey(), ItemRegistry.APALACHIA_BOOTS.getKey(), ItemRegistry.APALACHIA_LEGGINGS.getKey(), ItemRegistry.APALACHIA_CHESTPLATE.getKey(), ItemRegistry.APALACHIA_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_ARLEMITE).add(ItemRegistry.arlemite_pickaxe.getKey(), ItemRegistry.arlemite_shovel.getKey(), ItemRegistry.arlemite_axe.getKey(), ItemRegistry.arlemite_hoe.getKey(), ItemRegistry.arlemite_shickaxe.getKey(), ItemRegistry.arlemite_stabber.getKey(), ItemRegistry.arlemite_shield.getKey(), ItemRegistry.ARLEMITE_BOOTS.getKey(), ItemRegistry.ARLEMITE_LEGGINGS.getKey(), ItemRegistry.ARLEMITE_CHESTPLATE.getKey(), ItemRegistry.ARLEMITE_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_CORRUPTED).add(ItemRegistry.corrupted_pickaxe.getKey(), ItemRegistry.corrupted_shovel.getKey(), ItemRegistry.corrupted_axe.getKey(), ItemRegistry.corrupted_hoe.getKey(), ItemRegistry.corrupted_shickaxe.getKey(), ItemRegistry.death_bringer.getKey(), ItemRegistry.corrupted_maul.getKey(), ItemRegistry.corrupted_cannon.getKey(), ItemRegistry.CORRUPTED_BOOTS.getKey(), ItemRegistry.CORRUPTED_LEGGINGS.getKey(), ItemRegistry.CORRUPTED_CHESTPLATE.getKey(), ItemRegistry.CORRUPTED_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_DIVINE).add(ItemRegistry.divine_pickaxe.getKey(), ItemRegistry.divine_shovel.getKey(), ItemRegistry.divine_axe.getKey(), ItemRegistry.divine_hoe.getKey(), ItemRegistry.divine_shickaxe.getKey(), ItemRegistry.divine_sword.getKey(), ItemRegistry.red_divine_sword.getKey(), ItemRegistry.yellow_divine_sword.getKey(), ItemRegistry.green_divine_sword.getKey(), ItemRegistry.blue_divine_sword.getKey(), ItemRegistry.gray_divine_sword.getKey(), ItemRegistry.icine_sword.getKey(), ItemRegistry.DIVINE_BOOTS.getKey(), ItemRegistry.DIVINE_LEGGINGS.getKey(), ItemRegistry.DIVINE_CHESTPLATE.getKey(), ItemRegistry.DIVINE_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_EDEN).add(ItemRegistry.eden_pickaxe.getKey(), ItemRegistry.eden_shovel.getKey(), ItemRegistry.eden_axe.getKey(), ItemRegistry.eden_hoe.getKey(), ItemRegistry.eden_shickaxe.getKey(), ItemRegistry.eden_blade.getKey(), ItemRegistry.eden_bow.getKey(), ItemRegistry.eden_phaser.getKey(), ItemRegistry.eden_blitz.getKey(), ItemRegistry.eden_shield.getKey(), ItemRegistry.EDEN_BOOTS.getKey(), ItemRegistry.EDEN_LEGGINGS.getKey(), ItemRegistry.EDEN_CHESTPLATE.getKey(), ItemRegistry.EDEN_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_ENDER).add(ItemRegistry.ender_bow.getKey(), ItemRegistry.ENDER_BOOTS.getKey(), ItemRegistry.ENDER_LEGGINGS.getKey(), ItemRegistry.ENDER_CHESTPLATE.getKey(), ItemRegistry.ENDER_HELMET.getKey(), ItemRegistry.RED_ENDER_BOOTS.getKey(), ItemRegistry.RED_ENDER_LEGGINGS.getKey(), ItemRegistry.RED_ENDER_CHESTPLATE.getKey(), ItemRegistry.RED_ENDER_HELMET.getKey(), ItemRegistry.YELLOW_ENDER_BOOTS.getKey(), ItemRegistry.YELLOW_ENDER_LEGGINGS.getKey(), ItemRegistry.YELLOW_ENDER_CHESTPLATE.getKey(), ItemRegistry.YELLOW_ENDER_HELMET.getKey(), ItemRegistry.GREEN_ENDER_BOOTS.getKey(), ItemRegistry.GREEN_ENDER_LEGGINGS.getKey(), ItemRegistry.GREEN_ENDER_CHESTPLATE.getKey(), ItemRegistry.GREEN_ENDER_HELMET.getKey(), ItemRegistry.BLUE_ENDER_BOOTS.getKey(), ItemRegistry.BLUE_ENDER_LEGGINGS.getKey(), ItemRegistry.BLUE_ENDER_CHESTPLATE.getKey(), ItemRegistry.BLUE_ENDER_HELMET.getKey(), ItemRegistry.GRAY_ENDER_BOOTS.getKey(), ItemRegistry.GRAY_ENDER_LEGGINGS.getKey(), ItemRegistry.GRAY_ENDER_CHESTPLATE.getKey(), ItemRegistry.GRAY_ENDER_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_ICE).add(ItemRegistry.frost_sword.getKey(), ItemRegistry.frostking_sword.getKey(), ItemRegistry.icicle_bow.getKey(), ItemRegistry.frost_cannon.getKey(), ItemRegistry.fractite_cannon.getKey(), ItemRegistry.FROZEN_BOOTS.getKey(), ItemRegistry.FROZEN_LEGGINGS.getKey(), ItemRegistry.FROZEN_CHESTPLATE.getKey(), ItemRegistry.FROZEN_HELMET.getKey());
        tag(TagRegistry.SMELTABLE_JUNGLE).add(ItemRegistry.jungle_hook.getKey(), ItemRegistry.jungle_knife.getKey(), ItemRegistry.jungle_rapier.getKey(), ItemRegistry.poison_saber.getKey(), ItemRegistry.hunter_bow.getKey(), ItemRegistry.JUNGLE_HELMET.getKey(), ItemRegistry.JUNGLE_CHESTPLATE.getKey(), ItemRegistry.JUNGLE_LEGGINGS.getKey(), ItemRegistry.JUNGLE_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_MOLTEN).add(ItemRegistry.molten_sword.getKey(), ItemRegistry.inferno_bow.getKey(), ItemRegistry.INFERNO_HELMET.getKey(), ItemRegistry.INFERNO_CHESTPLATE.getKey(), ItemRegistry.INFERNO_LEGGINGS.getKey(), ItemRegistry.INFERNO_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_MORTUM).add(ItemRegistry.mortum_pickaxe.getKey(), ItemRegistry.mortum_shovel.getKey(), ItemRegistry.mortum_axe.getKey(), ItemRegistry.mortum_hoe.getKey(), ItemRegistry.mortum_shickaxe.getKey(), ItemRegistry.mortum_blade.getKey(), ItemRegistry.mortum_bow.getKey(), ItemRegistry.mortum_phaser.getKey(), ItemRegistry.mortum_blitz.getKey(), ItemRegistry.mortum_shield.getKey(), ItemRegistry.MORTUM_HELMET.getKey(), ItemRegistry.MORTUM_CHESTPLATE.getKey(), ItemRegistry.MORTUM_LEGGINGS.getKey(), ItemRegistry.MORTUM_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_OXDRITE).add(ItemRegistry.oxdrite_pickaxe.getKey());
        tag(TagRegistry.SMELTABLE_REALMITE).add(ItemRegistry.realmite_pickaxe.getKey(), ItemRegistry.realmite_shovel.getKey(), ItemRegistry.realmite_axe.getKey(), ItemRegistry.realmite_hoe.getKey(), ItemRegistry.palavence.getKey(), ItemRegistry.realmite_sword.getKey(), ItemRegistry.realmite_maul.getKey(), ItemRegistry.realmite_shield.getKey(), ItemRegistry.REALMITE_HELMET.getKey(), ItemRegistry.REALMITE_CHESTPLATE.getKey(), ItemRegistry.REALMITE_LEGGINGS.getKey(), ItemRegistry.REALMITE_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_RUPEE).add(ItemRegistry.rupee_pickaxe.getKey(), ItemRegistry.rupee_shovel.getKey(), ItemRegistry.rupee_axe.getKey(), ItemRegistry.rupee_hoe.getKey(), ItemRegistry.rupee_shickaxe.getKey(), ItemRegistry.rupee_rapier.getKey(), ItemRegistry.rupee_shield.getKey(), ItemRegistry.RUPEE_HELMET.getKey(), ItemRegistry.RUPEE_CHESTPLATE.getKey(), ItemRegistry.RUPEE_LEGGINGS.getKey(), ItemRegistry.RUPEE_BOOTS.getKey(), ItemRegistry.RED_RUPEE_HELMET.getKey(), ItemRegistry.RED_RUPEE_CHESTPLATE.getKey(), ItemRegistry.RED_RUPEE_LEGGINGS.getKey(), ItemRegistry.RED_RUPEE_BOOTS.getKey(), ItemRegistry.YELLOW_RUPEE_HELMET.getKey(), ItemRegistry.YELLOW_RUPEE_CHESTPLATE.getKey(), ItemRegistry.YELLOW_RUPEE_LEGGINGS.getKey(), ItemRegistry.YELLOW_RUPEE_BOOTS.getKey(), ItemRegistry.GREEN_RUPEE_HELMET.getKey(), ItemRegistry.GREEN_RUPEE_CHESTPLATE.getKey(), ItemRegistry.GREEN_RUPEE_LEGGINGS.getKey(), ItemRegistry.GREEN_RUPEE_BOOTS.getKey(), ItemRegistry.BLUE_RUPEE_HELMET.getKey(), ItemRegistry.BLUE_RUPEE_CHESTPLATE.getKey(), ItemRegistry.BLUE_RUPEE_LEGGINGS.getKey(), ItemRegistry.BLUE_RUPEE_BOOTS.getKey(), ItemRegistry.GRAY_RUPEE_HELMET.getKey(), ItemRegistry.GRAY_RUPEE_CHESTPLATE.getKey(), ItemRegistry.GRAY_RUPEE_LEGGINGS.getKey(), ItemRegistry.GRAY_RUPEE_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_SKYTHERN).add(ItemRegistry.skythern_pickaxe.getKey(), ItemRegistry.skythern_shovel.getKey(), ItemRegistry.skythern_axe.getKey(), ItemRegistry.skythern_hoe.getKey(), ItemRegistry.skythern_shickaxe.getKey(), ItemRegistry.skythern_blade.getKey(), ItemRegistry.skythern_bow.getKey(), ItemRegistry.skythern_phaser.getKey(), ItemRegistry.skythern_blitz.getKey(), ItemRegistry.skythern_shield.getKey(), ItemRegistry.SKYTHERN_HELMET.getKey(), ItemRegistry.SKYTHERN_CHESTPLATE.getKey(), ItemRegistry.SKYTHERN_LEGGINGS.getKey(), ItemRegistry.SKYTHERN_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_TERRAN).add(ItemRegistry.terran_pickaxe.getKey(), ItemRegistry.terran_shovel.getKey(), ItemRegistry.terran_axe.getKey(), ItemRegistry.terran_hoe.getKey(), ItemRegistry.terran_shickaxe.getKey(), ItemRegistry.terran_shifter.getKey(), ItemRegistry.terran_dagger.getKey(), ItemRegistry.terran_knife.getKey(), ItemRegistry.terran_maul.getKey(), ItemRegistry.TERRAN_HELMET.getKey(), ItemRegistry.TERRAN_CHESTPLATE.getKey(), ItemRegistry.TERRAN_LEGGINGS.getKey(), ItemRegistry.TERRAN_BOOTS.getKey());
        tag(TagRegistry.SMELTABLE_TORRIDITE).add(ItemRegistry.massivence.getKey(), ItemRegistry.frossivence.getKey(), ItemRegistry.scorching_sword.getKey());
        tag(TagRegistry.SMELTABLE_WILDWOOD).add(ItemRegistry.wildwood_pickaxe.getKey(), ItemRegistry.wildwood_shovel.getKey(), ItemRegistry.wildwood_axe.getKey(), ItemRegistry.wildwood_hoe.getKey(), ItemRegistry.wildwood_shickaxe.getKey(), ItemRegistry.wildwood_blade.getKey(), ItemRegistry.wildwood_bow.getKey(), ItemRegistry.wildwood_phaser.getKey(), ItemRegistry.wildwood_blitz.getKey(), ItemRegistry.wildwood_shield.getKey(), ItemRegistry.WILDWOOD_HELMET.getKey(), ItemRegistry.WILDWOOD_CHESTPLATE.getKey(), ItemRegistry.WILDWOOD_LEGGINGS.getKey(), ItemRegistry.WILDWOOD_BOOTS.getKey());

        tag(TagRegistry.SKIN_KRAKEN).add(ItemRegistry.kraken_skin.getKey());
        tag(TagRegistry.HEART_EDEN).add(ItemRegistry.eden_heart.getKey());
        tag(TagRegistry.HEART_WILDWOOD).add(ItemRegistry.wildwood_heart.getKey());
        tag(TagRegistry.HEART_APALACHIA).add(ItemRegistry.apalachia_heart.getKey());
        tag(TagRegistry.HEART_SKYTHERN).add(ItemRegistry.skythern_heart.getKey());
        tag(TagRegistry.HEART_MORTUM).add(ItemRegistry.mortum_heart.getKey());
        tag(TagRegistry.HEARTS).addTags(TagRegistry.HEART_EDEN, TagRegistry.HEART_WILDWOOD, TagRegistry.HEART_APALACHIA, TagRegistry.HEART_SKYTHERN, TagRegistry.HEART_MORTUM);

        tag(TagRegistry.DIAMOND_GRAY).add(ItemRegistry.gray_diamond_chunk.getKey());
        tag(TagRegistry.DIAMOND_BLUE).add(ItemRegistry.blue_diamond_chunk.getKey());
        tag(TagRegistry.DIAMOND_GREEN).add(ItemRegistry.green_diamond_chunk.getKey());
        tag(TagRegistry.DIAMOND_RED).add(ItemRegistry.red_diamond_chunk.getKey());
        tag(TagRegistry.DIAMOND_YELLOW).add(ItemRegistry.yellow_diamond_chunk.getKey());
        tag(commonTag("gems/diamond")).addTags(TagRegistry.DIAMOND_GRAY, TagRegistry.DIAMOND_BLUE, TagRegistry.DIAMOND_GREEN, TagRegistry.DIAMOND_RED, TagRegistry.DIAMOND_YELLOW);
        tag(TagRegistry.DIAMOND_NO).addTags(ItemTags.create(Identifier.fromNamespaceAndPath("c", "gems/diamond"))).remove(ItemRegistry.gray_diamond_chunk.getKey(), ItemRegistry.blue_diamond_chunk.getKey(), ItemRegistry.green_diamond_chunk.getKey(), ItemRegistry.red_diamond_chunk.getKey(), ItemRegistry.yellow_diamond_chunk.getKey());

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
        registerTool(ItemTags.PICKAXES, ItemRegistry.realmite_pickaxe.getKey(), ItemRegistry.arlemite_pickaxe.getKey());
        registerTool(ItemTags.AXES, ItemRegistry.realmite_axe.getKey(), ItemRegistry.arlemite_axe.getKey());
        registerTool(ItemTags.SHOVELS, ItemRegistry.realmite_shovel.getKey(), ItemRegistry.arlemite_shovel.getKey());
        registerTool(ItemTags.HOES, ItemRegistry.realmite_hoe.getKey(), ItemRegistry.arlemite_hoe.getKey());
        registerTool(ItemTags.SWORDS, ItemRegistry.realmite_sword.getKey(), ItemRegistry.arlemite_stabber.getKey());

        tag(TagRegistry.TOOL_MAUL).add(
                ItemRegistry.aquatic_maul.getKey(),
                ItemRegistry.bedrock_maul.getKey()
        );
        tag(TagRegistry.SHICKAXES).add(
                ItemRegistry.rupee_shickaxe.getKey(),
                ItemRegistry.arlemite_shickaxe.getKey()
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