package divinerpg.blocks.arcana;

import javax.annotation.Nullable;

import divinerpg.block_entities.furnace.*;
import divinerpg.blocks.base.BlockModInfiniFurnace;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;

public class BlockDemonFurnace extends BlockModInfiniFurnace {
    public BlockDemonFurnace() {
        super(Block.Properties.of(Material.STONE, MaterialColor.FIRE).requiresCorrectToolForDrops().strength(3.5F).noOcclusion(), () -> BlockEntityRegistry.DEMON_FURNACE.get());
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