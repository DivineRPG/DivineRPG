package divinerpg.entities.ai;

import divinerpg.entities.wildwood.EntityBehemoth;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.pathfinding.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;

public class EntityBehemothEatWood extends Goal {

    private final EntityBehemoth behemoth;
    private final float speed = 2.0F;
    private Path foodPath;
    private PathNavigator foodPathNavigator;
    private BlockPos target;

    public EntityBehemothEatWood(EntityBehemoth behemoth) {
        this.behemoth = behemoth;
        this.foodPathNavigator = behemoth.getNavigator();
//        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this.behemoth.getHealth() > this.behemoth.getMaxHealth() * 0.5) {
            return false;
        }

        double minDistance = Double.MAX_VALUE;
        BlockPos minDistanceWoodPos = null;
        BlockPos behemothPosition = behemoth.getPosition();

        for (int x2 = (int) this.behemoth.getPosX() - 12; x2 < (int) this.behemoth.getPosX() + 12; x2++) {
            for (int z2 = (int) this.behemoth.getPosZ() - 12; z2 < (int) this.behemoth.getPosZ() + 12; z2++) {
                for (int y2 = (int) this.behemoth.getPosY() - 2; y2 < (int) this.behemoth.getPosY() + 1; y2++) {

                    BlockPos candidate = new BlockPos(x2, y2, z2);
                    BlockState candidateState = behemoth.world.getBlockState(candidate);

                    boolean isEdible = isBlockEdible(candidateState, candidate);

                    if (isEdible) {
                        double distance = behemothPosition.distanceSq(x2, y2, z2, true);
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
            this.foodPath = this.foodPathNavigator.getPathToPos(target, 0);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void startExecuting() {
        this.foodPathNavigator.setPath(this.foodPath, this.speed);
    }



    //TODO - make Behemoth eat wood a task and not a goal
//    @Override
//    public void updateTask() {
//        if (this.behemoth.getDistanceSq(target.getX(), target.getY(), target.getZ()) > 2) {
//            this.foodPath = this.foodPathNavigator.getPathToPos(target, 0);
//            this.foodPathNavigator.setPath(this.foodPath, this.speed);
//        } else {
//            this.behemoth.heal(10F);
//            this.behemoth.world.destroyBlock(this.target, false);
//            this.behemoth.world.playSound(null, this.target, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.HOSTILE, 1.0F, 1.0F);
//            this.resetTask();
//        }
//    }

    @Override
    public void resetTask() {
        this.target = null;
        this.foodPathNavigator.clearPath();
    }

    @Override
    public boolean shouldContinueExecuting() {
        if (this.target == null) {
            return false;
        } else {
            BlockState targetState = behemoth.world.getBlockState(target);
            return isBlockEdible(targetState, target);
        }
    }


    private boolean isBlockEdible(BlockState state, BlockPos pos) {
        return state.getMaterial() == Material.WOOD && state.getBlockHardness(this.behemoth.world, pos) >= 0F || BlockTags.LOGS.contains(state.getBlock()) && state.getBlockHardness(this.behemoth.world, pos) >= 0F ;
    }
}