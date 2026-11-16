package divinerpg.data;

import divinerpg.registries.DivineRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagCopyingItemTagProvider;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.*;
import static divinerpg.registries.ItemRegistry.*;
import static divinerpg.registries.TagRegistry.Items.*;
import static divinerpg.registries.TagRegistry.BlockItems.*;
import static divinerpg.registries.TagRegistry.Items.RAW_MATERIALS_ARLEMITE;
import static net.minecraft.core.registries.Registries.ITEM;

public class ModItemTagsProvider extends BlockTagCopyingItemTagProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        for(var entry : DivineRegistries.ITEMS.getEntries()) {
            Item item = entry.get();
            if(item == Items.AIR) continue;
            var itemKey = toKey(item);
            String path = entry.getId().getPath();
            if(path.contains("_shovel")) tag(TOOLS_SHOVEL).add(itemKey);
            if(path.contains("_pickaxe")) tag(TOOLS_PICKAXE).add(itemKey);
            if(path.contains("_axe")) tag(TOOLS_AXE).add(itemKey);
            if(path.contains("_hoe")) tag(TOOLS_HOE).add(itemKey);
            if(path.contains("_shickaxe")) tag(TOOLS_SHICKAXE).add(itemKey);
            if(path.contains("_dagger") || path.contains("_stabber")) tag(TOOLS_DAGGER).add(itemKey);
            if(path.contains("_knife")) tag(TOOLS_KNIFE).add(itemKey);
            if(path.contains("_backsword")) tag(TOOLS_BACKSWORD).add(itemKey);
            if(path.contains("_blade")) tag(TOOLS_BLADE).add(itemKey);
            if(path.contains("_rapier")) tag(TOOLS_RAPIER).add(itemKey);
            if(path.contains("_saber") || path.contains("_sabre")) tag(TOOLS_SABER).add(itemKey);
            if(path.contains("slash")) tag(TOOLS_SLASH).add(itemKey);
            if(path.contains("_divine_sword")) tag(TOOLS_SWORD_DIVINE).add(itemKey);
            if(path.contains("_ender_sword")) tag(TOOLS_SWORD_ENDER).add(itemKey);
            if(path.contains("_claw") && itemKey != crab_claw.key()) tag(TOOLS_CLAW).add(itemKey);
            if(path.contains("maul")) tag(TOOLS_MAUL).add(itemKey);
            if(path.contains("_hammer")) tag(TOOLS_HAMMER).add(itemKey);
            if(path.contains("_anchor")) tag(TOOLS_ANCHOR).add(itemKey);
            if(path.contains("sound_of_")) tag(TOOLS_HARP).add(itemKey);
            if(path.contains("serenade_")) tag(TOOLS_SERENADE).add(itemKey);
            if(path.contains("_scepter")) tag(TOOLS_SCEPTER).add(itemKey);
            if(path.contains("_phaser")) tag(TOOLS_PHASER).add(itemKey);
            if(path.contains("_blitz")) tag(TOOLS_BLITZ).add(itemKey);
            if(path.contains("_cannon")) tag(TOOLS_CANNON).add(itemKey);
            if(path.contains("_bow")) tag(TOOLS_BOW).add(itemKey);
            if(path.contains("_disk")) tag(TOOLS_DISK).add(itemKey);
            if(path.contains("_dissipator")) tag(TOOLS_DISSIPATOR).add(itemKey);
            if(path.contains("_slicer")) tag(TOOLS_SLICER).add(itemKey);
            if(path.contains("_shield")) tag(TOOLS_SHIELD).add(itemKey);
            if(path.contains("_helmet") || path.contains("_hood") || path.contains("_mask")) tag(ARMOR_HEAD).add(itemKey);
            if(path.contains("_chestplate")) tag(ARMOR_CHEST).add(itemKey);
            if(path.contains("_leggings")) tag(ARMOR_LEG).add(itemKey);
            if(path.contains("_boots")) tag(ARMOR_FOOT).add(itemKey);
            if(path.contains("_helmet")) {
                if(path.contains("seng_fur") || path.contains("santa")) tag(ARMOR_HEAD_SENG_FUR).add(itemKey);
                if(path.contains("rupee")) tag(ARMOR_HEAD_RUPEE).add(itemKey);
                if(path.contains("ender")) tag(ARMOR_HEAD_ENDER).add(itemKey);
            }
            if(path.contains("_chestplate")) {
                if(path.contains("seng_fur") || path.contains("santa")) tag(ARMOR_CHEST_SENG_FUR).add(itemKey);
                if(path.contains("rupee")) tag(ARMOR_CHEST_RUPEE).add(itemKey);
                if(path.contains("ender")) tag(ARMOR_CHEST_ENDER).add(itemKey);
            }
            if(path.contains("_leggings")) {
                if(path.contains("seng_fur") || path.contains("santa")) tag(ARMOR_LEG_SENG_FUR).add(itemKey);
                if(path.contains("rupee")) tag(ARMOR_LEG_RUPEE).add(itemKey);
                if(path.contains("ender")) tag(ARMOR_LEG_ENDER).add(itemKey);
            }
            if(path.contains("_boots")) {
                if(path.contains("seng_fur") || path.contains("santa")) tag(ARMOR_FOOT_SENG_FUR).add(itemKey);
                if(path.contains("rupee")) tag(ARMOR_FOOT_RUPEE).add(itemKey);
                if(path.contains("ender")) tag(ARMOR_FOOT_ENDER).add(itemKey);
            }
            if(path.contains("_helmet") || path.contains("_hood") || path.contains("_mask") || path.contains("_chestplate") || path.contains("_leggings") || path.contains("_boots")) {
                if(path.contains("realmite")) tag(ARMOR_SETS_REALMITE).add(itemKey);
                if(path.contains("aquastrive")) tag(ARMOR_SETS_AQUASTRIVE).add(itemKey);
                if(path.contains("kraken")) tag(ARMOR_SETS_KRAKEN).add(itemKey);
                if(path.contains("jack_o_man")) tag(ARMOR_SETS_JACK_O_MAN).add(itemKey);
                if(path.contains("skeleman")) tag(ARMOR_SETS_SKELEMAN).add(itemKey);
                if(path.contains("wither_reaper")) tag(ARMOR_SETS_WITHER_REAPER).add(itemKey);
                if(path.contains("arlemite")) tag(ARMOR_SETS_ARLEMITE).add(itemKey);
                if(path.contains("frozen")) tag(ARMOR_SETS_FROZEN).add(itemKey);
                if(path.contains("jungle")) tag(ARMOR_SETS_JUNGLE).add(itemKey);
                if(path.contains("inferno")) tag(ARMOR_SETS_INFERNO).add(itemKey);
                if(path.contains("torridite")) tag(ARMOR_SETS_TORRIDITE).add(itemKey);
                if(path.contains("terran")) tag(ARMOR_SETS_TERRAN).add(itemKey);
                if(path.contains("angelic")) tag(ARMOR_SETS_ANGELIC).add(itemKey);
                if(path.contains("shadow")) tag(ARMOR_SETS_SHADOW).add(itemKey);
                if(path.contains("elite_realmite")) tag(ARMOR_SETS_ELITE_REALMITE).add(itemKey);
                if(path.contains("corrupted")) tag(ARMOR_SETS_CORRUPTED).add(itemKey);
                if(path.contains("bedrock")) tag(ARMOR_SETS_BEDROCK).add(itemKey);
                if(path.contains("korma")) tag(ARMOR_SETS_KORMA).add(itemKey);
                if(path.contains("vemos")) tag(ARMOR_SETS_VEMOS).add(itemKey);
                if(path.contains("divine")) tag(ARMOR_SETS_DIVINE).add(itemKey);
                if(path.contains("eden")) tag(ARMOR_SETS_EDEN).add(itemKey);
                if(path.contains("wildwood")) tag(ARMOR_SETS_WILDWOOD).add(itemKey);
                if(path.contains("apalachia")) tag(ARMOR_SETS_APALACHIA).add(itemKey);
                if(path.contains("skythern")) tag(ARMOR_SETS_SKYTHERN).add(itemKey);
                if(path.contains("mortum")) tag(ARMOR_SETS_MORTUM).add(itemKey);
                if(path.contains("halite")) tag(ARMOR_SETS_HALITE).add(itemKey);
                if(path.contains("awakened_halite")) tag(ARMOR_SETS_AWAKENED_HALITE).add(itemKey);
                if(path.contains("degraded")) tag(ARMOR_SETS_DEGRADED).add(itemKey);
                if(path.contains("finished")) tag(ARMOR_SETS_FINISHED).add(itemKey);
                if(path.contains("glistening")) tag(ARMOR_SETS_GLISTENING).add(itemKey);
                if(path.contains("demonized")) tag(ARMOR_SETS_DEMONIZED).add(itemKey);
                if(path.contains("tormented")) tag(ARMOR_SETS_TORMENTED).add(itemKey);
            }
        }
        tag(FRAGMENTS_COLLECTOR).add(collector_fragments.key());
        tag(FRAGMENTS_EDEN).add(eden_fragments.key());
        tag(FRAGMENTS_WILDWOOD).add(wildwood_fragments.key());
        tag(FRAGMENTS_APALACHIA).add(apalachia_fragments.key());
        tag(FRAGMENTS_SKYTHERN).add(skythern_fragments.key());
        tag(FRAGMENTS_MORTUM).add(mortum_fragments.key());
        tag(FRAGMENTS_TWILIGHT).addTags(FRAGMENTS_EDEN, FRAGMENTS_WILDWOOD, FRAGMENTS_APALACHIA, FRAGMENTS_SKYTHERN, FRAGMENTS_MORTUM);
        tag(FRAGMENTS).addTags(FRAGMENTS_COLLECTOR, FRAGMENTS_TWILIGHT);

        tag(PELLETS_AQUATIC).add(aquatic_pellets.key());
        tag(PELLETS_AQUATIC_PURE).add(pure_aquatic_pellets.key());

        tag(COALS_ANTHRACITE).add(anthracite.key());
        tag(ItemTags.COALS).addTag(COALS_ANTHRACITE);
        tag(commonTag("coals/anthracite")).addTag(COALS_ANTHRACITE);
        tag(ItemTags.FURNACE_MINECART_FUEL).addTag(COALS_ANTHRACITE);
        tag(FUELS_COLLECTOR).add(collector.key());
        tag(CYCLING_FROSTED_ALLURE).addTag(GEMS_ICE);

        tag(LUMPS_TEAKER).add(teaker_lump.key());
        tag(LUMPS_AMTHIRMIS).add(amthirmis_lump.key());
        tag(LUMPS_DARVEN).add(darven_lump.key());
        tag(LUMPS_CERMILE).add(cermile_lump.key());
        tag(LUMPS_PARDIMAL).add(pardimal_lump.key());
        tag(LUMPS_QUADROTIC).add(quadrotic_lump.key());
        tag(LUMPS_KAROS).add(karos_lump.key());
        tag(LUMPS_HELIOSIS).add(heliosis_lump.key());
        tag(LUMPS_ARKSIANE).add(arksiane_lump.key());
        tag(LUMPS).addTags(LUMPS_TEAKER, LUMPS_AMTHIRMIS, LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);

        tag(RAW_MATERIALS_AQUATIC).addTag(PELLETS_AQUATIC_PURE);
        tag(RAW_MATERIALS_REALMITE).add(raw_realmite.key());
        tag(RAW_MATERIALS_ARLEMITE).add(raw_arlemite.key());
        tag(RAW_MATERIALS_RUPEE).add(raw_rupee.key());
        tag(RAW_MATERIALS_TORRIDITE).add(raw_torridite.key());
        tag(RAW_MATERIALS_OXDRITE).add(raw_oxdrite.key());
        tag(RAW_MATERIALS_ARCANIUM).add(piece_of_raw_arcanium.key());
        tag(Tags.Items.RAW_MATERIALS).addTags(RAW_MATERIALS_AQUATIC, RAW_MATERIALS_REALMITE, RAW_MATERIALS_ARLEMITE, RAW_MATERIALS_RUPEE, RAW_MATERIALS_TORRIDITE, RAW_MATERIALS_OXDRITE, RAW_MATERIALS_ARCANIUM);

        tag(DUSTS_REALMITE).add(realmite_dust.key());
        tag(DUSTS_ARLEMITE).add(arlemite_dust.key());
        tag(DUSTS_RUPEE).add(rupee_dust.key());
        tag(DUSTS_SHADOW).add(shadow_dust.key());
        tag(DUSTS_BLOODGEM).add(bloodgem_dust.key());
        tag(DUSTS_TORRIDITE).add(torridite_dust.key());
        tag(DUSTS_OXDRITE).add(oxdrite_dust.key());
        tag(DUSTS_EDEN).add(eden_dust.key());
        tag(DUSTS_WILDWOOD).add(wildwood_dust.key());
        tag(DUSTS_APALACHIA).add(apalachia_dust.key());
        tag(DUSTS_SKYTHERN).add(skythern_dust.key());
        tag(DUSTS_MORTUM).add(mortum_dust.key());
        tag(Tags.Items.DUSTS).addTags(DUSTS_REALMITE, DUSTS_ARLEMITE, DUSTS_RUPEE, DUSTS_SHADOW, DUSTS_BLOODGEM, DUSTS_TORRIDITE, DUSTS_OXDRITE, DUSTS_EDEN, DUSTS_WILDWOOD, DUSTS_APALACHIA, DUSTS_SKYTHERN, DUSTS_MORTUM);

        tag(NUGGETS_REALMITE).add(realmite_nugget.key());
        tag(NUGGETS_ARLEMITE).add(arlemite_nugget.key());
        tag(NUGGETS_RUPEE).add(rupee_nugget.key());
        tag(NUGGETS_TORRIDITE).add(torridite_nugget.key());
        tag(NUGGETS_OXDRITE).add(oxdrite_nugget.key());
        tag(Tags.Items.NUGGETS).addTags(NUGGETS_REALMITE, NUGGETS_ARLEMITE, NUGGETS_RUPEE, NUGGETS_TORRIDITE, NUGGETS_OXDRITE);
        tag(ItemTags.METAL_NUGGETS).addTags(NUGGETS_REALMITE, NUGGETS_ARLEMITE, NUGGETS_RUPEE, NUGGETS_TORRIDITE, NUGGETS_OXDRITE);

        tag(INGOTS_AQUATIC).add(aquatic_ingot.key());
        tag(INGOTS_REALMITE).add(realmite_ingot.key());
        tag(INGOTS_ARLEMITE).add(arlemite_ingot.key());
        tag(INGOTS_RUPEE).add(rupee_ingot.key());
        tag(INGOTS_SHADOW).add(shadow_bar.key());
        tag(INGOTS_TORRIDITE).add(torridite_ingot.key());
        tag(INGOTS_HELLSTONE).add(hellstone_ingot.key());
        tag(INGOTS_OXDRITE).add(oxdrite_ingot.key());
        tag(Tags.Items.INGOTS).addTags(INGOTS_AQUATIC, INGOTS_REALMITE, INGOTS_ARLEMITE, INGOTS_RUPEE, INGOTS_SHADOW, INGOTS_TORRIDITE, INGOTS_HELLSTONE, INGOTS_OXDRITE);

        tag(ALLOY_BASES_REALMITE).addTags(RAW_MATERIALS_REALMITE, DUSTS_REALMITE, INGOTS_REALMITE).addOptional(crushed_raw_realmite.key());
        tag(ALLOY_BASES_ARLEMITE).addTags(RAW_MATERIALS_ARLEMITE, DUSTS_ARLEMITE, INGOTS_ARLEMITE).addOptional(crushed_raw_arlemite.key());
        tag(ALLOY_BASES_RUPEE).addTags(RAW_MATERIALS_RUPEE, DUSTS_RUPEE, INGOTS_RUPEE).addOptional(crushed_raw_rupee.key());
        tag(ALLOY_BASES_SHADOW).addTags(DUSTS_SHADOW, INGOTS_SHADOW);
        tag(ALLOY_BASES_BLOODGEM).addTags(DUSTS_BLOODGEM, GEMS_BLOODGEM);
        tag(ALLOY_BASES_TORRIDITE).addTags(RAW_MATERIALS_TORRIDITE, DUSTS_TORRIDITE, INGOTS_TORRIDITE).addOptional(crushed_raw_torridite.key());
        tag(ALLOY_BASES_OXDRITE).addTags(RAW_MATERIALS_OXDRITE, DUSTS_OXDRITE, INGOTS_OXDRITE).addOptional(crushed_raw_oxdrite.key());

        tag(SHARDS_ICE).add(ice_shards.key());
        tag(SHARDS_JUNGLE).add(jungle_shards.key());
        tag(SHARDS_TERRAN).add(terran_shards.key());
        tag(SHARDS_MOLTEN).add(molten_shards.key());
        tag(SHARDS_CORRUPTED).add(corrupted_shards.key());
        tag(SHARDS_ENDER).add(ender_shards.key());
        tag(SHARDS_DIVINE).add(divine_shards.key());
        tag(SHARDS).addTags(SHARDS_ICE, SHARDS_JUNGLE, SHARDS_TERRAN, SHARDS_MOLTEN, SHARDS_CORRUPTED, SHARDS_ENDER, SHARDS_DIVINE);

        tag(GEMS_OLIVINE).add(olivine.key());
        tag(commonTag("gems/olivine")).addTag(GEMS_OLIVINE);
        tag(GEMS_ICE).add(ice_stone.key());
        tag(GEMS_JUNGLE).add(jungle_stone.key());
        tag(GEMS_TERRAN).add(terran_stone.key());
        tag(GEMS_SHADOW).add(shadow_stone.key());
        tag(GEMS_BLOODGEM).add(bloodgem.key());
        tag(GEMS_HEALING).add(healing_stone.key());
        tag(GEMS_MOLTEN).add(molten_stone.key());
        tag(GEMS_SOULFIRE).add(soulfire_stone.key());
        tag(GEMS_ARCANIUM).add(arcanium.key());
        tag(GEMS_CORRUPTED).add(corrupted_stone.key());
        tag(GEMS_ENDER).add(ender_stone.key());
        tag(GEMS_DIVINE).add(divine_stone.key());
        tag(GEMS_EDEN).add(eden_gem.key());
        tag(GEMS_WILDWOOD).add(wildwood_gem.key());
        tag(GEMS_APALACHIA).add(apalachia_gem.key());
        tag(GEMS_SKYTHERN).add(skythern_gem.key());
        tag(GEMS_MORTUM).add(mortum_gem.key());
        tag(Tags.Items.GEMS).addTags(GEMS_OLIVINE, GEMS_ICE, GEMS_JUNGLE, GEMS_TERRAN, GEMS_SHADOW, GEMS_BLOODGEM, GEMS_HEALING, GEMS_MOLTEN, GEMS_SOULFIRE, GEMS_ARCANIUM, GEMS_CORRUPTED, GEMS_ENDER, GEMS_DIVINE, GEMS_EDEN, GEMS_WILDWOOD, GEMS_APALACHIA, GEMS_SKYTHERN, GEMS_MORTUM);

        tag(CHUNKS_DIAMOND_GRAY).add(gray_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_RED).add(red_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_YELLOW).add(yellow_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_GREEN).add(green_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_BLUE).add(blue_diamond_chunk.key());
        tag(CHUNKS_DIAMOND).addTags(CHUNKS_DIAMOND_GRAY, CHUNKS_DIAMOND_RED, CHUNKS_DIAMOND_YELLOW, CHUNKS_DIAMOND_GREEN, CHUNKS_DIAMOND_BLUE);
        tag(Tags.Items.GEMS_DIAMOND).addTag(CHUNKS_DIAMOND);
        tag(CHUNKS_TORRIDITE).add(torridite_chunk.key());
        tag(CHUNKS_BEDROCK).add(bedrock_chunk.key());
        tag(CHUNKS_EDEN).add(eden_chunk.key());
        tag(CHUNKS_WILDWOOD).add(wildwood_chunk.key());
        tag(CHUNKS_APALACHIA).add(apalachia_chunk.key());
        tag(CHUNKS_SKYTHERN).add(skythern_chunk.key());
        tag(CHUNKS_MORTUM).add(mortum_chunk.key());
        tag(CHUNKS_TWILIGHT).addTags(CHUNKS_EDEN, CHUNKS_WILDWOOD, CHUNKS_APALACHIA, CHUNKS_SKYTHERN, CHUNKS_MORTUM);
        tag(Tags.Items.GEMS).addTag(CHUNKS_TWILIGHT);
        tag(CHUNKS).addTags(CHUNKS_DIAMOND, CHUNKS_TORRIDITE, CHUNKS_BEDROCK, CHUNKS_TWILIGHT);

        tag(SOULS_EDEN).add(eden_soul.key());
        tag(SOULS_WILDWOOD).add(wildwood_soul.key());
        tag(SOULS_APALACHIA).add(apalachia_soul.key());
        tag(SOULS_SKYTHERN).add(skythern_soul.key());
        tag(SOULS_MORTUM).add(mortum_soul.key());
        tag(SOULS_TWILIGHT).addTags(SOULS_EDEN, SOULS_WILDWOOD, SOULS_APALACHIA, SOULS_SKYTHERN, SOULS_MORTUM);
        tag(SOULS).addTag(SOULS_TWILIGHT);
        tag(commonTag("souls")).addTag(SOULS);

        tag(HEARTS_EDEN).add(eden_heart.key());
        tag(HEARTS_WILDWOOD).add(wildwood_heart.key());
        tag(HEARTS_APALACHIA).add(apalachia_heart.key());
        tag(HEARTS_SKYTHERN).add(skythern_heart.key());
        tag(HEARTS_MORTUM).add(mortum_heart.key());
        tag(HEARTS_TWILIGHT).addTags(HEARTS_EDEN, HEARTS_WILDWOOD, HEARTS_APALACHIA, HEARTS_SKYTHERN, HEARTS_MORTUM);
        tag(HEARTS).addTag(HEARTS_TWILIGHT);
        tag(commonTag("hearts")).addTag(HEARTS);

        tag(ItemTags.BEACON_PAYMENT_ITEMS).addTags(CHUNKS, GEMS_ICE, GEMS_JUNGLE, GEMS_TERRAN, GEMS_SHADOW, GEMS_CORRUPTED, GEMS_DIVINE, GEMS_BLOODGEM, GEMS_HEALING, GEMS_MOLTEN, GEMS_SOULFIRE, GEMS_ENDER, GEMS_ARCANIUM, GEMS_EDEN, GEMS_WILDWOOD, GEMS_APALACHIA, GEMS_SKYTHERN, GEMS_MORTUM, INGOTS_AQUATIC, INGOTS_REALMITE, INGOTS_ARLEMITE, INGOTS_RUPEE, INGOTS_SHADOW, INGOTS_TORRIDITE, INGOTS_HELLSTONE, INGOTS_OXDRITE);

        tag(COINS_SHADOW).add(shadow_coins.key());
        tag(SNOWFLAKES).add(snowflake.key());

        tag(RIFT_REPLENISHING_OVERWORLD).addTag(Tags.Items.GEMS_DIAMOND);
        tag(RIFT_REPLENISHING_EDEN).addTag(GEMS_DIVINE);
        tag(RIFT_REPLENISHING_WILDWOOD).addTag(HEARTS_EDEN);
        tag(RIFT_REPLENISHING_APALACHIA).addTag(HEARTS_WILDWOOD);
        tag(RIFT_REPLENISHING_SKYTHERN).addTag(HEARTS_APALACHIA);
        tag(RIFT_REPLENISHING_MORTUM).addTag(HEARTS_SKYTHERN);

        tag(EYES_CYCLOPS).add(cyclops_eye.key());
        tag(commonTag("eyes/cyclops")).addTag(EYES_CYCLOPS);
        tag(EYES_ENDER_WATCHER).add(watching_eye.key());
        tag(EYES_LEGENDARY_ENDER).add(legendary_ender_eye.key());
        tag(EYES).addTags(EYES_CYCLOPS, EYES_ENDER_WATCHER, EYES_LEGENDARY_ENDER);
        tag(commonTag("eyes")).addTag(EYES);

        tag(TEETH_LIOPLEURODON).add(liopleurodon_teeth.key());
        tag(TEETH_SABEAR).add(sabear_tooth.key());
        tag(TEETH).addTags(TEETH_LIOPLEURODON, TEETH_SABEAR);
        tag(commonTag("teeth")).addTag(TEETH);

        tag(FINS_SHARK).add(shark_fin.key());
        tag(commonTag("fins/shark")).addTag(FINS_SHARK);
        tag(FINS_WHALE).add(whale_fin.key());
        tag(commonTag("fins/whale")).addTag(FINS_WHALE);
        tag(FINS).addTags(FINS_SHARK, FINS_WHALE);
        tag(commonTag("fins")).addTag(FINS);

        tag(CLAWS_CRAB).add(crab_claw.key());
        tag(CLAWS).addTag(CLAWS_CRAB);
        tag(commonTag("claws/crab")).addTag(CLAWS_CRAB);
        tag(commonTag("claws")).addTag(CLAWS_CRAB);

        tag(SKULLS_LIOPLEURODON).add(liopleurodon_skull.key());
        tag(SKINS_KRAKEN).add(kraken_skin.key());
        tag(Tags.Items.LEATHERS).addTag(SKINS_KRAKEN);

        tag(FURS_SENG).add(seng_fur.key());
        tag(FURS_SABEAR).add(sabear_fur.key());

        tag(POWDERS_PURPLE_BLAZE).add(purple_blaze.key());
        tag(POWDERS_FURY_FIRE).add(fury_fire.key());
        tag(POWDERS).addTags(POWDERS_PURPLE_BLAZE, POWDERS_FURY_FIRE);

        tag(RODS_AQUATIC_BLAZE).add(aquatic_blaze_rod.key());
        tag(Tags.Items.RODS).addTag(RODS_AQUATIC_BLAZE);

        tag(CLOCKS).add(toKey(Items.CLOCK), frozen_clock.key(), moon_clock.key(), mysterious_clock.key());
        tag(CLOCKS_NO_MYSTERIOUS).addTag(CLOCKS).remove(mysterious_clock.key());
        tag(DIAMOND_NO_CHUNKS).addTag(Tags.Items.GEMS_DIAMOND).remove(CHUNKS_DIAMOND_GRAY, CHUNKS_DIAMOND_RED, CHUNKS_DIAMOND_YELLOW, CHUNKS_DIAMOND_GREEN, CHUNKS_DIAMOND_BLUE);
        tag(Tags.Items.SLIME_BALLS).add(aqua_ball.key());
        tag(SLIME_BALLS_NO_AQUA).addTag(Tags.Items.SLIME_BALLS).remove(aqua_ball.key());
        tag(SANDS_NO_RICH).addTag(Tags.BlockItems.SANDS.item()).remove(toKey(arcaniumRichSand.asItem()));
        tag(PLANKS_NO_DESIGN).addTag(ItemTags.PLANKS).remove(toKey(plankDesign.asItem()));
        tag(WOODEN_STAIRS_NO_DESIGN).addTag(ItemTags.WOODEN_STAIRS).remove(toKey(stairDesign.asItem()));
        tag(WOODEN_SLABS_NO_DESIGN).addTag(ItemTags.WOODEN_SLABS).remove(toKey(slabDesign.asItem()));

        tag(ItemTags.BOOKSHELF_BOOKS).add(wizards_book.key(), maelstrom.key());

        tag(AMMO_ROPE).add(toKey(Items.LEAD)).addOptionalTag(Tags.BlockItems.ROPES.item());
        tag(AMMO_GRENADE).add(grenade.key());
        tag(AMMO_AQUATIC_CANNON).add(toKey(Items.CACTUS));
        tag(AMMO_CORRUPTED_CANNON).add(corrupted_bullet.key());
        tag(AMMO_FROST_CANNON).add(toKey(Items.SNOWBALL));
        tag(AMMO_FRACTITE_CANNON).addTag(SHARDS_ICE);
        tag(AMMO_GOLDEN_FURY).addTag(Tags.Items.NUGGETS_GOLD);
        tag(AMMO_EDEN_BLITZ).addTag(DUSTS_EDEN);
        tag(AMMO_WILDWOOD_BLITZ).addTag(DUSTS_WILDWOOD);
        tag(AMMO_APALACHIA_BLITZ).addTag(DUSTS_APALACHIA);
        tag(AMMO_SKYTHERN_BLITZ).addTag(DUSTS_SKYTHERN);
        tag(AMMO_MORTUM_BLITZ).addTag(DUSTS_MORTUM);
        tag(AMMO_HALITE_BLITZ).addTag(DUSTS_MORTUM);
        tag(AMMO_VETHEAN_CANNON).add(acid.key());
        tag(ItemTags.ARROWS).add(hunter_arrow.key(), shadow_arrow.key(), icicle_arrow.key(), inferno_arrow.key(), soulfire_arrow.key(), snowstorm_arrow.key(), ender_arrow.key(), eden_arrow.key(), wildwood_arrow.key(), fury_arrow.key(), teaker_arrow.key(), darven_arrow.key(), pardimal_arrow.key(), karos_arrow.key(), ever_arrow.key());

        tag(ARMOR_SETS_SENG_FUR).addTags(ARMOR_HEAD_SENG_FUR, ARMOR_CHEST_SENG_FUR, ARMOR_LEG_SENG_FUR, ARMOR_FOOT_SENG_FUR);
        tag(ARMOR_SETS_RUPEE).addTags(ARMOR_HEAD_RUPEE, ARMOR_CHEST_RUPEE, ARMOR_LEG_RUPEE, ARMOR_FOOT_RUPEE);
        tag(ARMOR_SETS_ENDER).addTags(ARMOR_HEAD_ENDER, ARMOR_CHEST_ENDER, ARMOR_LEG_ENDER, ARMOR_FOOT_ENDER);
        tag(ItemTags.FREEZE_IMMUNE_WEARABLES).addTag(ARMOR_SETS_SENG_FUR);
        tag(ItemTags.HEAD_ARMOR).addTag(ARMOR_HEAD);
        tag(ItemTags.CHEST_ARMOR).addTag(ARMOR_CHEST);
        tag(ItemTags.LEG_ARMOR).addTag(ARMOR_LEG);
        tag(ItemTags.FOOT_ARMOR).addTag(ARMOR_FOOT);

        tag(TOOLS_LEVEL_DIAMOND_SHICKAXE).add(arlemite_shickaxe.key(), rupee_shickaxe.key(), terran_shickaxe.key());
        tag(commonTag("tools/level/diamond/multipurpose")).addTag(TOOLS_LEVEL_DIAMOND_SHICKAXE);
        tag(TOOLS_LEVEL_NETHERITE_SHICKAXE).add(corrupted_shickaxe.key(), divine_shickaxe.key(), eden_shickaxe.key(), wildwood_shickaxe.key(), apalachia_shickaxe.key(), skythern_shickaxe.key(), mortum_shickaxe.key(), halite_shickaxe.key());
        tag(commonTag("tools/level/netherite/multipurpose")).addTag(TOOLS_LEVEL_NETHERITE_SHICKAXE);
        tag(TOOLS_EFFECT_FIRE).add(molten_sword.key(), inferno_sword.key(), fury_fire.key());
        tag(TOOLS_EFFECT_POISON).add(jungle_knife.key(), jungle_rapier.key(), poison_saber.key());
        tag(TOOLS_EFFECT_SLOWNESS).add(glacier_sword.key(), frozen_maul.key(), frost_sword.key(), icicle_bane.key(), glacial_blade.key(), enderice.key(), icine_sword.key(), snowslash.key());
        tag(commonTag("tools/dagger")).addTag(TOOLS_DAGGER);
        tag(commonTag("tools/knife")).addTag(TOOLS_KNIFE);
        tag(TOOLS_SWORD_FIRE).add(molten_sword.key(), inferno_sword.key(), fury_fire.key());
        tag(TOOLS_SWORD_HEALING).add(palavence.key(), massivence.key(), frossivence.key());
        tag(TOOLS_SWORD).addTags(TOOLS_BACKSWORD, TOOLS_BLADE, TOOLS_SWORD_FIRE, TOOLS_SWORD_DIVINE, TOOLS_SWORD_ENDER, TOOLS_SWORD_HEALING, TOOLS_RAPIER, TOOLS_SABER, TOOLS_SLASH).add(cyclopsian_sword.key(), slime_sword.key(), glacier_sword.key(), shark_sword.key(), aquatooth_sword.key(), aquaton.key(), realmite_sword.key(), bedrock_sword.key(), bloodgem_sword.key(), scorching_sword.key(), soulfire_sword.key(), frost_sword.key(), frostking_sword.key(), icicle_bane.key(), storm_sword.key(), livicia_sword.key());
        tag(ItemTags.SWORDS).addTag(TOOLS_SWORD);
        tag(TOOLS_CLAW).add(everbright.key());
        tag(TOOLS_SPEAR).add(death_bringer.key());
        tag(ItemTags.SPEARS).addTag(TOOLS_SPEAR);
        tag(commonTag("tools/spear")).addTag(TOOLS_SPEAR);
        tag(TOOLS_TRIDENT).add(aquatic_trident.key());
        tag(Tags.Items.TOOLS_TRIDENT).addTag(TOOLS_TRIDENT);
        tag(commonTag("tools/maul")).addTag(TOOLS_MAUL);
        tag(TOOLS_HAMMER).add(everlight.key());
        tag(Tags.Items.MELEE_WEAPON_TOOLS).addTags(TOOLS_DAGGER, TOOLS_KNIFE, TOOLS_SWORD, TOOLS_AXE, TOOLS_SPEAR, TOOLS_TRIDENT, TOOLS_CLAW, TOOLS_MAUL, TOOLS_HAMMER, TOOLS_ANCHOR);
        tag(TOOLS_STAFF).add(cyclopsian_staff.key(), scythe.key(), staff_of_enrichment.key(), generals_staff.key(), starlight.key(), staff_of_starlight.key(), meteor_mash.key(), teaker_staff.key(), amthirmis_staff.key(), darven_staff.key(), cermile_staff.key(), pardimal_staff.key(), quadrotic_staff.key(), karos_staff.key(), heliosis_staff.key(), arksiane_staff.key(), evernight.key());
        tag(TOOLS_CANNON).add(eversight.key());
        tag(TOOLS_BOW).add(everfright.key());
        tag(Tags.Items.TOOLS_BOW).addTag(TOOLS_BOW);
        tag(TOOLS_SHURIKEN).addTag(TOOLS_SLICER).add(shuriken.key(), vile_storm.key(), snowflake_shuriken.key());
        tag(Tags.Items.RANGED_WEAPON_TOOLS).addTags(TOOLS_ANCHOR, TOOLS_HARP, TOOLS_PHASER, TOOLS_STAFF, TOOLS_CANNON, TOOLS_BOW, TOOLS_SHURIKEN, TOOLS_DISK, TOOLS_DISSIPATOR).add(serenade_striker.key(), serenade_of_ice.key(), serenade_of_death.key(), maelstrom.key(), arcanium_attractor.key(), arcanium_reflector.key(), captains_sparkler.key(), grenade.key(), la_vekor.key(), firefly.key(), meriks_missile.key(), storm_sword.key()).remove(staff_of_enrichment.key());
        tag(Tags.Items.TOOLS_SHIELD).addTag(TOOLS_SHIELD);
        tag(TOOLS_UNBREAKABLE).addTags(ARMOR_SETS_BEDROCK, ARMOR_SETS_ENDER, ARMOR_SETS_DIVINE, TOOLS_SWORD_DIVINE).add(divine_accumulator.key(), ender_scepter.key(), ghostbane.key(), arcanium_attractor.key(), arcanium_reflector.key(), bedrock_sword.key(), bedrock_maul.key(), frozen_maul.key(), bloodgem_sword.key(), inferno_sword.key(), enderice.key(), storm_sword.key(), shadow_saber.key(), arcanium_saber.key(), teaker_backsword.key(), amthirmis_backsword.key(), darven_backsword.key(), cermile_backsword.key(), pardimal_backsword.key(), quadrotic_backsword.key(), karos_backsword.key(), heliosis_backsword.key(), arksiane_backsword.key(), teaker_hammer.key(), amthirmis_hammer.key(), darven_hammer.key(), cermile_hammer.key(), pardimal_hammer.key(), quadrotic_hammer.key(), karos_hammer.key(), heliosis_hammer.key(), arksiane_hammer.key(), everlight.key(), karos_rockmaul.key(), teaker_claw.key(), amthirmis_claw.key(), darven_claw.key(), cermile_claw.key(), pardimal_claw.key(), quadrotic_claw.key(), karos_claw.key(), heliosis_claw.key(), arksiane_claw.key(), everbright.key(), halite_shield.key(), inferno_bow.key(), soulfire_bow.key(), snowstorm_bow.key(), ender_bow.key(), teaker_bow.key(), amthirmis_bow.key(), darven_bow.key(), cermile_bow.key(), pardimal_bow.key(), quadrotic_bow.key(), karos_bow.key(), heliosis_bow.key(), arksiane_bow.key(), everfright.key(), scythe.key(), teaker_staff.key(), amthirmis_staff.key(), darven_staff.key(), cermile_staff.key(), pardimal_staff.key(), quadrotic_staff.key(), karos_staff.key(), heliosis_staff.key(), arksiane_staff.key(), evernight.key(), teaker_cannon.key(), amthirmis_cannon.key(), darven_cannon.key(), cermile_cannon.key(), pardimal_cannon.key(), quadrotic_cannon.key(), karos_cannon.key(), heliosis_cannon.key(), arksiane_cannon.key(), eversight.key(), bedrock_shovel.key(), bedrock_pickaxe.key(), bedrock_axe.key(), bedrock_hoe.key(), divine_shovel.key(), divine_pickaxe.key(), divine_axe.key(), divine_hoe.key(), divine_shickaxe.key(), halite_shickaxe.key());

        tag(ARMOR_POUCHES).add(armor_pouch.key(), gray_armor_pouch.key(), red_armor_pouch.key(), yellow_armor_pouch.key(), green_armor_pouch.key(), blue_armor_pouch.key());
        tag(Tags.Items.MUSIC_DISCS).add(md_destiny.key(), md_red_stains.key());

        tag(Tags.Items.BUCKETS_WATER).add(aquamarine.key());
        tag(Tags.Items.BUCKETS_ENTITY_WATER).add(cauldron_fish_bucket.key(), gem_fin_bucket.key());
        tag(commonTag("buckets/tar")).add(smoldering_tar_bucket.key());
        tag(commonTag("buckets/smoldering_tar")).add(smoldering_tar_bucket.key());
        tag(Tags.Items.BUCKETS).add(smoldering_tar_bucket.key());

        tag(ItemTags.SHOVELS).addTag(TOOLS_SHOVEL);
        tag(ItemTags.DOUSES_CAMPFIRES).addTag(TOOLS_SHICKAXE);
        tag(ItemTags.PICKAXES).addTag(TOOLS_PICKAXE);
        tag(Tags.Items.MINING_TOOL_TOOLS).addTags(TOOLS_PICKAXE, TOOLS_SHICKAXE).add(terran_shifter.key());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).addTags(TOOLS_PICKAXE, TOOLS_SHICKAXE).add(terran_shifter.key());
        tag(ItemTags.AXES).addTag(TOOLS_AXE);
        tag(ItemTags.HOES).addTag(TOOLS_HOE);
        tag(commonTag("tools/shickaxe")).addTag(TOOLS_SHICKAXE);
        tag(commonTag("tools/multipurpose")).addTag(TOOLS_SHICKAXE);
        tag(ItemTags.BREAKS_DECORATED_POTS).addTags(TOOLS_SHICKAXE, TOOLS_DAGGER, TOOLS_KNIFE, TOOLS_SPEAR, TOOLS_TRIDENT, TOOLS_CLAW, TOOLS_MAUL, TOOLS_HAMMER, TOOLS_ANCHOR);
        tag(Tags.Items.TOOLS_IGNITER).add(frozen_clock.key(), snow_globe.key(), dream_flint.key());
        tag(Tags.Items.TOOLS).addTag(TOOLS_SCEPTER).add(jungle_hook.key(), teleportation_crystal.key(), teleportation_star.key(), serenade_of_health.key(), serenade_of_infusion.key(), divine_accumulator.key(), ghostbane.key(), staff_of_enrichment.key());

        tag(ItemTags.MINING_ENCHANTABLE).addTag(TOOLS_SHICKAXE).add(terran_shifter.key());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(TOOLS_SHICKAXE);
        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE).addTags(TOOLS_DAGGER, TOOLS_KNIFE, TOOLS_CLAW, TOOLS_MAUL, TOOLS_HAMMER, TOOLS_ANCHOR);
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).remove(TOOLS_EFFECT_FIRE, TOOLS_EFFECT_SLOWNESS);
        tag(ENCHANTABLE_BRAIN_FREEZE).addTag(ItemTags.FIRE_ASPECT_ENCHANTABLE);
        tag(Tags.Items.ENCHANTABLES).addTag(ENCHANTABLE_BRAIN_FREEZE);
        tag(ItemTags.TRIDENT_ENCHANTABLE).addTag(TOOLS_TRIDENT);
        tag(ItemTags.BOW_ENCHANTABLE).addTag(TOOLS_BOW);
        tag(ItemTags.DURABILITY_ENCHANTABLE).addTags(TOOLS_SHICKAXE, TOOLS_DAGGER, TOOLS_KNIFE, TOOLS_CLAW, TOOLS_MAUL, TOOLS_HAMMER, TOOLS_ANCHOR, TOOLS_HARP, TOOLS_SERENADE, TOOLS_SCEPTER, TOOLS_STAFF, TOOLS_PHASER, TOOLS_CANNON, TOOLS_BOW, TOOLS_SHIELD).add(terran_shifter.key(), maelstrom.key(), captains_sparkler.key(), la_vekor.key(), firefly.key(), meriks_missile.key(), teleportation_crystal.key(), teleportation_star.key(), jungle_hook.key()).remove(TOOLS_UNBREAKABLE);
        tag(ItemTags.VANISHING_ENCHANTABLE).addTag(TOOLS_UNBREAKABLE);

        tag(SMELTABLE_EQUIPMENT_COMPRESSED_GOLD).add(golden_fury.key());
        tag(SMELTABLE_EQUIPMENT_COMPRESSED_REALMITE).add(ELITE_REALMITE_HELMET.key(), ELITE_REALMITE_CHESTPLATE.key(), ELITE_REALMITE_LEGGINGS.key(), ELITE_REALMITE_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_COMPRESSED_TORRIDITE).add(TORRIDITE_HELMET.key(), TORRIDITE_CHESTPLATE.key(), TORRIDITE_LEGGINGS.key(), TORRIDITE_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_REALMITE).add(realmite_pickaxe.key(), realmite_shovel.key(), realmite_axe.key(), realmite_hoe.key(), palavence.key(), realmite_sword.key(), realmite_maul.key(), realmite_shield.key(), REALMITE_HELMET.key(), REALMITE_CHESTPLATE.key(), REALMITE_LEGGINGS.key(), REALMITE_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_OXDRITE).add(oxdrite_pickaxe.key());
        tag(SMELTABLE_EQUIPMENT_ARLEMITE).add(arlemite_pickaxe.key(), arlemite_shovel.key(), arlemite_axe.key(), arlemite_hoe.key(), arlemite_shickaxe.key(), arlemite_stabber.key(), arlemite_shield.key(), ARLEMITE_BOOTS.key(), ARLEMITE_LEGGINGS.key(), ARLEMITE_CHESTPLATE.key(), ARLEMITE_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_ICE).add(frost_sword.key(), frostking_sword.key(), icicle_bow.key(), frost_cannon.key(), fractite_cannon.key(), FROZEN_BOOTS.key(), FROZEN_LEGGINGS.key(), FROZEN_CHESTPLATE.key(), FROZEN_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_TERRAN).add(terran_pickaxe.key(), terran_shovel.key(), terran_axe.key(), terran_hoe.key(), terran_shickaxe.key(), terran_shifter.key(), terran_dagger.key(), terran_knife.key(), terran_maul.key(), TERRAN_HELMET.key(), TERRAN_CHESTPLATE.key(), TERRAN_LEGGINGS.key(), TERRAN_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_RUPEE).add(rupee_pickaxe.key(), rupee_shovel.key(), rupee_axe.key(), rupee_hoe.key(), rupee_shickaxe.key(), rupee_rapier.key(), rupee_shield.key(), RUPEE_HELMET.key(), RUPEE_CHESTPLATE.key(), RUPEE_LEGGINGS.key(), RUPEE_BOOTS.key(), RED_RUPEE_HELMET.key(), RED_RUPEE_CHESTPLATE.key(), RED_RUPEE_LEGGINGS.key(), RED_RUPEE_BOOTS.key(), YELLOW_RUPEE_HELMET.key(), YELLOW_RUPEE_CHESTPLATE.key(), YELLOW_RUPEE_LEGGINGS.key(), YELLOW_RUPEE_BOOTS.key(), GREEN_RUPEE_HELMET.key(), GREEN_RUPEE_CHESTPLATE.key(), GREEN_RUPEE_LEGGINGS.key(), GREEN_RUPEE_BOOTS.key(), BLUE_RUPEE_HELMET.key(), BLUE_RUPEE_CHESTPLATE.key(), BLUE_RUPEE_LEGGINGS.key(), BLUE_RUPEE_BOOTS.key(), GRAY_RUPEE_HELMET.key(), GRAY_RUPEE_CHESTPLATE.key(), GRAY_RUPEE_LEGGINGS.key(), GRAY_RUPEE_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_JUNGLE).add(jungle_hook.key(), jungle_knife.key(), jungle_rapier.key(), poison_saber.key(), hunter_bow.key(), JUNGLE_HELMET.key(), JUNGLE_CHESTPLATE.key(), JUNGLE_LEGGINGS.key(), JUNGLE_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_MOLTEN).add(molten_sword.key(), inferno_bow.key(), INFERNO_HELMET.key(), INFERNO_CHESTPLATE.key(), INFERNO_LEGGINGS.key(), INFERNO_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_TORRIDITE).add(massivence.key(), frossivence.key(), scorching_sword.key());
        tag(SMELTABLE_EQUIPMENT_CORRUPTED).add(corrupted_pickaxe.key(), corrupted_shovel.key(), corrupted_axe.key(), corrupted_hoe.key(), corrupted_shickaxe.key(), death_bringer.key(), corrupted_maul.key(), corrupted_cannon.key(), CORRUPTED_BOOTS.key(), CORRUPTED_LEGGINGS.key(), CORRUPTED_CHESTPLATE.key(), CORRUPTED_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_ENDER).add(ender_bow.key(), ENDER_BOOTS.key(), ENDER_LEGGINGS.key(), ENDER_CHESTPLATE.key(), ENDER_HELMET.key(), GRAY_ENDER_BOOTS.key(), GRAY_ENDER_LEGGINGS.key(), GRAY_ENDER_CHESTPLATE.key(), GRAY_ENDER_HELMET.key(), RED_ENDER_BOOTS.key(), RED_ENDER_LEGGINGS.key(), RED_ENDER_CHESTPLATE.key(), RED_ENDER_HELMET.key(), YELLOW_ENDER_BOOTS.key(), YELLOW_ENDER_LEGGINGS.key(), YELLOW_ENDER_CHESTPLATE.key(), YELLOW_ENDER_HELMET.key(), GREEN_ENDER_BOOTS.key(), GREEN_ENDER_LEGGINGS.key(), GREEN_ENDER_CHESTPLATE.key(), GREEN_ENDER_HELMET.key(), BLUE_ENDER_BOOTS.key(), BLUE_ENDER_LEGGINGS.key(), BLUE_ENDER_CHESTPLATE.key(), BLUE_ENDER_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_DIVINE).add(divine_pickaxe.key(), divine_shovel.key(), divine_axe.key(), divine_hoe.key(), divine_shickaxe.key(), divine_sword.key(), gray_divine_sword.key(), red_divine_sword.key(), yellow_divine_sword.key(), green_divine_sword.key(), blue_divine_sword.key(), icine_sword.key(), DIVINE_BOOTS.key(), DIVINE_LEGGINGS.key(), DIVINE_CHESTPLATE.key(), DIVINE_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_EDEN).add(eden_pickaxe.key(), eden_shovel.key(), eden_axe.key(), eden_hoe.key(), eden_shickaxe.key(), eden_blade.key(), eden_bow.key(), eden_phaser.key(), eden_blitz.key(), eden_shield.key(), EDEN_BOOTS.key(), EDEN_LEGGINGS.key(), EDEN_CHESTPLATE.key(), EDEN_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_WILDWOOD).add(wildwood_pickaxe.key(), wildwood_shovel.key(), wildwood_axe.key(), wildwood_hoe.key(), wildwood_shickaxe.key(), wildwood_blade.key(), wildwood_bow.key(), wildwood_phaser.key(), wildwood_blitz.key(), wildwood_shield.key(), WILDWOOD_HELMET.key(), WILDWOOD_CHESTPLATE.key(), WILDWOOD_LEGGINGS.key(), WILDWOOD_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_APALACHIA).add(apalachia_pickaxe.key(), apalachia_shovel.key(), apalachia_axe.key(), apalachia_hoe.key(), apalachia_shickaxe.key(), apalachia_blade.key(), apalachia_bow.key(), apalachia_phaser.key(), apalachia_blitz.key(), apalachia_shield.key(), APALACHIA_BOOTS.key(), APALACHIA_LEGGINGS.key(), APALACHIA_CHESTPLATE.key(), APALACHIA_HELMET.key());
        tag(SMELTABLE_EQUIPMENT_SKYTHERN).add(skythern_pickaxe.key(), skythern_shovel.key(), skythern_axe.key(), skythern_hoe.key(), skythern_shickaxe.key(), skythern_blade.key(), skythern_bow.key(), skythern_phaser.key(), skythern_blitz.key(), skythern_shield.key(), SKYTHERN_HELMET.key(), SKYTHERN_CHESTPLATE.key(), SKYTHERN_LEGGINGS.key(), SKYTHERN_BOOTS.key());
        tag(SMELTABLE_EQUIPMENT_MORTUM).add(mortum_pickaxe.key(), mortum_shovel.key(), mortum_axe.key(), mortum_hoe.key(), mortum_shickaxe.key(), mortum_blade.key(), mortum_bow.key(), mortum_phaser.key(), mortum_blitz.key(), mortum_shield.key(), MORTUM_HELMET.key(), MORTUM_CHESTPLATE.key(), MORTUM_LEGGINGS.key(), MORTUM_BOOTS.key());

        tag(REPAIRS_EQUIPMENT_EXPENSIVE_GOLD).addTag(Tags.BlockItems.STORAGE_BLOCKS_GOLD.item());
        tag(REPAIRS_EQUIPMENT_EXPENSIVE_REALMITE).addTag(STORAGE_BLOCKS_REALMITE.item());
        tag(REPAIRS_EQUIPMENT_EXPENSIVE_SHADOW).addTag(GEMS_SHADOW);
        tag(REPAIRS_EQUIPMENT_EXPENSIVE_TORRIDITE).addTag(CHUNKS_TORRIDITE);
        tag(REPAIRS_EQUIPMENT_CYCLOPS).addTag(EYES_CYCLOPS);
        tag(REPAIRS_EQUIPMENT_REALMITE).addTags(INGOTS_REALMITE, CHUNKS_DIAMOND_YELLOW);
        tag(REPAIRS_EQUIPMENT_OXDRITE).addTag(INGOTS_OXDRITE);
        tag(REPAIRS_EQUIPMENT_SENG_FUR).addTag(FURS_SENG);
        tag(REPAIRS_EQUIPMENT_SABEAR_TEETH).addTag(TEETH_SABEAR);
        tag(REPAIRS_EQUIPMENT_SANTA).addTag(FURS_SENG).add(toKey(fancySet.getFirst().asItem()));
        tag(REPAIRS_EQUIPMENT_CRAB).addTag(CLAWS_CRAB);
        tag(REPAIRS_EQUIPMENT_SHARK).addTag(FINS_SHARK);
        tag(REPAIRS_EQUIPMENT_WHALE).addTag(FINS_WHALE);
        tag(REPAIRS_EQUIPMENT_LIOPLEURODON).addTags(TEETH_LIOPLEURODON, SKULLS_LIOPLEURODON);
        tag(REPAIRS_EQUIPMENT_AQUATIC).addTag(INGOTS_AQUATIC);
        tag(REPAIRS_EQUIPMENT_KRAKEN).addTag(SKINS_KRAKEN);
        tag(REPAIRS_EQUIPMENT_JACK_O_MAN).addTags(Tags.BlockItems.PUMPKINS_NORMAL.item(), Tags.BlockItems.PUMPKINS_CARVED.item());
        tag(REPAIRS_EQUIPMENT_SKELEMAN).addTag(Tags.Items.BONES);
        tag(REPAIRS_EQUIPMENT_WITHER_REAPER).addTag(Tags.Items.BONES);
        tag(REPAIRS_EQUIPMENT_ARLEMITE).addTags(INGOTS_ARLEMITE, CHUNKS_DIAMOND_GREEN);
        tag(REPAIRS_EQUIPMENT_ICE).addTag(GEMS_ICE);
        tag(REPAIRS_EQUIPMENT_SNOWFLAKE).addTag(SNOWFLAKES);
        tag(REPAIRS_EQUIPMENT_JUNGLE).addTag(GEMS_JUNGLE);
        tag(REPAIRS_EQUIPMENT_BLOODGEM).addTag(GEMS_BLOODGEM);
        tag(REPAIRS_EQUIPMENT_MOLTEN).addTag(GEMS_MOLTEN);
        tag(REPAIRS_EQUIPMENT_SOULFIRE).addTag(GEMS_SOULFIRE);
        tag(REPAIRS_EQUIPMENT_BLAZE).add(toKey(Items.BLAZE_POWDER)).addTags(POWDERS_PURPLE_BLAZE, POWDERS_FURY_FIRE);
        tag(REPAIRS_EQUIPMENT_PURPLE_BLAZE).addTag(POWDERS_PURPLE_BLAZE);
        tag(REPAIRS_EQUIPMENT_FURY_FIRE).addTag(POWDERS_FURY_FIRE);
        tag(REPAIRS_EQUIPMENT_TORRIDITE).addTags(INGOTS_TORRIDITE, CHUNKS_DIAMOND_RED);
        tag(REPAIRS_EQUIPMENT_TERRAN).addTag(GEMS_TERRAN);
        tag(REPAIRS_EQUIPMENT_ANGELIC).addTags(GEMS_SOULFIRE, GEMS_SOULFIRE);
        tag(REPAIRS_EQUIPMENT_SHADOW).addTags(INGOTS_SHADOW, CHUNKS_DIAMOND_GRAY);
        tag(REPAIRS_EQUIPMENT_RUPEE).addTags(INGOTS_RUPEE, CHUNKS_DIAMOND_BLUE);
        tag(REPAIRS_EQUIPMENT_CORRUPTED).addTag(GEMS_CORRUPTED);
        tag(REPAIRS_EQUIPMENT_BEDROCK).addTag(CHUNKS_BEDROCK);
        tag(REPAIRS_EQUIPMENT_ARCANIUM).addTag(GEMS_ARCANIUM);
        tag(REPAIRS_EQUIPMENT_KORMA).addTag(GEMS_ARCANIUM);
        tag(REPAIRS_EQUIPMENT_VEMOS).addTag(GEMS_ARCANIUM);
        tag(REPAIRS_EQUIPMENT_ENDER).addTag(GEMS_ENDER);
        tag(REPAIRS_EQUIPMENT_DIVINE).addTag(GEMS_DIVINE);
        tag(REPAIRS_EQUIPMENT_EDEN).addTags(CHUNKS_EDEN, HEARTS_EDEN);
        tag(REPAIRS_EQUIPMENT_WILDWOOD).addTags(CHUNKS_WILDWOOD, HEARTS_WILDWOOD);
        tag(REPAIRS_EQUIPMENT_APALACHIA).addTags(CHUNKS_APALACHIA, HEARTS_APALACHIA);
        tag(REPAIRS_EQUIPMENT_SKYTHERN).addTags(CHUNKS_SKYTHERN, HEARTS_SKYTHERN);
        tag(REPAIRS_EQUIPMENT_MORTUM).addTags(CHUNKS_MORTUM, HEARTS_MORTUM);
        tag(REPAIRS_EQUIPMENT_TWILIGHT).addTags(CHUNKS_TWILIGHT, HEARTS_EDEN, HEARTS_WILDWOOD, HEARTS_APALACHIA, HEARTS_SKYTHERN, HEARTS_MORTUM);
        tag(REPAIRS_EQUIPMENT_HALITE).addTags(CHUNKS_MORTUM, HEARTS_MORTUM);
        tag(REPAIRS_EQUIPMENT_AWAKENED_HALITE).addTags(CHUNKS_MORTUM, HEARTS_MORTUM, GEMS_ARCANIUM);
        tag(REPAIRS_EQUIPMENT_DREAM).add(toKey(dreamStone.asItem()));
        tag(REPAIRS_EQUIPMENT_TEAKER).addTags(LUMPS_TEAKER, LUMPS_AMTHIRMIS, LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_AMTHIRMIS).addTags(LUMPS_AMTHIRMIS, LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_DARVEN).addTags(LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_CERMILE).addTags(LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_PARDIMAL).addTags(LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_QUADROTIC).addTags(LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_KAROS).addTags(LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_HELIOSIS).addTags(LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_ARKSIANE).addTag(LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_EVER).addTag(LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_DEGRADED).addTags(LUMPS_TEAKER, LUMPS_AMTHIRMIS, LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_FINISHED).addTags(LUMPS_AMTHIRMIS, LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_GLISTENING).addTags(LUMPS_DARVEN, LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_DEMONIZED).addTags(LUMPS_CERMILE, LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_EQUIPMENT_TORMENTED).addTags(LUMPS_PARDIMAL, LUMPS_QUADROTIC, LUMPS_KAROS, LUMPS_HELIOSIS, LUMPS_ARKSIANE);
        tag(REPAIRS_GOLDEN_FURY).addTags(REPAIRS_EQUIPMENT_EXPENSIVE_GOLD, REPAIRS_EQUIPMENT_FURY_FIRE);

        tag(ItemTags.REPAIRS_LEATHER_ARMOR).addTag(SKINS_KRAKEN);
        tag(ItemTags.REPAIRS_DIAMOND_ARMOR).addTag(CHUNKS_DIAMOND);
        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(toKey(cobbledFrozenStoneSet.getFirst().asItem()),toKey(cobaltiteSet.getFirst().asItem()), toKey(arcaniteStoneSet.getFirst().asItem()), toKey(ancientStoneSet.getLast().asItem()), toKey(soulStoneSet.getLast().asItem()), toKey(divineRock.asItem()), toKey(twilightStoneSet.getFirst().asItem()), toKey(milkStone.asItem()), toKey(cobbledScorchaltSet.getFirst().asItem()), toKey(rayStoneSet.getFirst().asItem()), toKey(draughtStone.asItem()), toKey(dreamStone.asItem()), toKey(lunaStone.asItem()));
        tag(ItemTags.STONE_TOOL_MATERIALS).add(toKey(cobbledFrozenStoneSet.getFirst().asItem()),toKey(cobaltiteSet.getFirst().asItem()), toKey(arcaniteStoneSet.getFirst().asItem()), toKey(ancientStoneSet.getLast().asItem()), toKey(soulStoneSet.getLast().asItem()), toKey(divineRock.asItem()), toKey(twilightStoneSet.getFirst().asItem()), toKey(milkStone.asItem()), toKey(cobbledScorchaltSet.getFirst().asItem()), toKey(rayStoneSet.getFirst().asItem()), toKey(draughtStone.asItem()), toKey(dreamStone.asItem()), toKey(lunaStone.asItem()));
        tag(ItemTags.DIAMOND_TOOL_MATERIALS).addTag(CHUNKS_DIAMOND);
        tag(ItemTags.TRIM_MATERIALS).add(olivine.key());

        tag(SEEDS_TOMATO).add(tomato_seeds.key());
        tag(commonTag("seeds/tomato")).addTag(SEEDS_TOMATO);
        tag(SEEDS_WHITE_MUSHROOM).add(white_mushroom_seeds.key());
        tag(SEEDS_AQUAMARINE).add(aquamarine_seeds.key());
        tag(SEEDS_EUCALYPTUS_ROOT).add(eucalyptus_root_seeds.key());
        tag(SEEDS_FIRESTOCK).add(firestock_seeds.key());
        tag(SEEDS_HITCHAK).add(hitchak_seeds.key());
        tag(SEEDS_LAMONA).add(lamona_seeds.key());
        tag(SEEDS_MARSINE).add(marsine_seeds.key());
        tag(SEEDS_PINFLY).add(pinfly_seeds.key());
        tag(SEEDS_VEILO).add(veilo_seeds.key());
        tag(SEEDS_MOONBULB).add(moonbulb_seeds.key());
        tag(SEEDS_PURPLE_GLOWBONE).add(purple_glowbone_seeds.key());
        tag(SEEDS_PINK_GLOWBONE).add(pink_glowbone_seeds.key());
        tag(SEEDS_SKY_PLANT).add(sky_plant_seeds.key());
        tag(SEEDS).addTags(SEEDS_TOMATO, SEEDS_WHITE_MUSHROOM, SEEDS_AQUAMARINE, SEEDS_EUCALYPTUS_ROOT, SEEDS_FIRESTOCK, SEEDS_HITCHAK, SEEDS_LAMONA, SEEDS_MARSINE, SEEDS_PINFLY, SEEDS_VEILO, SEEDS_MOONBULB, SEEDS_PURPLE_GLOWBONE, SEEDS_PINK_GLOWBONE, SEEDS_SKY_PLANT);
        tag(Tags.Items.SEEDS).addTag(SEEDS);

        tag(Tags.Items.CROPS_CARROT).add(dream_carrot.key());
        tag(CROPS_TOMATO).add(tomato.key());
        tag(commonTag("crops/tomato")).addTag(CROPS_TOMATO);
        tag(CROPS_WHITE_MUSHROOM).add(white_mushroom.key());
        tag(commonTag("crops/white_mushroom")).addTag(CROPS_WHITE_MUSHROOM);
        tag(CROPS_AQUAMARINE).add(aquamarine.key());
        tag(CROPS_FIRESTOCK).add(firestock.key());
        tag(CROPS_HITCHAK).add(hitchak.key());
        tag(CROPS_LAMONA).add(lamona.key());
        tag(CROPS_MARSINE).add(marsine.key());
        tag(CROPS_PINFLY).add(pinfly.key());
        tag(CROPS_VEILO).add(veilo.key());
        tag(CROPS_MOONBULB).add(moonbulb.key());
        tag(CROPS_PURPLE_GLOWBONE).add(purple_glowbone.key());
        tag(CROPS_PINK_GLOWBONE).add(pink_glowbone.key());
        tag(CROPS_SKY_PLANT).add(sky_flower.key());
        tag(Tags.Items.CROPS).addTags(CROPS_TOMATO, CROPS_WHITE_MUSHROOM, CROPS_AQUAMARINE, CROPS_FIRESTOCK, CROPS_HITCHAK, CROPS_LAMONA, CROPS_MARSINE, CROPS_PINFLY, CROPS_VEILO, CROPS_MOONBULB, CROPS_PURPLE_GLOWBONE, CROPS_PINK_GLOWBONE, CROPS_SKY_PLANT);

        // TODO: villager pick up and plantable seeds behaviour
        tag(ItemTags.VILLAGER_PICKS_UP).addTags(CROPS_TOMATO, CROPS_WHITE_MUSHROOM);
        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addTags(SEEDS_TOMATO, SEEDS_WHITE_MUSHROOM);

        tag(FOODS_COOKED_EGG).add(boiled_egg.key());
        tag(FOODS_CHEESE).add(cheese.key());
        tag(commonTag("foods/cheese")).addTag(FOODS_CHEESE);
        tag(FOODS_HONEY).add(honeysuckle.key(), honeychunk.key());
        tag(commonTag("foods/honey")).addTag(FOODS_HONEY);
        tag(Tags.Items.FOODS_BREAD).add(donut.key());
        tag(Tags.Items.FOODS_PIE).add(hot_pumpkin_pie.key(), dream_pie.key());
        tag(Tags.Items.FOODS_CANDY).add(peppermints.key(), dream_sweets.key(), dream_sours.key());
        tag(commonTag("foods/ice_cream")).add(snow_cones.key());
        tag(FOODS_BERRY).add(winterberry.key());
        tag(Tags.Items.FOODS_BERRY).addTag(FOODS_BERRY);
        tag(FOODS_TOMATO).add(tomato.key());
        tag(commonTag("foods/tomato")).addTag(FOODS_TOMATO);
        tag(FOODS_WHITE_MUSHROOM).add(white_mushroom.key());
        tag(commonTag("foods/white_mushroom")).addTag(FOODS_WHITE_MUSHROOM);
        tag(FOODS_TRUFFLE).add(toKey(truffle.asItem()));
        tag(commonTag("foods/truffle")).addTag(FOODS_TRUFFLE);
        tag(commonTag("foods/mushroom")).addTags(FOODS_WHITE_MUSHROOM, FOODS_TRUFFLE);
        tag(Tags.Items.FOODS_VEGETABLE).addTags(FOODS_TOMATO, FOODS_HITCHAK, FOODS_LAMONA).add(dream_carrot.key());
        tag(Tags.Items.FOODS_FRUIT).addTags(FOODS_PINFLY, FOODS_VEILO, FOODS_FORBIDDEN_FRUIT, FOODS_MOONBULB).add(dream_melon.key());
        tag(FOODS_HITCHAK).add(hitchak.key());
        tag(FOODS_LAMONA).add(lamona.key());
        tag(FOODS_PINFLY).add(pinfly.key());
        tag(FOODS_VEILO).add(veilo.key());
        tag(FOODS_FORBIDDEN_FRUIT).add(forbidden_fruit.key());
        tag(FOODS_MOONBULB).add(moonbulb.key());
        tag(FOODS_PURPLE_GLOWBONE).add(purple_glowbone.key());
        tag(FOODS_PINK_GLOWBONE).add(pink_glowbone.key());
        tag(FOODS_SKY_FLOWER).add(sky_flower.key());
        tag(commonTag("foods/cooked_egg")).add(boiled_egg.key());
        tag(commonTag("foods/raw_pork")).add(bacon.key());
        tag(commonTag("foods/raw_bacon")).add(bacon.key());
        tag(commonTag("foods/cooked_pork")).add(cooked_bacon.key());
        tag(commonTag("foods/cooked_bacon")).add(cooked_bacon.key());
        tag(FOODS_MAGIC_MEAT).add(magic_meat.key(), enriched_magic_meat.key());
        tag(Tags.Items.FOODS_RAW_MEAT).add(bacon.key(), raw_wolpertinger_meat.key(), raw_seng_meat.key(), raw_empowered_meat.key());
        tag(Tags.Items.FOODS_COOKED_MEAT).add(cooked_bacon.key(), wolpertinger_steak.key(), seng_steak.key(), empowered_meat.key());
        tag(ItemTags.MEAT).addTag(FOODS_MAGIC_MEAT).add(bacon.key(), cooked_bacon.key(), raw_wolpertinger_meat.key(), wolpertinger_steak.key(), raw_seng_meat.key(), seng_steak.key(), raw_empowered_meat.key(), empowered_meat.key());
        tag(Tags.Items.FOODS_RAW_FISH).add(cauldron_flesh.key());
        tag(ItemTags.FISHES).add(cauldron_flesh.key());
        tag(commonTag("foods/safe_raw_fish")).remove(cauldron_flesh.key());
        tag(Tags.Items.FOODS_SOUP).add(advanced_mushroom_stew.key(), chicken_dinner.key());
        tag(Tags.Items.FOODS).addTags(FOODS_COOKED_EGG, FOODS_CHEESE, FOODS_HONEY, FOODS_WHITE_MUSHROOM, FOODS_PURPLE_GLOWBONE, FOODS_PINK_GLOWBONE, FOODS_SKY_FLOWER, FOODS_MAGIC_MEAT).add(chocolate_log.key(), egg_nog.key(), fruit_cake.key(), snow_cones.key(), weak_arcana_potion.key(), strong_arcana_potion.key(), dream_cake.key());
        tag(Tags.Items.FOODS_FOOD_POISONING).add(cauldron_flesh.key(), forbidden_fruit.key());

        tag(ItemTags.EGGS).add(robbin_egg.key());
        tag(Tags.Items.EGGS).add(robbin_egg.key());

        tag(Tags.Items.DRINK_CONTAINING_BOTTLE).add(weak_arcana_potion.key(), strong_arcana_potion.key());
        tag(Tags.Items.DRINK_CONTAINING_BUCKET).add(egg_nog.key());
        tag(DRINKS_ARCANA).add(weak_arcana_potion.key(), strong_arcana_potion.key());
        tag(Tags.Items.DRINKS_MAGIC).addTag(DRINKS_ARCANA);
        tag(commonTag("drinks/milky")).add(egg_nog.key());
        tag(Tags.Items.DRINKS).add(egg_nog.key());

        tag(SUMMONING_KITRA).addTag(SKULLS_LIOPLEURODON);
        tag(SUMMONING_CAPTAIN_MERIK).addTag(CROPS_FIRESTOCK);
        tag(SUMMONING_DATTICON).addTag(CROPS_AQUAMARINE);
        tag(SUMMONING_KAZARI).addTag(CROPS_LAMONA);
        tag(SUMMONING_LEORNA).addTag(CROPS_HITCHAK);
        tag(SUMMONING_LORD_VATTICUS).addTag(CROPS_MARSINE);
        tag(SUMMONING_WAR_GENERAL).addTag(CROPS_PINFLY);
        tag(SUMMONING_ZELUS).addTag(CROPS_VEILO);
        tag(SUMMONING_SUNSTORM).addTag(CHUNKS_EDEN);
        tag(SUMMONING_TERMASECT).addTag(CHUNKS_WILDWOOD);
        tag(SUMMONING_ETERNAL_ARCHER).addTag(CHUNKS_APALACHIA);
        tag(SUMMONING_EXPERIENCED_CORI).addTag(CHUNKS_SKYTHERN);

