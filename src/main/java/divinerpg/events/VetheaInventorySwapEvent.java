package divinerpg.events;

import divinerpg.capability.*;
import divinerpg.config.CommonConfig;
import divinerpg.registries.*;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.packets.PacketArcanaBar;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.network.PacketDistributor;

public class VetheaInventorySwapEvent {
	public static final String OVERWORLD_INVENTORY = "drpg_regular_inventory", VETHEA_INVENTORY = "drpg_dream_inventory";
	@SubscribeEvent
	public void onClone(PlayerEvent.Clone event) {
		Player original = event.getOriginal(), clone = event.getEntity();
		original.reviveCaps();
		original.getCapability(ReputationProvider.REPUTATION).ifPresent((origin) -> clone.getCapability(ReputationProvider.REPUTATION).ifPresent((target) -> origin.transferTo(target)));
		original.getCapability(DimensionalInventoryProvider.DIMENIONAL_INVENTORY).ifPresent((origin) -> clone.getCapability(DimensionalInventoryProvider.DIMENIONAL_INVENTORY).ifPresent((target) -> origin.transferTo(target)));
		original.invalidateCaps();
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDeath(LivingDeathEvent event) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			if(CommonConfig.saferVetheanInventory.get() == false) {
				DimensionalInventory d = player.getCapability(DimensionalInventoryProvider.DIMENIONAL_INVENTORY).orElse(null);
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
		if(!event.isCanceled()) {
			Player player = event.getEntity();
			DivineRPGPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer)player), new PacketArcanaBar(new Arcana()));
			if(CommonConfig.saferVetheanInventory.get() == false) {
				DimensionalInventory d = player.getCapability(DimensionalInventoryProvider.DIMENIONAL_INVENTORY).orElse(null);
				if(player.level().dimension().equals(LevelRegistry.VETHEA)) d.loadInventory(player, VETHEA_INVENTORY);
				else d.loadInventory(player, OVERWORLD_INVENTORY);
				player.inventoryMenu.broadcastChanges();
			} ArmorAbilitiesEvent.updateAbilities(player);
		}
	}
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onDimensionChange(EntityTravelToDimensionEvent event) {
		if(!event.isCanceled() && event.getEntity() instanceof Player player) {
			if(CommonConfig.saferVetheanInventory.get() == false) {
				boolean from = player.level().dimension().equals(LevelRegistry.VETHEA), to = event.getDimension().equals(LevelRegistry.VETHEA);
				DimensionalInventory d = player.getCapability(DimensionalInventoryProvider.DIMENIONAL_INVENTORY).orElse(null);
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