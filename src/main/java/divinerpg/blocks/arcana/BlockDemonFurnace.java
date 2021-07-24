package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.container.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockDemonFurnace extends BlockModFurnace {

    public BlockDemonFurnace(String name) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.STONE).noOcclusion());
    }
    protected void openContainer(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof TileEntityDemonFurnace) {
            player.openMenu((INamedContainerProvider)tileentity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        if(world.getBlockEntity(pos) instanceof TileEntityModFurnace) {
            TileEntityModFurnace tile = (TileEntityModFurnace) world.getBlockEntity(pos);
            return tile.isLit() ? 0 : 8;
        }
        return 0;
    }

    @Override
    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.INVISIBLE;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader world) {
        return new TileEntityDemonFurnace();
    }

}
