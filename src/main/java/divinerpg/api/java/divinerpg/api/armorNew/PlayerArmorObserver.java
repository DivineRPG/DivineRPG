package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.DivineRPG;
import divinerpg.networking.message.EquipmentChangeMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerArmorObserver {
    private final Map<EntityEquipmentSlot, Item> currentArmor = new HashMap<>();
    private EntityPlayer player;
    private Set<ResourceLocation> equipped = new HashSet<>();

    public PlayerArmorObserver(EntityPlayer player) {
        this.player = player;

        for (EntityEquipmentSlot id : EntityEquipmentSlot.values()) {
            currentArmor.put(id, player.getItemStackFromSlot(id).getItem());
        }

        recheckEquipment();

        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Check any armor equipment changes.
     * Server-side only
     */
    @SubscribeEvent
    public void handleArmorChanges(LivingEquipmentChangeEvent e) {
        if (this.player != e.getEntity())
            return;

        currentArmor.put(e.getSlot(), e.getTo().getItem());

        recheckEquipment();
    }

    /**
     * Remember curring player armor
     */
    public void rememberEquipment() {
        for (EntityEquipmentSlot id : EntityEquipmentSlot.values()) {
            currentArmor.put(id, player.getItemStackFromSlot(id).getItem());
        }
    }

    /**
     * Trying to recheck actal equipment
     */
    public void recheckEquipment() {
        // checks the statuses of

        IsEquppedEvent event = new IsEquppedEvent(player, currentArmor);
        MinecraftForge.EVENT_BUS.post(event);

        Collection<ResourceLocation> curentlyEquped = event.getEquipped();


        List<ResourceLocation> takenOff = this.equipped.stream().filter(x -> !curentlyEquped.contains(x)).collect(Collectors.toList());
        List<ResourceLocation> takenUp = curentlyEquped.stream().filter(x -> !equipped.contains(x)).collect(Collectors.toList());

        equipped.removeAll(takenOff);
        equipped.addAll(takenUp);

        for (ResourceLocation id : takenOff) {
            MainArmorEvents.findArmorSetManager(id).removePlayer(player);
        }

        for (ResourceLocation id : takenUp) {
            MainArmorEvents.findArmorSetManager(id).addPlayer(player);
        }

        if ((!takenOff.isEmpty() || !takenUp.isEmpty()) && player instanceof EntityPlayerMP) {
            DivineRPG.network.sendTo(new EquipmentChangeMessage(), (EntityPlayerMP) player);
        }
    }

    /**
     * Detects wherever the armor is on
     *
     * @param id - registry name of armor set
     * @return
     */
    public boolean isOn(ResourceLocation id) {
        return equipped.contains(id);
    }
}
