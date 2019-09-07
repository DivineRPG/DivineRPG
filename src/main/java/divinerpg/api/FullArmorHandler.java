package divinerpg.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handler for special armor powers
 */
public class FullArmorHandler {
    private final Item head;
    private final Item chest;
    private final Item legs;
    private final Item boots;
    private final IEquipped equipped;
    private final Map<Class, List<IPowerAbility>> abilityMap = new HashMap<>();

    public FullArmorHandler(Item head, Item chest, Item legs, Item boots) {
        this(head, chest, legs, boots, null);
    }

    public FullArmorHandler(Item head, Item chest, Item legs, Item boots, IEquipped equipped) {
        this.head = head;
        this.chest = chest;
        this.legs = legs;
        this.boots = boots;
        this.equipped = equipped;
    }

    public Item getLegs() {
        return legs;
    }

    public Item getBoots() {
        return boots;
    }

    public Item getChest() {
        return chest;
    }

    public IEquipped getEquipped() {
        return equipped;
    }

    /**
     * Ability handler on event by type
     */
    public <T extends Event> FullArmorHandler withAbility(Class<T> clazz, IPowerAbility<T> ability) {
        if (!abilityMap.containsKey(clazz)) {
            abilityMap.put(clazz, new ArrayList<>());
        }

        abilityMap.get(clazz).add(ability);
        return this;
    }

    public <T extends Event> void handle(T event) {
        Class<? extends Event> clazz = event.getClass();
        if (abilityMap.containsKey(clazz)) {
            abilityMap.get(clazz).forEach(iPowerAbility -> iPowerAbility.handle(event));
        }
    }

    @Override
    public int hashCode() {
        return head.hashCode() ^ chest.hashCode() ^ legs.hashCode() ^ boots.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        FullArmorHandler handler = (FullArmorHandler) obj;
        if (handler == null)
            return false;

        return head == handler.head
                && chest == handler.chest
                && legs == handler.legs
                && boots == handler.boots;
    }

    public Item getHead() {
        return head;
    }

    @FunctionalInterface
    public interface IEquipped {
        /**
         * Called when need to toggle armor power ability
         *
         * @param player
         * @param isFullEquipped - is player full armored
         */
        void onStatusChanged(EntityPlayer player, boolean isFullEquipped);
    }

    @FunctionalInterface
    public interface IPowerAbility<T extends Event> {
        /**
         * Called on event when player is full equipped.
         *
         * @param event - Forge event
         */
        void handle(T event);
    }
}
