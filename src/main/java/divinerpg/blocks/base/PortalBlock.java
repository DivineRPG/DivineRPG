package divinerpg.blocks.base;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.*;

public class PortalBlock extends BaseEntityBlock implements Portal {
	public static final TagKey<Block> portalTag = TagKey.create(Registries.BLOCK, ResourceLocation.parse("c:portals"));
	public static final VoxelShape X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0), Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);
	public final ResourceKey<Level> rootDimension;
	public final TagKey<Block> frameTag;
	public PortalBlock(Properties properties, ResourceKey<Level> rootDimension, TagKey<Block> frameTag) {
		super(properties);
		this.rootDimension = rootDimension;
		this.frameTag = frameTag;
		registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
	}
	public PortalBlock(Properties properties, ResourceLocation rootDimension, TagKey<Block> frameTag) {
		this(properties, ResourceKey.create(Registries.DIMENSION, rootDimension), frameTag);
	}
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityRegistry.PORTAL.get().create(pos, state);
	}
	/**
	 * Triggers the portal logic, constructs a new portal if necessary and creates the Dimension Transition record
	 */
	@Override
	public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
		if(hasConnection(level, pos)) return transitionTo(level.getServer(), entity, ((PortalBlockEntity)level.getBlockEntity(pos)).targetPosition);
