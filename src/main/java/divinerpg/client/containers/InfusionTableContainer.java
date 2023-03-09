package divinerpg.client.containers;

import divinerpg.DivineRPG;
import divinerpg.client.containers.slot.InfusionTableResultSlot;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.network.*;
import net.minecraft.network.chat.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.network.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.*;
import java.util.*;

public class InfusionTableContainer extends AbstractContainerMenu {
    public InfusionInventory inputs = new InfusionInventory(this);
    public ResultContainer output = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;

    public InfusionTableContainer(int screenId, Inventory plInventory, ContainerLevelAccess functionCaller) {
        super(MenuTypeRegistry.INFUSION_TABLE.get(), screenId);

        this.access = functionCaller;
        this.player = plInventory.player;

        addSlot(new Slot(inputs, 0, 18, 39));
        addSlot(new Slot(inputs, 1, 18, 59));
        addSlot(new InfusionTableResultSlot(player, inputs, output, 0, 63, 49));


        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(plInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(plInventory, k, 8 + k * 18, 142));
        }
    }

    public InfusionTableContainer(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory, ContainerLevelAccess.NULL);
    }

    @Override
    public void slotsChanged(Container inventory) {
        access.execute((world, pos) -> slotChangedCraftingGrid(world, player, inputs, output));
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "infusion_table")));
    }

    @Override
    public void removed(Player player) {
        super.removed(player);

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

        if (slot != null && slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            stack = slotStack.copy();

            if (index == 2) {
                access.execute((world, pos) -> slotStack.getItem().onCraftedBy(slotStack, world, player));

                if (!moveItemStackTo(slotStack, 3, 39, true))
                    return ItemStack.EMPTY;

                slot.onQuickCraft(slotStack, stack);
            }
            else if (index != 0 && index != 1) {
                if (index < 39 && !moveItemStackTo(slotStack, 0, 2, false))
                    return ItemStack.EMPTY;
            }
            else if (!moveItemStackTo(slotStack, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }
            else {
                slot.setChanged();
            }

            if (slotStack.getCount() == stack.getCount())
                return ItemStack.EMPTY;

            slot.onTake(player, slotStack);
        }

        return stack;
    }

    protected void slotChangedCraftingGrid(Level world, Player player, InfusionInventory inv, ResultContainer craftResult) {
        Optional<InfusionTableRecipe> recipeOptional = world.getServer().getRecipeManager().getRecipeFor(InfusionTableRecipe.Type.INSTANCE, inv, world);

        if (recipeOptional.isPresent()) {
            InfusionTableRecipe recipe = recipeOptional.get();

            if (recipe.matches(inv, world)) {
                ItemStack output = recipe.output.copy();
                ItemStack template = recipe.template.copy();

                if (craftResult.getItem(2).isEmpty()) {
                    craftResult.setItem(1, template);
                    craftResult.setItem(2, output);
                    ((ServerPlayer) player).connection.send(new ClientboundContainerSetSlotPacket(this.containerId, incrementStateId(), 1, template));
                    ((ServerPlayer) player).connection.send(new ClientboundContainerSetSlotPacket(this.containerId, incrementStateId(), 2, output));
                } else if (craftResult.getItem(2).getItem() == output.getItem() && ItemStack.tagMatches(craftResult.getItem(2), output)) {
                    inv.removeItem(0, recipe.getCount());
                    craftResult.getItem(2).grow(output.getCount());
                }
            }
        }
    }

    public static void openContainer(ServerPlayer player, BlockPos pos) {
        NetworkHooks.openScreen(player, new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.translatable(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "infusion_table")).getDescriptionId());
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int windowId, Inventory inv, Player player) {
                return new InfusionTableContainer(windowId, inv, ContainerLevelAccess.create(player.level, pos));
            }
        }, pos);
    }

    public static class InfusionInventory extends CraftingContainer {
        private final NonNullList<ItemStack> stackList;
        private final AbstractContainerMenu eventListener;

        public InfusionInventory(AbstractContainerMenu container) {
            super(container, 0, 0);

            this.stackList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
            this.eventListener = container;
        }

        @Override
        public int getContainerSize() {
            return 3;
        }

        @Override
        public boolean isEmpty() {
            for (ItemStack stack : stackList) {
                if (!stack.isEmpty())
                    return false;
            }

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

            if (!stack.isEmpty())
                eventListener.slotsChanged(this);

            return stack;
        }

        @Override
        public void setItem(int index, ItemStack stack) {
            stackList.set(index, stack);
            eventListener.slotsChanged(this);
        }

        @Override
        public void clearContent() {
            stackList.clear();
        }

        @Override
        public void fillStackedContents(StackedContents recipeItemHelper) {
            for (ItemStack stack : stackList) {
                recipeItemHelper.accountStack(stack);
            }
        }
    }

}
