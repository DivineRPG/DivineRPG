package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmorManage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PoweredArmorManager implements IPoweredArmorManage {

    private final List<ForgeEventHandler<?>> abilities;
    private IPoweredArmor armor;
    private final Set<EntityPlayer> players = new HashSet<>();

    public PoweredArmorManager(IPoweredArmor armor) {

        this.armor = armor;

        // cloning abilities
        abilities = armor.getAbilityMap().values().stream()
                .map(x -> (ForgeEventHandler<?>) x.cloneWithPredicate(this::canExecute))
                .collect(Collectors.toList());
    }

    @Override
    public IPoweredArmor getArmorSet() {
        return armor;
    }

    @Override
    public void addPlayer(EntityPlayer player) {
        players.add(player);
        checkSubscription();

        getArmorSet().onEquppedChanged(player, true);
    }

    @Override
    public void removePlayer(EntityPlayer player) {
        players.remove(player);
        checkSubscription();

        getArmorSet().onEquppedChanged(player, false);
    }

    /**
     * Check wherever we can subscribe on events
     */
    private void checkSubscription() {
        // unsubscribe
        if (players.isEmpty()) {
            abilities.forEach(ForgeEventHandler::unsubscribe);
        }
        // subscribe
        else if (players.size() == 1) {
            abilities.forEach(ForgeEventHandler::subscribe);
        }
    }

    /**
     * Check if we can execute current event for armor set.
     * Player from event should be equipped with current set
     *
     * @param e   - event
     * @param <T> - event type
     * @return
     */
    private <T extends Event> boolean canExecute(T e) {
        if (players.isEmpty())
            return false;

        return players.contains(getPlayerFromEvent(e));
    }

    /**
     * We need to get player reference from Event.
     * Possible weak-perfomance method
     *
     * @return
     */
    private <T extends Event> Entity getPlayerFromEvent(T e) {
        if (e instanceof EntityEvent && ((EntityEvent) e).getEntity() instanceof EntityPlayer) {
            return ((EntityEvent) e).getEntity();
        }

        if (e instanceof TickEvent.PlayerTickEvent) {
            return ((TickEvent.PlayerTickEvent) e).player;
        }

        if (e instanceof LivingHurtEvent
                && ((LivingHurtEvent) e).getSource().getTrueSource() instanceof EntityPlayer) {
            return ((LivingHurtEvent) e).getSource().getTrueSource();
        }

        if (e instanceof BlockEvent.BreakEvent) {
            return ((BlockEvent.BreakEvent) e).getPlayer();
        }

        if (e instanceof BlockEvent.PlaceEvent) {
            return ((BlockEvent.PlaceEvent) e).getPlayer();
        }

        if (e instanceof BlockEvent.HarvestDropsEvent) {
            return ((BlockEvent.HarvestDropsEvent) e).getHarvester();
        }

        return null;
    }
}
