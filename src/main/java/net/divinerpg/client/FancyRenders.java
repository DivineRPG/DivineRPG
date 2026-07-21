package net.divinerpg.client;

import net.divinerpg.client.models.ModelHat;
import net.divinerpg.client.render.PlayerHatRender;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber
public class FancyRenders {

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelHat.LAYER_LOCATION, ModelHat::createBodyLayer);
    }

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