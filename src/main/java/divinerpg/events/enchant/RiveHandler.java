package divinerpg.events.enchant;

import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
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
        if(player.isCrouching()) {
            return;
        }

        ItemStack itemStack = event.getPlayer().getMainHandItem();
        if(!(itemStack.getItem() instanceof DiggerItem)) {
            return;
        }

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.RIVE.get(), player);
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

    private void tryToBreakBlock(Level world, Player player, BlockPos pos, BlockState blockState, ItemStack tool) {
        if(blockState.getBlock() == Blocks.AIR) {
            return;
        }
        if(!ForgeHooks.canEntityDestroy(world, pos, player)){
            return;
        }

        if((blockState.getBlock() instanceof TorchBlock)){
            return;
        }
        if(blockState.getBlock() instanceof DoorBlock){
            return;
        }
        if(blockState.hasBlockEntity()){
            return;
        }

        if(blockState.getBlock().defaultDestroyTime() < 0) {
            return;
        }
        

        Block block = blockState.getBlock();
        if(block.canHarvestBlock(blockState, world, pos, player)) {
            block.playerDestroy(world, player, pos, blockState, null, tool);
            world.destroyBlock(pos, false);
            tool.hurtAndBreak(1, player, (context) -> {
                context.broadcastBreakEvent(player.getUsedItemHand());
            });
        }
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
