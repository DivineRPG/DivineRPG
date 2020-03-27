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
     * Change equipped status
     *
     * @param isOn
     */
    void changeStatus(boolean isOn);

    @Override
    default void subscribe() {
        getHandlers().forEach(IPlayerForgeEvent::subscribe);
    }

    @Override
    default void unsubscribe() {
        getHandlers().forEach(IPlayerForgeEvent::unsubscribe);
    }
}
