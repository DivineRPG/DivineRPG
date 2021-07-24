package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityBohemite extends EntityVetheaMob {

    public EntityBohemite(EntityType<? extends MobEntity> type, World worldIn) {
    	super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
    	return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.bohemiteHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.bohemiteDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.bohemiteSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.bohemiteFollowRange);
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
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BOHEMITE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BOHEMITE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BOHEMITE_HURT;
    }
}