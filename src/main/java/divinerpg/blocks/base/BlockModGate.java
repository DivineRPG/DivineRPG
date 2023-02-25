package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

public class BlockModGate extends FenceGateBlock {
    public BlockModGate() {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE));
    }
}
