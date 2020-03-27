package divinerpg.capabilities.armor;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.binded.IPlayerArmorDescription;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDeath(LivingDeathEvent e) {
        if (!e.isCanceled() && e.getEntity() == player) {
            MinecraftForge.EVENT_BUS.unregister(this);

            descriptions.values().forEach(IPlayerArmorDescription::unsubscribe);
            descriptions.clear();
        }
    }

    @Override
    public Set<ResourceLocation> wearing() {
        return new HashSet<>(descriptions.keySet());
    }

    @Override
    public void putOn(ResourceLocation id) {
        changeWearStatus(id, true);
    }

    @Override
    public void takeOff(ResourceLocation id) {
        changeWearStatus(id, false);
    }

    @Nullable
    private void changeWearStatus(ResourceLocation id, boolean isOn) {
        if (player != null) {
            IPlayerArmorDescription description = descriptions.computeIfAbsent(id, location -> {
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
