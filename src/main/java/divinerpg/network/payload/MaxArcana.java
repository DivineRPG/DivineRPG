package divinerpg.network.payload;

import divinerpg.DivineRPG;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record MaxArcana(float amount) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<MaxArcana> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "max_arcana"));
	public static final StreamCodec<ByteBuf, MaxArcana> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, MaxArcana::amount, MaxArcana::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}