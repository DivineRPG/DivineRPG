package divinerpg.client.containers;

import divinerpg.client.containers.slot.*;
import divinerpg.registries.*;
import divinerpg.tiles.block.*;
import divinerpg.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraftforge.items.*;
import net.minecraftforge.items.wrapper.*;

public class DreamLampContainer extends Container {

    //TODO - center dream lamp container

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

        final int SLOT_X_SPACING = 18;
        final int SLOT_Y_SPACING = 18;
        final int HOTBAR_XPOS = 8;
        final int HOTBAR_YPOS = 109;
        for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
            int slotNumber = x;
            addSlot(new SlotItemHandler(playerInventoryForge, slotNumber, HOTBAR_XPOS + SLOT_X_SPACING * x, HOTBAR_YPOS));
        }

        final int PLAYER_INVENTORY_XPOS = 8;
        for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
            for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
                int slotNumber = HOTBAR_SLOT_COUNT + y * PLAYER_INVENTORY_COLUMN_COUNT + x;
                int xpos = PLAYER_INVENTORY_XPOS + x * SLOT_X_SPACING;
                int ypos = PLAYER_INVENTORY_YPOS + y * SLOT_Y_SPACING;
                addSlot(new SlotItemHandler(playerInventoryForge, slotNumber,  xpos, ypos));
            }
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