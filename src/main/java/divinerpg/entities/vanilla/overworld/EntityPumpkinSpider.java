package divinerpg.entities.vanilla.overworld;

import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.network.syncher.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

import javax.annotation.*;

public class EntityPumpkinSpider extends Spider {
	private static final EntityDataAccessor<Boolean> PROVOKED = SynchedEntityData.defineId(EntityPumpkinSpider.class, EntityDataSerializers.BOOLEAN);

	public EntityPumpkinSpider(EntityType<? extends Spider> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PROVOKED, false);
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, true));
		targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	@Override
	public double getMeleeAttackRangeSqr(LivingEntity entity) {
		return super.getMeleeAttackRangeSqr(entity) * 1.25;
	}
	@Override
	public void tick() {
		super.tick();
		if(!level().isClientSide) {
			Player player = level().getNearestPlayer(this, 4D);
			if(player != null && hasLineOfSight(player)) setProvoked(player);
			else setProvoked(getTarget());
			if(!getProvoked()) setDeltaMovement(0, -0.3, 0);
			setNoAi(!entityData.get(PROVOKED));
		}
		if(!getProvoked()) xRotO = 0;
	}
	@Override
	public boolean hurt(DamageSource source, float amount) {
		Entity entity = source.getDirectEntity();
		if(!(entity instanceof LivingEntity)) entity = source.getEntity();
		if(entity != null && entity instanceof LivingEntity) {
			setProvoked((LivingEntity) entity);
			setDeltaMovement(0, .6, 0);
		}
		return super.hurt(source, amount);
	}
	public boolean getProvoked() {
		return entityData.get(PROVOKED);
	}
	@Nullable
	public void setProvoked(LivingEntity entity) {
		if(entity == null || (!hasLineOfSight(entity) && entity.distanceTo(this) > 32F)) calmDown();
		else {
			if(entity instanceof Player) {
				Player player = (Player) entity;
				if(player.isCreative() || player.isSpectator()) {
					calmDown();
					return;
				}
			}
			entityData.set(PROVOKED, true);
			setTarget(entity);
		}
	}
	public void calmDown() {
		entityData.set(PROVOKED, false);
		setTarget(null);
	}
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		entityData.set(PROVOKED, tag.getBoolean("Provoked"));
	}
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Provoked", getProvoked());
	}
	@Override
	public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
		return 0F;
	}
}