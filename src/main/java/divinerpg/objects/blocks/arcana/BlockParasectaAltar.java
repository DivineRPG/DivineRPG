package divinerpg.objects.blocks.arcana;

import divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockParasectaAltar extends BlockModAltar {

    public BlockParasectaAltar(String name) {
        super(name);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityParasectaAltar();
    }
}