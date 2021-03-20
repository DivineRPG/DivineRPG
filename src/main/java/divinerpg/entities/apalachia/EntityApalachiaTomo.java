package divinerpg.entities.apalachia;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityApalachiaTomo extends EntityPeacefulUntilAttacked {


    public EntityApalachiaTomo(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward=40;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.apalachiaTomoHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.apalachiaTomoDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.apalachiaTomoSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.apalachiaTomoFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.APALACHIA_WORLD;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CROAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }
}