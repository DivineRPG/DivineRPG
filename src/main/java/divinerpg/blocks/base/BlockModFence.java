package divinerpg.blocks.base;

import net.minecraft.block.*;

public class BlockModFence extends FenceBlock {
    public BlockModFence(String name) {
        super(AbstractBlock.Properties.copy(Blocks.OAK_FENCE).dynamicShape());
        setRegistryName(name);
    }
}
