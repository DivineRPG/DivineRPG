package net.divinerpg.entities.arcana.projectile;

import net.divinerpg.entities.base.EntityHeatSeekingProjectile;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(World w) {
        super(w);
    }
    
    public EntityFirefly(World w, EntityLivingBase e) {
        super(w, e);
    }
    

    @Override
    protected void onImpact(MovingObjectPosition pos) {
        if (pos.entityHit != null) pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 15);

        if (!this.worldObj.isRemote) this.setDead();
    }
}
