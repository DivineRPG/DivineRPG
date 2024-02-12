package divinerpg.entities.iceika;

import divinerpg.block_entities.block.RobbinNestBlockEntity;
import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.boss.EntityKitra;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class EntityRobbin extends EntityDivineFlyingMob {
    private int wingFlapTicks;
    private int tiredTicks = 0;
    private boolean isflying = false;
    public EntityRobbin(EntityType<? extends EntityDivineFlyingMob> entityType, Level world) {
        super(entityType, world);
        moveControl = new RobbinMoveControl(this);
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        targetSelector.addGoal(1, new FollowWhaleGoal());
        goalSelector.addGoal(2, new GoalRideWhaleWhenTired());
        goalSelector.addGoal(6, new RobbinRandomStrollGoal(this, 1D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, EntityKitra.class, 6F));
    }
    @Override protected PathNavigation createNavigation(Level level) {return new GroundPathNavigation(this, level);}
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .4375F;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 6;}
    public boolean isTired() {
        return tiredTicks > 1200;
    }
    @Override public void tick() {
    	super.tick();
    	if(level().isClientSide() && wingFlapTicks > 0) wingFlapTicks--;
    }
    @Override protected void customServerAiStep() {
    	if(isflying) {
            tiredTicks++;
            if(isTired() && tiredTicks % 20 == 0) {
            	Path path = getNavigation().getPath();
            	if(path == null) {
                    EntityKitra nearbyWhale = level().getNearestEntity(EntityKitra.class, TargetingConditions.DEFAULT, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().inflate(32.0));
                    if(nearbyWhale == null) {
                    	BlockPos pos;
                    	for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).is(BlockRegistry.robbinHut.get())) {
                    		getNavigation().moveTo(x, y, z, 1D);
                    		return;
                		} for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).isFaceSturdy(level(), pos, Direction.UP)) {
                    		MutableBlockPos mut = pos.mutable();
                    		while(level().isOutsideBuildHeight(mut.move(Direction.UP)) || (level().getBlockState(mut).isFaceSturdy(level(), pos, Direction.UP) && ++y < blockPosition().getY() + 7));
                			getNavigation().moveTo(x, y, z, 1D);
                    		return;
                		} tiredTicks -= 200;
                    } else pathfindPos = nearbyWhale.position();
                } else if(path.getDistToTarget() < 1F) {
                	BlockState target = level().getBlockState(path.getTarget());
                	if(target.is(BlockRegistry.robbinHut.get())) {
                		tiredTicks = 0;//TODO: enter the hut
                	} else if(target.is(BlockRegistry.robbinNest.get()) && level().getBlockEntity(path.getTarget()) instanceof RobbinNestBlockEntity nest && nest.isEmpty()) nest.setItem(ItemRegistry.robbin_egg.get().getDefaultInstance());
                }
            } super.customServerAiStep();
        	if(onGround()) {
        		isflying = false;
        		setNoGravity(false);
        		return;
        	}
        } else if(tiredTicks > 0) tiredTicks--;
        else if(random.nextBoolean()) {
        	setDeltaMovement(getDeltaMovement().add(0D, .2, 0D));
        	isflying = true;
        }
	}
    
    static class RobbinMoveControl extends MoveControl {
    	private int jumpDelay;
    	RobbinMoveControl(EntityRobbin entity) {
    		super(entity);
    	}
    	void setWantedMovement(double speedModifier) {
    		this.speedModifier = speedModifier;
    		operation = Operation.MOVE_TO;
    	}
    	@Override public void tick() {
            mob.yHeadRot = mob.getYRot();
            mob.yBodyRot = mob.getYRot();
            if(operation != Operation.MOVE_TO) mob.setZza(0F);
            else {
               operation = Operation.WAIT;
               if(mob.onGround()) {
                  mob.setSpeed((float)(speedModifier * mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                  if(jumpDelay-- <= 0) {
                     jumpDelay = mob.random.nextInt(10) + 1;
                     mob.getJumpControl().jump();
                  } else {
                     mob.xxa = 0F;
                     mob.zza = 0F;
                     mob.setSpeed(0F);
                  }
               } else mob.setSpeed((float)(speedModifier * mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            }
    	}
    }
    class RobbinRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
		public RobbinRandomStrollGoal(PathfinderMob mob, double speedModifier) {super(mob, speedModifier);}
    	@Override public boolean canUse() {return !isflying && super.canUse();}
    	@Override public boolean canContinueToUse() {return !isflying && super.canContinueToUse();}
    	@Override public void tick() {
    		super.tick();
    		Path path = getNavigation().getPath();
    		if(path != null) {
    			double distanceX = path.getNextNodePos().getX() - getX(), distanceZ = path.getNextNodePos().getZ() - getZ();
    			yRot = Utils.rotlerp(yRot, (float) (Mth.atan2(distanceZ, distanceX) * 180D / Math.PI) - 90F, 90F);
    		}
    	}
    }
    class FollowWhaleGoal extends Goal {
        private static final double FOLLOW_DISTANCE = 32.0, CIRCLE_RADIUS = 5.0;
        private EntityKitra targetWhale;
        @Override public boolean canUse() {
            if(targetWhale == null || !targetWhale.isAlive()) targetWhale = level().getNearestEntity(EntityKitra.class, TargetingConditions.DEFAULT, EntityRobbin.this, getX(), getY(), getZ(), getBoundingBox().inflate(FOLLOW_DISTANCE));
            return targetWhale != null;
        }
        @Override public void start() {
            getNavigation().stop();
        }
        @Override public void tick() {
            double distanceToWhale = distanceTo(targetWhale);
            if(distanceToWhale <= FOLLOW_DISTANCE) {// Fly circles around the whale
                double angleToWhale = Math.atan2(targetWhale.getZ() - getZ(), targetWhale.getX() - getX());
                pathfindPos = new Vec3(targetWhale.getX() + (CIRCLE_RADIUS * Math.cos(angleToWhale)), targetWhale.getY() + 5.0, targetWhale.getZ() + (CIRCLE_RADIUS * Math.sin(angleToWhale)));
            } else pathfindPos = targetWhale.position();
        }
        @Override public void stop() {
            getNavigation().stop();
        }
    }
    public class GoalRideWhaleWhenTired extends Goal {
        private EntityKitra whale;
        private int rideTime;
        public GoalRideWhaleWhenTired() {
            setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }
        @Override public boolean canUse() {
        	if(isTired()) {
        		whale = level().getNearestEntity(EntityKitra.class, TargetingConditions.DEFAULT, EntityRobbin.this, getX(), getY(), getZ(), getBoundingBox().inflate(16.0));
        		return whale != null && distanceTo(whale) < 3F && whale.getPassengers().size() == 0;
        	} return false;
        }
        @Override public void start() {
        	startRiding(whale);
            rideTime = 0;
        }
        @Override public void stop() {
            stopRiding();
            whale = null;
            rideTime = 0;
        }
        @Override public boolean canContinueToUse() {
            return isTired() && whale != null && !whale.isInWater() && rideTime < 200;
        }
        @Override public void tick() {
            rideTime++;
            if(isInWater()) stop();
        }
    }
}