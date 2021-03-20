package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityRoamer extends EntityDivineMob {
    public EntityRoamer(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.625F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.roamerHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.roamerDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.roamerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.roamerFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        //TODO - set arcana canSpawn
//        return level.dimension() == KeyRegistry.ARCANA_WORLD;
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.3F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ROAMER;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ROAMER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ROAMER_HURT;
    }

}

