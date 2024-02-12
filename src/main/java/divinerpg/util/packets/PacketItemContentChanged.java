package divinerpg.util.packets;

import java.util.function.Supplier;

import divinerpg.registries.BlockEntityRegistry;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.*;
import net.minecraftforge.network.NetworkEvent;

public class PacketItemContentChanged {
	public final BlockPos pos;
	public final Item content;
	public PacketItemContentChanged(ByteBuf buf) {
		pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		content = Item.byId(buf.readInt());
	}
	public PacketItemContentChanged(BlockPos pos, Item item) {
		this.pos = pos;
		content = item;
	}
	public void toBytes(ByteBuf buf) {
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		buf.writeInt(Item.getId(content));
	}
	@SuppressWarnings("resource")
	public void handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Minecraft.getInstance().level.getBlockEntity(pos, BlockEntityRegistry.ROBBIN_NEST.get()).ifPresent((block) -> {block.setItemNoUpdate(new ItemStack(content));});
		});
		ctx.get().setPacketHandled(true);
	}
}