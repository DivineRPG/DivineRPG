package divinerpg.api.armor;

import divinerpg.api.DivineAPI;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Set;

@Mod.EventBusSubscriber
public class ArmorWearingEvents {

    /**
     * Detecting here player armor changes.
     * Posting ArmorEquippedEvent event here and (un)subscribe from armor handlers there
     *
     * @param event - equipment change event
     */
    @SubscribeEvent
    public static void notifyChanges(LivingEquipmentChangeEvent event) {
        IArmorPowers powers = DivineAPI.getArmorPowers(event.getEntity());
        if (powers == null)
            return;

        EntityPlayer entity = (EntityPlayer) event.getEntity();
        ArmorEquippedEvent armorEquippedEvent = new ArmorEquippedEvent(entity);
        MinecraftForge.EVENT_BUS.post(armorEquippedEvent);

        Set<ResourceLocation> confirmed = armorEquippedEvent.getConfirmed();
        Set<ResourceLocation> current = powers.wearing();

        confirmed.stream().filter(x -> !current.contains(x))
                .forEach(powers::putOn);

        current.stream().filter(x -> !confirmed.contains(x))
                .forEach(powers::takeOff);
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
