package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.entities.projectile.fireball.EntityFractiteShot;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityFractite extends EntityDivineFlyingMonster implements RangedAttackMob {
    public EntityFractite(EntityType<? extends EntityFractite> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 40, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        super.registerGoals();
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        LivingEntity target = getTarget();
        if(isAlive() && target != null) {
            //TODO: to add a delay between the sound and the attack
            playSound(SoundRegistry.FRACTITE_ATTACK.get());
            if(!level().isClientSide()) {
                Fireball projectile = new EntityFractiteShot(level(), this, 0, 0, 0);
                projectile.setPos(new Vec3(getX(), getEyeY(), getZ()));
                projectile.shoot(target.getX() - getX() + random.nextDouble() - random.nextDouble(), target.getEyeY() - getEyeY() - random.nextDouble() / 2, target.getZ() - getZ() + random.nextDouble() - random.nextDouble(), 1.6F, .8F);
                level().addFreshEntity(projectile);
            }
        }
    }
    @Override public int getMaxSpawnClusterSize() {return 1;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 1;}
    @Override public SoundEvent getAmbientSound() {return SoundRegistry.FRACTITE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.FRACTITE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.FRACTITE_HURT.get();}
}