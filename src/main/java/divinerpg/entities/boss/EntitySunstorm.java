package divinerpg.entities.boss;

import divinerpg.entities.goals.SunstormAttackGoal;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class EntitySunstorm extends EntityDivineBoss implements RangedAttackMob {

    public EntitySunstorm(EntityType<? extends EntitySunstorm> type, Level worldIn) {
        super(type, worldIn);
        xpReward = XP_REWARD_BOSS;
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            if (canAttack(target)) {
                if (distanceTo(target) < 3) {
                    target.igniteForSeconds(3);
                }

                ThrowableProjectile projectile = EntityRegistry.SUNSTORM_SHOT.get().create(level());
                projectile.setOwner(this);
                projectile.setPos(getEyePosition());
                double tx = getTarget().getX() - this.getX();
                double ty = getTarget().getEyeY() - this.getEyeY();
                double tz = getTarget().getZ() - this.getZ();
                double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
                projectile.shoot(tx, ty, tz, 1.6f, 0);
                projectile.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
                this.level().addFreshEntity(projectile);
            }
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new SunstormAttackGoal(this, 0.27F, 50, 10));
        this.targetSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SPARKLER.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.FIRE_EXTINGUISH;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ZOMBIE_VILLAGER_CURE;
    }
}
