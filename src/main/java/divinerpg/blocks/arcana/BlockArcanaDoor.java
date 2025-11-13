package divinerpg.blocks.arcana;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import static divinerpg.util.BlockSetTypesList.ARCANA;
import static net.minecraft.core.registries.BuiltInRegistries.ITEM;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.stats.Stats.ITEM_USED;

public class BlockArcanaDoor extends DoorBlock {
    private final ResourceLocation keyItem;
    public BlockArcanaDoor(MapColor color, ResourceLocation key) {
        super(ARCANA, Properties.ofFullCopy(Blocks.BEDROCK).mapColor(color).noOcclusion());
        keyItem = key;
    }
    private void updateAdjacentDoors(Level world, BlockPos pos, Player player) {
        BlockPos[] adjacent = {pos.north(), pos.east(), pos.south(), pos.west()};
        for(BlockPos adjacentPos : adjacent) {
            BlockState adjacentState = world.getBlockState(adjacentPos);
            if(adjacentState.getBlock() instanceof BlockArcanaDoor) {
                world.setBlockAndUpdate(adjacentPos, adjacentState.cycle(OPEN));
                world.levelEvent(player, adjacentState.getValue(OPEN) ? 1005 : 1011, adjacentPos, 0);
            }
        }
    }
    @Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        BlockState iblockstate = pos.equals(pos.below()) ? state : level.getBlockState(pos.below());
        Item key = ITEM.get(keyItem);
        if(!iblockstate.is(this)) return ItemInteractionResult.FAIL;
        else {
            if(!player.isCreative()) {
                if(iblockstate.getValue(OPEN).equals(true)) return ItemInteractionResult.FAIL;
                if(stack.getItem() != key) return ItemInteractionResult.FAIL;
                player.awardStat(ITEM_USED.get(key));
            } stack.consume(1, player);
            level.setBlockAndUpdate(pos, state.cycle(OPEN));
            level.levelEvent(player, state.getValue(OPEN) ? 1005 : 1011, pos, 0);
            if(state.getValue(OPEN)) level.playSound(player, pos, SoundEvents.IRON_DOOR_CLOSE, BLOCKS, 1, .8F);
            else level.playSound(player, pos, SoundEvents.IRON_DOOR_OPEN, BLOCKS, 1, .8F);
            updateAdjacentDoors(level, pos, player);
            return ItemInteractionResult.SUCCESS;
        }
    }
    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPosition, boolean isPowered) {}
}