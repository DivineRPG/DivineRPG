package divinerpg.events;

import divinerpg.registries.KeyRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VetheaInventorySwapEvent {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDimensionTravel(EntityTravelToDimensionEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) return;
            PlayerEntity player = (PlayerEntity) event.getEntity();

        if (event.getDimension().equals(KeyRegistry.VETHEA_WORLD) || player.level.dimension().equals(KeyRegistry.VETHEA_WORLD)) {
            if (!player.inventory.isEmpty()) {
                    player.sendMessage(LocalizeUtils.i18n("tooltip.divinerpg.vethea_inventory_blocked"), player.getUUID());
                event.setCanceled(true);
            }
        }
    }
}
