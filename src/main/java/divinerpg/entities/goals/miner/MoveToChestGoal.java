package divinerpg.entities.goals.miner;

import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;

import java.util.EnumSet;

public class MoveToChestGoal extends Goal {
    private final EntityMiner miner;
    private BlockPos chestLocation = null;
    private final double speed;

    public MoveToChestGoal(EntityMiner miner, double speed) {
        this.miner = miner;
        this.speed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (chestLocation == null) {
            chestLocation = findNearestChest();
        }
        return chestLocation != null && miner.distanceToSqr(chestLocation.getX() + 0.5, chestLocation.getY() + 0.5, chestLocation.getZ() + 0.5) > 2.0D;
    }

    @Override
    public void start() {
        if (chestLocation != null) {
            miner.getNavigation().moveTo(chestLocation.getX() + 0.5, chestLocation.getY() + 0.5, chestLocation.getZ() + 0.5, speed);
        }
    }

    private BlockPos findNearestChest() {
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();
        BlockPos origin = miner.blockPosition();
        int searchRadius = 8;

        for (int x = -searchRadius; x <= searchRadius; x++) {
            for (int z = -searchRadius; z <= searchRadius; z++) {
                for (int y = -5; y <= 5; y++) {
                    checkPos.set(origin.getX() + x, origin.getY() + y, origin.getZ() + z);
                    if (miner.level().getBlockState(checkPos).is(Blocks.CHEST)) {
                        return checkPos.immutable();
                    }
                }
            }
        }
        return null;
    }
}