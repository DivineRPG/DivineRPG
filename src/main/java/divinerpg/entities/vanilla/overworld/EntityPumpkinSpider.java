package divinerpg.entities.vanilla.overworld;

import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityPumpkinSpider extends SpiderEntity {
    private static final DataParameter<Boolean> PROVOKED = EntityDataManager.defineId(EntityPumpkinSpider.class, DataSerializers.BOOLEAN);
	
    public EntityPumpkinSpider(EntityType<? extends MonsterEntity> type, World worldIn) {
		super((EntityType<? extends SpiderEntity>) type, worldIn);
	}
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.pumpkinSpiderHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.pumpkinSpiderDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.pumpkinSpiderSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.pumpkinSpiderFollowRange);
    }
	@Override
	protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(PROVOKED, false);
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
	@Override
	public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
        	PlayerEntity player = this.level.getNearestPlayer(this, 4.0D);
        	if(player != null && !player.isCreative() && !player.isSpectator() && canSee(player)) {
        		setProvoked(player);
        	} else {
        		setProvoked(this.getTarget());
        	}
            setNoAi(!entityData.get(PROVOKED));
        }
        if (!this.getProvoked()) {
            this.xRotO = 0;
        }
    }
	@Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof LivingEntity) {
            this.setProvoked((LivingEntity) entity);
            this.setDeltaMovement(0, 0.6, 0);
        }
        return super.hurt(source, amount);
    }
	public boolean getProvoked() {
        return entityData.get(PROVOKED);
    }
	@Nullable
	public void setProvoked(LivingEntity entity) {
		if (entity == null || (!canSee(entity) && entity.distanceTo(this) > 32.0f)) {
			entityData.set(PROVOKED, false);
			this.setTarget(null);
		} else {
			entityData.set(PROVOKED, true);
			this.setTarget(entity);
		}
	}
	public void readAdditionalSaveData(CompoundNBT tag) {
        super.readAdditionalSaveData(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }
    public void addAdditionalSaveData(CompoundNBT tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader reader) {
        return 0.0F;
    }
}