package divinerpg.entities.skythern;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

public class EntityAdvancedCori extends EntityDivineFlyingMonster implements RangedAttackMob {
    public EntityAdvancedCori(EntityType<? extends EntityAdvancedCori> type, Level worldIn) {super(type, worldIn);}
    protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, 1, 40, 20));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive() && getTarget() != null && !level().isClientSide()) {
            DivineThrowableProjectile projectile = EntityRegistry.CORI_SHOT.get().create(level(), EntitySpawnReason.EVENT);
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            projectile.baseDamage = 30;
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, 1.2F);
            this.level().addFreshEntity(projectile);
        }
    }
    @Override public int getMaxSpawnClusterSize() {return 1;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.CORI_IDLE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.CORI_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.CORI_HURT.get();}
}