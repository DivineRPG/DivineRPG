package net.divinerpg.entities.base;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityHeatSeekingProjectile extends EntityThrowable {
    
    private Entity target = null;
    private boolean onlyPlayers = false;

    public EntityHeatSeekingProjectile(World w) {
        super(w);
    }
    
    public EntityHeatSeekingProjectile(World w, EntityLivingBase e) {
        super(w, e);
    }
    
    public void setPlayersOnly() {
        this.onlyPlayers = true;
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
            if(e != this.getThrower() && (!this.onlyPlayers || (this.onlyPlayers && e instanceof EntityPlayer))) {
                if(findNewTarget && (target == null || (target != null && this.getDistanceToEntity(e) < this.getDistanceToEntity(target)))) target = e;
            }
        }
        
        if(target != null) {
            Vec3 dir = Vec3.createVectorHelper(target.posX-this.posX, target.posY-this.posY, target.posZ-this.posZ).normalize();
            this.motionX=dir.xCoord/1.5;
            this.motionY=dir.yCoord/1.5;
            this.motionZ=dir.zCoord/1.5;
        }
        
        if(this.ticksExisted>50)this.setDead();
    }
}
