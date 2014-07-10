package net.divinerpg.blocks.arcana.container.tile_entity;

import cpw.mods.fml.common.registry.GameRegistry;

import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.utils.recipes.ExtractorRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public class TileEntityExtractor extends TileEntityModFurnace {

	public TileEntityExtractor() {
		super("Extractor", true, 400);
	}
	
	@Override
    public void updateEntity() {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if(this.furnaceBurnTime > 0) --this.furnaceBurnTime;

        if(!this.worldObj.isRemote) {
            if(this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

                if(this.furnaceBurnTime > 0) {
                    flag1 = true;

                    if(this.furnaceItemStacks[1] != null) {
                        --this.furnaceItemStacks[1].stackSize;

                        if(this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                        }
                    }
                }
            }

            if(this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;

                if(this.furnaceCookTime == speed) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }

            if(flag != this.furnaceBurnTime > 0) {
                flag1 = true;
            }
        }

        if(flag1) this.markDirty();
    }

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			ItemStack itemstack = ExtractorRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			if (itemstack == null) return false;
			if (this.furnaceItemStacks[2] == null) return true;
			if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) return false;
			int result = furnaceItemStacks[2].stackSize + itemstack.stackSize;
			return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
		}
	}

	public void smeltItem() {
		if(this.canSmelt()) {
			ItemStack itemstack = ExtractorRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

			if(this.furnaceItemStacks[2] == null) 
				this.furnaceItemStacks[2] = itemstack.copy();

			else if(this.furnaceItemStacks[2].getItem() == itemstack.getItem()) 
				this.furnaceItemStacks[2].stackSize += itemstack.stackSize;


			--this.furnaceItemStacks[0].stackSize;

			if(this.furnaceItemStacks[0].stackSize <= 0) this.furnaceItemStacks[0] = null;
		}
	}
	
	public int getItemBurnTime(ItemStack stack) {
		return stack != null ? 400 : 0;
	}

	@Override
	public void addUpdate() { }
}