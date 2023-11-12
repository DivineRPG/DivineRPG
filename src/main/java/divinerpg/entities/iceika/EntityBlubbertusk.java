package divinerpg.entities.iceika;

import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.tags.*;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.*;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public class EntityBlubbertusk extends Animal {
	private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemTags.FISHES);
	private int energy = 6000, previousEnergy = 6000;
	public EntityBlubbertusk(EntityType<? extends Animal> type, Level worldIn) {
		super(type, worldIn);
		setPathfindingMalus(BlockPathTypes.WATER, 0F);
		setPathfindingMalus(BlockPathTypes.DOOR_IRON_CLOSED, -1F);
		setPathfindingMalus(BlockPathTypes.DOOR_WOOD_CLOSED, -1F);
		setPathfindingMalus(BlockPathTypes.DOOR_OPEN, -1F);
		moveControl = new SmoothSwimmingMoveControl(this, 85, 10, .18F, .5F, true);
		lookControl = new SmoothSwimmingLookControl(this, 20);
		setMaxUpStep(1F);
	}
	@Override
	public boolean hurt(DamageSource source, float f) {
		if(f > .1F) energy += 500;
		return super.hurt(source, f);
	}
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(0, new BreathAirGoal(this));
		goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, false));
		goalSelector.addGoal(1, new BlubbertuskPanicGoal(this, 1.5));
		goalSelector.addGoal(2, new BreedGoal(this, 1D));
		goalSelector.addGoal(3, new TemptGoal(this, 1.2, FOOD_ITEMS, false));
		goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
		goalSelector.addGoal(5, new BlubbertuskStrollGoal(this, 1D, 10));
		goalSelector.addGoal(5, new BlubbertuskJumpGoal(this, 10));
		targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityCauldronFish.class, true));
	}
	@Override
	protected PathNavigation createNavigation(Level level) {
		return new AmphibiousPathNavigation(this, level);
	}
	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		previousEnergy = energy;
		if(isInWater()) {
			energy--;
			if(energy < 0) energy = 0;
			if(previousEnergy > 499 && energy < 500) setPathfindingMalus(BlockPathTypes.WATER, -2F);
			if(getAirSupply() < 200 && level().getBlockState(blockPosition().above()).isAir()) setDeltaMovement(getDeltaMovement().add(0D, .5D, 0D));
		} else {
			energy += 5;
			if(energy > 6000) energy = 6000;
			if(previousEnergy < 5001 && energy > 5000) setPathfindingMalus(BlockPathTypes.WATER, 2F);
		}
	}
	@Override
	public void travel(Vec3 vec) {
		if(isEffectiveAi() && isInWater()) {
			moveRelative(getSpeed(), vec);
			move(MoverType.SELF, getDeltaMovement());
			setDeltaMovement(getDeltaMovement().scale(.9));
			if(getTarget() == null) setDeltaMovement(getDeltaMovement().add(0D, -.005, 0D));
		} else super.travel(vec);
	}
	@Override
	public boolean isPushedByFluid() {
		return false;
	}
	@Override
	public int getMaxAirSupply() {
		return 4000;
	}
	@Override
	protected int increaseAirSupply(int i) {
		return 4000;
	}
	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}
	@Override
	public MobType getMobType() {
		return MobType.WATER;
	}
	@Override
	protected void playSwimSound(float f) {
		super.playSwimSound(f * 1.5F);
	}
	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.DOLPHIN_SWIM;
	}
	@Override
	protected SoundEvent getSwimSplashSound() {
		return SoundEvents.DOLPHIN_SPLASH;
	}
	@Override
	public float getScale() {
		return isBaby() ? .3F : 1F;
	}
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		return EntityRegistry.BLUBBERTUSK.get().create(level);
	}
	@Override
	public boolean isFood(ItemStack item) {
		return item.is(ItemTags.FISHES);
	}
	@Override
	public boolean canBeLeashed(Player p) {
		return true;
	}
	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return .78F;
	}
	@Override
	public float getWalkTargetValue(BlockPos pos, LevelReader level) {
		return level.getFluidState(pos).is(FluidTags.WATER) ? 10F : level.getPathfindingCostFromLightLevels(pos);
	}
	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if(tag.contains("Energy")) {
			energy = tag.getInt("Energy");
			previousEnergy = tag.getInt("PreviousEnergy");
		}
	}
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Energy", energy);
		tag.putInt("PreviousEnergy", previousEnergy);
	}
	static class BlubbertuskPanicGoal extends PanicGoal {
		BlubbertuskPanicGoal(PathfinderMob mob, double speedModifier) {
			super(mob, speedModifier);
		}
		@Override
		public boolean canUse() {
			if(!shouldPanic()) return false;
			BlockPos pos = lookForWater(mob.level(), mob, 7);
			if(pos == null) return findRandomPosition();
			posX = pos.getX();
			posY = pos.getY();
			posZ = pos.getZ();
			return true;
		}
	}
	static class BlubbertuskStrollGoal extends RandomStrollGoal {
		BlubbertuskStrollGoal(EntityBlubbertusk entity, double speedModifier, int interval) {
			super(entity, speedModifier, interval);
		}
		@Override
		public boolean canUse() {
			return (mob.isInWater() || ((EntityBlubbertusk)mob).energy > 1000) && super.canUse();
		}
		@Override
		protected Vec3 getPosition() {
			return (mob.isInWater() && mob.getAirSupply() > 140 && ((EntityBlubbertusk)mob).energy > 500) ? BehaviorUtils.getRandomSwimmablePos(mob, 10, 7) : super.getPosition();
		}
	}
	static class BlubbertuskJumpGoal extends JumpGoal {
		static final int[] STEPS_TO_CHECK = new int[]{0, 1, 4, 5, 6, 7};
		final EntityBlubbertusk mob;
		final int interval;
		boolean breached;
		BlubbertuskJumpGoal(EntityBlubbertusk entity, int delay) {
			mob = entity;
			interval = reducedTickDelay(delay);
		}
		@Override
		public boolean canUse() {
			if(mob.getRandom().nextInt(interval) != 0) return false;
			else {
				Direction direction = mob.getMotionDirection();
				int stepX = direction.getStepX(), stepZ= direction.getStepZ();
				BlockPos blockpos = mob.blockPosition();
				for(int step : STEPS_TO_CHECK) if(!landingIsClear(blockpos, stepX, stepZ, step) || !surfaceIsClear(blockpos, stepX, stepZ, step)) return false;
				return true;
			}
		}
		@SuppressWarnings("deprecation")
		boolean landingIsClear(BlockPos pos, int stepX, int stepZ, int step) {
			BlockPos blockpos = pos.offset(stepX * step, 0, stepZ * step);
			return mob.level().getBlockState(blockpos).blocksMotion();
		}
		boolean surfaceIsClear(BlockPos pos, int stepX, int stepZ, int step) {
			return mob.level().getBlockState(pos.offset(stepX* step, 1, stepZ* step)).isAir() && mob.level().getBlockState(pos.offset(stepX* step, 2, stepZ* step)).isAir();
		}
		@Override
		public boolean canContinueToUse() {
			double ymov = mob.getDeltaMovement().y;
			return (!(ymov * ymov < .03) || mob.getXRot() == 0F || !(Math.abs(mob.getXRot()) < 10F) || !mob.isInWater()) && !mob.onGround();
		}
		@Override
		public boolean isInterruptable() {
			return false;
		}
		@Override
		public void start() {
			Direction direction = mob.getMotionDirection();
			mob.setDeltaMovement(mob.getDeltaMovement().add(direction.getStepX() * .6, .5, direction.getStepZ() * .6));
			mob.getNavigation().stop();
		}
		public void tick() {
			boolean prevBreach = breached;
			if(!prevBreach) breached = mob.level().getFluidState(mob.blockPosition()).is(FluidTags.WATER);
			Vec3 mov = mob.getDeltaMovement();
			if(mov.y * mov.y < .03 && mob.getXRot() != 0F) mob.setXRot(Mth.rotLerp(.2F, mob.getXRot(), 0F));
			else if(mov.length() > .00005) mob.setXRot((float) (Math.atan2(-mov.y, mov.horizontalDistance()) * (180D / Math.PI)));
		}
	}
}