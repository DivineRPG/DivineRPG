package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityMoltenFurnace;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMoltenFurnace extends BlockModFurnace implements ITileEntityProvider {

    public BlockMoltenFurnace(String name, boolean isBurnging) {
        super(name, isBurnging);
    }

    public int getGuiID() {
        return GUIHandler.MOLTEN_FURNACE_GUI_ID;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMoltenFurnace();
    }
}
