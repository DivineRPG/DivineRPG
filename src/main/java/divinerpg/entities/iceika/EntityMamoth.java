package divinerpg.entities.iceika;

import java.util.UUID;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.entities.ai.*;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityMamoth extends Animal implements NeutralMob {
	private static final EntityDataAccessor<Boolean> WANTS_TO_FLY = SynchedEntityData.defineId(EntityMamoth.class, EntityDataSerializers.BOOLEAN);
	public static final Ingredient FOOD = Ingredient.of(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_grass")));
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	protected @Nullable Vec3 pathfindPos;
	private UUID persistentAngerTarget;
	private int remainingPersistentAngerTime;
	public EntityMamoth(EntityType<? extends EntityMamoth> type, Level level) {
		super(type, level);
	}
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25, true));
		goalSelector.addGoal(1, new PanicGoal(this, 2D) {@Override protected boolean shouldPanic() {return mob.getLastHurtByMob() != null && mob.isBaby() || mob.isOnFire();}});
		goalSelector.addGoal(2, new BreedGoal(this, 1D));
		goalSelector.addGoal(3, new TemptGoal(this, 1.25, FOOD, false));
		goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1D));
		goalSelector.addGoal(5, new FollowParentGoal(this, 1.25));
		goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6F));
		goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		targetSelector.addGoal(1, new AlertingHurtByTargetGoal(this));
		targetSelector.addGoal(2, new ProtectBabyFromPlayerGoal(this));
		targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Fox.class, 10, true, true, null));
		targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PolarBear.class, 10, true, true, null));
		targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntitySeng.class, 10, true, true, null));
		targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntitySabear.class, 10, true, true, null));
		targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, false));
	}
	@Override
	public void tick() {
		super.tick();
		if(level() instanceof ServerLevel level) {
			updatePersistentAnger(level, true);
			if(isBaby()) {
				if(getLastHurtByMob() != null || entityData.get(WANTS_TO_FLY)) {
					if(onGround()) {
						setDeltaMovement(getDeltaMovement().multiply(1.1, 1D, 1.1));
						if(Math.pow(getDeltaMovement().x, 2) + Math.pow(getDeltaMovement().z, 2) > 8D) setDeltaMovement(getDeltaMovement().add(0D, .5, 0D));
					} else if(!isInWater()) {
						if(!isNoGravity()) setNoGravity(true);
						if(getNavigation().isInProgress()) getNavigation().stop();
						boolean blockedPath = horizontalCollision || verticalCollision;
				        if(!blockedPath) {
				            Vec3 futurePos = position().add(getDeltaMovement().x, getDeltaMovement().y, getDeltaMovement().z);
				            BlockPos pos = new BlockPos((int) futurePos.x, (int) futurePos.y, (int) futurePos.z);
				            BlockState state = level().getBlockState(pos);
				            blockedPath = state.is(Blocks.LAVA) || !state.getCollisionShape(level(), pos).equals(Shapes.empty());
				        }
				        if(pathfindPos == null || blockedPath) pathfindPos = new Vec3(getX() + ((random.nextFloat() - .5F) * 14F), getY() + ((random.nextFloat() - .6F) * 14F), getZ() + ((random.nextFloat() - .5F) * 14F));
				        double speed = getAttributeValue(Attributes.FLYING_SPEED);
				        setDeltaMovement(getDeltaMovement().x + (pathfindPos.x - getX()) / 64D * speed, getDeltaMovement().y + (pathfindPos.y- getY()) / 64D * speed, getDeltaMovement().z + (pathfindPos.z - getZ()) / 64D * speed);
				        double distanceX = pathfindPos.x - getX(), distanceY = pathfindPos.y- getY(), distanceZ = pathfindPos.z - getZ();
				        yRot = Utils.rotlerp(yRot, (float) (Mth.atan2(distanceZ, distanceX) * 180D / Math.PI) - 90F, 90F);
				        xRot = Utils.rotlerp(xRot, (float) -(Mth.atan2(distanceY, Math.sqrt(distanceX * distanceX + distanceZ * distanceZ)) * 180D / Math.PI), 20F);
				        if(Math.sqrt(distanceToSqr(pathfindPos)) < 2D) pathfindPos = null;
				        fallDistance = 0F;
					}
				} else {
					if(isNoGravity()) setNoGravity(false);
					if(getDeltaMovement().y < 0) {
						setDeltaMovement(getDeltaMovement().multiply(1D, .6, 1D));
						fallDistance = 0F;
					}
				}
				if(random.nextInt(100) == 0) {
					entityData.set(WANTS_TO_FLY, !entityData.get(WANTS_TO_FLY));
					setLastHurtByMob(null);
				}
			} else if(isNoGravity()) setNoGravity(false);
		}
	}
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(WANTS_TO_FLY, false);
	}
	@Override
	public boolean doHurtTarget(Entity entity) {
		boolean hurt = entity.hurt(damageSources().mobAttack(this), (int)getAttributeValue(Attributes.ATTACK_DAMAGE));
		if(hurt) doEnchantDamageEffects(this, entity);
		return hurt;
	}
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance instance, MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
		if(data == null) data = new AgeableMob.AgeableMobGroupData(1F);
		return super.finalizeSpawn(level, instance, type, data, tag);
	}
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		return EntityRegistry.MAMOTH.get().create(level);
	}
	@Override
	public float getScale() {
		return isBaby() ? .3F : 1F;
	}
	@Override
	public boolean isFood(ItemStack stack) {
		return FOOD.test(stack);
	}
	@Override public int getRemainingPersistentAngerTime() {return remainingPersistentAngerTime;}
	@Override public void setRemainingPersistentAngerTime(int i) {remainingPersistentAngerTime = i;}
	@Override public UUID getPersistentAngerTarget() {return persistentAngerTarget;}
	@Override public void setPersistentAngerTarget(UUID target) {persistentAngerTarget = target;}
	@Override public void startPersistentAngerTimer() {
		setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(random));
	}
	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		readPersistentAngerSaveData(level(), tag);
		if(tag.contains("wants_to_fly")) entityData.set(WANTS_TO_FLY, tag.getBoolean("wants_to_fly"));
	}
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		addPersistentAngerSaveData(tag);
		if(isBaby()) tag.putBoolean("wants_to_fly", entityData.get(WANTS_TO_FLY));
	}
}