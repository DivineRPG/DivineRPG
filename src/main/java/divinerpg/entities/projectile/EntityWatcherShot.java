package divinerpg.entities.projectile;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.event.ForgeEventFactory;

public class EntityWatcherShot extends DivineThrowable {

    public EntityWatcherShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityWatcherShot(EntityType<? extends ThrowableProjectile> type, Level world, LivingEntity entity) {
        super(type, entity, world);
    }

    public EntityWatcherShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        this(type, world);
        this.setPos(x, y, z);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (!this.level.isClientSide) {
                boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this);
                this.level.explode(null, this.getX(), this.getY(), this.getZ(), 5.0F, flag, Level.ExplosionInteraction.TNT);
            }

            if (result.getEntity() != null) {
                if (result.getEntity() instanceof LivingEntity) {
                    LivingEntity entity = (LivingEntity) result.getEntity();
                    entity.hurt(DamageSource.thrown(this, this.getOwner()), 4.0F);
                }
            }

            if (!this.level.isClientSide) {
                this.kill();
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult p_230299_1_) {
        if(tickCount != 1 || tickCount != 0) {
        if (!this.level.isClientSide) {
            boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this);
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 5.0F, flag, Level.ExplosionInteraction.TNT);
            this.kill();
        }
    }
    }
}
