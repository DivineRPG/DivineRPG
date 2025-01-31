package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.bullet.EntityDissimentShot;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class EntityDissiment extends EntityDivineFlyingMob implements RangedAttackMob {
    public EntityDissiment(EntityType<? extends EntityDissiment> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(2, new RangedAttackGoal(this, 1, 40, 20));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive() && getTarget() != null && !level().isClientSide) {
            Projectile projectile = new EntityDissimentShot(EntityRegistry.DISSIMENT_SHOT.get(), level());
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, .8F);
            this.level().addFreshEntity(projectile);
        }
    }
    @Override protected float getSoundVolume() {return 2;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DISSIMENT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DISSIMENT_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DISSIMENT_HURT.get();}
}