package divinerpg.entities.projectile;

import divinerpg.enums.*;
import divinerpg.registries.*;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntityGeneralsStaff extends EntityColoredBullet {
    EntityType<? extends ThrowableProjectile> type;

    public EntityGeneralsStaff(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        this.type = type;
    }

    public EntityGeneralsStaff(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world, BulletType.GENERALS_STAFF_SHOT);
        this.type = type;
    }

    @Override
    protected void onHit(HitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            super.onHit(result);
            if (!this.level().isClientSide) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                    EntityColoredBullet e = new EntityColoredBullet(EntityRegistry.COLORED_BULLET.get(), (LivingEntity) this.getOwner(), level(),
                            BulletType.GENERALS_STAFF_SPRAY);
                    setHere(e);
                    e.shoot(Math.cos(theta), 0.4, Math.sin(theta), 0.7f, 0);
                    this.level().addFreshEntity(e);
                }

                EntityColoredBullet e = new EntityColoredBullet(EntityRegistry.COLORED_BULLET.get(), (LivingEntity) getOwner(), this.level(), BulletType.GENERALS_STAFF_SPRAY);
                setHere(e);
                e.shoot(0, 1, 0, 0.7f, 0);
                this.level().addFreshEntity(e);
            }
        }
    }

    private void setHere(Entity e) {
        e.moveTo(this.xo, this.yo, this.zo);
    }
}