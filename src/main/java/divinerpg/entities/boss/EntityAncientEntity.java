package divinerpg.entities.boss;

import divinerpg.entities.base.*;

import net.minecraft.sounds.*;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityAncientEntity extends EntityDivineBoss {
    public EntityAncientEntity(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        xpReward = 2000;
    }
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true){
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return (double)(this.mob.getBbWidth() * 1.125F * this.mob.getBbWidth() * 1.125F + entity.getBbWidth());
            }
        });
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        super.doHurtTarget(entity);
        if (this.getTarget() != null) {
            this.getTarget().setDeltaMovement(this.getDeltaMovement().x * 10.0D, 2.0D, this.getDeltaMovement().z * 10.0D);
            if (this.getTarget() instanceof Player) {
                getTarget().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
                playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
            }
            return true;
        }
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.YELLOW;
    }
}
