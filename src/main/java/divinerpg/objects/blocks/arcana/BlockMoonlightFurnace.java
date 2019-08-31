package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.BlockModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityMoonlightFurnace;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMoonlightFurnace extends BlockModFurnace implements ITileEntityProvider {
    protected String name;

    public BlockMoonlightFurnace(String name, boolean isBurnging) {
        super(name, isBurnging);
        this.name = name;
    }

    public int getGuiID() {
        return GUIHandler.MOONLIGHT_FURNACE_GUI_ID;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMoonlightFurnace();
    }
}
