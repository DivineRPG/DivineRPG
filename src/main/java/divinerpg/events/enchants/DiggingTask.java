package divinerpg.events.enchants;

import divinerpg.utils.PositionHelper;
import io.netty.util.internal.ConcurrentSet;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.world.BlockEvent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DiggingTask extends TaskBase {
    /**
     * Contains current breaking blocks
     */
    private static final Map<Integer, Set<BlockPos>> breakingPositionsMap = new ConcurrentHashMap<>();

    /**
     * Current server player
     */
    private final EntityPlayerMP player;

    /**
     * List of blocks inside current task
     */
    private final List<BlockPos> currentBlockPoses;

    /**
     * All scheduled task inside the dimension
     */
    private final Set<BlockPos> dimensionBlocks;


    public DiggingTask(MinecraftServer server, EntityPlayerMP player, BlockPos brokenBlockPos, int enchantLevel) {
        super(server);
        Objects.requireNonNull(player);
        this.player = player;
        currentBlockPoses = new ArrayList<>();
        dimensionBlocks = breakingPositionsMap.computeIfAbsent(player.dimension, integer -> new ConcurrentSet<>());

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

        for (int i = 2; i <= enchantLevel; i++) {
            rightDownCorner = rightDownCorner.offset(direction.getOpposite());
        }

        BlockPos.getAllInBox(leftUpCorner, rightDownCorner).forEach(currentBlockPoses::add);
    }

    /**
     * Detects if current block is in work already
     *
     * @param e -- block break event
     * @return
     */
    public static boolean isInWork(BlockEvent.BreakEvent e) {
        if (e == null || e.getPlayer() == null || e.getPos() == null)
            return false;

        Set<BlockPos> poses = breakingPositionsMap.get(e.getPlayer().dimension);
        if (poses == null || poses.isEmpty())
            return false;

        return poses.contains(e.getPos());
    }

    @Override
    protected void start() {
        for (BlockPos pos : currentBlockPoses) {

            if (dimensionBlocks.contains(pos)) {
                if (canHarvestBlock(player.world.getMinecraftServer(), player.world, player.world.getBlockState(pos), pos, player.getHeldItemMainhand())) {
                    player.interactionManager.tryHarvestBlock(pos);
                }

                // removed from all blocks
                dimensionBlocks.remove(pos);
            }
        }

        currentBlockPoses.clear();
    }

    @Override
    protected void onRegister() {
        super.onRegister();

        // adding all blocks to global map
        dimensionBlocks.addAll(currentBlockPoses);
    }

    private boolean canHarvestBlock(MinecraftServer server, World world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (!ForgeHooks.canToolHarvestBlock(world, pos, stack))
            return false;

        if (server.isBlockProtected(world, pos, player))
            return false;

        return ForgeHooks.canHarvestBlock(state.getBlock(), player, world, pos);
    }
}
