package divinerpg.data;

import divinerpg.recipe.builder.MaulSmashingRecipeBuilder;
import divinerpg.registries.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.List;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.data.recipes.SingleItemRecipeBuilder.stonecutting;
import static net.minecraft.data.recipes.SmithingTransformRecipeBuilder.smithing;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        blasting(List.of(BlockRegistry.anthraciteOre.get()), ItemRegistry.anthracite.get(), 0.1f);
        blasting(List.of(BlockRegistry.apalachiaOre.get()), ItemRegistry.apalachia_fragments.get(), 1.f);
        blasting(TagRegistry.SMELTABLE_APALACHIA, ItemRegistry.apalachia_fragments, 0.1F);
        blasting(List.of(ItemRegistry.pure_aquatic_pellets), ItemRegistry.aquatic_ingot.get(), 1.3f);
        blasting(List.of(BlockRegistry.arlemiteOre.get(), ItemRegistry.raw_arlemite.get(), ItemRegistry.arlemite_dust), ItemRegistry.arlemite_ingot.get(), 0.7f);
        blasting(TagRegistry.SMELTABLE_ARLEMITE, ItemRegistry.arlemite_nugget.get(), 0.1f);
        blasting(List.of(BlockRegistry.bloodgemOre), ItemRegistry.bloodgem.get(), 1.2f);
        blasting(TagRegistry.SMELTABLE_CORRUPTED, ItemRegistry.corrupted_shards.get(), 0.1f);
        blasting(TagRegistry.SMELTABLE_DIVINE, ItemRegistry.divine_shards.get(), 0.1f);
        blasting(TagRegistry.SMELTABLE_EDEN, ItemRegistry.eden_fragments.get(), 0.1f);
        blasting(List.of(BlockRegistry.scorchaltEdenOre, BlockRegistry.twilightEdenOre), ItemRegistry.eden_fragments.get(), 0.7f);
        blasting(List.of(ItemRegistry.eden_dust), ItemRegistry.eden_sparkles, 0.35F);
        blasting(TagRegistry.SMELTABLE_ENDER, ItemRegistry.ender_shards.get(), 0.1f);
        blasting(TagRegistry.SMELTABLE_GOLD_COMPRESSED, Items.GOLD_INGOT, 1f);
        blasting(List.of(BlockRegistry.coldHellfireSponge), BlockRegistry.hellfireSponge, 0.1f);
        blasting(TagRegistry.SMELTABLE_ICE, ItemRegistry.ice_shards, 0.1f);
        blasting(TagRegistry.SMELTABLE_JUNGLE, ItemRegistry.jungle_shards, 0.1f);
        blasting(TagRegistry.SMELTABLE_MOLTEN, ItemRegistry.molten_shards, 0.1f);
        blasting(List.of(BlockRegistry.mortumOre), ItemRegistry.mortum_fragments, 2);
        blasting(TagRegistry.SMELTABLE_MORTUM, ItemRegistry.mortum_fragments, 0.1f);
        blasting(List.of(BlockRegistry.oxdriteOre, ItemRegistry.oxdrite_dust, ItemRegistry.raw_oxdrite), ItemRegistry.oxdrite_ingot.get(), 0.7f);
        blasting(TagRegistry.SMELTABLE_OXDRITE, ItemRegistry.oxdrite_nugget.get(), 0.1f);
        blasting(List.of(BlockRegistry.realmiteOre, BlockRegistry.realmiteOreDeepslate, ItemRegistry.realmite_dust, ItemRegistry.raw_realmite), ItemRegistry.realmite_ingot.get(), 0.7f);
        blasting(TagRegistry.SMELTABLE_REALMITE, ItemRegistry.realmite_nugget.get(), 0.1f);
        blasting(List.of(BlockRegistry.rupeeOre, BlockRegistry.rupeeOreDeepslate, ItemRegistry.rupee_dust, ItemRegistry.raw_rupee), ItemRegistry.rupee_ingot.get(), 0.7f);
        blasting(TagRegistry.SMELTABLE_RUPEE, ItemRegistry.rupee_nugget.get(), 0.1f);
        blasting(List.of(ItemRegistry.shadow_dust), ItemRegistry.shadow_bar.get(), 1f);
        blasting(List.of(BlockRegistry.skythernOre), ItemRegistry.skythern_fragments.get(), 1.7f);
        blasting(TagRegistry.SMELTABLE_SKYTHERN, ItemRegistry.skythern_fragments.get(), 0.1f);
        blasting(TagRegistry.SMELTABLE_TERRAN, ItemRegistry.terran_shards.get(), 0.1f);
        blasting(List.of(BlockRegistry.torriditeOre, ItemRegistry.torridite_dust, ItemRegistry.raw_torridite), ItemRegistry.torridite_ingot.get(), 0.7f);
        blasting(TagRegistry.SMELTABLE_TORRIDITE, ItemRegistry.torridite_nugget.get(), 0.1f);
        blasting(List.of(BlockRegistry.wildwoodOre), ItemRegistry.wildwood_fragments.get(), 1.7f);
        blasting(TagRegistry.SMELTABLE_WILDWOOD, ItemRegistry.wildwood_fragments.get(), 0.1f);

        campfire(ItemTags.create(Identifier.fromNamespaceAndPath("c", "eggs")), ItemRegistry.boiled_egg, 0.35F);
        campfire(List.of(ItemRegistry.frozen_clock), Items.CLOCK, 0.35F, 200);
        campfire(List.of(ItemRegistry.bacon), ItemRegistry.cooked_bacon, 0.35F, 300);
        campfire(List.of(ItemRegistry.raw_empowered_meat), ItemRegistry.empowered_meat, 0.35F);
        campfire(List.of(Items.PUMPKIN_PIE), ItemRegistry.hot_pumpkin_pie, 0.35F);
        campfire(List.of(ItemRegistry.raw_seng_meat), ItemRegistry.seng_steak, 0.35F);
        campfire(List.of(ItemRegistry.raw_wolpertinger_meat), ItemRegistry.wolpertinger_steak, 0.35F);

        //TODO - Compat

        //TODO - Extracting

        //TODO - Fire Conversion

        //TODO - Infusing

        shaped(RecipeCategory.COMBAT, ItemRegistry.ANGELIC_BOOTS.get()).pattern("I I").pattern("X X").define('X', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/shadow"))).define('I', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/soulfire"))).unlockedBy("has_shadow_gem", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/shadow")))).unlockedBy("has_soulfire_gem", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/soulfire")))).save(this.output, MODID + ":crafting_shaped/angelic_boots");
        //TODO - Finish shaped

        shapeless(RecipeCategory.FOOD, ItemRegistry.advanced_mushroom_stew.get()).requires(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "foods/white_mushroom"))).requires(Items.MUSHROOM_STEW).unlockedBy("has_mushroom_stew", has(Items.MUSHROOM_STEW)).save(this.output, MODID + ":crafting_shapeless/advanced_mushroom_stew");
        //TODO - Finish shapeless

        smelting(List.of(BlockRegistry.anthraciteOre), ItemRegistry.anthracite.get(), 0.1f);
        smelting(List.of(BlockRegistry.apalachiaOre), ItemRegistry.apalachia_fragments.get(), 1.3f);
        smelting(TagRegistry.SMELTABLE_APALACHIA, ItemRegistry.apalachia_fragments.get(), 0.1f);
        smelting(List.of(ItemRegistry.pure_aquatic_pellets.get()), ItemRegistry.aquatic_ingot.get(), 0.1f);
        smelting(List.of(BlockRegistry.arlemiteOre.get(), ItemRegistry.raw_arlemite.get(), ItemRegistry.arlemite_dust), ItemRegistry.arlemite_ingot.get(), 0.7f);
        smelting(TagRegistry.SMELTABLE_ARLEMITE, ItemRegistry.arlemite_nugget.get(), 0.1f);
        smelting(List.of(BlockRegistry.bloodgemOre), ItemRegistry.bloodgem.get(), 1.2F);
        smelting(ItemTags.create(Identifier.fromNamespaceAndPath("c", "eggs")), ItemRegistry.boiled_egg.get(), 0.35F);
        smelting(List.of(ItemRegistry.frozen_clock), Items.CLOCK, 0, 100);
        smelting(List.of(BlockRegistry.cobbledFrozenSlab), Items.COBBLESTONE_SLAB, 0.05F, 100);
        smelting(List.of(BlockRegistry.cobbledFrozenStairs), Items.COBBLESTONE_STAIRS, 0.1F);
        smelting(List.of(BlockRegistry.cobbledFrozenWall), Items.COBBLESTONE_WALL, 0.1F);
        smelting(List.of(ItemRegistry.bacon), ItemRegistry.cooked_bacon, 0.35F);
        smelting(TagRegistry.SMELTABLE_CORRUPTED, ItemRegistry.corrupted_shards, 0.1F);
        smelting(List.of(BlockRegistry.frozenDirt), Items.DIRT, 0.1F);
        smelting(TagRegistry.SMELTABLE_DIVINE, ItemRegistry.divine_shards, 0.1F);
        smelting(TagRegistry.SMELTABLE_EDEN, ItemRegistry.eden_fragments, 0.1F);
        smelting(List.of(BlockRegistry.scorchaltEdenOre, BlockRegistry.twilightEdenOre), ItemRegistry.eden_fragments, 0.1F);
        smelting(List.of(ItemRegistry.eden_dust), ItemRegistry.eden_sparkles, 0.1F);
        smelting(List.of(ItemRegistry.raw_empowered_meat), ItemRegistry.empowered_meat, 0.35F);
        smelting(TagRegistry.SMELTABLE_ENDER, ItemRegistry.ender_shards, 0.1F);
        smelting(List.of(BlockRegistry.cobbledFrozenStone), BlockRegistry.frozenStone, 0.1F);
        smelting(TagRegistry.SMELTABLE_GOLD_COMPRESSED, Items.GOLD_INGOT, 1F);
        smelting(List.of(BlockRegistry.frozenGravel), Blocks.GRAVEL, 0.1F);
        smelting(List.of(BlockRegistry.coldHellfireSponge), BlockRegistry.hellfireSponge, 0.1F, 600);
        smelting(List.of(Items.PUMPKIN_PIE), ItemRegistry.hot_pumpkin_pie, 0.35F);
        smelting(TagRegistry.SMELTABLE_ICE, ItemRegistry.ice_shards, 0.1F);
        smelting(TagRegistry.SMELTABLE_JUNGLE, ItemRegistry.jungle_shards, 0.1F);
        smelting(TagRegistry.SMELTABLE_MOLTEN, ItemRegistry.molten_shards, 0.1F);
        smelting(List.of(BlockRegistry.mortumOre), ItemRegistry.mortum_fragments, 2);
        smelting(TagRegistry.SMELTABLE_MORTUM, ItemRegistry.mortum_fragments, 0.1F);
        smelting(List.of(BlockRegistry.oxdriteOre.get(), ItemRegistry.raw_oxdrite.get(), ItemRegistry.oxdrite_dust), ItemRegistry.oxdrite_ingot.get(), 0.7f);
        smelting(TagRegistry.SMELTABLE_OXDRITE, ItemRegistry.oxdrite_nugget, 0.1F);
        smelting(List.of(BlockRegistry.realmiteOre, BlockRegistry.realmiteOreDeepslate, ItemRegistry.raw_realmite.get(), ItemRegistry.realmite_dust), ItemRegistry.realmite_ingot.get(), 0.7f);
        smelting(TagRegistry.SMELTABLE_REALMITE, ItemRegistry.realmite_nugget, 0.1F);
        smelting(List.of(BlockRegistry.rupeeOre, BlockRegistry.rupeeOreDeepslate, ItemRegistry.raw_rupee.get(), ItemRegistry.rupee_dust), ItemRegistry.rupee_ingot.get(), 0.7f);
        smelting(TagRegistry.SMELTABLE_RUPEE, ItemRegistry.rupee_nugget, 0.1F);
        smelting(List.of(BlockRegistry.cobbledScorchalt), BlockRegistry.scorchalt, 0.1F);
        smelting(List.of(ItemRegistry.raw_seng_meat), ItemRegistry.seng_steak, 0.35F);
        smelting(List.of(ItemRegistry.shadow_dust), ItemRegistry.shadow_bar, 1);
        smelting(List.of(BlockRegistry.skythernOre), ItemRegistry.skythern_fragments, 1.7F);
        smelting(TagRegistry.SMELTABLE_SKYTHERN, ItemRegistry.skythern_fragments, 0.1F);
        smelting(List.of(BlockRegistry.soulSludgeBreakable), Items.SOUL_SAND, 0.1F);
        smelting(List.of(BlockRegistry.frozenStone), Items.STONE, 0.1F);
        smelting(List.of(BlockRegistry.frozenBrickSlab), Items.STONE_BRICK_SLAB, 0.05F);
        smelting(List.of(BlockRegistry.frozenBrickStairs), Items.STONE_BRICK_STAIRS, 0.1F);
        smelting(List.of(BlockRegistry.frozenBrickWall), Items.STONE_BRICK_WALL, 0.1F);
        smelting(List.of(BlockRegistry.frozenBricks), Items.STONE_BRICKS, 0.1F);
        smelting(List.of(BlockRegistry.frozenButton), Items.STONE_BUTTON, 0.1F);
        smelting(List.of(BlockRegistry.frozenPressurePlate), Items.STONE_PRESSURE_PLATE, 0.1F);
        smelting(List.of(BlockRegistry.frozenSlab), Items.STONE_BRICK_SLAB, 0.1F);
        smelting(List.of(BlockRegistry.frozenStairs), Items.STONE_STAIRS, 0.1F);
        smelting(TagRegistry.SMELTABLE_TERRAN, ItemRegistry.terran_shards, 0.1F);
        smelting(List.of(BlockRegistry.torriditeOre, ItemRegistry.raw_torridite.get(), ItemRegistry.torridite_dust), ItemRegistry.torridite_ingot.get(), 0.7f);
        smelting(TagRegistry.SMELTABLE_TORRIDITE, ItemRegistry.torridite_nugget, 0.1F);
        smelting(List.of(BlockRegistry.wildwoodOre), ItemRegistry.wildwood_fragments, 1F);
        smelting(TagRegistry.SMELTABLE_WILDWOOD, ItemRegistry.wildwood_fragments, 0.1F);
        smelting(List.of(ItemRegistry.raw_wolpertinger_meat), ItemRegistry.wolpertinger_steak, 0.35F);

        maulSmashing(TagRegistry.GEM_SHADOW, ItemRegistry.bedrock_chunk, 1, TagRegistry.BEDROCK_GRINDING_BASE);
        maulSmashing(TagRegistry.INGOT_SHADOW, ItemRegistry.shadow_coins, 2, null);
        maulSmashing(List.of(ItemRegistry.apalachia_fragments), ItemRegistry.apalachia_dust, 1, TagRegistry.APALACHIA_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.arlemite_ingot), ItemRegistry.arlemite_dust, 1, TagRegistry.ARLEMITE_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.bloodgem), ItemRegistry.bloodgem_dust, 1, TagRegistry.BLOODGEM_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.eden_fragments), ItemRegistry.eden_dust, 1, TagRegistry.EDEN_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.mortum_fragments), ItemRegistry.mortum_fragments, 1, TagRegistry.MORTUM_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.oxdrite_ingot), ItemRegistry.oxdrite_dust, 1, TagRegistry.OXDRITE_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.realmite_ingot), ItemRegistry.realmite_dust, 1, TagRegistry.REALMITE_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.rupee_ingot), ItemRegistry.rupee_dust, 1, TagRegistry.RUPEE_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.skythern_fragments), ItemRegistry.skythern_dust, 1, TagRegistry.SKYTHERN_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.torridite_ingot), ItemRegistry.torridite_dust, 1, TagRegistry.TORRIDITE_ORE, "dusts");
        maulSmashing(List.of(ItemRegistry.wildwood_fragments), ItemRegistry.wildwood_dust, 1, TagRegistry.WILDWOOD_ORE, "dusts");

        smithing(ItemRegistry.bedrock_upgrade_template, ItemRegistry.INFERNO_BOOTS, ItemRegistry.bedrock_chunk, ItemRegistry.BEDROCK_BOOTS);
        smithing(ItemRegistry.bedrock_upgrade_template, ItemRegistry.INFERNO_LEGGINGS, ItemRegistry.bedrock_chunk, ItemRegistry.BEDROCK_LEGGINGS);
        smithing(ItemRegistry.bedrock_upgrade_template, ItemRegistry.INFERNO_CHESTPLATE, ItemRegistry.bedrock_chunk, ItemRegistry.BEDROCK_CHESTPLATE);
        smithing(ItemRegistry.bedrock_upgrade_template, ItemRegistry.INFERNO_HELMET, ItemRegistry.bedrock_chunk, ItemRegistry.BEDROCK_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ender_sword, ItemRegistry.red_ender_sword, ItemRegistry.yellow_ender_sword, ItemRegistry.green_ender_sword, ItemRegistry.blue_ender_sword), TagRegistry.DIAMOND_GRAY, ItemRegistry.black_ender_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.divine_sword, ItemRegistry.red_divine_sword, ItemRegistry.yellow_divine_sword, ItemRegistry.green_divine_sword, ItemRegistry.gray_divine_sword), TagRegistry.DIAMOND_BLUE, ItemRegistry.blue_divine_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_BOOTS, ItemRegistry.RED_ENDER_BOOTS, ItemRegistry.YELLOW_ENDER_BOOTS, ItemRegistry.GREEN_ENDER_BOOTS, ItemRegistry.GRAY_ENDER_BOOTS), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_ENDER_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_CHESTPLATE, ItemRegistry.RED_ENDER_CHESTPLATE, ItemRegistry.YELLOW_ENDER_CHESTPLATE, ItemRegistry.GREEN_ENDER_CHESTPLATE, ItemRegistry.GRAY_ENDER_CHESTPLATE), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_ENDER_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_HELMET, ItemRegistry.RED_ENDER_HELMET, ItemRegistry.YELLOW_ENDER_HELMET, ItemRegistry.GREEN_ENDER_HELMET, ItemRegistry.GRAY_ENDER_HELMET), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_ENDER_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_LEGGINGS, ItemRegistry.RED_ENDER_LEGGINGS, ItemRegistry.YELLOW_ENDER_LEGGINGS, ItemRegistry.GREEN_ENDER_LEGGINGS, ItemRegistry.GRAY_ENDER_LEGGINGS), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_ENDER_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ender_sword, ItemRegistry.red_ender_sword, ItemRegistry.yellow_ender_sword, ItemRegistry.green_ender_sword, ItemRegistry.black_ender_sword), TagRegistry.DIAMOND_BLUE, ItemRegistry.blue_ender_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_BOOTS, ItemRegistry.RED_RUPEE_BOOTS, ItemRegistry.YELLOW_RUPEE_BOOTS, ItemRegistry.GREEN_RUPEE_BOOTS, ItemRegistry.GRAY_RUPEE_BOOTS), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_RUPEE_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_CHESTPLATE, ItemRegistry.RED_RUPEE_CHESTPLATE, ItemRegistry.YELLOW_RUPEE_CHESTPLATE, ItemRegistry.GREEN_RUPEE_CHESTPLATE, ItemRegistry.GRAY_RUPEE_CHESTPLATE), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_RUPEE_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_HELMET, ItemRegistry.RED_RUPEE_HELMET, ItemRegistry.YELLOW_RUPEE_HELMET, ItemRegistry.GREEN_RUPEE_HELMET, ItemRegistry.GRAY_RUPEE_HELMET), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_RUPEE_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_LEGGINGS, ItemRegistry.RED_RUPEE_LEGGINGS, ItemRegistry.YELLOW_RUPEE_LEGGINGS, ItemRegistry.GREEN_RUPEE_LEGGINGS, ItemRegistry.GRAY_RUPEE_LEGGINGS), TagRegistry.DIAMOND_BLUE, ItemRegistry.BLUE_RUPEE_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.red_divine_sword, ItemRegistry.yellow_divine_sword, ItemRegistry.green_divine_sword, ItemRegistry.blue_divine_sword, ItemRegistry.gray_divine_sword), TagRegistry.DIAMOND_NO, ItemRegistry.divine_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_ENDER_BOOTS, ItemRegistry.YELLOW_ENDER_BOOTS, ItemRegistry.GREEN_ENDER_BOOTS, ItemRegistry.BLUE_ENDER_BOOTS, ItemRegistry.GRAY_ENDER_BOOTS), TagRegistry.DIAMOND_NO, ItemRegistry.ENDER_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_ENDER_CHESTPLATE, ItemRegistry.YELLOW_ENDER_CHESTPLATE, ItemRegistry.GREEN_ENDER_CHESTPLATE, ItemRegistry.BLUE_ENDER_CHESTPLATE, ItemRegistry.GRAY_ENDER_CHESTPLATE), TagRegistry.DIAMOND_NO, ItemRegistry.ENDER_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_ENDER_LEGGINGS, ItemRegistry.YELLOW_ENDER_LEGGINGS, ItemRegistry.GREEN_ENDER_LEGGINGS, ItemRegistry.BLUE_ENDER_LEGGINGS, ItemRegistry.GRAY_ENDER_LEGGINGS), TagRegistry.DIAMOND_NO, ItemRegistry.ENDER_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_ENDER_HELMET, ItemRegistry.YELLOW_ENDER_HELMET, ItemRegistry.GREEN_ENDER_HELMET, ItemRegistry.BLUE_ENDER_HELMET, ItemRegistry.GRAY_ENDER_HELMET), TagRegistry.DIAMOND_NO, ItemRegistry.ENDER_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.red_ender_sword, ItemRegistry.yellow_ender_sword, ItemRegistry.green_ender_sword, ItemRegistry.blue_ender_sword, ItemRegistry.black_ender_sword), TagRegistry.DIAMOND_NO, ItemRegistry.ender_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.divine_sword, ItemRegistry.red_divine_sword, ItemRegistry.yellow_divine_sword, ItemRegistry.green_divine_sword, ItemRegistry.blue_divine_sword), TagRegistry.DIAMOND_GRAY, ItemRegistry.gray_divine_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_BOOTS, ItemRegistry.RED_ENDER_BOOTS, ItemRegistry.YELLOW_ENDER_BOOTS, ItemRegistry.GREEN_ENDER_BOOTS, ItemRegistry.BLUE_ENDER_BOOTS), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_ENDER_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_LEGGINGS, ItemRegistry.RED_ENDER_LEGGINGS, ItemRegistry.YELLOW_ENDER_LEGGINGS, ItemRegistry.GREEN_ENDER_LEGGINGS, ItemRegistry.BLUE_ENDER_LEGGINGS), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_ENDER_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_CHESTPLATE, ItemRegistry.RED_ENDER_CHESTPLATE, ItemRegistry.YELLOW_ENDER_CHESTPLATE, ItemRegistry.GREEN_ENDER_CHESTPLATE, ItemRegistry.BLUE_ENDER_CHESTPLATE), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_ENDER_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_HELMET, ItemRegistry.RED_ENDER_HELMET, ItemRegistry.YELLOW_ENDER_HELMET, ItemRegistry.GREEN_ENDER_HELMET, ItemRegistry.BLUE_ENDER_HELMET), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_ENDER_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_BOOTS, ItemRegistry.RED_RUPEE_BOOTS, ItemRegistry.YELLOW_RUPEE_BOOTS, ItemRegistry.GREEN_RUPEE_BOOTS, ItemRegistry.BLUE_RUPEE_BOOTS), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_RUPEE_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_LEGGINGS, ItemRegistry.RED_RUPEE_LEGGINGS, ItemRegistry.YELLOW_RUPEE_LEGGINGS, ItemRegistry.GREEN_RUPEE_LEGGINGS, ItemRegistry.BLUE_RUPEE_LEGGINGS), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_RUPEE_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_CHESTPLATE, ItemRegistry.RED_RUPEE_CHESTPLATE, ItemRegistry.YELLOW_RUPEE_CHESTPLATE, ItemRegistry.GREEN_RUPEE_CHESTPLATE, ItemRegistry.BLUE_RUPEE_CHESTPLATE), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_RUPEE_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_HELMET, ItemRegistry.RED_RUPEE_HELMET, ItemRegistry.YELLOW_RUPEE_HELMET, ItemRegistry.GREEN_RUPEE_HELMET, ItemRegistry.BLUE_RUPEE_HELMET), TagRegistry.DIAMOND_GRAY, ItemRegistry.GRAY_RUPEE_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.divine_sword, ItemRegistry.red_divine_sword, ItemRegistry.yellow_divine_sword, ItemRegistry.blue_divine_sword, ItemRegistry.gray_divine_sword), TagRegistry.DIAMOND_GREEN, ItemRegistry.green_divine_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_BOOTS, ItemRegistry.RED_ENDER_BOOTS, ItemRegistry.YELLOW_ENDER_BOOTS, ItemRegistry.BLUE_ENDER_BOOTS, ItemRegistry.GRAY_ENDER_BOOTS), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_ENDER_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_LEGGINGS, ItemRegistry.RED_ENDER_LEGGINGS, ItemRegistry.YELLOW_ENDER_LEGGINGS, ItemRegistry.BLUE_ENDER_LEGGINGS, ItemRegistry.GRAY_ENDER_LEGGINGS), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_ENDER_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_CHESTPLATE, ItemRegistry.RED_ENDER_CHESTPLATE, ItemRegistry.YELLOW_ENDER_CHESTPLATE, ItemRegistry.BLUE_ENDER_CHESTPLATE, ItemRegistry.GRAY_ENDER_CHESTPLATE), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_ENDER_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_HELMET, ItemRegistry.RED_ENDER_HELMET, ItemRegistry.YELLOW_ENDER_HELMET, ItemRegistry.BLUE_ENDER_HELMET, ItemRegistry.GRAY_ENDER_HELMET), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_ENDER_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_BOOTS, ItemRegistry.RED_RUPEE_BOOTS, ItemRegistry.YELLOW_RUPEE_BOOTS, ItemRegistry.BLUE_RUPEE_BOOTS, ItemRegistry.GRAY_RUPEE_BOOTS), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_RUPEE_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_LEGGINGS, ItemRegistry.RED_RUPEE_LEGGINGS, ItemRegistry.YELLOW_RUPEE_LEGGINGS, ItemRegistry.BLUE_RUPEE_LEGGINGS, ItemRegistry.GRAY_RUPEE_LEGGINGS), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_RUPEE_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_CHESTPLATE, ItemRegistry.RED_RUPEE_CHESTPLATE, ItemRegistry.YELLOW_RUPEE_CHESTPLATE, ItemRegistry.BLUE_RUPEE_CHESTPLATE, ItemRegistry.GRAY_RUPEE_CHESTPLATE), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_RUPEE_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_HELMET, ItemRegistry.RED_RUPEE_HELMET, ItemRegistry.YELLOW_RUPEE_HELMET, ItemRegistry.BLUE_RUPEE_HELMET, ItemRegistry.GRAY_RUPEE_HELMET), TagRegistry.DIAMOND_GREEN, ItemRegistry.GREEN_RUPEE_HELMET);
        smithing(ItemRegistry.aquatic_coating_template, List.of(ItemRegistry.AQUASTRIVE_BOOTS), TagRegistry.SKIN_KRAKEN, ItemRegistry.KRAKEN_BOOTS);
        smithing(ItemRegistry.aquatic_coating_template, List.of(ItemRegistry.AQUASTRIVE_LEGGINGS), TagRegistry.SKIN_KRAKEN, ItemRegistry.KRAKEN_LEGGINGS);
        smithing(ItemRegistry.aquatic_coating_template, List.of(ItemRegistry.AQUASTRIVE_CHESTPLATE), TagRegistry.SKIN_KRAKEN, ItemRegistry.KRAKEN_CHESTPLATE);
        smithing(ItemRegistry.aquatic_coating_template, List.of(ItemRegistry.AQUASTRIVE_HELMET), TagRegistry.SKIN_KRAKEN, ItemRegistry.KRAKEN_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.divine_sword, ItemRegistry.yellow_divine_sword, ItemRegistry.green_divine_sword, ItemRegistry.blue_divine_sword, ItemRegistry.gray_divine_sword), TagRegistry.DIAMOND_RED, ItemRegistry.red_divine_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_BOOTS, ItemRegistry.YELLOW_ENDER_BOOTS, ItemRegistry.GREEN_ENDER_BOOTS, ItemRegistry.BLUE_ENDER_BOOTS, ItemRegistry.GRAY_ENDER_BOOTS), TagRegistry.DIAMOND_RED, ItemRegistry.RED_ENDER_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_LEGGINGS, ItemRegistry.YELLOW_ENDER_LEGGINGS, ItemRegistry.GREEN_ENDER_LEGGINGS, ItemRegistry.BLUE_ENDER_LEGGINGS, ItemRegistry.GRAY_ENDER_LEGGINGS), TagRegistry.DIAMOND_RED, ItemRegistry.RED_ENDER_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_CHESTPLATE, ItemRegistry.YELLOW_ENDER_CHESTPLATE, ItemRegistry.GREEN_ENDER_CHESTPLATE, ItemRegistry.BLUE_ENDER_CHESTPLATE, ItemRegistry.GRAY_ENDER_CHESTPLATE), TagRegistry.DIAMOND_RED, ItemRegistry.RED_ENDER_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_HELMET, ItemRegistry.YELLOW_ENDER_HELMET, ItemRegistry.GREEN_ENDER_HELMET, ItemRegistry.BLUE_ENDER_HELMET, ItemRegistry.GRAY_ENDER_HELMET), TagRegistry.DIAMOND_RED, ItemRegistry.RED_ENDER_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_BOOTS, ItemRegistry.YELLOW_RUPEE_BOOTS, ItemRegistry.GREEN_RUPEE_BOOTS, ItemRegistry.BLUE_RUPEE_BOOTS, ItemRegistry.GRAY_RUPEE_BOOTS), TagRegistry.DIAMOND_RED, ItemRegistry.RED_RUPEE_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_LEGGINGS, ItemRegistry.YELLOW_RUPEE_LEGGINGS, ItemRegistry.GREEN_RUPEE_LEGGINGS, ItemRegistry.BLUE_RUPEE_LEGGINGS, ItemRegistry.GRAY_RUPEE_LEGGINGS), TagRegistry.DIAMOND_RED, ItemRegistry.RED_RUPEE_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_CHESTPLATE, ItemRegistry.YELLOW_RUPEE_CHESTPLATE, ItemRegistry.GREEN_RUPEE_CHESTPLATE, ItemRegistry.BLUE_RUPEE_CHESTPLATE, ItemRegistry.GRAY_RUPEE_CHESTPLATE), TagRegistry.DIAMOND_RED, ItemRegistry.RED_RUPEE_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_HELMET, ItemRegistry.YELLOW_RUPEE_HELMET, ItemRegistry.GREEN_RUPEE_HELMET, ItemRegistry.BLUE_RUPEE_HELMET, ItemRegistry.GRAY_RUPEE_HELMET), TagRegistry.DIAMOND_RED, ItemRegistry.RED_RUPEE_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_RUPEE_BOOTS, ItemRegistry.YELLOW_RUPEE_BOOTS, ItemRegistry.GREEN_RUPEE_BOOTS, ItemRegistry.BLUE_RUPEE_BOOTS, ItemRegistry.GRAY_RUPEE_BOOTS), TagRegistry.DIAMOND_NO, ItemRegistry.RUPEE_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_RUPEE_CHESTPLATE, ItemRegistry.YELLOW_RUPEE_CHESTPLATE, ItemRegistry.GREEN_RUPEE_CHESTPLATE, ItemRegistry.BLUE_RUPEE_CHESTPLATE, ItemRegistry.GRAY_RUPEE_CHESTPLATE), TagRegistry.DIAMOND_NO, ItemRegistry.RUPEE_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_RUPEE_LEGGINGS, ItemRegistry.YELLOW_RUPEE_LEGGINGS, ItemRegistry.GREEN_RUPEE_LEGGINGS, ItemRegistry.BLUE_RUPEE_LEGGINGS, ItemRegistry.GRAY_RUPEE_LEGGINGS), TagRegistry.DIAMOND_NO, ItemRegistry.RUPEE_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RED_RUPEE_HELMET, ItemRegistry.YELLOW_RUPEE_HELMET, ItemRegistry.GREEN_RUPEE_HELMET, ItemRegistry.BLUE_RUPEE_HELMET, ItemRegistry.GRAY_RUPEE_HELMET), TagRegistry.DIAMOND_NO, ItemRegistry.RUPEE_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.SENG_FUR_BOOTS), BlockRegistry.fancyWool, ItemRegistry.SANTA_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.SENG_FUR_LEGGINGS), BlockRegistry.fancyWool, ItemRegistry.SANTA_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.SENG_FUR_CHESTPLATE), BlockRegistry.fancyWool, ItemRegistry.SANTA_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.SENG_FUR_HELMET), BlockRegistry.fancyWool, ItemRegistry.SANTA_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.divine_sword, ItemRegistry.red_divine_sword, ItemRegistry.green_divine_sword, ItemRegistry.blue_divine_sword, ItemRegistry.gray_divine_sword), TagRegistry.DIAMOND_YELLOW, ItemRegistry.yellow_divine_sword);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_BOOTS, ItemRegistry.RED_ENDER_BOOTS, ItemRegistry.GREEN_ENDER_BOOTS, ItemRegistry.BLUE_ENDER_BOOTS, ItemRegistry.GRAY_ENDER_BOOTS), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_ENDER_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_LEGGINGS, ItemRegistry.RED_ENDER_LEGGINGS, ItemRegistry.GREEN_ENDER_LEGGINGS, ItemRegistry.BLUE_ENDER_LEGGINGS, ItemRegistry.GRAY_ENDER_LEGGINGS), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_ENDER_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_CHESTPLATE, ItemRegistry.RED_ENDER_CHESTPLATE, ItemRegistry.GREEN_ENDER_CHESTPLATE, ItemRegistry.BLUE_ENDER_CHESTPLATE, ItemRegistry.GRAY_ENDER_CHESTPLATE), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_ENDER_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.ENDER_HELMET, ItemRegistry.RED_ENDER_HELMET, ItemRegistry.GREEN_ENDER_HELMET, ItemRegistry.BLUE_ENDER_HELMET, ItemRegistry.GRAY_ENDER_HELMET), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_ENDER_HELMET);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_BOOTS, ItemRegistry.RED_RUPEE_BOOTS, ItemRegistry.GREEN_RUPEE_BOOTS, ItemRegistry.BLUE_RUPEE_BOOTS, ItemRegistry.GRAY_RUPEE_BOOTS), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_RUPEE_BOOTS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_LEGGINGS, ItemRegistry.RED_RUPEE_LEGGINGS, ItemRegistry.GREEN_RUPEE_LEGGINGS, ItemRegistry.BLUE_RUPEE_LEGGINGS, ItemRegistry.GRAY_RUPEE_LEGGINGS), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_RUPEE_LEGGINGS);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_CHESTPLATE, ItemRegistry.RED_RUPEE_CHESTPLATE, ItemRegistry.GREEN_RUPEE_CHESTPLATE, ItemRegistry.BLUE_RUPEE_CHESTPLATE, ItemRegistry.GRAY_RUPEE_CHESTPLATE), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_RUPEE_CHESTPLATE);
        smithing(ItemRegistry.color_template, List.of(ItemRegistry.RUPEE_HELMET, ItemRegistry.RED_RUPEE_HELMET, ItemRegistry.GREEN_RUPEE_HELMET, ItemRegistry.BLUE_RUPEE_HELMET, ItemRegistry.GRAY_RUPEE_HELMET), TagRegistry.DIAMOND_YELLOW, ItemRegistry.YELLOW_RUPEE_HELMET);

        smoking(ItemTags.create(Identifier.fromNamespaceAndPath("c", "eggs")), ItemRegistry.boiled_egg, 0.35F);
        smoking(List.of(ItemRegistry.bacon.get()), ItemRegistry.cooked_bacon, 0.35F, 50);
        smoking(List.of(ItemRegistry.raw_empowered_meat.get()), ItemRegistry.empowered_meat, 0.35F);
        smoking(List.of(Items.PUMPKIN_PIE), ItemRegistry.hot_pumpkin_pie, 0.35F);
        smoking(List.of(ItemRegistry.raw_seng_meat.get()), ItemRegistry.seng_steak, 0.35F);
        smoking(List.of(ItemRegistry.raw_wolpertinger_meat.get()), ItemRegistry.wolpertinger_steak, 0.35F);

        stonecutting(Ingredient.of(BlockRegistry.cobaltite.get()), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.cobaltiteStairs.get(), 1).unlockedBy("has_cobaltite", has(BlockRegistry.cobaltite.get())).save(this.output, MODID + ":stonecutting/" + "cobalite_stairs");
        //TODO - Finish stonecutting
    }

    protected <T extends AbstractCookingRecipe> void cooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc, String folder) {
        for (ItemLike item : smeltables) {
            String recipeId = folder + "/" + getItemName(result) + fromDesc + "_" + getItemName(item);
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(item), this.has(item)).save(this.output, MODID + ":" + recipeId);
        }
    }

    protected <T extends AbstractCookingRecipe> void cooking(AbstractCookingRecipe.Factory<T> factory, TagKey<Item> inputTag, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc, String folder) {
        String recipeId = folder + "/" + getItemName(result) + fromDesc + "_tag";
        HolderSet<Item> tagHolderSet = this.registries.lookupOrThrow(Registries.ITEM).getOrThrow(inputTag);
        SimpleCookingRecipeBuilder.generic(Ingredient.of(tagHolderSet), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy("has_tag", this.has(inputTag)).save(this.output, MODID + ":" + recipeId);
    }

    protected void smelting(List<ItemLike> smeltables, ItemLike result, float experience) {
        this.cooking(SmeltingRecipe::new, smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 200, getItemName(result), "_from_smelting", "smelting");
    }

    protected void smelting(TagKey<Item> inputTag, ItemLike result, float experience) {
        this.cooking(SmeltingRecipe::new, inputTag, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 200, getItemName(result), "_from_smelting", "smelting");
    }

    protected void smelting(List<ItemLike> smeltables, ItemLike result, float experience, int cookTime) {
        this.cooking(SmeltingRecipe::new, smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, cookTime, getItemName(result), "_from_smelting", "smelting");
    }

    protected void blasting(List<ItemLike> smeltables, ItemLike result, float experience) {
        this.cooking(BlastingRecipe::new, smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 100, getItemName(result), "_from_blasting", "blasting");
    }

    protected void blasting(TagKey<Item> inputTag, ItemLike result, float experience) {
        this.cooking(BlastingRecipe::new, inputTag, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, 100, getItemName(result), "_from_blasting", "blasting");
    }

    protected void blasting(List<ItemLike> smeltables, ItemLike result, float experience, int cookTime) {
        this.cooking(BlastingRecipe::new, smeltables, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, cookTime, getItemName(result), "_from_blasting", "blasting");
    }

    protected void blasting(TagKey<Item> inputTag, ItemLike result, float experience, int cookTime) {
        this.cooking(BlastingRecipe::new, inputTag, RecipeCategory.MISC, CookingBookCategory.MISC, result, experience, cookTime, getItemName(result), "_from_blasting", "blasting");
    }

    protected void smoking(List<ItemLike> smeltables, ItemLike result, float experience) {
        this.cooking(SmokingRecipe::new, smeltables, RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, 100, getItemName(result), "_from_smoking", "smoking");
    }

    protected void smoking(TagKey<Item> inputTag, ItemLike result, float experience) {
        this.cooking(SmokingRecipe::new, inputTag, RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, 100, getItemName(result), "_from_smoking", "smoking");
    }

    protected void smoking(List<ItemLike> smeltables, ItemLike result, float experience, int cookTime) {
        this.cooking(SmokingRecipe::new, smeltables, RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, cookTime, getItemName(result), "_from_smoking", "smoking");
    }

    protected void campfire(List<ItemLike> smeltables, ItemLike result, float experience) {
        this.cooking(CampfireCookingRecipe::new, smeltables, RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, 600, getItemName(result), "_from_campfire", "campfire");
    }

    protected void campfire(TagKey<Item> inputTag, ItemLike result, float experience) {
        this.cooking(CampfireCookingRecipe::new, inputTag, RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, 600, getItemName(result), "_from_campfire", "campfire");
    }

    protected void campfire(List<ItemLike> smeltables, ItemLike result, float experience, int cookTime) {
        this.cooking(CampfireCookingRecipe::new, smeltables, RecipeCategory.FOOD, CookingBookCategory.FOOD, result, experience, cookTime, getItemName(result), "_from_campfire", "campfire");
    }

    protected void smithing(ItemLike template, ItemLike baseItem, ItemLike catalyst, ItemLike resultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template),Ingredient.of(baseItem),Ingredient.of(catalyst),RecipeCategory.COMBAT,resultItem.asItem()).unlocks("has_" + getItemName(template), has(template)).save(this.output, MODID + ":smithing/" + getItemName(resultItem) + "_from_" + getItemName(baseItem));
    }

    protected void smithing(ItemLike template, List<ItemLike> baseItems, Object catalystObj, ItemLike resultItem) {
        for (ItemLike baseItem : baseItems) {
            Ingredient catalystIngredient = catalystObj instanceof TagKey<?> tag ? Ingredient.of(this.registries.lookupOrThrow(Registries.ITEM).getOrThrow((TagKey<Item>) tag)) : catalystObj instanceof ItemLike item ? Ingredient.of(item) : Ingredient.of((Item) catalystObj);
            String baseName = baseItem instanceof Item item ? getItemName(item) : getItemName(baseItem.asItem());
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(template),Ingredient.of(baseItem),catalystIngredient,RecipeCategory.COMBAT,resultItem.asItem()).unlocks("has_" + getItemName(template), has(template)).save(this.output, MODID + ":smithing/" + getItemName(resultItem) + "_from_" + baseName);
        }
    }

    protected void maulSmashing(TagKey<Item> inputTag, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        HolderSet<Item> tagHolderSet = this.registries.lookupOrThrow(Registries.ITEM).getOrThrow(inputTag);
        String inputPath = inputTag.location().getPath(), inputName = inputPath.contains("/") ? inputPath.substring(inputPath.lastIndexOf('/') + 1) : inputPath, recipeName = getItemName(outputItem) + "_from_" + inputName;
        MaulSmashingRecipeBuilder.smashing(Ingredient.of(tagHolderSet), outputItem, count, requiredBaseBlockTag).unlockedBy("has_tag", this.has(inputTag)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "maul_smashing/" + recipeName)));
    }

    protected void maulSmashing(TagKey<Item> inputTag, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag, String subFolder) {
        HolderSet<Item> tagHolderSet = this.registries.lookupOrThrow(Registries.ITEM).getOrThrow(inputTag);
        String inputPath = inputTag.location().getPath(), inputName = inputPath.contains("/") ? inputPath.substring(inputPath.lastIndexOf('/') + 1) : inputPath, recipeName = getItemName(outputItem) + "_from_" + inputName;
        MaulSmashingRecipeBuilder.smashing(Ingredient.of(tagHolderSet), outputItem, count, requiredBaseBlockTag).unlockedBy("has_tag", this.has(inputTag)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "maul_smashing/"+ subFolder + "/" + recipeName)));
    }

    protected void maulSmashing(ItemLike inputItem, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        maulSmashing(List.of(inputItem), outputItem, count, requiredBaseBlockTag);
    }

    protected void maulSmashing(List<ItemLike> inputItems, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        for (ItemLike item : inputItems) {
            String inputName = getItemName(item), recipeName = getItemName(outputItem) + "_from_" + inputName;
            MaulSmashingRecipeBuilder.smashing(Ingredient.of(item), outputItem, count, requiredBaseBlockTag).unlockedBy(getHasName(item), this.has(item)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "maul_smashing/" + recipeName)));
        }
    }

    protected void maulSmashing(List<ItemLike> inputItems, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag, String subFolder) {
        for (ItemLike item : inputItems) {
            String inputName = getItemName(item), recipeName = getItemName(outputItem) + "_from_" + inputName;
            MaulSmashingRecipeBuilder.smashing(Ingredient.of(item), outputItem, count, requiredBaseBlockTag).unlockedBy(getHasName(item), this.has(item)).save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "maul_smashing/" + subFolder + "/" + recipeName)));
        }
    }
}