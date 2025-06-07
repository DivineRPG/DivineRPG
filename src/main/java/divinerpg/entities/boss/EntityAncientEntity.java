package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EntityAncientEntity extends EntityDivineBoss {
    public EntityAncientEntity(EntityType<? extends EntityAncientEntity> type, Level worldIn) {super(type, worldIn);}
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        super.doHurtTarget(entity);
        if(getTarget() != null) {
            getTarget().setDeltaMovement(getDeltaMovement().x * 10.0D, 2.0D, getDeltaMovement().z * 10.0D);
            if(getTarget() instanceof Player) {
                getTarget().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
                playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
            } return true;
        } return false;
    }
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.IRON_GOLEM_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.IRON_GOLEM_DEATH;}
    @Override public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {return false;}
    @Override protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {}
    @Override protected int calculateFallDamage(float fallDistance, float damageMultiplier) {return 0;}
}