package divinerpg.recipe;

import divinerpg.DivineRPG;
import divinerpg.registries.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.ForgeRegistries;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public ArcaniumExtractorRecipe(ResourceLocation p_i50022_1_, String p_i50022_2_, Ingredient p_i50022_3_, ItemStack p_i50022_4_, float p_i50022_5_, int p_i50022_6_) {
        super(Type.INSTANCE, p_i50022_1_, p_i50022_2_, p_i50022_3_, p_i50022_4_, p_i50022_5_, p_i50022_6_);
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