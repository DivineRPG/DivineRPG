package divinerpg.network.payload;

import divinerpg.DivineRPG;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.*;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record Reputation(String faction, int reputation) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<Reputation> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "reputation"));
	public static final StreamCodec<ByteBuf, Reputation> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, Reputation::faction, ByteBufCodecs.INT, Reputation::reputation, Reputation::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}