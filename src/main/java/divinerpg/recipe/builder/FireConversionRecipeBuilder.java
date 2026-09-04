package divinerpg.recipe.builder;

import divinerpg.recipe.FireConversionRecipe;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static divinerpg.DivineRPG.MODID;

public class FireConversionRecipeBuilder implements RecipeBuilder {
    private final Ingredient inputItem;
    private final RuleTest inputState;
    private Optional<ItemStack> outputItem = Optional.empty();
    private Optional<BlockStateProvider> outputState = Optional.empty();
    private Optional<Identifier> advancement = Optional.empty();
    private Optional<String> advancementCriteria = Optional.empty();
    private Optional<RuleTest> frame = Optional.empty();
    private Optional<BlockStateProvider> portal = Optional.empty();

    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public FireConversionRecipeBuilder(Ingredient inputItem, RuleTest inputState) {
        this.inputItem = inputItem;
        this.inputState = inputState;
    }

    public static FireConversionRecipeBuilder conversion(Ingredient inputItem, RuleTest inputState) {
        return new FireConversionRecipeBuilder(inputItem, inputState);
    }

    public FireConversionRecipeBuilder outputItem(ItemStack outputItem) {
        this.outputItem = Optional.of(outputItem);
        return this;
    }

    public FireConversionRecipeBuilder outputState(BlockStateProvider outputState) {
        this.outputState = Optional.of(outputState);
        return this;
    }

    public FireConversionRecipeBuilder advancement(Identifier advancement, String criteriaName) {
        this.advancement = Optional.of(advancement);
        this.advancementCriteria = Optional.of(criteriaName);
        return this;
    }

    public FireConversionRecipeBuilder frame(RuleTest frame) {
        this.frame = Optional.of(frame);
        return this;
    }

    public FireConversionRecipeBuilder portal(BlockStateProvider portal) {
        this.portal = Optional.of(portal);
        return this;
    }

    @Override
    public FireConversionRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public FireConversionRecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "fire_conversion"));
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey)).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancementBuilder::addCriterion);
        FireConversionRecipe recipe = new FireConversionRecipe(inputItem, inputState, outputItem, outputState, advancement, advancementCriteria, frame, portal);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/")));
    }

    private void ensureValid(Identifier id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No ways of obtaining recipe " + id);
        }
    }
}