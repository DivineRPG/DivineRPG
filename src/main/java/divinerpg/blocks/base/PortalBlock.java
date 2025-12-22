package divinerpg.blocks.base;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import divinerpg.DivineRPG;
import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.*;
import divinerpg.util.UniversalPosition;
import divinerpg.world.placement.Surface;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.*;
import net.minecraft.resources.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.*;

import static divinerpg.registries.LevelRegistry.*;

public abstract class PortalBlock extends BaseEntityBlock implements Portal {
	public final ResourceKey<Level> rootDimension, chainDimension;
	public final Block frameBlock;
	public final ResourceLocation particleLocation;
	public SimpleParticleType particle;
	public PortalBlock(Properties properties, ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, Block frameBlock, ResourceLocation particle) {
		super(properties);
		this.rootDimension = rootDimension;
		this.chainDimension = chainDimension;
		this.frameBlock = frameBlock;
		particleLocation = particle;
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

		UniversalPosition origin = new UniversalPosition(level, pos), target = getTargetLocation(level, entity, pos);
		if(target == null) return null;
		ServerLevel targetLevel = target.level(level.getServer());
		BlockPos targetPosition = target.blockPos();
		for(int tries = 0; tries < 10; tries++) if(hasRoomForPortal(targetLevel, pos = applyPlacementLocationPreference(targetLevel, entity, targetPosition.offset((int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)), 0, (int)((entity.getRandom().nextFloat() - 0.5F) * (tries << 2)))))) break;
		targetPosition = placePortal(targetLevel, pos, axis);
		if(targetPosition == null) return null;
		target = new UniversalPosition(targetLevel.dimension(), targetPosition);
		linkPortals(level.getServer(), origin, target);
		return transitionTo(level.getServer(), entity, target);
	}
	public UniversalPosition getTargetLocation(ServerLevel source, Entity entity, BlockPos pos) {
		ResourceKey<Level> targetDimension = source.dimension() == rootDimension ? chainDimension : rootDimension;
		return new UniversalPosition(targetDimension, scalePosition(pos, source.dimensionType(), source.getServer().getLevel(targetDimension).dimensionType()));
	}
	/**
	 * Use this method to influence where in the world the portal should be placed.
	 * @param level the target level where the portal should get placed
	 * @param pos the initial position provided for location search
	 * @return the new preferred block position for where to place the portal
	 */
    @NotNull
	public BlockPos applyPlacementLocationPreference(ServerLevel level, Entity entity, BlockPos pos) {
        return defaultLocationPreferences(level, pos);
	}
    public static BlockPos defaultLocationPreferences(ServerLevel level, BlockPos pos) {
        ResourceKey<Level> d = level.dimension();
        MutableBlockPos m;
        if(d == EDEN || d == WILDWOOD || d == APALACHIA) m = Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, 127, 250, 0, level, level.getRandom(), pos).mutable();
        else if(d == MORTUM) m = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, 20, 125, 0, level, level.getRandom(), pos).mutable();
        else if(d == VETHEA) m = Surface.getSurface(Surface_Type.LOWEST_GROUND, Mode.FULL, -55, 32, 0, level, level.getRandom(), pos).mutable();
        else m = Surface.getSurface(Surface_Type.HIGHEST_GROUND, Mode.FULL, level.getMinBuildHeight() + 5, level.dimensionType().logicalHeight(), 0, level, level.getRandom(), pos).mutable();
        while(level.getBlockState(m).is(Blocks.WATER)) m.move(0, 1, 0);
        return m.move(0, -1, 0);
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
	public abstract BlockPos placePortal(ServerLevel level, BlockPos pos, Axis axis);
	public static BlockPos placeVanillaLookingPortal(ServerLevel level, BlockPos pos, BlockState frameBlock, BlockState portalBlock, Axis axis) {
		if(!level.ensureCanWrite(pos)) return null;
        Block p = portalBlock.getBlock();
        for(int x = -3; x < 4; x++) for(int y = -3; y < 4; y++) for(int z = -3; z < 4; z++) if(level.getBlockState(pos.offset(x, y, z)).is(p)) return pos.offset(x, y, z);
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
		return target.level(server).getBlockState(target.blockPos()).is(BlockTags.PORTALS);
	}
	public static BlockPos scalePosition(BlockPos pos, DimensionType originDimension, DimensionType targetDimension) {
		double scale = DimensionType.getTeleportationScale(originDimension, targetDimension);
		return new BlockPos((int) (pos.getX() * scale), pos.getZ(), (int) (pos.getZ() * scale));
	}
	public static DimensionTransition transitionTo(MinecraftServer server, Entity entity, UniversalPosition pos) {
		return new DimensionTransition(pos.level(server), pos.pos().add(.5, 0, .5), entity.getKnownMovement(), entity.getYRot(), entity.getXRot(), false, DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET));
	}
	public abstract void linkPortals(MinecraftServer server, UniversalPosition origin, UniversalPosition target);
	public static void spreadBlock(Level level, BlockState newState, BlockPos pos, Block spreadTarget, Axis axis) {
		BlockState state;
		if((state = level.getBlockState(pos)).is(spreadTarget) && !state.is(newState.getBlock())) {
			level.setBlock(pos, newState, UPDATE_KNOWN_SHAPE);
			spreadBlock(level, newState, pos.above(), spreadTarget, axis);
			spreadBlock(level, newState, pos.below(), spreadTarget, axis);
			spreadBlock(level, newState, pos.relative(axis, 1), spreadTarget, axis);
			spreadBlock(level, newState, pos.relative(axis, -1), spreadTarget, axis);
		} level.sendBlockUpdated(pos, spreadTarget.defaultBlockState(), newState, 3);
	}
	public abstract void connectTo(ServerLevel level, BlockPos pos, @NotNull UniversalPosition connection, Axis axis);
	public Axis checkForFrame(Level level, BlockPos pos) {
		Direction d = null;
		for(Direction di : Direction.values()) if(level.getBlockState(pos.relative(di)).is(frameBlock)) {
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
			if(state.is(frameBlock)) continue;
			if(state.isAir()) break;
			return false;
		} if(dir == d) return true;
		mut.move(d = dir);
		while(mut.distManhattan(pos) < 33 && !mut.equals(pos)) {
			if(!level.getBlockState(mut.relative(d.getCounterClockWise(axis == Axis.X ? Axis.Z : Axis.X))).is(frameBlock)) return false;
			do {
				state = level.getBlockState(mut.relative(dir));
				if(state.is(frameBlock)) continue;
				if(state.isAir()) {
					d = dir;
					break;
				} return false;
			} while((dir = dir.getClockWise(axis == Axis.X ? Axis.Z : Axis.X)) != d);
			mut.move(d);
		} return level.getBlockState(mut.relative(d.getCounterClockWise(axis == Axis.X ? Axis.Z : Axis.X))).is(frameBlock) && mut.equals(pos);
	}
	protected Direction lookForFrameBlock(Level level, BlockPos pos, Axis axis) {
		Direction d = axis == Axis.X ? Direction.EAST : Direction.SOUTH, dir = d;
		do {
			if(level.getBlockState(pos.relative(dir)).is(frameBlock)) return dir;
		} while((dir = dir.getClockWise(axis == Axis.X ? Axis.Z : Axis.X)) != d);
		return null;
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
	public abstract boolean isSupported(BlockState state, LevelReader level, BlockPos pos);
	public boolean supportedBy(BlockState state) {
		return state.is(BlockTags.PORTALS) || state.is(frameBlock);
	}
	@Override
    public int getPortalTransitionTime(ServerLevel level, Entity entity) {
        return entity instanceof Player player ? Math.max(1, level.getGameRules().getInt(player.getAbilities().invulnerable ? GameRules.RULE_PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.RULE_PLAYERS_NETHER_PORTAL_DEFAULT_DELAY)) : 0;
    }
	//the boring part
	public static final MapCodec<PortalBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(propertiesCodec(), ResourceLocation.CODEC.fieldOf("target_dimension").forGetter(PortalBlock::rootDimension), ResourceLocation.CODEC.fieldOf("chain_dimension").forGetter(PortalBlock::chainDimension), Block.CODEC.fieldOf("frame_block").forGetter(PortalBlock::frameBlock), ResourceLocation.CODEC.fieldOf("particle").forGetter(PortalBlock::particle)).apply(instance, SimplePortalBlock::new));
	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}
	public ResourceLocation rootDimension() {
		return rootDimension.location();
	}
	public ResourceLocation chainDimension() {
		return chainDimension.location();
	}
	public ResourceLocation particle() {
		return particleLocation;
	}
	public Block frameBlock() {
		return frameBlock;
	}
	@Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity.canUsePortal(true)) entity.setAsInsidePortal(this, pos);
    }
	@Override
    protected abstract void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder);
	@Override
	public boolean canBeReplaced(BlockState state, Fluid fluid) {
		return false;
	}
	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if(particleLocation != null) {
			if(particle == null) {
				particle = (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.get(particleLocation);
				if(particle == null) DivineRPG.LOGGER.warn("Null particle ResourceLocation");
			} level.addParticle(particle, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 0D, 0D, 0D);
		}
	}
}