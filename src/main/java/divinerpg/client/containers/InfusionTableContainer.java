package divinerpg.client.containers;

import divinerpg.*;
import divinerpg.client.containers.slot.*;
import divinerpg.recipe.*;
import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import java.util.*;

public class InfusionTableContainer<C extends IInventory> extends Container {
    public InfusionInventory infusion = new InfusionInventory(this);
    public CraftResultInventory output = new CraftResultInventory(){};
    public final IWorldPosCallable access;
    private final PlayerEntity player;

    public InfusionTableContainer(int id, PlayerInventory inventory) {
        this(id, inventory, IWorldPosCallable.NULL);
    }

    public InfusionTableContainer(int id, PlayerInventory inventory, IWorldPosCallable functionCaller) {
        super(ContainerRegistry.INFUSION_TABLE.get(), id);
        this.access = functionCaller;
        this.player = inventory.player;
        addSlot(new Slot(infusion, 0, 18, 39));
        addSlot(new Slot(infusion, 1, 18, 59));
        addSlot(new InfusionTableResultSlot(player, infusion, output, 0, 63, 49));


        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

    }

    public InfusionTableContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(i, playerInventory);
    }
    @Override
    public void slotsChanged(IInventory inventory) {
        access.execute((world, pos) -> slotChangedCraftingGrid(world, player, infusion, output));
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return infusion.stillValid(player);
    }

    protected void slotChangedCraftingGrid(World world, PlayerEntity player, InfusionInventory inv, CraftResultInventory craftResult) {

        Optional<InfusionTableRecipe> recipes = world.getServer().getRecipeManager().getRecipeFor(DivineRPG.INFUSION_TABLE_RECIPE, inv, world);
        if(recipes.isPresent()) {
            InfusionTableRecipe recipe = recipes.get();
            if (recipe.matches(inv, world) && craftResult.getItem(2).isEmpty()) {
                craftResult.setItem(1, recipe.template.copy());
                craftResult.setItem(2, recipe.output.copy());
                ((ServerPlayerEntity)player).connection.send(new SSetSlotPacket(this.containerId, 1, recipe.template.copy()));
                ((ServerPlayerEntity)player).connection.send(new SSetSlotPacket(this.containerId, 2, recipe.output.copy()));
                inv.removeItem(0, recipe.getCount());
            }
        }

    }

    public static class InfusionInventory extends CraftingInventory {
        private final NonNullList<ItemStack> stackList;
        private final Container container;

        public InfusionInventory(Container container) {
            super(container, 0, 0);

            this.stackList = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
            this.container = container;
        }

        @Override
        public int getContainerSize() {
            return stackList.size();
        }

        @Override
        public boolean isEmpty() {
            for (int i = 0; i < 2; i++) {
                if (!stackList.get(i).isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public ItemStack getItem(int index) {
            return stackList.get(index);
        }

        @Override
        public ItemStack removeItemNoUpdate(int slot) {
            ItemStack itemStack = stackList.get(slot);
            stackList.set(slot, ItemStack.EMPTY);
            return itemStack;
        }

        @Override
        public ItemStack removeItem(int index, int count) {
            return !stackList.get(index).isEmpty() && count > 0 ? stackList.get(index).split(count) : ItemStack.EMPTY;
        }

        @Override
        public void setItem(int index, ItemStack stack) {
            stackList.set(index, stack);
            container.slotsChanged(this);
        }

        @Override
        public void clearContent() {
            for (int i = 0; i < 2; i++) {
                stackList.set(i, ItemStack.EMPTY);
            }
        }

        @Override
        public void fillStackedContents(RecipeItemHelper recipeItemHelper) {
            for (ItemStack stack : stackList) {
                recipeItemHelper.accountStack(stack);
            }
        }
    }
}