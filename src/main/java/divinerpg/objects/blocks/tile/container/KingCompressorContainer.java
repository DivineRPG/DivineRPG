package divinerpg.objects.blocks.tile.container;

import divinerpg.objects.blocks.tile.entity.TileEntityKingCompressior;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class KingCompressorContainer extends Container {
    private final InventoryPlayer inventoryPlayer;
    private final TileEntityKingCompressior tile;
    private final int lastInvIndex;

    public KingCompressorContainer(InventoryPlayer inventoryPlayer, TileEntityKingCompressior tile) {
        this.inventoryPlayer = inventoryPlayer;
        this.tile = tile;

        List<EntityEquipmentSlot> armorSlots = Arrays.asList(EntityEquipmentSlot.HEAD,
                EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET);
        List<EntityEquipmentSlot> handSlots = Arrays.asList(EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND);

        int baseOffset = 8;

        // output
        for (int i = 0; i < armorSlots.size(); i++) {
            final EntityEquipmentSlot slot = armorSlots.get(i);

            addSlotToContainer(new Slot(tile,
                    armorSlots.get(i).getSlotIndex(),
                    152,
                    baseOffset + i * 18) {
                @Override
                public boolean isItemValid(ItemStack stack) {
                    return EntityLiving.getSlotForItemStack(stack) == slot && tile.isItemValidForSlot(this.getSlotIndex(), stack);
                }

                @Override
                public int getSlotStackLimit() {
                    return 1;
                }

                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture() {
                    return ItemArmor.EMPTY_SLOT_NAMES[slot.getIndex()];
                }
            });
        }
        for (int i = 0; i < handSlots.size(); i++) {
            final EntityEquipmentSlot slot = handSlots.get(i);

            addSlotToContainer(new Slot(tile,
                    handSlots.get(i).getSlotIndex(),
                    134 + i * 18,
                    85) {
                @Override
                public boolean isItemValid(ItemStack stack) {
                    return EntityLiving.getSlotForItemStack(stack) == slot && tile.isItemValidForSlot(this.getSlotIndex(), stack);
                }

                @Override
                public int getSlotStackLimit() {
                    return 1;
                }

                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture() {
                    if (slot == EntityEquipmentSlot.OFFHAND) {
                        return "minecraft:items/empty_armor_slot_shield";
                    }

                    return super.getSlotTexture();
                }
            });
        }

        int startIndex = armorSlots.size() + handSlots.size();

        // input
        for (int i = 0; i < armorSlots.size(); i++) {
            final EntityEquipmentSlot slot = armorSlots.get(i);

            addSlotToContainer(new Slot(tile,
                    armorSlots.get(i).getSlotIndex() + startIndex,
                    baseOffset,
                    baseOffset + i * 18) {
                @Override
                public boolean isItemValid(ItemStack stack) {
                    return EntityLiving.getSlotForItemStack(stack) == slot && tile.isItemValidForSlot(this.getSlotIndex(), stack);
                }

                @Override
                public int getSlotStackLimit() {
                    return 1;
                }

                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture() {
                    return ItemArmor.EMPTY_SLOT_NAMES[slot.getIndex()];
                }
            });
        }
        for (int i = 0; i < handSlots.size(); i++) {
            final EntityEquipmentSlot slot = handSlots.get(i);

            addSlotToContainer(new Slot(tile,
                    handSlots.get(i).getSlotIndex() + +startIndex,
                    baseOffset + i * 18,
                    85) {
                @Override
                public boolean isItemValid(ItemStack stack) {
                    return EntityLiving.getSlotForItemStack(stack) == slot && tile.isItemValidForSlot(this.getSlotIndex(), stack);
                }

                @Override
                public int getSlotStackLimit() {
                    return 1;
                }

                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture() {
                    if (slot == EntityEquipmentSlot.OFFHAND) {
                        return "minecraft:items/empty_armor_slot_shield";
                    }

                    return super.getSlotTexture();
                }
            });
        }

        // fuel
        lastInvIndex = startIndex * 2;
        addSlotToContainer(new Slot(tile, lastInvIndex, 80, 85) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return tile.getBurnTime(stack) > 0;
            }
        });

        bindPlayerInventory(baseOffset, 111);
    }

    private void bindPlayerInventory(int topX, int topY) {

        //player inv
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, topX + j * 18, topY));
            }
            topY += 18;
        }

        topY += 4;

        //player hotbar
        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(inventoryPlayer, k, topX + k * 18, topY));
        }
    }

    public int getCookTimePercentage() {
        int cookTime = tile.getField(1);
        if (cookTime == 0)
            return 0;

        double value = cookTime * 1.0 / tile.getCookTimeLength();
        int precantages = (int) Math.ceil(value * 100);
        return MathHelper.clamp(precantages, 0, 100);
    }


    public Set<String> getAbsorbedSets() {
        return tile.getAbsorbedSets();
    }

    public int getLimit() {
        return tile.getKingCreationLimit();
    }

    @Override
    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, tile);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < this.lastInvIndex) {
                if (!this.mergeItemStack(itemStack1, lastInvIndex + 1, this.inventorySlots.size() - 1, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, lastInvIndex, false)) {
                return ItemStack.EMPTY;
            }
            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tile.isUsableByPlayer(playerIn);
    }
}
