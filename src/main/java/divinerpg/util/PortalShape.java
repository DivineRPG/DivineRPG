package divinerpg.util;

import net.minecraft.*;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.portal.*;
import net.minecraft.world.phys.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

public class PortalShape {
    private static final BlockBehaviour.StatePredicate FRAME = (p_242966_0_, p_242966_1_, p_242966_2_) -> {
        return p_242966_0_.isPortalFrame(p_242966_1_, p_242966_2_);
    };
    private static Block portal, frame;
    private final LevelAccessor level;
    private final Direction.Axis axis;
    private final Direction rightDir;
    private int numPortalBlocks;
    @Nullable
    private BlockPos bottomLeft;
    private int height;
    private final int width;

    public PortalShape(LevelAccessor world, BlockPos pos, Direction.Axis axis, Block portal, Block frame) {
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
        PortalShape.portal = portal;
        PortalShape.frame = frame;
    }

    private static boolean isEmpty(BlockState p_196900_0_) {
        return p_196900_0_.isAir() || p_196900_0_.is(BlockTags.FIRE) || p_196900_0_.is(portal);
    }

    public static Vec3 getRelativePosition(BlockUtil.FoundRectangle p_242973_0_, Direction.Axis p_242973_1_, Vec3 p_242973_2_, EntityDimensions p_242973_3_) {
        double d0 = (double) p_242973_0_.axis1Size - (double) p_242973_3_.width;
        double d1 = (double) p_242973_0_.axis2Size - (double) p_242973_3_.height;
        BlockPos blockpos = p_242973_0_.minCorner;
        double d2;
        if (d0 > 0.0D) {
            float f = (float) blockpos.get(p_242973_1_) + p_242973_3_.width / 2.0F;
            d2 = Mth.clamp(Mth.inverseLerp(p_242973_2_.get(p_242973_1_) - (double) f, 0.0D, d0), 0.0D, 1.0D);
        } else {
            d2 = 0.5D;
        }

        double d4;
        if (d1 > 0.0D) {
            Direction.Axis direction$axis = Direction.Axis.Y;
            d4 = Mth.clamp(Mth.inverseLerp(p_242973_2_.get(direction$axis) - (double) blockpos.get(direction$axis), 0.0D, d1), 0.0D, 1.0D);
        } else {
            d4 = 0.0D;
        }

        Direction.Axis direction$axis1 = p_242973_1_ == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        double d3 = p_242973_2_.get(direction$axis1) - ((double) blockpos.get(direction$axis1) + 0.5D);
        return new Vec3(d2, d4, d3);
    }

    public static PortalInfo createPortalInfo(ServerLevel p_242963_0_, BlockUtil.FoundRectangle p_242963_1_, Direction.Axis p_242963_2_, Vec3 p_242963_3_, EntityDimensions p_242963_4_, Vec3 p_242963_5_, float p_242963_6_, float p_242963_7_) {
        BlockPos blockpos = p_242963_1_.minCorner;
        BlockState blockstate = p_242963_0_.getBlockState(blockpos);
        Direction.Axis direction$axis = blockstate.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        double d0 = p_242963_1_.axis1Size;
        double d1 = p_242963_1_.axis2Size;
        int i = p_242963_2_ == direction$axis ? 0 : 90;
        Vec3 vector3d = p_242963_2_ == direction$axis ? p_242963_5_ : new Vec3(p_242963_5_.z, p_242963_5_.y, -p_242963_5_.x);
        double d2 = (double) p_242963_4_.width / 2.0D + (d0 - (double) p_242963_4_.width) * p_242963_3_.x();
        double d3 = (d1 - (double) p_242963_4_.height) * p_242963_3_.y();
        double d4 = 0.5D + p_242963_3_.z();
        boolean flag = direction$axis == Direction.Axis.X;
        Vec3 vector3d1 = new Vec3((double) blockpos.getX() + (flag ? d2 : d4), (double) blockpos.getY() + d3, (double) blockpos.getZ() + (flag ? d4 : d2));
        return new PortalInfo(vector3d1, vector3d, p_242963_6_ + (float) i, p_242963_7_);
    }

    public Optional<PortalShape> findEmptyPortalShape(LevelAccessor p_242964_0_, BlockPos p_242964_1_, Direction.Axis p_242964_2_) {
        return findPortalShape(p_242964_0_, p_242964_1_, (p_242968_0_) -> {
            return p_242968_0_.isValid() && p_242968_0_.numPortalBlocks == 0;
        }, p_242964_2_);
    }

    public Optional<PortalShape> findPortalShape(LevelAccessor p_242965_0_, BlockPos p_242965_1_, Predicate<PortalShape> p_242965_2_, Direction.Axis p_242965_3_) {
        Optional<PortalShape> optional = Optional.of(new PortalShape(p_242965_0_, p_242965_1_, p_242965_3_, portal, frame)).filter(p_242965_2_);
        if (optional.isPresent()) {
            return optional;
        } else {
            Direction.Axis direction$axis = p_242965_3_ == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            return Optional.of(new PortalShape(p_242965_0_, p_242965_1_, direction$axis, portal, frame)).filter(p_242965_2_);
        }
    }

    @Nullable
    private BlockPos calculateBottomLeft(BlockPos p_242971_1_) {
        for (int i = Math.max(0, p_242971_1_.getY() - 21); p_242971_1_.getY() > i && isEmpty(this.level.getBlockState(p_242971_1_.below())); p_242971_1_ = p_242971_1_.below()) {
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
        BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

        for (int i = 0; i <= 21; ++i) {
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
        BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();
        int i = this.getDistanceUntilTop(blockpos$mutable);
        return i >= 3 && i <= 21 && this.hasTopFrame(blockpos$mutable, i) ? i : 0;
    }

    private boolean hasTopFrame(BlockPos.MutableBlockPos p_242970_1_, int p_242970_2_) {
        for (int i = 0; i < this.width; ++i) {
            BlockPos.MutableBlockPos blockpos$mutable = p_242970_1_.set(this.bottomLeft).move(Direction.UP, p_242970_2_).move(this.rightDir, i);
            if (!FRAME.test(this.level.getBlockState(blockpos$mutable), this.level, blockpos$mutable)) {
                return false;
            }
        }

        return true;
    }

    private int getDistanceUntilTop(BlockPos.MutableBlockPos p_242969_1_) {
        for (int i = 0; i < 21; ++i) {
            p_242969_1_.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
            if (!FRAME.test(this.level.getBlockState(p_242969_1_), this.level, p_242969_1_)) {
                return i;
            }

            p_242969_1_.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
            if (!FRAME.test(this.level.getBlockState(p_242969_1_), this.level, p_242969_1_)) {
                return i;
            }

            for (int j = 0; j < this.width; ++j) {
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
}
