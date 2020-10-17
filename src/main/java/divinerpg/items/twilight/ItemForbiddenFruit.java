package divinerpg.items.twilight;


import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModFood;
import divinerpg.util.FoodList;

public class ItemForbiddenFruit extends ItemModFood {
    public ItemForbiddenFruit() {
        super("forbidden_fruit", FoodList.FORBIDDEN_FRUIT, DivineRPG.tabs.food);
    }
}
