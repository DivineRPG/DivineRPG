package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityOceanfireFurnace;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockOceanfireFurnace extends BlockModFurnace implements ITileEntityProvider {
    protected String name;

    public BlockOceanfireFurnace(String name, boolean isBurnging) {
        super(name, isBurnging);
        this.name = name;
    }

    public int getGuiID() {
        return GUIHandler.OCEANFIRE_FURNACE_GUI_ID;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityOceanfireFurnace();
    }
}
