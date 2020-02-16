package divinerpg.networking.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class EquipmentChangeMessage implements IMessage {

    /**
     * All we need is just to send that we need to recalculate armor status
     */
    public EquipmentChangeMessage() {
    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {
        // ignored
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        // ignored
    }

    public static class Handler implements IMessageHandler<EquipmentChangeMessage, IMessage> {

        @Override
        public IMessage onMessage(EquipmentChangeMessage msg, MessageContext ctx) {
            if (ctx.side == Side.SERVER) {
                EntityPlayerMP player = ctx.getServerHandler().player;
            }

            return null;
        }
    }
}
