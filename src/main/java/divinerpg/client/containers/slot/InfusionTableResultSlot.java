package divinerpg.client.containers.slot;

import divinerpg.*;
import divinerpg.recipe.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;

import java.util.*;

public class InfusionTableResultSlot extends Slot {
    private final CraftingInventory craftSlots;
    private final PlayerEntity player;
    private int removeCount;

    public InfusionTableResultSlot(PlayerEntity player, CraftingInventory craftSlots, IInventory inventory, int p_i45790_4_, int p_i45790_5_, int p_i45790_6_) {
        super(inventory, p_i45790_4_, p_i45790_5_, p_i45790_6_);
        this.player = player;
        this.craftSlots = craftSlots;
    }

    public boolean mayPlace(ItemStack p_75214_1_) {
        return false;
    }

    public ItemStack remove(int p_75209_1_) {
        if (this.hasItem()) {
            this.removeCount += Math.min(p_75209_1_, this.getItem().getCount());
        }

        return super.remove(p_75209_1_);
    }

    protected void onQuickCraft(ItemStack p_75210_1_, int p_75210_2_) {
        this.removeCount += p_75210_2_;
        this.checkTakeAchievements(p_75210_1_);
    }

    protected void onSwapCraft(int p_190900_1_) {
        this.removeCount += p_190900_1_;
    }

    protected void checkTakeAchievements(ItemStack p_75208_1_) {
        if (this.removeCount > 0) {
            p_75208_1_.onCraftedBy(this.player.level, this.player, this.removeCount);
            net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerCraftingEvent(this.player, p_75208_1_, this.craftSlots);
        }

        if (this.container instanceof IRecipeHolder) {
            ((IRecipeHolder)this.container).awardUsedRecipes(this.player);
        }

        this.removeCount = 0;
    }

    public ItemStack onTake(PlayerEntity player, ItemStack stack) {
        if(player.level != null) {
            if (!player.level.isClientSide) {
                this.checkTakeAchievements(stack);
                net.minecraftforge.common.ForgeHooks.setCraftingPlayer(player);
                Optional<InfusionTableRecipe> recipe = player.level.getServer().getRecipeManager().getRecipeFor(DivineRPG.INFUSION_TABLE_RECIPE, craftSlots, player.level);
                net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);
                if (recipe.isPresent()) {
                    craftSlots.getItem(0).shrink(recipe.get().getCount());
                }
//        slotsChanged(inputs);
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }
}
