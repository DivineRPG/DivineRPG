package divinerpg.attachments.data.base;

import com.mojang.serialization.Codec;
import divinerpg.registries.DivineRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class ServerHandledAttachment<T> extends SynchedAttachment<T> {
    public ServerHandledAttachment(String name, Supplier<T> defaultValue, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        super(name, defaultValue, codec, streamCodec);
    }

    protected ServerHandledAttachment(String name, DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        super(name, attachment, streamCodec);
    }

    @Override
    public void registerPayload(PayloadRegistrar r) {
        r.playToClient(type, streamCodec, (payload, context) -> context.enqueueWork(() -> {
            Entity e = context.player().level().getEntity(payload.entityID);
            if (e != null) e.setData(attachment.get(), payload.data);
        }));
        r.playToServer(requestType, requestCodec, (payload, context) -> context.enqueueWork(() -> {
            Entity e = context.player().level().getEntity(payload.entityID);
            if (e != null) context.reply(new AttachmentPayload(e.getData(attachment.get()), payload.entityID));
        }));
    }

    @Override
    public void requestAttachment(Entity e, ServerPlayer player) {
        if (!e.level().isClientSide()) throw new UnsupportedOperationException("Only client can send Data request!");
        PacketDistributor.sendToPlayer(player, new RequestAttachmentPayload(e.getId()));
    }

    @Override
    public boolean validate(Entity e, T data) {
        if (e.level().isClientSide()) throw new UnsupportedOperationException("Server handled Data only!");
        return super.validate(e, data);
    }

    @Override
    public void update(Entity e, T data) {
        PacketDistributor.sendToPlayersTrackingEntityAndSelf(e, new AttachmentPayload(data, e.getId()));
    }

    public static class Serializable<S extends ValueIOSerializable> extends ServerHandledAttachment<S> {
        public Serializable(String name, Supplier<S> defaultValue, StreamCodec<? super RegistryFriendlyByteBuf, S> streamCodec) {
            super(name, DivineRegistries.ATTACHMENTS.register(name, () -> AttachmentType.serializable(defaultValue).build()), streamCodec);
        }
    }
}