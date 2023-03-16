package divinerpg.entities.projectile;


import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityWreckShot extends DivineThrowable {

    public int damage;

    public EntityWreckShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityWreckShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityWreckShot(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity, int damage) {
        super(type, entity, world);
        this.damage=damage;
    }

    @Override
    protected void onHitEntity(EntityHitResult par1) {
        if(tickCount != 1 || tickCount != 0) {
            if (par1.getEntity() != null) {
                par1.getEntity().hurt(damageSources().thrown(this, this.getOwner()), this.damage);
            }

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }
}