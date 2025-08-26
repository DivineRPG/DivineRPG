package divinerpg.entities.vanilla.end;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.entities.projectile.fireball.EntityEnderTripletsFireball;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.Vec3;

public class EntityEnderTriplets extends EntityDivineFlyingMonster implements RangedAttackMob {
    public EntityEnderTriplets(EntityType<? extends EntityEnderTriplets> type, Level worldIn) {super(type, worldIn, 18);}
    @Override public boolean fireImmune() {return true;}
    @Override public int getMaxSpawnClusterSize() {return 1;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 1;}
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, 1, 40, 64));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive()) {
            if(getTarget() != null) {
                Vec3 vector3d = this.getViewVector(1);
                double d0 = getTarget().getX() - (getX() + vector3d.x * 4);
                double d1 = getTarget().getY(.5) - (.5 + getY(.5));
                double d2 = getTarget().getZ() - (getZ() + vector3d.z * 4);
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                EntityEnderTripletsFireball shot = new EntityEnderTripletsFireball(level(), this, d0, d1, d2);
                shot.shoot(d0, d1 + d3 * .2, d2, 3.3F, .2F);
                if(!level().isClientSide) level().addFreshEntity(shot);
                playSound(SoundEvents.FOX_TELEPORT);
            }
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundEvents.PARROT_IMITATE_GHAST;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.GHAST_SCREAM;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.GHAST_DEATH;}
}