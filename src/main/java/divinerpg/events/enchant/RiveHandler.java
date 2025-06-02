package divinerpg.events.enchant;

import divinerpg.blocks.base.BlockModMobCage;
import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

public class RiveHandler {
    @SubscribeEvent
    public void handleWorldBreak(BlockEvent.BreakEvent event) {
        Level world = (Level) event.getLevel();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getMainHandItem();
        BlockState blockState = world.getBlockState(event.getPos());
        int level = EnchantmentHelper.getEnchantmentLevel(world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.RIVE), player);
        float pitch = player.getXRot();
        Direction facing = (pitch > 45) ? Direction.DOWN : (pitch < -45) ? Direction.UP : player.getDirection();
        if(world.isClientSide) return;
        if(player.isShiftKeyDown()) return;
        if(!(itemStack.getItem() instanceof DiggerItem)) return;
        if(!itemStack.getItem().isCorrectToolForDrops(itemStack, blockState)) return;
        if(level < 1) return;
        int[] dimensions = getSizeByDirection(facing, level);
        int totalBlocksBroken = 0;
        //TODO: to make the around blocks breakable only when targeted block has the same or higher hardness value (so that you won't insta-break obsidian by breaking leaves with a shickaxe)
        for(int x = dimensions[0]; x <= dimensions[3]; x++) {
            for(int y = dimensions[1]; y <= dimensions[4]; y++) {
                for(int z = dimensions[2]; z <= dimensions[5]; z++) {
                    BlockPos pos = event.getPos().offset(x, y, z);
                    if(tryToBreakBlock(world, player, pos, world.getBlockState(pos), itemStack)) totalBlocksBroken++;
                }
            }
        } if(blockState.getDestroySpeed(world, event.getPos()) != 0 && totalBlocksBroken > 0) itemStack.hurtAndBreak(totalBlocksBroken - 1, player, EquipmentSlot.MAINHAND);
    }
    private boolean tryToBreakBlock(Level world, Player player, BlockPos pos, BlockState blockState, ItemStack tool) {
        Block block = blockState.getBlock();
        if(!tool.getItem().isCorrectToolForDrops(tool, blockState)) return false;
        if(!(block instanceof BlockModMobCage) && blockState.hasBlockEntity()) return false;
        if(block.defaultDestroyTime() < 0) return false;
        //Checks if the block is a mob cage and manually trigger entity spawn logic
        if(block instanceof BlockModMobCage mobCage) mobCage.onDestroyedByPlayer(blockState, world, pos, player, true, world.getFluidState(pos));
        if(block.canHarvestBlock(blockState, world, pos, player) && world instanceof ServerLevel) {
            if(!player.isCreative()) block.playerDestroy(world, player, pos, blockState, null, tool);
            world.destroyBlock(pos, false);
            return true;
        } return false;
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