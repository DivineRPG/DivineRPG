package divinerpg.entities.projectile;

import divinerpg.enums.BulletType;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGeneralsStaff extends EntityColoredBullet {
    EntityType<? extends ThrowableEntity> type;

    public EntityGeneralsStaff(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
        this.type = type;
    }

    public EntityGeneralsStaff(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world, BulletType.GENERALS_STAFF_SHOT);
        this.type = type;
    }

    @Override
    public void onHit(RayTraceResult position) {
        super.onHit(position);
        if (!this.level.isClientSide && this.getOwner() instanceof LivingEntity) {
            for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                EntityColoredBullet e = new EntityColoredBullet(type, (LivingEntity) this.getOwner(), this.level,
                        BulletType.GENERALS_STAFF_SPRAY);
                setHere(e);
                e.shoot(Math.cos(theta), 0.4, Math.sin(theta), 0.7f, 0);
                this.level.addFreshEntity(e);
            }

            EntityColoredBullet e = new EntityColoredBullet(type, (LivingEntity) this.getOwner(), this.level, BulletType.GENERALS_STAFF_SPRAY);
            setHere(e);
            e.shoot(0, 1, 0, 0.7f, 0);
            this.level.addFreshEntity(e);
        }
    }

    private void setHere(Entity e) {
        e.setPos(this.xo, this.yo, this.zo);
    }
}