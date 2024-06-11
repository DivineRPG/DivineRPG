package divinerpg.util.packets;

import java.util.function.Supplier;

import divinerpg.entities.base.FactionEntity.Faction;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class PacketReputation {
	public final int reputation;
	public PacketReputation(ByteBuf buf) {
		reputation = buf.readInt();
	}
	public PacketReputation(int reputation) {
		this.reputation = reputation;
	}
	public void toBytes(ByteBuf buf) {
		buf.writeInt(reputation);
	}
	public void handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Faction.rep = reputation;
		});
		ctx.get().setPacketHandled(true);
	}
}