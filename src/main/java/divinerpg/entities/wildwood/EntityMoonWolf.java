package divinerpg.entities.wildwood;

import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityMoonWolf extends WolfEntity {
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(EntityMoonWolf.class,
            DataSerializers.FLOAT);

    public EntityMoonWolf(EntityType<? extends WolfEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.getHeight()+0.8F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.moonWolfHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.moonWolfDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.moonWolfSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.moonWolfFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        if (this.getAngerTime()>0) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        } else if (this.rand.nextInt(3) == 0) {
            return this.isTamed() && this.dataManager.get(DATA_HEALTH_ID) < 10.0F ?
                    SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
        } else {
            return SoundEvents.ENTITY_WOLF_AMBIENT;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !isTamed();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MOON_WOLF;
    }
}