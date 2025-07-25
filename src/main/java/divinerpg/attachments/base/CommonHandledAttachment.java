package divinerpg.attachments.base;

import com.mojang.serialization.Codec;
import divinerpg.registries.AttachmentRegistry;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class CommonHandledAttachment<T> extends SynchedAttachement<T> {
    public CommonHandledAttachment(String name, Supplier<T> defaultValue, Codec<T> codec, StreamCodec<ByteBuf, T> streamCodec) {
        super(name, defaultValue, codec, streamCodec);
    }
    protected CommonHandledAttachment(String name, DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment, StreamCodec<ByteBuf, T> streamCodec) {
        super(name, attachment, streamCodec);
    }
    @Override
    public void registerPayload(PayloadRegistrar r) {
        r.playBidirectional(type, streamCodec, (payload, context) -> context.enqueueWork(() -> {
            Player p = context.player();
            Entity e = p.level().getEntity(payload.entityID);
            if(e != null) {
                e.setData(attachment, payload.data);
                if(!p.level().isClientSide()) PacketDistributor.sendToPlayersTrackingEntity(e, new AttachmentPayload(payload.data, payload.entityID));
            }
        }));
        r.playBidirectional(requestType, requestCodec, (payload, context) -> context.enqueueWork(() -> {
            Entity e = context.player().level().getEntity(payload.entityID);
            if(e != null) context.reply(new AttachmentPayload(e.getData(attachment), payload.entityID));
        }));
    }
    @Override
    public void requestAttachment(Entity e, ServerPlayer player) {
        if(e.level().isClientSide()) PacketDistributor.sendToServer(new RequestAttachmentPayload(e.getId()));
        else PacketDistributor.sendToPlayer(player, new RequestAttachmentPayload(e.getId()));
    }
    @Override
    public void update(Entity e, T data) {
        if(e.level().isClientSide()) PacketDistributor.sendToServer(new AttachmentPayload(data, e.getId()));
        else PacketDistributor.sendToPlayersTrackingEntityAndSelf(e, new AttachmentPayload(data, e.getId()));
    }
    public static class Serializable<B extends Tag, S extends INBTSerializable<B>>  extends CommonHandledAttachment<S> {
        public Serializable(String name, Supplier<S> defaultValue, StreamCodec<ByteBuf, S> streamCodec) {
            super(name, AttachmentRegistry.ATTACHMENT_TYPES.register(name, () -> AttachmentType.serializable(defaultValue).build()), streamCodec);
        }
    }
}