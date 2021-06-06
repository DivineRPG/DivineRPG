package divinerpg.entities.ai;

import divinerpg.enums.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import java.util.*;
import java.util.function.*;

public class AIDivineFireballAttack extends Goal {
    private final MobEntity parentEntity;
    private final BiFunction<MobEntity, Entity, Entity> createFireballFunc;
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

    public AIDivineFireballAttack(MobEntity parentEntity, BiFunction<MobEntity, Entity, Entity> createFireballFunc, int attackDelay, int maxDistance, SoundEvent beforeShoot, SoundEvent onShoot) {
        this.parentEntity = parentEntity;
        this.createFireballFunc = createFireballFunc;
        this.attackDelay = attackDelay;
        this.maxDistance = maxDistance;
        this.beforeShoot = beforeShoot;
        this.onShoot = onShoot;
    }

    public AIDivineFireballAttack(MobEntity ghast, ILaunchFireBall func) {
        this(ghast, func::createFireball, 20, 64, SoundEvents.GHAST_WARN, SoundEvents.GHAST_SHOOT);
    }

    public AIDivineFireballAttack(MobEntity ghast, ILaunchFireBall createFireball, SoundEvent onShoot) {
        this(ghast, createFireball::createFireball, 20, 64, null, onShoot);
    }

    public AIDivineFireballAttack(MobEntity ghast, ILaunchThrowable createThrowable, SoundEvent onShoot) {
        this(ghast, createThrowable::createFireball, 20, 64, null, onShoot);
    }
    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    @Override
    public void start() {
        attackTimer=0;
    }

    @Override
    public void stop() {
    }

    @Override
    public void tick() {
        if(parentEntity != null) {
            LivingEntity entitylivingbase = parentEntity.getTarget();
            if (entitylivingbase != null) {
                if (Math.sqrt(entitylivingbase.distanceTo(this.parentEntity)) < maxDistance
                        && this.parentEntity.canSee(entitylivingbase)) {
                    World world = this.parentEntity.level;
                    ++this.attackTimer;

                    if (this.attackTimer == attackDelay - 10) {
                        playSound(beforeShoot);
                    }

                    if (this.attackTimer == attackDelay) {
                        playSound(onShoot);
                        world.addFreshEntity(createFireballFunc.apply(parentEntity, entitylivingbase));
                        this.attackTimer = attackDelay * -2;
                    }
                } else if (this.attackTimer > 0) {
                    --this.attackTimer;
                }

                if (attackTimer <= 10) {
                }
            }
        }
    }

    @Override
    public boolean canUse() {
        return this.parentEntity.getLastHurtByMob() != null;
    }

    private void playSound(SoundEvent event) {
        if (parentEntity == null || parentEntity.level == null || event == null)
            return;

        Random rand = parentEntity.level.random;

        parentEntity.level.playSound(null,
                parentEntity.blockPosition(),
                event,
                SoundCategory.HOSTILE,
                10,
                (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
    }
}
