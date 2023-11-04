package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineWaterMob;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.*;
import net.minecraft.tags.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.*;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public class EntityBlubbertusk extends EntityDivineWaterMob {
	private static final Ingredient FOOD_ITEMS = Ingredient.of(ItemTags.FISHES);
	private int energy = 6000, previousEnergy = 6000;
	public EntityBlubbertusk(EntityType<? extends EntityDivineWaterMob> type, Level worldIn) {
		super(type, worldIn);
		setPathfindingMalus(BlockPathTypes.WATER, 0F);
		setPathfindingMalus(BlockPathTypes.DOOR_IRON_CLOSED, -1F);
		setPathfindingMalus(BlockPathTypes.DOOR_WOOD_CLOSED, -1F);
		setPathfindingMalus(BlockPathTypes.DOOR_OPEN, -1F);
		moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.15F, 0.1F, true);
		lookControl = new SmoothSwimmingLookControl(this, 20);
		setMaxUpStep(1F);
	}

	@Override
	public boolean isAmphibious() {
		return true;
	}

	@Override
	public boolean hurt(DamageSource source, float f) {
		if(f > .1F) energy += 500;
		return super.hurt(source, f);
	}
	//TODO - breeding
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(0, new BreathAirGoal(this));
		goalSelector.addGoal(1, new BlubbertuskPanicGoal(this, 1.5));
//		goalSelector.addGoal(2, new BreedGoal(this, 1D));
		goalSelector.addGoal(3, new TemptGoal(this, 1.2, FOOD_ITEMS, false));
//		goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
		goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1.0D, 1));
	}
	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		previousEnergy = energy;
		if(isInWater()) {
			energy--;
			if(previousEnergy > 499 && energy < 500) setPathfindingMalus(BlockPathTypes.WATER, -2F);
		} else {
			energy += 5;
			if(previousEnergy < 5001 && energy > 5000) setPathfindingMalus(BlockPathTypes.WATER, 2F);
		}
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
//	@Override
//	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
//		return EntityRegistry.BLUBBERTUSK.get().create(level);
//	}
//	@Override
//	public boolean isFood(ItemStack item) {
//		return item.is(ItemTags.FISHES);
//	}
	@Override
	public boolean canBeLeashed(Player p) {
		return true;
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
		protected Vec3 getPosition() {
			if (mob.isInWater() && mob.getAirSupply() > 140 && ((EntityBlubbertusk)mob).energy > 500) {
				return BehaviorUtils.getRandomSwimmablePos(mob, 10, 7);
			} else {
				BlockPos newPos = BlockPos.containing(BehaviorUtils.getRandomSwimmablePos(mob, 10, 3));
				return new Vec3(newPos.getX(), newPos.getY(), newPos.getZ());
			}
		}
	}

}