package divinerpg.events.enchants;

import divinerpg.api.DivineAPI;
import divinerpg.registry.EnchantRegister;
import divinerpg.utils.PositionHelper;
import divinerpg.utils.tasks.ITask;
import io.netty.util.internal.ConcurrentSet;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.BlockEvent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class DiggingTask implements ITask<BlockEvent.HarvestDropsEvent> {
    private final UUID id;
    private final WeakReference<EntityPlayerMP> player;
    private final Set<BlockPos> poses;

    public DiggingTask(EntityPlayerMP playerMP) {
        this.id = playerMP.getUniqueID();
        poses = new ConcurrentSet<>();
        player = new WeakReference<>(playerMP);
    }

    @Override
    public UUID getActor() {
        return id;
    }

    @Override
    public void merge(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        BlockPos eventPos = event.getPos();
        int enchantLevel = getEnchantLevel(player);

        RayTraceResult result = PositionHelper.rayTrace(player, player.getDistance(eventPos.getX(), eventPos.getY(), eventPos.getZ()), 0);

        EnumFacing direction = result == null
                ? EnumFacing.getDirectionFromEntityLiving(eventPos, player)
                : result.sideHit;

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

        BlockPos leftUpCorner = eventPos.offset(down.getOpposite()).offset(left);
        BlockPos rightDownCorner = eventPos.offset(down).offset(right);

        for (int i = 2; i <= enchantLevel; i++) {
            rightDownCorner = rightDownCorner.offset(direction.getOpposite());
        }

        BlockPos.getAllInBox(leftUpCorner, rightDownCorner).forEach(poses::add);
    }

    @Override
    public boolean shouldMerge(BlockEvent.HarvestDropsEvent event) {
        // no enchant
        if (getEnchantLevel(event.getHarvester()) < 1)
            return false;

        // current pos already scheduled
        return !poses.contains(event.getPos());
    }

    @Override
    public void execute() {
        EntityPlayerMP playerMP = player.get();
        MinecraftServer server = playerMP.mcServer;
        World world = playerMP.getEntityWorld();
        ItemStack stack = playerMP.getHeldItemMainhand();

        List<ItemStack> drops = new ArrayList<>();

        if (playerMP != null && server != null && world != null && stack != null) {

            for (BlockPos pos : poses) {
                IBlockState state = world.getBlockState(pos);

                if (canHarvestBlock(server, playerMP, world, state, pos, stack)) {
                    harvestBlock(world, playerMP, state, pos, stack, drops);
                }

                poses.remove(pos);
            }
        }

        for (int i = 0; i < drops.size(); i++) {
            ItemStack stack1 = drops.get(i);

            for (int j = i + 1; j < drops.size(); j++) {
                ItemStack stack2 = drops.get(j);

                if (stack1.isItemEqual(stack2)
                        && ItemStack.areItemStackTagsEqual(stack1, stack2)) {
                    stack1.grow(stack2.getCount());

                    drops.remove(j);
                    j--;
                }
            }
        }

        for (ItemStack drop : drops) {
            Block.spawnAsEntity(world, playerMP.getPosition().add(new BlockPos(playerMP.getLookVec().scale(2))), drop);
        }
    }

    /**
     * Getting world_break enchant level
     *
     * @param player - from that player
     * @return
     */
    private int getEnchantLevel(EntityPlayer player) {
        return EnchantmentHelper.getEnchantmentLevel(EnchantRegister.world_break, player.getHeldItemMainhand());
    }

    /**
     * Check if can break block
     */
    private boolean canHarvestBlock(MinecraftServer server, EntityPlayer player, World world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (!ForgeHooks.canToolHarvestBlock(world, pos, stack))
            return false;

        if (server.isBlockProtected(world, pos, player))
            return false;

        return ForgeHooks.canHarvestBlock(state.getBlock(), player, world, pos);
    }

    private void harvestBlock(World world, EntityPlayerMP player, IBlockState state, BlockPos pos, ItemStack stack,
                              List<ItemStack> drops) {
        int exp = ForgeHooks.onBlockBreakEvent(world, player.interactionManager.getGameType(), player, pos);
        if (exp < 0)
            return;

        Block block = state.getBlock();

        NonNullList<ItemStack> drop = NonNullList.create();
        boolean isSilk = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0;
        int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);

        if (block.canSilkHarvest(world, pos, state, player) && isSilk) {
            Object silkStack = DivineAPI.reflectionHelper.callMethod(Block.class, block, "getSilkTouchDrop", () -> new Object[]{state}, IBlockState.class);
            if (silkStack instanceof ItemStack) {
                drop.add((ItemStack) silkStack);
            }
        } else {
            block.getDrops(drop, world, pos, state, fortune);
        }


        ForgeEventFactory.fireBlockHarvesting(drop, world, pos, state, fortune, 1, isSilk, player);

        if (!block.removedByPlayer(state, world, pos, player, true))
            return;

        drops.addAll(drop);
        block.dropXpOnBlockBreak(world, pos, exp);
    }

}
