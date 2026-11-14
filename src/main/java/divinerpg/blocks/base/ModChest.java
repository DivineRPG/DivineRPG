package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.material.*;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class ModChest extends ChestBlock {
    public ModChest(Properties properties, Supplier<BlockEntityType<? extends ChestBlockEntity>> tile) {
        super(tile, SoundEvents.COPPER_CHEST_OPEN, SoundEvents.COPPER_CHEST_CLOSE, properties);//TODO: custom open/close sounds for chests
    }
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random).setValue(ChestBlock.TYPE, ChestType.SINGLE);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection().getOpposite();
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return defaultBlockState().setValue(FACING, direction).setValue(ChestBlock.TYPE, ChestType.SINGLE).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }
    @Nullable @Override
    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof MenuProvider && !isChestBlockedAt(world, pos)) return (MenuProvider) blockEntity;
        return null;
    }
}