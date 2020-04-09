package divinerpg.objects.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.function.BiFunction;

public class AIDivineFireballAttack extends EntityAIBase {
    private final EntityLiving parentEntity;
    private final BiFunction<EntityLivingBase, Entity, Entity> createFireballFunc;
    public int attackTimer;

    /**
     * Attack delay
     */
    private final int attackDelay;

    /**
     * Max attack distance
     */
    private final int maxDistance;

    /**
     * Warn pre shoot sound
     */
    private final SoundEvent beforeShoot;

    /**
     * shoot sound
     */
    private final SoundEvent onShoot;

    public AIDivineFireballAttack(EntityLiving parentEntity,
                                  BiFunction<EntityLivingBase, Entity, Entity> createFireballFunc,
                                  int attackDelay,
                                  int maxDistance,
                                  SoundEvent beforeShoot,
                                  SoundEvent onShoot) {

        this.parentEntity = parentEntity;
        this.createFireballFunc = createFireballFunc;

        this.attackDelay = attackDelay;
        this.maxDistance = maxDistance;
        this.beforeShoot = beforeShoot;
        this.onShoot = onShoot;
    }

    public AIDivineFireballAttack(EntityLiving ghast, ILaunchFireBall func) {
        this(ghast, func::createFireball, 20, 64, SoundEvents.ENTITY_GHAST_WARN, SoundEvents.ENTITY_GHAST_SHOOT);
    }

    public AIDivineFireballAttack(EntityLiving ghast, ILaunchFireBall createFireball, SoundEvent onShoot) {
        this(ghast, createFireball::createFireball, 20, 64, null, onShoot);
    }

    public AIDivineFireballAttack(EntityLiving ghast, ILaunchThrowable createThrowable, SoundEvent onShoot) {
        this(ghast, createThrowable::createFireball, 20, 64, null, onShoot);
    }

//    public AIDivineFireballAttack(EntityLiving ghast, ILaunchArrow createArrow, float maxAttackDistance) {
//        this.parentEntity = ghast;
//        this.createFireballFunc = (entityLivingBase, entity) -> createArrow.createArrow(entityLivingBase, entity, maxAttackDistance);
//    }


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
        this.parentEntity.setAttackTarget(null);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask() {
        EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();

        if (Math.sqrt(entitylivingbase.getDistanceSq(this.parentEntity)) < maxDistance
                && this.parentEntity.canEntityBeSeen(entitylivingbase)) {
            World world = this.parentEntity.world;
            ++this.attackTimer;

            if (this.attackTimer == attackDelay - 10) {
                playSound(beforeShoot);
            }

            if (this.attackTimer == attackDelay) {
                playSound(onShoot);
                world.spawnEntity(createFireballFunc.apply(parentEntity, entitylivingbase));
                this.attackTimer = attackDelay * -2;
            }
        } else if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        if (attackTimer <= 10) {
            // todo notify client about
        }
    }

    private void playSound(SoundEvent event) {
        if (parentEntity == null || parentEntity.world == null || event == null)
            return;

        parentEntity.world.playSound(parentEntity.posX, parentEntity.posY, parentEntity.posZ, event, SoundCategory.HOSTILE, 10,
                (parentEntity.world.rand.nextFloat() - parentEntity.world.rand.nextFloat()) * 0.2F + 1.0F, false);
    }
}
