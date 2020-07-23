package divinerpg.objects.entities.ai;

import divinerpg.objects.entities.entity.wildwood.EntityBehemoth;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class EntityBehemothEatWood extends EntityAIBase {

    private final EntityBehemoth behemoth;
    private final float speed = 2.0F;
    private Path foodPath;
    private PathNavigate foodPathNavigator;
    private BlockPos target;

    public EntityBehemothEatWood(EntityBehemoth behemoth) {
        this.behemoth = behemoth;
        this.foodPathNavigator = behemoth.getNavigator();
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute() {
        if (this.behemoth.getHealth() > this.behemoth.getMaxHealth() * 0.5) {
            return false;
        }

        double minDistance = Double.MAX_VALUE;
        BlockPos minDistanceWoodPos = null;
        BlockPos behemothPosition = behemoth.getPosition();

        for (int x2 = (int) this.behemoth.posX - 12; x2 < (int) this.behemoth.posX + 12; x2++) {
            for (int z2 = (int) this.behemoth.posZ - 12; z2 < (int) this.behemoth.posZ + 12; z2++) {
                for (int y2 = (int) this.behemoth.posY - 2; y2 < (int) this.behemoth.posY + 1; y2++) {

                    BlockPos candidate = new BlockPos(x2, y2, z2);
                    IBlockState candidateState = behemoth.world.getBlockState(candidate);

                    boolean isEdible = isBlockEdible(candidateState, candidate);

                    if (isEdible) {
                        double distance = behemothPosition.getDistance(x2, y2, z2);
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
            this.foodPath = this.foodPathNavigator.getPathToPos(target);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void startExecuting() {
        this.foodPathNavigator.setPath(this.foodPath, this.speed);
    }

    @Override
    public void updateTask() {
        if (this.behemoth.getDistance(target.getX(), target.getY(), target.getZ()) > 2) {
            this.foodPath = this.foodPathNavigator.getPathToPos(target);
            this.foodPathNavigator.setPath(this.foodPath, this.speed);
        } else {
            this.behemoth.heal(10F);
            this.behemoth.world.destroyBlock(this.target, false);
            this.behemoth.world.playSound(null, this.target, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.HOSTILE, 1.0F, 1.0F);
            this.resetTask();
        }
    }

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
            IBlockState targetState = behemoth.world.getBlockState(target);
            return isBlockEdible(targetState, target);
        }
    }


    private boolean isBlockEdible(IBlockState state, BlockPos pos) {
        return state.getMaterial() == Material.WOOD && state.getBlockHardness(this.behemoth.world, pos) >= 0F;
    }
}