package divinerpg.data;

import divinerpg.registries.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

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
        List<ItemLike> arlemiteSmeltables = List.of(BlockRegistry.arlemiteOre.get(), ItemRegistry.raw_arlemite.get());

        //TODO - more smelting
        oreSmelting(arlemiteSmeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ItemRegistry.arlemite_ingot.get(), 0.7f, 200, "arlemite");

        //TODO - more blasting
        oreBlasting(arlemiteSmeltables, RecipeCategory.MISC, CookingBookCategory.MISC, ItemRegistry.arlemite_ingot.get(), 0.7f, 100, "arlemite");

        //TODO - more shaped
        shaped(RecipeCategory.COMBAT, ItemRegistry.ANGELIC_BOOTS.get()).pattern("I I").pattern("X X").define('X', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/shadow"))).define('I', TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/soulfire"))).unlockedBy("has_shadow_gem", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/shadow")))).unlockedBy("has_soulfire_gem", has(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, "gems/soulfire")))).save(this.output, MODID + ":crafting_shaped/angelic_boots");

        //TODO - more shapeless
        shapeless(RecipeCategory.FOOD, ItemRegistry.advanced_mushroom_stew.get()).requires(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "foods/white_mushroom"))).requires(Items.MUSHROOM_STEW).unlockedBy("has_mushroom_stew", has(Items.MUSHROOM_STEW)).save(this.output, MODID + ":crafting_shapeless/advanced_mushroom_stew");

        //TODO - more smithing
        smithing(Ingredient.of(ItemRegistry.bedrock_upgrade_template.get()), Ingredient.of(ItemRegistry.INFERNO_BOOTS.get()), Ingredient.of(ItemRegistry.bedrock_chunk.get()), RecipeCategory.COMBAT, ItemRegistry.BEDROCK_BOOTS.get()).unlocks("has_bedrock_upgrade", has(ItemRegistry.bedrock_upgrade_template.get())).save(this.output, MODID + ":smithing/bedrock_boots_from_inferno");

        //TODO more stone cutting
        stonecutting(Ingredient.of(BlockRegistry.cobaltite.get()), RecipeCategory.BUILDING_BLOCKS, BlockRegistry.cobaltiteStairs.get(), 1).unlockedBy("has_cobaltite", has(BlockRegistry.cobaltite.get())).save(this.output, MODID + ":stonecutting/" + "cobalite_stairs");
    }
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc, String folder) {
        for (ItemLike item : smeltables) {
            String recipeId = folder + "/" + getItemName(result) + fromDesc + "_" + getItemName(item);
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(item), this.has(item)).save(this.output, MODID + ":" +recipeId);
        }
    }

    protected void oreSmelting(List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group) {
        this.oreCooking(SmeltingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_smelting", "smelting");
    }

    protected void oreBlasting(List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group) {
        this.oreCooking(BlastingRecipe::new, smeltables, craftingCategory, cookingCategory, result, experience, cookingTime, group, "_from_blasting", "blasting");
    }

}