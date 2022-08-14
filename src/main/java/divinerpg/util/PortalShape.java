package divinerpg.util;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.state.properties.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

public class PortalShape {
    private static final AbstractBlock.IPositionPredicate FRAME = (p_242966_0_, p_242966_1_, p_242966_2_) -> {
        return p_242966_0_.isPortalFrame(p_242966_1_, p_242966_2_);
    };
    private final IWorld level;
    private final Direction.Axis axis;
    private final Direction rightDir;
    private int numPortalBlocks;
    @Nullable
    private BlockPos bottomLeft;
    private int height;
    private int width;
    private static Block portal, frame;

    public Optional<PortalShape> findEmptyPortalShape(IWorld p_242964_0_, BlockPos p_242964_1_, Direction.Axis p_242964_2_) {
        return findPortalShape(p_242964_0_, p_242964_1_, (p_242968_0_) -> {
            return p_242968_0_.isValid() && p_242968_0_.numPortalBlocks == 0;
        }, p_242964_2_);
    }

    public Optional<PortalShape> findPortalShape(IWorld p_242965_0_, BlockPos p_242965_1_, Predicate<PortalShape> p_242965_2_, Direction.Axis p_242965_3_) {
        Optional<PortalShape> optional = Optional.of(new PortalShape(p_242965_0_, p_242965_1_, p_242965_3_, this.portal, this.frame)).filter(p_242965_2_);
        if (optional.isPresent()) {
            return optional;
        } else {
            Direction.Axis direction$axis = p_242965_3_ == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            return Optional.of(new PortalShape(p_242965_0_, p_242965_1_, direction$axis, portal, frame)).filter(p_242965_2_);
        }
    }

    public PortalShape(IWorld world, BlockPos pos, Direction.Axis axis, Block portal, Block frame) {
        this.level = world;
        this.axis = axis;
        this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
        this.bottomLeft = this.calculateBottomLeft(pos);
        if (this.bottomLeft == null) {
            this.bottomLeft = pos;
            this.width = 1;
            this.height = 1;
        } else {
            this.width = this.calculateWidth();
            if (this.width > 0) {
                this.height = this.calculateHeight();
            }
        }
        this.portal=portal;
        this.frame=frame;
    }

    @Nullable
    private BlockPos calculateBottomLeft(BlockPos p_242971_1_) {
        for(int i = Math.max(0, p_242971_1_.getY() - 21); p_242971_1_.getY() > i && isEmpty(this.level.getBlockState(p_242971_1_.below())); p_242971_1_ = p_242971_1_.below()) {
        }

        Direction direction = this.rightDir.getOpposite();
        int j = this.getDistanceUntilEdgeAboveFrame(p_242971_1_, direction) - 1;
        return j < 0 ? null : p_242971_1_.relative(direction, j);
    }

    private int calculateWidth() {
        int i = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
        return i >= 2 && i <= 21 ? i : 0;
    }

