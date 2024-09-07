package divinerpg.events.enchant;

import divinerpg.blocks.base.BlockModMobCage;
import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RiveHandler {
    @SubscribeEvent
    public void handleWorldBreak(BlockEvent.BreakEvent event) {
        Level world = (Level) event.getLevel();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getMainHandItem();
        BlockState blockState = world.getBlockState(event.getPos());
        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.RIVE.get(), player);
        float pitch = player.getXRot();
        Direction facing = (pitch > 45) ? Direction.DOWN : (pitch < -45) ? Direction.UP : player.getDirection();
        if(world.isClientSide) return;
        if(player.isShiftKeyDown()) return;
        if(!(itemStack.getItem() instanceof DiggerItem)) return;
        if(!itemStack.getItem().isCorrectToolForDrops(itemStack, blockState)) return;
        if(level < 1) return;
        int[] dimensions = getSizeByDirection(facing, level);
        int totalBlocksBroken = 0;
        for(int x = dimensions[0]; x <= dimensions[3]; x++) {
            for(int y = dimensions[1]; y <= dimensions[4]; y++) {
                for(int z = dimensions[2]; z <= dimensions[5]; z++) {
                    BlockPos pos = event.getPos().offset(x, y, z);
                    if(tryToBreakBlock(world, player, pos, world.getBlockState(pos), itemStack)) totalBlocksBroken++;
                }
            }
        } if(blockState.getDestroySpeed(world, event.getPos()) != 0.0F && totalBlocksBroken > 0) itemStack.hurtAndBreak(totalBlocksBroken - 1, player, (ctx) -> ctx.broadcastBreakEvent(EquipmentSlot.MAINHAND));
    }
    private boolean tryToBreakBlock(Level world, Player player, BlockPos pos, BlockState blockState, ItemStack tool) {
        Block block = blockState.getBlock();
        if(!tool.getItem().isCorrectToolForDrops(tool, blockState)) return false;
        if(!(block instanceof BlockModMobCage) && blockState.hasBlockEntity()) return false;
        if(block.defaultDestroyTime() < 0) return false;

        // Check if the block is a mob cage and manually trigger entity spawn logic
        if(block instanceof BlockModMobCage mobCage) {
            mobCage.onDestroyedByPlayer(blockState, world, pos, player, true, world.getFluidState(pos));
        }

        if(block.canHarvestBlock(blockState, world, pos, player) && world instanceof ServerLevel) {
            if(!player.isCreative()) {
                block.playerDestroy(world, player, pos, blockState, null, tool);
                block.popExperience((ServerLevel) world, pos, block.getExpDrop(blockState, world, world.random, pos, EnchantmentHelper.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE, player), EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player)));
            }
            world.destroyBlock(pos, false);
            return true;
        }
        return false;
    }

    private int[] getSizeByDirection(Direction facing, int level) {
        int depth = level - 1;
        //Format: fromX, fromY, fromZ, toX, toY, toZ
        //arr[x] must be greater than or equal to arr[x - 3]
        return switch (facing) {
            case NORTH -> new int[]{-1, -1, -depth, 1, 1, 0};
            case EAST -> new int[]{0, -1, -1, depth, 1, 1};
            case WEST -> new int[]{-depth, -1, -1, 0, 1, 1};
            case SOUTH -> new int[]{-1, -1, 0, 1, 1, depth};
            case UP -> new int[] {-1, 0, -1, 1, depth, 1};
            case DOWN -> new int[] {-1, -depth, -1, 1, 0, 1};
        };
    }
}