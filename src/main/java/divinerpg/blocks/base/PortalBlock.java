package divinerpg.blocks.base;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import divinerpg.DivineRPG;
import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.*;
import divinerpg.util.*;
import divinerpg.world.placement.Surface.*;
import net.minecraft.core.*;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.*;

import java.util.*;

public abstract class PortalBlock extends BaseEntityBlock implements DivinePortalLogic {
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
	@Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {DivinePortalLogic.super.entityInside(state, level, pos, entity);}
	@Override @Nullable
	public DimensionTransition getSimpleConnection(ServerLevel level, Entity entity, BlockPos pos) {
		if(level.getBlockEntity(pos) instanceof PortalBlockEntity p && p.hasTargetPos()) {
			UniversalPosition target = p.targetPosition;
			ServerLevel targetLevel = target.level(level.getServer());
			BlockPos targetPos = target.blockPos();
			if(targetLevel.getBlockState(targetPos).is(this)) return DivinePortalLogic.transitionTo(targetLevel, entity, targetPos);
		} return null;
	}
	@Override
	public UniversalPosition getTargetLocation(ServerLevel source, Entity entity, BlockPos pos) {
		ResourceKey<Level> targetDimension = source.dimension() == rootDimension ? chainDimension : rootDimension;
		return new UniversalPosition(targetDimension, DivinePortalLogic.scalePosition(pos, source.dimensionType(), source.getServer().getLevel(targetDimension).dimensionType()));
	}
	@Override @Nullable
	public BlockPos lookForNearbyPortal(ServerLevel level, Entity entity, BlockPos center) {
		MutableBlockPos m = center.mutable().move(-5, -2, -5);
		for(int x = 0; x < 11; x++) {
			for(int y = 0; y < 5; y++) {
				for(int z = 0; z < 11; z++) {
					if(level.getBlockState(m).is(this)) return m;
					m.move(0, 0, 1);
				} m.move(0, 1, -11);
			} m.move(1, -5, 0);
		} return null;
	}
	@Override public void link(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos) {
		link(originLevel, originPos, new UniversalPosition(targetLevel, targetPos), new ArrayList<>(9));
		link(targetLevel, targetPos, new UniversalPosition(originLevel, originPos), new ArrayList<>(9));
	}
	public void link(ServerLevel level, BlockPos pos, UniversalPosition link, List<BlockPos> updated) {
		if(updated.contains(pos)) return;
		BlockState state = level.getBlockState(pos);
		if(state.is(this) && level.getBlockEntity(pos) instanceof PortalBlockEntity p) {
			p.targetPosition = link;
			updated.add(pos);
			if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
				Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
				link(level, pos.above(), link, updated);
				link(level, pos.below(), link, updated);
				link(level, pos.relative(axis, 1), link, updated);
				link(level, pos.relative(axis, -1), link, updated);
			} else {
				link(level, pos.north(), link, updated);
				link(level, pos.south(), link, updated);
				link(level, pos.east(), link, updated);
				link(level, pos.west(), link, updated);
			}
		}
	}
	@Override public boolean hasSpace(ServerLevel level, BlockPos pos) {
		return level.getBlockState(pos.above()).isAir() && level.getBlockState(pos).isAir();
	}
	@Override
	public BlockPos placeAndLink(ServerLevel originLevel, BlockPos originPos, ServerLevel targetLevel, BlockPos targetPos, Entity entity) {
		BlockState state = originLevel.getBlockState(originPos);
		if(state.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
			placeVanillaLookingPortal(targetLevel, targetPos, frameBlock.defaultBlockState(), state, state.getValue(BlockStateProperties.HORIZONTAL_AXIS), new UniversalPosition(originLevel, originPos));
			link(originLevel, originPos, new UniversalPosition(targetLevel, targetPos), new ArrayList<>(9));
		} return targetPos;
	}
	public static void placeVanillaLookingPortal(ServerLevel level, BlockPos pos, BlockState frameBlock, BlockState portalBlock, Axis axis, UniversalPosition link) {
		if(!level.ensureCanWrite(pos)) return;
		Axis other = axis == Axis.X ? Axis.Z : Axis.X;
		BlockState air = Blocks.AIR.defaultBlockState();
		MutableBlockPos mut = below(pos.mutable());
		setBlock(level, relative(mut, axis, -1), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, relative(mut, axis, 1), frameBlock);
		setPortal(level, below(mut), portalBlock, link);
		setPortal(level, below(mut), portalBlock, link);
		setPortal(level, below(mut), portalBlock, link);
		setBlock(level, below(mut), frameBlock);
		if(level.getBlockState(relative(mut, other, 1)).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		setBlock(level, above(mut), air);
		setBlock(level, above(mut), air);
		setBlock(level, above(mut), air);
		setBlock(level, relative(mut, axis, 1), air);
		setBlock(level, below(mut), air);
		setBlock(level, below(mut), air);
		if(level.getBlockState(below(mut)).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		setBlock(level, relative(mut, other, -1), frameBlock);
		setBlock(level, relative(mut, axis, 1), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, above(mut), frameBlock);
		setBlock(level, relative(mut, axis, -1), frameBlock);
		setPortal(level, below(mut), portalBlock, link);
		setPortal(level, below(mut), portalBlock, link);
		setPortal(level, below(mut), portalBlock, link);
		setBlock(level, relative(mut, other, -1), air);
		if(level.getBlockState(below(mut)).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		if(level.getBlockState(relative(mut, axis, -1)).isAir()) level.setBlock(mut, frameBlock, UPDATE_KNOWN_SHAPE);
		setBlock(level, above(mut), air);
		setBlock(level, above(mut), air);
		setBlock(level, above(mut), air);
		setBlock(level, relative(mut, axis, 1), air);
		setBlock(level, below(mut), air);
	}
	public static MutableBlockPos relative(MutableBlockPos pos, Axis axis, int amount) {return pos.move(axis.choose(amount, 0, 0), 0, axis.choose(0, 0, amount));}
	public static MutableBlockPos above(MutableBlockPos pos) {return pos.move(0, 1, 0);}
	public static MutableBlockPos below(MutableBlockPos pos) {return pos.move(0, -1, 0);}
	public static void setBlock(ServerLevel level, BlockPos pos, BlockState state) {
		BlockState block = level.getBlockState(pos);
		if(state.isAir() || block.getBlock().defaultDestroyTime() > -1) level.setBlock(pos, state, UPDATE_KNOWN_SHAPE);
	}
	public static void setPortal(ServerLevel level, BlockPos pos, BlockState state, UniversalPosition link) {
		BlockState block = level.getBlockState(pos);
		if(state.isAir() || block.getBlock().defaultDestroyTime() > -1) {
			level.setBlock(pos, state, UPDATE_KNOWN_SHAPE);
			PortalBlockEntity portal = BlockEntityRegistry.PORTAL.get().create(pos, state);
			portal.targetPosition = link;
			level.setBlockEntity(portal);
		}
	}
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
	//the boring part
	public static final MapCodec<PortalBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(propertiesCodec(), ResourceLocation.CODEC.fieldOf("target_dimension").forGetter(PortalBlock::rootDimensionLocation), ResourceLocation.CODEC.fieldOf("chain_dimension").forGetter(PortalBlock::chainDimension), Block.CODEC.fieldOf("frame_block").forGetter(PortalBlock::frameBlock), ResourceLocation.CODEC.fieldOf("particle").forGetter(PortalBlock::particle)).apply(instance, SimplePortalBlock::new));
	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}
	@Override public ResourceKey<Level> rootDimension() {
		return rootDimension;
	}
	public ResourceLocation rootDimensionLocation() {return rootDimension.location();}
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