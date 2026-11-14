package divinerpg.client.menu;

import net.minecraft.recipebook.ServerPlaceRecipe;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class InfiniFurnaceMenu extends RecipeBookMenu {
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    private final RecipePropertySet acceptedInputs;

    protected InfiniFurnaceMenu(MenuType<?> menuType, int containerId, Inventory inventory) {
        this(menuType, containerId, inventory, new SimpleContainer(2), new SimpleContainerData(2));
    }
    protected InfiniFurnaceMenu(MenuType<?> menuType, int containerId, Inventory inventory, Container container, ContainerData data) {
        super(menuType, containerId);
        checkContainerSize(container, 2);
        checkContainerDataCount(data, 2);
        this.container = container;
        this.data = data;
        level = inventory.player.level();
        acceptedInputs = level.recipeAccess().propertySet(RecipePropertySet.FURNACE_INPUT);
        addSlot(new Slot(container, 0, 56, 17));
        addSlot(new FurnaceResultSlot(inventory.player, container, 1, 116, 35));
        addStandardInventorySlots(inventory, 8, 84);
        addDataSlots(data);
    }
    @Override
    public void fillCraftSlotsStackedContents(StackedItemContents stackedContents) {
        if(container instanceof StackedContentsCompatible stackedContentsCompatible) stackedContentsCompatible.fillStackedContents(stackedContents);
    }
    public Slot getResultSlot() {
        return this.slots.get(1);
    }
    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }
    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        ItemStack clicked = ItemStack.EMPTY;
        Slot slot = slots.get(slotIndex);
        if(slot.hasItem()) {
            ItemStack stack = slot.getItem();
            clicked = stack.copy();
            if(slotIndex == 1) {
                if(!moveItemStackTo(stack, 2, 39, true)) return ItemStack.EMPTY;
                slot.onQuickCraft(stack, clicked);
            } else if(slotIndex != 0) {
                if(canSmelt(stack)) {
                    if(!moveItemStackTo(stack, 0, 1, false)) return ItemStack.EMPTY;
                } else if(slotIndex >= 2 && slotIndex < 29) {
                    if(!moveItemStackTo(stack, 29, 38, false)) return ItemStack.EMPTY;
                } else if(slotIndex >= 29 && slotIndex < 38 && !moveItemStackTo(stack, 2, 29, false)) return ItemStack.EMPTY;
            } else if(!moveItemStackTo(stack, 2, 38, false)) return ItemStack.EMPTY;
            if(stack.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
            else slot.setChanged();
            if(stack.getCount() == clicked.getCount()) return ItemStack.EMPTY;
            slot.onTake(player, stack);
        }
        return clicked;
    }
    protected boolean canSmelt(ItemStack itemStack) {return acceptedInputs.test(itemStack);}
    public float getBurnProgress() {
        int current = data.get(0);
        int total = data.get(1);
        return total != 0 && current != 0 ? Mth.clamp((float)current / total, 0F, 1F) : 0F;
    }
    public boolean isLit() {
        return slots.getFirst().hasItem();
    }
    @Override
    public RecipeBookType getRecipeBookType() {
        return RecipeBookType.FURNACE;
    }
    @Override
    public RecipeBookMenu.PostPlaceAction handlePlacement(boolean useMaxItems, boolean allowDroppingItemsToClear, RecipeHolder<?> recipe, ServerLevel level, Inventory inventory) {
        final List<Slot> slotsToClear = List.of(getSlot(0), getSlot(1));
        return ServerPlaceRecipe.placeRecipe(new ServerPlaceRecipe.CraftingMenuAccess<>() {
            @Override
            public void fillCraftSlotsStackedContents(StackedItemContents stackedContents) {
                InfiniFurnaceMenu.this.fillCraftSlotsStackedContents(stackedContents);
            }
            @Override
            public void clearCraftingContent() {
                slotsToClear.forEach(s -> s.set(ItemStack.EMPTY));
            }
            @Override
            public boolean recipeMatches(RecipeHolder<AbstractCookingRecipe> recipe) {
                return recipe.value().matches(new SingleRecipeInput(container.getItem(0)), level);
            }
        }, 1, 1, List.of(getSlot(0)), slotsToClear, inventory, (RecipeHolder<AbstractCookingRecipe>)recipe, useMaxItems, allowDroppingItemsToClear);
    }
}