package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModGate extends FenceGateBlock {
    public BlockModGate(String name) {
        super(AbstractBlock.Properties.copy(Blocks.OAK_FENCE_GATE));
        setRegistryName(name);
    }
}
