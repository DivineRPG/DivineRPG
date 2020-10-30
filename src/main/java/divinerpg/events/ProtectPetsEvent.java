package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ProtectPetsEvent {
    private DamageSource source;
    private float amount;

    @SubscribeEvent
    public void onPlayerAttackMob(LivingAttackEvent event) {
        Entity entity = event.getSource().getTrueSource();
        if (event.getEntity() instanceof TameableEntity) {
            if (((TameableEntity) event.getEntity()).isTamed()) {
                if (entity == ((TameableEntity) event.getEntity()).getOwner()) {
                    event.setCanceled(true);
                }
            }
        }
    }
}
