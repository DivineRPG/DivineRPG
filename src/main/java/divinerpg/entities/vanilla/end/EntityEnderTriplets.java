package divinerpg.entities.vanilla.end;

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

import java.util.*;

public class EntityEnderTriplets extends EntityDivineFlyingMob {
    public EntityEnderTriplets(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 5;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.enderTripletsHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.enderTripletsSpeed).add(Attributes.FLYING_SPEED, EntityStats.enderTripletsSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.enderTripletsFollowRange);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.0F;
    }@Override
    protected float getSoundVolume() {
        return 10.0F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.GHAST_SCREAM;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GHAST_DEATH;
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
                ProjectileEntity projectile = new EntityEnderTripletsFireball(EntityRegistry.ENDER_TRIPLETS_FIREBALL, level);
                double d0 = getTarget().getX() - this.getX();
                double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
                double d2 = getTarget().getZ() - this.getZ();
                double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
                projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                this.level.addFreshEntity(projectile);
            }
        }
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
}
