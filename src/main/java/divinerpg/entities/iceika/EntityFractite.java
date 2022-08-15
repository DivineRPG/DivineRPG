package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityFractite extends EntityDivineFlyingMob {
    public EntityFractite(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.7F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.fractiteHealth).add(Attributes.FLYING_SPEED, EntityStats.fractiteSpeed).add(Attributes.MOVEMENT_SPEED, EntityStats.fractiteSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.fractiteFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.getBiome(blockPosition()).shouldSnow(worldIn, blockPosition());
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        super.performRangedAttack(entity, range);
        if(this.isAlive()) {
        if (getTarget() != null) {
            ProjectileEntity projectile = new EntityFractiteShot(EntityRegistry.FRACTITE_SHOT, level);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
        }
        }
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundRegistry.FRACTITE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.FRACTITE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.FRACTITE_HURT;
    }

}
