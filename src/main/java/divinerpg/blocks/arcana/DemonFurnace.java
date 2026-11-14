package divinerpg.blocks.arcana;

import divinerpg.block_entities.furnace.DemonFurnaceBlockEntity;
import divinerpg.block_entities.furnace.InfiniFurnaceBlockEntity;
import divinerpg.blocks.base.InfiniFurnace;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class DemonFurnace extends InfiniFurnace {
    public DemonFurnace(Properties p) {
        super(p, BlockEntityRegistry.DEMON_FURNACE::get);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createFurnaceTicker(type, level, blockEntityType.get());
    }
    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(BlockEntityType<T> type, Level level, BlockEntityType<? extends InfiniFurnaceBlockEntity> entityType) {
        return level.isClientSide() ? null : createTickerHelper(type, entityType, DemonFurnaceBlockEntity::serverTick);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {return RenderShape.INVISIBLE;}
}