package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockCoalstoneFurnace extends BlockModFurnace {

    public BlockCoalstoneFurnace(String name) {
        super(name);
    }
    protected void openContainer(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof TileEntityCoalstoneFurnace) {
            player.openMenu((INamedContainerProvider)tileentity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader world) {
        return new TileEntityCoalstoneFurnace();
    }
}
