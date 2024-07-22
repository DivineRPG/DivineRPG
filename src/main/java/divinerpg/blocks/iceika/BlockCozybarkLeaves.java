package divinerpg.blocks.iceika;

import static net.minecraft.world.level.material.MapColor.CRIMSON_STEM;

import divinerpg.blocks.base.BlockModLeaves;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

public class BlockCozybarkLeaves extends BlockModLeaves {
	public BlockCozybarkLeaves() {
		super(CRIMSON_STEM, SoundType.CHERRY_LEAVES);
		registerDefaultState(stateDefinition.any().setValue(DISTANCE, 1).setValue(PERSISTENT, false).setValue(WATERLOGGED, false).setValue(BlockStateProperties.SNOWY, false));
	}
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(DISTANCE, PERSISTENT, WATERLOGGED, BlockStateProperties.SNOWY);
	}
	@Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if(stack.is(Items.BUCKET) && (state.getValue(BlockStateProperties.SNOWY) || state.getValue(BlockStateProperties.WATERLOGGED))) {
			if(level.isClientSide()) {
				if(state.getValue(BlockStateProperties.SNOWY)) player.playSound(SoundEvents.BUCKET_FILL_POWDER_SNOW);
				else player.playSound(SoundEvents.BUCKET_FILL);
			} else {
				if(!player.isCreative()) {
					stack.shrink(1);
					if(state.getValue(BlockStateProperties.SNOWY)) player.addItem(new ItemStack(Items.POWDER_SNOW_BUCKET));
					else player.addItem(new ItemStack(Items.WATER_BUCKET));
				}
				level.setBlock(pos, state.setValue(BlockStateProperties.SNOWY, false).setValue(BlockStateProperties.WATERLOGGED, false), UPDATE_ALL);
			} return ItemInteractionResult.SUCCESS;
		} else if(stack.is(Items.POWDER_SNOW_BUCKET) && !state.getValue(BlockStateProperties.SNOWY) && !state.getValue(BlockStateProperties.WATERLOGGED)) {
			if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_EMPTY_POWDER_SNOW);
			else {
				if(!player.isCreative()) {
					stack.shrink(1);
					player.addItem(new ItemStack(Items.BUCKET));
				}
				level.setBlock(pos, state.setValue(BlockStateProperties.SNOWY, true), UPDATE_ALL);
			} return ItemInteractionResult.SUCCESS;
		} else if(stack.is(Items.WATER_BUCKET) && !state.getValue(BlockStateProperties.WATERLOGGED)) {
			if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_EMPTY);
			else {
				if(!player.isCreative()) {
					stack.shrink(1);
					player.addItem(new ItemStack(Items.BUCKET));
				}
				level.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, true), UPDATE_ALL);
			} return ItemInteractionResult.SUCCESS;
		} return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}
}