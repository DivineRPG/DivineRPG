package divinerpg.client.containers;

import divinerpg.client.containers.slot.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

public class ArcaniumExtractorContainer extends RecipeBookContainer<IInventory> {
    private final IInventory container;
    private final IIntArray data;
    protected final World level;
    private final IRecipeType<? extends ArcaniumExtractorRecipe> recipeType;


    public ArcaniumExtractorContainer(int id, PlayerInventory inventory, net.minecraft.network.PacketBuffer extraData)
    {
        this(id, inventory, new Inventory(3), new IntArray(4));
    }
    public ArcaniumExtractorContainer(int id, PlayerInventory playerInventory, IInventory inventory, IIntArray data) {
        super(ContainerRegistry.ARCANIUM_EXTRACTOR.get(), id);
        this.recipeType = RecipeRegistry.RecipeTypes.ARCANIUM_EXTRACTORRECIPE_TYPE;
        checkContainerSize(inventory, 3);
        checkContainerDataCount(data, 4);
        this.container = inventory;
        this.data = data;
        this.level = playerInventory.player.level;
        this.addSlot(new Slot(inventory, 0, 56, 17));
        this.addSlot(new ArcaniumExtractorFuelSlot(this, inventory, 1, 56, 53));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, inventory, 2, 116, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(data);
    }

    public void fillCraftSlotsStackedContents(RecipeItemHelper itemHelper) {
        if (this.container instanceof IRecipeHelperPopulator) {
            ((IRecipeHelperPopulator)this.container).fillStackedContents(itemHelper);
        }

    }

    public void clearCraftingContent() {
        this.container.clearContent();
    }

    public void handlePlacement(boolean p_217056_1_, IRecipe<?> p_217056_2_, ServerPlayerEntity p_217056_3_) {
        (new ServerRecipePlacerFurnace<>(this)).recipeClicked(p_217056_3_, (IRecipe<IInventory>) p_217056_2_, p_217056_1_);
    }

    public boolean recipeMatches(IRecipe<? super IInventory> iRecipe) {
        return iRecipe.matches(this.container, this.level);
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

    @Override
    public RecipeBookCategory getRecipeBookType() {
        return null;
    }

    public boolean stillValid(PlayerEntity entity) {
        return this.container.stillValid(entity);
    }

    public ItemStack quickMoveStack(PlayerEntity p_82846_1_, int i) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (i == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (i != 1 && i != 0) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (i >= 3 && i < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (i >= 30 && i < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
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

    public boolean isFuel(ItemStack stack) {
        return TileEntityArcaniumExtractor.getFuel().containsKey(stack.getItem());
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

}