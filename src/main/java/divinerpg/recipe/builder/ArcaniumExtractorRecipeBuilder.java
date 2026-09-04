package divinerpg.recipe.builder;

import divinerpg.recipe.ArcaniumExtractorRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

import static divinerpg.DivineRPG.MODID;

public class ArcaniumExtractorRecipeBuilder implements RecipeBuilder {
    private final Ingredient ingredient;
    private final ItemStackTemplate result;
    private final float experience;
    private final int cookingTime;
    private CookingBookCategory category = CookingBookCategory.MISC;
    private String group = "";
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public ArcaniumExtractorRecipeBuilder(Ingredient ingredient, ItemLike result, int resultCount, float experience, int cookingTime) {
        this.ingredient = ingredient;
        this.result = new ItemStackTemplate(result.asItem(), resultCount);
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static ArcaniumExtractorRecipeBuilder extraction(Ingredient ingredient, ItemLike result, int resultCount, float experience, int cookingTime) {
        return new ArcaniumExtractorRecipeBuilder(ingredient, result, resultCount, experience, cookingTime);
    }

    @Override
    public ArcaniumExtractorRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public ArcaniumExtractorRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName == null ? "" : groupName;
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "arcanium_extractor"));
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey)).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancementBuilder::addCriterion);
        Recipe.CommonInfo commonInfo = new Recipe.CommonInfo(true);
        AbstractCookingRecipe.CookingBookInfo bookInfo = new AbstractCookingRecipe.CookingBookInfo(category, group);
        ArcaniumExtractorRecipe recipe = new ArcaniumExtractorRecipe(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/")));
    }

    private void ensureValid(Identifier id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No ways of obtaining recipe " + id);
        }
    }
}