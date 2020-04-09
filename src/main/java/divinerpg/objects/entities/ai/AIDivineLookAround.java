package divinerpg.objects.entities.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.MathHelper;

public class AIDivineLookAround extends EntityAIBase {
    private final EntityLiving parentEntity;

    public AIDivineLookAround(EntityLiving ghast) {
        this.parentEntity = ghast;
        this.setMutexBits(2);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        return true;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask() {
        if (this.parentEntity.getAttackTarget() == null) {
            this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * (180F / (float) Math.PI);
            this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
        } else {
            EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
            double d0 = 64.0D;

            if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D) {
                double d1 = entitylivingbase.posX - this.parentEntity.posX;
                double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
                this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
                this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
            }
        }
    }
}
