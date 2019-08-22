package naturix.divinerpg.compat.jei.base;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import naturix.divinerpg.utils.Reference;
import net.minecraft.util.ResourceLocation;

public class VillagerCategory implements IRecipeCategory {

    // Taken from vanilla villager GUI
    private final IDrawableStatic background;
    /**
     * The X size of the inventory window in pixels.
     */
    private int xSize = 176;
    /**
     * The Y size of the inventory window in pixels.
     */
    private int ySize = 82;
    private String uid;
    private String title;

    public VillagerCategory(IGuiHelper helper,
                            ResourceLocation background,
                            String uid,
                            String title) {
        this.uid = uid;
        this.title = title;
        this.background = helper.createDrawable(background, 0, 0, xSize, xSize);
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
        return Reference.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
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
