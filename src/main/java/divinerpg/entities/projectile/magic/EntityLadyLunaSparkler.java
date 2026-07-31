package divinerpg.entities.projectile.magic;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import static divinerpg.registries.DamageRegistry.ARCANA;
import static divinerpg.registries.ParticleRegistry.APALACHIA_PORTAL;

public class EntityLadyLunaSparkler extends DivineParticleProjectile {
    public EntityLadyLunaSparkler(EntityType<? extends DivineParticleProjectile> type, Level world) {super(type, world, 12, APALACHIA_PORTAL);}
    @Override public boolean isNoGravity() {return true;}
    @Override public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof LivingEntity entity && entity.getLastHurtByMob() != null) {
            double tx = entity.getLastHurtByMob().xo - entity.xo;
            double ty = entity.getLastHurtByMob().getBoundingBox().minY - entity.yo;
            double tz = entity.getLastHurtByMob().zo - entity.zo;
            if(!level().isClientSide() && tickCount > 30) shoot(tx, ty, tz, .5F, 0);
        } if(!level().isClientSide() && tickCount > 80) discard();
    }
    @Override public DamageSource getDamageSource(EntityHitResult result) {return level().damageSources().source(ARCANA);}
}