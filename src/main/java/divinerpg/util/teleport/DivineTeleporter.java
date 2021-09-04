package divinerpg.util.teleport;

import divinerpg.blocks.base.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.village.*;
import net.minecraft.world.*;
import net.minecraft.world.border.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.util.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

public class DivineTeleporter implements ITeleporter {
    public static DivineTeleporter INSTANCE = null;
    private static Block portal;
    private static Block frame;
    protected final ServerWorld world;
    private boolean hasFrame;
    private static PointOfInterestType point;

    public DivineTeleporter(ServerWorld worldIn, Block portal, Block frame, boolean hasFrame, PointOfInterestType point) {
        this.portal = portal;
        this.frame = frame;
        INSTANCE = this;
        this.world = worldIn;
        this.hasFrame = hasFrame;
        this.point = point;
    }

    public Optional<TeleportationRepositioner.Result> getExistingPortal(BlockPos pos) {
        PointOfInterestManager poiManager = this.world.getPoiManager();
        poiManager.ensureLoadedAndValid(this.world, pos, 128);
        Optional<PointOfInterest> optional = poiManager.getInSquare((poiType) ->
                poiType == point, pos, 128, PointOfInterestManager.Status.ANY).sorted(Comparator.<PointOfInterest>comparingDouble((poi) ->
                poi.getPos().distSqr(pos)).thenComparingInt((poi) ->
                poi.getPos().getY())).filter((poi) ->
                this.world.getBlockState(poi.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();
        return optional.map((poi) -> {
            BlockPos blockpos = poi.getPos();
            this.world.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, blockpos);
            BlockState blockstate = this.world.getBlockState(blockpos);
            return TeleportationRepositioner.getLargestRectangleAround(blockpos, blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) ->
                    this.world.getBlockState(posIn) == blockstate);
        });
    }

