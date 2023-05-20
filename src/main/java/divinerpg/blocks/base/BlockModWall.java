package divinerpg.blocks.base;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockModWall extends WallBlock {
    public BlockModWall(Block base) {
        super(BlockBehaviour.Properties.copy(base));
    }
}
