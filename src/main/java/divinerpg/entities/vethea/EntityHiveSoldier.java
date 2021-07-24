package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityHiveSoldier extends EntityVetheaMob {

    public EntityHiveSoldier(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.6F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.hiveSoldierHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.hiveSoldierDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.hiveSoldierSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.hiveSoldierFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getSpawnLayer() {
        return 0;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HOVER_STINGER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HOVER_STINGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HOVER_STINGER_HURT;
    }
}