    private int getDistanceUntilEdgeAboveFrame(BlockPos p_242972_1_, Direction p_242972_2_) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int i = 0; i <= 21; ++i) {
            blockpos$mutable.set(p_242972_1_).move(p_242972_2_, i);
            BlockState blockstate = this.level.getBlockState(blockpos$mutable);
            if (!isEmpty(blockstate)) {
                if (FRAME.test(blockstate, this.level, blockpos$mutable)) {
                    return i;
                }
                break;
            }

            BlockState blockstate1 = this.level.getBlockState(blockpos$mutable.move(Direction.DOWN));
            if (!FRAME.test(blockstate1, this.level, blockpos$mutable)) {
                break;
            }
        }

        return 0;
    }

    private int calculateHeight() {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int i = this.getDistanceUntilTop(blockpos$mutable);
        return i >= 3 && i <= 21 && this.hasTopFrame(blockpos$mutable, i) ? i : 0;
    }

    private boolean hasTopFrame(BlockPos.Mutable p_242970_1_, int p_242970_2_) {
        for(int i = 0; i < this.width; ++i) {
            BlockPos.Mutable blockpos$mutable = p_242970_1_.set(this.bottomLeft).move(Direction.UP, p_242970_2_).move(this.rightDir, i);
            if (!FRAME.test(this.level.getBlockState(blockpos$mutable), this.level, blockpos$mutable)) {
                return false;
            }
        }

        return true;
    }

    private int getDistanceUntilTop(BlockPos.Mutable p_242969_1_) {
        for(int i = 0; i < 21; ++i) {
            p_242969_1_.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
            if (!FRAME.test(this.level.getBlockState(p_242969_1_), this.level, p_242969_1_)) {
                return i;
            }

            p_242969_1_.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
            if (!FRAME.test(this.level.getBlockState(p_242969_1_), this.level, p_242969_1_)) {
                return i;
            }

            for(int j = 0; j < this.width; ++j) {
                p_242969_1_.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                BlockState blockstate = this.level.getBlockState(p_242969_1_);
                if (!isEmpty(blockstate)) {
                    return i;
                }

                if (blockstate.is(portal)) {
                    ++this.numPortalBlocks;
                }
            }
        }

        return 21;
    }

    private static boolean isEmpty(BlockState p_196900_0_) {
        return p_196900_0_.isAir() || p_196900_0_.is(BlockTags.FIRE) || p_196900_0_.is(portal);
    }

    public boolean isValid() {
        return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
    }

    public void createPortalBlocks() {
        BlockState blockstate = portal.defaultBlockState().setValue(NetherPortalBlock.AXIS, this.axis);
        BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach((p_242967_2_) -> {
            this.level.setBlock(p_242967_2_, blockstate, 18);
        });
    }

    public boolean isComplete() {
        return this.isValid() && this.numPortalBlocks == this.width * this.height;
    }

    public static Vector3d getRelativePosition(TeleportationRepositioner.Result p_242973_0_, Direction.Axis p_242973_1_, Vector3d p_242973_2_, EntitySize p_242973_3_) {
        double d0 = (double)p_242973_0_.axis1Size - (double)p_242973_3_.width;
        double d1 = (double)p_242973_0_.axis2Size - (double)p_242973_3_.height;
        BlockPos blockpos = p_242973_0_.minCorner;
        double d2;
        if (d0 > 0.0D) {
            float f = (float)blockpos.get(p_242973_1_) + p_242973_3_.width / 2.0F;
            d2 = MathHelper.clamp(MathHelper.inverseLerp(p_242973_2_.get(p_242973_1_) - (double)f, 0.0D, d0), 0.0D, 1.0D);
        } else {
            d2 = 0.5D;
        }

        double d4;
        if (d1 > 0.0D) {
            Direction.Axis direction$axis = Direction.Axis.Y;
            d4 = MathHelper.clamp(MathHelper.inverseLerp(p_242973_2_.get(direction$axis) - (double)blockpos.get(direction$axis), 0.0D, d1), 0.0D, 1.0D);
        } else {
            d4 = 0.0D;
        }

        Direction.Axis direction$axis1 = p_242973_1_ == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        double d3 = p_242973_2_.get(direction$axis1) - ((double)blockpos.get(direction$axis1) + 0.5D);
        return new Vector3d(d2, d4, d3);
    }

    public static PortalInfo createPortalInfo(ServerWorld world, TeleportationRepositioner.Result result, Direction.Axis axis, Vector3d pos,
                                              EntitySize size, Vector3d speed, float yRot, float xRot) {
        BlockPos blockpos = result.minCorner;
        BlockState blockstate = world.getBlockState(blockpos);
        Direction.Axis direction$axis = blockstate.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
        double d0 = (double) result.axis1Size;
        double d1 = (double) result.axis2Size;
        int i = axis == direction$axis ? 0 : 90;
        Vector3d vec3 = axis == direction$axis ? speed : new Vector3d(speed.z, speed.y, -speed.x);
        double d2 = (double) size.width / 2.0D + (d0 - (double) size.width) * pos.x();
        double d3 = (d1 - (double) size.height) * pos.y();
        double d4 = 0.5D + pos.z();
        boolean flag = direction$axis == Direction.Axis.X;
        Vector3d vec31 = new Vector3d((double) blockpos.getX() + (flag ? d2 : d4), (double) blockpos.getY() + d3,
                (double) blockpos.getZ() + (flag ? d4 : d2));
        return new PortalInfo(vec31, vec3, yRot + (float) i, xRot);
    }
}
