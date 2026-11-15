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
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.*;
import static divinerpg.registries.ItemRegistry.*;
import static divinerpg.registries.TagRegistry.Items.*;
import static net.minecraft.core.registries.Registries.ITEM;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
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
        for(var entry : DivineRegistries.BLOCKS.getEntries()) {
            Block block = entry.get();
            if(block.asItem() == Items.AIR) continue;
            var itemKey = toKey(block.asItem());
            String path = entry.getId().getPath();
            if(block instanceof GrassBlock) tag(GRASS_BLOCKS).add(itemKey);
            if(block instanceof LeavesBlock) tag(ItemTags.LEAVES).add(itemKey);
            if(block instanceof SaplingBlock) tag(ItemTags.SAPLINGS).add(itemKey);
            if(block instanceof SignBlock) tag(ItemTags.SIGNS).add(itemKey); // TODO: sign and hanging sign tags
            if(block instanceof HangingSignBlock) tag(ItemTags.HANGING_SIGNS).add(itemKey);
            if(block instanceof WallBlock) tag(ItemTags.WALLS).add(itemKey);
            if(block instanceof WoolCarpetBlock) tag(ItemTags.WOOL_CARPETS).add(itemKey); // TODO: to remove if it still doesn't generate anything
            if(path.contains("stripped_")) {
                if(path.contains("_log")) tag(Tags.Items.STRIPPED_LOGS).add(itemKey);
                if(path.contains("_wood")) tag(Tags.Items.STRIPPED_WOODS).add(itemKey);
            }
        }
        tag(ALLOY_BASES_REALMITE).addTags(RAW_MATERIALS_REALMITE, DUSTS_REALMITE, INGOTS_REALMITE).addOptional(crushed_raw_realmite.key());
        tag(ALLOY_BASES_ARLEMITE).addTags(RAW_MATERIALS_ARLEMITE, DUSTS_ARLEMITE, INGOTS_ARLEMITE).addOptional(crushed_raw_arlemite.key());
        tag(ALLOY_BASES_RUPEE).addTags(RAW_MATERIALS_RUPEE, DUSTS_RUPEE, INGOTS_RUPEE).addOptional(crushed_raw_rupee.key());
        tag(ALLOY_BASES_SHADOW).addTags(DUSTS_SHADOW, INGOTS_SHADOW);
        tag(ALLOY_BASES_BLOODGEM).addTags(DUSTS_BLOODGEM, GEMS_BLOODGEM);
        tag(ALLOY_BASES_TORRIDITE).addTags(RAW_MATERIALS_TORRIDITE, DUSTS_TORRIDITE, INGOTS_TORRIDITE).addOptional(crushed_raw_torridite.key());
        tag(ALLOY_BASES_OXDRITE).addTags(RAW_MATERIALS_OXDRITE, DUSTS_OXDRITE, INGOTS_OXDRITE).addOptional(crushed_raw_oxdrite.key());

        registerMetalSet("aquatic", pure_aquatic_pellets.key(), null, null, aquatic_ingot.key(), null, null, null, null);
        registerMetalSet("realmite", raw_realmite.key(), realmite_dust.key(), realmite_nugget.key(), realmite_ingot.key(), null, toKey(realmiteBlockSet.getFirst().asItem()), toKey(realmiteBlockSet.getLast().asItem()), List.of(toKey(realmiteOreSet.getFirst().asItem()), toKey(realmiteOreSet.getLast().asItem())));
        registerMetalSet("arlemite", raw_arlemite.key(), arlemite_dust.key(), arlemite_nugget.key(), arlemite_ingot.key(), null, toKey(arlemiteBlockSet.getFirst().asItem()), toKey(arlemiteBlockSet.getLast().asItem()), List.of(toKey(arlemiteOreSet.getFirst().asItem()), toKey(arlemiteOreSet.getLast().asItem())));
        registerMetalSet("rupee", raw_rupee.key(), rupee_dust.key(), rupee_nugget.key(), rupee_ingot.key(), null, toKey(rupeeBlockSet.getFirst().asItem()), toKey(rupeeBlockSet.getLast().asItem()), List.of(toKey(rupeeOreSet.getFirst().asItem()), toKey(rupeeOreSet.getLast().asItem())));
        registerMetalSet("shadow", null, shadow_dust.key(), null, shadow_bar.key(), null, null, toKey(shadowBlock.asItem()), null);
        registerMetalSet("torridite", raw_torridite.key(), torridite_dust.key(), torridite_nugget.key(), torridite_ingot.key(), torridite_chunk.key(), toKey(torriditeBlockSet.getFirst().asItem()), toKey(torriditeBlockSet.getLast().asItem()), List.of(toKey(torriditeOre.asItem())));
        registerMetalSet("hellstone", null, null, null, hellstone_ingot.key(), null, null, null, null);
        registerMetalSet("oxdrite", raw_oxdrite.key(), oxdrite_dust.key(), oxdrite_nugget.key(), oxdrite_ingot.key(), null, toKey(oxdriteBlockSet.getFirst().asItem()), toKey(oxdriteBlockSet.getLast().asItem()), List.of(toKey(oxdriteOre.asItem())));
        tag(RAW_MATERIALS_ARCANIUM).add(pieceOfRawArcanium.key());
        tag(Tags.Items.RAW_MATERIALS).addTag(RAW_MATERIALS_ARCANIUM);

        tag(FRAGMENTS_COLLECTOR).add(collector_fragments.key());
        tag(divineTag("fragments")).addTag(FRAGMENTS_COLLECTOR);
        tag(PELLETS_AQUATIC).add(aquatic_pellets.key());
        tag(PELLETS_AQUATIC_PURE).add(pure_aquatic_pellets.key());

        tag(ItemTags.METAL_NUGGETS).addTags(NUGGETS_REALMITE, NUGGETS_ARLEMITE, NUGGETS_RUPEE, NUGGETS_TORRIDITE, NUGGETS_OXDRITE);

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

        registerGemSet("ice", null, ice_shards.key(), ice_stone.key(), null, null);
        registerGemSet("jungle", null, jungle_shards.key(), jungle_stone.key(), null, null);
        registerGemSet("terran", null, terran_shards.key(), terran_stone.key(), null, null);
        registerGemSet("shadow", null, null, shadow_stone.key(), null, null);
        registerGemSet("corrupted", null, corrupted_shards.key(), corrupted_stone.key(), null, null);
        registerGemSet("divine", null, divine_shards.key(), divine_stone.key(), null, null);
        registerGemSet("bloodgem", bloodgem_dust.key(), null, bloodgem.key(), toKey(bloodgemBlock.asItem()), List.of(toKey(bloodgemOre.asItem())));
        registerGemSet("healing", null, null, healing_stone.key(), null, null);
        registerGemSet("molten", null, molten_shards.key(), molten_stone.key(), null, null);
        registerGemSet("soulfire", null, null, soulfire_stone.key(), null, null);
        registerGemSet("olivine", null, null, olivine.key(), null, null);
        registerGemSet("ender", null, ender_shards.key(), ender_stone.key(), null, null);
        tag(STORAGE_BLOCKS_RAW_ARCANIUM).add(toKey(rawArcanium.asItem()));
        tag(Tags.Items.STORAGE_BLOCKS).addTag(STORAGE_BLOCKS_RAW_ARCANIUM);
        registerGemSet("arcanium", null, null, arcanium.key(), toKey(arcaniumBlock.asItem()), null);

        tag(SHARDS).addTags(SHARDS_ICE, SHARDS_JUNGLE, SHARDS_TERRAN, SHARDS_MOLTEN, SHARDS_CORRUPTED, SHARDS_ENDER, SHARDS_DIVINE);

        tag(CHUNKS_BEDROCK).add(bedrock_chunk.key());
        tag(CHUNKS_DIAMOND_GRAY).add(gray_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_RED).add(red_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_YELLOW).add(yellow_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_GREEN).add(green_diamond_chunk.key());
        tag(CHUNKS_DIAMOND_BLUE).add(blue_diamond_chunk.key());
        tag(CHUNKS_DIAMOND).addTags(CHUNKS_DIAMOND_GRAY, CHUNKS_DIAMOND_RED, CHUNKS_DIAMOND_YELLOW, CHUNKS_DIAMOND_GREEN, CHUNKS_DIAMOND_BLUE);
        tag(Tags.Items.GEMS_DIAMOND).addTag(CHUNKS_DIAMOND);
        tag(commonTag("gems/olivine")).addTag(GEMS_OLIVINE);

        registerTwilightMaterialSet("eden", eden_soul.key(), eden_heart.key(), eden_dust.key(), eden_fragments.key(), eden_gem.key(), eden_chunk.key(), toKey(edenBlock.asItem()), List.of(toKey(twilightEdenOre.asItem()), toKey(scorchaltEdenOre.asItem())));
        registerTwilightMaterialSet("wildwood", wildwood_soul.key(), wildwood_heart.key(), wildwood_dust.key(), wildwood_fragments.key(), wildwood_gem.key(), wildwood_chunk.key(), toKey(wildwoodBlock.asItem()), List.of(toKey(wildwoodOre.asItem())));
        registerTwilightMaterialSet("apalachia", apalachia_soul.key(), apalachia_heart.key(), apalachia_dust.key(), apalachia_fragments.key(), apalachia_gem.key(), apalachia_chunk.key(), toKey(apalachiaBlock.asItem()), List.of(toKey(apalachiaOre.asItem())));
        registerTwilightMaterialSet("skythern", skythern_soul.key(), skythern_heart.key(), skythern_dust.key(), skythern_fragments.key(), skythern_gem.key(), skythern_chunk.key(), toKey(skythernBlock.asItem()), List.of(toKey(skythernOre.asItem())));
        registerTwilightMaterialSet("mortum", mortum_soul.key(), mortum_heart.key(), mortum_dust.key(), mortum_fragments.key(), mortum_gem.key(), mortum_chunk.key(), toKey(mortumBlock.asItem()), List.of(toKey(mortumOre.asItem())));
        tag(SOULS).addTag(SOULS_TWILIGHT);
        tag(commonTag("souls")).addTag(SOULS);
        tag(HEARTS).addTag(HEARTS_TWILIGHT);
        tag(commonTag("hearts")).addTag(HEARTS);
        tag(Tags.Items.GEMS).addTag(CHUNKS_TWILIGHT);
        tag(CHUNKS).addTags(CHUNKS_DIAMOND, CHUNKS_BEDROCK, CHUNKS_TWILIGHT);

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
        tag(SANDS_NO_RICH).addTag(Tags.Items.SANDS).remove(toKey(arcaniumRichSand.asItem()));
        tag(PLANKS_NO_DESIGN).addTag(ItemTags.PLANKS).remove(toKey(plankDesign.asItem()));
        tag(WOODEN_STAIRS_NO_DESIGN).addTag(ItemTags.WOODEN_STAIRS).remove(toKey(stairDesign.asItem()));
        tag(WOODEN_SLABS_NO_DESIGN).addTag(ItemTags.WOODEN_SLABS).remove(toKey(slabDesign.asItem()));

        tag(ItemTags.BOOKSHELF_BOOKS).add(wizards_book.key(), maelstrom.key());

        tag(AMMO_ROPE).add(toKey(Items.LEAD)).addOptionalTag(Tags.Items.ROPES);
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

        tag(REPAIRS_EQUIPMENT_EXPENSIVE_GOLD).addTag(Tags.Items.STORAGE_BLOCKS_GOLD);
        tag(REPAIRS_EQUIPMENT_EXPENSIVE_REALMITE).addTag(STORAGE_BLOCKS_REALMITE);
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
        tag(REPAIRS_EQUIPMENT_JACK_O_MAN).addTags(Tags.Items.PUMPKINS_NORMAL, Tags.Items.PUMPKINS_CARVED);
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
        tag(PET_FOODS_STONE_GOLEM).addTags(Tags.Items.STONES, Tags.Items.COBBLESTONES);
        tag(PET_FOODS_SMELTER).addTags(Tags.Items.STORAGE_BLOCKS_COAL, STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE).addOptionalTags(commonTag("storage_blocks/anthracite"), commonTag("storage_blocks/charcoal"), commonTag("storage_blocks/coal_coke")).add(toKey(Items.MAGMA_BLOCK));
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
        tag(PET_TAMING_FOODS_SMELTER).addTag(Tags.Items.OBSIDIANS);
        tag(PET_TAMING_FOODS_HELL_PIG).add(toKey(Items.BLAZE_POWDER)).addTags(POWDERS_PURPLE_BLAZE, POWDERS_FURY_FIRE, CROPS_FIRESTOCK);
        tag(PET_TAMING_FOODS_FYRACRYX).addTag(CROPS_FIRESTOCK);
        tag(PET_TAMING_FOODS_GOLEM_OF_REJUVENATION).addTag(GEMS_ARCANIUM);
        tag(PET_TAMING_FOODS_PARATIKU).addTag(CROPS_AQUAMARINE);
        tag(PET_TAMING_FOODS_SEIMER).addTag(CROPS_MARSINE);
        tag(PET_TAMING_FOODS_GLINTHOP).add(eden_sparkles.key());
        tag(PET_TAMING_FOODS_MOON_WOLF).addTag(Tags.Items.BONES);

        tag(Tags.Items.BUDDING_BLOCKS).add(toKey(buddingOlivine.asItem()), toKey(buddingDravite.asItem()));
        tag(Tags.Items.CLUSTERS).add(toKey(olivineCluster.asItem()));

        tag(ORES_ANTHRACITE).add(toKey(anthraciteOre.asItem()));
        tag(commonTag("ores/anthracite")).addTag(ORES_ANTHRACITE);
        tag(minecraftTag("ores")).addTags(ORES_REALMITE, ORES_ARLEMITE, ORES_RUPEE, ORES_BLOODGEM, ORES_TORRIDITE, ORES_ANTHRACITE, ORES_OXDRITE, ORES_EDEN, ORES_WILDWOOD, ORES_APALACHIA, ORES_SKYTHERN, ORES_MORTUM);

        tag(Tags.Items.ORES_IN_GROUND_STONE).add(toKey(realmiteOreSet.getFirst().asItem()), toKey(arlemiteOreSet.getFirst().asItem()), toKey(rupeeOreSet.getFirst().asItem()));
        tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE).add(toKey(realmiteOreSet.getLast().asItem()), toKey(arlemiteOreSet.getLast().asItem()), toKey(rupeeOreSet.getLast().asItem()));
        tag(Tags.Items.ORES_IN_GROUND_NETHERRACK).add(toKey(bloodgemOre.asItem()), toKey(torriditeOre.asItem()));
        tag(ORES_IN_GROUND_FROZEN).add(toKey(anthraciteOre.asItem()), toKey(oxdriteOre.asItem()));
        tag(ORES_IN_GROUND_TWILIGHT).add(toKey(twilightEdenOre.asItem()), toKey(wildwoodOre.asItem()), toKey(apalachiaOre.asItem()), toKey(skythernOre.asItem()), toKey(mortumOre.asItem()));
        tag(ORES_IN_GROUND_SCORCHALT).add(toKey(scorchaltEdenOre.asItem()));

        tag(ORE_BEARING_GROUND_FROZEN).add(toKey(frozenStoneSet.getFirst().asItem()));
        tag(ORE_BEARING_GROUND_TWILIGHT).add(toKey(twilightStoneSet.getFirst().asItem()));
        tag(ORE_BEARING_GROUND_SCORCHALT).add(toKey(scorchaltSet.getFirst().asItem()));

        tag(Tags.Items.ORE_RATES_SINGULAR).add(toKey(realmiteOreSet.getFirst().asItem()), toKey(realmiteOreSet.getLast().asItem()), toKey(arlemiteOreSet.getFirst().asItem()), toKey(arlemiteOreSet.getLast().asItem()), toKey(rupeeOreSet.getFirst().asItem()), toKey(rupeeOreSet.getLast().asItem()), toKey(bloodgemOre.asItem()), toKey(torriditeOre.asItem()), toKey(anthraciteOre.asItem()), toKey(oxdriteOre.asItem()));
        tag(Tags.Items.ORE_RATES_SPARSE).add(toKey(twilightEdenOre.asItem()), toKey(scorchaltEdenOre.asItem()), toKey(wildwoodOre.asItem()), toKey(apalachiaOre.asItem()), toKey(skythernOre.asItem()), toKey(mortumOre.asItem()));

        tag(ItemTags.STONE_BRICKS).add(toKey(minibricks.asItem()));
        tag(MINIBRICKS).add(toKey(minibricks.asItem()), toKey(bedrockMinibricks.asItem()), toKey(torriditeMinibricks.asItem()), toKey(realmiteMinibricks.asItem()), toKey(arlemiteMinibricks.asItem()), toKey(rupeeMinibricks.asItem()), toKey(bloodgemMinibricks.asItem()));
        tag(COLORED_BRICKS).add(toKey(milkStoneBricks.asItem()), toKey(ironBricks.asItem()), toKey(torriditeBricks.asItem()), toKey(lavaBricks.asItem()), toKey(realmiteBricks.asItem()), toKey(goldBricks.asItem()), toKey(arlemiteBricks.asItem()), toKey(greenBricks.asItem()), toKey(darkstoneBricks.asItem()), toKey(aquatonicBricks.asItem()), toKey(diamondBricks.asItem()), toKey(lapisLazuliBricks.asItem()), toKey(purpleBricks.asItem()), toKey(magentaBricks.asItem()), toKey(bloodgemBricks.asItem()));
        tag(TWILIGHT_BRICKS).add(toKey(edenBricks.asItem()), toKey(wildwoodBricks.asItem()), toKey(apalachiaBricks.asItem()), toKey(skythernBricks.asItem()), toKey(mortumBricks.asItem()));
        tag(STONE_TYPES_ASPHALT).add(toKey(asphaltSet.getFirst().asItem()), toKey(asphaltSet.get(1).asItem()));
        tag(STONE_TYPES_COALSTONE).add(toKey(coalstoneSet.getFirst().asItem()), toKey(coalstoneSet.get(1).asItem()), toKey(coalstoneSet.get(3).asItem()), toKey(coalstoneBrickSet.getFirst().asItem()), toKey(coalstoneBrickSet.get(1).asItem()), toKey(coalstoneBrickSet.get(3).asItem()), toKey(chiseledCoalstoneBricks.asItem()), toKey(polishedCoalstoneSet.getFirst().asItem()), toKey(polishedCoalstoneSet.get(1).asItem()), toKey(polishedCoalstoneSet.get(3).asItem()), toKey(coalstoneFurnace.asItem()));
        tag(STONE_TYPES_COBALTITE).add(toKey(cobaltiteSet.getFirst().asItem()), toKey(cobaltiteSet.get(1).asItem()), toKey(cobaltiteSet.get(3).asItem()), toKey(polishedCobaltiteSet.getFirst().asItem()), toKey(polishedCobaltiteSet.get(1).asItem()), toKey(polishedCobaltiteSet.get(3).asItem()));
        tag(Tags.Items.STONES).add(toKey(frozenStoneSet.getFirst().asItem()), toKey(arcaniteStoneSet.getFirst().asItem()), toKey(divineRock.asItem()), toKey(twilightStoneSet.getFirst().asItem()), toKey(milkStone.asItem()), toKey(scorchaltSet.getFirst().asItem()), toKey(rayStoneSet.getFirst().asItem()), toKey(draughtStone.asItem()), toKey(dreamStone.asItem()));

        tag(OBSIDIANS_CRYING).add(toKey(broodingObsidian.asItem()), toKey(bleedingObsidian.asItem()), toKey(shiningObsidian.asItem()), toKey(glitteringObsidian.asItem()), toKey(seepingObsidian.asItem()), toKey(vwoopingObsidian.asItem()));
        tag(Tags.Items.OBSIDIANS_CRYING).addTag(OBSIDIANS_CRYING);
        tag(OBSIDIANS_DARK).add(toKey(darkstone.asItem()), toKey(darkstoneBricks.asItem()));
        tag(Tags.Items.OBSIDIANS).addTag(OBSIDIANS_DARK);

        tag(Tags.Items.COBBLESTONES_MOSSY).add(toKey(divineMossStone.asItem()));
        tag(COBBLESTONES_FROZEN).add(toKey(cobbledFrozenStoneSet.getFirst().asItem()));
        tag(commonTag("cobblestones/frozen")).addTag(COBBLESTONES_FROZEN);
        tag(COBBLESTONES_ICY).add(toKey(icyStone.asItem()));
        tag(commonTag("cobblestones/icy")).addTag(COBBLESTONES_ICY);
        tag(COBBLESTONES_SCORCHALT).add(toKey(cobbledScorchaltSet.getFirst().asItem()));
        tag(Tags.Items.COBBLESTONES).addTags(COBBLESTONES_FROZEN, COBBLESTONES_ICY, COBBLESTONES_SCORCHALT).add(toKey(cobaltiteSet.getFirst().asItem()), toKey(ancientStoneSet.getLast().asItem()), toKey(soulStoneSet.getLast().asItem()), toKey(lunaStone.asItem()));

        tag(Tags.Items.GRAVELS).add(toKey(frozenGravel.asItem()));

        tag(DIRTS).add(toKey(frozenSoil.getFirst().asItem()), toKey(arcaniteSoil.getFirst().asItem()), toKey(scorchsoil.getFirst().asItem()), toKey(raySoil.getFirst().asItem()), toKey(wildwoodSoil.getFirst().asItem()), toKey(apalachiaSoil.getFirst().asItem()), toKey(skythernSoil.getFirst().asItem()), toKey(mortumSoil.getFirst().asItem()), toKey(dreamSoil.getFirst().asItem()));
        tag(ItemTags.DIRT).addTag(DIRTS);
        tag(minecraftTag("grass_blocks")).addTag(GRASS_BLOCKS);
        tag(ItemTags.MUD).add(toKey(gelidite.asItem()));

        tag(SANDS_ARCANA).add(toKey(arcaniteSand.asItem()), toKey(arcanicSand.asItem()), toKey(arcaniumRichSand.asItem()));
        tag(commonTag("sands/light_blue")).add(toKey(arcaniteSand.asItem()));
        tag(commonTag("sands/cyan")).add(toKey(arcanicSand.asItem()));
        tag(commonTag("sands/blue")).add(toKey(arcaniumRichSand.asItem()));
        tag(SANDS).addTag(SANDS_ARCANA);
        tag(ItemTags.SAND).addTag(SANDS);
        tag(Tags.Items.SANDS).addTag(SANDS);
        tag(ItemTags.SMELTS_TO_GLASS).addTag(SANDS);
        tag(Tags.Items.GLASS_BLOCKS_COLORLESS).add(toKey(frostedGlass.asItem()));
        tag(commonTag("glass_blocks/smooth")).add(toKey(smoothGlass.asItem()));
        tag(commonTag("glass_blocks/stained")).add(toKey(stainedGlass.asItem()));
        tag(Tags.Items.GLASS_BLOCKS).add(toKey(smoothGlass.asItem()), toKey(stainedGlass.asItem()));

        tag(ItemTags.SOUL_FIRE_BASE_BLOCKS).add(toKey(soulSludgeSet.getLast().asItem()));

        tag(commonTag("ice")).add(toKey(glaciline.asItem()), toKey(icyBricks.asItem()), toKey(runicIcyBricks.asItem()));

        tag(MOSS_BLOCKS).add(toKey(brittleMoss.asItem()), toKey(arcaniteMoss.asItem()));
        tag(ItemTags.MOSS_BLOCKS).addTag(MOSS_BLOCKS);
        tag(PUMPKINS_MOB).add(toKey(blazePumpkin.asItem()), toKey(creeperPumpkin.asItem()), toKey(cyclopsPumpkin.asItem()), toKey(enderPumpkin.asItem()), toKey(enderWatcherPumpkin.asItem()), toKey(frostPumpkin.asItem()), toKey(ghastPumpkin.asItem()), toKey(glaconPumpkin.asItem()), toKey(hellspiderPumpkin.asItem()), toKey(jungleSpiderPumpkin.asItem()), toKey(skeletonPumpkin.asItem()), toKey(spiderPumpkin.asItem()), toKey(zombiePumpkin.asItem()));
        tag(PUMPKINS).addTag(PUMPKINS_MOB);
        tag(Tags.Items.PUMPKINS).addTag(PUMPKINS);
        tag(NATURAL_BULBS).addTag(Tags.Items.FROGLIGHTS).add(toKey(Items.SHROOMLIGHT.asItem()), toKey(glowsproutSet.get(2).asItem()), toKey(lowsproutSet.get(2).asItem()), toKey(slowsproutSet.get(2).asItem()));
        tag(minecraftTag("small_flowers")).add(toKey(crimpetal.getFirst().asItem()), toKey(roofbell.getFirst().asItem()), toKey(winterbloom.getFirst().asItem()), toKey(wispLeaf.getFirst().asItem()), toKey(gemOfTheDunes.getFirst().asItem()), toKey(sunBlossom.getFirst().asItem()), toKey(sunbloom.getFirst().asItem()), toKey(moonBud.getFirst().asItem()), toKey(duskBloom.getFirst().asItem()), toKey(dustLily.getFirst().asItem()), toKey(eyePlant.getFirst().asItem()), toKey(shineGrass.getFirst().asItem()), toKey(cracklespike.getFirst().asItem()), toKey(fernite.getFirst().asItem()), toKey(bulbatobe.getFirst().asItem()), toKey(shimmer.getFirst().asItem()), toKey(yellowDulah.getFirst().asItem()), toKey(greenDulah.getFirst().asItem()), toKey(greenGemtop.getFirst().asItem()), toKey(purpleGemtop.getFirst().asItem()));
        tag(Tags.Items.FLOWERS_TALL).add(toKey(globebrush.asItem()), toKey(thermoliage.asItem()), toKey(duskFlower.asItem()), toKey(dustBrambles.asItem()), toKey(demonBrambles.asItem()));
        tag(minecraftTag("flowers")).add(toKey(mortumWoodSet.get(2).asItem()));
        tag(ItemTags.MUSHROOMS).add(white_mushroom.key(), toKey(glowsproutSet.getFirst().asItem()), toKey(lowsproutSet.getFirst().asItem()), toKey(slowsproutSet.getFirst().asItem()), toKey(lushroom.getFirst().asItem()), toKey(duncap.asItem()), toKey(truffle.asItem()), toKey(dreamglow.getFirst().asItem()));

        tag(LOGS_DIVINE).add(toKey(divineWoodSet.get(3).asItem()), toKey(divineWoodSet.get(4).asItem()), toKey(divineWoodSet.get(5).asItem()), toKey(divineWoodSet.get(6).asItem()));
        tag(LOGS_SHIVERSPINE).add(toKey(shiverspineWoodSet.get(3).asItem()), toKey(shiverspineWoodSet.get(4).asItem()), toKey(shiverspineWoodSet.get(5).asItem()), toKey(shiverspineWoodSet.get(6).asItem()));
        tag(LOGS_AURORAOAK).add(toKey(auroraoakWoodSet.get(3).asItem()), toKey(auroraoakWoodSet.get(4).asItem()), toKey(auroraoakWoodSet.get(5).asItem()), toKey(auroraoakWoodSet.get(6).asItem()));
        tag(LOGS_COZYBARK).add(toKey(cozybarkWoodSet.get(3).asItem()), toKey(cozybarkWoodSet.get(4).asItem()), toKey(cozybarkWoodSet.get(5).asItem()), toKey(cozybarkWoodSet.get(6).asItem()));
        tag(LOGS_STREAMLEAF).add(toKey(streamleafWoodSet.get(3).asItem()), toKey(streamleafWoodSet.get(4).asItem()), toKey(streamleafWoodSet.get(5).asItem()), toKey(streamleafWoodSet.get(6).asItem()));
        tag(LOGS_EUCALYPTUS).add(toKey(eucalyptusWoodSet.getFirst().asItem()), toKey(eucalyptusWoodSet.get(1).asItem()), toKey(eucalyptusWoodSet.get(2).asItem()), toKey(eucalyptusWoodSet.get(3).asItem()));
        tag(LOGS_EDEN).add(toKey(edenWoodSet.get(3).asItem()), toKey(edenWoodSet.get(4).asItem()), toKey(edenWoodSet.get(5).asItem()), toKey(edenWoodSet.get(6).asItem()));
        tag(LOGS_CRIMSEEKER).add(toKey(crimseekerWoodSet.get(3).asItem()), toKey(crimseekerWoodSet.get(4).asItem()), toKey(crimseekerWoodSet.get(5).asItem()), toKey(crimseekerWoodSet.get(6).asItem()));
        tag(LOGS_WILDWOOD).add(toKey(wildwoodWoodSet.get(3).asItem()), toKey(wildwoodWoodSet.get(4).asItem()), toKey(wildwoodWoodSet.get(5).asItem()), toKey(wildwoodWoodSet.get(6).asItem()));
        tag(LOGS_APALACHIA).add(toKey(apalachiaWoodSet.get(3).asItem()), toKey(apalachiaWoodSet.get(4).asItem()), toKey(apalachiaWoodSet.get(5).asItem()), toKey(apalachiaWoodSet.get(6).asItem()));
        tag(LOGS_SKYTHERN).add(toKey(skythernWoodSet.get(3).asItem()), toKey(skythernWoodSet.get(4).asItem()), toKey(skythernWoodSet.get(5).asItem()), toKey(skythernWoodSet.get(6).asItem()));
        tag(LOGS_MORTUM).add(toKey(mortumWoodSet.get(3).asItem()), toKey(mortumWoodSet.get(4).asItem()), toKey(mortumWoodSet.get(5).asItem()), toKey(mortumWoodSet.get(6).asItem()));
        tag(LOGS_FIREWOOD).add(toKey(firewoodSet.get(1).asItem()), toKey(firewoodSet.get(2).asItem()), toKey(firewoodSet.get(3).asItem()), toKey(firewoodSet.get(4).asItem()));
        tag(LOGS_DREAMWOOD).add(toKey(dreamwoodSet.get(1).asItem()), toKey(dreamwoodSet.get(2).asItem()), toKey(dreamwoodSet.get(3).asItem()), toKey(dreamwoodSet.get(4).asItem()));
        tag(LOGS_HYREWOOD).add(toKey(hyrewoodSet.get(1).asItem()), toKey(hyrewoodSet.get(2).asItem()), toKey(hyrewoodSet.get(3).asItem()), toKey(hyrewoodSet.get(4).asItem()));
        tag(LOGS_MINTWOOD).add(toKey(mintwoodSet.get(1).asItem()), toKey(mintwoodSet.get(2).asItem()), toKey(mintwoodSet.get(3).asItem()), toKey(mintwoodSet.get(4).asItem()));
        tag(LOGS_VETHEA).addTags(LOGS_FIREWOOD, LOGS_DREAMWOOD, LOGS_HYREWOOD, LOGS_MINTWOOD);
        tag(ItemTags.LOGS_THAT_BURN).addTags(LOGS_DIVINE, LOGS_SHIVERSPINE, LOGS_AURORAOAK, LOGS_COZYBARK, LOGS_STREAMLEAF, LOGS_EUCALYPTUS, LOGS_EDEN, LOGS_CRIMSEEKER, LOGS_WILDWOOD, LOGS_APALACHIA, LOGS_SKYTHERN, LOGS_MORTUM, LOGS_FIREWOOD, LOGS_DREAMWOOD, LOGS_HYREWOOD, LOGS_MINTWOOD);

        tag(Tags.Items.OVERWORLD_NATURAL_LOGS).add(toKey(divineWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_ICEIKA).add(toKey(shiverspineWoodSet.get(3).asItem()), toKey(auroraoakWoodSet.get(3).asItem()), toKey(cozybarkWoodSet.get(3).asItem()), toKey(streamleafWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_ARCANA).add(toKey(eucalyptusWoodSet.getFirst().asItem())); // Not so natural, eh?
        tag(NATURAL_LOGS_EDEN).add(toKey(edenWoodSet.get(3).asItem()), toKey(crimseekerWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_WILDWOOD).add(toKey(wildwoodWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_APALACHIA).add(toKey(apalachiaWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_SKYTHERN).add(toKey(skythernWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_MORTUM).add(toKey(mortumWoodSet.get(3).asItem()));
        tag(NATURAL_LOGS_VETHEA).add(toKey(firewoodSet.get(1).asItem()), toKey(dreamwoodSet.get(1).asItem()), toKey(hyrewoodSet.get(1).asItem()), toKey(mintwoodSet.get(1).asItem()));
        tag(Tags.Items.NATURAL_LOGS).addTags(NATURAL_LOGS_ICEIKA, NATURAL_LOGS_ARCANA, NATURAL_LOGS_EDEN, NATURAL_LOGS_WILDWOOD, NATURAL_LOGS_APALACHIA, NATURAL_LOGS_SKYTHERN, NATURAL_LOGS_MORTUM, NATURAL_LOGS_VETHEA);
        tag(Tags.Items.NATURAL_WOODS).add(toKey(shiverspineWoodSet.get(5).asItem()), toKey(auroraoakWoodSet.get(5).asItem()), toKey(cozybarkWoodSet.get(5).asItem()), toKey(streamleafWoodSet.get(5).asItem()), toKey(eucalyptusWoodSet.get(2).asItem()), toKey(edenWoodSet.get(5).asItem()), toKey(wildwoodWoodSet.get(5).asItem()), toKey(apalachiaWoodSet.get(5).asItem()), toKey(skythernWoodSet.get(5).asItem()), toKey(mortumWoodSet.get(5).asItem()), toKey(firewoodSet.get(3).asItem()), toKey(dreamwoodSet.get(3).asItem()), toKey(hyrewoodSet.get(3).asItem()), toKey(mintwoodSet.get(3).asItem()));

        tag(PLANKS_DESIGN).add(toKey(plankDesign.asItem()));
        tag(PLANKS_OVERWORLD).add(toKey(divineWoodSet.get(7).asItem()));
        tag(PLANKS_ICEIKA).add(toKey(shiverspineWoodSet.get(7).asItem()), toKey(auroraoakWoodSet.get(7).asItem()), toKey(cozybarkWoodSet.get(7).asItem()), toKey(streamleafWoodSet.get(7).asItem()));
        tag(PLANKS_ARCANA).add(toKey(eucalyptusWoodSet.get(7).asItem()));
        tag(PLANKS_EDEN).add(toKey(edenWoodSet.get(7).asItem()));
        tag(PLANKS_WILDWOOD).add(toKey(wildwoodWoodSet.get(7).asItem()));
        tag(PLANKS_APALACHIA).add(toKey(apalachiaWoodSet.get(7).asItem()));
        tag(PLANKS_SKYTHERN).add(toKey(skythernWoodSet.get(7).asItem()));
        tag(PLANKS_MORTUM).add(toKey(mortumWoodSet.get(7).asItem()));
        tag(PLANKS).addTags(PLANKS_DESIGN, PLANKS_OVERWORLD, PLANKS_ICEIKA, PLANKS_ARCANA, PLANKS_EDEN, PLANKS_WILDWOOD, PLANKS_APALACHIA, PLANKS_SKYTHERN, PLANKS_SKYTHERN, PLANKS_MORTUM);
        tag(ItemTags.PLANKS).addTag(PLANKS);

        tag(ItemTags.WOODEN_STAIRS).add(toKey(stairDesign.asItem()), toKey(divineWoodSet.get(8).asItem()), toKey(shiverspineWoodSet.get(8).asItem()), toKey(auroraoakWoodSet.get(8).asItem()), toKey(cozybarkWoodSet.get(8).asItem()), toKey(streamleafWoodSet.get(8).asItem()), toKey(eucalyptusWoodSet.get(5).asItem()), toKey(edenWoodSet.get(8).asItem()), toKey(wildwoodWoodSet.get(8).asItem()), toKey(apalachiaWoodSet.get(8).asItem()), toKey(skythernWoodSet.get(8).asItem()), toKey(mortumWoodSet.get(8).asItem()));
        tag(minecraftTag("stairs")).add(toKey(asphaltSet.get(1).asItem()), toKey(frozenStoneSet.get(1).asItem()), toKey(cobbledFrozenStoneSet.get(1).asItem()), toKey(frozenBrickSet.get(1).asItem()), toKey(cobaltiteSet.get(1).asItem()), toKey(polishedCobaltiteSet.get(1).asItem()), toKey(coalstoneSet.get(1).asItem()), toKey(coalstoneBrickSet.get(1).asItem()), toKey(polishedCoalstoneSet.get(1).asItem()), toKey(cutOxdriteSet.get(1).asItem()), toKey(arcaniteStoneSet.get(1).asItem()), toKey(arcaniteTileSet.get(1).asItem()), toKey(ancientBrickSet.get(1).asItem()), toKey(ancientBrickSet.get(6).asItem()), toKey(degradedBrickSet.get(1).asItem()), toKey(degradedBrickSet.get(6).asItem()), toKey(twilightStoneSet.get(1).asItem()), toKey(twilightBrickSet.get(1).asItem()), toKey(scorchaltSet.get(1).asItem()), toKey(cobbledScorchaltSet.get(1).asItem()), toKey(polishedScorchaltSet.get(1).asItem()), toKey(rayStoneSet.get(1).asItem()), toKey(polishedRayStoneSet.get(1).asItem()));
        tag(ItemTags.WOODEN_SLABS).add(toKey(slabDesign.asItem()), toKey(divineWoodSet.get(9).asItem()), toKey(shiverspineWoodSet.get(9).asItem()), toKey(auroraoakWoodSet.get(9).asItem()), toKey(cozybarkWoodSet.get(9).asItem()), toKey(streamleafWoodSet.get(9).asItem()), toKey(eucalyptusWoodSet.get(6).asItem()), toKey(edenWoodSet.get(9).asItem()), toKey(wildwoodWoodSet.get(9).asItem()), toKey(apalachiaWoodSet.get(9).asItem()), toKey(skythernWoodSet.get(9).asItem()), toKey(mortumWoodSet.get(9).asItem()));
        tag(minecraftTag("slabs")).add(toKey(asphaltSet.getLast().asItem()), toKey(frozenStoneSet.get(2).asItem()), toKey(cobbledFrozenStoneSet.get(2).asItem()), toKey(frozenBrickSet.get(2).asItem()), toKey(cobaltiteSet.get(2).asItem()), toKey(polishedCobaltiteSet.get(2).asItem()), toKey(coalstoneSet.get(2).asItem()), toKey(coalstoneBrickSet.get(2).asItem()), toKey(polishedCoalstoneSet.get(2).asItem()), toKey(cutOxdriteSet.get(2).asItem()), toKey(arcaniteStoneSet.get(2).asItem()), toKey(arcaniteTileSet.get(2).asItem()), toKey(ancientBrickSet.get(2).asItem()), toKey(ancientBrickSet.get(7).asItem()), toKey(degradedBrickSet.get(2).asItem()), toKey(degradedBrickSet.get(7).asItem()), toKey(twilightStoneSet.get(2).asItem()), toKey(twilightBrickSet.get(2).asItem()), toKey(scorchaltSet.get(2).asItem()), toKey(cobbledScorchaltSet.get(2).asItem()), toKey(polishedScorchaltSet.get(2).asItem()), toKey(rayStoneSet.get(2).asItem()), toKey(polishedRayStoneSet.get(2).asItem()));

        tag(FENCES_REDSTONE).add(toKey(redFence.asItem()), toKey(greenFence.asItem()), toKey(blueFence.asItem()));
        tag(commonTag("fences/redstone")).addTag(FENCES_REDSTONE);
        tag(FENCES_DIVINE).add(toKey(divineWoodSet.get(10).asItem()));
        tag(FENCES_SHIVERSPINE).add(toKey(shiverspineWoodSet.get(10).asItem()));
        tag(FENCES_AURORAOAK).add(toKey(auroraoakWoodSet.get(10).asItem()));
        tag(FENCES_COZYBARK).add(toKey(cozybarkWoodSet.get(10).asItem()));
        tag(FENCES_STREAMLEAF).add(toKey(streamleafWoodSet.get(10).asItem()));
        tag(FENCES_EUCALYPTUS).add(toKey(eucalyptusWoodSet.get(7).asItem()));
        tag(commonTag("fences/eucalyptus")).addTag(FENCES_EUCALYPTUS);
        tag(FENCES_EDEN).add(toKey(edenWoodSet.get(10).asItem()));
        tag(FENCES_WILDWOOD).add(toKey(wildwoodWoodSet.get(10).asItem()));
        tag(FENCES_APALACHIA).add(toKey(apalachiaWoodSet.get(10).asItem()));
        tag(FENCES_SKYTHERN).add(toKey(skythernWoodSet.get(10).asItem()));
        tag(FENCES_MORTUM).add(toKey(mortumWoodSet.get(10).asItem()));
        tag(ItemTags.WOODEN_FENCES).addTags(FENCES_DIVINE, FENCES_SHIVERSPINE, FENCES_AURORAOAK, FENCES_COZYBARK, FENCES_STREAMLEAF, FENCES_EUCALYPTUS, FENCES_EDEN, FENCES_WILDWOOD, FENCES_APALACHIA, FENCES_SKYTHERN, FENCES_MORTUM);
        tag(minecraftTag("fences")).addTag(FENCES_REDSTONE);
        tag(Tags.Items.FENCES).addTag(FENCES_REDSTONE);

        tag(FENCE_GATES_DIVINE).add(toKey(divineWoodSet.get(11).asItem()));
        tag(FENCE_GATES_SHIVERSPINE).add(toKey(shiverspineWoodSet.get(11).asItem()));
        tag(FENCE_GATES_AURORAOAK).add(toKey(auroraoakWoodSet.get(11).asItem()));
        tag(FENCE_GATES_COZYBARK).add(toKey(cozybarkWoodSet.get(11).asItem()));
        tag(FENCE_GATES_STREAMLEAF).add(toKey(streamleafWoodSet.get(11).asItem()));
        tag(FENCE_GATES_EUCALYPTUS).add(toKey(eucalyptusWoodSet.get(8).asItem()));
        tag(commonTag("fence_gates/eucalyptus")).addTag(FENCE_GATES_EUCALYPTUS);
        tag(FENCE_GATES_EDEN).add(toKey(edenWoodSet.get(11).asItem()));
        tag(FENCE_GATES_WILDWOOD).add(toKey(wildwoodWoodSet.get(11).asItem()));
        tag(FENCE_GATES_APALACHIA).add(toKey(apalachiaWoodSet.get(11).asItem()));
        tag(FENCE_GATES_SKYTHERN).add(toKey(skythernWoodSet.get(11).asItem()));
        tag(FENCE_GATES_MORTUM).add(toKey(mortumWoodSet.get(11).asItem()));
        tag(ItemTags.FENCE_GATES).addTags(FENCE_GATES_DIVINE, FENCE_GATES_SHIVERSPINE, FENCE_GATES_AURORAOAK, FENCE_GATES_COZYBARK, FENCE_GATES_STREAMLEAF, FENCE_GATES_EUCALYPTUS, FENCE_GATES_EDEN, FENCE_GATES_WILDWOOD, FENCE_GATES_APALACHIA, FENCE_GATES_SKYTHERN, FENCE_GATES_MORTUM);
        tag(Tags.Items.FENCE_GATES_WOODEN).addTags(FENCE_GATES_DIVINE, FENCE_GATES_SHIVERSPINE, FENCE_GATES_AURORAOAK, FENCE_GATES_COZYBARK, FENCE_GATES_STREAMLEAF, FENCE_GATES_EUCALYPTUS, FENCE_GATES_EDEN, FENCE_GATES_WILDWOOD, FENCE_GATES_APALACHIA, FENCE_GATES_SKYTHERN, FENCE_GATES_MORTUM);

        tag(ItemTags.WOODEN_BUTTONS).add(toKey(divineWoodSet.get(16).asItem()), toKey(shiverspineWoodSet.get(16).asItem()), toKey(auroraoakWoodSet.get(16).asItem()), toKey(cozybarkWoodSet.get(16).asItem()), toKey(streamleafWoodSet.get(16).asItem()), toKey(eucalyptusWoodSet.get(13).asItem()), toKey(edenWoodSet.get(16).asItem()), toKey(wildwoodWoodSet.get(16).asItem()), toKey(apalachiaWoodSet.get(16).asItem()), toKey(skythernWoodSet.get(16).asItem()), toKey(mortumWoodSet.get(16).asItem()));
        tag(minecraftTag("stone_buttons")).add(toKey(frozenStoneSet.getLast().asItem()), toKey(cobbledFrozenStoneSet.getLast().asItem()), toKey(frozenBrickSet.getLast().asItem()), toKey(cobaltiteSet.getLast().asItem()), toKey(polishedCobaltiteSet.getLast().asItem()), toKey(coalstoneSet.getLast().asItem()), toKey(coalstoneBrickSet.getLast().asItem()), toKey(polishedCoalstoneSet.getLast().asItem()), toKey(arcaniteStoneSet.getLast().asItem()), toKey(arcaniteTileSet.getLast().asItem()), toKey(twilightStoneSet.getLast().asItem()), toKey(twilightBrickSet.getLast().asItem()), toKey(scorchaltSet.getLast().asItem()), toKey(cobbledScorchaltSet.getLast().asItem()), toKey(polishedScorchaltSet.getLast().asItem()), toKey(rayStoneSet.getLast().asItem()), toKey(polishedRayStoneSet.getLast().asItem()));
        tag(minecraftTag("buttons")).add(toKey(cutOxdriteSet.getLast().asItem()));
        tag(ItemTags.WOODEN_PRESSURE_PLATES).add(toKey(divineWoodSet.get(15).asItem()), toKey(shiverspineWoodSet.get(15).asItem()), toKey(auroraoakWoodSet.get(15).asItem()), toKey(cozybarkWoodSet.get(15).asItem()), toKey(streamleafWoodSet.get(15).asItem()), toKey(eucalyptusWoodSet.get(12).asItem()), toKey(edenWoodSet.get(15).asItem()), toKey(wildwoodWoodSet.get(15).asItem()), toKey(apalachiaWoodSet.get(15).asItem()), toKey(skythernWoodSet.get(15).asItem()), toKey(mortumWoodSet.get(15).asItem()));

        tag(ItemTags.WOODEN_DOORS).add(toKey(divineWoodSet.get(13).asItem()), toKey(shiverspineWoodSet.get(13).asItem()), toKey(auroraoakWoodSet.get(13).asItem()), toKey(cozybarkWoodSet.get(13).asItem()), toKey(streamleafWoodSet.get(13).asItem()), toKey(eucalyptusWoodSet.get(10).asItem()), toKey(edenWoodSet.get(13).asItem()), toKey(wildwoodWoodSet.get(13).asItem()), toKey(apalachiaWoodSet.get(13).asItem()), toKey(skythernWoodSet.get(13).asItem()), toKey(mortumWoodSet.get(13).asItem()));
        tag(minecraftTag("doors")).add(toKey(steelDoor.asItem()), toKey(barredDoor.asItem()));
        tag(ItemTags.WOODEN_TRAPDOORS).add(toKey(divineWoodSet.get(14).asItem()), toKey(shiverspineWoodSet.get(14).asItem()), toKey(auroraoakWoodSet.get(14).asItem()), toKey(cozybarkWoodSet.get(14).asItem()), toKey(streamleafWoodSet.get(14).asItem()), toKey(eucalyptusWoodSet.get(11).asItem()), toKey(edenWoodSet.get(14).asItem()), toKey(wildwoodWoodSet.get(14).asItem()), toKey(apalachiaWoodSet.get(14).asItem()), toKey(skythernWoodSet.get(14).asItem()), toKey(mortumWoodSet.get(14).asItem()));

        tag(ItemTags.WOOL).add(toKey(checkerSet.getFirst().asItem()), toKey(rainbowSet.getFirst().asItem()), toKey(fancySet.getFirst().asItem()), toKey(workshopCarpetSet.getFirst().asItem()));
        tag(ItemTags.WOOL_STAIRS).add(toKey(checkerSet.get(0).asItem()), toKey(rainbowSet.get(0).asItem()), toKey(fancySet.get(0).asItem()), toKey(workshopCarpetSet.get(0).asItem()));
        tag(ItemTags.WOOL_SLABS).add(toKey(checkerSet.get(1).asItem()), toKey(rainbowSet.get(1).asItem()), toKey(fancySet.get(1).asItem()), toKey(workshopCarpetSet.get(1).asItem()));

        tag(ItemTags.BEDS).add(nightmare_bed.key());

        tag(CRATES_WOODEN).add(toKey(crate.asItem()));
        tag(commonTag("crates/wooden")).addTag(CRATES_WOODEN);
        tag(CRATES_OXDRITE).add(toKey(oxcrate.asItem()));
        tag(CRATES).addTags(CRATES_WOODEN, CRATES_OXDRITE);
        tag(commonTag("crates")).addTag(CRATES);

        tag(CHESTS).add(toKey(boneChest.asItem()), toKey(frostedChest.asItem()), toKey(presentBox.asItem()), toKey(edenChest.asItem()));
        tag(commonTag("chests/bone")).add(toKey(boneChest.asItem()));
        tag(commonTag("chests/present")).add(toKey(presentBox.asItem()));
        tag(Tags.Items.CHESTS).addTag(CHESTS);

        tag(FURNACES).add(toKey(coalstoneFurnace.asItem()), toKey(greenlightFurnace.asItem()), toKey(oceanfireFurnace.asItem()), toKey(moltenFurnace.asItem()), toKey(whitefireFurnace.asItem()), toKey(moonlightFurnace.asItem()), toKey(demonFurnace.asItem()));
        tag(Tags.Items.PLAYER_WORKSTATIONS_FURNACES).addTag(FURNACES);

        tag(OXDRITE_TECH_BLOCKS).add(toKey(oxcrate.asItem()), toKey(booster.asItem()), toKey(limiter.asItem()), toKey(oxdriteRail.asItem()), toKey(oxdriteLamp.asItem()), toKey(capacitor.asItem()));
        tag(ItemTags.RAILS).add(toKey(oxdriteRail.asItem()));
        tag(METAL_SPIKE_BLOCKS).add(toKey(spikeBlock.asItem()), toKey(hotSpikeBlock.asItem()));
        tag(LAMPS_METAL).add(toKey(milkyLamp.asItem()), toKey(edenLamp.asItem()), toKey(torriditeLamp.asItem()), toKey(lavaLamp.asItem()), toKey(drakenLamp.asItem()), toKey(realmiteLamp.asItem()), toKey(blazeLamp.asItem()), toKey(goldLamp.asItem()), toKey(arlemiteLamp.asItem()), toKey(krakenLamp.asItem()), toKey(diamondLamp.asItem()), toKey(rupeeLamp.asItem()), toKey(lapisLazuliLamp.asItem()), toKey(aquaLamp.asItem()), toKey(enderLamp.asItem()), toKey(bloodgemLamp.asItem()));
        tag(LAMPS_GEM).add(toKey(moltenLamp.asItem()), toKey(divineLamp.asItem()), toKey(jungleLamp.asItem()), toKey(terranLamp.asItem()), toKey(iceLamp.asItem()), toKey(soulfireLamp.asItem()), toKey(enderStoneLamp.asItem()));
        tag(BRIDGES).add(toKey(darkBridge.asItem()), toKey(starBridge.asItem()));
        tag(FAIRY_LIGHTS).add(toKey(redFairyLights.asItem()), toKey(yellowFairyLights.asItem()), toKey(greenFairyLights.asItem()), toKey(blueFairyLights.asItem()), toKey(purpleFairyLights.asItem()));
        tag(TORCHES).add(skeleton_torch.key(), aqua_torch.key(), arcanium_torch.key(), eden_torch.key());

        tag(Tags.Items.BOOKSHELVES).add(toKey(workshopBookcase.asItem()), toKey(dungeonBookshelf.asItem()));

        tag(CANDY_CANES).add(toKey(redCandyCane.asItem()), toKey(yellowCandyCane.asItem()), toKey(greenCandyCane.asItem()), toKey(blueCandyCane.asItem()), toKey(pinkCandyCane.asItem()));

        tag(Tags.Items.DYEABLE_REDYEABLE_SIMPLE).addTags(STORAGE_BLOCKS_IRREVERSIBLE_STEEL, CANDY_CANES).remove(toKey(fancySet.getFirst().asItem()), toKey(fancySet.get(1).asItem()), toKey(fancySet.get(2).asItem()), toKey(fancySet.getLast().asItem()), toKey(workshopCarpetSet.getFirst().asItem()), toKey(workshopCarpetSet.get(1).asItem()), toKey(workshopCarpetSet.getLast().asItem()));
        tag(DYED_BLACK_AND_WHITE).add(toKey(checkerSet.getFirst().asItem()), toKey(checkerSet.get(1).asItem()), toKey(checkerSet.get(2).asItem()), toKey(checkerSet.getLast().asItem()));
        tag(Tags.Items.DYED_LIGHT_GRAY).add(toKey(steel.asItem()));
        tag(Tags.Items.DYED_BLACK).add(toKey(blackSteel.asItem()));
        tag(Tags.Items.DYED_RED).add(toKey(redSteel.asItem()), toKey(redCandyCane.asItem()));
        tag(Tags.Items.DYED_ORANGE).add(toKey(orangeSteel.asItem()));
        tag(Tags.Items.DYED_YELLOW).add(toKey(yellowSteel.asItem()), toKey(yellowCandyCane.asItem()));
        tag(Tags.Items.DYED_GREEN).add(toKey(greenSteel.asItem()), toKey(greenCandyCane.asItem()));
        tag(Tags.Items.DYED_CYAN).add(toKey(cyanSteel.asItem()));
        tag(Tags.Items.DYED_BLUE).add(toKey(blueSteel.asItem()), toKey(blueCandyCane.asItem()));
        tag(Tags.Items.DYED_PURPLE).add(toKey(purpleSteel.asItem()));
        tag(Tags.Items.DYED_MAGENTA).add(toKey(magentaSteel.asItem()));
        tag(Tags.Items.DYED_PINK).add(toKey(pinkCandyCane.asItem()));
        tag(DYED_RAINBOW).add(toKey(rainbowSet.getFirst().asItem()), toKey(rainbowSet.get(1).asItem()), toKey(rainbowSet.get(2).asItem()), toKey(rainbowSet.getLast().asItem()));
        tag(Tags.Items.DYED).add(toKey(checkerSet.getFirst().asItem()), toKey(checkerSet.get(1).asItem()), toKey(checkerSet.get(2).asItem()), toKey(checkerSet.getLast().asItem()), toKey(rainbowSet.getFirst().asItem()), toKey(rainbowSet.get(1).asItem()), toKey(rainbowSet.get(2).asItem()), toKey(rainbowSet.getLast().asItem()));

        tag(STORAGE_BLOCKS_IRREVERSIBLE_GLOWSTONE).add(toKey(Items.GLOWSTONE), toKey(blueStone.asItem()));
        tag(STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE).add(toKey(olivineBlock.asItem()));
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE).add(toKey(coalstoneSet.getFirst().asItem()), toKey(coalstoneBrickSet.getFirst().asItem()), toKey(chiseledCoalstoneBricks.asItem()), toKey(polishedCoalstoneSet.getFirst().asItem()));
        tag(STORAGE_BLOCKS_IRREVERSIBLE_STEEL).add(toKey(steel.asItem()), toKey(blackSteel.asItem()), toKey(redSteel.asItem()), toKey(orangeSteel.asItem()), toKey(yellowSteel.asItem()), toKey(greenSteel.asItem()), toKey(cyanSteel.asItem()), toKey(blueSteel.asItem()), toKey(purpleSteel.asItem()), toKey(magentaSteel.asItem()));
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIC_SAND).add(toKey(arcanicSand.asItem()));
        tag(STORAGE_BLOCKS_IRREVERSIBLE_ARCANIUM_RICH_SAND).add(toKey(arcaniumRichSand.asItem()));

        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT).addTag(PUMPKINS).add(toKey(coldHellfireSponge.asItem()), toKey(hellfireSponge.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_SLIDING).addTag(COBBLESTONES_ICY).add(toKey(glaciline.asItem()), toKey(snowBricks.asItem()), toKey(icyBricks.asItem()), toKey(runicIcyBricks.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_HIGH_RESISTANCE).add(toKey(soulSludgeSet.getLast().asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_HOT).add(toKey(hotSpikeBlock.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_REGULAR).addTags(DIRTS, GRASS_BLOCKS, STORAGE_BLOCKS_IRREVERSIBLE_ANTHRACITE, CANDY_CANES).add(toKey(gelidite.asItem())).remove(toKey(scorchedGrass.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_BOUNCY).addTags(ORES_ANTHRACITE, ORES_BLOODGEM, STORAGE_BLOCKS_BLOODGEM, STORAGE_BLOCKS_RAW_ARCANIUM, STORAGE_BLOCKS_ARCANIUM, ORES_EDEN, STORAGE_BLOCKS_IRREVERSIBLE_EDEN, ORES_WILDWOOD, STORAGE_BLOCKS_IRREVERSIBLE_WILDWOOD, ORES_APALACHIA, STORAGE_BLOCKS_IRREVERSIBLE_APALACHIA, ORES_SKYTHERN, STORAGE_BLOCKS_IRREVERSIBLE_SKYTHERN, ORES_MORTUM, STORAGE_BLOCKS_IRREVERSIBLE_MORTUM, STORAGE_BLOCKS_IRREVERSIBLE_OLIVINE, MINIBRICKS, COLORED_BRICKS, TWILIGHT_BRICKS, COBBLESTONES_FROZEN, COBBLESTONES_SCORCHALT, OBSIDIANS_CRYING, OBSIDIANS_DARK, LAMPS_GEM).add(toKey(scorchedGrass.asItem()), toKey(asphaltSet.getFirst().asItem()), toKey(frozenStoneSet.getFirst().asItem()), toKey(cobaltiteSet.getFirst().asItem()), toKey(ancientStoneSet.getLast().asItem()), toKey(soulStoneSet.getLast().asItem()), toKey(divineMossStone.asItem()), toKey(lunaStone.asItem()), toKey(blueStone.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_FLAT).addTags(ORES_REALMITE, STORAGE_BLOCKS_RAW_REALMITE, STORAGE_BLOCKS_REALMITE, ORES_ARLEMITE, STORAGE_BLOCKS_RAW_ARLEMITE, STORAGE_BLOCKS_ARLEMITE, ORES_RUPEE, STORAGE_BLOCKS_RAW_RUPEE, STORAGE_BLOCKS_RUPEE, STORAGE_BLOCKS_SHADOW, ORES_TORRIDITE, STORAGE_BLOCKS_RAW_TORRIDITE, STORAGE_BLOCKS_TORRIDITE, ORES_OXDRITE, STORAGE_BLOCKS_RAW_OXDRITE, STORAGE_BLOCKS_OXDRITE, STORAGE_BLOCKS_IRREVERSIBLE_STEEL, LAMPS_METAL).add(toKey(spikeBlock.asItem()));
        tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_SLIDING).add(toKey(glowsproutSet.getLast().asItem()), toKey(glowsproutSet.get(2).asItem()), toKey(lowsproutSet.getLast().asItem()), toKey(lowsproutSet.get(2).asItem()), toKey(slowsproutSet.getLast().asItem()), toKey(slowsproutSet.get(2).asItem()));
    }
    private void registerMetalSet(String name, ResourceKey<Item> raw_materials, ResourceKey<Item> dusts, ResourceKey<Item> nuggets, ResourceKey<Item> ingots, ResourceKey<Item> chunks, ResourceKey<Item> raw_storage_blocks, ResourceKey<Item> storage_blocks, Iterable<ResourceKey<Item>> ores) {
        if(raw_materials != null) {
            tag(divineTag("raw_materials/" + name)).add(raw_materials);
            tag(Tags.Items.RAW_MATERIALS).addTag(divineTag("raw_materials/" + name));
        }
        if(dusts != null) {
            tag(divineTag("dusts/" + name)).add(dusts);
            tag(Tags.Items.DUSTS).addTag(divineTag("dusts/" + name));
        }
        if(nuggets != null) {
            tag(divineTag("nuggets/" + name)).add(nuggets);
            tag(Tags.Items.NUGGETS).addTag(divineTag("nuggets/" + name));
        }
        if(ingots != null) {
            tag(divineTag("ingots/" + name)).add(ingots);
            tag(Tags.Items.INGOTS).addTag(divineTag("ingots/" + name));
        }
        if(chunks != null) {
            tag(divineTag("chunks/" + name)).add(chunks);
            tag(CHUNKS).addTag(divineTag("chunks/" + name));
        }
        if(raw_storage_blocks != null) {
            tag(divineTag("storage_blocks/raw_" + name)).add(raw_storage_blocks);
            tag(Tags.Items.STORAGE_BLOCKS).addTag(divineTag("storage_blocks/raw_" + name));
        }
        if(storage_blocks != null) {
            tag(divineTag("storage_blocks/" + name)).add(storage_blocks); //Those that can't be uncrafted don't count
            tag(Tags.Items.STORAGE_BLOCKS).addTag(divineTag("storage_blocks/" + name));
        }
        if(ores != null) {
            for(ResourceKey<Item> ore : ores) {
                if(ore != null) tag(divineTag("ores/" + name)).add(ore);
            } tag(Tags.Items.ORES).addTag(divineTag("ores/" + name));
        }
    }
    private void registerGemSet(String name, ResourceKey<Item> dusts, ResourceKey<Item> shards, ResourceKey<Item> gems, ResourceKey<Item> storage_blocks, Iterable<ResourceKey<Item>> ores) {
        if(dusts != null) {
            tag(divineTag("dusts/" + name)).add(dusts);
            tag(Tags.Items.DUSTS).addTag(divineTag("dusts/" + name));
        }
        if(shards != null) {
            tag(divineTag("shards/" + name)).add(shards);
        }
        if(gems != null) {
            tag(divineTag("gems/" + name)).add(gems);
            tag(Tags.Items.GEMS).addTag(divineTag("gems/" + name));
        }
        if(storage_blocks != null) {
            tag(divineTag("storage_blocks/" + name)).add(storage_blocks); //Those that can't be uncrafted don't count
            tag(Tags.Items.STORAGE_BLOCKS).addTag(divineTag("storage_blocks/" + name));
        }
        if(ores != null) {
            for(ResourceKey<Item> ore : ores) {
                if(ore != null) tag(divineTag("ores/" + name)).add(ore);
            } tag(Tags.Items.ORES).addTag(divineTag("ores/" + name));
        }
    }
    private void registerTwilightMaterialSet(String name, ResourceKey<Item> souls, ResourceKey<Item> hearts, ResourceKey<Item> dusts, ResourceKey<Item> fragments, ResourceKey<Item> gems, ResourceKey<Item> chunks, ResourceKey<Item> storage_blocks, Iterable<ResourceKey<Item>> ores) {
        if(souls != null) {
            tag(divineTag("souls/" + name)).add(souls);
            tag(SOULS_TWILIGHT).addTag(divineTag("souls/" + name));
        }
        if(hearts != null) {
            tag(divineTag("hearts/" + name)).add(hearts);
            tag(HEARTS_TWILIGHT).addTag(divineTag("hearts/" + name));
        }
        if(dusts != null) {
            tag(divineTag("dusts/" + name)).add(dusts);
            tag(Tags.Items.DUSTS).addTag(divineTag("dusts/" + name));
        }
        if(fragments != null) {
            tag(divineTag("fragments/" + name)).add(fragments);
            tag(divineTag("fragments")).addTag(divineTag("fragments/" + name));
        }
        if(gems != null) {
            tag(divineTag("gems/" + name)).add(gems);
            tag(Tags.Items.GEMS).addTag(divineTag("gems/" + name));
        }
        if(chunks != null) {
            tag(divineTag("chunks/" + name)).add(chunks);
            tag(CHUNKS_TWILIGHT).addTag(divineTag("chunks/" + name));
        }
        if(storage_blocks != null) {
            tag(divineTag("storage_blocks/irreversible/" + name)).add(storage_blocks);
        }
        if(ores != null) {
            for(ResourceKey<Item> ore : ores) {
                if(ore != null) tag(divineTag("ores/" + name)).add(ore);
            } tag(Tags.Items.ORES).addTag(divineTag("ores/" + name));
        }
    }
    private ResourceKey<Item> toKey(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }
    private TagKey<Item> divineTag(String name) {
        return TagKey.create(ITEM, Identifier.fromNamespaceAndPath(MODID, name));
    }
    private TagKey<Item> minecraftTag(String name){
        return TagKey.create(ITEM, Identifier.withDefaultNamespace(name));
    }
    private static TagKey<Item> commonTag(String name){
        return TagKey.create(ITEM, Identifier.fromNamespaceAndPath("c", name));
    }
}