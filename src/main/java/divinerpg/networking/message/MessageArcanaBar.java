package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageArcanaBar implements IMessage {

    private int delay;
    private float arcana;
    private float max;

    public MessageArcanaBar() {
    }

    public MessageArcanaBar(IArcana arcana) {
        if (arcana == null)
            return;

        delay = arcana.getRegenDelay();
        this.arcana = arcana.getArcana();
        max = arcana.getMaxArcana();
    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {
        max = byteBuf.readFloat();
        arcana = byteBuf.readFloat();
        delay = byteBuf.readInt();
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        byteBuf.writeFloat(max);
        byteBuf.writeFloat(arcana);
        byteBuf.writeInt(delay);
    }

    public static class Handler implements IMessageHandler<MessageArcanaBar, IMessage> {

        @Override
        public IMessage onMessage(MessageArcanaBar msg, MessageContext ctx) {

            if (ctx.side == Side.CLIENT) {
                IArcana capability = DivineAPI.getArcana(DivineRPG.proxy.getPlayer());

                if (capability != null) {
                    capability.setMaxArcana(msg.max);
                    capability.setRegenDelay(msg.delay);
                    capability.set(msg.arcana);
                }
            }

            return null;
        }

    }
}