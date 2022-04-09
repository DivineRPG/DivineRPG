package divinerpg.events.enchant;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.world.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber
public class RiveHandler {

    @SubscribeEvent
    public void handleWorldBreak(BlockEvent.BreakEvent event) {
        World world = (World) event.getWorld();
        if(world.isClientSide) {
            return;
        }

        PlayerEntity player = event.getPlayer();
        if(player.isCrouching()) {
            return;
        }

        ItemStack itemStack = event.getPlayer().getMainHandItem();
        if(!(itemStack.getItem() instanceof ToolItem)) {
            return;
        }

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.RIVE, player);
        if(level < 1) {
            return;
        }

        Direction facing = player.getDirection();

        int[] dimensions = getSizeByDirection(facing, level);
        for(int x = dimensions[0]; x <= dimensions[3]; x++) {
            for(int y = dimensions[1]; y <= dimensions[4]; y++) {
                for(int z = dimensions[2]; z <= dimensions[5]; z++) {
                    BlockPos pos = event.getPos().offset(x, y, z);
                    tryToBreakBlock(world, player, pos, world.getBlockState(pos), itemStack);
                }
            }
        }
    }

    private void tryToBreakBlock(World world, PlayerEntity player, BlockPos pos, BlockState blockState, ItemStack tool) {
        if(blockState.getBlock() == Blocks.AIR) {
            return;
        }
        if(!blockState.getBlock().canHarvestBlock(blockState, world, pos, player)){
            return;
        }
        if(!ForgeHooks.isToolEffective(world, pos, tool)){
        return;
        }

        if(!(blockState.getBlock() instanceof TorchBlock)){
            return;
        }

        if(blockState.getBlock() instanceof DoorBlock){
            return;
        }

        Block block = blockState.getBlock();
            block.playerDestroy(world, player, pos, blockState, null, tool);
            world.destroyBlock(pos, false);
            tool.hurtAndBreak(1, player, (context) -> {
                context.broadcastBreakEvent(player.getUsedItemHand());
            });
    }

    private int[] getSizeByDirection(Direction facing, int level) {

        int depth = level - 1;

        //Format: fromX, fromY, fromZ, toX, toY, toZ
        //arr[x] must be greater than or equal to arr[x - 3]
        switch(facing) {
            case NORTH:
                return new int[] {-1, -1, 0 - depth, 1, 1, 0};
            case EAST:
                return new int[] {0, -1, -1, 0 + depth, 1, 1};
            case WEST:
                return new int[] {0 - depth, -1, -1, 0, 1, 1};
            case SOUTH:
                return new int[] {-1, -1, 0, 1, 1, 0 + depth};
            case UP:
                return new int[] {-1, 0, -1, 1, 0 + depth, 1};
            case DOWN:
                return new int[] {-1, 0 - depth, -1, 1, 0, 1};
            default:
                return new int[] {0, 0, 0, 0, 0, 0};
        }
    }
}
