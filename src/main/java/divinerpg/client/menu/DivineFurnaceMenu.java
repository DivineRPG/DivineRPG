package divinerpg.client.menu;

import divinerpg.block_entities.furnace.*;
import divinerpg.client.slot.FuelSlot;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.CommonHooks;

public abstract class DivineFurnaceMenu extends RecipeBookMenu<Container> {
    public static final int INGREDIENT_SLOT = 0;
    public static final int FUEL_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    public static final int SLOT_COUNT = 3;
    public static final int DATA_COUNT = 4;
//    private static final int INV_SLOT_START = 3;
//    private static final int INV_SLOT_END = 30;
//    private static final int USE_ROW_SLOT_START = 30;
//    private static final int USE_ROW_SLOT_END = 39;
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    private final RecipeType<? extends AbstractCookingRecipe> recipeType;
    private final RecipeBookType recipeBookType;

    protected DivineFurnaceMenu(MenuType<?> p_38960_, RecipeType<? extends AbstractCookingRecipe> p_38961_, RecipeBookType p_38962_, int p_38963_, Inventory p_38964_) {
        this(p_38960_, p_38961_, p_38962_, p_38963_, p_38964_, new SimpleContainer(3), new SimpleContainerData(4));
    }

    protected DivineFurnaceMenu(MenuType<?> p_38966_, RecipeType<? extends AbstractCookingRecipe> p_38967_, RecipeBookType p_38968_, int p_38969_, Inventory inventory, Container container, ContainerData p_38972_) {
        super(p_38966_, p_38969_);
        this.recipeType = p_38967_;
        this.recipeBookType = p_38968_;
        checkContainerSize(container, 3);
        checkContainerDataCount(p_38972_, 4);
        this.container = container;
        this.data = p_38972_;
        this.level = inventory.player.level();
        this.addSlot(new Slot(container, 0, 56, 17));
        this.addSlot(new FuelSlot(this, container, 1, 56, 53));
        addSlot(new FurnaceResultSlot(inventory.player, DivineFurnaceMenu.this.container, 2, 116, 35){
            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);
                if(player instanceof ServerPlayer)
                    ((ModFurnaceBlockEntity)container).awardUsedRecipesAndPopExperience(((ServerPlayer) player));
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(p_38972_);
    }

    public void fillCraftSlotsStackedContents(StackedContents p_38976_) {
        if (this.container instanceof StackedContentsCompatible) {
            ((StackedContentsCompatible)this.container).fillStackedContents(p_38976_);
        }

    }

    public void clearCraftingContent() {
        this.getSlot(0).set(ItemStack.EMPTY);
        this.getSlot(2).set(ItemStack.EMPTY);
    }

    public boolean recipeMatches(Recipe<? super Container> p_38980_) {
        return p_38980_.matches(this.container, this.level);
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

    public int getSize() {
        return 3;
    }

    public boolean stillValid(Player p_38974_) {
        return this.container.stillValid(p_38974_);
    }

    public ItemStack quickMoveStack(Player p_38986_, int p_38987_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_38987_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_38987_ == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_38987_ != 1 && p_38987_ != 0) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_38987_ >= 3 && p_38987_ < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_38987_ >= 30 && p_38987_ < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_38986_, itemstack1);
        }

        return itemstack;
    }

    @SuppressWarnings("unchecked")
	protected boolean canSmelt(ItemStack p_38978_) {
        return this.level.getRecipeManager().getRecipeFor((RecipeType<AbstractCookingRecipe>)recipeType, new SimpleContainer(p_38978_), this.level).isPresent();
    }

    public boolean isFuel(ItemStack stack) {
        return CommonHooks.getBurnTime(stack, this.recipeType) > 0;
    }

    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }

    public RecipeBookType getRecipeBookType() {
        return this.recipeBookType;
    }

    public boolean shouldMoveToInventory(int p_150463_) {
        return p_150463_ != 1;
    }
}
