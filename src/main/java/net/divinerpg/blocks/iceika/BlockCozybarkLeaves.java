package net.divinerpg.blocks.iceika;

import net.divinerpg.blocks.base.DivineLeavesBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.SNOWY;

public class BlockCozybarkLeaves extends DivineLeavesBlock {

    public BlockCozybarkLeaves(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(DISTANCE, 1).setValue(PERSISTENT, false).setValue(WATERLOGGED, false).setValue(SNOWY, false));
    }

    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(DISTANCE, PERSISTENT, WATERLOGGED, SNOWY);}

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        //TODO: Using water & powder snow buckets doesn't count towards statistics + interactions with buckets is annoyingly different
        if(stack.is(Items.BUCKET) && (state.getValue(SNOWY) || state.getValue(WATERLOGGED))) {
            if(level.isClientSide()) {
                if(state.getValue(SNOWY)) player.playSound(SoundEvents.BUCKET_FILL_POWDER_SNOW);
                else player.playSound(SoundEvents.BUCKET_FILL);
            } else {
                if(!player.isCreative()) {
                    if(state.getValue(SNOWY)) player.addItem(new ItemStack(Items.POWDER_SNOW_BUCKET));
                    else player.addItem(new ItemStack(Items.WATER_BUCKET));
                } stack.consume(1, player);
                level.setBlock(pos, state.setValue(SNOWY, false).setValue(WATERLOGGED, false), UPDATE_ALL);
            } return InteractionResult.SUCCESS;
        } else if(stack.is(Items.POWDER_SNOW_BUCKET) && !state.getValue(SNOWY) && !state.getValue(WATERLOGGED)) {
            if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_EMPTY_POWDER_SNOW);
            else {
                if(!player.isCreative()) player.addItem(new ItemStack(Items.BUCKET));
                stack.consume(1, player);
                level.setBlock(pos, state.setValue(SNOWY, true), UPDATE_ALL);
            } return InteractionResult.SUCCESS;
        } else if(stack.is(Items.WATER_BUCKET) && !state.getValue(WATERLOGGED)) {
            if(level.isClientSide()) player.playSound(SoundEvents.BUCKET_EMPTY);
            else {
                if(!player.isCreative()) player.addItem(new ItemStack(Items.BUCKET));
                stack.consume(1, player);
                level.setBlock(pos, state.setValue(WATERLOGGED, true), UPDATE_ALL);
            } return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
}
