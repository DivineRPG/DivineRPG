package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.armorset.FullArmorHandler;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import static divinerpg.registry.ModArmorEvents.ALL_HANDLERS;
import static divinerpg.registry.ModArmorEvents.HANDLERS_MAP;

public class EquipmentChangeMessage implements IMessage {

    private int handleIndex;
    private boolean isEquipped;

    /**
     * Message to client about equipment changed
     *
     * @param handler    - handler that should be called
     * @param isEquipped - is player full armored
     */
    public EquipmentChangeMessage(FullArmorHandler handler, boolean isEquipped) {
        this.handleIndex = ALL_HANDLERS.indexOf(handler);
        this.isEquipped = isEquipped;
    }

    /**
     * Empty ctor for internal usage
     */
    public EquipmentChangeMessage() {
    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {
        isEquipped = byteBuf.readBoolean();
        handleIndex = byteBuf.readInt();
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        byteBuf.writeBoolean(isEquipped);
        byteBuf.writeInt(handleIndex);
    }

    public static class Handler implements IMessageHandler<EquipmentChangeMessage, IMessage> {

        @Override
        public IMessage onMessage(EquipmentChangeMessage msg, MessageContext messageContext) {
            if (messageContext.side == Side.CLIENT) {
                if (msg.handleIndex < 0 || ALL_HANDLERS.size() <= msg.handleIndex) {
                    DivineRPG.logger.warn("Wrong handle index " + msg.handleIndex + ", currently we have " + ALL_HANDLERS.size() + " total handlers");
                } else {
                    // Find handler by index
                    FullArmorHandler currentHandler = ALL_HANDLERS.get(msg.handleIndex);
                    // put a new value
                    HANDLERS_MAP.merge(currentHandler, msg.isEquipped, (aBoolean, aBoolean2) -> msg.isEquipped);
                    // call handler
                    currentHandler.onStatusChanged(DivineRPG.proxy.getPlayer(), msg.isEquipped);
                }
            }

            return null;
        }
    }
}
