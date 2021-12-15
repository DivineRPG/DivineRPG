package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityRollum extends EntityDivineMob {

    public EntityRollum(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.rollumHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.rollumDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.rollumSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.rollumFollowRange);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        super.doHurtTarget(entity);
        entity.setDeltaMovement(this.stuckSpeedMultiplier.x * 3.0D, 0.3D, this.stuckSpeedMultiplier.z * 3.0D);
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ROLLUM;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ROLLUM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ROLLUM_HURT;
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader reader) {
        return 0.0F;
    }
}
