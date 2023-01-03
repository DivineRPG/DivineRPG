package divinerpg.recipe;

import divinerpg.DivineRPG;
import divinerpg.registries.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.ForgeRegistries;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public ArcaniumExtractorRecipe(ResourceLocation p_249157_, String p_250200_, CookingBookCategory p_251114_, Ingredient p_250340_, ItemStack p_250306_, float p_249577_, int p_250030_) {
        super(RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), p_249157_, p_250200_, p_251114_, p_250340_, p_250306_, p_249577_, p_250030_);
    }
    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor")));
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