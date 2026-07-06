package net.divinerpg.client;

import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class FancyRenders {

    @SubscribeEvent
    public static void onAddLayer(EntityRenderersEvent.AddLayers event) {
        addHatToSkin(event, PlayerModelType.WIDE);
        addHatToSkin(event, PlayerModelType.SLIM);
    }

    private static void addHatToSkin(EntityRenderersEvent.AddLayers event, PlayerModelType type) {
        var renderer = event.getPlayerRenderer(type);
        if (renderer != null) {
//            renderer.addLayer(new PlayerHatRender(renderer, event.getEntityModels()));
        }
    }
}