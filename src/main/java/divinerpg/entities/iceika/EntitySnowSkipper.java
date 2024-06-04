package divinerpg.entities.iceika;

import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;

public class EntitySnowSkipper extends PathfinderMob {
	BlockPos pathfindPos, afraidPos;
	boolean wantsToRest = false;
	public EntitySnowSkipper(EntityType<? extends EntitySnowSkipper> type, Level worldIn) {
        super(type, worldIn);
        setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 1F);
        setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, 1F);
    }
	@Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .37F;}
	@Override
	public boolean checkSpawnObstruction(LevelReader worldIn) {
		return true;
	}
	@Override
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
		BlockState state = level.getBlockState(blockPosition());
		return state.is(Blocks.POWDER_SNOW) || (state.isAir() && level.getBlockState(blockPosition().below()).is(Blocks.POWDER_SNOW));
	}
	@Override
	protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(6, new SkipperStrollGoal(this, 1D));
		goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		goalSelector.addGoal(5, new SkipperAvoidGoal(this));
	}
	@Override protected void customServerAiStep() {
		BlockPos p = null;
		if(getLastHurtByMob() != null && position().distanceTo(getLastHurtByMob().position()) < 5D) p = getLastHurtByMob().blockPosition();
		Player player = level().getNearestPlayer(this, 5D);
		if(player != null) p = player.blockPosition();
		afraidPos = p;
		if(p != null) wantsToRest = false;
		else if(random.nextInt(100) == 0) wantsToRest = !wantsToRest;
		if(level().getBlockState(blockPosition()).is(Blocks.POWDER_SNOW)) {
			if(!isNoGravity()) setNoGravity(true);
			travel();
		} else {
			if(isNoGravity()) setNoGravity(false);
			if(level().getBlockState(blockPosition().below()).is(Blocks.POWDER_SNOW) && !wantsToRest) travel();
		}
	}
	void travel() {
        Vec3 futurePos = position().add(getDeltaMovement().x * 2D, getDeltaMovement().y * 2D, getDeltaMovement().z * 2D);
        BlockPos pos = new BlockPos((int) futurePos.x, (int) futurePos.y, (int) futurePos.z);
        BlockState state = level().getBlockState(pos);
        boolean blockedPath = !state.is(Blocks.POWDER_SNOW) && (state.is(Blocks.LAVA) || !state.getCollisionShape(level(), pos).equals(Shapes.empty()));
        //decide where to go next
        if(pathfindPos == null || blockedPath) {
        	int dx, dz;
        	if(afraidPos == null) {
        		dx = 0;
        		dz = 0;
        	} else {
        		dx = afraidPos.getX() - (int) (getX() * random.nextDouble() * 1.5D);
        		dz = afraidPos.getZ() - (int) (getZ() * random.nextDouble() * 1.5D);
        	}
        	pathfindPos = new BlockPos((int) (getX() + ((random.nextFloat() - .5F) * 8F)) - dx, (int) (getY() + ((random.nextFloat() - .6F) * 8F)), (int) (getZ() + ((random.nextFloat() - .5F) * 8F)) - dz);
        }
        if(pathfindPos != null) {
            //movement
            double speed = getAttributeValue(Attributes.FLYING_SPEED), distanceX = pathfindPos.getX() - getX(), distanceY = pathfindPos.getY() - getY() + (wantsToRest ? .3 : 0D), distanceZ = pathfindPos.getZ() - getZ(), distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY+distanceZ*distanceZ);
            setDeltaMovement(getDeltaMovement().x + distanceX / distance * speed, getDeltaMovement().y + distanceY / distance * speed, getDeltaMovement().z + distanceZ / distance * speed);
            yRot = Utils.rotlerp(yRot, (float) (Mth.atan2(distanceZ, distanceX) * 180D / Math.PI) - 90F, 90F);
            xRot = Utils.rotlerp(xRot, (float) -(Mth.atan2(distanceY, Math.sqrt(distanceX * distanceX + distanceZ * distanceZ)) * 180D / Math.PI), 20F);
            if(distance < 1D) pathfindPos = null;
        }
	}
	@Override
	protected void actuallyHurt(DamageSource source, float f) {
		wantsToRest = false;
		super.actuallyHurt(source, f);
	}
	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		return source.is(DamageTypes.DROWN) || (source.is(DamageTypes.IN_WALL) && level().getBlockState(blockPosition()).is(Blocks.POWDER_SNOW)) || super.isInvulnerableTo(source);
	}
	@Override public boolean canFreeze() {return false;}
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("wants_to_rest", wantsToRest);
	}
	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if(tag.contains("wants_to_rest")) wantsToRest = tag.getBoolean("wants_to_rest");
	}
	static class SkipperStrollGoal extends WaterAvoidingRandomStrollGoal {
		public SkipperStrollGoal(PathfinderMob mob, double speedModifier) {
			super(mob, speedModifier);
		}
		@Override
		public boolean canUse() {
			return !mob.level().getBlockState(mob.blockPosition()).is(Blocks.POWDER_SNOW) && !mob.level().getBlockState(mob.blockPosition().below()).is(Blocks.POWDER_SNOW) && super.canUse();
		}
		@Override
		public boolean canContinueToUse() {
			return !mob.level().getBlockState(mob.blockPosition()).is(Blocks.POWDER_SNOW) && !mob.level().getBlockState(mob.blockPosition().below()).is(Blocks.POWDER_SNOW) && super.canContinueToUse();
		}
	}
	static class SkipperAvoidGoal extends AvoidEntityGoal<Player> {
		public SkipperAvoidGoal(PathfinderMob mob) {
			super(mob, Player.class, 6F, 1D, 1.2);
		}
		@Override
		public boolean canUse() {
			return !mob.level().getBlockState(mob.blockPosition()).is(Blocks.POWDER_SNOW) && !mob.level().getBlockState(mob.blockPosition().below()).is(Blocks.POWDER_SNOW) && super.canUse();
		}
		@Override
		public boolean canContinueToUse() {
			return !mob.level().getBlockState(mob.blockPosition()).is(Blocks.POWDER_SNOW) && !mob.level().getBlockState(mob.blockPosition().below()).is(Blocks.POWDER_SNOW) && super.canContinueToUse();
		}
	}
}