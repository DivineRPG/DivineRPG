package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IAbilityHandler;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmorManage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PoweredArmorManager implements IPoweredArmorManage {

    private final Set<EntityPlayer> players = new HashSet<>();
    private final List<IAbilityHandler<?>> ownHandlers = new ArrayList<>();
    private IPoweredArmor armor;

    public PoweredArmorManager(IPoweredArmor armor) {
        this.armor = armor;

        /**
         *
         */
        armor.getAbilityMap().forEach((key, value) -> {

            IAbilityHandler<Event> byPlayer = event -> {
                if (players.contains(getPlayerFromEvent(event))) {
                    value.handle(event);
                }
            };

            ownHandlers.add(byPlayer);
        });
    }

    @Override
    public IPoweredArmor getArmorSet() {
        return armor;
    }

    @Override
    public void addPlayer(EntityPlayer player) {
        if (player == null)
            return;


        players.add(player);
        armor.onEquppedChanged(player, true);
        checkSubscription();
    }

    @Override
    public void removePlayer(EntityPlayer player) {
        players.remove(player);
        armor.onEquppedChanged(player, false);
        checkSubscription();
    }


    private void checkSubscription() {
        // no one is wearing that armor
        if (players.isEmpty()) {
            ownHandlers.forEach(MinecraftForge.EVENT_BUS::unregister);
            return;
        }

        // the first one
        if (players.size() == 1) {
            ownHandlers.forEach(MinecraftForge.EVENT_BUS::register);
        }
    }

    /**
     * We need to get player reference from Event.
     * Possible weak-perfomance method
     *
     * @return
     */
    private EntityPlayer getPlayerFromEvent(Event e) {
        if (e instanceof EntityEvent && ((EntityEvent) e).getEntity() instanceof EntityPlayer) {
            return (EntityPlayer) ((EntityEvent) e).getEntity();
        }

        if (e instanceof TickEvent.PlayerTickEvent) {
            return ((TickEvent.PlayerTickEvent) e).player;
        }

        if (e instanceof LivingHurtEvent && ((LivingHurtEvent) e).getSource().getTrueSource() instanceof EntityPlayer) {
            return (EntityPlayer) ((LivingHurtEvent) e).getSource().getTrueSource();
        }

        return null;
    }
}
