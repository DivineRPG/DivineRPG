package net.divinerpg.entities.arcana.projectile;

import net.divinerpg.entities.base.EntityHeatSeekingProjectile;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMerikMissile extends EntityHeatSeekingProjectile {

    public EntityMerikMissile(World w) {
        super(w);
    }
    
    public EntityMerikMissile(World w, EntityLivingBase e) {
        super(w, e);
    }
    

    @Override
    protected void onImpact(MovingObjectPosition pos) {
        if (pos.entityHit != null) pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 22);
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2, false);
            this.setDead();
        }
    }
}
