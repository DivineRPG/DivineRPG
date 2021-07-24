package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityBiphron extends EntityVetheaMob {

    private boolean gravity;

    public EntityBiphron(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.addAttackingAI();
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.biphronHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.biphronDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.biphronSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.biphronFollowRange);
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
    public void tick() {
        super.tick();
        if (this.random.nextInt(50) == 0) {
            this.gravity = !this.gravity;
        }

        if (this.gravity) {
        	this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 0.4, getDeltaMovement().z);
        }
    }
    
    @Override
    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    @Override
    public void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    	//previously called fall(...)
    }
    
    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
    	return 0;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(source == DamageSource.FALL) {
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    public int getSpawnLayer() {
        return 2;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BIPHRON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BIPHRON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BIPHRON_HURT;
    }
}