package divinerpg.blocks.arcana;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.stats.Stats.ITEM_USED;

public class ArcanaDoor extends DoorBlock {
    private final Holder<Item> keyItem;
    public ArcanaDoor(Properties p, Holder<Item> key) {
        super(BlockRegistry.ARCANA_TYPE, p);
        keyItem = key;
    }
    private void updateAdjacentDoors(Level world, BlockPos pos, Player player) {
        BlockPos[] adjacent = {pos.north(), pos.east(), pos.south(), pos.west()};
        for(BlockPos adjacentPos : adjacent) {
            BlockState adjacentState = world.getBlockState(adjacentPos);
            if(adjacentState.getBlock() instanceof ArcanaDoor) {
                world.setBlockAndUpdate(adjacentPos, adjacentState.cycle(OPEN));
                world.levelEvent(player, adjacentState.getValue(OPEN) ? 1005 : 1011, adjacentPos, 0);
            }
        }
    }
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        BlockState iblockstate = pos.equals(pos.below()) ? state : level.getBlockState(pos.below());
        Item key = keyItem.value();
        if(!iblockstate.is(this)) return InteractionResult.FAIL;
        else {
            if(!player.isCreative()) {
                if(iblockstate.getValue(OPEN).equals(true)) return InteractionResult.FAIL;
                if(stack.is(keyItem)) return InteractionResult.FAIL;
                player.awardStat(ITEM_USED.get(key));
            } stack.consume(1, player);
            level.setBlockAndUpdate(pos, state.cycle(OPEN));
            level.levelEvent(player, state.getValue(OPEN) ? 1005 : 1011, pos, 0);
            if(state.getValue(OPEN)) level.playSound(player, pos, SoundEvents.IRON_DOOR_CLOSE, BLOCKS, 1, .8F);
            else level.playSound(player, pos, SoundEvents.IRON_DOOR_OPEN, BLOCKS, 1, .8F);
            updateAdjacentDoors(level, pos, player);
            return InteractionResult.SUCCESS;
        }
    }
    @Override protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, @Nullable Orientation orientation, boolean movedByPiston) {}
}
