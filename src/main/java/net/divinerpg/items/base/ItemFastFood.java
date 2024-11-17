package net.divinerpg.items.base;

import net.minecraft.item.ItemStack;

public class ItemFastFood extends ItemModFood{

	public ItemFastFood(int food, float sat, boolean wolfFood, String name) {
		super(food, sat, wolfFood, name);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}

}
