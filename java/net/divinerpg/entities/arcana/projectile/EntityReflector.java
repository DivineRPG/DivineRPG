package net.divinerpg.entities.arcana.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityReflector extends EntityThrowable {
    
    int age;

    public EntityReflector(World w) {
        super(w);
    }
    
    public EntityReflector(World w, EntityLivingBase e) {
        super(w, e);
        this.motionX*=3;
        this.motionY*=3;
        this.motionZ*=3;
    }

    @Override
    protected void onImpact(MovingObjectPosition pos) {
        if(pos.entityHit != null && this.getThrower() != null) {
            double xDist = (pos.entityHit.posX-this.getThrower().posX)/5, yDist = (pos.entityHit.posY-this.getThrower().posY)/5, zDist = (pos.entityHit.posZ-this.getThrower().posZ)/5;
            pos.entityHit.addVelocity(xDist, yDist, zDist);
        }
        this.setDead();
    }
    
    @Override
    public float getGravityVelocity() {
        return 0;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        age++;
        if(age>18)this.setDead();//I'm an Adult!
    }

}