//        tag(ItemTags.DROWNED_PREFERRED_WEAPONS).addTag(TOOLS_TRIDENT); // TODO: to make our trident work just like a regular trident
        tag(ItemTags.PIGLIN_LOVED).add(golden_fury.key(), toKey(goldBricks.asItem()), toKey(goldLamp.asItem()), toKey(shiningObsidian.asItem()), toKey(gildedBricks.asItem()), orb_of_light.key(), livicia_sword.key(), divine_accumulator.key());
        tag(ItemTags.SKELETON_PREFERRED_WEAPONS).addTag(TOOLS_BOW);
        tag(ItemTags.WITHER_SKELETON_DISLIKED_WEAPONS).addTag(TOOLS_BOW);

        tag(ANIMAL_FOODS_DOLOSSAL).add(winterberry.key());
        tag(ANIMAL_FOODS_MAMOTH).add(toKey(brittleGrass.getFirst().asItem()));
        tag(ItemTags.BEE_FOOD).add(toKey(crimpetal.getFirst().asItem()), toKey(roofbell.getFirst().asItem()), toKey(winterbloom.getFirst().asItem()), toKey(wispLeaf.getFirst().asItem()), toKey(globebrush.asItem()), toKey(thermoliage.asItem()), toKey(gemOfTheDunes.getFirst().asItem()), toKey(sunBlossom.getFirst().asItem()), toKey(sunbloom.getFirst().asItem()), toKey(moonBud.getFirst().asItem()), toKey(duskBloom.getFirst().asItem()), toKey(duskFlower.asItem()), toKey(dustLily.getFirst().asItem()), toKey(dustBrambles.asItem()), toKey(mortumWoodSet.get(2).asItem()), toKey(eyePlant.getFirst().asItem()), toKey(demonBrambles.asItem()), toKey(shineGrass.getFirst().asItem()), toKey(cracklespike.getFirst().asItem()), toKey(fernite.getFirst().asItem()), toKey(bulbatobe.getFirst().asItem()), toKey(shimmer.getFirst().asItem()), toKey(yellowDulah.getFirst().asItem()), toKey(greenDulah.getFirst().asItem()), toKey(greenGemtop.getFirst().asItem()), toKey(purpleGemtop.getFirst().asItem()));
        tag(ItemTags.CHICKEN_FOOD).addTag(SEEDS);
        tag(ItemTags.FOX_FOOD).addTag(FOODS_BERRY);
        tag(ItemTags.FROG_FOOD).add(aqua_ball.key());
        tag(ItemTags.NAUTILUS_BUCKET_FOOD).add(cauldron_fish_bucket.key(), gem_fin_bucket.key());
        tag(ItemTags.PARROT_FOOD).addTag(SEEDS);
        tag(ItemTags.PIG_FOOD).addTags(FOODS_WHITE_MUSHROOM, FOODS_TRUFFLE, FOODS_HITCHAK, FOODS_LAMONA).add(dream_carrot.key());
        tag(ItemTags.RABBIT_FOOD).add(dream_carrot.key());
        tag(ItemTags.SULFUR_CUBE_FOOD).add(aqua_ball.key());
        tag(ItemTags.WOLF_FOOD).add(boiled_egg.key(), chicken_dinner.key(), cauldron_flesh.key());

        tag(PET_FOODS_SNAPPER).addTags(Tags.Items.FOODS_RAW_MEAT, FOODS_MAGIC_MEAT, Tags.Items.FOODS_RAW_FISH, ItemTags.TURTLE_FOOD).add(toKey(Items.KELP));
        tag(PET_FOODS_EHU).addTag(ItemTags.MEAT);
        tag(PET_FOODS_HUSK).addTag(ItemTags.MEAT);
        tag(PET_FOODS_BROWN_GRIZZLE).addTags(Tags.Items.FOODS_BERRY, Tags.Items.FOODS_RAW_FISH, Tags.Items.FOODS_RAW_MEAT, FOODS_MAGIC_MEAT).remove(Tags.Items.FOODS_FOOD_POISONING);
        tag(PET_FOODS_WHITE_GRIZZLE).addTags(Tags.Items.FOODS_BERRY, Tags.Items.FOODS_RAW_FISH, Tags.Items.FOODS_RAW_MEAT, FOODS_MAGIC_MEAT).remove(Tags.Items.FOODS_FOOD_POISONING);
        tag(PET_FOODS_STONE_GOLEM).addTags(Tags.BlockItems.STONES.item(), Tags.BlockItems.COBBLESTONES.item());
        tag(PET_FOODS_SMELTER).addTags(Tags.BlockItems.STORAGE_BLOCKS_COAL.item(), STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE.item()).addOptionalTags(commonTag("storage_blocks/anthracite"), commonTag("storage_blocks/charcoal"), commonTag("storage_blocks/coal_coke")).add(toKey(Items.MAGMA_BLOCK));
        tag(PET_FOODS_HELL_PIG).addTag(ItemTags.MEAT);
        tag(PET_FOODS_FYRACRYX).addTags(CROPS_MARSINE, FOODS_MAGIC_MEAT).add(raw_empowered_meat.key());
        tag(PET_FOODS_GOLEM_OF_REJUVENATION).addTag(FUELS_COLLECTOR);
        tag(PET_FOODS_PARATIKU).addTags(FOODS_HITCHAK, FOODS_LAMONA, FOODS_PINFLY, FOODS_VEILO);
        tag(PET_FOODS_SEIMER).addTags(FOODS_HITCHAK, FOODS_LAMONA, FOODS_PINFLY, FOODS_VEILO, FOODS_MAGIC_MEAT).add(raw_empowered_meat.key());
        tag(PET_FOODS_GLINTHOP).addTag(ItemTags.CAT_FOOD).add(raw_empowered_meat.key(), empowered_meat.key());
        tag(PET_FOODS_MOON_WOLF).addTag(ItemTags.WOLF_FOOD);
        tag(Tags.Items.ANIMAL_FOODS).addTags(ANIMAL_FOODS_DOLOSSAL, ANIMAL_FOODS_MAMOTH, PET_FOODS_SNAPPER, PET_FOODS_EHU, PET_FOODS_HUSK, PET_FOODS_BROWN_GRIZZLE, PET_FOODS_WHITE_GRIZZLE, PET_FOODS_STONE_GOLEM, PET_FOODS_SMELTER, PET_FOODS_HELL_PIG, PET_FOODS_FYRACRYX, PET_FOODS_GOLEM_OF_REJUVENATION, PET_FOODS_PARATIKU, PET_FOODS_SEIMER, PET_FOODS_GLINTHOP, PET_FOODS_MOON_WOLF);

        tag(PET_TAMING_FOODS_SNAPPER).addTag(Tags.Items.SLIME_BALLS);
        tag(PET_TAMING_FOODS_EHU).addTag(Tags.Items.BONES);
        tag(PET_TAMING_FOODS_HUSK).addTag(Tags.Items.BONES);
        tag(PET_TAMING_FOODS_BROWN_GRIZZLE).addTags(commonTag("foods/honey"), Tags.Items.DRINKS_HONEY);
        tag(PET_TAMING_FOODS_WHITE_GRIZZLE).addTags(commonTag("foods/honey"), Tags.Items.DRINKS_HONEY);
        tag(PET_TAMING_FOODS_STONE_GOLEM).add(toKey(Items.FLINT));
        tag(PET_TAMING_FOODS_SMELTER).addTag(Tags.BlockItems.OBSIDIANS.item());
        tag(PET_TAMING_FOODS_HELL_PIG).add(toKey(Items.BLAZE_POWDER)).addTags(POWDERS_PURPLE_BLAZE, POWDERS_FURY_FIRE, CROPS_FIRESTOCK);
        tag(PET_TAMING_FOODS_FYRACRYX).addTag(CROPS_FIRESTOCK);
        tag(PET_TAMING_FOODS_GOLEM_OF_REJUVENATION).addTag(GEMS_ARCANIUM);
        tag(PET_TAMING_FOODS_PARATIKU).addTag(CROPS_AQUAMARINE);
        tag(PET_TAMING_FOODS_SEIMER).addTag(CROPS_MARSINE);
        tag(PET_TAMING_FOODS_GLINTHOP).add(eden_sparkles.key());
        tag(PET_TAMING_FOODS_MOON_WOLF).addTag(Tags.Items.BONES);

        copy(Tags.BlockItems.BUDDING_BLOCKS);
        copy(Tags.BlockItems.CLUSTERS);

        copy(ORES_REALMITE);
        copy(ORES_ARLEMITE);
        copy(ORES_RUPEE);
        copy(ORES_BLOODGEM);
        copy(ORES_TORRIDITE);
        copy(ORES_ANTHRACITE);
        copy(commonBlockItemTag("ores/anthracite"));
        copy(ORES_OXDRITE);
        copy(ORES_EDEN);
        copy(ORES_WILDWOOD);
        copy(ORES_APALACHIA);
        copy(ORES_SKYTHERN);
        copy(ORES_MORTUM);
        copy(BlockItemTags.ORES);

        copy(Tags.BlockItems.ORES_IN_GROUND_STONE);
        copy(Tags.BlockItems.ORES_IN_GROUND_DEEPSLATE);
        copy(Tags.BlockItems.ORES_IN_GROUND_NETHERRACK);
        copy(ORES_IN_GROUND_FROZEN);
        copy(ORES_IN_GROUND_TWILIGHT);
        copy(ORES_IN_GROUND_SCORCHALT);

        copy(ORE_BEARING_GROUND_FROZEN);
        copy(ORE_BEARING_GROUND_TWILIGHT);
        copy(ORE_BEARING_GROUND_SCORCHALT);

        copy(Tags.BlockItems.ORE_RATES_SINGULAR);
        copy(Tags.BlockItems.ORE_RATES_SPARSE);

        copy(BlockItemTags.STONE_BRICKS);
        copy(MINIBRICKS);
        copy(COLORED_BRICKS);
        copy(TWILIGHT_BRICKS);
        copy(STONE_TYPES_ASPHALT);
        copy(STONE_TYPES_COALSTONE);
        copy(STONE_TYPES_COBALTITE);
        copy(Tags.BlockItems.STONES);

        copy(OBSIDIANS_CRYING);
        copy(Tags.BlockItems.OBSIDIANS_CRYING);
        copy(OBSIDIANS_DARK);
        copy(Tags.BlockItems.OBSIDIANS);

        copy(Tags.BlockItems.COBBLESTONES_MOSSY);
        copy(COBBLESTONES_FROZEN);
        copy(commonBlockItemTag("cobblestones/frozen"));
        copy(COBBLESTONES_ICY);
        copy(commonBlockItemTag("cobblestones/icy"));
        copy(COBBLESTONES_SCORCHALT);
        copy(Tags.BlockItems.COBBLESTONES);

        copy(Tags.BlockItems.GRAVELS);

        copy(DIRTS);
        copy(BlockItemTags.DIRT);
        copy(GRASS_BLOCKS);
        copy(BlockItemTags.GRASS_BLOCKS);
        copy(BlockItemTags.MUD);

        copy(SANDS_ARCANA);
        copy(commonBlockItemTag("sands/light_blue"));
        copy(commonBlockItemTag("sands/cyan"));
        copy(commonBlockItemTag("sands/blue"));
        copy(SANDS);
        copy(BlockItemTags.SAND);
        copy(Tags.BlockItems.SANDS);
        copy(BlockItemTags.SMELTS_TO_GLASS);
        copy(Tags.BlockItems.GLASS_BLOCKS_COLORLESS);
        copy(commonBlockItemTag("glass_blocks/smooth"));
        copy(commonBlockItemTag("glass_blocks/stained"));
        copy(Tags.BlockItems.GLASS_BLOCKS);

        tag(ItemTags.SOUL_FIRE_BASE_BLOCKS).add(toKey(soulSludgeSet.getLast().asItem()));

        copy(Tags.BlockItems.ICE);

        copy(MOSS_BLOCKS);
        copy(BlockItemTags.MOSS_BLOCKS);
        copy(PUMPKINS_MOB);
        copy(PUMPKINS);
        copy(Tags.BlockItems.PUMPKINS);
        copy(NATURAL_BULBS);
        copy(FLOWERS_SMALL);
        copy(BlockItemTags.SMALL_FLOWERS);
        copy(FLOWERS_BRAMBLE);
        copy(FLOWERS_TALL);
        copy(Tags.BlockItems.FLOWERS_TALL);
        copy(FLOWERS);
        copy(BlockItemTags.FLOWERS);
        copy(GRASS_BRUSH);
        copy(GRASS_SHORT);
        copy(GRASS_TALL);
        copy(GRASS);
        copy(VINES);
        tag(ItemTags.MUSHROOMS).add(white_mushroom.key(), toKey(glowsproutSet.getFirst().asItem()), toKey(lowsproutSet.getFirst().asItem()), toKey(slowsproutSet.getFirst().asItem()), toKey(lushroom.getFirst().asItem()), toKey(duncap.asItem()), toKey(truffle.asItem()), toKey(dreamglow.getFirst().asItem()));

        copy(BlockItemTags.SAPLINGS);
        copy(BlockItemTags.LEAVES);

        copy(LOGS_DIVINE);
        copy(LOGS_SHIVERSPINE);
        copy(LOGS_AURORAOAK);
        copy(LOGS_COZYBARK);
        copy(LOGS_STREAMLEAF);
        copy(LOGS_EUCALYPTUS);
        copy(LOGS_EDEN);
        copy(LOGS_CRIMSEEKER);
        copy(LOGS_WILDWOOD);
        copy(LOGS_APALACHIA);
        copy(LOGS_SKYTHERN);
        copy(LOGS_MORTUM);
        copy(LOGS_FIREWOOD);
        copy(LOGS_DREAMWOOD);
        copy(LOGS_HYREWOOD);
        copy(LOGS_MINTWOOD);
        copy(LOGS_VETHEA);
        copy(BlockItemTags.LOGS_THAT_BURN);

        tag(Tags.BlockItems.OVERWORLD_NATURAL_LOGS.item()).add(toKey(divineWoodSet.get(3).asItem()));
        copy(NATURAL_LOGS_ICEIKA);
        copy(NATURAL_LOGS_ARCANA);
        copy(NATURAL_LOGS_EDEN);
        copy(NATURAL_LOGS_WILDWOOD);
        copy(NATURAL_LOGS_APALACHIA);
        copy(NATURAL_LOGS_SKYTHERN);
        copy(NATURAL_LOGS_MORTUM);
        copy(NATURAL_LOGS_VETHEA);
        copy(Tags.BlockItems.NATURAL_LOGS);
        copy(Tags.BlockItems.NATURAL_WOODS);

        copy(Tags.BlockItems.STRIPPED_LOGS);
        copy(Tags.BlockItems.STRIPPED_WOODS);

        copy(PLANKS_DESIGN);
        copy(PLANKS_OVERWORLD);
        copy(PLANKS_ICEIKA);
        copy(PLANKS_ARCANA);
        copy(PLANKS_EDEN);
        copy(PLANKS_WILDWOOD);
        copy(PLANKS_APALACHIA);
        copy(PLANKS_SKYTHERN);
        copy(PLANKS_MORTUM);
        copy(PLANKS);
        copy(BlockItemTags.PLANKS);

        copy(BlockItemTags.WOODEN_STAIRS);
        copy(BlockItemTags.STAIRS);
        copy(BlockItemTags.WOODEN_SLABS);
        copy(BlockItemTags.SLABS);
        copy(BlockItemTags.WALLS);

        copy(FENCES_REDSTONE);
        copy(commonBlockItemTag("fences/redstone"));
        copy(FENCES_DIVINE);
        copy(FENCES_SHIVERSPINE);
        copy(FENCES_AURORAOAK);
        copy(FENCES_COZYBARK);
        copy(FENCES_STREAMLEAF);
        copy(FENCES_EUCALYPTUS);
        copy(commonBlockItemTag("fences/eucalyptus"));
        copy(FENCES_EDEN);
        copy(FENCES_WILDWOOD);
        copy(FENCES_APALACHIA);
        copy(FENCES_SKYTHERN);
        copy(FENCES_MORTUM);
        copy(BlockItemTags.WOODEN_FENCES);
        copy(BlockItemTags.FENCES);
        copy(Tags.BlockItems.FENCES);

        copy(FENCE_GATES_DIVINE);
        copy(FENCE_GATES_SHIVERSPINE);
        copy(FENCE_GATES_AURORAOAK);
        copy(FENCE_GATES_COZYBARK);
        copy(FENCE_GATES_STREAMLEAF);
        copy(FENCE_GATES_EUCALYPTUS);
        copy(commonBlockItemTag("fence_gates/eucalyptus"));
        copy(FENCE_GATES_EDEN);
        copy(FENCE_GATES_WILDWOOD);
        copy(FENCE_GATES_APALACHIA);
        copy(FENCE_GATES_SKYTHERN);
        copy(FENCE_GATES_MORTUM);
        copy(BlockItemTags.FENCE_GATES);
        copy(Tags.BlockItems.FENCE_GATES_WOODEN);

        copy(BlockItemTags.WOODEN_BUTTONS);
        copy(BlockItemTags.STONE_BUTTONS);
        copy(BlockItemTags.BUTTONS);
        copy(BlockItemTags.WOODEN_PRESSURE_PLATES);

        copy(BlockItemTags.WOODEN_DOORS);
        tag(BlockItemTags.DOORS.item()).add(toKey(steelDoor.asItem()), toKey(barredDoor.asItem()));
        copy(BlockItemTags.WOODEN_TRAPDOORS);

