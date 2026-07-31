package divinerpg.entities.projectile.bullet;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class EntityDissimentShot extends ThrowableProjectile {

    public EntityDissimentShot(EntityType<? extends ThrowableProjectile> type, Level world) {super(type, world);}
    public EntityDissimentShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityDissimentShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, world);
        if (entity == null) {
            return;
        }

        this.moveOrInterpolateTo(new Vec3(entity.xo, entity.yo + (double)entity.getEyeHeight(), entity.zo), entity.getYRot(), entity.getXRot());
        this.xo -= (double)(Mth.cos(getYRot() / 180.0F * (float)Math.PI) * 0.16F);
        this.yo -= 0.1;
        this.zo -= (double)(Mth.sin(getYRot() / 180.0F * (float)Math.PI) * 0.16F);
        this.setPos(this.xo, this.yo, this.zo);
        float f = 0.4F;
        this.setDeltaMovement((double)(-Mth.sin(getYRot() / 180.0F * (float)Math.PI) * Mth.cos(getXRot() / 180.0F * (float)Math.PI) * f),
                (double)(Mth.cos(getYRot() / 180.0F * (float)Math.PI) * Mth.cos(getXRot() / 180.0F * (float)Math.PI) * f),
                (double)(-Mth.sin((getXRot() + (float)getGravity()) / 180 * (float)Math.PI) * f));
        this.shoot(this.getDeltaMovement().x, this.getDeltaMovement().y, this.getDeltaMovement().z, 1.6F, 1.0F);
    }
    @Override protected void onHitEntity(EntityHitResult result) {
        if(tickCount > 1) {
            if(result.getEntity() != null) {
                byte var2 = 9;
                Entity entity = result.getEntity();
                entity.hurt(entity.damageSources().thrown(this, getOwner()), var2);
            } if(!level().isClientSide()) discard();
        }
    }
    @Override protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {}
}