package divinerpg.events;

import divinerpg.compat.CuriosCompat;
import divinerpg.registries.LevelRegistry;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.ModList;

public class VetheaInventorySwapEvent {
    public static final String OVERWORLD_INVENTORY = "OvWorldInv", VETHEA_INVENTORY = "DreamInv", MODID_SEPERATOR = "divinerpg:";
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDeath(LivingDeathEvent event) {
//            if (!event.isCanceled() && event.getEntity() instanceof Player player) {
//                if (player.level.getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
//                    if (player.level.dimension().equals(LevelRegistry.VETHEA)) saveToInv(player, VETHEA_INVENTORY);
//                    else saveToInv(player, OVERWORLD_INVENTORY);
//                } else if (player.level.dimension().equals(LevelRegistry.VETHEA)) clearInv(player, VETHEA_INVENTORY);
//                else clearInv(player, OVERWORLD_INVENTORY);
//            }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
//            if (!event.isCanceled()) {
//                Player player = event.getEntity();
//                if (player.level.dimension().equals(LevelRegistry.VETHEA)) loadInv(player, VETHEA_INVENTORY);
//                else loadInv(player, OVERWORLD_INVENTORY);
//                player.inventoryMenu.broadcastChanges();
//            }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDimensionChange(EntityTravelToDimensionEvent event) {
        if (!event.isCanceled() && event.getEntity() instanceof Player player) {
            boolean from = player.level.dimension().equals(LevelRegistry.VETHEA);
            boolean to = event.getDimension().equals(LevelRegistry.VETHEA);

            if ((from && !player.inventory.isEmpty()) || (to && !player.inventory.isEmpty())) {
                    event.setCanceled(true);
                    player.displayClientMessage(Component.translatable("teleport.failed.inventory_not_empty"), true);
                    return;
            }
            if (ModList.get().isLoaded("curios")) {
                if (CuriosCompat.checkCuriosSlots(player)) {
                    event.setCanceled(true);
                    player.displayClientMessage(Component.translatable("teleport.failed.curios_slots"), true);
                    return;
                }
            }


//            if (from ^ to) {
//                if (from) {
//                    saveToInv(player, VETHEA_INVENTORY);
//                    loadInv(player, OVERWORLD_INVENTORY);
//                } else {
//                    saveToInv(player, OVERWORLD_INVENTORY);
//                    loadInv(player, VETHEA_INVENTORY);
//                }
//                player.inventoryMenu.broadcastChanges();
//                player.removeAllEffects();
//            } else if (from && to) {
//                saveToInv(player, VETHEA_INVENTORY);
//            } else {
//                saveToInv(player, OVERWORLD_INVENTORY);
//            }
        }
    }
    public void saveToInv(Player player, String inv) {
        CompoundTag persisted = player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);
        persisted.put(MODID_SEPERATOR + player.getStringUUID() + "_" + inv, player.inventory.save(new ListTag()));
        player.getPersistentData().put(Player.PERSISTED_NBT_TAG, persisted);
    }
    public void loadInv(Player player, String inv) {
        ListTag newInventory = player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG).getList(MODID_SEPERATOR + player.getStringUUID() + "_" + inv, 10);
        if(newInventory != null) player.inventory.load(newInventory);
    }
    public void clearInv(Player player, String inv) {
        CompoundTag persisted = player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);
        persisted.put(MODID_SEPERATOR + player.getStringUUID() + "_" + inv, new ListTag());
        player.getPersistentData().put(Player.PERSISTED_NBT_TAG, persisted);
    }
}