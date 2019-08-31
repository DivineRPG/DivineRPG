package divinerpg.objects.blocks.iceika;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityCoalstoneFurnace;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCoalstoneFurnace extends BlockModFurnace implements ITileEntityProvider {

    public BlockCoalstoneFurnace(String name, boolean isBurnging) {
        super(name, isBurnging);
    }

    public int getGuiID() {
        return GUIHandler.COALSTONE_FURNACE_GUI_ID;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCoalstoneFurnace();
    }
}
