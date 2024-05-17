package divinerpg.entities.projectile;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class DivineThrowable extends ThrowableProjectile {
    public DivineThrowable(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public DivineThrowable(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {super(type, x, y, z, world);}
    public DivineThrowable(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {super(type, entity, world);}
    @Override public void tick() {
        if(tickCount > 200) discard();
        super.tick();
    }
    @Override protected void onHit(HitResult result) {
        super.onHit(result);
        discard();
    }
    @Override protected void defineSynchedData() {}
}