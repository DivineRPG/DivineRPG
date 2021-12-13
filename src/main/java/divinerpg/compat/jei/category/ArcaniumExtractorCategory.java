package divinerpg.compat.jei.category;

import divinerpg.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import mezz.jei.api.constants.*;
import mezz.jei.api.gui.*;
import mezz.jei.api.gui.drawable.*;
import mezz.jei.api.gui.ingredient.*;
import mezz.jei.api.helpers.*;
import mezz.jei.api.ingredients.*;
import mezz.jei.api.recipe.category.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class ArcaniumExtractorCategory implements IRecipeCategory<ArcaniumExtractorRecipe> {
    public static final ResourceLocation ARCANIUM_EXTRACTOR = new ResourceLocation(DivineRPG.MODID, "textures/gui/jei/arcanium_extractor.png");

    private final IDrawable back;
    private final IDrawable icon;

    public ArcaniumExtractorCategory(IGuiHelper helper) {
        this.back = helper.createDrawable(ARCANIUM_EXTRACTOR, 1, 1, 167, 78);
        this.icon = helper.createDrawableIngredient(new ItemStack(BlockRegistry.arcaniumExtractor));
    }

    @Override
    public ResourceLocation getUid() {
        return ARCANIUM_EXTRACTOR;
    }

    @Override
    public Class<? extends ArcaniumExtractorRecipe> getRecipeClass() {
        return ArcaniumExtractorRecipe.class;
    }

    @Override
    public String getTitle() {
        return new TranslationTextComponent("category." + DivineRPG.MODID + ".arcanium_extractor").getString();
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
    public void setIngredients(ArcaniumExtractorRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ArcaniumExtractorRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();

        itemStackGroup.init(0, true, 50, 11);
        itemStackGroup.init(1, true, 50, 47);
        itemStackGroup.set(1, new ItemStack(ItemRegistry.collector));
        itemStackGroup.init(2, false, 110, 29);

        itemStackGroup.set(ingredients);
    }

}
