package divinerpg.recipe;

import divinerpg.DivineRPG;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public ArcaniumExtractorRecipe(String p_249518_, CookingBookCategory p_250891_, Ingredient p_251354_, ItemStack p_252185_, float p_252165_, int p_250256_) {
        super(RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), p_249518_, p_250891_, p_251354_, p_252185_, p_252165_, p_250256_);
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor")));
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.Serailizers.ARCANIUM_EXTRACTOR_SERIALIZER.get();
    }
    @Override
    public String toString() {
    	return "arcanium_extractor";
    }
    public static class Type implements RecipeType<ArcaniumExtractorRecipe> {
        private Type() {}
        public static final ArcaniumExtractorRecipe.Type INSTANCE = new ArcaniumExtractorRecipe.Type();
        public static final String ID = "arcanium_extractor";
        @Override
        public String toString() {
        	return ID;
        }
    }
}