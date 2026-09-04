package divinerpg.recipe.builder;

import divinerpg.recipe.InfusionTableRecipe;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

import static divinerpg.DivineRPG.MODID;

public class InfusionTableRecipeBuilder implements RecipeBuilder {
    private final Item inputItem;
    private final int inputCount;
    private final Ingredient template;
    private final Item outputItem;
    private final int outputCount;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public InfusionTableRecipeBuilder(ItemLike inputItem, int inputCount, Ingredient template, ItemLike outputItem, int outputCount) {
        this.inputItem = inputItem.asItem();
        this.inputCount = inputCount;
        this.template = template;
        this.outputItem = outputItem.asItem();
        this.outputCount = outputCount;
    }

    public static InfusionTableRecipeBuilder infusion(ItemLike inputItem, int inputCount, Ingredient template, ItemLike outputItem, int outputCount) {
        return new InfusionTableRecipeBuilder(inputItem, inputCount, template, outputItem, outputCount);
    }

    @Override
    public InfusionTableRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public InfusionTableRecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "infusion_table"));
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey)).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancementBuilder::addCriterion);
        InfusionTableRecipe recipe = new InfusionTableRecipe(inputItem, inputCount, template, outputItem, outputCount);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/")));
    }

    private void ensureValid(Identifier id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No ways of obtaining recipe " + id);
        }
    }
}