package divinerpg.blocks.arcana;

import net.minecraft.core.BlockPos;
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
import net.minecraftforge.registries.ForgeRegistries;

public class BlockArcanaDoor extends DoorBlock {
    private final ResourceLocation keyItem;

    public BlockArcanaDoor(MapColor color, ResourceLocation key) {
        super(BlockBehaviour.Properties.of().mapColor(color).strength(-1.0F, 3600000.0F).noOcclusion().instrument(NoteBlockInstrument.BASEDRUM), BlockSetType.STONE);
        this.keyItem = key;
    }

    private void updateAdjacentDoors(Level world, BlockPos pos, Player player, BlockState state) {
        BlockPos[] adjacent = {
                pos.north(),
                pos.east(),
                pos.south(),
                pos.west()
        };

        for (BlockPos adjacentPos : adjacent) {
            BlockState adjacentState = world.getBlockState(adjacentPos);

            if (adjacentState.getBlock() instanceof BlockArcanaDoor) {

                world.setBlockAndUpdate(adjacentPos, adjacentState.cycle(BlockStateProperties.OPEN).cycle(BlockStateProperties.DOOR_HINGE));
                world.levelEvent(player, adjacentState.getValue(BlockStateProperties.OPEN) ? 1005 : 1011, adjacentPos, 0);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        BlockState iblockstate = pos.equals(pos.below()) ? state : world.getBlockState(pos.below());
        Item key = ForgeRegistries.ITEMS.getValue(keyItem);

        if (!player.isCreative() && itemstack.getItem() != key) {
            return InteractionResult.FAIL;
        }

        if (!player.isCreative()) {
            if (iblockstate.getValue(OPEN).equals(true)) {
                return InteractionResult.FAIL;
            }

            if (itemstack.getItem() != key) {
                return InteractionResult.FAIL;
            }
            itemstack.shrink(1);
        }

        world.setBlockAndUpdate(pos, state.cycle(BlockStateProperties.OPEN));
        world.levelEvent(player, state.getValue(BlockStateProperties.OPEN) ? 1005 : 1011, pos, 0);
        if (state.getValue(OPEN)) {
            world.playSound(player, pos, SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 0.8F);
        }

        if (!state.getValue(OPEN)) {
            world.playSound(player, pos, SoundEvents.IRON_DOOR_OPEN, SoundSource.BLOCKS, 1.0F, 0.8F);
        }

        updateAdjacentDoors(world, pos, player, state);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPosition, boolean isPowered) {
    }
}
