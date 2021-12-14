package divinerpg.client.containers;

import divinerpg.client.containers.slot.*;
import divinerpg.registries.*;
import divinerpg.tiles.block.*;
import divinerpg.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraftforge.items.wrapper.*;

public class DreamLampContainer extends Container {

    public static DreamLampContainer createContainerClientSide(int windowID, PlayerInventory playerInventory, net.minecraft.network.PacketBuffer extraData) {
        TileInventoryHelper chestContents = TileInventoryHelper.createForClientSideContainer(TileEntityDreamLamp.NUMBER_OF_SLOTS);
        return new DreamLampContainer(windowID, playerInventory, chestContents);
    }
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;

    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = TileEntityDreamLamp.NUMBER_OF_SLOTS;

    public static final int PLAYER_INVENTORY_YPOS = 51;

    public DreamLampContainer(int windowID, PlayerInventory playerInventory, TileInventoryHelper chestContents) {
        super(ContainerRegistry.DREAM_LAMP.get(), windowID);

        PlayerInvWrapper playerInventoryForge = new PlayerInvWrapper(playerInventory);
        this.chestContents = chestContents;

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
            addSlot(new SlotDreamLamp(chestContents, 0, 80, 47));
    }

    @Override
    public boolean stillValid(PlayerEntity playerEntity)
    {
        return chestContents.stillValid(playerEntity);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity playerEntity, int sourceSlotIndex)
    {
        Slot sourceSlot = slots.get(sourceSlotIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (sourceSlotIndex >= VANILLA_FIRST_SLOT_INDEX && sourceSlotIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)){
                return ItemStack.EMPTY;
            }
        } else if (sourceSlotIndex >= TE_INVENTORY_FIRST_SLOT_INDEX && sourceSlotIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(playerEntity, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public void removed(PlayerEntity playerIn)
    {
        super.removed(playerIn);
    }

    private TileInventoryHelper chestContents;
}