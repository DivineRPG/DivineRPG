package divinerpg.network.payload;

import divinerpg.DivineRPG;
import divinerpg.network.Payloads;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ItemContentChanged(BlockPos pos, String itemid) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<ItemContentChanged> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "item_content_changed"));
	public static final StreamCodec<ByteBuf, ItemContentChanged> STREAM_CODEC = StreamCodec.composite(Payloads.BLOCK_POS, ItemContentChanged::pos, ByteBufCodecs.STRING_UTF8, ItemContentChanged::itemid, ItemContentChanged::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}