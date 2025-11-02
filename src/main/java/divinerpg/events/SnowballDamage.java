package divinerpg.events;

import divinerpg.entities.boss.EntityKingOfScorchers;
import divinerpg.entities.vanilla.nether.EntityScorcher;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.Snowball;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class SnowballDamage {
    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        float amount = event.getNewDamage();
        Entity entity = event.getSource().getDirectEntity();
        if(entity instanceof Snowball && (target instanceof EntityScorcher || target instanceof EntityKingOfScorchers)) {
            //unaffected by armor (as intended)
            event.setNewDamage(amount + 3);
        }
    }
}