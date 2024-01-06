package divinerpg.events.enchant;

import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RiveHandler {

    @SubscribeEvent
    public void handleWorldBreak(BlockEvent.BreakEvent event) {
        Level world = (Level) event.getLevel();
        if(world.isClientSide) {
            return;
        }

        Player player = event.getPlayer();
        if(player.isShiftKeyDown()) {
            return;
        }

        ItemStack itemStack = player.getMainHandItem();
        if(!(itemStack.getItem() instanceof DiggerItem)) {
            return;
        }

        BlockState blockState = world.getBlockState(event.getPos());
        if(!itemStack.getItem().isCorrectToolForDrops(itemStack, blockState)) {
            return;
        }

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.RIVE.get(), player);
        if(level < 1) {
            return;
        }

        float pitch = player.getXRot();
        Direction facing = (pitch > 45) ? Direction.DOWN : (pitch < -45) ? Direction.UP : player.getDirection();

        int[] dimensions = getSizeByDirection(facing, level);
        int totalBlocksBroken = 0;
        for(int x = dimensions[0]; x <= dimensions[3]; x++) {
            for(int y = dimensions[1]; y <= dimensions[4]; y++) {
                for(int z = dimensions[2]; z <= dimensions[5]; z++) {
                    BlockPos pos = event.getPos().offset(x, y, z);
                    if (tryToBreakBlock(world, player, pos, world.getBlockState(pos), itemStack)) {
                        totalBlocksBroken++;
                    }
                }
            }
        }
        if (blockState.getDestroySpeed(world, event.getPos()) != 0.0F && totalBlocksBroken > 0) {
            itemStack.hurtAndBreak(totalBlocksBroken - 1, player, (context) -> context.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
    }

    private boolean tryToBreakBlock(Level world, Player player, BlockPos pos, BlockState blockState, ItemStack tool) {
        if(!tool.getItem().isCorrectToolForDrops(tool, blockState)) {
            return false;
        }
        if(blockState.getBlock() instanceof DoorBlock) {
            return false;
        }
        if(blockState.hasBlockEntity()) {
            return false;
        }
        if(blockState.getBlock().defaultDestroyTime() < 0.0F) {
            return false;
        }

        Block block = blockState.getBlock();
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
