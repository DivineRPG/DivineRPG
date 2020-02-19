package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.*;
import java.util.stream.Collectors;

public class ArmorObserver {
    /**
     * Map of all possible armor set describers
     */
    private final Map<ResourceLocation, IPoweredArmor> allPossible;

    /**
     * List of equipped armor sets
     */
    private final List<ResourceLocation> equipped = new ArrayList<>();

    private final EntityPlayer player;

    private final Map<EntityEquipmentSlot, Item> currentArmor;

    public ArmorObserver(EntityPlayer player, Collection<IPoweredArmor> allPossible) {
        this.allPossible = allPossible.stream().collect(Collectors.toMap(IForgeRegistryEntry::getRegistryName, o -> o));
        this.player = player;
        currentArmor = new HashMap<>();

        for (EntityEquipmentSlot id : EntityEquipmentSlot.values()) {
            currentArmor.put(id, player.getItemStackFromSlot(id).getItem());
        }

        recheckEquipment();

        // Subscribe on handleArmorChanges equipment event
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Check any armor equipment changes
     */
    @SubscribeEvent
    public void handleArmorChanges(LivingEquipmentChangeEvent e) {
        EntityPlayer player = (EntityPlayer) e.getEntity();
        if (player == null)
            return;

        if (this.player != player)
            return;

        currentArmor.put(e.getSlot(), e.getTo().getItem());

        recheckEquipment();
    }

    /**
     * Main handle event method
     *
     * @param clazz
     * @param event
     */
    public void handle(Class clazz, Event event) {
        equipped.stream().map(allPossible::get).filter(Objects::nonNull)
                .map(x -> x.getAbilityMap().get(clazz)).filter(Objects::nonNull)
                .forEach(x -> x.handleAbility(event));
    }

    /**
     * Dispose resource here, after player log out from game
     */
    @SubscribeEvent
    public void onLogOut(PlayerEvent.PlayerLoggedOutEvent e) {
        if (this.player == e.player) {
            MinecraftForge.EVENT_BUS.unregister(this);

            allPossible.clear();
            equipped.clear();
            currentArmor.clear();
        }
    }


    public void recheckEquipment() {
        // checks the statuses of

        IsEquppedEvent event = new IsEquppedEvent(player, currentArmor);
        MinecraftForge.EVENT_BUS.post(event);

        Collection<ResourceLocation> curentlyEquped = event.getEquipped();

        // taken off
        this.equipped.stream().filter(x -> !curentlyEquped.contains(x))
                // find actual handlers
                .map(allPossible::get).filter(Objects::nonNull)
                // call for each armor
                .forEach(x -> x.onEquppedChanged(player, false));

        // taken on
        curentlyEquped.stream().filter(x -> !equipped.contains(x))
                // find actual handlers
                .map(allPossible::get).filter(Objects::nonNull)
                // call for each armor
                .forEach(x -> x.onEquppedChanged(player, true));
    }

}
