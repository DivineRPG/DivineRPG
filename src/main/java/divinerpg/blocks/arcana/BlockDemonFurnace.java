package divinerpg.blocks.arcana;

import divinerpg.block_entities.furnace.*;
import divinerpg.blocks.base.BlockModInfiniFurnace;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

public class BlockDemonFurnace extends BlockModInfiniFurnace {
    public BlockDemonFurnace() {
        super(Block.Properties.of().mapColor(MapColor.FIRE).requiresCorrectToolForDrops().strength(3.5F).instrument(NoteBlockInstrument.BASEDRUM).noOcclusion(), () -> BlockEntityRegistry.DEMON_FURNACE.get());
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return createFurnaceTicker(type, level, blockEntityType.get());
    }
    @Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(BlockEntityType<T> type, Level level, BlockEntityType<? extends InfiniFurnaceBlockEntity> entityType) {
		return level.isClientSide ? null : createTickerHelper(type, entityType, DemonFurnaceBlockEntity::serverTick);
	}
    @Override
    public RenderShape getRenderShape(BlockState state) {return RenderShape.INVISIBLE;}
}