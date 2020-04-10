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
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.BlockEvent;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

public class DiggingTask implements ITask<BlockEvent.HarvestDropsEvent> {

    /**
     * Cached player UUID
     */
    private final UUID id;

    /**
     * Player weak reference
     */
    private final WeakReference<EntityPlayerMP> player;

    /**
     * Initial player break pos
     */
    private final BlockPos startPos;

    /**
     * Cached poses to break
     */
    private final Set<BlockPos> poses;

    /**
     * Direction in depth, forward to player look
     */
    private final EnumFacing forward;

    /**
     * Relative to forward right direction
     */
    private final EnumFacing right;

    /**
     * Relative to forward up direction
     */
    private final EnumFacing up;

    public DiggingTask(BlockEvent.HarvestDropsEvent e) {
        // It checked is task factory method
        EntityPlayerMP harvester = (EntityPlayerMP) e.getHarvester();

        // caching break start pos
        startPos = e.getPos();

        // caching id
        this.id = harvester.getUniqueID();
        poses = new ConcurrentSet<>();
        player = new WeakReference<>(harvester);

        // getting correct side hit (thanks cofh core)
        RayTraceResult result = PositionHelper.rayTrace(harvester, false);

        forward = (result == null
                // using 100% working but inaccurate method
                ? EnumFacing.getDirectionFromEntityLiving(startPos, harvester)
                : result.sideHit).getOpposite();

        // getting sides
        if (forward.getAxis().isVertical()) {
            up = harvester.getHorizontalFacing();
            right = up.rotateYCCW();
        } else {
            up = EnumFacing.UP;
            right = forward.rotateYCCW();
        }
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

        BlockPos leftUpCorner = eventPos.offset(up).offset(right.getOpposite());
        BlockPos rightDownCorner = eventPos.offset(up.getOpposite()).offset(right);

        //next level will dig in depth
        for (int i = 2; i <= enchantLevel; i++) {
            rightDownCorner = rightDownCorner.offset(forward);
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

        // vertical offset
        // player do not need to look up
        // all breaking block will be from where player started digging - 1 and higher
        if (up.getAxis().isVertical()) {
            // find min pos in breaking blocks
            Optional<Integer> min = poses.stream().map(Vec3i::getY).min(Integer::compareTo);
            if (min.isPresent()) {
                int diff = startPos.getY() - min.get();

                // min pos lower, player will fall, need to fix
                if (diff > 0) {
                    List<BlockPos> newPoses = poses.stream().map(x -> x.up(diff)).collect(Collectors.toList());
                    poses.clear();
                    poses.addAll(newPoses);
                }
            }
        }


        if (playerMP != null && server != null && world != null && stack != null) {
            for (BlockPos pos : poses) {
                IBlockState state = world.getBlockState(pos);

                if (canHarvestBlock(server, playerMP, world, state, pos, stack)) {
                    harvestBlock(world, playerMP, state, pos, stack, drops);
                }

                poses.remove(pos);
            }
        }

        // merging stacks
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

        stack.damageItem(1, player);
    }

}
