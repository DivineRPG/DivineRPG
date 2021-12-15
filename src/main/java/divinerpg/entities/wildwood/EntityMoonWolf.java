package divinerpg.entities.wildwood;

import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityMoonWolf extends WolfEntity {
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.defineId(EntityMoonWolf.class,
            DataSerializers.FLOAT);

    public EntityMoonWolf(EntityType<? extends WolfEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.getBbHeight()+0.8F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.moonWolfHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.moonWolfDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.moonWolfSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.moonWolfFollowRange);
    }


    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (this.getRemainingPersistentAngerTime()>0) {
            return SoundEvents.WOLF_GROWL;
        } else if (this.random.nextInt(3) == 0) {
            return this.isTame() && this.entityData.get(DATA_HEALTH_ID) < 10.0F ?
                    SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
        } else {
            return SoundEvents.WOLF_AMBIENT;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOLF_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public boolean removeWhenFarAway(double distance) {return !isTame();
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader world) {
        return 0.0F;
    }

}