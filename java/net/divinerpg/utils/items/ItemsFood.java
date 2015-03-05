package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemFastFood;
import net.divinerpg.items.base.ItemModFood;
import net.minecraft.item.Item;

public class ItemsFood {

    public static Item bacon;
    public static Item hotPie;
    public static Item boiledEgg;
    public static Item cheese;
    public static Item whiteMushroom;
    public static Item advMushroomStew;
    public static Item chickenDinner;
    public static Item tomato;
    public static Item donut;
    public static Item rawEmpoweredMeat;
    public static Item empoweredMeat;
    public static Item magicMeat;
    public static Item enrichedMagicMeat;
    
    public static void init() {
    	bacon              = new ItemModFood(2, 3.0F, true, "bacon");
    	hotPie              = new ItemModFood(5, 7.0F, true, "hotPumpkinPie");
        boiledEgg          = new ItemModFood(4, 0.5F, false, "boiledEgg");
        cheese             = new ItemModFood(2, 0.2F, false, "cheese");
        whiteMushroom      = new ItemModFood(1, 0.1F, false, "whiteMushroom");
        advMushroomStew    = new ItemModFood(10, 10.0F, false, "advancedMushroomStew");
        chickenDinner      = new ItemModFood(20, 20.0F, false, "chickenDinner");
        tomato             = new ItemModFood(4, 0.3F, false, "tomato");
        donut              = new ItemModFood(16, 0.3F, false, "donut");
        rawEmpoweredMeat   = new ItemModFood(5, 2.0F, true, "rawEmpoweredMeat");
        empoweredMeat      = new ItemModFood(10, 4.0F, true, "empoweredMeat");
        magicMeat			= new ItemFastFood(5, 1.0F, true, "magicMeat");
        enrichedMagicMeat	= new ItemFastFood(7, 2.5F, true, "enrichedMagicMeat");
    }
}
