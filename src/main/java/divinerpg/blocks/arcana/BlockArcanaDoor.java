package divinerpg.blocks.arcana;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;

public class BlockArcanaDoor extends DoorBlock {
    private final ResourceLocation keyItem;
    public BlockArcanaDoor(MapColor color, ResourceLocation key) {
        super(BlockSetType.IRON, BlockBehaviour.Properties.of().mapColor(color).strength(-1.0F, 3600000.0F).noOcclusion().instrument(NoteBlockInstrument.BASEDRUM));
        this.keyItem = key;
    }
    private void updateAdjacentDoors(Level world, BlockPos pos, Player player, BlockState state) {
        BlockPos[] adjacent = {
                pos.north(),
                pos.east(),
                pos.south(),
                pos.west()
        };
        for(BlockPos adjacentPos : adjacent) {
            BlockState adjacentState = world.getBlockState(adjacentPos);
            if(adjacentState.getBlock() instanceof BlockArcanaDoor) {
                world.setBlockAndUpdate(adjacentPos, adjacentState.cycle(BlockStateProperties.OPEN));
                world.levelEvent(player, adjacentState.getValue(BlockStateProperties.OPEN) ? 1005 : 1011, adjacentPos, 0);
            }
        }
    }
    @Override public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        ItemStack itemstack = player.getUseItem();
        BlockState iblockstate = pos.equals(pos.below()) ? state : world.getBlockState(pos.below());
        Item key = BuiltInRegistries.ITEM.get(keyItem);
        if(!iblockstate.is(this)) return InteractionResult.FAIL;
        else {
            if(!player.isCreative()) {
                if(iblockstate.getValue(OPEN).equals(true)) return InteractionResult.FAIL;
                if(itemstack.getItem() != key) return InteractionResult.FAIL;
                itemstack.shrink(1);
            } world.setBlockAndUpdate(pos, state.cycle(BlockStateProperties.OPEN));
            world.levelEvent(player, state.getValue(BlockStateProperties.OPEN) ? 1005 : 1011, pos, 0);
            if(state.getValue(OPEN)) world.playSound(player, pos, SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, 1F, .8F);
            else world.playSound(player, pos, SoundEvents.IRON_DOOR_OPEN, SoundSource.BLOCKS, 1F, .8F);
            updateAdjacentDoors(world, pos, player, state);
            return InteractionResult.SUCCESS;
        }
    }
    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPosition, boolean isPowered) {}
}
