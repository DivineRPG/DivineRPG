package divinerpg.recipe;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.BlockRegistry.arcaniumExtractor;
import static divinerpg.registries.RecipeRegistry.Serializers.ARCANIUM_EXTRACTOR_SERIALIZER;
import static divinerpg.registries.RecipeRegistry.Types.ARCANIUM_EXTRACTOR_RECIPE_TYPE;

public class ArcaniumExtractorRecipe extends AbstractCookingRecipe {

    public ArcaniumExtractorRecipe(Recipe.CommonInfo commonInfo, CookingBookInfo bookInfo, Ingredient ingredient, ItemStackTemplate result, float experience, int cookingTime) {
        super(commonInfo, bookInfo, ingredient, result, experience, cookingTime);
    }

    @Override
    protected Item furnaceIcon() {
        return arcaniumExtractor.asItem();
    }

    @Override
    public RecipeSerializer<? extends AbstractCookingRecipe> getSerializer() {
        return ARCANIUM_EXTRACTOR_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return ARCANIUM_EXTRACTOR_RECIPE_TYPE.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    @Override
    public String toString() {
        return "arcanium_extractor";
    }

    public Ingredient getExtractorInput() {
        return this.input();
    }

    public ItemStackTemplate getExtractorResult() {
        return this.result();
    }

    public static final RecipeType<ArcaniumExtractorRecipe> TYPE = RecipeType.simple(
            Identifier.fromNamespaceAndPath(MODID, "arcanium_extractor")
    );

    public static final RecipeSerializer<ArcaniumExtractorRecipe> SERIALIZER = new RecipeSerializer<>(
            cookingMapCodec(ArcaniumExtractorRecipe::new, 200),
            cookingStreamCodec(ArcaniumExtractorRecipe::new)
    );
}