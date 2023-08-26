package divinerpg.events;

import divinerpg.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "OvWorldInv", VETHEA_INVENTORY = "DreamInv", MODID_SEPERATOR = "divinerpg:";
	@SubscribeEvent(priority = EventPriority.HIGH)
    public void onDeath(LivingDeathEvent event) {
    	if(!event.isCanceled() && event.getEntity() instanceof Player player) {
    		if(player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
        		if(player.level().dimension() == LevelRegistry.VETHEA) saveToInv(player, VETHEA_INVENTORY);
        		else saveToInv(player, OVERWORLD_INVENTORY);
    		} else if(player.level().dimension() == LevelRegistry.VETHEA) clearInv(player, VETHEA_INVENTORY);
    		else clearInv(player, OVERWORLD_INVENTORY);
    	}
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if(!event.isCanceled()) {
        	Player player = event.getEntity();
        	if(player.level().dimension() == LevelRegistry.VETHEA) loadInv(player, VETHEA_INVENTORY);
    		else loadInv(player, OVERWORLD_INVENTORY);
        	player.inventoryMenu.broadcastChanges();
        	ArmorAbilitiesEvent.updateAbilities(player);
        }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDimensionChange(PlayerEvent.PlayerChangedDimensionEvent event) {
        if(!event.isCanceled()) {
	        Player playerIn = event.getEntity();
	        if(event.getFrom() == LevelRegistry.VETHEA) {
	            saveToInv(playerIn, VETHEA_INVENTORY);
	            loadInv(playerIn, OVERWORLD_INVENTORY);
	            playerIn.inventoryMenu.broadcastChanges();
	            playerIn.removeAllEffects();
	        } else if(event.getTo() == LevelRegistry.VETHEA) {
	        	saveToInv(playerIn, OVERWORLD_INVENTORY);
	        	loadInv(playerIn, VETHEA_INVENTORY);
	            playerIn.inventoryMenu.broadcastChanges();
	            playerIn.removeAllEffects();
	        }
	        ArmorAbilitiesEvent.updateAbilities(playerIn);
        }
    }
	public void saveToInv(Player player, String inv) {
		CompoundTag persisted = player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);
		persisted.put(MODID_SEPERATOR + player.getStringUUID() + "_" + inv, player.inventory.save(new ListTag()));
		player.getPersistentData().put(Player.PERSISTED_NBT_TAG, persisted);
	}
	public void loadInv(Player player, String inv) {
		player.inventory.load(player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG).getList(MODID_SEPERATOR + player.getStringUUID() + "_" + inv, 10));
	}
	public void clearInv(Player player, String inv) {
		CompoundTag persisted = player.getPersistentData().getCompound(Player.PERSISTED_NBT_TAG);
		persisted.put(MODID_SEPERATOR + player.getStringUUID() + "_" + inv, new ListTag());
		player.getPersistentData().put(Player.PERSISTED_NBT_TAG, persisted);
	}
}