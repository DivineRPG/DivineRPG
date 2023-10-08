package divinerpg.util;

import java.util.function.Supplier;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.*;
import net.minecraftforge.network.simple.SimpleChannel;

public class DivineRPGPacketHandler {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
		new ResourceLocation(DivineRPG.MODID, "main"),
		() -> PROTOCOL_VERSION,
		PROTOCOL_VERSION::equals,
		PROTOCOL_VERSION::equals
	);
	public static void init() {
		INSTANCE.registerMessage(0, Byte.class, (l, buf) -> buf.writeByte(l), (buf) -> buf.readByte(), DivineRPGPacketHandler::handle);
	}
	public static void handle(Byte i, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			  Utils.ICEIKA_WEATHER = i;
		});
		ctx.get().setPacketHandled(true);
	}
	public static byte newWeather() {
		byte b = (byte)(Math.random() * 4D);
		INSTANCE.send(PacketDistributor.ALL.noArg(), b);
		return b;
	}
}
