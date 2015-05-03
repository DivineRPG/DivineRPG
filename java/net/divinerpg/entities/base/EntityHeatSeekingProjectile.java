package net.divinerpg.entities.base;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityHeatSeekingProjectile extends EntityThrowable {
    
    private Entity target = null;

    public EntityHeatSeekingProjectile(World w) {
        super(w);
    }
    
    public EntityHeatSeekingProjectile(World w, EntityLivingBase e) {
        super(w, e);
    }
    
    @Override
    public float getGravityVelocity() {
        return 0;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(this.worldObj.isRemote)return;
        List<EntityLivingBase> mobs = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(50, 50, 50));
        boolean findNewTarget = this.target == null || (this.target != null && this.target.isDead);
        for(EntityLivingBase e : mobs) {
            if(e != this.getThrower()) {
                if(findNewTarget && (target == null || (target != null && this.getDistanceToEntity(e) < this.getDistanceToEntity(target)))) target = e;
            }
        }
        
        if(target != null) {
            Vec3 motion = Vec3.createVectorHelper(this.motionX, this.motionY, this.motionZ).normalize();
            Vec3 ideal = Vec3.createVectorHelper(target.posX-this.posX, target.posY-this.posY, target.posZ-this.posZ);
            double dist = ideal.lengthVector()/3;
            ideal = ideal.normalize();
            double diffX = motion.dotProduct(ideal)*Math.signum(target.posX-this.posX);
            double diffZ = Math.sin(Math.acos(diffX))*Math.signum(target.posZ-this.posZ);
            this.motionX+=(diffX/dist)*(diffX/dist)*(diffX/dist);
            this.motionZ+=(diffZ/dist)*(diffZ/dist)*(diffZ/dist);
        }
        
        if(this.ticksExisted>50)this.setDead();
    }
}
