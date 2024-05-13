package divinerpg.recipe;

import divinerpg.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public ArcaniumExtractorRecipe(ResourceLocation loc, String group, CookingBookCategory category, Ingredient ingredient, ItemStack stack, float xp, int time) {
        super(RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), loc, group, category, ingredient, stack, xp, time);
    }
    @Override public ItemStack getToastSymbol() {return new ItemStack(BlockRegistry.arcaniumExtractor.get());}
    @Override public RecipeSerializer<?> getSerializer() {return RecipeRegistry.Serailizers.ARCANIUM_EXTRACTOR_SERIALIZER.get();}
    @Override public String toString() {return "arcanium_extractor";}
    public static class Type implements RecipeType<ArcaniumExtractorRecipe> {
        private Type() {}
        public static final ArcaniumExtractorRecipe.Type INSTANCE = new ArcaniumExtractorRecipe.Type();
        public static final String ID = "arcanium_extractor";
        @Override public String toString() {return ID;}
    }
}