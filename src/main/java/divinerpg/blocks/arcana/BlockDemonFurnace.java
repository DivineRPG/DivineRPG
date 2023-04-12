package divinerpg.blocks.arcana;

import javax.annotation.Nullable;

import divinerpg.blocks.base.*;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.block_entities.furnace.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

public class BlockDemonFurnace extends BlockModInfiniFurnace {
    public BlockDemonFurnace() {
        super(Block.Properties.of(Material.STONE, MaterialColor.STONE).noOcclusion(), () -> BlockEntityRegistry.DEMON_FURNACE.get());
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