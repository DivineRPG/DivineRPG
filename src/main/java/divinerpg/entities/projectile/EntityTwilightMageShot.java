package divinerpg.entities.projectile;

import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityTwilightMageShot extends EntityColoredBullet {


    public EntityTwilightMageShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityTwilightMageShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount > 30) {
            this.kill();
        }
    }
    
    @Override
    public void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null) {
            result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()),
                    this.getBulletType().getDamage());
        }
        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}