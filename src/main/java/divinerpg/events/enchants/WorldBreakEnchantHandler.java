package divinerpg.events.enchants;

import divinerpg.registry.EnchantRegister;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class WorldBreakEnchantHandler {

    @SubscribeEvent
    public void handleWorldBreak(BlockEvent.BreakEvent event) {
        World world = event.getWorld();
        if(world.isRemote) {
            return;
        }

        EntityPlayer player = event.getPlayer();
        if(player.isSneaking()) {
            return;
        }

        ItemStack itemStack = event.getPlayer().getHeldItemMainhand();
        if(!(itemStack.getItem() instanceof ItemTool)) {
            return;
        }

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantRegister.world_break, itemStack);
        if(level < 1) {
            return;
        }

        EnumFacing facing = player.getHorizontalFacing();

        int[] dimensions = getSizeByDirection(facing, level);
        for(int x = dimensions[0]; x <= dimensions[3]; x++) {
            for(int y = dimensions[1]; y <= dimensions[4]; y++) {
                for(int z = dimensions[2]; z <= dimensions[5]; z++) {
                    BlockPos pos = event.getPos().add(x, y, z);
                    tryToBreakBlock(world, player, pos, world.getBlockState(pos), itemStack);
                }
            }
        }
    }

    private void tryToBreakBlock(World world, EntityPlayer player, BlockPos pos, IBlockState blockState, ItemStack tool) {
        if(blockState.getBlock() == Blocks.AIR || blockState.getBlockHardness(world, pos) < 0) {
            return;
        }

        Block block = blockState.getBlock();
        if(block.canHarvestBlock(world, pos, player)) {
            block.harvestBlock(world, player, pos, blockState, null, tool);
            world.destroyBlock(pos, false);
            tool.damageItem(1, player);
        }
    }

    private int[] getSizeByDirection(EnumFacing facing, int level) {

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
