package divinerpg.recipe;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.arcaniumExtractor;
import static divinerpg.registries.RecipeRegistry.Serializers.ARCANIUM_EXTRACTOR_SERIALIZER;
import static divinerpg.registries.RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {
    public static final RecipeType<ArcaniumExtractorRecipe> TYPE = RecipeType.simple(Identifier.fromNamespaceAndPath(MODID, "arcanium_extractor"));
    public static final RecipeSerializer<ArcaniumExtractorRecipe> SERIALIZER = new RecipeSerializer<>(cookingMapCodec(ArcaniumExtractorRecipe::new), cookingStreamCodec(ArcaniumExtractorRecipe::new));
    public ArcaniumExtractorRecipe(Recipe.CommonInfo commonInfo, CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }
    public ArcaniumExtractorRecipe(Recipe.CommonInfo commonInfo, CookingBookInfo bookInfo, Ingredient ingredient, Item result, float experience, int cookingTime) {
        this(commonInfo, bookInfo, ingredient, new ItemStackTemplate(result), experience, cookingTime);
    }
    @Override protected Item furnaceIcon() {
        return arcaniumExtractor.asItem();
    }
    @Override public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return ARCANIUM_EXTRACTOR_SERIALIZER.get();
    }
    @Override public RecipeType<? extends AbstractCookingRecipe> getType() {
        return ARCANIUM_EXTRACTOR_RECIPE_TYPE.get();
    }
    @Override public RecipeBookCategory recipeBookCategory() {
        CookingBookCategory cookingCat = category();
        if(cookingCat == CookingBookCategory.FOOD) return RecipeBookCategories.FURNACE_FOOD;
        else if(cookingCat == CookingBookCategory.BLOCKS) return RecipeBookCategories.FURNACE_BLOCKS;
        return RecipeBookCategories.FURNACE_MISC;
    }
    @Override public String toString() {
        return "arcanium_extractor";
    }
    public Ingredient getExtractorInput() {
        return input();
    }
    public ItemStackTemplate getExtractorResult() {
        return result();
    }
}