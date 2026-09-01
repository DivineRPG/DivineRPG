package divinerpg.network.payload;

import divinerpg.DivineRPG;
import divinerpg.network.Payloads;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.*;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record RiftVariant(BlockPos pos, byte variant) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RiftVariant> TYPE = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "rift_variant"));
    public static final StreamCodec<ByteBuf, RiftVariant> STREAM_CODEC = StreamCodec.composite(Payloads.BLOCK_POS, RiftVariant::pos, ByteBufCodecs.BYTE, RiftVariant::variant, RiftVariant::new);
    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}