//        copy(BlockItemTags.SIGNS); // TODO: crimseeker sign
//        copy(BlockItemTags.HANGING_SIGNS);

        copy(BlockItemTags.WOOL);
        copy(BlockItemTags.WOOL_STAIRS);
        copy(BlockItemTags.WOOL_SLABS);
        copy(BlockItemTags.WOOL_CARPETS);

        tag(ItemTags.BEDS).add(nightmare_bed.key());

        copy(CRATES_WOODEN);
        copy(commonBlockItemTag("crates/wooden"));
        copy(CRATES_OXDRITE);
        copy(CRATES);
        copy(commonBlockItemTag("crates"));

        copy(CHESTS);
        copy(commonBlockItemTag("chests/bone"));
        copy(commonBlockItemTag("chests/present"));
        copy(Tags.BlockItems.CHESTS);

        copy(FURNACES);
        copy(Tags.BlockItems.PLAYER_WORKSTATIONS_FURNACES);

        copy(OXDRITE_TECH_BLOCKS);
        copy(BlockItemTags.RAILS);
        copy(METAL_SPIKE_BLOCKS);
        copy(LAMPS_METAL);
        copy(LAMPS_GEM);
        copy(BRIDGES);
        copy(FAIRY_LIGHTS);
        tag(TORCHES.item()).add(skeleton_torch.key(), aqua_torch.key(), arcanium_torch.key(), eden_torch.key());

        copy(Tags.BlockItems.BOOKSHELVES);

        copy(CANDY_CANES);

        copy(Tags.BlockItems.DYEABLE_REDYEABLE_SIMPLE);
        copy(DYED_BLACK_AND_WHITE);
        copy(Tags.BlockItems.DYED_LIGHT_GRAY);
        copy(Tags.BlockItems.DYED_BLACK);
        copy(Tags.BlockItems.DYED_RED);
        copy(Tags.BlockItems.DYED_ORANGE);
        copy(Tags.BlockItems.DYED_YELLOW);
        copy(Tags.BlockItems.DYED_GREEN);
        copy(Tags.BlockItems.DYED_CYAN);
        copy(Tags.BlockItems.DYED_BLUE);
        copy(Tags.BlockItems.DYED_PURPLE);
        copy(Tags.BlockItems.DYED_MAGENTA);
        copy(Tags.BlockItems.DYED_PINK);
        copy(DYED_RAINBOW);
        copy(Tags.BlockItems.DYED);

        copy(STORAGE_BLOCKS_IRREVERSIBLE_GLOWSTONE);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_STEEL);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIC_SAND);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIUM_RICH_SAND);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_EDEN);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN);
        copy(STORAGE_BLOCKS_IRREVERSIBLE_MORTUM);

        copy(STORAGE_BLOCKS_RAW_REALMITE);
        copy(STORAGE_BLOCKS_REALMITE);
        copy(STORAGE_BLOCKS_RAW_ARLEMITE);
        copy(STORAGE_BLOCKS_ARLEMITE);
        copy(STORAGE_BLOCKS_RAW_RUPEE);
        copy(STORAGE_BLOCKS_RUPEE);
        copy(STORAGE_BLOCKS_SHADOW);
        copy(STORAGE_BLOCKS_BLOODGEM);
        copy(STORAGE_BLOCKS_RAW_TORRIDITE);
        copy(STORAGE_BLOCKS_TORRIDITE);
        copy(STORAGE_BLOCKS_RAW_OXDRITE);
        copy(STORAGE_BLOCKS_OXDRITE);
        copy(STORAGE_BLOCKS_RAW_ARCANIUM);
        copy(STORAGE_BLOCKS_ARCANIUM);
        copy(Tags.BlockItems.STORAGE_BLOCKS);

        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT).addTag(PUMPKINS.item()).add(toKey(coldHellfireSponge.asItem()), toKey(hellfireSponge.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_SLIDING).addTag(COBBLESTONES_ICY.item()).add(toKey(glaciline.asItem()), toKey(snowBricks.asItem()), toKey(icyBricks.asItem()), toKey(runicIcyBricks.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_HIGH_RESISTANCE).add(toKey(soulSludgeSet.getLast().asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_HOT).add(toKey(hotSpikeBlock.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_REGULAR).addTags(DIRTS.item(), GRASS_BLOCKS.item(), STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE.item(), CANDY_CANES.item()).add(toKey(gelidite.asItem())).remove(toKey(scorchedGrass.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_BOUNCY).addTags(ORES_ANTHRACITE.item(), ORES_BLOODGEM.item(), STORAGE_BLOCKS_BLOODGEM.item(), STORAGE_BLOCKS_RAW_ARCANIUM.item(), STORAGE_BLOCKS_ARCANIUM.item(), ORES_EDEN.item(), STORAGE_BLOCKS_IRREVERSIBLE_EDEN.item(), ORES_WILDWOOD.item(), STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD.item(), ORES_APALACHIA.item(), STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA.item(), ORES_SKYTHERN.item(), STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN.item(), ORES_MORTUM.item(), STORAGE_BLOCKS_IRREVERSIBLE_MORTUM.item(), STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE.item(), MINIBRICKS.item(), COLORED_BRICKS.item(), TWILIGHT_BRICKS.item(), COBBLESTONES_FROZEN.item(), COBBLESTONES_SCORCHALT.item(), OBSIDIANS_CRYING.item(), OBSIDIANS_DARK.item(), LAMPS_GEM.item()).add(toKey(scorchedGrass.asItem()), toKey(asphaltSet.getFirst().asItem()), toKey(frozenStoneSet.getFirst().asItem()), toKey(cobaltiteSet.getFirst().asItem()), toKey(ancientStoneSet.getLast().asItem()), toKey(soulStoneSet.getLast().asItem()), toKey(divineMossStone.asItem()), toKey(lunaStone.asItem()), toKey(blueStone.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_FLAT).addTags(ORES_REALMITE.item(), STORAGE_BLOCKS_RAW_REALMITE.item(), STORAGE_BLOCKS_REALMITE.item(), ORES_ARLEMITE.item(), STORAGE_BLOCKS_RAW_ARLEMITE.item(), STORAGE_BLOCKS_ARLEMITE.item(), ORES_RUPEE.item(), STORAGE_BLOCKS_RAW_RUPEE.item(), STORAGE_BLOCKS_RUPEE.item(), STORAGE_BLOCKS_SHADOW.item(), ORES_TORRIDITE.item(), STORAGE_BLOCKS_RAW_TORRIDITE.item(), STORAGE_BLOCKS_TORRIDITE.item(), ORES_OXDRITE.item(), STORAGE_BLOCKS_RAW_OXDRITE.item(), STORAGE_BLOCKS_OXDRITE.item(), STORAGE_BLOCKS_IRREVERSIBLE_STEEL.item(), LAMPS_METAL.item()).add(toKey(spikeBlock.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_SLIDING).add(toKey(glowsproutSet.getLast().asItem()), toKey(glowsproutSet.get(2).asItem()), toKey(lowsproutSet.getLast().asItem()), toKey(lowsproutSet.get(2).asItem()), toKey(slowsproutSet.getLast().asItem()), toKey(slowsproutSet.get(2).asItem()));
    }
    private ResourceKey<Item> toKey(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }
    private static TagKey<Item> commonTag(String name){
        return TagKey.create(ITEM, Identifier.fromNamespaceAndPath("c", name));
    }
    private static BlockItemTagId commonBlockItemTag(String name){
        return BlockItemTagId.create(Identifier.fromNamespaceAndPath("c", name), Identifier.fromNamespaceAndPath("c", name));
    }
}