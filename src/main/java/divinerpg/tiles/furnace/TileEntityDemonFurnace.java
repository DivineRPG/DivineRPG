package divinerpg.tiles.furnace;

import divinerpg.client.containers.DemonFurnaceContainer;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class TileEntityDemonFurnace extends TileEntityInfiniFurnace {
    public TileEntityDemonFurnace(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.DEMON_FURNACE.get(), pos, state, "block.divinerpg.demon_furnace", 3.0);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, TileEntityInfiniFurnace block) {
    	TileEntityInfiniFurnace.serverTick(level, pos, state, block);
        if (!level.isClientSide && block.isLit && level.random.nextInt(50) == 0) {
            BlockPos blockpos = block.getBlockPos().offset(level.random.nextInt(3) - 1, level.random.nextInt(3) - 1, level.random.nextInt(3) - 1);
            if (level.isEmptyBlock(blockpos)) level.setBlock(blockpos, Blocks.FIRE.defaultBlockState(), 3);
        }
    }
	@Override
	protected AbstractContainerMenu createMenu(int i, Inventory inv) {
		return new DemonFurnaceContainer(i, inv, this, dataAccess);
	}
}