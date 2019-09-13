package divinerpg.events.armorEvents;

import com.google.common.base.Function;
import divinerpg.api.armorset.FullArmorHandler;
import divinerpg.api.armorset.IPowerAbility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * Class managing armor handler for current user
 */
public class PlayerHandlers implements IPowerAbility {
    /**
     * Map of equipped armor handlers
     */
    private final Map<FullArmorHandler, Boolean> handlers_map = new HashMap<>();

    /**
     * Current player
     */
    private final EntityPlayer player;

    /**
     * @param player      - current player
     * @param allHandlers - all existing handlers
     */
    public PlayerHandlers(EntityPlayer player, List<FullArmorHandler> allHandlers) {
        this.player = player;
        handlers_map.putAll(allHandlers.stream().collect(Collectors.toMap(o -> o, o -> false)));
    }

    /**
     * Was created to call on client side. Force change of equipped status
     *
     * @param handler    - armor handler
     * @param isEquipped - is player full equipped
     */
    public void changeEquippedStatus(FullArmorHandler handler, boolean isEquipped) {
        if (handlers_map.containsKey(handler)) {
            throw new IllegalArgumentException("This handler is null or not registered!");
        }

        handlers_map.merge(handler, isEquipped, (aBoolean, aBoolean2) -> isEquipped);
        handler.onStatusChanged(player, isEquipped);
    }

    /**
     * Called on equipment change event
     *
     * @param isEquippedFunc        - function returning is player full equipped
     * @param onEquippedChangedFunc - function called when equipped status was changed
     */
    public void updateEquippedStatus(Function<FullArmorHandler, Boolean> isEquippedFunc, BiConsumer<FullArmorHandler, Boolean> onEquippedChangedFunc) {
        handlers_map.replaceAll((handler, wasEquipped) -> {
            Boolean isEquipped = isEquippedFunc.apply(handler);
            if (isEquipped != wasEquipped) {
                onEquippedChangedFunc.accept(handler, isEquipped);
            }
            return isEquipped;
        });
    }

    /**
     * Handling event for player
     *
     * @param event - Forge event
     */
    @Override
    public void handle(Event event) {
        Class<? extends Event> clazz = event.getClass();
        handlers_map.entrySet().stream().filter(Map.Entry::getValue)
                .forEach(x -> x.getKey().abilityMap.get(clazz).forEach(iPowerAbility -> iPowerAbility.handle(event)));
    }
}
