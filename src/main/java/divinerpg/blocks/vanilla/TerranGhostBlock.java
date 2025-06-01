package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.TerranGhostBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

public class TerranGhostBlock extends BaseEntityBlock {
    public static final MapCodec<TerranGhostBlock> CODEC = simpleCodec(TerranGhostBlock::new);
    public TerranGhostBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
        return 1.0F;
    }
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return true;
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BlockEntityRegistry.TERRAN_GHOST.get().create(blockPos, blockState);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createCrateTicker(level, type, BlockEntityRegistry.TERRAN_GHOST.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCrateTicker(Level level, BlockEntityType<T> type, BlockEntityType< ? extends TerranGhostBlockEntity> entityType) {
        return level.isClientSide ? createTickerHelper(type, entityType, TerranGhostBlockEntity::clientTick) : createTickerHelper(type, entityType, TerranGhostBlockEntity::serverTick);
    }
}
