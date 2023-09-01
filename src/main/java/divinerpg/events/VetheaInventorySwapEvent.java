package divinerpg.events;

import divinerpg.config.CommonConfig;
import divinerpg.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "OvWorldInv", VETHEA_INVENTORY = "DreamInv", MODID_SEPERATOR = "divinerpg:";
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDeath(LivingDeathEvent event) {
		if(CommonConfig.saferVetheanInventory.get() == false) {
			if (!event.isCanceled() && event.getEntity() instanceof Player player) {
				if (player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
					if (player.level().dimension().equals(LevelRegistry.VETHEA)) saveToInv(player, VETHEA_INVENTORY);
					else saveToInv(player, OVERWORLD_INVENTORY);
				} else if (player.level().dimension().equals(LevelRegistry.VETHEA)) clearInv(player, VETHEA_INVENTORY);
				else clearInv(player, OVERWORLD_INVENTORY);
			}
		}
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
		if(CommonConfig.saferVetheanInventory.get() == false) {
			if (!event.isCanceled()) {
				Player player = event.getEntity();
				if (player.level().dimension().equals(LevelRegistry.VETHEA)) loadInv(player, VETHEA_INVENTORY);
				else loadInv(player, OVERWORLD_INVENTORY);
				player.inventoryMenu.broadcastChanges();
				ArmorAbilitiesEvent.updateAbilities(player);
			}
		}
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDimensionChange(EntityTravelToDimensionEvent event) {
		if(CommonConfig.saferVetheanInventory.get() == false) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			boolean from = player.level().dimension().equals(LevelRegistry.VETHEA), to = event.getDimension().equals(LevelRegistry.VETHEA);
			if (from ^ to) {
				if (from) {
					saveToInv(player, VETHEA_INVENTORY);
					loadInv(player, OVERWORLD_INVENTORY);
				} else {
					saveToInv(player, OVERWORLD_INVENTORY);
					loadInv(player, VETHEA_INVENTORY);
				}
				player.inventoryMenu.broadcastChanges();
				player.removeAllEffects();
			} else if (from && to) saveToInv(player, VETHEA_INVENTORY);
			else saveToInv(player, OVERWORLD_INVENTORY);
			ArmorAbilitiesEvent.updateAbilities(player);
		}
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