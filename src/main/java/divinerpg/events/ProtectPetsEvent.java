package divinerpg.events;

import net.minecraft.world.entity.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.*;

public class ProtectPetsEvent {
    @SubscribeEvent
    public void onPlayerAttackMob(LivingAttackEvent event) {
        if (event.getSource() != null) {
            if (event.getSource().getDirectEntity() != null) {
                Entity entity = event.getSource().getDirectEntity();
                if (entity != null) {
                    if (event.getEntity() instanceof TamableAnimal) {
                        TamableAnimal animal = (TamableAnimal) event.getEntity();
                        if (animal.isTame() && animal.getOwner() != null) {
                            if (entity == animal.getOwner() && !animal.getOwner().isCrouching()) {
                                event.setCanceled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
