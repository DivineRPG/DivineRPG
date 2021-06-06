package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityDissimentShot extends DivineThrowable {

    public EntityDissimentShot(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityDissimentShot(EntityType<? extends ThrowableEntity> type, double x, double y, double z, World world) {
        super(type, x, y, z, world);
    }

    public EntityDissimentShot(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
        if (entity == null) {
            return;
        }

        this.moveTo(entity.xo, entity.yo + (double)entity.getEyeHeight(), entity.zo, entity.yRot, entity.xRot);
        this.xo -= (double)(MathHelper.cos(this.yRot / 180.0F * (float)Math.PI) * 0.16F);
        this.yo -= 0.10000000149011612D;
        this.zo -= (double)(MathHelper.sin(this.yRot / 180.0F * (float)Math.PI) * 0.16F);
        this.setPos(this.xo, this.yo, this.zo);
        float f = 0.4F;
        this.setDeltaMovement((double)(-MathHelper.sin(this.yRot / 180.0F * (float)Math.PI) * MathHelper.cos(this.xRot / 180.0F * (float)Math.PI) * f),
                (double)(MathHelper.cos(this.yRot / 180.0F * (float)Math.PI) * MathHelper.cos(this.xRot / 180.0F * (float)Math.PI) * f),
                (double)(-MathHelper.sin((this.xRot + this.getGravity()) / 180.0F * (float)Math.PI) * f));
        this.shoot(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z, 1.6F, 1.0F);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if(result.hitInfo != null && result.hitInfo instanceof Entity) {
            byte var2 = 9;
            Entity entity = (Entity) result.hitInfo;
            entity.hurt(DamageSource.thrown(this, this.getOwner()), var2);
        }

        if(!this.level.isClientSide) {
            this.kill();
        }
    }
}
