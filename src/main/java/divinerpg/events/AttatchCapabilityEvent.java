package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.capability.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class AttatchCapabilityEvent {
    public static final Capability<Arcana> ARCANA = CapabilityManager.get(new CapabilityToken<>() {});

    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(Arcana.class);
    }

    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(ArcanaProvider.ARCANA).isPresent()) {
                event.addCapability(new ResourceLocation(DivineRPG.MODID, "arcana"), new ArcanaProvider());
            }
        }
    }
}
