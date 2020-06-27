package divinerpg.objects.entities.ai;

import divinerpg.DivineRPG;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.EnumParticleTypes;

public class AIBreach extends EntityAIBase
{
    private EntityLiving mob;
    public AIBreach(EntityLiving p_i1624_1_)
    {
        this.mob = p_i1624_1_;
        this.setMutexBits(4);
    }

    public boolean shouldExecute()
    {
        if(mob.posY > mob.world.getSeaLevel())
        	{
        	return false;        	
        	}
        if(mob.posY < 49) 
        	while(mob.posY < 61) {
        		return true;
        	}
        return true;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.mob.getRNG().nextFloat() < 0.8F)
        {
            this.mob.getJumpHelper().setJumping();
        }

    }
}