package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.tiles.chests.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockPresentBox extends BlockModChest {

    public BlockPresentBox(String name) {
        super(name, Properties.of(Material.WOOD).sound(SoundType.STONE).strength(2, 1000000), () -> TileRegistry.PRESENT_BOX);
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityPresentBox();
    }
}
