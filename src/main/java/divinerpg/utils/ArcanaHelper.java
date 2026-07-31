package divinerpg.utils;

import divinerpg.attachments.data.ArcanaData;
import divinerpg.config.Config;
import divinerpg.registries.AttachmentRegistry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class ArcanaHelper {

    public static float getArcana(Entity entity) {
        return entity.getData(AttachmentRegistry.ARCANA.attachment.get()).getValue();
    }

    public static void setArcana(Entity entity, float value) {
        ArcanaData data = entity.getData(AttachmentRegistry.ARCANA.attachment.get());
        data.setValue(value);
        entity.setData(AttachmentRegistry.ARCANA.attachment.get(), data);

        if (canSendPackets(entity)) {
            AttachmentRegistry.ARCANA.update(entity, data);
        }
    }

    private static boolean canSendPackets(Entity entity) {
        if (entity instanceof ServerPlayer serverPlayer) {
            return serverPlayer.connection != null && serverPlayer.connection.isAcceptingMessages();
        }
        return !entity.level().isClientSide();
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!event.getEntity().level().isClientSide()) {
            if (event.getEntity() instanceof ServerPlayer serverPlayer) {
                if (!serverPlayer.connection.isAcceptingMessages()) {
                    return;
                }
            }

            ArcanaData data = event.getEntity().getData(AttachmentRegistry.ARCANA.attachment.get());
            if (data.getValue() < data.getMaxValue()) {
                data.setValue(data.getValue() + 0.1F);
                event.getEntity().setData(AttachmentRegistry.ARCANA.attachment.get(), data);
                AttachmentRegistry.ARCANA.update(event.getEntity(), data);
            }
        }
    }

    @SubscribeEvent
    public static void playerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            MinecraftServer server = player.level().getServer();
            if (server != null) {
                server.execute(() -> {
                    ArcanaData data = player.getData(AttachmentRegistry.ARCANA.attachment.get());
                    data.setValue(Config.Values.ARCANA_MAX);
                    player.setData(AttachmentRegistry.ARCANA.attachment.get(), data);
                    if (player.connection.isAcceptingMessages()) {
                        AttachmentRegistry.ARCANA.update(player, data);
                    }
                });
            }
        }
    }

    public static boolean hasEnoughArcana(Player player, float amount) {
        if (player.isCreative()) {
            return true;
        }
        return getArcana(player) >= amount;
    }

    public static void consumeArcana(Player player, float amount) {
        if (player.isCreative()) {
            return;
        }
        consumeArcana((Entity) player, amount);
    }

    public static void consumeArcana(Entity entity, float amount) {
        ArcanaData data = entity.getData(AttachmentRegistry.ARCANA.attachment.get());
        data.setValue(Math.max(0, data.getValue() - amount));
        entity.setData(AttachmentRegistry.ARCANA.attachment.get(), data);

        if (canSendPackets(entity)) {
            AttachmentRegistry.ARCANA.update(entity, data);
        }
    }
}