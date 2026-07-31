package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import static net.minecraft.world.damagesource.DamageTypes.EXPLOSION;

public class EntityKingOfScorchers extends EntityDivineBoss implements RangedAttackMob {
    public EntityKingOfScorchers(EntityType<? extends EntityKingOfScorchers> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new RangedAttackGoal(this, 1, 40, 32));
        goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity, level) -> Math.abs(entity.getY() - getY()) <= 4));
    }
    //TODO: lame pattern, to improve
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if (isAlive() && getTarget() != null && !level().isClientSide()) {
            ThrowableProjectile projectile = EntityRegistry.KING_OF_SCORCHERS_SHOT.get().create(level(), EntitySpawnReason.EVENT);
            projectile.setOwner(this);
            projectile.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            if(level().getRandom().nextInt(10) == 0) {
                projectile = EntityRegistry.KING_OF_SCORCHERS_METEOR.get().create(level(), EntitySpawnReason.EVENT);
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
    @Override public boolean isSensitiveToWater() {return true;}
    @Override public boolean hurtServer(ServerLevel level, DamageSource source, float par2) {
        if(source.is(EXPLOSION)) return false;
        return super.hurtServer(level, source, par2);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.KING_OF_SCORCHERS.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.KING_OF_SCORCHERS_HURT.get();}
}