package naturix.divinerpg.compat.jei.base;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SmelterCategory extends VillagerCategory {

    private IDrawableAnimated animatedFlame;
    private IDrawableAnimated arrow;

    public SmelterCategory(IGuiHelper helper, ResourceLocation background, String uid, String title, ItemStack stack) {
        super(helper, background, uid, title, stack);
        animatedFlame = helper.drawableBuilder(background, 176, 0, 14, 14)
                .buildAnimated(200, IDrawableAnimated.StartDirection.BOTTOM, false);

        arrow = helper.drawableBuilder(background, 176, 14, 24, 17)
                .buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = layout.getItemStacks();

        itemStacks.init(0, true, 55, 16);
        itemStacks.init(1, true, 55, 52);
        itemStacks.init(2, false, 115, 34);

        itemStacks.set(ingredients);
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedFlame.draw(minecraft, 57, 36);
        arrow.draw(minecraft, 79, 35);
    }

}
