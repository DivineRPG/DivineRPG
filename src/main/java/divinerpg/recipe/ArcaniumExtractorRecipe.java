package divinerpg.recipe;

import divinerpg.registries.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {

    public ArcaniumExtractorRecipe(ResourceLocation p_i50022_1_, String p_i50022_2_, Ingredient p_i50022_3_, ItemStack p_i50022_4_, float p_i50022_5_, int p_i50022_6_) {
        super(RecipeRegistry.RecipeTypes.ARCANIUM_EXTRACTORRECIPE_TYPE, p_i50022_1_, p_i50022_2_, p_i50022_3_, p_i50022_4_, p_i50022_5_, p_i50022_6_);
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(BlockRegistry.arcaniumExtractor);
    }

    public IRecipeSerializer<?> getSerializer() {
        return RecipeRegistry.Serailizers.ARCANIUM_EXTRACTOR_SERIALIZER.get();
    }

    public static class Serializer extends CookingRecipeSerializer<ArcaniumExtractorRecipe> {

        public Serializer() {
            super(ArcaniumExtractorRecipe::new, 100);
        }
    }

}
