package divinerpg.entities.projectile;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public EntityFirefly(EntityType<? extends ThrowableEntity> type, LivingEntity entity, World world) {
        super(type, entity, world);
    }
    public EntityFirefly(World world, PlayerEntity player) {
        super(EntityRegistry.FIREFLY, world);
    }


    @Override
    protected void onHitEntity(EntityRayTraceResult result) {
        if (result.getEntity() != null && result.getEntity() instanceof LivingEntity){
            LivingEntity entity = (LivingEntity) result.getEntity();
            entity.hurt(DamageSource.thrown(this, this.getOwner()), 15);

        }

        if (!this.level.isClientSide)
            this.kill();
    }
}