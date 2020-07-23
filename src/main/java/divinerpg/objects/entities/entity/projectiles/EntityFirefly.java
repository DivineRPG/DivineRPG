package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(World w) {
        super(w);
    }

    public EntityFirefly(World w, EntityPlayer e) {
        super(w, e);
    }

    @Override
    protected void onImpact(RayTraceResult pos) {
        if (pos.entityHit != null)
            pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 15);

        if (!this.world.isRemote)
            this.setDead();
    }
}