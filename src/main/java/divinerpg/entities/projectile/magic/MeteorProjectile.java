package divinerpg.entities.projectile.magic;

import divinerpg.registries.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class MeteorProjectile extends StarProjectile {
    public MeteorProjectile(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level, 7.5F, ParticleRegistry.MORTUM_PORTAL);
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if(!level().isClientSide()) level().explode(this, xo, yo, zo, 4.5F, false, Level.ExplosionInteraction.TNT);
        discard();
    }
}