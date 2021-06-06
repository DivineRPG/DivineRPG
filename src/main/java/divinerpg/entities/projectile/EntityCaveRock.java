package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityCaveRock extends DivineThrowable {


    public EntityCaveRock(EntityType<? extends ThrowableEntity> p_i48540_1_, World p_i48540_2_) {
        super(p_i48540_1_, p_i48540_2_);
    }

    public EntityCaveRock(EntityType<? extends ThrowableEntity> p_i48541_1_, double p_i48541_2_, double p_i48541_4_, double p_i48541_6_, World p_i48541_8_) {
        super(p_i48541_1_, p_i48541_2_, p_i48541_4_, p_i48541_6_, p_i48541_8_);
    }

    public EntityCaveRock(EntityType<? extends ThrowableEntity> p_i48542_1_, LivingEntity p_i48542_2_, World p_i48542_3_) {
        super(p_i48542_1_, p_i48542_2_, p_i48542_3_);
    }

    @Override
    public void onHit(RayTraceResult result) {
        if (result.hitInfo != null && result.hitInfo instanceof Entity) {
            Entity entity = (Entity) result.hitInfo;
            entity.hurt(DamageSource.thrown(this, this.getOwner()), 6.0F);
        }
        if (!this.level.isClientSide) {
            this.kill();
        }
    }
}