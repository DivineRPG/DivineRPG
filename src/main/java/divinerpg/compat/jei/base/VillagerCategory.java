package divinerpg.compat.jei.base;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class VillagerCategory implements IRecipeCategory {

    // Taken from vanilla villager GUI
    private final IDrawableStatic background;
    /**
     * The X size of the inventory window in pixels.
     */
    public int xSize = 176;
    /**
     * The Y size of the inventory window in pixels.
     */
    public int ySize = 82;
    private String uid;
    private String title;
    private IDrawable icon;

    public VillagerCategory(IGuiHelper helper,
                            ResourceLocation background,
                            String uid,
                            String title,
                            Item icon) {
        this(helper, background, uid, title, new ItemStack(icon));
    }

    public VillagerCategory(IGuiHelper helper,
                            ResourceLocation background,
                            String uid,
                            String title,
                            ItemStack stack) {
        this.uid = uid;
        this.title = title;
        this.background = helper.createDrawable(background, 0, 0, xSize, ySize);
        this.icon = helper.createDrawableIngredient(stack);
    }



    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getModName() {
        return "DivineRPG";
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Nullable
    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = layout.getItemStacks();

        itemStacks.init(0, true, 35, 52);
        itemStacks.init(1, true, 61, 52);
        itemStacks.init(2, false, 119, 52);

        itemStacks.set(ingredients);
    }
}
