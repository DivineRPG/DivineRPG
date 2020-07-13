package divinerpg.compat.baubles;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BaublesCompat {

    public static void changeBaubles(EntityPlayer player, NBTTagCompound tag, boolean backToOverworld) {
        List<String> tagNames = Arrays.asList("Baubles_Overworld", "Baubles_Vethea");
        if (backToOverworld) {
            Collections.reverse(tagNames);
        }

        String saveTo = tagNames.get(0);
        String loadFrom = tagNames.get(1);

        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);

        tag.setTag(saveTo, serializeBaubles(handler));
        deserializeBaubles(handler, ((NBTTagList) tag.getTag(loadFrom)));
    }

    private static NBTTagList serializeBaubles(IBaublesItemHandler baublesHandler) {
        NBTTagList serializedInventory = new NBTTagList();

        for (int slotIndex = 0; slotIndex < baublesHandler.getSlots(); slotIndex++) {
            NBTTagCompound serializedSlot = baublesHandler.getStackInSlot(slotIndex).writeToNBT(new NBTTagCompound());
            serializedInventory.appendTag(serializedSlot);
        }

        return serializedInventory;
    }

    private static void deserializeBaubles(IBaublesItemHandler baublesHandler, NBTTagList serializedInventory) {
        for (int slotIndex = 0; slotIndex < baublesHandler.getSlots(); slotIndex++) {
            if (serializedInventory == null) {
                baublesHandler.setStackInSlot(slotIndex, ItemStack.EMPTY);
            } else {
                NBTBase slotNbt = serializedInventory.get(slotIndex);
                if (slotNbt instanceof NBTTagCompound) {
                    ItemStack deserializedItem = new ItemStack(((NBTTagCompound) serializedInventory.get(slotIndex)));
                    baublesHandler.setStackInSlot(slotIndex, deserializedItem);
                } else {
                    baublesHandler.setStackInSlot(slotIndex, ItemStack.EMPTY);
                }
            }
        }
    }

}
