package divinerpg.entities.boss;

import divinerpg.entities.ai.*;
import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.util.*;
import net.minecraft.world.BossEvent.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

public class EntitySunstorm extends EntityDivineBoss implements RangedAttackMob {

    public EntitySunstorm(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 1000;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level.isClientSide) {
            if (canAttack(target))
                if (distanceTo(target) < 3) {
                    target.setSecondsOnFire(3);
                }

            EntityTwilightMageShot projectile = new EntityTwilightMageShot(EntityRegistry.MAGE_SHOT.get(), this, level, BulletType.SUNSTORM);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.3F);
            this.level.addFreshEntity(projectile);
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
