package divinerpg.entities.vethea;

import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityHoverStinger extends EntityVetheaMob {

    public EntityHoverStinger(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.2F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.hoverStingerHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.hoverStingerDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.hoverStingerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.hoverStingerFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IServerWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
    	return (reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn)) && isDarkEnoughToSpawn(worldIn, pos, randomIn);
    }

    @Override
    protected void registerGoals() {
    	this.goalSelector.addGoal(0, new SwimGoal(this));
    	this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
    	this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    	this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
    	this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    	this.goalSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
    	this.goalSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
    	this.applyEntityAI();
    	super.registerGoals();
        addAttackingAI();
    }

	private void applyEntityAI() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public int getSpawnLayer() {
        return 0;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}