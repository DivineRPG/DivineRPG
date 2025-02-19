package divinerpg.entities.iceika;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.floats.*;
import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.pathfinder.*;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class EntitySnowSkipper extends PathfinderMob {
	public EntitySnowSkipper(EntityType<? extends EntitySnowSkipper> type, Level worldIn) {
        super(type, worldIn);
		getNavigation().setCanFloat(true);
		setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 0F);
		setPathfindingMalus(PathType.POWDER_SNOW, 0F);
    }
	@Override protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.RABBIT_HURT;
	}
	@Override protected @Nullable SoundEvent getDeathSound() {
		return SoundEvents.RABBIT_DEATH;
	}
	@Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
	@Override protected void registerGoals() {
		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 6F, 1D, 1.2));
		goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1D));
		goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	}
	@Override protected PathNavigation createNavigation(Level level) {
		return new GroundPathNavigation(this, level) {
			@Override protected PathFinder createPathFinder(int maxVisitedNodes) {
				nodeEvaluator = new WalkNodeEvaluator() {
					@Override public PathType getPathType(PathfindingContext context, int x, int y, int z) {
						return isTravelMedium(level.getBlockState(new BlockPos(x, y, z))) ? PathType.WALKABLE : super.getPathType(context, x, y, z);
					}
				};
				return new PathFinder(nodeEvaluator, maxVisitedNodes);
			}
			@Override protected boolean canUpdatePath() {
				return super.canUpdatePath() || isTravelMedium(mob.getInBlockState());
			}
		};
	}
	public static boolean isTravelMedium(BlockState state) {
		return state.is(Blocks.POWDER_SNOW) || state.is(Blocks.SNOW_BLOCK) || state.is(Blocks.SNOW);
	}
	@Override public boolean isInvulnerableTo(DamageSource source) {
		return (source.is(DamageTypes.IN_WALL) && !isTravelMedium(getInBlockState())) || super.isInvulnerableTo(source);
	}
	@Override public boolean isColliding(BlockPos pos, BlockState state) {
		return !isTravelMedium(state) && super.isColliding(pos, state);
	}
	@Override public boolean isInWall() {
		return !isTravelMedium(getInBlockState()) && super.isInWall();
	}
	@Override public void travel(Vec3 travelVector) {
		super.travel(travelVector);
		if(isPathFinding()) {
			if(isTravelMedium(getInBlockState())) addDeltaMovement(new Vec3(getDeltaMovement().x * 0.01, .15, getDeltaMovement().z * 0.01));
			else if(isTravelMedium(getBlockStateOn())) jumpFromGround();
		}
	}
	@Override
	public void move(MoverType type, Vec3 dv) {
		AABB aabb = getBoundingBox().expandTowards(dv).deflate(1E-6);
		if(level().getBlockStatesIfLoaded(aabb).anyMatch(EntitySnowSkipper::isTravelMedium)) {
			dv = collide(dv, aabb);
			setPos(getX() + dv.x, getY() + dv.y, getZ() + dv.z);
		} else super.move(type, dv);
	}
	public Vec3 collide(Vec3 vec, AABB expandedBox) {
		AABB aabb = getBoundingBox();
		List<VoxelShape> list = level().getEntityCollisions(this, expandedBox);
		Vec3 vec3 = vec.lengthSqr() == 0D ? vec : getBlockCollisions(vec, aabb, expandedBox, list);
		boolean xcollision = vec.x != vec3.x, ycollision = vec.y != vec3.y, zcollision = vec.z != vec3.z;
		boolean groundcollision = ycollision && vec.y < 0D;
		if(maxUpStep() > 0F && (groundcollision || onGround()) && (xcollision || zcollision)) {
			AABB aabb1 = groundcollision ? aabb.move(0D, vec3.y, 0D) : aabb;
			AABB aabb2 = aabb1.expandTowards(vec.x, maxUpStep(), vec.z);
			if(!groundcollision) aabb2 = aabb2.expandTowards(0D, -1E-5, 0D);
			List<VoxelShape> list1 = collectColliders(list, aabb2);
			float[] afloat = collectCandidateStepUpHeights(aabb1, list1, maxUpStep(), (float)vec3.y);
			for(float f1 : afloat) {
				Vec3 vec31 = collideWithShapes(new Vec3(vec.x, f1, vec.z), aabb1, list1);
				if(vec31.horizontalDistanceSqr() > vec3.horizontalDistanceSqr()) return vec31.add(0D, aabb1.minY - aabb.minY, 0D);
			}
		} return vec3;
	}
	public Vec3 getBlockCollisions(Vec3 vec, AABB collisionBox, AABB expandedBox, List<VoxelShape> potentialHits) {
		List<VoxelShape> list = collectColliders(potentialHits, expandedBox);
		return collideWithShapes(vec, collisionBox, list);
	}
	public List<VoxelShape> collectColliders(List<VoxelShape> collisions, AABB boundingBox) {
		ImmutableList.Builder<VoxelShape> builder = ImmutableList.builderWithExpectedSize(collisions.size() + 1);
		if(!collisions.isEmpty()) builder.addAll(collisions);
		WorldBorder worldborder = level().getWorldBorder();
		boolean flag = worldborder.isInsideCloseToBorder(this, boundingBox);
		if(flag) builder.add(worldborder.getCollisionShape());
		CollisionContext context = CollisionContext.of(this);
		VoxelShape entityShape = Shapes.create(boundingBox);
		final BlockGetter[] cachedBlockGetter = {null};
		final AtomicLong cachedBlockGetterPos = new AtomicLong(0L);
		BlockPos.betweenClosedStream(boundingBox).forEach((pos) -> {
			double x = pos.getX(), y = pos.getY(), z = pos.getZ();
			int i = SectionPos.blockToSectionCoord(x);
			int j = SectionPos.blockToSectionCoord(z);
			long k = ChunkPos.asLong(i, j);
			if(cachedBlockGetter[0] == null || cachedBlockGetterPos.get() != k) {
				BlockGetter blockgetter = level().getChunkForCollisions(i, j);
				cachedBlockGetter[0] = blockgetter;
				cachedBlockGetterPos.set(k);
			} if(cachedBlockGetter[0] == null) return;
			BlockState state = cachedBlockGetter[0].getBlockState(pos);
			if(!isTravelMedium(state)) {
				VoxelShape voxelshape = state.getCollisionShape(level(), pos, context);
				if(voxelshape == Shapes.block() && boundingBox.intersects(x, y, z, x + 1D, y + 1D, z + 1D)) builder.add(voxelshape.move(x, y, z));
				voxelshape = voxelshape.move(x, y, z);
				if(!voxelshape.isEmpty() && Shapes.joinIsNotEmpty(voxelshape, entityShape, BooleanOp.AND)) builder.add(voxelshape);
			}
		}); return builder.build();
	}
	//Copied and pasted from the private static classes in the Entity class
	public static float[] collectCandidateStepUpHeights(AABB box, List<VoxelShape> colliders, float deltaY, float maxUpStep) {
		FloatSet floatset = new FloatArraySet(4);
		for(VoxelShape voxelshape : colliders) for(double d0 : voxelshape.getCoords(Direction.Axis.Y)) {
			float f = (float) (d0 - box.minY);
			if(!(f < 0.0F) && f != maxUpStep) {
				if(f > deltaY) break;
				floatset.add(f);
			}
		} float[] afloat = floatset.toFloatArray();
		FloatArrays.unstableSort(afloat);
		return afloat;
	}
	public static Vec3 collideWithShapes(Vec3 deltaMovement, AABB entityBB, List<VoxelShape> shapes) {
		if(shapes.isEmpty()) return deltaMovement;
		else {
			double d0 = deltaMovement.x;
			double d1 = deltaMovement.y;
			double d2 = deltaMovement.z;
			if(d1 != 0D) {
				d1 = Shapes.collide(Direction.Axis.Y, entityBB, shapes, d1);
				if(d1 != 0D) entityBB = entityBB.move(0D, d1, 0D);
			} boolean flag = Math.abs(d0) < Math.abs(d2);
			if(flag && d2 != 0D) {
				d2 = Shapes.collide(Direction.Axis.Z, entityBB, shapes, d2);
				if(d2 != 0D) entityBB = entityBB.move(0D, 0D, d2);
			} if(d0 != 0D) {
				d0 = Shapes.collide(Direction.Axis.X, entityBB, shapes, d0);
				if(!flag && d0 != 0D) entityBB = entityBB.move(d0, 0D, 0D);
			} if(!flag && d2 != 0D) d2 = Shapes.collide(Direction.Axis.Z, entityBB, shapes, d2);
			return new Vec3(d0, d1, d2);
		}
	}
}