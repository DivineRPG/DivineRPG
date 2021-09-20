package divinerpg.events;

import divinerpg.*;
import divinerpg.capability.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;

public class AttatchCapabilityEvent {
    @SubscribeEvent
    public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))event
                .addCapability(new ResourceLocation(DivineRPG.MODID, "arcana"), new ArcanaProvider());
    }
}
