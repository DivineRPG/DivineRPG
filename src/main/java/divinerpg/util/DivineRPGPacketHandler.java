package divinerpg.util;

import java.util.function.Supplier;

import divinerpg.DivineRPG;
import divinerpg.util.packets.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.*;
import net.minecraftforge.network.simple.SimpleChannel;

public class DivineRPGPacketHandler {
	private static final String PROTOCOL_VERSION = "2";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
		new ResourceLocation(DivineRPG.MODID, "main"),
		() -> PROTOCOL_VERSION,
		PROTOCOL_VERSION::equals,
		PROTOCOL_VERSION::equals
	);
	public static void init() {
		int index = 0;
		INSTANCE.registerMessage(index++, Byte.class, (l, buf) -> buf.writeByte(l), (buf) -> buf.readByte(), DivineRPGPacketHandler::handleNewWeather);
		INSTANCE.registerMessage(index++, PacketArcanaBar.class, PacketArcanaBar::toBytes, PacketArcanaBar::new, PacketArcanaBar::handle);
		INSTANCE.registerMessage(index++, PacketItemContentChanged.class, PacketItemContentChanged::toBytes, PacketItemContentChanged::new, PacketItemContentChanged::handle);
		INSTANCE.registerMessage(index++, PacketRequestItemContent.class, PacketRequestItemContent::toBytes, PacketRequestItemContent::new, PacketRequestItemContent::handle);
		INSTANCE.registerMessage(index++, PacketRequestReputation.class, PacketRequestReputation::toByte, PacketRequestReputation::new, PacketRequestReputation::handle);
		INSTANCE.registerMessage(index++, PacketReputation.class, PacketReputation::toBytes, PacketReputation::new, PacketReputation::handle);
	}
	public static void handleNewWeather(Byte i, Supplier<NetworkEvent.Context> ctx) {
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
