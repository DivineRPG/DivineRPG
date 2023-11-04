package divinerpg.compat.jei;

import divinerpg.DivineRPG;
import divinerpg.compat.jei.category.*;
import divinerpg.recipe.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.*;

@JeiPlugin
public final class JEICompat
        implements IModPlugin
{

    public static final ResourceLocation UID = new ResourceLocation(DivineRPG.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipeCatalysts(@Nonnull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demon_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "greenlight_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "molten_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "oceanfire_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "whitefire_furnace"))), RecipeTypes.SMELTING, RecipeTypes.FUELING);

        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor"))), ArcaniumExtractorCategory.ARCANIUM_EXTRACTOR_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "infusion_table"))), InfusionTableCategory.INFUSION_TABLE_TYPE);
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
