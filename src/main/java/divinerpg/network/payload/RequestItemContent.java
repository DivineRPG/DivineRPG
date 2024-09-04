package divinerpg.network.payload;

import divinerpg.DivineRPG;
import divinerpg.network.Payloads;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RequestItemContent(BlockPos pos) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<RequestItemContent> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "request_item_content"));
	public static final StreamCodec<ByteBuf, RequestItemContent> STREAM_CODEC = StreamCodec.composite(Payloads.BLOCK_POS, RequestItemContent::pos, RequestItemContent::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}