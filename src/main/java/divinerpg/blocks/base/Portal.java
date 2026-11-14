package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.block_entities.block.PortalBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.utils.*;
import net.minecraft.core.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
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
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.level.redstone.Orientation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class Portal extends BaseEntityBlock implements DivinePortalLogic {
    public final ResourceKey<Level> rootDimension, chainDimension;
    public final Block frameBlock;
    public final Identifier particleLocation;
    public SimpleParticleType particle;
    public Portal(Properties properties, ResourceKey<Level> rootDimension, ResourceKey<Level> chainDimension, Block frameBlock, Identifier particle) {
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
    public TeleportTransition getSimpleConnection(ServerLevel level, Entity entity, BlockPos pos) {
        if(level.getBlockEntity(pos) instanceof PortalBlockEntity p && p.targetPosition != null) {
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
        BlockPos.MutableBlockPos m = center.mutable().move(-5, -2, -5);
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
                Direction.Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
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
    public static void placeVanillaLookingPortal(ServerLevel level, BlockPos pos, BlockState frameBlock, BlockState portalBlock, Direction.Axis axis, UniversalPosition link) {
        if(!level.ensureCanWrite(pos)) return;
        Direction.Axis other = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        BlockState air = Blocks.AIR.defaultBlockState();
        BlockPos.MutableBlockPos mut = below(pos.mutable());
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
    public static BlockPos.MutableBlockPos relative(BlockPos.MutableBlockPos pos, Direction.Axis axis, int amount) {return pos.move(axis.choose(amount, 0, 0), 0, axis.choose(0, 0, amount));}
    public static BlockPos.MutableBlockPos above(BlockPos.MutableBlockPos pos) {return pos.move(0, 1, 0);}
    public static BlockPos.MutableBlockPos below(BlockPos.MutableBlockPos pos) {return pos.move(0, -1, 0);}
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
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return isSupported(state, level, pos) ? state : Blocks.AIR.defaultBlockState();
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, Orientation orientation, boolean movedByPiston) {
        if(!isSupported(state, level, pos)) level.setBlock(pos, Blocks.AIR.defaultBlockState(), UPDATE_ALL);
        super.neighborChanged(state, level, pos, block, orientation, movedByPiston);
    }
    public abstract boolean isSupported(BlockState state, LevelReader level, BlockPos pos);
    public boolean supportedBy(BlockState state) {
        return state.is(BlockTags.PORTALS) || state.is(frameBlock);
    }
    //the boring part
    @Override public ResourceKey<Level> rootDimension() {
        return rootDimension;
    }
    public Identifier rootDimensionLocation() {return rootDimension.identifier();}
    public Identifier chainDimension() {
        return chainDimension.identifier();
    }
    public Identifier particle() {
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
                particle = (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.getValue(particleLocation);
                if(particle == null) DivineRPG.LOGGER.warn("Null particle ResourceLocation");
            } level.addParticle(particle, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 0D, 0D, 0D);
        }
    }
}