package divinerpg.data;

import divinerpg.recipe.builder.*;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.*;
import net.neoforged.neoforge.registries.DeferredItem;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Consumer;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.*;
import static divinerpg.registries.ItemRegistry.*;
import static divinerpg.registries.TagRegistry.BlockItems.*;
import static divinerpg.registries.TagRegistry.Blocks.BEDROCK_GRINDING_BASE;
import static divinerpg.registries.TagRegistry.Items.*;
import static net.minecraft.core.registries.BuiltInRegistries.ITEM;
import static net.minecraft.core.registries.Registries.RECIPE;
import static net.minecraft.data.BlockFamily.Variant.*;
import static net.minecraft.data.recipes.RecipeCategory.*;
import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static net.minecraft.world.flag.FeatureFlags.DEFAULT_FLAGS;
import static net.minecraft.world.level.block.Blocks.FIRE;
import static net.neoforged.neoforge.common.Tags.Items.INGOTS_IRON;
import static net.neoforged.neoforge.common.Tags.Items.RODS_WOODEN;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }
    @Override protected void buildRecipes() {
        generateForEnabledBlockFamilies(DEFAULT_FLAGS);
        // CRAFTING
        // Equipment (armor, tools, swords, etc.)
        equipment(FURS_SENG);
        equipment(INGOTS_REALMITE);
        equipment(INGOTS_ARLEMITE);
        equipment(INGOTS_RUPEE);
        equipment(INGOTS_SHADOW);
        equipment(INGOTS_OXDRITE);
        equipment(GEMS_ICE);
        equipment(GEMS_JUNGLE);
        equipment(GEMS_TERRAN);
        equipment(GEMS_BLOODGEM);
        equipment(GEMS_MOLTEN);
        equipment(GEMS_CORRUPTED);
        equipment(GEMS_ENDER);
        equipment(GEMS_DIVINE);
        equipment(CHUNKS_EDEN);
        equipment(CHUNKS_WILDWOOD);
        equipment(CHUNKS_APALACHIA);
        equipment(CHUNKS_SKYTHERN);
        equipment(CHUNKS_MORTUM);
        shaped(COMBAT, ARLEMITE_HELMET).pattern("###").pattern("X X").define('#', INGOTS_ARLEMITE).define('X', INGOTS_IRON).unlockedBy("has_arlemite_ingots", has(INGOTS_ARLEMITE)).save(output);
        shaped(COMBAT, ARLEMITE_CHESTPLATE).pattern("# #").pattern("X#X").pattern("#X#").define('#', INGOTS_ARLEMITE).define('X', INGOTS_IRON).unlockedBy("has_arlemite_ingots", has(INGOTS_ARLEMITE)).save(output);
        shaped(COMBAT, ARLEMITE_LEGGINGS).pattern("###").pattern("X X").pattern("# #").define('#', INGOTS_ARLEMITE).define('X', INGOTS_IRON).unlockedBy("has_arlemite_ingots", has(INGOTS_ARLEMITE)).save(output);
        shaped(COMBAT, ARLEMITE_BOOTS).pattern("X X").pattern("# #").define('#', INGOTS_ARLEMITE).define('X', INGOTS_IRON).unlockedBy("has_arlemite_ingots", has(INGOTS_ARLEMITE)).save(output);
        shaped(COMBAT, ANGELIC_HELMET).pattern("XXX").pattern("# #").define('#', GEMS_SOULFIRE).define('X', GEMS_SHADOW).unlockedBy("has_soulfire_gems", has(GEMS_SOULFIRE)).save(output);
        shaped(COMBAT, ANGELIC_CHESTPLATE).pattern("# #").pattern("XYX").pattern("XXX").define('#', GEMS_SOULFIRE).define('X', GEMS_SHADOW).define('Y', Items.ELYTRA).unlockedBy("has_soulfire_gems", has(GEMS_SOULFIRE)).save(output);
        shaped(COMBAT, ANGELIC_LEGGINGS).pattern("###").pattern("X X").pattern("X X").define('#', GEMS_SOULFIRE).define('X', GEMS_SHADOW).unlockedBy("has_soulfire_gems", has(GEMS_SOULFIRE)).save(output);
        shaped(COMBAT, ANGELIC_BOOTS).pattern("# #").pattern("X X").define('#', GEMS_SOULFIRE).define('X', GEMS_SHADOW).unlockedBy("has_soulfire_gems", has(GEMS_SOULFIRE)).save(output);
        // Storage blocks and materials
        storageBlocks(raw_realmite);
        storageBlocks(raw_arlemite);
        storageBlocks(raw_rupee);
        storageBlocks(raw_torridite);
        storageBlocks(raw_oxdrite);
        storageBlocks(realmite_ingot);
        storageBlocks(arlemite_ingot);
        storageBlocks(rupee_ingot);
        storageBlocks(shadow_bar);
        storageBlocks(torridite_ingot);
        storageBlocks(oxdrite_ingot);
        storageBlocks(ice_stone);
        storageBlocks(jungle_stone);
        storageBlocks(terran_stone);
        storageBlocks(bloodgem);
        storageBlocks(molten_stone);
        storageBlocks(arcanium);
        storageBlocks(corrupted_stone);
        storageBlocks(ender_stone);
        storageBlocks(divine_stone);
        storageBlocks(eden_chunk, false);
        storageBlocks(wildwood_chunk, false);
        storageBlocks(apalachia_chunk, false);
        storageBlocks(skythern_chunk, false);
        storageBlocks(mortum_chunk, false);
        // Wood
        woodSetFromLogs(divineWoodSet);
        woodSetFromLogs(shiverspineWoodSet);
        woodSetFromLogs(auroraoakWoodSet);
        woodSetFromLogs(cozybarkWoodSet);
        woodSetFromLogs(streamleafWoodSet);
        woodSetFromLogs(eucalyptusWoodSet);
        woodSetFromLogs(edenWoodSet);
        woodSetFromLogs(crimseekerWoodSet);
        woodSetFromLogs(wildwoodWoodSet);
        woodSetFromLogs(apalachiaWoodSet);
        woodSetFromLogs(skythernWoodSet);
        woodSetFromLogs(mortumWoodSet);
        woodSetFromLogs(firewoodSet);
        woodSetFromLogs(dreamwoodSet);
        woodSetFromLogs(hyrewoodSet);
        woodSetFromLogs(mintwoodSet);
        // Other blocks
        shaped(BUILDING_BLOCKS, checkerSet.getFirst(), 4).pattern("BW").pattern("WB").define('W', Items.WOOL.white()).define('B', Items.WOOL.black()).unlockedBy("has_wool", inventoryTrigger(ItemPredicate.Builder.item().of(items, Items.WOOL.white(), Items.WOOL.black()))).save(output);
        shapeless(BUILDING_BLOCKS, rainbowSet.getFirst(), 7).requires(Items.WOOL.red()).requires(Items.WOOL.orange()).requires(Items.WOOL.yellow()).requires(Items.WOOL.lime()).requires(Items.WOOL.lightBlue()).requires(Items.WOOL.blue()).requires(Items.WOOL.purple()).unlockedBy("has_wool", inventoryTrigger(ItemPredicate.Builder.item().of(items, Items.WOOL.red(), Items.WOOL.orange(), Items.WOOL.yellow(), Items.WOOL.lime(), Items.WOOL.lightBlue(), Items.WOOL.blue(), Items.WOOL.purple()))).save(output);
        List.of(GEMS_EDEN, GEMS_WILDWOOD, GEMS_APALACHIA, GEMS_SKYTHERN, GEMS_MORTUM).forEach(this::twilightSet);
        // Food
        shapeless(FOOD, advanced_mushroom_stew).requires(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "foods/white_mushroom"))).requires(Items.MUSHROOM_STEW).unlockedBy("has_white_mushrooms", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "foods/white_mushroom")))).save(output);
        // TODO: the rest of the shaped and shapeless
        // STONECUTTING
        stonecutting(Items.STONE, minibricks);
        stonecutting(Items.STONE_BRICKS, minibricks);
        stonecutting(realmiteBricks, realmiteMinibricks);
        stonecutting(arlemiteBricks, arlemiteMinibricks);
        stonecutting(bloodgemBricks, bloodgemMinibricks);
        stonecutting(torriditeBricks, torriditeMinibricks);
        // SMELTING
        // Defrosting
        smelting(List.of(frozenSoil.getFirst()), Items.DIRT, .1F);
        smelting(List.of(frozenGravel), Items.GRAVEL, .1F);
        smelting(List.of(frozenStoneSet.getFirst()), Items.STONE, .1F);
        smelting(List.of(frozenStoneSet.get(1)), Items.STONE_STAIRS, .1F);
        smelting(List.of(frozenStoneSet.get(2)), Items.STONE_SLAB, .05F, 100);
        smelting(List.of(frozenStoneSet.get(4)), Items.STONE_PRESSURE_PLATE, .1F);
        smelting(List.of(frozenStoneSet.get(5)), Items.STONE_BUTTON, .1F);
        smelting(List.of(cobbledFrozenStoneSet.get(1)), Items.COBBLESTONE_STAIRS, .1F);
        smelting(List.of(cobbledFrozenStoneSet.get(2)), Items.COBBLESTONE_SLAB, .05F, 100);
        smelting(List.of(cobbledFrozenStoneSet.get(3)), Items.COBBLESTONE_WALL, .1F);
        smelting(List.of(frozenBrickSet.getFirst()), Items.STONE_BRICKS, .1F);
        smelting(List.of(frozenBrickSet.get(1)), Items.STONE_BRICK_STAIRS, .1F);
        smelting(List.of(frozenBrickSet.get(2)), Items.STONE_BRICK_SLAB, .05F, 100);
        smelting(List.of(frozenBrickSet.get(3)), Items.STONE_BRICK_WALL, .1F);
        // Misc
        smelting(List.of(frozen_clock), TOOLS, Items.CLOCK, .01F, 80);
        smelting(List.of(soulSludgeSet.getLast()), Items.SOUL_SAND, .1F);
        // BLASTING + SMELTING
        // Ores, raw materials, dusts, etc.
        blastingSet(List.of(pure_aquatic_pellets), aquatic_ingot, 1.3F);
        blastingSet(List.of(realmiteOreSet.getFirst(), realmiteOreSet.getLast(), raw_realmite, realmite_dust), realmite_ingot, .7F);
        blastingSet(List.of(arlemiteOreSet.getFirst(), arlemiteOreSet.getLast(), raw_arlemite, arlemite_dust), arlemite_ingot, 1);
        blastingSet(List.of(rupeeOreSet.getFirst(), rupeeOreSet.getLast(), raw_rupee, rupee_dust), rupee_ingot, 1);
        blastingSet(List.of(shadow_dust), shadow_bar, 1);
        blastingSet(List.of(bloodgemOre), bloodgem, 1.2F);
        blastingSet(List.of(torriditeOre, raw_torridite, torridite_dust), torridite_ingot, .7F);
        blastingSet(List.of(anthraciteOre), anthracite, .1F);
        blastingSet(List.of(oxdriteOre, raw_oxdrite, oxdrite_dust), oxdrite_ingot, .7F);
        blastingSet(List.of(eden_dust), eden_sparkles, .35F);
        blastingSet(List.of(scorchaltEdenOre, twilightEdenOre), eden_fragments, .7F);
        blastingSet(List.of(wildwoodOre), wildwood_fragments, 1);
        blastingSet(List.of(apalachiaOre), apalachia_fragments, 1.3F);
        blastingSet(List.of(skythernOre), skythern_fragments, 1.7F);
        blastingSet(List.of(mortumOre), mortum_fragments, 2);
        // Equipment
        blastingSet(List.of(SMELTABLE_EQUIPMENT_COMPRESSED_GOLD), Items.GOLD_INGOT, 1);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_COMPRESSED_REALMITE), realmite_ingot, .7F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_COMPRESSED_TORRIDITE), torridite_ingot, 1.1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_REALMITE), realmite_nugget, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_OXDRITE), oxdrite_nugget, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_ARLEMITE), arlemite_nugget, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_ICE), ice_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_TERRAN), terran_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_RUPEE), rupee_nugget, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_JUNGLE), jungle_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_MOLTEN), molten_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_TORRIDITE), torridite_nugget, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_CORRUPTED), corrupted_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_ENDER), ender_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_DIVINE), divine_shards, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_EDEN), eden_fragments, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_WILDWOOD), wildwood_fragments, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_APALACHIA), apalachia_fragments, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_SKYTHERN), skythern_fragments, .1F);
        blastingSet(List.of(SMELTABLE_EQUIPMENT_MORTUM), mortum_fragments, .1F);
        // Misc
        blastingSet(List.of(coldHellfireSponge), BUILDING_BLOCKS, hellfireSponge, .45F, 300);
        // SMOKING + SMELTING + CAMPFIRE COOKING
        smokingSet(List.of(Items.PUMPKIN_PIE), hot_pumpkin_pie, .35F);
        smokingSet(List.of(Tags.Items.EGGS), boiled_egg, .35F, new NotCondition(new ModLoadedCondition("farmersdelight")));
        // Meat
        smokingSet(List.of(bacon), cooked_bacon, .175F, 50);
        smokingSet(List.of(raw_wolpertinger_meat), wolpertinger_steak, .35F);
        smokingSet(List.of(raw_seng_meat), seng_steak, .35F);
        smokingSet(List.of(raw_empowered_meat), empowered_meat, .35F);
        // CAMPFIRE COOKING
        campfireCooking(List.of(frozen_clock), Items.CLOCK, .1F, 240);
        // SMITHING
        // Aquatic coating
        smithing(aquatic_coating_template, List.of(AQUASTRIVE_BOOTS), SKINS_KRAKEN, KRAKEN_BOOTS);
        smithing(aquatic_coating_template, List.of(AQUASTRIVE_LEGGINGS), SKINS_KRAKEN, KRAKEN_LEGGINGS);
        smithing(aquatic_coating_template, List.of(AQUASTRIVE_CHESTPLATE), SKINS_KRAKEN, KRAKEN_CHESTPLATE);
        smithing(aquatic_coating_template, List.of(AQUASTRIVE_HELMET), SKINS_KRAKEN, KRAKEN_HELMET);
        // Bedrock upgrade
        smithing(bedrock_upgrade_template, List.of(INFERNO_HELMET, TORRIDITE_HELMET), bedrock_chunk, BEDROCK_HELMET);
        smithing(bedrock_upgrade_template, List.of(INFERNO_CHESTPLATE, TORRIDITE_CHESTPLATE), bedrock_chunk, BEDROCK_CHESTPLATE);
        smithing(bedrock_upgrade_template, List.of(INFERNO_LEGGINGS, TORRIDITE_LEGGINGS), bedrock_chunk, BEDROCK_LEGGINGS);
        smithing(bedrock_upgrade_template, List.of(INFERNO_BOOTS, TORRIDITE_BOOTS), bedrock_chunk, BEDROCK_BOOTS);
        smithing(bedrock_upgrade_template, List.of(corrupted_shovel), bedrock_chunk, TOOLS, bedrock_shovel);
        smithing(bedrock_upgrade_template, List.of(corrupted_pickaxe), bedrock_chunk, TOOLS, bedrock_pickaxe);
        smithing(bedrock_upgrade_template, List.of(corrupted_axe), bedrock_chunk, TOOLS, bedrock_axe);
        smithing(bedrock_upgrade_template, List.of(corrupted_hoe), bedrock_chunk, TOOLS, bedrock_hoe);
        // Color upgrade
        smithing(color_template, List.of(SENG_FUR_BOOTS), fancySet.getFirst(), SANTA_BOOTS);
        smithing(color_template, List.of(SENG_FUR_LEGGINGS), fancySet.getFirst(), SANTA_LEGGINGS);
        smithing(color_template, List.of(SENG_FUR_CHESTPLATE), fancySet.getFirst(), SANTA_CHESTPLATE);
        smithing(color_template, List.of(SENG_FUR_HELMET), fancySet.getFirst(), SANTA_HELMET);
        smithingColorFamily(color_template, ender_sword);
        smithingColorFamily(color_template, divine_sword);
        smithingColorFamily(color_template, ENDER_HELMET);
        smithingColorFamily(color_template, ENDER_CHESTPLATE);
        smithingColorFamily(color_template, ENDER_LEGGINGS);
        smithingColorFamily(color_template, ENDER_BOOTS);
        smithingColorFamily(color_template, RUPEE_HELMET);
        smithingColorFamily(color_template, RUPEE_CHESTPLATE);
        smithingColorFamily(color_template, RUPEE_LEGGINGS);
        smithingColorFamily(color_template, RUPEE_BOOTS);
        // EXTRACTING
        extracting(arcaniteStoneSet.getFirst().asItem(), BUILDING_BLOCKS, arcaniteSand.asItem(), .1F, 20);
        extracting(arcaniumRichSand.asItem(), piece_of_raw_arcanium, .1F, 20);
        extracting(rawArcanium.asItem(), arcanium, 1, 100);
        // MAUL SMASHING
        // Dusts
        maulSmashing(List.of(ORES_REALMITE.item(), RAW_MATERIALS_REALMITE, INGOTS_REALMITE), realmite_dust, 1);
        maulSmashing(List.of(ORES_ARLEMITE.item(), RAW_MATERIALS_ARLEMITE, INGOTS_ARLEMITE), arlemite_dust, 1);
        maulSmashing(List.of(ORES_RUPEE.item(), RAW_MATERIALS_RUPEE, INGOTS_RUPEE), rupee_dust, 1);
        maulSmashing(List.of(ORES_BLOODGEM.item(), GEMS_BLOODGEM), bloodgem_dust, 1);
        maulSmashing(List.of(ORES_TORRIDITE.item(), RAW_MATERIALS_TORRIDITE, INGOTS_TORRIDITE), torridite_dust, 1);
        maulSmashing(List.of(ORES_OXDRITE.item(), RAW_MATERIALS_OXDRITE, INGOTS_OXDRITE), oxdrite_dust, 1);
        maulSmashing(List.of(ORES_EDEN.item(), FRAGMENTS_EDEN), eden_dust, 1);
        maulSmashing(List.of(ORES_WILDWOOD.item(), FRAGMENTS_WILDWOOD), wildwood_dust, 1);
        maulSmashing(List.of(ORES_APALACHIA.item(), FRAGMENTS_APALACHIA), apalachia_dust, 1);
        maulSmashing(List.of(ORES_SKYTHERN.item(), FRAGMENTS_SKYTHERN), skythern_dust, 1);
        maulSmashing(List.of(ORES_MORTUM.item(), FRAGMENTS_MORTUM), mortum_dust, 1);
        // Misc
        maulSmashing(List.of(INGOTS_SHADOW), shadow_coins, 2);
        maulSmashing(List.of(GEMS_SHADOW), bedrock_chunk, 1, BEDROCK_GRINDING_BASE);
        // FIRE CONVERTING // TODO (also they don't really work)
        fireConverting(divineFlame, Ingredient.of(eden_soul, eden_heart), new BlockMatchTest(FIRE), builder -> builder.outputState(new SimpleStateProvider(divineFlame.get().defaultBlockState())).advancement(fromNamespaceAndPath(MODID, "divine/the_link"), "create_divine_flame").frame(new BlockMatchTest(edenBlock.get())).portal(new SimpleStateProvider(edenPortal.get().defaultBlockState())), "has_eden_soul", this.has(eden_soul));
        fireConverting(enchantedFlame, HEARTS_WILDWOOD, new BlockMatchTest(wildFlame.get()), builder -> builder.outputState(new SimpleStateProvider(enchantedFlame.get().defaultBlockState())).advancement(fromNamespaceAndPath(MODID, "twilight/magical_incineration"), "create_enchanted_flame").frame(new BlockMatchTest(apalachiaBlock.get())).portal(new SimpleStateProvider(apalachiaPortal.get().defaultBlockState())), "has_wildwood_heart", has(HEARTS_WILDWOOD));
        // INFUSING
        // Backswords
        infusing(List.of(LUMPS_TEAKER), 4, backsword_template, teaker_backsword);
        infusing(List.of(LUMPS_AMTHIRMIS), 5, backsword_template, amthirmis_backsword);
        infusing(List.of(LUMPS_DARVEN), 6, backsword_template, darven_backsword);
        infusing(List.of(LUMPS_CERMILE), 8, backsword_template, cermile_backsword);
        infusing(List.of(LUMPS_PARDIMAL), 11, backsword_template, pardimal_backsword);
        infusing(List.of(LUMPS_QUADROTIC), 13, backsword_template, quadrotic_backsword);
        infusing(List.of(LUMPS_KAROS), 18, backsword_template, karos_backsword);
        infusing(List.of(LUMPS_HELIOSIS), 20, backsword_template, heliosis_backsword);
        infusing(List.of(LUMPS_ARKSIANE), 24, backsword_template, arksiane_backsword);
        // Claws
        infusing(List.of(LUMPS_TEAKER), 2, claw_template, teaker_claw);
        infusing(List.of(LUMPS_AMTHIRMIS), 3, claw_template, amthirmis_claw);
        infusing(List.of(LUMPS_DARVEN), 4, claw_template, darven_claw);
        infusing(List.of(LUMPS_CERMILE), 6, claw_template, cermile_claw);
        infusing(List.of(LUMPS_PARDIMAL), 8, claw_template, pardimal_claw);
        infusing(List.of(LUMPS_QUADROTIC), 10, claw_template, quadrotic_claw);
        infusing(List.of(LUMPS_KAROS), 16, claw_template, karos_claw);
        infusing(List.of(LUMPS_HELIOSIS), 17, claw_template, heliosis_claw);
        infusing(List.of(LUMPS_ARKSIANE), 21, claw_template, arksiane_claw);
        // Hammers
        infusing(List.of(LUMPS_TEAKER), 7, hammer_template, teaker_hammer);
        infusing(List.of(LUMPS_AMTHIRMIS), 9, hammer_template, amthirmis_hammer);
        infusing(List.of(LUMPS_DARVEN), 11, hammer_template, darven_hammer);
        infusing(List.of(LUMPS_CERMILE), 14, hammer_template, cermile_hammer);
        infusing(List.of(LUMPS_PARDIMAL), 17, hammer_template, pardimal_hammer);
        infusing(List.of(LUMPS_QUADROTIC), 19, hammer_template, quadrotic_hammer);
        infusing(List.of(LUMPS_KAROS), 22, hammer_template, karos_hammer);
        infusing(List.of(LUMPS_HELIOSIS), 27, hammer_template, heliosis_hammer);
        infusing(List.of(LUMPS_ARKSIANE), 31, hammer_template, arksiane_hammer);
        // Staves
        infusing(List.of(LUMPS_TEAKER), 2, staff_template, teaker_staff);
        infusing(List.of(LUMPS_AMTHIRMIS), 3, staff_template, amthirmis_staff);
        infusing(List.of(LUMPS_DARVEN), 4, staff_template, darven_staff);
        infusing(List.of(LUMPS_CERMILE), 6, staff_template, cermile_staff);
        infusing(List.of(LUMPS_PARDIMAL), 8, staff_template, pardimal_staff);
        infusing(List.of(LUMPS_QUADROTIC), 10, staff_template, quadrotic_staff);
        infusing(List.of(LUMPS_KAROS), 16, staff_template, karos_staff);
        infusing(List.of(LUMPS_HELIOSIS), 17, staff_template, heliosis_staff);
        infusing(List.of(LUMPS_ARKSIANE), 21, staff_template, arksiane_staff);
        // Cannons
        infusing(List.of(LUMPS_TEAKER), 7, cannon_template, teaker_cannon);
        infusing(List.of(LUMPS_AMTHIRMIS), 9, cannon_template, amthirmis_cannon);
        infusing(List.of(LUMPS_DARVEN), 11, cannon_template, darven_cannon);
        infusing(List.of(LUMPS_CERMILE), 14, cannon_template, cermile_cannon);
        infusing(List.of(LUMPS_PARDIMAL), 17, cannon_template, pardimal_cannon);
        infusing(List.of(LUMPS_QUADROTIC), 19, cannon_template, quadrotic_cannon);
        infusing(List.of(LUMPS_KAROS), 22, cannon_template, karos_cannon);
        infusing(List.of(LUMPS_HELIOSIS), 27, cannon_template, heliosis_cannon);
        infusing(List.of(LUMPS_ARKSIANE), 31, cannon_template, arksiane_cannon);
        // Bows
        infusing(List.of(LUMPS_TEAKER), 4, bow_template, teaker_bow);
        infusing(List.of(LUMPS_AMTHIRMIS), 5, bow_template, amthirmis_bow);
        infusing(List.of(LUMPS_DARVEN), 6, bow_template, darven_bow);
        infusing(List.of(LUMPS_CERMILE), 8, bow_template, cermile_bow);
        infusing(List.of(LUMPS_PARDIMAL), 11, bow_template, pardimal_bow);
        infusing(List.of(LUMPS_QUADROTIC), 13, bow_template, quadrotic_bow);
        infusing(List.of(LUMPS_KAROS), 18, bow_template, karos_bow);
        infusing(List.of(LUMPS_HELIOSIS), 20, bow_template, heliosis_bow);
        infusing(List.of(LUMPS_ARKSIANE), 24, bow_template, arksiane_bow);
        // Disks
        infusing(List.of(LUMPS_TEAKER), 4, disk_template, teaker_disk);
        infusing(List.of(LUMPS_AMTHIRMIS), 5, disk_template, amthirmis_disk);
        infusing(List.of(LUMPS_DARVEN), 6, disk_template, darven_disk);
        infusing(List.of(LUMPS_CERMILE), 8, disk_template, cermile_disk);
        infusing(List.of(LUMPS_PARDIMAL), 11, disk_template, pardimal_disk);
        infusing(List.of(LUMPS_QUADROTIC), 13, disk_template, quadrotic_disk);
        infusing(List.of(LUMPS_KAROS), 18, disk_template, karos_disk);
        infusing(List.of(LUMPS_HELIOSIS), 20, disk_template, heliosis_disk);
        infusing(List.of(LUMPS_ARKSIANE), 24, disk_template, arksiane_disk);
        // Dissipators
        infusing(List.of(LUMPS_TEAKER), 4, dissipator_template, teaker_dissipator);
        infusing(List.of(LUMPS_AMTHIRMIS), 5, dissipator_template, amthirmis_dissipator);
        infusing(List.of(LUMPS_DARVEN), 6, dissipator_template, darven_dissipator);
        infusing(List.of(LUMPS_CERMILE), 8, dissipator_template, cermile_dissipator);
        infusing(List.of(LUMPS_PARDIMAL), 11, dissipator_template, pardimal_dissipator);
        infusing(List.of(LUMPS_QUADROTIC), 13, dissipator_template, quadrotic_dissipator);
        infusing(List.of(LUMPS_KAROS), 18, dissipator_template, karos_dissipator);
        infusing(List.of(LUMPS_HELIOSIS), 20, dissipator_template, heliosis_dissipator);
        infusing(List.of(LUMPS_ARKSIANE), 24, dissipator_template, arksiane_dissipator);
        // Armors
        infusing(List.of(LUMPS_TEAKER), 7, degraded_template, DEGRADED_HELMET);
        infusing(List.of(LUMPS_TEAKER), 8, degraded_template, DEGRADED_HOOD);
        infusing(List.of(LUMPS_TEAKER), 6, degraded_template, DEGRADED_MASK);
        infusing(List.of(LUMPS_TEAKER), 10, degraded_template, DEGRADED_CHESTPLATE);
        infusing(List.of(LUMPS_TEAKER), 9, degraded_template, DEGRADED_LEGGINGS);
        infusing(List.of(LUMPS_TEAKER), 5, degraded_template, DEGRADED_BOOTS);
        infusing(List.of(LUMPS_AMTHIRMIS), 10, finished_template, FINISHED_HELMET);
        infusing(List.of(LUMPS_AMTHIRMIS), 11, finished_template, FINISHED_HOOD);
        infusing(List.of(LUMPS_AMTHIRMIS), 9, finished_template, FINISHED_MASK);
        infusing(List.of(LUMPS_AMTHIRMIS), 14, finished_template, FINISHED_CHESTPLATE);
        infusing(List.of(LUMPS_AMTHIRMIS), 12, finished_template, FINISHED_LEGGINGS);
        infusing(List.of(LUMPS_AMTHIRMIS), 8, finished_template, FINISHED_BOOTS);
        infusing(List.of(LUMPS_DARVEN), 10, glistening_template, GLISTENING_HELMET);
        infusing(List.of(LUMPS_DARVEN), 11, glistening_template, GLISTENING_HOOD);
        infusing(List.of(LUMPS_DARVEN), 9, glistening_template, GLISTENING_MASK);
        infusing(List.of(LUMPS_DARVEN), 14, glistening_template, GLISTENING_CHESTPLATE);
        infusing(List.of(LUMPS_DARVEN), 12, glistening_template, GLISTENING_LEGGINGS);
        infusing(List.of(LUMPS_DARVEN), 8, glistening_template, GLISTENING_BOOTS);
        infusing(List.of(LUMPS_CERMILE), 10, demonized_template, DEMONIZED_HELMET);
        infusing(List.of(LUMPS_CERMILE), 11, demonized_template, DEMONIZED_HOOD);
        infusing(List.of(LUMPS_CERMILE), 9, demonized_template, DEMONIZED_MASK);
        infusing(List.of(LUMPS_CERMILE), 14, demonized_template, DEMONIZED_CHESTPLATE);
        infusing(List.of(LUMPS_CERMILE), 12, demonized_template, DEMONIZED_LEGGINGS);
        infusing(List.of(LUMPS_CERMILE), 8, demonized_template, DEMONIZED_BOOTS);
        infusing(List.of(LUMPS_PARDIMAL), 10, tormented_template, TORMENTED_HELMET);
        infusing(List.of(LUMPS_PARDIMAL), 11, tormented_template, TORMENTED_HOOD);
        infusing(List.of(LUMPS_PARDIMAL), 9, tormented_template, TORMENTED_MASK);
        infusing(List.of(LUMPS_PARDIMAL), 14, tormented_template, TORMENTED_CHESTPLATE);
        infusing(List.of(LUMPS_PARDIMAL), 12, tormented_template, TORMENTED_LEGGINGS);
        infusing(List.of(LUMPS_PARDIMAL), 8, tormented_template, TORMENTED_BOOTS);
        // COMPAT // TODO
        // CREATE
        // Blasting and smelting
        blastingSet(List.of(crushed_raw_realmite), realmite_ingot, .1F, new ModLoadedCondition("create"));
        blastingSet(List.of(crushed_raw_arlemite), arlemite_ingot, .1F, new ModLoadedCondition("create"));
        blastingSet(List.of(crushed_raw_rupee), rupee_ingot, .1F, new ModLoadedCondition("create"));
        blastingSet(List.of(crushed_raw_torridite), torridite_ingot, .1F, new ModLoadedCondition("create"));
        blastingSet(List.of(crushed_raw_oxdrite), oxdrite_ingot, .1F, new ModLoadedCondition("create"));
        // Maul smashing
        maulSmashing(List.of(crushed_raw_realmite), realmite_dust, 1, new ModLoadedCondition("create"));
        maulSmashing(List.of(crushed_raw_arlemite), arlemite_dust, 1, new ModLoadedCondition("create"));
        maulSmashing(List.of(crushed_raw_rupee), rupee_dust, 1, new ModLoadedCondition("create"));
        maulSmashing(List.of(crushed_raw_torridite), torridite_dust, 1, new ModLoadedCondition("create"));
        maulSmashing(List.of(crushed_raw_oxdrite), oxdrite_dust, 1, new ModLoadedCondition("create"));
    }
    private static String getTagBaseName(TagKey<?> tag) {
        String path = tag.location().getPath();
        return path.contains("/") ? path.substring(path.lastIndexOf('/') + 1) : path;
    }
    private static String getTagName(TagKey<?> tag) {
        String path = tag.location().getPath();
        if(!path.contains("/")) return path;
        int slashIdx = path.lastIndexOf('/');
        return path.substring(slashIdx + 1) + "_" + path.substring(0, slashIdx).replace('/', '_');
    }
    @Override protected void generateRecipes(BlockFamily family, FeatureFlagSet flagSet) {
        super.generateRecipes(family, flagSet);
        if(family.shouldGenerateStonecutterRecipe()) {
            family.getVariants().forEach((variant, result) -> {
                if(result.requiredFeatures().isSubsetOf(flagSet)) generateStonecutterRecipe(family, variant, family.getBaseBlock());
            });
        }
    }
    // SHAPED CRAFTING
    private record RecipeSpec(RecipeCategory category, List<String> pattern) {}
    protected void equipment(TagKey<Item> material) {
        String baseName = getTagBaseName(material);
        String tagName = getTagName(material);
        Set<String> armorSuffixes = Set.of("_helmet", "_chestplate", "_leggings", "_boots");
        Map<String, RecipeSpec> recipes = Map.ofEntries(
            // Tools
            Map.entry("_pickaxe",    new RecipeSpec(TOOLS, List.of("XXX", " # ", " # "))),
            Map.entry("_axe",        new RecipeSpec(TOOLS, List.of("XX", "X#", " #"))),
            Map.entry("_shovel",     new RecipeSpec(TOOLS, List.of("X", "#", "#"))),
            Map.entry("_hoe",        new RecipeSpec(TOOLS, List.of("XX", " #", " #"))),
            // Weapons
            Map.entry("_dagger",     new RecipeSpec(COMBAT, List.of("X", "#"))),
            Map.entry("_knife",      new RecipeSpec(COMBAT, List.of("X", "X", "#"))),
            Map.entry("_stabber",    new RecipeSpec(COMBAT, List.of("X", "X", "#"))),
            Map.entry("_sword",      new RecipeSpec(COMBAT, List.of("X", "X", "#"))),
            Map.entry("_maul",       new RecipeSpec(COMBAT, List.of("XXX", "X#X", " # "))),
            // Armor
            Map.entry("_helmet",     new RecipeSpec(COMBAT, List.of("XXX", "X X"))),
            Map.entry("_chestplate", new RecipeSpec(COMBAT, List.of("X X", "XXX", "XXX"))),
            Map.entry("_leggings",   new RecipeSpec(COMBAT, List.of("XXX", "X X", "X X"))),
            Map.entry("_boots",      new RecipeSpec(COMBAT, List.of("X X", "X X")))
        );
        recipes.forEach((suffix, spec) -> {
            if(baseName.equals("arlemite") && armorSuffixes.contains(suffix)) return;
            Identifier itemId = Identifier.fromNamespaceAndPath(MODID, baseName + suffix);
            ITEM.getOptional(itemId).ifPresent(item -> {
                var builder = shaped(spec.category(), item).define('X', material).unlockedBy("has_" + tagName, has(material));
                boolean needsSticks = spec.pattern().stream().anyMatch(row -> row.contains("#"));
                if(needsSticks) builder.define('#', RODS_WOODEN);
                spec.pattern().forEach(builder::pattern);
                builder.save(output);
            });
        });
    }
    protected void storageBlocks(ItemLike material, boolean reversibleBlock) {
        String materialName = ITEM.getKey(material.asItem()).getPath();
        int underscoreIdx = materialName.lastIndexOf('_');
        String baseName = materialName.startsWith("raw_") || underscoreIdx == -1 ? materialName : materialName.substring(0, underscoreIdx);
        ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, baseName + "_block")).ifPresent(block -> {
            String blockName = ITEM.getKey(block).getPath();
            shaped(BUILDING_BLOCKS, block).define('X', material)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX").unlockedBy("has_" + materialName, has(material)).save(output);
            if(reversibleBlock) shapeless(MISC, material, 9).requires(block).unlockedBy("has_" + blockName, has(block)).save(output, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, materialName + "_from_" + blockName)));
        });
        List.of("_nugget", "_shards").forEach(suffix -> ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, baseName + suffix)).ifPresent(piece -> {
            String pieceName = ITEM.getKey(piece).getPath();
            shaped(MISC, material).define('X', piece)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX").unlockedBy("has_" + pieceName, has(piece)).save(output, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, materialName + "_from_" + pieceName)));
            if(suffix.equals("_nugget")) shapeless(MISC, piece, 9).requires(material).unlockedBy("has_" + materialName, has(material)).save(output);
        }));
    }
    protected void storageBlocks(ItemLike material) {
        storageBlocks(material, true);
    }
    protected void woodSetFromLogs(List<? extends ItemLike> woodSet) {
        for(ItemLike entry : woodSet) {
            String path = ITEM.getKey(entry.asItem()).getPath();
            if(path.endsWith("_planks")) {
                String woodName = path.substring(0, path.length() - "_planks".length());
                TagKey<Item> logsTag = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "logs/" + woodName));
                planksFromLogs(entry, logsTag, 4);
            } else if(path.endsWith("_wood")) {
                String logPath = path.replace("_wood", "_log");
                ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, logPath)).ifPresent(log -> woodFromLogs(entry, log));
            } else if(path.endsWith("_ladder")) {
                String planksPath = path.replace("_ladder", "_planks");
                ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, planksPath)).ifPresent(planks ->
                    shaped(DECORATIONS, entry, 4)
                        .pattern("# #")
                        .pattern("#P#")
                        .pattern("# #").define('#', RODS_WOODEN).define('P', planks).unlockedBy(getHasName(planks), has(planks)).save(output));
            }
        }
    }
    protected void twilightSet(TagKey<Item> gem) {
        ItemLike baseBrick = twilightBrickSet.getFirst();
        String baseName = getTagBaseName(gem);
        String gemTagName = getTagName(gem);
        TagKey<Item> soul = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(gem.location().getNamespace(), "souls/" + baseName));
        ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, baseName + "_bricks")).ifPresent(bricks ->
            shapeless(BUILDING_BLOCKS, bricks, 4).requires(baseBrick, 4).requires(gem).group(getItemName(baseBrick)).unlockedBy("has_" + gemTagName, has(gem)).save(output)
        );
        ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, baseName + "_slicer")).ifPresent(slicer ->
            shapeless(COMBAT, slicer, 20).requires(gem).unlockedBy("has_" + gemTagName, has(gem)).save(output)
        );
        ITEM.getOptional(Identifier.fromNamespaceAndPath(MODID, baseName + "_fragments")).ifPresent(fragments ->
            shapeless(MISC, fragments).requires(soul).group("twilight_fragments").unlockedBy("has_" + getTagName(soul), has(soul)).save(output)
        );
    }
    // STONECUTTING
    // From block families
    private void generateStonecutterRecipe(BlockFamily family, BlockFamily.Variant variant, Block base) {
        Block result = family.get(variant);
        int count = (variant == SLAB) ? 2 : 1;
        if(base == ModBlockFamilies.OXDRITE.getBaseBlock()) count *= 4;
        switch(variant) {
            case SLAB, STAIRS, WALL, CHISELED, POLISHED, CUT, BRICKS, TILES, PILLAR -> {
                String recipeName = getItemName(result) + "_from_" + getItemName(base) + "_stonecutting";
                ResourceKey<Recipe<?>> key = ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName));
                SingleItemRecipeBuilder.stonecutting(Ingredient.of(base), BUILDING_BLOCKS, result, count).unlockedBy(getHasName(base), has(base)).save(output, key);
            } default -> {}
        } if(variant == POLISHED || variant == CUT || variant == BRICKS || variant == TILES || variant == PILLAR || variant == COBBLED) {
            BlockFamily childVariantFamily = ModBlockFamilies.getFamily(result);
            if(childVariantFamily != null) childVariantFamily.getVariants().forEach((childVariant, r) -> generateStonecutterRecipe(childVariantFamily, childVariant, base));
        }
    }
    @Override protected void generateForEnabledBlockFamilies(FeatureFlagSet flagSet) {
        ModBlockFamilies.getAllFamilies().forEach((family) -> generateRecipes(family, flagSet));
    }
    // Fully custom
    protected void stonecutting(ItemLike input, RecipeCategory category, ItemLike result, int count) {
        String recipeName = getConversionRecipeName(result, input) + "_stonecutting";
        ResourceKey<Recipe<?>> key = ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, result, count).unlockedBy(getHasName(input), has(input)).save(output, key);
    }
    // Default all
    protected void stonecutting(ItemLike input, ItemLike result) {
        stonecutting(input, BUILDING_BLOCKS, result, 1);
    }
    // FURNACES
    private static CookingBookCategory cookingBookCategory(RecipeCategory category, ItemLike result) {
        if(category == FOOD) return CookingBookCategory.FOOD;
        return result.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
    }
    protected <T extends AbstractCookingRecipe> void cooking(AbstractCookingRecipe.Factory<T> factory, List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, String prefix, ICondition... conditions) {
        RecipeOutput conditionalOutput = conditions.length > 0 ? output.withConditions(conditions) : output;
        for(Object input : inputs) {
            if(input instanceof ItemLike item) {
                String recipeName = prefix + "_" + getItemName(item);
                SimpleCookingRecipeBuilder.generic(Ingredient.of(item), category, cookingBookCategory(category, result), result, experience, cookingTime, factory).group(getItemName(result)).unlockedBy(getHasName(item), has(item)).save(conditionalOutput, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName)));
            } else if(input instanceof TagKey<?> rawTag) {
                @SuppressWarnings("unchecked")
                TagKey<Item> tag = (TagKey<Item>) rawTag;
                String tagName = getTagName(tag);
                String recipeName = prefix + "_" + tagName;
                HolderSet<Item> tagHolderSet = items.getOrThrow(tag);
                SimpleCookingRecipeBuilder.generic(Ingredient.of(tagHolderSet), category, cookingBookCategory(category, result), result, experience, cookingTime, factory).group(getItemName(result)).unlockedBy("has_" + tagName, has(tag)).save(conditionalOutput, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName)));
            }
        }
    }
    // SMELTING
    // Fully custom
    protected void smelting(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        cooking(SmeltingRecipe::new, inputs, category, result, experience, cookingTime, getSmeltingRecipeName(result), conditions);
    }
    // Custom cooking time
    protected void smelting(List<Object> inputs, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        smelting(inputs, BUILDING_BLOCKS, result, experience, cookingTime, conditions);
    }
    // Default all
    protected void smelting(List<Object> inputs, ItemLike result, float experience, ICondition... conditions) {
        smelting(inputs, result, experience, 200, conditions);
    }
    // BLASTING + SMELTING
    // Fully custom
    protected void blastingSet(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        cooking(BlastingRecipe::new, inputs, category, result, experience, cookingTime, getBlastingRecipeName(result), conditions);
        cooking(SmeltingRecipe::new, inputs, category, result, experience, cookingTime * 2, getSmeltingRecipeName(result), conditions);
    }
    // Custom recipe category
    protected void blastingSet(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, ICondition... conditions) {
        blastingSet(inputs, category, result, experience, 100, conditions);
    }
    // Custom cooking time
    protected void blastingSet(List<Object> inputs, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        blastingSet(inputs, MISC, result, experience, cookingTime, conditions);
    }
    // Default all
    protected void blastingSet(List<Object> inputs, ItemLike result, float experience, ICondition... conditions) {
        blastingSet(inputs, result, experience, 100, conditions);
    }
    // BLASTING
    // Fully custom
    protected void blasting(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        cooking(BlastingRecipe::new, inputs, category, result, experience, cookingTime, getBlastingRecipeName(result), conditions);
    }
    // Custom cooking time
    protected void blasting(List<Object> inputs, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        blasting(inputs, MISC, result, experience, cookingTime, conditions);
    }
    // Default all
    protected void blasting(List<Object> inputs, ItemLike result, float experience, ICondition... conditions) {
        blasting(inputs, result, experience, 100, conditions);
    }
    // SMOKING + SMELTING + CAMPFIRE COOKING
    // Fully custom
    protected void smokingSet(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        cooking(SmokingRecipe::new, inputs, category, result, experience, cookingTime, getItemName(result) + "_from_smoking", conditions);
        cooking(SmeltingRecipe::new, inputs, category, result, experience, cookingTime * 2, getSmeltingRecipeName(result), conditions);
        cooking(CampfireCookingRecipe::new, inputs, category, result, experience, cookingTime * 6, getItemName(result) + "_from_campfire_cooking", conditions);
    }
    // Custom cooking time
    protected void smokingSet(List<Object> inputs, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        smokingSet(inputs, FOOD, result, experience, cookingTime, conditions);
    }
    // Default all
    protected void smokingSet(List<Object> inputs, ItemLike result, float experience, ICondition... conditions) {
        smokingSet(inputs, result, experience, 100, conditions);
    }
    // SMOKING
    // Fully custom
    protected void smoking(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        cooking(SmokingRecipe::new, inputs, category, result, experience, cookingTime, getItemName(result) + "_from_smoking", conditions);
    }
    // Custom cooking time
    protected void smoking(List<Object> inputs, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        smoking(inputs, FOOD, result, experience, cookingTime, conditions);
    }
    // Default all
    protected void smoking(List<Object> inputs, ItemLike result, float experience, ICondition... conditions) {
        smoking(inputs, result, experience, 100, conditions);
    }
    // CAMPFIRE COOKING
    // Fully custom
    protected void campfireCooking(List<Object> inputs, RecipeCategory category, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        cooking(CampfireCookingRecipe::new, inputs, category, result, experience, cookingTime, getItemName(result) + "_from_campfire_cooking", conditions);
    }
    // Custom cooking time
    protected void campfireCooking(List<Object> inputs, ItemLike result, float experience, int cookingTime, ICondition... conditions) {
        campfireCooking(inputs, FOOD, result, experience, cookingTime, conditions);
    }
    // Default all
    protected void campfireCooking(List<Object> inputs, ItemLike result, float experience, ICondition... conditions) {
        campfireCooking(inputs, result, experience, 600, conditions);
    }
    // SMITHING
    // Custom recipe category
    protected void smithing(ItemLike template, List<ItemLike> baseItems, Object material, RecipeCategory category, ItemLike result) {
        Ingredient baseIngredient = Ingredient.of(baseItems.toArray(ItemLike[]::new));
        Ingredient catalystIngredient = material instanceof TagKey<?> tag
            ? Ingredient.of(items.getOrThrow(tag.cast(Registries.ITEM).orElseThrow()))
            : Ingredient.of((ItemLike) material);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), baseIngredient, catalystIngredient, category, result.asItem())
            .unlocks("has_" + getItemName(template), has(template))
            .save(output, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, getItemName(result) + "_smithing")));
    }
    // Combat
    protected void smithing(ItemLike template, List<ItemLike> baseItems, Object material, ItemLike result) {
        smithing(template, baseItems, material, COMBAT, result);
    }
    // Custom recipe category
    protected void smithingColorFamily(ItemLike template, ItemLike baseItem, RecipeCategory category) {
        Identifier baseId = ITEM.getKey(baseItem.asItem());
        String ns = baseId.getNamespace();
        String basePath = baseId.getPath();
        ItemLike grayVariant = baseItem == ender_sword ? black_ender_sword : ITEM.getValue(Identifier.fromNamespaceAndPath(ns, "gray_" + basePath));
        List<Map.Entry<Object, ItemLike>> variants = List.of(
            Map.entry(DIAMOND_NO_CHUNKS, baseItem),
            Map.entry(CHUNKS_DIAMOND_GRAY, grayVariant),
            Map.entry(CHUNKS_DIAMOND_RED, ITEM.getValue(Identifier.fromNamespaceAndPath(ns, "red_" + basePath))),
            Map.entry(CHUNKS_DIAMOND_YELLOW, ITEM.getValue(Identifier.fromNamespaceAndPath(ns, "yellow_" + basePath))),
            Map.entry(CHUNKS_DIAMOND_GREEN, ITEM.getValue(Identifier.fromNamespaceAndPath(ns, "green_" + basePath))),
            Map.entry(CHUNKS_DIAMOND_BLUE, ITEM.getValue(Identifier.fromNamespaceAndPath(ns, "blue_" + basePath)))
        );
        var allItems = variants.stream().map(Map.Entry::getValue).toList();
        for(var entry : variants) {
            var others = allItems.stream().filter(i -> i != entry.getValue()).toList();
            smithing(template, others, entry.getKey(), category, entry.getValue());
        }
    }
    // Combat
    protected void smithingColorFamily(ItemLike template, ItemLike baseItem) {
        smithingColorFamily(template, baseItem, COMBAT);
    }
    // ARCANIUM EXTRACTION
    // Fully custom
    protected void extracting(ItemLike input, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        ArcaniumExtractorRecipeBuilder.extraction(Ingredient.of(input), category, result, experience, cookingTime)
            .unlockedBy(getHasName(input), has(input))
            .save(output, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, getItemName(result) + "_from_" + getItemName(input) + "_extracting")));
    }
    // Custom cooking time
    protected void extracting(ItemLike input, ItemLike result, float experience, int cookingTime) {
        extracting(input, MISC, result, experience, cookingTime);
    }
    // MAUL SMASHING
    // Fully custom
    protected void maulSmashing(List<Object> inputs, RecipeCategory category, ItemLike result, int count, @Nullable TagKey<Block> requiredBaseBlockTag, ICondition... conditions) {
        RecipeOutput conditionalOutput = conditions.length > 0 ? output.withConditions(conditions) : output;
        for(Object input : inputs) {
            if(input instanceof ItemLike item) {
                String recipeName = getItemName(result) + "_from_" + getItemName(item) + "_maul_smashing";
                MaulSmashingRecipeBuilder.smashing(Ingredient.of(item), category, result, count, requiredBaseBlockTag).unlockedBy(getHasName(item), has(item)).save(conditionalOutput, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName)));
            } else if(input instanceof TagKey<?> rawTag) {
                @SuppressWarnings("unchecked")
                TagKey<Item> tag = (TagKey<Item>) rawTag;
                String tagName = getTagName(tag);
                String recipeName = getItemName(result) + "_from_" + tagName + "_maul_smashing";
                MaulSmashingRecipeBuilder.smashing(Ingredient.of(items.getOrThrow(tag)), category, result, count, requiredBaseBlockTag).unlockedBy("has_" + tagName, has(tag)).save(conditionalOutput, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName)));
            }
        }
    }
    // Custom base block
    protected void maulSmashing(List<Object> inputs, ItemLike result, int count, @Nullable TagKey<Block> requiredBaseBlockTag, ICondition... conditions) {
        maulSmashing(inputs, MISC, result, count, requiredBaseBlockTag, conditions);
    }
    // Default all
    protected void maulSmashing(List<Object> inputs, ItemLike result, int count, ICondition... conditions) {
        maulSmashing(inputs, result, count, null, conditions);
    }
    // FIRE CONVERTING
    protected void fireConverting(ItemLike output, Ingredient inputItem, RuleTest inputState, Consumer<FireConversionRecipeBuilder> configurator, String unlockCriterionName, Criterion<?> unlockCriterion) {
        fireConverting("", output, inputItem, inputState, configurator, unlockCriterionName, unlockCriterion);
    }
    protected void fireConverting(String subfolder, ItemLike result, Ingredient inputItem, RuleTest inputState, Consumer<FireConversionRecipeBuilder> configurator, String unlockCriterionName, Criterion<?> unlockCriterion) {
        String fileName = getItemName(result);
        String path = subfolder.isEmpty() ? "fire_conversion/" + fileName : "fire_conversion/" + subfolder + "/" + fileName;
        ResourceKey<Recipe<?>> recipeKey = ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, path));
        FireConversionRecipeBuilder builder = FireConversionRecipeBuilder.conversion(inputItem, inputState).unlockedBy(unlockCriterionName, unlockCriterion);
        configurator.accept(builder);
        builder.save(output, recipeKey);
    }
    protected void fireConverting(ItemLike output, TagKey<Item> inputTag, RuleTest inputState, Consumer<FireConversionRecipeBuilder> configurator, String unlockCriterionName, Criterion<?> unlockCriterion) {
        fireConverting("", output, inputTag, inputState, configurator, unlockCriterionName, unlockCriterion);
    }
    protected void fireConverting(String subfolder, ItemLike output, TagKey<Item> inputTag, RuleTest inputState, Consumer<FireConversionRecipeBuilder> configurator, String unlockCriterionName, Criterion<?> unlockCriterion) {
        String fileName = getItemName(output);
        String path = subfolder.isEmpty() ? "fire_conversion/" + fileName : "fire_conversion/" + subfolder + "/" + fileName;
        ResourceKey<Recipe<?>> recipeKey = ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, path));
        HolderSet<Item> tagHolderSet = items.get(inputTag).orElseThrow();
        Ingredient inputItem = Ingredient.of(tagHolderSet);
        FireConversionRecipeBuilder builder = FireConversionRecipeBuilder.conversion(inputItem, inputState).unlockedBy(unlockCriterionName, unlockCriterion);
        configurator.accept(builder);
        builder.save(this.output, recipeKey);
    }
    // INFUSING
    // Fully custom
    protected void infusing(List<Object> inputs, int inputCount, RecipeCategory category, DeferredItem<Item> template, ItemLike result, int resultCount, ICondition... conditions) {
        RecipeOutput conditionalOutput = conditions.length > 0 ? output.withConditions(conditions) : output;
        for(Object input : inputs) {
            if(input instanceof ItemLike item) {
                String recipeName = getItemName(result) + "_from_" + getItemName(item) + "_infusing";
                InfusionTableRecipeBuilder.infusion(Ingredient.of(item), inputCount, category, Ingredient.of(template), result, resultCount).unlockedBy(getHasName(item), has(item)).save(conditionalOutput, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName)));
            } else if(input instanceof TagKey<?> rawTag) {
                @SuppressWarnings("unchecked")
                TagKey<Item> tag = (TagKey<Item>) rawTag;
                String tagName = getTagName(tag);
                String recipeName = getItemName(result) + "_from_" + tagName + "_infusing";
                InfusionTableRecipeBuilder.infusion(Ingredient.of(items.getOrThrow(tag)), inputCount, category, Ingredient.of(template), result, resultCount).unlockedBy("has_" + tagName, has(tag)).save(conditionalOutput, ResourceKey.create(RECIPE, fromNamespaceAndPath(MODID, recipeName)));
            }
        }
    }
    // Default all
    protected void infusing(List<Object> inputs, int inputCount, DeferredItem<Item> template, ItemLike result, ICondition... conditions) {
        infusing(inputs, inputCount, COMBAT, template, result, 1, conditions);
    }
}