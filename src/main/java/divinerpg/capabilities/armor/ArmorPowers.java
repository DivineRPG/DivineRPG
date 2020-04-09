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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

public class ArmorPowers implements IArmorPowers {
    private final Map<ResourceLocation, IPlayerArmorDescription> descriptions = new LinkedHashMap<>();
    private final WeakReference<EntityPlayer> player;

    public ArmorPowers() {
        this(null);

        DivineRPG.logger.warn("Should never get there");
        DivineRPG.logger.log(Level.DEBUG, Thread.currentThread().getStackTrace());
    }

    public ArmorPowers(EntityPlayer player) {
        this.player = new WeakReference<>(player);

        if (player != null) {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }

    @SubscribeEvent
    public void onCleanUp(EntityJoinWorldEvent e) {
        EntityPlayer currentPlayer = this.player.get();

        // should unregister
        if (currentPlayer == null) {
            unsubscribe();
            return;
        }

        // Same entity
        if (e.getEntity() == currentPlayer)
            return;

        // another entity, don't care
        if (Objects.equals(e.getEntity().getUniqueID(), currentPlayer.getUniqueID()))
            return;

        unsubscribe();
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

        if (player.get() != null) {
            Item item = player.get().getItemStackFromSlot(slot).getItem();

            items.add(item);

            if (item instanceof IItemContainer) {
                items.addAll(((IItemContainer) item).getItems());
            }
        }

        return items;
    }

    @Nullable
    private void changeWearStatus(ResourceLocation id, boolean isOn) {
        if (player.get() != null) {
            IPlayerArmorDescription description = descriptions.computeIfAbsent(id, location -> {
                // lazy creation of armor set. Further we manage (un)subscription that armor handler
                IArmorDescription value = DivineAPI.getArmorDescriptionRegistry().getValue(id);
                return value == null
                        ? null
                        : new PlayerArmorDescription(player.get(), value);
            });

            if (description != null) {
                description.changeStatus(isOn);
            }
        }
    }

    private void unsubscribe() {
        MinecraftForge.EVENT_BUS.unregister(this);

        descriptions.values().forEach(IPlayerArmorDescription::unsubscribe);
        descriptions.clear();
    }
}
