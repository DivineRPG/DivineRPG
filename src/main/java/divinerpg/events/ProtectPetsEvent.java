package divinerpg.events;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.*;

public class ProtectPetsEvent {
    private DamageSource source;
    private float amount;

    @SubscribeEvent
    public void onPlayerAttackMob(LivingAttackEvent event) {
        Entity entity = event.getSource().getDirectEntity();
        if (event.getEntity() instanceof TameableEntity) {
            if (((TameableEntity) event.getEntity()).isTame()) {
                if (entity == ((TameableEntity) event.getEntity()).getOwner()) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
