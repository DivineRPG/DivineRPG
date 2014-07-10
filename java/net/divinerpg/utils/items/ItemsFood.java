package net.divinerpg.utils.items;

import net.divinerpg.api.items.ItemModFood;
import net.minecraft.item.Item;

public class ItemsFood {

    public static final Item bacon              = new ItemModFood(1, 3.0F, true, "bacon");
    public static final Item baconCooked        = new ItemModFood(10, 10.0F, true, "baconCooked");
    public static final Item boiledEgg          = new ItemModFood(4, 0.5F, false, "boiledEgg");
    public static final Item cheese             = new ItemModFood(2, 0.2F, false, "cheese");
    public static final Item whiteMushroom      = new ItemModFood(1, 0.1F, false, "whiteMushroom");
    public static final Item advMushroomStew    = new ItemModFood(10, 10.0F, false, "advancedMushroomStew");
    public static final Item chickenDinner      = new ItemModFood(20, 20.0F, false, "chickenDinner");
    public static final Item tomato             = new ItemModFood(4, 0.3F, false, "tomato");
    public static final Item donut              = new ItemModFood(16, 0.3F, false, "donut");
    public static final Item rawEmpoweredMeat   = new ItemModFood(5, 2.0F, true, "rawEmpoweredMeat");
    public static final Item empoweredMeat      = new ItemModFood(10, 4.0F, true, "empoweredMeat");
    
}
