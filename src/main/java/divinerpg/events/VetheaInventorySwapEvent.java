package divinerpg.events;

import divinerpg.registries.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;

public class VetheaInventorySwapEvent {
    private CompoundNBT persistentData;

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.isCanceled() || !(event.getEntity() instanceof PlayerEntity)) return;

        PlayerEntity playerIn = event.getPlayer();
        if (!persistentData.getList("OverworldInv", 10).isEmpty() && persistentData.getList("OverworldInv", 10) != null) {
            ListNBT inv = persistentData.getList("OverworldInv", 10);
            playerIn.inventory.load(inv);
            playerIn.inventoryMenu.broadcastChanges();
            persistentData.getList("OverworldInv", 10).clear();
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.isCanceled() || !(event.getEntity() instanceof PlayerEntity))
            return;

        RegistryKey<World> vetheaID = KeyRegistry.VETHEA_WORLD;
        PlayerEntity playerIn = event.getPlayer();
        persistentData = playerIn.getPersistentData().getCompound(PlayerEntity.PERSISTED_NBT_TAG);

        if (event.getFrom() == vetheaID) {
            persistentData.put("VetheaInv", playerIn.inventory.save(new ListNBT()));
            playerIn.getPersistentData().put("PlayerPersisted", persistentData);
            playerIn.inventory.clearContent();
            ListNBT inv = persistentData.getList("OverworldInv", 10);
            playerIn.inventory.load(inv);
            playerIn.inventoryMenu.broadcastChanges();
            persistentData.getList("OverworldInv", 10).clear();
            playerIn.removeAllEffects();
        }
        if (event.getTo() == vetheaID) {
            persistentData.put("OverworldInv", playerIn.inventory.save(new ListNBT()));
            playerIn.getPersistentData().put("PlayerPersisted", persistentData);
            playerIn.inventory.clearContent();
            ListNBT inv = persistentData.getList("VetheaInv", 10);
            playerIn.inventory.load(inv);
            playerIn.inventoryMenu.broadcastChanges();
            playerIn.removeAllEffects();
        }

    }

}
