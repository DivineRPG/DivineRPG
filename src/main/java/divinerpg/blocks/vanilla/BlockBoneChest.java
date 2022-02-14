package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.tiles.chests.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockBoneChest extends BlockModChest {

    public BlockBoneChest(String name) {
        super(name, Properties.of(Material.STONE).noOcclusion().sound(SoundType.STONE).strength(2.5F), () -> TileRegistry.BONE_CHEST);
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityBoneChest();
    }
}
