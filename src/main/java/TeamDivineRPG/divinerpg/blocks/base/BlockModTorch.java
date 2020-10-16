package TeamDivineRPG.divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModTorch extends TorchBlock {
    public BlockModTorch(String name) {
        super(Properties.from(Blocks.TORCH), null);
        //TODO - Basically needs everything done
        setRegistryName(name);
    }
}
