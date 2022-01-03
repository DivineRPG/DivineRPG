package divinerpg.entities.projectile;

import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityTwilightDemonShot extends EntityColoredBullet {


    public EntityTwilightDemonShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityTwilightDemonShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount > 20) {
            this.kill();
        }
    }

    @Override
    public void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null && result.getEntity() instanceof PlayerEntity) {
            ((PlayerEntity) result.getEntity()).addEffect(new EffectInstance(Effects.CONFUSION, 200, 0));
            ((PlayerEntity) result.getEntity()).hurt(DamageSource.mobAttack((LivingEntity)this.getOwner()), 5);
        }
    }
}