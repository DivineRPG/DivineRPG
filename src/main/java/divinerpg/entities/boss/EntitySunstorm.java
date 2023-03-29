package divinerpg.entities.boss;

import divinerpg.entities.ai.AISunstormAttack;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.EntityTwilightMageShot;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntitySunstorm extends EntityDivineBoss implements RangedAttackMob {

    public EntitySunstorm(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 1000;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level.isClientSide) {
            if (canAttack(target)) {
                if (distanceTo(target) < 3) {
                    target.setSecondsOnFire(3);
                }

                EntityTwilightMageShot projectile = new EntityTwilightMageShot(EntityRegistry.MAGE_SHOT.get(), this, level, BulletType.SUNSTORM);
                double tx = getTarget().getX() - this.getX();
                double ty = getTarget().getEyeY() - this.getEyeY();
                double tz = getTarget().getZ() - this.getZ();
                double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
                projectile.shoot(tx, ty, tz, 1.6f, 0);
                projectile.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
                this.level.addFreshEntity(projectile);
            }
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new AISunstormAttack(this, 0.27F, 50, 10));
        this.targetSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.YELLOW;
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
        return SoundEvents.FIRE_EXTINGUISH;
    }
}