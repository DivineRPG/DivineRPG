package divinerpg.compat.jei.category;

//import divinerpg.*;
//import divinerpg.recipe.*;
//import divinerpg.registries.*;
//import net.minecraft.network.chat.*;
//import net.minecraft.resources.*;
//import net.minecraft.world.item.*;

import divinerpg.DivineRPG;
import divinerpg.recipe.ArcaniumExtractorRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ArcaniumExtractorCategory implements IRecipeCategory<ArcaniumExtractorRecipe> {

    public static final ResourceLocation ARCANIUM_EXTRACTOR = new ResourceLocation(DivineRPG.MODID, "textures/gui/jei/arcanium_extractor.png");

    private final IDrawable back, icon;

    public ArcaniumExtractorCategory(IGuiHelper helper) {
        this.back = helper.createDrawable(ARCANIUM_EXTRACTOR, 1, 1, 167, 78);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor"))));
    }


    @Override
    public RecipeType<ArcaniumExtractorRecipe> getRecipeType() {
        return RecipeType.create(DivineRPG.MODID, "arcanium_extractor", ArcaniumExtractorRecipe.class);
    }

    @Override
    public Component getTitle() {
        return Component.translatable(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor")).getDescriptionId());
    }

    @Override
    public IDrawable getBackground() {
        return back;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ArcaniumExtractorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 51, 12).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.CATALYST, 51, 48).addItemStack(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "collector"))));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 111, 30).addItemStack(recipe.getResultItem());
    }

}
