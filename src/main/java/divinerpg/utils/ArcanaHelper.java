package divinerpg.utils;

import divinerpg.attachments.data.ArcanaData;
import divinerpg.config.Config;
import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ArcanaHelper {

    public static boolean hasArcana(@Nullable Entity entity) {
        return entity != null && entity.hasData(AttachmentRegistry.ARCANA.attachment.get());
    }

    public static float getArcana(Entity entity) {
        if (entity == null) return 0F;
        return entity.getData(AttachmentRegistry.ARCANA.attachment.get()).getValue();
    }

    public static float getMaxArcana(Entity entity) {
        if (entity == null) return 0F;
        return entity.getData(AttachmentRegistry.ARCANA.attachment.get()).getMaxValue();
    }

    public static void setArcana(Entity entity, float value) {
        if (entity == null) return;
        ArcanaData data = entity.getData(AttachmentRegistry.ARCANA.attachment.get());
        float clamped = Math.clamp(value, 0F, data.getMaxValue());

        if (data.getValue() != clamped) {
            data.setValue(clamped);
            entity.setData(AttachmentRegistry.ARCANA.attachment.get(), data);

            if (canSendPackets(entity)) {
                AttachmentRegistry.ARCANA.update(entity, data);
            }
        }
    }

    public static void setMaxArcana(Entity entity, float max) {
        if (entity == null) return;
        ArcanaData data = entity.getData(AttachmentRegistry.ARCANA.attachment.get());
        float newMax = Math.max(max, 0F);

        if (data.getMaxValue() != newMax) {
            data.setMaxValue(newMax);
            // Ensure current value doesn't exceed the new maximum
            if (data.getValue() > newMax) {
                data.setValue(newMax);
            }
            entity.setData(AttachmentRegistry.ARCANA.attachment.get(), data);

            if (canSendPackets(entity)) {
                AttachmentRegistry.ARCANA.update(entity, data);
            }
        }
    }

    public static void modifyAmount(Entity entity, float amount) {
        if (entity == null || amount == 0F) return;
        if (amount < 0F && entity instanceof Player player && player.isCreative()) {
            return;
        }
        setArcana(entity, getArcana(entity) + amount);
    }

    public static int getRegenDelay() {
        return 4;
    }

    public static void regen(Entity entity) {
        if (entity != null && entity.level().getGameTime() % getRegenDelay() == 0) {
            float regenAmount = (entity instanceof LivingEntity living/* && living.hasEffect(MobEffectRegistry.KORMA_ARCANA)*/) ? 4F : 1F;
            modifyAmount(entity, regenAmount);
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
                regen(event.getEntity());
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
                    data.setMaxValue(Config.Values.ARCANA_MAX);
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
        modifyAmount(entity, -Math.abs(amount));
    }
}