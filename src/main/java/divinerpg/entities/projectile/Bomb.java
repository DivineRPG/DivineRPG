package divinerpg.entities.projectile;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static net.minecraft.world.entity.projectile.ProjectileDeflection.NONE;
import static net.minecraft.world.level.Level.ExplosionInteraction.MOB;

public class Bomb extends ThrowableProjectile {
    public Bomb(EntityType<? extends ThrowableProjectile> entityType, Level level) {super(entityType, level);}
    @Override public ProjectileDeflection deflection(Projectile projectile) {return NONE;}
    @Override protected void onHit(HitResult result) {
        super.onHit(result);
        if(!level().isClientSide()) level().explode(this, xo, yo, zo, 3, false, MOB);
        discard();
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}