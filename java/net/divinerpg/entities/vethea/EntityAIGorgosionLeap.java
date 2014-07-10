package net.divinerpg.entities.vethea;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;

public class EntityAIGorgosionLeap extends EntityAIBase {
    EntityLivingBase leaper;
    EntityLivingBase leapTarget;
    float leapMotionY;

    public EntityAIGorgosionLeap(EntityLiving par1EntityLiving, float par2) {
        this.leaper = par1EntityLiving;
        this.leapMotionY = par2;
        this.setMutexBits(3);
    }
 
    @Override
    public boolean shouldExecute() {
        this.leapTarget = this.leaper.getAITarget();

        if (this.leapTarget == null)
            return false;
        else {
            double var1 = this.leaper.getDistanceSqToEntity(this.leapTarget);
            return var1 <= 32.0D ? (!this.leaper.onGround ? false : this.leaper.getRNG().nextInt(5) == 0) : false;
        }
    }
 
    @Override
    public boolean continueExecuting() {
        return !this.leaper.onGround;
    }
 
    @Override
    public void startExecuting() {
        double var1 = this.leapTarget.posX - this.leaper.posX;
        double var3 = this.leapTarget.posZ - this.leaper.posZ;
        float var5 = MathHelper.sqrt_double(var1 * var1 + var3 * var3);
        this.leaper.motionX += var1 / var5 * 0.5D * 0.800000011920929D + this.leaper.motionX * 0.20000000298023224D;
        this.leaper.motionZ += var3 / var5 * 0.5D * 0.800000011920929D + this.leaper.motionZ * 0.20000000298023224D;
        this.leaper.motionY = this.leapMotionY;
    }
}