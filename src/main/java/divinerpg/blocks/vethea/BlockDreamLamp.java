package divinerpg.blocks.vethea;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.DreamLampBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class BlockDreamLamp extends BaseEntityBlock {
    public static final MapCodec<BlockDreamLamp> CODEC = simpleCodec(BlockDreamLamp::new);
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    @Override public MapCodec<BlockDreamLamp> codec() {return CODEC;}
    public BlockDreamLamp(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(POWERED, false));
    }
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.DREAM_LAMP.get(), DreamLampBlockEntity::serverTick);
    }
    @Nullable
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(POWERED, false);
    }
    @SuppressWarnings("deprecation")
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
	@Override public void onRemove(BlockState state, Level level, BlockPos pos, BlockState st, boolean b) {
		if (!state.is(st.getBlock())) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof DreamLampBlockEntity) {
				if (level instanceof ServerLevel) Containers.dropContents(level, pos, (DreamLampBlockEntity)blockentity);
	            level.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, level, pos, st, b);
		}
	}
    @Override public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        if(state.getValue(POWERED)) return 15;
        return 0;
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DreamLampBlockEntity(pos, state);
    }
    @Override public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result) {
		if(level.isClientSide) return InteractionResult.SUCCESS;
		else {
			BlockEntity blockentity = level.getBlockEntity(pos);
	        if (blockentity instanceof DreamLampBlockEntity) player.openMenu((MenuProvider)blockentity);
	        return InteractionResult.CONSUME;
		}
	}
}