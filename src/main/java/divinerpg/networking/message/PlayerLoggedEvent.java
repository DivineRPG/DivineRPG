package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.armorNew.MainArmorEvents;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PlayerLoggedEvent implements IMessage {

    private boolean addedToWorld;

    public PlayerLoggedEvent(){

    }

    public PlayerLoggedEvent(boolean addedToWorld){

        this.addedToWorld = addedToWorld;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        addedToWorld = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(addedToWorld);
    }

    public static class Handler implements IMessageHandler<PlayerLoggedEvent, IMessage> {

        @Override
        public IMessage onMessage(PlayerLoggedEvent message, MessageContext ctx) {
            if (ctx.side == Side.CLIENT){
                if (message.addedToWorld){
                    MainArmorEvents.onLogin(new PlayerEvent.PlayerLoggedInEvent(DivineRPG.proxy.getPlayer()));
                } else {
                    MainArmorEvents.onPlayerLeave(new PlayerEvent.PlayerLoggedOutEvent(DivineRPG.proxy.getPlayer()));
                }
            }

            return null;
        }
    }
}
