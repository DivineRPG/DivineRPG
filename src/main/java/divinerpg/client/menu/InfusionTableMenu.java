package divinerpg.client.menu;

import divinerpg.client.slot.InfusionTableResultSlot;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.network.*;
import net.minecraft.network.chat.*;
//import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.network.*;

import javax.annotation.*;
import java.util.*;

public class InfusionTableMenu extends AbstractContainerMenu {
    public InfusionInventory inputs = new InfusionInventory(this);
    public ResultContainer output = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;
    public InfusionTableMenu(int screenId, Inventory plInventory, ContainerLevelAccess functionCaller) {
        super(MenuTypeRegistry.INFUSION_TABLE.get(), screenId);
        access = functionCaller;
        player = plInventory.player;
        addSlot(new Slot(inputs, 0, 18, 39));
        addSlot(new Slot(inputs, 1, 18, 59));
        addSlot(new InfusionTableResultSlot(player, inputs, output, 0, 63, 49));
        //Player inventory
        for(int i = 0; i < 3; ++i) for(int j = 0; j < 9; ++j) {
            addSlot(new Slot(plInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
        } for(int k = 0; k < 9; ++k) addSlot(new Slot(plInventory, k, 8 + k * 18, 142));
    }
    public InfusionTableMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory, ContainerLevelAccess.NULL);
    }
    @Override
    public void slotsChanged(Container inventory) {
        access.execute((world, pos) -> slotChangedCraftingGrid(world, player, inputs, output));
    }
    protected void slotChangedCraftingGrid(Level world, Player player, InfusionInventory inv, ResultContainer craftResult) {
        Optional<InfusionTableRecipe> recipeOptional = world.getServer().getRecipeManager().getRecipeFor(InfusionTableRecipe.Type.INSTANCE, inv, world);
        if(recipeOptional.isPresent()) {
            ItemStack output = recipeOptional.get().output.copy();
            if(!craftResult.getItem(2).is(output.getItem())) {
            	craftResult.setItem(2, output);
//            	((ServerPlayer) player).connection.send(new ClientboundContainerSetSlotPacket(containerId, incrementStateId(), 2, output));
            }
        } else craftResult.setItem(2, ItemStack.EMPTY);
    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, BlockRegistry.infusionTable.get());
    }
    @Override
    public void removed(Player player) {
        super.removed(player);
        output.setItem(2,ItemStack.EMPTY);
        access.execute((world, pos) -> clearContainer(player, inputs));
    }
    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != output && super.canTakeItemForPickAll(stack, slot);
    }
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if(slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            stack = slotStack.copy();
            if(index == 2) {
                if(!moveItemStackTo(slotStack, 3, 39, true)) return ItemStack.EMPTY;
                slot.onQuickCraft(slotStack, stack);
                inputs.setItem(index, slotStack);
            } else if(index != 0 && index != 1) {
                if(index < 39 && !moveItemStackTo(slotStack, 0, 2, false)) return ItemStack.EMPTY;
            } else if(!moveItemStackTo(slotStack, 3, 39, false)) return ItemStack.EMPTY;
            if(slotStack.isEmpty()) slot.set(ItemStack.EMPTY);
            else slot.setChanged();
            if(slotStack.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(player, slotStack);
        } return stack;
    }
    public static void openContainer(ServerPlayer player, BlockPos pos) {
        NetworkHooks.openScreen(player, new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.translatable(BlockRegistry.infusionTable.get().getDescriptionId());
            }
            @Nullable @Override
            public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                return new InfusionTableMenu(windowId, inv, ContainerLevelAccess.create(player.level(), pos));
            }
        }, pos);
    }
    public static class InfusionInventory implements CraftingContainer {
        private final NonNullList<ItemStack> stackList;
        private final AbstractContainerMenu eventListener;
        public InfusionInventory(AbstractContainerMenu container) {
            super();
            stackList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
            eventListener = container;
        }
        @Override
        public int getContainerSize() {
            return 3;
        }
        @Override
        public boolean isEmpty() {
            for(ItemStack stack : stackList) if(!stack.isEmpty()) return false;
            return true;
        }
        @Override
        public ItemStack getItem(int index) {
            return index >= getContainerSize() || index < 0 ? ItemStack.EMPTY : stackList.get(index);
        }
        @Override
        public ItemStack removeItemNoUpdate(int index) {
            return ContainerHelper.takeItem(stackList, index);
        }
        @Override
        public ItemStack removeItem(int index, int count) {
            ItemStack stack = ContainerHelper.removeItem(stackList, index, count);
            if(!stack.isEmpty()) eventListener.slotsChanged(this);
            return stack;
        }
        @Override
        public void setItem(int index, ItemStack stack) {
            stackList.set(index, stack);
            eventListener.slotsChanged(this);
        }
        @Override
        public void setChanged() {
        }
        @Override
        public boolean stillValid(Player p_18946_) {
            return false;
        }
        @Override
        public void clearContent() {
            stackList.clear();
        }
        @Override
        public void fillStackedContents(StackedContents recipeItemHelper) {
            for(ItemStack stack : stackList) recipeItemHelper.accountStack(stack);
        }
        @Override
        public int getWidth() {
            return 3;
        }
        @Override
        public int getHeight() {
            return 1;
        }
        @Override
        public List<ItemStack> getItems() {
            return stackList;
        }
    }
}