package divinerpg.blocks.vanilla;

import javax.annotation.Nullable;

import divinerpg.block_entities.block.CrateBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockCrate extends BaseEntityBlock {
	public BlockCrate() {
		super(Block.Properties.copy(Blocks.OAK_PLANKS).instrument(NoteBlockInstrument.BASS));
		registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true));
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.ENABLED);}
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityRegistry.CRATE.get().create(pos, state);
	}
	@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return createCrateTicker(level, type, BlockEntityRegistry.CRATE.get());
    }
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createCrateTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends CrateBlockEntity> entityType) {
		return level.isClientSide ? null : createTickerHelper(type, entityType, CrateBlockEntity::serverTick);
	}
	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
		boolean signal = !level.hasNeighborSignal(pos);
		if(state.getValue(BlockStateProperties.ENABLED) ^ signal) level.setBlock(pos, state.setValue(BlockStateProperties.ENABLED, signal), 4);
	}
	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}
	@Override
	public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
	}
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	@Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if(level.getBlockEntity(pos) instanceof CrateBlockEntity block) {
			ItemStack handItem = player.getItemInHand(hand);
			if(handItem == null || handItem.isEmpty()) {
				if(!block.getItem(0).isEmpty()) {
					player.setItemInHand(hand, block.getItem(0));
					block.clearContent();
					return InteractionResult.SUCCESS;
				} return InteractionResult.FAIL;
			} if(block.getItem(0).isEmpty()) {
				block.setItem(0, handItem.copy());
				if(!player.isCreative()) player.setItemInHand(hand, ItemStack.EMPTY);
				return InteractionResult.SUCCESS;
			}
		} return InteractionResult.PASS;
	}
	@Override public void onRemove(BlockState state, Level level, BlockPos pos, BlockState s, boolean b) {
		if((!state.is(s.getBlock()) || !s.hasBlockEntity())) {
			if(level.getBlockEntity(pos) instanceof CrateBlockEntity block && !block.isEmpty()) Containers.dropContents(level, pos, block);
			level.removeBlockEntity(pos);
			level.updateNeighbourForOutputSignal(pos, this);
		}
	}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if(level.getBlockEntity(pos) instanceof CrateBlockEntity block) {
			if(!block.isEmpty()) Containers.dropContents(level, pos, block);
			level.removeBlockEntity(pos);
			level.updateNeighbourForOutputSignal(pos, this);
		} return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
}