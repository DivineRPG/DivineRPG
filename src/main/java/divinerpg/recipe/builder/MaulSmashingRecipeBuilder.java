package divinerpg.recipe.builder;

import divinerpg.recipe.MaulSmashingRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.triggers.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.RECIPE;

public class MaulSmashingRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final RecipeCategory category;
    private final ItemStackTemplate result;
    @Nullable
    private final TagKey<Block> requiredBaseBlockTag;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    public MaulSmashingRecipeBuilder(Ingredient input, RecipeCategory category, ItemLike result, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        this.input = input;
        this.category = category;
        this.result = new ItemStackTemplate(result.asItem(), count);
        this.requiredBaseBlockTag = requiredBaseBlockTag;
    }
    public static MaulSmashingRecipeBuilder smashing(Ingredient input, RecipeCategory category, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        return new MaulSmashingRecipeBuilder(input, category, outputItem, count, requiredBaseBlockTag);
    }
    @Override public MaulSmashingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        criteria.put(name, criterion);
        return this;
    }
    @Override public MaulSmashingRecipeBuilder group(@Nullable String groupName) {
        return this;
    }
    @Override public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(RECIPE, Identifier.fromNamespaceAndPath(MODID, "maul_smashing"));
    }
    @Override public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeOutput.lookup(RECIPE).getOrThrow(resourceKey))).rewards(AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        criteria.forEach(advancementBuilder::addCriterion);
        MaulSmashingRecipe recipe = new MaulSmashingRecipe(input, result, requiredBaseBlockTag);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/" + category.getFolderName() + "/")));
    }
    private void ensureValid(Identifier id) {
        if(criteria.isEmpty()) throw new IllegalStateException("No ways of obtaining recipe " + id);
    }
}