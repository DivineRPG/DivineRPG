package divinerpg.events;

import divinerpg.attachments.*;
import divinerpg.config.CommonConfig;
import divinerpg.registries.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "drpg_regular_inventory", VETHEA_INVENTORY = "drpg_dream_inventory";
	@SubscribeEvent
	public void onClone(PlayerEvent.Clone event) {
		Player original = event.getOriginal(), clone = event.getEntity();
		if(original.hasData(AttachmentRegistry.REPUTATION)) clone.setData(AttachmentRegistry.REPUTATION, original.getData(AttachmentRegistry.REPUTATION));
		if(original.hasData(AttachmentRegistry.DIMENSIONAL_INVENTORY)) clone.setData(AttachmentRegistry.DIMENSIONAL_INVENTORY, original.getData(AttachmentRegistry.DIMENSIONAL_INVENTORY));
		if(original.hasData(AttachmentRegistry.MAX_ARCANA)) clone.setData(AttachmentRegistry.MAX_ARCANA, original.getData(AttachmentRegistry.MAX_ARCANA));
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDeath(LivingDeathEvent event) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			if(!CommonConfig.SAFER_VETHEA) {
				DimensionalInventory d = player.getData(AttachmentRegistry.DIMENSIONAL_INVENTORY);
				if(player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
					if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.saveInventory(player, VETHEA_INVENTORY);
					else d.saveInventory(player, OVERWORLD_INVENTORY);
				} else if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.clearInventory(VETHEA_INVENTORY);
				else d.clearInventory(OVERWORLD_INVENTORY);
			} ArmorAbilitiesEvent.updateAbilities(player);
		}
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
		Player player = event.getEntity();
		if(!CommonConfig.SAFER_VETHEA) {
			DimensionalInventory d = player.getData(AttachmentRegistry.DIMENSIONAL_INVENTORY);
			if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.loadInventory(player, VETHEA_INVENTORY);
			else d.loadInventory(player, OVERWORLD_INVENTORY);
			player.inventoryMenu.broadcastChanges();
		} ArmorAbilitiesEvent.updateAbilities(player);
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDimensionChange(EntityTravelToDimensionEvent event) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			if(!CommonConfig.SAFER_VETHEA) {
				boolean from = player.level().dimension().equals(LevelRegistry.VETHEA), to = event.getDimension().equals(LevelRegistry.VETHEA);
				DimensionalInventory d = player.getData(AttachmentRegistry.DIMENSIONAL_INVENTORY);
				if(from ^ to) {
					if(from) {
						d.saveInventory(player, VETHEA_INVENTORY);
						d.loadInventory(player, OVERWORLD_INVENTORY);
					} else {
						d.saveInventory(player, OVERWORLD_INVENTORY);
						d.loadInventory(player, VETHEA_INVENTORY);
					} player.removeAllEffects();
				} else if(from && to) d.saveInventory(player, VETHEA_INVENTORY);
				else d.saveInventory(player,  OVERWORLD_INVENTORY);
			} ArmorAbilitiesEvent.updateAbilities(player);
		}
	}
}