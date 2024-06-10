package divinerpg.entities.vanilla.overworld;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;

public class EntityPumpkinSpider extends Spider {
	private static final EntityDataAccessor<Boolean> PROVOKED = SynchedEntityData.defineId(EntityPumpkinSpider.class, EntityDataSerializers.BOOLEAN);

	public EntityPumpkinSpider(EntityType<? extends Spider> type, Level worldIn) {
		super(type, worldIn);
	}
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PROVOKED, false);
		setRot(0, 0);
		setYBodyRot(0);
	}
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(1, new FloatGoal(this));
		goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
		goalSelector.addGoal(4, new MeleeAttackGoal(this, 1, getProvoked()));
	}
	@Override
	public double getMeleeAttackRangeSqr(LivingEntity entity) {
		return super.getMeleeAttackRangeSqr(entity) * 1.25;
	}
	@Override
	public void tick() {
		super.tick();
		if(!level().isClientSide()) {
			Player player = level().getNearestPlayer(this, 4D);
			if(player != null && hasLineOfSight(player)) setProvoked(player);
			else setProvoked(getTarget());
		}
	}
	@Override
	public boolean hurt(DamageSource source, float amount) {
		Entity entity = source.getDirectEntity();
		if(!(entity instanceof LivingEntity)) entity = source.getEntity();
		if(entity instanceof LivingEntity && entity.distanceTo(this) <= 25D) setProvoked((LivingEntity) entity);
		return super.hurt(source, amount);
	}
	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33790_, DifficultyInstance p_33791_, MobSpawnType p_33792_, @Nullable SpawnGroupData p_33793_, @Nullable CompoundTag p_33794_) {
		return p_33793_;
	}
	public boolean getProvoked() {
		return entityData.get(PROVOKED);
	}
	public void setProvoked(LivingEntity entity) {
		if(entity == null || (!hasLineOfSight(entity) && entity.distanceTo(this) > 25D || !entity.isAlive())) calmDown();
		else {
			if(entity instanceof Player player) {
				if(player.isCreative() || player.isSpectator()) {
					calmDown();
					return;
				}
			}
			if(!level().isClientSide()) entityData.set(PROVOKED, true);
			setTarget(entity);
		}
	}
	public void calmDown() {
		getNavigation().setSpeedModifier(0);
		setRot(0, 0);
		setYBodyRot(0);
		setTarget(null);
		entityData.set(PROVOKED, false);
	}
	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		entityData.set(PROVOKED, tag.getBoolean("Provoked"));
	}
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Provoked", getProvoked());
	}
	@Override
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
		return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
	}
}
