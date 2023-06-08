package divinerpg.client.containers.slot;

import divinerpg.client.containers.InfusionTableContainer;
import divinerpg.recipe.InfusionTableRecipe;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

import java.util.Optional;

public class InfusionTableResultSlot extends Slot {
    private final InfusionTableContainer.InfusionInventory craftSlots;
    private final Player player;
    private int removeCount;

    public InfusionTableResultSlot(Player player, InfusionTableContainer.InfusionInventory craftSlots, ResultContainer inventory, int p_i45790_4_, int p_i45790_5_, int p_i45790_6_) {
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

    protected void checkTakeAchievements(ItemStack p_39558_) {
        p_39558_.onCraftedBy(this.player.level(), this.player, this.removeCount);
        if (this.player instanceof ServerPlayer && this.container instanceof AbstractFurnaceBlockEntity) {
            ((AbstractFurnaceBlockEntity)this.container).awardUsedRecipesAndPopExperience((ServerPlayer)this.player);
        }

        this.removeCount = 0;
        net.minecraftforge.event.ForgeEventFactory.firePlayerSmeltedEvent(this.player, p_39558_);
    }

    public void onTake(Player player, ItemStack stack) {
        if(player.level() != null) {
            if (!player.level().isClientSide) {
                this.checkTakeAchievements(stack);
                net.minecraftforge.common.ForgeHooks.setCraftingPlayer(player);
                Optional<InfusionTableRecipe> recipe = player.level().getServer().getRecipeManager().getRecipeFor(InfusionTableRecipe.Type.INSTANCE, craftSlots, player.level());
                net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);
                if (recipe.isPresent()) {
                    craftSlots.getItem(0).shrink(recipe.get().getCount());
                }
//        slotsChanged(inputs);
                super.onTake(player, stack);
            }
        }
    }
}