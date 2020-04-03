package divinerpg.capabilities.armor;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.IItemContainer;
import divinerpg.api.armor.binded.IPlayerArmorDescription;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArmorPowers implements IArmorPowers {
    private final Map<ResourceLocation, IPlayerArmorDescription> descriptions = new LinkedHashMap<>();
    private final EntityPlayer player;

    public ArmorPowers() {
        this(null);

        DivineRPG.logger.warn("Should never get there");
        DivineRPG.logger.log(Level.DEBUG, Thread.currentThread().getStackTrace());
    }

    public ArmorPowers(EntityPlayer player) {
        this.player = player;

        if (player != null) {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }

    /**
     * Avoid memory leaking, because capability is creating on every entity instance
     *
     * @param e - event calling on both sides where any entity is joined the world
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onCleanUp(EntityJoinWorldEvent e) {
        // the same IDs but not the same instance
        if (e.getEntity().getUniqueID() == player.getUniqueID() && e.getEntity() != player) {
            MinecraftForge.EVENT_BUS.unregister(this);

            descriptions.values().forEach(IPlayerArmorDescription::unsubscribe);
            descriptions.clear();
        }
    }

    @Override
    public Set<ResourceLocation> wearing() {
        return descriptions.entrySet().stream()
                .filter(x -> x.getValue().isListening())
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public void putOn(ResourceLocation id) {
        changeWearStatus(id, true);
    }

    @Override
    public void takeOff(ResourceLocation id) {
        changeWearStatus(id, false);
    }

    @Override
    public Set<Item> currentItems(EntityEquipmentSlot slot) {
        Set<Item> items = new HashSet<>();

        if (player != null) {
            Item item = player.getItemStackFromSlot(slot).getItem();

            items.add(item);

            if (item instanceof IItemContainer) {
                items.addAll(((IItemContainer) item).getItems());
            }
        }

        return items;
    }

    @Nullable
    private void changeWearStatus(ResourceLocation id, boolean isOn) {
        if (player != null) {
            IPlayerArmorDescription description = descriptions.computeIfAbsent(id, location -> {
                // lazy creation of armor set. Further we manage (un)subscription that armor handler
                IArmorDescription value = DivineAPI.getArmorDescriptionRegistry().getValue(id);
                return value == null
                        ? null
                        : new PlayerArmorDescription(player, value);
            });

            if (description != null) {
                description.changeStatus(isOn);
            }
        }
    }
}
