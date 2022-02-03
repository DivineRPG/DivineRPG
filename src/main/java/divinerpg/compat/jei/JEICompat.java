package divinerpg.compat.jei;

import divinerpg.*;
import divinerpg.compat.jei.category.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.*;
import mezz.jei.api.helpers.*;
import mezz.jei.api.registration.*;
import net.minecraft.client.*;
import net.minecraft.client.world.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;

import java.util.*;

@JeiPlugin
public final class JEICompat implements IModPlugin {
    public static final ResourceLocation UID = new ResourceLocation(DivineRPG.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.coalstoneFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.demonFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.greenlightFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.moltenFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.moonlightFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.oceanfireFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.whitefireFurnace), VanillaRecipeCategoryUid.FURNACE);


        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.arcaniumExtractor), ArcaniumExtractorCategory.ARCANIUM_EXTRACTOR);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.infusionTable), InfusionTableCategory.TEXTURE);
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(new ArcaniumExtractorCategory(guiHelper));
        registration.addRecipeCategories(new InfusionTableCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Results recipes = getAllRecipes();

        registration.addRecipes(recipes.arcaniumExtractorRecipes(), ArcaniumExtractorCategory.ARCANIUM_EXTRACTOR);
        registration.addRecipes(recipes.infusionTableRecipes(), InfusionTableCategory.TEXTURE);
    }



    public static class Results {
        private final List<ArcaniumExtractorRecipe> arcaniumExtractorRecipes = new ArrayList<>();
        private final List<InfusionTableRecipe> infusionTableRecipes = new ArrayList<>();

        public List<ArcaniumExtractorRecipe> arcaniumExtractorRecipes() {
            return arcaniumExtractorRecipes;
        }
        public List<InfusionTableRecipe> infusionTableRecipes() {
            return infusionTableRecipes;
        }
    }

    public static Results getAllRecipes() {

        Results results = new Results();
        ClientWorld world = Minecraft.getInstance().level;
        RecipeManager recipeManager = world.getRecipeManager();

        results.arcaniumExtractorRecipes.addAll(getRecipes(recipeManager, RecipeRegistry.RecipeTypes.ARCANIUM_EXTRACTOR_RECIPE_TYPE));
        results.infusionTableRecipes.addAll(getRecipes(recipeManager, DivineRPG.INFUSION_TABLE_RECIPE));

        return results;
    }

    @SuppressWarnings("unchecked")
    private static <C extends IInventory, T extends IRecipe<C>> Collection<T> getRecipes(RecipeManager recipeManager, IRecipeType<T> recipeType) {
        Map<ResourceLocation, IRecipe<C>> recipesMap = recipeManager.byType(recipeType);
        return (Collection<T>) recipesMap.values();
    }

}
