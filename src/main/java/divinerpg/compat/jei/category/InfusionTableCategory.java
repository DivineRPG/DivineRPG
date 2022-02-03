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

import java.util.*;

public class InfusionTableCategory implements IRecipeCategory<InfusionTableRecipe> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/jei/infusion_table.png");

    private final IDrawable back;
    private final IDrawable icon;
    private final ICraftingGridHelper craftingGridHelper;

    public InfusionTableCategory(IGuiHelper helper) {
        this.back = helper.createDrawable(TEXTURE, 1, 1, 166, 76);
        this.icon = helper.createDrawableIngredient(new ItemStack(BlockRegistry.infusionTable));
        craftingGridHelper = helper.createCraftingGridHelper(0);
    }

    @Override
    public ResourceLocation getUid() {
        return TEXTURE;
    }

    @Override
    public Class<? extends InfusionTableRecipe> getRecipeClass() {
        return InfusionTableRecipe.class;
    }

    @Override
    public String getTitle() {
        return new TranslationTextComponent(BlockRegistry.infusionTable.getDescriptionId()).getString();
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
    public void setIngredients(InfusionTableRecipe recipe, IIngredients ingredients) {
        List<List<ItemStack>> itemStacks = new ArrayList<>();
        itemStacks.add(Arrays.asList(recipe.input.getItems()));
        itemStacks.add(Arrays.asList(recipe.template.getItems()));
        itemStacks.add(Collections.singletonList(recipe.getResultItem()));
        ingredients.setInputLists(VanillaTypes.ITEM, itemStacks);
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, InfusionTableRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();

        int index = 0;
        itemStackGroup.init(index, true, 11, 33);
        itemStackGroup.set(index, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        index++;
        itemStackGroup.init(index, true, 11, 53);
        itemStackGroup.set(index, ingredients.getInputs(VanillaTypes.ITEM).get(1));
        index++;
        itemStackGroup.init(index, false, 56, 43);
        itemStackGroup.set(index, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}