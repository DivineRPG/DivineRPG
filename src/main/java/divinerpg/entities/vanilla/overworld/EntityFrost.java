package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityFrostShot;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class EntityFrost extends EntityDivineFlyingMob implements IRangedAttackMob {

    public EntityFrost(EntityType<? extends EntityFrost> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.frostHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.frostDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.frostSpeed).add(Attributes.FLYING_SPEED, EntityStats.frostSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.follow);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float p_82196_2_) {
        if (getTarget() != null) {
            EntityFrostShot projectile = new EntityFrostShot(level, this, 0, 0, 0);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 2.3F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROST;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLAZE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }


    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

}