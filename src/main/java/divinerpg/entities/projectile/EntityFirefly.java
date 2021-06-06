package divinerpg.entities.projectile;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityFirefly(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(RayTraceResult pos) {
        if (pos.hitInfo != null && pos.hitInfo instanceof Entity){
        Entity entity = (Entity) pos.hitInfo;
            entity.hurt(DamageSource.thrown(this, this.getOwner()), 15);

        }

        if (!this.level.isClientSide)
            this.kill();
    }
}