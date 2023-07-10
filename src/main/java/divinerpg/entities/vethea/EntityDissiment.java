package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityDissimentShot;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.*;

public class EntityDissiment extends EntityDivineFlyingMob implements RangedAttackMob {
    private static final int spawnLayer = 4;

    public EntityDissiment(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.125F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
    }

    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return this.getY() < 48.0D * spawnLayer && this.getY() > 48.0D * (spawnLayer - 1) && super.checkSpawnRules(level, type);
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            Projectile projectile = new EntityDissimentShot(EntityRegistry.DISSIMENT_SHOT.get(), level());
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DISSIMENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DISSIMENT_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DISSIMENT_HURT.get();
    }

    @Override
    protected float getSoundVolume() {
        return 2.0F;
    }
}