package divinerpg.events;

import divinerpg.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.world.entity.player.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "OvWorldInv", VETHEA_INVENTORY = "DreamInv", MODID_SEPERATOR = "divinerpg:";
    private CompoundTag persistentData;

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if(!event.isCanceled() && event.getEntity() instanceof Player && persistentData != null) {
        	Player playerIn = event.getEntity();
        	if(event.getEntity().level().dimension() == LevelRegistry.VETHEA) {
        		if(!persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + VETHEA_INVENTORY, 10).isEmpty()) {
                    ListTag inv = persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + VETHEA_INVENTORY, 10);
                    playerIn.inventory.load(inv);
                    playerIn.inventoryMenu.broadcastChanges();
                    persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + VETHEA_INVENTORY, 10).clear();
        		}
        	} else if(!persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + OVERWORLD_INVENTORY, 10).isEmpty()) {
                ListTag inv = persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + OVERWORLD_INVENTORY, 10);
                playerIn.inventory.load(inv);
                playerIn.inventoryMenu.broadcastChanges();
                persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + OVERWORLD_INVENTORY, 10).clear();
            }
        	ArmorAbilitiesEvent.updateAbilities(playerIn, true);
        }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if(!event.isCanceled() && event.getEntity() instanceof Player) {
	        Player playerIn = event.getEntity();
	        persistentData = playerIn.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);
	        if(event.getFrom() == LevelRegistry.VETHEA) {
	            persistentData.put(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + VETHEA_INVENTORY, playerIn.inventory.save(new ListTag()));
	            playerIn.getPersistentData().put("PlayerPersisted", persistentData);
	            playerIn.inventory.clearContent();
	            ListTag inv = persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + OVERWORLD_INVENTORY, 10);
	            playerIn.inventory.load(inv);
	            playerIn.inventoryMenu.broadcastChanges();
	            persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + OVERWORLD_INVENTORY, 10).clear();
	            playerIn.removeAllEffects();
	        } else if(event.getTo() == LevelRegistry.VETHEA) {
	        	persistentData.put(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + OVERWORLD_INVENTORY, playerIn.inventory.save(new ListTag()));
	            playerIn.getPersistentData().put("PlayerPersisted", persistentData);
	            playerIn.inventory.clearContent();
	            ListTag inv = persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + VETHEA_INVENTORY, 10);
	            playerIn.inventory.load(inv);
	            playerIn.inventoryMenu.broadcastChanges();
	            persistentData.getList(MODID_SEPERATOR + playerIn.getStringUUID() + "_" + VETHEA_INVENTORY, 10).clear();
	            playerIn.removeAllEffects();
	        }
	        ArmorAbilitiesEvent.updateAbilities(playerIn, true);
        }
    }
}