package divinerpg.entities.eden;

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

public class EntityWeakCori extends EntityDivineFlyingMob {

    public EntityWeakCori(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.8F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.edenCoriHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.edenCoriDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.edenCoriSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.edenCoriFollowRange).add(Attributes.FLYING_SPEED, EntityStats.edenCoriSpeed);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
    }

    @Override
    public int getMaxSpawnClusterSize() {return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CORI_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CORI_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CORI_HURT;
    }


    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        super.performRangedAttack(entity, range);
        ProjectileEntity projectile = new EntityCoriShot(EntityRegistry.CORI_SHOT, level, this, (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
        double d0 = getTarget().getX() - this.getX();
        double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
        double d2 = getTarget().getZ() - this.getZ();
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
        this.level.addFreshEntity(projectile);
    }
}
