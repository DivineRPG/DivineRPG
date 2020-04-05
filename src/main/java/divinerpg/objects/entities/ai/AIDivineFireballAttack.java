package divinerpg.objects.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.BiFunction;

public class AIDivineFireballAttack extends EntityAIBase {
    private final EntityGhast parentEntity;
    private final BiFunction<EntityLivingBase, Entity, Entity> createFireballFunc;
    public int attackTimer;

    public AIDivineFireballAttack(EntityGhast ghast, ILaunchArrow createArrow, float maxAttackDistance) {
        this.parentEntity = ghast;
        this.createFireballFunc = (entityLivingBase, entity) -> createArrow.createArrow(entityLivingBase, entity, maxAttackDistance);
    }

    public AIDivineFireballAttack(EntityGhast ghast, ILaunchFireBall createFireball) {
        this.parentEntity = ghast;
        this.createFireballFunc = (entityLivingBase, entity) -> createFireball.createFireball((EntityGhast) entityLivingBase, entity);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        return this.parentEntity.getAttackTarget() != null;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.attackTimer = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        this.parentEntity.setAttacking(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask() {
        EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
        double d0 = 64.0D;

        if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entitylivingbase)) {
            World world = this.parentEntity.world;
            ++this.attackTimer;

            if (this.attackTimer == 10) {
                world.playEvent(null, 1015, new BlockPos(this.parentEntity), 0);
            }

            if (this.attackTimer == 20) {
                world.playEvent(null, 1016, new BlockPos(this.parentEntity), 0);
                world.spawnEntity(createFireballFunc.apply(parentEntity, entitylivingbase));
                this.attackTimer = -40;
            }
        } else if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        this.parentEntity.setAttacking(this.attackTimer > 10);
    }
}