    public Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis) {
        Direction direction = Direction.get(Direction.AxisDirection.NEGATIVE, axis);
        double d0 = -1.0D;
        BlockPos blockpos = null;
        double d1 = -1.0D;
        BlockPos blockpos1 = null;
        WorldBorder worldborder = this.world.getWorldBorder();
        int dimensionLogicalHeight = this.world.getHeight() - 1;
        BlockPos.Mutable mutablePos = pos.mutable();

        for (BlockPos.Mutable blockpos$mutable1 : BlockPos.spiralAround(pos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(dimensionLogicalHeight, this.world.getHeight(Heightmap.Type.MOTION_BLOCKING, blockpos$mutable1.getX(), blockpos$mutable1.getZ()));
            if (worldborder.isWithinBounds(blockpos$mutable1) && worldborder.isWithinBounds(blockpos$mutable1.move(direction, 1))) {
                blockpos$mutable1.move(direction.getOpposite(), 1);

                for (int l = j; l >= 0; --l) {
                    blockpos$mutable1.setY(l);
                    if (this.world.isEmptyBlock(blockpos$mutable1)) {
                        int i1;
                        for (i1 = l; l > 0 && this.world.isEmptyBlock(blockpos$mutable1.move(Direction.DOWN)); --l) {
                        }

                        if (l + 4 <= dimensionLogicalHeight) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                blockpos$mutable1.setY(l);
                                if (this.checkRegionForPlacement(blockpos$mutable1, mutablePos, direction, 0)) {
                                    double d2 = pos.distSqr(blockpos$mutable1);
                                    if (this.checkRegionForPlacement(blockpos$mutable1, mutablePos, direction, -1) && this.checkRegionForPlacement(blockpos$mutable1, mutablePos, direction, 1) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockpos = blockpos$mutable1.immutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockpos1 = blockpos$mutable1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockpos = blockpos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockpos = (new BlockPos(pos.getX(), MathHelper.clamp(pos.getY(), 70, this.world.getHeight() - 10), pos.getZ())).immutable();
            Direction direction1 = direction.getClockWise();
            if (!worldborder.isWithinBounds(blockpos)) {
                return Optional.empty();
            }

            for (int l1 = -1; l1 < 2; ++l1) {
                for (int k2 = 0; k2 < 2; ++k2) {
                    for (int i3 = -1; i3 < 3; ++i3) {
                        BlockState blockstate1 = i3 < 0 ? frame.defaultBlockState() : Blocks.AIR.defaultBlockState();
                        mutablePos.setWithOffset(blockpos, k2 * direction.getStepX() + l1 * direction1.getStepX(), i3, k2 * direction.getStepZ() + l1 * direction1.getStepZ());
                        this.world.setBlockAndUpdate(mutablePos, blockstate1);
                    }
                }
            }
        }

        for (int k1 = -1; k1 < 3; ++k1) {
            for (int i2 = -1; i2 < 4; ++i2) {
                if (k1 == -1 || k1 == 2 || i2 == -1 || i2 == 3) {
                    mutablePos.setWithOffset(blockpos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                    this.world.setBlock(mutablePos, frame.defaultBlockState(), 3);
                }
            }
        }

        BlockState portal = this.portal.defaultBlockState().setValue(BlockModPortal.AXIS, axis);

        for (int j2 = 0; j2 < 2; ++j2) {
            for (int l2 = 0; l2 < 3; ++l2) {
                mutablePos.setWithOffset(blockpos, j2 * direction.getStepX(), l2, j2 * direction.getStepZ());
                this.world.setBlock(mutablePos, portal, 18);
            }
        }

        return Optional.of(new TeleportationRepositioner.Result(blockpos.immutable(), 2, 3));
    }

    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
        Direction direction = directionIn.getClockWise();

        for (int i = -1; i < 3; ++i) {
            for (int j = -1; j < 4; ++j) {
                offsetPos.setWithOffset(originalPos, directionIn.getStepX() * i + direction.getStepX() * offsetScale, j, directionIn.getStepZ() * i + direction.getStepZ() * offsetScale);
                if (j < 0 && !this.world.getBlockState(offsetPos).getMaterial().isSolid()) {
                    return false;
                }

                if (j >= 0 && !this.world.isEmptyBlock(offsetPos)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        boolean isntOverworld = destWorld.dimension() == world.dimension();
        if (entity.level.dimension() != world.dimension() && !isntOverworld) {
            return null;
        }
        else if(!this.hasFrame) {
            return new PortalInfo(new Vector3d(entity.getX(), 255D, entity.getZ()), Vector3d.ZERO, entity.yRot, entity.xRot);
        }
        else {
            WorldBorder border = destWorld.getWorldBorder();
            double minX = Math.max(-2.9999872E7D, border.getMinX() + 16.0D);
            double minZ = Math.max(-2.9999872E7D, border.getMinZ() + 16.0D);
            double maxX = Math.min(2.9999872E7D, border.getMaxX() - 16.0D);
            double maxZ = Math.min(2.9999872E7D, border.getMaxZ() - 16.0D);
            double coordinateDifference = DimensionType.getTeleportationScale(entity.level.dimensionType(), destWorld.dimensionType());
            BlockPos blockpos = new BlockPos(MathHelper.clamp(entity.getX() * coordinateDifference, minX, maxX), entity.getY(), MathHelper.clamp(entity.getZ() * coordinateDifference, minZ, maxZ));
            return this.getOrMakePortal(entity, blockpos).map((result) -> {
                BlockState blockstate = entity.level.getBlockState(entity.blockPosition());
                Direction.Axis axis;
                Vector3d vector3d;
                if (blockstate.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                    axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                    TeleportationRepositioner.Result rectangle = TeleportationRepositioner.getLargestRectangleAround(entity.blockPosition(), axis, 21, Direction.Axis.Y, 21, (pos) -> entity.level.getBlockState(pos) == blockstate);
                    vector3d = entity.getRelativePortalPosition(axis, rectangle);
                } else {
                    axis = Direction.Axis.X;
                    vector3d = new Vector3d(0.5D, 0.0D, 0.0D);
                }

                return PortalShape.createPortalInfo(destWorld, result, axis, vector3d, entity.getDimensions(entity.getPose()), entity.getDeltaMovement(), entity.yRot, entity.xRot);
            }).orElse(null);
        }
    }

    protected Optional<TeleportationRepositioner.Result> getOrMakePortal(Entity entity, BlockPos pos) {
        Optional<TeleportationRepositioner.Result> existingPortal = this.getExistingPortal(pos);
        if (existingPortal.isPresent()) {
            return existingPortal;
        }
        else {
            Direction.Axis portalAxis = this.world.getBlockState(entity.blockPosition()).getOptionalValue(BlockModPortal.AXIS).orElse(Direction.Axis.X);
            Optional<TeleportationRepositioner.Result> makePortal = this.makePortal(pos, portalAxis);
            if (!makePortal.isPresent()) {
            }

            return makePortal;
        }
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity.setPortalCooldown();
        return ITeleporter.super.placeEntity(entity, currentWorld, destWorld, yaw, repositionEntity);
    }
}