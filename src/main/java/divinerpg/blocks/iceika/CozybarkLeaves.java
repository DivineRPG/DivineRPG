package divinerpg.blocks.iceika;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.SNOWY;

public class CozybarkLeaves extends LeavesBlock {
    public CozybarkLeaves(Properties properties) {
        super(AmbientLeavesBlockSoundPlayer.noAmbientSound(), properties);
        registerDefaultState(stateDefinition.any().setValue(DISTANCE, 1).setValue(PERSISTENT, false).setValue(WATERLOGGED, false).setValue(SNOWY, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(DISTANCE, PERSISTENT, WATERLOGGED, SNOWY);}
    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
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
        } return InteractionResult.TRY_WITH_EMPTY_HAND;
    }
}
