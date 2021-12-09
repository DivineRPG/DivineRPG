package divinerpg.blocks.base;

import divinerpg.tiles.block.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockModStructureAir extends BlockMod implements ITileEntityProvider {

    public BlockModStructureAir() {
        super("structure_air", AbstractBlock.Properties.copy(Blocks.AIR).randomTicks());
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new TileEntityStructureAir();
    }
}
