package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockModFence extends FenceBlock {
    public BlockModFence() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).dynamicShape());
    }
}
