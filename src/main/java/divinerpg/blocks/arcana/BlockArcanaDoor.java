package divinerpg.blocks.arcana;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

import static net.minecraft.core.registries.BuiltInRegistries.ITEM;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.stats.Stats.ITEM_USED;

public class BlockArcanaDoor extends DoorBlock {
    private final Identifier keyItem;

    public BlockArcanaDoor(MapColor color, Identifier key, BlockSetType setType, Properties properties) {
        super(setType, properties.mapColor(color).noOcclusion());
        this.keyItem = key;
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

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockState iblockstate = pos.equals(pos.below()) ? state : level.getBlockState(pos.below());
        Optional<Holder.Reference<Item>> key = ITEM.get(keyItem);
        if(!iblockstate.is(this)) return InteractionResult.FAIL;
        else {
            if(!player.isCreative()) {
                if(iblockstate.getValue(OPEN).equals(true)) return InteractionResult.FAIL;
                if(stack.getItem() != key.get().value()) return InteractionResult.FAIL;
                player.awardStat(ITEM_USED.get(key.get().value()));
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
