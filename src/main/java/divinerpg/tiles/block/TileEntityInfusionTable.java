package divinerpg.tiles.block;

import divinerpg.*;
import divinerpg.client.containers.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

import javax.annotation.*;

public class TileEntityInfusionTable extends LockableTileEntity implements ITickableTileEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
    private boolean recipeValid;
    private final Object2IntOpenHashMap<ResourceLocation> recipes = new Object2IntOpenHashMap<>();


    protected final IIntArray forgeData = new IIntArray() {
        public int get(int index) {
            switch (index) {
                case 0:
                    return TileEntityInfusionTable.this.recipeValid ? 1 : 0;
                default:
                    return 0;
            }
        }

        public void set(int index, int k) {
            switch (index) {
                case 0:
                    TileEntityInfusionTable.this.recipeValid = k == 1;
                    break;
            }
        }

        public int getCount() {
            return 2;
        }
    };
    ;

    public TileEntityInfusionTable() {
        super(TileRegistry.INFUSION_TABLE);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(BlockRegistry.infusionTable.getDescriptionId());
    }

    public int getContainerSize() {
        return this.items.size();
    }


    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(nbt, this.items);

        CompoundNBT compoundnbt = nbt.getCompound("RecipesUsed");
        this.recipeValid = nbt.getBoolean("RecipeValid");


        for (String s : compoundnbt.getAllKeys()) {
            this.recipes.put(new ResourceLocation(s), compoundnbt.getInt(s));
        }
    }

    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        ItemStackHelper.saveAllItems(nbt, this.items);
        CompoundNBT compoundnbt = new CompoundNBT();
        this.recipes.forEach((recipeId, craftedAmount) -> {
            compoundnbt.putInt(recipeId.toString(), craftedAmount);
        });
        nbt.put("RecipesUsed", compoundnbt);
        nbt.putBoolean("RecipeValid", this.recipeValid);
        return nbt;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < 2; i++) {
            if (!this.items.get(i).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    public ItemStack removeItem(int slot, int count) {
        return !this.items.get(slot).isEmpty() && count > 0 ? this.items.get(slot).split(count) : ItemStack.EMPTY;
    }

    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack itemStack = this.items.get(slot);
        this.items.set(slot, ItemStack.EMPTY);
        return itemStack;
    }

    public void setItem(int slot, ItemStack stack) {
        this.items.set(slot, stack);
        if (stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        setChanged();
    }

    public boolean stillValid(PlayerEntity player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }


    public void clearContent() {
        for (int i = 0; i < 2; i++) {
            this.items.set(i, ItemStack.EMPTY);
        }
    }

    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return new InfusionTableContainer(p_213906_1_, p_213906_2_, this, forgeData);
    }

    public void tick() {
        if (!this.level.isClientSide) {
            IRecipe<?> irecipe = this.level.getRecipeManager().getRecipeFor(DivineRPG.INFUSION_TABLE_RECIPE, this, this.level).orElse(null);
            if(irecipe instanceof InfusionTableRecipe) {
            InfusionTableRecipe recipe = (InfusionTableRecipe) irecipe;
                int inputStackSize = recipe.getCount();
                ItemStack input = items.get(0);
                ItemStack template = items.get(1);
                ItemStack output = items.get(2);
                if (recipe.matches(this, level) && output.isEmpty()) {
                setItem(2, recipe.output.copy());
                removeItem(0, inputStackSize);
                setRecipeUsed(recipe);
                }
            }
        }
    }


    public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
        if (recipe != null) {
            ResourceLocation resourcelocation = recipe.getId();
            this.recipes.addTo(resourcelocation, 1);
            setChanged();
        }
    }



}