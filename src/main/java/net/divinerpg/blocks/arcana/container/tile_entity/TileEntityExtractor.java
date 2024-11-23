package net.divinerpg.blocks.arcana.container.tile_entity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.blocks.base.tileentity.TileEntityModFurnace;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.recipes.ExtractorRecipes;
import net.minecraft.item.ItemStack;

public class TileEntityExtractor extends TileEntityModFurnace {

    public TileEntityExtractor() {
        super("Extractor", 100);
    }

    @Override
    public void updateEntity() {
        boolean wasBurning = this.furnaceBurnTime > 0;
        boolean needsUpdate = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }
        if (!this.worldObj.isRemote) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
                if (this.furnaceBurnTime > 0) {
                    needsUpdate = true;
                    if (this.furnaceItemStacks[1] != null) {
                        --this.furnaceItemStacks[1].stackSize;
                        if (this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = this.furnaceItemStacks[1].getItem().getContainerItem(this.furnaceItemStacks[1]);
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if (this.furnaceCookTime >= this.speed) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    needsUpdate = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }
            if (wasBurning != (this.furnaceBurnTime > 0)) {
                needsUpdate = true;
                this.updateBlock();
            }
        }
        if (needsUpdate) {
            this.markDirty();
        }
    }

    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        } else {
            ItemStack result = ExtractorRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
            if (result == null) return false;
            if (this.furnaceItemStacks[2] == null) return true;
            if (!this.furnaceItemStacks[2].isItemEqual(result)) return false;
            int outputStackSize = this.furnaceItemStacks[2].stackSize + result.stackSize;
            return outputStackSize <= getInventoryStackLimit() && outputStackSize <= this.furnaceItemStacks[2].getMaxStackSize();
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack result = ExtractorRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = result.copy();
            } else if (this.furnaceItemStacks[2].isItemEqual(result)) {
                this.furnaceItemStacks[2].stackSize += result.stackSize;
            }
            --this.furnaceItemStacks[0].stackSize;

            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }
        }
    }

    @Override
    public int getItemBurnTime(ItemStack stack) {
        if (stack == null || stack.getItem() != ArcanaItems.chargedCollector) {
            return 0;
        }
        return 400;
    }
}
