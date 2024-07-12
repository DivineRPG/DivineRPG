package divinerpg.compat.jei;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.category.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import javax.annotation.Nonnull;
import java.util.*;

@JeiPlugin
public final class JEICompat
        implements IModPlugin
{

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.coalstoneFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.demonFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.greenlightFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.moltenFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.moonlightFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.oceanfireFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.whitefireFurnace.asItem()), RecipeTypes.SMELTING, RecipeTypes.FUELING);

        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.arcaniumExtractor.get()), ArcaniumExtractorCategory.ARCANIUM_EXTRACTOR_TYPE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.infusionTable.get()), InfusionTableCategory.INFUSION_TABLE_TYPE);
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ArcaniumExtractorCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new InfusionTableCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration){
        List<ArcaniumExtractorRecipe> arcaniumExtractorRecipes = new ArrayList<>();
        List<InfusionTableRecipe> infusionTableRecipes = new ArrayList<>();

        @SuppressWarnings("resource")
		RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();

        for (Recipe<?> i : manager.getRecipes()) {
            if (i instanceof ArcaniumExtractorRecipe arcaniumExtractorRecipe) {
                arcaniumExtractorRecipes.add(arcaniumExtractorRecipe);
            }
        }

        for (Recipe<?> i : manager.getRecipes()) {
            if (i instanceof InfusionTableRecipe infusionTableRecipe) {
                infusionTableRecipes.add(infusionTableRecipe);
            }
        }


        registration.addRecipes(ArcaniumExtractorCategory.ARCANIUM_EXTRACTOR_TYPE, arcaniumExtractorRecipes);
        registration.addRecipes(InfusionTableCategory.INFUSION_TABLE_TYPE, infusionTableRecipes);

    }


}
