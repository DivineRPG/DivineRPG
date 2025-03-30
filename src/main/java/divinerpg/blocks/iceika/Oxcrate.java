package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.OxcrateBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class Oxcrate extends BaseEntityBlock {
    public static final MapCodec<Oxcrate> CODEC = simpleCodec(Oxcrate::new);
    public Oxcrate(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(BlockStateProperties.ENABLED, true));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(BlockStateProperties.ENABLED);}
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    @Override @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.OXCRATE.get().create(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createCrateTicker(level, type, BlockEntityRegistry.OXCRATE.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCrateTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends OxcrateBlockEntity> entityType) {
        return level.isClientSide ? null : createTickerHelper(type, entityType, OxcrateBlockEntity::serverTick);
    }
    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
        boolean signal = !level.hasNeighborSignal(pos);
        if(state.getValue(BlockStateProperties.ENABLED) ^ signal) level.setBlock(pos, state.setValue(BlockStateProperties.ENABLED, signal), 4);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(level.getBlockEntity(pos) instanceof OxcrateBlockEntity block) {
            block.setItem(stack);
            return ItemInteractionResult.SUCCESS;
        } return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}