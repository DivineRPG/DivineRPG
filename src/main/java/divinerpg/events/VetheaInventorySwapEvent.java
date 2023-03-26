package divinerpg.events;

import divinerpg.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.world.entity.player.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "divinerpg:OvWorldInv", VETHEA_INVENTORY = "divinerpg:DreamInv";
    private CompoundTag persistentData;

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if(!event.isCanceled() && event.getEntity() instanceof Player && persistentData != null) {
        	Player playerIn = event.getEntity();
        	if(event.getEntity().level.dimension() == LevelRegistry.VETHEA) {
        		if(!persistentData.getList(VETHEA_INVENTORY, 10).isEmpty()) {
                    ListTag inv = persistentData.getList(VETHEA_INVENTORY, 10);
                    playerIn.inventory.load(inv);
                    playerIn.inventoryMenu.broadcastChanges();
                    persistentData.getList(VETHEA_INVENTORY, 10).clear();
        		}
        	} else if(!persistentData.getList(OVERWORLD_INVENTORY, 10).isEmpty()) {
                ListTag inv = persistentData.getList(OVERWORLD_INVENTORY, 10);
                playerIn.inventory.load(inv);
                playerIn.inventoryMenu.broadcastChanges();
                persistentData.getList(OVERWORLD_INVENTORY, 10).clear();
            }
        	ArmorAbilitiesEvent.updateAbilities(playerIn);
        }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if(!event.isCanceled() && event.getEntity() instanceof Player) {
	        Player playerIn = event.getEntity();
	        persistentData = playerIn.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);
	        if(event.getFrom() == LevelRegistry.VETHEA) {
	            persistentData.put(VETHEA_INVENTORY, playerIn.inventory.save(new ListTag()));
	            playerIn.getPersistentData().put("PlayerPersisted", persistentData);
	            playerIn.inventory.clearContent();
	            ListTag inv = persistentData.getList(OVERWORLD_INVENTORY, 10);
	            playerIn.inventory.load(inv);
	            playerIn.inventoryMenu.broadcastChanges();
	            persistentData.getList(OVERWORLD_INVENTORY, 10).clear();
	            playerIn.removeAllEffects();
	        } else if(event.getTo() == LevelRegistry.VETHEA) {
	        	persistentData.put(OVERWORLD_INVENTORY, playerIn.inventory.save(new ListTag()));
	            playerIn.getPersistentData().put("PlayerPersisted", persistentData);
	            playerIn.inventory.clearContent();
	            ListTag inv = persistentData.getList(VETHEA_INVENTORY, 10);
	            playerIn.inventory.load(inv);
	            playerIn.inventoryMenu.broadcastChanges();
	            persistentData.getList(VETHEA_INVENTORY, 10).clear();
	            playerIn.removeAllEffects();
	        }
	        ArmorAbilitiesEvent.updateAbilities(playerIn);
        }
    }
}