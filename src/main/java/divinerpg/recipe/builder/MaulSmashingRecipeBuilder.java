package divinerpg.recipe.builder;

import divinerpg.recipe.MaulSmashingRecipe;
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
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

import static divinerpg.DivineRPG.MODID;

public class MaulSmashingRecipeBuilder implements RecipeBuilder {
    private final Ingredient input;
    private final Item outputItem;
    private final int count;
    @Nullable
    private final TagKey<Block> requiredBaseBlockTag;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public MaulSmashingRecipeBuilder(Ingredient input, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        this.input = input;
        this.outputItem = outputItem.asItem();
        this.count = count;
        this.requiredBaseBlockTag = requiredBaseBlockTag;
    }

    public static MaulSmashingRecipeBuilder smashing(Ingredient input, ItemLike outputItem, int count, @Nullable TagKey<Block> requiredBaseBlockTag) {
        return new MaulSmashingRecipeBuilder(input, outputItem, count, requiredBaseBlockTag);
    }

    @Override
    public MaulSmashingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public MaulSmashingRecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(MODID, "maul_smashing"));
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey.identifier());
        Advancement.Builder advancementBuilder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancementBuilder::addCriterion);

        // NO new ItemStack(...) created here! Passed cleanly as raw item and count.
        MaulSmashingRecipe recipe = new MaulSmashingRecipe(input, outputItem, count, requiredBaseBlockTag);
        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(resourceKey.identifier().withPrefix("recipes/")));
    }

    private void ensureValid(Identifier id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No ways of obtaining recipe " + id);
        }
    }
}