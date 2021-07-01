package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityWreckShot extends DivineThrowable {

    public int damage;

    public EntityWreckShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityWreckShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityWreckShot(EntityType<? extends ThrowableEntity> type, World world, LivingEntity entity, int damage) {
        super(type, entity, world);
        this.damage=damage;
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult par1) {
        if (par1.getEntity() != null) {
            par1.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), this.damage);
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}