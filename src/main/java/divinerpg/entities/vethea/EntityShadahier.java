package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityShadahier extends EntityVetheaMob {

    public EntityShadahier(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.1F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.shadahierHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.shadahierDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.shadahierSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.shadahierFollowRange);
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
    public boolean doHurtTarget(Entity target) {
        if(super.doHurtTarget(target)) {
            if(!this.level.isClientSide && target instanceof LivingEntity) {
                ((LivingEntity) target).addEffect(new EffectInstance(Effects.BLINDNESS, 1, 1));
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHADAHIER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHADAHIER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHADAHIER_HURT;
    }
}