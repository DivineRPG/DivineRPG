package divinerpg.containers;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

public abstract class DivineFurnaceContainer extends RecipeBookContainer<IInventory> {
    private final IInventory container;
    private final IIntArray data;
    protected final World level;
    private final IRecipeType<? extends AbstractCookingRecipe> recipeType;
    private final RecipeBookCategory recipeBookType;

    protected DivineFurnaceContainer(ContainerType<?> p_i241921_1_, IRecipeType<? extends AbstractCookingRecipe> p_i241921_2_, RecipeBookCategory p_i241921_3_, int p_i241921_4_, PlayerInventory p_i241921_5_) {
        this(p_i241921_1_, p_i241921_2_, p_i241921_3_, p_i241921_4_, p_i241921_5_, new Inventory(3), new IntArray(4));
    }

    protected DivineFurnaceContainer(ContainerType<?> p_i241922_1_, IRecipeType<? extends AbstractCookingRecipe> p_i241922_2_, RecipeBookCategory p_i241922_3_, int p_i241922_4_, PlayerInventory p_i241922_5_, IInventory p_i241922_6_, IIntArray p_i241922_7_) {
        super(p_i241922_1_, p_i241922_4_);
        this.recipeType = p_i241922_2_;
        this.recipeBookType = p_i241922_3_;
        checkContainerSize(p_i241922_6_, 3);
        checkContainerDataCount(p_i241922_7_, 4);
        this.container = p_i241922_6_;
        this.data = p_i241922_7_;
        this.level = p_i241922_5_.player.level;
        this.addSlot(new Slot(p_i241922_6_, 0, 56, 17));
        this.addSlot(new FurnaceResultSlot(p_i241922_5_.player, p_i241922_6_, 2, 116, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_i241922_5_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_i241922_5_, k, 8 + k * 18, 142));
        }

        this.addDataSlots(p_i241922_7_);
    }

    public void fillCraftSlotsStackedContents(RecipeItemHelper p_201771_1_) {
        if (this.container instanceof IRecipeHelperPopulator) {
            ((IRecipeHelperPopulator)this.container).fillStackedContents(p_201771_1_);
        }

    }

    public void clearCraftingContent() {
        this.container.clearContent();
    }

    public void handlePlacement(boolean p_217056_1_, IRecipe<?> p_217056_2_, ServerPlayerEntity p_217056_3_) {
        (new ServerRecipePlacerFurnace<>(this)).recipeClicked(p_217056_3_, (IRecipe<IInventory>) p_217056_2_, p_217056_1_);
    }

    public boolean recipeMatches(IRecipe<? super IInventory> p_201769_1_) {
        return p_201769_1_.matches(this.container, this.level);
    }

    public int getResultSlotIndex() {
        return 2;
    }

    public int getGridWidth() {
        return 1;
    }

    public int getGridHeight() {
        return 1;
    }

    @OnlyIn(Dist.CLIENT)
    public int getSize() {
        return 3;
    }

    public boolean stillValid(PlayerEntity p_75145_1_) {
        return this.container.stillValid(p_75145_1_);
    }

    public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_82846_2_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_82846_2_ == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_82846_2_ != 1 && p_82846_2_ != 0) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

    protected boolean canSmelt(ItemStack p_217057_1_) {
        return this.level.getRecipeManager().getRecipeFor((IRecipeType)this.recipeType, new Inventory(p_217057_1_), this.level).isPresent();
    }

    protected boolean isFuel(ItemStack p_217058_1_) {
        return AbstractFurnaceTileEntity.isFuel(p_217058_1_);
    }

    @OnlyIn(Dist.CLIENT)
    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isLit() {
        return this.data.get(0) > 0;
    }

    @OnlyIn(Dist.CLIENT)
    public RecipeBookCategory getRecipeBookType() {
        return this.recipeBookType;
    }
}