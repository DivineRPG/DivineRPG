package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.networking.message.ArmorStatusChangedMessage;
import divinerpg.networking.message.MessageArcanaBar;
import divinerpg.networking.message.MessageDivineAccumulator;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.relauncher.Side;

public class MessageRegistry {
    private static int i = 0;

    public static void initMessages() {
        registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, Side.CLIENT);
        registerMessage(MessageDivineAccumulator.Handler.class, MessageDivineAccumulator.class, Side.CLIENT);
        registerMessage(ArmorStatusChangedMessage.Handler.class, ArmorStatusChangedMessage.class);
    }

    /**
     * Registering message with handler.
     * Should receive on both sides
     *
     * @param messageHandler     - message handler class
     * @param requestMessageType - message class
     * @param <REQ>              - any IMessage child types
     * @param <REPLY>            - any IMessage child types. Can be different from REQ type
     */
    public static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType) {
        registerMessage(messageHandler, requestMessageType, Side.CLIENT);
        registerMessage(messageHandler, requestMessageType, Side.SERVER);
    }

    /**
     * Registering message with handler
     *
     * @param messageHandler     - message handler class
     * @param requestMessageType - message class
     * @param <REQ>              - any IMessage child types
     * @param <REPLY>            - any IMessage child types. Can be different from REQ type
     */
    public static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side handlerSide) {
        DivineRPG.network.registerMessage(messageHandler, requestMessageType, i++, handlerSide);
    }
}
