package naturix.divinerpg.objects.items;

import naturix.divinerpg.objects.items.food.ItemFoodBase;
import net.minecraft.item.ItemStack;

public class ItemFastFood extends ItemFoodBase {

    public ItemFastFood(int healAmount, float saturation, boolean isWolfFood, String name) {
        super(healAmount, saturation, isWolfFood, name);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }
}
