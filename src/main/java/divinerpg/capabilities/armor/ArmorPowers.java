package divinerpg.capabilities.armor;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.IItemContainer;
import divinerpg.api.armor.binded.IPlayerArmorDescription;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.networking.message.ArmorStatusChangedMessage;
import net.minecraft.entity.EntityLivingBase;
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
    private final WeakReference<EntityLivingBase> player;
    private boolean wasInitialized;

    public ArmorPowers() {
        this(null);

        DivineRPG.logger.warn("Should never get there");
        DivineRPG.logger.log(Level.DEBUG, Thread.currentThread().getStackTrace());
    }

    public ArmorPowers(EntityLivingBase player) {
        this.player = new WeakReference<>(player);

        if (player != null) {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }

    @SubscribeEvent
    public void onCleanUp(EntityJoinWorldEvent e) {
        EntityLivingBase currentPlayer = this.player.get();

        // should unregister
        if (currentPlayer == null) {
            unsubscribe();
            return;
        }

        // Same entity
        if (e.getEntity() == currentPlayer) {

            if (!wasInitialized) {
                wasInitialized = true;

                // Client side is creating more often
                // So I send request from server to confirm
                // what armor is equipped
                if (currentPlayer.world.isRemote) {
                    DivineRPG.network.sendToServer(new ArmorStatusChangedMessage(new ResourceLocation(""), true));
                }
            }

            return;
        }


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
    public void putOn(ResourceLocation id, boolean sendMessage) {
        changeWearStatus(id, true, sendMessage);
    }

    @Override
    public void takeOff(ResourceLocation id) {
        changeWearStatus(id, false, true);
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
    private void changeWearStatus(ResourceLocation id, boolean isOn, boolean sendMessage) {
        if (player.get() != null) {
            IPlayerArmorDescription description = descriptions.computeIfAbsent(id, location -> {
                // lazy creation of armor set. Further we manage (un)subscription that armor handler
                IArmorDescription value = DivineAPI.getArmorDescriptionRegistry().getValue(id);
                return value == null
                        ? null
                        : new PlayerArmorDescription(player.get(), value);
            });

            if (description != null) {
                description.changeStatus(isOn, sendMessage);
            }
        }
    }

    private void unsubscribe() {
        MinecraftForge.EVENT_BUS.unregister(this);

        descriptions.values().forEach(IPlayerArmorDescription::unsubscribe);
        descriptions.clear();
    }
}
