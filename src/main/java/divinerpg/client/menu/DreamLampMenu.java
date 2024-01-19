package divinerpg.client.menu;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DreamLampMenu extends AbstractContainerMenu {
	private final Container container;
	protected final Level level;
	public DreamLampMenu(int i, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(i, playerInventory);
    }
	public DreamLampMenu(int i, Inventory inv) {
		this(i, inv, new SimpleContainer(1));
	}
	public DreamLampMenu(int num, Inventory inv, Container container) {
		super(MenuTypeRegistry.DREAM_LAMP.get(), num);
		checkContainerSize(container, 1);
	    this.container = container;
	    level = inv.player.level();
	    addSlot(new Slot(container, 0, 80, 47));
	    for(int i = 0; i < 3; ++i) for(int j = 0; j < 9; ++j) addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	    for(int k = 0; k < 9; ++k) addSlot(new Slot(inv, k, 8 + k * 18, 142));
	}
	@Override public boolean stillValid(Player player) {return container.stillValid(player);}
	@Override
	public ItemStack quickMoveStack(Player player, int i) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = slots.get(i);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (i == 0) {
	            if (!moveItemStackTo(itemstack1, 1, 37, true)) return ItemStack.EMPTY;
	         } else if (itemstack.is(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "acid")))) {
	        	 if (!moveItemStackTo(itemstack1, 0, 0, false)) return ItemStack.EMPTY;
	         } else if (i >= 1 && i < 28) {
	        	 if (!moveItemStackTo(itemstack1, 28, 37, false)) return ItemStack.EMPTY;
	         } else if (i >= 28 && i < 37 && !this.moveItemStackTo(itemstack1, 1, 28, false)) return ItemStack.EMPTY;
	         else if (!moveItemStackTo(itemstack1, 1, 37, false)) return ItemStack.EMPTY;
	         if (itemstack1.isEmpty()) slot.set(ItemStack.EMPTY);
	         else slot.setChanged();
	         if (itemstack1.getCount() == itemstack.getCount()) return ItemStack.EMPTY;
	         slot.onTake(player, itemstack1);
	      }
	      return itemstack;
	}
}