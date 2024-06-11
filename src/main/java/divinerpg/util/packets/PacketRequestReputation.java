package divinerpg.util.packets;

import java.util.function.Supplier;

import divinerpg.entities.base.FactionEntity.Faction;
import divinerpg.util.DivineRPGPacketHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PacketRequestReputation {
	public final Faction faction;
	public PacketRequestReputation(ByteBuf buf) {
		byte b = buf.readByte();
		faction = b == 0 ? Faction.GROGLIN : (b == 1 ? Faction.GRUZZORLUG : Faction.ICEIKA_MERCHANT);
	}
	public PacketRequestReputation(Faction faction) {
		this.faction = faction;
	}
	public void toByte(ByteBuf buf) {
		buf.writeByte(faction == Faction.GROGLIN ? 0 : (faction == Faction.GRUZZORLUG ? 1 : 2));
	}
	public void handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			DivineRPGPacketHandler.INSTANCE.reply(new PacketReputation(faction.getReputation(ctx.get().getSender())), ctx.get());
		});
		ctx.get().setPacketHandled(true);
	}
}