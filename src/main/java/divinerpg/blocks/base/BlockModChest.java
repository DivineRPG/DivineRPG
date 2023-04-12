package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class BlockModChest extends ChestBlock {
    public BlockModChest(Properties properties, Supplier<BlockEntityType<? extends ChestBlockEntity>> tile) {
        super(properties, tile);
    }
    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos).setValue(ChestBlock.TYPE, ChestType.SINGLE);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection().getOpposite();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, direction).setValue(ChestBlock.TYPE, ChestType.SINGLE).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }
    @Nullable @Override
    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof MenuProvider ? (MenuProvider) blockEntity : null;
    }
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
    	if(worldIn.isClientSide) return InteractionResult.SUCCESS;
        else {
            MenuProvider menuprovider = getMenuProvider(state, worldIn, pos);
            if(menuprovider != null) {
               player.openMenu(menuprovider);
               player.awardStat(getOpenChestStat());
            }
            return InteractionResult.CONSUME;
        }
    }
    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }
    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = worldIn.getBlockEntity(pos);
            if(blockEntity instanceof Container && !((Container) blockEntity).isEmpty()) super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }
}