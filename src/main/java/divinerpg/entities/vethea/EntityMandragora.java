package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class EntityMandragora extends EntityDivineMonster implements RangedAttackMob {
    public EntityMandragora(EntityType<? extends EntityMandragora> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, .25F, 15, 40));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null && !level().isClientSide) {
            ThrowableProjectile projectile = EntityRegistry.MANDRAGORA_SHOT.get().create(level());
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, .8F);
            this.level().addFreshEntity(projectile);
        }
    }
    @Override protected float getSoundVolume() {return .7F;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.MANDRAGORA.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.MANDRAGORA.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.MANDRAGORA.get();}
}