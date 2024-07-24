package divinerpg.client.slot;

import divinerpg.client.menu.InfusionTableMenu;
import divinerpg.recipe.InfusionTableRecipe;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.EventHooks;

import java.util.Optional;

public class InfusionTableResultSlot extends Slot {
    private final InfusionTableMenu.InfusionInventory craftSlots;
    private final Player player;
    private int removeCount;
    public InfusionTableResultSlot(Player player, InfusionTableMenu.InfusionInventory craftSlots, ResultContainer inventory, int index, int xpos, int ypos) {
        super(inventory, index, xpos, ypos);
        this.player = player;
        this.craftSlots = craftSlots;
    }
    public boolean mayPlace(ItemStack stack) {
        return false;
    }
    public ItemStack remove(int amount) {
        if(hasItem()) removeCount += Math.min(amount, getItem().getCount());
        return super.remove(amount);
    }
    protected void onQuickCraft(ItemStack stack, int amount) {
        removeCount += amount;
        checkTakeAchievements(stack);
    }
    protected void onSwapCraft(int amount) {
        removeCount += amount;
    }
    protected void checkTakeAchievements(ItemStack stack) {
    	stack.onCraftedBy(player.level(), player, removeCount);
        removeCount = 0;
        EventHooks.firePlayerSmeltedEvent(player, stack);
    }
    public void onTake(Player player, ItemStack stack) {
        if(player.level() != null && !player.level().isClientSide()) {
            checkTakeAchievements(stack);
            CommonHooks.setCraftingPlayer(player);
            Optional<InfusionTableRecipe> recipe = player.level().getServer().getRecipeManager().getRecipeFor(InfusionTableRecipe.Type.INSTANCE, craftSlots, player.level());
            CommonHooks.setCraftingPlayer(null);
            if(recipe.isPresent()) craftSlots.getItem(0).shrink(recipe.get().getCount());
            super.onTake(player, stack);
        }
    }
}