package divinerpg.client.menu;

import divinerpg.block_entities.furnace.InfiniFurnaceBlockEntity;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class InfiniFurnaceMenu extends RecipeBookMenu<Container> {
	private final Container container;
	private final ContainerData data;
	protected final Level level;
	public InfiniFurnaceMenu(MenuType<?> type, int i, Inventory inv) {
		this(type, i, inv, new SimpleContainer(2), new SimpleContainerData(2));
	}
	public InfiniFurnaceMenu(MenuType<?> type, int num, Inventory inv, Container container, ContainerData data) {
		super(type, num);
	      checkContainerSize(container, 2);
	      checkContainerDataCount(data, 2);
	      this.container = container;
	      this.data = data;
	      level = inv.player.level();
	      addSlot(new Slot(container, 0, 56, 17));
	      addSlot(new FurnaceResultSlot(inv.player, container, 1, 116, 35){
			  @Override
			  public void onTake(Player player, ItemStack stack) {
				  super.onTake(player, stack);
				  if(player instanceof ServerPlayer)
				  ((InfiniFurnaceBlockEntity)container).awardUsedRecipesAndPopExperience((ServerPlayer) player);
			  }
		  });
	      for(int i = 0; i < 3; ++i) for(int j = 0; j < 9; ++j) addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	      for(int k = 0; k < 9; ++k) addSlot(new Slot(inv, k, 8 + k * 18, 142));
	      addDataSlots(data);
	}
	@Override
	public void fillCraftSlotsStackedContents(StackedContents contents) {
		if (container instanceof StackedContentsCompatible) ((StackedContentsCompatible)container).fillStackedContents(contents);
	}
	@Override
	public void clearCraftingContent() {
		getSlot(0).set(ItemStack.EMPTY);
		getSlot(1).set(ItemStack.EMPTY);
	}
	@Override
	public boolean recipeMatches(Recipe<? super Container> recipe) {
	      return recipe.matches(container, level);
	}
	@Override public boolean stillValid(Player player) {return container.stillValid(player);}
	@Override public int getResultSlotIndex() {return 1;}
	@Override public int getGridWidth() {return 1;}
	@Override public int getGridHeight() {return 1;}
	@Override public int getSize() {return 2;}
	@Override public RecipeBookType getRecipeBookType() {return RecipeBookType.FURNACE;}
	@Override public boolean shouldMoveToInventory(int i) {return true;}
	@Override
	public ItemStack quickMoveStack(Player player, int i) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = slots.get(i);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (i == 1) {
	            if (!moveItemStackTo(itemstack1, 2, 38, true)) return ItemStack.EMPTY;
	            slot.onQuickCraft(itemstack1, itemstack);
	         } else if (i != 0) {
	            if (this.canSmelt(itemstack1)) {
	               if (!moveItemStackTo(itemstack1, 0, 1, false)) return ItemStack.EMPTY;
	            } else if (i >= 2 && i < 29) {
	               if (!moveItemStackTo(itemstack1, 29, 38, false)) return ItemStack.EMPTY;
	            } else if (i >= 29 && i < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) return ItemStack.EMPTY;
	         } else if (!moveItemStackTo(itemstack1, 2, 38, false)) return ItemStack.EMPTY;
	         if (itemstack1.isEmpty()) slot.set(ItemStack.EMPTY);
	         else slot.setChanged();
	         if (itemstack1.getCount() == itemstack.getCount()) return ItemStack.EMPTY;
	         slot.onTake(player, itemstack1);
	      }
	      return itemstack;
	}
	protected boolean canSmelt(ItemStack stack) {
	      return level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), level).isPresent();
	}
	public int getBurnProgress() {
	      int i = data.get(0), j = data.get(1);
	      return j != 0 && i != 0 ? i * 24 / j : 0;
	}
	public boolean isLit() {return !container.getItem(0).isEmpty();}
}