package divinerpg.blocks.vanilla;

import divinerpg.block_entities.chest.CrateBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class Crate extends BaseEntityBlock {
    public Crate(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.ENABLED);}
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.CRATE.get().create(pos, state);
    }
    @Nullable
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, BlockEntityRegistry.CRATE.get(), CrateBlockEntity::serverTick);
    }
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, Orientation orientation, boolean movedByPiston) {
        boolean signal = !level.hasNeighborSignal(pos);
        if(state.getValue(BlockStateProperties.ENABLED) ^ signal) level.setBlock(pos, state.setValue(BlockStateProperties.ENABLED, signal), 4);
    }
    @Override public boolean hasAnalogOutputSignal(BlockState state) {return true;}
    @Override protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {
        if(level.getBlockEntity(pos) instanceof CrateBlockEntity block) {
            if(!block.isEmpty()) Containers.dropContents(level, pos, block);
            level.removeBlockEntity(pos);
            level.updateNeighbourForOutputSignal(pos, this);
        } return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }
    @Override protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.BARREL_OPEN, SoundSource.BLOCKS, .5F, level.getRandom().nextFloat() * .1F + .9F);
        if(level.isClientSide()) return InteractionResult.SUCCESS;
        else {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if(blockentity instanceof CrateBlockEntity c) {
                player.openMenu(c);
                //TODO: custom stats
                //player.awardStat(Stats.OPEN_BARREL);
                if(level instanceof ServerLevel s) PiglinAi.angerNearbyPiglins(s, player, true);
            } return InteractionResult.CONSUME;
        }
    }
}