package net.divinerpg.utils;

import net.divinerpg.attachments.data.ArcanaData;
import net.divinerpg.registries.AttachmentRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class ArcanaHelper {

    public static float getArcana(Entity entity) {
        return entity.getData(AttachmentRegistry.ARCANA).getValue();
    }

    public static void setArcana(Entity entity, float value) {
        ArcanaData data = entity.getData(AttachmentRegistry.ARCANA);
        data.setValue(value);
        entity.setData(AttachmentRegistry.ARCANA, data);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!event.getEntity().level().isClientSide()) {
            ArcanaData data = event.getEntity().getData(AttachmentRegistry.ARCANA);
            if (data.getValue() < data.getMaxValue()) {
                data.setValue(data.getValue() + 0.1F);
                event.getEntity().setData(AttachmentRegistry.ARCANA, data);
            }
        }
    }

    public static boolean hasEnoughArcana(Player player, float amount) {
        return getArcana(player) >= amount;
    }

    public static void consumeArcana(Player player, float amount) {
        ArcanaData data = player.getData(AttachmentRegistry.ARCANA);
        data.setValue(Math.max(0, data.getValue() - amount));
        player.setData(AttachmentRegistry.ARCANA, data);
    }
}
