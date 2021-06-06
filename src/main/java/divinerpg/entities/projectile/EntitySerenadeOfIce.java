package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntitySerenadeOfIce extends DivineThrowable {
    int age;

    public EntitySerenadeOfIce(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntitySerenadeOfIce(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntitySerenadeOfIce(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        setDeltaMovement(getDeltaMovement().x*3, getDeltaMovement().y*3, getDeltaMovement().z*3);
    }


    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        age++;
        if (!this.level.isClientSide && age > 35)
            this.kill();
    }

    @Override
    protected void onHit(RayTraceResult var1) {
        if (var1.hitInfo != null) {
            List<LivingEntity> entities = this.level.getEntitiesOfClass(LivingEntity.class,
                    ((LivingEntity)var1.hitInfo).getBoundingBox().expandTowards(3, 3, 3));
            for (LivingEntity e : entities) {
                if (e != this.getOwner())
                    e.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 3));
            }
        }

        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}