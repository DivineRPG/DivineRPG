package divinerpg.compat.jei.brewing;

import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import org.jetbrains.annotations.*;

import java.util.List;

public record PotionRecipe(Item bottle, Holder<Potion> input, Holder<Potion> output, int brewingSteps, ResourceLocation id, ItemStack... ingredients) implements IJeiBrewingRecipe {
    @Override public @Unmodifiable List<ItemStack> getPotionInputs() {return List.of(PotionContents.createItemStack(bottle, input));}
    @Override public @Unmodifiable List<ItemStack> getIngredients() {return List.of(ingredients);}
    @Override public ItemStack getPotionOutput() {return PotionContents.createItemStack(bottle, output);}
    @Override public int getBrewingSteps() {return brewingSteps;}
    @Override public @Nullable ResourceLocation getUid() {return id;}
}