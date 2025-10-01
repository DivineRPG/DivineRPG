package divinerpg.recipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.arcaniumExtractor;
import static divinerpg.registries.RecipeRegistry.Serializers.ARCANIUM_EXTRACTOR_SERIALIZER;
import static divinerpg.registries.RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public ArcaniumExtractorRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack stack, float xp, int time) {
        super(ARCANIUM_EXTRACTOR_RECIPE_TYPE.get(), group, category, ingredient, stack, xp, time);
    }
    @Override public ItemStack getToastSymbol() {return arcaniumExtractor.toStack();}
    @Override public RecipeSerializer<?> getSerializer() {return ARCANIUM_EXTRACTOR_SERIALIZER.get();}
    @Override public String toString() {return "arcanium_extractor";}
    public static final RecipeType<ArcaniumExtractorRecipe> TYPE = RecipeType.simple(ResourceLocation.fromNamespaceAndPath(MODID, "arcanium_extractor"));
}