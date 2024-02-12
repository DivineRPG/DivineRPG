package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.boss.EntityKitra;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class EntityRobbin extends EntityDivineFlyingMob {
    private int wingFlapTicks;
    private static final int TICKS_PER_MINUTE = 1200; // 20 ticks per second * 60 seconds per minute
    private int tiredTicks = 0;
    private int tiredThreshold = 0;
    private boolean isflying = false;

    public EntityRobbin(EntityType<? extends EntityDivineFlyingMob> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(1, new FollowWhaleGoal(this));
        this.goalSelector.addGoal(2, new GoalRideWhaleWhenTired(this));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, EntityKitra.class, 6.0F));
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.4375F;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 6;
    }

    @Override
    public void tick() {
        super.tick();
        if(isflying) {
        	if(onGround()) {
        		isflying = false;
        		return;
        	} if(level().isClientSide() && wingFlapTicks > 0) wingFlapTicks--;
            tiredTicks++;
            // If tiredTicks reaches the threshold and there is no resting place nearby, set the robbin to be tired and reset tiredTicks and tiredThreshold
            if(tiredTicks >= tiredThreshold) {
            	Path path = getNavigation().getPath();
            	if(path == null) {
                    EntityKitra nearbyWhale = this.level().getNearestEntity(EntityKitra.class,
                            TargetingConditions.DEFAULT, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().inflate(32.0));
                    if(nearbyWhale == null) {
                    	//search for nearby hut
                    	BlockPos pos;
                    	if(tiredTicks % 20 == 0) {
                    		for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).is(BlockRegistry.robbinHut.get())) {
                        		getNavigation().moveTo(x, y, z, 1D);
                        		return;
                    		} for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).isFaceSturdy(level(), pos, Direction.UP)) {
                        		MutableBlockPos mut = pos.mutable();
                        		while(level().isOutsideBuildHeight(mut.move(Direction.UP)) || (level().getBlockState(mut).isFaceSturdy(level(), pos, Direction.UP) && ++y < blockPosition().getY() + 7));
                    			getNavigation().moveTo(x, y, z, 1D);
                        		return;
                    		}
                    	} tiredThreshold = this.level().getRandom().nextInt(TICKS_PER_MINUTE * 2); // Set a new random threshold between 0 and 2 minutes
                        tiredTicks = 0;
                    } else getNavigation().moveTo(nearbyWhale, 1D);
                } else if(getNavigation().getPath().getDistToTarget() < 2F && level().getBlockState(getNavigation().getPath().getTarget()).is(BlockRegistry.robbinHut.get()));//TODO: enter the hut
            }
        } else {
        	
        }
    }

    public boolean isTired() {
        return tiredThreshold > 900;
    }

    class FollowWhaleGoal extends Goal {
        private static final double FOLLOW_DISTANCE = 32.0;
        private static final double CIRCLE_RADIUS = 5.0;
        private EntityRobbin entityRobbin;
        private EntityKitra targetWhale;

        public FollowWhaleGoal(EntityRobbin entityRobbin) {
            this.entityRobbin = entityRobbin;
        }

        @Override
        public boolean canUse() {
            if (targetWhale == null || !targetWhale.isAlive()) {
                // Find a new target whale
                targetWhale = entityRobbin.level().getNearestEntity(EntityKitra.class,
                        TargetingConditions.DEFAULT, entityRobbin, entityRobbin.getX(), entityRobbin.getY(),
                        entityRobbin.getZ(), entityRobbin.getBoundingBox().inflate(FOLLOW_DISTANCE));
            }
            return targetWhale != null;
        }

        @Override
        public void start() {
            entityRobbin.getNavigation().stop();
        }

        @Override
        public void tick() {
            double distanceToWhale = entityRobbin.distanceTo(targetWhale);
            if (distanceToWhale <= FOLLOW_DISTANCE) {
                // Fly circles around the whale
                double angleToWhale = Math.atan2(targetWhale.getZ() - entityRobbin.getZ(),
                        targetWhale.getX() - entityRobbin.getX());
                double circleX = targetWhale.getX() + (CIRCLE_RADIUS * Math.cos(angleToWhale));
                double circleY = targetWhale.getY() + 5.0;
                double circleZ = targetWhale.getZ() + (CIRCLE_RADIUS * Math.sin(angleToWhale));
                entityRobbin.getNavigation().moveTo(circleX, circleY, circleZ, 1.0);
            } else {
                // Fly towards the whale
                entityRobbin.getNavigation().moveTo(targetWhale, 1.0);
            }
        }

        @Override
        public void stop() {
            entityRobbin.getNavigation().stop();
        }
    }

    public class GoalRideWhaleWhenTired extends Goal {
        private final EntityRobbin robbin;
        private EntityKitra whale;
        private int rideTime;
        private int rideTimeThreshold = 200;

        public GoalRideWhaleWhenTired(EntityRobbin robbin) {
            this.robbin = robbin;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            // Only ride the whale when tired
        	if(isTired()) {
        		whale = robbin.level().getNearestEntity(EntityKitra.class, TargetingConditions.DEFAULT, robbin, robbin.getX(), robbin.getY(), robbin.getZ(), robbin.getBoundingBox().inflate(16.0));
        		return whale != null && robbin.distanceTo(whale) < 3F && whale.getPassengers().size() == 0;
        	} return false;
        }

        @Override
        public void start() {
        	robbin.startRiding(whale);
            rideTime = 0;
        }

        @Override
        public void stop() {
            // Dismount the whale when the ride is over
            robbin.stopRiding();
            whale = null;
            rideTime = 0;
        }

        @Override
        public boolean canContinueToUse() {
            // Continue riding the whale while tired
            return robbin.isTired() && whale != null && !whale.isInWater() && rideTime < rideTimeThreshold;
        }

        @Override
        public void tick() {
            // Increment ride time
            rideTime++;

            // Dismount the whale if the robbin goes underwater
            if (robbin.isInWater()) {
                stop();
            }
        }
    }

}
