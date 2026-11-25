package divinerpg.recipe.builder;

import divinerpg.recipe.InfusionTableRecipe;
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

public class InfusionTableRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Ingredient input;
    private final int inputCount;
    private final Ingredient template;
    private final ItemStackTemplate result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public InfusionTableRecipeBuilder(RecipeCategory category, Ingredient input, int inputCount, Ingredient template, ItemLike outputItem, int outputCount) {
        this.category = category;
        this.input = input;
        this.inputCount = inputCount;
        this.template = template;
        this.result = new ItemStackTemplate(outputItem.asItem(), outputCount);
    }
    public static InfusionTableRecipeBuilder infusion(Ingredient input, int inputCount, RecipeCategory category, Ingredient template, ItemLike outputItem, int outputCount) {
        return new InfusionTableRecipeBuilder(category, input, inputCount, template, outputItem, outputCount);
    }
    @Override public InfusionTableRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }
    @Override public InfusionTableRecipeBuilder group(@Nullable String groupName) {
        return this;
    }
    @Override public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "infusion_table"));
    }
    @Override public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeOutput.lookup(Registries.RECIPE).getOrThrow(resourceKey))).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        criteria.forEach(advancementBuilder::addCriterion);
        InfusionTableRecipe recipe = new InfusionTableRecipe(input, inputCount, template, result);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/" + category.getFolderName() + "/")));
    }
    private void ensureValid(Identifier id) {
        if(criteria.isEmpty()) throw new IllegalStateException("No ways of obtaining recipe " + id);
    }
}