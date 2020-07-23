package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDramixAltar extends BlockModAltar {

    public BlockDramixAltar(String name) {
        super(name);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityDramixAltar();
    }
}