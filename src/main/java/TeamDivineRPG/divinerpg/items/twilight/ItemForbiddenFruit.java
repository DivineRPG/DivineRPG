package TeamDivineRPG.divinerpg.items.twilight;

import TeamDivineRPG.divinerpg.DivineRPG;
import TeamDivineRPG.divinerpg.items.base.ItemModFood;
import TeamDivineRPG.divinerpg.util.FoodList;

public class ItemForbiddenFruit extends ItemModFood {
    public ItemForbiddenFruit() {
        super("forbidden_fruit", FoodList.FORBIDDEN_FRUIT, DivineRPG.tabs.food);
    }
}
