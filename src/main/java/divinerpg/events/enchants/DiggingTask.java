package divinerpg.events.enchants;

import divinerpg.utils.PositionHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.common.ForgeHooks;

import java.util.HashSet;
import java.util.Set;

public class DiggingTask {
    private final Set<BlockPos> positions = new HashSet<>();
    private EntityPlayerMP player;

    public DiggingTask(EntityPlayerMP player, BlockPos brokenBlockPos, int level) {
        this.player = player;

        // trying to get correct side hit of block
        RayTraceResult result = PositionHelper.rayTrace(player, player.getPosition().distanceSq(brokenBlockPos.getX(), brokenBlockPos.getY(), brokenBlockPos.getZ()), 0);

        EnumFacing direction = result != null
                ? result.sideHit
                : EnumFacing.getDirectionFromEntityLiving(brokenBlockPos, player);

        // relative positions
        EnumFacing right, left, down;

        if (direction.getAxis().isVertical()) {
            down = player.getHorizontalFacing().getOpposite();
            right = down.rotateYCCW();
            left = right.getOpposite();
        } else {
            down = EnumFacing.DOWN;
            right = direction.rotateYCCW();
            left = right.getOpposite();
        }

        BlockPos leftUpCorner = brokenBlockPos.offset(down.getOpposite()).offset(left);
        BlockPos rightDownCorner = brokenBlockPos.offset(down).offset(right);

        for (int i = 2; i <= level; i++) {
            rightDownCorner = rightDownCorner.offset(direction.getOpposite());
        }


        BlockPos.getAllInBox(leftUpCorner, rightDownCorner).forEach(positions::add);
    }

    /**
     * Check if current player is breaking current block position
     *
     * @param player - player
     * @param pos    - block break position
     */
    public boolean isInWork(EntityPlayer player, BlockPos pos) {
        return player.getUniqueID() == this.player.getUniqueID() && positions.contains(pos);
    }

    /**
     * Perform range breaking
     */
    public void perform() {
        while (!positions.isEmpty()) {
            BlockPos pos = positions.stream().findFirst().orElse(null);
            if (pos != null) {

                if (ForgeHooks.canHarvestBlock(player.world.getBlockState(pos).getBlock(), player, player.world, pos))
                    player.interactionManager.tryHarvestBlock(pos);
            }

            positions.remove(pos);
        }
    }
}
