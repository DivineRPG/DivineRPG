package divinerpg.entities.projectile.bullet;

import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntitySaguaroWormShot extends DivineThrowableProjectile {
    public EntitySaguaroWormShot(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    @Override protected void onHitEntity(EntityHitResult result) {
        if(!(result.getEntity() instanceof EntitySaguaroWorm)) super.onHitEntity(result);
    }
    @Override public void tick() {
        super.tick();
        if(tickCount > 50) discard();
    }
}