package divinerpg.util.packets;

import java.util.function.Supplier;

import divinerpg.block_entities.block.RobbinNestBlockEntity;
import divinerpg.util.DivineRPGPacketHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraftforge.network.*;

public class PacketRequestItemContent {
	public final BlockPos pos;
	public PacketRequestItemContent(ByteBuf buf) {
		pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
	}
	public PacketRequestItemContent(BlockPos pos) {
		this.pos = pos;
	}
	public void toBytes(ByteBuf buf) {
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
	}
	public void handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			if(ctx.get().getSender().level().getBlockEntity(pos) instanceof RobbinNestBlockEntity robbinNest) DivineRPGPacketHandler.INSTANCE.reply(new PacketItemContentChanged(pos, robbinNest.getItem().getItem()), ctx.get());
		});
		ctx.get().setPacketHandled(true);
	}
}