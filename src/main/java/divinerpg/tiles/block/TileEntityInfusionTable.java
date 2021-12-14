package divinerpg.tiles.block;

import divinerpg.client.containers.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class TileEntityInfusionTable extends LockableTileEntity implements ITickableTileEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);

    public TileEntityInfusionTable() {
        super(TileRegistry.INFUSION_TABLE);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(BlockRegistry.infusionTable.getDescriptionId());
    }

    public int getContainerSize() {
        return this.items.size();
    }


    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(p_230337_2_, this.items);
    }

    public CompoundNBT save(CompoundNBT p_189515_1_) {
        super.save(p_189515_1_);
        ItemStackHelper.saveAllItems(p_189515_1_, this.items);
        return p_189515_1_;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return ItemStackHelper.removeItem(this.items, index, count);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return ItemStackHelper.takeItem(this.items, i);
    }

    @Override
    public void setItem(int index, ItemStack itemstack) {
        this.items.set(index, itemstack);
        if (itemstack != null && itemstack.getCount() > getMaxStackSize()) {
            itemstack.setCount(getMaxStackSize());
        }
    }

    public boolean stillValid(PlayerEntity p_70300_1_) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return !(p_70300_1_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) > 64.0D);
        }
    }

    public void clearContent() {
        this.items.clear();
    }

    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return new InfusionTableContainer(p_213906_1_, p_213906_2_, this, new IntArray(3));
    }

    @Override
    public void tick() {
        ItemStack inputStack = items.get(0);
        ItemStack templateStack = items.get(1);

        if(!inputStack.isEmpty() && !templateStack.isEmpty()) {
            Item input = items.get(0).getItem();
            Item template = items.get(1).getItem();
            int inputCount = items.get(0).getCount();

            InfusionTableRecipes x = InfusionTableRecipes.instance;
            Item item = x.getOutput(input, template, inputCount);
            if(item != null) {
                items.set(2, new ItemStack(item));
                items.set(0, ItemStack.EMPTY);
            }
            else {
                items.set(2, ItemStack.EMPTY);
            }
        }
        else {
//            items.set(2, ItemStack.EMPTY);
        }
    }



}