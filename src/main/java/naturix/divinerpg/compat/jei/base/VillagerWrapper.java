package naturix.divinerpg.compat.jei.base;

import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;

import java.util.List;

public class VillagerWrapper implements IRecipeWrapper {

    private ItemStack left;
    private ItemStack right;
    private ItemStack result;


    public VillagerWrapper(MerchantRecipe recipe) {
        this.left = recipe.getItemToBuy();
        this.right = recipe.getSecondItemToBuy();
        this.result = recipe.getItemToSell();
    }

    @Override
    public void getIngredients(IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Lists.asList(left, right, new ItemStack[0]));
        iIngredients.setOutput(VanillaTypes.ITEM, result);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        // TODO do not have idea what to draw
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return Lists.newArrayList();
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }
}
