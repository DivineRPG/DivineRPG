package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.ArmorEquippedEvent;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.networking.message.ArmorStatusChangedMessage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber
public class ArmorWearingEvents {

    /**
     * Rechecks armor status
     *
     * @param player - current player
     * @param forced - should notify client about all wearing armor sets
     */
    public static void recheckAllWearing(Entity player, boolean forced) {
        IArmorPowers powers = DivineAPI.getArmorPowers(player);
        if (powers == null)
            return;

        ArmorEquippedEvent armorEquippedEvent = new ArmorEquippedEvent(player);
        MinecraftForge.EVENT_BUS.post(armorEquippedEvent);

        Set<ResourceLocation> confirmed = armorEquippedEvent.getConfirmed();
        Set<ResourceLocation> current = powers.wearing();

        List<ResourceLocation> newWearing = confirmed.stream().filter(x -> !current.contains(x)).collect(Collectors.toList());

        List<ResourceLocation> takenOff = current.stream().filter(x -> !confirmed.contains(x)).collect(Collectors.toList());

        takenOff.forEach(powers::takeOff);
        newWearing.forEach(powers::putOn);

        if (forced && player instanceof EntityPlayerMP) {
            current.removeAll(takenOff);
            current.removeAll(newWearing);

            current.stream()
                    .map(x -> new ArmorStatusChangedMessage(x, true))
                    .forEach(x -> DivineRPG.network.sendTo(x, (EntityPlayerMP) player));
        }
    }

    /**
     * Detecting here player armor changes.
     * Posting ArmorEquippedEvent event here and (un)subscribe from armor handlers there
     *
     * @param event - equipment change event
     */
    @SubscribeEvent
    public static void notifyChanges(LivingEquipmentChangeEvent event) {
        recheckAllWearing(event.getEntity(), false);
    }

    /**
     * Checking if player is equipped current armor.
     * Should execute at the lowest priority, it's base functionality
     *
     * @param event - checking actual armor equipment event
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void detectIsOn(ArmorEquippedEvent event) {
        IForgeRegistry<IArmorDescription> registry = DivineAPI.getArmorDescriptionRegistry();
        if (registry == null)
            return;

        registry.getEntries().parallelStream()
                .filter(x -> x.getValue() != null)
                .filter(x -> {
                    IArmorDescription description = x.getValue();

                    for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
                        Set<Item> setItems = description.getPossibleItems(slot);
                        Set<Item> currentItems = event.getItemsInSlot(slot);

                        if (!setItems.isEmpty() && setItems.stream().noneMatch(currentItems::contains)) {
                            return false;
                        }
                    }

                    return true;
                }).sequential()
                .forEach(x -> event.confirm(x.getKey()));
    }
}
