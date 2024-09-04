package divinerpg.network.payload;

import divinerpg.DivineRPG;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.*;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RequestReputation(String faction) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<RequestReputation> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "request_reputation"));
	public static final StreamCodec<ByteBuf, RequestReputation> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, RequestReputation::faction, RequestReputation::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}