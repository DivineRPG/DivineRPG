package divinerpg.network.payload;

import divinerpg.DivineRPG;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ArcanaAmount(float amount) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<ArcanaAmount> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "arcana"));
	public static final StreamCodec<ByteBuf, ArcanaAmount> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, ArcanaAmount::amount, ArcanaAmount::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}