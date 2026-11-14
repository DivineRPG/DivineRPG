package divinerpg.block_entities.furnace;

import divinerpg.client.menu.DemonFurnaceMenu;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DemonFurnaceBlockEntity extends InfiniFurnaceBlockEntity {
    public DemonFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.DEMON_FURNACE.get(), pos, state, "block.divinerpg.demon_furnace", 3.0);
    }
    public static void serverTick(Level level, BlockPos pos, BlockState state, InfiniFurnaceBlockEntity block) {
        InfiniFurnaceBlockEntity.serverTick(level, pos, state, block);
        if (!level.isClientSide() && block.isLit && level.getRandom().nextInt(50) == 0) {
            BlockPos blockpos = block.getBlockPos().offset(level.getRandom().nextInt(3) - 1, level.getRandom().nextInt(3) - 1, level.getRandom().nextInt(3) - 1);
            if (level.isEmptyBlock(blockpos)) level.setBlock(blockpos, Blocks.FIRE.defaultBlockState(), 3);
        }
    }
    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inv) {
        return new DemonFurnaceMenu(i, inv, this, dataAccess);
    }
}