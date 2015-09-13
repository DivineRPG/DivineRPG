package net.divinerpg.utils.items;

import net.divinerpg.items.base.ItemFastFood;
import net.divinerpg.items.base.ItemModFood;
import net.minecraft.item.Item;

public class ItemsFood {

	public static Item bacon = new ItemModFood(2,3.0F,true,"bacon");
 
	public static Item hotPie = new ItemModFood(5, 7.0F, true, "hotPumpkinPie");
	public static Item boiledEgg = new ItemModFood(4, 0.5F, false, "boiledEgg");
	public static Item cheese = new ItemModFood(2, 0.2F, false, "cheese");
	public static Item whiteMushroom = new ItemModFood(1, 0.1F, false, "whiteMushroom");
	public static Item advMushroomStew = new ItemModFood(10, 10.0F, false, "advancedMushroomStew");
	public static Item chickenDinner = new ItemModFood(20, 20.0F, false, "chickenDinner");
	public static Item tomato = new ItemModFood(4, 0.3F, false, "tomato");
	public static Item donut = new ItemModFood(16, 0.3F, false, "donut");
	public static Item rawEmpoweredMeat = new ItemModFood(5, 2.0F, true, "rawEmpoweredMeat");
	public static Item empoweredMeat = new ItemModFood(10, 4.0F, true, "empoweredMeat");
	public static Item magicMeat = new ItemFastFood(5, 1.0F, true, "magicMeat");
	public static Item enrichedMagicMeat = new ItemFastFood(7, 2.5F, true, "enrichedMagicMeat");
	
	public static void init(){}
}
