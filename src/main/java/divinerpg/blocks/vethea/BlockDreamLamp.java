package divinerpg.blocks.vethea;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.block_entities.block.*;
import divinerpg.block_entities.furnace.InfiniFurnaceBlockEntity;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;

import javax.annotation.*;

public class BlockDreamLamp extends BaseEntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public BlockDreamLamp() {
        super(Block.Properties.of(Material.BUILDABLE_GLASS, MaterialColor.COLOR_LIGHT_GRAY).strength(0.3F).sound(SoundType.GLASS));
        this.registerDefaultState(this.getStateDefinition().any().setValue(POWERED, false));
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.DREAM_LAMP.get(), DreamLampBlockEntity::serverTick);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(POWERED, false);
    }
    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
    	return RenderShape.MODEL;
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
    @SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState st, boolean b) {
		if (!state.is(st.getBlock())) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof DreamLampBlockEntity) {
				if (level instanceof ServerLevel) Containers.dropContents(level, pos, (DreamLampBlockEntity)blockentity);
	            level.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, level, pos, st, b);
		}
	}
    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        if(state.getValue(POWERED)) return 15;
        return 0;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new DreamLampBlockEntity(p_153215_, p_153216_);
    }
    @Override
	public InteractionResult use(BlockState p_48706_, Level level, BlockPos pos, Player player, InteractionHand p_48710_, BlockHitResult p_48711_) {
		if (level.isClientSide) return InteractionResult.SUCCESS;
		else {
			BlockEntity blockentity = level.getBlockEntity(pos);
	        if (blockentity instanceof InfiniFurnaceBlockEntity) player.openMenu((MenuProvider)blockentity);
	        return InteractionResult.CONSUME;
		}
	}
}