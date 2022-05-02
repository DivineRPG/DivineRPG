package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.EntityKingOfScorchersMeteor;
import divinerpg.entities.projectile.EntityKingOfScorchersShot;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityKingOfScorchers extends EntityDivineBoss implements IRangedAttackMob {
    public EntityKingOfScorchers(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.kingOfScorchersHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.kingOfScorchersDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.kingOfScorchersSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.kingOfScorchersFollowRange);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 32.0F));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (entity) -> {
            return Math.abs(entity.getY() - this.getY()) <= 4.0D;
        }));

    }

        protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
            return 1F;
        }



    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public boolean hurt(DamageSource source, float par2) {
        if (source.isExplosion())
            return false;
        return super.hurt(source, par2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.KING_OF_SCORCHERS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KING_OF_SCORCHERS_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        ProjectileEntity projectile = new EntityKingOfScorchersShot(EntityRegistry.KING_OF_SCORCHERS_SHOT, this, level);
        if (level.random.nextInt(10) == 0) {
            projectile = new EntityKingOfScorchersMeteor(EntityRegistry.KING_OF_SCORCHERS_METEOR, this, level);
            for (int i = 0; i < 4; i++) {
                double d0 = getTarget().getX() - this.getX();
                double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
                double d2 = getTarget().getZ() - this.getZ();
                double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
                projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                this.level.addFreshEntity(projectile);
            }

        } else {
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
        }
    }
}
