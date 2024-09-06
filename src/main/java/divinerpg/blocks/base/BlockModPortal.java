package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.BlockUtil;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.village.poi.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.portal.*;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.Optional;

import javax.annotation.Nullable;

public class BlockModPortal extends NetherPortalBlock {
	public final ResourceKey<Level> dimension;
	public final ResourceKey<PoiType> poi;
	public final Block block;
	public BlockModPortal(ResourceKey<Level> dimension, ResourceKey<PoiType> poi, Block block) {
		super(BlockBehaviour.Properties.of().noCollission().strength(-1.0F).sound(SoundType.GLASS).lightLevel(p_50870_ -> 11).pushReaction(PushReaction.BLOCK));
		this.dimension = dimension;
		this.poi = poi;
		this.block = block;
	}
	protected BlockModPortal(ResourceKey<Level> dimension, Block block) {
		this(dimension, null, block);
	}
	@Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {}
	@Override @Nullable
	public DimensionTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
		ResourceKey<Level> resourcekey = level.dimension() == dimension ? Level.OVERWORLD : dimension;
        ServerLevel serverlevel = level.getServer().getLevel(resourcekey);
        if(serverlevel == null) return null;
        WorldBorder worldborder = serverlevel.getWorldBorder();
        double d0 = DimensionType.getTeleportationScale(level.dimensionType(), serverlevel.dimensionType());
        BlockPos blockpos = worldborder.clampToBounds(entity.getX() * d0, entity.getY(), entity.getZ() * d0);
        return getExitPortal(serverlevel, entity, pos, blockpos, worldborder);
	}
	@Nullable
    protected DimensionTransition getExitPortal(ServerLevel level, Entity entity, BlockPos pos, BlockPos exitPos, WorldBorder worldBorder) {
        Optional<BlockPos> optional = findClosestPortalPosition(exitPos, worldBorder, level);
        BlockUtil.FoundRectangle blockutil$foundrectangle;
        DimensionTransition.PostDimensionTransition dimensiontransition$postdimensiontransition;
        if(optional.isPresent()) {
            BlockPos blockpos = optional.get();
            BlockState blockstate = level.getBlockState(blockpos);
            blockutil$foundrectangle = BlockUtil.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, p_351970_ -> level.getBlockState(p_351970_) == blockstate);
            dimensiontransition$postdimensiontransition = DimensionTransition.PLAY_PORTAL_SOUND.then(p_351967_ -> p_351967_.placePortalTicket(blockpos));
        } else {
            Direction.Axis direction$axis = entity.level().getBlockState(pos).getOptionalValue(AXIS).orElse(Direction.Axis.X);
            Optional<BlockUtil.FoundRectangle> optional1 = createPortal(exitPos, direction$axis, level);
            if(optional1.isEmpty()) {
            	DivineRPG.LOGGER.error("Unable to create a portal, likely target out of worldborder");
                return null;
            } blockutil$foundrectangle = optional1.get();
            dimensiontransition$postdimensiontransition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        } return getDimensionTransitionFromExit(entity, pos, blockutil$foundrectangle, level, dimensiontransition$postdimensiontransition);
    }
	public boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos, ServerLevel level) {
        BlockState blockstate = level.getBlockState(pos);
        return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
    }
	@SuppressWarnings("deprecation")
	public boolean canHostFrame(BlockPos originalPos, BlockPos.MutableBlockPos offsetPos, Direction p_direction, int offsetScale, ServerLevel level) {
        Direction direction = p_direction.getClockWise();
        for(int i = -1; i < 3; i++) for (int j = -1; j < 4; j++) {
            offsetPos.setWithOffset(originalPos, p_direction.getStepX() * i + direction.getStepX() * offsetScale, j, p_direction.getStepZ() * i + direction.getStepZ() * offsetScale);
            if(j < 0 && !level.getBlockState(offsetPos).isSolid()) return false;
            if(j >= 0 && !canPortalReplaceBlock(offsetPos, level)) return false;
        } return true;
    }
	public Optional<BlockUtil.FoundRectangle> createPortal(BlockPos pos, Direction.Axis axis, ServerLevel level) {
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, axis);
        double d0 = -1.0, d1 = d0;
        BlockPos blockpos = null, blockpos1 = null;
        WorldBorder worldborder = level.getWorldBorder();
        int i = Math.min(level.getMaxBuildHeight(), level.getMinBuildHeight() + level.getLogicalHeight()) - 1;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();
        for(BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int k = Math.min(i, level.getHeight(Heightmap.Types.MOTION_BLOCKING, blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getZ()));
            if(worldborder.isWithinBounds(blockpos$mutableblockpos1) && worldborder.isWithinBounds(blockpos$mutableblockpos1.move(direction, 1))) {
                blockpos$mutableblockpos1.move(direction.getOpposite(), 1);
                for(int l = k; l >= level.getMinBuildHeight(); l--) {
                    blockpos$mutableblockpos1.setY(l);
                    if(canPortalReplaceBlock(blockpos$mutableblockpos1, level)) {
                        int i1 = l;
                        while(l > level.getMinBuildHeight() && canPortalReplaceBlock(blockpos$mutableblockpos1.move(Direction.DOWN), level)) l--;
                        if(l + 4 <= i) {
                            int j1 = i1 - l;
                            if(j1 <= 0 || j1 >= 3) {
                                blockpos$mutableblockpos1.setY(l);
                                if(canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 0, level)) {
                                    double d2 = pos.distSqr(blockpos$mutableblockpos1);
                                    if(canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, -1, level) && canHostFrame(blockpos$mutableblockpos1, blockpos$mutableblockpos, direction, 1, level) && (d0 == -1.0 || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = blockpos$mutableblockpos1.immutable();
                                    } if(d0 == -1.0 && (d1 == -1.0 || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = blockpos$mutableblockpos1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } if(d0 == -1.0 && d1 != -1.0) {
            blockpos = blockpos1;
            d0 = d1;
        } if(d0 == -1.0) {
            int k1 = Math.max(level.getMinBuildHeight() - -1, 70), i2 = i - 9;
            if(i2 < k1) return Optional.empty();
            blockpos = new BlockPos(pos.getX() - direction.getStepX() * 1, Mth.clamp(pos.getY(), k1, i2), pos.getZ() - direction.getStepZ() * 1).immutable();
            blockpos = worldborder.clampToBounds(blockpos);
            Direction direction1 = direction.getClockWise();
            for(int i3 = -1; i3 < 2; i3++) for(int j3 = 0; j3 < 2; j3++) for(int k3 = -1; k3 < 3; k3++) {
                BlockState blockstate1 = k3 < 0 ? block.defaultBlockState() : Blocks.AIR.defaultBlockState();
                blockpos$mutableblockpos.setWithOffset(blockpos, j3 * direction.getStepX() + i3 * direction1.getStepX(), k3, j3 * direction.getStepZ() + i3 * direction1.getStepZ());
                level.setBlockAndUpdate(blockpos$mutableblockpos, blockstate1);
            }
        } for(int l1 = -1; l1 < 3; l1++) for(int j2 = -1; j2 < 4; j2++) if(l1 == -1 || l1 == 2 || j2 == -1 || j2 == 3) {
            blockpos$mutableblockpos.setWithOffset(blockpos, l1 * direction.getStepX(), j2, l1 * direction.getStepZ());
            level.setBlock(blockpos$mutableblockpos, block.defaultBlockState(), 3);
        } BlockState blockstate = defaultBlockState().setValue(NetherPortalBlock.AXIS, axis);
        for(int k2 = 0; k2 < 2; k2++) for(int l2 = 0; l2 < 3; l2++) {
            blockpos$mutableblockpos.setWithOffset(blockpos, k2 * direction.getStepX(), l2, k2 * direction.getStepZ());
            level.setBlock(blockpos$mutableblockpos, blockstate, 18);
        } return Optional.of(new BlockUtil.FoundRectangle(blockpos.immutable(), 2, 3));
    }
	public Optional<BlockPos> findClosestPortalPosition(BlockPos exitPos, WorldBorder worldBorder, ServerLevel level) {
        PoiManager poimanager = level.getPoiManager();
        int i = 128;
        poimanager.ensureLoadedAndValid(level, exitPos, i);
        return poimanager.getInSquare(p_230634_ -> p_230634_.is(poi), exitPos, i, PoiManager.Occupancy.ANY).map(PoiRecord::getPos).filter(worldBorder::isWithinBounds)
            .filter(p_352047_ -> level.getBlockState(p_352047_).hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
            .min(Comparator.<BlockPos>comparingDouble(p_352046_ -> p_352046_.distSqr(exitPos)).thenComparingInt(Vec3i::getY));
    }
	protected DimensionTransition getDimensionTransitionFromExit(Entity entity, BlockPos pos, BlockUtil.FoundRectangle rectangle, ServerLevel level, DimensionTransition.PostDimensionTransition postDimensionTransition) {
        BlockState blockstate = entity.level().getBlockState(pos);
        Direction.Axis direction$axis;
        Vec3 vec3;
        if(blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            BlockUtil.FoundRectangle blockutil$foundrectangle = BlockUtil.getLargestRectangleAround(pos, direction$axis, 21, Direction.Axis.Y, 21, p_351016_ -> entity.level().getBlockState(p_351016_) == blockstate);
            vec3 = entity.getRelativePortalPosition(direction$axis, blockutil$foundrectangle);
        } else {
            direction$axis = Direction.Axis.X;
            vec3 = new Vec3(0.5, 0.0, 0.0);
        } return createDimensionTransition(level, rectangle, direction$axis, vec3, entity, entity.getDeltaMovement(), entity.getYRot(), entity.getXRot(), postDimensionTransition);
    }
	protected DimensionTransition createDimensionTransition(ServerLevel level, BlockUtil.FoundRectangle rectangle, Direction.Axis axis, Vec3 offset, Entity entity, Vec3 speed, float yRot, float xRot, DimensionTransition.PostDimensionTransition postDimensionTransition) {
        BlockPos blockpos = rectangle.minCorner;
        BlockState blockstate = level.getBlockState(blockpos);
        Direction.Axis direction$axis = blockstate.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
        double d0 = rectangle.axis1Size, d1 = rectangle.axis2Size;
        EntityDimensions entitydimensions = entity.getDimensions(entity.getPose());
        int i = axis == direction$axis ? 0 : 90;
        Vec3 vec3 = axis == direction$axis ? speed : new Vec3(speed.z, speed.y, -speed.x);
        double d2 = entitydimensions.width() / 2.0 + (d0 - entitydimensions.width()) * offset.x(), d3 = (d1 - entitydimensions.height()) * offset.y(), d4 = 0.5 + offset.z();
        boolean flag = direction$axis == Direction.Axis.X;
        Vec3 vec31 = new Vec3(blockpos.getX() + (flag ? d2 : d4), blockpos.getY() + d3, blockpos.getZ() + (flag ? d4 : d2)), vec32 = PortalShape.findCollisionFreePosition(vec31, level, entity, entitydimensions);
        return new DimensionTransition(level, vec32, vec3, yRot + i, xRot, postDimensionTransition);
    }
	@Override
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
		if(random.nextInt(100) == 0) level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
	}
}