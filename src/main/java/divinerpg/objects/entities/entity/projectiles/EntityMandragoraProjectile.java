package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMandragoraProjectile extends EntityHeatSeekingProjectile {
    private EntityLiving thrower;

    public EntityMandragoraProjectile(World w) {
        super(w);
        this.setPlayersOnly();
    }

    public EntityMandragoraProjectile(World w, EntityLiving e) {
        super(w, e);
        this.thrower = e;
        this.setPlayersOnly();
    }

    @Override
    protected void onImpact(RayTraceResult pos) {
        if (pos.entityHit != null && pos.entityHit != this.thrower) {
            pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), 4.0F);
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}
