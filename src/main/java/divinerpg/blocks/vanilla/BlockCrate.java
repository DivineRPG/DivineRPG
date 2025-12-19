package divinerpg.blocks.vanilla;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.CrateBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.level.block.Blocks.BARREL;

public class BlockCrate extends BaseEntityBlock {
	public static final MapCodec<BlockCrate> CODEC = simpleCodec(BlockCrate::new);
	@Override public MapCodec<? extends BaseEntityBlock> codec() {return CODEC;}
	public BlockCrate() {this(Properties.ofFullCopy(BARREL));}
	public BlockCrate(Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true));
	}
	@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.ENABLED);}
	@Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityRegistry.CRATE.get().create(pos, state);
	}
	@Nullable
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.CRATE.get(), CrateBlockEntity::serverTick);
    }
	@Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
		boolean signal = !level.hasNeighborSignal(pos);
		if(state.getValue(BlockStateProperties.ENABLED) ^ signal) level.setBlock(pos, state.setValue(BlockStateProperties.ENABLED, signal), 4);
	}
	@Override public boolean hasAnalogOutputSignal(BlockState state) {return true;}
	@Override public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
	}
	@Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
	@Override public void onRemove(BlockState state, Level level, BlockPos pos, BlockState s, boolean isMoving) {
		Containers.dropContentsOnDestroy(state, s, level, pos);
		super.onRemove(state, level, pos, s, isMoving);
	}
	@Override public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
		if(level.getBlockEntity(pos) instanceof CrateBlockEntity block) {
			if(!block.isEmpty()) Containers.dropContents(level, pos, block);
			level.removeBlockEntity(pos);
			level.updateNeighbourForOutputSignal(pos, this);
		} return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}
	@Override protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		level.playSound(player, pos, SoundEvents.BARREL_OPEN, SoundSource.BLOCKS, .5F, level.random.nextFloat() * .1F + .9F);
		if(level.isClientSide) return InteractionResult.SUCCESS;
		else {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if(blockentity instanceof CrateBlockEntity c) {
				player.openMenu(c);
				//TODO: custom stats
				//player.awardStat(Stats.OPEN_BARREL);
				PiglinAi.angerNearbyPiglins(player, true);
			} return InteractionResult.CONSUME;
		}
	}
}