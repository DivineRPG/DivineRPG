package divinerpg.network.payload;

import divinerpg.DivineRPG;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.network.PacketDistributor;

public record Weather(byte weatherType) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<Weather> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "weather"));
	public static final StreamCodec<ByteBuf, Weather> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BYTE, Weather::weatherType, Weather::new);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
	public static byte newWeather(ServerLevel level) {
		byte b = (byte)(Math.random() * 4D);
		PacketDistributor.sendToPlayersInDimension(level, new Weather(b));
		return b;
	}
}