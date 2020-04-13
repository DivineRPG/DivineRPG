package divinerpg.api.armor.binded;

import divinerpg.api.armor.IPlayerSubscription;

import java.util.List;

public interface IPlayerArmorDescription extends IPlayerSubscription {
    /**
     * list of armor powers
     *
     * @return
     */
    List<IPlayerForgeEvent<?>> getHandlers();

    /**
     * Changes armor set wearing status
     *
     * @param isOn        - is armor on
     * @param sendMessage - should send message to client
     */
    void changeStatus(boolean isOn, boolean sendMessage);

    @Override
    default void subscribe() {
        getHandlers().forEach(IPlayerForgeEvent::subscribe);
    }

    @Override
    default void unsubscribe() {
        getHandlers().forEach(IPlayerForgeEvent::unsubscribe);
    }

    @Override
    default boolean isListening() {
        return getHandlers().stream().anyMatch(IPlayerSubscription::isListening);
    }
}
