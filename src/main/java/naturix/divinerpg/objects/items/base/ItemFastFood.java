package naturix.divinerpg.objects.items.base;

import net.minecraft.item.ItemStack;

public class ItemFastFood extends ItemModFood {

    public ItemFastFood(int healAmount, float saturation, boolean isWolfFood, String name) {
        super(healAmount, saturation, isWolfFood, name);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }
}
