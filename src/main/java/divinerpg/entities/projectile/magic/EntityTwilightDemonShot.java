package divinerpg.entities.projectile.magic;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ParticleRegistry.MORTUM_PORTAL;
import static net.minecraft.world.effect.MobEffects.CONFUSION;

public class EntityTwilightDemonShot extends DivineParticleProjectile {
    public EntityTwilightDemonShot(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world, 16, MORTUM_PORTAL);}
    @Override public boolean isNoGravity() {return true;}
    @Override public void tick() {
        super.tick();
        if(tickCount > 20) discard();
    }
    @Override protected void doPostHurtEffects(LivingEntity living) {
        living.addEffect(new MobEffectInstance(CONFUSION, 200, 0), getOwner());
    }
}