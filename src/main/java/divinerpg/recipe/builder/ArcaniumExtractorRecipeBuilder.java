package divinerpg.recipe.builder;

import divinerpg.recipe.ArcaniumExtractorRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.triggers.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static divinerpg.DivineRPG.MODID;

public class ArcaniumExtractorRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final RecipeCategory category;
    private final Item result;
    private final float experience;
    private final int cookingTime;
    private String group = "";
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    public ArcaniumExtractorRecipeBuilder(Ingredient input, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        this.input = input;
        this.category = category;
        this.result = result.asItem();
        this.experience = experience;
        this.cookingTime = cookingTime;
    }
    public static ArcaniumExtractorRecipeBuilder extraction(Ingredient input, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
        return new ArcaniumExtractorRecipeBuilder(input, category, result, experience, cookingTime);
    }
    @Override public ArcaniumExtractorRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }
    @Override public ArcaniumExtractorRecipeBuilder group(@Nullable String groupName) {
        group = groupName == null ? "" : groupName;
        return this;
    }
    @Override public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "arcanium_extractor"));
    }
    private static CookingBookCategory determineBookCategory(RecipeCategory category, Item result) {
        if(category == RecipeCategory.FOOD) return CookingBookCategory.FOOD;
        return result instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC;
    }
    @Override public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeOutput.lookup(Registries.RECIPE).getOrThrow(resourceKey))).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        criteria.forEach(advancementBuilder::addCriterion);
        Recipe.CommonInfo commonInfo = new Recipe.CommonInfo(true);
        AbstractCookingRecipe.CookingBookInfo bookInfo = new AbstractCookingRecipe.CookingBookInfo(determineBookCategory(category, result), group);
        ArcaniumExtractorRecipe recipe = new ArcaniumExtractorRecipe(commonInfo, bookInfo, input, result, experience, cookingTime);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/" + category.getFolderName() + "/")));
    }
    private void ensureValid(Identifier id) {
        if(criteria.isEmpty()) throw new IllegalStateException("No ways of obtaining recipe " + id);
    }
}