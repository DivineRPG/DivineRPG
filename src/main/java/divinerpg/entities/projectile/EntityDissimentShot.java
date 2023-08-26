package divinerpg.entities.projectile;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityDissimentShot extends DivineThrowable {

    public EntityDissimentShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityDissimentShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityDissimentShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
        if (entity == null) {
            return;
        }

        this.moveTo(entity.xo, entity.yo + (double)entity.getEyeHeight(), entity.zo, entity.yRot, entity.xRot);
        this.xo -= (double)(Mth.cos(this.yRot / 180.0F * (float)Math.PI) * 0.16F);
        this.yo -= 0.10000000149011612D;
        this.zo -= (double)(Mth.sin(this.yRot / 180.0F * (float)Math.PI) * 0.16F);
        this.setPos(this.xo, this.yo, this.zo);
        float f = 0.4F;
        this.setDeltaMovement((double)(-Mth.sin(this.yRot / 180.0F * (float)Math.PI) * Mth.cos(this.xRot / 180.0F * (float)Math.PI) * f),
                (double)(Mth.cos(this.yRot / 180.0F * (float)Math.PI) * Mth.cos(this.xRot / 180.0F * (float)Math.PI) * f),
                (double)(-Mth.sin((this.xRot + this.getGravity()) / 180.0F * (float)Math.PI) * f));
        this.shoot(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z, 1.6F, 1.0F);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                byte var2 = 9;
                Entity entity = result.getEntity();
                entity.hurt(entity.damageSources().thrown(this, this.getOwner()), var2);
            }

            if (!this.level().isClientSide()) {
                this.kill();
            }
        }
    }
}
