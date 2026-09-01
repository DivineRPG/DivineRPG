package divinerpg.network.payload;

import divinerpg.DivineRPG;
import divinerpg.network.Payloads;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record RequestRiftVariant(BlockPos pos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<RequestRiftVariant> TYPE = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "request_rift_variant"));
    public static final StreamCodec<ByteBuf, RequestRiftVariant> STREAM_CODEC = StreamCodec.composite(Payloads.BLOCK_POS, RequestRiftVariant::pos, RequestRiftVariant::new);
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}