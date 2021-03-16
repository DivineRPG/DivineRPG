package divinerpg.entities.ai;

import divinerpg.entities.wildwood.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.pathfinding.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class EntityBehemothEatWood extends Goal {

    private final EntityBehemoth behemoth;
    private final float speed = 2.0F;
    private Path foodPath;
    private PathNavigator foodPathNavigator;
    private BlockPos target;

    public EntityBehemothEatWood(EntityBehemoth behemoth) {
        this.behemoth = behemoth;
        this.foodPathNavigator = behemoth.getNavigation();
//        this.setMutexBits(1);
    }

    @Override
    public boolean canUse() {
        if (this.behemoth.getHealth() > this.behemoth.getMaxHealth() * 0.5) {
            return false;
        }

        double minDistance = Double.MAX_VALUE;
        BlockPos minDistanceWoodPos = null;
        BlockPos behemothPosition = behemoth.blockPosition();

        for (int x2 = (int) this.behemoth.getX() - 12; x2 < (int) this.behemoth.getX() + 12; x2++) {
            for (int z2 = (int) this.behemoth.getZ() - 12; z2 < (int) this.behemoth.getZ() + 12; z2++) {
                for (int y2 = (int) this.behemoth.getY() - 2; y2 < (int) this.behemoth.getY() + 1; y2++) {

                    BlockPos candidate = new BlockPos(x2, y2, z2);
                    BlockState candidateState = behemoth.level.getBlockState(candidate);

                    boolean isEdible = isBlockEdible(candidateState, candidate);

                    if (isEdible) {
                        double distance = behemothPosition.distSqr(x2, y2, z2, true);
                        if (distance < minDistance) {
                            minDistance = distance;
                            minDistanceWoodPos = candidate;
                        }
                    }
                }
            }
        }

        if (minDistanceWoodPos != null) {
            this.target = minDistanceWoodPos;
            this.foodPath = this.foodPathNavigator.createPath(target, 0);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void start() {
        this.foodPathNavigator.moveTo(this.foodPath, this.speed);
    }

    @Override
    public void tick() {
        if (this.behemoth.distanceToSqr(target.getX(), target.getY(), target.getZ()) > 2) {
            this.foodPath = this.foodPathNavigator.createPath(target, 0);
            this.foodPathNavigator.moveTo(this.foodPath, this.speed);
        } else {
            this.behemoth.heal(10F);
            this.behemoth.level.destroyBlock(this.target, false);
            this.behemoth.level.playSound(null, this.target, SoundEvents.GENERIC_EAT, SoundCategory.HOSTILE, 1.0F, 1.0F);
            this.stop();
        }
    }



//    @Override
//    public void reset() {
//        this.target = null;
//        this.foodPathNavigator.clearPath();
//    }
//
//    @Override
//    public boolean shouldContinueExecuting() {
//        if (this.target == null) {
//            return false;
//        } else {
//            BlockState targetState = behemoth.world.getBlockState(target);
//            return isBlockEdible(targetState, target);
//        }
//    }


    private boolean isBlockEdible(BlockState state, BlockPos pos) {
        return state.getMaterial() == Material.WOOD|| BlockTags.LOGS.contains(state.getBlock());
    }
}