//		DivineRPG.LOGGER.info("No Connection Present. Creating new Portal.");
		BlockState state = level.getBlockState(pos);
		Axis axis = state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS) ? state.getValue(BlockStateProperties.HORIZONTAL_AXIS) : null;
		ResourceKey<Level> targetDimension = level.dimension() == rootDimension ? Level.OVERWORLD : rootDimension;
		ServerLevel targetLevel = level.getServer().getLevel(targetDimension);
		BlockPos targetPosition = UniversalPosition.toBlockPos(scalePosition(entity.position(), level.dimensionType(), targetLevel.dimensionType()));
		UniversalPosition origin = new UniversalPosition(level, pos);
		pos = targetPosition;
		for(int tries = 0; tries < 10; tries++) {
			pos = applyPlacementLocationPreference(targetLevel, entity, pos);
			if(hasRoomForPortal(targetLevel, pos)) break;
			if(tries == 9) pos = targetPosition;
			else pos = targetPosition.offset((int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)), 0, (int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)));
		} targetPosition = placePortal(targetLevel, pos, axis);
		if(targetPosition == null) return null;
		UniversalPosition target = new UniversalPosition(targetDimension, targetPosition);
		linkPortals(level.getServer(), origin, target);
		return transitionTo(level.getServer(), entity, target);
	}
	/**
	 * Use this method to influence where in the world the portal should be placed.
	 * @param level the target level where the portal should get placed
	 * @param pos the initial position provided for location search
	 * @return the new preferred block position for where to place the portal
	 */
	public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
		return new BlockPos(pos.getX(), Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, level.getMinBuildHeight(), level.dimensionType().logicalHeight(), 0, level, level.getRandom(), pos.getX(), pos.getZ()), pos.getZ());
	}
	public boolean hasRoomForPortal(ServerLevel level, BlockPos pos) {
		pos = pos.above();
		return level.getBlockState(pos.above()).isAir() && level.getBlockState(pos.north()).isAir() && level.getBlockState(pos.east()).isAir() && level.getBlockState(pos.south()).isAir() && level.getBlockState(pos.west()).isAir();
	}
	/**
	 * 
	 * @param level the world where the portal gets placed
	 * @param pos the portal placement location
	 * @param axis the portal axis
	 * @return position where to teleport the entity to. Returns {@code null} if the portal placement failed.
	 */
	public BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis) {return null;}
	public static BlockPos placeVanillaLookingPortal(ServerLevel level, BlockPos pos, BlockState frameBlock, BlockState portalBlock, Axis axis) {
		if(!level.ensureCanWrite(pos)) return null;
		Axis other = axis == Axis.X ? Axis.Z : Axis.X;
		BlockState air = Blocks.AIR.defaultBlockState();
		MutableBlockPos mut = pos.mutable();
		setBlock(level, mut, frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.set(mut.relative(axis, 1)), frameBlock);
		setBlock(level, mut.move(Direction.DOWN), portalBlock);
		setBlock(level, mut.move(Direction.DOWN), portalBlock);
		setBlock(level, mut.move(Direction.DOWN), portalBlock);
		setBlock(level, mut.move(Direction.DOWN), frameBlock);
		if(level.getBlockState(mut.set(mut.relative(other, 1))).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		setBlock(level, mut.move(Direction.UP), air);
		setBlock(level, mut.move(Direction.UP), air);
		setBlock(level, mut.move(Direction.UP), air);
		setBlock(level, mut.set(mut.relative(axis, 1)), air);
		setBlock(level, mut.move(Direction.DOWN), air);
		setBlock(level, mut.move(Direction.DOWN), air);
		if(level.getBlockState(mut.move(Direction.DOWN)).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		setBlock(level, mut.set(mut.relative(other, -1)), frameBlock);
		setBlock(level, mut.set(mut.relative(axis, 1)), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.move(Direction.UP), frameBlock);
		setBlock(level, mut.set(mut.relative(axis, -1)), frameBlock);
		setBlock(level, mut.move(Direction.DOWN), portalBlock);
		setBlock(level, mut.move(Direction.DOWN), portalBlock);
		setBlock(level, mut.move(Direction.DOWN), portalBlock);
		setBlock(level, mut.set(mut.relative(other, -1)), air);
		if(level.getBlockState(mut.move(Direction.DOWN)).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		if(level.getBlockState(mut.set(mut.relative(axis, -1))).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		setBlock(level, mut.move(Direction.UP), air);
		setBlock(level, mut.move(Direction.UP), air);
		setBlock(level, mut.move(Direction.UP), air);
		setBlock(level, mut.set(mut.relative(axis, 1)), air);
		setBlock(level, mut.move(Direction.DOWN), air);
		return mut.set(mut.relative(other, 1).below());
	}
	public static void setBlock(ServerLevel level, BlockPos pos, BlockState state) {
		BlockState block = level.getBlockState(pos);
		if(state.isAir() || block.getBlock().defaultDestroyTime() > -1) {
			level.setBlock(pos, state, UPDATE_KNOWN_SHAPE);
			if(state.getBlock() instanceof PortalBlock) level.setBlockEntity(BlockEntityRegistry.PORTAL.get().create(pos, state));
		}
	}
	public static boolean hasConnection(ServerLevel level, BlockPos pos) {
		return level.getBlockEntity(pos) instanceof PortalBlockEntity p && p.hasTargetPos() && hasPortal(level.getServer(), p.targetPosition);
	}
	public static boolean hasPortal(MinecraftServer server, UniversalPosition target) {
		return target.level(server).getBlockState(target.blockPos()).is(portalTag);
	}
	public static Vec3 scalePosition(Vec3 pos, DimensionType originDimension, DimensionType targetDimension) {
		double scale = DimensionType.getTeleportationScale(originDimension, targetDimension);
		return new Vec3(pos.x * scale, pos.y, pos.z * scale);
	}
	public static DimensionTransition transitionTo(MinecraftServer server, Entity entity, UniversalPosition pos) {
		return new DimensionTransition(pos.level(server), pos.pos(), entity.getKnownMovement(), entity.getYRot(), entity.getXRot(), false, DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET));
	}
	public void linkPortals(MinecraftServer server, UniversalPosition origin, UniversalPosition target) {
		if(!hasPortal(server, origin) || !hasPortal(server, target)) {
//			DivineRPG.LOGGER.error("portal linking failed");
			return;
		} ServerLevel level = origin.level(server);
		BlockPos pos = origin.blockPos();
		connectTo(level, pos, target, level.getBlockState(pos).getValue(BlockStateProperties.HORIZONTAL_AXIS));
		level = target.level(server);
		pos = target.blockPos();
		connectTo(level, pos, origin, level.getBlockState(pos).getValue(BlockStateProperties.HORIZONTAL_AXIS));
//		DivineRPG.LOGGER.info("portal linking succeeded");
	}
	public static void spreadBlock(Level level, BlockState newState, BlockPos pos, Block spreadTarget, Axis axis) {
		BlockState state;
		if((state = level.getBlockState(pos)).is(spreadTarget) && !state.is(newState.getBlock())) {
			level.setBlock(pos, newState, UPDATE_ALL);
			spreadBlock(level, newState, pos.above(), spreadTarget, axis);
			spreadBlock(level, newState, pos.below(), spreadTarget, axis);
			spreadBlock(level, newState, pos.relative(axis, 1), spreadTarget, axis);
			spreadBlock(level, newState, pos.relative(axis, -1), spreadTarget, axis);
		}
	}
	public void connectTo(ServerLevel level, BlockPos pos, @NotNull UniversalPosition connection, Axis axis) {
		if(level.getBlockEntity(pos) instanceof PortalBlockEntity portal && connection != portal.targetPosition && !connection.equals(portal.targetPosition)) {
			portal.targetPosition = connection;
			connectTo(level, pos.above(), connection, axis);
			connectTo(level, pos.below(), connection, axis);
			connectTo(level, pos.relative(axis, 1), connection, axis);
			connectTo(level, pos.relative(axis, -1), connection, axis);
		}
	}
	public Axis checkForFrame(Level level, BlockPos pos) {
		Direction d = null;
		for(Direction di : Direction.values()) if(level.getBlockState(pos.relative(di)).is(frameTag)) {
			d = di;
			break;
		} if(d == null) return null;
		return travel(level, pos, Axis.X) ? Axis.X : (travel(level, pos, Axis.Z) ? Axis.Z : null);
	}
	protected boolean travel(Level level, BlockPos pos, Axis axis) {
		Direction d = lookForFrameBlock(level, pos, axis), dir = d;
		if(d == null) return false;
		BlockState state;
		MutableBlockPos mut = pos.mutable();
		while((dir = dir.getClockWise(axis == Axis.X ? Axis.Z : Axis.X)) != d) {
			state = level.getBlockState(mut.relative(dir));
			if(state.is(frameTag)) continue;
			if(state.isAir()) break;
			return false;
		} if(dir == d) return true;
		mut.move(d = dir);
		while(mut.distManhattan(pos) < 33 && !mut.equals(pos)) {
			if(!level.getBlockState(mut.relative(d.getCounterClockWise(axis == Axis.X ? Axis.Z : Axis.X))).is(frameTag)) return false;
			do {
				state = level.getBlockState(mut.relative(dir));
				if(state.is(frameTag)) continue;
				if(state.isAir()) {
					d = dir;
					break;
				} return false;
			} while((dir = dir.getClockWise(axis == Axis.X ? Axis.Z : Axis.X)) != d);
			mut.move(d);
		} return mut.equals(pos);
	}
	protected Direction lookForFrameBlock(Level level, BlockPos pos, Axis axis) {
		Direction d = axis == Axis.X ? Direction.EAST : Direction.SOUTH, dir = d;
		do {
			if(level.getBlockState(pos.relative(dir)).is(frameTag)) return dir;
		} while((dir = dir.getClockWise(axis == Axis.X ? Axis.Z : Axis.X)) != d);
		return null;
	}
	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
		return rotate(defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, context.getHorizontalDirection().getAxis()), Rotation.CLOCKWISE_90);
	}
	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	@Override
	protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
		return isSupported(state, level, pos) ? state : Blocks.AIR.defaultBlockState();
	}
	@Override
	protected void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
		if(!isSupported(pState, pLevel, pPos)) pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), UPDATE_ALL);
		else super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
	}
	public boolean isSupported(BlockState state, LevelReader level, BlockPos pos) {
		Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
		return supportedBy(level.getBlockState(pos.above())) && supportedBy(level.getBlockState(pos.below())) && supportedBy(level.getBlockState(pos.relative(axis, 1))) && supportedBy(level.getBlockState(pos.relative(axis, -1)));
	}
	public boolean supportedBy(BlockState state) {
		return state.is(portalTag) || state.is(frameTag);
	}
	@Override
    public int getPortalTransitionTime(ServerLevel level, Entity entity) {
        return entity instanceof Player player ? Math.max(1, level.getGameRules().getInt(player.getAbilities().invulnerable ? GameRules.RULE_PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.RULE_PLAYERS_NETHER_PORTAL_DEFAULT_DELAY)) : 0;
    }
	//the boring part
	public static final MapCodec<PortalBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(propertiesCodec(), ResourceLocation.CODEC.fieldOf("target_dimension").forGetter(PortalBlock::rootDimension), TagKey.codec(Registries.BLOCK).fieldOf("target_position").forGetter(PortalBlock::frameTag)).apply(instance, PortalBlock::new));
	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}
	public ResourceLocation rootDimension() {
		return rootDimension.location();
	}
	public TagKey<Block> frameTag() {
		return frameTag;
	}
	@Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity.canUsePortal(true)) entity.setAsInsidePortal(this, pos);
    }
	@Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(BlockStateProperties.HORIZONTAL_AXIS) == Axis.Z ? Z_AXIS_AABB : X_AXIS_AABB;
    }
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_AXIS);
    }
	@Override
	public boolean canBeReplaced(BlockState state, Fluid fluid) {
		return false;
	}
	@Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return switch (rot) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(BlockStateProperties.HORIZONTAL_AXIS)) {
                case Z -> state.setValue(BlockStateProperties.HORIZONTAL_AXIS, Axis.X);
                case X -> state.setValue(BlockStateProperties.HORIZONTAL_AXIS, Axis.Z);
                default -> state;
            };
            default -> state;
        };
    }
}