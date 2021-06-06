package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.event.*;

public class EntityWatcherShot extends DivineThrowable {

    public EntityWatcherShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityWatcherShot(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity) {
        super(type, entity, world);
    }

    public EntityWatcherShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        this(type, world);
        this.setPos(x, y, z);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level, this);
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 5.0F, flag, Explosion.Mode.BREAK);
        }

        if (result.hitInfo != null) {
            if (result.hitInfo instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) result.hitInfo;
                entity.hurt(DamageSource.thrown(this, this.getOwner()), 4.0F);
            }
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }

}
