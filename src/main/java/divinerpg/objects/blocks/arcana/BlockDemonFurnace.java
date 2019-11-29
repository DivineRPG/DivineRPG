package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityDemonFurnace;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockDemonFurnace extends BlockModFurnace implements ITileEntityProvider {

    public BlockDemonFurnace(String name, boolean isBurning) {
        super(name, isBurning);
    }

    public int getGuiID() {
        return GUIHandler.DEMON_FURNACE_GUI_ID;
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityDemonFurnace();
    }
}
