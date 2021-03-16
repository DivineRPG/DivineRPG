package divinerpg.events;

import divinerpg.*;
import divinerpg.capability.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;

public class AttatchCapabilityEvent {

    public static final ResourceLocation ARCANA_CAP = new ResourceLocation(DivineRPG.MODID, "arcana");

    @SubscribeEvent
    public void attachCapability(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(ARCANA_CAP, new ArcanaProvider());
        }
    }
}
