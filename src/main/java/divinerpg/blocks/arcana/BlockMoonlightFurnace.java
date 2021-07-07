package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockMoonlightFurnace extends BlockModFurnace {

    public BlockMoonlightFurnace(String name) {
        super(name);
    }

    @Override
    protected void openContainer(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof TileEntityMoonlightFurnace) {
            player.openMenu((INamedContainerProvider)tileentity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityMoonlightFurnace();
    }
}
