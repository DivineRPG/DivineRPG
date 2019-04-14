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
                float fovModifier = getNewFovModifier(event.getEntity().getItemInUseMaxCount());
                float fov = 1.0f;
                fov *= 1.0F - fovModifier * 0.15F;
                event.setNewfov(fov);
            }
        }
    }

    protected float getNewFovModifier(int itemInUseDuration) {
        float f = (float) itemInUseDuration / 20.0F;
        if (f > 1.0F) {
            f = 1.0F;
        } else {
            f *= f;
        }
        return f;
    }
}
