package divinerpg.compat.jei.ingredient;

import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class NoRender implements IIngredientRenderer<ItemStack> {
    @Override
    public void render(GuiGraphics guiGraphics, ItemStack ingredient) {

    }
    @Override @SuppressWarnings({"deprecated", "removal"})
    public List<Component> getTooltip(ItemStack ingredient, TooltipFlag tooltipFlag) {
        return ingredient.getTooltipLines(Item.TooltipContext.EMPTY, null, tooltipFlag);
    }
}
