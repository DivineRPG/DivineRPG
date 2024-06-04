package divinerpg.entities.iceika;

import divinerpg.block_entities.block.*;
import divinerpg.blocks.iceika.BlockRobbinHut;
import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.boss.EntityKitra;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.*;

import java.util.*;

public class EntityRobbin extends EntityDivineFlyingMob {
    private int tiredTicks = 0;
    public boolean wantsNest = false;
    private static final EntityDataAccessor<Integer> ITEM = SynchedEntityData.defineId(EntityRobbin.class, EntityDataSerializers.INT);
    public ItemStack mouthPiece = ItemStack.EMPTY;
    public EntityRobbin(EntityType<? extends EntityDivineFlyingMob> entityType, Level world) {
        super(entityType, world);
        moveControl = new RobbinMoveControl(this);
    }
    @Override protected void defineSynchedData() {
    	super.defineSynchedData();
    	entityData.define(ITEM, 0);
    }
    @Override public void addAdditionalSaveData(CompoundTag tag) {
    	super.addAdditionalSaveData(tag);
    	tag.put("MouthPiece", mouthPiece.save(new CompoundTag()));
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
    	super.readAdditionalSaveData(tag);
    	if(tag.contains("MouthPiece")) setMouthPiece(ItemStack.of(tag.getCompound("MouthPiece")));
    }
    public int getItemID() {
    	return entityData.get(ITEM);
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        targetSelector.addGoal(1, new FollowWhaleGoal());
        goalSelector.addGoal(2, new GoalRideWhaleWhenTired());
        goalSelector.addGoal(6, new RobbinRandomStrollGoal(this, 1D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, EntityKitra.class, 6F));
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .46F;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 6;}
    public boolean isTired() {
        return tiredTicks > 1200;
    }
    public void setMouthPiece(ItemStack item) {
    	if(item == null) item = ItemStack.EMPTY;
    	mouthPiece = item;
    	entityData.set(ITEM, Item.getId(item.getItem()));
    }
    @Override
    public void die(DamageSource source) {
    	super.die(source);
    	if(!mouthPiece.isEmpty()) level().addFreshEntity(new ItemEntity(level(), getX(), getY(), getZ(), mouthPiece));
    }
    @Override protected float getJumpPower() {
    	return .22F * getBlockJumpFactor() + getJumpBoostPower();
    }
    @Override public void reachTarget() {
    	Path path = getNavigation().getPath();
		BlockPos targetPos = path.getTarget();
    	BlockState target = level().getBlockState(targetPos);
    	if(target.is(BlockRegistry.robbinHut.get()) && BlockRobbinHut.hasSpace((ServerLevel) level(), targetPos)) {
    		RobbinHutBlockEntity block = (RobbinHutBlockEntity) level().getBlockEntity(targetPos);
			CompoundTag tag = new CompoundTag();
			save(tag);
    		if(block.robbin1 == null) block.robbin1 = tag;
    		else block.robbin2 = tag;
    		remove(RemovalReason.DISCARDED);
    	} else if(target.is(BlockRegistry.robbinNest.get()) && level().getBlockEntity(targetPos) instanceof RobbinNestBlockEntity nest) {
    		if(wantsNest && !nest.getItem().is(ItemRegistry.robbin_egg.get())) {
    			if(!nest.isEmpty()) level().addFreshEntity(new ItemEntity(level(), targetPos.getX() + .5, targetPos.getY() + .1, targetPos.getZ() + .5, nest.getItem()));
    			nest.setItem(ItemRegistry.robbin_egg.get().getDefaultInstance());
    			level().playSound(this, targetPos, SoundEvents.BEEHIVE_ENTER, SoundSource.NEUTRAL, .5F, 1.5F);
    		} else if(nest.isEmpty() && !mouthPiece.isEmpty()) {
    			nest.setItem(mouthPiece);
    			level().playSound(this, targetPos, SoundEvents.BEEHIVE_ENTER, SoundSource.NEUTRAL, .5F, 1.5F);
    			setMouthPiece(ItemStack.EMPTY);
    		}
    	} else {
    		List<ItemEntity> items = level().getEntitiesOfClass(ItemEntity.class, new AABB(targetPos.offset(-1, -1, -1), targetPos.offset(1, 1, 1)));
    		if(items.size() > 0) {
    			setMouthPiece(items.get(0).getItem());
    			level().playSound(this, targetPos, SoundEvents.ITEM_PICKUP, SoundSource.NEUTRAL, .5F, 1F);
    			items.get(0).discard();
    		}
    	}
    }
    @Override protected void customServerAiStep() {
    	Path path = getNavigation().getPath();
    	if(path == null && tiredTicks % 10 == 0) {
        	BlockPos pos;
			if(isTired()) {
        		EntityKitra nearbyWhale = level().getNearestEntity(EntityKitra.class, TargetingConditions.DEFAULT, this, this.getX(), this.getY(), this.getZ(), this.getBoundingBox().inflate(32.0));
                if(nearbyWhale == null) {
                	for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).is(BlockRegistry.robbinHut.get())) {
                		getNavigation().moveTo(x, y, z, 1D);
                		return;
            		} for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).isFaceSturdy(level(), pos, Direction.UP)) {
                		MutableBlockPos mut = pos.mutable();
                		while(level().isOutsideBuildHeight(mut.move(Direction.UP)) || (level().getBlockState(mut).isFaceSturdy(level(), pos, Direction.UP) && ++y < blockPosition().getY() + 7));
            			getNavigation().moveTo(x, y, z, 1D);
                		return;
            		}
                } else pathfindPos = nearbyWhale.position();
            } else if(wantsNest || !mouthPiece.isEmpty()) {for(int x = blockPosition().getX() - 5; x < blockPosition().getX() + 5; x++) for(int y = blockPosition().getY() - 5; y < blockPosition().getY() + 5; y++) for(int z = blockPosition().getZ() - 5; z < blockPosition().getZ() + 5; z++) if(!level().isOutsideBuildHeight(pos = new BlockPos(x, y, z)) && level().getBlockState(pos).is(BlockRegistry.robbinNest.get()) && level().getBlockEntity(pos) instanceof RobbinNestBlockEntity nest && (nest.isEmpty() || (wantsNest && !nest.getItem().is(ItemRegistry.robbin_egg.get()))))
 				getNavigation().moveTo(x, y, z, 1D);
			} else {
    			List<Entity> items = level().getEntities(this, new AABB(blockPosition().offset(-5, -5, -5), blockPosition().offset(5, 5, 5)), (entity) -> entity instanceof ItemEntity);
            	if(items.size() > 0) {
            		ItemEntity nearest = (ItemEntity) items.get(0);
            		for(Entity e : items) if(distanceTo(e) < distanceTo(nearest)) nearest = (ItemEntity) e;
            		getNavigation().moveTo(nearest, 1D);
            	}
     		}
		} if(isNoGravity()) {
            tiredTicks++;
        	super.customServerAiStep();
        	if(onGround()) {
        		setNoGravity(false);
        		return;
        	}
        } else if(tiredTicks > 0) tiredTicks--;
        else if(random.nextBoolean()) {
        	setDeltaMovement(getDeltaMovement().add(0D, .2, 0D));
        	setNoGravity(true);
        }
	}
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return mouthPiece.isEmpty();}
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
    	@Override public boolean canUse() {return !isNoGravity() && getNavigation().getPath() == null && super.canUse();}
    	@Override public boolean canContinueToUse() {return !isNoGravity() && super.canContinueToUse();}
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