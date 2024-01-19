package divinerpg.util;

import divinerpg.DivineRPG;
import divinerpg.capability.PacketArcanaBar;
import divinerpg.items.arcana.PacketDivineAccumulator;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.*;

import java.util.function.Supplier;

public class DivineRPGPacketHandler {


	@SubscribeEvent
	public static void register(final RegisterPayloadHandlerEvent event) {
		final IPayloadRegistrar registrar = event.registrar(DivineRPG.MODID).versioned("2.0.0").optional();
	}

	public static void init() {
		int index = 0;
		INSTANCE.registerMessage(index++, Byte.class, (l, buf) -> buf.writeByte(l), (buf) -> buf.readByte(), DivineRPGPacketHandler::handle);
		INSTANCE.registerMessage(index++, PacketArcanaBar.class, PacketArcanaBar::toBytes, PacketArcanaBar::new, PacketArcanaBar::handle);
		INSTANCE.registerMessage(index++, PacketDivineAccumulator.class, PacketDivineAccumulator::toBytes, PacketDivineAccumulator::new, PacketDivineAccumulator::handle);
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
