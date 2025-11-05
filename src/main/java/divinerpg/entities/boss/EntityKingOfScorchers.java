package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import static net.minecraft.world.damagesource.DamageTypes.EXPLOSION;

public class EntityKingOfScorchers extends EntityDivineBoss implements RangedAttackMob {
    public EntityKingOfScorchers(EntityType<? extends EntityKingOfScorchers> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new RangedAttackGoal(this, 1, 40, 32));
        goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) -> Math.abs(entity.getY() - getY()) <= 4));
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if (isAlive() && !level().isClientSide) {
            if (getTarget() != null) {
                Vec3 vector3d = getViewVector(1);
                double d0 = getTarget().getX() - (getX() + vector3d.x * 4);
                double d1 = getTarget().getY(.5) - (.5 + getY(.5));
                double d2 = getTarget().getZ() - (getZ() + vector3d.z * 4);
                double d3 = Math.sqrt(d0 * d0 + d2 * d2);
                ThrowableProjectile projectile = EntityRegistry.KING_OF_SCORCHERS_SHOT.get().create(level());
                projectile.setOwner(this);
                projectile.setPos(getEyePosition());
                if(level().getRandom().nextInt(10) == 0) {
                    projectile = EntityRegistry.KING_OF_SCORCHERS_METEOR.get().create(level());
                    projectile.setOwner(this);
                    projectile.setPos(getEyePosition());
                    for(int i = 0; i < 4; i++) {
                        projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, (float)(14 - level().getDifficulty().getId() * 4));
                        level().addFreshEntity(projectile);
                    }
                } else {
                    projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, (float)(14 - level().getDifficulty().getId() * 4));
                    level().addFreshEntity(projectile);
                }
            }
        }
    }
    @Override public boolean isSensitiveToWater() {return true;}
    @Override public boolean hurt(DamageSource source, float par2) {
        if(source.is(EXPLOSION)) return false;
        return super.hurt(source, par2);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.KING_OF_SCORCHERS.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.KING_OF_SCORCHERS_HURT.get();}
}