package naturix.divinerpg.events;

import naturix.divinerpg.objects.items.base.ItemModBow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventBowZoom {
    @SubscribeEvent
    public void fovUpdate(FOVUpdateEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            if (event.getEntity().isHandActive()
                    && event.getEntity().getActiveItemStack().getItem() instanceof ItemModBow) {
                ItemModBow bow = (ItemModBow) event.getEntity().getActiveItemStack().getItem();
                int itemInUseDuration = event.getEntity().getItemInUseMaxCount();
                float timeRatio = ItemModBow.DEFAULT_MAX_USE_DURATION / bow.getMaxItemUseDuration(null);
                float fovModifier = getNewFovModifier(itemInUseDuration, timeRatio);
                float fov = 1.0f;
                fov *= 1.0F - fovModifier * 0.15F;
                //DivineRPG.logger.info("fovUpdate(): itemUseDuration = " + itemInUseDuration + "; fovModifier = "
                //        + fovModifier + "; newfov = " + fov);
                event.setNewfov(fov);
            }
        }
    }

    protected float getNewFovModifier(int itemInUseDuration, float timeRatio) {
        float f = ((float) itemInUseDuration / 20.0F) * timeRatio;
        if (f > 1.0F) {
            f = 1.0F;
        } else {
            f *= f;
        }
        return f;
    }
}
