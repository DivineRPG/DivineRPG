package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.armorset.FullArmorHandler;
import divinerpg.events.armorEvents.PlayerHandlers;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import static divinerpg.registry.ModArmorEvents.ARMOR_HANDLERS;


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
        this.handleIndex = ARMOR_HANDLERS.getHandlerIndex(handler);
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
                PlayerHandlers handler = ARMOR_HANDLERS.getPlayerHandler(DivineRPG.proxy.getPlayer());
                handler.changeEquippedStatus(ARMOR_HANDLERS.getHandlerByIndex(msg.handleIndex), msg.isEquipped);
            }

            return null;
        }
    }
}
