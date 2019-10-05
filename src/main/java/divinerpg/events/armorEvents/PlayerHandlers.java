package divinerpg.events.armorEvents;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import divinerpg.api.java.divinerpg.api.armorset.FullArmorHandler;
import divinerpg.api.java.divinerpg.api.armorset.IPowerAbility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

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
    private final UUID player;

    /**
     * @param player      - current player
     * @param allHandlers - all existing handlers
     */
    public PlayerHandlers(EntityPlayer player, List<FullArmorHandler> allHandlers) {
        this.player = player.getUniqueID();
        handlers_map.putAll(allHandlers.stream().collect(Collectors.toMap(o -> o, o -> false)));
    }

    /**
     * Was created to call on client side. Force change of equipped status
     *
     * @param world - world where we are searchin for entity
     * @param handler    - armor handler
     * @param isEquipped - is player full equipped
     */
    public void changeEquippedStatus(World world, @Nullable FullArmorHandler handler, boolean isEquipped) {
        if (handler == null || !handlers_map.containsKey(handler)) {
            throw new IllegalArgumentException("This handler is null or not registered!");
        }

        handlers_map.merge(handler, isEquipped, (aBoolean, aBoolean2) -> isEquipped);
        handler.onStatusChanged(world.getPlayerEntityByUUID(player), isEquipped);
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
        handlers_map.entrySet().stream().filter(Map.Entry::getValue).map(x -> x.getKey().abilityMap.get(clazz))
                .filter(x -> x != null && !x.isEmpty()).flatMap(Collection::stream).forEach(x -> x.handle(event));
    }
}
