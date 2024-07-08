package divinerpg.recipe;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public ArcaniumExtractorRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack stack, float xp, int time) {
        super(RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), group, category, ingredient, stack, xp, time);
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