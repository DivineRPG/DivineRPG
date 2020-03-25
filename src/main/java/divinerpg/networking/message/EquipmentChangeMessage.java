package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.armorNew.MainArmorEvents;
import divinerpg.api.armorNew.PlayerArmorObserver;
import io.netty.buffer.ByteBuf;
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
            if (ctx.side == Side.CLIENT && DivineRPG.proxy.getPlayer() != null) {
                PlayerArmorObserver observer = MainArmorEvents.findPlayerArmorObserver(DivineRPG.proxy.getPlayer());

                if (observer != null) {
                    observer.rememberEquipment();
                    observer.recheckEquipment();
                }
            }

            return null;
        }
    }
}
