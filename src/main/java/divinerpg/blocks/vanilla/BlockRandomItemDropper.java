package divinerpg.blocks.vanilla;

import java.util.Set;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRandomItemDropper extends BlockMod {
	public BlockRandomItemDropper() {
		super(Properties.ofFullCopy(Blocks.DROPPER));
		registerDefaultState(stateDefinition.any().setValue(DirectionalBlock.FACING, Direction.NORTH).setValue(BlockStateProperties.TRIGGERED, false));
	}
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(DirectionalBlock.FACING, BlockStateProperties.TRIGGERED);
	}
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(DirectionalBlock.FACING, context.getNearestLookingDirection().getOpposite());
	}
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(DirectionalBlock.FACING, rot.rotate(state.getValue(DirectionalBlock.FACING)));
	}
	@Override
	public BlockState mirror(BlockState state, Mirror mir) {
		return rotate(state, mir.getRotation(state.getValue(DirectionalBlock.FACING)));
	}
	@Override
	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
		if(!level.isClientSide()) {
			boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
			if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
			else if(hasSignal && !triggered) {
				level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
				Set<ResourceLocation> keys = ForgeRegistries.ITEMS.getKeys();
				Direction dir = state.getValue(DirectionalBlock.FACING);
				ItemEntity i = new ItemEntity(level, pos.getX() + .7 * dir.getStepX(), pos.getY() + .7 * dir.getStepY(), pos.getZ() + .7 * dir.getStepZ(), new ItemStack(ForgeRegistries.ITEMS.getValue((ResourceLocation) keys.toArray()[level.random.nextInt(keys.size())])));
				i.setDeltaMovement(i.getDeltaMovement().add(dir.getStepX() * .5, dir.getStepY() * .5, dir.getStepZ() * .5));
				level.addFreshEntity(i);
				level.playSound(null, pos, SoundEvents.DISPENSER_DISPENSE, SoundSource.BLOCKS);
			}
		}
	}
}