package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityKingOfScorchers extends EntityDivineBoss implements RangedAttackMob {
    public EntityKingOfScorchers(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 32.0F));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) -> {
            return Math.abs(entity.getY() - this.getY()) <= 4.0D;
        }));
    }

        protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
            return 1F;
        }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive() && !level().isClientSide) {
            if (getTarget() != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                double d0 = getTarget().getX() - (this.getX() + vector3d.x * 4.0D);
                double d1 = getTarget().getY(0.5D) - (0.5D + this.getY(0.5D));
                double d2 = getTarget().getZ() - (this.getZ() + vector3d.z * 4.0D);
                double d3 = (double) Math.sqrt(d0 * d0 + d2 * d2);
                ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.KING_OF_SCORCHERS_SHOT);
                if (level().getRandom().nextInt(10) == 0) {
                    projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.KING_OF_SCORCHERS_METEOR);
                    for (int i = 0; i < 4; i++) {
                        projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level().getDifficulty().getId() * 4));
                        this.level().addFreshEntity(projectile);
                    }
                } else {
                    projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level().getDifficulty().getId() * 4));
                    this.level().addFreshEntity(projectile);
                }
            }
        }
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public boolean hurt(DamageSource source, float par2) {
        if (source.is(DamageTypes.EXPLOSION))
            return false;
        return super.hurt(source, par2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.KING_OF_SCORCHERS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KING_OF_SCORCHERS_HURT.get();
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.RED;
    }
    
}
