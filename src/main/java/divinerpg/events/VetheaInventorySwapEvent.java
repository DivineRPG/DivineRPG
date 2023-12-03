package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.compat.CuriosCompat;
import divinerpg.registries.LevelRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.ModList;

public class VetheaInventorySwapEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onDimensionChange(EntityTravelToDimensionEvent event) {
        if (!event.isCanceled() && event.getEntity() instanceof Player player) {
            boolean isVetheaDimension = player.level.dimension().equals(LevelRegistry.VETHEA);
            boolean isTargetVetheaDimension = event.getDimension().equals(LevelRegistry.VETHEA);
            boolean isOverworld = player.level.dimension().equals(Level.OVERWORLD);
            boolean isTargetOverworld = event.getDimension().equals(Level.OVERWORLD);

            if ((isVetheaDimension && isTargetOverworld) || (isOverworld && isTargetVetheaDimension)) {
                if (!player.inventory.isEmpty()) {
                    event.setCanceled(true);
                    player.displayClientMessage(Component.translatable("teleport.failed.inventory_not_empty"), true);

                    DivineRPG.LOGGER.warn("Dimension change canceled for player '{}' from '{}' to '{}' due to non-empty inventory.", player.getDisplayName(), player.level.dimension().location(), event.getDimension().location());


                    return;
                }
                if (ModList.get().isLoaded("curios")) {
                    if (CuriosCompat.checkCuriosSlots(player)) {
                        event.setCanceled(true);
                        player.displayClientMessage(Component.translatable("teleport.failed.curios_slots"), true);

                        DivineRPG.LOGGER.warn("Dimension change canceled for player '{}' from '{}' to '{}' due to insufficient Curios slots.", player.getDisplayName(), player.level.dimension().location(), event.getDimension().location());


                        return;
                    }
                }
            }
        }
    }
}