package divinerpg.entities.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.*;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Supplier;

public class MoveTowardsGoal extends Goal {
    private final Mob mob;
    private double wantedX;
    private double wantedY;
    private double wantedZ;
    private final double speedModifier;

    public MoveTowardsGoal(Mob p_25633_, double p_25634_) {
        this.mob = p_25633_;
        this.speedModifier = p_25634_;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        if (this.mob.isWithinRestriction()) {
            return false;
        } else {
            Vec3 vec3 = getPosTowards(this.mob, 16, 7, Vec3.atBottomCenterOf(this.mob.getRestrictCenter()), (double)((float)Math.PI / 2F));
            if (vec3 == null) {
                return false;
            } else {
                this.wantedX = vec3.x;
                this.wantedY = vec3.y;
                this.wantedZ = vec3.z;
                return true;
            }
        }
    }

    @Nullable
    public static Vec3 generateRandomPos(Mob p_148543_, Supplier<BlockPos> p_148544_) {
        return generateRandomPos(p_148543_, p_148544_);
    }
    @Nullable
    public static Vec3 getPosTowards(Mob p_148413_, int p_148414_, int p_148415_, Vec3 p_148416_, double p_148417_) {
        Vec3 vec3 = p_148416_.subtract(p_148413_.getX(), p_148413_.getY(), p_148413_.getZ());
        boolean flag = mobRestricted(p_148413_, p_148414_);
        return generateRandomPos(p_148413_, () -> {
            BlockPos blockpos = RandomPos.generateRandomDirectionWithinRadians(p_148413_.getRandom(), p_148414_, p_148415_, 0, vec3.x, vec3.z, p_148417_);
            return blockpos == null ? null : generateRandomPosTowardDirection(p_148413_, p_148414_, flag, blockpos);
        });
    }
    @Nullable
    private static BlockPos generateRandomPosTowardDirection(Mob p_148437_, int p_148438_, boolean p_148439_, BlockPos p_148440_) {
        BlockPos blockpos = generateRandomPosTowardDirection(p_148437_, p_148438_, p_148437_.getRandom(), p_148440_);
        return !isOutsideLimits(blockpos, p_148437_) && !isRestricted(p_148439_, p_148437_, blockpos) && !GoalUtils.isNotStable(p_148437_.getNavigation(), blockpos) && !hasMalus(p_148437_, blockpos) ? blockpos : null;
    }

    public static boolean isOutsideLimits(BlockPos p_148452_, Mob p_148453_) {
        return p_148452_.getY() < p_148453_.level.getMinBuildHeight() || p_148452_.getY() > p_148453_.level.getMaxBuildHeight();
    }

    public static boolean isRestricted(boolean p_148455_, Mob p_148456_, BlockPos p_148457_) {
        return p_148455_ && !p_148456_.isWithinRestriction(p_148457_);
    }
    public static boolean hasMalus(Mob p_148459_, BlockPos p_148460_) {
        return p_148459_.getPathfindingMalus(WalkNodeEvaluator.getBlockPathTypeStatic(p_148459_.level, p_148460_.mutable())) != 0.0F;
    }
    public static BlockPos generateRandomPosTowardDirection(Mob p_217864_, int p_217865_, RandomSource p_217866_, BlockPos p_217867_) {
        int i = p_217867_.getX();
        int j = p_217867_.getZ();
        if (p_217864_.hasRestriction() && p_217865_ > 1) {
            BlockPos blockpos = p_217864_.getRestrictCenter();
            if (p_217864_.getX() > (double)blockpos.getX()) {
                i -= p_217866_.nextInt(p_217865_ / 2);
            } else {
                i += p_217866_.nextInt(p_217865_ / 2);
            }

            if (p_217864_.getZ() > (double)blockpos.getZ()) {
                j -= p_217866_.nextInt(p_217865_ / 2);
            } else {
                j += p_217866_.nextInt(p_217865_ / 2);
            }
        }

        return new BlockPos((int) ((double)i + p_217864_.getX()), (int) ((double)p_217867_.getY() + p_217864_.getY()), (int) ((double)j + p_217864_.getZ()));
    }
    public static boolean mobRestricted(Mob p_148443_, int p_148444_) {
        return p_148443_.hasRestriction() && p_148443_.getRestrictCenter().closerToCenterThan(p_148443_.position(), (double)(p_148443_.getRestrictRadius() + (float)p_148444_) + 1.0D);
    }


    public boolean canContinueToUse() {
        return !this.mob.getNavigation().isDone();
    }

    public void start() {
        this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
    }
}