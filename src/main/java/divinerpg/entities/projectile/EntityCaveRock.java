package divinerpg.entities.projectile;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityCaveRock extends DivineThrowable {


    public EntityCaveRock(EntityType<? extends ThrowableProjectile> p_i48540_1_, Level p_i48540_2_) {
        super(p_i48540_1_, p_i48540_2_);
    }

    public EntityCaveRock(EntityType<? extends ThrowableProjectile> p_i48541_1_, double p_i48541_2_, double p_i48541_4_, double p_i48541_6_, Level p_i48541_8_) {
        super(p_i48541_1_, p_i48541_2_, p_i48541_4_, p_i48541_6_, p_i48541_8_);
    }

    public EntityCaveRock(EntityType<? extends ThrowableProjectile> p_i48542_1_, LivingEntity p_i48542_2_, Level p_i48542_3_) {
        super(p_i48542_1_, p_i48542_2_, p_i48542_3_);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null) {
                result.getEntity().hurt(result.getEntity().level().damageSources().thrown(this, this.getOwner()), 6.0F);

                if (!this.level().isClientSide) {
                    this.kill();
                }
            }
        }
    }
}