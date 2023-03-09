package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.vanilla.overworld.EntityWhale;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class EntityRobin extends EntityDivineFlyingMob {
        private int wingFlapTicks;
        private static final int TICKS_PER_MINUTE = 1200; // 20 ticks per second * 60 seconds per minute
    private int tiredTicks = 0;
    private int tiredThreshold = 0;


    public EntityRobin(EntityType<? extends EntityDivineFlyingMob> entityType, Level world) {
            super(entityType, world);
            this.moveControl = new MoveControl(this);
            setNoGravity(true);
        }

        @Override
        protected void registerGoals() {
            goalSelector.addGoal(0, new FloatGoal(this));
            this.targetSelector.addGoal(1, new FollowWhaleGoal(this));
            this.goalSelector.addGoal(2, new GoalRideWhaleWhenTired(this));
            goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
            goalSelector.addGoal(7, new LookAtPlayerGoal(this, EntityWhale.class, 6.0F));
        }


    @Override
    public void tick() {
        super.tick();
        if (level.isClientSide) {
            // Animate wing flapping on client-side
            if (wingFlapTicks > 0) {
                wingFlapTicks--;
            } else {
            }
        }
        // Increment tiredTicks every tick
        tiredTicks++;

        // If tiredTicks reaches the threshold and there is no whale nearby, set the robin to be tired and reset tiredTicks and tiredThreshold
        if (tiredTicks >= tiredThreshold) {
            EntityWhale nearbyWhale = this.level.getNearestEntity(EntityWhale.class,
                    TargetingConditions.DEFAULT, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().inflate(32.0));
            if (nearbyWhale == null) {
                tiredThreshold = this.level.random.nextInt(TICKS_PER_MINUTE * 2); // Set a new random threshold between 0 and 2 minutes
                tiredTicks = 0;
            }
        }
    }
        public boolean isTired() {
        return tiredThreshold > 900;
    }



    class FollowWhaleGoal extends Goal {
        private static final double FOLLOW_DISTANCE = 32.0;
        private static final double CIRCLE_RADIUS = 5.0;
        private EntityRobin entityRobin;
        private EntityWhale targetWhale;

        public FollowWhaleGoal(EntityRobin entityRobin) {
            this.entityRobin = entityRobin;
        }

        @Override
        public boolean canUse() {
            if (targetWhale == null || !targetWhale.isAlive()) {
                // Find a new target whale
                targetWhale = entityRobin.level.getNearestEntity(EntityWhale.class,
                        TargetingConditions.DEFAULT, entityRobin, entityRobin.getX(), entityRobin.getY(),
                        entityRobin.getZ(), entityRobin.getBoundingBox().inflate(FOLLOW_DISTANCE));
            }
            return targetWhale != null;
        }

        @Override
        public void start() {
            entityRobin.getNavigation().stop();
        }

        @Override
        public void tick() {
            double distanceToWhale = entityRobin.distanceTo(targetWhale);
            if (distanceToWhale <= FOLLOW_DISTANCE) {
                // Fly circles around the whale
                double angleToWhale = Math.atan2(targetWhale.getZ() - entityRobin.getZ(),
                        targetWhale.getX() - entityRobin.getX());
                double circleX = targetWhale.getX() + (CIRCLE_RADIUS * Math.cos(angleToWhale));
                double circleY = targetWhale.getY() + 5.0;
                double circleZ = targetWhale.getZ() + (CIRCLE_RADIUS * Math.sin(angleToWhale));
                entityRobin.getNavigation().moveTo(circleX, circleY, circleZ, 1.0);
            } else {
                // Fly towards the whale
                entityRobin.getNavigation().moveTo(targetWhale, 1.0);
            }
        }

        @Override
        public void stop() {
            entityRobin.getNavigation().stop();
        }
    }

    public class GoalRideWhaleWhenTired extends Goal {
        private final EntityRobin robin;
        private EntityWhale whale;
        private int rideTime;
        private int rideTimeThreshold = 200;

        public GoalRideWhaleWhenTired(EntityRobin robin) {
            this.robin = robin;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            // Only ride the whale when tired
            return robin.isTired() && robin.getControllingPassenger() == null;
        }

        @Override
        public void start() {
            // Find the nearest whale
            whale = robin.level.getNearestEntity(EntityWhale.class, TargetingConditions.DEFAULT, robin, robin.getX(), robin.getY(), robin.getZ(), robin.getBoundingBox().inflate(16.0));
            rideTime = 0;
        }

        @Override
        public void stop() {
            // Dismount the whale when the ride is over
            robin.stopRiding();
            whale = null;
            rideTime = 0;
        }

        @Override
        public boolean canContinueToUse() {
            // Continue riding the whale while tired
            return robin.isTired() && whale != null && !whale.isInWater() && rideTime < rideTimeThreshold;
        }

        @Override
        public void tick() {
            if(whale != null) {
                robin.getNavigation().moveTo(whale, 1.0);
                robin.getLookControl().setLookAt(whale, 30.0F, 30.0F);

            }
            // Increment ride time
            rideTime++;

            // Dismount the whale if the robin goes underwater
            if (robin.isInWater()) {
                stop();
            }
        }
    }

}