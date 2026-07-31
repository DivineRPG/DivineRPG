package divinerpg.client;

import divinerpg.client.renders.PlayerHatRender;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@EventBusSubscriber(modid = MODID, value = CLIENT)
public class FancyRenders {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerModelType modelType : event.getSkins()) {
            AvatarRenderer renderer = event.getPlayerRenderer(modelType);
            if (renderer != null) {
                renderer.addLayer(new PlayerHatRender(renderer, event.getEntityModels()));
            }
        }
    }
}