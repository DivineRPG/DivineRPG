package net.divinerpg.blocks.vethea.container;

import net.divinerpg.utils.recipes.RecipesInfusionTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotInfusion extends SlotFurnace {

	public SlotInfusion(EntityPlayer p_i1813_1_, IInventory p_i1813_2_, int p_i1813_3_, int p_i1813_4_, int p_i1813_5_) {
		super(p_i1813_1_, p_i1813_2_, p_i1813_3_, p_i1813_4_, p_i1813_5_);
	}
	
	@Override
	protected void onCrafting(ItemStack stack) {
		if(inventory.getStackInSlot(2) == null) {
			if(inventory.getStackInSlot(0) != null && inventory.getStackInSlot(1) != null) {
				Item item1 = inventory.getStackInSlot(0).getItem();
				Item item2 = inventory.getStackInSlot(1).getItem();
				int c = inventory.getStackInSlot(0).stackSize;
				if(item1 != null && item2 != null) {
					RecipesInfusionTable x = new RecipesInfusionTable();
					Item item = x.getOutput(item1, item2, c);
					if(item != null) {
						inventory.decrStackSize(0, c);
						inventory.decrStackSize(1, 1);
					}
				}
			}
		}
	}
}