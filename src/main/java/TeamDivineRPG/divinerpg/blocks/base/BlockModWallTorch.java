package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;

public class BlockModWallTorch extends WallTorchBlock {

    public BlockModWallTorch(String name) {
        super(Properties.from(Blocks.TORCH), null);
        //TODO - basically needs everything done
        setRegistryName(name);
    }
}
