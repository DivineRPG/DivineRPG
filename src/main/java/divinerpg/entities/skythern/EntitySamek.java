package divinerpg.entities.skythern;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySamek extends EntityPeacefulUntilAttacked {


    public EntitySamek(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward=40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.7F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.samekHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.samekDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.samekSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.samekFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.SKYTHERN_WORLD;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VEREK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VEREK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VEREK_HURT;
    }

}